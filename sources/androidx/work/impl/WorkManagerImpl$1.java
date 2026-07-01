package androidx.work.impl;

import androidx.work.impl.utils.PreferenceUtils;
import androidx.work.impl.utils.futures.SettableFuture;

/* JADX INFO: loaded from: classes.dex */
public class WorkManagerImpl$1 implements Runnable {
    public final /* synthetic */ WorkManagerImpl this$0;
    public final /* synthetic */ SettableFuture val$future;
    public final /* synthetic */ PreferenceUtils val$preferenceUtils;

    public WorkManagerImpl$1(WorkManagerImpl workManagerImpl, SettableFuture settableFuture, PreferenceUtils preferenceUtils) {
        this.this$0 = workManagerImpl;
        this.val$future = settableFuture;
        this.val$preferenceUtils = preferenceUtils;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.val$future.set(Long.valueOf(this.val$preferenceUtils.getLastCancelAllTimeMillis()));
        } catch (Throwable th) {
            this.val$future.setException(th);
        }
    }
}
