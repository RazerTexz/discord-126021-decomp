package com.discord.utilities.auth;

import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.stores.StoreAuthentication;
import com.discord.stores.StoreStream;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.widgets.settings.account.WidgetSettingsAccountChangePassword;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.C12083g;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p658rx.Observable;
import p658rx.Subscription;
import p658rx.subjects.PublishSubject;

/* JADX INFO: compiled from: GoogleSmartLockRepo.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GoogleSmartLockRepo {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Lazy INSTANCE$delegate = C12083g.lazy(GoogleSmartLockRepo$Companion$INSTANCE$2.INSTANCE);
    private boolean disableAutoLogin;
    private String pendingIdChange;
    private PublishSubject<GoogleSmartLockManager.SmartLockCredentials> smartLockLogin;
    private SmartLockSignInAttempt smartLockLoginAttempt;

    /* JADX INFO: renamed from: com.discord.utilities.auth.GoogleSmartLockRepo$1 */
    /* JADX INFO: compiled from: GoogleSmartLockRepo.kt */
    public static final class C67011 extends AbstractC12240o implements Function1<Boolean, Unit> {
        public C67011() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            invoke(bool.booleanValue());
            return Unit.f27425a;
        }

        public final void invoke(boolean z2) {
            if (z2) {
                return;
            }
            GoogleSmartLockRepo.this.setDisableAutoLogin(true);
        }
    }

    /* JADX INFO: compiled from: GoogleSmartLockRepo.kt */
    public static final class Companion {
        private Companion() {
        }

        public final GoogleSmartLockRepo getINSTANCE() {
            Lazy lazy = GoogleSmartLockRepo.INSTANCE$delegate;
            Companion companion = GoogleSmartLockRepo.INSTANCE;
            return (GoogleSmartLockRepo) lazy.getValue();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public GoogleSmartLockRepo() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public GoogleSmartLockRepo(StoreAuthentication storeAuthentication) {
        C12238m.checkNotNullParameter(storeAuthentication, "storeAuth");
        PublishSubject<GoogleSmartLockManager.SmartLockCredentials> publishSubjectM11133k0 = PublishSubject.m11133k0();
        C12238m.checkNotNullExpressionValue(publishSubjectM11133k0, "PublishSubject.create()");
        this.smartLockLogin = publishSubjectM11133k0;
        this.smartLockLoginAttempt = new SmartLockSignInAttempt(false, false, 3, null);
        ObservableExtensionsKt.appSubscribe(storeAuthentication.getPreLogoutSignal$app_productionGoogleRelease(), (Class<?>) GoogleSmartLockRepo.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C67011());
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

    public final Observable<GoogleSmartLockManager.SmartLockCredentials> getSmartLockLoginObservable() {
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
        C12238m.checkNotNullParameter(id2, ModelAuditLogEntry.CHANGE_KEY_ID);
        C12238m.checkNotNullParameter(password, WidgetSettingsAccountChangePassword.CURRENT_PASSWORD_FIELD);
        PublishSubject<GoogleSmartLockManager.SmartLockCredentials> publishSubject = this.smartLockLogin;
        publishSubject.f27650k.onNext(new GoogleSmartLockManager.SmartLockCredentials(id2, password));
    }

    public final void setSmartLockLoginAttempt(SmartLockSignInAttempt smartLockSignInAttempt) {
        C12238m.checkNotNullParameter(smartLockSignInAttempt, "<set-?>");
        this.smartLockLoginAttempt = smartLockSignInAttempt;
    }

    public /* synthetic */ GoogleSmartLockRepo(StoreAuthentication storeAuthentication, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? StoreStream.INSTANCE.getAuthentication() : storeAuthentication);
    }
}
