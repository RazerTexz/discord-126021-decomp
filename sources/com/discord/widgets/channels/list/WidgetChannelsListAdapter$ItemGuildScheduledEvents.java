package com.discord.widgets.channels.list;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import com.discord.R$id;
import com.discord.databinding.WidgetChannelsListItemGuildScheduledEventsBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.drawable.DrawableCompat;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.widgets.channels.list.items.ChannelListItem;
import com.discord.widgets.channels.list.items.ChannelListItemGuildScheduledEvents;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetChannelsListAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelsListAdapter$ItemGuildScheduledEvents extends WidgetChannelsListAdapter$Item {
    private final WidgetChannelsListItemGuildScheduledEventsBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChannelsListAdapter$ItemGuildScheduledEvents(int i, WidgetChannelsListAdapter widgetChannelsListAdapter) {
        super(i, widgetChannelsListAdapter);
        m.checkNotNullParameter(widgetChannelsListAdapter, "adapter");
        View view = this.itemView;
        int i2 = R$id.channels_list_item_guild_scheduled_event_count;
        TextView textView = (TextView) view.findViewById(R$id.channels_list_item_guild_scheduled_event_count);
        if (textView != null) {
            i2 = R$id.channels_list_item_guild_scheduled_event_icon;
            ImageView imageView = (ImageView) view.findViewById(R$id.channels_list_item_guild_scheduled_event_icon);
            if (imageView != null) {
                i2 = R$id.channels_list_item_guild_scheduled_event_label;
                TextView textView2 = (TextView) view.findViewById(R$id.channels_list_item_guild_scheduled_event_label);
                if (textView2 != null) {
                    WidgetChannelsListItemGuildScheduledEventsBinding widgetChannelsListItemGuildScheduledEventsBinding = new WidgetChannelsListItemGuildScheduledEventsBinding((ConstraintLayout) view, textView, imageView, textView2);
                    m.checkNotNullExpressionValue(widgetChannelsListItemGuildScheduledEventsBinding, "WidgetChannelsListItemGu…ntsBinding.bind(itemView)");
                    this.binding = widgetChannelsListItemGuildScheduledEventsBinding;
                    return;
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i2)));
    }

    public static final /* synthetic */ WidgetChannelsListAdapter access$getAdapter$p(WidgetChannelsListAdapter$ItemGuildScheduledEvents widgetChannelsListAdapter$ItemGuildScheduledEvents) {
        return (WidgetChannelsListAdapter) widgetChannelsListAdapter$ItemGuildScheduledEvents.adapter;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public /* bridge */ /* synthetic */ void onConfigure(int i, ChannelListItem channelListItem) {
        onConfigure2(i, channelListItem);
    }

    /* JADX INFO: renamed from: onConfigure, reason: avoid collision after fix types in other method */
    public void onConfigure2(int position, ChannelListItem data) {
        m.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        ChannelListItemGuildScheduledEvents channelListItemGuildScheduledEvents = (ChannelListItemGuildScheduledEvents) data;
        View view = this.itemView;
        m.checkNotNullExpressionValue(view, "itemView");
        Context context = view.getContext();
        TextView textView = this.binding.f2294b;
        m.checkNotNullExpressionValue(textView, "binding.channelsListItemGuildScheduledEventCount");
        textView.setVisibility(channelListItemGuildScheduledEvents.getData().isEmpty() ^ true ? 0 : 8);
        TextView textView2 = this.binding.f2294b;
        m.checkNotNullExpressionValue(textView2, "binding.channelsListItemGuildScheduledEventCount");
        textView2.setText(String.valueOf(channelListItemGuildScheduledEvents.getData().size()));
        ConstraintLayout constraintLayout = this.binding.a;
        m.checkNotNullExpressionValue(constraintLayout, "binding.root");
        m.checkNotNullExpressionValue(context, "context");
        ViewExtensions.setBackgroundAndKeepPadding(constraintLayout, ContextCompat.getDrawable(context, DrawableCompat.getThemedDrawableRes$default(context, 2130969277, 0, 2, (Object) null)));
        this.binding.a.setOnClickListener(new WidgetChannelsListAdapter$ItemGuildScheduledEvents$onConfigure$1(this, channelListItemGuildScheduledEvents));
    }
}
