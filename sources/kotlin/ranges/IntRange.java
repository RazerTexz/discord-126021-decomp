package kotlin.ranges;

import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.p512d0.InterfaceC11221a;

/* JADX INFO: compiled from: Ranges.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class IntRange extends IntProgression implements InterfaceC11221a<Integer> {

    /* JADX INFO: renamed from: o, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: n */
    public static final IntRange f27436n = new IntRange(1, 0);

    /* JADX INFO: renamed from: kotlin.ranges.IntRange$a, reason: from kotlin metadata */
    /* JADX INFO: compiled from: Ranges.kt */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final IntRange getEMPTY() {
            return IntRange.f27436n;
        }
    }

    public IntRange(int i, int i2) {
        super(i, i2, 1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // p507d0.p512d0.InterfaceC11221a
    public /* bridge */ /* synthetic */ boolean contains(Comparable comparable) {
        return contains(((Number) comparable).intValue());
    }

    @Override // kotlin.ranges.IntProgression
    public boolean equals(Object other) {
        if (other instanceof IntRange) {
            if (!isEmpty() || !((IntRange) other).isEmpty()) {
                IntRange intRange = (IntRange) other;
                if (getFirst() != intRange.getFirst() || getLast() != intRange.getLast()) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // kotlin.ranges.IntProgression
    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (getFirst() * 31) + getLast();
    }

    @Override // kotlin.ranges.IntProgression
    public boolean isEmpty() {
        return getFirst() > getLast();
    }

    @Override // kotlin.ranges.IntProgression
    public String toString() {
        return getFirst() + ".." + getLast();
    }

    public boolean contains(int value) {
        return getFirst() <= value && value <= getLast();
    }

    @Override // p507d0.p512d0.InterfaceC11221a
    public Integer getEndInclusive() {
        return Integer.valueOf(getLast());
    }

    @Override // p507d0.p512d0.InterfaceC11221a
    public Integer getStart() {
        return Integer.valueOf(getFirst());
    }
}
