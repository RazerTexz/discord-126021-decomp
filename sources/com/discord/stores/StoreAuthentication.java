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
import com.discord.analytics.generated.events.network_action.TrackNetworkActionAuthorizeIp;
import com.discord.analytics.generated.events.network_action.TrackNetworkActionForgotPassword;
import com.discord.analytics.generated.events.network_action.TrackNetworkActionUserLogin;
import com.discord.analytics.generated.events.network_action.TrackNetworkActionUserLoginMfa;
import com.discord.analytics.generated.events.network_action.TrackNetworkActionUserLogout;
import com.discord.analytics.generated.events.network_action.TrackNetworkActionUserRegister;
import com.discord.analytics.generated.traits.TrackNetworkMetadataReceiver;
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
import com.discord.stores.authentication.AuthStateCache;
import com.discord.stores.utilities.RestCallStateKt;
import com.discord.utilities.SnowflakeUtils;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.captcha.CaptchaHelper;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.persister.Persister;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.time.TimeUtils;
import com.discord.widgets.settings.account.WidgetSettingsAccountChangePassword;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import java.util.List;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p579g0.C12103t;
import p507d0.p580t.C12148n0;
import p507d0.p580t.C12150o0;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;
import p637j0.p641k.InterfaceC12589b;
import p637j0.p642l.p647e.C12721k;
import p637j0.p650m.C12756a;
import p658rx.Observable;
import p658rx.Subscription;
import p658rx.functions.Action1;
import p658rx.functions.Func2;
import p658rx.functions.Func3;
import p658rx.subjects.BehaviorSubject;
import p658rx.subjects.PublishSubject;
import p658rx.subjects.SerializedSubject;

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
            return C12238m.areEqual(this.inviteCode, authRequestParams.inviteCode) && C12238m.areEqual(this.guildTemplateCode, authRequestParams.guildTemplateCode);
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
            StringBuilder sbM833U = C1643a.m833U("AuthRequestParams(inviteCode=");
            sbM833U.append(this.inviteCode);
            sbM833U.append(", guildTemplateCode=");
            return C1643a.m822J(sbM833U, this.guildTemplateCode, ")");
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
            C12238m.checkNotNullExpressionValue(accountManager, "AccountManager.get(context)");
            Account[] accounts = accountManager.getAccounts();
            C12238m.checkNotNullExpressionValue(accounts, "AccountManager.get(context).accounts");
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
                return C12103t.replace$default(string, "\"", "", false, 4, (Object) null);
            }
            return null;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreAuthentication$authMFA$1 */
    /* JADX INFO: compiled from: StoreAuthentication.kt */
    public static final class C57711 extends AbstractC12240o implements Function1<ModelLoginResult, TrackNetworkMetadataReceiver> {
        public static final C57711 INSTANCE = new C57711();

        public C57711() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final TrackNetworkMetadataReceiver invoke(ModelLoginResult modelLoginResult) {
            return new TrackNetworkActionUserLoginMfa();
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreAuthentication$authorizeIP$1 */
    /* JADX INFO: compiled from: StoreAuthentication.kt */
    public static final class C57731 extends AbstractC12240o implements Function1<Void, TrackNetworkMetadataReceiver> {
        public static final C57731 INSTANCE = new C57731();

        public C57731() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final TrackNetworkMetadataReceiver invoke(Void r1) {
            return new TrackNetworkActionAuthorizeIp();
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreAuthentication$dispatchLogin$1 */
    /* JADX INFO: compiled from: StoreAuthentication.kt */
    public static final class C57741 extends AbstractC12240o implements Function0<Unit> {
        public final /* synthetic */ ModelLoginResult $loginResult;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C57741(ModelLoginResult modelLoginResult) {
            super(0);
            this.$loginResult = modelLoginResult;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreAuthentication.this.storeStream.handleLoginResult(this.$loginResult);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreAuthentication$forgotPassword$1 */
    /* JADX INFO: compiled from: StoreAuthentication.kt */
    public static final class C57751 extends AbstractC12240o implements Function1<Void, TrackNetworkMetadataReceiver> {
        public static final C57751 INSTANCE = new C57751();

        public C57751() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final TrackNetworkMetadataReceiver invoke(Void r1) {
            return new TrackNetworkActionForgotPassword();
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreAuthentication$init$1 */
    /* JADX INFO: compiled from: StoreAuthentication.kt */
    public static final class C57791 extends AbstractC12240o implements Function1<Boolean, Unit> {
        public final /* synthetic */ Context $context;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C57791(Context context) {
            super(1);
            this.$context = context;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            invoke2(bool);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Boolean bool) {
            Context context = this.$context;
            C12238m.checkNotNullExpressionValue(bool, "isLoggedIn");
            context.sendBroadcast(new Intent(bool.booleanValue() ? "com.discord.broadcast.LOGGED_IN" : "com.discord.broadcast.LOGGED_OUT"));
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreAuthentication$logout$1 */
    /* JADX INFO: compiled from: StoreAuthentication.kt */
    public static final class C57821 extends AbstractC12240o implements Function1<Void, TrackNetworkMetadataReceiver> {
        public static final C57821 INSTANCE = new C57821();

        public C57821() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final TrackNetworkMetadataReceiver invoke(Void r1) {
            return new TrackNetworkActionUserLogout();
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreAuthentication$logout$3 */
    /* JADX INFO: compiled from: StoreAuthentication.kt */
    public static final class C57843 extends AbstractC12240o implements Function1<String, Unit> {
        public C57843() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String str) {
            StoreStream.INSTANCE.getNux().clearNux();
            StoreAuthentication.this.publishAuthState(null);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreAuthentication$logout$4 */
    /* JADX INFO: compiled from: StoreAuthentication.kt */
    public static final class C57854 extends AbstractC12240o implements Function1<Error, Unit> {
        public C57854() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            C12238m.checkNotNullParameter(error, "it");
            StoreAuthentication.this.publishAuthState(null);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreAuthentication$onPasswordChanged$1 */
    /* JADX INFO: compiled from: StoreAuthentication.kt */
    public static final class C57861 extends AbstractC12240o implements Function0<Unit> {
        public final /* synthetic */ String $token;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C57861(String str) {
            super(0);
            this.$token = str;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            Set<RequiredAction> setEmptySet;
            AuthState authState = StoreAuthentication.this.getAuthState();
            if (authState == null || (setEmptySet = authState.getRequiredActions()) == null) {
                setEmptySet = C12148n0.emptySet();
            }
            StoreAuthentication.this.publishAuthState(AuthState.INSTANCE.from(this.$token, C12150o0.minus(setEmptySet, RequiredAction.UPDATE_PASSWORD)));
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreAuthentication$register$1 */
    /* JADX INFO: compiled from: StoreAuthentication.kt */
    public static final class C57871<T, R> implements InterfaceC12589b<String, Observable<? extends RegisterResponse>> {
        public final /* synthetic */ CaptchaHelper.CaptchaPayload $captchaPayload;
        public final /* synthetic */ boolean $consent;
        public final /* synthetic */ String $dateOfBirth;
        public final /* synthetic */ String $email;
        public final /* synthetic */ String $password;
        public final /* synthetic */ String $phoneToken;
        public final /* synthetic */ String $username;

        /* JADX INFO: renamed from: com.discord.stores.StoreAuthentication$register$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: StoreAuthentication.kt */
        public static final /* synthetic */ class AnonymousClass1 extends C12236k implements Function2<StoreInviteSettings.InviteCode, String, AuthRequestParams> {
            public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

            public AnonymousClass1() {
                super(2, AuthRequestParams.class, "<init>", "<init>(Lcom/discord/stores/StoreInviteSettings$InviteCode;Ljava/lang/String;)V", 0);
            }

            @Override // kotlin.jvm.functions.Function2
            public final AuthRequestParams invoke(StoreInviteSettings.InviteCode inviteCode, String str) {
                return new AuthRequestParams(inviteCode, str);
            }
        }

        public C57871(String str, String str2, String str3, String str4, CaptchaHelper.CaptchaPayload captchaPayload, boolean z2, String str5) {
            this.$username = str;
            this.$email = str2;
            this.$phoneToken = str3;
            this.$password = str4;
            this.$captchaPayload = captchaPayload;
            this.$consent = z2;
            this.$dateOfBirth = str5;
        }

        @Override // p637j0.p641k.InterfaceC12589b
        public final Observable<? extends RegisterResponse> call(final String str) {
            StoreStream.Companion companion = StoreStream.INSTANCE;
            Observable<StoreInviteSettings.InviteCode> inviteCode = companion.getInviteSettings().getInviteCode();
            Observable<String> observableObserveDynamicLinkGuildTemplateCode = companion.getGuildTemplates().observeDynamicLinkGuildTemplateCode();
            final AnonymousClass1 anonymousClass1 = AnonymousClass1.INSTANCE;
            Object obj = anonymousClass1;
            if (anonymousClass1 != null) {
                obj = new Func2() { // from class: com.discord.stores.StoreAuthentication$sam$rx_functions_Func2$0
                    @Override // p658rx.functions.Func2
                    public final /* synthetic */ Object call(Object obj2, Object obj3) {
                        return anonymousClass1.invoke(obj2, obj3);
                    }
                };
            }
            Observable observableM11076j = Observable.m11076j(inviteCode, observableObserveDynamicLinkGuildTemplateCode, (Func2) obj);
            C12238m.checkNotNullExpressionValue(observableM11076j, "Observable.combineLatest…RequestParams\n          )");
            Observable<R> observableM11082A = ObservableExtensionsKt.takeSingleUntilTimeout$default(observableM11076j, 500L, false, 2, null).m11082A(new InterfaceC12589b<AuthRequestParams, Observable<? extends RegisterResponse>>() { // from class: com.discord.stores.StoreAuthentication.register.1.2

                /* JADX INFO: renamed from: com.discord.stores.StoreAuthentication$register$1$2$1, reason: invalid class name */
                /* JADX INFO: compiled from: StoreAuthentication.kt */
                public static final class AnonymousClass1 extends AbstractC12240o implements Function1<RegisterResponse, TrackNetworkMetadataReceiver> {
                    public final /* synthetic */ String $inviteCode;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    public AnonymousClass1(String str) {
                        super(1);
                        this.$inviteCode = str;
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final TrackNetworkMetadataReceiver invoke(RegisterResponse registerResponse) {
                        return new TrackNetworkActionUserRegister(this.$inviteCode, Boolean.valueOf(C57871.this.$consent), Boolean.FALSE);
                    }
                }

                @Override // p637j0.p641k.InterfaceC12589b
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
                    C57871 c57871 = C57871.this;
                    String str3 = c57871.$username;
                    String str4 = c57871.$email;
                    String str5 = c57871.$phoneToken;
                    String str6 = c57871.$password;
                    CaptchaHelper.CaptchaPayload captchaPayload = c57871.$captchaPayload;
                    String captchaKey = captchaPayload != null ? captchaPayload.getCaptchaKey() : null;
                    CaptchaHelper.CaptchaPayload captchaPayload2 = C57871.this.$captchaPayload;
                    String captchaRqtoken = captchaPayload2 != null ? captchaPayload2.getCaptchaRqtoken() : null;
                    String guildTemplateCode = authRequestParams.getGuildTemplateCode();
                    C57871 c57872 = C57871.this;
                    return RestCallStateKt.logNetworkAction(api.postAuthRegister(new RestAPIParams.AuthRegister(str2, str3, str4, str5, str6, captchaKey, captchaRqtoken, inviteCode3, guildTemplateCode, c57872.$consent, c57872.$dateOfBirth)), new AnonymousClass1(inviteCode3));
                }
            });
            C12238m.checkNotNullExpressionValue(observableM11082A, "Observable.combineLatest…        }\n              }");
            return ObservableExtensionsKt.takeSingleUntilTimeout$default(ObservableExtensionsKt.restSubscribeOn$default(observableM11082A, false, 1, null), 0L, false, 3, null).m11115u(new Action1<RegisterResponse>() { // from class: com.discord.stores.StoreAuthentication.register.1.3
                @Override // p658rx.functions.Action1
                public final void call(RegisterResponse registerResponse) {
                    StoreStream.Companion companion2 = StoreStream.INSTANCE;
                    companion2.getUserSettingsSystem().setIsSyncThemeEnabled(false);
                    StoreAuthentication.this.setFingerprint(null, true);
                    StoreAuthentication.this.publishAuthState(new AuthState(registerResponse.getToken(), C12148n0.emptySet()));
                    AnalyticsTracker.INSTANCE.appFirstLogin();
                    companion2.getNotifications().setEnabledInApp(true, false);
                    companion2.getNux().setFirstOpen(true);
                }
            });
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreAuthentication$requestConsentRequired$1 */
    /* JADX INFO: compiled from: StoreAuthentication.kt */
    public static final class C57881 extends AbstractC12240o implements Function1<ModelLocationMetadata, Unit> {
        public C57881() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ModelLocationMetadata modelLocationMetadata) {
            invoke2(modelLocationMetadata);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ModelLocationMetadata modelLocationMetadata) {
            C12238m.checkNotNullParameter(modelLocationMetadata, "it");
            StoreAuthentication.this.setConsentRequired(modelLocationMetadata.getConsentRequired());
            String countryCode = modelLocationMetadata.getCountryCode();
            if (countryCode != null) {
                StoreStream.INSTANCE.getPhone().updateDefaultCountryCode(countryCode);
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreAuthentication$requestConsentRequired$2 */
    /* JADX INFO: compiled from: StoreAuthentication.kt */
    public static final class C57892 extends AbstractC12240o implements Function1<Error, Unit> {
        public C57892() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            C12238m.checkNotNullParameter(error, "it");
            StoreAuthentication.this.setConsentRequired(true);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreAuthentication$requestConsentRequired$3 */
    /* JADX INFO: compiled from: StoreAuthentication.kt */
    public static final class C57903 extends AbstractC12240o implements Function1<Subscription, Unit> {
        public C57903() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Subscription subscription) {
            invoke2(subscription);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Subscription subscription) {
            C12238m.checkNotNullParameter(subscription, "consentSubscription");
            StoreAuthentication.this.isConsentRequiredSubscription = subscription;
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreAuthentication$setAgeGateError$1 */
    /* JADX INFO: compiled from: StoreAuthentication.kt */
    public static final class C57911 extends AbstractC12240o implements Function0<Unit> {
        public final /* synthetic */ String $error;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C57911(String str) {
            super(0);
            this.$error = str;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreAuthentication.this.handleAgeGateError(this.$error);
        }
    }

    public StoreAuthentication(StoreStream storeStream, Dispatcher dispatcher) {
        C12238m.checkNotNullParameter(storeStream, "storeStream");
        C12238m.checkNotNullParameter(dispatcher, "dispatcher");
        this.storeStream = storeStream;
        this.dispatcher = dispatcher;
        this.userInitiatedAuthEventSubject = PublishSubject.m11133k0();
        this.fingerprintSubject = new SerializedSubject<>(BehaviorSubject.m11129k0());
        this.authStateSubject = new SerializedSubject<>(BehaviorSubject.m11130l0(null));
        BehaviorSubject<String> behaviorSubjectM11129k0 = BehaviorSubject.m11129k0();
        C12238m.checkNotNullExpressionValue(behaviorSubjectM11129k0, "BehaviorSubject.create()");
        this.ageGateError = behaviorSubjectM11129k0;
        this.oauthUriSubject = new SerializedSubject<>(BehaviorSubject.m11130l0(Uri.EMPTY));
        this.authStateCache = new AuthStateCache(getPrefs());
    }

    private final void dispatchLogin(ModelLoginResult loginResult) {
        this.dispatcher.schedule(new C57741(loginResult));
    }

    private final Observable<String> getFingerprintSnapshotOrGenerate() {
        Observable<String> observableM11115u = this.fingerprintSubject.m11100Z(1).m11099Y(new InterfaceC12589b<String, Observable<? extends String>>() { // from class: com.discord.stores.StoreAuthentication.getFingerprintSnapshotOrGenerate.1
            @Override // p637j0.p641k.InterfaceC12589b
            public final Observable<? extends String> call(String str) {
                return str != null ? new C12721k(str) : ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().postAuthFingerprint(new RestAPIParams.EmptyBody()), false, 1, null).m11083G(new InterfaceC12589b<FingerprintResponse, String>() { // from class: com.discord.stores.StoreAuthentication.getFingerprintSnapshotOrGenerate.1.2
                    @Override // p637j0.p641k.InterfaceC12589b
                    public final String call(FingerprintResponse fingerprintResponse) {
                        return fingerprintResponse.getFingerprint();
                    }
                });
            }
        }).m11115u(new Action1<String>() { // from class: com.discord.stores.StoreAuthentication.getFingerprintSnapshotOrGenerate.2
            @Override // p658rx.functions.Action1
            public final void call(String str) {
                StoreAuthentication.this.setFingerprint(str, false);
            }
        });
        C12238m.checkNotNullExpressionValue(observableM11115u, "fingerprintSubject\n     …int(fingerprint, false) }");
        return observableM11115u;
    }

    private final Set<RequiredAction> getRequiredActionsFromLoginResponse(ModelLoginResult loginResult) {
        Set<RequiredAction> set;
        List<RequiredAction> requiredActions = loginResult.getRequiredActions();
        return (requiredActions == null || (set = C12163u.toSet(requiredActions)) == null) ? C12148n0.emptySet() : set;
    }

    public static /* synthetic */ Observable login$default(StoreAuthentication storeAuthentication, String str, String str2, CaptchaHelper.CaptchaPayload captchaPayload, boolean z2, String str3, int i, Object obj) {
        if ((i & 16) != 0) {
            str3 = null;
        }
        return storeAuthentication.login(str, str2, captchaPayload, z2, str3);
    }

    private final void publishAuthState(AuthState authState) {
        this.authStateSubject.f27653k.onNext(authState);
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
        AppLog.m8357g(null, str, null);
        getPrefsSessionDurable().edit().putString(CACHE_KEY_LOGIN, str).apply();
    }

    public final Observable<ModelLoginResult> authMFA(String code, String ticket) {
        C12238m.checkNotNullParameter(code, ModelAuditLogEntry.CHANGE_KEY_CODE);
        C12238m.checkNotNullParameter(ticket, "ticket");
        Observable<ModelLoginResult> observableM11115u = ObservableExtensionsKt.restSubscribeOn$default(RestCallStateKt.logNetworkAction(RestAPI.INSTANCE.getApi().postMFACode(new RestAPIParams.MFALogin(ticket, code)), C57711.INSTANCE), false, 1, null).m11115u(new Action1<ModelLoginResult>() { // from class: com.discord.stores.StoreAuthentication.authMFA.2
            @Override // p658rx.functions.Action1
            public final void call(ModelLoginResult modelLoginResult) {
                StoreAuthentication storeAuthentication = StoreAuthentication.this;
                C12238m.checkNotNullExpressionValue(modelLoginResult, "loginResult");
                storeAuthentication.dispatchLogin(modelLoginResult);
            }
        });
        C12238m.checkNotNullExpressionValue(observableM11115u, "RestAPI\n        .api\n   …in(loginResult)\n        }");
        return observableM11115u;
    }

    public final Observable<Void> authorizeIP(String token) {
        C12238m.checkNotNullParameter(token, CACHE_KEY_TOKEN_RNA);
        return RestCallStateKt.logNetworkAction(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().authorizeIP(new RestAPIParams.AuthorizeIP(token)), false, 1, null), C57731.INSTANCE);
    }

    public final Observable<Void> forgotPassword(String login, CaptchaHelper.CaptchaPayload captchaPayload) {
        C12238m.checkNotNullParameter(login, "login");
        return ObservableExtensionsKt.restSubscribeOn$default(RestCallStateKt.logNetworkAction(RestAPI.INSTANCE.getApi().forgotPassword(new RestAPIParams.ForgotPassword(login, captchaPayload != null ? captchaPayload.getCaptchaKey() : null, captchaPayload != null ? captchaPayload.getCaptchaRqtoken() : null)), C57751.INSTANCE), false, 1, null);
    }

    public final Observable<String> getAgeGateError() {
        Observable<String> observableM11112r = this.ageGateError.m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r, "ageGateError.distinctUntilChanged()");
        return observableM11112r;
    }

    /* JADX INFO: renamed from: getAuthState$app_productionGoogleRelease, reason: from getter */
    public final AuthState getAuthState() {
        return this.authState;
    }

    public final Observable<String> getAuthedToken$app_productionGoogleRelease() {
        Observable observableM11083G = this.authStateSubject.m11112r().m11083G(new InterfaceC12589b<AuthState, String>() { // from class: com.discord.stores.StoreAuthentication$getAuthedToken$1
            @Override // p637j0.p641k.InterfaceC12589b
            public final String call(AuthState authState) {
                if (authState != null) {
                    return authState.getToken();
                }
                return null;
            }
        });
        C12238m.checkNotNullExpressionValue(observableM11083G, "authStateSubject.distinc…anged().map { it?.token }");
        return observableM11083G;
    }

    public final Observable<String> getFingerPrint$app_productionGoogleRelease() {
        Observable<String> observableM11112r = this.fingerprintSubject.m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r, "fingerprintSubject.distinctUntilChanged()");
        return observableM11112r;
    }

    /* JADX INFO: renamed from: getFingerprint$app_productionGoogleRelease, reason: from getter */
    public final String getFingerprint() {
        return this.fingerprint;
    }

    public final Observable<Uri> getOAuthUriObservable() {
        Observable<Uri> observableM11112r = this.oauthUriSubject.m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r, "oauthUriSubject.distinctUntilChanged()");
        return observableM11112r;
    }

    public final Observable<Boolean> getPreLogoutSignal$app_productionGoogleRelease() {
        Observable<Boolean> observableM11118y = this.userInitiatedAuthEventSubject.m11118y(new InterfaceC12589b<Boolean, Boolean>() { // from class: com.discord.stores.StoreAuthentication$getPreLogoutSignal$1
            @Override // p637j0.p641k.InterfaceC12589b
            public final Boolean call(Boolean bool) {
                return Boolean.valueOf(!bool.booleanValue());
            }
        });
        C12238m.checkNotNullExpressionValue(observableM11118y, "userInitiatedAuthEventSu…LoggedIn -> !isLoggedIn }");
        return observableM11118y;
    }

    public final String getSavedLogin() {
        return this.savedLogin;
    }

    public final Observable<StoreNavigation.AgeGate> getShouldShowAgeGate() {
        Observable<StoreNavigation.AgeGate> observableM11112r = Observable.m11075i(this.storeStream.getUsers().observeMe(true), this.storeStream.getAuthentication().getAgeGateError(), this.storeStream.getChannelsSelected().observeSelectedChannel(), new Func3<MeUser, String, Channel, StoreNavigation.AgeGate>() { // from class: com.discord.stores.StoreAuthentication.getShouldShowAgeGate.1
            @Override // p658rx.functions.Func3
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
        }).m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r, "Observable.combineLatest…  .distinctUntilChanged()");
        return observableM11112r;
    }

    @StoreThread
    public final void handleAgeGateError(String error) {
        this.ageGateError.onNext(error);
    }

    @StoreThread
    public final void handleAuthState$app_productionGoogleRelease(AuthState authState) {
        this.authState = authState;
        this.authStateCache.cacheAuthState(authState);
        if (authState == null) {
            Persister.INSTANCE.reset();
            SharedPreferences.Editor editorEdit = getPrefs().edit();
            C12238m.checkNotNullExpressionValue(editorEdit, "editor");
            editorEdit.clear();
            editorEdit.apply();
        }
    }

    @StoreThread
    public final void handleLoginResult(ModelLoginResult loginResult) {
        C12238m.checkNotNullParameter(loginResult, "loginResult");
        setFingerprint(null, true);
        publishAuthState(AuthState.INSTANCE.from(loginResult.getToken(), getRequiredActionsFromLoginResponse(loginResult)));
        if (loginResult.getToken() != null) {
            setAgeGateError(null);
            AnalyticsTracker.INSTANCE.appFirstLogin();
        }
        PublishSubject<Boolean> publishSubject = this.userInitiatedAuthEventSubject;
        publishSubject.f27650k.onNext(Boolean.TRUE);
        StoreStream.INSTANCE.getNux().setFirstOpen(true);
    }

    @StoreThread
    public final void handlePreLogout$app_productionGoogleRelease() {
        resetIsConsentRequired();
    }

    @Override // com.discord.stores.Store
    @StoreThread
    public synchronized void init(Context context) {
        C12238m.checkNotNullParameter(context, "context");
        super.init(context);
        String string = getPrefsSessionDurable().getString(CACHE_KEY_FINGERPRINT, null);
        if (string != null) {
            setFingerprint(string, false);
        }
        AuthState cachedAuthState = this.authStateCache.getCachedAuthState();
        if (cachedAuthState == null) {
            cachedAuthState = AuthState.INSTANCE.from(INSTANCE.getRnaAuthToken(context), C12148n0.emptySet());
        }
        if (AuthState.INSTANCE.isUpdatePasswordRequired(cachedAuthState)) {
            logout();
        } else {
            this.authState = cachedAuthState;
            publishAuthState(cachedAuthState);
        }
        handleAgeGateError(null);
        setSavedLogin(getPrefsSessionDurable().getString(CACHE_KEY_LOGIN, INSTANCE.getDeviceEmail(context)));
        Observable<Boolean> observableM11112r = this.userInitiatedAuthEventSubject.m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r, "userInitiatedAuthEventSu…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.m8518ui(ObservableExtensionsKt.computationLatest(observableM11112r)), (Class<?>) getClass(), (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C57791(context));
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
        C12238m.checkNotNullParameter(login, "login");
        C12238m.checkNotNullParameter(password, WidgetSettingsAccountChangePassword.CURRENT_PASSWORD_FIELD);
        setSavedLogin(login);
        Observable<ModelLoginResult> observableM11115u = getFingerprintSnapshotOrGenerate().m11082A(new InterfaceC12589b<String, Observable<? extends ModelLoginResult>>() { // from class: com.discord.stores.StoreAuthentication.login.1

            /* JADX INFO: renamed from: com.discord.stores.StoreAuthentication$login$1$1, reason: invalid class name */
            /* JADX INFO: compiled from: StoreAuthentication.kt */
            public static final class AnonymousClass1 extends AbstractC12240o implements Function1<ModelLoginResult, TrackNetworkMetadataReceiver> {
                public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

                public AnonymousClass1() {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final TrackNetworkMetadataReceiver invoke(ModelLoginResult modelLoginResult) {
                    Observable<T> observableM11087M = ObservableExtensionsKt.takeSingleUntilTimeout$default(StoreStream.INSTANCE.getInviteSettings().getInvite(), 250L, false, 2, null).m11087M(new InterfaceC12589b<Throwable, ModelInvite>() { // from class: com.discord.stores.StoreAuthentication$login$1$1$invite$1
                        @Override // p637j0.p641k.InterfaceC12589b
                        public final ModelInvite call(Throwable th) {
                            return null;
                        }
                    });
                    ModelInvite modelInvite = (ModelInvite) new C12756a(observableM11087M).m10859a(observableM11087M.m11119z());
                    return new TrackNetworkActionUserLogin(modelInvite != null ? modelInvite.code : null, null, 2);
                }
            }

            @Override // p637j0.p641k.InterfaceC12589b
            public final Observable<? extends ModelLoginResult> call(String str) {
                RestAPI api = RestAPI.INSTANCE.getApi();
                String str2 = login;
                String str3 = password;
                CaptchaHelper.CaptchaPayload captchaPayload2 = captchaPayload;
                String captchaKey = captchaPayload2 != null ? captchaPayload2.getCaptchaKey() : null;
                CaptchaHelper.CaptchaPayload captchaPayload3 = captchaPayload;
                return RestCallStateKt.logNetworkAction(ObservableExtensionsKt.restSubscribeOn$default(api.postAuthLogin(new RestAPIParams.AuthLogin(str2, str3, captchaKey, captchaPayload3 != null ? captchaPayload3.getCaptchaRqtoken() : null, Boolean.valueOf(undelete), loginSource)), false, 1, null), AnonymousClass1.INSTANCE);
            }
        }).m11115u(new Action1<ModelLoginResult>() { // from class: com.discord.stores.StoreAuthentication.login.2
            @Override // p658rx.functions.Action1
            public final void call(ModelLoginResult modelLoginResult) {
                if (modelLoginResult.getMfa()) {
                    return;
                }
                StoreAuthentication storeAuthentication = StoreAuthentication.this;
                C12238m.checkNotNullExpressionValue(modelLoginResult, "loginResult");
                storeAuthentication.dispatchLogin(modelLoginResult);
            }
        });
        C12238m.checkNotNullExpressionValue(observableM11115u, "getFingerprintSnapshotOr…lt)\n          }\n        }");
        return observableM11115u;
    }

    public final void logout() {
        PublishSubject<Boolean> publishSubject = this.userInitiatedAuthEventSubject;
        publishSubject.f27650k.onNext(Boolean.FALSE);
        Observable observableM11082A = ObservableExtensionsKt.restSubscribeOn$default(RestCallStateKt.logNetworkAction(RestAPI.INSTANCE.getApi().logout(new RestAPIParams.UserDevices(StoreStream.INSTANCE.getNotifications().getPushToken())), C57821.INSTANCE), false, 1, null).m11082A(new InterfaceC12589b<Void, Observable<? extends String>>() { // from class: com.discord.stores.StoreAuthentication.logout.2
            @Override // p637j0.p641k.InterfaceC12589b
            public final Observable<? extends String> call(Void r1) {
                return StoreAuthentication.this.getFingerprintSnapshotOrGenerate();
            }
        });
        C12238m.checkNotNullExpressionValue(observableM11082A, "RestAPI\n        .api\n   …intSnapshotOrGenerate() }");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.takeSingleUntilTimeout$default(observableM11082A, 0L, false, 3, null), (117 & 1) != 0 ? null : null, "logout", (Function1<? super Subscription, Unit>) ((117 & 4) != 0 ? null : null), new C57843(), (Function1<? super Error, Unit>) ((117 & 16) != 0 ? null : new C57854()), (Function0<Unit>) ((117 & 32) != 0 ? ObservableExtensionsKt.C68813.INSTANCE : null), (Function0<Unit>) ((117 & 64) != 0 ? ObservableExtensionsKt.C68824.INSTANCE : null));
    }

    public final Observable<Boolean> observeIsAuthed$app_productionGoogleRelease() {
        Observable observableM11083G = m11385getAuthState$app_productionGoogleRelease().m11083G(new InterfaceC12589b<AuthState, Boolean>() { // from class: com.discord.stores.StoreAuthentication$observeIsAuthed$1
            @Override // p637j0.p641k.InterfaceC12589b
            public final Boolean call(AuthState authState) {
                return Boolean.valueOf(authState != null);
            }
        });
        C12238m.checkNotNullExpressionValue(observableM11083G, "getAuthState()\n      .ma…te -> authState != null }");
        return observableM11083G;
    }

    public final void onPasswordChanged(String token) {
        this.dispatcher.schedule(new C57861(token));
    }

    public final Observable<RegisterResponse> register(String username, String email, String phoneToken, String password, CaptchaHelper.CaptchaPayload captchaPayload, boolean consent, String dateOfBirth) {
        C12238m.checkNotNullParameter(username, "username");
        C12238m.checkNotNullParameter(password, WidgetSettingsAccountChangePassword.CURRENT_PASSWORD_FIELD);
        setSavedLogin(email);
        Observable observableM11082A = getFingerprintSnapshotOrGenerate().m11082A(new C57871(username, email, phoneToken, password, captchaPayload, consent, dateOfBirth));
        C12238m.checkNotNullExpressionValue(observableM11082A, "getFingerprintSnapshotOr…              }\n        }");
        return observableM11082A;
    }

    public final synchronized void requestConsentRequired() {
        if (this._isConsentRequired != null) {
            return;
        }
        resetIsConsentRequired();
        Observable observableRestSubscribeOn$default = ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().getLocationMetadata(), false, 1, null);
        Class<?> cls = getClass();
        ObservableExtensionsKt.appSubscribe(observableRestSubscribeOn$default, (Class<?>) cls, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : new C57903()), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new C57892()), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C57881());
    }

    public final void setAgeGateError(String error) {
        this.dispatcher.schedule(new C57911(error));
    }

    public final void setAuthed(String authToken) {
        publishAuthState(AuthState.INSTANCE.from(authToken, C12148n0.emptySet()));
    }

    /* JADX WARN: Code duplicated, block: B:6:0x0007 A[Catch: all -> 0x0044, TryCatch #0 {, blocks: (B:4:0x0003, B:9:0x002c, B:11:0x0030, B:14:0x003a, B:6:0x0007, B:8:0x0023), top: B:20:0x0003 }] */
    /* JADX WARN: Code duplicated, block: B:8:0x0023 A[Catch: all -> 0x0044, TryCatch #0 {, blocks: (B:4:0x0003, B:9:0x002c, B:11:0x0030, B:14:0x003a, B:6:0x0007, B:8:0x0023), top: B:20:0x0003 }] */
    public final synchronized void setFingerprint(String fingerprint, boolean force) {
        String str;
        if (force) {
            getPrefsSessionDurable().edit().putString(CACHE_KEY_FINGERPRINT, fingerprint).apply();
            this.fingerprint = fingerprint;
            this.fingerprintSubject.f27653k.onNext(fingerprint);
            if (fingerprint != null) {
                FirebaseCrashlytics.getInstance().setCustomKey("fingerprint", fingerprint);
            }
            str = this.fingerprint;
            if (str != null) {
                String str2 = this.fingerprint;
                C12238m.checkNotNull(str2);
                AnalyticsTracker.externalFingerprintDropped(str2, fingerprint);
            }
        } else {
            if (this.fingerprint == null) {
                getPrefsSessionDurable().edit().putString(CACHE_KEY_FINGERPRINT, fingerprint).apply();
                this.fingerprint = fingerprint;
                this.fingerprintSubject.f27653k.onNext(fingerprint);
                if (fingerprint != null) {
                    FirebaseCrashlytics.getInstance().setCustomKey("fingerprint", fingerprint);
                }
            }
            str = this.fingerprint;
            if (str != null && (!C12238m.areEqual(str, fingerprint)) && fingerprint != null) {
                String str3 = this.fingerprint;
                C12238m.checkNotNull(str3);
                AnalyticsTracker.externalFingerprintDropped(str3, fingerprint);
            }
        }
        throw th;
    }

    public final void setOAuthUriSubject(Uri uri) {
        C12238m.checkNotNullParameter(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
        this.oauthUriSubject.f27653k.onNext(uri);
    }

    /* JADX INFO: renamed from: getAuthState$app_productionGoogleRelease, reason: collision with other method in class */
    public final Observable<AuthState> m11385getAuthState$app_productionGoogleRelease() {
        Observable<AuthState> observableM11112r = this.authStateSubject.m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r, "authStateSubject.distinctUntilChanged()");
        return observableM11112r;
    }
}
