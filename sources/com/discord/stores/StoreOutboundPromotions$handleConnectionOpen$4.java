package com.discord.stores;

import com.discord.api.premium.OutboundPromotion;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: StoreOutboundPromotions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreOutboundPromotions$handleConnectionOpen$4 extends AbstractC12240o implements Function1<List<? extends OutboundPromotion>, Unit> {
    public final /* synthetic */ StoreOutboundPromotions this$0;

    /* JADX INFO: renamed from: com.discord.stores.StoreOutboundPromotions$handleConnectionOpen$4$1 */
    /* JADX INFO: compiled from: StoreOutboundPromotions.kt */
    public static final class C63181 extends AbstractC12240o implements Function0<Unit> {
        public final /* synthetic */ List $validActivePromos;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C63181(List list) {
            super(0);
            this.$validActivePromos = list;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreOutboundPromotions storeOutboundPromotions = StoreOutboundPromotions$handleConnectionOpen$4.this.this$0;
            List list = this.$validActivePromos;
            C12238m.checkNotNullExpressionValue(list, "validActivePromos");
            StoreOutboundPromotions storeOutboundPromotions2 = StoreOutboundPromotions$handleConnectionOpen$4.this.this$0;
            List list2 = this.$validActivePromos;
            C12238m.checkNotNullExpressionValue(list2, "validActivePromos");
            storeOutboundPromotions.state = new StoreOutboundPromotions.State.Loaded(list, storeOutboundPromotions2.getUnseenCount(list2));
            StoreOutboundPromotions$handleConnectionOpen$4.this.this$0.markChanged();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreOutboundPromotions$handleConnectionOpen$4(StoreOutboundPromotions storeOutboundPromotions) {
        super(1);
        this.this$0 = storeOutboundPromotions;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(List<? extends OutboundPromotion> list) {
        invoke2((List<OutboundPromotion>) list);
        return Unit.f27425a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(List<OutboundPromotion> list) {
        this.this$0.dispatcher.schedule(new C63181(list));
    }
}
