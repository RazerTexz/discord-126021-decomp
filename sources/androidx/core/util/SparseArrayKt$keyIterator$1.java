package androidx.core.util;

import android.util.SparseArray;
import d0.t.c0;

/* JADX INFO: compiled from: SparseArray.kt */
/* JADX INFO: loaded from: classes.dex */
public final class SparseArrayKt$keyIterator$1 extends c0 {
    public final /* synthetic */ SparseArray<T> $this_keyIterator;
    private int index;

    public SparseArrayKt$keyIterator$1(SparseArray<T> sparseArray) {
        this.$this_keyIterator = sparseArray;
    }

    public final int getIndex() {
        return this.index;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.index < this.$this_keyIterator.size();
    }

    @Override // d0.t.c0
    public int nextInt() {
        SparseArray<T> sparseArray = this.$this_keyIterator;
        int i = this.index;
        this.index = i + 1;
        return sparseArray.keyAt(i);
    }

    public final void setIndex(int i) {
        this.index = i;
    }
}
