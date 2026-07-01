package j0.l.e.o;

import java.util.Iterator;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: ConcurrentCircularArrayQueue.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class e<E> extends f<E> {
    public static final int j;
    public static final long k;
    public static final int l;
    public final long m;
    public final E[] n;

    static {
        int iIntValue = Integer.getInteger("sparse.shift", 0).intValue();
        j = iIntValue;
        Unsafe unsafe = y.a;
        int iArrayIndexScale = unsafe.arrayIndexScale(Object[].class);
        if (4 == iArrayIndexScale) {
            l = iIntValue + 2;
        } else {
            if (8 != iArrayIndexScale) {
                throw new IllegalStateException("Unknown pointer size");
            }
            l = iIntValue + 3;
        }
        k = unsafe.arrayBaseOffset(Object[].class) + (32 << (l - iIntValue));
    }

    public e(int i) {
        int iB = j0.l.e.m.b(i);
        this.m = iB - 1;
        this.n = (E[]) new Object[(iB << j) + 64];
    }

    public final long c(long j2) {
        return k + ((j2 & this.m) << l);
    }

    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
    public void clear() {
        while (true) {
            if (poll() == null && isEmpty()) {
                return;
            }
        }
    }

    public final E d(E[] eArr, long j2) {
        return (E) y.a.getObject(eArr, j2);
    }

    public final E e(E[] eArr, long j2) {
        return (E) y.a.getObjectVolatile(eArr, j2);
    }

    public final void g(E[] eArr, long j2, E e) {
        y.a.putOrderedObject(eArr, j2, e);
    }

    public final void h(E[] eArr, long j2, E e) {
        y.a.putObject(eArr, j2, e);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }
}
