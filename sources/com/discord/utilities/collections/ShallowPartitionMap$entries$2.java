package com.discord.utilities.collections;

import androidx.exifinterface.media.ExifInterface;
import d0.z.d.m;
import d0.z.d.o;
import java.util.Map$Entry;
import kotlin.jvm.functions.Function1;

/* JADX INFO: Add missing generic type declarations: [V, K] */
/* JADX INFO: compiled from: ShallowPartitionMap.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ShallowPartitionMap$entries$2<K, V> extends o implements Function1<Map$Entry<K, V>, Integer> {
    public final /* synthetic */ ShallowPartitionMap this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShallowPartitionMap$entries$2(ShallowPartitionMap shallowPartitionMap) {
        super(1);
        this.this$0 = shallowPartitionMap;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Integer invoke(Object obj) {
        return Integer.valueOf(invoke((Map$Entry) obj));
    }

    public final int invoke(Map$Entry<K, V> map$Entry) {
        m.checkNotNullParameter(map$Entry, "it");
        return this.this$0.getPartitionStrategy().invoke(map$Entry.getKey()).intValue();
    }
}
