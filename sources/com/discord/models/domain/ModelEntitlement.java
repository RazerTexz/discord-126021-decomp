package com.discord.models.domain;

import b.d.b.a.a;
import com.discord.api.premium.SubscriptionPlan;
import d0.z.d.m;

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
        m.checkNotNullParameter(modelSku, "sku");
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

    public static /* synthetic */ ModelEntitlement copy$default(ModelEntitlement modelEntitlement, long j, long j2, int i, long j3, long j4, ModelSku modelSku, SubscriptionPlan subscriptionPlan, Long l, Boolean bool, Long l2, int i2, Object obj) {
        return modelEntitlement.copy((i2 & 1) != 0 ? modelEntitlement.id : j, (i2 & 2) != 0 ? modelEntitlement.applicationId : j2, (i2 & 4) != 0 ? modelEntitlement.type : i, (i2 & 8) != 0 ? modelEntitlement.userId : j3, (i2 & 16) != 0 ? modelEntitlement.skuId : j4, (i2 & 32) != 0 ? modelEntitlement.sku : modelSku, (i2 & 64) != 0 ? modelEntitlement.subscriptionPlan : subscriptionPlan, (i2 & 128) != 0 ? modelEntitlement.parentId : l, (i2 & 256) != 0 ? modelEntitlement.consumed : bool, (i2 & 512) != 0 ? modelEntitlement.promotionId : l2);
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
        m.checkNotNullParameter(sku, "sku");
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
        return this.id == modelEntitlement.id && this.applicationId == modelEntitlement.applicationId && this.type == modelEntitlement.type && this.userId == modelEntitlement.userId && this.skuId == modelEntitlement.skuId && m.areEqual(this.sku, modelEntitlement.sku) && m.areEqual(this.subscriptionPlan, modelEntitlement.subscriptionPlan) && m.areEqual(this.parentId, modelEntitlement.parentId) && m.areEqual(this.consumed, modelEntitlement.consumed) && m.areEqual(this.promotionId, modelEntitlement.promotionId);
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
        StringBuilder sbU = a.U("ModelEntitlement(id=");
        sbU.append(this.id);
        sbU.append(", applicationId=");
        sbU.append(this.applicationId);
        sbU.append(", type=");
        sbU.append(this.type);
        sbU.append(", userId=");
        sbU.append(this.userId);
        sbU.append(", skuId=");
        sbU.append(this.skuId);
        sbU.append(", sku=");
        sbU.append(this.sku);
        sbU.append(", subscriptionPlan=");
        sbU.append(this.subscriptionPlan);
        sbU.append(", parentId=");
        sbU.append(this.parentId);
        sbU.append(", consumed=");
        sbU.append(this.consumed);
        sbU.append(", promotionId=");
        return a.G(sbU, this.promotionId, ")");
    }
}
