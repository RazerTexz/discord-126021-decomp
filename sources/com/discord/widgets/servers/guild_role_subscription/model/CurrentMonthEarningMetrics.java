package com.discord.widgets.servers.guild_role_subscription.model;

import a0.a.a.b;
import b.d.b.a.a;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

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

    public static /* synthetic */ CurrentMonthEarningMetrics copy$default(CurrentMonthEarningMetrics currentMonthEarningMetrics, long j, Long l, long j2, Long l2, String str, String str2, int i, Object obj) {
        return currentMonthEarningMetrics.copy((i & 1) != 0 ? currentMonthEarningMetrics.revenue : j, (i & 2) != 0 ? currentMonthEarningMetrics.monthOverMonthRevenueChangePercent : l, (i & 4) != 0 ? currentMonthEarningMetrics.subscriberCount : j2, (i & 8) != 0 ? currentMonthEarningMetrics.monthOverMonthSubscriberCountChange : l2, (i & 16) != 0 ? currentMonthEarningMetrics.nextPaymentDate : str, (i & 32) != 0 ? currentMonthEarningMetrics.revenueSinceDate : str2);
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
        return this.revenue == currentMonthEarningMetrics.revenue && m.areEqual(this.monthOverMonthRevenueChangePercent, currentMonthEarningMetrics.monthOverMonthRevenueChangePercent) && this.subscriberCount == currentMonthEarningMetrics.subscriberCount && m.areEqual(this.monthOverMonthSubscriberCountChange, currentMonthEarningMetrics.monthOverMonthSubscriberCountChange) && m.areEqual(this.nextPaymentDate, currentMonthEarningMetrics.nextPaymentDate) && m.areEqual(this.revenueSinceDate, currentMonthEarningMetrics.revenueSinceDate);
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
        int iA = b.a(this.revenue) * 31;
        Long l = this.monthOverMonthRevenueChangePercent;
        int iA2 = (b.a(this.subscriberCount) + ((iA + (l != null ? l.hashCode() : 0)) * 31)) * 31;
        Long l2 = this.monthOverMonthSubscriberCountChange;
        int iHashCode = (iA2 + (l2 != null ? l2.hashCode() : 0)) * 31;
        String str = this.nextPaymentDate;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.revenueSinceDate;
        return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("CurrentMonthEarningMetrics(revenue=");
        sbU.append(this.revenue);
        sbU.append(", monthOverMonthRevenueChangePercent=");
        sbU.append(this.monthOverMonthRevenueChangePercent);
        sbU.append(", subscriberCount=");
        sbU.append(this.subscriberCount);
        sbU.append(", monthOverMonthSubscriberCountChange=");
        sbU.append(this.monthOverMonthSubscriberCountChange);
        sbU.append(", nextPaymentDate=");
        sbU.append(this.nextPaymentDate);
        sbU.append(", revenueSinceDate=");
        return a.J(sbU, this.revenueSinceDate, ")");
    }

    public /* synthetic */ CurrentMonthEarningMetrics(long j, Long l, long j2, Long l2, String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0L : j, (i & 2) != 0 ? null : l, (i & 4) == 0 ? j2 : 0L, (i & 8) == 0 ? l2 : null, (i & 16) != 0 ? "" : str, (i & 32) == 0 ? str2 : "");
    }
}
