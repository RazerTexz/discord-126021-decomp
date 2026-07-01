package com.discord.stores;

import b.d.b.a.a;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: StoreGooglePlayPurchases.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class StoreGooglePlayPurchases$Event$PurchaseQuerySuccess extends StoreGooglePlayPurchases$Event {
    private final String giftCode;
    private final String newSkuName;
    private final Long skuId;
    private final Long subscriptionPlanId;

    public /* synthetic */ StoreGooglePlayPurchases$Event$PurchaseQuerySuccess(String str, Long l, Long l2, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : l, (i & 4) != 0 ? null : l2, (i & 8) != 0 ? null : str2);
    }

    public static /* synthetic */ StoreGooglePlayPurchases$Event$PurchaseQuerySuccess copy$default(StoreGooglePlayPurchases$Event$PurchaseQuerySuccess storeGooglePlayPurchases$Event$PurchaseQuerySuccess, String str, Long l, Long l2, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = storeGooglePlayPurchases$Event$PurchaseQuerySuccess.newSkuName;
        }
        if ((i & 2) != 0) {
            l = storeGooglePlayPurchases$Event$PurchaseQuerySuccess.skuId;
        }
        if ((i & 4) != 0) {
            l2 = storeGooglePlayPurchases$Event$PurchaseQuerySuccess.subscriptionPlanId;
        }
        if ((i & 8) != 0) {
            str2 = storeGooglePlayPurchases$Event$PurchaseQuerySuccess.giftCode;
        }
        return storeGooglePlayPurchases$Event$PurchaseQuerySuccess.copy(str, l, l2, str2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getNewSkuName() {
        return this.newSkuName;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Long getSkuId() {
        return this.skuId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Long getSubscriptionPlanId() {
        return this.subscriptionPlanId;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getGiftCode() {
        return this.giftCode;
    }

    public final StoreGooglePlayPurchases$Event$PurchaseQuerySuccess copy(String newSkuName, Long skuId, Long subscriptionPlanId, String giftCode) {
        m.checkNotNullParameter(newSkuName, "newSkuName");
        return new StoreGooglePlayPurchases$Event$PurchaseQuerySuccess(newSkuName, skuId, subscriptionPlanId, giftCode);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StoreGooglePlayPurchases$Event$PurchaseQuerySuccess)) {
            return false;
        }
        StoreGooglePlayPurchases$Event$PurchaseQuerySuccess storeGooglePlayPurchases$Event$PurchaseQuerySuccess = (StoreGooglePlayPurchases$Event$PurchaseQuerySuccess) other;
        return m.areEqual(this.newSkuName, storeGooglePlayPurchases$Event$PurchaseQuerySuccess.newSkuName) && m.areEqual(this.skuId, storeGooglePlayPurchases$Event$PurchaseQuerySuccess.skuId) && m.areEqual(this.subscriptionPlanId, storeGooglePlayPurchases$Event$PurchaseQuerySuccess.subscriptionPlanId) && m.areEqual(this.giftCode, storeGooglePlayPurchases$Event$PurchaseQuerySuccess.giftCode);
    }

    public final String getGiftCode() {
        return this.giftCode;
    }

    public final String getNewSkuName() {
        return this.newSkuName;
    }

    public final Long getSkuId() {
        return this.skuId;
    }

    public final Long getSubscriptionPlanId() {
        return this.subscriptionPlanId;
    }

    public int hashCode() {
        String str = this.newSkuName;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        Long l = this.skuId;
        int iHashCode2 = (iHashCode + (l != null ? l.hashCode() : 0)) * 31;
        Long l2 = this.subscriptionPlanId;
        int iHashCode3 = (iHashCode2 + (l2 != null ? l2.hashCode() : 0)) * 31;
        String str2 = this.giftCode;
        return iHashCode3 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("PurchaseQuerySuccess(newSkuName=");
        sbU.append(this.newSkuName);
        sbU.append(", skuId=");
        sbU.append(this.skuId);
        sbU.append(", subscriptionPlanId=");
        sbU.append(this.subscriptionPlanId);
        sbU.append(", giftCode=");
        return a.J(sbU, this.giftCode, ")");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreGooglePlayPurchases$Event$PurchaseQuerySuccess(String str, Long l, Long l2, String str2) {
        super(null);
        m.checkNotNullParameter(str, "newSkuName");
        this.newSkuName = str;
        this.skuId = l;
        this.subscriptionPlanId = l2;
        this.giftCode = str2;
    }
}
