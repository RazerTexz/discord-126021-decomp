package s.a;

import androidx.recyclerview.widget.RecyclerView;
import b.d.b.a.outline;
import d0.d0._Ranges;
import d0.z.d.Intrinsics3;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CancellableContinuation;
import s.a.a.ArrayQueue;
import s.a.a.LockFreeTaskQueue2;
import s.a.a.Symbol3;
import s.a.a.ThreadSafeHeap;
import s.a.a.ThreadSafeHeap2;

/* JADX INFO: compiled from: EventLoop.common.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class r0 extends EventLoop2 implements Delay {
    public static final AtomicReferenceFieldUpdater n = AtomicReferenceFieldUpdater.newUpdater(r0.class, Object.class, "_queue");
    public static final AtomicReferenceFieldUpdater o = AtomicReferenceFieldUpdater.newUpdater(r0.class, Object.class, "_delayed");
    public volatile Object _queue = null;
    public volatile Object _delayed = null;
    public volatile int _isCompleted = 0;

    /* JADX INFO: compiled from: EventLoop.common.kt */
    public final class a extends c {
        public final CancellableContinuation<Unit> m;

        /* JADX WARN: Multi-variable type inference failed */
        public a(long j, CancellableContinuation<? super Unit> cancellableContinuation) {
            super(j);
            this.m = cancellableContinuation;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.m.i(r0.this, Unit.a);
        }

        @Override // s.a.r0.c
        public String toString() {
            return super.toString() + this.m.toString();
        }
    }

    /* JADX INFO: compiled from: EventLoop.common.kt */
    public static final class b extends c {
        public final Runnable m;

        public b(long j, Runnable runnable) {
            super(j);
            this.m = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.m.run();
        }

        @Override // s.a.r0.c
        public String toString() {
            return super.toString() + this.m.toString();
        }
    }

    /* JADX INFO: compiled from: EventLoop.common.kt */
    public static abstract class c implements Runnable, Comparable<c>, Job2, ThreadSafeHeap2 {
        public Object j;
        public int k = -1;
        public long l;

        public c(long j) {
            this.l = j;
        }

        @Override // java.lang.Comparable
        public int compareTo(c cVar) {
            long j = this.l - cVar.l;
            if (j > 0) {
                return 1;
            }
            return j < 0 ? -1 : 0;
        }

        @Override // s.a.Job2
        public final synchronized void dispose() {
            Object obj = this.j;
            Symbol3 symbol3 = t0.a;
            if (obj == symbol3) {
                return;
            }
            if (!(obj instanceof d)) {
                obj = null;
            }
            d dVar = (d) obj;
            if (dVar != null) {
                synchronized (dVar) {
                    if (i() != null) {
                        dVar.c(getIndex());
                    }
                }
            }
            this.j = symbol3;
        }

        @Override // s.a.a.ThreadSafeHeap2
        public void f(int i) {
            this.k = i;
        }

        @Override // s.a.a.ThreadSafeHeap2
        public void g(ThreadSafeHeap<?> threadSafeHeap) {
            if (!(this.j != t0.a)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            this.j = threadSafeHeap;
        }

        @Override // s.a.a.ThreadSafeHeap2
        public int getIndex() {
            return this.k;
        }

        @Override // s.a.a.ThreadSafeHeap2
        public ThreadSafeHeap<?> i() {
            Object obj = this.j;
            if (!(obj instanceof ThreadSafeHeap)) {
                obj = null;
            }
            return (ThreadSafeHeap) obj;
        }

        public String toString() {
            StringBuilder sbU = outline.U("Delayed[nanos=");
            sbU.append(this.l);
            sbU.append(']');
            return sbU.toString();
        }
    }

    /* JADX INFO: compiled from: EventLoop.common.kt */
    public static final class d extends ThreadSafeHeap<c> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f3843b;

        public d(long j) {
            this.f3843b = j;
        }
    }

    /* JADX WARN: Code duplicated, block: B:64:0x009d  */
    /* JADX WARN: Code duplicated, block: B:78:0x00bb  */
    /* JADX WARN: Code duplicated, block: B:83:0x00c5  */
    /* JADX WARN: Code duplicated, block: B:91:0x00bc A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // s.a.q0
    public long O() {
        long j;
        d dVar;
        c cVarB;
        c cVarC;
        if (R()) {
            return 0L;
        }
        d dVar2 = (d) this._delayed;
        Runnable runnable = null;
        if (dVar2 != null) {
            if (!(dVar2._size == 0)) {
                long jNanoTime = System.nanoTime();
                do {
                    synchronized (dVar2) {
                        c cVarB2 = dVar2.b();
                        if (cVarB2 != null) {
                            c cVar = cVarB2;
                            cVarC = ((jNanoTime - cVar.l) > 0L ? 1 : ((jNanoTime - cVar.l) == 0L ? 0 : -1)) >= 0 ? U(cVar) : false ? dVar2.c(0) : null;
                        } else {
                            cVarC = null;
                        }
                    }
                } while (cVarC != null);
            }
        }
        while (true) {
            Object obj = this._queue;
            if (obj == null) {
                break;
            }
            if (!(obj instanceof LockFreeTaskQueue2)) {
                if (obj == t0.f3844b) {
                    break;
                }
                if (n.compareAndSet(this, obj, null)) {
                    runnable = (Runnable) obj;
                    break;
                }
            } else {
                LockFreeTaskQueue2 lockFreeTaskQueue2 = (LockFreeTaskQueue2) obj;
                Object objE = lockFreeTaskQueue2.e();
                if (objE != LockFreeTaskQueue2.c) {
                    runnable = (Runnable) objE;
                    break;
                }
                n.compareAndSet(this, obj, lockFreeTaskQueue2.d());
            }
        }
        if (runnable != null) {
            runnable.run();
            return 0L;
        }
        ArrayQueue<DispatchedTask<?>> arrayQueue = this.m;
        if (arrayQueue == null) {
            j = Long.MAX_VALUE;
        } else {
            if (arrayQueue.f3826b == arrayQueue.c) {
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
                    cVarB = dVar.b();
                    if (cVarB != null) {
                        return _Ranges.coerceAtLeast(cVarB.l - System.nanoTime(), 0L);
                    }
                }
            }
        } else if (obj2 instanceof LockFreeTaskQueue2) {
            if (!((LockFreeTaskQueue2) obj2).c()) {
                return 0L;
            }
            dVar = (d) this._delayed;
            if (dVar != null) {
                synchronized (dVar) {
                }
                cVarB = dVar.b();
                if (cVarB != null) {
                    return _Ranges.coerceAtLeast(cVarB.l - System.nanoTime(), 0L);
                }
            }
        } else if (obj2 != t0.f3844b) {
            return 0L;
        }
        return RecyclerView.FOREVER_NS;
    }

    public final void T(Runnable runnable) {
        if (!U(runnable)) {
            DefaultExecutor.q.T(runnable);
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
            } else if (obj instanceof LockFreeTaskQueue2) {
                LockFreeTaskQueue2 lockFreeTaskQueue2 = (LockFreeTaskQueue2) obj;
                int iA = lockFreeTaskQueue2.a(runnable);
                if (iA == 0) {
                    return true;
                }
                if (iA == 1) {
                    n.compareAndSet(this, obj, lockFreeTaskQueue2.d());
                } else if (iA == 2) {
                    return false;
                }
            } else {
                if (obj == t0.f3844b) {
                    return false;
                }
                LockFreeTaskQueue2 lockFreeTaskQueue3 = new LockFreeTaskQueue2(8, true);
                lockFreeTaskQueue3.a((Runnable) obj);
                lockFreeTaskQueue3.a(runnable);
                if (n.compareAndSet(this, obj, lockFreeTaskQueue3)) {
                    return true;
                }
            }
        }
    }

    public boolean V() {
        ArrayQueue<DispatchedTask<?>> arrayQueue = this.m;
        if (!(arrayQueue == null || arrayQueue.f3826b == arrayQueue.c)) {
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
        if (obj instanceof LockFreeTaskQueue2) {
            return ((LockFreeTaskQueue2) obj).c();
        }
        return obj == t0.f3844b;
    }

    public final void W(long j, c cVar) {
        char c2;
        Thread threadS;
        c cVarB;
        c cVar2 = null;
        if (this._isCompleted == 0) {
            d dVar = (d) this._delayed;
            if (dVar == null) {
                o.compareAndSet(this, null, new d(j));
                Object obj = this._delayed;
                Intrinsics3.checkNotNull(obj);
                dVar = (d) obj;
            }
            synchronized (cVar) {
                if (cVar.j == t0.a) {
                    c2 = 2;
                } else {
                    synchronized (dVar) {
                        c cVarB2 = dVar.b();
                        if (this._isCompleted != 0) {
                            c2 = 1;
                        } else {
                            if (cVarB2 == null) {
                                dVar.f3843b = j;
                            } else {
                                long j2 = cVarB2.l;
                                if (j2 - j >= 0) {
                                    j2 = j;
                                }
                                if (j2 - dVar.f3843b > 0) {
                                    dVar.f3843b = j2;
                                }
                            }
                            long j3 = cVar.l;
                            long j4 = dVar.f3843b;
                            if (j3 - j4 < 0) {
                                cVar.l = j4;
                            }
                            dVar.a(cVar);
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
                DefaultExecutor.q.W(j, cVar);
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
                cVarB = dVar2.b();
            }
            cVar2 = cVarB;
        }
        if (!(cVar2 == cVar) || Thread.currentThread() == (threadS = S())) {
            return;
        }
        LockSupport.unpark(threadS);
    }

    @Override // s.a.Delay
    public void c(long j, CancellableContinuation<? super Unit> cancellableContinuation) {
        long jA = t0.a(j);
        if (jA < 4611686018427387903L) {
            long jNanoTime = System.nanoTime();
            a aVar = new a(jA + jNanoTime, cancellableContinuation);
            cancellableContinuation.f(new CancellableContinuation2(aVar));
            W(jNanoTime, aVar);
        }
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final void dispatch(CoroutineContext coroutineContext, Runnable runnable) {
        T(runnable);
    }

    @Override // s.a.q0
    public void shutdown() {
        c cVarC;
        w1 w1Var = w1.f3847b;
        w1.a.set(null);
        this._isCompleted = 1;
        while (true) {
            Object obj = this._queue;
            if (obj == null) {
                if (n.compareAndSet(this, null, t0.f3844b)) {
                    break;
                }
            } else if (obj instanceof LockFreeTaskQueue2) {
                ((LockFreeTaskQueue2) obj).b();
                break;
            } else {
                if (obj == t0.f3844b) {
                    break;
                }
                LockFreeTaskQueue2 lockFreeTaskQueue2 = new LockFreeTaskQueue2(8, true);
                lockFreeTaskQueue2.a((Runnable) obj);
                if (n.compareAndSet(this, obj, lockFreeTaskQueue2)) {
                    break;
                }
            }
        }
        while (O() <= 0) {
        }
        long jNanoTime = System.nanoTime();
        while (true) {
            d dVar = (d) this._delayed;
            if (dVar == null) {
                return;
            }
            synchronized (dVar) {
                cVarC = dVar._size > 0 ? dVar.c(0) : null;
            }
            c cVar = cVarC;
            if (cVar == null) {
                return;
            } else {
                DefaultExecutor.q.W(jNanoTime, cVar);
            }
        }
    }

    public Job2 x(long j, Runnable runnable, CoroutineContext coroutineContext) {
        return DefaultExecutor2.a.x(j, runnable, coroutineContext);
    }
}
