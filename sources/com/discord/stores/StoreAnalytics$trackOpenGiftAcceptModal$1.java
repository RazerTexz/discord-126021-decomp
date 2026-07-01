package com.discord.stores;

import com.discord.models.domain.ModelGift;
import com.discord.utilities.analytics.AnalyticsTracker;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreAnalytics.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreAnalytics$trackOpenGiftAcceptModal$1 extends o implements Function0<Unit> {
    public final /* synthetic */ long $channelId;
    public final /* synthetic */ String $giftCode;
    public final /* synthetic */ String $location;
    public final /* synthetic */ StoreAnalytics this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreAnalytics$trackOpenGiftAcceptModal$1(StoreAnalytics storeAnalytics, String str, long j, String str2) {
        super(0);
        this.this$0 = storeAnalytics;
        this.$giftCode = str;
        this.$channelId = j;
        this.$location = str2;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        ModelGift gift;
        StoreGifting$GiftState storeGifting$GiftState = StoreAnalytics.access$getStores$p(this.this$0).getGifting().getKnownGifts().get(this.$giftCode);
        if (storeGifting$GiftState instanceof StoreGifting$GiftState$Resolved) {
            gift = ((StoreGifting$GiftState$Resolved) storeGifting$GiftState).getGift();
        } else if (storeGifting$GiftState instanceof StoreGifting$GiftState$Redeeming) {
            gift = ((StoreGifting$GiftState$Redeeming) storeGifting$GiftState).getGift();
        } else {
            gift = storeGifting$GiftState instanceof StoreGifting$GiftState$RedeemedFailed ? ((StoreGifting$GiftState$RedeemedFailed) storeGifting$GiftState).getGift() : null;
        }
        if (gift != null) {
            AnalyticsTracker.openGiftModal(gift, StoreAnalytics.access$getStores$p(this.this$0).getChannels().findChannelByIdInternal$app_productionGoogleRelease(this.$channelId), this.$location);
        }
    }
}
