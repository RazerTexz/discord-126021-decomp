package p507d0.p512d0;

import java.util.NoSuchElementException;
import kotlin.ranges.IntProgression;
import kotlin.ranges.IntRange;
import kotlin.ranges.LongRange;
import p507d0.p510c0.AbstractC11216c;
import p507d0.p510c0.C11217d;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.d0.f */
/* JADX INFO: compiled from: _Ranges.kt */
/* JADX INFO: loaded from: classes3.dex */
public class C11226f extends C11225e {
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
        return IntProgression.INSTANCE.fromClosedRange(i, i2, -1);
    }

    public static final boolean longRangeContains(InterfaceC11221a<Long> interfaceC11221a, int i) {
        C12238m.checkNotNullParameter(interfaceC11221a, "$this$contains");
        return interfaceC11221a.contains(Long.valueOf(i));
    }

    public static final int random(IntRange intRange, AbstractC11216c abstractC11216c) {
        C12238m.checkNotNullParameter(intRange, "$this$random");
        C12238m.checkNotNullParameter(abstractC11216c, "random");
        try {
            return C11217d.nextInt(abstractC11216c, intRange);
        } catch (IllegalArgumentException e) {
            throw new NoSuchElementException(e.getMessage());
        }
    }

    public static final IntProgression step(IntProgression intProgression, int i) {
        C12238m.checkNotNullParameter(intProgression, "$this$step");
        C11225e.checkStepIsPositive(i > 0, Integer.valueOf(i));
        IntProgression.Companion companion = IntProgression.INSTANCE;
        int first = intProgression.getFirst();
        int last = intProgression.getLast();
        if (intProgression.getStep() <= 0) {
            i = -i;
        }
        return companion.fromClosedRange(first, last, i);
    }

    public static final IntRange until(int i, int i2) {
        return i2 <= Integer.MIN_VALUE ? IntRange.INSTANCE.getEMPTY() : new IntRange(i, i2 - 1);
    }

    public static final LongRange until(int i, long j) {
        if (j <= Long.MIN_VALUE) {
            return LongRange.INSTANCE.getEMPTY();
        }
        return new LongRange(i, j - 1);
    }
}
