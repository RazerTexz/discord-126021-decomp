package com.discord.widgets.user;

import b.d.b.a.a;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetPruneUsersViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class WidgetPruneUsersViewModel$ViewState$Loading extends WidgetPruneUsersViewModel$ViewState {
    private final String guildName;
    private final WidgetPruneUsersViewModel$PruneDays whichPruneDays;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetPruneUsersViewModel$ViewState$Loading(WidgetPruneUsersViewModel$PruneDays widgetPruneUsersViewModel$PruneDays, String str) {
        super(null);
        m.checkNotNullParameter(widgetPruneUsersViewModel$PruneDays, "whichPruneDays");
        m.checkNotNullParameter(str, "guildName");
        this.whichPruneDays = widgetPruneUsersViewModel$PruneDays;
        this.guildName = str;
    }

    public static /* synthetic */ WidgetPruneUsersViewModel$ViewState$Loading copy$default(WidgetPruneUsersViewModel$ViewState$Loading widgetPruneUsersViewModel$ViewState$Loading, WidgetPruneUsersViewModel$PruneDays widgetPruneUsersViewModel$PruneDays, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            widgetPruneUsersViewModel$PruneDays = widgetPruneUsersViewModel$ViewState$Loading.whichPruneDays;
        }
        if ((i & 2) != 0) {
            str = widgetPruneUsersViewModel$ViewState$Loading.guildName;
        }
        return widgetPruneUsersViewModel$ViewState$Loading.copy(widgetPruneUsersViewModel$PruneDays, str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final WidgetPruneUsersViewModel$PruneDays getWhichPruneDays() {
        return this.whichPruneDays;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getGuildName() {
        return this.guildName;
    }

    public final WidgetPruneUsersViewModel$ViewState$Loading copy(WidgetPruneUsersViewModel$PruneDays whichPruneDays, String guildName) {
        m.checkNotNullParameter(whichPruneDays, "whichPruneDays");
        m.checkNotNullParameter(guildName, "guildName");
        return new WidgetPruneUsersViewModel$ViewState$Loading(whichPruneDays, guildName);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetPruneUsersViewModel$ViewState$Loading)) {
            return false;
        }
        WidgetPruneUsersViewModel$ViewState$Loading widgetPruneUsersViewModel$ViewState$Loading = (WidgetPruneUsersViewModel$ViewState$Loading) other;
        return m.areEqual(this.whichPruneDays, widgetPruneUsersViewModel$ViewState$Loading.whichPruneDays) && m.areEqual(this.guildName, widgetPruneUsersViewModel$ViewState$Loading.guildName);
    }

    public final String getGuildName() {
        return this.guildName;
    }

    public final WidgetPruneUsersViewModel$PruneDays getWhichPruneDays() {
        return this.whichPruneDays;
    }

    public int hashCode() {
        WidgetPruneUsersViewModel$PruneDays widgetPruneUsersViewModel$PruneDays = this.whichPruneDays;
        int iHashCode = (widgetPruneUsersViewModel$PruneDays != null ? widgetPruneUsersViewModel$PruneDays.hashCode() : 0) * 31;
        String str = this.guildName;
        return iHashCode + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("Loading(whichPruneDays=");
        sbU.append(this.whichPruneDays);
        sbU.append(", guildName=");
        return a.J(sbU, this.guildName, ")");
    }
}
