package com.discord.utilities.billing;

import com.android.billingclient.api.Purchase;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreGooglePlayPurchases;
import com.discord.stores.StoreStream;
import com.discord.utilities.error.Error;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import rx.Subscription;

/* JADX INFO: compiled from: BillingUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class BillingUtils {
    public static final BillingUtils INSTANCE = new BillingUtils();

    /* JADX INFO: renamed from: com.discord.utilities.billing.BillingUtils$createPendingPurchaseMetadata$1, reason: invalid class name */
    /* JADX INFO: compiled from: BillingUtils.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<Unit, Unit> {
        public final /* synthetic */ Function0 $onSuccess;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Function0 function0) {
            super(1);
            this.$onSuccess = function0;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Unit unit) {
            invoke2(unit);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Unit unit) {
            this.$onSuccess.invoke();
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.billing.BillingUtils$createPendingPurchaseMetadata$2, reason: invalid class name */
    /* JADX INFO: compiled from: BillingUtils.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<Error, Unit> {
        public final /* synthetic */ Function0 $onFailure;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Function0 function0) {
            super(1);
            this.$onFailure = function0;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "it");
            this.$onFailure.invoke();
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.billing.BillingUtils$verifyPurchase$1, reason: invalid class name */
    /* JADX INFO: compiled from: BillingUtils.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<RestAPIParams.VerifyPurchaseResponse, Unit> {
        public final /* synthetic */ Purchase $purchase;
        public final /* synthetic */ String $sku;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Purchase purchase, String str) {
            super(1);
            this.$purchase = purchase;
            this.$sku = str;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RestAPIParams.VerifyPurchaseResponse verifyPurchaseResponse) {
            invoke2(verifyPurchaseResponse);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RestAPIParams.VerifyPurchaseResponse verifyPurchaseResponse) {
            StoreStream.INSTANCE.getGooglePlayPurchases().onVerificationSuccess(new StoreGooglePlayPurchases.VerificationResult(this.$purchase, verifyPurchaseResponse));
            GooglePlayInAppSku inAppSku = GooglePlayInAppSku3.INSTANCE.getInAppSku(this.$sku);
            if (inAppSku != null) {
                GooglePlayBillingManager.INSTANCE.consumePurchase(this.$purchase, inAppSku.getType(), verifyPurchaseResponse != null ? Long.valueOf(verifyPurchaseResponse.getVerifiedSkuId()) : null);
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.billing.BillingUtils$verifyPurchase$2, reason: invalid class name */
    /* JADX INFO: compiled from: BillingUtils.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<Error, Unit> {
        public final /* synthetic */ Purchase $purchase;
        public final /* synthetic */ String $sku;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Purchase purchase, String str) {
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
            Intrinsics3.checkNotNullParameter(error, "it");
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
        if (GooglePlayInAppSku3.INSTANCE.isInAppSku(sku)) {
            str2 = sku;
            str = null;
        } else {
            str = sku;
            str2 = null;
        }
        String strA = purchase.a();
        Intrinsics3.checkNotNullExpressionValue(strA, "purchase.purchaseToken");
        String strOptString = purchase.c.optString("packageName");
        Intrinsics3.checkNotNullExpressionValue(strOptString, "purchase.packageName");
        RestAPIParams.VerifyPurchaseTokenBody verifyPurchaseTokenBody = new RestAPIParams.VerifyPurchaseTokenBody(strA, id2, strOptString, str, str2);
        companion.getGooglePlayPurchases().onVerificationStart();
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().verifyPurchaseToken(verifyPurchaseTokenBody), false, 1, null), (Class<?>) BillingUtils.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new AnonymousClass2(purchase, sku)), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1(purchase, sku));
    }

    public final void createPendingPurchaseMetadata(String paymentGatewaySkuId, long skuId, Function0<Unit> onSuccess, Function0<Unit> onFailure) {
        Intrinsics3.checkNotNullParameter(paymentGatewaySkuId, "paymentGatewaySkuId");
        Intrinsics3.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics3.checkNotNullParameter(onFailure, "onFailure");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().createPurchaseMetadata(new RestAPIParams.PurchaseMetadataBody(skuId, paymentGatewaySkuId)), false, 1, null), (Class<?>) BillingUtils.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new AnonymousClass2(onFailure)), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1(onSuccess));
    }

    public final long microToMinor(long amount) {
        return amount / 10000;
    }

    public final void verifyPurchases(List<? extends Purchase> purchases) {
        if (purchases != null) {
            for (Purchase purchase : purchases) {
                if ((purchase.c.optInt("purchaseState", 1) != 4 ? (char) 1 : (char) 2) == 1 && !purchase.c()) {
                    ArrayList<String> arrayListB = purchase.b();
                    Intrinsics3.checkNotNullExpressionValue(arrayListB, "purchase.skus");
                    for (String str : arrayListB) {
                        BillingUtils billingUtils = INSTANCE;
                        Intrinsics3.checkNotNullExpressionValue(str, "sku");
                        billingUtils.verifyPurchase(purchase, str);
                    }
                }
            }
        }
    }
}
