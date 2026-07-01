package com.discord.utilities.collections;

import androidx.exifinterface.media.ExifInterface;
import d0.z.d.o;
import kotlin.jvm.functions.Function1;

/* JADX INFO: Add missing generic type declarations: [E] */
/* JADX INFO: compiled from: ShallowPartitionImmutableCollection.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ShallowPartitionImmutableCollection$1<E> extends o implements Function1<E, Integer> {
    public static final ShallowPartitionImmutableCollection$1 INSTANCE = new ShallowPartitionImmutableCollection$1();

    public ShallowPartitionImmutableCollection$1() {
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final int invoke2(E e) {
        return -1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Integer invoke(Object obj) {
        return Integer.valueOf(invoke2(obj));
    }
}
