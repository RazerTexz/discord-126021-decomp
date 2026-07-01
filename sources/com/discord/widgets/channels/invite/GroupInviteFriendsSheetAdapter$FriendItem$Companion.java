package com.discord.widgets.channels.invite;

import com.discord.models.user.User;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: GroupInviteFriendsSheetAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GroupInviteFriendsSheetAdapter$FriendItem$Companion {
    private GroupInviteFriendsSheetAdapter$FriendItem$Companion() {
    }

    public final ArrayList<GroupInviteFriendsSheetAdapter$FriendItem> createItems(Collection<? extends User> users, Set<? extends User> checkedUsers) {
        m.checkNotNullParameter(users, "users");
        m.checkNotNullParameter(checkedUsers, "checkedUsers");
        ArrayList<GroupInviteFriendsSheetAdapter$FriendItem> arrayList = new ArrayList<>();
        for (User user : users) {
            arrayList.add(new GroupInviteFriendsSheetAdapter$FriendItem(user, checkedUsers.contains(user)));
        }
        return arrayList;
    }

    public /* synthetic */ GroupInviteFriendsSheetAdapter$FriendItem$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
