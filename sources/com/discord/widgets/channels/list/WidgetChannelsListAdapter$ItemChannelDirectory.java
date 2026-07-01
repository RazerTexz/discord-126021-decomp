package com.discord.widgets.channels.list;

import android.widget.LinearLayout;
import android.widget.TextView;
import b.a.k.b;
import com.discord.api.channel.ChannelUtils;
import com.discord.databinding.WidgetChannelsListItemDirectoryBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.widgets.channels.list.items.ChannelListItem;
import com.discord.widgets.channels.list.items.ChannelListItemDirectory;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetChannelsListAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelsListAdapter$ItemChannelDirectory extends WidgetChannelsListAdapter$Item {
    private final WidgetChannelsListItemDirectoryBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChannelsListAdapter$ItemChannelDirectory(int i, WidgetChannelsListAdapter widgetChannelsListAdapter) {
        super(i, widgetChannelsListAdapter);
        m.checkNotNullParameter(widgetChannelsListAdapter, "adapter");
        WidgetChannelsListItemDirectoryBinding widgetChannelsListItemDirectoryBindingA = WidgetChannelsListItemDirectoryBinding.a(this.itemView);
        m.checkNotNullExpressionValue(widgetChannelsListItemDirectoryBindingA, "WidgetChannelsListItemDi…oryBinding.bind(itemView)");
        this.binding = widgetChannelsListItemDirectoryBindingA;
    }

    public static final /* synthetic */ WidgetChannelsListAdapter access$getAdapter$p(WidgetChannelsListAdapter$ItemChannelDirectory widgetChannelsListAdapter$ItemChannelDirectory) {
        return (WidgetChannelsListAdapter) widgetChannelsListAdapter$ItemChannelDirectory.adapter;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public /* bridge */ /* synthetic */ void onConfigure(int i, ChannelListItem channelListItem) {
        onConfigure2(i, channelListItem);
    }

    /* JADX INFO: renamed from: onConfigure, reason: avoid collision after fix types in other method */
    public void onConfigure2(int position, ChannelListItem data) {
        m.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        ChannelListItemDirectory channelListItemDirectory = (ChannelListItemDirectory) data;
        boolean zX = ChannelUtils.x(channelListItemDirectory.getChannel());
        if (zX) {
            TextView textView = this.binding.c;
            m.checkNotNullExpressionValue(textView, "binding.directoryChannelName");
            String name = channelListItemDirectory.getChannel().getName();
            if (name == null) {
                name = "";
            }
            textView.setText(name);
        } else {
            this.binding.c.setText(2131891853);
        }
        this.binding.f2291b.setImageResource(zX ? 2131231874 : 2131231687);
        TextView textView2 = this.binding.d;
        m.checkNotNullExpressionValue(textView2, "binding.directoryChannelUnreadCount");
        b.a(textView2, channelListItemDirectory.getUnreadCount() > 0 ? String.valueOf(channelListItemDirectory.getUnreadCount()) : null);
        LinearLayout linearLayout = this.binding.a;
        linearLayout.setOnClickListener(new WidgetChannelsListAdapter$ItemChannelDirectory$onConfigure$$inlined$apply$lambda$1(this, channelListItemDirectory));
        linearLayout.setSelected(channelListItemDirectory.getSelected());
    }
}
