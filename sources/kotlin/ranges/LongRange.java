package kotlin.ranges;

import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.p512d0.C11223c;
import p507d0.p512d0.InterfaceC11221a;

/* JADX INFO: compiled from: Ranges.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class LongRange extends C11223c implements InterfaceC11221a<Long> {

    /* JADX INFO: renamed from: n, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: m */
    public static final LongRange f27438m = new LongRange(1, 0);

    /* JADX INFO: renamed from: kotlin.ranges.LongRange$a, reason: from kotlin metadata */
    /* JADX INFO: compiled from: Ranges.kt */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final LongRange getEMPTY() {
            return LongRange.f27438m;
        }
    }

    public LongRange(long j, long j2) {
        super(j, j2, 1L);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // p507d0.p512d0.InterfaceC11221a
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

    @Override // p507d0.p512d0.InterfaceC11221a
    public Long getEndInclusive() {
        return Long.valueOf(getLast());
    }

    @Override // p507d0.p512d0.InterfaceC11221a
    public Long getStart() {
        return Long.valueOf(getFirst());
    }
}
