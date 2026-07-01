package com.discord.widgets.channels.invite;

import b.d.b.a.a;
import com.discord.models.user.User;
import d0.z.d.m;
import java.util.HashSet;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: GroupInviteFriendsSheetViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class GroupInviteFriendsSheetViewModel$ViewState {
    private final HashSet<User> checkedUsers;
    private final List<GroupInviteFriendsSheetAdapter$FriendItem> friendItems;
    private final boolean showSearchIcon;

    public GroupInviteFriendsSheetViewModel$ViewState(HashSet<User> hashSet, List<GroupInviteFriendsSheetAdapter$FriendItem> list, boolean z2) {
        m.checkNotNullParameter(hashSet, "checkedUsers");
        m.checkNotNullParameter(list, "friendItems");
        this.checkedUsers = hashSet;
        this.friendItems = list;
        this.showSearchIcon = z2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GroupInviteFriendsSheetViewModel$ViewState copy$default(GroupInviteFriendsSheetViewModel$ViewState groupInviteFriendsSheetViewModel$ViewState, HashSet hashSet, List list, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            hashSet = groupInviteFriendsSheetViewModel$ViewState.checkedUsers;
        }
        if ((i & 2) != 0) {
            list = groupInviteFriendsSheetViewModel$ViewState.friendItems;
        }
        if ((i & 4) != 0) {
            z2 = groupInviteFriendsSheetViewModel$ViewState.showSearchIcon;
        }
        return groupInviteFriendsSheetViewModel$ViewState.copy(hashSet, list, z2);
    }

    public final HashSet<User> component1() {
        return this.checkedUsers;
    }

    public final List<GroupInviteFriendsSheetAdapter$FriendItem> component2() {
        return this.friendItems;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getShowSearchIcon() {
        return this.showSearchIcon;
    }

    public final GroupInviteFriendsSheetViewModel$ViewState copy(HashSet<User> checkedUsers, List<GroupInviteFriendsSheetAdapter$FriendItem> friendItems, boolean showSearchIcon) {
        m.checkNotNullParameter(checkedUsers, "checkedUsers");
        m.checkNotNullParameter(friendItems, "friendItems");
        return new GroupInviteFriendsSheetViewModel$ViewState(checkedUsers, friendItems, showSearchIcon);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GroupInviteFriendsSheetViewModel$ViewState)) {
            return false;
        }
        GroupInviteFriendsSheetViewModel$ViewState groupInviteFriendsSheetViewModel$ViewState = (GroupInviteFriendsSheetViewModel$ViewState) other;
        return m.areEqual(this.checkedUsers, groupInviteFriendsSheetViewModel$ViewState.checkedUsers) && m.areEqual(this.friendItems, groupInviteFriendsSheetViewModel$ViewState.friendItems) && this.showSearchIcon == groupInviteFriendsSheetViewModel$ViewState.showSearchIcon;
    }

    public final HashSet<User> getCheckedUsers() {
        return this.checkedUsers;
    }

    public final List<GroupInviteFriendsSheetAdapter$FriendItem> getFriendItems() {
        return this.friendItems;
    }

    public final boolean getShowSearchIcon() {
        return this.showSearchIcon;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v6 */
    public int hashCode() {
        HashSet<User> hashSet = this.checkedUsers;
        int iHashCode = (hashSet != null ? hashSet.hashCode() : 0) * 31;
        List<GroupInviteFriendsSheetAdapter$FriendItem> list = this.friendItems;
        int iHashCode2 = (iHashCode + (list != null ? list.hashCode() : 0)) * 31;
        boolean z2 = this.showSearchIcon;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        return iHashCode2 + r1;
    }

    public String toString() {
        StringBuilder sbU = a.U("ViewState(checkedUsers=");
        sbU.append(this.checkedUsers);
        sbU.append(", friendItems=");
        sbU.append(this.friendItems);
        sbU.append(", showSearchIcon=");
        return a.O(sbU, this.showSearchIcon, ")");
    }

    public /* synthetic */ GroupInviteFriendsSheetViewModel$ViewState(HashSet hashSet, List list, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(hashSet, list, (i & 4) != 0 ? true : z2);
    }
}
