package p659s.p660a;

import androidx.recyclerview.widget.RecyclerView;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CancellableContinuation;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p512d0.C11226f;
import p507d0.p592z.p594d.C12238m;
import p659s.p660a.p661a.C13019b;
import p659s.p660a.p661a.C13030m;
import p659s.p660a.p661a.C13037t;
import p659s.p660a.p661a.C13039v;
import p659s.p660a.p661a.InterfaceC13040w;

/* JADX INFO: renamed from: s.a.r0 */
/* JADX INFO: compiled from: EventLoop.common.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC13145r0 extends AbstractC13148s0 implements InterfaceC13115h0 {

    /* JADX INFO: renamed from: n */
    public static final AtomicReferenceFieldUpdater f27887n = AtomicReferenceFieldUpdater.newUpdater(AbstractC13145r0.class, Object.class, "_queue");

    /* JADX INFO: renamed from: o */
    public static final AtomicReferenceFieldUpdater f27888o = AtomicReferenceFieldUpdater.newUpdater(AbstractC13145r0.class, Object.class, "_delayed");
    public volatile Object _queue = null;
    public volatile Object _delayed = null;
    public volatile int _isCompleted = 0;

    /* JADX INFO: renamed from: s.a.r0$a */
    /* JADX INFO: compiled from: EventLoop.common.kt */
    public final class a extends c {

        /* JADX INFO: renamed from: m */
        public final CancellableContinuation<Unit> f27889m;

        /* JADX WARN: Multi-variable type inference failed */
        public a(long j, CancellableContinuation<? super Unit> cancellableContinuation) {
            super(j);
            this.f27889m = cancellableContinuation;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f27889m.mo10905i(AbstractC13145r0.this, Unit.f27425a);
        }

        @Override // p659s.p660a.AbstractC13145r0.c
        public String toString() {
            return super.toString() + this.f27889m.toString();
        }
    }

    /* JADX INFO: renamed from: s.a.r0$b */
    /* JADX INFO: compiled from: EventLoop.common.kt */
    public static final class b extends c {

        /* JADX INFO: renamed from: m */
        public final Runnable f27891m;

        public b(long j, Runnable runnable) {
            super(j);
            this.f27891m = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f27891m.run();
        }

        @Override // p659s.p660a.AbstractC13145r0.c
        public String toString() {
            return super.toString() + this.f27891m.toString();
        }
    }

    /* JADX INFO: renamed from: s.a.r0$c */
    /* JADX INFO: compiled from: EventLoop.common.kt */
    public static abstract class c implements Runnable, Comparable<c>, InterfaceC13130m0, InterfaceC13040w {

        /* JADX INFO: renamed from: j */
        public Object f27892j;

        /* JADX INFO: renamed from: k */
        public int f27893k = -1;

        /* JADX INFO: renamed from: l */
        public long f27894l;

        public c(long j) {
            this.f27894l = j;
        }

        @Override // java.lang.Comparable
        public int compareTo(c cVar) {
            long j = this.f27894l - cVar.f27894l;
            if (j > 0) {
                return 1;
            }
            return j < 0 ? -1 : 0;
        }

        @Override // p659s.p660a.InterfaceC13130m0
        public final synchronized void dispose() {
            Object obj = this.f27892j;
            C13037t c13037t = C13151t0.f27903a;
            if (obj == c13037t) {
                return;
            }
            if (!(obj instanceof d)) {
                obj = null;
            }
            d dVar = (d) obj;
            if (dVar != null) {
                synchronized (dVar) {
                    if (mo11181i() != null) {
                        dVar.m11176c(getIndex());
                    }
                }
            }
            this.f27892j = c13037t;
        }

        @Override // p659s.p660a.p661a.InterfaceC13040w
        /* JADX INFO: renamed from: f */
        public void mo11179f(int i) {
            this.f27893k = i;
        }

        @Override // p659s.p660a.p661a.InterfaceC13040w
        /* JADX INFO: renamed from: g */
        public void mo11180g(C13039v<?> c13039v) {
            if (!(this.f27892j != C13151t0.f27903a)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            this.f27892j = c13039v;
        }

        @Override // p659s.p660a.p661a.InterfaceC13040w
        public int getIndex() {
            return this.f27893k;
        }

        @Override // p659s.p660a.p661a.InterfaceC13040w
        /* JADX INFO: renamed from: i */
        public C13039v<?> mo11181i() {
            Object obj = this.f27892j;
            if (!(obj instanceof C13039v)) {
                obj = null;
            }
            return (C13039v) obj;
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("Delayed[nanos=");
            sbM833U.append(this.f27894l);
            sbM833U.append(']');
            return sbM833U.toString();
        }
    }

    /* JADX INFO: renamed from: s.a.r0$d */
    /* JADX INFO: compiled from: EventLoop.common.kt */
    public static final class d extends C13039v<c> {

        /* JADX INFO: renamed from: b */
        public long f27895b;

        public d(long j) {
            this.f27895b = j;
        }
    }

    /* JADX WARN: Code duplicated, block: B:64:0x009d  */
    /* JADX WARN: Code duplicated, block: B:78:0x00bb  */
    /* JADX WARN: Code duplicated, block: B:83:0x00c5  */
    /* JADX WARN: Code duplicated, block: B:91:0x00bc A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // p659s.p660a.AbstractC13142q0
    /* JADX INFO: renamed from: O */
    public long mo11339O() {
        long j;
        d dVar;
        c cVarM11175b;
        c cVarM11176c;
        if (m11340R()) {
            return 0L;
        }
        d dVar2 = (d) this._delayed;
        Runnable runnable = null;
        if (dVar2 != null) {
            if (!(dVar2._size == 0)) {
                long jNanoTime = System.nanoTime();
                do {
                    synchronized (dVar2) {
                        c cVarM11175b2 = dVar2.m11175b();
                        if (cVarM11175b2 != null) {
                            c cVar = cVarM11175b2;
                            cVarM11176c = ((jNanoTime - cVar.f27894l) > 0L ? 1 : ((jNanoTime - cVar.f27894l) == 0L ? 0 : -1)) >= 0 ? m11342U(cVar) : false ? dVar2.m11176c(0) : null;
                        } else {
                            cVarM11176c = null;
                        }
                    }
                } while (cVarM11176c != null);
            }
        }
        while (true) {
            Object obj = this._queue;
            if (obj == null) {
                break;
            }
            if (!(obj instanceof C13030m)) {
                if (obj == C13151t0.f27904b) {
                    break;
                }
                if (f27887n.compareAndSet(this, obj, null)) {
                    runnable = (Runnable) obj;
                    break;
                }
            } else {
                C13030m c13030m = (C13030m) obj;
                Object objM11169e = c13030m.m11169e();
                if (objM11169e != C13030m.f27692c) {
                    runnable = (Runnable) objM11169e;
                    break;
                }
                f27887n.compareAndSet(this, obj, c13030m.m11168d());
            }
        }
        if (runnable != null) {
            runnable.run();
            return 0L;
        }
        C13019b<AbstractC13121j0<?>> c13019b = this.f27886m;
        if (c13019b == null) {
            j = Long.MAX_VALUE;
        } else {
            if (c13019b.f27669b == c13019b.f27670c) {
                j = Long.MAX_VALUE;
            } else {
                j = 0;
            }
        }
        if (j == 0) {
            return 0L;
        }
        Object obj2 = this._queue;
        if (obj2 == null) {
            dVar = (d) this._delayed;
            if (dVar != null) {
                synchronized (dVar) {
                    cVarM11175b = dVar.m11175b();
                    if (cVarM11175b != null) {
                        return C11226f.coerceAtLeast(cVarM11175b.f27894l - System.nanoTime(), 0L);
                    }
                }
            }
        } else if (obj2 instanceof C13030m) {
            if (!((C13030m) obj2).m11167c()) {
                return 0L;
            }
            dVar = (d) this._delayed;
            if (dVar != null) {
                synchronized (dVar) {
                }
                cVarM11175b = dVar.m11175b();
                if (cVarM11175b != null) {
                    return C11226f.coerceAtLeast(cVarM11175b.f27894l - System.nanoTime(), 0L);
                }
            }
        } else if (obj2 != C13151t0.f27904b) {
            return 0L;
        }
        return RecyclerView.FOREVER_NS;
    }

    /* JADX INFO: renamed from: T */
    public final void m11341T(Runnable runnable) {
        if (!m11342U(runnable)) {
            RunnableC13077d0.f27779q.m11341T(runnable);
            return;
        }
        Thread threadMo11243S = mo11243S();
        if (Thread.currentThread() != threadMo11243S) {
            LockSupport.unpark(threadMo11243S);
        }
    }

    /* JADX INFO: renamed from: U */
    public final boolean m11342U(Runnable runnable) {
        while (true) {
            Object obj = this._queue;
            if (this._isCompleted != 0) {
                return false;
            }
            if (obj == null) {
                if (f27887n.compareAndSet(this, null, runnable)) {
                    return true;
                }
            } else if (obj instanceof C13030m) {
                C13030m c13030m = (C13030m) obj;
                int iM11165a = c13030m.m11165a(runnable);
                if (iM11165a == 0) {
                    return true;
                }
                if (iM11165a == 1) {
                    f27887n.compareAndSet(this, obj, c13030m.m11168d());
                } else if (iM11165a == 2) {
                    return false;
                }
            } else {
                if (obj == C13151t0.f27904b) {
                    return false;
                }
                C13030m c13030m2 = new C13030m(8, true);
                c13030m2.m11165a((Runnable) obj);
                c13030m2.m11165a(runnable);
                if (f27887n.compareAndSet(this, obj, c13030m2)) {
                    return true;
                }
            }
        }
    }

    /* JADX INFO: renamed from: V */
    public boolean m11343V() {
        C13019b<AbstractC13121j0<?>> c13019b = this.f27886m;
        if (!(c13019b == null || c13019b.f27669b == c13019b.f27670c)) {
            return false;
        }
        d dVar = (d) this._delayed;
        if (dVar != null) {
            if (!(dVar._size == 0)) {
                return false;
            }
        }
        Object obj = this._queue;
        if (obj == null) {
            return true;
        }
        if (obj instanceof C13030m) {
            return ((C13030m) obj).m11167c();
        }
        return obj == C13151t0.f27904b;
    }

    /* JADX INFO: renamed from: W */
    public final void m11344W(long j, c cVar) {
        char c2;
        Thread threadMo11243S;
        c cVarM11175b;
        c cVar2 = null;
        if (this._isCompleted == 0) {
            d dVar = (d) this._delayed;
            if (dVar == null) {
                f27888o.compareAndSet(this, null, new d(j));
                Object obj = this._delayed;
                C12238m.checkNotNull(obj);
                dVar = (d) obj;
            }
            synchronized (cVar) {
                if (cVar.f27892j == C13151t0.f27903a) {
                    c2 = 2;
                } else {
                    synchronized (dVar) {
                        c cVarM11175b2 = dVar.m11175b();
                        if (this._isCompleted != 0) {
                            c2 = 1;
                        } else {
                            if (cVarM11175b2 == null) {
                                dVar.f27895b = j;
                            } else {
                                long j2 = cVarM11175b2.f27894l;
                                if (j2 - j >= 0) {
                                    j2 = j;
                                }
                                if (j2 - dVar.f27895b > 0) {
                                    dVar.f27895b = j2;
                                }
                            }
                            long j3 = cVar.f27894l;
                            long j4 = dVar.f27895b;
                            if (j3 - j4 < 0) {
                                cVar.f27894l = j4;
                            }
                            dVar.m11174a(cVar);
                            c2 = 0;
                        }
                    }
                }
            }
        } else {
            c2 = 1;
        }
        if (c2 != 0) {
            if (c2 == 1) {
                RunnableC13077d0.f27779q.m11344W(j, cVar);
                return;
            } else {
                if (c2 != 2) {
                    throw new IllegalStateException("unexpected result".toString());
                }
                return;
            }
        }
        d dVar2 = (d) this._delayed;
        if (dVar2 != null) {
            synchronized (dVar2) {
                cVarM11175b = dVar2.m11175b();
            }
            cVar2 = cVarM11175b;
        }
        if (!(cVar2 == cVar) || Thread.currentThread() == (threadMo11243S = mo11243S())) {
            return;
        }
        LockSupport.unpark(threadMo11243S);
    }

    @Override // p659s.p660a.InterfaceC13115h0
    /* JADX INFO: renamed from: c */
    public void mo11195c(long j, CancellableContinuation<? super Unit> cancellableContinuation) {
        long jM11348a = C13151t0.m11348a(j);
        if (jM11348a < 4611686018427387903L) {
            long jNanoTime = System.nanoTime();
            a aVar = new a(jM11348a + jNanoTime, cancellableContinuation);
            cancellableContinuation.mo10902f(new C13133n0(aVar));
            m11344W(jNanoTime, aVar);
        }
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final void dispatch(CoroutineContext coroutineContext, Runnable runnable) {
        m11341T(runnable);
    }

    @Override // p659s.p660a.AbstractC13142q0
    public void shutdown() {
        c cVarM11176c;
        C13161w1 c13161w1 = C13161w1.f27916b;
        C13161w1.f27915a.set(null);
        this._isCompleted = 1;
        while (true) {
            Object obj = this._queue;
            if (obj == null) {
                if (f27887n.compareAndSet(this, null, C13151t0.f27904b)) {
                    break;
                }
            } else if (obj instanceof C13030m) {
                ((C13030m) obj).m11166b();
                break;
            } else {
                if (obj == C13151t0.f27904b) {
                    break;
                }
                C13030m c13030m = new C13030m(8, true);
                c13030m.m11165a((Runnable) obj);
                if (f27887n.compareAndSet(this, obj, c13030m)) {
                    break;
                }
            }
        }
        while (mo11339O() <= 0) {
        }
        long jNanoTime = System.nanoTime();
        while (true) {
            d dVar = (d) this._delayed;
            if (dVar == null) {
                return;
            }
            synchronized (dVar) {
                cVarM11176c = dVar._size > 0 ? dVar.m11176c(0) : null;
            }
            c cVar = cVarM11176c;
            if (cVar == null) {
                return;
            } else {
                RunnableC13077d0.f27779q.m11344W(jNanoTime, cVar);
            }
        }
    }

    /* JADX INFO: renamed from: x */
    public InterfaceC13130m0 mo11196x(long j, Runnable runnable, CoroutineContext coroutineContext) {
        return C13093e0.f27793a.mo11196x(j, runnable, coroutineContext);
    }
}
