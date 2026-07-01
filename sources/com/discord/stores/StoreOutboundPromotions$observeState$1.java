package com.discord.stores;

import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreOutboundPromotions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreOutboundPromotions$observeState$1 extends o implements Function0<StoreOutboundPromotions$State> {
    public final /* synthetic */ StoreOutboundPromotions this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreOutboundPromotions$observeState$1(StoreOutboundPromotions storeOutboundPromotions) {
        super(0);
        this.this$0 = storeOutboundPromotions;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ StoreOutboundPromotions$State invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final StoreOutboundPromotions$State invoke() {
        return this.this$0.getStateSnapshot();
    }
}
