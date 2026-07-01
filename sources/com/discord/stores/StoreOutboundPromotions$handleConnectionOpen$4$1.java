package com.discord.stores;

import d0.z.d.m;
import d0.z.d.o;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreOutboundPromotions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreOutboundPromotions$handleConnectionOpen$4$1 extends o implements Function0<Unit> {
    public final /* synthetic */ List $validActivePromos;
    public final /* synthetic */ StoreOutboundPromotions$handleConnectionOpen$4 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreOutboundPromotions$handleConnectionOpen$4$1(StoreOutboundPromotions$handleConnectionOpen$4 storeOutboundPromotions$handleConnectionOpen$4, List list) {
        super(0);
        this.this$0 = storeOutboundPromotions$handleConnectionOpen$4;
        this.$validActivePromos = list;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        StoreOutboundPromotions storeOutboundPromotions = this.this$0.this$0;
        List list = this.$validActivePromos;
        m.checkNotNullExpressionValue(list, "validActivePromos");
        StoreOutboundPromotions storeOutboundPromotions2 = this.this$0.this$0;
        List list2 = this.$validActivePromos;
        m.checkNotNullExpressionValue(list2, "validActivePromos");
        StoreOutboundPromotions.access$setState$p(storeOutboundPromotions, new StoreOutboundPromotions$State$Loaded(list, StoreOutboundPromotions.access$getUnseenCount(storeOutboundPromotions2, list2)));
        this.this$0.this$0.markChanged();
    }
}
