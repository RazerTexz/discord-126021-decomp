package j0.l.e.o;

import java.util.Objects;

/* JADX INFO: renamed from: j0.l.e.o.n, reason: use source file name */
/* JADX INFO: compiled from: SpscArrayQueue.java */
/* JADX INFO: loaded from: classes3.dex */
public final class SpscArrayQueue<E> {
    public SpscArrayQueue(int i) {
        super(i);
    }

    public final long i() {
        return UnsafeAccess.a.getLongVolatile(this, SpscArrayQueue2.q);
    }

    public boolean isEmpty() {
        return j() == i();
    }

    public final long j() {
        return UnsafeAccess.a.getLongVolatile(this, SpscArrayQueue5.p);
    }

    public final void k(long j) {
        UnsafeAccess.a.putOrderedLong(this, SpscArrayQueue2.q, j);
    }

    public final void l(long j) {
        UnsafeAccess.a.putOrderedLong(this, SpscArrayQueue5.p, j);
    }

    public boolean offer(E e) {
        Objects.requireNonNull(e, "null elements not allowed");
        E[] eArr = this.n;
        long j = this.producerIndex;
        long jC = c(j);
        if (e(eArr, jC) != null) {
            return false;
        }
        g(eArr, jC, e);
        l(j + 1);
        return true;
    }

    public E peek() {
        return e(this.n, c(this.consumerIndex));
    }

    public E poll() {
        long j = this.consumerIndex;
        long jC = c(j);
        E[] eArr = this.n;
        E e = e(eArr, jC);
        if (e == null) {
            return null;
        }
        g(eArr, jC, null);
        k(j + 1);
        return e;
    }

    public int size() {
        long jI = i();
        while (true) {
            long j = j();
            long jI2 = i();
            if (jI == jI2) {
                return (int) (j - jI2);
            }
            jI = jI2;
        }
    }
}
