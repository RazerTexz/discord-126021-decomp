package com.discord.utilities.collections;

import androidx.exifinterface.media.ExifInterface;
import d0.d0.f;
import d0.t.c0;
import d0.t.o;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.IntRange;

/* JADX INFO: compiled from: ShallowPartitionCollection.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ShallowPartitionCollection$Companion {
    private ShallowPartitionCollection$Companion() {
    }

    public static /* synthetic */ ShallowPartitionCollection withArrayListPartions$default(ShallowPartitionCollection$Companion shallowPartitionCollection$Companion, int i, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 40;
        }
        return shallowPartitionCollection$Companion.withArrayListPartions(i, function1);
    }

    public final <E> ShallowPartitionCollection<E, ArrayList<E>> withArrayListPartions(int numPartitions, Function1<? super E, Integer> partitionStrategy) {
        m.checkNotNullParameter(partitionStrategy, "partitionStrategy");
        IntRange intRangeUntil = f.until(0, numPartitions);
        ArrayList arrayList = new ArrayList(o.collectionSizeOrDefault(intRangeUntil, 10));
        Iterator<Integer> it = intRangeUntil.iterator();
        while (it.hasNext()) {
            ((c0) it).nextInt();
            arrayList.add(new ArrayList());
        }
        return new ShallowPartitionCollection<>(arrayList, partitionStrategy);
    }

    public /* synthetic */ ShallowPartitionCollection$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
