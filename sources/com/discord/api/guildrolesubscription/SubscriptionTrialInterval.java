package com.discord.api.guildrolesubscription;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: SubscriptionTrialInterval.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class SubscriptionTrialInterval {
    private final GuildRoleSubscriptionFreeTrialIntervalTypes interval;
    private final int intervalCount;

    public SubscriptionTrialInterval(GuildRoleSubscriptionFreeTrialIntervalTypes guildRoleSubscriptionFreeTrialIntervalTypes, int i) {
        Intrinsics3.checkNotNullParameter(guildRoleSubscriptionFreeTrialIntervalTypes, "interval");
        this.interval = guildRoleSubscriptionFreeTrialIntervalTypes;
        this.intervalCount = i;
    }

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
        if (!(other instanceof SubscriptionTrialInterval)) {
            return false;
        }
        SubscriptionTrialInterval subscriptionTrialInterval = (SubscriptionTrialInterval) other;
        return Intrinsics3.areEqual(this.interval, subscriptionTrialInterval.interval) && this.intervalCount == subscriptionTrialInterval.intervalCount;
    }

    public int hashCode() {
        GuildRoleSubscriptionFreeTrialIntervalTypes guildRoleSubscriptionFreeTrialIntervalTypes = this.interval;
        return ((guildRoleSubscriptionFreeTrialIntervalTypes != null ? guildRoleSubscriptionFreeTrialIntervalTypes.hashCode() : 0) * 31) + this.intervalCount;
    }

    public String toString() {
        StringBuilder sbU = outline.U("SubscriptionTrialInterval(interval=");
        sbU.append(this.interval);
        sbU.append(", intervalCount=");
        return outline.B(sbU, this.intervalCount, ")");
    }
}
