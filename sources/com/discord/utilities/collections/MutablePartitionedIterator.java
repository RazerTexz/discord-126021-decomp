package com.discord.utilities.collections;

import androidx.exifinterface.media.ExifInterface;
import java.util.Iterator;
import java.util.LinkedList;
import p507d0.p592z.p594d.C12238m;
import p507d0.p592z.p594d.p595g0.InterfaceC12228a;

/* JADX INFO: compiled from: MutablePartitionedIterator.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class MutablePartitionedIterator<T> implements Iterator<T>, InterfaceC12228a {
    private Iterator<? extends T> currentPartitionIterator;
    private final Iterator<Iterable<T>> partitionIterator;

    /* JADX WARN: Multi-variable type inference failed */
    public MutablePartitionedIterator(Iterator<? extends Iterable<? extends T>> it) {
        C12238m.checkNotNullParameter(it, "partitionIterator");
        this.partitionIterator = it;
        Iterator<? extends T> it2 = new LinkedList().iterator();
        C12238m.checkNotNullExpressionValue(it2, "LinkedList<T>().iterator()");
        this.currentPartitionIterator = it2;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        if (this.currentPartitionIterator.hasNext()) {
            return true;
        }
        while (this.partitionIterator.hasNext()) {
            Iterator<T> it = this.partitionIterator.next().iterator();
            this.currentPartitionIterator = it;
            if (it.hasNext()) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.Iterator
    public T next() {
        return this.currentPartitionIterator.next();
    }

    @Override // java.util.Iterator
    public void remove() {
        this.currentPartitionIterator.remove();
    }
}
