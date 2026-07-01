package com.discord.widgets.channels.list;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.discord.R$id;
import com.discord.databinding.WidgetChannelsListItemHeaderBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.widgets.channels.list.items.ChannelListItem;
import com.discord.widgets.channels.list.items.ChannelListItemHeader;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetChannelsListAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelsListAdapter$ItemHeader extends WidgetChannelsListAdapter$Item {
    private final WidgetChannelsListItemHeaderBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChannelsListAdapter$ItemHeader(int i, WidgetChannelsListAdapter widgetChannelsListAdapter) {
        super(i, widgetChannelsListAdapter);
        m.checkNotNullParameter(widgetChannelsListAdapter, "adapter");
        View view = this.itemView;
        int i2 = R$id.channels_list_item_header;
        TextView textView = (TextView) view.findViewById(R$id.channels_list_item_header);
        if (textView != null) {
            i2 = R$id.channels_list_new;
            ImageView imageView = (ImageView) view.findViewById(R$id.channels_list_new);
            if (imageView != null) {
                WidgetChannelsListItemHeaderBinding widgetChannelsListItemHeaderBinding = new WidgetChannelsListItemHeaderBinding((RelativeLayout) view, textView, imageView);
                m.checkNotNullExpressionValue(widgetChannelsListItemHeaderBinding, "WidgetChannelsListItemHeaderBinding.bind(itemView)");
                this.binding = widgetChannelsListItemHeaderBinding;
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
        ChannelListItemHeader channelListItemHeader = (ChannelListItemHeader) data;
        int textResId = channelListItemHeader.getTextResId();
        boolean ableToManageChannel = channelListItemHeader.getAbleToManageChannel();
        long selectedGuildId = channelListItemHeader.getSelectedGuildId();
        if (!ableToManageChannel) {
            ImageView imageView = this.binding.c;
            m.checkNotNullExpressionValue(imageView, "binding.channelsListNew");
            imageView.setVisibility(4);
            this.binding.c.setOnClickListener(null);
        } else if (textResId == 2131893540) {
            ImageView imageView2 = this.binding.c;
            m.checkNotNullExpressionValue(imageView2, "binding.channelsListNew");
            imageView2.setVisibility(4);
            this.binding.c.setOnClickListener(null);
        } else if (textResId == 2131896304) {
            ImageView imageView3 = this.binding.c;
            m.checkNotNullExpressionValue(imageView3, "binding.channelsListNew");
            imageView3.setVisibility(0);
            this.binding.c.setOnClickListener(new WidgetChannelsListAdapter$ItemHeader$onConfigure$1(selectedGuildId));
        } else if (textResId == 2131897174) {
            ImageView imageView4 = this.binding.c;
            m.checkNotNullExpressionValue(imageView4, "binding.channelsListNew");
            imageView4.setVisibility(0);
            this.binding.c.setOnClickListener(new WidgetChannelsListAdapter$ItemHeader$onConfigure$2(selectedGuildId));
        }
        this.binding.f2295b.setText(textResId);
    }
}
