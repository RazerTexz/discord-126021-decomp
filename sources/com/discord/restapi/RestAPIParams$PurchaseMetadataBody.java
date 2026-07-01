package com.discord.restapi;

import b.d.b.a.a;
import d0.z.d.m;

/* JADX INFO: compiled from: RestAPIParams.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class RestAPIParams$PurchaseMetadataBody {
    private final String paymentGatewaySkuId;
    private final long skuId;

    public RestAPIParams$PurchaseMetadataBody(long j, String str) {
        m.checkNotNullParameter(str, "paymentGatewaySkuId");
        this.skuId = j;
        this.paymentGatewaySkuId = str;
    }

    public static /* synthetic */ RestAPIParams$PurchaseMetadataBody copy$default(RestAPIParams$PurchaseMetadataBody restAPIParams$PurchaseMetadataBody, long j, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            j = restAPIParams$PurchaseMetadataBody.skuId;
        }
        if ((i & 2) != 0) {
            str = restAPIParams$PurchaseMetadataBody.paymentGatewaySkuId;
        }
        return restAPIParams$PurchaseMetadataBody.copy(j, str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getSkuId() {
        return this.skuId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getPaymentGatewaySkuId() {
        return this.paymentGatewaySkuId;
    }

    public final RestAPIParams$PurchaseMetadataBody copy(long skuId, String paymentGatewaySkuId) {
        m.checkNotNullParameter(paymentGatewaySkuId, "paymentGatewaySkuId");
        return new RestAPIParams$PurchaseMetadataBody(skuId, paymentGatewaySkuId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RestAPIParams$PurchaseMetadataBody)) {
            return false;
        }
        RestAPIParams$PurchaseMetadataBody restAPIParams$PurchaseMetadataBody = (RestAPIParams$PurchaseMetadataBody) other;
        return this.skuId == restAPIParams$PurchaseMetadataBody.skuId && m.areEqual(this.paymentGatewaySkuId, restAPIParams$PurchaseMetadataBody.paymentGatewaySkuId);
    }

    public final String getPaymentGatewaySkuId() {
        return this.paymentGatewaySkuId;
    }

    public final long getSkuId() {
        return this.skuId;
    }

    public int hashCode() {
        long j = this.skuId;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        String str = this.paymentGatewaySkuId;
        return i + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("PurchaseMetadataBody(skuId=");
        sbU.append(this.skuId);
        sbU.append(", paymentGatewaySkuId=");
        return a.J(sbU, this.paymentGatewaySkuId, ")");
    }
}
