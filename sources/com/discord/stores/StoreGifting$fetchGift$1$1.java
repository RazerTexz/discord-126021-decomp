package com.discord.stores;

import com.discord.models.domain.ModelGift;
import com.discord.utilities.analytics.AnalyticsTracker;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreGifting.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGifting$fetchGift$1$1 extends o implements Function0<Unit> {
    public final /* synthetic */ ModelGift $gift;
    public final /* synthetic */ StoreGifting$fetchGift$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreGifting$fetchGift$1$1(StoreGifting$fetchGift$1 storeGifting$fetchGift$1, ModelGift modelGift) {
        super(0);
        this.this$0 = storeGifting$fetchGift$1;
        this.$gift = modelGift;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        AnalyticsTracker.INSTANCE.giftResolved(this.$gift);
        StoreGifting$fetchGift$1 storeGifting$fetchGift$1 = this.this$0;
        StoreGifting.access$setGifts(storeGifting$fetchGift$1.this$0, storeGifting$fetchGift$1.$giftCode, new StoreGifting$GiftState$Resolved(this.$gift));
    }
}
