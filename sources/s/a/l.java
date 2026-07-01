package s.a;

import b.d.b.a.a;
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

/* JADX INFO: compiled from: CancellableContinuationImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public class l<T> extends j0<T> implements CancellableContinuation<T>, CoroutineStackFrame {
    public static final AtomicIntegerFieldUpdater m = AtomicIntegerFieldUpdater.newUpdater(l.class, "_decision");
    public static final AtomicReferenceFieldUpdater n = AtomicReferenceFieldUpdater.newUpdater(l.class, Object.class, "_state");
    public volatile int _decision;
    public volatile Object _parentHandle;
    public volatile Object _state;
    public final CoroutineContext o;
    public final Continuation<T> p;

    /* JADX WARN: Multi-variable type inference failed */
    public l(Continuation<? super T> continuation, int i) {
        super(i);
        this.p = continuation;
        this.o = continuation.getContext();
        this._decision = 0;
        this._state = c.j;
        this._parentHandle = null;
    }

    public final void A() {
        Job job;
        s.a.a.t tVar;
        boolean zV = v();
        if (this.l == 2) {
            Continuation<T> continuation = this.p;
            Throwable th = null;
            if (!(continuation instanceof s.a.a.g)) {
                continuation = null;
            }
            s.a.a.g gVar = (s.a.a.g) continuation;
            if (gVar != null) {
                do {
                    Object obj = gVar._reusableCancellableContinuation;
                    tVar = s.a.a.h.f3827b;
                    if (obj != tVar) {
                        if (obj == null) {
                            break;
                        }
                        if (!(obj instanceof Throwable)) {
                            throw new IllegalStateException(a.v("Inconsistent state ", obj).toString());
                        }
                        if (!s.a.a.g.m.compareAndSet(gVar, obj, null)) {
                            throw new IllegalArgumentException("Failed requirement.".toString());
                        }
                        th = (Throwable) obj;
                        break;
                    }
                } while (!s.a.a.g.m.compareAndSet(gVar, tVar, this));
                if (th != null) {
                    if (!zV) {
                        k(th);
                    }
                    zV = true;
                }
            }
        }
        if (zV || ((m0) this._parentHandle) != null || (job = (Job) this.p.getContext().get(Job.h)) == null) {
            return;
        }
        m0 m0VarW0 = b.i.a.f.e.o.f.w0(job, true, false, new o(job, this), 2, null);
        this._parentHandle = m0VarW0;
        if (!v() || w()) {
            return;
        }
        m0VarW0.dispose();
        this._parentHandle = o1.j;
    }

    public final s.a.a.t B(Object obj, Object obj2, Function1<? super Throwable, Unit> function1) {
        Object obj3;
        do {
            obj3 = this._state;
            if (!(obj3 instanceof p1)) {
                if ((obj3 instanceof v) && obj2 != null && ((v) obj3).d == obj2) {
                    return m.a;
                }
                return null;
            }
        } while (!n.compareAndSet(this, obj3, z((p1) obj3, obj, this.l, function1, obj2)));
        s();
        return m.a;
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public boolean a() {
        return this._state instanceof p1;
    }

    @Override // s.a.j0
    public void b(Object obj, Throwable th) {
        while (true) {
            Object obj2 = this._state;
            if (obj2 instanceof p1) {
                throw new IllegalStateException("Not completed".toString());
            }
            if (obj2 instanceof w) {
                return;
            }
            if (obj2 instanceof v) {
                v vVar = (v) obj2;
                if (!(!(vVar.e != null))) {
                    throw new IllegalStateException("Must be called at most once".toString());
                }
                if (n.compareAndSet(this, obj2, v.a(vVar, null, null, null, null, th, 15))) {
                    j jVar = vVar.f3845b;
                    if (jVar != null) {
                        o(jVar, th);
                    }
                    Function1<Throwable, Unit> function1 = vVar.c;
                    if (function1 != null) {
                        p(function1, th);
                        return;
                    }
                    return;
                }
            } else if (n.compareAndSet(this, obj2, new v(obj2, null, null, null, th, 14))) {
                return;
            }
        }
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public Object c(T t, Object obj) {
        return B(t, obj, null);
    }

    @Override // s.a.j0
    public final Continuation<T> d() {
        return this.p;
    }

    @Override // s.a.j0
    public Throwable e(Object obj) {
        Throwable thE = super.e(obj);
        if (thE != null) {
            return thE;
        }
        return null;
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public void f(Function1<? super Throwable, Unit> function1) {
        j b1Var = function1 instanceof j ? (j) function1 : new b1(function1);
        while (true) {
            Object obj = this._state;
            if (!(obj instanceof c)) {
                if (obj instanceof j) {
                    x(function1, obj);
                    throw null;
                }
                boolean z2 = obj instanceof w;
                if (z2) {
                    w wVar = (w) obj;
                    Objects.requireNonNull(wVar);
                    if (!w.a.compareAndSet(wVar, 0, 1)) {
                        x(function1, obj);
                        throw null;
                    }
                    if (obj instanceof n) {
                        if (!z2) {
                            obj = null;
                        }
                        w wVar2 = (w) obj;
                        n(function1, wVar2 != null ? wVar2.f3846b : null);
                        return;
                    }
                    return;
                }
                if (obj instanceof v) {
                    v vVar = (v) obj;
                    if (vVar.f3845b != null) {
                        x(function1, obj);
                        throw null;
                    }
                    if (b1Var instanceof e) {
                        return;
                    }
                    Throwable th = vVar.e;
                    if (th != null) {
                        n(function1, th);
                        return;
                    } else {
                        if (n.compareAndSet(this, obj, v.a(vVar, null, b1Var, null, null, null, 29))) {
                            return;
                        }
                    }
                } else {
                    if (b1Var instanceof e) {
                        return;
                    }
                    if (n.compareAndSet(this, obj, new v(obj, b1Var, null, null, null, 28))) {
                        return;
                    }
                }
            } else if (n.compareAndSet(this, obj, b1Var)) {
                return;
            }
        }
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public Object g(Throwable th) {
        return B(new w(th, false, 2), null, null);
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
        if (!(continuation instanceof s.a.a.g)) {
            continuation = null;
        }
        s.a.a.g gVar = (s.a.a.g) continuation;
        y(t, (gVar != null ? gVar.q : null) == coroutineDispatcher ? 4 : this.l, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // s.a.j0
    public <T> T j(Object obj) {
        return obj instanceof v ? (T) ((v) obj).a : obj;
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public boolean k(Throwable th) {
        Object obj;
        boolean z2;
        do {
            obj = this._state;
            if (!(obj instanceof p1)) {
                return false;
            }
            z2 = obj instanceof j;
        } while (!n.compareAndSet(this, obj, new n(this, th, z2)));
        if (!z2) {
            obj = null;
        }
        j jVar = (j) obj;
        if (jVar != null) {
            o(jVar, th);
        }
        s();
        t(this.l);
        return true;
    }

    @Override // s.a.j0
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

    public final void o(j jVar, Throwable th) {
        try {
            jVar.a(th);
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
        m0 m0Var = (m0) this._parentHandle;
        if (m0Var != null) {
            m0Var.dispose();
        }
        this._parentHandle = o1.j;
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public void r(Object obj) {
        t(this.l);
    }

    @Override // kotlin.coroutines.Continuation
    public void resumeWith(Object obj) {
        Throwable thM99exceptionOrNullimpl = d0.k.m99exceptionOrNullimpl(obj);
        if (thM99exceptionOrNullimpl != null) {
            obj = new w(thM99exceptionOrNullimpl, false, 2);
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
        if (z3 || !(continuationD instanceof s.a.a.g) || b.i.a.f.e.o.f.B0(i) != b.i.a.f.e.o.f.B0(this.l)) {
            b.i.a.f.e.o.f.Y0(this, continuationD, z3);
            return;
        }
        CoroutineDispatcher coroutineDispatcher = ((s.a.a.g) continuationD).q;
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
            return d0.w.h.c.getCOROUTINE_SUSPENDED();
        }
        Object obj = this._state;
        if (obj instanceof w) {
            throw ((w) obj).f3846b;
        }
        if (!b.i.a.f.e.o.f.B0(this.l) || (job = (Job) this.o.get(Job.h)) == null || job.a()) {
            return j(obj);
        }
        CancellationException cancellationExceptionQ = job.q();
        b(obj, cancellationExceptionQ);
        throw cancellationExceptionQ;
    }

    public boolean v() {
        return !(this._state instanceof p1);
    }

    public final boolean w() {
        Continuation<T> continuation = this.p;
        if (!(continuation instanceof s.a.a.g)) {
            return false;
        }
        Object obj = ((s.a.a.g) continuation)._reusableCancellableContinuation;
        return obj != null && (!(obj instanceof l) || obj == this);
    }

    public final void x(Function1<? super Throwable, Unit> function1, Object obj) {
        throw new IllegalStateException(("It's prohibited to register multiple handlers, tried to register " + function1 + ", already has " + obj).toString());
    }

    public final void y(Object obj, int i, Function1<? super Throwable, Unit> function1) {
        Object obj2;
        do {
            obj2 = this._state;
            if (!(obj2 instanceof p1)) {
                if (obj2 instanceof n) {
                    n nVar = (n) obj2;
                    Objects.requireNonNull(nVar);
                    if (n.c.compareAndSet(nVar, 0, 1)) {
                        if (function1 != null) {
                            p(function1, nVar.f3846b);
                            return;
                        }
                        return;
                    }
                }
                throw new IllegalStateException(a.v("Already resumed, but proposed with update ", obj).toString());
            }
        } while (!n.compareAndSet(this, obj2, z((p1) obj2, obj, i, function1, null)));
        s();
        t(i);
    }

    public final Object z(p1 p1Var, Object obj, int i, Function1<? super Throwable, Unit> function1, Object obj2) {
        if (obj instanceof w) {
            return obj;
        }
        if (!b.i.a.f.e.o.f.B0(i) && obj2 == null) {
            return obj;
        }
        if (function1 == null && ((!(p1Var instanceof j) || (p1Var instanceof e)) && obj2 == null)) {
            return obj;
        }
        if (!(p1Var instanceof j)) {
            p1Var = null;
        }
        return new v(obj, (j) p1Var, function1, obj2, null, 16);
    }
}
