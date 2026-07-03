package com.discord.api.guildrolesubscription;

import com.discord.models.domain.ModelAuditLogEntry;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: SubscriptionTrial.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class SubscriptionTrial {
    private final long id;
    private final GuildRoleSubscriptionFreeTrialIntervalTypes interval;
    private final int intervalCount;
    private final long skuId;

    /* JADX INFO: renamed from: a, reason: from getter */
    public final GuildRoleSubscriptionFreeTrialIntervalTypes getInterval() {
        return this.interval;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final int getIntervalCount() {
        return this.intervalCount;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SubscriptionTrial)) {
            return false;
        }
        SubscriptionTrial subscriptionTrial = (SubscriptionTrial) other;
        return this.id == subscriptionTrial.id && C12238m.areEqual(this.interval, subscriptionTrial.interval) && this.intervalCount == subscriptionTrial.intervalCount && this.skuId == subscriptionTrial.skuId;
    }

    public int hashCode() {
        long j = this.id;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        GuildRoleSubscriptionFreeTrialIntervalTypes guildRoleSubscriptionFreeTrialIntervalTypes = this.interval;
        int iHashCode = (((i + (guildRoleSubscriptionFreeTrialIntervalTypes != null ? guildRoleSubscriptionFreeTrialIntervalTypes.hashCode() : 0)) * 31) + this.intervalCount) * 31;
        long j2 = this.skuId;
        return iHashCode + ((int) (j2 ^ (j2 >>> 32)));
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("SubscriptionTrial(id=");
        sbM833U.append(this.id);
        sbM833U.append(", interval=");
        sbM833U.append(this.interval);
        sbM833U.append(", intervalCount=");
        sbM833U.append(this.intervalCount);
        sbM833U.append(", skuId=");
        return C1643a.m815C(sbM833U, this.skuId, ")");
    }
}
