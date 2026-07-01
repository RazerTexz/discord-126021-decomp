package com.discord.widgets.channels.list;

import android.view.View;
import com.discord.databinding.WidgetChannelsListItemDirectoryBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.widgets.channels.list.items.ChannelListItem;
import com.discord.widgets.channels.list.items.ChannelListItemInvite;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetChannelsListAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelsListAdapter$ItemInvite extends WidgetChannelsListAdapter$Item {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChannelsListAdapter$ItemInvite(int i, WidgetChannelsListAdapter widgetChannelsListAdapter) {
        super(i, widgetChannelsListAdapter);
        m.checkNotNullParameter(widgetChannelsListAdapter, "adapter");
    }

    public static final /* synthetic */ WidgetChannelsListAdapter access$getAdapter$p(WidgetChannelsListAdapter$ItemInvite widgetChannelsListAdapter$ItemInvite) {
        return (WidgetChannelsListAdapter) widgetChannelsListAdapter$ItemInvite.adapter;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public /* bridge */ /* synthetic */ void onConfigure(int i, ChannelListItem channelListItem) {
        onConfigure2(i, channelListItem);
    }

    /* JADX INFO: renamed from: onConfigure, reason: avoid collision after fix types in other method */
    public void onConfigure2(int position, ChannelListItem data) {
        m.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        if (data instanceof ChannelListItemInvite) {
            this.itemView.setOnClickListener(new WidgetChannelsListAdapter$ItemInvite$onConfigure$1(this, data));
            View view = this.itemView;
            m.checkNotNullExpressionValue(view, "itemView");
            ViewExtensions.setOnLongClickListenerConsumeClick(view, new WidgetChannelsListAdapter$ItemInvite$onConfigure$2(this));
            if (((ChannelListItemInvite) data).isHub()) {
                WidgetChannelsListItemDirectoryBinding widgetChannelsListItemDirectoryBindingA = WidgetChannelsListItemDirectoryBinding.a(this.itemView);
                m.checkNotNullExpressionValue(widgetChannelsListItemDirectoryBindingA, "WidgetChannelsListItemDi…oryBinding.bind(itemView)");
                widgetChannelsListItemDirectoryBindingA.c.setText(2131892215);
                widgetChannelsListItemDirectoryBindingA.f2291b.setImageResource(2131231835);
            }
        }
    }
}
