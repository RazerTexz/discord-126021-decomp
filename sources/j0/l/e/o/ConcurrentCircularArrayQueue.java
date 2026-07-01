package j0.l.e.o;

import j0.l.e.UtilityFunctions;
import java.util.Iterator;
import sun.misc.Unsafe;

/* JADX INFO: renamed from: j0.l.e.o.e, reason: use source file name */
/* JADX INFO: compiled from: ConcurrentCircularArrayQueue.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class ConcurrentCircularArrayQueue<E> extends ConcurrentCircularArrayQueue2<E> {
    public static final int j;
    public static final long k;
    public static final int l;
    public final long m;
    public final E[] n;

    static {
        int iIntValue = Integer.getInteger("sparse.shift", 0).intValue();
        j = iIntValue;
        Unsafe unsafe = UnsafeAccess.a;
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

    public ConcurrentCircularArrayQueue(int i) {
        int iB = UtilityFunctions.b(i);
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
        return (E) UnsafeAccess.a.getObject(eArr, j2);
    }

    public final E e(E[] eArr, long j2) {
        return (E) UnsafeAccess.a.getObjectVolatile(eArr, j2);
    }

    public final void g(E[] eArr, long j2, E e) {
        UnsafeAccess.a.putOrderedObject(eArr, j2, e);
    }

    public final void h(E[] eArr, long j2, E e) {
        UnsafeAccess.a.putObject(eArr, j2, e);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }
}
