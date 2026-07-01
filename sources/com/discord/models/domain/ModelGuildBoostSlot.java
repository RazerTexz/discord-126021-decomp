package com.discord.models.domain;

import b.d.b.a.a;
import com.discord.utilities.time.TimeUtils;
import d0.z.d.m;

/* JADX INFO: compiled from: ModelGuildBoostSlot.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class ModelGuildBoostSlot {
    private final boolean canceled;
    private final String cooldownEndsAt;
    private final long id;
    private final ModelAppliedGuildBoost premiumGuildSubscription;
    private final long subscriptionId;

    public ModelGuildBoostSlot(String str, long j, long j2, ModelAppliedGuildBoost modelAppliedGuildBoost, boolean z2) {
        this.cooldownEndsAt = str;
        this.id = j;
        this.subscriptionId = j2;
        this.premiumGuildSubscription = modelAppliedGuildBoost;
        this.canceled = z2;
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    private final String getCooldownEndsAt() {
        return this.cooldownEndsAt;
    }

    public static /* synthetic */ ModelGuildBoostSlot copy$default(ModelGuildBoostSlot modelGuildBoostSlot, String str, long j, long j2, ModelAppliedGuildBoost modelAppliedGuildBoost, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = modelGuildBoostSlot.cooldownEndsAt;
        }
        if ((i & 2) != 0) {
            j = modelGuildBoostSlot.id;
        }
        long j3 = j;
        if ((i & 4) != 0) {
            j2 = modelGuildBoostSlot.subscriptionId;
        }
        long j4 = j2;
        if ((i & 8) != 0) {
            modelAppliedGuildBoost = modelGuildBoostSlot.premiumGuildSubscription;
        }
        ModelAppliedGuildBoost modelAppliedGuildBoost2 = modelAppliedGuildBoost;
        if ((i & 16) != 0) {
            z2 = modelGuildBoostSlot.canceled;
        }
        return modelGuildBoostSlot.copy(str, j3, j4, modelAppliedGuildBoost2, z2);
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final long getSubscriptionId() {
        return this.subscriptionId;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final ModelAppliedGuildBoost getPremiumGuildSubscription() {
        return this.premiumGuildSubscription;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getCanceled() {
        return this.canceled;
    }

    public final ModelGuildBoostSlot copy(String cooldownEndsAt, long id2, long subscriptionId, ModelAppliedGuildBoost premiumGuildSubscription, boolean canceled) {
        return new ModelGuildBoostSlot(cooldownEndsAt, id2, subscriptionId, premiumGuildSubscription, canceled);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ModelGuildBoostSlot)) {
            return false;
        }
        ModelGuildBoostSlot modelGuildBoostSlot = (ModelGuildBoostSlot) other;
        return m.areEqual(this.cooldownEndsAt, modelGuildBoostSlot.cooldownEndsAt) && this.id == modelGuildBoostSlot.id && this.subscriptionId == modelGuildBoostSlot.subscriptionId && m.areEqual(this.premiumGuildSubscription, modelGuildBoostSlot.premiumGuildSubscription) && this.canceled == modelGuildBoostSlot.canceled;
    }

    public final boolean getCanceled() {
        return this.canceled;
    }

    public final long getCooldownExpiresAtTimestamp() {
        return TimeUtils.parseUTCDate(this.cooldownEndsAt);
    }

    public final long getId() {
        return this.id;
    }

    public final ModelAppliedGuildBoost getPremiumGuildSubscription() {
        return this.premiumGuildSubscription;
    }

    public final long getSubscriptionId() {
        return this.subscriptionId;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v6 */
    public int hashCode() {
        String str = this.cooldownEndsAt;
        int iHashCode = str != null ? str.hashCode() : 0;
        long j = this.id;
        int i = ((iHashCode * 31) + ((int) (j ^ (j >>> 32)))) * 31;
        long j2 = this.subscriptionId;
        int i2 = (i + ((int) (j2 ^ (j2 >>> 32)))) * 31;
        ModelAppliedGuildBoost modelAppliedGuildBoost = this.premiumGuildSubscription;
        int iHashCode2 = (i2 + (modelAppliedGuildBoost != null ? modelAppliedGuildBoost.hashCode() : 0)) * 31;
        boolean z2 = this.canceled;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        return iHashCode2 + r1;
    }

    public String toString() {
        StringBuilder sbU = a.U("ModelGuildBoostSlot(cooldownEndsAt=");
        sbU.append(this.cooldownEndsAt);
        sbU.append(", id=");
        sbU.append(this.id);
        sbU.append(", subscriptionId=");
        sbU.append(this.subscriptionId);
        sbU.append(", premiumGuildSubscription=");
        sbU.append(this.premiumGuildSubscription);
        sbU.append(", canceled=");
        return a.O(sbU, this.canceled, ")");
    }
}
