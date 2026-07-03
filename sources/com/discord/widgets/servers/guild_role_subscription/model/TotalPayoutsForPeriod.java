package com.discord.widgets.servers.guild_role_subscription.model;

import com.discord.api.guildrolesubscription.PayoutGroup;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p001a0.p002a.p003a.C0002b;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TotalPayoutsForPeriod.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class TotalPayoutsForPeriod {
    private final Map<Long, PayoutGroup> payoutGroups;
    private final String periodStartingAt;
    private final long revenue;
    private final long subscriberCount;

    public TotalPayoutsForPeriod(String str, long j, long j2, Map<Long, PayoutGroup> map) {
        C12238m.checkNotNullParameter(str, "periodStartingAt");
        this.periodStartingAt = str;
        this.subscriberCount = j;
        this.revenue = j2;
        this.payoutGroups = map;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TotalPayoutsForPeriod copy$default(TotalPayoutsForPeriod totalPayoutsForPeriod, String str, long j, long j2, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            str = totalPayoutsForPeriod.periodStartingAt;
        }
        if ((i & 2) != 0) {
            j = totalPayoutsForPeriod.subscriberCount;
        }
        long j3 = j;
        if ((i & 4) != 0) {
            j2 = totalPayoutsForPeriod.revenue;
        }
        long j4 = j2;
        if ((i & 8) != 0) {
            map = totalPayoutsForPeriod.payoutGroups;
        }
        return totalPayoutsForPeriod.copy(str, j3, j4, map);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getPeriodStartingAt() {
        return this.periodStartingAt;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getSubscriberCount() {
        return this.subscriberCount;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final long getRevenue() {
        return this.revenue;
    }

    public final Map<Long, PayoutGroup> component4() {
        return this.payoutGroups;
    }

    public final TotalPayoutsForPeriod copy(String periodStartingAt, long subscriberCount, long revenue, Map<Long, PayoutGroup> payoutGroups) {
        C12238m.checkNotNullParameter(periodStartingAt, "periodStartingAt");
        return new TotalPayoutsForPeriod(periodStartingAt, subscriberCount, revenue, payoutGroups);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TotalPayoutsForPeriod)) {
            return false;
        }
        TotalPayoutsForPeriod totalPayoutsForPeriod = (TotalPayoutsForPeriod) other;
        return C12238m.areEqual(this.periodStartingAt, totalPayoutsForPeriod.periodStartingAt) && this.subscriberCount == totalPayoutsForPeriod.subscriberCount && this.revenue == totalPayoutsForPeriod.revenue && C12238m.areEqual(this.payoutGroups, totalPayoutsForPeriod.payoutGroups);
    }

    public final Map<Long, PayoutGroup> getPayoutGroups() {
        return this.payoutGroups;
    }

    public final String getPeriodStartingAt() {
        return this.periodStartingAt;
    }

    public final long getRevenue() {
        return this.revenue;
    }

    public final long getSubscriberCount() {
        return this.subscriberCount;
    }

    public int hashCode() {
        String str = this.periodStartingAt;
        int iM3a = (C0002b.m3a(this.revenue) + ((C0002b.m3a(this.subscriberCount) + ((str != null ? str.hashCode() : 0) * 31)) * 31)) * 31;
        Map<Long, PayoutGroup> map = this.payoutGroups;
        return iM3a + (map != null ? map.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("TotalPayoutsForPeriod(periodStartingAt=");
        sbM833U.append(this.periodStartingAt);
        sbM833U.append(", subscriberCount=");
        sbM833U.append(this.subscriberCount);
        sbM833U.append(", revenue=");
        sbM833U.append(this.revenue);
        sbM833U.append(", payoutGroups=");
        return C1643a.m825M(sbM833U, this.payoutGroups, ")");
    }

    public /* synthetic */ TotalPayoutsForPeriod(String str, long j, long j2, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? 0L : j, (i & 4) == 0 ? j2 : 0L, (i & 8) != 0 ? null : map);
    }
}
