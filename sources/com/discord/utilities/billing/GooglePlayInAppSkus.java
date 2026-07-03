package com.discord.utilities.billing;

import com.android.billingclient.api.SkuDetails;
import com.discord.models.domain.ModelSku;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import p507d0.p512d0.C11226f;
import p507d0.p580t.C12134g0;
import p507d0.p580t.C12149o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: GooglePlayInAppSku.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GooglePlayInAppSkus {
    public static final GooglePlayInAppSkus INSTANCE = new GooglePlayInAppSkus();
    private static final List<GooglePlayInAppSku> skus = GooglePlayInAppSkuKt.getPremiumGifts();

    private GooglePlayInAppSkus() {
    }

    private final Map<String, GooglePlayInAppSku> getSkusById() {
        List<GooglePlayInAppSku> list = skus;
        LinkedHashMap linkedHashMap = new LinkedHashMap(C11226f.coerceAtLeast(C12134g0.mapCapacity(C12149o.collectionSizeOrDefault(list, 10)), 16));
        for (Object obj : list) {
            linkedHashMap.put(((GooglePlayInAppSku) obj).getPaymentGatewaySkuId(), obj);
        }
        return linkedHashMap;
    }

    public final GooglePlayInAppSku getInAppSku(String paymentGatewaySkuId) {
        C12238m.checkNotNullParameter(paymentGatewaySkuId, "paymentGatewaySkuId");
        return getSkusById().get(paymentGatewaySkuId);
    }

    public final List<GooglePlayInAppSku> getSkus() {
        return skus;
    }

    public final boolean isInAppSku(String paymentGatewaySkuId) {
        C12238m.checkNotNullParameter(paymentGatewaySkuId, "paymentGatewaySkuId");
        return getSkusById().containsKey(paymentGatewaySkuId);
    }

    public final void populateSkuDetails(Map<String, ? extends SkuDetails> skuDetails) {
        C12238m.checkNotNullParameter(skuDetails, "skuDetails");
        for (Map.Entry<String, ? extends SkuDetails> entry : skuDetails.entrySet()) {
            GooglePlayInAppSku googlePlayInAppSku = INSTANCE.getSkusById().get(entry.getKey());
            if (googlePlayInAppSku != null) {
                googlePlayInAppSku.setSkuDetails(entry.getValue());
            }
        }
    }

    public final GooglePlayInAppSku getInAppSku(ModelSku sku) {
        Object next;
        C12238m.checkNotNullParameter(sku, "sku");
        Iterator<T> it = GooglePlayInAppSkuKt.getPremiumGifts().iterator();
        while (it.hasNext()) {
            next = it.next();
            if (C12238m.areEqual(((GooglePlayInAppSku) next).getPaymentGatewaySkuId(), sku.getName())) {
                return (GooglePlayInAppSku) next;
            }
        }
        next = null;
        return (GooglePlayInAppSku) next;
    }
}
