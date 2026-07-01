package com.discord.utilities.collections;

import androidx.exifinterface.media.ExifInterface;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.Map;
import kotlin.jvm.functions.Function1;

/* JADX INFO: Add missing generic type declarations: [V, K] */
/* JADX INFO: renamed from: com.discord.utilities.collections.ShallowPartitionMap$entries$2, reason: use source file name */
/* JADX INFO: compiled from: ShallowPartitionMap.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ShallowPartitionMap3<K, V> extends Lambda implements Function1<Map.Entry<K, V>, Integer> {
    public final /* synthetic */ ShallowPartitionMap this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShallowPartitionMap3(ShallowPartitionMap shallowPartitionMap) {
        super(1);
        this.this$0 = shallowPartitionMap;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Integer invoke(Object obj) {
        return Integer.valueOf(invoke((Map.Entry) obj));
    }

    public final int invoke(Map.Entry<K, V> entry) {
        Intrinsics3.checkNotNullParameter(entry, "it");
        return this.this$0.getPartitionStrategy().invoke(entry.getKey()).intValue();
    }
}
