package kotlin.ranges;

import d0.d0.Range3;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: renamed from: kotlin.ranges.IntRange, reason: use source file name */
/* JADX INFO: compiled from: Ranges.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class Ranges2 extends Progressions2 implements Range3<Integer> {

    /* JADX INFO: renamed from: o, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final Ranges2 n = new Ranges2(1, 0);

    /* JADX INFO: renamed from: kotlin.ranges.IntRange$a, reason: from kotlin metadata */
    /* JADX INFO: compiled from: Ranges.kt */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final Ranges2 getEMPTY() {
            return Ranges2.n;
        }
    }

    public Ranges2(int i, int i2) {
        super(i, i2, 1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // d0.d0.Range3
    public /* bridge */ /* synthetic */ boolean contains(Comparable comparable) {
        return contains(((Number) comparable).intValue());
    }

    @Override // kotlin.ranges.Progressions2
    public boolean equals(Object other) {
        if (other instanceof Ranges2) {
            if (!isEmpty() || !((Ranges2) other).isEmpty()) {
                Ranges2 ranges2 = (Ranges2) other;
                if (getFirst() != ranges2.getFirst() || getLast() != ranges2.getLast()) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // kotlin.ranges.Progressions2
    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (getFirst() * 31) + getLast();
    }

    @Override // kotlin.ranges.Progressions2
    public boolean isEmpty() {
        return getFirst() > getLast();
    }

    @Override // kotlin.ranges.Progressions2
    public String toString() {
        return getFirst() + ".." + getLast();
    }

    public boolean contains(int value) {
        return getFirst() <= value && value <= getLast();
    }

    @Override // d0.d0.Range3
    public Integer getEndInclusive() {
        return Integer.valueOf(getLast());
    }

    @Override // d0.d0.Range3
    public Integer getStart() {
        return Integer.valueOf(getFirst());
    }
}
