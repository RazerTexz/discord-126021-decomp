package com.discord.widgets.search.suggestions;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.discord.R$id;
import com.discord.R$layout;
import com.discord.databinding.WidgetSearchSuggestionItemHeaderHistoryBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetSearchSuggestionsAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSearchSuggestionsAdapter$HistoryHeaderViewHolder extends MGRecyclerViewHolder<WidgetSearchSuggestionsAdapter, MGRecyclerDataPayload> {
    private final WidgetSearchSuggestionItemHeaderHistoryBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetSearchSuggestionsAdapter$HistoryHeaderViewHolder(WidgetSearchSuggestionsAdapter widgetSearchSuggestionsAdapter) {
        super(R$layout.widget_search_suggestion_item_header_history, widgetSearchSuggestionsAdapter);
        m.checkNotNullParameter(widgetSearchSuggestionsAdapter, "searchSuggestionsAdapter");
        View view = this.itemView;
        int i = R$id.suggestion_item_header_history_clear_icon;
        ImageView imageView = (ImageView) view.findViewById(R$id.suggestion_item_header_history_clear_icon);
        if (imageView != null) {
            i = R$id.suggestion_item_header_history_divider;
            View viewFindViewById = view.findViewById(R$id.suggestion_item_header_history_divider);
            if (viewFindViewById != null) {
                i = R$id.suggestion_item_header_history_text;
                TextView textView = (TextView) view.findViewById(R$id.suggestion_item_header_history_text);
                if (textView != null) {
                    WidgetSearchSuggestionItemHeaderHistoryBinding widgetSearchSuggestionItemHeaderHistoryBinding = new WidgetSearchSuggestionItemHeaderHistoryBinding((RelativeLayout) view, imageView, viewFindViewById, textView);
                    m.checkNotNullExpressionValue(widgetSearchSuggestionItemHeaderHistoryBinding, "WidgetSearchSuggestionIt…oryBinding.bind(itemView)");
                    this.binding = widgetSearchSuggestionItemHeaderHistoryBinding;
                    return;
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static final /* synthetic */ WidgetSearchSuggestionsAdapter access$getAdapter$p(WidgetSearchSuggestionsAdapter$HistoryHeaderViewHolder widgetSearchSuggestionsAdapter$HistoryHeaderViewHolder) {
        return (WidgetSearchSuggestionsAdapter) widgetSearchSuggestionsAdapter$HistoryHeaderViewHolder.adapter;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public /* bridge */ /* synthetic */ void onConfigure(int i, MGRecyclerDataPayload mGRecyclerDataPayload) {
        onConfigure2(i, mGRecyclerDataPayload);
    }

    /* JADX INFO: renamed from: onConfigure, reason: avoid collision after fix types in other method */
    public void onConfigure2(int position, MGRecyclerDataPayload data) {
        m.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        this.binding.f2525b.setOnClickListener(new WidgetSearchSuggestionsAdapter$HistoryHeaderViewHolder$onConfigure$1(this));
    }
}
