package s.a;

import b.d.b.a.outline;
import d0.Result2;
import d0.w.h.Intrinsics2;
import java.util.Objects;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CompletionHandlerException;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Job;
import s.a.a.DispatchedContinuation;
import s.a.a.DispatchedContinuation2;
import s.a.a.Symbol3;

/* JADX INFO: renamed from: s.a.l, reason: use source file name */
/* JADX INFO: compiled from: CancellableContinuationImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public class CancellableContinuationImpl5<T> extends DispatchedTask<T> implements CancellableContinuation<T>, CoroutineStackFrame {
    public static final AtomicIntegerFieldUpdater m = AtomicIntegerFieldUpdater.newUpdater(CancellableContinuationImpl5.class, "_decision");
    public static final AtomicReferenceFieldUpdater n = AtomicReferenceFieldUpdater.newUpdater(CancellableContinuationImpl5.class, Object.class, "_state");
    public volatile int _decision;
    public volatile Object _parentHandle;
    public volatile Object _state;
    public final CoroutineContext o;
    public final Continuation<T> p;

    /* JADX WARN: Multi-variable type inference failed */
    public CancellableContinuationImpl5(Continuation<? super T> continuation, int i) {
        super(i);
        this.p = continuation;
        this.o = continuation.getContext();
        this._decision = 0;
        this._state = CancellableContinuationImpl2.j;
        this._parentHandle = null;
    }

    public final void A() {
        Job job;
        Symbol3 symbol3;
        boolean zV = v();
        if (this.l == 2) {
            Continuation<T> continuation = this.p;
            Throwable th = null;
            if (!(continuation instanceof DispatchedContinuation)) {
                continuation = null;
            }
            DispatchedContinuation dispatchedContinuation = (DispatchedContinuation) continuation;
            if (dispatchedContinuation != null) {
                do {
                    Object obj = dispatchedContinuation._reusableCancellableContinuation;
                    symbol3 = DispatchedContinuation2.f3827b;
                    if (obj != symbol3) {
                        if (obj == null) {
                            break;
                        }
                        if (!(obj instanceof Throwable)) {
                            throw new IllegalStateException(outline.v("Inconsistent state ", obj).toString());
                        }
                        if (!DispatchedContinuation.m.compareAndSet(dispatchedContinuation, obj, null)) {
                            throw new IllegalArgumentException("Failed requirement.".toString());
                        }
                        th = (Throwable) obj;
                        break;
                    }
                } while (!DispatchedContinuation.m.compareAndSet(dispatchedContinuation, symbol3, this));
                if (th != null) {
                    if (!zV) {
                        k(th);
                    }
                    zV = true;
                }
            }
        }
        if (zV || ((Job2) this._parentHandle) != null || (job = (Job) this.p.getContext().get(Job.INSTANCE)) == null) {
            return;
        }
        Job2 job2W0 = b.i.a.f.e.o.f.w0(job, true, false, new o(job, this), 2, null);
        this._parentHandle = job2W0;
        if (!v() || w()) {
            return;
        }
        job2W0.dispose();
        this._parentHandle = Job3.j;
    }

    public final Symbol3 B(Object obj, Object obj2, Function1<? super Throwable, Unit> function1) {
        Object obj3;
        do {
            obj3 = this._state;
            if (!(obj3 instanceof CancellableContinuationImpl7)) {
                if ((obj3 instanceof CancellableContinuationImpl8) && obj2 != null && ((CancellableContinuationImpl8) obj3).d == obj2) {
                    return CancellableContinuationImpl6.a;
                }
                return null;
            }
        } while (!n.compareAndSet(this, obj3, z((CancellableContinuationImpl7) obj3, obj, this.l, function1, obj2)));
        s();
        return CancellableContinuationImpl6.a;
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public boolean a() {
        return this._state instanceof CancellableContinuationImpl7;
    }

    @Override // s.a.DispatchedTask
    public void b(Object obj, Throwable th) {
        while (true) {
            Object obj2 = this._state;
            if (obj2 instanceof CancellableContinuationImpl7) {
                throw new IllegalStateException("Not completed".toString());
            }
            if (obj2 instanceof CompletionState2) {
                return;
            }
            if (obj2 instanceof CancellableContinuationImpl8) {
                CancellableContinuationImpl8 cancellableContinuationImpl8 = (CancellableContinuationImpl8) obj2;
                if (!(!(cancellableContinuationImpl8.e != null))) {
                    throw new IllegalStateException("Must be called at most once".toString());
                }
                if (n.compareAndSet(this, obj2, CancellableContinuationImpl8.a(cancellableContinuationImpl8, null, null, null, null, th, 15))) {
                    CancellableContinuationImpl4 cancellableContinuationImpl4 = cancellableContinuationImpl8.f3845b;
                    if (cancellableContinuationImpl4 != null) {
                        o(cancellableContinuationImpl4, th);
                    }
                    Function1<Throwable, Unit> function1 = cancellableContinuationImpl8.c;
                    if (function1 != null) {
                        p(function1, th);
                        return;
                    }
                    return;
                }
            } else if (n.compareAndSet(this, obj2, new CancellableContinuationImpl8(obj2, null, null, null, th, 14))) {
                return;
            }
        }
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public Object c(T t, Object obj) {
        return B(t, obj, null);
    }

    @Override // s.a.DispatchedTask
    public final Continuation<T> d() {
        return this.p;
    }

    @Override // s.a.DispatchedTask
    public Throwable e(Object obj) {
        Throwable thE = super.e(obj);
        if (thE != null) {
            return thE;
        }
        return null;
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public void f(Function1<? super Throwable, Unit> function1) {
        CancellableContinuationImpl4 cancellableContinuationImpl = function1 instanceof CancellableContinuationImpl4 ? (CancellableContinuationImpl4) function1 : new CancellableContinuationImpl(function1);
        while (true) {
            Object obj = this._state;
            if (!(obj instanceof CancellableContinuationImpl2)) {
                if (obj instanceof CancellableContinuationImpl4) {
                    x(function1, obj);
                    throw null;
                }
                boolean z2 = obj instanceof CompletionState2;
                if (z2) {
                    CompletionState2 completionState2 = (CompletionState2) obj;
                    Objects.requireNonNull(completionState2);
                    if (!CompletionState2.a.compareAndSet(completionState2, 0, 1)) {
                        x(function1, obj);
                        throw null;
                    }
                    if (obj instanceof CompletionState) {
                        if (!z2) {
                            obj = null;
                        }
                        CompletionState2 completionState3 = (CompletionState2) obj;
                        n(function1, completionState3 != null ? completionState3.f3846b : null);
                        return;
                    }
                    return;
                }
                if (obj instanceof CancellableContinuationImpl8) {
                    CancellableContinuationImpl8 cancellableContinuationImpl8 = (CancellableContinuationImpl8) obj;
                    if (cancellableContinuationImpl8.f3845b != null) {
                        x(function1, obj);
                        throw null;
                    }
                    if (cancellableContinuationImpl instanceof CancellableContinuationImpl3) {
                        return;
                    }
                    Throwable th = cancellableContinuationImpl8.e;
                    if (th != null) {
                        n(function1, th);
                        return;
                    } else {
                        if (n.compareAndSet(this, obj, CancellableContinuationImpl8.a(cancellableContinuationImpl8, null, cancellableContinuationImpl, null, null, null, 29))) {
                            return;
                        }
                    }
                } else {
                    if (cancellableContinuationImpl instanceof CancellableContinuationImpl3) {
                        return;
                    }
                    if (n.compareAndSet(this, obj, new CancellableContinuationImpl8(obj, cancellableContinuationImpl, null, null, null, 28))) {
                        return;
                    }
                }
            } else if (n.compareAndSet(this, obj, cancellableContinuationImpl)) {
                return;
            }
        }
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public Object g(Throwable th) {
        return B(new CompletionState2(th, false, 2), null, null);
    }

    @Override // kotlin.coroutines.Continuation
    public CoroutineContext getContext() {
        return this.o;
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public Object h(T t, Object obj, Function1<? super Throwable, Unit> function1) {
        return B(t, null, function1);
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public void i(CoroutineDispatcher coroutineDispatcher, T t) {
        Continuation<T> continuation = this.p;
        if (!(continuation instanceof DispatchedContinuation)) {
            continuation = null;
        }
        DispatchedContinuation dispatchedContinuation = (DispatchedContinuation) continuation;
        y(t, (dispatchedContinuation != null ? dispatchedContinuation.q : null) == coroutineDispatcher ? 4 : this.l, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // s.a.DispatchedTask
    public <T> T j(Object obj) {
        return obj instanceof CancellableContinuationImpl8 ? (T) ((CancellableContinuationImpl8) obj).a : obj;
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public boolean k(Throwable th) {
        Object obj;
        boolean z2;
        do {
            obj = this._state;
            if (!(obj instanceof CancellableContinuationImpl7)) {
                return false;
            }
            z2 = obj instanceof CancellableContinuationImpl4;
        } while (!n.compareAndSet(this, obj, new CompletionState(this, th, z2)));
        if (!z2) {
            obj = null;
        }
        CancellableContinuationImpl4 cancellableContinuationImpl4 = (CancellableContinuationImpl4) obj;
        if (cancellableContinuationImpl4 != null) {
            o(cancellableContinuationImpl4, th);
        }
        s();
        t(this.l);
        return true;
    }

    @Override // s.a.DispatchedTask
    public Object m() {
        return this._state;
    }

    public final void n(Function1<? super Throwable, Unit> function1, Throwable th) {
        try {
            function1.invoke(th);
        } catch (Throwable th2) {
            b.i.a.f.e.o.f.u0(this.o, new CompletionHandlerException("Exception in invokeOnCancellation handler for " + this, th2));
        }
    }

    public final void o(CancellableContinuationImpl4 cancellableContinuationImpl4, Throwable th) {
        try {
            cancellableContinuationImpl4.a(th);
        } catch (Throwable th2) {
            b.i.a.f.e.o.f.u0(this.o, new CompletionHandlerException("Exception in invokeOnCancellation handler for " + this, th2));
        }
    }

    public final void p(Function1<? super Throwable, Unit> function1, Throwable th) {
        try {
            function1.invoke(th);
        } catch (Throwable th2) {
            b.i.a.f.e.o.f.u0(this.o, new CompletionHandlerException("Exception in resume onCancellation handler for " + this, th2));
        }
    }

    public final void q() {
        Job2 job2 = (Job2) this._parentHandle;
        if (job2 != null) {
            job2.dispose();
        }
        this._parentHandle = Job3.j;
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public void r(Object obj) {
        t(this.l);
    }

    @Override // kotlin.coroutines.Continuation
    public void resumeWith(Object obj) {
        Throwable thM99exceptionOrNullimpl = Result2.m99exceptionOrNullimpl(obj);
        if (thM99exceptionOrNullimpl != null) {
            obj = new CompletionState2(thM99exceptionOrNullimpl, false, 2);
        }
        y(obj, this.l, null);
    }

    public final void s() {
        if (w()) {
            return;
        }
        q();
    }

    public final void t(int i) {
        boolean z2;
        while (true) {
            int i2 = this._decision;
            if (i2 != 0) {
                if (i2 != 1) {
                    throw new IllegalStateException("Already resumed".toString());
                }
                z2 = false;
                break;
            } else if (m.compareAndSet(this, 0, 2)) {
                z2 = true;
                break;
            }
        }
        if (z2) {
            return;
        }
        Continuation<T> continuationD = d();
        boolean z3 = i == 4;
        if (z3 || !(continuationD instanceof DispatchedContinuation) || b.i.a.f.e.o.f.B0(i) != b.i.a.f.e.o.f.B0(this.l)) {
            b.i.a.f.e.o.f.Y0(this, continuationD, z3);
            return;
        }
        CoroutineDispatcher coroutineDispatcher = ((DispatchedContinuation) continuationD).q;
        CoroutineContext context = continuationD.getContext();
        if (coroutineDispatcher.isDispatchNeeded(context)) {
            coroutineDispatcher.dispatch(context, this);
            return;
        }
        w1 w1Var = w1.f3847b;
        q0 q0VarA = w1.a();
        if (q0VarA.N()) {
            q0VarA.J(this);
            return;
        }
        q0VarA.L(true);
        try {
            b.i.a.f.e.o.f.Y0(this, d(), true);
            do {
            } while (q0VarA.R());
        } catch (Throwable th) {
            try {
                l(th, null);
            } finally {
                q0VarA.H(true);
            }
        }
    }

    public String toString() {
        return "CancellableContinuation(" + b.i.a.f.e.o.f.s1(this.p) + "){" + this._state + "}@" + b.i.a.f.e.o.f.l0(this);
    }

    public final Object u() {
        boolean z2;
        Job job;
        A();
        while (true) {
            int i = this._decision;
            z2 = false;
            if (i != 0) {
                if (i == 2) {
                    break;
                }
                throw new IllegalStateException("Already suspended".toString());
            }
            if (m.compareAndSet(this, 0, 1)) {
                z2 = true;
                break;
            }
        }
        if (z2) {
            return Intrinsics2.getCOROUTINE_SUSPENDED();
        }
        Object obj = this._state;
        if (obj instanceof CompletionState2) {
            throw ((CompletionState2) obj).f3846b;
        }
        if (!b.i.a.f.e.o.f.B0(this.l) || (job = (Job) this.o.get(Job.INSTANCE)) == null || job.a()) {
            return j(obj);
        }
        CancellationException cancellationExceptionQ = job.q();
        b(obj, cancellationExceptionQ);
        throw cancellationExceptionQ;
    }

    public boolean v() {
        return !(this._state instanceof CancellableContinuationImpl7);
    }

    public final boolean w() {
        Continuation<T> continuation = this.p;
        if (!(continuation instanceof DispatchedContinuation)) {
            return false;
        }
        Object obj = ((DispatchedContinuation) continuation)._reusableCancellableContinuation;
        return obj != null && (!(obj instanceof CancellableContinuationImpl5) || obj == this);
    }

    public final void x(Function1<? super Throwable, Unit> function1, Object obj) {
        throw new IllegalStateException(("It's prohibited to register multiple handlers, tried to register " + function1 + ", already has " + obj).toString());
    }

    public final void y(Object obj, int i, Function1<? super Throwable, Unit> function1) {
        Object obj2;
        do {
            obj2 = this._state;
            if (!(obj2 instanceof CancellableContinuationImpl7)) {
                if (obj2 instanceof CompletionState) {
                    CompletionState completionState = (CompletionState) obj2;
                    Objects.requireNonNull(completionState);
                    if (CompletionState.c.compareAndSet(completionState, 0, 1)) {
                        if (function1 != null) {
                            p(function1, completionState.f3846b);
                            return;
                        }
                        return;
                    }
                }
                throw new IllegalStateException(outline.v("Already resumed, but proposed with update ", obj).toString());
            }
        } while (!n.compareAndSet(this, obj2, z((CancellableContinuationImpl7) obj2, obj, i, function1, null)));
        s();
        t(i);
    }

    public final Object z(CancellableContinuationImpl7 cancellableContinuationImpl7, Object obj, int i, Function1<? super Throwable, Unit> function1, Object obj2) {
        if (obj instanceof CompletionState2) {
            return obj;
        }
        if (!b.i.a.f.e.o.f.B0(i) && obj2 == null) {
            return obj;
        }
        if (function1 == null && ((!(cancellableContinuationImpl7 instanceof CancellableContinuationImpl4) || (cancellableContinuationImpl7 instanceof CancellableContinuationImpl3)) && obj2 == null)) {
            return obj;
        }
        if (!(cancellableContinuationImpl7 instanceof CancellableContinuationImpl4)) {
            cancellableContinuationImpl7 = null;
        }
        return new CancellableContinuationImpl8(obj, (CancellableContinuationImpl4) cancellableContinuationImpl7, function1, obj2, null, 16);
    }
}
