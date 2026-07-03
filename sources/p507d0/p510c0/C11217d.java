package p507d0.p510c0;

import kotlin.ranges.IntRange;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.c0.d */
/* JADX INFO: compiled from: Random.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11217d {
    public static final AbstractC11216c Random(long j) {
        return new C11218e((int) j, (int) (j >> 32));
    }

    public static final String boundsErrorMessage(Object obj, Object obj2) {
        C12238m.checkNotNullParameter(obj, "from");
        C12238m.checkNotNullParameter(obj2, "until");
        return "Random range is empty: [" + obj + ", " + obj2 + ").";
    }

    public static final void checkRangeBounds(int i, int i2) {
        if (!(i2 > i)) {
            throw new IllegalArgumentException(boundsErrorMessage(Integer.valueOf(i), Integer.valueOf(i2)).toString());
        }
    }

    public static final int fastLog2(int i) {
        return 31 - Integer.numberOfLeadingZeros(i);
    }

    public static final int nextInt(AbstractC11216c abstractC11216c, IntRange intRange) {
        C12238m.checkNotNullParameter(abstractC11216c, "$this$nextInt");
        C12238m.checkNotNullParameter(intRange, "range");
        if (!intRange.isEmpty()) {
            if (intRange.getLast() < Integer.MAX_VALUE) {
                return abstractC11216c.nextInt(intRange.getFirst(), intRange.getLast() + 1);
            }
            return intRange.getFirst() > Integer.MIN_VALUE ? abstractC11216c.nextInt(intRange.getFirst() - 1, intRange.getLast()) + 1 : abstractC11216c.nextInt();
        }
        throw new IllegalArgumentException("Cannot get random in empty range: " + intRange);
    }

    public static final int takeUpperBits(int i, int i2) {
        return (i >>> (32 - i2)) & ((-i2) >> 31);
    }
}
