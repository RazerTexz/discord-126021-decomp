package p637j0.p642l.p647e.p649o;

import java.util.Objects;

/* JADX INFO: renamed from: j0.l.e.o.n */
/* JADX INFO: compiled from: SpscArrayQueue.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C12744n<E> {
    public C12744n(int i) {
        super(i);
    }

    /* JADX INFO: renamed from: i */
    public final long m10844i() {
        return C12755y.f27357a.getLongVolatile(this, AbstractC12745o.f27342q);
    }

    public boolean isEmpty() {
        return m10845j() == m10844i();
    }

    /* JADX INFO: renamed from: j */
    public final long m10845j() {
        return C12755y.f27357a.getLongVolatile(this, AbstractC12748r.f27344p);
    }

    /* JADX INFO: renamed from: k */
    public final void m10846k(long j) {
        C12755y.f27357a.putOrderedLong(this, AbstractC12745o.f27342q, j);
    }

    /* JADX INFO: renamed from: l */
    public final void m10847l(long j) {
        C12755y.f27357a.putOrderedLong(this, AbstractC12748r.f27344p, j);
    }

    public boolean offer(E e) {
        Objects.requireNonNull(e, "null elements not allowed");
        E[] eArr = this.f27338n;
        long j = this.producerIndex;
        long jM10835c = m10835c(j);
        if (m10837e(eArr, jM10835c) != null) {
            return false;
        }
        m10838g(eArr, jM10835c, e);
        m10847l(j + 1);
        return true;
    }

    public E peek() {
        return m10837e(this.f27338n, m10835c(this.consumerIndex));
    }

    public E poll() {
        long j = this.consumerIndex;
        long jM10835c = m10835c(j);
        E[] eArr = this.f27338n;
        E eM10837e = m10837e(eArr, jM10835c);
        if (eM10837e == null) {
            return null;
        }
        m10838g(eArr, jM10835c, null);
        m10846k(j + 1);
        return eM10837e;
    }

    public int size() {
        long jM10844i = m10844i();
        while (true) {
            long jM10845j = m10845j();
            long jM10844i2 = m10844i();
            if (jM10844i == jM10844i2) {
                return (int) (jM10845j - jM10844i2);
            }
            jM10844i = jM10844i2;
        }
    }
}
