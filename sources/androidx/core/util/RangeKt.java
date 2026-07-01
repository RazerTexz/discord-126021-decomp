package androidx.core.util;

import android.util.Range;
import androidx.annotation.RequiresApi;
import androidx.exifinterface.media.ExifInterface;
import d0.d0.a;
import d0.z.d.m;

/* JADX INFO: compiled from: Range.kt */
/* JADX INFO: loaded from: classes.dex */
public final class RangeKt {
    @RequiresApi(21)
    public static final <T extends Comparable<? super T>> Range<T> and(Range<T> range, Range<T> range2) {
        m.checkNotNullParameter(range, "<this>");
        m.checkNotNullParameter(range2, "other");
        Range<T> rangeIntersect = range.intersect(range2);
        m.checkNotNullExpressionValue(rangeIntersect, "intersect(other)");
        return rangeIntersect;
    }

    @RequiresApi(21)
    public static final <T extends Comparable<? super T>> Range<T> plus(Range<T> range, T t) {
        m.checkNotNullParameter(range, "<this>");
        m.checkNotNullParameter(t, "value");
        Range<T> rangeExtend = range.extend(t);
        m.checkNotNullExpressionValue(rangeExtend, "extend(value)");
        return rangeExtend;
    }

    @RequiresApi(21)
    public static final <T extends Comparable<? super T>> Range<T> rangeTo(T t, T t2) {
        m.checkNotNullParameter(t, "<this>");
        m.checkNotNullParameter(t2, "that");
        return new Range<>(t, t2);
    }

    @RequiresApi(21)
    public static final <T extends Comparable<? super T>> a<T> toClosedRange(Range<T> range) {
        m.checkNotNullParameter(range, "<this>");
        return new RangeKt$toClosedRange$1(range);
    }

    @RequiresApi(21)
    public static final <T extends Comparable<? super T>> Range<T> toRange(a<T> aVar) {
        m.checkNotNullParameter(aVar, "<this>");
        return new Range<>(aVar.getStart(), aVar.getEndInclusive());
    }

    @RequiresApi(21)
    public static final <T extends Comparable<? super T>> Range<T> plus(Range<T> range, Range<T> range2) {
        m.checkNotNullParameter(range, "<this>");
        m.checkNotNullParameter(range2, "other");
        Range<T> rangeExtend = range.extend(range2);
        m.checkNotNullExpressionValue(rangeExtend, "extend(other)");
        return rangeExtend;
    }
}
