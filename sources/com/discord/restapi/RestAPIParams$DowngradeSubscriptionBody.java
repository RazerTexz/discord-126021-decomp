package com.discord.restapi;

import b.d.b.a.a;
import d0.z.d.m;

/* JADX INFO: compiled from: RestAPIParams.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class RestAPIParams$DowngradeSubscriptionBody {
    private final String purchaseToken;
    private final String subscriptionId;
    private final String subscriptionSkuId;

    public RestAPIParams$DowngradeSubscriptionBody(String str, String str2, String str3) {
        a.q0(str, "subscriptionId", str2, "purchaseToken", str3, "subscriptionSkuId");
        this.subscriptionId = str;
        this.purchaseToken = str2;
        this.subscriptionSkuId = str3;
    }

    public static /* synthetic */ RestAPIParams$DowngradeSubscriptionBody copy$default(RestAPIParams$DowngradeSubscriptionBody restAPIParams$DowngradeSubscriptionBody, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = restAPIParams$DowngradeSubscriptionBody.subscriptionId;
        }
        if ((i & 2) != 0) {
            str2 = restAPIParams$DowngradeSubscriptionBody.purchaseToken;
        }
        if ((i & 4) != 0) {
            str3 = restAPIParams$DowngradeSubscriptionBody.subscriptionSkuId;
        }
        return restAPIParams$DowngradeSubscriptionBody.copy(str, str2, str3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getSubscriptionId() {
        return this.subscriptionId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getPurchaseToken() {
        return this.purchaseToken;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getSubscriptionSkuId() {
        return this.subscriptionSkuId;
    }

    public final RestAPIParams$DowngradeSubscriptionBody copy(String subscriptionId, String purchaseToken, String subscriptionSkuId) {
        m.checkNotNullParameter(subscriptionId, "subscriptionId");
        m.checkNotNullParameter(purchaseToken, "purchaseToken");
        m.checkNotNullParameter(subscriptionSkuId, "subscriptionSkuId");
        return new RestAPIParams$DowngradeSubscriptionBody(subscriptionId, purchaseToken, subscriptionSkuId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RestAPIParams$DowngradeSubscriptionBody)) {
            return false;
        }
        RestAPIParams$DowngradeSubscriptionBody restAPIParams$DowngradeSubscriptionBody = (RestAPIParams$DowngradeSubscriptionBody) other;
        return m.areEqual(this.subscriptionId, restAPIParams$DowngradeSubscriptionBody.subscriptionId) && m.areEqual(this.purchaseToken, restAPIParams$DowngradeSubscriptionBody.purchaseToken) && m.areEqual(this.subscriptionSkuId, restAPIParams$DowngradeSubscriptionBody.subscriptionSkuId);
    }

    public final String getPurchaseToken() {
        return this.purchaseToken;
    }

    public final String getSubscriptionId() {
        return this.subscriptionId;
    }

    public final String getSubscriptionSkuId() {
        return this.subscriptionSkuId;
    }

    public int hashCode() {
        String str = this.subscriptionId;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.purchaseToken;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.subscriptionSkuId;
        return iHashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("DowngradeSubscriptionBody(subscriptionId=");
        sbU.append(this.subscriptionId);
        sbU.append(", purchaseToken=");
        sbU.append(this.purchaseToken);
        sbU.append(", subscriptionSkuId=");
        return a.J(sbU, this.subscriptionSkuId, ")");
    }
}
