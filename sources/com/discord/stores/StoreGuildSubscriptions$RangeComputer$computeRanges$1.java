package com.discord.stores;

import d0.z.d.o;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: StoreGuildSubscriptions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGuildSubscriptions$RangeComputer$computeRanges$1 extends o implements Function2<Integer, Integer, Integer> {
    public static final StoreGuildSubscriptions$RangeComputer$computeRanges$1 INSTANCE = new StoreGuildSubscriptions$RangeComputer$computeRanges$1();

    public StoreGuildSubscriptions$RangeComputer$computeRanges$1() {
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
