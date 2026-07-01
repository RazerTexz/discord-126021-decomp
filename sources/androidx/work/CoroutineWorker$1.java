package androidx.work;

import b.i.a.f.e.o.f;

/* JADX INFO: compiled from: CoroutineWorker.kt */
/* JADX INFO: loaded from: classes.dex */
public final class CoroutineWorker$1 implements Runnable {
    public final /* synthetic */ CoroutineWorker this$0;

    public CoroutineWorker$1(CoroutineWorker coroutineWorker) {
        this.this$0 = coroutineWorker;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.this$0.getFuture$work_runtime_ktx_release().isCancelled()) {
            f.t(this.this$0.getJob(), null, 1, null);
        }
    }
}
