package androidx.view;

import b.i.a.f.e.o.f;
import d0.z.d.m;
import kotlinx.coroutines.Job;

/* JADX INFO: compiled from: LifecycleController.kt */
/* JADX INFO: loaded from: classes.dex */
public final class LifecycleController$observer$1 implements LifecycleEventObserver {
    public final /* synthetic */ Job $parentJob;
    public final /* synthetic */ LifecycleController this$0;

    public LifecycleController$observer$1(LifecycleController lifecycleController, Job job) {
        this.this$0 = lifecycleController;
        this.$parentJob = job;
    }

    @Override // androidx.view.LifecycleEventObserver
    public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle$Event lifecycle$Event) {
        m.checkNotNullParameter(lifecycleOwner, "source");
        m.checkNotNullParameter(lifecycle$Event, "<anonymous parameter 1>");
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        m.checkNotNullExpressionValue(lifecycle, "source.lifecycle");
        if (lifecycle.getCurrentState() == Lifecycle$State.DESTROYED) {
            LifecycleController lifecycleController = this.this$0;
            f.t(this.$parentJob, null, 1, null);
            lifecycleController.finish();
        } else {
            Lifecycle lifecycle2 = lifecycleOwner.getLifecycle();
            m.checkNotNullExpressionValue(lifecycle2, "source.lifecycle");
            if (lifecycle2.getCurrentState().compareTo(LifecycleController.access$getMinState$p(this.this$0)) < 0) {
                LifecycleController.access$getDispatchQueue$p(this.this$0).pause();
            } else {
                LifecycleController.access$getDispatchQueue$p(this.this$0).resume();
            }
        }
    }
}
