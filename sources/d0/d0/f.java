package d0.d0;

import d0.z.d.m;
import java.util.NoSuchElementException;
import kotlin.ranges.IntProgression;
import kotlin.ranges.IntProgression$a;
import kotlin.ranges.IntRange;
import kotlin.ranges.LongRange;

/* JADX INFO: compiled from: _Ranges.kt */
/* JADX INFO: loaded from: classes3.dex */
public class f extends e {
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

    public static final IntProgression downTo(int i, int i2) {
        return IntProgression.j.fromClosedRange(i, i2, -1);
    }

    public static final boolean longRangeContains(a<Long> aVar, int i) {
        m.checkNotNullParameter(aVar, "$this$contains");
        return aVar.contains(Long.valueOf(i));
    }

    public static final int random(IntRange intRange, d0.c0.c cVar) {
        m.checkNotNullParameter(intRange, "$this$random");
        m.checkNotNullParameter(cVar, "random");
        try {
            return d0.c0.d.nextInt(cVar, intRange);
        } catch (IllegalArgumentException e) {
            throw new NoSuchElementException(e.getMessage());
        }
    }

    public static final IntProgression step(IntProgression intProgression, int i) {
        m.checkNotNullParameter(intProgression, "$this$step");
        e.checkStepIsPositive(i > 0, Integer.valueOf(i));
        IntProgression$a intProgression$a = IntProgression.j;
        int first = intProgression.getFirst();
        int last = intProgression.getLast();
        if (intProgression.getStep() <= 0) {
            i = -i;
        }
        return intProgression$a.fromClosedRange(first, last, i);
    }

    public static final IntRange until(int i, int i2) {
        return i2 <= Integer.MIN_VALUE ? IntRange.o.getEMPTY() : new IntRange(i, i2 - 1);
    }

    public static final LongRange until(int i, long j) {
        if (j <= Long.MIN_VALUE) {
            return LongRange.n.getEMPTY();
        }
        return new LongRange(i, j - 1);
    }
}
