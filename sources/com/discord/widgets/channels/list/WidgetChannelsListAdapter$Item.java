package com.discord.widgets.channels.list;

import android.content.Context;
import android.view.View;
import androidx.annotation.LayoutRes;
import androidx.core.content.ContextCompat;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.utilities.drawable.DrawableCompat;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.widgets.channels.list.items.ChannelListItem;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetChannelsListAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class WidgetChannelsListAdapter$Item extends MGRecyclerViewHolder<WidgetChannelsListAdapter, ChannelListItem> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChannelsListAdapter$Item(@LayoutRes int i, WidgetChannelsListAdapter widgetChannelsListAdapter) {
        super(i, widgetChannelsListAdapter);
        m.checkNotNullParameter(widgetChannelsListAdapter, "adapter");
    }

    public final void setBackground(View view, boolean z2, Channel channel) {
        int themedDrawableRes$default;
        m.checkNotNullParameter(view, "$this$setBackground");
        m.checkNotNullParameter(channel, "channel");
        if (!z2 || ChannelUtils.w(channel)) {
            Context context = view.getContext();
            m.checkNotNullExpressionValue(context, "context");
            themedDrawableRes$default = DrawableCompat.getThemedDrawableRes$default(context, 2130969277, 0, 2, (Object) null);
        } else {
            Context context2 = view.getContext();
            m.checkNotNullExpressionValue(context2, "context");
            themedDrawableRes$default = DrawableCompat.getThemedDrawableRes$default(context2, 2130969278, 0, 2, (Object) null);
        }
        ViewExtensions.setBackgroundAndKeepPadding(view, ContextCompat.getDrawable(view.getContext(), themedDrawableRes$default));
    }
}
