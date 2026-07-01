package s.a;

import androidx.recyclerview.widget.RecyclerView;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CancellableContinuation;

/* JADX INFO: compiled from: EventLoop.common.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class r0 extends s0 implements h0 {
    public static final AtomicReferenceFieldUpdater n = AtomicReferenceFieldUpdater.newUpdater(r0.class, Object.class, "_queue");
    public static final AtomicReferenceFieldUpdater o = AtomicReferenceFieldUpdater.newUpdater(r0.class, Object.class, "_delayed");
    public volatile Object _queue = null;
    public volatile Object _delayed = null;
    public volatile int _isCompleted = 0;

    /* JADX WARN: Code duplicated, block: B:64:0x009d  */
    /* JADX WARN: Code duplicated, block: B:78:0x00bb  */
    /* JADX WARN: Code duplicated, block: B:83:0x00c5  */
    /* JADX WARN: Code duplicated, block: B:91:0x00bc A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // s.a.q0
    public long O() {
        long j;
        r0$d r0_d;
        r0$c r0_cB;
        r0$c r0_cC;
        if (R()) {
            return 0L;
        }
        r0$d r0_d2 = (r0$d) this._delayed;
        Runnable runnable = null;
        if (r0_d2 != null) {
            if (!(r0_d2._size == 0)) {
                long jNanoTime = System.nanoTime();
                do {
                    synchronized (r0_d2) {
                        r0$c r0_cB2 = r0_d2.b();
                        if (r0_cB2 != null) {
                            r0$c r0_c = r0_cB2;
                            r0_cC = ((jNanoTime - r0_c.l) > 0L ? 1 : ((jNanoTime - r0_c.l) == 0L ? 0 : -1)) >= 0 ? U(r0_c) : false ? r0_d2.c(0) : null;
                        } else {
                            r0_cC = null;
                        }
                    }
                } while (r0_cC != null);
            }
        }
        while (true) {
            Object obj = this._queue;
            if (obj == null) {
                break;
            }
            if (!(obj instanceof s.a.a.m)) {
                if (obj == t0.f3844b) {
                    break;
                }
                if (n.compareAndSet(this, obj, null)) {
                    runnable = (Runnable) obj;
                    break;
                }
            } else {
                s.a.a.m mVar = (s.a.a.m) obj;
                Object objE = mVar.e();
                if (objE != s.a.a.m.c) {
                    runnable = (Runnable) objE;
                    break;
                }
                n.compareAndSet(this, obj, mVar.d());
            }
        }
        if (runnable != null) {
            runnable.run();
            return 0L;
        }
        s.a.a.b<j0<?>> bVar = this.m;
        if (bVar == null) {
            j = Long.MAX_VALUE;
        } else {
            if (bVar.f3826b == bVar.c) {
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
            r0_d = (r0$d) this._delayed;
            if (r0_d != null) {
                synchronized (r0_d) {
                    r0_cB = r0_d.b();
                    if (r0_cB != null) {
                        return d0.d0.f.coerceAtLeast(r0_cB.l - System.nanoTime(), 0L);
                    }
                }
            }
        } else if (obj2 instanceof s.a.a.m) {
            if (!((s.a.a.m) obj2).c()) {
                return 0L;
            }
            r0_d = (r0$d) this._delayed;
            if (r0_d != null) {
                synchronized (r0_d) {
                }
                r0_cB = r0_d.b();
                if (r0_cB != null) {
                    return d0.d0.f.coerceAtLeast(r0_cB.l - System.nanoTime(), 0L);
                }
            }
        } else if (obj2 != t0.f3844b) {
            return 0L;
        }
        return RecyclerView.FOREVER_NS;
    }

    public final void T(Runnable runnable) {
        if (!U(runnable)) {
            d0.q.T(runnable);
            return;
        }
        Thread threadS = S();
        if (Thread.currentThread() != threadS) {
            LockSupport.unpark(threadS);
        }
    }

    public final boolean U(Runnable runnable) {
        while (true) {
            Object obj = this._queue;
            if (this._isCompleted != 0) {
                return false;
            }
            if (obj == null) {
                if (n.compareAndSet(this, null, runnable)) {
                    return true;
                }
            } else if (obj instanceof s.a.a.m) {
                s.a.a.m mVar = (s.a.a.m) obj;
                int iA = mVar.a(runnable);
                if (iA == 0) {
                    return true;
                }
                if (iA == 1) {
                    n.compareAndSet(this, obj, mVar.d());
                } else if (iA == 2) {
                    return false;
                }
            } else {
                if (obj == t0.f3844b) {
                    return false;
                }
                s.a.a.m mVar2 = new s.a.a.m(8, true);
                mVar2.a((Runnable) obj);
                mVar2.a(runnable);
                if (n.compareAndSet(this, obj, mVar2)) {
                    return true;
                }
            }
        }
    }

    public boolean V() {
        s.a.a.b<j0<?>> bVar = this.m;
        if (!(bVar == null || bVar.f3826b == bVar.c)) {
            return false;
        }
        r0$d r0_d = (r0$d) this._delayed;
        if (r0_d != null) {
            if (!(r0_d._size == 0)) {
                return false;
            }
        }
        Object obj = this._queue;
        if (obj == null) {
            return true;
        }
        if (obj instanceof s.a.a.m) {
            return ((s.a.a.m) obj).c();
        }
        return obj == t0.f3844b;
    }

    public final void W(long j, r0$c r0_c) {
        char c;
        Thread threadS;
        r0$c r0_cB;
        r0$c r0_c2 = null;
        if (this._isCompleted == 0) {
            r0$d r0_d = (r0$d) this._delayed;
            if (r0_d == null) {
                o.compareAndSet(this, null, new r0$d(j));
                Object obj = this._delayed;
                d0.z.d.m.checkNotNull(obj);
                r0_d = (r0$d) obj;
            }
            synchronized (r0_c) {
                if (r0_c.j == t0.a) {
                    c = 2;
                } else {
                    synchronized (r0_d) {
                        r0$c r0_cB2 = r0_d.b();
                        if (this._isCompleted != 0) {
                            c = 1;
                        } else {
                            if (r0_cB2 == null) {
                                r0_d.f3843b = j;
                            } else {
                                long j2 = r0_cB2.l;
                                if (j2 - j >= 0) {
                                    j2 = j;
                                }
                                if (j2 - r0_d.f3843b > 0) {
                                    r0_d.f3843b = j2;
                                }
                            }
                            long j3 = r0_c.l;
                            long j4 = r0_d.f3843b;
                            if (j3 - j4 < 0) {
                                r0_c.l = j4;
                            }
                            r0_d.a(r0_c);
                            c = 0;
                        }
                    }
                }
            }
        } else {
            c = 1;
        }
        if (c != 0) {
            if (c == 1) {
                d0.q.W(j, r0_c);
                return;
            } else {
                if (c != 2) {
                    throw new IllegalStateException("unexpected result".toString());
                }
                return;
            }
        }
        r0$d r0_d2 = (r0$d) this._delayed;
        if (r0_d2 != null) {
            synchronized (r0_d2) {
                r0_cB = r0_d2.b();
            }
            r0_c2 = r0_cB;
        }
        if (!(r0_c2 == r0_c) || Thread.currentThread() == (threadS = S())) {
            return;
        }
        LockSupport.unpark(threadS);
    }

    @Override // s.a.h0
    public void c(long j, CancellableContinuation<? super Unit> cancellableContinuation) {
        long jA = t0.a(j);
        if (jA < 4611686018427387903L) {
            long jNanoTime = System.nanoTime();
            r0$a r0_a = new r0$a(this, jA + jNanoTime, cancellableContinuation);
            cancellableContinuation.f(new n0(r0_a));
            W(jNanoTime, r0_a);
        }
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final void dispatch(CoroutineContext coroutineContext, Runnable runnable) {
        T(runnable);
    }

    @Override // s.a.q0
    public void shutdown() {
        r0$c r0_cC;
        w1 w1Var = w1.f3847b;
        w1.a.set(null);
        this._isCompleted = 1;
        while (true) {
            Object obj = this._queue;
            if (obj == null) {
                if (n.compareAndSet(this, null, t0.f3844b)) {
                    break;
                }
            } else if (obj instanceof s.a.a.m) {
                ((s.a.a.m) obj).b();
                break;
            } else {
                if (obj == t0.f3844b) {
                    break;
                }
                s.a.a.m mVar = new s.a.a.m(8, true);
                mVar.a((Runnable) obj);
                if (n.compareAndSet(this, obj, mVar)) {
                    break;
                }
            }
        }
        while (O() <= 0) {
        }
        long jNanoTime = System.nanoTime();
        while (true) {
            r0$d r0_d = (r0$d) this._delayed;
            if (r0_d == null) {
                return;
            }
            synchronized (r0_d) {
                r0_cC = r0_d._size > 0 ? r0_d.c(0) : null;
            }
            r0$c r0_c = r0_cC;
            if (r0_c == null) {
                return;
            } else {
                d0.q.W(jNanoTime, r0_c);
            }
        }
    }

    public m0 x(long j, Runnable runnable, CoroutineContext coroutineContext) {
        return e0.a.x(j, runnable, coroutineContext);
    }
}
