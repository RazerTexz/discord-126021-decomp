package com.discord.utilities.collections;

import androidx.exifinterface.media.ExifInterface;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.C12227g;
import p507d0.p592z.p594d.C12238m;
import p507d0.p592z.p594d.p595g0.InterfaceC12232e;

/* JADX INFO: compiled from: LeastRecentlyAddedSet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class LeastRecentlyAddedSet<E> implements Set<E>, InterfaceC12232e {
    private final LinkedHashSet<E> _set;
    private final int maxSize;

    /* JADX WARN: Multi-variable type inference failed */
    public LeastRecentlyAddedSet() {
        this(0, null, 3, 0 == true ? 1 : 0);
    }

    public LeastRecentlyAddedSet(int i, LinkedHashSet<E> linkedHashSet) {
        C12238m.checkNotNullParameter(linkedHashSet, "_set");
        this.maxSize = i;
        this._set = linkedHashSet;
    }

    @Override // java.util.Set, java.util.Collection
    public synchronized boolean add(E element) {
        boolean zRemove;
        zRemove = this._set.remove(element);
        Iterator<E> it = this._set.iterator();
        C12238m.checkNotNullExpressionValue(it, "_set.iterator()");
        while (this._set.size() >= this.maxSize) {
            it.next();
            it.remove();
        }
        this._set.add(element);
        return !zRemove;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean addAll(Collection<? extends E> elements) {
        C12238m.checkNotNullParameter(elements, "elements");
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
        C12238m.checkNotNullParameter(elements, "elements");
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
        C12238m.checkNotNullExpressionValue(it, "iterator(...)");
        return it;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean remove(Object element) {
        return this._set.remove(element);
    }

    @Override // java.util.Set, java.util.Collection
    public boolean removeAll(Collection<? extends Object> elements) {
        C12238m.checkNotNullParameter(elements, "elements");
        return this._set.removeAll(elements);
    }

    @Override // java.util.Set, java.util.Collection
    public boolean retainAll(Collection<? extends Object> elements) {
        C12238m.checkNotNullParameter(elements, "elements");
        return this._set.retainAll(elements);
    }

    @Override // java.util.Set, java.util.Collection
    public final /* bridge */ int size() {
        return getSize();
    }

    @Override // java.util.Set, java.util.Collection
    public Object[] toArray() {
        return C12227g.toArray(this);
    }

    @Override // java.util.Set, java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        return (T[]) C12227g.toArray(this, tArr);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("LRA Set ");
        sbM833U.append(C12163u.toList(this._set));
        return sbM833U.toString();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ LeastRecentlyAddedSet(int i, LinkedHashSet linkedHashSet, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        i = (i2 & 1) != 0 ? 3 : i;
        this(i, (i2 & 2) != 0 ? new LinkedHashSet(i) : linkedHashSet);
    }
}
