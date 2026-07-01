package s.a.e2;

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
import s.a.a.t;

/* JADX INFO: compiled from: CoroutineScheduler.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a implements Executor, Closeable {
    public volatile int _isTerminated;
    public volatile long controlState;
    public final d n;
    public final d o;
    public final AtomicReferenceArray<a$a> p;
    public volatile long parkedWorkersStack;
    public final int q;
    public final int r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final long f3838s;
    public final String t;
    public static final t m = new t("NOT_IN_STACK");
    public static final AtomicLongFieldUpdater j = AtomicLongFieldUpdater.newUpdater(a.class, "parkedWorkersStack");
    public static final AtomicLongFieldUpdater k = AtomicLongFieldUpdater.newUpdater(a.class, "controlState");
    public static final AtomicIntegerFieldUpdater l = AtomicIntegerFieldUpdater.newUpdater(a.class, "_isTerminated");

    public a(int i, int i2, long j2, String str) {
        this.q = i;
        this.r = i2;
        this.f3838s = j2;
        this.t = str;
        if (!(i >= 1)) {
            throw new IllegalArgumentException(b.d.b.a.a.r("Core pool size ", i, " should be at least 1").toString());
        }
        if (!(i2 >= i)) {
            throw new IllegalArgumentException(b.d.b.a.a.s("Max pool size ", i2, " should be greater than or equals to core pool size ", i).toString());
        }
        if (!(i2 <= 2097150)) {
            throw new IllegalArgumentException(b.d.b.a.a.r("Max pool size ", i2, " should not exceed maximal supported number of threads 2097150").toString());
        }
        if (!(j2 > 0)) {
            throw new IllegalArgumentException(("Idle worker keep alive time " + j2 + " must be positive").toString());
        }
        this.n = new d();
        this.o = new d();
        this.parkedWorkersStack = 0L;
        this.p = new AtomicReferenceArray<>(i2 + 1);
        this.controlState = ((long) i) << 42;
        this._isTerminated = 0;
    }

    public static /* synthetic */ void e(a aVar, Runnable runnable, i iVar, boolean z2, int i) {
        g gVar = (i & 2) != 0 ? g.j : null;
        if ((i & 4) != 0) {
            z2 = false;
        }
        aVar.d(runnable, gVar, z2);
    }

    public final int a() {
        synchronized (this.p) {
            if (this._isTerminated != 0) {
                return -1;
            }
            long j2 = this.controlState;
            int i = (int) (j2 & 2097151);
            int iCoerceAtLeast = d0.d0.f.coerceAtLeast(i - ((int) ((j2 & 4398044413952L) >> 21)), 0);
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
            a$a a_a = new a$a(this, i2);
            this.p.set(i2, a_a);
            if (!(i2 == ((int) (2097151 & k.incrementAndGet(this))))) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            a_a.start();
            return iCoerceAtLeast + 1;
        }
    }

    public final h b(Runnable runnable, i iVar) {
        long jA = k.e.a();
        if (!(runnable instanceof h)) {
            return new j(runnable, jA, iVar);
        }
        h hVar = (h) runnable;
        hVar.j = jA;
        hVar.k = iVar;
        return hVar;
    }

    public final a$a c() {
        Thread threadCurrentThread = Thread.currentThread();
        if (!(threadCurrentThread instanceof a$a)) {
            threadCurrentThread = null;
        }
        a$a a_a = (a$a) threadCurrentThread;
        if (a_a == null || !d0.z.d.m.areEqual(a_a.q, this)) {
            return null;
        }
        return a_a;
    }

    /* JADX WARN: Code duplicated, block: B:33:0x0076  */
    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws InterruptedException {
        int i;
        h hVarD;
        boolean z2;
        if (l.compareAndSet(this, 0, 1)) {
            a$a a_aC = c();
            synchronized (this.p) {
                i = (int) (this.controlState & 2097151);
            }
            if (1 <= i) {
                int i2 = 1;
                while (true) {
                    a$a a_a = this.p.get(i2);
                    d0.z.d.m.checkNotNull(a_a);
                    a$a a_a2 = a_a;
                    if (a_a2 != a_aC) {
                        while (a_a2.isAlive()) {
                            LockSupport.unpark(a_a2);
                            a_a2.join(10000L);
                        }
                        m mVar = a_a2.k;
                        d dVar = this.o;
                        Objects.requireNonNull(mVar);
                        h hVar = (h) m.a.getAndSet(mVar, null);
                        if (hVar != null) {
                            dVar.a(hVar);
                        }
                        do {
                            h hVarF = mVar.f();
                            if (hVarF != null) {
                                dVar.a(hVarF);
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
                if (a_aC == null) {
                    hVarD = this.n.d();
                } else {
                    hVarD = a_aC.a(true);
                    if (hVarD == null) {
                        hVarD = this.n.d();
                    }
                }
                if (hVarD == null) {
                    hVarD = this.o.d();
                }
                if (hVarD == null) {
                    break;
                } else {
                    q(hVarD);
                }
            }
            if (a_aC != null) {
                a_aC.e(5);
            }
            this.parkedWorkersStack = 0L;
            this.controlState = 0L;
        }
    }

    public final void d(Runnable runnable, i iVar, boolean z2) {
        h hVarA;
        h hVarB = b(runnable, iVar);
        a$a a_aC = c();
        if (a_aC == null || a_aC.l == 5 || (hVarB.k.t() == 0 && a_aC.l == 2)) {
            hVarA = hVarB;
        } else {
            a_aC.p = true;
            hVarA = a_aC.k.a(hVarB, z2);
        }
        if (hVarA != null) {
            if (!(hVarA.k.t() == 1 ? this.o.a(hVarA) : this.n.a(hVarA))) {
                throw new RejectedExecutionException(b.d.b.a.a.J(new StringBuilder(), this.t, " was terminated"));
            }
        }
        boolean z3 = z2 && a_aC != null;
        if (hVarB.k.t() == 0) {
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

    public final int f(a$a a_a) {
        Object obj = a_a.nextParkedWorker;
        while (obj != m) {
            if (obj == null) {
                return 0;
            }
            a$a a_a2 = (a$a) obj;
            int i = a_a2.indexInArray;
            if (i != 0) {
                return i;
            }
            obj = a_a2.nextParkedWorker;
        }
        return -1;
    }

    public final void n(a$a a_a, int i, int i2) {
        while (true) {
            long j2 = this.parkedWorkersStack;
            int iF = (int) (2097151 & j2);
            long j3 = (Permission.SPEAK + j2) & (-2097152);
            if (iF == i) {
                iF = i2 == 0 ? f(a_a) : i2;
            }
            if (iF >= 0 && j.compareAndSet(this, j2, j3 | ((long) iF))) {
                return;
            }
        }
    }

    public final void q(h hVar) {
        try {
            hVar.run();
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
        if (d0.d0.f.coerceAtLeast(((int) (2097151 & j2)) - ((int) ((j2 & 4398044413952L) >> 21)), 0) < this.q) {
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
            a$a a_a = this.p.get(i6);
            if (a_a != null) {
                int iD = a_a.k.d();
                int iH = b.c.a.y.b.h(a_a.l);
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
        return this.t + MentionUtilsKt.MENTIONS_CHAR + b.i.a.f.e.o.f.l0(this) + "[Pool Size {core = " + this.q + ", max = " + this.r + "}, Worker States {CPU = " + i + ", blocking = " + i2 + ", parked = " + i3 + ", dormant = " + i4 + ", terminated = " + i5 + "}, running workers queues = " + arrayList + ", global CPU queue size = " + this.n.c() + ", global blocking queue size = " + this.o.c() + ", Control State {created workers= " + ((int) (2097151 & j2)) + ", blocking tasks = " + ((int) ((4398044413952L & j2) >> 21)) + ", CPUs acquired = " + (this.q - ((int) ((9223367638808264704L & j2) >> 42))) + "}]";
    }

    public final boolean u() {
        while (true) {
            long j2 = this.parkedWorkersStack;
            a$a a_a = this.p.get((int) (2097151 & j2));
            if (a_a != null) {
                long j3 = (Permission.SPEAK + j2) & (-2097152);
                int iF = f(a_a);
                if (iF >= 0 && j.compareAndSet(this, j2, ((long) iF) | j3)) {
                    a_a.nextParkedWorker = m;
                }
            } else {
                a_a = null;
            }
            if (a_a == null) {
                return false;
            }
            if (a$a.j.compareAndSet(a_a, -1, 0)) {
                LockSupport.unpark(a_a);
                return true;
            }
        }
    }
}
