package d0.d0;

import d0.c0.Random;
import d0.c0.Random2;
import d0.z.d.Intrinsics3;
import java.util.NoSuchElementException;
import kotlin.ranges.Progressions2;
import kotlin.ranges.Ranges2;
import kotlin.ranges.Ranges3;

/* JADX INFO: renamed from: d0.d0.f, reason: use source file name */
/* JADX INFO: compiled from: _Ranges.kt */
/* JADX INFO: loaded from: classes3.dex */
public class _Ranges extends Ranges {
    public static final int coerceAtLeast(int i, int i2) {
        return i < i2 ? i2 : i;
    }

    public static final long coerceAtLeast(long j, long j2) {
        return j < j2 ? j2 : j;
    }

    public static final float coerceAtMost(float f, float f2) {
        return f > f2 ? f2 : f;
    }

    public static final int coerceAtMost(int i, int i2) {
        return i > i2 ? i2 : i;
    }

    public static final long coerceAtMost(long j, long j2) {
        return j > j2 ? j2 : j;
    }

    public static final int coerceIn(int i, int i2, int i3) {
        if (i2 <= i3) {
            if (i < i2) {
                return i2;
            }
            return i > i3 ? i3 : i;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + i3 + " is less than minimum " + i2 + '.');
    }

    public static final Progressions2 downTo(int i, int i2) {
        return Progressions2.INSTANCE.fromClosedRange(i, i2, -1);
    }

    public static final boolean longRangeContains(Range3<Long> range3, int i) {
        Intrinsics3.checkNotNullParameter(range3, "$this$contains");
        return range3.contains(Long.valueOf(i));
    }

    public static final int random(Ranges2 ranges2, Random random) {
        Intrinsics3.checkNotNullParameter(ranges2, "$this$random");
        Intrinsics3.checkNotNullParameter(random, "random");
        try {
            return Random2.nextInt(random, ranges2);
        } catch (IllegalArgumentException e) {
            throw new NoSuchElementException(e.getMessage());
        }
    }

    public static final Progressions2 step(Progressions2 progressions2, int i) {
        Intrinsics3.checkNotNullParameter(progressions2, "$this$step");
        Ranges.checkStepIsPositive(i > 0, Integer.valueOf(i));
        Progressions2.Companion companion = Progressions2.INSTANCE;
        int first = progressions2.getFirst();
        int last = progressions2.getLast();
        if (progressions2.getStep() <= 0) {
            i = -i;
        }
        return companion.fromClosedRange(first, last, i);
    }

    public static final Ranges2 until(int i, int i2) {
        return i2 <= Integer.MIN_VALUE ? Ranges2.INSTANCE.getEMPTY() : new Ranges2(i, i2 - 1);
    }

    public static final Ranges3 until(int i, long j) {
        if (j <= Long.MIN_VALUE) {
            return Ranges3.INSTANCE.getEMPTY();
        }
        return new Ranges3(i, j - 1);
    }
}
