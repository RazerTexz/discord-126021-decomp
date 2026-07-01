package com.discord.api.premium;

import b.d.b.a.a;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.m;

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
        return this.id == subscriptionPlan.id && this.intervalCount == subscriptionPlan.intervalCount && m.areEqual(this.interval, subscriptionPlan.interval) && m.areEqual(this.name, subscriptionPlan.name) && this.price == subscriptionPlan.price;
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
        StringBuilder sbU = a.U("SubscriptionPlan(id=");
        sbU.append(this.id);
        sbU.append(", intervalCount=");
        sbU.append(this.intervalCount);
        sbU.append(", interval=");
        sbU.append(this.interval);
        sbU.append(", name=");
        sbU.append(this.name);
        sbU.append(", price=");
        return a.B(sbU, this.price, ")");
    }
}
