package com.discord.models.domain;

import b.d.b.a.a;

/* JADX INFO: compiled from: ModelSubscription.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class ModelSubscription$SubscriptionAdditionalPlan {
    private final long planId;
    private final int quantity;

    public ModelSubscription$SubscriptionAdditionalPlan(long j, int i) {
        this.planId = j;
        this.quantity = i;
    }

    public static /* synthetic */ ModelSubscription$SubscriptionAdditionalPlan copy$default(ModelSubscription$SubscriptionAdditionalPlan modelSubscription$SubscriptionAdditionalPlan, long j, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            j = modelSubscription$SubscriptionAdditionalPlan.planId;
        }
        if ((i2 & 2) != 0) {
            i = modelSubscription$SubscriptionAdditionalPlan.quantity;
        }
        return modelSubscription$SubscriptionAdditionalPlan.copy(j, i);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getPlanId() {
        return this.planId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getQuantity() {
        return this.quantity;
    }

    public final ModelSubscription$SubscriptionAdditionalPlan copy(long planId, int quantity) {
        return new ModelSubscription$SubscriptionAdditionalPlan(planId, quantity);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ModelSubscription$SubscriptionAdditionalPlan)) {
            return false;
        }
        ModelSubscription$SubscriptionAdditionalPlan modelSubscription$SubscriptionAdditionalPlan = (ModelSubscription$SubscriptionAdditionalPlan) other;
        return this.planId == modelSubscription$SubscriptionAdditionalPlan.planId && this.quantity == modelSubscription$SubscriptionAdditionalPlan.quantity;
    }

    public final long getPlanId() {
        return this.planId;
    }

    public final int getQuantity() {
        return this.quantity;
    }

    public int hashCode() {
        long j = this.planId;
        return (((int) (j ^ (j >>> 32))) * 31) + this.quantity;
    }

    public String toString() {
        StringBuilder sbU = a.U("SubscriptionAdditionalPlan(planId=");
        sbU.append(this.planId);
        sbU.append(", quantity=");
        return a.B(sbU, this.quantity, ")");
    }
}
