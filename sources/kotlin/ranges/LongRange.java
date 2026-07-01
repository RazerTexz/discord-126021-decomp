package kotlin.ranges;

import d0.d0.a;
import d0.d0.c;

/* JADX INFO: compiled from: Ranges.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class LongRange extends c implements a<Long> {
    public static final LongRange$a n = new LongRange$a(null);
    public static final LongRange m = new LongRange(1, 0);

    public LongRange(long j, long j2) {
        super(j, j2, 1L);
    }

    public static final /* synthetic */ LongRange access$getEMPTY$cp() {
        return m;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // d0.d0.a
    public /* bridge */ /* synthetic */ boolean contains(Comparable comparable) {
        return contains(((Number) comparable).longValue());
    }

    public boolean equals(Object other) {
        if (other instanceof LongRange) {
            if (!isEmpty() || !((LongRange) other).isEmpty()) {
                LongRange longRange = (LongRange) other;
                if (getFirst() != longRange.getFirst() || getLast() != longRange.getLast()) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // d0.d0.a
    public /* bridge */ /* synthetic */ Comparable getEndInclusive() {
        return getEndInclusive();
    }

    @Override // d0.d0.a
    public /* bridge */ /* synthetic */ Comparable getStart() {
        return getStart();
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (int) ((((long) 31) * (getFirst() ^ (getFirst() >>> 32))) + (getLast() ^ (getLast() >>> 32)));
    }

    public boolean isEmpty() {
        return getFirst() > getLast();
    }

    public String toString() {
        return getFirst() + ".." + getLast();
    }

    public boolean contains(long value) {
        return getFirst() <= value && value <= getLast();
    }

    @Override // d0.d0.a
    public Long getEndInclusive() {
        return Long.valueOf(getLast());
    }

    @Override // d0.d0.a
    public Long getStart() {
        return Long.valueOf(getFirst());
    }
}
