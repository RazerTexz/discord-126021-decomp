package com.discord.widgets.servers.guild_role_subscription.model;

import b.d.b.a.a;
import d0.t.n;
import d0.z.d.m;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: TotalEarningMetrics.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class TotalEarningMetrics {
    private final CurrentMonthEarningMetrics currentMonthEarningMetrics;
    private final TotalPayoutsForPeriod currentPeriod;
    private final List<TotalPayoutsForPeriod> previousPeriods;

    public TotalEarningMetrics(CurrentMonthEarningMetrics currentMonthEarningMetrics, TotalPayoutsForPeriod totalPayoutsForPeriod, List<TotalPayoutsForPeriod> list) {
        m.checkNotNullParameter(currentMonthEarningMetrics, "currentMonthEarningMetrics");
        m.checkNotNullParameter(list, "previousPeriods");
        this.currentMonthEarningMetrics = currentMonthEarningMetrics;
        this.currentPeriod = totalPayoutsForPeriod;
        this.previousPeriods = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TotalEarningMetrics copy$default(TotalEarningMetrics totalEarningMetrics, CurrentMonthEarningMetrics currentMonthEarningMetrics, TotalPayoutsForPeriod totalPayoutsForPeriod, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            currentMonthEarningMetrics = totalEarningMetrics.currentMonthEarningMetrics;
        }
        if ((i & 2) != 0) {
            totalPayoutsForPeriod = totalEarningMetrics.currentPeriod;
        }
        if ((i & 4) != 0) {
            list = totalEarningMetrics.previousPeriods;
        }
        return totalEarningMetrics.copy(currentMonthEarningMetrics, totalPayoutsForPeriod, list);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final CurrentMonthEarningMetrics getCurrentMonthEarningMetrics() {
        return this.currentMonthEarningMetrics;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final TotalPayoutsForPeriod getCurrentPeriod() {
        return this.currentPeriod;
    }

    public final List<TotalPayoutsForPeriod> component3() {
        return this.previousPeriods;
    }

    public final TotalEarningMetrics copy(CurrentMonthEarningMetrics currentMonthEarningMetrics, TotalPayoutsForPeriod currentPeriod, List<TotalPayoutsForPeriod> previousPeriods) {
        m.checkNotNullParameter(currentMonthEarningMetrics, "currentMonthEarningMetrics");
        m.checkNotNullParameter(previousPeriods, "previousPeriods");
        return new TotalEarningMetrics(currentMonthEarningMetrics, currentPeriod, previousPeriods);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TotalEarningMetrics)) {
            return false;
        }
        TotalEarningMetrics totalEarningMetrics = (TotalEarningMetrics) other;
        return m.areEqual(this.currentMonthEarningMetrics, totalEarningMetrics.currentMonthEarningMetrics) && m.areEqual(this.currentPeriod, totalEarningMetrics.currentPeriod) && m.areEqual(this.previousPeriods, totalEarningMetrics.previousPeriods);
    }

    public final CurrentMonthEarningMetrics getCurrentMonthEarningMetrics() {
        return this.currentMonthEarningMetrics;
    }

    public final TotalPayoutsForPeriod getCurrentPeriod() {
        return this.currentPeriod;
    }

    public final List<TotalPayoutsForPeriod> getPreviousPeriods() {
        return this.previousPeriods;
    }

    public int hashCode() {
        CurrentMonthEarningMetrics currentMonthEarningMetrics = this.currentMonthEarningMetrics;
        int iHashCode = (currentMonthEarningMetrics != null ? currentMonthEarningMetrics.hashCode() : 0) * 31;
        TotalPayoutsForPeriod totalPayoutsForPeriod = this.currentPeriod;
        int iHashCode2 = (iHashCode + (totalPayoutsForPeriod != null ? totalPayoutsForPeriod.hashCode() : 0)) * 31;
        List<TotalPayoutsForPeriod> list = this.previousPeriods;
        return iHashCode2 + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("TotalEarningMetrics(currentMonthEarningMetrics=");
        sbU.append(this.currentMonthEarningMetrics);
        sbU.append(", currentPeriod=");
        sbU.append(this.currentPeriod);
        sbU.append(", previousPeriods=");
        return a.L(sbU, this.previousPeriods, ")");
    }

    public /* synthetic */ TotalEarningMetrics(CurrentMonthEarningMetrics currentMonthEarningMetrics, TotalPayoutsForPeriod totalPayoutsForPeriod, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(currentMonthEarningMetrics, totalPayoutsForPeriod, (i & 4) != 0 ? n.emptyList() : list);
    }
}
