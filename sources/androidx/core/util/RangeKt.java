package androidx.core.util;

import android.util.Range;
import androidx.annotation.RequiresApi;
import androidx.exifinterface.media.ExifInterface;
import p507d0.p512d0.InterfaceC11221a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: Range.kt */
/* JADX INFO: loaded from: classes.dex */
public final class RangeKt {
    @RequiresApi(21)
    public static final <T extends Comparable<? super T>> Range<T> and(Range<T> range, Range<T> range2) {
        C12238m.checkNotNullParameter(range, "<this>");
        C12238m.checkNotNullParameter(range2, "other");
        Range<T> rangeIntersect = range.intersect(range2);
        C12238m.checkNotNullExpressionValue(rangeIntersect, "intersect(other)");
        return rangeIntersect;
    }

    @RequiresApi(21)
    public static final <T extends Comparable<? super T>> Range<T> plus(Range<T> range, T t) {
        C12238m.checkNotNullParameter(range, "<this>");
        C12238m.checkNotNullParameter(t, "value");
        Range<T> rangeExtend = range.extend(t);
        C12238m.checkNotNullExpressionValue(rangeExtend, "extend(value)");
        return rangeExtend;
    }

    @RequiresApi(21)
    public static final <T extends Comparable<? super T>> Range<T> rangeTo(T t, T t2) {
        C12238m.checkNotNullParameter(t, "<this>");
        C12238m.checkNotNullParameter(t2, "that");
        return new Range<>(t, t2);
    }

    @RequiresApi(21)
    public static final <T extends Comparable<? super T>> InterfaceC11221a<T> toClosedRange(final Range<T> range) {
        C12238m.checkNotNullParameter(range, "<this>");
        return (InterfaceC11221a<T>) new InterfaceC11221a<T>() { // from class: androidx.core.util.RangeKt.toClosedRange.1
            /* JADX WARN: Incorrect types in method signature: (TT;)Z */
            @Override // p507d0.p512d0.InterfaceC11221a
            public boolean contains(Comparable comparable) {
                return InterfaceC11221a.a.contains(this, comparable);
            }

            /* JADX WARN: Incorrect return type in method signature: ()TT; */
            @Override // p507d0.p512d0.InterfaceC11221a
            public Comparable getEndInclusive() {
                return range.getUpper();
            }

            /* JADX WARN: Incorrect return type in method signature: ()TT; */
            @Override // p507d0.p512d0.InterfaceC11221a
            public Comparable getStart() {
                return range.getLower();
            }

            public boolean isEmpty() {
                return InterfaceC11221a.a.isEmpty(this);
            }
        };
    }

    @RequiresApi(21)
    public static final <T extends Comparable<? super T>> Range<T> toRange(InterfaceC11221a<T> interfaceC11221a) {
        C12238m.checkNotNullParameter(interfaceC11221a, "<this>");
        return new Range<>(interfaceC11221a.getStart(), interfaceC11221a.getEndInclusive());
    }

    @RequiresApi(21)
    public static final <T extends Comparable<? super T>> Range<T> plus(Range<T> range, Range<T> range2) {
        C12238m.checkNotNullParameter(range, "<this>");
        C12238m.checkNotNullParameter(range2, "other");
        Range<T> rangeExtend = range.extend(range2);
        C12238m.checkNotNullExpressionValue(rangeExtend, "extend(other)");
        return rangeExtend;
    }
}
