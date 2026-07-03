package p007b.p225i.p361c.p369m.p370d.p375m;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* JADX INFO: renamed from: b.i.c.m.d.m.w */
/* JADX INFO: compiled from: ImmutableList.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C4696w<E> implements List<E>, RandomAccess {

    /* JADX INFO: renamed from: j */
    public final List<E> f12648j;

    public C4696w(List<E> list) {
        this.f12648j = Collections.unmodifiableList(list);
    }

    @Override // java.util.List, java.util.Collection
    public boolean add(@NonNull E e) {
        return this.f12648j.add(e);
    }

    @Override // java.util.List, java.util.Collection
    public boolean addAll(@NonNull Collection<? extends E> collection) {
        return this.f12648j.addAll(collection);
    }

    @Override // java.util.List, java.util.Collection
    public void clear() {
        this.f12648j.clear();
    }

    @Override // java.util.List, java.util.Collection
    public boolean contains(@Nullable Object obj) {
        return this.f12648j.contains(obj);
    }

    @Override // java.util.List, java.util.Collection
    public boolean containsAll(@NonNull Collection<?> collection) {
        return this.f12648j.containsAll(collection);
    }

    @Override // java.util.List, java.util.Collection
    public boolean equals(@Nullable Object obj) {
        return this.f12648j.equals(obj);
    }

    @Override // java.util.List
    @NonNull
    public E get(int i) {
        return this.f12648j.get(i);
    }

    @Override // java.util.List, java.util.Collection
    public int hashCode() {
        return this.f12648j.hashCode();
    }

    @Override // java.util.List
    public int indexOf(@Nullable Object obj) {
        return this.f12648j.indexOf(obj);
    }

    @Override // java.util.List, java.util.Collection
    public boolean isEmpty() {
        return this.f12648j.isEmpty();
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    @NonNull
    public Iterator<E> iterator() {
        return this.f12648j.iterator();
    }

    @Override // java.util.List
    public int lastIndexOf(@Nullable Object obj) {
        return this.f12648j.lastIndexOf(obj);
    }

    @Override // java.util.List
    @NonNull
    public ListIterator<E> listIterator() {
        return this.f12648j.listIterator();
    }

    @Override // java.util.List, java.util.Collection
    public boolean remove(@Nullable Object obj) {
        return this.f12648j.remove(obj);
    }

    @Override // java.util.List, java.util.Collection
    public boolean removeAll(@NonNull Collection<?> collection) {
        return this.f12648j.removeAll(collection);
    }

    @Override // java.util.List, java.util.Collection
    public boolean retainAll(@NonNull Collection<?> collection) {
        return this.f12648j.retainAll(collection);
    }

    @Override // java.util.List
    @NonNull
    public E set(int i, @NonNull E e) {
        return this.f12648j.set(i, e);
    }

    @Override // java.util.List, java.util.Collection
    public int size() {
        return this.f12648j.size();
    }

    @Override // java.util.List
    @NonNull
    public List<E> subList(int i, int i2) {
        return this.f12648j.subList(i, i2);
    }

    @Override // java.util.List, java.util.Collection
    @Nullable
    public Object[] toArray() {
        return this.f12648j.toArray();
    }

    @Override // java.util.List
    public void add(int i, @NonNull E e) {
        this.f12648j.add(i, e);
    }

    @Override // java.util.List
    public boolean addAll(int i, @NonNull Collection<? extends E> collection) {
        return this.f12648j.addAll(i, collection);
    }

    @Override // java.util.List
    @NonNull
    public ListIterator<E> listIterator(int i) {
        return this.f12648j.listIterator(i);
    }

    @Override // java.util.List
    public E remove(int i) {
        return this.f12648j.remove(i);
    }

    @Override // java.util.List, java.util.Collection
    public <T> T[] toArray(@Nullable T[] tArr) {
        return (T[]) this.f12648j.toArray(tArr);
    }
}
