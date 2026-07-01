package s.a.c2;

import java.util.concurrent.locks.ReentrantLock;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.internal.UndeliveredElementException;

/* JADX INFO: compiled from: ArrayChannel.kt */
/* JADX INFO: loaded from: classes3.dex */
public class d<E> extends a<E> {
    public final ReentrantLock m;
    public Object[] n;
    public int o;
    public final int p;
    public final e q;
    public volatile int size;

    public d(int i, e eVar, Function1<? super E, Unit> function1) {
        super(function1);
        this.p = i;
        this.q = eVar;
        if (!(i >= 1)) {
            throw new IllegalArgumentException(b.d.b.a.a.r("ArrayChannel capacity must be at least 1, but ", i, " was specified").toString());
        }
        this.m = new ReentrantLock();
        Object[] objArr = new Object[Math.min(i, 8)];
        d0.t.j.fill$default(objArr, b.a, 0, 0, 6, null);
        this.n = objArr;
        this.size = 0;
    }

    @Override // s.a.c2.c
    public Object c(r rVar) {
        ReentrantLock reentrantLock = this.m;
        reentrantLock.lock();
        try {
            return super.c(rVar);
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // s.a.c2.c
    public String d() {
        StringBuilder sbU = b.d.b.a.a.U("(buffer:capacity=");
        sbU.append(this.p);
        sbU.append(",size=");
        return b.d.b.a.a.A(sbU, this.size, ')');
    }

    @Override // s.a.c2.c
    public final boolean h() {
        return false;
    }

    @Override // s.a.c2.c
    public final boolean i() {
        return this.size == this.p && this.q == e.SUSPEND;
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0038  */
    /* JADX WARN: Code duplicated, block: B:23:0x003c A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:24:0x003e A[Catch: all -> 0x0076, LOOP:0: B:24:0x003e->B:46:?, LOOP_START, TRY_ENTER, TryCatch #0 {all -> 0x0076, blocks: (B:3:0x0005, B:7:0x0011, B:9:0x0017, B:24:0x003e, B:26:0x0044, B:28:0x0048, B:31:0x0051, B:33:0x005a, B:36:0x006d, B:10:0x001c, B:15:0x0029, B:16:0x002c, B:17:0x0031, B:19:0x0034), top: B:42:0x0005 }] */
    /* JADX WARN: Code duplicated, block: B:26:0x0044 A[Catch: all -> 0x0076, TryCatch #0 {all -> 0x0076, blocks: (B:3:0x0005, B:7:0x0011, B:9:0x0017, B:24:0x003e, B:26:0x0044, B:28:0x0048, B:31:0x0051, B:33:0x005a, B:36:0x006d, B:10:0x001c, B:15:0x0029, B:16:0x002c, B:17:0x0031, B:19:0x0034), top: B:42:0x0005 }] */
    /* JADX WARN: Code duplicated, block: B:31:0x0051 A[Catch: all -> 0x0076, TRY_ENTER, TryCatch #0 {all -> 0x0076, blocks: (B:3:0x0005, B:7:0x0011, B:9:0x0017, B:24:0x003e, B:26:0x0044, B:28:0x0048, B:31:0x0051, B:33:0x005a, B:36:0x006d, B:10:0x001c, B:15:0x0029, B:16:0x002c, B:17:0x0031, B:19:0x0034), top: B:42:0x0005 }] */
    /* JADX WARN: Code duplicated, block: B:43:0x005a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:44:0x006d A[EDGE_INSN: B:44:0x006d->B:36:0x006d BREAK  A[LOOP:0: B:24:0x003e->B:46:?], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:45:0x0048 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:46:? A[LOOP:0: B:24:0x003e->B:46:?, LOOP_END, SYNTHETIC] */
    @Override // s.a.c2.c
    public Object k(E e) {
        s.a.a.t tVar;
        p<E> pVarN;
        ReentrantLock reentrantLock = this.m;
        reentrantLock.lock();
        try {
            int i = this.size;
            i<?> iVarE = e();
            if (iVarE != null) {
                reentrantLock.unlock();
                return iVarE;
            }
            if (i >= this.p) {
                int iOrdinal = this.q.ordinal();
                if (iOrdinal == 0) {
                    tVar = b.c;
                } else if (iOrdinal != 1) {
                    if (iOrdinal != 2) {
                        throw new NoWhenBranchMatchedException();
                    }
                    tVar = b.f3834b;
                }
                if (tVar != null) {
                    reentrantLock.unlock();
                    return tVar;
                }
                if (i == 0) {
                    while (true) {
                        pVarN = n();
                        if (pVarN != null) {
                            break;
                        }
                        if (pVarN instanceof i) {
                            this.size = i;
                            d0.z.d.m.checkNotNull(pVarN);
                            reentrantLock.unlock();
                            return pVarN;
                        }
                        d0.z.d.m.checkNotNull(pVarN);
                        if (pVarN.d(e, null) != null) {
                            this.size = i;
                            reentrantLock.unlock();
                            d0.z.d.m.checkNotNull(pVarN);
                            pVarN.c(e);
                            d0.z.d.m.checkNotNull(pVarN);
                            return pVarN.b();
                        }
                    }
                }
                w(i, e);
                s.a.a.t tVar2 = b.f3834b;
                reentrantLock.unlock();
                return tVar2;
            }
            this.size = i + 1;
            tVar = null;
            if (tVar != null) {
                reentrantLock.unlock();
                return tVar;
            }
            if (i == 0) {
                while (true) {
                    pVarN = n();
                    if (pVarN != null) {
                        break;
                        break;
                    }
                    if (pVarN instanceof i) {
                        this.size = i;
                        d0.z.d.m.checkNotNull(pVarN);
                        reentrantLock.unlock();
                        return pVarN;
                    }
                    d0.z.d.m.checkNotNull(pVarN);
                    if (pVarN.d(e, null) != null) {
                        this.size = i;
                        reentrantLock.unlock();
                        d0.z.d.m.checkNotNull(pVarN);
                        pVarN.c(e);
                        d0.z.d.m.checkNotNull(pVarN);
                        return pVarN.b();
                    }
                }
            }
            w(i, e);
            s.a.a.t tVar3 = b.f3834b;
            reentrantLock.unlock();
            return tVar3;
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    @Override // s.a.c2.a
    public boolean r(n<? super E> nVar) {
        ReentrantLock reentrantLock = this.m;
        reentrantLock.lock();
        try {
            return super.r(nVar);
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // s.a.c2.a
    public final boolean s() {
        return false;
    }

    @Override // s.a.c2.a
    public final boolean t() {
        return this.size == 0;
    }

    @Override // s.a.c2.a
    public void u(boolean z2) {
        Function1<E, Unit> function1 = this.l;
        ReentrantLock reentrantLock = this.m;
        reentrantLock.lock();
        try {
            int i = this.size;
            UndeliveredElementException undeliveredElementExceptionP = null;
            for (int i2 = 0; i2 < i; i2++) {
                Object obj = this.n[this.o];
                if (function1 != null && obj != b.a) {
                    undeliveredElementExceptionP = b.i.a.f.e.o.f.p(function1, obj, undeliveredElementExceptionP);
                }
                Object[] objArr = this.n;
                int i3 = this.o;
                objArr[i3] = b.a;
                this.o = (i3 + 1) % objArr.length;
            }
            this.size = 0;
            reentrantLock.unlock();
            super.u(z2);
            if (undeliveredElementExceptionP != null) {
                throw undeliveredElementExceptionP;
            }
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    @Override // s.a.c2.a
    public Object v() {
        ReentrantLock reentrantLock = this.m;
        reentrantLock.lock();
        try {
            int i = this.size;
            if (i == 0) {
                Object objE = e();
                if (objE == null) {
                    objE = b.d;
                }
                reentrantLock.unlock();
                return objE;
            }
            Object[] objArr = this.n;
            int i2 = this.o;
            Object obj = objArr[i2];
            r rVar = null;
            objArr[i2] = null;
            this.size = i - 1;
            Object objR = b.d;
            boolean z2 = false;
            if (i == this.p) {
                r rVar2 = null;
                while (true) {
                    r rVarQ = q();
                    if (rVarQ == null) {
                        rVar = rVar2;
                        break;
                    }
                    d0.z.d.m.checkNotNull(rVarQ);
                    if (rVarQ.t(null) != null) {
                        d0.z.d.m.checkNotNull(rVarQ);
                        objR = rVarQ.r();
                        rVar = rVarQ;
                        z2 = true;
                        break;
                    }
                    d0.z.d.m.checkNotNull(rVarQ);
                    rVarQ.u();
                    rVar2 = rVarQ;
                }
            }
            if (objR != b.d && !(objR instanceof i)) {
                this.size = i;
                Object[] objArr2 = this.n;
                objArr2[(this.o + i) % objArr2.length] = objR;
            }
            this.o = (this.o + 1) % this.n.length;
            reentrantLock.unlock();
            if (z2) {
                d0.z.d.m.checkNotNull(rVar);
                rVar.q();
            }
            return obj;
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public final void w(int i, E e) {
        int i2 = this.p;
        if (i >= i2) {
            Object[] objArr = this.n;
            int i3 = this.o;
            objArr[i3 % objArr.length] = null;
            objArr[(i + i3) % objArr.length] = e;
            this.o = (i3 + 1) % objArr.length;
            return;
        }
        Object[] objArr2 = this.n;
        if (i >= objArr2.length) {
            int iMin = Math.min(objArr2.length * 2, i2);
            Object[] objArr3 = new Object[iMin];
            for (int i4 = 0; i4 < i; i4++) {
                Object[] objArr4 = this.n;
                objArr3[i4] = objArr4[(this.o + i4) % objArr4.length];
            }
            d0.t.j.fill((s.a.a.t[]) objArr3, b.a, i, iMin);
            this.n = objArr3;
            this.o = 0;
        }
        Object[] objArr5 = this.n;
        objArr5[(this.o + i) % objArr5.length] = e;
    }
}
