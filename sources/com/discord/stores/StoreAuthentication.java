package com.discord.stores;

import android.content.Context;
import android.content.SharedPreferences$Editor;
import android.net.Uri;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationCompat$MessagingStyle$Message;
import com.discord.api.auth.RegisterResponse;
import com.discord.api.auth.RequiredAction;
import com.discord.app.AppLog;
import com.discord.models.authentication.AuthState;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.auth.ModelLoginResult;
import com.discord.restapi.RestAPIParams$AuthorizeIP;
import com.discord.restapi.RestAPIParams$ForgotPassword;
import com.discord.restapi.RestAPIParams$MFALogin;
import com.discord.restapi.RestAPIParams$UserDevices;
import com.discord.stores.authentication.AuthStateCache;
import com.discord.stores.utilities.RestCallStateKt;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.captcha.CaptchaHelper$CaptchaPayload;
import com.discord.utilities.persister.Persister;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.settings.account.WidgetSettingsAccountChangePassword;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import d0.t.n0;
import d0.t.u;
import d0.z.d.m;
import java.util.List;
import java.util.Set;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import rx.Observable;
import rx.Subscription;
import rx.subjects.BehaviorSubject;
import rx.subjects.PublishSubject;
import rx.subjects.SerializedSubject;

/* JADX INFO: compiled from: StoreAuthentication.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreAuthentication extends Store {
    private static final String CACHE_KEY_FINGERPRINT = "STORE_AUTHED_FINGERPRINT";
    private static final String CACHE_KEY_LOGIN = "STORE_AUTHED_LOGIN";
    private static final String CACHE_KEY_TOKEN_RNA = "token";
    public static final StoreAuthentication$Companion Companion = new StoreAuthentication$Companion(null);
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

    public StoreAuthentication(StoreStream storeStream, Dispatcher dispatcher) {
        m.checkNotNullParameter(storeStream, "storeStream");
        m.checkNotNullParameter(dispatcher, "dispatcher");
        this.storeStream = storeStream;
        this.dispatcher = dispatcher;
        this.userInitiatedAuthEventSubject = PublishSubject.k0();
        this.fingerprintSubject = new SerializedSubject<>(BehaviorSubject.k0());
        this.authStateSubject = new SerializedSubject<>(BehaviorSubject.l0(null));
        BehaviorSubject<String> behaviorSubjectK0 = BehaviorSubject.k0();
        m.checkNotNullExpressionValue(behaviorSubjectK0, "BehaviorSubject.create()");
        this.ageGateError = behaviorSubjectK0;
        this.oauthUriSubject = new SerializedSubject<>(BehaviorSubject.l0(Uri.EMPTY));
        this.authStateCache = new AuthStateCache(getPrefs());
    }

    public static final /* synthetic */ void access$dispatchLogin(StoreAuthentication storeAuthentication, ModelLoginResult modelLoginResult) {
        storeAuthentication.dispatchLogin(modelLoginResult);
    }

    public static final /* synthetic */ AuthState access$getAuthState$p(StoreAuthentication storeAuthentication) {
        return storeAuthentication.authState;
    }

    public static final /* synthetic */ Observable access$getFingerprintSnapshotOrGenerate(StoreAuthentication storeAuthentication) {
        return storeAuthentication.getFingerprintSnapshotOrGenerate();
    }

    public static final /* synthetic */ StoreStream access$getStoreStream$p(StoreAuthentication storeAuthentication) {
        return storeAuthentication.storeStream;
    }

    public static final /* synthetic */ boolean access$isConsentRequired$p(StoreAuthentication storeAuthentication) {
        return storeAuthentication.isConsentRequired();
    }

    public static final /* synthetic */ Subscription access$isConsentRequiredSubscription$p(StoreAuthentication storeAuthentication) {
        return storeAuthentication.isConsentRequiredSubscription;
    }

    public static final /* synthetic */ void access$publishAuthState(StoreAuthentication storeAuthentication, AuthState authState) {
        storeAuthentication.publishAuthState(authState);
    }

    public static final /* synthetic */ void access$setAuthState$p(StoreAuthentication storeAuthentication, AuthState authState) {
        storeAuthentication.authState = authState;
    }

    public static final /* synthetic */ void access$setConsentRequired$p(StoreAuthentication storeAuthentication, boolean z2) {
        storeAuthentication.setConsentRequired(z2);
    }

    public static final /* synthetic */ void access$setConsentRequiredSubscription$p(StoreAuthentication storeAuthentication, Subscription subscription) {
        storeAuthentication.isConsentRequiredSubscription = subscription;
    }

    private final void dispatchLogin(ModelLoginResult loginResult) {
        this.dispatcher.schedule(new StoreAuthentication$dispatchLogin$1(this, loginResult));
    }

    private final Observable<String> getFingerprintSnapshotOrGenerate() {
        Observable<String> observableU = this.fingerprintSubject.Z(1).Y(StoreAuthentication$getFingerprintSnapshotOrGenerate$1.INSTANCE).u(new StoreAuthentication$getFingerprintSnapshotOrGenerate$2(this));
        m.checkNotNullExpressionValue(observableU, "fingerprintSubject\n     …int(fingerprint, false) }");
        return observableU;
    }

    private final Set<RequiredAction> getRequiredActionsFromLoginResponse(ModelLoginResult loginResult) {
        Set<RequiredAction> set;
        List<RequiredAction> requiredActions = loginResult.getRequiredActions();
        return (requiredActions == null || (set = u.toSet(requiredActions)) == null) ? n0.emptySet() : set;
    }

    public static /* synthetic */ Observable login$default(StoreAuthentication storeAuthentication, String str, String str2, CaptchaHelper$CaptchaPayload captchaHelper$CaptchaPayload, boolean z2, String str3, int i, Object obj) {
        if ((i & 16) != 0) {
            str3 = null;
        }
        return storeAuthentication.login(str, str2, captchaHelper$CaptchaPayload, z2, str3);
    }

    private final void publishAuthState(AuthState authState) {
        this.authStateSubject.k.onNext(authState);
    }

    public static /* synthetic */ Observable register$default(StoreAuthentication storeAuthentication, String str, String str2, String str3, String str4, CaptchaHelper$CaptchaPayload captchaHelper$CaptchaPayload, boolean z2, String str5, int i, Object obj) {
        return storeAuthentication.register(str, str2, str3, str4, captchaHelper$CaptchaPayload, z2, (i & 64) != 0 ? null : str5);
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
        m.checkNotNullParameter(code, ModelAuditLogEntry.CHANGE_KEY_CODE);
        m.checkNotNullParameter(ticket, "ticket");
        Observable<ModelLoginResult> observableU = ObservableExtensionsKt.restSubscribeOn$default(RestCallStateKt.logNetworkAction(RestAPI.Companion.getApi().postMFACode(new RestAPIParams$MFALogin(ticket, code)), StoreAuthentication$authMFA$1.INSTANCE), false, 1, null).u(new StoreAuthentication$authMFA$2(this));
        m.checkNotNullExpressionValue(observableU, "RestAPI\n        .api\n   …in(loginResult)\n        }");
        return observableU;
    }

    public final Observable<Void> authorizeIP(String token) {
        m.checkNotNullParameter(token, CACHE_KEY_TOKEN_RNA);
        return RestCallStateKt.logNetworkAction(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.Companion.getApi().authorizeIP(new RestAPIParams$AuthorizeIP(token)), false, 1, null), StoreAuthentication$authorizeIP$1.INSTANCE);
    }

    public final Observable<Void> forgotPassword(String login, CaptchaHelper$CaptchaPayload captchaPayload) {
        m.checkNotNullParameter(login, "login");
        return ObservableExtensionsKt.restSubscribeOn$default(RestCallStateKt.logNetworkAction(RestAPI.Companion.getApi().forgotPassword(new RestAPIParams$ForgotPassword(login, captchaPayload != null ? captchaPayload.getCaptchaKey() : null, captchaPayload != null ? captchaPayload.getCaptchaRqtoken() : null)), StoreAuthentication$forgotPassword$1.INSTANCE), false, 1, null);
    }

    public final Observable<String> getAgeGateError() {
        Observable<String> observableR = this.ageGateError.r();
        m.checkNotNullExpressionValue(observableR, "ageGateError.distinctUntilChanged()");
        return observableR;
    }

    /* JADX INFO: renamed from: getAuthState$app_productionGoogleRelease, reason: from getter */
    public final AuthState getAuthState() {
        return this.authState;
    }

    public final Observable<String> getAuthedToken$app_productionGoogleRelease() {
        Observable observableG = this.authStateSubject.r().G(StoreAuthentication$getAuthedToken$1.INSTANCE);
        m.checkNotNullExpressionValue(observableG, "authStateSubject.distinc…anged().map { it?.token }");
        return observableG;
    }

    public final Observable<String> getFingerPrint$app_productionGoogleRelease() {
        Observable<String> observableR = this.fingerprintSubject.r();
        m.checkNotNullExpressionValue(observableR, "fingerprintSubject.distinctUntilChanged()");
        return observableR;
    }

    /* JADX INFO: renamed from: getFingerprint$app_productionGoogleRelease, reason: from getter */
    public final String getFingerprint() {
        return this.fingerprint;
    }

    public final Observable<Uri> getOAuthUriObservable() {
        Observable<Uri> observableR = this.oauthUriSubject.r();
        m.checkNotNullExpressionValue(observableR, "oauthUriSubject.distinctUntilChanged()");
        return observableR;
    }

    public final Observable<Boolean> getPreLogoutSignal$app_productionGoogleRelease() {
        Observable<Boolean> observableY = this.userInitiatedAuthEventSubject.y(StoreAuthentication$getPreLogoutSignal$1.INSTANCE);
        m.checkNotNullExpressionValue(observableY, "userInitiatedAuthEventSu…LoggedIn -> !isLoggedIn }");
        return observableY;
    }

    public final String getSavedLogin() {
        return this.savedLogin;
    }

    public final Observable<StoreNavigation$AgeGate> getShouldShowAgeGate() {
        Observable<StoreNavigation$AgeGate> observableR = Observable.i(this.storeStream.getUsers().observeMe(true), this.storeStream.getAuthentication().getAgeGateError(), this.storeStream.getChannelsSelected().observeSelectedChannel(), StoreAuthentication$getShouldShowAgeGate$1.INSTANCE).r();
        m.checkNotNullExpressionValue(observableR, "Observable.combineLatest…  .distinctUntilChanged()");
        return observableR;
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
            Persister.Companion.reset();
            SharedPreferences$Editor sharedPreferences$EditorEdit = getPrefs().edit();
            m.checkNotNullExpressionValue(sharedPreferences$EditorEdit, "editor");
            sharedPreferences$EditorEdit.clear();
            sharedPreferences$EditorEdit.apply();
        }
    }

    @StoreThread
    public final void handleLoginResult(ModelLoginResult loginResult) {
        m.checkNotNullParameter(loginResult, "loginResult");
        setFingerprint(null, true);
        publishAuthState(AuthState.Companion.from(loginResult.getToken(), getRequiredActionsFromLoginResponse(loginResult)));
        if (loginResult.getToken() != null) {
            setAgeGateError(null);
            AnalyticsTracker.INSTANCE.appFirstLogin();
        }
        PublishSubject<Boolean> publishSubject = this.userInitiatedAuthEventSubject;
        publishSubject.k.onNext(Boolean.TRUE);
        StoreStream.Companion.getNux().setFirstOpen(true);
    }

    @StoreThread
    public final void handlePreLogout$app_productionGoogleRelease() {
        resetIsConsentRequired();
    }

    @Override // com.discord.stores.Store
    @StoreThread
    public synchronized void init(Context context) {
        m.checkNotNullParameter(context, "context");
        super.init(context);
        String string = getPrefsSessionDurable().getString(CACHE_KEY_FINGERPRINT, null);
        if (string != null) {
            setFingerprint(string, false);
        }
        AuthState cachedAuthState = this.authStateCache.getCachedAuthState();
        if (cachedAuthState == null) {
            cachedAuthState = AuthState.Companion.from(StoreAuthentication$Companion.access$getRnaAuthToken(Companion, context), n0.emptySet());
        }
        if (AuthState.Companion.isUpdatePasswordRequired(cachedAuthState)) {
            logout();
        } else {
            this.authState = cachedAuthState;
            publishAuthState(cachedAuthState);
        }
        handleAgeGateError(null);
        setSavedLogin(getPrefsSessionDurable().getString(CACHE_KEY_LOGIN, StoreAuthentication$Companion.access$getDeviceEmail(Companion, context)));
        Observable<Boolean> observableR = this.userInitiatedAuthEventSubject.r();
        m.checkNotNullExpressionValue(observableR, "userInitiatedAuthEventSu…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui(ObservableExtensionsKt.computationLatest(observableR)), getClass(), (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new StoreAuthentication$init$1(context), 62, (Object) null);
    }

    public final boolean isAuthed() {
        return this.authState != null;
    }

    public final synchronized boolean isConsentRequired() {
        Boolean bool;
        bool = this._isConsentRequired;
        return bool != null ? bool.booleanValue() : true;
    }

    public final Observable<ModelLoginResult> login(String login, String password, CaptchaHelper$CaptchaPayload captchaPayload, boolean undelete, String loginSource) {
        m.checkNotNullParameter(login, "login");
        m.checkNotNullParameter(password, WidgetSettingsAccountChangePassword.CURRENT_PASSWORD_FIELD);
        setSavedLogin(login);
        Observable<ModelLoginResult> observableU = getFingerprintSnapshotOrGenerate().A(new StoreAuthentication$login$1(login, password, captchaPayload, undelete, loginSource)).u(new StoreAuthentication$login$2(this));
        m.checkNotNullExpressionValue(observableU, "getFingerprintSnapshotOr…lt)\n          }\n        }");
        return observableU;
    }

    public final void logout() {
        PublishSubject<Boolean> publishSubject = this.userInitiatedAuthEventSubject;
        publishSubject.k.onNext(Boolean.FALSE);
        Observable observableA = ObservableExtensionsKt.restSubscribeOn$default(RestCallStateKt.logNetworkAction(RestAPI.Companion.getApi().logout(new RestAPIParams$UserDevices(StoreStream.Companion.getNotifications().getPushToken())), StoreAuthentication$logout$1.INSTANCE), false, 1, null).A(new StoreAuthentication$logout$2(this));
        m.checkNotNullExpressionValue(observableA, "RestAPI\n        .api\n   …intSnapshotOrGenerate() }");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.takeSingleUntilTimeout$default(observableA, 0L, false, 3, null), (Context) null, "logout", (Function1) null, new StoreAuthentication$logout$3(this), new StoreAuthentication$logout$4(this), (Function0) null, (Function0) null, 101, (Object) null);
    }

    public final Observable<Boolean> observeIsAuthed$app_productionGoogleRelease() {
        Observable observableG = m8getAuthState$app_productionGoogleRelease().G(StoreAuthentication$observeIsAuthed$1.INSTANCE);
        m.checkNotNullExpressionValue(observableG, "getAuthState()\n      .ma…te -> authState != null }");
        return observableG;
    }

    public final void onPasswordChanged(String token) {
        this.dispatcher.schedule(new StoreAuthentication$onPasswordChanged$1(this, token));
    }

    public final Observable<RegisterResponse> register(String username, String email, String phoneToken, String password, CaptchaHelper$CaptchaPayload captchaPayload, boolean consent, String dateOfBirth) {
        m.checkNotNullParameter(username, "username");
        m.checkNotNullParameter(password, WidgetSettingsAccountChangePassword.CURRENT_PASSWORD_FIELD);
        setSavedLogin(email);
        Observable observableA = getFingerprintSnapshotOrGenerate().A(new StoreAuthentication$register$1(this, username, email, phoneToken, password, captchaPayload, consent, dateOfBirth));
        m.checkNotNullExpressionValue(observableA, "getFingerprintSnapshotOr…              }\n        }");
        return observableA;
    }

    public final synchronized void requestConsentRequired() {
        if (this._isConsentRequired != null) {
            return;
        }
        resetIsConsentRequired();
        Observable observableRestSubscribeOn$default = ObservableExtensionsKt.restSubscribeOn$default(RestAPI.Companion.getApi().getLocationMetadata(), false, 1, null);
        Class<?> cls = getClass();
        StoreAuthentication$requestConsentRequired$1 storeAuthentication$requestConsentRequired$1 = new StoreAuthentication$requestConsentRequired$1(this);
        ObservableExtensionsKt.appSubscribe$default(observableRestSubscribeOn$default, cls, (Context) null, new StoreAuthentication$requestConsentRequired$3(this), new StoreAuthentication$requestConsentRequired$2(this), (Function0) null, (Function0) null, storeAuthentication$requestConsentRequired$1, 50, (Object) null);
    }

    public final void setAgeGateError(String error) {
        this.dispatcher.schedule(new StoreAuthentication$setAgeGateError$1(this, error));
    }

    public final void setAuthed(String authToken) {
        publishAuthState(AuthState.Companion.from(authToken, n0.emptySet()));
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
                m.checkNotNull(str2);
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
            if (str != null && (!m.areEqual(str, fingerprint)) && fingerprint != null) {
                String str3 = this.fingerprint;
                m.checkNotNull(str3);
                AnalyticsTracker.externalFingerprintDropped(str3, fingerprint);
            }
        }
        throw th;
    }

    public final void setOAuthUriSubject(Uri uri) {
        m.checkNotNullParameter(uri, NotificationCompat$MessagingStyle$Message.KEY_DATA_URI);
        this.oauthUriSubject.k.onNext(uri);
    }

    /* JADX INFO: renamed from: getAuthState$app_productionGoogleRelease, reason: collision with other method in class */
    public final Observable<AuthState> m8getAuthState$app_productionGoogleRelease() {
        Observable<AuthState> observableR = this.authStateSubject.r();
        m.checkNotNullExpressionValue(observableR, "authStateSubject.distinctUntilChanged()");
        return observableR;
    }
}
