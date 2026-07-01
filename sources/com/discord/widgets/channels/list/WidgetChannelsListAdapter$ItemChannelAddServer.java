package com.discord.widgets.channels.list;

import com.discord.databinding.WidgetChannelsListItemDirectoryBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.widgets.channels.list.items.ChannelListItem;
import com.discord.widgets.channels.list.items.ChannelListItemAddServer;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetChannelsListAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelsListAdapter$ItemChannelAddServer extends WidgetChannelsListAdapter$Item {
    private final WidgetChannelsListItemDirectoryBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChannelsListAdapter$ItemChannelAddServer(int i, WidgetChannelsListAdapter widgetChannelsListAdapter) {
        super(i, widgetChannelsListAdapter);
        m.checkNotNullParameter(widgetChannelsListAdapter, "adapter");
        WidgetChannelsListItemDirectoryBinding widgetChannelsListItemDirectoryBindingA = WidgetChannelsListItemDirectoryBinding.a(this.itemView);
        m.checkNotNullExpressionValue(widgetChannelsListItemDirectoryBindingA, "WidgetChannelsListItemDi…oryBinding.bind(itemView)");
        this.binding = widgetChannelsListItemDirectoryBindingA;
    }

    public static final /* synthetic */ WidgetChannelsListAdapter access$getAdapter$p(WidgetChannelsListAdapter$ItemChannelAddServer widgetChannelsListAdapter$ItemChannelAddServer) {
        return (WidgetChannelsListAdapter) widgetChannelsListAdapter$ItemChannelAddServer.adapter;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public /* bridge */ /* synthetic */ void onConfigure(int i, ChannelListItem channelListItem) {
        onConfigure2(i, channelListItem);
    }

    /* JADX INFO: renamed from: onConfigure, reason: avoid collision after fix types in other method */
    public void onConfigure2(int position, ChannelListItem data) {
        m.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        if (data instanceof ChannelListItemAddServer) {
            this.binding.c.setText(2131891851);
            this.binding.f2291b.setImageResource(2131231500);
            this.binding.a.setOnClickListener(new WidgetChannelsListAdapter$ItemChannelAddServer$onConfigure$$inlined$apply$lambda$1(this));
        }
    }
}
