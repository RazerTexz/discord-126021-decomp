package p659s.p660a;

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
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p507d0.C12112k;
import p507d0.p584w.p585h.C12183c;
import p659s.p660a.p661a.C13024g;
import p659s.p660a.p661a.C13025h;
import p659s.p660a.p661a.C13037t;

/* JADX INFO: renamed from: s.a.l */
/* JADX INFO: compiled from: CancellableContinuationImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public class C13126l<T> extends AbstractC13121j0<T> implements CancellableContinuation<T>, CoroutineStackFrame {

    /* JADX INFO: renamed from: m */
    public static final AtomicIntegerFieldUpdater f27869m = AtomicIntegerFieldUpdater.newUpdater(C13126l.class, "_decision");

    /* JADX INFO: renamed from: n */
    public static final AtomicReferenceFieldUpdater f27870n = AtomicReferenceFieldUpdater.newUpdater(C13126l.class, Object.class, "_state");
    public volatile int _decision;
    public volatile Object _parentHandle;
    public volatile Object _state;

    /* JADX INFO: renamed from: o */
    public final CoroutineContext f27871o;

    /* JADX INFO: renamed from: p */
    public final Continuation<T> f27872p;

    /* JADX WARN: Multi-variable type inference failed */
    public C13126l(Continuation<? super T> continuation, int i) {
        super(i);
        this.f27872p = continuation;
        this.f27871o = continuation.getContext();
        this._decision = 0;
        this._state = C13051c.f27726j;
        this._parentHandle = null;
    }

    /* JADX INFO: renamed from: A */
    public final void m11318A() {
        Job job;
        C13037t c13037t;
        boolean zM11327v = m11327v();
        if (this.f27864l == 2) {
            Continuation<T> continuation = this.f27872p;
            Throwable th = null;
            if (!(continuation instanceof C13024g)) {
                continuation = null;
            }
            C13024g c13024g = (C13024g) continuation;
            if (c13024g != null) {
                do {
                    Object obj = c13024g._reusableCancellableContinuation;
                    c13037t = C13025h.f27682b;
                    if (obj != c13037t) {
                        if (obj == null) {
                            break;
                        }
                        if (!(obj instanceof Throwable)) {
                            throw new IllegalStateException(C1643a.m881v("Inconsistent state ", obj).toString());
                        }
                        if (!C13024g.f27675m.compareAndSet(c13024g, obj, null)) {
                            throw new IllegalArgumentException("Failed requirement.".toString());
                        }
                        th = (Throwable) obj;
                        break;
                    }
                } while (!C13024g.f27675m.compareAndSet(c13024g, c13037t, this));
                if (th != null) {
                    if (!zM11327v) {
                        mo10906k(th);
                    }
                    zM11327v = true;
                }
            }
        }
        if (zM11327v || ((InterfaceC13130m0) this._parentHandle) != null || (job = (Job) this.f27872p.getContext().get(Job.INSTANCE)) == null) {
            return;
        }
        InterfaceC13130m0 interfaceC13130m0M4356w0 = C3404f.m4356w0(job, true, false, new C13135o(job, this), 2, null);
        this._parentHandle = interfaceC13130m0M4356w0;
        if (!m11327v() || m11328w()) {
            return;
        }
        interfaceC13130m0M4356w0.dispose();
        this._parentHandle = C13137o1.f27880j;
    }

    /* JADX INFO: renamed from: B */
    public final C13037t m11319B(Object obj, Object obj2, Function1<? super Throwable, Unit> function1) {
        Object obj3;
        do {
            obj3 = this._state;
            if (!(obj3 instanceof InterfaceC13140p1)) {
                if ((obj3 instanceof C13156v) && obj2 != null && ((C13156v) obj3).f27909d == obj2) {
                    return C13129m.f27874a;
                }
                return null;
            }
        } while (!f27870n.compareAndSet(this, obj3, m11331z((InterfaceC13140p1) obj3, obj, this.f27864l, function1, obj2)));
        m11324s();
        return C13129m.f27874a;
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    /* JADX INFO: renamed from: a */
    public boolean mo10900a() {
        return this._state instanceof InterfaceC13140p1;
    }

    @Override // p659s.p660a.AbstractC13121j0
    /* JADX INFO: renamed from: b */
    public void mo11145b(Object obj, Throwable th) {
        while (true) {
            Object obj2 = this._state;
            if (obj2 instanceof InterfaceC13140p1) {
                throw new IllegalStateException("Not completed".toString());
            }
            if (obj2 instanceof C13159w) {
                return;
            }
            if (obj2 instanceof C13156v) {
                C13156v c13156v = (C13156v) obj2;
                if (!(!(c13156v.f27910e != null))) {
                    throw new IllegalStateException("Must be called at most once".toString());
                }
                if (f27870n.compareAndSet(this, obj2, C13156v.m11349a(c13156v, null, null, null, null, th, 15))) {
                    AbstractC13120j abstractC13120j = c13156v.f27907b;
                    if (abstractC13120j != null) {
                        m11321o(abstractC13120j, th);
                    }
                    Function1<Throwable, Unit> function1 = c13156v.f27908c;
                    if (function1 != null) {
                        m11322p(function1, th);
                        return;
                    }
                    return;
                }
            } else if (f27870n.compareAndSet(this, obj2, new C13156v(obj2, null, null, null, th, 14))) {
                return;
            }
        }
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    /* JADX INFO: renamed from: c */
    public Object mo10901c(T t, Object obj) {
        return m11319B(t, obj, null);
    }

    @Override // p659s.p660a.AbstractC13121j0
    /* JADX INFO: renamed from: d */
    public final Continuation<T> mo11146d() {
        return this.f27872p;
    }

    @Override // p659s.p660a.AbstractC13121j0
    /* JADX INFO: renamed from: e */
    public Throwable mo11315e(Object obj) {
        Throwable thMo11315e = super.mo11315e(obj);
        if (thMo11315e != null) {
            return thMo11315e;
        }
        return null;
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    /* JADX INFO: renamed from: f */
    public void mo10902f(Function1<? super Throwable, Unit> function1) {
        AbstractC13120j c13047b1 = function1 instanceof AbstractC13120j ? (AbstractC13120j) function1 : new C13047b1(function1);
        while (true) {
            Object obj = this._state;
            if (!(obj instanceof C13051c)) {
                if (obj instanceof AbstractC13120j) {
                    m11329x(function1, obj);
                    throw null;
                }
                boolean z2 = obj instanceof C13159w;
                if (z2) {
                    C13159w c13159w = (C13159w) obj;
                    Objects.requireNonNull(c13159w);
                    if (!C13159w.f27912a.compareAndSet(c13159w, 0, 1)) {
                        m11329x(function1, obj);
                        throw null;
                    }
                    if (obj instanceof C13132n) {
                        if (!z2) {
                            obj = null;
                        }
                        C13159w c13159w2 = (C13159w) obj;
                        m11320n(function1, c13159w2 != null ? c13159w2.f27913b : null);
                        return;
                    }
                    return;
                }
                if (obj instanceof C13156v) {
                    C13156v c13156v = (C13156v) obj;
                    if (c13156v.f27907b != null) {
                        m11329x(function1, obj);
                        throw null;
                    }
                    if (c13047b1 instanceof AbstractC13092e) {
                        return;
                    }
                    Throwable th = c13156v.f27910e;
                    if (th != null) {
                        m11320n(function1, th);
                        return;
                    } else {
                        if (f27870n.compareAndSet(this, obj, C13156v.m11349a(c13156v, null, c13047b1, null, null, null, 29))) {
                            return;
                        }
                    }
                } else {
                    if (c13047b1 instanceof AbstractC13092e) {
                        return;
                    }
                    if (f27870n.compareAndSet(this, obj, new C13156v(obj, c13047b1, null, null, null, 28))) {
                        return;
                    }
                }
            } else if (f27870n.compareAndSet(this, obj, c13047b1)) {
                return;
            }
        }
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    /* JADX INFO: renamed from: g */
    public Object mo10903g(Throwable th) {
        return m11319B(new C13159w(th, false, 2), null, null);
    }

    @Override // kotlin.coroutines.Continuation
    public CoroutineContext getContext() {
        return this.f27871o;
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    /* JADX INFO: renamed from: h */
    public Object mo10904h(T t, Object obj, Function1<? super Throwable, Unit> function1) {
        return m11319B(t, null, function1);
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    /* JADX INFO: renamed from: i */
    public void mo10905i(CoroutineDispatcher coroutineDispatcher, T t) {
        Continuation<T> continuation = this.f27872p;
        if (!(continuation instanceof C13024g)) {
            continuation = null;
        }
        C13024g c13024g = (C13024g) continuation;
        m11330y(t, (c13024g != null ? c13024g.f27679q : null) == coroutineDispatcher ? 4 : this.f27864l, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // p659s.p660a.AbstractC13121j0
    /* JADX INFO: renamed from: j */
    public <T> T mo11316j(Object obj) {
        return obj instanceof C13156v ? (T) ((C13156v) obj).f27906a : obj;
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    /* JADX INFO: renamed from: k */
    public boolean mo10906k(Throwable th) {
        Object obj;
        boolean z2;
        do {
            obj = this._state;
            if (!(obj instanceof InterfaceC13140p1)) {
                return false;
            }
            z2 = obj instanceof AbstractC13120j;
        } while (!f27870n.compareAndSet(this, obj, new C13132n(this, th, z2)));
        if (!z2) {
            obj = null;
        }
        AbstractC13120j abstractC13120j = (AbstractC13120j) obj;
        if (abstractC13120j != null) {
            m11321o(abstractC13120j, th);
        }
        m11324s();
        m11325t(this.f27864l);
        return true;
    }

    @Override // p659s.p660a.AbstractC13121j0
    /* JADX INFO: renamed from: m */
    public Object mo11147m() {
        return this._state;
    }

    /* JADX INFO: renamed from: n */
    public final void m11320n(Function1<? super Throwable, Unit> function1, Throwable th) {
        try {
            function1.invoke(th);
        } catch (Throwable th2) {
            C3404f.m4348u0(this.f27871o, new CompletionHandlerException("Exception in invokeOnCancellation handler for " + this, th2));
        }
    }

    /* JADX INFO: renamed from: o */
    public final void m11321o(AbstractC13120j abstractC13120j, Throwable th) {
        try {
            abstractC13120j.mo11193a(th);
        } catch (Throwable th2) {
            C3404f.m4348u0(this.f27871o, new CompletionHandlerException("Exception in invokeOnCancellation handler for " + this, th2));
        }
    }

    /* JADX INFO: renamed from: p */
    public final void m11322p(Function1<? super Throwable, Unit> function1, Throwable th) {
        try {
            function1.invoke(th);
        } catch (Throwable th2) {
            C3404f.m4348u0(this.f27871o, new CompletionHandlerException("Exception in resume onCancellation handler for " + this, th2));
        }
    }

    /* JADX INFO: renamed from: q */
    public final void m11323q() {
        InterfaceC13130m0 interfaceC13130m0 = (InterfaceC13130m0) this._parentHandle;
        if (interfaceC13130m0 != null) {
            interfaceC13130m0.dispose();
        }
        this._parentHandle = C13137o1.f27880j;
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    /* JADX INFO: renamed from: r */
    public void mo10907r(Object obj) {
        m11325t(this.f27864l);
    }

    @Override // kotlin.coroutines.Continuation
    public void resumeWith(Object obj) {
        Throwable thM11476exceptionOrNullimpl = C12112k.m11476exceptionOrNullimpl(obj);
        if (thM11476exceptionOrNullimpl != null) {
            obj = new C13159w(thM11476exceptionOrNullimpl, false, 2);
        }
        m11330y(obj, this.f27864l, null);
    }

    /* JADX INFO: renamed from: s */
    public final void m11324s() {
        if (m11328w()) {
            return;
        }
        m11323q();
    }

    /* JADX INFO: renamed from: t */
    public final void m11325t(int i) {
        boolean z2;
        while (true) {
            int i2 = this._decision;
            if (i2 != 0) {
                if (i2 != 1) {
                    throw new IllegalStateException("Already resumed".toString());
                }
                z2 = false;
                break;
            } else if (f27869m.compareAndSet(this, 0, 2)) {
                z2 = true;
                break;
            }
        }
        if (z2) {
            return;
        }
        Continuation<T> continuationMo11146d = mo11146d();
        boolean z3 = i == 4;
        if (z3 || !(continuationMo11146d instanceof C13024g) || C3404f.m4193B0(i) != C3404f.m4193B0(this.f27864l)) {
            C3404f.m4262Y0(this, continuationMo11146d, z3);
            return;
        }
        CoroutineDispatcher coroutineDispatcher = ((C13024g) continuationMo11146d).f27679q;
        CoroutineContext context = continuationMo11146d.getContext();
        if (coroutineDispatcher.isDispatchNeeded(context)) {
            coroutineDispatcher.dispatch(context, this);
            return;
        }
        C13161w1 c13161w1 = C13161w1.f27916b;
        AbstractC13142q0 abstractC13142q0M11353a = C13161w1.m11353a();
        if (abstractC13142q0M11353a.m11338N()) {
            abstractC13142q0M11353a.m11336J(this);
            return;
        }
        abstractC13142q0M11353a.m11337L(true);
        try {
            C3404f.m4262Y0(this, mo11146d(), true);
            do {
            } while (abstractC13142q0M11353a.m11340R());
        } catch (Throwable th) {
            try {
                m11317l(th, null);
            } finally {
                abstractC13142q0M11353a.m11334H(true);
            }
        }
    }

    public String toString() {
        return "CancellableContinuation(" + C3404f.m4341s1(this.f27872p) + "){" + this._state + "}@" + C3404f.m4312l0(this);
    }

    /* JADX INFO: renamed from: u */
    public final Object m11326u() {
        boolean z2;
        Job job;
        m11318A();
        while (true) {
            int i = this._decision;
            z2 = false;
            if (i != 0) {
                if (i == 2) {
                    break;
                }
                throw new IllegalStateException("Already suspended".toString());
            }
            if (f27869m.compareAndSet(this, 0, 1)) {
                z2 = true;
                break;
            }
        }
        if (z2) {
            return C12183c.getCOROUTINE_SUSPENDED();
        }
        Object obj = this._state;
        if (obj instanceof C13159w) {
            throw ((C13159w) obj).f27913b;
        }
        if (!C3404f.m4193B0(this.f27864l) || (job = (Job) this.f27871o.get(Job.INSTANCE)) == null || job.mo10910a()) {
            return mo11316j(obj);
        }
        CancellationException cancellationExceptionMo10914q = job.mo10914q();
        mo11145b(obj, cancellationExceptionMo10914q);
        throw cancellationExceptionMo10914q;
    }

    /* JADX INFO: renamed from: v */
    public boolean m11327v() {
        return !(this._state instanceof InterfaceC13140p1);
    }

    /* JADX INFO: renamed from: w */
    public final boolean m11328w() {
        Continuation<T> continuation = this.f27872p;
        if (!(continuation instanceof C13024g)) {
            return false;
        }
        Object obj = ((C13024g) continuation)._reusableCancellableContinuation;
        return obj != null && (!(obj instanceof C13126l) || obj == this);
    }

    /* JADX INFO: renamed from: x */
    public final void m11329x(Function1<? super Throwable, Unit> function1, Object obj) {
        throw new IllegalStateException(("It's prohibited to register multiple handlers, tried to register " + function1 + ", already has " + obj).toString());
    }

    /* JADX INFO: renamed from: y */
    public final void m11330y(Object obj, int i, Function1<? super Throwable, Unit> function1) {
        Object obj2;
        do {
            obj2 = this._state;
            if (!(obj2 instanceof InterfaceC13140p1)) {
                if (obj2 instanceof C13132n) {
                    C13132n c13132n = (C13132n) obj2;
                    Objects.requireNonNull(c13132n);
                    if (C13132n.f27875c.compareAndSet(c13132n, 0, 1)) {
                        if (function1 != null) {
                            m11322p(function1, c13132n.f27913b);
                            return;
                        }
                        return;
                    }
                }
                throw new IllegalStateException(C1643a.m881v("Already resumed, but proposed with update ", obj).toString());
            }
        } while (!f27870n.compareAndSet(this, obj2, m11331z((InterfaceC13140p1) obj2, obj, i, function1, null)));
        m11324s();
        m11325t(i);
    }

    /* JADX INFO: renamed from: z */
    public final Object m11331z(InterfaceC13140p1 interfaceC13140p1, Object obj, int i, Function1<? super Throwable, Unit> function1, Object obj2) {
        if (obj instanceof C13159w) {
            return obj;
        }
        if (!C3404f.m4193B0(i) && obj2 == null) {
            return obj;
        }
        if (function1 == null && ((!(interfaceC13140p1 instanceof AbstractC13120j) || (interfaceC13140p1 instanceof AbstractC13092e)) && obj2 == null)) {
            return obj;
        }
        if (!(interfaceC13140p1 instanceof AbstractC13120j)) {
            interfaceC13140p1 = null;
        }
        return new C13156v(obj, (AbstractC13120j) interfaceC13140p1, function1, obj2, null, 16);
    }
}
