package androidx.view;

import androidx.annotation.MainThread;
import androidx.view.Lifecycle;
import kotlinx.coroutines.Job;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: LifecycleController.kt */
/* JADX INFO: loaded from: classes.dex */
@MainThread
public final class LifecycleController {
    private final DispatchQueue dispatchQueue;
    private final Lifecycle lifecycle;
    private final Lifecycle.State minState;
    private final LifecycleEventObserver observer;

    public LifecycleController(Lifecycle lifecycle, Lifecycle.State state, DispatchQueue dispatchQueue, final Job job) {
        C12238m.checkNotNullParameter(lifecycle, "lifecycle");
        C12238m.checkNotNullParameter(state, "minState");
        C12238m.checkNotNullParameter(dispatchQueue, "dispatchQueue");
        C12238m.checkNotNullParameter(job, "parentJob");
        this.lifecycle = lifecycle;
        this.minState = state;
        this.dispatchQueue = dispatchQueue;
        LifecycleEventObserver lifecycleEventObserver = new LifecycleEventObserver() { // from class: androidx.lifecycle.LifecycleController$observer$1
            @Override // androidx.view.LifecycleEventObserver
            public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                C12238m.checkNotNullParameter(lifecycleOwner, "source");
                C12238m.checkNotNullParameter(event, "<anonymous parameter 1>");
                Lifecycle lifecycle2 = lifecycleOwner.getLifecycle();
                C12238m.checkNotNullExpressionValue(lifecycle2, "source.lifecycle");
                if (lifecycle2.getCurrentState() == Lifecycle.State.DESTROYED) {
                    LifecycleController lifecycleController = this.this$0;
                    C3404f.m4343t(job, null, 1, null);
                    lifecycleController.finish();
                } else {
                    Lifecycle lifecycle3 = lifecycleOwner.getLifecycle();
                    C12238m.checkNotNullExpressionValue(lifecycle3, "source.lifecycle");
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
            C3404f.m4343t(job, null, 1, null);
            finish();
        }
    }

    private final void handleDestroy(Job parentJob) {
        C3404f.m4343t(parentJob, null, 1, null);
        finish();
    }

    @MainThread
    public final void finish() {
        this.lifecycle.removeObserver(this.observer);
        this.dispatchQueue.finish();
    }
}
