package androidx.core.util;

import android.util.Range;
import d0.d0.a;
import d0.d0.a$a;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: compiled from: Range.kt */
/* JADX INFO: loaded from: classes.dex */
public final class RangeKt$toClosedRange$1<T> implements a<T> {
    public final /* synthetic */ Range<T> $this_toClosedRange;

    public RangeKt$toClosedRange$1(Range<T> range) {
        this.$this_toClosedRange = range;
    }

    /* JADX WARN: Incorrect types in method signature: (TT;)Z */
    @Override // d0.d0.a
    public boolean contains(Comparable comparable) {
        return a$a.contains(this, comparable);
    }

    /* JADX WARN: Incorrect return type in method signature: ()TT; */
    @Override // d0.d0.a
    public Comparable getEndInclusive() {
        return this.$this_toClosedRange.getUpper();
    }

    /* JADX WARN: Incorrect return type in method signature: ()TT; */
    @Override // d0.d0.a
    public Comparable getStart() {
        return this.$this_toClosedRange.getLower();
    }

    public boolean isEmpty() {
        return a$a.isEmpty(this);
    }
}
