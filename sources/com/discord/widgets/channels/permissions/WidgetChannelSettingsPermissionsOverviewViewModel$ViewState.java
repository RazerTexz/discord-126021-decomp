package com.discord.widgets.channels.permissions;

import b.d.b.a.a;
import d0.z.d.m;
import java.util.List;

/* JADX INFO: compiled from: WidgetChannelSettingsPermissionsOverviewViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetChannelSettingsPermissionsOverviewViewModel$ViewState {
    private final List<WidgetChannelSettingsPermissionsOverviewViewModel$Tab> availableTabs;
    private final WidgetChannelSettingsPermissionsOverviewViewModel$Tab selectedTab;

    /* JADX WARN: Multi-variable type inference failed */
    public WidgetChannelSettingsPermissionsOverviewViewModel$ViewState(WidgetChannelSettingsPermissionsOverviewViewModel$Tab widgetChannelSettingsPermissionsOverviewViewModel$Tab, List<? extends WidgetChannelSettingsPermissionsOverviewViewModel$Tab> list) {
        m.checkNotNullParameter(widgetChannelSettingsPermissionsOverviewViewModel$Tab, "selectedTab");
        m.checkNotNullParameter(list, "availableTabs");
        this.selectedTab = widgetChannelSettingsPermissionsOverviewViewModel$Tab;
        this.availableTabs = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WidgetChannelSettingsPermissionsOverviewViewModel$ViewState copy$default(WidgetChannelSettingsPermissionsOverviewViewModel$ViewState widgetChannelSettingsPermissionsOverviewViewModel$ViewState, WidgetChannelSettingsPermissionsOverviewViewModel$Tab widgetChannelSettingsPermissionsOverviewViewModel$Tab, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            widgetChannelSettingsPermissionsOverviewViewModel$Tab = widgetChannelSettingsPermissionsOverviewViewModel$ViewState.selectedTab;
        }
        if ((i & 2) != 0) {
            list = widgetChannelSettingsPermissionsOverviewViewModel$ViewState.availableTabs;
        }
        return widgetChannelSettingsPermissionsOverviewViewModel$ViewState.copy(widgetChannelSettingsPermissionsOverviewViewModel$Tab, list);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final WidgetChannelSettingsPermissionsOverviewViewModel$Tab getSelectedTab() {
        return this.selectedTab;
    }

    public final List<WidgetChannelSettingsPermissionsOverviewViewModel$Tab> component2() {
        return this.availableTabs;
    }

    public final WidgetChannelSettingsPermissionsOverviewViewModel$ViewState copy(WidgetChannelSettingsPermissionsOverviewViewModel$Tab selectedTab, List<? extends WidgetChannelSettingsPermissionsOverviewViewModel$Tab> availableTabs) {
        m.checkNotNullParameter(selectedTab, "selectedTab");
        m.checkNotNullParameter(availableTabs, "availableTabs");
        return new WidgetChannelSettingsPermissionsOverviewViewModel$ViewState(selectedTab, availableTabs);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetChannelSettingsPermissionsOverviewViewModel$ViewState)) {
            return false;
        }
        WidgetChannelSettingsPermissionsOverviewViewModel$ViewState widgetChannelSettingsPermissionsOverviewViewModel$ViewState = (WidgetChannelSettingsPermissionsOverviewViewModel$ViewState) other;
        return m.areEqual(this.selectedTab, widgetChannelSettingsPermissionsOverviewViewModel$ViewState.selectedTab) && m.areEqual(this.availableTabs, widgetChannelSettingsPermissionsOverviewViewModel$ViewState.availableTabs);
    }

    public final List<WidgetChannelSettingsPermissionsOverviewViewModel$Tab> getAvailableTabs() {
        return this.availableTabs;
    }

    public final WidgetChannelSettingsPermissionsOverviewViewModel$Tab getSelectedTab() {
        return this.selectedTab;
    }

    public int hashCode() {
        WidgetChannelSettingsPermissionsOverviewViewModel$Tab widgetChannelSettingsPermissionsOverviewViewModel$Tab = this.selectedTab;
        int iHashCode = (widgetChannelSettingsPermissionsOverviewViewModel$Tab != null ? widgetChannelSettingsPermissionsOverviewViewModel$Tab.hashCode() : 0) * 31;
        List<WidgetChannelSettingsPermissionsOverviewViewModel$Tab> list = this.availableTabs;
        return iHashCode + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("ViewState(selectedTab=");
        sbU.append(this.selectedTab);
        sbU.append(", availableTabs=");
        return a.L(sbU, this.availableTabs, ")");
    }
}
