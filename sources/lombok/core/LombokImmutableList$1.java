package lombok.core;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: loaded from: app.apk:lombok/core/LombokImmutableList$1.SCL.lombok */
class LombokImmutableList$1<T> implements Iterator<T> {
    private int idx = 0;
    final /* synthetic */ LombokImmutableList this$0;

    LombokImmutableList$1(LombokImmutableList lombokImmutableList) {
        this.this$0 = lombokImmutableList;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.idx < LombokImmutableList.access$0(this.this$0).length;
    }

    @Override // java.util.Iterator
    public T next() {
        if (this.idx >= LombokImmutableList.access$0(this.this$0).length) {
            throw new NoSuchElementException();
        }
        Object[] objArrAccess$0 = LombokImmutableList.access$0(this.this$0);
        int i = this.idx;
        this.idx = i + 1;
        return (T) objArrAccess$0[i];
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("List is immutable");
    }
}
