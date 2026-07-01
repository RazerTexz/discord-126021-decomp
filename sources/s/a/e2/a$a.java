package s.a.e2;

import androidx.recyclerview.widget.RecyclerView;
import com.discord.api.permission.Permission;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.locks.LockSupport;
import org.objectweb.asm.Opcodes;
import s.a.a.t;

/* JADX INFO: compiled from: CoroutineScheduler.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a$a extends Thread {
    public static final AtomicIntegerFieldUpdater j = AtomicIntegerFieldUpdater.newUpdater(a$a.class, "workerCtl");
    public volatile int indexInArray;
    public final m k;
    public int l;
    public long m;
    public long n;
    public volatile Object nextParkedWorker;
    public int o;
    public boolean p;
    public final /* synthetic */ a q;
    public volatile int workerCtl;

    public a$a(a aVar, int i) {
        this.q = aVar;
        setDaemon(true);
        this.k = new m();
        this.l = 4;
        this.workerCtl = 0;
        this.nextParkedWorker = a.m;
        this.o = d0.c0.c.k.nextInt();
        d(i);
    }

    public final h a(boolean z2) {
        boolean z3;
        h hVarD;
        h hVarC;
        h hVarC2;
        boolean z4;
        if (this.l == 1) {
            z3 = true;
        } else {
            a aVar = this.q;
            while (true) {
                long j2 = aVar.controlState;
                if (((int) ((9223367638808264704L & j2) >> 42)) == 0) {
                    z4 = false;
                    break;
                }
                if (a.k.compareAndSet(aVar, j2, j2 - 4398046511104L)) {
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
            if (!z2 || (hVarD = this.k.e()) == null) {
                hVarD = this.q.o.d();
            }
            return hVarD != null ? hVarD : f(true);
        }
        if (z2) {
            boolean z5 = b(this.q.q * 2) == 0;
            if (z5 && (hVarC2 = c()) != null) {
                return hVarC2;
            }
            h hVarE = this.k.e();
            if (hVarE != null) {
                return hVarE;
            }
            if (!z5 && (hVarC = c()) != null) {
                return hVarC;
            }
        } else {
            h hVarC3 = c();
            if (hVarC3 != null) {
                return hVarC3;
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

    public final h c() {
        if (b(2) == 0) {
            h hVarD = this.q.n.d();
            return hVarD != null ? hVarD : this.q.o.d();
        }
        h hVarD2 = this.q.o.d();
        return hVarD2 != null ? hVarD2 : this.q.n.d();
    }

    public final void d(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.q.t);
        sb.append("-worker-");
        sb.append(i == 0 ? "TERMINATED" : String.valueOf(i));
        setName(sb.toString());
        this.indexInArray = i;
    }

    public final boolean e(int i) {
        int i2 = this.l;
        boolean z2 = i2 == 1;
        if (z2) {
            a.k.addAndGet(this.q, 4398046511104L);
        }
        if (i2 != i) {
            this.l = i;
        }
        return z2;
    }

    public final h f(boolean z2) {
        long jG;
        int i = (int) (this.q.controlState & 2097151);
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
            a$a a_a = this.q.p.get(iB);
            if (a_a != null && a_a != this) {
                if (z2) {
                    m mVar = this.k;
                    m mVar2 = a_a.k;
                    Objects.requireNonNull(mVar);
                    int i3 = mVar2.consumerIndex;
                    int i4 = mVar2.producerIndex;
                    AtomicReferenceArray<h> atomicReferenceArray = mVar2.e;
                    while (true) {
                        if (i3 != i4) {
                            int i5 = i3 & Opcodes.LAND;
                            if (mVar2.blockingTasksInBuffer != 0) {
                                h hVar = atomicReferenceArray.get(i5);
                                if (hVar != null) {
                                    if ((hVar.k.t() == 1) && atomicReferenceArray.compareAndSet(i5, hVar, null)) {
                                        m.d.decrementAndGet(mVar2);
                                        mVar.a(hVar, false);
                                        jG = -1;
                                        break;
                                    }
                                }
                                i3++;
                            }
                        }
                        jG = mVar.g(mVar2, true);
                        break;
                    }
                } else {
                    m mVar3 = this.k;
                    m mVar4 = a_a.k;
                    Objects.requireNonNull(mVar3);
                    h hVarF = mVar4.f();
                    if (hVarF != null) {
                        mVar3.a(hVarF, false);
                        jG = -1;
                    } else {
                        jG = mVar3.g(mVar4, false);
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
                if (this.q._isTerminated != 0 || this.l == 5) {
                    break loop0;
                }
                h hVarA = a(this.p);
                if (hVarA != null) {
                    this.n = 0L;
                    int iT = hVarA.k.t();
                    this.m = 0L;
                    if (this.l == 3) {
                        this.l = 2;
                    }
                    if (iT != 0 && e(2)) {
                        this.q.s();
                    }
                    this.q.q(hVarA);
                    if (iT != 0) {
                        a.k.addAndGet(this.q, -2097152L);
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
                    t tVar = a.m;
                    if (obj != tVar) {
                        this.workerCtl = -1;
                        while (true) {
                            if (!(this.nextParkedWorker != a.m) || this.q._isTerminated != 0 || this.l == 5) {
                                break;
                            }
                            e(3);
                            Thread.interrupted();
                            if (this.m == 0) {
                                this.m = System.nanoTime() + this.q.f3838s;
                            }
                            LockSupport.parkNanos(this.q.f3838s);
                            if (System.nanoTime() - this.m >= 0) {
                                this.m = 0L;
                                synchronized (this.q.p) {
                                    if (this.q._isTerminated == 0) {
                                        if (((int) (this.q.controlState & 2097151)) > this.q.q) {
                                            if (j.compareAndSet(this, -1, 1)) {
                                                int i2 = this.indexInArray;
                                                d(0);
                                                this.q.n(this, i2, 0);
                                                int andDecrement = (int) (a.k.getAndDecrement(this.q) & 2097151);
                                                if (andDecrement != i2) {
                                                    a$a a_a = this.q.p.get(andDecrement);
                                                    d0.z.d.m.checkNotNull(a_a);
                                                    a$a a_a2 = a_a;
                                                    this.q.p.set(i2, a_a2);
                                                    a_a2.d(i2);
                                                    this.q.n(a_a2, andDecrement, i2);
                                                }
                                                this.q.p.set(andDecrement, null);
                                                this.l = 5;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    } else {
                        a aVar = this.q;
                        Objects.requireNonNull(aVar);
                        if (this.nextParkedWorker == tVar) {
                            do {
                                j2 = aVar.parkedWorkersStack;
                                j3 = (Permission.SPEAK + j2) & (-2097152);
                                i = this.indexInArray;
                                this.nextParkedWorker = aVar.p.get((int) (j2 & 2097151));
                            } while (!a.j.compareAndSet(aVar, j2, ((long) i) | j3));
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
