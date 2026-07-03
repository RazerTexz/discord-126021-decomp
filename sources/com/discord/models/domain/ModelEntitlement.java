package com.discord.models.domain;

import com.discord.api.premium.SubscriptionPlan;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: ModelEntitlement.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class ModelEntitlement {
    private final long applicationId;
    private final Boolean consumed;
    private final long id;
    private final Long parentId;
    private final Long promotionId;
    private final ModelSku sku;
    private final long skuId;
    private final SubscriptionPlan subscriptionPlan;
    private final int type;
    private final long userId;

    public ModelEntitlement(long j, long j2, int i, long j3, long j4, ModelSku modelSku, SubscriptionPlan subscriptionPlan, Long l, Boolean bool, Long l2) {
        C12238m.checkNotNullParameter(modelSku, "sku");
        this.id = j;
        this.applicationId = j2;
        this.type = i;
        this.userId = j3;
        this.skuId = j4;
        this.sku = modelSku;
        this.subscriptionPlan = subscriptionPlan;
        this.parentId = l;
        this.consumed = bool;
        this.promotionId = l2;
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final Long getPromotionId() {
        return this.promotionId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getApplicationId() {
        return this.applicationId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final long getUserId() {
        return this.userId;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final long getSkuId() {
        return this.skuId;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final ModelSku getSku() {
        return this.sku;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final SubscriptionPlan getSubscriptionPlan() {
        return this.subscriptionPlan;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final Long getParentId() {
        return this.parentId;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final Boolean getConsumed() {
        return this.consumed;
    }

    public final ModelEntitlement copy(long id2, long applicationId, int type, long userId, long skuId, ModelSku sku, SubscriptionPlan subscriptionPlan, Long parentId, Boolean consumed, Long promotionId) {
        C12238m.checkNotNullParameter(sku, "sku");
        return new ModelEntitlement(id2, applicationId, type, userId, skuId, sku, subscriptionPlan, parentId, consumed, promotionId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ModelEntitlement)) {
            return false;
        }
        ModelEntitlement modelEntitlement = (ModelEntitlement) other;
        return this.id == modelEntitlement.id && this.applicationId == modelEntitlement.applicationId && this.type == modelEntitlement.type && this.userId == modelEntitlement.userId && this.skuId == modelEntitlement.skuId && C12238m.areEqual(this.sku, modelEntitlement.sku) && C12238m.areEqual(this.subscriptionPlan, modelEntitlement.subscriptionPlan) && C12238m.areEqual(this.parentId, modelEntitlement.parentId) && C12238m.areEqual(this.consumed, modelEntitlement.consumed) && C12238m.areEqual(this.promotionId, modelEntitlement.promotionId);
    }

    public final long getApplicationId() {
        return this.applicationId;
    }

    public final Boolean getConsumed() {
        return this.consumed;
    }

    public final long getId() {
        return this.id;
    }

    public final Long getParentId() {
        return this.parentId;
    }

    public final Long getPromotionId() {
        return this.promotionId;
    }

    public final ModelSku getSku() {
        return this.sku;
    }

    public final long getSkuId() {
        return this.skuId;
    }

    public final SubscriptionPlan getSubscriptionPlan() {
        return this.subscriptionPlan;
    }

    public final int getType() {
        return this.type;
    }

    public final long getUserId() {
        return this.userId;
    }

    public int hashCode() {
        long j = this.id;
        long j2 = this.applicationId;
        int i = ((((((int) (j ^ (j >>> 32))) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31) + this.type) * 31;
        long j3 = this.userId;
        int i2 = (i + ((int) (j3 ^ (j3 >>> 32)))) * 31;
        long j4 = this.skuId;
        int i3 = (i2 + ((int) (j4 ^ (j4 >>> 32)))) * 31;
        ModelSku modelSku = this.sku;
        int iHashCode = (i3 + (modelSku != null ? modelSku.hashCode() : 0)) * 31;
        SubscriptionPlan subscriptionPlan = this.subscriptionPlan;
        int iHashCode2 = (iHashCode + (subscriptionPlan != null ? subscriptionPlan.hashCode() : 0)) * 31;
        Long l = this.parentId;
        int iHashCode3 = (iHashCode2 + (l != null ? l.hashCode() : 0)) * 31;
        Boolean bool = this.consumed;
        int iHashCode4 = (iHashCode3 + (bool != null ? bool.hashCode() : 0)) * 31;
        Long l2 = this.promotionId;
        return iHashCode4 + (l2 != null ? l2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("ModelEntitlement(id=");
        sbM833U.append(this.id);
        sbM833U.append(", applicationId=");
        sbM833U.append(this.applicationId);
        sbM833U.append(", type=");
        sbM833U.append(this.type);
        sbM833U.append(", userId=");
        sbM833U.append(this.userId);
        sbM833U.append(", skuId=");
        sbM833U.append(this.skuId);
        sbM833U.append(", sku=");
        sbM833U.append(this.sku);
        sbM833U.append(", subscriptionPlan=");
        sbM833U.append(this.subscriptionPlan);
        sbM833U.append(", parentId=");
        sbM833U.append(this.parentId);
        sbM833U.append(", consumed=");
        sbM833U.append(this.consumed);
        sbM833U.append(", promotionId=");
        return C1643a.m819G(sbM833U, this.promotionId, ")");
    }
}
