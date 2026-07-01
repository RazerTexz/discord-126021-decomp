package com.discord.widgets.friends;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: WidgetFriendsListAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetFriendsListAdapter$ItemSuggestedFriendHeader$onConfigure$2 implements View$OnClickListener {
    public final /* synthetic */ WidgetFriendsListAdapter$ItemSuggestedFriendHeader this$0;

    public WidgetFriendsListAdapter$ItemSuggestedFriendHeader$onConfigure$2(WidgetFriendsListAdapter$ItemSuggestedFriendHeader widgetFriendsListAdapter$ItemSuggestedFriendHeader) {
        this.this$0 = widgetFriendsListAdapter$ItemSuggestedFriendHeader;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetFriendsListAdapter$ItemSuggestedFriendHeader.access$getAdapter$p(this.this$0).getOnClickSuggestedHeaderExpandCollapse().invoke();
    }
}
