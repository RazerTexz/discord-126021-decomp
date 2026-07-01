package j0.l.e.n;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* JADX INFO: compiled from: SpscAtomicArrayQueue.java */
/* JADX INFO: loaded from: classes3.dex */
public final class c<E> extends a<E> {
    public static final Integer l = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096);
    public final AtomicLong m;
    public long n;
    public final AtomicLong o;
    public final int p;

    public c(int i) {
        super(i);
        this.m = new AtomicLong();
        this.o = new AtomicLong();
        this.p = Math.min(i / 4, l.intValue());
    }

    public final long c() {
        return this.o.get();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return this.m.get() == c();
    }

    @Override // java.util.Queue
    public boolean offer(E e) {
        Objects.requireNonNull(e, "Null is not a valid element");
        AtomicReferenceArray<E> atomicReferenceArray = this.j;
        int i = this.k;
        long j = this.m.get();
        int i2 = ((int) j) & i;
        if (j >= this.n) {
            long j2 = ((long) this.p) + j;
            if (atomicReferenceArray.get(i & ((int) j2)) == null) {
                this.n = j2;
            } else if (atomicReferenceArray.get(i2) != null) {
                return false;
            }
        }
        atomicReferenceArray.lazySet(i2, e);
        this.m.lazySet(j + 1);
        return true;
    }

    @Override // java.util.Queue
    public E peek() {
        return this.j.get(this.k & ((int) this.o.get()));
    }

    @Override // java.util.Queue
    public E poll() {
        long j = this.o.get();
        int i = ((int) j) & this.k;
        AtomicReferenceArray<E> atomicReferenceArray = this.j;
        E e = atomicReferenceArray.get(i);
        if (e == null) {
            return null;
        }
        atomicReferenceArray.lazySet(i, null);
        this.o.lazySet(j + 1);
        return e;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        long jC = c();
        while (true) {
            long j = this.m.get();
            long jC2 = c();
            if (jC == jC2) {
                return (int) (j - jC2);
            }
            jC = jC2;
        }
    }
}
