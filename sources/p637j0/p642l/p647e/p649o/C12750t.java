package p637j0.p642l.p647e.p649o;

import java.util.Iterator;
import java.util.Objects;
import p637j0.p642l.p647e.C12723m;
import sun.misc.Unsafe;

/* JADX INFO: renamed from: j0.l.e.o.t */
/* JADX INFO: compiled from: SpscUnboundedArrayQueue.java */
/* JADX INFO: loaded from: classes3.dex */
public class C12750t<E> extends AbstractC12752v<E> {

    /* JADX INFO: renamed from: q */
    public static final long f27346q;

    /* JADX INFO: renamed from: r */
    public static final long f27347r;

    /* JADX INFO: renamed from: s */
    public static final long f27348s;

    /* JADX INFO: renamed from: t */
    public static final int f27349t;

    /* JADX INFO: renamed from: p */
    public static final int f27345p = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();

    /* JADX INFO: renamed from: u */
    public static final Object f27350u = new Object();

    static {
        Unsafe unsafe = C12755y.f27357a;
        int iArrayIndexScale = unsafe.arrayIndexScale(Object[].class);
        if (4 == iArrayIndexScale) {
            f27349t = 2;
        } else {
            if (8 != iArrayIndexScale) {
                throw new IllegalStateException("Unknown pointer size");
            }
            f27349t = 3;
        }
        f27348s = unsafe.arrayBaseOffset(Object[].class);
        try {
            f27346q = unsafe.objectFieldOffset(AbstractC12754x.class.getDeclaredField("producerIndex"));
            try {
                f27347r = unsafe.objectFieldOffset(AbstractC12752v.class.getDeclaredField("consumerIndex"));
            } catch (NoSuchFieldException e) {
                InternalError internalError = new InternalError();
                internalError.initCause(e);
                throw internalError;
            }
        } catch (NoSuchFieldException e2) {
            InternalError internalError2 = new InternalError();
            internalError2.initCause(e2);
            throw internalError2;
        }
    }

    public C12750t(int i) {
        int iM10823b = C12723m.m10823b(i);
        long j = iM10823b - 1;
        E[] eArr = (E[]) new Object[iM10823b + 1];
        this.f27356m = eArr;
        this.f27355l = j;
        this.f27353j = Math.min(iM10823b / 4, f27345p);
        this.f27352o = eArr;
        this.f27351n = j;
        this.f27354k = j - 1;
        m10855k(0L);
    }

    /* JADX INFO: renamed from: c */
    public static long m10848c(long j) {
        return f27348s + (j << f27349t);
    }

    /* JADX INFO: renamed from: d */
    public static long m10849d(long j, long j2) {
        return m10848c(j & j2);
    }

    /* JADX INFO: renamed from: g */
    public static <E> Object m10850g(E[] eArr, long j) {
        return C12755y.f27357a.getObjectVolatile(eArr, j);
    }

    /* JADX INFO: renamed from: j */
    public static void m10851j(Object[] objArr, long j, Object obj) {
        C12755y.f27357a.putOrderedObject(objArr, j, obj);
    }

    /* JADX INFO: renamed from: e */
    public final long m10852e() {
        return C12755y.f27357a.getLongVolatile(this, f27347r);
    }

    /* JADX INFO: renamed from: h */
    public final long m10853h() {
        return C12755y.f27357a.getLongVolatile(this, f27346q);
    }

    /* JADX INFO: renamed from: i */
    public final void m10854i(long j) {
        C12755y.f27357a.putOrderedLong(this, f27347r, j);
    }

    public final Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }

    /* JADX INFO: renamed from: k */
    public final void m10855k(long j) {
        C12755y.f27357a.putOrderedLong(this, f27346q, j);
    }

    /* JADX INFO: renamed from: l */
    public final boolean m10856l(E[] eArr, E e, long j, long j2) {
        m10851j(eArr, j2, e);
        m10855k(j + 1);
        return true;
    }

    public final boolean offer(E e) {
        Objects.requireNonNull(e, "Null is not a valid element");
        E[] eArr = this.f27356m;
        long j = this.producerIndex;
        long j2 = this.f27355l;
        long jM10849d = m10849d(j, j2);
        if (j < this.f27354k) {
            m10856l(eArr, e, j, jM10849d);
            return true;
        }
        long j3 = ((long) this.f27353j) + j;
        if (m10850g(eArr, m10849d(j3, j2)) == null) {
            this.f27354k = j3 - 1;
            m10856l(eArr, e, j, jM10849d);
            return true;
        }
        long j4 = j + 1;
        if (m10850g(eArr, m10849d(j4, j2)) != null) {
            m10856l(eArr, e, j, jM10849d);
            return true;
        }
        E[] eArr2 = (E[]) new Object[eArr.length];
        this.f27356m = eArr2;
        this.f27354k = (j2 + j) - 1;
        m10851j(eArr2, jM10849d, e);
        m10851j(eArr, m10848c(eArr.length - 1), eArr2);
        m10851j(eArr, jM10849d, f27350u);
        m10855k(j4);
        return true;
    }

    public final E peek() {
        E[] eArr = this.f27352o;
        long j = this.consumerIndex;
        long j2 = this.f27351n;
        E e = (E) m10850g(eArr, m10849d(j, j2));
        if (e != f27350u) {
            return e;
        }
        E[] eArr2 = (E[]) ((Object[]) m10850g(eArr, m10848c(eArr.length - 1)));
        this.f27352o = eArr2;
        return (E) m10850g(eArr2, m10849d(j, j2));
    }

    public final E poll() {
        E[] eArr = this.f27352o;
        long j = this.consumerIndex;
        long j2 = this.f27351n;
        long jM10849d = m10849d(j, j2);
        E e = (E) m10850g(eArr, jM10849d);
        boolean z2 = e == f27350u;
        if (e != null && !z2) {
            m10851j(eArr, jM10849d, null);
            m10854i(j + 1);
            return e;
        }
        if (!z2) {
            return null;
        }
        E[] eArr2 = (E[]) ((Object[]) m10850g(eArr, m10848c(eArr.length - 1)));
        this.f27352o = eArr2;
        long jM10849d2 = m10849d(j, j2);
        E e2 = (E) m10850g(eArr2, jM10849d2);
        if (e2 == null) {
            return null;
        }
        m10851j(eArr2, jM10849d2, null);
        m10854i(j + 1);
        return e2;
    }

    public final int size() {
        long jM10852e = m10852e();
        while (true) {
            long jM10853h = m10853h();
            long jM10852e2 = m10852e();
            if (jM10852e == jM10852e2) {
                return (int) (jM10853h - jM10852e2);
            }
            jM10852e = jM10852e2;
        }
    }
}
