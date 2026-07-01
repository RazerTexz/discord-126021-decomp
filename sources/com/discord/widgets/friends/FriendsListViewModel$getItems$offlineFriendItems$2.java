package com.discord.widgets.friends;

import com.discord.utilities.user.UserUtils;
import java.util.Comparator;

/* JADX INFO: compiled from: FriendsListViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class FriendsListViewModel$getItems$offlineFriendItems$2<T> implements Comparator<FriendsListViewModel$Item$Friend> {
    public static final FriendsListViewModel$getItems$offlineFriendItems$2 INSTANCE = new FriendsListViewModel$getItems$offlineFriendItems$2();

    @Override // java.util.Comparator
    public /* bridge */ /* synthetic */ int compare(FriendsListViewModel$Item$Friend friendsListViewModel$Item$Friend, FriendsListViewModel$Item$Friend friendsListViewModel$Item$Friend2) {
        return compare2(friendsListViewModel$Item$Friend, friendsListViewModel$Item$Friend2);
    }

    /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
    public final int compare2(FriendsListViewModel$Item$Friend friendsListViewModel$Item$Friend, FriendsListViewModel$Item$Friend friendsListViewModel$Item$Friend2) {
        return UserUtils.INSTANCE.compareUserNames(friendsListViewModel$Item$Friend.getUser(), friendsListViewModel$Item$Friend2.getUser());
    }
}
