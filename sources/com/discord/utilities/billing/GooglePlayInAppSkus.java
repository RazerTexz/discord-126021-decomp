package com.discord.utilities.billing;

import com.android.billingclient.api.SkuDetails;
import com.discord.models.domain.ModelSku;
import d0.d0.f;
import d0.t.g0;
import d0.t.o;
import d0.z.d.m;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map$Entry;

/* JADX INFO: compiled from: GooglePlayInAppSku.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GooglePlayInAppSkus {
    public static final GooglePlayInAppSkus INSTANCE = new GooglePlayInAppSkus();
    private static final List<GooglePlayInAppSku> skus = GooglePlayInAppSkuKt.getPremiumGifts();

    private GooglePlayInAppSkus() {
    }

    private final Map<String, GooglePlayInAppSku> getSkusById() {
        List<GooglePlayInAppSku> list = skus;
        LinkedHashMap linkedHashMap = new LinkedHashMap(f.coerceAtLeast(g0.mapCapacity(o.collectionSizeOrDefault(list, 10)), 16));
        for (Object obj : list) {
            linkedHashMap.put(((GooglePlayInAppSku) obj).getPaymentGatewaySkuId(), obj);
        }
        return linkedHashMap;
    }

    public final GooglePlayInAppSku getInAppSku(String paymentGatewaySkuId) {
        m.checkNotNullParameter(paymentGatewaySkuId, "paymentGatewaySkuId");
        return getSkusById().get(paymentGatewaySkuId);
    }

    public final List<GooglePlayInAppSku> getSkus() {
        return skus;
    }

    public final boolean isInAppSku(String paymentGatewaySkuId) {
        m.checkNotNullParameter(paymentGatewaySkuId, "paymentGatewaySkuId");
        return getSkusById().containsKey(paymentGatewaySkuId);
    }

    public final void populateSkuDetails(Map<String, ? extends SkuDetails> skuDetails) {
        m.checkNotNullParameter(skuDetails, "skuDetails");
        for (Map$Entry<String, ? extends SkuDetails> map$Entry : skuDetails.entrySet()) {
            GooglePlayInAppSku googlePlayInAppSku = INSTANCE.getSkusById().get(map$Entry.getKey());
            if (googlePlayInAppSku != null) {
                googlePlayInAppSku.setSkuDetails(map$Entry.getValue());
            }
        }
    }

    public final GooglePlayInAppSku getInAppSku(ModelSku sku) {
        Object next;
        m.checkNotNullParameter(sku, "sku");
        Iterator<T> it = GooglePlayInAppSkuKt.getPremiumGifts().iterator();
        while (it.hasNext()) {
            next = it.next();
            if (m.areEqual(((GooglePlayInAppSku) next).getPaymentGatewaySkuId(), sku.getName())) {
                return (GooglePlayInAppSku) next;
            }
        }
        next = null;
        return (GooglePlayInAppSku) next;
    }
}
