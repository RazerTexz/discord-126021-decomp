package com.discord.utilities.collections;

import androidx.exifinterface.media.ExifInterface;
import d0.z.d.g0.e;
import d0.z.d.m;
import java.util.List;
import java.util.Set;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: ShallowPartitionImmutableCollection.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ShallowPartitionImmutableCollection$Set<E, T extends Set<E>> extends ShallowPartitionImmutableCollection<E, T> implements Set<E>, e {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShallowPartitionImmutableCollection$Set(List<? extends T> list, Function1<? super E, Integer> function1) {
        super(list, function1);
        m.checkNotNullParameter(list, "partitions");
        m.checkNotNullParameter(function1, "partitionStrategy");
    }
}
