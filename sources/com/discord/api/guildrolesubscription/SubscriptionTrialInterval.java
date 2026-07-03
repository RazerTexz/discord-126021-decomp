package com.discord.api.guildrolesubscription;

import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: SubscriptionTrialInterval.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class SubscriptionTrialInterval {
    private final GuildRoleSubscriptionFreeTrialIntervalTypes interval;
    private final int intervalCount;

    public SubscriptionTrialInterval(GuildRoleSubscriptionFreeTrialIntervalTypes guildRoleSubscriptionFreeTrialIntervalTypes, int i) {
        C12238m.checkNotNullParameter(guildRoleSubscriptionFreeTrialIntervalTypes, "interval");
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
        return C12238m.areEqual(this.interval, subscriptionTrialInterval.interval) && this.intervalCount == subscriptionTrialInterval.intervalCount;
    }

    public int hashCode() {
        GuildRoleSubscriptionFreeTrialIntervalTypes guildRoleSubscriptionFreeTrialIntervalTypes = this.interval;
        return ((guildRoleSubscriptionFreeTrialIntervalTypes != null ? guildRoleSubscriptionFreeTrialIntervalTypes.hashCode() : 0) * 31) + this.intervalCount;
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("SubscriptionTrialInterval(interval=");
        sbM833U.append(this.interval);
        sbM833U.append(", intervalCount=");
        return C1643a.m814B(sbM833U, this.intervalCount, ")");
    }
}
