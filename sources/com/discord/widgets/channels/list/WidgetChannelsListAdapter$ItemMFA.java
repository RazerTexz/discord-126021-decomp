package com.discord.widgets.channels.list;

import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.LayoutRes;
import b.a.k.b;
import com.discord.R$id;
import com.discord.databinding.WidgetChannelsListItemMfaBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.widgets.channels.list.items.ChannelListItem;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetChannelsListAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelsListAdapter$ItemMFA extends MGRecyclerViewHolder<WidgetChannelsListAdapter, ChannelListItem> {
    private final WidgetChannelsListItemMfaBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChannelsListAdapter$ItemMFA(@LayoutRes int i, WidgetChannelsListAdapter widgetChannelsListAdapter) {
        super(i, widgetChannelsListAdapter);
        m.checkNotNullParameter(widgetChannelsListAdapter, "adapter");
        View view = this.itemView;
        LinkifiedTextView linkifiedTextView = (LinkifiedTextView) view.findViewById(R$id.channels_list_item_mfa_text);
        if (linkifiedTextView == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R$id.channels_list_item_mfa_text)));
        }
        WidgetChannelsListItemMfaBinding widgetChannelsListItemMfaBinding = new WidgetChannelsListItemMfaBinding((LinearLayout) view, linkifiedTextView);
        m.checkNotNullExpressionValue(widgetChannelsListItemMfaBinding, "WidgetChannelsListItemMfaBinding.bind(itemView)");
        this.binding = widgetChannelsListItemMfaBinding;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public /* bridge */ /* synthetic */ void onConfigure(int i, ChannelListItem channelListItem) {
        onConfigure2(i, channelListItem);
    }

    /* JADX INFO: renamed from: onConfigure, reason: avoid collision after fix types in other method */
    public void onConfigure2(int position, ChannelListItem data) {
        m.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        LinkifiedTextView linkifiedTextView = this.binding.f2296b;
        m.checkNotNullExpressionValue(linkifiedTextView, "binding.channelsListItemMfaText");
        b.m(linkifiedTextView, 2131896526, new Object[0], WidgetChannelsListAdapter$ItemMFA$onConfigure$1.INSTANCE);
    }
}
