package androidx.core.util;

import android.util.SparseLongArray;
import d0.t.d0;

/* JADX INFO: compiled from: SparseLongArray.kt */
/* JADX INFO: loaded from: classes.dex */
public final class SparseLongArrayKt$valueIterator$1 extends d0 {
    public final /* synthetic */ SparseLongArray $this_valueIterator;
    private int index;

    public SparseLongArrayKt$valueIterator$1(SparseLongArray sparseLongArray) {
        this.$this_valueIterator = sparseLongArray;
    }

    public final int getIndex() {
        return this.index;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.index < this.$this_valueIterator.size();
    }

    @Override // d0.t.d0
    public long nextLong() {
        SparseLongArray sparseLongArray = this.$this_valueIterator;
        int i = this.index;
        this.index = i + 1;
        return sparseLongArray.valueAt(i);
    }

    public final void setIndex(int i) {
        this.index = i;
    }
}
