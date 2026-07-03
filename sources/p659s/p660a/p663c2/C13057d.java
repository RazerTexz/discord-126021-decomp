package p659s.p660a.p663c2;

import java.util.concurrent.locks.ReentrantLock;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.internal.UndeliveredElementException;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p507d0.p580t.C12139j;
import p507d0.p592z.p594d.C12238m;
import p659s.p660a.p661a.C13037t;

/* JADX INFO: renamed from: s.a.c2.d */
/* JADX INFO: compiled from: ArrayChannel.kt */
/* JADX INFO: loaded from: classes3.dex */
public class C13057d<E> extends AbstractC13054a<E> {

    /* JADX INFO: renamed from: m */
    public final ReentrantLock f27750m;

    /* JADX INFO: renamed from: n */
    public Object[] f27751n;

    /* JADX INFO: renamed from: o */
    public int f27752o;

    /* JADX INFO: renamed from: p */
    public final int f27753p;

    /* JADX INFO: renamed from: q */
    public final EnumC13058e f27754q;
    public volatile int size;

    public C13057d(int i, EnumC13058e enumC13058e, Function1<? super E, Unit> function1) {
        super(function1);
        this.f27753p = i;
        this.f27754q = enumC13058e;
        if (!(i >= 1)) {
            throw new IllegalArgumentException(C1643a.m873r("ArrayChannel capacity must be at least 1, but ", i, " was specified").toString());
        }
        this.f27750m = new ReentrantLock();
        Object[] objArr = new Object[Math.min(i, 8)];
        C12139j.fill$default(objArr, C13055b.f27739a, 0, 0, 6, null);
        this.f27751n = objArr;
        this.size = 0;
    }

    @Override // p659s.p660a.p663c2.AbstractC13056c
    /* JADX INFO: renamed from: c */
    public Object mo11214c(AbstractC13071r abstractC13071r) {
        ReentrantLock reentrantLock = this.f27750m;
        reentrantLock.lock();
        try {
            return super.mo11214c(abstractC13071r);
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // p659s.p660a.p663c2.AbstractC13056c
    /* JADX INFO: renamed from: d */
    public String mo11215d() {
        StringBuilder sbM833U = C1643a.m833U("(buffer:capacity=");
        sbM833U.append(this.f27753p);
        sbM833U.append(",size=");
        return C1643a.m813A(sbM833U, this.size, ')');
    }

    @Override // p659s.p660a.p663c2.AbstractC13056c
    /* JADX INFO: renamed from: h */
    public final boolean mo11219h() {
        return false;
    }

    @Override // p659s.p660a.p663c2.AbstractC13056c
    /* JADX INFO: renamed from: i */
    public final boolean mo11220i() {
        return this.size == this.f27753p && this.f27754q == EnumC13058e.SUSPEND;
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
    @Override // p659s.p660a.p663c2.AbstractC13056c
    /* JADX INFO: renamed from: k */
    public Object mo11222k(E e) {
        C13037t c13037t;
        InterfaceC13069p<E> interfaceC13069pMo11201n;
        ReentrantLock reentrantLock = this.f27750m;
        reentrantLock.lock();
        try {
            int i = this.size;
            C13062i<?> c13062iM11216e = m11216e();
            if (c13062iM11216e != null) {
                reentrantLock.unlock();
                return c13062iM11216e;
            }
            if (i >= this.f27753p) {
                int iOrdinal = this.f27754q.ordinal();
                if (iOrdinal == 0) {
                    c13037t = C13055b.f27741c;
                } else if (iOrdinal != 1) {
                    if (iOrdinal != 2) {
                        throw new NoWhenBranchMatchedException();
                    }
                    c13037t = C13055b.f27740b;
                }
                if (c13037t != null) {
                    reentrantLock.unlock();
                    return c13037t;
                }
                if (i == 0) {
                    while (true) {
                        interfaceC13069pMo11201n = mo11201n();
                        if (interfaceC13069pMo11201n != null) {
                            break;
                        }
                        if (interfaceC13069pMo11201n instanceof C13062i) {
                            this.size = i;
                            C12238m.checkNotNull(interfaceC13069pMo11201n);
                            reentrantLock.unlock();
                            return interfaceC13069pMo11201n;
                        }
                        C12238m.checkNotNull(interfaceC13069pMo11201n);
                        if (interfaceC13069pMo11201n.mo11210d(e, null) != null) {
                            this.size = i;
                            reentrantLock.unlock();
                            C12238m.checkNotNull(interfaceC13069pMo11201n);
                            interfaceC13069pMo11201n.mo11209c(e);
                            C12238m.checkNotNull(interfaceC13069pMo11201n);
                            return interfaceC13069pMo11201n.mo11232b();
                        }
                    }
                }
                m11231w(i, e);
                C13037t c13037t2 = C13055b.f27740b;
                reentrantLock.unlock();
                return c13037t2;
            }
            this.size = i + 1;
            c13037t = null;
            if (c13037t != null) {
                reentrantLock.unlock();
                return c13037t;
            }
            if (i == 0) {
                while (true) {
                    interfaceC13069pMo11201n = mo11201n();
                    if (interfaceC13069pMo11201n != null) {
                        break;
                        break;
                    }
                    if (interfaceC13069pMo11201n instanceof C13062i) {
                        this.size = i;
                        C12238m.checkNotNull(interfaceC13069pMo11201n);
                        reentrantLock.unlock();
                        return interfaceC13069pMo11201n;
                    }
                    C12238m.checkNotNull(interfaceC13069pMo11201n);
                    if (interfaceC13069pMo11201n.mo11210d(e, null) != null) {
                        this.size = i;
                        reentrantLock.unlock();
                        C12238m.checkNotNull(interfaceC13069pMo11201n);
                        interfaceC13069pMo11201n.mo11209c(e);
                        C12238m.checkNotNull(interfaceC13069pMo11201n);
                        return interfaceC13069pMo11201n.mo11232b();
                    }
                }
            }
            m11231w(i, e);
            C13037t c13037t3 = C13055b.f27740b;
            reentrantLock.unlock();
            return c13037t3;
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    @Override // p659s.p660a.p663c2.AbstractC13054a
    /* JADX INFO: renamed from: r */
    public boolean mo11202r(AbstractC13067n<? super E> abstractC13067n) {
        ReentrantLock reentrantLock = this.f27750m;
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
        return this.size == 0;
    }

    @Override // p659s.p660a.p663c2.AbstractC13054a
    /* JADX INFO: renamed from: u */
    public void mo11205u(boolean z2) {
        Function1<E, Unit> function1 = this.f27747l;
        ReentrantLock reentrantLock = this.f27750m;
        reentrantLock.lock();
        try {
            int i = this.size;
            UndeliveredElementException undeliveredElementExceptionM4327p = null;
            for (int i2 = 0; i2 < i; i2++) {
                Object obj = this.f27751n[this.f27752o];
                if (function1 != null && obj != C13055b.f27739a) {
                    undeliveredElementExceptionM4327p = C3404f.m4327p(function1, obj, undeliveredElementExceptionM4327p);
                }
                Object[] objArr = this.f27751n;
                int i3 = this.f27752o;
                objArr[i3] = C13055b.f27739a;
                this.f27752o = (i3 + 1) % objArr.length;
            }
            this.size = 0;
            reentrantLock.unlock();
            super.mo11205u(z2);
            if (undeliveredElementExceptionM4327p != null) {
                throw undeliveredElementExceptionM4327p;
            }
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    @Override // p659s.p660a.p663c2.AbstractC13054a
    /* JADX INFO: renamed from: v */
    public Object mo11206v() {
        ReentrantLock reentrantLock = this.f27750m;
        reentrantLock.lock();
        try {
            int i = this.size;
            if (i == 0) {
                Object objM11216e = m11216e();
                if (objM11216e == null) {
                    objM11216e = C13055b.f27742d;
                }
                reentrantLock.unlock();
                return objM11216e;
            }
            Object[] objArr = this.f27751n;
            int i2 = this.f27752o;
            Object obj = objArr[i2];
            AbstractC13071r abstractC13071r = null;
            objArr[i2] = null;
            this.size = i - 1;
            Object objMo11228r = C13055b.f27742d;
            boolean z2 = false;
            if (i == this.f27753p) {
                AbstractC13071r abstractC13071r2 = null;
                while (true) {
                    AbstractC13071r abstractC13071rM11226q = m11226q();
                    if (abstractC13071rM11226q == null) {
                        abstractC13071r = abstractC13071r2;
                        break;
                    }
                    C12238m.checkNotNull(abstractC13071rM11226q);
                    if (abstractC13071rM11226q.mo11230t(null) != null) {
                        C12238m.checkNotNull(abstractC13071rM11226q);
                        objMo11228r = abstractC13071rM11226q.mo11228r();
                        abstractC13071r = abstractC13071rM11226q;
                        z2 = true;
                        break;
                    }
                    C12238m.checkNotNull(abstractC13071rM11226q);
                    abstractC13071rM11226q.mo11241u();
                    abstractC13071r2 = abstractC13071rM11226q;
                }
            }
            if (objMo11228r != C13055b.f27742d && !(objMo11228r instanceof C13062i)) {
                this.size = i;
                Object[] objArr2 = this.f27751n;
                objArr2[(this.f27752o + i) % objArr2.length] = objMo11228r;
            }
            this.f27752o = (this.f27752o + 1) % this.f27751n.length;
            reentrantLock.unlock();
            if (z2) {
                C12238m.checkNotNull(abstractC13071r);
                abstractC13071r.mo11227q();
            }
            return obj;
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    /* JADX INFO: renamed from: w */
    public final void m11231w(int i, E e) {
        int i2 = this.f27753p;
        if (i >= i2) {
            Object[] objArr = this.f27751n;
            int i3 = this.f27752o;
            objArr[i3 % objArr.length] = null;
            objArr[(i + i3) % objArr.length] = e;
            this.f27752o = (i3 + 1) % objArr.length;
            return;
        }
        Object[] objArr2 = this.f27751n;
        if (i >= objArr2.length) {
            int iMin = Math.min(objArr2.length * 2, i2);
            Object[] objArr3 = new Object[iMin];
            for (int i4 = 0; i4 < i; i4++) {
                Object[] objArr4 = this.f27751n;
                objArr3[i4] = objArr4[(this.f27752o + i4) % objArr4.length];
            }
            C12139j.fill((C13037t[]) objArr3, C13055b.f27739a, i, iMin);
            this.f27751n = objArr3;
            this.f27752o = 0;
        }
        Object[] objArr5 = this.f27751n;
        objArr5[(this.f27752o + i) % objArr5.length] = e;
    }
}
