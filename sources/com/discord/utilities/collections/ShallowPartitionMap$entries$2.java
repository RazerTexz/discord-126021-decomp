package com.discord.utilities.collections;

import androidx.exifinterface.media.ExifInterface;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: Add missing generic type declarations: [V, K] */
/* JADX INFO: compiled from: ShallowPartitionMap.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ShallowPartitionMap$entries$2<K, V> extends AbstractC12240o implements Function1<Map.Entry<K, V>, Integer> {
    public final /* synthetic */ ShallowPartitionMap this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShallowPartitionMap$entries$2(ShallowPartitionMap shallowPartitionMap) {
        super(1);
        this.this$0 = shallowPartitionMap;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Integer invoke(Object obj) {
        return Integer.valueOf(invoke((Map.Entry) obj));
    }

    public final int invoke(Map.Entry<K, V> entry) {
        C12238m.checkNotNullParameter(entry, "it");
        return this.this$0.getPartitionStrategy().invoke(entry.getKey()).intValue();
    }
}
