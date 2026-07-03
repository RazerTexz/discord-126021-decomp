package com.discord.utilities.auth;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.net.Uri;
import androidx.fragment.app.Fragment;
import com.discord.app.AppFragment;
import com.discord.app.AppLog;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.user.MeUser;
import com.discord.stores.StoreNotices;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.utilities.error.Error;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.user.UserUtils;
import com.discord.widgets.settings.account.WidgetSettingsAccount;
import com.discord.widgets.settings.account.WidgetSettingsAccountChangePassword;
import com.discord.widgets.tabs.WidgetTabsHost;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.auth.api.credentials.CredentialRequest;
import com.google.android.gms.auth.api.credentials.CredentialsClient;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.ResolvableApiException;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.List;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.objectweb.asm.Opcodes;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p226a.p288f.p292c.p293a.C3183a;
import p007b.p225i.p226a.p288f.p292c.p293a.p294d.C3186a;
import p007b.p225i.p226a.p288f.p292c.p293a.p294d.C3189d;
import p007b.p225i.p226a.p288f.p292c.p293a.p294d.InterfaceC3187b;
import p007b.p225i.p226a.p288f.p292c.p293a.p294d.InterfaceC3188c;
import p007b.p225i.p226a.p288f.p299e.p300h.AbstractC3268c;
import p007b.p225i.p226a.p288f.p299e.p300h.p301j.AbstractC3284d;
import p007b.p225i.p226a.p288f.p299e.p304k.C3363k;
import p007b.p225i.p226a.p288f.p299e.p304k.C3379s;
import p007b.p225i.p226a.p288f.p299e.p304k.C3385v;
import p007b.p225i.p226a.p288f.p313h.p316c.C3458g;
import p007b.p225i.p226a.p288f.p313h.p316c.C3459h;
import p007b.p225i.p226a.p288f.p313h.p316c.C3460i;
import p007b.p225i.p226a.p288f.p313h.p316c.C3462k;
import p007b.p225i.p226a.p288f.p313h.p316c.C3463l;
import p007b.p225i.p226a.p288f.p340n.InterfaceC4357c;
import p507d0.p513e0.InterfaceC11230c;
import p507d0.p580t.C12147n;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12216a0;
import p507d0.p592z.p594d.C12238m;
import p658rx.Observable;
import p658rx.Subscription;

/* JADX INFO: compiled from: GoogleSmartLockManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GoogleSmartLockManager {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String DISCORD_ACCOUNT_IDENTITY = "https://discord.com/";
    public static final boolean ENABLE_SMART_LOCK = false;
    public static final int GOOGLE_SMART_LOCK_REQUEST_CODE_RESOLVE = 4008;
    public static final int GOOGLE_SMART_LOCK_REQUEST_CODE_RESOLVE_FOR_REQUEST = 4009;
    public static final boolean SET_DISCORD_ACCOUNT_DETAILS = true;
    public static final String SMART_LOCK_NOTICE_NAME = "smartlock_resolution_";
    private CredentialsClient credentialsClient;
    private final List<InterfaceC11230c<? extends AppFragment>> resolvableFragments;
    private final GoogleSmartLockRepo smartLockRepo;

    /* JADX INFO: compiled from: GoogleSmartLockManager.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void handleResult(int resultCode, Intent data) {
            if (resultCode != -1 || data == null) {
                return;
            }
            Credential credential = (Credential) data.getParcelableExtra("com.google.android.gms.credentials.Credential");
            String str = credential != null ? credential.f20389j : null;
            String str2 = credential != null ? credential.f20393n : null;
            if (str == null || str2 == null) {
                return;
            }
            GoogleSmartLockRepo.INSTANCE.getINSTANCE().setSmartLockLogin(str, str2);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: GoogleSmartLockManager.kt */
    public static final /* data */ class SmartLockCredentials {
        private final String id;
        private final String password;

        public SmartLockCredentials(String str, String str2) {
            C12238m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_ID);
            C12238m.checkNotNullParameter(str2, WidgetSettingsAccountChangePassword.CURRENT_PASSWORD_FIELD);
            this.id = str;
            this.password = str2;
        }

        public static /* synthetic */ SmartLockCredentials copy$default(SmartLockCredentials smartLockCredentials, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = smartLockCredentials.id;
            }
            if ((i & 2) != 0) {
                str2 = smartLockCredentials.password;
            }
            return smartLockCredentials.copy(str, str2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getId() {
            return this.id;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getPassword() {
            return this.password;
        }

        public final SmartLockCredentials copy(String id2, String password) {
            C12238m.checkNotNullParameter(id2, ModelAuditLogEntry.CHANGE_KEY_ID);
            C12238m.checkNotNullParameter(password, WidgetSettingsAccountChangePassword.CURRENT_PASSWORD_FIELD);
            return new SmartLockCredentials(id2, password);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SmartLockCredentials)) {
                return false;
            }
            SmartLockCredentials smartLockCredentials = (SmartLockCredentials) other;
            return C12238m.areEqual(this.id, smartLockCredentials.id) && C12238m.areEqual(this.password, smartLockCredentials.password);
        }

        public final String getId() {
            return this.id;
        }

        public final String getPassword() {
            return this.password;
        }

        public int hashCode() {
            String str = this.id;
            int iHashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.password;
            return iHashCode + (str2 != null ? str2.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("SmartLockCredentials(id=");
            sbM833U.append(this.id);
            sbM833U.append(", password=");
            return C1643a.m822J(sbM833U, this.password, ")");
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.auth.GoogleSmartLockManager$saveCredentials$1 */
    /* JADX INFO: compiled from: GoogleSmartLockManager.kt */
    public static final class C67001 extends AbstractC12240o implements Function1<MeUser, Unit> {
        public final /* synthetic */ String $id;
        public final /* synthetic */ String $password;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C67001(String str, String str2) {
            super(1);
            this.$id = str;
            this.$password = str2;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(MeUser meUser) {
            invoke2(meUser);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(MeUser meUser) {
            String forUser$default = IconUtils.getForUser$default(meUser, false, null, 4, null);
            Credential.C10792a c10792a = new Credential.C10792a(this.$id);
            c10792a.f20400d = this.$password;
            C12238m.checkNotNullExpressionValue(c10792a, "Credential.Builder(id)\n …   .setPassword(password)");
            UserUtils userUtils = UserUtils.INSTANCE;
            C12238m.checkNotNullExpressionValue(meUser, "it");
            c10792a.f20398b = UserUtils.getUserNameWithDiscriminator$default(userUtils, meUser, null, null, 3, null).toString();
            c10792a.f20399c = Uri.parse(forUser$default);
            Credential credentialM9009a = c10792a.m9009a();
            CredentialsClient credentialsClient = GoogleSmartLockManager.this.credentialsClient;
            Objects.requireNonNull(credentialsClient);
            InterfaceC3188c interfaceC3188c = C3183a.f9209g;
            AbstractC3268c abstractC3268c = credentialsClient.f9332g;
            Objects.requireNonNull((C3459h) interfaceC3188c);
            C1460d.m595z(abstractC3268c, "client must not be null");
            C1460d.m595z(credentialM9009a, "credential must not be null");
            C3363k.m4164a(abstractC3268c.mo4049b(new C3460i(abstractC3268c, credentialM9009a))).mo6007b(new InterfaceC4357c<Void>() { // from class: com.discord.utilities.auth.GoogleSmartLockManager.saveCredentials.1.1
                @Override // p007b.p225i.p226a.p288f.p340n.InterfaceC4357c
                public final void onComplete(Task<Void> task) {
                    C12238m.checkNotNullExpressionValue(task, "task");
                    if (task.mo6021p()) {
                        Logger.i$default(AppLog.f14950g, "Google Smart Lock", "Credentials Saved", null, 4, null);
                        return;
                    }
                    Exception excMo6016k = task.mo6016k();
                    if (!(excMo6016k instanceof ResolvableApiException)) {
                        AppLog.f14950g.mo8369w("Google Smart Lock", "Exception saving credentials", excMo6016k);
                        return;
                    }
                    AppLog.f14950g.mo8369w("Google Smart Lock", "Resolving Exception saving credentials", excMo6016k);
                    C67001 c67001 = C67001.this;
                    GoogleSmartLockManager.this.resolveResult((ResolvableApiException) excMo6016k, c67001.$id);
                }
            });
        }
    }

    public GoogleSmartLockManager(Context context, GoogleSmartLockRepo googleSmartLockRepo) {
        C12238m.checkNotNullParameter(context, "context");
        C12238m.checkNotNullParameter(googleSmartLockRepo, "smartLockRepo");
        this.smartLockRepo = googleSmartLockRepo;
        this.resolvableFragments = C12147n.listOf((Object[]) new InterfaceC11230c[]{C12216a0.getOrCreateKotlinClass(WidgetTabsHost.class), C12216a0.getOrCreateKotlinClass(WidgetSettingsAccount.class)});
        C3189d.a aVar = new C3189d.a();
        aVar.f9215b = Boolean.TRUE;
        CredentialsClient credentialsClient = new CredentialsClient(context, new C3189d(aVar, null));
        C12238m.checkNotNullExpressionValue(credentialsClient, "Credentials.getClient(context, options)");
        this.credentialsClient = credentialsClient;
        if (googleSmartLockRepo.getDisableAutoLogin()) {
            CredentialsClient credentialsClient2 = this.credentialsClient;
            Objects.requireNonNull(credentialsClient2);
            InterfaceC3188c interfaceC3188c = C3183a.f9209g;
            AbstractC3268c abstractC3268c = credentialsClient2.f9332g;
            Objects.requireNonNull((C3459h) interfaceC3188c);
            C1460d.m595z(abstractC3268c, "client must not be null");
            C3363k.m4164a(abstractC3268c.mo4049b(new C3462k(abstractC3268c)));
        }
    }

    private final void resolveResult(Fragment fragment, int requestCode, ResolvableApiException rae) {
        try {
            if (!(rae.mStatus.f20495p != 4) || fragment.isDetached() || fragment.isRemoving()) {
                return;
            }
            PendingIntent pendingIntent = rae.mStatus.f20497r;
            C12238m.checkNotNullExpressionValue(pendingIntent, "rae.resolution");
            fragment.startIntentSenderForResult(pendingIntent.getIntentSender(), requestCode, null, 0, 0, 0, null);
        } catch (IntentSender.SendIntentException e) {
            AppLog.f14950g.mo8369w("Google Smart Lock", "Failed to send resolution.", e);
        } catch (Exception e2) {
            AppLog.f14950g.mo8369w("Google Smart Lock", "Failed to resolve", e2);
        }
    }

    public final void deleteCredentials(String id2) {
        C12238m.checkNotNullParameter(id2, ModelAuditLogEntry.CHANGE_KEY_ID);
        CredentialsClient credentialsClient = this.credentialsClient;
        Credential credential = new Credential(id2, null, null, null, null, null, null, null);
        Objects.requireNonNull(credentialsClient);
        InterfaceC3188c interfaceC3188c = C3183a.f9209g;
        AbstractC3268c abstractC3268c = credentialsClient.f9332g;
        Objects.requireNonNull((C3459h) interfaceC3188c);
        C1460d.m595z(abstractC3268c, "client must not be null");
        C1460d.m595z(credential, "credential must not be null");
        C3363k.m4164a(abstractC3268c.mo4049b(new C3463l(abstractC3268c, credential)));
    }

    public final GoogleSmartLockRepo getSmartLockRepo() {
        return this.smartLockRepo;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public final void requestCredentials(final AppFragment fragment, final int requestCode) {
        C12238m.checkNotNullParameter(fragment, "fragment");
        CredentialRequest credentialRequest = new CredentialRequest(4, true, new String[]{DISCORD_ACCOUNT_IDENTITY}, null, null, false, null, null, false);
        CredentialsClient credentialsClient = this.credentialsClient;
        Objects.requireNonNull(credentialsClient);
        InterfaceC3188c interfaceC3188c = C3183a.f9209g;
        AbstractC3268c abstractC3268c = credentialsClient.f9332g;
        Objects.requireNonNull((C3459h) interfaceC3188c);
        C1460d.m595z(abstractC3268c, "client must not be null");
        C1460d.m595z(credentialRequest, "request must not be null");
        AbstractC3284d abstractC3284dMo4048a = abstractC3268c.mo4048a(new C3458g(abstractC3268c, credentialRequest));
        C3385v c3385v = new C3385v(new C3186a());
        C3363k.b bVar = C3363k.f9531a;
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        abstractC3284dMo4048a.mo4051c(new C3379s(abstractC3284dMo4048a, taskCompletionSource, c3385v, bVar));
        taskCompletionSource.f20845a.mo6007b((InterfaceC4357c<TResult>) new InterfaceC4357c<C3186a>() { // from class: com.discord.utilities.auth.GoogleSmartLockManager.requestCredentials.1
            @Override // p007b.p225i.p226a.p288f.p340n.InterfaceC4357c
            public final void onComplete(Task<C3186a> task) {
                C12238m.checkNotNullExpressionValue(task, "task");
                if (task.mo6021p()) {
                    C3186a c3186aMo6017l = task.mo6017l();
                    C12238m.checkNotNullExpressionValue(c3186aMo6017l, "task.result");
                    Credential credentialMo3969R = ((InterfaceC3187b) c3186aMo6017l.f9340a).mo3969R();
                    String str = credentialMo3969R != null ? credentialMo3969R.f20389j : null;
                    C3186a c3186aMo6017l2 = task.mo6017l();
                    C12238m.checkNotNullExpressionValue(c3186aMo6017l2, "task.result");
                    Credential credentialMo3969R2 = ((InterfaceC3187b) c3186aMo6017l2.f9340a).mo3969R();
                    String str2 = credentialMo3969R2 != null ? credentialMo3969R2.f20393n : null;
                    if (str == null || str2 == null) {
                        return;
                    }
                    GoogleSmartLockManager.this.getSmartLockRepo().setAttemptToSignInWithSmartLock(true);
                    GoogleSmartLockManager.this.getSmartLockRepo().setSmartLockLogin(str, str2);
                    return;
                }
                Exception excMo6016k = task.mo6016k();
                if (!(excMo6016k instanceof ResolvableApiException)) {
                    if (excMo6016k instanceof ApiException) {
                        AppLog.f14950g.mo8369w("Google Smart Lock", "API Exception requesting credentials", excMo6016k);
                        return;
                    } else {
                        AppLog.f14950g.mo8369w("Google Smart Lock", "Exception requesting credentials", excMo6016k);
                        return;
                    }
                }
                ResolvableApiException resolvableApiException = (ResolvableApiException) excMo6016k;
                boolean z2 = resolvableApiException.mStatus.f20495p != 4;
                AppLog.f14950g.mo8369w("Google Smart Lock", "Resolvable Exception requesting credentials", excMo6016k);
                if (z2) {
                    GoogleSmartLockManager.this.resolveResult(fragment, requestCode, resolvableApiException);
                }
            }
        });
    }

    public final void saveCredentials(String id2, String password) {
        C12238m.checkNotNullParameter(id2, ModelAuditLogEntry.CHANGE_KEY_ID);
        C12238m.checkNotNullParameter(password, WidgetSettingsAccountChangePassword.CURRENT_PASSWORD_FIELD);
        Observable observableM11100Z = StoreUser.observeMe$default(StoreStream.INSTANCE.getUsers(), false, 1, null).m11100Z(1);
        C12238m.checkNotNullExpressionValue(observableM11100Z, "StoreStream.getUsers().observeMe().take(1)");
        ObservableExtensionsKt.appSubscribe(observableM11100Z, (Class<?>) GoogleSmartLockManager.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C67001(id2, password));
    }

    public final void updateAccountInfo(String login, String newPassword) {
        C12238m.checkNotNullParameter(newPassword, "newPassword");
        String pendingIdChange = this.smartLockRepo.getPendingIdChange();
        if (pendingIdChange != null) {
            deleteCredentials(pendingIdChange);
            this.smartLockRepo.setPendingIdChange(null);
        }
        if (login == null) {
            login = StoreStream.INSTANCE.getAuthentication().getSavedLogin();
        }
        if (login != null) {
            saveCredentials(login, newPassword);
        }
    }

    private final void resolveResult(ResolvableApiException rae, String id2) {
        try {
            if (rae.mStatus.f20495p != 4) {
                StoreStream.INSTANCE.getNotices().requestToShow(new StoreNotices.Notice(SMART_LOCK_NOTICE_NAME + id2, null, 0L, 0, false, this.resolvableFragments, 0L, false, 0L, new GoogleSmartLockManager$resolveResult$notice$1(this, rae), Opcodes.I2F, null));
            }
        } catch (IntentSender.SendIntentException e) {
            AppLog.f14950g.mo8369w("Google Smart Lock", "Failed to send resolution.", e);
        } catch (Exception e2) {
            AppLog.f14950g.mo8369w("Google Smart Lock", "Failed to resolve", e2);
        }
    }

    public /* synthetic */ GoogleSmartLockManager(Context context, GoogleSmartLockRepo googleSmartLockRepo, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? GoogleSmartLockRepo.INSTANCE.getINSTANCE() : googleSmartLockRepo);
    }
}
