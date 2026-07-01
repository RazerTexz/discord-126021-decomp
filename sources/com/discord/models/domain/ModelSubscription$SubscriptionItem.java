package com.discord.models.domain;

import b.d.b.a.a;

/* JADX INFO: compiled from: ModelSubscription.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class ModelSubscription$SubscriptionItem {
    private final long id;
    private final long planId;
    private final int quantity;

    public ModelSubscription$SubscriptionItem(long j, long j2, int i) {
        this.id = j;
        this.planId = j2;
        this.quantity = i;
    }

    public static /* synthetic */ ModelSubscription$SubscriptionItem copy$default(ModelSubscription$SubscriptionItem modelSubscription$SubscriptionItem, long j, long j2, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            j = modelSubscription$SubscriptionItem.id;
        }
        long j3 = j;
        if ((i2 & 2) != 0) {
            j2 = modelSubscription$SubscriptionItem.planId;
        }
        long j4 = j2;
        if ((i2 & 4) != 0) {
            i = modelSubscription$SubscriptionItem.quantity;
        }
        return modelSubscription$SubscriptionItem.copy(j3, j4, i);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getPlanId() {
        return this.planId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getQuantity() {
        return this.quantity;
    }

    public final ModelSubscription$SubscriptionItem copy(long id2, long planId, int quantity) {
        return new ModelSubscription$SubscriptionItem(id2, planId, quantity);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ModelSubscription$SubscriptionItem)) {
            return false;
        }
        ModelSubscription$SubscriptionItem modelSubscription$SubscriptionItem = (ModelSubscription$SubscriptionItem) other;
        return this.id == modelSubscription$SubscriptionItem.id && this.planId == modelSubscription$SubscriptionItem.planId && this.quantity == modelSubscription$SubscriptionItem.quantity;
    }

    public final long getId() {
        return this.id;
    }

    public final long getPlanId() {
        return this.planId;
    }

    public final int getQuantity() {
        return this.quantity;
    }

    public int hashCode() {
        long j = this.id;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        long j2 = this.planId;
        return ((i + ((int) (j2 ^ (j2 >>> 32)))) * 31) + this.quantity;
    }

    public String toString() {
        StringBuilder sbU = a.U("SubscriptionItem(id=");
        sbU.append(this.id);
        sbU.append(", planId=");
        sbU.append(this.planId);
        sbU.append(", quantity=");
        return a.B(sbU, this.quantity, ")");
    }
}
