package j0.l.e.o;

import java.util.Iterator;
import java.util.Objects;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: SpscUnboundedArrayQueue.java */
/* JADX INFO: loaded from: classes3.dex */
public class t<E> extends v<E> {
    public static final long q;
    public static final long r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final long f3798s;
    public static final int t;
    public static final int p = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();
    public static final Object u = new Object();

    static {
        Unsafe unsafe = y.a;
        int iArrayIndexScale = unsafe.arrayIndexScale(Object[].class);
        if (4 == iArrayIndexScale) {
            t = 2;
        } else {
            if (8 != iArrayIndexScale) {
                throw new IllegalStateException("Unknown pointer size");
            }
            t = 3;
        }
        f3798s = unsafe.arrayBaseOffset(Object[].class);
        try {
            q = unsafe.objectFieldOffset(x.class.getDeclaredField("producerIndex"));
            try {
                r = unsafe.objectFieldOffset(v.class.getDeclaredField("consumerIndex"));
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

    public t(int i) {
        int iB = j0.l.e.m.b(i);
        long j = iB - 1;
        E[] eArr = (E[]) new Object[iB + 1];
        this.m = eArr;
        this.l = j;
        this.j = Math.min(iB / 4, p);
        this.o = eArr;
        this.n = j;
        this.k = j - 1;
        k(0L);
    }

    public static long c(long j) {
        return f3798s + (j << t);
    }

    public static long d(long j, long j2) {
        return c(j & j2);
    }

    public static <E> Object g(E[] eArr, long j) {
        return y.a.getObjectVolatile(eArr, j);
    }

    public static void j(Object[] objArr, long j, Object obj) {
        y.a.putOrderedObject(objArr, j, obj);
    }

    public final long e() {
        return y.a.getLongVolatile(this, r);
    }

    public final long h() {
        return y.a.getLongVolatile(this, q);
    }

    public final void i(long j) {
        y.a.putOrderedLong(this, r, j);
    }

    public final Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }

    public final void k(long j) {
        y.a.putOrderedLong(this, q, j);
    }

    public final boolean l(E[] eArr, E e, long j, long j2) {
        j(eArr, j2, e);
        k(j + 1);
        return true;
    }

    public final boolean offer(E e) {
        Objects.requireNonNull(e, "Null is not a valid element");
        E[] eArr = this.m;
        long j = this.producerIndex;
        long j2 = this.l;
        long jD = d(j, j2);
        if (j < this.k) {
            l(eArr, e, j, jD);
            return true;
        }
        long j3 = ((long) this.j) + j;
        if (g(eArr, d(j3, j2)) == null) {
            this.k = j3 - 1;
            l(eArr, e, j, jD);
            return true;
        }
        long j4 = j + 1;
        if (g(eArr, d(j4, j2)) != null) {
            l(eArr, e, j, jD);
            return true;
        }
        E[] eArr2 = (E[]) new Object[eArr.length];
        this.m = eArr2;
        this.k = (j2 + j) - 1;
        j(eArr2, jD, e);
        j(eArr, c(eArr.length - 1), eArr2);
        j(eArr, jD, u);
        k(j4);
        return true;
    }

    public final E peek() {
        E[] eArr = this.o;
        long j = this.consumerIndex;
        long j2 = this.n;
        E e = (E) g(eArr, d(j, j2));
        if (e != u) {
            return e;
        }
        E[] eArr2 = (E[]) ((Object[]) g(eArr, c(eArr.length - 1)));
        this.o = eArr2;
        return (E) g(eArr2, d(j, j2));
    }

    public final E poll() {
        E[] eArr = this.o;
        long j = this.consumerIndex;
        long j2 = this.n;
        long jD = d(j, j2);
        E e = (E) g(eArr, jD);
        boolean z2 = e == u;
        if (e != null && !z2) {
            j(eArr, jD, null);
            i(j + 1);
            return e;
        }
        if (!z2) {
            return null;
        }
        E[] eArr2 = (E[]) ((Object[]) g(eArr, c(eArr.length - 1)));
        this.o = eArr2;
        long jD2 = d(j, j2);
        E e2 = (E) g(eArr2, jD2);
        if (e2 == null) {
            return null;
        }
        j(eArr2, jD2, null);
        i(j + 1);
        return e2;
    }

    public final int size() {
        long jE = e();
        while (true) {
            long jH = h();
            long jE2 = e();
            if (jE == jE2) {
                return (int) (jH - jE2);
            }
            jE = jE2;
        }
    }
}
