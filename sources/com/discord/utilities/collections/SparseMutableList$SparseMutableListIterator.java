package com.discord.utilities.collections;

import androidx.exifinterface.media.ExifInterface;
import d0.t.n;
import d0.z.d.g0.a;
import d0.z.d.m;
import java.util.ListIterator;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: SparseMutableList.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SparseMutableList$SparseMutableListIterator<T> implements ListIterator<T>, a {
    private int index;
    private final SparseMutableList<T> sparseMutableList;

    public SparseMutableList$SparseMutableListIterator(SparseMutableList<T> sparseMutableList, int i) {
        m.checkNotNullParameter(sparseMutableList, "sparseMutableList");
        this.sparseMutableList = sparseMutableList;
        this.index = i;
    }

    @Override // java.util.ListIterator
    public void add(T element) {
        throw new UnsupportedOperationException("add not supported during iteration");
    }

    public final int getIndex() {
        return this.index;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public boolean hasNext() {
        return nextIndex() < n.getLastIndex(this.sparseMutableList);
    }

    @Override // java.util.ListIterator
    public boolean hasPrevious() {
        return this.index > 0;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public T next() {
        int i = this.index + 1;
        this.index = i;
        return this.sparseMutableList.get(i);
    }

    @Override // java.util.ListIterator
    public int nextIndex() {
        return this.index + 1;
    }

    @Override // java.util.ListIterator
    public T previous() {
        int i = this.index - 1;
        this.index = i;
        return this.sparseMutableList.get(i);
    }

    @Override // java.util.ListIterator
    public int previousIndex() {
        return this.index - 1;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public void remove() {
        this.sparseMutableList.remove(this.index);
    }

    @Override // java.util.ListIterator
    public void set(T element) {
        this.sparseMutableList.set(this.index, element);
    }

    public final void setIndex(int i) {
        this.index = i;
    }

    public /* synthetic */ SparseMutableList$SparseMutableListIterator(SparseMutableList sparseMutableList, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(sparseMutableList, (i2 & 2) != 0 ? -1 : i);
    }
}
