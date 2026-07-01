package com.discord.widgets.tabs;

import a0.a.a.b;
import b.d.b.a.a;
import d0.z.d.m;
import java.util.Set;

/* JADX INFO: compiled from: TabsHostViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TabsHostViewModel$ViewState {
    private final int bottomNavHeight;
    private final long myUserId;
    private final int numFriendsNotifications;
    private final int numHomeNotifications;
    private final NavigationTab selectedTab;
    private final boolean showBottomNav;
    private final Set<NavigationTab> visibleTabs;

    /* JADX WARN: Multi-variable type inference failed */
    public TabsHostViewModel$ViewState(NavigationTab navigationTab, boolean z2, int i, long j, Set<? extends NavigationTab> set, int i2, int i3) {
        m.checkNotNullParameter(navigationTab, "selectedTab");
        m.checkNotNullParameter(set, "visibleTabs");
        this.selectedTab = navigationTab;
        this.showBottomNav = z2;
        this.bottomNavHeight = i;
        this.myUserId = j;
        this.visibleTabs = set;
        this.numHomeNotifications = i2;
        this.numFriendsNotifications = i3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TabsHostViewModel$ViewState copy$default(TabsHostViewModel$ViewState tabsHostViewModel$ViewState, NavigationTab navigationTab, boolean z2, int i, long j, Set set, int i2, int i3, int i4, Object obj) {
        return tabsHostViewModel$ViewState.copy((i4 & 1) != 0 ? tabsHostViewModel$ViewState.selectedTab : navigationTab, (i4 & 2) != 0 ? tabsHostViewModel$ViewState.showBottomNav : z2, (i4 & 4) != 0 ? tabsHostViewModel$ViewState.bottomNavHeight : i, (i4 & 8) != 0 ? tabsHostViewModel$ViewState.myUserId : j, (i4 & 16) != 0 ? tabsHostViewModel$ViewState.visibleTabs : set, (i4 & 32) != 0 ? tabsHostViewModel$ViewState.numHomeNotifications : i2, (i4 & 64) != 0 ? tabsHostViewModel$ViewState.numFriendsNotifications : i3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final NavigationTab getSelectedTab() {
        return this.selectedTab;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getShowBottomNav() {
        return this.showBottomNav;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getBottomNavHeight() {
        return this.bottomNavHeight;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final long getMyUserId() {
        return this.myUserId;
    }

    public final Set<NavigationTab> component5() {
        return this.visibleTabs;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final int getNumHomeNotifications() {
        return this.numHomeNotifications;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final int getNumFriendsNotifications() {
        return this.numFriendsNotifications;
    }

    public final TabsHostViewModel$ViewState copy(NavigationTab selectedTab, boolean showBottomNav, int bottomNavHeight, long myUserId, Set<? extends NavigationTab> visibleTabs, int numHomeNotifications, int numFriendsNotifications) {
        m.checkNotNullParameter(selectedTab, "selectedTab");
        m.checkNotNullParameter(visibleTabs, "visibleTabs");
        return new TabsHostViewModel$ViewState(selectedTab, showBottomNav, bottomNavHeight, myUserId, visibleTabs, numHomeNotifications, numFriendsNotifications);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TabsHostViewModel$ViewState)) {
            return false;
        }
        TabsHostViewModel$ViewState tabsHostViewModel$ViewState = (TabsHostViewModel$ViewState) other;
        return m.areEqual(this.selectedTab, tabsHostViewModel$ViewState.selectedTab) && this.showBottomNav == tabsHostViewModel$ViewState.showBottomNav && this.bottomNavHeight == tabsHostViewModel$ViewState.bottomNavHeight && this.myUserId == tabsHostViewModel$ViewState.myUserId && m.areEqual(this.visibleTabs, tabsHostViewModel$ViewState.visibleTabs) && this.numHomeNotifications == tabsHostViewModel$ViewState.numHomeNotifications && this.numFriendsNotifications == tabsHostViewModel$ViewState.numFriendsNotifications;
    }

    public final int getBottomNavHeight() {
        return this.bottomNavHeight;
    }

    public final long getMyUserId() {
        return this.myUserId;
    }

    public final int getNumFriendsNotifications() {
        return this.numFriendsNotifications;
    }

    public final int getNumHomeNotifications() {
        return this.numHomeNotifications;
    }

    public final NavigationTab getSelectedTab() {
        return this.selectedTab;
    }

    public final boolean getShowBottomNav() {
        return this.showBottomNav;
    }

    public final Set<NavigationTab> getVisibleTabs() {
        return this.visibleTabs;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v13 */
    public int hashCode() {
        NavigationTab navigationTab = this.selectedTab;
        int iHashCode = (navigationTab != null ? navigationTab.hashCode() : 0) * 31;
        boolean z2 = this.showBottomNav;
        ?? r2 = z2;
        if (z2) {
            r2 = 1;
        }
        int iA = (b.a(this.myUserId) + ((((iHashCode + r2) * 31) + this.bottomNavHeight) * 31)) * 31;
        Set<NavigationTab> set = this.visibleTabs;
        return ((((iA + (set != null ? set.hashCode() : 0)) * 31) + this.numHomeNotifications) * 31) + this.numFriendsNotifications;
    }

    public String toString() {
        StringBuilder sbU = a.U("ViewState(selectedTab=");
        sbU.append(this.selectedTab);
        sbU.append(", showBottomNav=");
        sbU.append(this.showBottomNav);
        sbU.append(", bottomNavHeight=");
        sbU.append(this.bottomNavHeight);
        sbU.append(", myUserId=");
        sbU.append(this.myUserId);
        sbU.append(", visibleTabs=");
        sbU.append(this.visibleTabs);
        sbU.append(", numHomeNotifications=");
        sbU.append(this.numHomeNotifications);
        sbU.append(", numFriendsNotifications=");
        return a.B(sbU, this.numFriendsNotifications, ")");
    }
}
