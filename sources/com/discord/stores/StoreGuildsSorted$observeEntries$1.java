package com.discord.stores;

import d0.z.d.o;
import java.util.List;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreGuildsSorted.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGuildsSorted$observeEntries$1 extends o implements Function0<List<? extends StoreGuildsSorted$Entry>> {
    public final /* synthetic */ StoreGuildsSorted this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreGuildsSorted$observeEntries$1(StoreGuildsSorted storeGuildsSorted) {
        super(0);
        this.this$0 = storeGuildsSorted;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ List<? extends StoreGuildsSorted$Entry> invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final List<? extends StoreGuildsSorted$Entry> invoke2() {
        return this.this$0.getEntries();
    }
}
