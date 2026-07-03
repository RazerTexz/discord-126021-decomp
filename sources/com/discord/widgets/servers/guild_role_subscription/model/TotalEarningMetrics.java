package com.discord.widgets.servers.guild_role_subscription.model;

import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p580t.C12147n;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TotalEarningMetrics.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class TotalEarningMetrics {
    private final CurrentMonthEarningMetrics currentMonthEarningMetrics;
    private final TotalPayoutsForPeriod currentPeriod;
    private final List<TotalPayoutsForPeriod> previousPeriods;

    public TotalEarningMetrics(CurrentMonthEarningMetrics currentMonthEarningMetrics, TotalPayoutsForPeriod totalPayoutsForPeriod, List<TotalPayoutsForPeriod> list) {
        C12238m.checkNotNullParameter(currentMonthEarningMetrics, "currentMonthEarningMetrics");
        C12238m.checkNotNullParameter(list, "previousPeriods");
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
        C12238m.checkNotNullParameter(currentMonthEarningMetrics, "currentMonthEarningMetrics");
        C12238m.checkNotNullParameter(previousPeriods, "previousPeriods");
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
        return C12238m.areEqual(this.currentMonthEarningMetrics, totalEarningMetrics.currentMonthEarningMetrics) && C12238m.areEqual(this.currentPeriod, totalEarningMetrics.currentPeriod) && C12238m.areEqual(this.previousPeriods, totalEarningMetrics.previousPeriods);
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
        StringBuilder sbM833U = C1643a.m833U("TotalEarningMetrics(currentMonthEarningMetrics=");
        sbM833U.append(this.currentMonthEarningMetrics);
        sbM833U.append(", currentPeriod=");
        sbM833U.append(this.currentPeriod);
        sbM833U.append(", previousPeriods=");
        return C1643a.m824L(sbM833U, this.previousPeriods, ")");
    }

    public /* synthetic */ TotalEarningMetrics(CurrentMonthEarningMetrics currentMonthEarningMetrics, TotalPayoutsForPeriod totalPayoutsForPeriod, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(currentMonthEarningMetrics, totalPayoutsForPeriod, (i & 4) != 0 ? C12147n.emptyList() : list);
    }
}
