package com.discord.stores;

import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreOutboundPromotions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreOutboundPromotions$observeUnseenCount$1 extends o implements Function0<Integer> {
    public final /* synthetic */ StoreOutboundPromotions this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreOutboundPromotions$observeUnseenCount$1(StoreOutboundPromotions storeOutboundPromotions) {
        super(0);
        this.this$0 = storeOutboundPromotions;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Integer invoke() {
        return Integer.valueOf(invoke2());
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final int invoke2() {
        return this.this$0.getUnseenCount();
    }
}
