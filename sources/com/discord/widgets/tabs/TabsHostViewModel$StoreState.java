package com.discord.widgets.tabs;

import a0.a.a.b;
import b.d.b.a.a;
import com.discord.models.guild.Guild;
import com.discord.panels.PanelState;
import d0.z.d.m;
import java.util.Map;

/* JADX INFO: compiled from: TabsHostViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TabsHostViewModel$StoreState {
    private final Map<Long, Guild> guildIdToGuildMap;
    private final PanelState leftPanelState;
    private final long myUserId;
    private final int numTotalMentions;
    private final NavigationTab selectedTab;
    private final Map<Long, Integer> userRelationships;

    public TabsHostViewModel$StoreState(PanelState panelState, NavigationTab navigationTab, long j, Map<Long, Guild> map, int i, Map<Long, Integer> map2) {
        m.checkNotNullParameter(panelState, "leftPanelState");
        m.checkNotNullParameter(navigationTab, "selectedTab");
        m.checkNotNullParameter(map, "guildIdToGuildMap");
        m.checkNotNullParameter(map2, "userRelationships");
        this.leftPanelState = panelState;
        this.selectedTab = navigationTab;
        this.myUserId = j;
        this.guildIdToGuildMap = map;
        this.numTotalMentions = i;
        this.userRelationships = map2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TabsHostViewModel$StoreState copy$default(TabsHostViewModel$StoreState tabsHostViewModel$StoreState, PanelState panelState, NavigationTab navigationTab, long j, Map map, int i, Map map2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            panelState = tabsHostViewModel$StoreState.leftPanelState;
        }
        if ((i2 & 2) != 0) {
            navigationTab = tabsHostViewModel$StoreState.selectedTab;
        }
        NavigationTab navigationTab2 = navigationTab;
        if ((i2 & 4) != 0) {
            j = tabsHostViewModel$StoreState.myUserId;
        }
        long j2 = j;
        if ((i2 & 8) != 0) {
            map = tabsHostViewModel$StoreState.guildIdToGuildMap;
        }
        Map map3 = map;
        if ((i2 & 16) != 0) {
            i = tabsHostViewModel$StoreState.numTotalMentions;
        }
        int i3 = i;
        if ((i2 & 32) != 0) {
            map2 = tabsHostViewModel$StoreState.userRelationships;
        }
        return tabsHostViewModel$StoreState.copy(panelState, navigationTab2, j2, map3, i3, map2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final PanelState getLeftPanelState() {
        return this.leftPanelState;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final NavigationTab getSelectedTab() {
        return this.selectedTab;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final long getMyUserId() {
        return this.myUserId;
    }

    public final Map<Long, Guild> component4() {
        return this.guildIdToGuildMap;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final int getNumTotalMentions() {
        return this.numTotalMentions;
    }

    public final Map<Long, Integer> component6() {
        return this.userRelationships;
    }

    public final TabsHostViewModel$StoreState copy(PanelState leftPanelState, NavigationTab selectedTab, long myUserId, Map<Long, Guild> guildIdToGuildMap, int numTotalMentions, Map<Long, Integer> userRelationships) {
        m.checkNotNullParameter(leftPanelState, "leftPanelState");
        m.checkNotNullParameter(selectedTab, "selectedTab");
        m.checkNotNullParameter(guildIdToGuildMap, "guildIdToGuildMap");
        m.checkNotNullParameter(userRelationships, "userRelationships");
        return new TabsHostViewModel$StoreState(leftPanelState, selectedTab, myUserId, guildIdToGuildMap, numTotalMentions, userRelationships);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TabsHostViewModel$StoreState)) {
            return false;
        }
        TabsHostViewModel$StoreState tabsHostViewModel$StoreState = (TabsHostViewModel$StoreState) other;
        return m.areEqual(this.leftPanelState, tabsHostViewModel$StoreState.leftPanelState) && m.areEqual(this.selectedTab, tabsHostViewModel$StoreState.selectedTab) && this.myUserId == tabsHostViewModel$StoreState.myUserId && m.areEqual(this.guildIdToGuildMap, tabsHostViewModel$StoreState.guildIdToGuildMap) && this.numTotalMentions == tabsHostViewModel$StoreState.numTotalMentions && m.areEqual(this.userRelationships, tabsHostViewModel$StoreState.userRelationships);
    }

    public final Map<Long, Guild> getGuildIdToGuildMap() {
        return this.guildIdToGuildMap;
    }

    public final PanelState getLeftPanelState() {
        return this.leftPanelState;
    }

    public final long getMyUserId() {
        return this.myUserId;
    }

    public final int getNumTotalMentions() {
        return this.numTotalMentions;
    }

    public final NavigationTab getSelectedTab() {
        return this.selectedTab;
    }

    public final Map<Long, Integer> getUserRelationships() {
        return this.userRelationships;
    }

    public int hashCode() {
        PanelState panelState = this.leftPanelState;
        int iHashCode = (panelState != null ? panelState.hashCode() : 0) * 31;
        NavigationTab navigationTab = this.selectedTab;
        int iA = (b.a(this.myUserId) + ((iHashCode + (navigationTab != null ? navigationTab.hashCode() : 0)) * 31)) * 31;
        Map<Long, Guild> map = this.guildIdToGuildMap;
        int iHashCode2 = (((iA + (map != null ? map.hashCode() : 0)) * 31) + this.numTotalMentions) * 31;
        Map<Long, Integer> map2 = this.userRelationships;
        return iHashCode2 + (map2 != null ? map2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("StoreState(leftPanelState=");
        sbU.append(this.leftPanelState);
        sbU.append(", selectedTab=");
        sbU.append(this.selectedTab);
        sbU.append(", myUserId=");
        sbU.append(this.myUserId);
        sbU.append(", guildIdToGuildMap=");
        sbU.append(this.guildIdToGuildMap);
        sbU.append(", numTotalMentions=");
        sbU.append(this.numTotalMentions);
        sbU.append(", userRelationships=");
        return a.M(sbU, this.userRelationships, ")");
    }
}
