package com.discord.widgets.chat.list.adapter;

import android.content.res.Resources;
import android.view.View;
import android.widget.TextView;
import com.discord.C5419R;
import com.discord.databinding.WidgetChatListAdapterItemResultCountBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.resources.StringResourceUtilsKt;
import com.discord.widgets.chat.list.entries.ChatListEntry;
import com.discord.widgets.chat.list.entries.SearchResultCountEntry;
import java.util.Objects;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetChatListAdapterItemSearchResultCount.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemSearchResultCount extends WidgetChatListItem {
    private final WidgetChatListAdapterItemResultCountBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterItemSearchResultCount(WidgetChatListAdapter widgetChatListAdapter) {
        super(C5419R.layout.widget_chat_list_adapter_item_result_count, widgetChatListAdapter);
        C12238m.checkNotNullParameter(widgetChatListAdapter, "adapter");
        View view = this.itemView;
        Objects.requireNonNull(view, "rootView");
        TextView textView = (TextView) view;
        WidgetChatListAdapterItemResultCountBinding widgetChatListAdapterItemResultCountBinding = new WidgetChatListAdapterItemResultCountBinding(textView, textView);
        C12238m.checkNotNullExpressionValue(widgetChatListAdapterItemResultCountBinding, "WidgetChatListAdapterIte…untBinding.bind(itemView)");
        this.binding = widgetChatListAdapterItemResultCountBinding;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListItem, com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public void onConfigure(int position, ChatListEntry data) {
        C12238m.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        int totalResults = ((SearchResultCountEntry) data).getTotalResults();
        TextView textView = this.binding.f16273b;
        C12238m.checkNotNullExpressionValue(textView, "binding.resultCount");
        TextView textView2 = this.binding.f16273b;
        C12238m.checkNotNullExpressionValue(textView2, "binding.resultCount");
        Resources resources = textView2.getResources();
        C12238m.checkNotNullExpressionValue(resources, "binding.resultCount.resources");
        textView.setText(StringResourceUtilsKt.getQuantityString(resources, C1643a.m821I(this.binding.f16273b, "binding.resultCount", "binding.resultCount.context"), C5419R.plurals.total_results_count, totalResults, Integer.valueOf(totalResults)));
    }
}
