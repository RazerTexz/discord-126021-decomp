package com.discord.restapi;

import b.d.b.a.a;
import d0.z.d.m;

/* JADX INFO: compiled from: RestAPIParams.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class RestAPIParams$VerifyPurchaseResponse {
    private final String giftCode;
    private final Long subscriptionPlanId;
    private final long verifiedSkuId;

    public RestAPIParams$VerifyPurchaseResponse(long j, Long l, String str) {
        this.verifiedSkuId = j;
        this.subscriptionPlanId = l;
        this.giftCode = str;
    }

    public static /* synthetic */ RestAPIParams$VerifyPurchaseResponse copy$default(RestAPIParams$VerifyPurchaseResponse restAPIParams$VerifyPurchaseResponse, long j, Long l, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            j = restAPIParams$VerifyPurchaseResponse.verifiedSkuId;
        }
        if ((i & 2) != 0) {
            l = restAPIParams$VerifyPurchaseResponse.subscriptionPlanId;
        }
        if ((i & 4) != 0) {
            str = restAPIParams$VerifyPurchaseResponse.giftCode;
        }
        return restAPIParams$VerifyPurchaseResponse.copy(j, l, str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getVerifiedSkuId() {
        return this.verifiedSkuId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Long getSubscriptionPlanId() {
        return this.subscriptionPlanId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getGiftCode() {
        return this.giftCode;
    }

    public final RestAPIParams$VerifyPurchaseResponse copy(long verifiedSkuId, Long subscriptionPlanId, String giftCode) {
        return new RestAPIParams$VerifyPurchaseResponse(verifiedSkuId, subscriptionPlanId, giftCode);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RestAPIParams$VerifyPurchaseResponse)) {
            return false;
        }
        RestAPIParams$VerifyPurchaseResponse restAPIParams$VerifyPurchaseResponse = (RestAPIParams$VerifyPurchaseResponse) other;
        return this.verifiedSkuId == restAPIParams$VerifyPurchaseResponse.verifiedSkuId && m.areEqual(this.subscriptionPlanId, restAPIParams$VerifyPurchaseResponse.subscriptionPlanId) && m.areEqual(this.giftCode, restAPIParams$VerifyPurchaseResponse.giftCode);
    }

    public final String getGiftCode() {
        return this.giftCode;
    }

    public final Long getSubscriptionPlanId() {
        return this.subscriptionPlanId;
    }

    public final long getVerifiedSkuId() {
        return this.verifiedSkuId;
    }

    public int hashCode() {
        long j = this.verifiedSkuId;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        Long l = this.subscriptionPlanId;
        int iHashCode = (i + (l != null ? l.hashCode() : 0)) * 31;
        String str = this.giftCode;
        return iHashCode + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("VerifyPurchaseResponse(verifiedSkuId=");
        sbU.append(this.verifiedSkuId);
        sbU.append(", subscriptionPlanId=");
        sbU.append(this.subscriptionPlanId);
        sbU.append(", giftCode=");
        return a.J(sbU, this.giftCode, ")");
    }
}
