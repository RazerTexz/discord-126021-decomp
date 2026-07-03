package p637j0.p642l.p647e.p648n;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* JADX INFO: renamed from: j0.l.e.n.c */
/* JADX INFO: compiled from: SpscAtomicArrayQueue.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C12726c<E> extends AbstractC12724a<E> {

    /* JADX INFO: renamed from: l */
    public static final Integer f27305l = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096);

    /* JADX INFO: renamed from: m */
    public final AtomicLong f27306m;

    /* JADX INFO: renamed from: n */
    public long f27307n;

    /* JADX INFO: renamed from: o */
    public final AtomicLong f27308o;

    /* JADX INFO: renamed from: p */
    public final int f27309p;

    public C12726c(int i) {
        super(i);
        this.f27306m = new AtomicLong();
        this.f27308o = new AtomicLong();
        this.f27309p = Math.min(i / 4, f27305l.intValue());
    }

    /* JADX INFO: renamed from: c */
    public final long m10827c() {
        return this.f27308o.get();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return this.f27306m.get() == m10827c();
    }

    @Override // java.util.Queue
    public boolean offer(E e) {
        Objects.requireNonNull(e, "Null is not a valid element");
        AtomicReferenceArray<E> atomicReferenceArray = this.f27303j;
        int i = this.f27304k;
        long j = this.f27306m.get();
        int i2 = ((int) j) & i;
        if (j >= this.f27307n) {
            long j2 = ((long) this.f27309p) + j;
            if (atomicReferenceArray.get(i & ((int) j2)) == null) {
                this.f27307n = j2;
            } else if (atomicReferenceArray.get(i2) != null) {
                return false;
            }
        }
        atomicReferenceArray.lazySet(i2, e);
        this.f27306m.lazySet(j + 1);
        return true;
    }

    @Override // java.util.Queue
    public E peek() {
        return this.f27303j.get(this.f27304k & ((int) this.f27308o.get()));
    }

    @Override // java.util.Queue
    public E poll() {
        long j = this.f27308o.get();
        int i = ((int) j) & this.f27304k;
        AtomicReferenceArray<E> atomicReferenceArray = this.f27303j;
        E e = atomicReferenceArray.get(i);
        if (e == null) {
            return null;
        }
        atomicReferenceArray.lazySet(i, null);
        this.f27308o.lazySet(j + 1);
        return e;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        long jM10827c = m10827c();
        while (true) {
            long j = this.f27306m.get();
            long jM10827c2 = m10827c();
            if (jM10827c == jM10827c2) {
                return (int) (j - jM10827c2);
            }
            jM10827c = jM10827c2;
        }
    }
}
