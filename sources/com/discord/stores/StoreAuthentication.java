package com.discord.stores;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.util.Patterns;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import b.d.b.a.outline;
import com.discord.analytics.generated.events.network_action.TrackNetworkActionAuthorizeIp;
import com.discord.analytics.generated.events.network_action.TrackNetworkActionForgotPassword;
import com.discord.analytics.generated.events.network_action.TrackNetworkActionUserLogin;
import com.discord.analytics.generated.events.network_action.TrackNetworkActionUserLoginMfa;
import com.discord.analytics.generated.events.network_action.TrackNetworkActionUserLogout;
import com.discord.analytics.generated.events.network_action.TrackNetworkActionUserRegister;
import com.discord.analytics.generated.traits.TrackNetworkMetadata2;
import com.discord.api.auth.RegisterResponse;
import com.discord.api.auth.RequiredAction;
import com.discord.api.channel.Channel;
import com.discord.api.fingerprint.FingerprintResponse;
import com.discord.app.AppLog;
import com.discord.models.authentication.AuthState;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelInvite;
import com.discord.models.domain.ModelLocationMetadata;
import com.discord.models.domain.auth.ModelLoginResult;
import com.discord.models.user.MeUser;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreInviteSettings;
import com.discord.stores.StoreNavigation;
import com.discord.stores.StoreStream;
import com.discord.stores.authentication.AuthStateCache;
import com.discord.stores.utilities.RestCallState5;
import com.discord.utilities.SnowflakeUtils;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.captcha.CaptchaHelper;
import com.discord.utilities.error.Error;
import com.discord.utilities.persister.Persister;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.time.TimeUtils;
import com.discord.widgets.settings.account.WidgetSettingsAccountChangePassword;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import d0.g0.StringsJVM;
import d0.t.Sets5;
import d0.t._Collections;
import d0.t._Sets;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.k.Func1;
import j0.l.e.ScalarSynchronousObservable;
import j0.m.BlockingObservable;
import java.util.List;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.Subscription;
import rx.functions.Action1;
import rx.functions.Func2;
import rx.functions.Func3;
import rx.subjects.BehaviorSubject;
import rx.subjects.PublishSubject;
import rx.subjects.SerializedSubject;

/* JADX INFO: compiled from: StoreAuthentication.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreAuthentication extends Store {
    private static final String CACHE_KEY_FINGERPRINT = "STORE_AUTHED_FINGERPRINT";
    private static final String CACHE_KEY_LOGIN = "STORE_AUTHED_LOGIN";
    private static final String CACHE_KEY_TOKEN_RNA = "token";

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String SHARED_PREFS_NAME_RNA = "CacheStore";
    private Boolean _isConsentRequired;
    private BehaviorSubject<String> ageGateError;
    private AuthState authState;
    private final AuthStateCache authStateCache;
    private final SerializedSubject<AuthState, AuthState> authStateSubject;
    private final Dispatcher dispatcher;
    private String fingerprint;
    private final SerializedSubject<String, String> fingerprintSubject;
    private Subscription isConsentRequiredSubscription;
    private final SerializedSubject<Uri, Uri> oauthUriSubject;
    private String savedLogin;
    private final StoreStream storeStream;
    private final PublishSubject<Boolean> userInitiatedAuthEventSubject;

    /* JADX INFO: compiled from: StoreAuthentication.kt */
    public static final /* data */ class AuthRequestParams {
        private final String guildTemplateCode;
        private final StoreInviteSettings.InviteCode inviteCode;

        public AuthRequestParams(StoreInviteSettings.InviteCode inviteCode, String str) {
            this.inviteCode = inviteCode;
            this.guildTemplateCode = str;
        }

        public static /* synthetic */ AuthRequestParams copy$default(AuthRequestParams authRequestParams, StoreInviteSettings.InviteCode inviteCode, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                inviteCode = authRequestParams.inviteCode;
            }
            if ((i & 2) != 0) {
                str = authRequestParams.guildTemplateCode;
            }
            return authRequestParams.copy(inviteCode, str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final StoreInviteSettings.InviteCode getInviteCode() {
            return this.inviteCode;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getGuildTemplateCode() {
            return this.guildTemplateCode;
        }

        public final AuthRequestParams copy(StoreInviteSettings.InviteCode inviteCode, String guildTemplateCode) {
            return new AuthRequestParams(inviteCode, guildTemplateCode);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AuthRequestParams)) {
                return false;
            }
            AuthRequestParams authRequestParams = (AuthRequestParams) other;
            return Intrinsics3.areEqual(this.inviteCode, authRequestParams.inviteCode) && Intrinsics3.areEqual(this.guildTemplateCode, authRequestParams.guildTemplateCode);
        }

        public final String getGuildTemplateCode() {
            return this.guildTemplateCode;
        }

        public final StoreInviteSettings.InviteCode getInviteCode() {
            return this.inviteCode;
        }

        public int hashCode() {
            StoreInviteSettings.InviteCode inviteCode = this.inviteCode;
            int iHashCode = (inviteCode != null ? inviteCode.hashCode() : 0) * 31;
            String str = this.guildTemplateCode;
            return iHashCode + (str != null ? str.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("AuthRequestParams(inviteCode=");
            sbU.append(this.inviteCode);
            sbU.append(", guildTemplateCode=");
            return outline.J(sbU, this.guildTemplateCode, ")");
        }
    }

    /* JADX INFO: compiled from: StoreAuthentication.kt */
    public static final class Companion {
        private Companion() {
        }

        /* JADX WARN: Code duplicated, block: B:13:0x0037  */
        /* JADX WARN: Code duplicated, block: B:17:? A[RETURN, SYNTHETIC] */
        @SuppressLint({"MissingPermission"})
        private final String getDeviceEmail(Context context) {
            if (ContextCompat.checkSelfPermission(context, "android.permission.GET_ACCOUNTS") != 0) {
                return null;
            }
            AccountManager accountManager = AccountManager.get(context);
            Intrinsics3.checkNotNullExpressionValue(accountManager, "AccountManager.get(context)");
            Account[] accounts = accountManager.getAccounts();
            Intrinsics3.checkNotNullExpressionValue(accounts, "AccountManager.get(context).accounts");
            for (Account account : accounts) {
                if (Patterns.EMAIL_ADDRESS.matcher(account.type).matches()) {
                    if (account != null) {
                        return account.name;
                    }
                    return null;
                }
            }
            account = null;
            if (account != null) {
                return account.name;
            }
            return null;
        }

        private final String getRnaAuthToken(Context context) {
            String string = context.getSharedPreferences(StoreAuthentication.SHARED_PREFS_NAME_RNA, 0).getString(StoreAuthentication.CACHE_KEY_TOKEN_RNA, null);
            if (string != null) {
                return StringsJVM.replace$default(string, "\"", "", false, 4, (Object) null);
            }
            return null;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreAuthentication$authMFA$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreAuthentication.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<ModelLoginResult, TrackNetworkMetadata2> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final TrackNetworkMetadata2 invoke(ModelLoginResult modelLoginResult) {
            return new TrackNetworkActionUserLoginMfa();
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreAuthentication$authorizeIP$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreAuthentication.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<Void, TrackNetworkMetadata2> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final TrackNetworkMetadata2 invoke(Void r1) {
            return new TrackNetworkActionAuthorizeIp();
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreAuthentication$dispatchLogin$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreAuthentication.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ ModelLoginResult $loginResult;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(ModelLoginResult modelLoginResult) {
            super(0);
            this.$loginResult = modelLoginResult;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreAuthentication.this.storeStream.handleLoginResult(this.$loginResult);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreAuthentication$forgotPassword$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreAuthentication.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<Void, TrackNetworkMetadata2> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final TrackNetworkMetadata2 invoke(Void r1) {
            return new TrackNetworkActionForgotPassword();
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreAuthentication$init$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreAuthentication.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<Boolean, Unit> {
        public final /* synthetic */ Context $context;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Context context) {
            super(1);
            this.$context = context;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            invoke2(bool);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Boolean bool) {
            Context context = this.$context;
            Intrinsics3.checkNotNullExpressionValue(bool, "isLoggedIn");
            context.sendBroadcast(new Intent(bool.booleanValue() ? "com.discord.broadcast.LOGGED_IN" : "com.discord.broadcast.LOGGED_OUT"));
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreAuthentication$logout$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreAuthentication.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<Void, TrackNetworkMetadata2> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final TrackNetworkMetadata2 invoke(Void r1) {
            return new TrackNetworkActionUserLogout();
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreAuthentication$logout$3, reason: invalid class name */
    /* JADX INFO: compiled from: StoreAuthentication.kt */
    public static final class AnonymousClass3 extends Lambda implements Function1<String, Unit> {
        public AnonymousClass3() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String str) {
            StoreStream.INSTANCE.getNux().clearNux();
            StoreAuthentication.this.publishAuthState(null);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreAuthentication$logout$4, reason: invalid class name */
    /* JADX INFO: compiled from: StoreAuthentication.kt */
    public static final class AnonymousClass4 extends Lambda implements Function1<Error, Unit> {
        public AnonymousClass4() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "it");
            StoreAuthentication.this.publishAuthState(null);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreAuthentication$onPasswordChanged$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreAuthentication.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ String $token;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(String str) {
            super(0);
            this.$token = str;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            Set<RequiredAction> setEmptySet;
            AuthState authState = StoreAuthentication.this.getAuthState();
            if (authState == null || (setEmptySet = authState.getRequiredActions()) == null) {
                setEmptySet = Sets5.emptySet();
            }
            StoreAuthentication.this.publishAuthState(AuthState.INSTANCE.from(this.$token, _Sets.minus(setEmptySet, RequiredAction.UPDATE_PASSWORD)));
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreAuthentication$register$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreAuthentication.kt */
    public static final class AnonymousClass1<T, R> implements Func1<String, Observable<? extends RegisterResponse>> {
        public final /* synthetic */ CaptchaHelper.CaptchaPayload $captchaPayload;
        public final /* synthetic */ boolean $consent;
        public final /* synthetic */ String $dateOfBirth;
        public final /* synthetic */ String $email;
        public final /* synthetic */ String $password;
        public final /* synthetic */ String $phoneToken;
        public final /* synthetic */ String $username;

        /* JADX INFO: renamed from: com.discord.stores.StoreAuthentication$register$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: StoreAuthentication.kt */
        public static final /* synthetic */ class C00921 extends FunctionReferenceImpl implements Function2<StoreInviteSettings.InviteCode, String, AuthRequestParams> {
            public static final C00921 INSTANCE = new C00921();

            public C00921() {
                super(2, AuthRequestParams.class, "<init>", "<init>(Lcom/discord/stores/StoreInviteSettings$InviteCode;Ljava/lang/String;)V", 0);
            }

            @Override // kotlin.jvm.functions.Function2
            public final AuthRequestParams invoke(StoreInviteSettings.InviteCode inviteCode, String str) {
                return new AuthRequestParams(inviteCode, str);
            }
        }

        public AnonymousClass1(String str, String str2, String str3, String str4, CaptchaHelper.CaptchaPayload captchaPayload, boolean z2, String str5) {
            this.$username = str;
            this.$email = str2;
            this.$phoneToken = str3;
            this.$password = str4;
            this.$captchaPayload = captchaPayload;
            this.$consent = z2;
            this.$dateOfBirth = str5;
        }

        @Override // j0.k.Func1
        public final Observable<? extends RegisterResponse> call(final String str) {
            StoreStream.Companion companion = StoreStream.INSTANCE;
            Observable<StoreInviteSettings.InviteCode> inviteCode = companion.getInviteSettings().getInviteCode();
            Observable<String> observableObserveDynamicLinkGuildTemplateCode = companion.getGuildTemplates().observeDynamicLinkGuildTemplateCode();
            final C00921 c00921 = C00921.INSTANCE;
            Object obj = c00921;
            if (c00921 != null) {
                obj = new Func2() { // from class: com.discord.stores.StoreAuthentication$sam$rx_functions_Func2$0
                    @Override // rx.functions.Func2
                    public final /* synthetic */ Object call(Object obj2, Object obj3) {
                        return c00921.invoke(obj2, obj3);
                    }
                };
            }
            Observable observableJ = Observable.j(inviteCode, observableObserveDynamicLinkGuildTemplateCode, (Func2) obj);
            Intrinsics3.checkNotNullExpressionValue(observableJ, "Observable.combineLatest…RequestParams\n          )");
            Observable<R> observableA = ObservableExtensionsKt.takeSingleUntilTimeout$default(observableJ, 500L, false, 2, null).A(new Func1<AuthRequestParams, Observable<? extends RegisterResponse>>() { // from class: com.discord.stores.StoreAuthentication.register.1.2

                /* JADX INFO: renamed from: com.discord.stores.StoreAuthentication$register$1$2$1, reason: invalid class name and collision with other inner class name */
                /* JADX INFO: compiled from: StoreAuthentication.kt */
                public static final class C00931 extends Lambda implements Function1<RegisterResponse, TrackNetworkMetadata2> {
                    public final /* synthetic */ String $inviteCode;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    public C00931(String str) {
                        super(1);
                        this.$inviteCode = str;
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final TrackNetworkMetadata2 invoke(RegisterResponse registerResponse) {
                        return new TrackNetworkActionUserRegister(this.$inviteCode, Boolean.valueOf(AnonymousClass1.this.$consent), Boolean.FALSE);
                    }
                }

                @Override // j0.k.Func1
                public final Observable<? extends RegisterResponse> call(AuthRequestParams authRequestParams) {
                    StoreInviteSettings.InviteCode inviteCode2 = authRequestParams.getInviteCode();
                    String inviteCode3 = inviteCode2 != null ? inviteCode2.getInviteCode() : null;
                    if (inviteCode3 == null || inviteCode3.length() == 0) {
                        StoreStream.INSTANCE.getNux().setPostRegister(true);
                    } else {
                        StoreStream.INSTANCE.getNux().setPostRegisterWithInvite(true);
                    }
                    RestAPI api = RestAPI.INSTANCE.getApi();
                    String str2 = str;
                    AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                    String str3 = anonymousClass1.$username;
                    String str4 = anonymousClass1.$email;
                    String str5 = anonymousClass1.$phoneToken;
                    String str6 = anonymousClass1.$password;
                    CaptchaHelper.CaptchaPayload captchaPayload = anonymousClass1.$captchaPayload;
                    String captchaKey = captchaPayload != null ? captchaPayload.getCaptchaKey() : null;
                    CaptchaHelper.CaptchaPayload captchaPayload2 = AnonymousClass1.this.$captchaPayload;
                    String captchaRqtoken = captchaPayload2 != null ? captchaPayload2.getCaptchaRqtoken() : null;
                    String guildTemplateCode = authRequestParams.getGuildTemplateCode();
                    AnonymousClass1 anonymousClass2 = AnonymousClass1.this;
                    return RestCallState5.logNetworkAction(api.postAuthRegister(new RestAPIParams.AuthRegister(str2, str3, str4, str5, str6, captchaKey, captchaRqtoken, inviteCode3, guildTemplateCode, anonymousClass2.$consent, anonymousClass2.$dateOfBirth)), new C00931(inviteCode3));
                }
            });
            Intrinsics3.checkNotNullExpressionValue(observableA, "Observable.combineLatest…        }\n              }");
            return ObservableExtensionsKt.takeSingleUntilTimeout$default(ObservableExtensionsKt.restSubscribeOn$default(observableA, false, 1, null), 0L, false, 3, null).u(new Action1<RegisterResponse>() { // from class: com.discord.stores.StoreAuthentication.register.1.3
                @Override // rx.functions.Action1
                public final void call(RegisterResponse registerResponse) {
                    StoreStream.Companion companion2 = StoreStream.INSTANCE;
                    companion2.getUserSettingsSystem().setIsSyncThemeEnabled(false);
                    StoreAuthentication.this.setFingerprint(null, true);
                    StoreAuthentication.this.publishAuthState(new AuthState(registerResponse.getToken(), Sets5.emptySet()));
                    AnalyticsTracker.INSTANCE.appFirstLogin();
                    companion2.getNotifications().setEnabledInApp(true, false);
                    companion2.getNux().setFirstOpen(true);
                }
            });
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreAuthentication$requestConsentRequired$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreAuthentication.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<ModelLocationMetadata, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ModelLocationMetadata modelLocationMetadata) {
            invoke2(modelLocationMetadata);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ModelLocationMetadata modelLocationMetadata) {
            Intrinsics3.checkNotNullParameter(modelLocationMetadata, "it");
            StoreAuthentication.this.setConsentRequired(modelLocationMetadata.getConsentRequired());
            String countryCode = modelLocationMetadata.getCountryCode();
            if (countryCode != null) {
                StoreStream.INSTANCE.getPhone().updateDefaultCountryCode(countryCode);
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreAuthentication$requestConsentRequired$2, reason: invalid class name */
    /* JADX INFO: compiled from: StoreAuthentication.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<Error, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "it");
            StoreAuthentication.this.setConsentRequired(true);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreAuthentication$requestConsentRequired$3, reason: invalid class name */
    /* JADX INFO: compiled from: StoreAuthentication.kt */
    public static final class AnonymousClass3 extends Lambda implements Function1<Subscription, Unit> {
        public AnonymousClass3() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Subscription subscription) {
            invoke2(subscription);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Subscription subscription) {
            Intrinsics3.checkNotNullParameter(subscription, "consentSubscription");
            StoreAuthentication.this.isConsentRequiredSubscription = subscription;
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreAuthentication$setAgeGateError$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreAuthentication.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ String $error;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(String str) {
            super(0);
            this.$error = str;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreAuthentication.this.handleAgeGateError(this.$error);
        }
    }

    public StoreAuthentication(StoreStream storeStream, Dispatcher dispatcher) {
        Intrinsics3.checkNotNullParameter(storeStream, "storeStream");
        Intrinsics3.checkNotNullParameter(dispatcher, "dispatcher");
        this.storeStream = storeStream;
        this.dispatcher = dispatcher;
        this.userInitiatedAuthEventSubject = PublishSubject.k0();
        this.fingerprintSubject = new SerializedSubject<>(BehaviorSubject.k0());
        this.authStateSubject = new SerializedSubject<>(BehaviorSubject.l0(null));
        BehaviorSubject<String> behaviorSubjectK0 = BehaviorSubject.k0();
        Intrinsics3.checkNotNullExpressionValue(behaviorSubjectK0, "BehaviorSubject.create()");
        this.ageGateError = behaviorSubjectK0;
        this.oauthUriSubject = new SerializedSubject<>(BehaviorSubject.l0(Uri.EMPTY));
        this.authStateCache = new AuthStateCache(getPrefs());
    }

    private final void dispatchLogin(ModelLoginResult loginResult) {
        this.dispatcher.schedule(new AnonymousClass1(loginResult));
    }

    private final Observable<String> getFingerprintSnapshotOrGenerate() {
        Observable<String> observableU = this.fingerprintSubject.Z(1).Y(new Func1<String, Observable<? extends String>>() { // from class: com.discord.stores.StoreAuthentication.getFingerprintSnapshotOrGenerate.1
            @Override // j0.k.Func1
            public final Observable<? extends String> call(String str) {
                return str != null ? new ScalarSynchronousObservable(str) : ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().postAuthFingerprint(new RestAPIParams.EmptyBody()), false, 1, null).G(new Func1<FingerprintResponse, String>() { // from class: com.discord.stores.StoreAuthentication.getFingerprintSnapshotOrGenerate.1.2
                    @Override // j0.k.Func1
                    public final String call(FingerprintResponse fingerprintResponse) {
                        return fingerprintResponse.getFingerprint();
                    }
                });
            }
        }).u(new Action1<String>() { // from class: com.discord.stores.StoreAuthentication.getFingerprintSnapshotOrGenerate.2
            @Override // rx.functions.Action1
            public final void call(String str) {
                StoreAuthentication.this.setFingerprint(str, false);
            }
        });
        Intrinsics3.checkNotNullExpressionValue(observableU, "fingerprintSubject\n     …int(fingerprint, false) }");
        return observableU;
    }

    private final Set<RequiredAction> getRequiredActionsFromLoginResponse(ModelLoginResult loginResult) {
        Set<RequiredAction> set;
        List<RequiredAction> requiredActions = loginResult.getRequiredActions();
        return (requiredActions == null || (set = _Collections.toSet(requiredActions)) == null) ? Sets5.emptySet() : set;
    }

    public static /* synthetic */ Observable login$default(StoreAuthentication storeAuthentication, String str, String str2, CaptchaHelper.CaptchaPayload captchaPayload, boolean z2, String str3, int i, Object obj) {
        if ((i & 16) != 0) {
            str3 = null;
        }
        return storeAuthentication.login(str, str2, captchaPayload, z2, str3);
    }

    private final void publishAuthState(AuthState authState) {
        this.authStateSubject.k.onNext(authState);
    }

    private final synchronized void resetIsConsentRequired() {
        this._isConsentRequired = null;
        Subscription subscription = this.isConsentRequiredSubscription;
        if (subscription != null) {
            subscription.unsubscribe();
        }
        this.isConsentRequiredSubscription = null;
    }

    private final synchronized void setConsentRequired(boolean z2) {
        this._isConsentRequired = Boolean.valueOf(z2);
    }

    private final void setSavedLogin(String str) {
        this.savedLogin = str;
        AppLog.g(null, str, null);
        getPrefsSessionDurable().edit().putString(CACHE_KEY_LOGIN, str).apply();
    }

    public final Observable<ModelLoginResult> authMFA(String code, String ticket) {
        Intrinsics3.checkNotNullParameter(code, ModelAuditLogEntry.CHANGE_KEY_CODE);
        Intrinsics3.checkNotNullParameter(ticket, "ticket");
        Observable<ModelLoginResult> observableU = ObservableExtensionsKt.restSubscribeOn$default(RestCallState5.logNetworkAction(RestAPI.INSTANCE.getApi().postMFACode(new RestAPIParams.MFALogin(ticket, code)), AnonymousClass1.INSTANCE), false, 1, null).u(new Action1<ModelLoginResult>() { // from class: com.discord.stores.StoreAuthentication.authMFA.2
            @Override // rx.functions.Action1
            public final void call(ModelLoginResult modelLoginResult) {
                StoreAuthentication storeAuthentication = StoreAuthentication.this;
                Intrinsics3.checkNotNullExpressionValue(modelLoginResult, "loginResult");
                storeAuthentication.dispatchLogin(modelLoginResult);
            }
        });
        Intrinsics3.checkNotNullExpressionValue(observableU, "RestAPI\n        .api\n   …in(loginResult)\n        }");
        return observableU;
    }

    public final Observable<Void> authorizeIP(String token) {
        Intrinsics3.checkNotNullParameter(token, CACHE_KEY_TOKEN_RNA);
        return RestCallState5.logNetworkAction(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().authorizeIP(new RestAPIParams.AuthorizeIP(token)), false, 1, null), AnonymousClass1.INSTANCE);
    }

    public final Observable<Void> forgotPassword(String login, CaptchaHelper.CaptchaPayload captchaPayload) {
        Intrinsics3.checkNotNullParameter(login, "login");
        return ObservableExtensionsKt.restSubscribeOn$default(RestCallState5.logNetworkAction(RestAPI.INSTANCE.getApi().forgotPassword(new RestAPIParams.ForgotPassword(login, captchaPayload != null ? captchaPayload.getCaptchaKey() : null, captchaPayload != null ? captchaPayload.getCaptchaRqtoken() : null)), AnonymousClass1.INSTANCE), false, 1, null);
    }

    public final Observable<String> getAgeGateError() {
        Observable<String> observableR = this.ageGateError.r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "ageGateError.distinctUntilChanged()");
        return observableR;
    }

    /* JADX INFO: renamed from: getAuthState$app_productionGoogleRelease, reason: from getter */
    public final AuthState getAuthState() {
        return this.authState;
    }

    public final Observable<String> getAuthedToken$app_productionGoogleRelease() {
        Observable observableG = this.authStateSubject.r().G(new Func1<AuthState, String>() { // from class: com.discord.stores.StoreAuthentication$getAuthedToken$1
            @Override // j0.k.Func1
            public final String call(AuthState authState) {
                if (authState != null) {
                    return authState.getToken();
                }
                return null;
            }
        });
        Intrinsics3.checkNotNullExpressionValue(observableG, "authStateSubject.distinc…anged().map { it?.token }");
        return observableG;
    }

    public final Observable<String> getFingerPrint$app_productionGoogleRelease() {
        Observable<String> observableR = this.fingerprintSubject.r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "fingerprintSubject.distinctUntilChanged()");
        return observableR;
    }

    /* JADX INFO: renamed from: getFingerprint$app_productionGoogleRelease, reason: from getter */
    public final String getFingerprint() {
        return this.fingerprint;
    }

    public final Observable<Uri> getOAuthUriObservable() {
        Observable<Uri> observableR = this.oauthUriSubject.r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "oauthUriSubject.distinctUntilChanged()");
        return observableR;
    }

    public final Observable<Boolean> getPreLogoutSignal$app_productionGoogleRelease() {
        Observable<Boolean> observableY = this.userInitiatedAuthEventSubject.y(new Func1<Boolean, Boolean>() { // from class: com.discord.stores.StoreAuthentication$getPreLogoutSignal$1
            @Override // j0.k.Func1
            public final Boolean call(Boolean bool) {
                return Boolean.valueOf(!bool.booleanValue());
            }
        });
        Intrinsics3.checkNotNullExpressionValue(observableY, "userInitiatedAuthEventSu…LoggedIn -> !isLoggedIn }");
        return observableY;
    }

    public final String getSavedLogin() {
        return this.savedLogin;
    }

    public final Observable<StoreNavigation.AgeGate> getShouldShowAgeGate() {
        Observable<StoreNavigation.AgeGate> observableR = Observable.i(this.storeStream.getUsers().observeMe(true), this.storeStream.getAuthentication().getAgeGateError(), this.storeStream.getChannelsSelected().observeSelectedChannel(), new Func3<MeUser, String, Channel, StoreNavigation.AgeGate>() { // from class: com.discord.stores.StoreAuthentication.getShouldShowAgeGate.1
            @Override // rx.functions.Func3
            public final StoreNavigation.AgeGate call(MeUser meUser, String str, Channel channel) {
                long uTCDate = TimeUtils.parseUTCDate("2021-02-05T12:00:00+0000");
                if (!meUser.getHasBirthday() && (meUser.getId() >>> 22) + SnowflakeUtils.DISCORD_EPOCH > uTCDate) {
                    return StoreNavigation.AgeGate.REGISTER_AGE_GATE;
                }
                if (str != null || meUser.getHasBirthday() || channel == null || !channel.getNsfw()) {
                    return null;
                }
                return StoreNavigation.AgeGate.NSFW_CHANNEL_AGE_GATE;
            }
        }).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "Observable.combineLatest…  .distinctUntilChanged()");
        return observableR;
    }

    @Store3
    public final void handleAgeGateError(String error) {
        this.ageGateError.onNext(error);
    }

    @Store3
    public final void handleAuthState$app_productionGoogleRelease(AuthState authState) {
        this.authState = authState;
        this.authStateCache.cacheAuthState(authState);
        if (authState == null) {
            Persister.INSTANCE.reset();
            SharedPreferences.Editor editorEdit = getPrefs().edit();
            Intrinsics3.checkNotNullExpressionValue(editorEdit, "editor");
            editorEdit.clear();
            editorEdit.apply();
        }
    }

    @Store3
    public final void handleLoginResult(ModelLoginResult loginResult) {
        Intrinsics3.checkNotNullParameter(loginResult, "loginResult");
        setFingerprint(null, true);
        publishAuthState(AuthState.INSTANCE.from(loginResult.getToken(), getRequiredActionsFromLoginResponse(loginResult)));
        if (loginResult.getToken() != null) {
            setAgeGateError(null);
            AnalyticsTracker.INSTANCE.appFirstLogin();
        }
        PublishSubject<Boolean> publishSubject = this.userInitiatedAuthEventSubject;
        publishSubject.k.onNext(Boolean.TRUE);
        StoreStream.INSTANCE.getNux().setFirstOpen(true);
    }

    @Store3
    public final void handlePreLogout$app_productionGoogleRelease() {
        resetIsConsentRequired();
    }

    @Override // com.discord.stores.Store
    @Store3
    public synchronized void init(Context context) {
        Intrinsics3.checkNotNullParameter(context, "context");
        super.init(context);
        String string = getPrefsSessionDurable().getString(CACHE_KEY_FINGERPRINT, null);
        if (string != null) {
            setFingerprint(string, false);
        }
        AuthState cachedAuthState = this.authStateCache.getCachedAuthState();
        if (cachedAuthState == null) {
            cachedAuthState = AuthState.INSTANCE.from(INSTANCE.getRnaAuthToken(context), Sets5.emptySet());
        }
        if (AuthState.INSTANCE.isUpdatePasswordRequired(cachedAuthState)) {
            logout();
        } else {
            this.authState = cachedAuthState;
            publishAuthState(cachedAuthState);
        }
        handleAgeGateError(null);
        setSavedLogin(getPrefsSessionDurable().getString(CACHE_KEY_LOGIN, INSTANCE.getDeviceEmail(context)));
        Observable<Boolean> observableR = this.userInitiatedAuthEventSubject.r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "userInitiatedAuthEventSu…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui(ObservableExtensionsKt.computationLatest(observableR)), (Class<?>) getClass(), (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1(context));
    }

    public final boolean isAuthed() {
        return this.authState != null;
    }

    public final synchronized boolean isConsentRequired() {
        Boolean bool;
        bool = this._isConsentRequired;
        return bool != null ? bool.booleanValue() : true;
    }

    public final Observable<ModelLoginResult> login(final String login, final String password, final CaptchaHelper.CaptchaPayload captchaPayload, final boolean undelete, final String loginSource) {
        Intrinsics3.checkNotNullParameter(login, "login");
        Intrinsics3.checkNotNullParameter(password, WidgetSettingsAccountChangePassword.CURRENT_PASSWORD_FIELD);
        setSavedLogin(login);
        Observable<ModelLoginResult> observableU = getFingerprintSnapshotOrGenerate().A(new Func1<String, Observable<? extends ModelLoginResult>>() { // from class: com.discord.stores.StoreAuthentication.login.1

            /* JADX INFO: renamed from: com.discord.stores.StoreAuthentication$login$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: StoreAuthentication.kt */
            public static final class C00911 extends Lambda implements Function1<ModelLoginResult, TrackNetworkMetadata2> {
                public static final C00911 INSTANCE = new C00911();

                public C00911() {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final TrackNetworkMetadata2 invoke(ModelLoginResult modelLoginResult) {
                    Observable<T> observableM = ObservableExtensionsKt.takeSingleUntilTimeout$default(StoreStream.INSTANCE.getInviteSettings().getInvite(), 250L, false, 2, null).M(new Func1<Throwable, ModelInvite>() { // from class: com.discord.stores.StoreAuthentication$login$1$1$invite$1
                        @Override // j0.k.Func1
                        public final ModelInvite call(Throwable th) {
                            return null;
                        }
                    });
                    ModelInvite modelInvite = (ModelInvite) new BlockingObservable(observableM).a(observableM.z());
                    return new TrackNetworkActionUserLogin(modelInvite != null ? modelInvite.code : null, null, 2);
                }
            }

            @Override // j0.k.Func1
            public final Observable<? extends ModelLoginResult> call(String str) {
                RestAPI api = RestAPI.INSTANCE.getApi();
                String str2 = login;
                String str3 = password;
                CaptchaHelper.CaptchaPayload captchaPayload2 = captchaPayload;
                String captchaKey = captchaPayload2 != null ? captchaPayload2.getCaptchaKey() : null;
                CaptchaHelper.CaptchaPayload captchaPayload3 = captchaPayload;
                return RestCallState5.logNetworkAction(ObservableExtensionsKt.restSubscribeOn$default(api.postAuthLogin(new RestAPIParams.AuthLogin(str2, str3, captchaKey, captchaPayload3 != null ? captchaPayload3.getCaptchaRqtoken() : null, Boolean.valueOf(undelete), loginSource)), false, 1, null), C00911.INSTANCE);
            }
        }).u(new Action1<ModelLoginResult>() { // from class: com.discord.stores.StoreAuthentication.login.2
            @Override // rx.functions.Action1
            public final void call(ModelLoginResult modelLoginResult) {
                if (modelLoginResult.getMfa()) {
                    return;
                }
                StoreAuthentication storeAuthentication = StoreAuthentication.this;
                Intrinsics3.checkNotNullExpressionValue(modelLoginResult, "loginResult");
                storeAuthentication.dispatchLogin(modelLoginResult);
            }
        });
        Intrinsics3.checkNotNullExpressionValue(observableU, "getFingerprintSnapshotOr…lt)\n          }\n        }");
        return observableU;
    }

    public final void logout() {
        PublishSubject<Boolean> publishSubject = this.userInitiatedAuthEventSubject;
        publishSubject.k.onNext(Boolean.FALSE);
        Observable observableA = ObservableExtensionsKt.restSubscribeOn$default(RestCallState5.logNetworkAction(RestAPI.INSTANCE.getApi().logout(new RestAPIParams.UserDevices(StoreStream.INSTANCE.getNotifications().getPushToken())), AnonymousClass1.INSTANCE), false, 1, null).A(new Func1<Void, Observable<? extends String>>() { // from class: com.discord.stores.StoreAuthentication.logout.2
            @Override // j0.k.Func1
            public final Observable<? extends String> call(Void r1) {
                return StoreAuthentication.this.getFingerprintSnapshotOrGenerate();
            }
        });
        Intrinsics3.checkNotNullExpressionValue(observableA, "RestAPI\n        .api\n   …intSnapshotOrGenerate() }");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.takeSingleUntilTimeout$default(observableA, 0L, false, 3, null), (117 & 1) != 0 ? null : null, "logout", (Function1<? super Subscription, Unit>) ((117 & 4) != 0 ? null : null), new AnonymousClass3(), (Function1<? super Error, Unit>) ((117 & 16) != 0 ? null : new AnonymousClass4()), (Function0<Unit>) ((117 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass3.INSTANCE : null), (Function0<Unit>) ((117 & 64) != 0 ? ObservableExtensionsKt.AnonymousClass4.INSTANCE : null));
    }

    public final Observable<Boolean> observeIsAuthed$app_productionGoogleRelease() {
        Observable observableG = m8getAuthState$app_productionGoogleRelease().G(new Func1<AuthState, Boolean>() { // from class: com.discord.stores.StoreAuthentication$observeIsAuthed$1
            @Override // j0.k.Func1
            public final Boolean call(AuthState authState) {
                return Boolean.valueOf(authState != null);
            }
        });
        Intrinsics3.checkNotNullExpressionValue(observableG, "getAuthState()\n      .ma…te -> authState != null }");
        return observableG;
    }

    public final void onPasswordChanged(String token) {
        this.dispatcher.schedule(new AnonymousClass1(token));
    }

    public final Observable<RegisterResponse> register(String username, String email, String phoneToken, String password, CaptchaHelper.CaptchaPayload captchaPayload, boolean consent, String dateOfBirth) {
        Intrinsics3.checkNotNullParameter(username, "username");
        Intrinsics3.checkNotNullParameter(password, WidgetSettingsAccountChangePassword.CURRENT_PASSWORD_FIELD);
        setSavedLogin(email);
        Observable observableA = getFingerprintSnapshotOrGenerate().A(new AnonymousClass1(username, email, phoneToken, password, captchaPayload, consent, dateOfBirth));
        Intrinsics3.checkNotNullExpressionValue(observableA, "getFingerprintSnapshotOr…              }\n        }");
        return observableA;
    }

    public final synchronized void requestConsentRequired() {
        if (this._isConsentRequired != null) {
            return;
        }
        resetIsConsentRequired();
        Observable observableRestSubscribeOn$default = ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().getLocationMetadata(), false, 1, null);
        Class<?> cls = getClass();
        ObservableExtensionsKt.appSubscribe(observableRestSubscribeOn$default, (Class<?>) cls, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : new AnonymousClass3()), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new AnonymousClass2()), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1());
    }

    public final void setAgeGateError(String error) {
        this.dispatcher.schedule(new AnonymousClass1(error));
    }

    public final void setAuthed(String authToken) {
        publishAuthState(AuthState.INSTANCE.from(authToken, Sets5.emptySet()));
    }

    /* JADX WARN: Code duplicated, block: B:6:0x0007 A[Catch: all -> 0x0044, TryCatch #0 {, blocks: (B:4:0x0003, B:9:0x002c, B:11:0x0030, B:14:0x003a, B:6:0x0007, B:8:0x0023), top: B:20:0x0003 }] */
    /* JADX WARN: Code duplicated, block: B:8:0x0023 A[Catch: all -> 0x0044, TryCatch #0 {, blocks: (B:4:0x0003, B:9:0x002c, B:11:0x0030, B:14:0x003a, B:6:0x0007, B:8:0x0023), top: B:20:0x0003 }] */
    public final synchronized void setFingerprint(String fingerprint, boolean force) {
        String str;
        if (force) {
            getPrefsSessionDurable().edit().putString(CACHE_KEY_FINGERPRINT, fingerprint).apply();
            this.fingerprint = fingerprint;
            this.fingerprintSubject.k.onNext(fingerprint);
            if (fingerprint != null) {
                FirebaseCrashlytics.getInstance().setCustomKey("fingerprint", fingerprint);
            }
            str = this.fingerprint;
            if (str != null) {
                String str2 = this.fingerprint;
                Intrinsics3.checkNotNull(str2);
                AnalyticsTracker.externalFingerprintDropped(str2, fingerprint);
            }
        } else {
            if (this.fingerprint == null) {
                getPrefsSessionDurable().edit().putString(CACHE_KEY_FINGERPRINT, fingerprint).apply();
                this.fingerprint = fingerprint;
                this.fingerprintSubject.k.onNext(fingerprint);
                if (fingerprint != null) {
                    FirebaseCrashlytics.getInstance().setCustomKey("fingerprint", fingerprint);
                }
            }
            str = this.fingerprint;
            if (str != null && (!Intrinsics3.areEqual(str, fingerprint)) && fingerprint != null) {
                String str3 = this.fingerprint;
                Intrinsics3.checkNotNull(str3);
                AnalyticsTracker.externalFingerprintDropped(str3, fingerprint);
            }
        }
        throw th;
    }

    public final void setOAuthUriSubject(Uri uri) {
        Intrinsics3.checkNotNullParameter(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
        this.oauthUriSubject.k.onNext(uri);
    }

    /* JADX INFO: renamed from: getAuthState$app_productionGoogleRelease, reason: collision with other method in class */
    public final Observable<AuthState> m8getAuthState$app_productionGoogleRelease() {
        Observable<AuthState> observableR = this.authStateSubject.r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "authStateSubject.distinctUntilChanged()");
        return observableR;
    }
}
