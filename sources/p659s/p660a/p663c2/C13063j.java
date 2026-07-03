package p659s.p660a.p663c2;

import java.util.concurrent.locks.ReentrantLock;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.internal.UndeliveredElementException;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p507d0.p592z.p594d.C12238m;
import p659s.p660a.p661a.C13037t;

/* JADX INFO: renamed from: s.a.c2.j */
/* JADX INFO: compiled from: ConflatedChannel.kt */
/* JADX INFO: loaded from: classes3.dex */
public class C13063j<E> extends AbstractC13054a<E> {

    /* JADX INFO: renamed from: m */
    public final ReentrantLock f27764m;

    /* JADX INFO: renamed from: n */
    public Object f27765n;

    public C13063j(Function1<? super E, Unit> function1) {
        super(function1);
        this.f27764m = new ReentrantLock();
        this.f27765n = C13055b.f27739a;
    }

    @Override // p659s.p660a.p663c2.AbstractC13056c
    /* JADX INFO: renamed from: d */
    public String mo11215d() {
        StringBuilder sbM833U = C1643a.m833U("(value=");
        sbM833U.append(this.f27765n);
        sbM833U.append(')');
        return sbM833U.toString();
    }

    @Override // p659s.p660a.p663c2.AbstractC13056c
    /* JADX INFO: renamed from: h */
    public final boolean mo11219h() {
        return false;
    }

    @Override // p659s.p660a.p663c2.AbstractC13056c
    /* JADX INFO: renamed from: i */
    public final boolean mo11220i() {
        return false;
    }

    @Override // p659s.p660a.p663c2.AbstractC13056c
    /* JADX INFO: renamed from: k */
    public Object mo11222k(E e) {
        ReentrantLock reentrantLock = this.f27764m;
        reentrantLock.lock();
        try {
            C13062i<?> c13062iM11216e = m11216e();
            if (c13062iM11216e != null) {
                reentrantLock.unlock();
                return c13062iM11216e;
            }
            if (this.f27765n == C13055b.f27739a) {
                while (true) {
                    InterfaceC13069p<E> interfaceC13069pMo11201n = mo11201n();
                    if (interfaceC13069pMo11201n == null) {
                        break;
                    }
                    if (interfaceC13069pMo11201n instanceof C13062i) {
                        C12238m.checkNotNull(interfaceC13069pMo11201n);
                        reentrantLock.unlock();
                        return interfaceC13069pMo11201n;
                    }
                    C12238m.checkNotNull(interfaceC13069pMo11201n);
                    if (interfaceC13069pMo11201n.mo11210d(e, null) != null) {
                        reentrantLock.unlock();
                        C12238m.checkNotNull(interfaceC13069pMo11201n);
                        interfaceC13069pMo11201n.mo11209c(e);
                        C12238m.checkNotNull(interfaceC13069pMo11201n);
                        return interfaceC13069pMo11201n.mo11232b();
                    }
                }
            }
            UndeliveredElementException undeliveredElementExceptionM11235w = m11235w(e);
            if (undeliveredElementExceptionM11235w != null) {
                throw undeliveredElementExceptionM11235w;
            }
            C13037t c13037t = C13055b.f27740b;
            reentrantLock.unlock();
            return c13037t;
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    @Override // p659s.p660a.p663c2.AbstractC13054a
    /* JADX INFO: renamed from: r */
    public boolean mo11202r(AbstractC13067n<? super E> abstractC13067n) {
        ReentrantLock reentrantLock = this.f27764m;
        reentrantLock.lock();
        try {
            return super.mo11202r(abstractC13067n);
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // p659s.p660a.p663c2.AbstractC13054a
    /* JADX INFO: renamed from: s */
    public final boolean mo11203s() {
        return false;
    }

    @Override // p659s.p660a.p663c2.AbstractC13054a
    /* JADX INFO: renamed from: t */
    public final boolean mo11204t() {
        return this.f27765n == C13055b.f27739a;
    }

    @Override // p659s.p660a.p663c2.AbstractC13054a
    /* JADX INFO: renamed from: u */
    public void mo11205u(boolean z2) {
        ReentrantLock reentrantLock = this.f27764m;
        reentrantLock.lock();
        try {
            UndeliveredElementException undeliveredElementExceptionM11235w = m11235w(C13055b.f27739a);
            reentrantLock.unlock();
            super.mo11205u(z2);
            if (undeliveredElementExceptionM11235w != null) {
                throw undeliveredElementExceptionM11235w;
            }
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    @Override // p659s.p660a.p663c2.AbstractC13054a
    /* JADX INFO: renamed from: v */
    public Object mo11206v() {
        ReentrantLock reentrantLock = this.f27764m;
        reentrantLock.lock();
        try {
            Object obj = this.f27765n;
            C13037t c13037t = C13055b.f27739a;
            if (obj != c13037t) {
                this.f27765n = c13037t;
                return obj;
            }
            Object objM11216e = m11216e();
            if (objM11216e == null) {
                objM11216e = C13055b.f27742d;
            }
            return objM11216e;
        } finally {
            reentrantLock.unlock();
        }
    }

    /* JADX INFO: renamed from: w */
    public final UndeliveredElementException m11235w(Object obj) {
        Function1<E, Unit> function1;
        Object obj2 = this.f27765n;
        UndeliveredElementException undeliveredElementExceptionM4331q = null;
        if (obj2 != C13055b.f27739a && (function1 = this.f27747l) != null) {
            undeliveredElementExceptionM4331q = C3404f.m4331q(function1, obj2, null, 2);
        }
        this.f27765n = obj;
        return undeliveredElementExceptionM4331q;
    }
}
