package com.discord.utilities.auth;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.net.Uri;
import androidx.fragment.app.Fragment;
import b.c.a.a0.AnimatableValueParser;
import b.d.b.a.outline;
import b.i.a.f.c.a.a;
import b.i.a.f.c.a.d.b;
import b.i.a.f.c.a.d.c;
import b.i.a.f.c.a.d.d;
import b.i.a.f.e.k.k;
import b.i.a.f.e.k.s;
import b.i.a.f.e.k.v;
import b.i.a.f.h.c.g;
import b.i.a.f.h.c.h;
import b.i.a.f.h.c.i;
import b.i.a.f.h.c.l;
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
import com.discord.utilities.rx.ObservableExtensionsKt;
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
import d0.e0.KClass;
import d0.t.Collections2;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import java.util.List;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.objectweb.asm.Opcodes;
import rx.Observable;
import rx.Subscription;

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
    private final List<KClass<? extends AppFragment>> resolvableFragments;
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
            String str = credential != null ? credential.j : null;
            String str2 = credential != null ? credential.n : null;
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
            Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_ID);
            Intrinsics3.checkNotNullParameter(str2, WidgetSettingsAccountChangePassword.CURRENT_PASSWORD_FIELD);
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
            Intrinsics3.checkNotNullParameter(id2, ModelAuditLogEntry.CHANGE_KEY_ID);
            Intrinsics3.checkNotNullParameter(password, WidgetSettingsAccountChangePassword.CURRENT_PASSWORD_FIELD);
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
            return Intrinsics3.areEqual(this.id, smartLockCredentials.id) && Intrinsics3.areEqual(this.password, smartLockCredentials.password);
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
            StringBuilder sbU = outline.U("SmartLockCredentials(id=");
            sbU.append(this.id);
            sbU.append(", password=");
            return outline.J(sbU, this.password, ")");
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.auth.GoogleSmartLockManager$saveCredentials$1, reason: invalid class name */
    /* JADX INFO: compiled from: GoogleSmartLockManager.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<MeUser, Unit> {
        public final /* synthetic */ String $id;
        public final /* synthetic */ String $password;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(String str, String str2) {
            super(1);
            this.$id = str;
            this.$password = str2;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(MeUser meUser) {
            invoke2(meUser);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(MeUser meUser) {
            String forUser$default = IconUtils.getForUser$default(meUser, false, null, 4, null);
            Credential.a aVar = new Credential.a(this.$id);
            aVar.d = this.$password;
            Intrinsics3.checkNotNullExpressionValue(aVar, "Credential.Builder(id)\n …   .setPassword(password)");
            UserUtils userUtils = UserUtils.INSTANCE;
            Intrinsics3.checkNotNullExpressionValue(meUser, "it");
            aVar.f2995b = UserUtils.getUserNameWithDiscriminator$default(userUtils, meUser, null, null, 3, null).toString();
            aVar.c = Uri.parse(forUser$default);
            Credential credentialA = aVar.a();
            CredentialsClient credentialsClient = GoogleSmartLockManager.this.credentialsClient;
            Objects.requireNonNull(credentialsClient);
            c cVar = a.g;
            b.i.a.f.e.h.c cVar2 = credentialsClient.g;
            Objects.requireNonNull((h) cVar);
            AnimatableValueParser.z(cVar2, "client must not be null");
            AnimatableValueParser.z(credentialA, "credential must not be null");
            k.a(cVar2.b(new i(cVar2, credentialA))).b(new b.i.a.f.n.c<Void>() { // from class: com.discord.utilities.auth.GoogleSmartLockManager.saveCredentials.1.1
                @Override // b.i.a.f.n.c
                public final void onComplete(Task<Void> task) {
                    Intrinsics3.checkNotNullExpressionValue(task, "task");
                    if (task.p()) {
                        Logger.i$default(AppLog.g, "Google Smart Lock", "Credentials Saved", null, 4, null);
                        return;
                    }
                    Exception excK = task.k();
                    if (!(excK instanceof ResolvableApiException)) {
                        AppLog.g.w("Google Smart Lock", "Exception saving credentials", excK);
                        return;
                    }
                    AppLog.g.w("Google Smart Lock", "Resolving Exception saving credentials", excK);
                    AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                    GoogleSmartLockManager.this.resolveResult((ResolvableApiException) excK, anonymousClass1.$id);
                }
            });
        }
    }

    public GoogleSmartLockManager(Context context, GoogleSmartLockRepo googleSmartLockRepo) {
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(googleSmartLockRepo, "smartLockRepo");
        this.smartLockRepo = googleSmartLockRepo;
        this.resolvableFragments = Collections2.listOf((Object[]) new KClass[]{Reflection2.getOrCreateKotlinClass(WidgetTabsHost.class), Reflection2.getOrCreateKotlinClass(WidgetSettingsAccount.class)});
        d.a aVar = new d.a();
        aVar.f1333b = Boolean.TRUE;
        CredentialsClient credentialsClient = new CredentialsClient(context, new d(aVar, null));
        Intrinsics3.checkNotNullExpressionValue(credentialsClient, "Credentials.getClient(context, options)");
        this.credentialsClient = credentialsClient;
        if (googleSmartLockRepo.getDisableAutoLogin()) {
            CredentialsClient credentialsClient2 = this.credentialsClient;
            Objects.requireNonNull(credentialsClient2);
            c cVar = a.g;
            b.i.a.f.e.h.c cVar2 = credentialsClient2.g;
            Objects.requireNonNull((h) cVar);
            AnimatableValueParser.z(cVar2, "client must not be null");
            k.a(cVar2.b(new b.i.a.f.h.c.k(cVar2)));
        }
    }

    private final void resolveResult(Fragment fragment, int requestCode, ResolvableApiException rae) {
        try {
            if (!(rae.mStatus.p != 4) || fragment.isDetached() || fragment.isRemoving()) {
                return;
            }
            PendingIntent pendingIntent = rae.mStatus.r;
            Intrinsics3.checkNotNullExpressionValue(pendingIntent, "rae.resolution");
            fragment.startIntentSenderForResult(pendingIntent.getIntentSender(), requestCode, null, 0, 0, 0, null);
        } catch (IntentSender.SendIntentException e) {
            AppLog.g.w("Google Smart Lock", "Failed to send resolution.", e);
        } catch (Exception e2) {
            AppLog.g.w("Google Smart Lock", "Failed to resolve", e2);
        }
    }

    public final void deleteCredentials(String id2) {
        Intrinsics3.checkNotNullParameter(id2, ModelAuditLogEntry.CHANGE_KEY_ID);
        CredentialsClient credentialsClient = this.credentialsClient;
        Credential credential = new Credential(id2, null, null, null, null, null, null, null);
        Objects.requireNonNull(credentialsClient);
        c cVar = a.g;
        b.i.a.f.e.h.c cVar2 = credentialsClient.g;
        Objects.requireNonNull((h) cVar);
        AnimatableValueParser.z(cVar2, "client must not be null");
        AnimatableValueParser.z(credential, "credential must not be null");
        k.a(cVar2.b(new l(cVar2, credential)));
    }

    public final GoogleSmartLockRepo getSmartLockRepo() {
        return this.smartLockRepo;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public final void requestCredentials(final AppFragment fragment, final int requestCode) {
        Intrinsics3.checkNotNullParameter(fragment, "fragment");
        CredentialRequest credentialRequest = new CredentialRequest(4, true, new String[]{DISCORD_ACCOUNT_IDENTITY}, null, null, false, null, null, false);
        CredentialsClient credentialsClient = this.credentialsClient;
        Objects.requireNonNull(credentialsClient);
        c cVar = a.g;
        b.i.a.f.e.h.c cVar2 = credentialsClient.g;
        Objects.requireNonNull((h) cVar);
        AnimatableValueParser.z(cVar2, "client must not be null");
        AnimatableValueParser.z(credentialRequest, "request must not be null");
        b.i.a.f.e.h.j.d dVarA = cVar2.a(new g(cVar2, credentialRequest));
        v vVar = new v(new b.i.a.f.c.a.d.a());
        k.b bVar = k.a;
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        dVarA.c(new s(dVarA, taskCompletionSource, vVar, bVar));
        taskCompletionSource.a.b((b.i.a.f.n.c<TResult>) new b.i.a.f.n.c<b.i.a.f.c.a.d.a>() { // from class: com.discord.utilities.auth.GoogleSmartLockManager.requestCredentials.1
            @Override // b.i.a.f.n.c
            public final void onComplete(Task<b.i.a.f.c.a.d.a> task) {
                Intrinsics3.checkNotNullExpressionValue(task, "task");
                if (task.p()) {
                    b.i.a.f.c.a.d.a aVarL = task.l();
                    Intrinsics3.checkNotNullExpressionValue(aVarL, "task.result");
                    Credential credentialR = ((b) aVarL.a).R();
                    String str = credentialR != null ? credentialR.j : null;
                    b.i.a.f.c.a.d.a aVarL2 = task.l();
                    Intrinsics3.checkNotNullExpressionValue(aVarL2, "task.result");
                    Credential credentialR2 = ((b) aVarL2.a).R();
                    String str2 = credentialR2 != null ? credentialR2.n : null;
                    if (str == null || str2 == null) {
                        return;
                    }
                    GoogleSmartLockManager.this.getSmartLockRepo().setAttemptToSignInWithSmartLock(true);
                    GoogleSmartLockManager.this.getSmartLockRepo().setSmartLockLogin(str, str2);
                    return;
                }
                Exception excK = task.k();
                if (!(excK instanceof ResolvableApiException)) {
                    if (excK instanceof ApiException) {
                        AppLog.g.w("Google Smart Lock", "API Exception requesting credentials", excK);
                        return;
                    } else {
                        AppLog.g.w("Google Smart Lock", "Exception requesting credentials", excK);
                        return;
                    }
                }
                ResolvableApiException resolvableApiException = (ResolvableApiException) excK;
                boolean z2 = resolvableApiException.mStatus.p != 4;
                AppLog.g.w("Google Smart Lock", "Resolvable Exception requesting credentials", excK);
                if (z2) {
                    GoogleSmartLockManager.this.resolveResult(fragment, requestCode, resolvableApiException);
                }
            }
        });
    }

    public final void saveCredentials(String id2, String password) {
        Intrinsics3.checkNotNullParameter(id2, ModelAuditLogEntry.CHANGE_KEY_ID);
        Intrinsics3.checkNotNullParameter(password, WidgetSettingsAccountChangePassword.CURRENT_PASSWORD_FIELD);
        Observable observableZ = StoreUser.observeMe$default(StoreStream.INSTANCE.getUsers(), false, 1, null).Z(1);
        Intrinsics3.checkNotNullExpressionValue(observableZ, "StoreStream.getUsers().observeMe().take(1)");
        ObservableExtensionsKt.appSubscribe(observableZ, (Class<?>) GoogleSmartLockManager.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1(id2, password));
    }

    public final void updateAccountInfo(String login, String newPassword) {
        Intrinsics3.checkNotNullParameter(newPassword, "newPassword");
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
            if (rae.mStatus.p != 4) {
                StoreStream.INSTANCE.getNotices().requestToShow(new StoreNotices.Notice(SMART_LOCK_NOTICE_NAME + id2, null, 0L, 0, false, this.resolvableFragments, 0L, false, 0L, new GoogleSmartLockManager2(this, rae), Opcodes.I2F, null));
            }
        } catch (IntentSender.SendIntentException e) {
            AppLog.g.w("Google Smart Lock", "Failed to send resolution.", e);
        } catch (Exception e2) {
            AppLog.g.w("Google Smart Lock", "Failed to resolve", e2);
        }
    }

    public /* synthetic */ GoogleSmartLockManager(Context context, GoogleSmartLockRepo googleSmartLockRepo, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? GoogleSmartLockRepo.INSTANCE.getINSTANCE() : googleSmartLockRepo);
    }
}
