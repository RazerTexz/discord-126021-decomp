package p637j0.p642l.p647e.p649o;

import java.util.Iterator;
import p637j0.p642l.p647e.C12723m;
import sun.misc.Unsafe;

/* JADX INFO: renamed from: j0.l.e.o.e */
/* JADX INFO: compiled from: ConcurrentCircularArrayQueue.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC12735e<E> extends AbstractC12736f<E> {

    /* JADX INFO: renamed from: j */
    public static final int f27334j;

    /* JADX INFO: renamed from: k */
    public static final long f27335k;

    /* JADX INFO: renamed from: l */
    public static final int f27336l;

    /* JADX INFO: renamed from: m */
    public final long f27337m;

    /* JADX INFO: renamed from: n */
    public final E[] f27338n;

    static {
        int iIntValue = Integer.getInteger("sparse.shift", 0).intValue();
        f27334j = iIntValue;
        Unsafe unsafe = C12755y.f27357a;
        int iArrayIndexScale = unsafe.arrayIndexScale(Object[].class);
        if (4 == iArrayIndexScale) {
            f27336l = iIntValue + 2;
        } else {
            if (8 != iArrayIndexScale) {
                throw new IllegalStateException("Unknown pointer size");
            }
            f27336l = iIntValue + 3;
        }
        f27335k = unsafe.arrayBaseOffset(Object[].class) + (32 << (f27336l - iIntValue));
    }

    public AbstractC12735e(int i) {
        int iM10823b = C12723m.m10823b(i);
        this.f27337m = iM10823b - 1;
        this.f27338n = (E[]) new Object[(iM10823b << f27334j) + 64];
    }

    /* JADX INFO: renamed from: c */
    public final long m10835c(long j) {
        return f27335k + ((j & this.f27337m) << f27336l);
    }

    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
    public void clear() {
        while (true) {
            if (poll() == null && isEmpty()) {
                return;
            }
        }
    }

    /* JADX INFO: renamed from: d */
    public final E m10836d(E[] eArr, long j) {
        return (E) C12755y.f27357a.getObject(eArr, j);
    }

    /* JADX INFO: renamed from: e */
    public final E m10837e(E[] eArr, long j) {
        return (E) C12755y.f27357a.getObjectVolatile(eArr, j);
    }

    /* JADX INFO: renamed from: g */
    public final void m10838g(E[] eArr, long j, E e) {
        C12755y.f27357a.putOrderedObject(eArr, j, e);
    }

    /* JADX INFO: renamed from: h */
    public final void m10839h(E[] eArr, long j, E e) {
        C12755y.f27357a.putObject(eArr, j, e);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }
}
