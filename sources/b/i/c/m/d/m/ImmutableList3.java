package b.i.c.m.d.m;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* JADX INFO: renamed from: b.i.c.m.d.m.w, reason: use source file name */
/* JADX INFO: compiled from: ImmutableList.java */
/* JADX INFO: loaded from: classes3.dex */
public final class ImmutableList3<E> implements List<E>, RandomAccess {
    public final List<E> j;

    public ImmutableList3(List<E> list) {
        this.j = Collections.unmodifiableList(list);
    }

    @Override // java.util.List, java.util.Collection
    public boolean add(@NonNull E e) {
        return this.j.add(e);
    }

    @Override // java.util.List, java.util.Collection
    public boolean addAll(@NonNull Collection<? extends E> collection) {
        return this.j.addAll(collection);
    }

    @Override // java.util.List, java.util.Collection
    public void clear() {
        this.j.clear();
    }

    @Override // java.util.List, java.util.Collection
    public boolean contains(@Nullable Object obj) {
        return this.j.contains(obj);
    }

    @Override // java.util.List, java.util.Collection
    public boolean containsAll(@NonNull Collection<?> collection) {
        return this.j.containsAll(collection);
    }

    @Override // java.util.List, java.util.Collection
    public boolean equals(@Nullable Object obj) {
        return this.j.equals(obj);
    }

    @Override // java.util.List
    @NonNull
    public E get(int i) {
        return this.j.get(i);
    }

    @Override // java.util.List, java.util.Collection
    public int hashCode() {
        return this.j.hashCode();
    }

    @Override // java.util.List
    public int indexOf(@Nullable Object obj) {
        return this.j.indexOf(obj);
    }

    @Override // java.util.List, java.util.Collection
    public boolean isEmpty() {
        return this.j.isEmpty();
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    @NonNull
    public Iterator<E> iterator() {
        return this.j.iterator();
    }

    @Override // java.util.List
    public int lastIndexOf(@Nullable Object obj) {
        return this.j.lastIndexOf(obj);
    }

    @Override // java.util.List
    @NonNull
    public ListIterator<E> listIterator() {
        return this.j.listIterator();
    }

    @Override // java.util.List, java.util.Collection
    public boolean remove(@Nullable Object obj) {
        return this.j.remove(obj);
    }

    @Override // java.util.List, java.util.Collection
    public boolean removeAll(@NonNull Collection<?> collection) {
        return this.j.removeAll(collection);
    }

    @Override // java.util.List, java.util.Collection
    public boolean retainAll(@NonNull Collection<?> collection) {
        return this.j.retainAll(collection);
    }

    @Override // java.util.List
    @NonNull
    public E set(int i, @NonNull E e) {
        return this.j.set(i, e);
    }

    @Override // java.util.List, java.util.Collection
    public int size() {
        return this.j.size();
    }

    @Override // java.util.List
    @NonNull
    public List<E> subList(int i, int i2) {
        return this.j.subList(i, i2);
    }

    @Override // java.util.List, java.util.Collection
    @Nullable
    public Object[] toArray() {
        return this.j.toArray();
    }

    @Override // java.util.List
    public void add(int i, @NonNull E e) {
        this.j.add(i, e);
    }

    @Override // java.util.List
    public boolean addAll(int i, @NonNull Collection<? extends E> collection) {
        return this.j.addAll(i, collection);
    }

    @Override // java.util.List
    @NonNull
    public ListIterator<E> listIterator(int i) {
        return this.j.listIterator(i);
    }

    @Override // java.util.List
    public E remove(int i) {
        return this.j.remove(i);
    }

    @Override // java.util.List, java.util.Collection
    public <T> T[] toArray(@Nullable T[] tArr) {
        return (T[]) this.j.toArray(tArr);
    }
}
