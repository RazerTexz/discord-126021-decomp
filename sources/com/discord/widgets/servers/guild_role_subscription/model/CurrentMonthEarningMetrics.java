package com.discord.widgets.servers.guild_role_subscription.model;

import kotlin.jvm.internal.DefaultConstructorMarker;
import p001a0.p002a.p003a.C0002b;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: CurrentMonthEarningMetrics.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class CurrentMonthEarningMetrics {
    private final Long monthOverMonthRevenueChangePercent;
    private final Long monthOverMonthSubscriberCountChange;
    private final String nextPaymentDate;
    private final long revenue;
    private final String revenueSinceDate;
    private final long subscriberCount;

    public CurrentMonthEarningMetrics() {
        this(0L, null, 0L, null, null, null, 63, null);
    }

    public CurrentMonthEarningMetrics(long j, Long l, long j2, Long l2, String str, String str2) {
        this.revenue = j;
        this.monthOverMonthRevenueChangePercent = l;
        this.subscriberCount = j2;
        this.monthOverMonthSubscriberCountChange = l2;
        this.nextPaymentDate = str;
        this.revenueSinceDate = str2;
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getRevenue() {
        return this.revenue;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Long getMonthOverMonthRevenueChangePercent() {
        return this.monthOverMonthRevenueChangePercent;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final long getSubscriberCount() {
        return this.subscriberCount;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Long getMonthOverMonthSubscriberCountChange() {
        return this.monthOverMonthSubscriberCountChange;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getNextPaymentDate() {
        return this.nextPaymentDate;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getRevenueSinceDate() {
        return this.revenueSinceDate;
    }

    public final CurrentMonthEarningMetrics copy(long revenue, Long monthOverMonthRevenueChangePercent, long subscriberCount, Long monthOverMonthSubscriberCountChange, String nextPaymentDate, String revenueSinceDate) {
        return new CurrentMonthEarningMetrics(revenue, monthOverMonthRevenueChangePercent, subscriberCount, monthOverMonthSubscriberCountChange, nextPaymentDate, revenueSinceDate);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CurrentMonthEarningMetrics)) {
            return false;
        }
        CurrentMonthEarningMetrics currentMonthEarningMetrics = (CurrentMonthEarningMetrics) other;
        return this.revenue == currentMonthEarningMetrics.revenue && C12238m.areEqual(this.monthOverMonthRevenueChangePercent, currentMonthEarningMetrics.monthOverMonthRevenueChangePercent) && this.subscriberCount == currentMonthEarningMetrics.subscriberCount && C12238m.areEqual(this.monthOverMonthSubscriberCountChange, currentMonthEarningMetrics.monthOverMonthSubscriberCountChange) && C12238m.areEqual(this.nextPaymentDate, currentMonthEarningMetrics.nextPaymentDate) && C12238m.areEqual(this.revenueSinceDate, currentMonthEarningMetrics.revenueSinceDate);
    }

    public final Long getMonthOverMonthRevenueChangePercent() {
        return this.monthOverMonthRevenueChangePercent;
    }

    public final Long getMonthOverMonthSubscriberCountChange() {
        return this.monthOverMonthSubscriberCountChange;
    }

    public final String getNextPaymentDate() {
        return this.nextPaymentDate;
    }

    public final long getRevenue() {
        return this.revenue;
    }

    public final String getRevenueSinceDate() {
        return this.revenueSinceDate;
    }

    public final long getSubscriberCount() {
        return this.subscriberCount;
    }

    public int hashCode() {
        int iM3a = C0002b.m3a(this.revenue) * 31;
        Long l = this.monthOverMonthRevenueChangePercent;
        int iM3a2 = (C0002b.m3a(this.subscriberCount) + ((iM3a + (l != null ? l.hashCode() : 0)) * 31)) * 31;
        Long l2 = this.monthOverMonthSubscriberCountChange;
        int iHashCode = (iM3a2 + (l2 != null ? l2.hashCode() : 0)) * 31;
        String str = this.nextPaymentDate;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.revenueSinceDate;
        return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("CurrentMonthEarningMetrics(revenue=");
        sbM833U.append(this.revenue);
        sbM833U.append(", monthOverMonthRevenueChangePercent=");
        sbM833U.append(this.monthOverMonthRevenueChangePercent);
        sbM833U.append(", subscriberCount=");
        sbM833U.append(this.subscriberCount);
        sbM833U.append(", monthOverMonthSubscriberCountChange=");
        sbM833U.append(this.monthOverMonthSubscriberCountChange);
        sbM833U.append(", nextPaymentDate=");
        sbM833U.append(this.nextPaymentDate);
        sbM833U.append(", revenueSinceDate=");
        return C1643a.m822J(sbM833U, this.revenueSinceDate, ")");
    }

    public /* synthetic */ CurrentMonthEarningMetrics(long j, Long l, long j2, Long l2, String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0L : j, (i & 2) != 0 ? null : l, (i & 4) == 0 ? j2 : 0L, (i & 8) == 0 ? l2 : null, (i & 16) != 0 ? "" : str, (i & 32) == 0 ? str2 : "");
    }
}
