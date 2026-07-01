package com.discord.utilities.billing;

import b.d.b.a.a;
import com.android.billingclient.api.SkuDetails;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: GooglePlayInAppSku.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class GooglePlayInAppSku {
    private final String paymentGatewaySkuId;
    private SkuDetails skuDetails;
    private final Long skuId;
    private InAppSkuType type;

    public GooglePlayInAppSku(String str, InAppSkuType inAppSkuType, SkuDetails skuDetails, Long l) {
        m.checkNotNullParameter(str, "paymentGatewaySkuId");
        m.checkNotNullParameter(inAppSkuType, "type");
        this.paymentGatewaySkuId = str;
        this.type = inAppSkuType;
        this.skuDetails = skuDetails;
        this.skuId = l;
    }

    public static /* synthetic */ GooglePlayInAppSku copy$default(GooglePlayInAppSku googlePlayInAppSku, String str, InAppSkuType inAppSkuType, SkuDetails skuDetails, Long l, int i, Object obj) {
        if ((i & 1) != 0) {
            str = googlePlayInAppSku.paymentGatewaySkuId;
        }
        if ((i & 2) != 0) {
            inAppSkuType = googlePlayInAppSku.type;
        }
        if ((i & 4) != 0) {
            skuDetails = googlePlayInAppSku.skuDetails;
        }
        if ((i & 8) != 0) {
            l = googlePlayInAppSku.skuId;
        }
        return googlePlayInAppSku.copy(str, inAppSkuType, skuDetails, l);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getPaymentGatewaySkuId() {
        return this.paymentGatewaySkuId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final InAppSkuType getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final SkuDetails getSkuDetails() {
        return this.skuDetails;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Long getSkuId() {
        return this.skuId;
    }

    public final GooglePlayInAppSku copy(String paymentGatewaySkuId, InAppSkuType type, SkuDetails skuDetails, Long skuId) {
        m.checkNotNullParameter(paymentGatewaySkuId, "paymentGatewaySkuId");
        m.checkNotNullParameter(type, "type");
        return new GooglePlayInAppSku(paymentGatewaySkuId, type, skuDetails, skuId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GooglePlayInAppSku)) {
            return false;
        }
        GooglePlayInAppSku googlePlayInAppSku = (GooglePlayInAppSku) other;
        return m.areEqual(this.paymentGatewaySkuId, googlePlayInAppSku.paymentGatewaySkuId) && m.areEqual(this.type, googlePlayInAppSku.type) && m.areEqual(this.skuDetails, googlePlayInAppSku.skuDetails) && m.areEqual(this.skuId, googlePlayInAppSku.skuId);
    }

    public final String getPaymentGatewaySkuId() {
        return this.paymentGatewaySkuId;
    }

    public final SkuDetails getSkuDetails() {
        return this.skuDetails;
    }

    public final Long getSkuId() {
        return this.skuId;
    }

    public final InAppSkuType getType() {
        return this.type;
    }

    public int hashCode() {
        String str = this.paymentGatewaySkuId;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        InAppSkuType inAppSkuType = this.type;
        int iHashCode2 = (iHashCode + (inAppSkuType != null ? inAppSkuType.hashCode() : 0)) * 31;
        SkuDetails skuDetails = this.skuDetails;
        int iHashCode3 = (iHashCode2 + (skuDetails != null ? skuDetails.hashCode() : 0)) * 31;
        Long l = this.skuId;
        return iHashCode3 + (l != null ? l.hashCode() : 0);
    }

    public final void setSkuDetails(SkuDetails skuDetails) {
        this.skuDetails = skuDetails;
    }

    public final void setType(InAppSkuType inAppSkuType) {
        m.checkNotNullParameter(inAppSkuType, "<set-?>");
        this.type = inAppSkuType;
    }

    public String toString() {
        StringBuilder sbU = a.U("GooglePlayInAppSku(paymentGatewaySkuId=");
        sbU.append(this.paymentGatewaySkuId);
        sbU.append(", type=");
        sbU.append(this.type);
        sbU.append(", skuDetails=");
        sbU.append(this.skuDetails);
        sbU.append(", skuId=");
        return a.G(sbU, this.skuId, ")");
    }

    public /* synthetic */ GooglePlayInAppSku(String str, InAppSkuType inAppSkuType, SkuDetails skuDetails, Long l, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, inAppSkuType, (i & 4) != 0 ? null : skuDetails, (i & 8) != 0 ? null : l);
    }
}
