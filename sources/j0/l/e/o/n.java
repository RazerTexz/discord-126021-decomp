package j0.l.e.o;

import java.util.Objects;

/* JADX INFO: compiled from: SpscArrayQueue.java */
/* JADX INFO: loaded from: classes3.dex */
public final class n<E> {
    public n(int i) {
        super(i);
    }

    public final long i() {
        return y.a.getLongVolatile(this, o.q);
    }

    public boolean isEmpty() {
        return j() == i();
    }

    public final long j() {
        return y.a.getLongVolatile(this, r.p);
    }

    public final void k(long j) {
        y.a.putOrderedLong(this, o.q, j);
    }

    public final void l(long j) {
        y.a.putOrderedLong(this, r.p, j);
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
