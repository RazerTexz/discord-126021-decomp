package kotlin.ranges;

import java.util.Iterator;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.p512d0.C11222b;
import p507d0.p588x.C12197c;
import p507d0.p592z.p594d.p595g0.InterfaceC12228a;

/* JADX INFO: compiled from: Progressions.kt */
/* JADX INFO: loaded from: classes3.dex */
public class IntProgression implements Iterable<Integer>, InterfaceC12228a {

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    public final int first;

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    public final int last;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    public final int step;

    /* JADX INFO: renamed from: kotlin.ranges.IntProgression$a, reason: from kotlin metadata */
    /* JADX INFO: compiled from: Progressions.kt */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final IntProgression fromClosedRange(int i, int i2, int i3) {
            return new IntProgression(i, i2, i3);
        }
    }

    public IntProgression(int i, int i2, int i3) {
        if (i3 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (i3 == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
        this.first = i;
        this.last = C12197c.getProgressionLastElement(i, i2, i3);
        this.step = i3;
    }

    public boolean equals(Object other) {
        if (other instanceof IntProgression) {
            if (!isEmpty() || !((IntProgression) other).isEmpty()) {
                IntProgression intProgression = (IntProgression) other;
                if (this.first != intProgression.first || this.last != intProgression.last || this.step != intProgression.step) {
                }
            }
            return true;
        }
        return false;
    }

    public final int getFirst() {
        return this.first;
    }

    public final int getLast() {
        return this.last;
    }

    public final int getStep() {
        return this.step;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.first * 31) + this.last) * 31) + this.step;
    }

    public boolean isEmpty() {
        if (this.step > 0) {
            if (this.first > this.last) {
                return true;
            }
        } else if (this.first < this.last) {
            return true;
        }
        return false;
    }

    public String toString() {
        StringBuilder sb;
        int i;
        if (this.step > 0) {
            sb = new StringBuilder();
            sb.append(this.first);
            sb.append("..");
            sb.append(this.last);
            sb.append(" step ");
            i = this.step;
        } else {
            sb = new StringBuilder();
            sb.append(this.first);
            sb.append(" downTo ");
            sb.append(this.last);
            sb.append(" step ");
            i = -this.step;
        }
        sb.append(i);
        return sb.toString();
    }

    @Override // java.lang.Iterable
    /* JADX INFO: renamed from: iterator, reason: merged with bridge method [inline-methods] */
    public Iterator<Integer> iterator2() {
        return new C11222b(this.first, this.last, this.step);
    }
}
