package com.discord.widgets.servers.guild_role_subscription.model;

import a0.a.a.b;
import b.d.b.a.outline;
import com.discord.api.guildrolesubscription.PayoutGroup;
import d0.z.d.Intrinsics3;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: TotalPayoutsForPeriod.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class TotalPayoutsForPeriod {
    private final Map<Long, PayoutGroup> payoutGroups;
    private final String periodStartingAt;
    private final long revenue;
    private final long subscriberCount;

    public TotalPayoutsForPeriod(String str, long j, long j2, Map<Long, PayoutGroup> map) {
        Intrinsics3.checkNotNullParameter(str, "periodStartingAt");
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
        Intrinsics3.checkNotNullParameter(periodStartingAt, "periodStartingAt");
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
        return Intrinsics3.areEqual(this.periodStartingAt, totalPayoutsForPeriod.periodStartingAt) && this.subscriberCount == totalPayoutsForPeriod.subscriberCount && this.revenue == totalPayoutsForPeriod.revenue && Intrinsics3.areEqual(this.payoutGroups, totalPayoutsForPeriod.payoutGroups);
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
        int iA = (b.a(this.revenue) + ((b.a(this.subscriberCount) + ((str != null ? str.hashCode() : 0) * 31)) * 31)) * 31;
        Map<Long, PayoutGroup> map = this.payoutGroups;
        return iA + (map != null ? map.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TotalPayoutsForPeriod(periodStartingAt=");
        sbU.append(this.periodStartingAt);
        sbU.append(", subscriberCount=");
        sbU.append(this.subscriberCount);
        sbU.append(", revenue=");
        sbU.append(this.revenue);
        sbU.append(", payoutGroups=");
        return outline.M(sbU, this.payoutGroups, ")");
    }

    public /* synthetic */ TotalPayoutsForPeriod(String str, long j, long j2, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? 0L : j, (i & 4) == 0 ? j2 : 0L, (i & 8) != 0 ? null : map);
    }
}
