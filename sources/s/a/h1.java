package s.a;

import b.d.b.a.a;
import com.discord.widgets.chat.input.MentionUtilsKt;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.CoroutineContext$Element;
import kotlin.coroutines.CoroutineContext$Element$a;
import kotlin.coroutines.CoroutineContext$Key;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.Sequence;
import kotlinx.coroutines.CompletionHandlerException;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobCancellationException;
import kotlinx.coroutines.TimeoutCancellationException;

/* JADX INFO: compiled from: JobSupport.kt */
/* JADX INFO: loaded from: classes3.dex */
public class h1 implements Job, r, q1 {
    public static final AtomicReferenceFieldUpdater j = AtomicReferenceFieldUpdater.newUpdater(h1.class, Object.class, "_state");
    public volatile Object _parentHandle;
    public volatile Object _state;

    public h1(boolean z2) {
        this._state = z2 ? i1.g : i1.f;
        this._parentHandle = null;
    }

    public static /* synthetic */ CancellationException b0(h1 h1Var, Throwable th, String str, int i, Object obj) {
        int i2 = i & 1;
        return h1Var.a0(th, null);
    }

    @Override // s.a.q1
    public CancellationException A() {
        Throwable th;
        Object objM = M();
        if (objM instanceof h1$b) {
            th = (Throwable) ((h1$b) objM)._rootCause;
        } else if (objM instanceof w) {
            th = ((w) objM).f3846b;
        } else {
            if (objM instanceof z0) {
                throw new IllegalStateException(a.v("Cannot be cancelling child in this state: ", objM).toString());
            }
            th = null;
        }
        CancellationException cancellationException = (CancellationException) (th instanceof CancellationException ? th : null);
        if (cancellationException != null) {
            return cancellationException;
        }
        StringBuilder sbU = a.U("Parent job is ");
        sbU.append(Z(objM));
        return new JobCancellationException(sbU.toString(), th, this);
    }

    public String B() {
        return "Job was cancelled";
    }

    @Override // kotlinx.coroutines.Job
    public final p D(r rVar) {
        m0 m0VarW0 = b.i.a.f.e.o.f.w0(this, true, false, new q(this, rVar), 2, null);
        Objects.requireNonNull(m0VarW0, "null cannot be cast to non-null type kotlinx.coroutines.ChildHandle");
        return (p) m0VarW0;
    }

    public boolean E(Throwable th) {
        if (th instanceof CancellationException) {
            return true;
        }
        return w(th) && J();
    }

    public final void F(z0 z0Var, Object obj) throws Throwable {
        p pVar = (p) this._parentHandle;
        if (pVar != null) {
            pVar.dispose();
            this._parentHandle = o1.j;
        }
        CompletionHandlerException completionHandlerException = null;
        if (!(obj instanceof w)) {
            obj = null;
        }
        w wVar = (w) obj;
        Throwable th = wVar != null ? wVar.f3846b : null;
        if (z0Var instanceof g1) {
            try {
                ((g1) z0Var).q(th);
                return;
            } catch (Throwable th2) {
                O(new CompletionHandlerException("Exception in completion handler " + z0Var + " for " + this, th2));
                return;
            }
        }
        m1 list = z0Var.getList();
        if (list != null) {
            Object objI = list.i();
            Objects.requireNonNull(objI, "null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
            for (s.a.a.k kVarJ = (s.a.a.k) objI; !d0.z.d.m.areEqual(kVarJ, list); kVarJ = kVarJ.j()) {
                if (kVarJ instanceof g1) {
                    g1 g1Var = (g1) kVarJ;
                    try {
                        g1Var.q(th);
                    } catch (Throwable th3) {
                        if (completionHandlerException != null) {
                            d0.b.addSuppressed(completionHandlerException, th3);
                        } else {
                            completionHandlerException = new CompletionHandlerException("Exception in completion handler " + g1Var + " for " + this, th3);
                        }
                    }
                }
            }
            if (completionHandlerException != null) {
                O(completionHandlerException);
            }
        }
    }

    public final Throwable G(Object obj) {
        if (obj != null ? obj instanceof Throwable : true) {
            return obj != null ? (Throwable) obj : new JobCancellationException(B(), null, this);
        }
        Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.ParentJob");
        return ((q1) obj).A();
    }

    public final Object H(h1$b h1_b, Object obj) throws Throwable {
        Throwable thI;
        w wVar = (w) (!(obj instanceof w) ? null : obj);
        Throwable th = wVar != null ? wVar.f3846b : null;
        synchronized (h1_b) {
            h1_b.d();
            List<Throwable> listF = h1_b.f(th);
            thI = I(h1_b, listF);
            if (thI != null && listF.size() > 1) {
                Set setNewSetFromMap = Collections.newSetFromMap(new IdentityHashMap(listF.size()));
                for (Throwable th2 : listF) {
                    if (th2 != thI && th2 != thI && !(th2 instanceof CancellationException) && setNewSetFromMap.add(th2)) {
                        d0.b.addSuppressed(thI, th2);
                    }
                }
            }
        }
        if (thI != null && thI != th) {
            obj = new w(thI, false, 2);
        }
        if (thI != null) {
            if (z(thI) || N(thI)) {
                Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.CompletedExceptionally");
                w.a.compareAndSet((w) obj, 0, 1);
            }
        }
        W(obj);
        j.compareAndSet(this, h1_b, obj instanceof z0 ? new a1((z0) obj) : obj);
        F(h1_b, obj);
        return obj;
    }

    public final Throwable I(h1$b h1_b, List<? extends Throwable> list) {
        Object next;
        Object obj = null;
        if (list.isEmpty()) {
            if (h1_b.d()) {
                return new JobCancellationException(B(), null, this);
            }
            return null;
        }
        Iterator<T> it = list.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!(!(((Throwable) next) instanceof CancellationException)));
        Throwable th = (Throwable) next;
        if (th != null) {
            return th;
        }
        Throwable th2 = list.get(0);
        if (th2 instanceof TimeoutCancellationException) {
            for (Object obj2 : list) {
                Throwable th3 = (Throwable) obj2;
                if (th3 != th2 && (th3 instanceof TimeoutCancellationException)) {
                    obj = obj2;
                    break;
                }
            }
            Throwable th4 = (Throwable) obj;
            if (th4 != null) {
                return th4;
            }
        }
        return th2;
    }

    public boolean J() {
        return true;
    }

    public boolean K() {
        return false;
    }

    public final m1 L(z0 z0Var) {
        m1 list = z0Var.getList();
        if (list != null) {
            return list;
        }
        if (z0Var instanceof p0) {
            return new m1();
        }
        if (z0Var instanceof g1) {
            Y((g1) z0Var);
            return null;
        }
        throw new IllegalStateException(("State should have list: " + z0Var).toString());
    }

    public final Object M() {
        while (true) {
            Object obj = this._state;
            if (!(obj instanceof s.a.a.p)) {
                return obj;
            }
            ((s.a.a.p) obj).a(this);
        }
    }

    public boolean N(Throwable th) {
        return false;
    }

    public void O(Throwable th) throws Throwable {
        throw th;
    }

    public final void P(Job job) {
        if (job == null) {
            this._parentHandle = o1.j;
            return;
        }
        job.start();
        p pVarD = job.D(this);
        this._parentHandle = pVarD;
        if (!(M() instanceof z0)) {
            pVarD.dispose();
            this._parentHandle = o1.j;
        }
    }

    public boolean Q() {
        return this instanceof f;
    }

    public final Object R(Object obj) throws Throwable {
        Object objC0;
        do {
            objC0 = c0(M(), obj);
            if (objC0 == i1.a) {
                String str = "Job " + this + " is already complete or completing, but is being completed with " + obj;
                if (!(obj instanceof w)) {
                    obj = null;
                }
                w wVar = (w) obj;
                throw new IllegalStateException(str, wVar != null ? wVar.f3846b : null);
            }
        } while (objC0 == i1.c);
        return objC0;
    }

    public final g1<?> S(Function1<? super Throwable, Unit> function1, boolean z2) {
        if (z2) {
            e1 e1Var = (e1) (function1 instanceof e1 ? function1 : null);
            return e1Var != null ? e1Var : new c1(this, function1);
        }
        g1<?> g1Var = (g1) (function1 instanceof g1 ? function1 : null);
        return g1Var != null ? g1Var : new d1(this, function1);
    }

    public String T() {
        return getClass().getSimpleName();
    }

    public final q U(s.a.a.k kVar) {
        while (kVar.m()) {
            kVar = kVar.k();
        }
        while (true) {
            kVar = kVar.j();
            if (!kVar.m()) {
                if (kVar instanceof q) {
                    return (q) kVar;
                }
                if (kVar instanceof m1) {
                    return null;
                }
            }
        }
    }

    public final void V(m1 m1Var, Throwable th) throws Throwable {
        CompletionHandlerException completionHandlerException = null;
        Object objI = m1Var.i();
        Objects.requireNonNull(objI, "null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
        for (s.a.a.k kVarJ = (s.a.a.k) objI; !d0.z.d.m.areEqual(kVarJ, m1Var); kVarJ = kVarJ.j()) {
            if (kVarJ instanceof e1) {
                g1 g1Var = (g1) kVarJ;
                try {
                    g1Var.q(th);
                } catch (Throwable th2) {
                    if (completionHandlerException != null) {
                        d0.b.addSuppressed(completionHandlerException, th2);
                    } else {
                        completionHandlerException = new CompletionHandlerException("Exception in completion handler " + g1Var + " for " + this, th2);
                    }
                }
            }
        }
        if (completionHandlerException != null) {
            O(completionHandlerException);
        }
        z(th);
    }

    public void W(Object obj) {
    }

    public void X() {
    }

    public final void Y(g1<?> g1Var) {
        m1 m1Var = new m1();
        s.a.a.k.k.lazySet(m1Var, g1Var);
        s.a.a.k.j.lazySet(m1Var, g1Var);
        while (g1Var.i() == g1Var) {
            if (s.a.a.k.j.compareAndSet(g1Var, g1Var, m1Var)) {
                m1Var.g(g1Var);
                break;
            }
        }
        j.compareAndSet(this, g1Var, g1Var.j());
    }

    public final String Z(Object obj) {
        if (!(obj instanceof h1$b)) {
            if (obj instanceof z0) {
                return ((z0) obj).a() ? "Active" : "New";
            }
            return obj instanceof w ? "Cancelled" : "Completed";
        }
        h1$b h1_b = (h1$b) obj;
        if (h1_b.d()) {
            return "Cancelling";
        }
        return h1_b._isCompleting != 0 ? "Completing" : "Active";
    }

    @Override // kotlinx.coroutines.Job
    public boolean a() {
        Object objM = M();
        return (objM instanceof z0) && ((z0) objM).a();
    }

    public final CancellationException a0(Throwable th, String str) {
        CancellationException jobCancellationException = (CancellationException) (!(th instanceof CancellationException) ? null : th);
        if (jobCancellationException == null) {
            if (str == null) {
                str = B();
            }
            jobCancellationException = new JobCancellationException(str, th, this);
        }
        return jobCancellationException;
    }

    @Override // kotlinx.coroutines.Job
    public void b(CancellationException cancellationException) throws Throwable {
        if (cancellationException == null) {
            cancellationException = new JobCancellationException(B(), null, this);
        }
        x(cancellationException);
    }

    public final Object c0(Object obj, Object obj2) throws Throwable {
        if (!(obj instanceof z0)) {
            return i1.a;
        }
        boolean z2 = true;
        if (((obj instanceof p0) || (obj instanceof g1)) && !(obj instanceof q) && !(obj2 instanceof w)) {
            z0 z0Var = (z0) obj;
            if (j.compareAndSet(this, z0Var, obj2 instanceof z0 ? new a1((z0) obj2) : obj2)) {
                W(obj2);
                F(z0Var, obj2);
            } else {
                z2 = false;
            }
            return z2 ? obj2 : i1.c;
        }
        z0 z0Var2 = (z0) obj;
        m1 m1VarL = L(z0Var2);
        if (m1VarL == null) {
            return i1.c;
        }
        q qVarU = null;
        h1$b h1_b = (h1$b) (!(z0Var2 instanceof h1$b) ? null : z0Var2);
        if (h1_b == null) {
            h1_b = new h1$b(m1VarL, false, null);
        }
        synchronized (h1_b) {
            if (h1_b._isCompleting != 0) {
                return i1.a;
            }
            h1_b._isCompleting = 1;
            if (h1_b != z0Var2 && !j.compareAndSet(this, z0Var2, h1_b)) {
                return i1.c;
            }
            boolean zD = h1_b.d();
            w wVar = (w) (!(obj2 instanceof w) ? null : obj2);
            if (wVar != null) {
                h1_b.b(wVar.f3846b);
            }
            Throwable th = (Throwable) h1_b._rootCause;
            if (!(true ^ zD)) {
                th = null;
            }
            if (th != null) {
                V(m1VarL, th);
            }
            q qVar = (q) (!(z0Var2 instanceof q) ? null : z0Var2);
            if (qVar != null) {
                qVarU = qVar;
            } else {
                m1 list = z0Var2.getList();
                if (list != null) {
                    qVarU = U(list);
                }
            }
            return (qVarU == null || !d0(h1_b, qVarU, obj2)) ? H(h1_b, obj2) : i1.f3841b;
        }
    }

    public final boolean d0(h1$b h1_b, q qVar, Object obj) {
        while (b.i.a.f.e.o.f.w0(qVar.n, false, false, new h1$a(this, h1_b, qVar, obj), 1, null) == o1.j) {
            qVar = U(qVar);
            if (qVar == null) {
                return false;
            }
        }
        return true;
    }

    @Override // kotlinx.coroutines.Job
    public final Sequence<Job> e() {
        return d0.f0.l.sequence(new h1$d(this, null));
    }

    @Override // kotlin.coroutines.CoroutineContext
    public <R> R fold(R r, Function2<? super R, ? super CoroutineContext$Element, ? extends R> function2) {
        return (R) CoroutineContext$Element$a.fold(this, r, function2);
    }

    @Override // kotlin.coroutines.CoroutineContext$Element, kotlin.coroutines.CoroutineContext
    public <E extends CoroutineContext$Element> E get(CoroutineContext$Key<E> coroutineContext$Key) {
        return (E) CoroutineContext$Element$a.get(this, coroutineContext$Key);
    }

    @Override // kotlin.coroutines.CoroutineContext$Element
    public final CoroutineContext$Key<?> getKey() {
        return Job.h;
    }

    @Override // kotlin.coroutines.CoroutineContext
    public CoroutineContext minusKey(CoroutineContext$Key<?> coroutineContext$Key) {
        return CoroutineContext$Element$a.minusKey(this, coroutineContext$Key);
    }

    /* JADX WARN: Code duplicated, block: B:53:0x008a  */
    /* JADX WARN: Code duplicated, block: B:55:0x008e A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:57:0x0091  */
    /* JADX WARN: Code duplicated, block: B:83:0x0088 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:84:0x009b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:91:0x0002 A[SYNTHETIC] */
    @Override // kotlinx.coroutines.Job
    public final m0 n(boolean z2, boolean z3, Function1<? super Throwable, Unit> function1) {
        Throwable th;
        g1<?> g1VarS = null;
        while (true) {
            Object objM = M();
            if (objM instanceof p0) {
                p0 p0Var = (p0) objM;
                if (p0Var.j) {
                    if (g1VarS == null) {
                        g1VarS = S(function1, z2);
                    }
                    if (j.compareAndSet(this, objM, g1VarS)) {
                        return g1VarS;
                    }
                } else {
                    m1 m1Var = new m1();
                    Object y0Var = m1Var;
                    if (!p0Var.j) {
                        y0Var = new y0(m1Var);
                    }
                    j.compareAndSet(this, p0Var, y0Var);
                }
            } else {
                if (!(objM instanceof z0)) {
                    if (z3) {
                        if (!(objM instanceof w)) {
                            objM = null;
                        }
                        w wVar = (w) objM;
                        function1.invoke(wVar != null ? wVar.f3846b : null);
                    }
                    return o1.j;
                }
                m1 list = ((z0) objM).getList();
                if (list == null) {
                    Objects.requireNonNull(objM, "null cannot be cast to non-null type kotlinx.coroutines.JobNode<*>");
                    Y((g1) objM);
                } else {
                    m0 m0Var = o1.j;
                    if (z2 && (objM instanceof h1$b)) {
                        synchronized (objM) {
                            th = (Throwable) ((h1$b) objM)._rootCause;
                            if (th == null || ((function1 instanceof q) && ((h1$b) objM)._isCompleting == 0)) {
                                if (g1VarS == null) {
                                    g1VarS = S(function1, z2);
                                }
                                if (t(objM, list, g1VarS)) {
                                    if (th == null) {
                                        return g1VarS;
                                    }
                                    m0Var = g1VarS;
                                }
                            }
                        }
                        if (th != null) {
                            if (z3) {
                                function1.invoke(th);
                            }
                            return m0Var;
                        }
                        if (g1VarS == null) {
                            g1VarS = S(function1, z2);
                        }
                        if (t(objM, list, g1VarS)) {
                            return g1VarS;
                        }
                    } else {
                        th = null;
                        if (th != null) {
                            if (z3) {
                                function1.invoke(th);
                            }
                            return m0Var;
                        }
                        if (g1VarS == null) {
                            g1VarS = S(function1, z2);
                        }
                        if (t(objM, list, g1VarS)) {
                            return g1VarS;
                        }
                    }
                }
            }
        }
    }

    @Override // kotlin.coroutines.CoroutineContext
    public CoroutineContext plus(CoroutineContext coroutineContext) {
        return CoroutineContext$Element$a.plus(this, coroutineContext);
    }

    @Override // kotlinx.coroutines.Job
    public final CancellationException q() {
        Object objM = M();
        if (objM instanceof h1$b) {
            Throwable th = (Throwable) ((h1$b) objM)._rootCause;
            if (th != null) {
                return a0(th, getClass().getSimpleName() + " is cancelling");
            }
            throw new IllegalStateException(("Job is still new or active: " + this).toString());
        }
        if (objM instanceof z0) {
            throw new IllegalStateException(("Job is still new or active: " + this).toString());
        }
        if (objM instanceof w) {
            return b0(this, ((w) objM).f3846b, null, 1, null);
        }
        return new JobCancellationException(getClass().getSimpleName() + " has completed normally", null, this);
    }

    @Override // s.a.r
    public final void s(q1 q1Var) throws Throwable {
        w(q1Var);
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0039  */
    @Override // kotlinx.coroutines.Job
    public final boolean start() {
        byte b2;
        do {
            Object objM = M();
            b2 = -1;
            if (objM instanceof p0) {
                if (((p0) objM).j) {
                    b2 = 0;
                } else if (j.compareAndSet(this, objM, i1.g)) {
                    X();
                    b2 = 1;
                }
            } else if (!(objM instanceof y0)) {
                b2 = 0;
            } else if (j.compareAndSet(this, objM, ((y0) objM).j)) {
                X();
                b2 = 1;
            }
            if (b2 == 0) {
                return false;
            }
        } while (b2 != 1);
        return true;
    }

    public final boolean t(Object obj, m1 m1Var, g1<?> g1Var) {
        int iP;
        h1$c h1_c = new h1$c(g1Var, g1Var, this, obj);
        do {
            iP = m1Var.k().p(g1Var, m1Var, h1_c);
            if (iP == 1) {
                return true;
            }
        } while (iP != 2);
        return false;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(T() + '{' + Z(M()) + '}');
        sb.append(MentionUtilsKt.MENTIONS_CHAR);
        sb.append(b.i.a.f.e.o.f.l0(this));
        return sb.toString();
    }

    @Override // kotlinx.coroutines.Job
    public final m0 u(Function1<? super Throwable, Unit> function1) {
        return n(false, true, function1);
    }

    public void v(Object obj) {
    }

    /* JADX WARN: Code duplicated, block: B:60:0x00b6  */
    public final boolean w(Object obj) throws Throwable {
        s.a.a.t tVar;
        boolean z2;
        Object objC0 = i1.a;
        if (K()) {
            do {
                Object objM = M();
                if (!(objM instanceof z0) || ((objM instanceof h1$b) && ((h1$b) objM)._isCompleting != 0)) {
                    objC0 = i1.a;
                    break;
                }
                objC0 = c0(objM, new w(G(obj), false, 2));
            } while (objC0 == i1.c);
            if (objC0 == i1.f3841b) {
                return true;
            }
        }
        if (objC0 == i1.a) {
            Throwable thG = null;
            while (true) {
                Object objM2 = M();
                if (objM2 instanceof h1$b) {
                    synchronized (objM2) {
                        if (((h1$b) objM2).e()) {
                            tVar = i1.d;
                        } else {
                            boolean zD = ((h1$b) objM2).d();
                            if (obj != null || !zD) {
                                if (thG == null) {
                                    thG = G(obj);
                                }
                                ((h1$b) objM2).b(thG);
                            }
                            Throwable th = zD ^ true ? (Throwable) ((h1$b) objM2)._rootCause : null;
                            if (th != null) {
                                V(((h1$b) objM2).j, th);
                            }
                            tVar = i1.a;
                        }
                    }
                } else if (objM2 instanceof z0) {
                    if (thG == null) {
                        thG = G(obj);
                    }
                    z0 z0Var = (z0) objM2;
                    if (z0Var.a()) {
                        m1 m1VarL = L(z0Var);
                        if (m1VarL != null) {
                            if (j.compareAndSet(this, z0Var, new h1$b(m1VarL, false, thG))) {
                                V(m1VarL, thG);
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                        } else {
                            z2 = false;
                        }
                        if (z2) {
                            tVar = i1.a;
                        }
                    } else {
                        Object objC1 = c0(objM2, new w(thG, false, 2));
                        if (objC1 == i1.a) {
                            throw new IllegalStateException(a.v("Cannot happen in ", objM2).toString());
                        }
                        if (objC1 != i1.c) {
                            objC0 = objC1;
                            break;
                        }
                    }
                } else {
                    tVar = i1.d;
                }
                objC0 = tVar;
                break;
            }
        }
        if (objC0 != i1.a && objC0 != i1.f3841b) {
            if (objC0 == i1.d) {
                return false;
            }
            v(objC0);
        }
        return true;
    }

    public void x(Throwable th) throws Throwable {
        w(th);
    }

    public final boolean z(Throwable th) {
        if (Q()) {
            return true;
        }
        boolean z2 = th instanceof CancellationException;
        p pVar = (p) this._parentHandle;
        if (pVar == null || pVar == o1.j) {
            return z2;
        }
        return pVar.h(th) || z2;
    }
}
