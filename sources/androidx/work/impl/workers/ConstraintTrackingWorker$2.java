package androidx.work.impl.workers;

import b.i.b.d.a.a;

/* JADX INFO: loaded from: classes.dex */
public class ConstraintTrackingWorker$2 implements Runnable {
    public final /* synthetic */ ConstraintTrackingWorker this$0;
    public final /* synthetic */ a val$innerFuture;

    public ConstraintTrackingWorker$2(ConstraintTrackingWorker constraintTrackingWorker, a aVar) {
        this.this$0 = constraintTrackingWorker;
        this.val$innerFuture = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        synchronized (this.this$0.mLock) {
            if (this.this$0.mAreConstraintsUnmet) {
                this.this$0.setFutureRetry();
            } else {
                this.this$0.mFuture.setFuture(this.val$innerFuture);
            }
        }
    }
}
