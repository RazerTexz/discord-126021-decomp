package androidx.view;

import b.i.a.f.e.o.f;
import d0.z.d.m;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineDispatcher;
import s.a.a.n;
import s.a.k0;

/* JADX INFO: compiled from: Lifecycle.kt */
/* JADX INFO: loaded from: classes.dex */
public final class LifecycleCoroutineScopeImpl extends LifecycleCoroutineScope implements LifecycleEventObserver {
    private final CoroutineContext coroutineContext;
    private final Lifecycle lifecycle;

    public LifecycleCoroutineScopeImpl(Lifecycle lifecycle, CoroutineContext coroutineContext) {
        m.checkNotNullParameter(lifecycle, "lifecycle");
        m.checkNotNullParameter(coroutineContext, "coroutineContext");
        this.lifecycle = lifecycle;
        this.coroutineContext = coroutineContext;
        if (getLifecycle().getCurrentState() == Lifecycle$State.DESTROYED) {
            f.s(getCoroutineContext(), null, 1, null);
        }
    }

    @Override // androidx.view.LifecycleCoroutineScope, kotlinx.coroutines.CoroutineScope
    public CoroutineContext getCoroutineContext() {
        return this.coroutineContext;
    }

    @Override // androidx.view.LifecycleCoroutineScope
    /* JADX INFO: renamed from: getLifecycle$lifecycle_runtime_ktx_release, reason: from getter */
    public Lifecycle getLifecycle() {
        return this.lifecycle;
    }

    @Override // androidx.view.LifecycleEventObserver
    public void onStateChanged(LifecycleOwner source, Lifecycle$Event event) {
        m.checkNotNullParameter(source, "source");
        m.checkNotNullParameter(event, "event");
        if (getLifecycle().getCurrentState().compareTo(Lifecycle$State.DESTROYED) <= 0) {
            getLifecycle().removeObserver(this);
            f.s(getCoroutineContext(), null, 1, null);
        }
    }

    public final void register() {
        CoroutineDispatcher coroutineDispatcher = k0.a;
        f.H0(this, n.f3830b.H(), null, new LifecycleCoroutineScopeImpl$register$1(this, null), 2, null);
    }
}
