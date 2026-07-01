package com.discord.widgets.chat.list.adapter;

import android.content.res.Resources;
import android.view.View;
import android.widget.TextView;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.databinding.WidgetChatListAdapterItemResultCountBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.resources.StringResourceUtils;
import com.discord.widgets.chat.list.entries.ChatListEntry;
import com.discord.widgets.chat.list.entries.SearchResultCountEntry;
import d0.z.d.Intrinsics3;
import java.util.Objects;

/* JADX INFO: compiled from: WidgetChatListAdapterItemSearchResultCount.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemSearchResultCount extends WidgetChatListItem {
    private final WidgetChatListAdapterItemResultCountBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterItemSearchResultCount(WidgetChatListAdapter widgetChatListAdapter) {
        super(R.layout.widget_chat_list_adapter_item_result_count, widgetChatListAdapter);
        Intrinsics3.checkNotNullParameter(widgetChatListAdapter, "adapter");
        View view = this.itemView;
        Objects.requireNonNull(view, "rootView");
        TextView textView = (TextView) view;
        WidgetChatListAdapterItemResultCountBinding widgetChatListAdapterItemResultCountBinding = new WidgetChatListAdapterItemResultCountBinding(textView, textView);
        Intrinsics3.checkNotNullExpressionValue(widgetChatListAdapterItemResultCountBinding, "WidgetChatListAdapterIte…untBinding.bind(itemView)");
        this.binding = widgetChatListAdapterItemResultCountBinding;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListItem, com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public void onConfigure(int position, ChatListEntry data) {
        Intrinsics3.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        int totalResults = ((SearchResultCountEntry) data).getTotalResults();
        TextView textView = this.binding.f2330b;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.resultCount");
        TextView textView2 = this.binding.f2330b;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.resultCount");
        Resources resources = textView2.getResources();
        Intrinsics3.checkNotNullExpressionValue(resources, "binding.resultCount.resources");
        textView.setText(StringResourceUtils.getQuantityString(resources, outline.I(this.binding.f2330b, "binding.resultCount", "binding.resultCount.context"), R.plurals.total_results_count, totalResults, Integer.valueOf(totalResults)));
    }
}
