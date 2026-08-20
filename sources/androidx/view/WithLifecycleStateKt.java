package androidx.view;

import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CoroutineDispatcher;
import p507d0.C12112k;
import p507d0.C12113l;
import p507d0.p584w.C12179f;
import p507d0.p584w.p585h.C12182b;
import p507d0.p584w.p585h.C12183c;
import p507d0.p584w.p586i.p587a.C12190g;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12237l;
import p507d0.p592z.p594d.C12238m;
import p659s.p660a.AbstractC13128l1;
import p659s.p660a.C13124k0;
import p659s.p660a.C13126l;
import p659s.p660a.p661a.C13031n;

/* JADX INFO: compiled from: WithLifecycleState.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WithLifecycleStateKt {

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* JADX INFO: renamed from: androidx.lifecycle.WithLifecycleStateKt$withStateAtLeastUnchecked$2 */
    /* JADX INFO: compiled from: WithLifecycleState.kt */
    public static final class C04572<R> extends AbstractC12240o implements Function0<R> {
        public final /* synthetic */ Function0 $block;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C04572(Function0 function0) {
            super(0);
            this.$block = function0;
        }

        @Override // kotlin.jvm.functions.Function0
        public final R invoke() {
            return (R) this.$block.invoke();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v0, types: [androidx.lifecycle.LifecycleObserver, androidx.lifecycle.WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$$inlined$suspendCancellableCoroutine$lambda$1] */
    public static final <R> Object suspendWithStateAtLeastUnchecked(final Lifecycle lifecycle, final Lifecycle.State state, final boolean z2, final CoroutineDispatcher coroutineDispatcher, final Function0<? extends R> function0, Continuation<? super R> continuation) {
        final C13126l c13126l = new C13126l(C12182b.intercepted(continuation), 1);
        c13126l.m11318A();
        final ?? r15 = new LifecycleEventObserver() { // from class: androidx.lifecycle.WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$$inlined$suspendCancellableCoroutine$lambda$1
            @Override // androidx.view.LifecycleEventObserver
            public void onStateChanged(LifecycleOwner source, Lifecycle.Event event) {
                Object objM11474constructorimpl;
                C12238m.checkNotNullParameter(source, "source");
                C12238m.checkNotNullParameter(event, "event");
                if (event != Lifecycle.Event.upTo(state)) {
                    if (event == Lifecycle.Event.ON_DESTROY) {
                        lifecycle.removeObserver(this);
                        CancellableContinuation cancellableContinuation = c13126l;
                        LifecycleDestroyedException lifecycleDestroyedException = new LifecycleDestroyedException();
                        C12112k.a aVar = C12112k.f25169j;
                        cancellableContinuation.resumeWith(C12112k.m11474constructorimpl(C12113l.createFailure(lifecycleDestroyedException)));
                        return;
                    }
                    return;
                }
                lifecycle.removeObserver(this);
                CancellableContinuation cancellableContinuation2 = c13126l;
                Function0 function1 = function0;
                try {
                    C12112k.a aVar2 = C12112k.f25169j;
                    objM11474constructorimpl = C12112k.m11474constructorimpl(function1.invoke());
                } catch (Throwable th) {
                    C12112k.a aVar3 = C12112k.f25169j;
                    objM11474constructorimpl = C12112k.m11474constructorimpl(C12113l.createFailure(th));
                }
                cancellableContinuation2.resumeWith(objM11474constructorimpl);
            }
        };
        if (z2) {
            coroutineDispatcher.dispatch(C12179f.f25237j, new Runnable() { // from class: androidx.lifecycle.WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$$inlined$suspendCancellableCoroutine$lambda$2
                @Override // java.lang.Runnable
                public final void run() {
                    lifecycle.addObserver(r15);
                }
            });
        } else {
            lifecycle.addObserver(r15);
        }
        c13126l.mo10902f(new C0456x3029b3a0(r15, lifecycle, state, function0, z2, coroutineDispatcher));
        Object objM11326u = c13126l.m11326u();
        if (objM11326u == C12183c.getCOROUTINE_SUSPENDED()) {
            C12190g.probeCoroutineSuspended(continuation);
        }
        return objM11326u;
    }

    public static final <R> Object withCreated(Lifecycle lifecycle, Function0<? extends R> function0, Continuation<? super R> continuation) {
        Lifecycle.State state = Lifecycle.State.CREATED;
        CoroutineDispatcher coroutineDispatcher = C13124k0.f27866a;
        AbstractC13128l1 abstractC13128l1Mo11194H = C13031n.f27700b.mo11194H();
        boolean zIsDispatchNeeded = abstractC13128l1Mo11194H.isDispatchNeeded(continuation.getContext());
        if (!zIsDispatchNeeded) {
            if (lifecycle.getCurrentState() == Lifecycle.State.DESTROYED) {
                throw new LifecycleDestroyedException();
            }
            if (lifecycle.getCurrentState().compareTo(state) >= 0) {
                return function0.invoke();
            }
        }
        return suspendWithStateAtLeastUnchecked(lifecycle, state, zIsDispatchNeeded, abstractC13128l1Mo11194H, new C04572(function0), continuation);
    }

    private static final Object withCreated$$forInline(Lifecycle lifecycle, Function0 function0, Continuation continuation) {
        Lifecycle.State state = Lifecycle.State.CREATED;
        CoroutineDispatcher coroutineDispatcher = C13124k0.f27866a;
        C13031n.f27700b.mo11194H();
        C12237l.mark(3);
        throw null;
    }

    public static final <R> Object withResumed(Lifecycle lifecycle, Function0<? extends R> function0, Continuation<? super R> continuation) {
        Lifecycle.State state = Lifecycle.State.RESUMED;
        CoroutineDispatcher coroutineDispatcher = C13124k0.f27866a;
        AbstractC13128l1 abstractC13128l1Mo11194H = C13031n.f27700b.mo11194H();
        boolean zIsDispatchNeeded = abstractC13128l1Mo11194H.isDispatchNeeded(continuation.getContext());
        if (!zIsDispatchNeeded) {
            if (lifecycle.getCurrentState() == Lifecycle.State.DESTROYED) {
                throw new LifecycleDestroyedException();
            }
            if (lifecycle.getCurrentState().compareTo(state) >= 0) {
                return function0.invoke();
            }
        }
        return suspendWithStateAtLeastUnchecked(lifecycle, state, zIsDispatchNeeded, abstractC13128l1Mo11194H, new C04572(function0), continuation);
    }

    private static final Object withResumed$$forInline(Lifecycle lifecycle, Function0 function0, Continuation continuation) {
        Lifecycle.State state = Lifecycle.State.RESUMED;
        CoroutineDispatcher coroutineDispatcher = C13124k0.f27866a;
        C13031n.f27700b.mo11194H();
        C12237l.mark(3);
        throw null;
    }

    public static final <R> Object withStarted(Lifecycle lifecycle, Function0<? extends R> function0, Continuation<? super R> continuation) {
        Lifecycle.State state = Lifecycle.State.STARTED;
        CoroutineDispatcher coroutineDispatcher = C13124k0.f27866a;
        AbstractC13128l1 abstractC13128l1Mo11194H = C13031n.f27700b.mo11194H();
        boolean zIsDispatchNeeded = abstractC13128l1Mo11194H.isDispatchNeeded(continuation.getContext());
        if (!zIsDispatchNeeded) {
            if (lifecycle.getCurrentState() == Lifecycle.State.DESTROYED) {
                throw new LifecycleDestroyedException();
            }
            if (lifecycle.getCurrentState().compareTo(state) >= 0) {
                return function0.invoke();
            }
        }
        return suspendWithStateAtLeastUnchecked(lifecycle, state, zIsDispatchNeeded, abstractC13128l1Mo11194H, new C04572(function0), continuation);
    }

    private static final Object withStarted$$forInline(Lifecycle lifecycle, Function0 function0, Continuation continuation) {
        Lifecycle.State state = Lifecycle.State.STARTED;
        CoroutineDispatcher coroutineDispatcher = C13124k0.f27866a;
        C13031n.f27700b.mo11194H();
        C12237l.mark(3);
        throw null;
    }

    public static final <R> Object withStateAtLeast(Lifecycle lifecycle, Lifecycle.State state, Function0<? extends R> function0, Continuation<? super R> continuation) {
        if (!(state.compareTo(Lifecycle.State.CREATED) >= 0)) {
            throw new IllegalArgumentException(("target state must be CREATED or greater, found " + state).toString());
        }
        CoroutineDispatcher coroutineDispatcher = C13124k0.f27866a;
        AbstractC13128l1 abstractC13128l1Mo11194H = C13031n.f27700b.mo11194H();
        boolean zIsDispatchNeeded = abstractC13128l1Mo11194H.isDispatchNeeded(continuation.getContext());
        if (!zIsDispatchNeeded) {
            if (lifecycle.getCurrentState() == Lifecycle.State.DESTROYED) {
                throw new LifecycleDestroyedException();
            }
            if (lifecycle.getCurrentState().compareTo(state) >= 0) {
                return function0.invoke();
            }
        }
        return suspendWithStateAtLeastUnchecked(lifecycle, state, zIsDispatchNeeded, abstractC13128l1Mo11194H, new C04572(function0), continuation);
    }

    private static final Object withStateAtLeast$$forInline(Lifecycle lifecycle, Lifecycle.State state, Function0 function0, Continuation continuation) {
        if (state.compareTo(Lifecycle.State.CREATED) >= 0) {
            CoroutineDispatcher coroutineDispatcher = C13124k0.f27866a;
            C13031n.f27700b.mo11194H();
            C12237l.mark(3);
            throw null;
        }
        throw new IllegalArgumentException(("target state must be CREATED or greater, found " + state).toString());
    }

    public static final <R> Object withStateAtLeastUnchecked(Lifecycle lifecycle, Lifecycle.State state, Function0<? extends R> function0, Continuation<? super R> continuation) {
        CoroutineDispatcher coroutineDispatcher = C13124k0.f27866a;
        AbstractC13128l1 abstractC13128l1Mo11194H = C13031n.f27700b.mo11194H();
        boolean zIsDispatchNeeded = abstractC13128l1Mo11194H.isDispatchNeeded(continuation.getContext());
        if (!zIsDispatchNeeded) {
            if (lifecycle.getCurrentState() == Lifecycle.State.DESTROYED) {
                throw new LifecycleDestroyedException();
            }
            if (lifecycle.getCurrentState().compareTo(state) >= 0) {
                return function0.invoke();
            }
        }
        return suspendWithStateAtLeastUnchecked(lifecycle, state, zIsDispatchNeeded, abstractC13128l1Mo11194H, new C04572(function0), continuation);
    }

    private static final Object withStateAtLeastUnchecked$$forInline(Lifecycle lifecycle, Lifecycle.State state, Function0 function0, Continuation continuation) {
        CoroutineDispatcher coroutineDispatcher = C13124k0.f27866a;
        C13031n.f27700b.mo11194H();
        C12237l.mark(3);
        throw null;
    }

    private static final Object withCreated$$forInline(LifecycleOwner lifecycleOwner, Function0 function0, Continuation continuation) {
        C12238m.checkNotNullExpressionValue(lifecycleOwner.getLifecycle(), "lifecycle");
        Lifecycle.State state = Lifecycle.State.CREATED;
        CoroutineDispatcher coroutineDispatcher = C13124k0.f27866a;
        C13031n.f27700b.mo11194H();
        C12237l.mark(3);
        throw null;
    }

    private static final Object withResumed$$forInline(LifecycleOwner lifecycleOwner, Function0 function0, Continuation continuation) {
        C12238m.checkNotNullExpressionValue(lifecycleOwner.getLifecycle(), "lifecycle");
        Lifecycle.State state = Lifecycle.State.RESUMED;
        CoroutineDispatcher coroutineDispatcher = C13124k0.f27866a;
        C13031n.f27700b.mo11194H();
        C12237l.mark(3);
        throw null;
    }

    private static final Object withStarted$$forInline(LifecycleOwner lifecycleOwner, Function0 function0, Continuation continuation) {
        C12238m.checkNotNullExpressionValue(lifecycleOwner.getLifecycle(), "lifecycle");
        Lifecycle.State state = Lifecycle.State.STARTED;
        CoroutineDispatcher coroutineDispatcher = C13124k0.f27866a;
        C13031n.f27700b.mo11194H();
        C12237l.mark(3);
        throw null;
    }

    private static final Object withStateAtLeast$$forInline(LifecycleOwner lifecycleOwner, Lifecycle.State state, Function0 function0, Continuation continuation) {
        C12238m.checkNotNullExpressionValue(lifecycleOwner.getLifecycle(), "lifecycle");
        if (!(state.compareTo(Lifecycle.State.CREATED) >= 0)) {
            throw new IllegalArgumentException(("target state must be CREATED or greater, found " + state).toString());
        }
        CoroutineDispatcher coroutineDispatcher = C13124k0.f27866a;
        C13031n.f27700b.mo11194H();
        C12237l.mark(3);
        throw null;
    }

    public static final <R> Object withCreated(LifecycleOwner lifecycleOwner, Function0<? extends R> function0, Continuation<? super R> continuation) {
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        C12238m.checkNotNullExpressionValue(lifecycle, "lifecycle");
        Lifecycle.State state = Lifecycle.State.CREATED;
        CoroutineDispatcher coroutineDispatcher = C13124k0.f27866a;
        AbstractC13128l1 abstractC13128l1Mo11194H = C13031n.f27700b.mo11194H();
        boolean zIsDispatchNeeded = abstractC13128l1Mo11194H.isDispatchNeeded(continuation.getContext());
        if (!zIsDispatchNeeded) {
            if (lifecycle.getCurrentState() != Lifecycle.State.DESTROYED) {
                if (lifecycle.getCurrentState().compareTo(state) >= 0) {
                    return function0.invoke();
                }
            } else {
                throw new LifecycleDestroyedException();
            }
        }
        return suspendWithStateAtLeastUnchecked(lifecycle, state, zIsDispatchNeeded, abstractC13128l1Mo11194H, new C04572(function0), continuation);
    }

    public static final <R> Object withResumed(LifecycleOwner lifecycleOwner, Function0<? extends R> function0, Continuation<? super R> continuation) {
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        C12238m.checkNotNullExpressionValue(lifecycle, "lifecycle");
        Lifecycle.State state = Lifecycle.State.RESUMED;
        CoroutineDispatcher coroutineDispatcher = C13124k0.f27866a;
        AbstractC13128l1 abstractC13128l1Mo11194H = C13031n.f27700b.mo11194H();
        boolean zIsDispatchNeeded = abstractC13128l1Mo11194H.isDispatchNeeded(continuation.getContext());
        if (!zIsDispatchNeeded) {
            if (lifecycle.getCurrentState() != Lifecycle.State.DESTROYED) {
                if (lifecycle.getCurrentState().compareTo(state) >= 0) {
                    return function0.invoke();
                }
            } else {
                throw new LifecycleDestroyedException();
            }
        }
        return suspendWithStateAtLeastUnchecked(lifecycle, state, zIsDispatchNeeded, abstractC13128l1Mo11194H, new C04572(function0), continuation);
    }

    public static final <R> Object withStarted(LifecycleOwner lifecycleOwner, Function0<? extends R> function0, Continuation<? super R> continuation) {
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        C12238m.checkNotNullExpressionValue(lifecycle, "lifecycle");
        Lifecycle.State state = Lifecycle.State.STARTED;
        CoroutineDispatcher coroutineDispatcher = C13124k0.f27866a;
        AbstractC13128l1 abstractC13128l1Mo11194H = C13031n.f27700b.mo11194H();
        boolean zIsDispatchNeeded = abstractC13128l1Mo11194H.isDispatchNeeded(continuation.getContext());
        if (!zIsDispatchNeeded) {
            if (lifecycle.getCurrentState() != Lifecycle.State.DESTROYED) {
                if (lifecycle.getCurrentState().compareTo(state) >= 0) {
                    return function0.invoke();
                }
            } else {
                throw new LifecycleDestroyedException();
            }
        }
        return suspendWithStateAtLeastUnchecked(lifecycle, state, zIsDispatchNeeded, abstractC13128l1Mo11194H, new C04572(function0), continuation);
    }

    public static final <R> Object withStateAtLeast(LifecycleOwner lifecycleOwner, Lifecycle.State state, Function0<? extends R> function0, Continuation<? super R> continuation) {
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        C12238m.checkNotNullExpressionValue(lifecycle, "lifecycle");
        if (state.compareTo(Lifecycle.State.CREATED) >= 0) {
            CoroutineDispatcher coroutineDispatcher = C13124k0.f27866a;
            AbstractC13128l1 abstractC13128l1Mo11194H = C13031n.f27700b.mo11194H();
            boolean zIsDispatchNeeded = abstractC13128l1Mo11194H.isDispatchNeeded(continuation.getContext());
            if (!zIsDispatchNeeded) {
                if (lifecycle.getCurrentState() != Lifecycle.State.DESTROYED) {
                    if (lifecycle.getCurrentState().compareTo(state) >= 0) {
                        return function0.invoke();
                    }
                } else {
                    throw new LifecycleDestroyedException();
                }
            }
            return suspendWithStateAtLeastUnchecked(lifecycle, state, zIsDispatchNeeded, abstractC13128l1Mo11194H, new C04572(function0), continuation);
        }
        throw new IllegalArgumentException(("target state must be CREATED or greater, found " + state).toString());
    }
}
