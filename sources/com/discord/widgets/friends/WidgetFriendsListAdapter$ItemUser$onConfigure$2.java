package com.discord.widgets.friends;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: WidgetFriendsListAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetFriendsListAdapter$ItemUser$onConfigure$2 implements View$OnClickListener {
    public final /* synthetic */ FriendsListViewModel$Item$Friend $item;
    public final /* synthetic */ WidgetFriendsListAdapter$ItemUser this$0;

    public WidgetFriendsListAdapter$ItemUser$onConfigure$2(WidgetFriendsListAdapter$ItemUser widgetFriendsListAdapter$ItemUser, FriendsListViewModel$Item$Friend friendsListViewModel$Item$Friend) {
        this.this$0 = widgetFriendsListAdapter$ItemUser;
        this.$item = friendsListViewModel$Item$Friend;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetFriendsListAdapter$ItemUser.access$getAdapter$p(this.this$0).getOnClickCall().invoke(this.$item.getUser());
    }
}
