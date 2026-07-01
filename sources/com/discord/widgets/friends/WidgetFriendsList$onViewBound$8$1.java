package com.discord.widgets.friends;

import android.view.MenuItem;
import android.view.MenuItem$OnMenuItemClickListener;

/* JADX INFO: compiled from: WidgetFriendsList.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetFriendsList$onViewBound$8$1 implements MenuItem$OnMenuItemClickListener {
    public final /* synthetic */ WidgetFriendsList$onViewBound$8 this$0;

    public WidgetFriendsList$onViewBound$8$1(WidgetFriendsList$onViewBound$8 widgetFriendsList$onViewBound$8) {
        this.this$0 = widgetFriendsList$onViewBound$8;
    }

    @Override // android.view.MenuItem$OnMenuItemClickListener
    public final boolean onMenuItemClick(MenuItem menuItem) {
        WidgetFriendsList.access$getViewModel$p(this.this$0.this$0).dismissContactSyncUpsell();
        return true;
    }
}
