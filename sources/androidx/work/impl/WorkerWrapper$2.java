package androidx.work.impl;

import android.annotation.SuppressLint;
import androidx.work.ListenableWorker$Result;
import androidx.work.Logger;
import androidx.work.impl.utils.futures.SettableFuture;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;

/* JADX INFO: loaded from: classes.dex */
public class WorkerWrapper$2 implements Runnable {
    public final /* synthetic */ WorkerWrapper this$0;
    public final /* synthetic */ SettableFuture val$future;
    public final /* synthetic */ String val$workDescription;

    public WorkerWrapper$2(WorkerWrapper workerWrapper, SettableFuture settableFuture, String str) {
        this.this$0 = workerWrapper;
        this.val$future = settableFuture;
        this.val$workDescription = str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.lang.Runnable
    @SuppressLint({"SyntheticAccessor"})
    public void run() {
        try {
            try {
                ListenableWorker$Result listenableWorker$Result = (ListenableWorker$Result) this.val$future.get();
                if (listenableWorker$Result == null) {
                    Logger.get().error(WorkerWrapper.TAG, String.format("%s returned a null result. Treating it as a failure.", this.this$0.mWorkSpec.workerClassName), new Throwable[0]);
                } else {
                    Logger.get().debug(WorkerWrapper.TAG, String.format("%s returned a %s result.", this.this$0.mWorkSpec.workerClassName, listenableWorker$Result), new Throwable[0]);
                    this.this$0.mResult = listenableWorker$Result;
                }
            } catch (InterruptedException e) {
                e = e;
                Logger.get().error(WorkerWrapper.TAG, String.format("%s failed because it threw an exception/error", this.val$workDescription), e);
            } catch (CancellationException e2) {
                Logger.get().info(WorkerWrapper.TAG, String.format("%s was cancelled", this.val$workDescription), e2);
            } catch (ExecutionException e3) {
                e = e3;
                Logger.get().error(WorkerWrapper.TAG, String.format("%s failed because it threw an exception/error", this.val$workDescription), e);
            }
            this.this$0.onWorkFinished();
        } catch (Throwable th) {
            this.this$0.onWorkFinished();
            throw th;
        }
    }
}
