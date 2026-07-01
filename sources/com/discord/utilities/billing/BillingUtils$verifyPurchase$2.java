package com.discord.utilities.billing;

import com.android.billingclient.api.Purchase;
import com.discord.stores.StoreGooglePlayPurchases$VerificationResult;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreStream$Companion;
import com.discord.utilities.error.Error;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: BillingUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class BillingUtils$verifyPurchase$2 extends o implements Function1<Error, Unit> {
    public final /* synthetic */ Purchase $purchase;
    public final /* synthetic */ String $sku;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BillingUtils$verifyPurchase$2(Purchase purchase, String str) {
        super(1);
        this.$purchase = purchase;
        this.$sku = str;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Error error) {
        invoke2(error);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Error error) {
        m.checkNotNullParameter(error, "it");
        StoreStream$Companion storeStream$Companion = StoreStream.Companion;
        storeStream$Companion.getGooglePlayPurchases().onVerificationFailure(new StoreGooglePlayPurchases$VerificationResult(this.$purchase, null));
        storeStream$Companion.getGooglePlayPurchases().trackPaymentFlowFailed(this.$sku);
    }
}
