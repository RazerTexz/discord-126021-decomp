package com.discord.widgets.channels.list;

import android.view.View;
import android.view.ViewGroup$LayoutParams;
import androidx.annotation.LayoutRes;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.widgets.channels.list.items.ChannelListItem;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetChannelsListAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelsListAdapter$ItemSpace extends MGRecyclerViewHolder<WidgetChannelsListAdapter, ChannelListItem> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChannelsListAdapter$ItemSpace(@LayoutRes int i, WidgetChannelsListAdapter widgetChannelsListAdapter) {
        super(i, widgetChannelsListAdapter);
        m.checkNotNullParameter(widgetChannelsListAdapter, "adapter");
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public /* bridge */ /* synthetic */ void onConfigure(int i, ChannelListItem channelListItem) {
        onConfigure2(i, channelListItem);
    }

    /* JADX INFO: renamed from: onConfigure, reason: avoid collision after fix types in other method */
    public void onConfigure2(int position, ChannelListItem data) {
        m.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        View view = this.itemView;
        m.checkNotNullExpressionValue(view, "itemView");
        ViewGroup$LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.height = WidgetChannelsListAdapter.access$getBottomNavHeight$p((WidgetChannelsListAdapter) this.adapter);
        View view2 = this.itemView;
        m.checkNotNullExpressionValue(view2, "itemView");
        view2.setLayoutParams(layoutParams);
    }
}
