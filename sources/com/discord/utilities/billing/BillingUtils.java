package com.discord.utilities.billing;

import android.content.Context;
import com.android.billingclient.api.Purchase;
import com.discord.restapi.RestAPIParams$PurchaseMetadataBody;
import com.discord.restapi.RestAPIParams$VerifyPurchaseTokenBody;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreStream$Companion;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: BillingUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class BillingUtils {
    public static final BillingUtils INSTANCE = new BillingUtils();

    private BillingUtils() {
    }

    private final void verifyPurchase(Purchase purchase, String sku) {
        String str;
        String str2;
        StoreStream$Companion storeStream$Companion = StoreStream.Companion;
        long id2 = storeStream$Companion.getUsers().getMeSnapshot().getId();
        if (GooglePlayInAppSkus.INSTANCE.isInAppSku(sku)) {
            str2 = sku;
            str = null;
        } else {
            str = sku;
            str2 = null;
        }
        String strA = purchase.a();
        m.checkNotNullExpressionValue(strA, "purchase.purchaseToken");
        String strOptString = purchase.c.optString("packageName");
        m.checkNotNullExpressionValue(strOptString, "purchase.packageName");
        RestAPIParams$VerifyPurchaseTokenBody restAPIParams$VerifyPurchaseTokenBody = new RestAPIParams$VerifyPurchaseTokenBody(strA, id2, strOptString, str, str2);
        storeStream$Companion.getGooglePlayPurchases().onVerificationStart();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.Companion.getApi().verifyPurchaseToken(restAPIParams$VerifyPurchaseTokenBody), false, 1, null), BillingUtils.class, (Context) null, (Function1) null, new BillingUtils$verifyPurchase$2(purchase, sku), (Function0) null, (Function0) null, new BillingUtils$verifyPurchase$1(purchase, sku), 54, (Object) null);
    }

    public final void createPendingPurchaseMetadata(String paymentGatewaySkuId, long skuId, Function0<Unit> onSuccess, Function0<Unit> onFailure) {
        m.checkNotNullParameter(paymentGatewaySkuId, "paymentGatewaySkuId");
        m.checkNotNullParameter(onSuccess, "onSuccess");
        m.checkNotNullParameter(onFailure, "onFailure");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.Companion.getApi().createPurchaseMetadata(new RestAPIParams$PurchaseMetadataBody(skuId, paymentGatewaySkuId)), false, 1, null), BillingUtils.class, (Context) null, (Function1) null, new BillingUtils$createPendingPurchaseMetadata$2(onFailure), (Function0) null, (Function0) null, new BillingUtils$createPendingPurchaseMetadata$1(onSuccess), 54, (Object) null);
    }

    public final long microToMinor(long amount) {
        return amount / 10000;
    }

    public final void verifyPurchases(List<? extends Purchase> purchases) {
        if (purchases != null) {
            for (Purchase purchase : purchases) {
                if ((purchase.c.optInt("purchaseState", 1) != 4 ? (char) 1 : (char) 2) == 1 && !purchase.c()) {
                    ArrayList<String> arrayListB = purchase.b();
                    m.checkNotNullExpressionValue(arrayListB, "purchase.skus");
                    for (String str : arrayListB) {
                        BillingUtils billingUtils = INSTANCE;
                        m.checkNotNullExpressionValue(str, "sku");
                        billingUtils.verifyPurchase(purchase, str);
                    }
                }
            }
        }
    }
}
