package com.discord.widgets.friends;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: WidgetFriendsListAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetFriendsListAdapter$ItemPendingUser$onConfigure$3 implements View$OnClickListener {
    public final /* synthetic */ FriendsListViewModel$Item$PendingFriendRequest $item;
    public final /* synthetic */ WidgetFriendsListAdapter$ItemPendingUser this$0;

    public WidgetFriendsListAdapter$ItemPendingUser$onConfigure$3(WidgetFriendsListAdapter$ItemPendingUser widgetFriendsListAdapter$ItemPendingUser, FriendsListViewModel$Item$PendingFriendRequest friendsListViewModel$Item$PendingFriendRequest) {
        this.this$0 = widgetFriendsListAdapter$ItemPendingUser;
        this.$item = friendsListViewModel$Item$PendingFriendRequest;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetFriendsListAdapter$ItemPendingUser.access$getAdapter$p(this.this$0).getOnClickDeclineFriend().invoke(this.$item.getUser(), Integer.valueOf(this.$item.getRelationshipType()));
    }
}
