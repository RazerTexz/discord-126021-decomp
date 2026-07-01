package com.discord.widgets.channels.invite;

import b.d.b.a.a;
import com.discord.models.user.User;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import d0.z.d.m;

/* JADX INFO: compiled from: GroupInviteFriendsSheetAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class GroupInviteFriendsSheetAdapter$FriendItem implements MGRecyclerDataPayload {
    public static final GroupInviteFriendsSheetAdapter$FriendItem$Companion Companion = new GroupInviteFriendsSheetAdapter$FriendItem$Companion(null);
    public static final int TYPE_FRIEND = 0;
    private final boolean isSelected;
    private final String key;
    private final int type;
    private final User user;

    public GroupInviteFriendsSheetAdapter$FriendItem(User user, boolean z2) {
        m.checkNotNullParameter(user, "user");
        this.user = user;
        this.isSelected = z2;
        this.key = String.valueOf(user.getId());
    }

    public static /* synthetic */ GroupInviteFriendsSheetAdapter$FriendItem copy$default(GroupInviteFriendsSheetAdapter$FriendItem groupInviteFriendsSheetAdapter$FriendItem, User user, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            user = groupInviteFriendsSheetAdapter$FriendItem.user;
        }
        if ((i & 2) != 0) {
            z2 = groupInviteFriendsSheetAdapter$FriendItem.isSelected;
        }
        return groupInviteFriendsSheetAdapter$FriendItem.copy(user, z2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final User getUser() {
        return this.user;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getIsSelected() {
        return this.isSelected;
    }

    public final GroupInviteFriendsSheetAdapter$FriendItem copy(User user, boolean isSelected) {
        m.checkNotNullParameter(user, "user");
        return new GroupInviteFriendsSheetAdapter$FriendItem(user, isSelected);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GroupInviteFriendsSheetAdapter$FriendItem)) {
            return false;
        }
        GroupInviteFriendsSheetAdapter$FriendItem groupInviteFriendsSheetAdapter$FriendItem = (GroupInviteFriendsSheetAdapter$FriendItem) other;
        return m.areEqual(this.user, groupInviteFriendsSheetAdapter$FriendItem.user) && this.isSelected == groupInviteFriendsSheetAdapter$FriendItem.isSelected;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return this.key;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
    public int getType() {
        return this.type;
    }

    public final User getUser() {
        return this.user;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    public int hashCode() {
        User user = this.user;
        int iHashCode = (user != null ? user.hashCode() : 0) * 31;
        boolean z2 = this.isSelected;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        return iHashCode + r1;
    }

    public final boolean isSelected() {
        return this.isSelected;
    }

    public String toString() {
        StringBuilder sbU = a.U("FriendItem(user=");
        sbU.append(this.user);
        sbU.append(", isSelected=");
        return a.O(sbU, this.isSelected, ")");
    }
}
