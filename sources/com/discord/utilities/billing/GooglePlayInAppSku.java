package com.discord.utilities.billing;

import b.d.b.a.outline;
import com.android.billingclient.api.SkuDetails;
import d0.z.d.Intrinsics3;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: GooglePlayInAppSku.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class GooglePlayInAppSku {
    private final String paymentGatewaySkuId;
    private SkuDetails skuDetails;
    private final Long skuId;
    private GooglePlayInAppSku4 type;

    public GooglePlayInAppSku(String str, GooglePlayInAppSku4 googlePlayInAppSku4, SkuDetails skuDetails, Long l) {
        Intrinsics3.checkNotNullParameter(str, "paymentGatewaySkuId");
        Intrinsics3.checkNotNullParameter(googlePlayInAppSku4, "type");
        this.paymentGatewaySkuId = str;
        this.type = googlePlayInAppSku4;
        this.skuDetails = skuDetails;
        this.skuId = l;
    }

    public static /* synthetic */ GooglePlayInAppSku copy$default(GooglePlayInAppSku googlePlayInAppSku, String str, GooglePlayInAppSku4 googlePlayInAppSku4, SkuDetails skuDetails, Long l, int i, Object obj) {
        if ((i & 1) != 0) {
            str = googlePlayInAppSku.paymentGatewaySkuId;
        }
        if ((i & 2) != 0) {
            googlePlayInAppSku4 = googlePlayInAppSku.type;
        }
        if ((i & 4) != 0) {
            skuDetails = googlePlayInAppSku.skuDetails;
        }
        if ((i & 8) != 0) {
            l = googlePlayInAppSku.skuId;
        }
        return googlePlayInAppSku.copy(str, googlePlayInAppSku4, skuDetails, l);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getPaymentGatewaySkuId() {
        return this.paymentGatewaySkuId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final GooglePlayInAppSku4 getType() {
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

    public final GooglePlayInAppSku copy(String paymentGatewaySkuId, GooglePlayInAppSku4 type, SkuDetails skuDetails, Long skuId) {
        Intrinsics3.checkNotNullParameter(paymentGatewaySkuId, "paymentGatewaySkuId");
        Intrinsics3.checkNotNullParameter(type, "type");
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
        return Intrinsics3.areEqual(this.paymentGatewaySkuId, googlePlayInAppSku.paymentGatewaySkuId) && Intrinsics3.areEqual(this.type, googlePlayInAppSku.type) && Intrinsics3.areEqual(this.skuDetails, googlePlayInAppSku.skuDetails) && Intrinsics3.areEqual(this.skuId, googlePlayInAppSku.skuId);
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

    public final GooglePlayInAppSku4 getType() {
        return this.type;
    }

    public int hashCode() {
        String str = this.paymentGatewaySkuId;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        GooglePlayInAppSku4 googlePlayInAppSku4 = this.type;
        int iHashCode2 = (iHashCode + (googlePlayInAppSku4 != null ? googlePlayInAppSku4.hashCode() : 0)) * 31;
        SkuDetails skuDetails = this.skuDetails;
        int iHashCode3 = (iHashCode2 + (skuDetails != null ? skuDetails.hashCode() : 0)) * 31;
        Long l = this.skuId;
        return iHashCode3 + (l != null ? l.hashCode() : 0);
    }

    public final void setSkuDetails(SkuDetails skuDetails) {
        this.skuDetails = skuDetails;
    }

    public final void setType(GooglePlayInAppSku4 googlePlayInAppSku4) {
        Intrinsics3.checkNotNullParameter(googlePlayInAppSku4, "<set-?>");
        this.type = googlePlayInAppSku4;
    }

    public String toString() {
        StringBuilder sbU = outline.U("GooglePlayInAppSku(paymentGatewaySkuId=");
        sbU.append(this.paymentGatewaySkuId);
        sbU.append(", type=");
        sbU.append(this.type);
        sbU.append(", skuDetails=");
        sbU.append(this.skuDetails);
        sbU.append(", skuId=");
        return outline.G(sbU, this.skuId, ")");
    }

    public /* synthetic */ GooglePlayInAppSku(String str, GooglePlayInAppSku4 googlePlayInAppSku4, SkuDetails skuDetails, Long l, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, googlePlayInAppSku4, (i & 4) != 0 ? null : skuDetails, (i & 8) != 0 ? null : l);
    }
}
