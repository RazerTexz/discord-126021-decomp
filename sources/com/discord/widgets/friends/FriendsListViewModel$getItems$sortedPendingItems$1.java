package com.discord.widgets.friends;

import com.discord.utilities.user.UserUtils;
import java.util.Comparator;

/* JADX INFO: compiled from: FriendsListViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class FriendsListViewModel$getItems$sortedPendingItems$1<T> implements Comparator<FriendsListViewModel$Item$PendingFriendRequest> {
    public static final FriendsListViewModel$getItems$sortedPendingItems$1 INSTANCE = new FriendsListViewModel$getItems$sortedPendingItems$1();

    @Override // java.util.Comparator
    public /* bridge */ /* synthetic */ int compare(FriendsListViewModel$Item$PendingFriendRequest friendsListViewModel$Item$PendingFriendRequest, FriendsListViewModel$Item$PendingFriendRequest friendsListViewModel$Item$PendingFriendRequest2) {
        return compare2(friendsListViewModel$Item$PendingFriendRequest, friendsListViewModel$Item$PendingFriendRequest2);
    }

    /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
    public final int compare2(FriendsListViewModel$Item$PendingFriendRequest friendsListViewModel$Item$PendingFriendRequest, FriendsListViewModel$Item$PendingFriendRequest friendsListViewModel$Item$PendingFriendRequest2) {
        if (friendsListViewModel$Item$PendingFriendRequest.getRelationshipType() == 3 && friendsListViewModel$Item$PendingFriendRequest2.getRelationshipType() == 4) {
            return -1;
        }
        if (friendsListViewModel$Item$PendingFriendRequest.getRelationshipType() == 4 && friendsListViewModel$Item$PendingFriendRequest2.getRelationshipType() == 3) {
            return 1;
        }
        return UserUtils.INSTANCE.compareUserNames(friendsListViewModel$Item$PendingFriendRequest.getUser(), friendsListViewModel$Item$PendingFriendRequest2.getUser());
    }
}
