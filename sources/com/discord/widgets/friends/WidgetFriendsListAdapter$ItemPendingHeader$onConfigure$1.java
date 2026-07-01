package com.discord.widgets.friends;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: WidgetFriendsListAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetFriendsListAdapter$ItemPendingHeader$onConfigure$1 implements View$OnClickListener {
    public final /* synthetic */ WidgetFriendsListAdapter$ItemPendingHeader this$0;

    public WidgetFriendsListAdapter$ItemPendingHeader$onConfigure$1(WidgetFriendsListAdapter$ItemPendingHeader widgetFriendsListAdapter$ItemPendingHeader) {
        this.this$0 = widgetFriendsListAdapter$ItemPendingHeader;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetFriendsListAdapter$ItemPendingHeader.access$getAdapter$p(this.this$0).getOnClickPendingHeaderExpand().invoke();
    }
}
