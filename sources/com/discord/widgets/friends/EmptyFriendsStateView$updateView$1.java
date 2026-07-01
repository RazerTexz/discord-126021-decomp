package com.discord.widgets.friends;

import android.content.Context;
import android.view.View;
import android.view.View$OnClickListener;
import d0.z.d.m;

/* JADX INFO: compiled from: EmptyFriendsStateView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class EmptyFriendsStateView$updateView$1 implements View$OnClickListener {
    public final /* synthetic */ String $addFriendSource;
    public final /* synthetic */ EmptyFriendsStateView this$0;

    public EmptyFriendsStateView$updateView$1(EmptyFriendsStateView emptyFriendsStateView, String str) {
        this.this$0 = emptyFriendsStateView;
        this.$addFriendSource = str;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetFriendsAdd$Companion widgetFriendsAdd$Companion = WidgetFriendsAdd.Companion;
        Context context = this.this$0.getContext();
        m.checkNotNullExpressionValue(context, "context");
        WidgetFriendsAdd$Companion.show$default(widgetFriendsAdd$Companion, context, null, this.$addFriendSource, 2, null);
    }
}
