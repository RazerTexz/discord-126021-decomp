package com.discord.widgets.channels.list;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import b.a.k.b;
import com.discord.R$id;
import com.discord.databinding.WidgetChannelsListItemAudienceCountBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.widgets.channels.list.items.ChannelListItem;
import com.discord.widgets.channels.list.items.ChannelListItemStageAudienceCount;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetChannelsListAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelsListAdapter$ItemStageChannelAudienceCount extends WidgetChannelsListAdapter$Item {
    private final WidgetChannelsListItemAudienceCountBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChannelsListAdapter$ItemStageChannelAudienceCount(int i, WidgetChannelsListAdapter widgetChannelsListAdapter) {
        super(i, widgetChannelsListAdapter);
        m.checkNotNullParameter(widgetChannelsListAdapter, "adapter");
        View view = this.itemView;
        int i2 = R$id.stage_channel_audience_icon;
        ImageView imageView = (ImageView) view.findViewById(R$id.stage_channel_audience_icon);
        if (imageView != null) {
            i2 = R$id.stage_channels_audience_count;
            TextView textView = (TextView) view.findViewById(R$id.stage_channels_audience_count);
            if (textView != null) {
                WidgetChannelsListItemAudienceCountBinding widgetChannelsListItemAudienceCountBinding = new WidgetChannelsListItemAudienceCountBinding((RelativeLayout) view, imageView, textView);
                m.checkNotNullExpressionValue(widgetChannelsListItemAudienceCountBinding, "WidgetChannelsListItemAu…untBinding.bind(itemView)");
                this.binding = widgetChannelsListItemAudienceCountBinding;
                return;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i2)));
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public /* bridge */ /* synthetic */ void onConfigure(int i, ChannelListItem channelListItem) {
        onConfigure2(i, channelListItem);
    }

    /* JADX INFO: renamed from: onConfigure, reason: avoid collision after fix types in other method */
    public void onConfigure2(int position, ChannelListItem data) {
        m.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        ChannelListItemStageAudienceCount channelListItemStageAudienceCount = (ChannelListItemStageAudienceCount) data;
        TextView textView = this.binding.f2285b;
        if (channelListItemStageAudienceCount.getAudienceSize() != 0) {
            b.n(textView, 2131895777, new Object[]{Integer.valueOf(channelListItemStageAudienceCount.getAudienceSize())}, null, 4);
        } else {
            textView.setText(2131895797);
        }
    }
}
