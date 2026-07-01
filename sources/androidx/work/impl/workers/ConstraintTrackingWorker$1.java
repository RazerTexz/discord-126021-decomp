package androidx.work.impl.workers;

/* JADX INFO: loaded from: classes.dex */
public class ConstraintTrackingWorker$1 implements Runnable {
    public final /* synthetic */ ConstraintTrackingWorker this$0;

    public ConstraintTrackingWorker$1(ConstraintTrackingWorker constraintTrackingWorker) {
        this.this$0 = constraintTrackingWorker;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.this$0.setupAndRunConstraintTrackingWork();
    }
}
