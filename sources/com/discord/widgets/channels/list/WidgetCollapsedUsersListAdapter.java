package com.discord.widgets.channels.list;

import android.content.Context;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;
import com.discord.R$layout;
import com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.widgets.channels.list.items.CollapsedUser;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetCollapsedUsersListAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetCollapsedUsersListAdapter extends MGRecyclerAdapterSimple<CollapsedUser> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetCollapsedUsersListAdapter(RecyclerView recyclerView) {
        super(recyclerView, false, 2, null);
        m.checkNotNullParameter(recyclerView, "recycler");
        Context context = recyclerView.getContext();
        m.checkNotNullExpressionValue(context, "recycler.context");
        recyclerView.addItemDecoration(new WidgetCollapsedUsersListAdapter$OverlapDecoration(-context.getResources().getDimensionPixelSize(2131165286)));
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public /* bridge */ /* synthetic */ RecyclerView$ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return onCreateViewHolder(viewGroup, i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public MGRecyclerViewHolder<?, CollapsedUser> onCreateViewHolder(ViewGroup parent, int viewType) {
        m.checkNotNullParameter(parent, "parent");
        return new WidgetCollapsedUsersListAdapter$WidgetCollapsedUserListItem(R$layout.widget_collapsed_voice_user_list_item, this);
    }
}
