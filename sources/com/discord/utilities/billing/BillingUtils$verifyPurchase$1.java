package com.discord.utilities.billing;

import com.android.billingclient.api.Purchase;
import com.discord.restapi.RestAPIParams$VerifyPurchaseResponse;
import com.discord.stores.StoreGooglePlayPurchases$VerificationResult;
import com.discord.stores.StoreStream;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: BillingUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class BillingUtils$verifyPurchase$1 extends o implements Function1<RestAPIParams$VerifyPurchaseResponse, Unit> {
    public final /* synthetic */ Purchase $purchase;
    public final /* synthetic */ String $sku;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BillingUtils$verifyPurchase$1(Purchase purchase, String str) {
        super(1);
        this.$purchase = purchase;
        this.$sku = str;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(RestAPIParams$VerifyPurchaseResponse restAPIParams$VerifyPurchaseResponse) {
        invoke2(restAPIParams$VerifyPurchaseResponse);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(RestAPIParams$VerifyPurchaseResponse restAPIParams$VerifyPurchaseResponse) {
        StoreStream.Companion.getGooglePlayPurchases().onVerificationSuccess(new StoreGooglePlayPurchases$VerificationResult(this.$purchase, restAPIParams$VerifyPurchaseResponse));
        GooglePlayInAppSku inAppSku = GooglePlayInAppSkus.INSTANCE.getInAppSku(this.$sku);
        if (inAppSku != null) {
            GooglePlayBillingManager.INSTANCE.consumePurchase(this.$purchase, inAppSku.getType(), restAPIParams$VerifyPurchaseResponse != null ? Long.valueOf(restAPIParams$VerifyPurchaseResponse.getVerifiedSkuId()) : null);
        }
    }
}
