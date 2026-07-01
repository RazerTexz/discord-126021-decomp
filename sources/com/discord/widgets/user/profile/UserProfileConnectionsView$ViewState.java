package com.discord.widgets.user.profile;

import b.d.b.a.a;
import d0.z.d.m;
import java.util.List;

/* JADX INFO: compiled from: UserProfileConnectionsView.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class UserProfileConnectionsView$ViewState {
    private final List<UserProfileConnectionsView$ConnectedAccountItem> connectedAccountItems;
    private final boolean showConnectionsSection;
    private final boolean showMutualGuildsAndFriends;

    public UserProfileConnectionsView$ViewState(boolean z2, boolean z3, List<UserProfileConnectionsView$ConnectedAccountItem> list) {
        m.checkNotNullParameter(list, "connectedAccountItems");
        this.showConnectionsSection = z2;
        this.showMutualGuildsAndFriends = z3;
        this.connectedAccountItems = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ UserProfileConnectionsView$ViewState copy$default(UserProfileConnectionsView$ViewState userProfileConnectionsView$ViewState, boolean z2, boolean z3, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = userProfileConnectionsView$ViewState.showConnectionsSection;
        }
        if ((i & 2) != 0) {
            z3 = userProfileConnectionsView$ViewState.showMutualGuildsAndFriends;
        }
        if ((i & 4) != 0) {
            list = userProfileConnectionsView$ViewState.connectedAccountItems;
        }
        return userProfileConnectionsView$ViewState.copy(z2, z3, list);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getShowConnectionsSection() {
        return this.showConnectionsSection;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getShowMutualGuildsAndFriends() {
        return this.showMutualGuildsAndFriends;
    }

    public final List<UserProfileConnectionsView$ConnectedAccountItem> component3() {
        return this.connectedAccountItems;
    }

    public final UserProfileConnectionsView$ViewState copy(boolean showConnectionsSection, boolean showMutualGuildsAndFriends, List<UserProfileConnectionsView$ConnectedAccountItem> connectedAccountItems) {
        m.checkNotNullParameter(connectedAccountItems, "connectedAccountItems");
        return new UserProfileConnectionsView$ViewState(showConnectionsSection, showMutualGuildsAndFriends, connectedAccountItems);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UserProfileConnectionsView$ViewState)) {
            return false;
        }
        UserProfileConnectionsView$ViewState userProfileConnectionsView$ViewState = (UserProfileConnectionsView$ViewState) other;
        return this.showConnectionsSection == userProfileConnectionsView$ViewState.showConnectionsSection && this.showMutualGuildsAndFriends == userProfileConnectionsView$ViewState.showMutualGuildsAndFriends && m.areEqual(this.connectedAccountItems, userProfileConnectionsView$ViewState.connectedAccountItems);
    }

    public final List<UserProfileConnectionsView$ConnectedAccountItem> getConnectedAccountItems() {
        return this.connectedAccountItems;
    }

    public final boolean getShowConnectionsSection() {
        return this.showConnectionsSection;
    }

    public final boolean getShowMutualGuildsAndFriends() {
        return this.showMutualGuildsAndFriends;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v6 */
    public int hashCode() {
        boolean z2 = this.showConnectionsSection;
        ?? r0 = z2;
        if (z2) {
            r0 = 1;
        }
        int i = r0 * 31;
        boolean z3 = this.showMutualGuildsAndFriends;
        int i2 = (i + (z3 ? 1 : z3)) * 31;
        List<UserProfileConnectionsView$ConnectedAccountItem> list = this.connectedAccountItems;
        return i2 + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("ViewState(showConnectionsSection=");
        sbU.append(this.showConnectionsSection);
        sbU.append(", showMutualGuildsAndFriends=");
        sbU.append(this.showMutualGuildsAndFriends);
        sbU.append(", connectedAccountItems=");
        return a.L(sbU, this.connectedAccountItems, ")");
    }
}
