package p637j0.p642l.p647e.p649o;

import java.util.Objects;

/* JADX INFO: renamed from: j0.l.e.o.h */
/* JADX INFO: compiled from: SpmcArrayQueue.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C12738h<E> {
    public C12738h(int i) {
        super(i);
    }

    public boolean isEmpty() {
        return m10841l() == m10842i();
    }

    public boolean offer(E e) {
        Objects.requireNonNull(e, "Null is not a valid element");
        E[] eArr = this.f27338n;
        long j = this.f27337m;
        long jM10842i = m10842i();
        long jM10835c = m10835c(jM10842i);
        if (m10837e(eArr, jM10835c) != null) {
            if (jM10842i - m10841l() > j) {
                return false;
            }
            while (m10837e(eArr, jM10835c) != null) {
            }
        }
        m10839h(eArr, jM10835c, e);
        m10843j(jM10842i + 1);
        return true;
    }

    public E peek() {
        E eM10837e;
        long j = this.f27341q;
        do {
            long jM10841l = m10841l();
            if (jM10841l >= j) {
                long jM10842i = m10842i();
                if (jM10841l >= jM10842i) {
                    return null;
                }
                this.f27341q = jM10842i;
            }
            eM10837e = m10837e(this.f27338n, m10835c(jM10841l));
        } while (eM10837e == null);
        return eM10837e;
    }

    public E poll() {
        long jM10841l;
        long j = this.f27341q;
        do {
            jM10841l = m10841l();
            if (jM10841l >= j) {
                long jM10842i = m10842i();
                if (jM10841l >= jM10842i) {
                    return null;
                }
                this.f27341q = jM10842i;
            }
        } while (!m10840k(jM10841l, 1 + jM10841l));
        long jM10835c = m10835c(jM10841l);
        E[] eArr = this.f27338n;
        E eM10836d = m10836d(eArr, jM10835c);
        m10838g(eArr, jM10835c, null);
        return eM10836d;
    }

    public int size() {
        long jM10841l = m10841l();
        while (true) {
            long jM10842i = m10842i();
            long jM10841l2 = m10841l();
            if (jM10841l == jM10841l2) {
                return (int) (jM10842i - jM10841l2);
            }
            jM10841l = jM10841l2;
        }
    }
}
