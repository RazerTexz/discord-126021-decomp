package com.discord.widgets.chat.list.adapter;

import android.content.res.Resources;
import android.view.View;
import android.widget.TextView;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.R$plurals;
import com.discord.databinding.WidgetChatListAdapterItemResultCountBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.resources.StringResourceUtilsKt;
import com.discord.widgets.chat.list.entries.ChatListEntry;
import com.discord.widgets.chat.list.entries.SearchResultCountEntry;
import d0.z.d.m;
import java.util.Objects;

/* JADX INFO: compiled from: WidgetChatListAdapterItemSearchResultCount.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemSearchResultCount extends WidgetChatListItem {
    private final WidgetChatListAdapterItemResultCountBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterItemSearchResultCount(WidgetChatListAdapter widgetChatListAdapter) {
        super(R$layout.widget_chat_list_adapter_item_result_count, widgetChatListAdapter);
        m.checkNotNullParameter(widgetChatListAdapter, "adapter");
        View view = this.itemView;
        Objects.requireNonNull(view, "rootView");
        TextView textView = (TextView) view;
        WidgetChatListAdapterItemResultCountBinding widgetChatListAdapterItemResultCountBinding = new WidgetChatListAdapterItemResultCountBinding(textView, textView);
        m.checkNotNullExpressionValue(widgetChatListAdapterItemResultCountBinding, "WidgetChatListAdapterIte…untBinding.bind(itemView)");
        this.binding = widgetChatListAdapterItemResultCountBinding;
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListItem, com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public /* bridge */ /* synthetic */ void onConfigure(int i, ChatListEntry chatListEntry) {
        onConfigure(i, chatListEntry);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListItem
    public void onConfigure(int position, ChatListEntry data) {
        m.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        int totalResults = ((SearchResultCountEntry) data).getTotalResults();
        TextView textView = this.binding.f2330b;
        m.checkNotNullExpressionValue(textView, "binding.resultCount");
        TextView textView2 = this.binding.f2330b;
        m.checkNotNullExpressionValue(textView2, "binding.resultCount");
        Resources resources = textView2.getResources();
        m.checkNotNullExpressionValue(resources, "binding.resultCount.resources");
        textView.setText(StringResourceUtilsKt.getQuantityString(resources, a.I(this.binding.f2330b, "binding.resultCount", "binding.resultCount.context"), R$plurals.total_results_count, totalResults, Integer.valueOf(totalResults)));
    }
}
