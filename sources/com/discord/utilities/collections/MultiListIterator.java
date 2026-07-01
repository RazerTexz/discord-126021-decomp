package com.discord.utilities.collections;

import androidx.exifinterface.media.ExifInterface;
import d0.z.d.Intrinsics3;
import d0.z.d.g0.KMarkers;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: MultiListIterator.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class MultiListIterator<T> implements Iterator<T>, KMarkers {
    private Iterator<? extends T> curIterator;
    private int listIndex;
    private final List<T>[] lists;

    /* JADX WARN: Multi-variable type inference failed */
    public MultiListIterator(List<? extends T>... listArr) {
        Intrinsics3.checkNotNullParameter(listArr, "lists");
        this.lists = listArr;
        this.curIterator = listArr[this.listIndex].iterator();
    }

    public final List<T>[] getLists() {
        return this.lists;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        if (this.curIterator.hasNext()) {
            return true;
        }
        while (!this.curIterator.hasNext()) {
            int i = this.listIndex + 1;
            this.listIndex = i;
            List<T>[] listArr = this.lists;
            if (i >= listArr.length) {
                return false;
            }
            this.curIterator = listArr[i].iterator();
        }
        return true;
    }

    @Override // java.util.Iterator
    public T next() {
        return this.curIterator.next();
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
