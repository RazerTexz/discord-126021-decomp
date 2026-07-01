package d0.c0;

import d0.z.d.Intrinsics3;
import kotlin.ranges.Ranges2;

/* JADX INFO: renamed from: d0.c0.d, reason: use source file name */
/* JADX INFO: compiled from: Random.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class Random2 {
    public static final Random Random(long j) {
        return new XorWowRandom((int) j, (int) (j >> 32));
    }

    public static final String boundsErrorMessage(Object obj, Object obj2) {
        Intrinsics3.checkNotNullParameter(obj, "from");
        Intrinsics3.checkNotNullParameter(obj2, "until");
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

    public static final int nextInt(Random random, Ranges2 ranges2) {
        Intrinsics3.checkNotNullParameter(random, "$this$nextInt");
        Intrinsics3.checkNotNullParameter(ranges2, "range");
        if (!ranges2.isEmpty()) {
            if (ranges2.getLast() < Integer.MAX_VALUE) {
                return random.nextInt(ranges2.getFirst(), ranges2.getLast() + 1);
            }
            return ranges2.getFirst() > Integer.MIN_VALUE ? random.nextInt(ranges2.getFirst() - 1, ranges2.getLast()) + 1 : random.nextInt();
        }
        throw new IllegalArgumentException("Cannot get random in empty range: " + ranges2);
    }

    public static final int takeUpperBits(int i, int i2) {
        return (i >>> (32 - i2)) & ((-i2) >> 31);
    }
}
