package androidx.view;

import androidx.annotation.MainThread;
import androidx.view.Lifecycle;
import b.i.a.f.e.o.f;
import d0.z.d.Intrinsics3;
import kotlinx.coroutines.Job;

/* JADX INFO: compiled from: LifecycleController.kt */
/* JADX INFO: loaded from: classes.dex */
@MainThread
public final class LifecycleController {
    private final DispatchQueue dispatchQueue;
    private final Lifecycle lifecycle;
    private final Lifecycle.State minState;
    private final LifecycleEventObserver observer;

    public LifecycleController(Lifecycle lifecycle, Lifecycle.State state, DispatchQueue dispatchQueue, final Job job) {
        Intrinsics3.checkNotNullParameter(lifecycle, "lifecycle");
        Intrinsics3.checkNotNullParameter(state, "minState");
        Intrinsics3.checkNotNullParameter(dispatchQueue, "dispatchQueue");
        Intrinsics3.checkNotNullParameter(job, "parentJob");
        this.lifecycle = lifecycle;
        this.minState = state;
        this.dispatchQueue = dispatchQueue;
        LifecycleEventObserver lifecycleEventObserver = new LifecycleEventObserver() { // from class: androidx.lifecycle.LifecycleController$observer$1
            @Override // androidx.view.LifecycleEventObserver
            public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                Intrinsics3.checkNotNullParameter(lifecycleOwner, "source");
                Intrinsics3.checkNotNullParameter(event, "<anonymous parameter 1>");
                Lifecycle lifecycle2 = lifecycleOwner.getLifecycle();
                Intrinsics3.checkNotNullExpressionValue(lifecycle2, "source.lifecycle");
                if (lifecycle2.getCurrentState() == Lifecycle.State.DESTROYED) {
                    LifecycleController lifecycleController = this.this$0;
                    f.t(job, null, 1, null);
                    lifecycleController.finish();
                } else {
                    Lifecycle lifecycle3 = lifecycleOwner.getLifecycle();
                    Intrinsics3.checkNotNullExpressionValue(lifecycle3, "source.lifecycle");
                    if (lifecycle3.getCurrentState().compareTo(this.this$0.minState) < 0) {
                        this.this$0.dispatchQueue.pause();
                    } else {
                        this.this$0.dispatchQueue.resume();
                    }
                }
            }
        };
        this.observer = lifecycleEventObserver;
        if (lifecycle.getCurrentState() != Lifecycle.State.DESTROYED) {
            lifecycle.addObserver(lifecycleEventObserver);
        } else {
            f.t(job, null, 1, null);
            finish();
        }
    }

    private final void handleDestroy(Job parentJob) {
        f.t(parentJob, null, 1, null);
        finish();
    }

    @MainThread
    public final void finish() {
        this.lifecycle.removeObserver(this.observer);
        this.dispatchQueue.finish();
    }
}
