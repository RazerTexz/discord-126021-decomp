package com.discord.widgets.friends;

import android.view.View;
import androidx.annotation.LayoutRes;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetFriendsListAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class WidgetFriendsListAdapter$Item extends MGRecyclerViewHolder<WidgetFriendsListAdapter, FriendsListViewModel$Item> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetFriendsListAdapter$Item(@LayoutRes int i, WidgetFriendsListAdapter widgetFriendsListAdapter) {
        super(i, widgetFriendsListAdapter);
        m.checkNotNullParameter(widgetFriendsListAdapter, "adapter");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetFriendsListAdapter$Item(View view, WidgetFriendsListAdapter widgetFriendsListAdapter) {
        super(view, widgetFriendsListAdapter);
        m.checkNotNullParameter(view, "view");
        m.checkNotNullParameter(widgetFriendsListAdapter, "adapter");
    }
}
