package com.discord.utilities.billing;

import b.d.b.a.a;
import d0.z.d.m;

/* JADX INFO: compiled from: GooglePlayBillingManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class GooglePlayBillingManager$InAppSkuToConsume {
    private final String paymentGatewaySkuId;
    private final Long skuId;
    private final InAppSkuType type;

    public GooglePlayBillingManager$InAppSkuToConsume(InAppSkuType inAppSkuType, Long l, String str) {
        m.checkNotNullParameter(inAppSkuType, "type");
        m.checkNotNullParameter(str, "paymentGatewaySkuId");
        this.type = inAppSkuType;
        this.skuId = l;
        this.paymentGatewaySkuId = str;
    }

    public static /* synthetic */ GooglePlayBillingManager$InAppSkuToConsume copy$default(GooglePlayBillingManager$InAppSkuToConsume googlePlayBillingManager$InAppSkuToConsume, InAppSkuType inAppSkuType, Long l, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            inAppSkuType = googlePlayBillingManager$InAppSkuToConsume.type;
        }
        if ((i & 2) != 0) {
            l = googlePlayBillingManager$InAppSkuToConsume.skuId;
        }
        if ((i & 4) != 0) {
            str = googlePlayBillingManager$InAppSkuToConsume.paymentGatewaySkuId;
        }
        return googlePlayBillingManager$InAppSkuToConsume.copy(inAppSkuType, l, str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final InAppSkuType getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Long getSkuId() {
        return this.skuId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getPaymentGatewaySkuId() {
        return this.paymentGatewaySkuId;
    }

    public final GooglePlayBillingManager$InAppSkuToConsume copy(InAppSkuType type, Long skuId, String paymentGatewaySkuId) {
        m.checkNotNullParameter(type, "type");
        m.checkNotNullParameter(paymentGatewaySkuId, "paymentGatewaySkuId");
        return new GooglePlayBillingManager$InAppSkuToConsume(type, skuId, paymentGatewaySkuId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GooglePlayBillingManager$InAppSkuToConsume)) {
            return false;
        }
        GooglePlayBillingManager$InAppSkuToConsume googlePlayBillingManager$InAppSkuToConsume = (GooglePlayBillingManager$InAppSkuToConsume) other;
        return m.areEqual(this.type, googlePlayBillingManager$InAppSkuToConsume.type) && m.areEqual(this.skuId, googlePlayBillingManager$InAppSkuToConsume.skuId) && m.areEqual(this.paymentGatewaySkuId, googlePlayBillingManager$InAppSkuToConsume.paymentGatewaySkuId);
    }

    public final String getPaymentGatewaySkuId() {
        return this.paymentGatewaySkuId;
    }

    public final Long getSkuId() {
        return this.skuId;
    }

    public final InAppSkuType getType() {
        return this.type;
    }

    public int hashCode() {
        InAppSkuType inAppSkuType = this.type;
        int iHashCode = (inAppSkuType != null ? inAppSkuType.hashCode() : 0) * 31;
        Long l = this.skuId;
        int iHashCode2 = (iHashCode + (l != null ? l.hashCode() : 0)) * 31;
        String str = this.paymentGatewaySkuId;
        return iHashCode2 + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("InAppSkuToConsume(type=");
        sbU.append(this.type);
        sbU.append(", skuId=");
        sbU.append(this.skuId);
        sbU.append(", paymentGatewaySkuId=");
        return a.J(sbU, this.paymentGatewaySkuId, ")");
    }
}
