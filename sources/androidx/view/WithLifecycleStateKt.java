package androidx.view;

import d0.w.f;
import d0.w.h.b;
import d0.w.h.c;
import d0.w.i.a.g;
import d0.z.d.m;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.CoroutineDispatcher;
import s.a.a.n;
import s.a.k0;
import s.a.l;
import s.a.l1;

/* JADX INFO: compiled from: WithLifecycleState.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WithLifecycleStateKt {
    public static final <R> Object suspendWithStateAtLeastUnchecked(Lifecycle lifecycle, Lifecycle$State lifecycle$State, boolean z2, CoroutineDispatcher coroutineDispatcher, Function0<? extends R> function0, Continuation<? super R> continuation) {
        l lVar = new l(b.intercepted(continuation), 1);
        lVar.A();
        WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$$inlined$suspendCancellableCoroutine$lambda$1 withLifecycleStateKt$suspendWithStateAtLeastUnchecked$$inlined$suspendCancellableCoroutine$lambda$1 = new WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$$inlined$suspendCancellableCoroutine$lambda$1(lVar, lifecycle, lifecycle$State, function0, z2, coroutineDispatcher);
        if (z2) {
            coroutineDispatcher.dispatch(f.j, new WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$$inlined$suspendCancellableCoroutine$lambda$2(withLifecycleStateKt$suspendWithStateAtLeastUnchecked$$inlined$suspendCancellableCoroutine$lambda$1, lifecycle, lifecycle$State, function0, z2, coroutineDispatcher));
        } else {
            lifecycle.addObserver(withLifecycleStateKt$suspendWithStateAtLeastUnchecked$$inlined$suspendCancellableCoroutine$lambda$1);
        }
        lVar.f(new WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$$inlined$suspendCancellableCoroutine$lambda$3(withLifecycleStateKt$suspendWithStateAtLeastUnchecked$$inlined$suspendCancellableCoroutine$lambda$1, lifecycle, lifecycle$State, function0, z2, coroutineDispatcher));
        Object objU = lVar.u();
        if (objU == c.getCOROUTINE_SUSPENDED()) {
            g.probeCoroutineSuspended(continuation);
        }
        return objU;
    }

    public static final <R> Object withCreated(Lifecycle lifecycle, Function0<? extends R> function0, Continuation<? super R> continuation) {
        Lifecycle$State lifecycle$State = Lifecycle$State.CREATED;
        CoroutineDispatcher coroutineDispatcher = k0.a;
        l1 l1VarH = n.f3830b.H();
        boolean zIsDispatchNeeded = l1VarH.isDispatchNeeded(continuation.getContext());
        if (!zIsDispatchNeeded) {
            if (lifecycle.getCurrentState() == Lifecycle$State.DESTROYED) {
                throw new LifecycleDestroyedException();
            }
            if (lifecycle.getCurrentState().compareTo(lifecycle$State) >= 0) {
                return function0.invoke();
            }
        }
        return suspendWithStateAtLeastUnchecked(lifecycle, lifecycle$State, zIsDispatchNeeded, l1VarH, new WithLifecycleStateKt$withStateAtLeastUnchecked$2(function0), continuation);
    }

    private static final Object withCreated$$forInline(Lifecycle lifecycle, Function0 function0, Continuation continuation) {
        Lifecycle$State lifecycle$State = Lifecycle$State.CREATED;
        CoroutineDispatcher coroutineDispatcher = k0.a;
        n.f3830b.H();
        d0.z.d.l.mark(3);
        throw null;
    }

    public static final <R> Object withResumed(Lifecycle lifecycle, Function0<? extends R> function0, Continuation<? super R> continuation) {
        Lifecycle$State lifecycle$State = Lifecycle$State.RESUMED;
        CoroutineDispatcher coroutineDispatcher = k0.a;
        l1 l1VarH = n.f3830b.H();
        boolean zIsDispatchNeeded = l1VarH.isDispatchNeeded(continuation.getContext());
        if (!zIsDispatchNeeded) {
            if (lifecycle.getCurrentState() == Lifecycle$State.DESTROYED) {
                throw new LifecycleDestroyedException();
            }
            if (lifecycle.getCurrentState().compareTo(lifecycle$State) >= 0) {
                return function0.invoke();
            }
        }
        return suspendWithStateAtLeastUnchecked(lifecycle, lifecycle$State, zIsDispatchNeeded, l1VarH, new WithLifecycleStateKt$withStateAtLeastUnchecked$2(function0), continuation);
    }

    private static final Object withResumed$$forInline(Lifecycle lifecycle, Function0 function0, Continuation continuation) {
        Lifecycle$State lifecycle$State = Lifecycle$State.RESUMED;
        CoroutineDispatcher coroutineDispatcher = k0.a;
        n.f3830b.H();
        d0.z.d.l.mark(3);
        throw null;
    }

    public static final <R> Object withStarted(Lifecycle lifecycle, Function0<? extends R> function0, Continuation<? super R> continuation) {
        Lifecycle$State lifecycle$State = Lifecycle$State.STARTED;
        CoroutineDispatcher coroutineDispatcher = k0.a;
        l1 l1VarH = n.f3830b.H();
        boolean zIsDispatchNeeded = l1VarH.isDispatchNeeded(continuation.getContext());
        if (!zIsDispatchNeeded) {
            if (lifecycle.getCurrentState() == Lifecycle$State.DESTROYED) {
                throw new LifecycleDestroyedException();
            }
            if (lifecycle.getCurrentState().compareTo(lifecycle$State) >= 0) {
                return function0.invoke();
            }
        }
        return suspendWithStateAtLeastUnchecked(lifecycle, lifecycle$State, zIsDispatchNeeded, l1VarH, new WithLifecycleStateKt$withStateAtLeastUnchecked$2(function0), continuation);
    }

    private static final Object withStarted$$forInline(Lifecycle lifecycle, Function0 function0, Continuation continuation) {
        Lifecycle$State lifecycle$State = Lifecycle$State.STARTED;
        CoroutineDispatcher coroutineDispatcher = k0.a;
        n.f3830b.H();
        d0.z.d.l.mark(3);
        throw null;
    }

    public static final <R> Object withStateAtLeast(Lifecycle lifecycle, Lifecycle$State lifecycle$State, Function0<? extends R> function0, Continuation<? super R> continuation) {
        if (!(lifecycle$State.compareTo(Lifecycle$State.CREATED) >= 0)) {
            throw new IllegalArgumentException(("target state must be CREATED or greater, found " + lifecycle$State).toString());
        }
        CoroutineDispatcher coroutineDispatcher = k0.a;
        l1 l1VarH = n.f3830b.H();
        boolean zIsDispatchNeeded = l1VarH.isDispatchNeeded(continuation.getContext());
        if (!zIsDispatchNeeded) {
            if (lifecycle.getCurrentState() == Lifecycle$State.DESTROYED) {
                throw new LifecycleDestroyedException();
            }
            if (lifecycle.getCurrentState().compareTo(lifecycle$State) >= 0) {
                return function0.invoke();
            }
        }
        return suspendWithStateAtLeastUnchecked(lifecycle, lifecycle$State, zIsDispatchNeeded, l1VarH, new WithLifecycleStateKt$withStateAtLeastUnchecked$2(function0), continuation);
    }

    private static final Object withStateAtLeast$$forInline(Lifecycle lifecycle, Lifecycle$State lifecycle$State, Function0 function0, Continuation continuation) {
        if (lifecycle$State.compareTo(Lifecycle$State.CREATED) >= 0) {
            CoroutineDispatcher coroutineDispatcher = k0.a;
            n.f3830b.H();
            d0.z.d.l.mark(3);
            throw null;
        }
        throw new IllegalArgumentException(("target state must be CREATED or greater, found " + lifecycle$State).toString());
    }

    public static final <R> Object withStateAtLeastUnchecked(Lifecycle lifecycle, Lifecycle$State lifecycle$State, Function0<? extends R> function0, Continuation<? super R> continuation) {
        CoroutineDispatcher coroutineDispatcher = k0.a;
        l1 l1VarH = n.f3830b.H();
        boolean zIsDispatchNeeded = l1VarH.isDispatchNeeded(continuation.getContext());
        if (!zIsDispatchNeeded) {
            if (lifecycle.getCurrentState() == Lifecycle$State.DESTROYED) {
                throw new LifecycleDestroyedException();
            }
            if (lifecycle.getCurrentState().compareTo(lifecycle$State) >= 0) {
                return function0.invoke();
            }
        }
        return suspendWithStateAtLeastUnchecked(lifecycle, lifecycle$State, zIsDispatchNeeded, l1VarH, new WithLifecycleStateKt$withStateAtLeastUnchecked$2(function0), continuation);
    }

    private static final Object withStateAtLeastUnchecked$$forInline(Lifecycle lifecycle, Lifecycle$State lifecycle$State, Function0 function0, Continuation continuation) {
        CoroutineDispatcher coroutineDispatcher = k0.a;
        n.f3830b.H();
        d0.z.d.l.mark(3);
        throw null;
    }

    private static final Object withCreated$$forInline(LifecycleOwner lifecycleOwner, Function0 function0, Continuation continuation) {
        m.checkNotNullExpressionValue(lifecycleOwner.getLifecycle(), "lifecycle");
        Lifecycle$State lifecycle$State = Lifecycle$State.CREATED;
        CoroutineDispatcher coroutineDispatcher = k0.a;
        n.f3830b.H();
        d0.z.d.l.mark(3);
        throw null;
    }

    private static final Object withResumed$$forInline(LifecycleOwner lifecycleOwner, Function0 function0, Continuation continuation) {
        m.checkNotNullExpressionValue(lifecycleOwner.getLifecycle(), "lifecycle");
        Lifecycle$State lifecycle$State = Lifecycle$State.RESUMED;
        CoroutineDispatcher coroutineDispatcher = k0.a;
        n.f3830b.H();
        d0.z.d.l.mark(3);
        throw null;
    }

    private static final Object withStarted$$forInline(LifecycleOwner lifecycleOwner, Function0 function0, Continuation continuation) {
        m.checkNotNullExpressionValue(lifecycleOwner.getLifecycle(), "lifecycle");
        Lifecycle$State lifecycle$State = Lifecycle$State.STARTED;
        CoroutineDispatcher coroutineDispatcher = k0.a;
        n.f3830b.H();
        d0.z.d.l.mark(3);
        throw null;
    }

    private static final Object withStateAtLeast$$forInline(LifecycleOwner lifecycleOwner, Lifecycle$State lifecycle$State, Function0 function0, Continuation continuation) {
        m.checkNotNullExpressionValue(lifecycleOwner.getLifecycle(), "lifecycle");
        if (!(lifecycle$State.compareTo(Lifecycle$State.CREATED) >= 0)) {
            throw new IllegalArgumentException(("target state must be CREATED or greater, found " + lifecycle$State).toString());
        }
        CoroutineDispatcher coroutineDispatcher = k0.a;
        n.f3830b.H();
        d0.z.d.l.mark(3);
        throw null;
    }

    public static final <R> Object withCreated(LifecycleOwner lifecycleOwner, Function0<? extends R> function0, Continuation<? super R> continuation) {
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        m.checkNotNullExpressionValue(lifecycle, "lifecycle");
        Lifecycle$State lifecycle$State = Lifecycle$State.CREATED;
        CoroutineDispatcher coroutineDispatcher = k0.a;
        l1 l1VarH = n.f3830b.H();
        boolean zIsDispatchNeeded = l1VarH.isDispatchNeeded(continuation.getContext());
        if (!zIsDispatchNeeded) {
            if (lifecycle.getCurrentState() != Lifecycle$State.DESTROYED) {
                if (lifecycle.getCurrentState().compareTo(lifecycle$State) >= 0) {
                    return function0.invoke();
                }
            } else {
                throw new LifecycleDestroyedException();
            }
        }
        return suspendWithStateAtLeastUnchecked(lifecycle, lifecycle$State, zIsDispatchNeeded, l1VarH, new WithLifecycleStateKt$withStateAtLeastUnchecked$2(function0), continuation);
    }

    public static final <R> Object withResumed(LifecycleOwner lifecycleOwner, Function0<? extends R> function0, Continuation<? super R> continuation) {
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        m.checkNotNullExpressionValue(lifecycle, "lifecycle");
        Lifecycle$State lifecycle$State = Lifecycle$State.RESUMED;
        CoroutineDispatcher coroutineDispatcher = k0.a;
        l1 l1VarH = n.f3830b.H();
        boolean zIsDispatchNeeded = l1VarH.isDispatchNeeded(continuation.getContext());
        if (!zIsDispatchNeeded) {
            if (lifecycle.getCurrentState() != Lifecycle$State.DESTROYED) {
                if (lifecycle.getCurrentState().compareTo(lifecycle$State) >= 0) {
                    return function0.invoke();
                }
            } else {
                throw new LifecycleDestroyedException();
            }
        }
        return suspendWithStateAtLeastUnchecked(lifecycle, lifecycle$State, zIsDispatchNeeded, l1VarH, new WithLifecycleStateKt$withStateAtLeastUnchecked$2(function0), continuation);
    }

    public static final <R> Object withStarted(LifecycleOwner lifecycleOwner, Function0<? extends R> function0, Continuation<? super R> continuation) {
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        m.checkNotNullExpressionValue(lifecycle, "lifecycle");
        Lifecycle$State lifecycle$State = Lifecycle$State.STARTED;
        CoroutineDispatcher coroutineDispatcher = k0.a;
        l1 l1VarH = n.f3830b.H();
        boolean zIsDispatchNeeded = l1VarH.isDispatchNeeded(continuation.getContext());
        if (!zIsDispatchNeeded) {
            if (lifecycle.getCurrentState() != Lifecycle$State.DESTROYED) {
                if (lifecycle.getCurrentState().compareTo(lifecycle$State) >= 0) {
                    return function0.invoke();
                }
            } else {
                throw new LifecycleDestroyedException();
            }
        }
        return suspendWithStateAtLeastUnchecked(lifecycle, lifecycle$State, zIsDispatchNeeded, l1VarH, new WithLifecycleStateKt$withStateAtLeastUnchecked$2(function0), continuation);
    }

    public static final <R> Object withStateAtLeast(LifecycleOwner lifecycleOwner, Lifecycle$State lifecycle$State, Function0<? extends R> function0, Continuation<? super R> continuation) {
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        m.checkNotNullExpressionValue(lifecycle, "lifecycle");
        if (lifecycle$State.compareTo(Lifecycle$State.CREATED) >= 0) {
            CoroutineDispatcher coroutineDispatcher = k0.a;
            l1 l1VarH = n.f3830b.H();
            boolean zIsDispatchNeeded = l1VarH.isDispatchNeeded(continuation.getContext());
            if (!zIsDispatchNeeded) {
                if (lifecycle.getCurrentState() != Lifecycle$State.DESTROYED) {
                    if (lifecycle.getCurrentState().compareTo(lifecycle$State) >= 0) {
                        return function0.invoke();
                    }
                } else {
                    throw new LifecycleDestroyedException();
                }
            }
            return suspendWithStateAtLeastUnchecked(lifecycle, lifecycle$State, zIsDispatchNeeded, l1VarH, new WithLifecycleStateKt$withStateAtLeastUnchecked$2(function0), continuation);
        }
        throw new IllegalArgumentException(("target state must be CREATED or greater, found " + lifecycle$State).toString());
    }
}
