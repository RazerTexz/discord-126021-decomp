package s.a.c2;

import java.util.concurrent.locks.ReentrantLock;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.internal.UndeliveredElementException;

/* JADX INFO: compiled from: ConflatedChannel.kt */
/* JADX INFO: loaded from: classes3.dex */
public class j<E> extends a<E> {
    public final ReentrantLock m;
    public Object n;

    public j(Function1<? super E, Unit> function1) {
        super(function1);
        this.m = new ReentrantLock();
        this.n = b.a;
    }

    @Override // s.a.c2.c
    public String d() {
        StringBuilder sbU = b.d.b.a.a.U("(value=");
        sbU.append(this.n);
        sbU.append(')');
        return sbU.toString();
    }

    @Override // s.a.c2.c
    public final boolean h() {
        return false;
    }

    @Override // s.a.c2.c
    public final boolean i() {
        return false;
    }

    @Override // s.a.c2.c
    public Object k(E e) {
        ReentrantLock reentrantLock = this.m;
        reentrantLock.lock();
        try {
            i<?> iVarE = e();
            if (iVarE != null) {
                reentrantLock.unlock();
                return iVarE;
            }
            if (this.n == b.a) {
                while (true) {
                    p<E> pVarN = n();
                    if (pVarN == null) {
                        break;
                    }
                    if (pVarN instanceof i) {
                        d0.z.d.m.checkNotNull(pVarN);
                        reentrantLock.unlock();
                        return pVarN;
                    }
                    d0.z.d.m.checkNotNull(pVarN);
                    if (pVarN.d(e, null) != null) {
                        reentrantLock.unlock();
                        d0.z.d.m.checkNotNull(pVarN);
                        pVarN.c(e);
                        d0.z.d.m.checkNotNull(pVarN);
                        return pVarN.b();
                    }
                }
            }
            UndeliveredElementException undeliveredElementExceptionW = w(e);
            if (undeliveredElementExceptionW != null) {
                throw undeliveredElementExceptionW;
            }
            s.a.a.t tVar = b.f3834b;
            reentrantLock.unlock();
            return tVar;
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
        return this.n == b.a;
    }

    @Override // s.a.c2.a
    public void u(boolean z2) {
        ReentrantLock reentrantLock = this.m;
        reentrantLock.lock();
        try {
            UndeliveredElementException undeliveredElementExceptionW = w(b.a);
            reentrantLock.unlock();
            super.u(z2);
            if (undeliveredElementExceptionW != null) {
                throw undeliveredElementExceptionW;
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
            Object obj = this.n;
            s.a.a.t tVar = b.a;
            if (obj != tVar) {
                this.n = tVar;
                return obj;
            }
            Object objE = e();
            if (objE == null) {
                objE = b.d;
            }
            return objE;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final UndeliveredElementException w(Object obj) {
        Function1<E, Unit> function1;
        Object obj2 = this.n;
        UndeliveredElementException undeliveredElementExceptionQ = null;
        if (obj2 != b.a && (function1 = this.l) != null) {
            undeliveredElementExceptionQ = b.i.a.f.e.o.f.q(function1, obj2, null, 2);
        }
        this.n = obj;
        return undeliveredElementExceptionQ;
    }
}
