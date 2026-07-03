package com.discord.api.premium;

import com.discord.models.domain.ModelAuditLogEntry;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: SubscriptionPlan.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class SubscriptionPlan {
    private final long id;
    private final SubscriptionInterval interval;
    private final int intervalCount;
    private final String name;
    private final int price;

    /* JADX INFO: renamed from: a, reason: from getter */
    public final long getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final SubscriptionInterval getInterval() {
        return this.interval;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final int getIntervalCount() {
        return this.intervalCount;
    }

    /* JADX INFO: renamed from: d, reason: from getter */
    public final int getPrice() {
        return this.price;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SubscriptionPlan)) {
            return false;
        }
        SubscriptionPlan subscriptionPlan = (SubscriptionPlan) other;
        return this.id == subscriptionPlan.id && this.intervalCount == subscriptionPlan.intervalCount && C12238m.areEqual(this.interval, subscriptionPlan.interval) && C12238m.areEqual(this.name, subscriptionPlan.name) && this.price == subscriptionPlan.price;
    }

    public int hashCode() {
        long j = this.id;
        int i = ((((int) (j ^ (j >>> 32))) * 31) + this.intervalCount) * 31;
        SubscriptionInterval subscriptionInterval = this.interval;
        int iHashCode = (i + (subscriptionInterval != null ? subscriptionInterval.hashCode() : 0)) * 31;
        String str = this.name;
        return ((iHashCode + (str != null ? str.hashCode() : 0)) * 31) + this.price;
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("SubscriptionPlan(id=");
        sbM833U.append(this.id);
        sbM833U.append(", intervalCount=");
        sbM833U.append(this.intervalCount);
        sbM833U.append(", interval=");
        sbM833U.append(this.interval);
        sbM833U.append(", name=");
        sbM833U.append(this.name);
        sbM833U.append(", price=");
        return C1643a.m814B(sbM833U, this.price, ")");
    }
}
