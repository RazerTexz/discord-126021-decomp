package com.discord.utilities.auth;

import android.content.Context;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.stores.StoreAuthentication;
import com.discord.stores.StoreStream;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.settings.account.WidgetSettingsAccountChangePassword;
import d0.g;
import d0.z.d.m;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.subjects.PublishSubject;

/* JADX INFO: compiled from: GoogleSmartLockRepo.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GoogleSmartLockRepo {
    public static final GoogleSmartLockRepo$Companion Companion = new GoogleSmartLockRepo$Companion(null);
    private static final Lazy INSTANCE$delegate = g.lazy(GoogleSmartLockRepo$Companion$INSTANCE$2.INSTANCE);
    private boolean disableAutoLogin;
    private String pendingIdChange;
    private PublishSubject<GoogleSmartLockManager$SmartLockCredentials> smartLockLogin;
    private SmartLockSignInAttempt smartLockLoginAttempt;

    public GoogleSmartLockRepo() {
        this(null, 1, null);
    }

    public GoogleSmartLockRepo(StoreAuthentication storeAuthentication) {
        m.checkNotNullParameter(storeAuthentication, "storeAuth");
        PublishSubject<GoogleSmartLockManager$SmartLockCredentials> publishSubjectK0 = PublishSubject.k0();
        m.checkNotNullExpressionValue(publishSubjectK0, "PublishSubject.create()");
        this.smartLockLogin = publishSubjectK0;
        this.smartLockLoginAttempt = new SmartLockSignInAttempt(false, false, 3, null);
        ObservableExtensionsKt.appSubscribe$default(storeAuthentication.getPreLogoutSignal$app_productionGoogleRelease(), GoogleSmartLockRepo.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new GoogleSmartLockRepo$1(this), 62, (Object) null);
    }

    public static final /* synthetic */ Lazy access$getINSTANCE$cp() {
        return INSTANCE$delegate;
    }

    public final boolean getDisableAutoLogin() {
        return this.disableAutoLogin;
    }

    public final String getPendingIdChange() {
        return this.pendingIdChange;
    }

    public final SmartLockSignInAttempt getSmartLockLoginAttempt() {
        return this.smartLockLoginAttempt;
    }

    public final Observable<GoogleSmartLockManager$SmartLockCredentials> getSmartLockLoginObservable() {
        return this.smartLockLogin;
    }

    public final void onLoginWithSmartLockSuccess() {
        if (this.smartLockLoginAttempt.getSignedInWithoutError()) {
            if (this.smartLockLoginAttempt.getUsedAutomaticCredentials()) {
                AnalyticsTracker.INSTANCE.smartLockAutoLogin();
            } else {
                AnalyticsTracker.INSTANCE.smartLockLogin();
            }
        }
    }

    public final void onSmartLockCredentialsFailed() {
        this.smartLockLoginAttempt = SmartLockSignInAttempt.copy$default(this.smartLockLoginAttempt, false, false, 1, null);
        AnalyticsTracker.INSTANCE.smartLockLoginCredentialsFailed();
    }

    public final void setAttemptToSignInWithSmartLock(boolean usedAutomaticCredentials) {
        this.smartLockLoginAttempt = new SmartLockSignInAttempt(usedAutomaticCredentials, false, 2, null);
    }

    public final void setDisableAutoLogin(boolean z2) {
        this.disableAutoLogin = z2;
    }

    public final void setPendingIdChange(String str) {
        this.pendingIdChange = str;
    }

    public final void setSmartLockLogin(String id2, String password) {
        m.checkNotNullParameter(id2, ModelAuditLogEntry.CHANGE_KEY_ID);
        m.checkNotNullParameter(password, WidgetSettingsAccountChangePassword.CURRENT_PASSWORD_FIELD);
        PublishSubject<GoogleSmartLockManager$SmartLockCredentials> publishSubject = this.smartLockLogin;
        publishSubject.k.onNext(new GoogleSmartLockManager$SmartLockCredentials(id2, password));
    }

    public final void setSmartLockLoginAttempt(SmartLockSignInAttempt smartLockSignInAttempt) {
        m.checkNotNullParameter(smartLockSignInAttempt, "<set-?>");
        this.smartLockLoginAttempt = smartLockSignInAttempt;
    }

    public /* synthetic */ GoogleSmartLockRepo(StoreAuthentication storeAuthentication, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? StoreStream.Companion.getAuthentication() : storeAuthentication);
    }
}
