package com.discord.widgets.guilds.list;

import android.view.View;
import android.view.View$OnClickListener;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetGuildListAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildListAdapter$onBindViewHolder$1 implements View$OnClickListener {
    public final /* synthetic */ GuildListViewHolder $holder;
    public final /* synthetic */ GuildListItem $item;
    public final /* synthetic */ WidgetGuildListAdapter this$0;

    public WidgetGuildListAdapter$onBindViewHolder$1(WidgetGuildListAdapter widgetGuildListAdapter, GuildListViewHolder guildListViewHolder, GuildListItem guildListItem) {
        this.this$0 = widgetGuildListAdapter;
        this.$holder = guildListViewHolder;
        this.$item = guildListItem;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetGuildListAdapter$InteractionListener widgetGuildListAdapter$InteractionListenerAccess$getInteractionListener$p = WidgetGuildListAdapter.access$getInteractionListener$p(this.this$0);
        View view2 = this.$holder.itemView;
        m.checkNotNullExpressionValue(view2, "holder.itemView");
        widgetGuildListAdapter$InteractionListenerAccess$getInteractionListener$p.onItemClicked(view2, this.$item);
    }
}
