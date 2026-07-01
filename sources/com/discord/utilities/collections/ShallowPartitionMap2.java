package com.discord.utilities.collections;

import androidx.exifinterface.media.ExifInterface;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: Add missing generic type declarations: [K] */
/* JADX INFO: renamed from: com.discord.utilities.collections.ShallowPartitionMap$Companion$getHashCodePartitionStrategy$1, reason: use source file name */
/* JADX INFO: compiled from: ShallowPartitionMap.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ShallowPartitionMap2<K> extends Lambda implements Function1<K, Integer> {
    public final /* synthetic */ int $numPartitions;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShallowPartitionMap2(int i) {
        super(1);
        this.$numPartitions = i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Integer invoke(Object obj) {
        return Integer.valueOf(invoke2(obj));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final int invoke2(K k) {
        int iHashCode = k != null ? k.hashCode() : 0;
        return Math.abs(iHashCode ^ (iHashCode >>> 16)) % this.$numPartitions;
    }
}
