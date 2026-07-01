package androidx.core.util;

import android.util.SparseIntArray;
import d0.t.c0;

/* JADX INFO: compiled from: SparseIntArray.kt */
/* JADX INFO: loaded from: classes.dex */
public final class SparseIntArrayKt$valueIterator$1 extends c0 {
    public final /* synthetic */ SparseIntArray $this_valueIterator;
    private int index;

    public SparseIntArrayKt$valueIterator$1(SparseIntArray sparseIntArray) {
        this.$this_valueIterator = sparseIntArray;
    }

    public final int getIndex() {
        return this.index;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.index < this.$this_valueIterator.size();
    }

    @Override // d0.t.c0
    public int nextInt() {
        SparseIntArray sparseIntArray = this.$this_valueIterator;
        int i = this.index;
        this.index = i + 1;
        return sparseIntArray.valueAt(i);
    }

    public final void setIndex(int i) {
        this.index = i;
    }
}
