package androidx.work.impl;

import androidx.work.Logger;
import androidx.work.impl.utils.futures.SettableFuture;

/* JADX INFO: loaded from: classes.dex */
public class WorkerWrapper$1 implements Runnable {
    public final /* synthetic */ WorkerWrapper this$0;
    public final /* synthetic */ SettableFuture val$future;

    public WorkerWrapper$1(WorkerWrapper workerWrapper, SettableFuture settableFuture) {
        this.this$0 = workerWrapper;
        this.val$future = settableFuture;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            Logger.get().debug(WorkerWrapper.TAG, String.format("Starting work for %s", this.this$0.mWorkSpec.workerClassName), new Throwable[0]);
            WorkerWrapper workerWrapper = this.this$0;
            workerWrapper.mInnerFuture = workerWrapper.mWorker.startWork();
            this.val$future.setFuture(this.this$0.mInnerFuture);
        } catch (Throwable th) {
            this.val$future.setException(th);
        }
    }
}
