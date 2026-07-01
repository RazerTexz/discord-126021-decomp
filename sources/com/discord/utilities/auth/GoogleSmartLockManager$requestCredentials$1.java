package com.discord.utilities.auth;

import b.i.a.f.c.a.d.a;
import b.i.a.f.c.a.d.b;
import b.i.a.f.n.c;
import com.discord.app.AppFragment;
import com.discord.app.AppLog;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.ResolvableApiException;
import com.google.android.gms.tasks.Task;
import d0.z.d.m;

/* JADX INFO: compiled from: GoogleSmartLockManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GoogleSmartLockManager$requestCredentials$1<TResult> implements c<a> {
    public final /* synthetic */ AppFragment $fragment;
    public final /* synthetic */ int $requestCode;
    public final /* synthetic */ GoogleSmartLockManager this$0;

    public GoogleSmartLockManager$requestCredentials$1(GoogleSmartLockManager googleSmartLockManager, AppFragment appFragment, int i) {
        this.this$0 = googleSmartLockManager;
        this.$fragment = appFragment;
        this.$requestCode = i;
    }

    @Override // b.i.a.f.n.c
    public final void onComplete(Task<a> task) {
        m.checkNotNullExpressionValue(task, "task");
        if (task.p()) {
            a aVarL = task.l();
            m.checkNotNullExpressionValue(aVarL, "task.result");
            Credential credentialR = ((b) aVarL.a).R();
            String str = credentialR != null ? credentialR.j : null;
            a aVarL2 = task.l();
            m.checkNotNullExpressionValue(aVarL2, "task.result");
            Credential credentialR2 = ((b) aVarL2.a).R();
            String str2 = credentialR2 != null ? credentialR2.n : null;
            if (str == null || str2 == null) {
                return;
            }
            this.this$0.getSmartLockRepo().setAttemptToSignInWithSmartLock(true);
            this.this$0.getSmartLockRepo().setSmartLockLogin(str, str2);
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
            GoogleSmartLockManager.access$resolveResult(this.this$0, this.$fragment, this.$requestCode, resolvableApiException);
        }
    }
}
