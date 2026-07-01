package com.discord.utilities.gifting;

import android.view.View;
import com.discord.stores.StoreStream;
import com.discord.utilities.billing.GooglePlayInAppSku;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: GiftingUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GiftingUtils$buyGift$2 extends o implements Function1<View, Unit> {
    public final /* synthetic */ GooglePlayInAppSku $inAppSku;
    public final /* synthetic */ GiftingUtils$buyGift$1 $launchBillingFlow$1;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GiftingUtils$buyGift$2(GooglePlayInAppSku googlePlayInAppSku, GiftingUtils$buyGift$1 giftingUtils$buyGift$1) {
        super(1);
        this.$inAppSku = googlePlayInAppSku;
        this.$launchBillingFlow$1 = giftingUtils$buyGift$1;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(View view) {
        invoke2(view);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(View view) {
        m.checkNotNullParameter(view, "it");
        StoreStream.Companion.getGooglePlayPurchases().trackPaymentFlowStep(this.$inAppSku.getPaymentGatewaySkuId(), "warning_dialog", "");
        this.$launchBillingFlow$1.invoke2();
    }
}
