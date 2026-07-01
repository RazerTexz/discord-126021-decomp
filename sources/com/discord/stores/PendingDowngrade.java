package com.discord.stores;

import b.d.b.a.a;
import d0.z.d.m;

/* JADX INFO: compiled from: StoreGooglePlayPurchases.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class PendingDowngrade {
    private final String newSkuName;
    private final String purchaseToken;
    private final String subscriptionId;

    public PendingDowngrade(String str, String str2, String str3) {
        a.q0(str, "purchaseToken", str2, "subscriptionId", str3, "newSkuName");
        this.purchaseToken = str;
        this.subscriptionId = str2;
        this.newSkuName = str3;
    }

    public static /* synthetic */ PendingDowngrade copy$default(PendingDowngrade pendingDowngrade, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = pendingDowngrade.purchaseToken;
        }
        if ((i & 2) != 0) {
            str2 = pendingDowngrade.subscriptionId;
        }
        if ((i & 4) != 0) {
            str3 = pendingDowngrade.newSkuName;
        }
        return pendingDowngrade.copy(str, str2, str3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getPurchaseToken() {
        return this.purchaseToken;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getSubscriptionId() {
        return this.subscriptionId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getNewSkuName() {
        return this.newSkuName;
    }

    public final PendingDowngrade copy(String purchaseToken, String subscriptionId, String newSkuName) {
        m.checkNotNullParameter(purchaseToken, "purchaseToken");
        m.checkNotNullParameter(subscriptionId, "subscriptionId");
        m.checkNotNullParameter(newSkuName, "newSkuName");
        return new PendingDowngrade(purchaseToken, subscriptionId, newSkuName);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PendingDowngrade)) {
            return false;
        }
        PendingDowngrade pendingDowngrade = (PendingDowngrade) other;
        return m.areEqual(this.purchaseToken, pendingDowngrade.purchaseToken) && m.areEqual(this.subscriptionId, pendingDowngrade.subscriptionId) && m.areEqual(this.newSkuName, pendingDowngrade.newSkuName);
    }

    public final String getNewSkuName() {
        return this.newSkuName;
    }

    public final String getPurchaseToken() {
        return this.purchaseToken;
    }

    public final String getSubscriptionId() {
        return this.subscriptionId;
    }

    public int hashCode() {
        String str = this.purchaseToken;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.subscriptionId;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.newSkuName;
        return iHashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("PendingDowngrade(purchaseToken=");
        sbU.append(this.purchaseToken);
        sbU.append(", subscriptionId=");
        sbU.append(this.subscriptionId);
        sbU.append(", newSkuName=");
        return a.J(sbU, this.newSkuName, ")");
    }
}
