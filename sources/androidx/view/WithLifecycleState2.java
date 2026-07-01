package androidx.view;

import androidx.view.Lifecycle;
import d0.Result2;
import d0.Result3;
import d0.w.CoroutineContextImpl4;
import d0.w.h.Intrinsics2;
import d0.w.h.IntrinsicsJvm;
import d0.w.i.a.DebugProbes;
import d0.z.d.InlineMarker;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CoroutineDispatcher;
import s.a.CancellableContinuationImpl5;
import s.a.Dispatchers;
import s.a.MainCoroutineDispatcher;
import s.a.a.MainDispatchers;

/* JADX INFO: renamed from: androidx.lifecycle.WithLifecycleStateKt, reason: use source file name */
/* JADX INFO: compiled from: WithLifecycleState.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WithLifecycleState2 {

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* JADX INFO: renamed from: androidx.lifecycle.WithLifecycleStateKt$withStateAtLeastUnchecked$2, reason: invalid class name */
    /* JADX INFO: compiled from: WithLifecycleState.kt */
    public static final class AnonymousClass2<R> extends Lambda implements Function0<R> {
        public final /* synthetic */ Function0 $block;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Function0 function0) {
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
        final CancellableContinuationImpl5 cancellableContinuationImpl5 = new CancellableContinuationImpl5(IntrinsicsJvm.intercepted(continuation), 1);
        cancellableContinuationImpl5.A();
        final ?? r15 = new LifecycleEventObserver() { // from class: androidx.lifecycle.WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$$inlined$suspendCancellableCoroutine$lambda$1
            @Override // androidx.view.LifecycleEventObserver
            public void onStateChanged(LifecycleOwner source, Lifecycle.Event event) {
                Object objM97constructorimpl;
                Intrinsics3.checkNotNullParameter(source, "source");
                Intrinsics3.checkNotNullParameter(event, "event");
                if (event != Lifecycle.Event.upTo(state)) {
                    if (event == Lifecycle.Event.ON_DESTROY) {
                        lifecycle.removeObserver(this);
                        CancellableContinuation cancellableContinuation = cancellableContinuationImpl5;
                        WithLifecycleState withLifecycleState = new WithLifecycleState();
                        Result2.a aVar = Result2.j;
                        cancellableContinuation.resumeWith(Result2.m97constructorimpl(Result3.createFailure(withLifecycleState)));
                        return;
                    }
                    return;
                }
                lifecycle.removeObserver(this);
                CancellableContinuation cancellableContinuation2 = cancellableContinuationImpl5;
                Function0 function1 = function0;
                try {
                    Result2.a aVar2 = Result2.j;
                    objM97constructorimpl = Result2.m97constructorimpl(function1.invoke());
                } catch (Throwable th) {
                    Result2.a aVar3 = Result2.j;
                    objM97constructorimpl = Result2.m97constructorimpl(Result3.createFailure(th));
                }
                cancellableContinuation2.resumeWith(objM97constructorimpl);
            }
        };
        if (z2) {
            coroutineDispatcher.dispatch(CoroutineContextImpl4.j, new Runnable() { // from class: androidx.lifecycle.WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$$inlined$suspendCancellableCoroutine$lambda$2
                @Override // java.lang.Runnable
                public final void run() {
                    lifecycle.addObserver(r15);
                }
            });
        } else {
            lifecycle.addObserver(r15);
        }
        cancellableContinuationImpl5.f(new WithLifecycleState5(r15, lifecycle, state, function0, z2, coroutineDispatcher));
        Object objU = cancellableContinuationImpl5.u();
        if (objU == Intrinsics2.getCOROUTINE_SUSPENDED()) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return objU;
    }

    public static final <R> Object withCreated(Lifecycle lifecycle, Function0<? extends R> function0, Continuation<? super R> continuation) {
        Lifecycle.State state = Lifecycle.State.CREATED;
        CoroutineDispatcher coroutineDispatcher = Dispatchers.a;
        MainCoroutineDispatcher mainCoroutineDispatcherH = MainDispatchers.f3830b.H();
        boolean zIsDispatchNeeded = mainCoroutineDispatcherH.isDispatchNeeded(continuation.getContext());
        if (!zIsDispatchNeeded) {
            if (lifecycle.getCurrentState() == Lifecycle.State.DESTROYED) {
                throw new WithLifecycleState();
            }
            if (lifecycle.getCurrentState().compareTo(state) >= 0) {
                return function0.invoke();
            }
        }
        return suspendWithStateAtLeastUnchecked(lifecycle, state, zIsDispatchNeeded, mainCoroutineDispatcherH, new AnonymousClass2(function0), continuation);
    }

    private static final Object withCreated$$forInline(Lifecycle lifecycle, Function0 function0, Continuation continuation) {
        Lifecycle.State state = Lifecycle.State.CREATED;
        CoroutineDispatcher coroutineDispatcher = Dispatchers.a;
        MainDispatchers.f3830b.H();
        InlineMarker.mark(3);
        throw null;
    }

    public static final <R> Object withResumed(Lifecycle lifecycle, Function0<? extends R> function0, Continuation<? super R> continuation) {
        Lifecycle.State state = Lifecycle.State.RESUMED;
        CoroutineDispatcher coroutineDispatcher = Dispatchers.a;
        MainCoroutineDispatcher mainCoroutineDispatcherH = MainDispatchers.f3830b.H();
        boolean zIsDispatchNeeded = mainCoroutineDispatcherH.isDispatchNeeded(continuation.getContext());
        if (!zIsDispatchNeeded) {
            if (lifecycle.getCurrentState() == Lifecycle.State.DESTROYED) {
                throw new WithLifecycleState();
            }
            if (lifecycle.getCurrentState().compareTo(state) >= 0) {
                return function0.invoke();
            }
        }
        return suspendWithStateAtLeastUnchecked(lifecycle, state, zIsDispatchNeeded, mainCoroutineDispatcherH, new AnonymousClass2(function0), continuation);
    }

    private static final Object withResumed$$forInline(Lifecycle lifecycle, Function0 function0, Continuation continuation) {
        Lifecycle.State state = Lifecycle.State.RESUMED;
        CoroutineDispatcher coroutineDispatcher = Dispatchers.a;
        MainDispatchers.f3830b.H();
        InlineMarker.mark(3);
        throw null;
    }

    public static final <R> Object withStarted(Lifecycle lifecycle, Function0<? extends R> function0, Continuation<? super R> continuation) {
        Lifecycle.State state = Lifecycle.State.STARTED;
        CoroutineDispatcher coroutineDispatcher = Dispatchers.a;
        MainCoroutineDispatcher mainCoroutineDispatcherH = MainDispatchers.f3830b.H();
        boolean zIsDispatchNeeded = mainCoroutineDispatcherH.isDispatchNeeded(continuation.getContext());
        if (!zIsDispatchNeeded) {
            if (lifecycle.getCurrentState() == Lifecycle.State.DESTROYED) {
                throw new WithLifecycleState();
            }
            if (lifecycle.getCurrentState().compareTo(state) >= 0) {
                return function0.invoke();
            }
        }
        return suspendWithStateAtLeastUnchecked(lifecycle, state, zIsDispatchNeeded, mainCoroutineDispatcherH, new AnonymousClass2(function0), continuation);
    }

    private static final Object withStarted$$forInline(Lifecycle lifecycle, Function0 function0, Continuation continuation) {
        Lifecycle.State state = Lifecycle.State.STARTED;
        CoroutineDispatcher coroutineDispatcher = Dispatchers.a;
        MainDispatchers.f3830b.H();
        InlineMarker.mark(3);
        throw null;
    }

    public static final <R> Object withStateAtLeast(Lifecycle lifecycle, Lifecycle.State state, Function0<? extends R> function0, Continuation<? super R> continuation) {
        if (!(state.compareTo(Lifecycle.State.CREATED) >= 0)) {
            throw new IllegalArgumentException(("target state must be CREATED or greater, found " + state).toString());
        }
        CoroutineDispatcher coroutineDispatcher = Dispatchers.a;
        MainCoroutineDispatcher mainCoroutineDispatcherH = MainDispatchers.f3830b.H();
        boolean zIsDispatchNeeded = mainCoroutineDispatcherH.isDispatchNeeded(continuation.getContext());
        if (!zIsDispatchNeeded) {
            if (lifecycle.getCurrentState() == Lifecycle.State.DESTROYED) {
                throw new WithLifecycleState();
            }
            if (lifecycle.getCurrentState().compareTo(state) >= 0) {
                return function0.invoke();
            }
        }
        return suspendWithStateAtLeastUnchecked(lifecycle, state, zIsDispatchNeeded, mainCoroutineDispatcherH, new AnonymousClass2(function0), continuation);
    }

    private static final Object withStateAtLeast$$forInline(Lifecycle lifecycle, Lifecycle.State state, Function0 function0, Continuation continuation) {
        if (state.compareTo(Lifecycle.State.CREATED) >= 0) {
            CoroutineDispatcher coroutineDispatcher = Dispatchers.a;
            MainDispatchers.f3830b.H();
            InlineMarker.mark(3);
            throw null;
        }
        throw new IllegalArgumentException(("target state must be CREATED or greater, found " + state).toString());
    }

    public static final <R> Object withStateAtLeastUnchecked(Lifecycle lifecycle, Lifecycle.State state, Function0<? extends R> function0, Continuation<? super R> continuation) {
        CoroutineDispatcher coroutineDispatcher = Dispatchers.a;
        MainCoroutineDispatcher mainCoroutineDispatcherH = MainDispatchers.f3830b.H();
        boolean zIsDispatchNeeded = mainCoroutineDispatcherH.isDispatchNeeded(continuation.getContext());
        if (!zIsDispatchNeeded) {
            if (lifecycle.getCurrentState() == Lifecycle.State.DESTROYED) {
                throw new WithLifecycleState();
            }
            if (lifecycle.getCurrentState().compareTo(state) >= 0) {
                return function0.invoke();
            }
        }
        return suspendWithStateAtLeastUnchecked(lifecycle, state, zIsDispatchNeeded, mainCoroutineDispatcherH, new AnonymousClass2(function0), continuation);
    }

    private static final Object withStateAtLeastUnchecked$$forInline(Lifecycle lifecycle, Lifecycle.State state, Function0 function0, Continuation continuation) {
        CoroutineDispatcher coroutineDispatcher = Dispatchers.a;
        MainDispatchers.f3830b.H();
        InlineMarker.mark(3);
        throw null;
    }

    private static final Object withCreated$$forInline(LifecycleOwner lifecycleOwner, Function0 function0, Continuation continuation) {
        Intrinsics3.checkNotNullExpressionValue(lifecycleOwner.getLifecycle(), "lifecycle");
        Lifecycle.State state = Lifecycle.State.CREATED;
        CoroutineDispatcher coroutineDispatcher = Dispatchers.a;
        MainDispatchers.f3830b.H();
        InlineMarker.mark(3);
        throw null;
    }

    private static final Object withResumed$$forInline(LifecycleOwner lifecycleOwner, Function0 function0, Continuation continuation) {
        Intrinsics3.checkNotNullExpressionValue(lifecycleOwner.getLifecycle(), "lifecycle");
        Lifecycle.State state = Lifecycle.State.RESUMED;
        CoroutineDispatcher coroutineDispatcher = Dispatchers.a;
        MainDispatchers.f3830b.H();
        InlineMarker.mark(3);
        throw null;
    }

    private static final Object withStarted$$forInline(LifecycleOwner lifecycleOwner, Function0 function0, Continuation continuation) {
        Intrinsics3.checkNotNullExpressionValue(lifecycleOwner.getLifecycle(), "lifecycle");
        Lifecycle.State state = Lifecycle.State.STARTED;
        CoroutineDispatcher coroutineDispatcher = Dispatchers.a;
        MainDispatchers.f3830b.H();
        InlineMarker.mark(3);
        throw null;
    }

    private static final Object withStateAtLeast$$forInline(LifecycleOwner lifecycleOwner, Lifecycle.State state, Function0 function0, Continuation continuation) {
        Intrinsics3.checkNotNullExpressionValue(lifecycleOwner.getLifecycle(), "lifecycle");
        if (!(state.compareTo(Lifecycle.State.CREATED) >= 0)) {
            throw new IllegalArgumentException(("target state must be CREATED or greater, found " + state).toString());
        }
        CoroutineDispatcher coroutineDispatcher = Dispatchers.a;
        MainDispatchers.f3830b.H();
        InlineMarker.mark(3);
        throw null;
    }

    public static final <R> Object withCreated(LifecycleOwner lifecycleOwner, Function0<? extends R> function0, Continuation<? super R> continuation) {
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        Intrinsics3.checkNotNullExpressionValue(lifecycle, "lifecycle");
        Lifecycle.State state = Lifecycle.State.CREATED;
        CoroutineDispatcher coroutineDispatcher = Dispatchers.a;
        MainCoroutineDispatcher mainCoroutineDispatcherH = MainDispatchers.f3830b.H();
        boolean zIsDispatchNeeded = mainCoroutineDispatcherH.isDispatchNeeded(continuation.getContext());
        if (!zIsDispatchNeeded) {
            if (lifecycle.getCurrentState() != Lifecycle.State.DESTROYED) {
                if (lifecycle.getCurrentState().compareTo(state) >= 0) {
                    return function0.invoke();
                }
            } else {
                throw new WithLifecycleState();
            }
        }
        return suspendWithStateAtLeastUnchecked(lifecycle, state, zIsDispatchNeeded, mainCoroutineDispatcherH, new AnonymousClass2(function0), continuation);
    }

    public static final <R> Object withResumed(LifecycleOwner lifecycleOwner, Function0<? extends R> function0, Continuation<? super R> continuation) {
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        Intrinsics3.checkNotNullExpressionValue(lifecycle, "lifecycle");
        Lifecycle.State state = Lifecycle.State.RESUMED;
        CoroutineDispatcher coroutineDispatcher = Dispatchers.a;
        MainCoroutineDispatcher mainCoroutineDispatcherH = MainDispatchers.f3830b.H();
        boolean zIsDispatchNeeded = mainCoroutineDispatcherH.isDispatchNeeded(continuation.getContext());
        if (!zIsDispatchNeeded) {
            if (lifecycle.getCurrentState() != Lifecycle.State.DESTROYED) {
                if (lifecycle.getCurrentState().compareTo(state) >= 0) {
                    return function0.invoke();
                }
            } else {
                throw new WithLifecycleState();
            }
        }
        return suspendWithStateAtLeastUnchecked(lifecycle, state, zIsDispatchNeeded, mainCoroutineDispatcherH, new AnonymousClass2(function0), continuation);
    }

    public static final <R> Object withStarted(LifecycleOwner lifecycleOwner, Function0<? extends R> function0, Continuation<? super R> continuation) {
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        Intrinsics3.checkNotNullExpressionValue(lifecycle, "lifecycle");
        Lifecycle.State state = Lifecycle.State.STARTED;
        CoroutineDispatcher coroutineDispatcher = Dispatchers.a;
        MainCoroutineDispatcher mainCoroutineDispatcherH = MainDispatchers.f3830b.H();
        boolean zIsDispatchNeeded = mainCoroutineDispatcherH.isDispatchNeeded(continuation.getContext());
        if (!zIsDispatchNeeded) {
            if (lifecycle.getCurrentState() != Lifecycle.State.DESTROYED) {
                if (lifecycle.getCurrentState().compareTo(state) >= 0) {
                    return function0.invoke();
                }
            } else {
                throw new WithLifecycleState();
            }
        }
        return suspendWithStateAtLeastUnchecked(lifecycle, state, zIsDispatchNeeded, mainCoroutineDispatcherH, new AnonymousClass2(function0), continuation);
    }

    public static final <R> Object withStateAtLeast(LifecycleOwner lifecycleOwner, Lifecycle.State state, Function0<? extends R> function0, Continuation<? super R> continuation) {
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        Intrinsics3.checkNotNullExpressionValue(lifecycle, "lifecycle");
        if (state.compareTo(Lifecycle.State.CREATED) >= 0) {
            CoroutineDispatcher coroutineDispatcher = Dispatchers.a;
            MainCoroutineDispatcher mainCoroutineDispatcherH = MainDispatchers.f3830b.H();
            boolean zIsDispatchNeeded = mainCoroutineDispatcherH.isDispatchNeeded(continuation.getContext());
            if (!zIsDispatchNeeded) {
                if (lifecycle.getCurrentState() != Lifecycle.State.DESTROYED) {
                    if (lifecycle.getCurrentState().compareTo(state) >= 0) {
                        return function0.invoke();
                    }
                } else {
                    throw new WithLifecycleState();
                }
            }
            return suspendWithStateAtLeastUnchecked(lifecycle, state, zIsDispatchNeeded, mainCoroutineDispatcherH, new AnonymousClass2(function0), continuation);
        }
        throw new IllegalArgumentException(("target state must be CREATED or greater, found " + state).toString());
    }
}
