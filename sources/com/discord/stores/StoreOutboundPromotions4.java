package com.discord.stores;

import com.discord.api.premium.OutboundPromotion;
import com.discord.stores.StoreOutboundPromotions;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.stores.StoreOutboundPromotions$handleConnectionOpen$4, reason: use source file name */
/* JADX INFO: compiled from: StoreOutboundPromotions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreOutboundPromotions4 extends Lambda implements Function1<List<? extends OutboundPromotion>, Unit> {
    public final /* synthetic */ StoreOutboundPromotions this$0;

    /* JADX INFO: renamed from: com.discord.stores.StoreOutboundPromotions$handleConnectionOpen$4$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreOutboundPromotions.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ List $validActivePromos;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(List list) {
            super(0);
            this.$validActivePromos = list;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreOutboundPromotions storeOutboundPromotions = StoreOutboundPromotions4.this.this$0;
            List list = this.$validActivePromos;
            Intrinsics3.checkNotNullExpressionValue(list, "validActivePromos");
            StoreOutboundPromotions storeOutboundPromotions2 = StoreOutboundPromotions4.this.this$0;
            List list2 = this.$validActivePromos;
            Intrinsics3.checkNotNullExpressionValue(list2, "validActivePromos");
            storeOutboundPromotions.state = new StoreOutboundPromotions.State.Loaded(list, storeOutboundPromotions2.getUnseenCount(list2));
            StoreOutboundPromotions4.this.this$0.markChanged();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreOutboundPromotions4(StoreOutboundPromotions storeOutboundPromotions) {
        super(1);
        this.this$0 = storeOutboundPromotions;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(List<? extends OutboundPromotion> list) {
        invoke2((List<OutboundPromotion>) list);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(List<OutboundPromotion> list) {
        this.this$0.dispatcher.schedule(new AnonymousClass1(list));
    }
}
