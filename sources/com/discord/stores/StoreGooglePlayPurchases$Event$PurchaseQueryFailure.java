package com.discord.stores;

import b.d.b.a.a;
import d0.z.d.m;

/* JADX INFO: compiled from: StoreGooglePlayPurchases.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class StoreGooglePlayPurchases$Event$PurchaseQueryFailure extends StoreGooglePlayPurchases$Event {
    private final String newSkuName;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreGooglePlayPurchases$Event$PurchaseQueryFailure(String str) {
        super(null);
        m.checkNotNullParameter(str, "newSkuName");
        this.newSkuName = str;
    }

    public static /* synthetic */ StoreGooglePlayPurchases$Event$PurchaseQueryFailure copy$default(StoreGooglePlayPurchases$Event$PurchaseQueryFailure storeGooglePlayPurchases$Event$PurchaseQueryFailure, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = storeGooglePlayPurchases$Event$PurchaseQueryFailure.newSkuName;
        }
        return storeGooglePlayPurchases$Event$PurchaseQueryFailure.copy(str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getNewSkuName() {
        return this.newSkuName;
    }

    public final StoreGooglePlayPurchases$Event$PurchaseQueryFailure copy(String newSkuName) {
        m.checkNotNullParameter(newSkuName, "newSkuName");
        return new StoreGooglePlayPurchases$Event$PurchaseQueryFailure(newSkuName);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof StoreGooglePlayPurchases$Event$PurchaseQueryFailure) && m.areEqual(this.newSkuName, ((StoreGooglePlayPurchases$Event$PurchaseQueryFailure) other).newSkuName);
        }
        return true;
    }

    public final String getNewSkuName() {
        return this.newSkuName;
    }

    public int hashCode() {
        String str = this.newSkuName;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public String toString() {
        return a.J(a.U("PurchaseQueryFailure(newSkuName="), this.newSkuName, ")");
    }
}
