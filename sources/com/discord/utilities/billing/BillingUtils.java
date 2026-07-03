package com.discord.utilities.billing;

import com.android.billingclient.api.Purchase;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreGooglePlayPurchases;
import com.discord.stores.StoreStream;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.rest.RestAPI;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p658rx.Subscription;

/* JADX INFO: compiled from: BillingUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class BillingUtils {
    public static final BillingUtils INSTANCE = new BillingUtils();

    /* JADX INFO: renamed from: com.discord.utilities.billing.BillingUtils$createPendingPurchaseMetadata$1 */
    /* JADX INFO: compiled from: BillingUtils.kt */
    public static final class C67021 extends AbstractC12240o implements Function1<Unit, Unit> {
        public final /* synthetic */ Function0 $onSuccess;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C67021(Function0 function0) {
            super(1);
            this.$onSuccess = function0;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Unit unit) {
            invoke2(unit);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Unit unit) {
            this.$onSuccess.invoke();
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.billing.BillingUtils$createPendingPurchaseMetadata$2 */
    /* JADX INFO: compiled from: BillingUtils.kt */
    public static final class C67032 extends AbstractC12240o implements Function1<Error, Unit> {
        public final /* synthetic */ Function0 $onFailure;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C67032(Function0 function0) {
            super(1);
            this.$onFailure = function0;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            C12238m.checkNotNullParameter(error, "it");
            this.$onFailure.invoke();
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.billing.BillingUtils$verifyPurchase$1 */
    /* JADX INFO: compiled from: BillingUtils.kt */
    public static final class C67041 extends AbstractC12240o implements Function1<RestAPIParams.VerifyPurchaseResponse, Unit> {
        public final /* synthetic */ Purchase $purchase;
        public final /* synthetic */ String $sku;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C67041(Purchase purchase, String str) {
            super(1);
            this.$purchase = purchase;
            this.$sku = str;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RestAPIParams.VerifyPurchaseResponse verifyPurchaseResponse) {
            invoke2(verifyPurchaseResponse);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RestAPIParams.VerifyPurchaseResponse verifyPurchaseResponse) {
            StoreStream.INSTANCE.getGooglePlayPurchases().onVerificationSuccess(new StoreGooglePlayPurchases.VerificationResult(this.$purchase, verifyPurchaseResponse));
            GooglePlayInAppSku inAppSku = GooglePlayInAppSkus.INSTANCE.getInAppSku(this.$sku);
            if (inAppSku != null) {
                GooglePlayBillingManager.INSTANCE.consumePurchase(this.$purchase, inAppSku.getType(), verifyPurchaseResponse != null ? Long.valueOf(verifyPurchaseResponse.getVerifiedSkuId()) : null);
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.billing.BillingUtils$verifyPurchase$2 */
    /* JADX INFO: compiled from: BillingUtils.kt */
    public static final class C67052 extends AbstractC12240o implements Function1<Error, Unit> {
        public final /* synthetic */ Purchase $purchase;
        public final /* synthetic */ String $sku;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C67052(Purchase purchase, String str) {
            super(1);
            this.$purchase = purchase;
            this.$sku = str;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            C12238m.checkNotNullParameter(error, "it");
            StoreStream.Companion companion = StoreStream.INSTANCE;
            companion.getGooglePlayPurchases().onVerificationFailure(new StoreGooglePlayPurchases.VerificationResult(this.$purchase, null));
            companion.getGooglePlayPurchases().trackPaymentFlowFailed(this.$sku);
        }
    }

    private BillingUtils() {
    }

    private final void verifyPurchase(Purchase purchase, String sku) {
        String str;
        String str2;
        StoreStream.Companion companion = StoreStream.INSTANCE;
        long id2 = companion.getUsers().getMeSnapshot().getId();
        if (GooglePlayInAppSkus.INSTANCE.isInAppSku(sku)) {
            str2 = sku;
            str = null;
        } else {
            str = sku;
            str2 = null;
        }
        String strM7497a = purchase.m7497a();
        C12238m.checkNotNullExpressionValue(strM7497a, "purchase.purchaseToken");
        String strOptString = purchase.f14563c.optString("packageName");
        C12238m.checkNotNullExpressionValue(strOptString, "purchase.packageName");
        RestAPIParams.VerifyPurchaseTokenBody verifyPurchaseTokenBody = new RestAPIParams.VerifyPurchaseTokenBody(strM7497a, id2, strOptString, str, str2);
        companion.getGooglePlayPurchases().onVerificationStart();
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().verifyPurchaseToken(verifyPurchaseTokenBody), false, 1, null), (Class<?>) BillingUtils.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new C67052(purchase, sku)), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C67041(purchase, sku));
    }

    public final void createPendingPurchaseMetadata(String paymentGatewaySkuId, long skuId, Function0<Unit> onSuccess, Function0<Unit> onFailure) {
        C12238m.checkNotNullParameter(paymentGatewaySkuId, "paymentGatewaySkuId");
        C12238m.checkNotNullParameter(onSuccess, "onSuccess");
        C12238m.checkNotNullParameter(onFailure, "onFailure");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().createPurchaseMetadata(new RestAPIParams.PurchaseMetadataBody(skuId, paymentGatewaySkuId)), false, 1, null), (Class<?>) BillingUtils.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new C67032(onFailure)), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C67021(onSuccess));
    }

    public final long microToMinor(long amount) {
        return amount / 10000;
    }

    public final void verifyPurchases(List<? extends Purchase> purchases) {
        if (purchases != null) {
            for (Purchase purchase : purchases) {
                if ((purchase.f14563c.optInt("purchaseState", 1) != 4 ? (char) 1 : (char) 2) == 1 && !purchase.m7499c()) {
                    ArrayList<String> arrayListM7498b = purchase.m7498b();
                    C12238m.checkNotNullExpressionValue(arrayListM7498b, "purchase.skus");
                    for (String str : arrayListM7498b) {
                        BillingUtils billingUtils = INSTANCE;
                        C12238m.checkNotNullExpressionValue(str, "sku");
                        billingUtils.verifyPurchase(purchase, str);
                    }
                }
            }
        }
    }
}
