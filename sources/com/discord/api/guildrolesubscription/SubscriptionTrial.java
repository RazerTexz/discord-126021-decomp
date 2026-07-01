package com.discord.api.guildrolesubscription;

import b.d.b.a.a;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.m;

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
        return this.id == subscriptionTrial.id && m.areEqual(this.interval, subscriptionTrial.interval) && this.intervalCount == subscriptionTrial.intervalCount && this.skuId == subscriptionTrial.skuId;
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
        StringBuilder sbU = a.U("SubscriptionTrial(id=");
        sbU.append(this.id);
        sbU.append(", interval=");
        sbU.append(this.interval);
        sbU.append(", intervalCount=");
        sbU.append(this.intervalCount);
        sbU.append(", skuId=");
        return a.C(sbU, this.skuId, ")");
    }
}
