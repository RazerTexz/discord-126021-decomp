package com.discord.stores;

import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.error.Error;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreGifting.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGifting$fetchGift$2$1 extends o implements Function0<Unit> {
    public final /* synthetic */ Error $error;
    public final /* synthetic */ StoreGifting$fetchGift$2 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreGifting$fetchGift$2$1(StoreGifting$fetchGift$2 storeGifting$fetchGift$2, Error error) {
        super(0);
        this.this$0 = storeGifting$fetchGift$2;
        this.$error = error;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        AnalyticsTracker.INSTANCE.giftResolvedFailed(this.this$0.$giftCode);
        int iOrdinal = this.$error.getType().ordinal();
        if (iOrdinal == 3) {
            this.$error.setShowErrorToasts(false);
            StoreGifting$fetchGift$2 storeGifting$fetchGift$2 = this.this$0;
            StoreGifting.access$setGifts(storeGifting$fetchGift$2.this$0, storeGifting$fetchGift$2.$giftCode, StoreGifting$GiftState$Invalid.INSTANCE);
        } else if (iOrdinal != 11) {
            StoreGifting$fetchGift$2 storeGifting$fetchGift$3 = this.this$0;
            StoreGifting.access$setGifts(storeGifting$fetchGift$3.this$0, storeGifting$fetchGift$3.$giftCode, StoreGifting$GiftState$LoadFailed.INSTANCE);
        } else {
            StoreGifting$fetchGift$2 storeGifting$fetchGift$4 = this.this$0;
            StoreGifting.access$setGifts(storeGifting$fetchGift$4.this$0, storeGifting$fetchGift$4.$giftCode, StoreGifting$GiftState$LoadFailed.INSTANCE);
        }
    }
}
