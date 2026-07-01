package com.discord.widgets.channels.list;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.discord.R$id;
import com.discord.databinding.WidgetChannelsListItemGuildRoleSubsBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.drawable.DrawableCompat;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.widgets.channels.list.items.ChannelListItem;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetChannelsListAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelsListAdapter$ItemGuildRoleSubscriptionsOverview extends WidgetChannelsListAdapter$Item {
    private final WidgetChannelsListItemGuildRoleSubsBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChannelsListAdapter$ItemGuildRoleSubscriptionsOverview(int i, WidgetChannelsListAdapter widgetChannelsListAdapter) {
        super(i, widgetChannelsListAdapter);
        m.checkNotNullParameter(widgetChannelsListAdapter, "adapter");
        View view = this.itemView;
        int i2 = R$id.directory_channel_icon;
        ImageView imageView = (ImageView) view.findViewById(R$id.directory_channel_icon);
        if (imageView != null) {
            i2 = R$id.directory_channel_name;
            TextView textView = (TextView) view.findViewById(R$id.directory_channel_name);
            if (textView != null) {
                WidgetChannelsListItemGuildRoleSubsBinding widgetChannelsListItemGuildRoleSubsBinding = new WidgetChannelsListItemGuildRoleSubsBinding((LinearLayout) view, imageView, textView);
                m.checkNotNullExpressionValue(widgetChannelsListItemGuildRoleSubsBinding, "WidgetChannelsListItemGu…ubsBinding.bind(itemView)");
                this.binding = widgetChannelsListItemGuildRoleSubsBinding;
                return;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i2)));
    }

    public static final /* synthetic */ WidgetChannelsListAdapter access$getAdapter$p(WidgetChannelsListAdapter$ItemGuildRoleSubscriptionsOverview widgetChannelsListAdapter$ItemGuildRoleSubscriptionsOverview) {
        return (WidgetChannelsListAdapter) widgetChannelsListAdapter$ItemGuildRoleSubscriptionsOverview.adapter;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public /* bridge */ /* synthetic */ void onConfigure(int i, ChannelListItem channelListItem) {
        onConfigure2(i, channelListItem);
    }

    /* JADX INFO: renamed from: onConfigure, reason: avoid collision after fix types in other method */
    public void onConfigure2(int position, ChannelListItem data) {
        m.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        LinearLayout linearLayout = this.binding.a;
        m.checkNotNullExpressionValue(linearLayout, "binding.root");
        Context context = linearLayout.getContext();
        m.checkNotNullExpressionValue(context, "context");
        int themedDrawableRes$default = DrawableCompat.getThemedDrawableRes$default(context, 2130969277, 0, 2, (Object) null);
        LinearLayout linearLayout2 = this.binding.a;
        m.checkNotNullExpressionValue(linearLayout2, "binding.root");
        ViewExtensions.setBackgroundAndKeepPadding(linearLayout2, ContextCompat.getDrawable(context, themedDrawableRes$default));
        this.binding.f2293b.setText(2131890706);
        this.binding.a.setOnClickListener(new WidgetChannelsListAdapter$ItemGuildRoleSubscriptionsOverview$onConfigure$1(this));
    }
}
