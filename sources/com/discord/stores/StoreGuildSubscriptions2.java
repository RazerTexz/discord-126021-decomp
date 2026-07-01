package com.discord.stores;

import d0.z.d.Lambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: renamed from: com.discord.stores.StoreGuildSubscriptions$RangeComputer$computeRanges$1, reason: use source file name */
/* JADX INFO: compiled from: StoreGuildSubscriptions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGuildSubscriptions2 extends Lambda implements Function2<Integer, Integer, Integer> {
    public static final StoreGuildSubscriptions2 INSTANCE = new StoreGuildSubscriptions2();

    public StoreGuildSubscriptions2() {
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Integer invoke(Integer num, Integer num2) {
        return Integer.valueOf(invoke(num.intValue(), num2.intValue()));
    }

    public final int invoke(int i, int i2) {
        return (i / i2) * i2;
    }
}
