package com.discord.restapi;

import b.d.b.a.a;
import d0.z.d.m;

/* JADX INFO: compiled from: RestAPIParams.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class RestAPIParams$VerifyPurchaseTokenBody {
    private final String oneTimePurchaseSkuId;
    private final String packageName;
    private final String purchaseToken;
    private final String subscriptionSkuId;
    private final long userId;

    public RestAPIParams$VerifyPurchaseTokenBody(String str, long j, String str2, String str3, String str4) {
        m.checkNotNullParameter(str, "purchaseToken");
        m.checkNotNullParameter(str2, "packageName");
        this.purchaseToken = str;
        this.userId = j;
        this.packageName = str2;
        this.subscriptionSkuId = str3;
        this.oneTimePurchaseSkuId = str4;
    }

    public static /* synthetic */ RestAPIParams$VerifyPurchaseTokenBody copy$default(RestAPIParams$VerifyPurchaseTokenBody restAPIParams$VerifyPurchaseTokenBody, String str, long j, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = restAPIParams$VerifyPurchaseTokenBody.purchaseToken;
        }
        if ((i & 2) != 0) {
            j = restAPIParams$VerifyPurchaseTokenBody.userId;
        }
        long j2 = j;
        if ((i & 4) != 0) {
            str2 = restAPIParams$VerifyPurchaseTokenBody.packageName;
        }
        String str5 = str2;
        if ((i & 8) != 0) {
            str3 = restAPIParams$VerifyPurchaseTokenBody.subscriptionSkuId;
        }
        String str6 = str3;
        if ((i & 16) != 0) {
            str4 = restAPIParams$VerifyPurchaseTokenBody.oneTimePurchaseSkuId;
        }
        return restAPIParams$VerifyPurchaseTokenBody.copy(str, j2, str5, str6, str4);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getPurchaseToken() {
        return this.purchaseToken;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getUserId() {
        return this.userId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getPackageName() {
        return this.packageName;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getSubscriptionSkuId() {
        return this.subscriptionSkuId;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getOneTimePurchaseSkuId() {
        return this.oneTimePurchaseSkuId;
    }

    public final RestAPIParams$VerifyPurchaseTokenBody copy(String purchaseToken, long userId, String packageName, String subscriptionSkuId, String oneTimePurchaseSkuId) {
        m.checkNotNullParameter(purchaseToken, "purchaseToken");
        m.checkNotNullParameter(packageName, "packageName");
        return new RestAPIParams$VerifyPurchaseTokenBody(purchaseToken, userId, packageName, subscriptionSkuId, oneTimePurchaseSkuId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RestAPIParams$VerifyPurchaseTokenBody)) {
            return false;
        }
        RestAPIParams$VerifyPurchaseTokenBody restAPIParams$VerifyPurchaseTokenBody = (RestAPIParams$VerifyPurchaseTokenBody) other;
        return m.areEqual(this.purchaseToken, restAPIParams$VerifyPurchaseTokenBody.purchaseToken) && this.userId == restAPIParams$VerifyPurchaseTokenBody.userId && m.areEqual(this.packageName, restAPIParams$VerifyPurchaseTokenBody.packageName) && m.areEqual(this.subscriptionSkuId, restAPIParams$VerifyPurchaseTokenBody.subscriptionSkuId) && m.areEqual(this.oneTimePurchaseSkuId, restAPIParams$VerifyPurchaseTokenBody.oneTimePurchaseSkuId);
    }

    public final String getOneTimePurchaseSkuId() {
        return this.oneTimePurchaseSkuId;
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public final String getPurchaseToken() {
        return this.purchaseToken;
    }

    public final String getSubscriptionSkuId() {
        return this.subscriptionSkuId;
    }

    public final long getUserId() {
        return this.userId;
    }

    public int hashCode() {
        String str = this.purchaseToken;
        int iHashCode = str != null ? str.hashCode() : 0;
        long j = this.userId;
        int i = ((iHashCode * 31) + ((int) (j ^ (j >>> 32)))) * 31;
        String str2 = this.packageName;
        int iHashCode2 = (i + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.subscriptionSkuId;
        int iHashCode3 = (iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.oneTimePurchaseSkuId;
        return iHashCode3 + (str4 != null ? str4.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("VerifyPurchaseTokenBody(purchaseToken=");
        sbU.append(this.purchaseToken);
        sbU.append(", userId=");
        sbU.append(this.userId);
        sbU.append(", packageName=");
        sbU.append(this.packageName);
        sbU.append(", subscriptionSkuId=");
        sbU.append(this.subscriptionSkuId);
        sbU.append(", oneTimePurchaseSkuId=");
        return a.J(sbU, this.oneTimePurchaseSkuId, ")");
    }
}
