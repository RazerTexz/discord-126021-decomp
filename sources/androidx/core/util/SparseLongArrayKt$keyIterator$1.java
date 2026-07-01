package androidx.core.util;

import android.util.SparseLongArray;
import d0.t.c0;

/* JADX INFO: compiled from: SparseLongArray.kt */
/* JADX INFO: loaded from: classes.dex */
public final class SparseLongArrayKt$keyIterator$1 extends c0 {
    public final /* synthetic */ SparseLongArray $this_keyIterator;
    private int index;

    public SparseLongArrayKt$keyIterator$1(SparseLongArray sparseLongArray) {
        this.$this_keyIterator = sparseLongArray;
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
        SparseLongArray sparseLongArray = this.$this_keyIterator;
        int i = this.index;
        this.index = i + 1;
        return sparseLongArray.keyAt(i);
    }

    public final void setIndex(int i) {
        this.index = i;
    }
}
