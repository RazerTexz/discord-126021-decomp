package com.discord.utilities.collections;

import androidx.exifinterface.media.ExifInterface;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p507d0.p592z.p594d.p595g0.InterfaceC12228a;
import p507d0.p592z.p594d.p595g0.InterfaceC12232e;

/* JADX INFO: compiled from: ShallowPartitionImmutableCollection.kt */
/* JADX INFO: loaded from: classes2.dex */
public class ShallowPartitionImmutableCollection<E, T extends Collection<E>> extends ShallowPartitionCollection<E, T> implements Collection<E>, InterfaceC12228a {
    private final Function1<E, Integer> readOnlyPartitionStrategy;

    /* JADX INFO: renamed from: com.discord.utilities.collections.ShallowPartitionImmutableCollection$1 */
    /* JADX INFO: compiled from: ShallowPartitionImmutableCollection.kt */
    public static final class C67321 extends AbstractC12240o implements Function1<E, Integer> {
        public static final C67321 INSTANCE = new C67321();

        public C67321() {
            super(1);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final int invoke2(E e) {
            return -1;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Integer invoke(Object obj) {
            return Integer.valueOf(invoke2(obj));
        }
    }

    /* JADX INFO: compiled from: ShallowPartitionImmutableCollection.kt */
    public static final class Set<E, T extends java.util.Set<E>> extends ShallowPartitionImmutableCollection<E, T> implements java.util.Set<E>, InterfaceC12232e {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Set(List<? extends T> list, Function1<? super E, Integer> function1) {
            super(list, function1);
            C12238m.checkNotNullParameter(list, "partitions");
            C12238m.checkNotNullParameter(function1, "partitionStrategy");
        }
    }

    public /* synthetic */ ShallowPartitionImmutableCollection(List list, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, (i & 2) != 0 ? null : function1);
    }

    @Override // com.discord.utilities.collections.ShallowPartitionCollection, java.util.Collection
    public boolean add(E element) {
        throw new UnsupportedOperationException();
    }

    @Override // com.discord.utilities.collections.ShallowPartitionCollection, java.util.Collection
    public boolean addAll(Collection<? extends E> elements) {
        C12238m.checkNotNullParameter(elements, "elements");
        throw new UnsupportedOperationException();
    }

    @Override // com.discord.utilities.collections.ShallowPartitionCollection, java.util.Collection
    public boolean contains(Object element) {
        Integer numInvoke;
        Function1<E, Integer> function1 = this.readOnlyPartitionStrategy;
        if (function1 != null && (numInvoke = function1.invoke(element)) != null) {
            return getPartitions().get(numInvoke.intValue()).contains(element);
        }
        List<T> partitions = getPartitions();
        if ((partitions instanceof Collection) && partitions.isEmpty()) {
            return false;
        }
        Iterator<T> it = partitions.iterator();
        while (it.hasNext()) {
            if (((Collection) it.next()).contains(element)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.discord.utilities.collections.ShallowPartitionCollection, java.util.Collection
    public boolean remove(Object element) {
        throw new UnsupportedOperationException();
    }

    @Override // com.discord.utilities.collections.ShallowPartitionCollection, java.util.Collection
    public boolean removeAll(Collection<? extends Object> elements) {
        C12238m.checkNotNullParameter(elements, "elements");
        throw new UnsupportedOperationException();
    }

    @Override // com.discord.utilities.collections.ShallowPartitionCollection, java.util.Collection
    public boolean retainAll(Collection<? extends Object> elements) {
        C12238m.checkNotNullParameter(elements, "elements");
        throw new UnsupportedOperationException();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ShallowPartitionImmutableCollection(List<? extends T> list, Function1<? super E, Integer> function1) {
        super(list, C67321.INSTANCE);
        C12238m.checkNotNullParameter(list, "partitions");
        this.readOnlyPartitionStrategy = function1;
    }

    @Override // com.discord.utilities.collections.ShallowPartitionCollection, java.util.Collection
    public Void clear() {
        throw new UnsupportedOperationException();
    }
}
