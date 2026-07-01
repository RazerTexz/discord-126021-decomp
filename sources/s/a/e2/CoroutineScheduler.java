package s.a.e2;

import androidx.recyclerview.widget.RecyclerView;
import b.d.b.a.outline;
import com.discord.api.permission.Permission;
import com.discord.widgets.chat.input.MentionUtils;
import d0.c0.Random;
import d0.d0._Ranges;
import d0.z.d.Intrinsics3;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.locks.LockSupport;
import org.objectweb.asm.Opcodes;
import s.a.a.Symbol3;

/* JADX INFO: renamed from: s.a.e2.a, reason: use source file name */
/* JADX INFO: compiled from: CoroutineScheduler.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class CoroutineScheduler implements Executor, Closeable {
    public volatile int _isTerminated;
    public volatile long controlState;
    public final Tasks n;
    public final Tasks o;
    public final AtomicReferenceArray<a> p;
    public volatile long parkedWorkersStack;
    public final int q;
    public final int r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final long f3838s;
    public final String t;
    public static final Symbol3 m = new Symbol3("NOT_IN_STACK");
    public static final AtomicLongFieldUpdater j = AtomicLongFieldUpdater.newUpdater(CoroutineScheduler.class, "parkedWorkersStack");
    public static final AtomicLongFieldUpdater k = AtomicLongFieldUpdater.newUpdater(CoroutineScheduler.class, "controlState");
    public static final AtomicIntegerFieldUpdater l = AtomicIntegerFieldUpdater.newUpdater(CoroutineScheduler.class, "_isTerminated");

    /* JADX INFO: renamed from: s.a.e2.a$a */
    /* JADX INFO: compiled from: CoroutineScheduler.kt */
    public final class a extends Thread {
        public static final AtomicIntegerFieldUpdater j = AtomicIntegerFieldUpdater.newUpdater(a.class, "workerCtl");
        public volatile int indexInArray;
        public final WorkQueue k;
        public int l;
        public long m;
        public long n;
        public volatile Object nextParkedWorker;
        public int o;
        public boolean p;
        public volatile int workerCtl;

        public a(int i) {
            setDaemon(true);
            this.k = new WorkQueue();
            this.l = 4;
            this.workerCtl = 0;
            this.nextParkedWorker = CoroutineScheduler.m;
            this.o = Random.k.nextInt();
            d(i);
        }

        public final Tasks4 a(boolean z2) {
            boolean z3;
            Tasks4 tasks4D;
            Tasks4 tasks4C;
            Tasks4 tasks4C2;
            boolean z4;
            if (this.l == 1) {
                z3 = true;
            } else {
                CoroutineScheduler coroutineScheduler = CoroutineScheduler.this;
                while (true) {
                    long j2 = coroutineScheduler.controlState;
                    if (((int) ((9223367638808264704L & j2) >> 42)) == 0) {
                        z4 = false;
                        break;
                    }
                    if (CoroutineScheduler.k.compareAndSet(coroutineScheduler, j2, j2 - 4398046511104L)) {
                        z4 = true;
                        break;
                    }
                }
                if (z4) {
                    this.l = 1;
                    z3 = true;
                } else {
                    z3 = false;
                }
            }
            if (!z3) {
                if (!z2 || (tasks4D = this.k.e()) == null) {
                    tasks4D = CoroutineScheduler.this.o.d();
                }
                return tasks4D != null ? tasks4D : f(true);
            }
            if (z2) {
                boolean z5 = b(CoroutineScheduler.this.q * 2) == 0;
                if (z5 && (tasks4C2 = c()) != null) {
                    return tasks4C2;
                }
                Tasks4 tasks4E = this.k.e();
                if (tasks4E != null) {
                    return tasks4E;
                }
                if (!z5 && (tasks4C = c()) != null) {
                    return tasks4C;
                }
            } else {
                Tasks4 tasks4C3 = c();
                if (tasks4C3 != null) {
                    return tasks4C3;
                }
            }
            return f(false);
        }

        public final int b(int i) {
            int i2 = this.o;
            int i3 = i2 ^ (i2 << 13);
            int i4 = i3 ^ (i3 >> 17);
            int i5 = i4 ^ (i4 << 5);
            this.o = i5;
            int i6 = i - 1;
            return (i6 & i) == 0 ? i5 & i6 : (i5 & Integer.MAX_VALUE) % i;
        }

        public final Tasks4 c() {
            if (b(2) == 0) {
                Tasks4 tasks4D = CoroutineScheduler.this.n.d();
                return tasks4D != null ? tasks4D : CoroutineScheduler.this.o.d();
            }
            Tasks4 tasks4D2 = CoroutineScheduler.this.o.d();
            return tasks4D2 != null ? tasks4D2 : CoroutineScheduler.this.n.d();
        }

        public final void d(int i) {
            StringBuilder sb = new StringBuilder();
            sb.append(CoroutineScheduler.this.t);
            sb.append("-worker-");
            sb.append(i == 0 ? "TERMINATED" : String.valueOf(i));
            setName(sb.toString());
            this.indexInArray = i;
        }

        public final boolean e(int i) {
            int i2 = this.l;
            boolean z2 = i2 == 1;
            if (z2) {
                CoroutineScheduler.k.addAndGet(CoroutineScheduler.this, 4398046511104L);
            }
            if (i2 != i) {
                this.l = i;
            }
            return z2;
        }

        public final Tasks4 f(boolean z2) {
            long jG;
            int i = (int) (CoroutineScheduler.this.controlState & 2097151);
            if (i < 2) {
                return null;
            }
            int iB = b(i);
            long jMin = RecyclerView.FOREVER_NS;
            for (int i2 = 0; i2 < i; i2++) {
                iB++;
                if (iB > i) {
                    iB = 1;
                }
                a aVar = CoroutineScheduler.this.p.get(iB);
                if (aVar != null && aVar != this) {
                    if (z2) {
                        WorkQueue workQueue = this.k;
                        WorkQueue workQueue2 = aVar.k;
                        Objects.requireNonNull(workQueue);
                        int i3 = workQueue2.consumerIndex;
                        int i4 = workQueue2.producerIndex;
                        AtomicReferenceArray<Tasks4> atomicReferenceArray = workQueue2.e;
                        while (true) {
                            if (i3 != i4) {
                                int i5 = i3 & Opcodes.LAND;
                                if (workQueue2.blockingTasksInBuffer != 0) {
                                    Tasks4 tasks4 = atomicReferenceArray.get(i5);
                                    if (tasks4 != null) {
                                        if ((tasks4.k.t() == 1) && atomicReferenceArray.compareAndSet(i5, tasks4, null)) {
                                            WorkQueue.d.decrementAndGet(workQueue2);
                                            workQueue.a(tasks4, false);
                                            jG = -1;
                                            break;
                                        }
                                    }
                                    i3++;
                                }
                            }
                            jG = workQueue.g(workQueue2, true);
                            break;
                        }
                    } else {
                        WorkQueue workQueue3 = this.k;
                        WorkQueue workQueue4 = aVar.k;
                        Objects.requireNonNull(workQueue3);
                        Tasks4 tasks4F = workQueue4.f();
                        if (tasks4F != null) {
                            workQueue3.a(tasks4F, false);
                            jG = -1;
                        } else {
                            jG = workQueue3.g(workQueue4, false);
                        }
                    }
                    if (jG == -1) {
                        return this.k.e();
                    }
                    if (jG > 0) {
                        jMin = Math.min(jMin, jG);
                    }
                }
            }
            if (jMin == RecyclerView.FOREVER_NS) {
                jMin = 0;
            }
            this.n = jMin;
            return null;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            long j2;
            long j3;
            int i;
            loop0: while (true) {
                boolean z2 = false;
                while (true) {
                    if (CoroutineScheduler.this._isTerminated != 0 || this.l == 5) {
                        break loop0;
                    }
                    Tasks4 tasks4A = a(this.p);
                    if (tasks4A != null) {
                        this.n = 0L;
                        int iT = tasks4A.k.t();
                        this.m = 0L;
                        if (this.l == 3) {
                            this.l = 2;
                        }
                        if (iT != 0 && e(2)) {
                            CoroutineScheduler.this.s();
                        }
                        CoroutineScheduler.this.q(tasks4A);
                        if (iT != 0) {
                            CoroutineScheduler.k.addAndGet(CoroutineScheduler.this, -2097152L);
                            if (this.l == 5) {
                                break;
                            }
                            this.l = 4;
                            break;
                        }
                        break;
                    }
                    this.p = false;
                    if (this.n == 0) {
                        Object obj = this.nextParkedWorker;
                        Symbol3 symbol3 = CoroutineScheduler.m;
                        if (obj != symbol3) {
                            this.workerCtl = -1;
                            while (true) {
                                if (!(this.nextParkedWorker != CoroutineScheduler.m) || CoroutineScheduler.this._isTerminated != 0 || this.l == 5) {
                                    break;
                                }
                                e(3);
                                Thread.interrupted();
                                if (this.m == 0) {
                                    this.m = System.nanoTime() + CoroutineScheduler.this.f3838s;
                                }
                                LockSupport.parkNanos(CoroutineScheduler.this.f3838s);
                                if (System.nanoTime() - this.m >= 0) {
                                    this.m = 0L;
                                    synchronized (CoroutineScheduler.this.p) {
                                        if (CoroutineScheduler.this._isTerminated == 0) {
                                            if (((int) (CoroutineScheduler.this.controlState & 2097151)) > CoroutineScheduler.this.q) {
                                                if (j.compareAndSet(this, -1, 1)) {
                                                    int i2 = this.indexInArray;
                                                    d(0);
                                                    CoroutineScheduler.this.n(this, i2, 0);
                                                    int andDecrement = (int) (CoroutineScheduler.k.getAndDecrement(CoroutineScheduler.this) & 2097151);
                                                    if (andDecrement != i2) {
                                                        a aVar = CoroutineScheduler.this.p.get(andDecrement);
                                                        Intrinsics3.checkNotNull(aVar);
                                                        a aVar2 = aVar;
                                                        CoroutineScheduler.this.p.set(i2, aVar2);
                                                        aVar2.d(i2);
                                                        CoroutineScheduler.this.n(aVar2, andDecrement, i2);
                                                    }
                                                    CoroutineScheduler.this.p.set(andDecrement, null);
                                                    this.l = 5;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        } else {
                            CoroutineScheduler coroutineScheduler = CoroutineScheduler.this;
                            Objects.requireNonNull(coroutineScheduler);
                            if (this.nextParkedWorker == symbol3) {
                                do {
                                    j2 = coroutineScheduler.parkedWorkersStack;
                                    j3 = (Permission.SPEAK + j2) & (-2097152);
                                    i = this.indexInArray;
                                    this.nextParkedWorker = coroutineScheduler.p.get((int) (j2 & 2097151));
                                } while (!CoroutineScheduler.j.compareAndSet(coroutineScheduler, j2, ((long) i) | j3));
                            }
                        }
                    } else {
                        if (z2) {
                            e(3);
                            Thread.interrupted();
                            LockSupport.parkNanos(this.n);
                            this.n = 0L;
                            break;
                        }
                        z2 = true;
                    }
                }
            }
            e(5);
        }
    }

    public CoroutineScheduler(int i, int i2, long j2, String str) {
        this.q = i;
        this.r = i2;
        this.f3838s = j2;
        this.t = str;
        if (!(i >= 1)) {
            throw new IllegalArgumentException(outline.r("Core pool size ", i, " should be at least 1").toString());
        }
        if (!(i2 >= i)) {
            throw new IllegalArgumentException(outline.s("Max pool size ", i2, " should be greater than or equals to core pool size ", i).toString());
        }
        if (!(i2 <= 2097150)) {
            throw new IllegalArgumentException(outline.r("Max pool size ", i2, " should not exceed maximal supported number of threads 2097150").toString());
        }
        if (!(j2 > 0)) {
            throw new IllegalArgumentException(("Idle worker keep alive time " + j2 + " must be positive").toString());
        }
        this.n = new Tasks();
        this.o = new Tasks();
        this.parkedWorkersStack = 0L;
        this.p = new AtomicReferenceArray<>(i2 + 1);
        this.controlState = ((long) i) << 42;
        this._isTerminated = 0;
    }

    public static /* synthetic */ void e(CoroutineScheduler coroutineScheduler, Runnable runnable, Tasks5 tasks5, boolean z2, int i) {
        Tasks3 tasks3 = (i & 2) != 0 ? Tasks3.j : null;
        if ((i & 4) != 0) {
            z2 = false;
        }
        coroutineScheduler.d(runnable, tasks3, z2);
    }

    public final int a() {
        synchronized (this.p) {
            if (this._isTerminated != 0) {
                return -1;
            }
            long j2 = this.controlState;
            int i = (int) (j2 & 2097151);
            int iCoerceAtLeast = _Ranges.coerceAtLeast(i - ((int) ((j2 & 4398044413952L) >> 21)), 0);
            if (iCoerceAtLeast >= this.q) {
                return 0;
            }
            if (i >= this.r) {
                return 0;
            }
            int i2 = ((int) (this.controlState & 2097151)) + 1;
            if (!(i2 > 0 && this.p.get(i2) == null)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            a aVar = new a(i2);
            this.p.set(i2, aVar);
            if (!(i2 == ((int) (2097151 & k.incrementAndGet(this))))) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            aVar.start();
            return iCoerceAtLeast + 1;
        }
    }

    public final Tasks4 b(Runnable runnable, Tasks5 tasks5) {
        long jA = Tasks7.e.a();
        if (!(runnable instanceof Tasks4)) {
            return new Tasks6(runnable, jA, tasks5);
        }
        Tasks4 tasks4 = (Tasks4) runnable;
        tasks4.j = jA;
        tasks4.k = tasks5;
        return tasks4;
    }

    public final a c() {
        Thread threadCurrentThread = Thread.currentThread();
        if (!(threadCurrentThread instanceof a)) {
            threadCurrentThread = null;
        }
        a aVar = (a) threadCurrentThread;
        if (aVar == null || !Intrinsics3.areEqual(CoroutineScheduler.this, this)) {
            return null;
        }
        return aVar;
    }

    /* JADX WARN: Code duplicated, block: B:33:0x0076  */
    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws InterruptedException {
        int i;
        Tasks4 tasks4D;
        boolean z2;
        if (l.compareAndSet(this, 0, 1)) {
            a aVarC = c();
            synchronized (this.p) {
                i = (int) (this.controlState & 2097151);
            }
            if (1 <= i) {
                int i2 = 1;
                while (true) {
                    a aVar = this.p.get(i2);
                    Intrinsics3.checkNotNull(aVar);
                    a aVar2 = aVar;
                    if (aVar2 != aVarC) {
                        while (aVar2.isAlive()) {
                            LockSupport.unpark(aVar2);
                            aVar2.join(10000L);
                        }
                        WorkQueue workQueue = aVar2.k;
                        Tasks tasks = this.o;
                        Objects.requireNonNull(workQueue);
                        Tasks4 tasks4 = (Tasks4) WorkQueue.a.getAndSet(workQueue, null);
                        if (tasks4 != null) {
                            tasks.a(tasks4);
                        }
                        do {
                            Tasks4 tasks4F = workQueue.f();
                            if (tasks4F != null) {
                                tasks.a(tasks4F);
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                        } while (z2);
                    }
                    if (i2 == i) {
                        break;
                    } else {
                        i2++;
                    }
                }
            }
            this.o.b();
            this.n.b();
            while (true) {
                if (aVarC == null) {
                    tasks4D = this.n.d();
                } else {
                    tasks4D = aVarC.a(true);
                    if (tasks4D == null) {
                        tasks4D = this.n.d();
                    }
                }
                if (tasks4D == null) {
                    tasks4D = this.o.d();
                }
                if (tasks4D == null) {
                    break;
                } else {
                    q(tasks4D);
                }
            }
            if (aVarC != null) {
                aVarC.e(5);
            }
            this.parkedWorkersStack = 0L;
            this.controlState = 0L;
        }
    }

    public final void d(Runnable runnable, Tasks5 tasks5, boolean z2) {
        Tasks4 tasks4A;
        Tasks4 tasks4B = b(runnable, tasks5);
        a aVarC = c();
        if (aVarC == null || aVarC.l == 5 || (tasks4B.k.t() == 0 && aVarC.l == 2)) {
            tasks4A = tasks4B;
        } else {
            aVarC.p = true;
            tasks4A = aVarC.k.a(tasks4B, z2);
        }
        if (tasks4A != null) {
            if (!(tasks4A.k.t() == 1 ? this.o.a(tasks4A) : this.n.a(tasks4A))) {
                throw new RejectedExecutionException(outline.J(new StringBuilder(), this.t, " was terminated"));
            }
        }
        boolean z3 = z2 && aVarC != null;
        if (tasks4B.k.t() == 0) {
            if (z3) {
                return;
            }
            s();
        } else {
            long jAddAndGet = k.addAndGet(this, Permission.SPEAK);
            if (z3 || u() || t(jAddAndGet)) {
                return;
            }
            u();
        }
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        e(this, runnable, null, false, 6);
    }

    public final int f(a aVar) {
        Object obj = aVar.nextParkedWorker;
        while (obj != m) {
            if (obj == null) {
                return 0;
            }
            a aVar2 = (a) obj;
            int i = aVar2.indexInArray;
            if (i != 0) {
                return i;
            }
            obj = aVar2.nextParkedWorker;
        }
        return -1;
    }

    public final void n(a aVar, int i, int i2) {
        while (true) {
            long j2 = this.parkedWorkersStack;
            int iF = (int) (2097151 & j2);
            long j3 = (Permission.SPEAK + j2) & (-2097152);
            if (iF == i) {
                iF = i2 == 0 ? f(aVar) : i2;
            }
            if (iF >= 0 && j.compareAndSet(this, j2, j3 | ((long) iF))) {
                return;
            }
        }
    }

    public final void q(Tasks4 tasks4) {
        try {
            tasks4.run();
        } catch (Throwable th) {
            Thread threadCurrentThread = Thread.currentThread();
            threadCurrentThread.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread, th);
        }
    }

    public final void s() {
        if (u() || t(this.controlState)) {
            return;
        }
        u();
    }

    public final boolean t(long j2) {
        if (_Ranges.coerceAtLeast(((int) (2097151 & j2)) - ((int) ((j2 & 4398044413952L) >> 21)), 0) < this.q) {
            int iA = a();
            if (iA == 1 && this.q > 1) {
                a();
            }
            if (iA > 0) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        ArrayList arrayList = new ArrayList();
        int length = this.p.length();
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        for (int i6 = 1; i6 < length; i6++) {
            a aVar = this.p.get(i6);
            if (aVar != null) {
                int iD = aVar.k.d();
                int iH = b.c.a.y.b.h(aVar.l);
                if (iH == 0) {
                    i++;
                    arrayList.add(String.valueOf(iD) + "c");
                } else if (iH == 1) {
                    i2++;
                    arrayList.add(String.valueOf(iD) + "b");
                } else if (iH == 2) {
                    i3++;
                } else if (iH == 3) {
                    i4++;
                    if (iD > 0) {
                        arrayList.add(String.valueOf(iD) + "d");
                    }
                } else if (iH == 4) {
                    i5++;
                }
            }
        }
        long j2 = this.controlState;
        return this.t + MentionUtils.MENTIONS_CHAR + b.i.a.f.e.o.f.l0(this) + "[Pool Size {core = " + this.q + ", max = " + this.r + "}, Worker States {CPU = " + i + ", blocking = " + i2 + ", parked = " + i3 + ", dormant = " + i4 + ", terminated = " + i5 + "}, running workers queues = " + arrayList + ", global CPU queue size = " + this.n.c() + ", global blocking queue size = " + this.o.c() + ", Control State {created workers= " + ((int) (2097151 & j2)) + ", blocking tasks = " + ((int) ((4398044413952L & j2) >> 21)) + ", CPUs acquired = " + (this.q - ((int) ((9223367638808264704L & j2) >> 42))) + "}]";
    }

    public final boolean u() {
        while (true) {
            long j2 = this.parkedWorkersStack;
            a aVar = this.p.get((int) (2097151 & j2));
            if (aVar != null) {
                long j3 = (Permission.SPEAK + j2) & (-2097152);
                int iF = f(aVar);
                if (iF >= 0 && j.compareAndSet(this, j2, ((long) iF) | j3)) {
                    aVar.nextParkedWorker = m;
                }
            } else {
                aVar = null;
            }
            if (aVar == null) {
                return false;
            }
            if (a.j.compareAndSet(aVar, -1, 0)) {
                LockSupport.unpark(aVar);
                return true;
            }
        }
    }
}
