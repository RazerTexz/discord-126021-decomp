package com.discord.utilities.billing;

import com.android.billingclient.api.SkuDetails;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: GooglePlayInAppSku.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class GooglePlayInAppSku {
    private final String paymentGatewaySkuId;
    private SkuDetails skuDetails;
    private final Long skuId;
    private InAppSkuType type;

    public GooglePlayInAppSku(String str, InAppSkuType inAppSkuType, SkuDetails skuDetails, Long l) {
        C12238m.checkNotNullParameter(str, "paymentGatewaySkuId");
        C12238m.checkNotNullParameter(inAppSkuType, "type");
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
        C12238m.checkNotNullParameter(paymentGatewaySkuId, "paymentGatewaySkuId");
        C12238m.checkNotNullParameter(type, "type");
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
        return C12238m.areEqual(this.paymentGatewaySkuId, googlePlayInAppSku.paymentGatewaySkuId) && C12238m.areEqual(this.type, googlePlayInAppSku.type) && C12238m.areEqual(this.skuDetails, googlePlayInAppSku.skuDetails) && C12238m.areEqual(this.skuId, googlePlayInAppSku.skuId);
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
        C12238m.checkNotNullParameter(inAppSkuType, "<set-?>");
        this.type = inAppSkuType;
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("GooglePlayInAppSku(paymentGatewaySkuId=");
        sbM833U.append(this.paymentGatewaySkuId);
        sbM833U.append(", type=");
        sbM833U.append(this.type);
        sbM833U.append(", skuDetails=");
        sbM833U.append(this.skuDetails);
        sbM833U.append(", skuId=");
        return C1643a.m819G(sbM833U, this.skuId, ")");
    }

    public /* synthetic */ GooglePlayInAppSku(String str, InAppSkuType inAppSkuType, SkuDetails skuDetails, Long l, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, inAppSkuType, (i & 4) != 0 ? null : skuDetails, (i & 8) != 0 ? null : l);
    }
}
