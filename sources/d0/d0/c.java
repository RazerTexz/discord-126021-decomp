package d0.d0;

import java.util.Iterator;

/* JADX INFO: compiled from: Progressions.kt */
/* JADX INFO: loaded from: classes3.dex */
public class c implements Iterable<Long>, d0.z.d.g0.a {
    public final long j;
    public final long k;
    public final long l;

    static {
        new c$a(null);
    }

    public c(long j, long j2, long j3) {
        if (j3 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (j3 == Long.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Long.MIN_VALUE to avoid overflow on negation.");
        }
        this.j = j;
        this.k = d0.x.c.getProgressionLastElement(j, j2, j3);
        this.l = j3;
    }

    public final long getFirst() {
        return this.j;
    }

    public final long getLast() {
        return this.k;
    }

    @Override // java.lang.Iterable
    /* JADX INFO: renamed from: iterator, reason: avoid collision after fix types in other method */
    public /* bridge */ /* synthetic */ Iterator<Long> iterator2() {
        return iterator();
    }

    @Override // java.lang.Iterable
    public Iterator<Long> iterator() {
        return new d(this.j, this.k, this.l);
    }
}
