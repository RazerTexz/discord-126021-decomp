package com.discord.utilities.collections;

import androidx.exifinterface.media.ExifInterface;
import d0.a0.a;
import d0.t.c0;
import d0.t.o;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.IntRange;

/* JADX INFO: compiled from: ShallowPartitionMap.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ShallowPartitionMap$Companion {
    private ShallowPartitionMap$Companion() {
    }

    public static /* synthetic */ ShallowPartitionMap create$default(ShallowPartitionMap$Companion shallowPartitionMap$Companion, int i, int i2, int i3, Function1 function1, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 100;
        }
        if ((i4 & 4) != 0) {
            i3 = a.roundToInt((float) Math.ceil((i > 0 ? i : 1) / i2));
        }
        if ((i4 & 8) != 0) {
            function1 = shallowPartitionMap$Companion.getHashCodePartitionStrategy(i3);
        }
        return shallowPartitionMap$Companion.create(i, i2, i3, function1);
    }

    private final <K> Function1<K, Integer> getHashCodePartitionStrategy(int numPartitions) {
        return new ShallowPartitionMap$Companion$getHashCodePartitionStrategy$1(numPartitions);
    }

    public final <K, V> ShallowPartitionMap<K, V> create(int mapSize, int partitionSize, int partitionCount, Function1<? super K, Integer> partitionStrategy) {
        m.checkNotNullParameter(partitionStrategy, "partitionStrategy");
        IntRange intRange = new IntRange(0, partitionCount);
        ArrayList arrayList = new ArrayList(o.collectionSizeOrDefault(intRange, 10));
        Iterator<Integer> it = intRange.iterator();
        while (it.hasNext()) {
            ((c0) it).nextInt();
            arrayList.add(new HashMap(partitionSize));
        }
        return new ShallowPartitionMap<>(arrayList, partitionStrategy);
    }

    public /* synthetic */ ShallowPartitionMap$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
