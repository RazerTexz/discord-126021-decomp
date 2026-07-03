package com.discord.utilities.collections;

import androidx.exifinterface.media.ExifInterface;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.IntRange;
import p507d0.p512d0.C11226f;
import p507d0.p580t.AbstractC12126c0;
import p507d0.p580t.C12149o;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.C12227g;
import p507d0.p592z.p594d.C12238m;
import p507d0.p592z.p594d.p595g0.InterfaceC12229b;

/* JADX INFO: compiled from: ShallowPartitionCollection.kt */
/* JADX INFO: loaded from: classes2.dex */
public class ShallowPartitionCollection<E, T extends Collection<E>> implements Collection<E>, InterfaceC12229b {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Function1<E, Integer> partitionStrategy;
    private final List<T> partitions;
    private int size;

    /* JADX INFO: compiled from: ShallowPartitionCollection.kt */
    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ ShallowPartitionCollection withArrayListPartions$default(Companion companion, int i, Function1 function1, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = 40;
            }
            return companion.withArrayListPartions(i, function1);
        }

        public final <E> ShallowPartitionCollection<E, ArrayList<E>> withArrayListPartions(int numPartitions, Function1<? super E, Integer> partitionStrategy) {
            C12238m.checkNotNullParameter(partitionStrategy, "partitionStrategy");
            IntRange intRangeUntil = C11226f.until(0, numPartitions);
            ArrayList arrayList = new ArrayList(C12149o.collectionSizeOrDefault(intRangeUntil, 10));
            Iterator<Integer> it = intRangeUntil.iterator();
            while (it.hasNext()) {
                ((AbstractC12126c0) it).nextInt();
                arrayList.add(new ArrayList());
            }
            return new ShallowPartitionCollection<>(arrayList, partitionStrategy);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ShallowPartitionCollection(List<? extends T> list, Function1<? super E, Integer> function1) {
        C12238m.checkNotNullParameter(list, "partitions");
        C12238m.checkNotNullParameter(function1, "partitionStrategy");
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
        return INSTANCE.withArrayListPartions(i, function1);
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
        C12238m.checkNotNullParameter(elements, "elements");
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
        C12238m.checkNotNullParameter(elements, "elements");
        Iterator<T> it = this.partitions.iterator();
        while (it.hasNext()) {
            elements = C12163u.minus((Iterable) elements, (Iterable) it.next());
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
        C12238m.checkNotNullParameter(elements, "elements");
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
        C12238m.checkNotNullParameter(elements, "elements");
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
        return C12227g.toArray(this);
    }

    @Override // java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        return (T[]) C12227g.toArray(this, tArr);
    }

    @Override // java.util.Collection, java.lang.Iterable
    public MutablePartitionedIterator<E> iterator() {
        return new MutablePartitionedIterator<>(this.partitions.iterator());
    }
}
