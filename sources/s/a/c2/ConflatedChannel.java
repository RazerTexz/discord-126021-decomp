package s.a.c2;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.internal.OnUndeliveredElement;
import s.a.a.Symbol3;

/* JADX INFO: renamed from: s.a.c2.j, reason: use source file name */
/* JADX INFO: compiled from: ConflatedChannel.kt */
/* JADX INFO: loaded from: classes3.dex */
public class ConflatedChannel<E> extends AbstractChannel<E> {
    public final ReentrantLock m;
    public Object n;

    public ConflatedChannel(Function1<? super E, Unit> function1) {
        super(function1);
        this.m = new ReentrantLock();
        this.n = AbstractChannel2.a;
    }

    @Override // s.a.c2.AbstractChannel3
    public String d() {
        StringBuilder sbU = outline.U("(value=");
        sbU.append(this.n);
        sbU.append(')');
        return sbU.toString();
    }

    @Override // s.a.c2.AbstractChannel3
    public final boolean h() {
        return false;
    }

    @Override // s.a.c2.AbstractChannel3
    public final boolean i() {
        return false;
    }

    @Override // s.a.c2.AbstractChannel3
    public Object k(E e) {
        ReentrantLock reentrantLock = this.m;
        reentrantLock.lock();
        try {
            AbstractChannel4<?> abstractChannel4E = e();
            if (abstractChannel4E != null) {
                reentrantLock.unlock();
                return abstractChannel4E;
            }
            if (this.n == AbstractChannel2.a) {
                while (true) {
                    AbstractChannel6<E> abstractChannel6N = n();
                    if (abstractChannel6N == null) {
                        break;
                    }
                    if (abstractChannel6N instanceof AbstractChannel4) {
                        Intrinsics3.checkNotNull(abstractChannel6N);
                        reentrantLock.unlock();
                        return abstractChannel6N;
                    }
                    Intrinsics3.checkNotNull(abstractChannel6N);
                    if (abstractChannel6N.d(e, null) != null) {
                        reentrantLock.unlock();
                        Intrinsics3.checkNotNull(abstractChannel6N);
                        abstractChannel6N.c(e);
                        Intrinsics3.checkNotNull(abstractChannel6N);
                        return abstractChannel6N.b();
                    }
                }
            }
            OnUndeliveredElement onUndeliveredElementW = w(e);
            if (onUndeliveredElementW != null) {
                throw onUndeliveredElementW;
            }
            Symbol3 symbol3 = AbstractChannel2.f3834b;
            reentrantLock.unlock();
            return symbol3;
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    @Override // s.a.c2.AbstractChannel
    public boolean r(AbstractChannel5<? super E> abstractChannel5) {
        ReentrantLock reentrantLock = this.m;
        reentrantLock.lock();
        try {
            return super.r(abstractChannel5);
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // s.a.c2.AbstractChannel
    public final boolean s() {
        return false;
    }

    @Override // s.a.c2.AbstractChannel
    public final boolean t() {
        return this.n == AbstractChannel2.a;
    }

    @Override // s.a.c2.AbstractChannel
    public void u(boolean z2) {
        ReentrantLock reentrantLock = this.m;
        reentrantLock.lock();
        try {
            OnUndeliveredElement onUndeliveredElementW = w(AbstractChannel2.a);
            reentrantLock.unlock();
            super.u(z2);
            if (onUndeliveredElementW != null) {
                throw onUndeliveredElementW;
            }
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    @Override // s.a.c2.AbstractChannel
    public Object v() {
        ReentrantLock reentrantLock = this.m;
        reentrantLock.lock();
        try {
            Object obj = this.n;
            Symbol3 symbol3 = AbstractChannel2.a;
            if (obj != symbol3) {
                this.n = symbol3;
                return obj;
            }
            Object objE = e();
            if (objE == null) {
                objE = AbstractChannel2.d;
            }
            return objE;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final OnUndeliveredElement w(Object obj) {
        Function1<E, Unit> function1;
        Object obj2 = this.n;
        OnUndeliveredElement onUndeliveredElementQ = null;
        if (obj2 != AbstractChannel2.a && (function1 = this.l) != null) {
            onUndeliveredElementQ = b.i.a.f.e.o.f.q(function1, obj2, null, 2);
        }
        this.n = obj;
        return onUndeliveredElementQ;
    }
}
