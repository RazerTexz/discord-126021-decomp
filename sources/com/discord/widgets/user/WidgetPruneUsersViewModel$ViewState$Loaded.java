package com.discord.widgets.user;

import b.d.b.a.a;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetPruneUsersViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class WidgetPruneUsersViewModel$ViewState$Loaded extends WidgetPruneUsersViewModel$ViewState {
    private final int pruneCount;
    private final WidgetPruneUsersViewModel$PruneDays pruneDays;
    private final boolean pruneInProgress;

    public /* synthetic */ WidgetPruneUsersViewModel$ViewState$Loaded(WidgetPruneUsersViewModel$PruneDays widgetPruneUsersViewModel$PruneDays, int i, boolean z2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(widgetPruneUsersViewModel$PruneDays, i, (i2 & 4) != 0 ? false : z2);
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    private final boolean getPruneInProgress() {
        return this.pruneInProgress;
    }

    public static /* synthetic */ WidgetPruneUsersViewModel$ViewState$Loaded copy$default(WidgetPruneUsersViewModel$ViewState$Loaded widgetPruneUsersViewModel$ViewState$Loaded, WidgetPruneUsersViewModel$PruneDays widgetPruneUsersViewModel$PruneDays, int i, boolean z2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            widgetPruneUsersViewModel$PruneDays = widgetPruneUsersViewModel$ViewState$Loaded.pruneDays;
        }
        if ((i2 & 2) != 0) {
            i = widgetPruneUsersViewModel$ViewState$Loaded.pruneCount;
        }
        if ((i2 & 4) != 0) {
            z2 = widgetPruneUsersViewModel$ViewState$Loaded.pruneInProgress;
        }
        return widgetPruneUsersViewModel$ViewState$Loaded.copy(widgetPruneUsersViewModel$PruneDays, i, z2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final WidgetPruneUsersViewModel$PruneDays getPruneDays() {
        return this.pruneDays;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getPruneCount() {
        return this.pruneCount;
    }

    public final WidgetPruneUsersViewModel$ViewState$Loaded copy(WidgetPruneUsersViewModel$PruneDays pruneDays, int pruneCount, boolean pruneInProgress) {
        m.checkNotNullParameter(pruneDays, "pruneDays");
        return new WidgetPruneUsersViewModel$ViewState$Loaded(pruneDays, pruneCount, pruneInProgress);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetPruneUsersViewModel$ViewState$Loaded)) {
            return false;
        }
        WidgetPruneUsersViewModel$ViewState$Loaded widgetPruneUsersViewModel$ViewState$Loaded = (WidgetPruneUsersViewModel$ViewState$Loaded) other;
        return m.areEqual(this.pruneDays, widgetPruneUsersViewModel$ViewState$Loaded.pruneDays) && this.pruneCount == widgetPruneUsersViewModel$ViewState$Loaded.pruneCount && this.pruneInProgress == widgetPruneUsersViewModel$ViewState$Loaded.pruneInProgress;
    }

    public final boolean getPruneButtonEnabled() {
        return this.pruneCount > 0 && !this.pruneInProgress;
    }

    public final int getPruneCount() {
        return this.pruneCount;
    }

    public final WidgetPruneUsersViewModel$PruneDays getPruneDays() {
        return this.pruneDays;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4 */
    public int hashCode() {
        WidgetPruneUsersViewModel$PruneDays widgetPruneUsersViewModel$PruneDays = this.pruneDays;
        int iHashCode = (((widgetPruneUsersViewModel$PruneDays != null ? widgetPruneUsersViewModel$PruneDays.hashCode() : 0) * 31) + this.pruneCount) * 31;
        boolean z2 = this.pruneInProgress;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        return iHashCode + r1;
    }

    public String toString() {
        StringBuilder sbU = a.U("Loaded(pruneDays=");
        sbU.append(this.pruneDays);
        sbU.append(", pruneCount=");
        sbU.append(this.pruneCount);
        sbU.append(", pruneInProgress=");
        return a.O(sbU, this.pruneInProgress, ")");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetPruneUsersViewModel$ViewState$Loaded(WidgetPruneUsersViewModel$PruneDays widgetPruneUsersViewModel$PruneDays, int i, boolean z2) {
        super(null);
        m.checkNotNullParameter(widgetPruneUsersViewModel$PruneDays, "pruneDays");
        this.pruneDays = widgetPruneUsersViewModel$PruneDays;
        this.pruneCount = i;
        this.pruneInProgress = z2;
    }
}
