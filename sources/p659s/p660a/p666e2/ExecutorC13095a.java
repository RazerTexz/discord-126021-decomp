package p659s.p660a.p666e2;

import androidx.recyclerview.widget.RecyclerView;
import com.discord.api.permission.Permission;
import com.discord.widgets.chat.input.MentionUtilsKt;
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
import p007b.p085c.p086a.p095y.C1563b;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p507d0.p510c0.AbstractC11216c;
import p507d0.p512d0.C11226f;
import p507d0.p592z.p594d.C12238m;
import p659s.p660a.p661a.C13037t;

/* JADX INFO: renamed from: s.a.e2.a */
/* JADX INFO: compiled from: CoroutineScheduler.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ExecutorC13095a implements Executor, Closeable {
    public volatile int _isTerminated;
    public volatile long controlState;

    /* JADX INFO: renamed from: n */
    public final C13098d f27798n;

    /* JADX INFO: renamed from: o */
    public final C13098d f27799o;

    /* JADX INFO: renamed from: p */
    public final AtomicReferenceArray<a> f27800p;
    public volatile long parkedWorkersStack;

    /* JADX INFO: renamed from: q */
    public final int f27801q;

    /* JADX INFO: renamed from: r */
    public final int f27802r;

    /* JADX INFO: renamed from: s */
    public final long f27803s;

    /* JADX INFO: renamed from: t */
    public final String f27804t;

    /* JADX INFO: renamed from: m */
    public static final C13037t f27797m = new C13037t("NOT_IN_STACK");

    /* JADX INFO: renamed from: j */
    public static final AtomicLongFieldUpdater f27794j = AtomicLongFieldUpdater.newUpdater(ExecutorC13095a.class, "parkedWorkersStack");

    /* JADX INFO: renamed from: k */
    public static final AtomicLongFieldUpdater f27795k = AtomicLongFieldUpdater.newUpdater(ExecutorC13095a.class, "controlState");

    /* JADX INFO: renamed from: l */
    public static final AtomicIntegerFieldUpdater f27796l = AtomicIntegerFieldUpdater.newUpdater(ExecutorC13095a.class, "_isTerminated");

    /* JADX INFO: renamed from: s.a.e2.a$a */
    /* JADX INFO: compiled from: CoroutineScheduler.kt */
    public final class a extends Thread {

        /* JADX INFO: renamed from: j */
        public static final AtomicIntegerFieldUpdater f27805j = AtomicIntegerFieldUpdater.newUpdater(a.class, "workerCtl");
        public volatile int indexInArray;

        /* JADX INFO: renamed from: k */
        public final C13107m f27806k;

        /* JADX INFO: renamed from: l */
        public int f27807l;

        /* JADX INFO: renamed from: m */
        public long f27808m;

        /* JADX INFO: renamed from: n */
        public long f27809n;
        public volatile Object nextParkedWorker;

        /* JADX INFO: renamed from: o */
        public int f27810o;

        /* JADX INFO: renamed from: p */
        public boolean f27811p;
        public volatile int workerCtl;

        public a(int i) {
            setDaemon(true);
            this.f27806k = new C13107m();
            this.f27807l = 4;
            this.workerCtl = 0;
            this.nextParkedWorker = ExecutorC13095a.f27797m;
            this.f27810o = AbstractC11216c.f22272k.nextInt();
            m11264d(i);
        }

        /* JADX INFO: renamed from: a */
        public final AbstractRunnableC13102h m11261a(boolean z2) {
            boolean z3;
            AbstractRunnableC13102h abstractRunnableC13102hM11164d;
            AbstractRunnableC13102h abstractRunnableC13102hM11263c;
            AbstractRunnableC13102h abstractRunnableC13102hM11263c2;
            boolean z4;
            if (this.f27807l == 1) {
                z3 = true;
            } else {
                ExecutorC13095a executorC13095a = ExecutorC13095a.this;
                while (true) {
                    long j = executorC13095a.controlState;
                    if (((int) ((9223367638808264704L & j) >> 42)) == 0) {
                        z4 = false;
                        break;
                    }
                    if (ExecutorC13095a.f27795k.compareAndSet(executorC13095a, j, j - 4398046511104L)) {
                        z4 = true;
                        break;
                    }
                }
                if (z4) {
                    this.f27807l = 1;
                    z3 = true;
                } else {
                    z3 = false;
                }
            }
            if (!z3) {
                if (!z2 || (abstractRunnableC13102hM11164d = this.f27806k.m11275e()) == null) {
                    abstractRunnableC13102hM11164d = ExecutorC13095a.this.f27799o.m11164d();
                }
                return abstractRunnableC13102hM11164d != null ? abstractRunnableC13102hM11164d : m11266f(true);
            }
            if (z2) {
                boolean z5 = m11262b(ExecutorC13095a.this.f27801q * 2) == 0;
                if (z5 && (abstractRunnableC13102hM11263c2 = m11263c()) != null) {
                    return abstractRunnableC13102hM11263c2;
                }
                AbstractRunnableC13102h abstractRunnableC13102hM11275e = this.f27806k.m11275e();
                if (abstractRunnableC13102hM11275e != null) {
                    return abstractRunnableC13102hM11275e;
                }
                if (!z5 && (abstractRunnableC13102hM11263c = m11263c()) != null) {
                    return abstractRunnableC13102hM11263c;
                }
            } else {
                AbstractRunnableC13102h abstractRunnableC13102hM11263c3 = m11263c();
                if (abstractRunnableC13102hM11263c3 != null) {
                    return abstractRunnableC13102hM11263c3;
                }
            }
            return m11266f(false);
        }

        /* JADX INFO: renamed from: b */
        public final int m11262b(int i) {
            int i2 = this.f27810o;
            int i3 = i2 ^ (i2 << 13);
            int i4 = i3 ^ (i3 >> 17);
            int i5 = i4 ^ (i4 << 5);
            this.f27810o = i5;
            int i6 = i - 1;
            return (i6 & i) == 0 ? i5 & i6 : (i5 & Integer.MAX_VALUE) % i;
        }

        /* JADX INFO: renamed from: c */
        public final AbstractRunnableC13102h m11263c() {
            if (m11262b(2) == 0) {
                AbstractRunnableC13102h abstractRunnableC13102hM11164d = ExecutorC13095a.this.f27798n.m11164d();
                return abstractRunnableC13102hM11164d != null ? abstractRunnableC13102hM11164d : ExecutorC13095a.this.f27799o.m11164d();
            }
            AbstractRunnableC13102h abstractRunnableC13102hM11164d2 = ExecutorC13095a.this.f27799o.m11164d();
            return abstractRunnableC13102hM11164d2 != null ? abstractRunnableC13102hM11164d2 : ExecutorC13095a.this.f27798n.m11164d();
        }

        /* JADX INFO: renamed from: d */
        public final void m11264d(int i) {
            StringBuilder sb = new StringBuilder();
            sb.append(ExecutorC13095a.this.f27804t);
            sb.append("-worker-");
            sb.append(i == 0 ? "TERMINATED" : String.valueOf(i));
            setName(sb.toString());
            this.indexInArray = i;
        }

        /* JADX INFO: renamed from: e */
        public final boolean m11265e(int i) {
            int i2 = this.f27807l;
            boolean z2 = i2 == 1;
            if (z2) {
                ExecutorC13095a.f27795k.addAndGet(ExecutorC13095a.this, 4398046511104L);
            }
            if (i2 != i) {
                this.f27807l = i;
            }
            return z2;
        }

        /* JADX INFO: renamed from: f */
        public final AbstractRunnableC13102h m11266f(boolean z2) {
            long jM11277g;
            int i = (int) (ExecutorC13095a.this.controlState & 2097151);
            if (i < 2) {
                return null;
            }
            int iM11262b = m11262b(i);
            long jMin = RecyclerView.FOREVER_NS;
            for (int i2 = 0; i2 < i; i2++) {
                iM11262b++;
                if (iM11262b > i) {
                    iM11262b = 1;
                }
                a aVar = ExecutorC13095a.this.f27800p.get(iM11262b);
                if (aVar != null && aVar != this) {
                    if (z2) {
                        C13107m c13107m = this.f27806k;
                        C13107m c13107m2 = aVar.f27806k;
                        Objects.requireNonNull(c13107m);
                        int i3 = c13107m2.consumerIndex;
                        int i4 = c13107m2.producerIndex;
                        AtomicReferenceArray<AbstractRunnableC13102h> atomicReferenceArray = c13107m2.f27840e;
                        while (true) {
                            if (i3 != i4) {
                                int i5 = i3 & Opcodes.LAND;
                                if (c13107m2.blockingTasksInBuffer != 0) {
                                    AbstractRunnableC13102h abstractRunnableC13102h = atomicReferenceArray.get(i5);
                                    if (abstractRunnableC13102h != null) {
                                        if ((abstractRunnableC13102h.f27829k.mo11269t() == 1) && atomicReferenceArray.compareAndSet(i5, abstractRunnableC13102h, null)) {
                                            C13107m.f27839d.decrementAndGet(c13107m2);
                                            c13107m.m11271a(abstractRunnableC13102h, false);
                                            jM11277g = -1;
                                            break;
                                        }
                                    }
                                    i3++;
                                }
                            }
                            jM11277g = c13107m.m11277g(c13107m2, true);
                            break;
                        }
                    } else {
                        C13107m c13107m3 = this.f27806k;
                        C13107m c13107m4 = aVar.f27806k;
                        Objects.requireNonNull(c13107m3);
                        AbstractRunnableC13102h abstractRunnableC13102hM11276f = c13107m4.m11276f();
                        if (abstractRunnableC13102hM11276f != null) {
                            c13107m3.m11271a(abstractRunnableC13102hM11276f, false);
                            jM11277g = -1;
                        } else {
                            jM11277g = c13107m3.m11277g(c13107m4, false);
                        }
                    }
                    if (jM11277g == -1) {
                        return this.f27806k.m11275e();
                    }
                    if (jM11277g > 0) {
                        jMin = Math.min(jMin, jM11277g);
                    }
                }
            }
            if (jMin == RecyclerView.FOREVER_NS) {
                jMin = 0;
            }
            this.f27809n = jMin;
            return null;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            long j;
            long j2;
            int i;
            loop0: while (true) {
                boolean z2 = false;
                while (true) {
                    if (ExecutorC13095a.this._isTerminated != 0 || this.f27807l == 5) {
                        break loop0;
                    }
                    AbstractRunnableC13102h abstractRunnableC13102hM11261a = m11261a(this.f27811p);
                    if (abstractRunnableC13102hM11261a != null) {
                        this.f27809n = 0L;
                        int iMo11269t = abstractRunnableC13102hM11261a.f27829k.mo11269t();
                        this.f27808m = 0L;
                        if (this.f27807l == 3) {
                            this.f27807l = 2;
                        }
                        if (iMo11269t != 0 && m11265e(2)) {
                            ExecutorC13095a.this.m11258s();
                        }
                        ExecutorC13095a.this.m11257q(abstractRunnableC13102hM11261a);
                        if (iMo11269t != 0) {
                            ExecutorC13095a.f27795k.addAndGet(ExecutorC13095a.this, -2097152L);
                            if (this.f27807l == 5) {
                                break;
                            }
                            this.f27807l = 4;
                            break;
                        }
                        break;
                    }
                    this.f27811p = false;
                    if (this.f27809n == 0) {
                        Object obj = this.nextParkedWorker;
                        C13037t c13037t = ExecutorC13095a.f27797m;
                        if (obj != c13037t) {
                            this.workerCtl = -1;
                            while (true) {
                                if (!(this.nextParkedWorker != ExecutorC13095a.f27797m) || ExecutorC13095a.this._isTerminated != 0 || this.f27807l == 5) {
                                    break;
                                }
                                m11265e(3);
                                Thread.interrupted();
                                if (this.f27808m == 0) {
                                    this.f27808m = System.nanoTime() + ExecutorC13095a.this.f27803s;
                                }
                                LockSupport.parkNanos(ExecutorC13095a.this.f27803s);
                                if (System.nanoTime() - this.f27808m >= 0) {
                                    this.f27808m = 0L;
                                    synchronized (ExecutorC13095a.this.f27800p) {
                                        if (ExecutorC13095a.this._isTerminated == 0) {
                                            if (((int) (ExecutorC13095a.this.controlState & 2097151)) > ExecutorC13095a.this.f27801q) {
                                                if (f27805j.compareAndSet(this, -1, 1)) {
                                                    int i2 = this.indexInArray;
                                                    m11264d(0);
                                                    ExecutorC13095a.this.m11256n(this, i2, 0);
                                                    int andDecrement = (int) (ExecutorC13095a.f27795k.getAndDecrement(ExecutorC13095a.this) & 2097151);
                                                    if (andDecrement != i2) {
                                                        a aVar = ExecutorC13095a.this.f27800p.get(andDecrement);
                                                        C12238m.checkNotNull(aVar);
                                                        a aVar2 = aVar;
                                                        ExecutorC13095a.this.f27800p.set(i2, aVar2);
                                                        aVar2.m11264d(i2);
                                                        ExecutorC13095a.this.m11256n(aVar2, andDecrement, i2);
                                                    }
                                                    ExecutorC13095a.this.f27800p.set(andDecrement, null);
                                                    this.f27807l = 5;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        } else {
                            ExecutorC13095a executorC13095a = ExecutorC13095a.this;
                            Objects.requireNonNull(executorC13095a);
                            if (this.nextParkedWorker == c13037t) {
                                do {
                                    j = executorC13095a.parkedWorkersStack;
                                    j2 = (Permission.SPEAK + j) & (-2097152);
                                    i = this.indexInArray;
                                    this.nextParkedWorker = executorC13095a.f27800p.get((int) (j & 2097151));
                                } while (!ExecutorC13095a.f27794j.compareAndSet(executorC13095a, j, ((long) i) | j2));
                            }
                        }
                    } else {
                        if (z2) {
                            m11265e(3);
                            Thread.interrupted();
                            LockSupport.parkNanos(this.f27809n);
                            this.f27809n = 0L;
                            break;
                        }
                        z2 = true;
                    }
                }
            }
            m11265e(5);
        }
    }

    public ExecutorC13095a(int i, int i2, long j, String str) {
        this.f27801q = i;
        this.f27802r = i2;
        this.f27803s = j;
        this.f27804t = str;
        if (!(i >= 1)) {
            throw new IllegalArgumentException(C1643a.m873r("Core pool size ", i, " should be at least 1").toString());
        }
        if (!(i2 >= i)) {
            throw new IllegalArgumentException(C1643a.m875s("Max pool size ", i2, " should be greater than or equals to core pool size ", i).toString());
        }
        if (!(i2 <= 2097150)) {
            throw new IllegalArgumentException(C1643a.m873r("Max pool size ", i2, " should not exceed maximal supported number of threads 2097150").toString());
        }
        if (!(j > 0)) {
            throw new IllegalArgumentException(("Idle worker keep alive time " + j + " must be positive").toString());
        }
        this.f27798n = new C13098d();
        this.f27799o = new C13098d();
        this.parkedWorkersStack = 0L;
        this.f27800p = new AtomicReferenceArray<>(i2 + 1);
        this.controlState = ((long) i) << 42;
        this._isTerminated = 0;
    }

    /* JADX INFO: renamed from: e */
    public static /* synthetic */ void m11250e(ExecutorC13095a executorC13095a, Runnable runnable, InterfaceC13103i interfaceC13103i, boolean z2, int i) {
        C13101g c13101g = (i & 2) != 0 ? C13101g.f27827j : null;
        if ((i & 4) != 0) {
            z2 = false;
        }
        executorC13095a.m11254d(runnable, c13101g, z2);
    }

    /* JADX INFO: renamed from: a */
    public final int m11251a() {
        synchronized (this.f27800p) {
            if (this._isTerminated != 0) {
                return -1;
            }
            long j = this.controlState;
            int i = (int) (j & 2097151);
            int iCoerceAtLeast = C11226f.coerceAtLeast(i - ((int) ((j & 4398044413952L) >> 21)), 0);
            if (iCoerceAtLeast >= this.f27801q) {
                return 0;
            }
            if (i >= this.f27802r) {
                return 0;
            }
            int i2 = ((int) (this.controlState & 2097151)) + 1;
            if (!(i2 > 0 && this.f27800p.get(i2) == null)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            a aVar = new a(i2);
            this.f27800p.set(i2, aVar);
            if (!(i2 == ((int) (2097151 & f27795k.incrementAndGet(this))))) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            aVar.start();
            return iCoerceAtLeast + 1;
        }
    }

    /* JADX INFO: renamed from: b */
    public final AbstractRunnableC13102h m11252b(Runnable runnable, InterfaceC13103i interfaceC13103i) {
        long jMo11270a = C13105k.f27835e.mo11270a();
        if (!(runnable instanceof AbstractRunnableC13102h)) {
            return new C13104j(runnable, jMo11270a, interfaceC13103i);
        }
        AbstractRunnableC13102h abstractRunnableC13102h = (AbstractRunnableC13102h) runnable;
        abstractRunnableC13102h.f27828j = jMo11270a;
        abstractRunnableC13102h.f27829k = interfaceC13103i;
        return abstractRunnableC13102h;
    }

    /* JADX INFO: renamed from: c */
    public final a m11253c() {
        Thread threadCurrentThread = Thread.currentThread();
        if (!(threadCurrentThread instanceof a)) {
            threadCurrentThread = null;
        }
        a aVar = (a) threadCurrentThread;
        if (aVar == null || !C12238m.areEqual(ExecutorC13095a.this, this)) {
            return null;
        }
        return aVar;
    }

    /* JADX WARN: Code duplicated, block: B:33:0x0076  */
    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws InterruptedException {
        int i;
        AbstractRunnableC13102h abstractRunnableC13102hM11164d;
        boolean z2;
        if (f27796l.compareAndSet(this, 0, 1)) {
            a aVarM11253c = m11253c();
            synchronized (this.f27800p) {
                i = (int) (this.controlState & 2097151);
            }
            if (1 <= i) {
                int i2 = 1;
                while (true) {
                    a aVar = this.f27800p.get(i2);
                    C12238m.checkNotNull(aVar);
                    a aVar2 = aVar;
                    if (aVar2 != aVarM11253c) {
                        while (aVar2.isAlive()) {
                            LockSupport.unpark(aVar2);
                            aVar2.join(10000L);
                        }
                        C13107m c13107m = aVar2.f27806k;
                        C13098d c13098d = this.f27799o;
                        Objects.requireNonNull(c13107m);
                        AbstractRunnableC13102h abstractRunnableC13102h = (AbstractRunnableC13102h) C13107m.f27836a.getAndSet(c13107m, null);
                        if (abstractRunnableC13102h != null) {
                            c13098d.m11161a(abstractRunnableC13102h);
                        }
                        do {
                            AbstractRunnableC13102h abstractRunnableC13102hM11276f = c13107m.m11276f();
                            if (abstractRunnableC13102hM11276f != null) {
                                c13098d.m11161a(abstractRunnableC13102hM11276f);
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
            this.f27799o.m11162b();
            this.f27798n.m11162b();
            while (true) {
                if (aVarM11253c == null) {
                    abstractRunnableC13102hM11164d = this.f27798n.m11164d();
                } else {
                    abstractRunnableC13102hM11164d = aVarM11253c.m11261a(true);
                    if (abstractRunnableC13102hM11164d == null) {
                        abstractRunnableC13102hM11164d = this.f27798n.m11164d();
                    }
                }
                if (abstractRunnableC13102hM11164d == null) {
                    abstractRunnableC13102hM11164d = this.f27799o.m11164d();
                }
                if (abstractRunnableC13102hM11164d == null) {
                    break;
                } else {
                    m11257q(abstractRunnableC13102hM11164d);
                }
            }
            if (aVarM11253c != null) {
                aVarM11253c.m11265e(5);
            }
            this.parkedWorkersStack = 0L;
            this.controlState = 0L;
        }
    }

    /* JADX INFO: renamed from: d */
    public final void m11254d(Runnable runnable, InterfaceC13103i interfaceC13103i, boolean z2) {
        AbstractRunnableC13102h abstractRunnableC13102hM11271a;
        AbstractRunnableC13102h abstractRunnableC13102hM11252b = m11252b(runnable, interfaceC13103i);
        a aVarM11253c = m11253c();
        if (aVarM11253c == null || aVarM11253c.f27807l == 5 || (abstractRunnableC13102hM11252b.f27829k.mo11269t() == 0 && aVarM11253c.f27807l == 2)) {
            abstractRunnableC13102hM11271a = abstractRunnableC13102hM11252b;
        } else {
            aVarM11253c.f27811p = true;
            abstractRunnableC13102hM11271a = aVarM11253c.f27806k.m11271a(abstractRunnableC13102hM11252b, z2);
        }
        if (abstractRunnableC13102hM11271a != null) {
            if (!(abstractRunnableC13102hM11271a.f27829k.mo11269t() == 1 ? this.f27799o.m11161a(abstractRunnableC13102hM11271a) : this.f27798n.m11161a(abstractRunnableC13102hM11271a))) {
                throw new RejectedExecutionException(C1643a.m822J(new StringBuilder(), this.f27804t, " was terminated"));
            }
        }
        boolean z3 = z2 && aVarM11253c != null;
        if (abstractRunnableC13102hM11252b.f27829k.mo11269t() == 0) {
            if (z3) {
                return;
            }
            m11258s();
        } else {
            long jAddAndGet = f27795k.addAndGet(this, Permission.SPEAK);
            if (z3 || m11260u() || m11259t(jAddAndGet)) {
                return;
            }
            m11260u();
        }
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        m11250e(this, runnable, null, false, 6);
    }

    /* JADX INFO: renamed from: f */
    public final int m11255f(a aVar) {
        Object obj = aVar.nextParkedWorker;
        while (obj != f27797m) {
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

    /* JADX INFO: renamed from: n */
    public final void m11256n(a aVar, int i, int i2) {
        while (true) {
            long j = this.parkedWorkersStack;
            int iM11255f = (int) (2097151 & j);
            long j2 = (Permission.SPEAK + j) & (-2097152);
            if (iM11255f == i) {
                iM11255f = i2 == 0 ? m11255f(aVar) : i2;
            }
            if (iM11255f >= 0 && f27794j.compareAndSet(this, j, j2 | ((long) iM11255f))) {
                return;
            }
        }
    }

    /* JADX INFO: renamed from: q */
    public final void m11257q(AbstractRunnableC13102h abstractRunnableC13102h) {
        try {
            abstractRunnableC13102h.run();
        } catch (Throwable th) {
            Thread threadCurrentThread = Thread.currentThread();
            threadCurrentThread.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread, th);
        }
    }

    /* JADX INFO: renamed from: s */
    public final void m11258s() {
        if (m11260u() || m11259t(this.controlState)) {
            return;
        }
        m11260u();
    }

    /* JADX INFO: renamed from: t */
    public final boolean m11259t(long j) {
        if (C11226f.coerceAtLeast(((int) (2097151 & j)) - ((int) ((j & 4398044413952L) >> 21)), 0) < this.f27801q) {
            int iM11251a = m11251a();
            if (iM11251a == 1 && this.f27801q > 1) {
                m11251a();
            }
            if (iM11251a > 0) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        ArrayList arrayList = new ArrayList();
        int length = this.f27800p.length();
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        for (int i6 = 1; i6 < length; i6++) {
            a aVar = this.f27800p.get(i6);
            if (aVar != null) {
                int iM11274d = aVar.f27806k.m11274d();
                int iM758h = C1563b.m758h(aVar.f27807l);
                if (iM758h == 0) {
                    i++;
                    arrayList.add(String.valueOf(iM11274d) + "c");
                } else if (iM758h == 1) {
                    i2++;
                    arrayList.add(String.valueOf(iM11274d) + "b");
                } else if (iM758h == 2) {
                    i3++;
                } else if (iM758h == 3) {
                    i4++;
                    if (iM11274d > 0) {
                        arrayList.add(String.valueOf(iM11274d) + "d");
                    }
                } else if (iM758h == 4) {
                    i5++;
                }
            }
        }
        long j = this.controlState;
        return this.f27804t + MentionUtilsKt.MENTIONS_CHAR + C3404f.m4312l0(this) + "[Pool Size {core = " + this.f27801q + ", max = " + this.f27802r + "}, Worker States {CPU = " + i + ", blocking = " + i2 + ", parked = " + i3 + ", dormant = " + i4 + ", terminated = " + i5 + "}, running workers queues = " + arrayList + ", global CPU queue size = " + this.f27798n.m11163c() + ", global blocking queue size = " + this.f27799o.m11163c() + ", Control State {created workers= " + ((int) (2097151 & j)) + ", blocking tasks = " + ((int) ((4398044413952L & j) >> 21)) + ", CPUs acquired = " + (this.f27801q - ((int) ((9223367638808264704L & j) >> 42))) + "}]";
    }

    /* JADX INFO: renamed from: u */
    public final boolean m11260u() {
        while (true) {
            long j = this.parkedWorkersStack;
            a aVar = this.f27800p.get((int) (2097151 & j));
            if (aVar != null) {
                long j2 = (Permission.SPEAK + j) & (-2097152);
                int iM11255f = m11255f(aVar);
                if (iM11255f >= 0 && f27794j.compareAndSet(this, j, ((long) iM11255f) | j2)) {
                    aVar.nextParkedWorker = f27797m;
                }
            } else {
                aVar = null;
            }
            if (aVar == null) {
                return false;
            }
            if (a.f27805j.compareAndSet(aVar, -1, 0)) {
                LockSupport.unpark(aVar);
                return true;
            }
        }
    }
}
