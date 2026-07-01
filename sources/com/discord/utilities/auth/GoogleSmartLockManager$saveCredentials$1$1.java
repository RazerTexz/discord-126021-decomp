package com.discord.utilities.auth;

import b.i.a.f.n.c;
import com.discord.app.AppLog;
import com.discord.utilities.logging.Logger;
import com.google.android.gms.common.api.ResolvableApiException;
import com.google.android.gms.tasks.Task;
import d0.z.d.m;

/* JADX INFO: compiled from: GoogleSmartLockManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GoogleSmartLockManager$saveCredentials$1$1<TResult> implements c<Void> {
    public final /* synthetic */ GoogleSmartLockManager$saveCredentials$1 this$0;

    public GoogleSmartLockManager$saveCredentials$1$1(GoogleSmartLockManager$saveCredentials$1 googleSmartLockManager$saveCredentials$1) {
        this.this$0 = googleSmartLockManager$saveCredentials$1;
    }

    @Override // b.i.a.f.n.c
    public final void onComplete(Task<Void> task) {
        m.checkNotNullExpressionValue(task, "task");
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
        GoogleSmartLockManager$saveCredentials$1 googleSmartLockManager$saveCredentials$1 = this.this$0;
        GoogleSmartLockManager.access$resolveResult(googleSmartLockManager$saveCredentials$1.this$0, (ResolvableApiException) excK, googleSmartLockManager$saveCredentials$1.$id);
    }
}
