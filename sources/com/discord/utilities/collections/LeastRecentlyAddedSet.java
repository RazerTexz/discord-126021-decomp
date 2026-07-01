package com.discord.utilities.collections;

import androidx.exifinterface.media.ExifInterface;
import b.d.b.a.outline;
import d0.t._Collections;
import d0.z.d.CollectionToArray;
import d0.z.d.Intrinsics3;
import d0.z.d.g0.KMarkers5;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: LeastRecentlyAddedSet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class LeastRecentlyAddedSet<E> implements Set<E>, KMarkers5 {
    private final LinkedHashSet<E> _set;
    private final int maxSize;

    /* JADX WARN: Multi-variable type inference failed */
    public LeastRecentlyAddedSet() {
        this(0, null, 3, 0 == true ? 1 : 0);
    }

    public LeastRecentlyAddedSet(int i, LinkedHashSet<E> linkedHashSet) {
        Intrinsics3.checkNotNullParameter(linkedHashSet, "_set");
        this.maxSize = i;
        this._set = linkedHashSet;
    }

    @Override // java.util.Set, java.util.Collection
    public synchronized boolean add(E element) {
        boolean zRemove;
        zRemove = this._set.remove(element);
        Iterator<E> it = this._set.iterator();
        Intrinsics3.checkNotNullExpressionValue(it, "_set.iterator()");
        while (this._set.size() >= this.maxSize) {
            it.next();
            it.remove();
        }
        this._set.add(element);
        return !zRemove;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean addAll(Collection<? extends E> elements) {
        Intrinsics3.checkNotNullParameter(elements, "elements");
        return this._set.addAll(elements);
    }

    @Override // java.util.Set, java.util.Collection
    public void clear() {
        this._set.clear();
    }

    @Override // java.util.Set, java.util.Collection
    public boolean contains(Object element) {
        return this._set.contains(element);
    }

    @Override // java.util.Set, java.util.Collection
    public boolean containsAll(Collection<? extends Object> elements) {
        Intrinsics3.checkNotNullParameter(elements, "elements");
        return this._set.containsAll(elements);
    }

    public final int getMaxSize() {
        return this.maxSize;
    }

    public int getSize() {
        return this._set.size();
    }

    @Override // java.util.Set, java.util.Collection
    public boolean isEmpty() {
        return this._set.isEmpty();
    }

    @Override // java.util.Set, java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        Iterator<E> it = this._set.iterator();
        Intrinsics3.checkNotNullExpressionValue(it, "iterator(...)");
        return it;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean remove(Object element) {
        return this._set.remove(element);
    }

    @Override // java.util.Set, java.util.Collection
    public boolean removeAll(Collection<? extends Object> elements) {
        Intrinsics3.checkNotNullParameter(elements, "elements");
        return this._set.removeAll(elements);
    }

    @Override // java.util.Set, java.util.Collection
    public boolean retainAll(Collection<? extends Object> elements) {
        Intrinsics3.checkNotNullParameter(elements, "elements");
        return this._set.retainAll(elements);
    }

    @Override // java.util.Set, java.util.Collection
    public final /* bridge */ int size() {
        return getSize();
    }

    @Override // java.util.Set, java.util.Collection
    public Object[] toArray() {
        return CollectionToArray.toArray(this);
    }

    @Override // java.util.Set, java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        return (T[]) CollectionToArray.toArray(this, tArr);
    }

    public String toString() {
        StringBuilder sbU = outline.U("LRA Set ");
        sbU.append(_Collections.toList(this._set));
        return sbU.toString();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ LeastRecentlyAddedSet(int i, LinkedHashSet linkedHashSet, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        i = (i2 & 1) != 0 ? 3 : i;
        this(i, (i2 & 2) != 0 ? new LinkedHashSet(i) : linkedHashSet);
    }
}
