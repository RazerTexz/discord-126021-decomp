package d0.c0;

import d0.z.d.m;
import kotlin.ranges.IntRange;

/* JADX INFO: compiled from: Random.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d {
    public static final c Random(long j) {
        return new e((int) j, (int) (j >> 32));
    }

    public static final String boundsErrorMessage(Object obj, Object obj2) {
        m.checkNotNullParameter(obj, "from");
        m.checkNotNullParameter(obj2, "until");
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

    public static final int nextInt(c cVar, IntRange intRange) {
        m.checkNotNullParameter(cVar, "$this$nextInt");
        m.checkNotNullParameter(intRange, "range");
        if (!intRange.isEmpty()) {
            if (intRange.getLast() < Integer.MAX_VALUE) {
                return cVar.nextInt(intRange.getFirst(), intRange.getLast() + 1);
            }
            return intRange.getFirst() > Integer.MIN_VALUE ? cVar.nextInt(intRange.getFirst() - 1, intRange.getLast()) + 1 : cVar.nextInt();
        }
        throw new IllegalArgumentException("Cannot get random in empty range: " + intRange);
    }

    public static final int takeUpperBits(int i, int i2) {
        return (i >>> (32 - i2)) & ((-i2) >> 31);
    }
}
