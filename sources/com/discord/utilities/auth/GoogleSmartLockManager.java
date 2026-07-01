package com.discord.utilities.auth;

import android.app.PendingIntent;
import android.content.Context;
import android.content.IntentSender$SendIntentException;
import androidx.fragment.app.Fragment;
import b.i.a.f.c.a.a;
import b.i.a.f.c.a.d.d;
import b.i.a.f.c.a.d.d$a;
import b.i.a.f.e.k.k;
import b.i.a.f.e.k.k$b;
import b.i.a.f.e.k.s;
import b.i.a.f.e.k.v;
import b.i.a.f.h.c.g;
import b.i.a.f.h.c.h;
import b.i.a.f.h.c.l;
import com.discord.app.AppFragment;
import com.discord.app.AppLog;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.stores.StoreNotices$Notice;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.settings.account.WidgetSettingsAccount;
import com.discord.widgets.settings.account.WidgetSettingsAccountChangePassword;
import com.discord.widgets.tabs.WidgetTabsHost;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.auth.api.credentials.CredentialRequest;
import com.google.android.gms.auth.api.credentials.CredentialsClient;
import com.google.android.gms.common.api.ResolvableApiException;
import com.google.android.gms.tasks.TaskCompletionSource;
import d0.e0.c;
import d0.t.n;
import d0.z.d.a0;
import d0.z.d.m;
import java.util.List;
import java.util.Objects;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.objectweb.asm.Opcodes;
import rx.Observable;

/* JADX INFO: compiled from: GoogleSmartLockManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GoogleSmartLockManager {
    public static final GoogleSmartLockManager$Companion Companion = new GoogleSmartLockManager$Companion(null);
    public static final String DISCORD_ACCOUNT_IDENTITY = "https://discord.com/";
    public static final boolean ENABLE_SMART_LOCK = false;
    public static final int GOOGLE_SMART_LOCK_REQUEST_CODE_RESOLVE = 4008;
    public static final int GOOGLE_SMART_LOCK_REQUEST_CODE_RESOLVE_FOR_REQUEST = 4009;
    public static final boolean SET_DISCORD_ACCOUNT_DETAILS = true;
    public static final String SMART_LOCK_NOTICE_NAME = "smartlock_resolution_";
    private CredentialsClient credentialsClient;
    private final List<c<? extends AppFragment>> resolvableFragments;
    private final GoogleSmartLockRepo smartLockRepo;

    public GoogleSmartLockManager(Context context, GoogleSmartLockRepo googleSmartLockRepo) {
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(googleSmartLockRepo, "smartLockRepo");
        this.smartLockRepo = googleSmartLockRepo;
        this.resolvableFragments = n.listOf((Object[]) new c[]{a0.getOrCreateKotlinClass(WidgetTabsHost.class), a0.getOrCreateKotlinClass(WidgetSettingsAccount.class)});
        d$a d_a = new d$a();
        d_a.f1333b = Boolean.TRUE;
        CredentialsClient credentialsClient = new CredentialsClient(context, new d(d_a, null));
        m.checkNotNullExpressionValue(credentialsClient, "Credentials.getClient(context, options)");
        this.credentialsClient = credentialsClient;
        if (googleSmartLockRepo.getDisableAutoLogin()) {
            CredentialsClient credentialsClient2 = this.credentialsClient;
            Objects.requireNonNull(credentialsClient2);
            b.i.a.f.c.a.d.c cVar = a.g;
            b.i.a.f.e.h.c cVar2 = credentialsClient2.g;
            Objects.requireNonNull((h) cVar);
            b.c.a.a0.d.z(cVar2, "client must not be null");
            k.a(cVar2.b(new b.i.a.f.h.c.k(cVar2)));
        }
    }

    public static final /* synthetic */ CredentialsClient access$getCredentialsClient$p(GoogleSmartLockManager googleSmartLockManager) {
        return googleSmartLockManager.credentialsClient;
    }

    public static final /* synthetic */ List access$getResolvableFragments$p(GoogleSmartLockManager googleSmartLockManager) {
        return googleSmartLockManager.resolvableFragments;
    }

    public static final /* synthetic */ void access$resolveResult(GoogleSmartLockManager googleSmartLockManager, Fragment fragment, int i, ResolvableApiException resolvableApiException) {
        googleSmartLockManager.resolveResult(fragment, i, resolvableApiException);
    }

    public static final /* synthetic */ void access$setCredentialsClient$p(GoogleSmartLockManager googleSmartLockManager, CredentialsClient credentialsClient) {
        googleSmartLockManager.credentialsClient = credentialsClient;
    }

    private final void resolveResult(Fragment fragment, int requestCode, ResolvableApiException rae) {
        try {
            if (!(rae.mStatus.p != 4) || fragment.isDetached() || fragment.isRemoving()) {
                return;
            }
            PendingIntent pendingIntent = rae.mStatus.r;
            m.checkNotNullExpressionValue(pendingIntent, "rae.resolution");
            fragment.startIntentSenderForResult(pendingIntent.getIntentSender(), requestCode, null, 0, 0, 0, null);
        } catch (IntentSender$SendIntentException e) {
            AppLog.g.w("Google Smart Lock", "Failed to send resolution.", e);
        } catch (Exception e2) {
            AppLog.g.w("Google Smart Lock", "Failed to resolve", e2);
        }
    }

    public final void deleteCredentials(String id2) {
        m.checkNotNullParameter(id2, ModelAuditLogEntry.CHANGE_KEY_ID);
        CredentialsClient credentialsClient = this.credentialsClient;
        Credential credential = new Credential(id2, null, null, null, null, null, null, null);
        Objects.requireNonNull(credentialsClient);
        b.i.a.f.c.a.d.c cVar = a.g;
        b.i.a.f.e.h.c cVar2 = credentialsClient.g;
        Objects.requireNonNull((h) cVar);
        b.c.a.a0.d.z(cVar2, "client must not be null");
        b.c.a.a0.d.z(credential, "credential must not be null");
        k.a(cVar2.b(new l(cVar2, credential)));
    }

    public final GoogleSmartLockRepo getSmartLockRepo() {
        return this.smartLockRepo;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public final void requestCredentials(AppFragment fragment, int requestCode) {
        m.checkNotNullParameter(fragment, "fragment");
        CredentialRequest credentialRequest = new CredentialRequest(4, true, new String[]{DISCORD_ACCOUNT_IDENTITY}, null, null, false, null, null, false);
        CredentialsClient credentialsClient = this.credentialsClient;
        Objects.requireNonNull(credentialsClient);
        b.i.a.f.c.a.d.c cVar = a.g;
        b.i.a.f.e.h.c cVar2 = credentialsClient.g;
        Objects.requireNonNull((h) cVar);
        b.c.a.a0.d.z(cVar2, "client must not be null");
        b.c.a.a0.d.z(credentialRequest, "request must not be null");
        b.i.a.f.e.h.j.d dVarA = cVar2.a(new g(cVar2, credentialRequest));
        v vVar = new v(new b.i.a.f.c.a.d.a());
        k$b k_b = k.a;
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        dVarA.c(new s(dVarA, taskCompletionSource, vVar, k_b));
        taskCompletionSource.a.b(new GoogleSmartLockManager$requestCredentials$1(this, fragment, requestCode));
    }

    public final void saveCredentials(String id2, String password) {
        m.checkNotNullParameter(id2, ModelAuditLogEntry.CHANGE_KEY_ID);
        m.checkNotNullParameter(password, WidgetSettingsAccountChangePassword.CURRENT_PASSWORD_FIELD);
        Observable observableZ = StoreUser.observeMe$default(StoreStream.Companion.getUsers(), false, 1, null).Z(1);
        m.checkNotNullExpressionValue(observableZ, "StoreStream.getUsers().observeMe().take(1)");
        ObservableExtensionsKt.appSubscribe$default(observableZ, GoogleSmartLockManager.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new GoogleSmartLockManager$saveCredentials$1(this, id2, password), 62, (Object) null);
    }

    public final void updateAccountInfo(String login, String newPassword) {
        m.checkNotNullParameter(newPassword, "newPassword");
        String pendingIdChange = this.smartLockRepo.getPendingIdChange();
        if (pendingIdChange != null) {
            deleteCredentials(pendingIdChange);
            this.smartLockRepo.setPendingIdChange(null);
        }
        if (login == null) {
            login = StoreStream.Companion.getAuthentication().getSavedLogin();
        }
        if (login != null) {
            saveCredentials(login, newPassword);
        }
    }

    public static final /* synthetic */ void access$resolveResult(GoogleSmartLockManager googleSmartLockManager, ResolvableApiException resolvableApiException, String str) {
        googleSmartLockManager.resolveResult(resolvableApiException, str);
    }

    private final void resolveResult(ResolvableApiException rae, String id2) {
        try {
            if (rae.mStatus.p != 4) {
                StoreStream.Companion.getNotices().requestToShow(new StoreNotices$Notice(SMART_LOCK_NOTICE_NAME + id2, null, 0L, 0, false, this.resolvableFragments, 0L, false, 0L, new GoogleSmartLockManager$resolveResult$notice$1(this, rae), Opcodes.I2F, null));
            }
        } catch (IntentSender$SendIntentException e) {
            AppLog.g.w("Google Smart Lock", "Failed to send resolution.", e);
        } catch (Exception e2) {
            AppLog.g.w("Google Smart Lock", "Failed to resolve", e2);
        }
    }

    public /* synthetic */ GoogleSmartLockManager(Context context, GoogleSmartLockRepo googleSmartLockRepo, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? GoogleSmartLockRepo.Companion.getINSTANCE() : googleSmartLockRepo);
    }
}
