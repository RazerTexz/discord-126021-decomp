package j0.l.e.o;

import java.util.Objects;

/* JADX INFO: renamed from: j0.l.e.o.h, reason: use source file name */
/* JADX INFO: compiled from: SpmcArrayQueue.java */
/* JADX INFO: loaded from: classes3.dex */
public final class SpmcArrayQueue<E> {
    public SpmcArrayQueue(int i) {
        super(i);
    }

    public boolean isEmpty() {
        return l() == i();
    }

    public boolean offer(E e) {
        Objects.requireNonNull(e, "Null is not a valid element");
        E[] eArr = this.n;
        long j = this.m;
        long jI = i();
        long jC = c(jI);
        if (e(eArr, jC) != null) {
            if (jI - l() > j) {
                return false;
            }
            while (e(eArr, jC) != null) {
            }
        }
        h(eArr, jC, e);
        j(jI + 1);
        return true;
    }

    public E peek() {
        E e;
        long j = this.q;
        do {
            long jL = l();
            if (jL >= j) {
                long jI = i();
                if (jL >= jI) {
                    return null;
                }
                this.q = jI;
            }
            e = e(this.n, c(jL));
        } while (e == null);
        return e;
    }

    public E poll() {
        long jL;
        long j = this.q;
        do {
            jL = l();
            if (jL >= j) {
                long jI = i();
                if (jL >= jI) {
                    return null;
                }
                this.q = jI;
            }
        } while (!k(jL, 1 + jL));
        long jC = c(jL);
        E[] eArr = this.n;
        E eD = d(eArr, jC);
        g(eArr, jC, null);
        return eD;
    }

    public int size() {
        long jL = l();
        while (true) {
            long jI = i();
            long jL2 = l();
            if (jL == jL2) {
                return (int) (jI - jL2);
            }
            jL = jL2;
        }
    }
}
