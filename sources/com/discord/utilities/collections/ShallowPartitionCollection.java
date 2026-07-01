package com.discord.utilities.collections;

import androidx.exifinterface.media.ExifInterface;
import d0.t.u;
import d0.z.d.g;
import d0.z.d.g0.b;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: ShallowPartitionCollection.kt */
/* JADX INFO: loaded from: classes2.dex */
public class ShallowPartitionCollection<E, T extends Collection<E>> implements Collection<E>, b {
    public static final ShallowPartitionCollection$Companion Companion = new ShallowPartitionCollection$Companion(null);
    private final Function1<E, Integer> partitionStrategy;
    private final List<T> partitions;
    private int size;

    /* JADX WARN: Multi-variable type inference failed */
    public ShallowPartitionCollection(List<? extends T> list, Function1<? super E, Integer> function1) {
        m.checkNotNullParameter(list, "partitions");
        m.checkNotNullParameter(function1, "partitionStrategy");
        this.partitions = list;
        this.partitionStrategy = function1;
        Iterator it = list.iterator();
        int size = 0;
        while (it.hasNext()) {
            size += ((Collection) it.next()).size();
        }
        this.size = size;
    }

    private final T getPartition(E key) {
        return this.partitions.get(this.partitionStrategy.invoke(key).intValue());
    }

    public static final <E> ShallowPartitionCollection<E, ArrayList<E>> withArrayListPartions(int i, Function1<? super E, Integer> function1) {
        return Companion.withArrayListPartions(i, function1);
    }

    @Override // java.util.Collection
    public boolean add(E element) {
        boolean zAdd = getPartition(element).add(element);
        if (zAdd) {
            setSize(size() + 1);
        }
        return zAdd;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Collection
    public boolean addAll(Collection<? extends E> elements) {
        m.checkNotNullParameter(elements, "elements");
        Iterator<T> it = elements.iterator();
        while (true) {
            boolean z2 = false;
            while (it.hasNext()) {
                if (add(it.next()) || z2) {
                    z2 = true;
                }
            }
            return z2;
        }
    }

    @Override // java.util.Collection
    public void clear() {
        Iterator<T> it = this.partitions.iterator();
        while (it.hasNext()) {
            ((Collection) it.next()).clear();
        }
        setSize(0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Collection
    public boolean contains(Object element) {
        return getPartition(element).contains(element);
    }

    @Override // java.util.Collection
    public boolean containsAll(Collection<? extends Object> elements) {
        m.checkNotNullParameter(elements, "elements");
        Iterator<T> it = this.partitions.iterator();
        while (it.hasNext()) {
            elements = u.minus((Iterable) elements, (Iterable) it.next());
        }
        return elements.isEmpty();
    }

    public final Function1<E, Integer> getPartitionStrategy() {
        return this.partitionStrategy;
    }

    public final List<T> getPartitions() {
        return this.partitions;
    }

    public int getSize() {
        return this.size;
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.Collection, java.lang.Iterable
    public /* bridge */ /* synthetic */ Iterator iterator() {
        return iterator();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Collection
    public boolean remove(Object element) {
        boolean zRemove = getPartition(element).remove(element);
        if (zRemove) {
            setSize(size() - 1);
        }
        return zRemove;
    }

    @Override // java.util.Collection
    public boolean removeAll(Collection<? extends Object> elements) {
        m.checkNotNullParameter(elements, "elements");
        Iterator<T> it = elements.iterator();
        while (true) {
            boolean z2 = false;
            while (it.hasNext()) {
                if (remove(it.next()) || z2) {
                    z2 = true;
                }
            }
            return z2;
        }
    }

    @Override // java.util.Collection
    public boolean retainAll(Collection<? extends Object> elements) {
        m.checkNotNullParameter(elements, "elements");
        Iterator<T> it = this.partitions.iterator();
        while (true) {
            boolean z2 = false;
            while (it.hasNext()) {
                if (((Collection) it.next()).retainAll(elements) || z2) {
                    z2 = true;
                }
            }
            return z2;
        }
    }

    public void setSize(int i) {
        this.size = i;
    }

    @Override // java.util.Collection
    public final /* bridge */ int size() {
        return getSize();
    }

    @Override // java.util.Collection
    public Object[] toArray() {
        return g.toArray(this);
    }

    @Override // java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        return (T[]) g.toArray(this, tArr);
    }

    @Override // java.util.Collection, java.lang.Iterable
    public MutablePartitionedIterator<E> iterator() {
        return new MutablePartitionedIterator<>(this.partitions.iterator());
    }
}
