package com.discord.stores;

import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreGooglePlayPurchases;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p658rx.subjects.PublishSubject;

/* JADX INFO: renamed from: com.discord.stores.StoreGooglePlayPurchases$onVerificationSuccess$$inlined$forEach$lambda$1 */
/* JADX INFO: compiled from: StoreGooglePlayPurchases.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class C6011x737ab450 extends AbstractC12240o implements Function0<Unit> {
    public final /* synthetic */ String $sku;
    public final /* synthetic */ StoreGooglePlayPurchases.VerificationResult $verificationResult$inlined;
    public final /* synthetic */ StoreGooglePlayPurchases this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C6011x737ab450(String str, StoreGooglePlayPurchases storeGooglePlayPurchases, StoreGooglePlayPurchases.VerificationResult verificationResult) {
        super(0);
        this.$sku = str;
        this.this$0 = storeGooglePlayPurchases;
        this.$verificationResult$inlined = verificationResult;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.f27425a;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        PublishSubject publishSubject = this.this$0.eventSubject;
        String str = this.$sku;
        C12238m.checkNotNullExpressionValue(str, "sku");
        RestAPIParams.VerifyPurchaseResponse apiResponse = this.$verificationResult$inlined.getApiResponse();
        Long lValueOf = apiResponse != null ? Long.valueOf(apiResponse.getVerifiedSkuId()) : null;
        RestAPIParams.VerifyPurchaseResponse apiResponse2 = this.$verificationResult$inlined.getApiResponse();
        Long subscriptionPlanId = apiResponse2 != null ? apiResponse2.getSubscriptionPlanId() : null;
        RestAPIParams.VerifyPurchaseResponse apiResponse3 = this.$verificationResult$inlined.getApiResponse();
        publishSubject.f27650k.onNext((T) new StoreGooglePlayPurchases.Event.PurchaseQuerySuccess(str, lValueOf, subscriptionPlanId, apiResponse3 != null ? apiResponse3.getGiftCode() : null));
        this.this$0.queryState = StoreGooglePlayPurchases.QueryState.NotInProgress.INSTANCE;
        this.this$0.markChanged();
    }
}
