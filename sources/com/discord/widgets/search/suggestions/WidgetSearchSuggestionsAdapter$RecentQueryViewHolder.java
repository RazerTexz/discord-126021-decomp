package com.discord.widgets.search.suggestions;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.discord.R$id;
import com.discord.R$layout;
import com.discord.databinding.WidgetSearchSuggestionsItemRecentQueryBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.utilities.mg_recycler.SingleTypePayload;
import com.discord.utilities.search.query.node.QueryNode;
import com.discord.utilities.search.suggestion.entries.RecentQuerySuggestion;
import com.discord.utilities.textprocessing.AstRenderer;
import d0.z.d.m;
import java.util.List;

/* JADX INFO: compiled from: WidgetSearchSuggestionsAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSearchSuggestionsAdapter$RecentQueryViewHolder extends MGRecyclerViewHolder<WidgetSearchSuggestionsAdapter, MGRecyclerDataPayload> {
    private final WidgetSearchSuggestionsItemRecentQueryBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetSearchSuggestionsAdapter$RecentQueryViewHolder(WidgetSearchSuggestionsAdapter widgetSearchSuggestionsAdapter) {
        super(R$layout.widget_search_suggestions_item_recent_query, widgetSearchSuggestionsAdapter);
        m.checkNotNullParameter(widgetSearchSuggestionsAdapter, "widgetSearchSuggestionsAdapter");
        View view = this.itemView;
        RelativeLayout relativeLayout = (RelativeLayout) view;
        int i = R$id.search_suggestions_item_recent_query_icon;
        ImageView imageView = (ImageView) view.findViewById(R$id.search_suggestions_item_recent_query_icon);
        if (imageView != null) {
            i = R$id.search_suggestions_item_recent_query_text;
            TextView textView = (TextView) view.findViewById(R$id.search_suggestions_item_recent_query_text);
            if (textView != null) {
                WidgetSearchSuggestionsItemRecentQueryBinding widgetSearchSuggestionsItemRecentQueryBinding = new WidgetSearchSuggestionsItemRecentQueryBinding((RelativeLayout) view, relativeLayout, imageView, textView);
                m.checkNotNullExpressionValue(widgetSearchSuggestionsItemRecentQueryBinding, "WidgetSearchSuggestionsI…eryBinding.bind(itemView)");
                this.binding = widgetSearchSuggestionsItemRecentQueryBinding;
                return;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static final /* synthetic */ WidgetSearchSuggestionsAdapter access$getAdapter$p(WidgetSearchSuggestionsAdapter$RecentQueryViewHolder widgetSearchSuggestionsAdapter$RecentQueryViewHolder) {
        return (WidgetSearchSuggestionsAdapter) widgetSearchSuggestionsAdapter$RecentQueryViewHolder.adapter;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public /* bridge */ /* synthetic */ void onConfigure(int i, MGRecyclerDataPayload mGRecyclerDataPayload) {
        onConfigure2(i, mGRecyclerDataPayload);
    }

    /* JADX INFO: renamed from: onConfigure, reason: avoid collision after fix types in other method */
    public void onConfigure2(int position, MGRecyclerDataPayload data) {
        m.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        List<QueryNode> query = ((RecentQuerySuggestion) ((SingleTypePayload) data).getData()).getQuery();
        TextView textView = this.binding.c;
        m.checkNotNullExpressionValue(textView, "binding.searchSuggestionsItemRecentQueryText");
        View view = this.itemView;
        m.checkNotNullExpressionValue(view, "itemView");
        Context context = view.getContext();
        m.checkNotNullExpressionValue(context, "itemView.context");
        textView.setText(AstRenderer.render(query, context));
        this.binding.f2529b.setOnClickListener(new WidgetSearchSuggestionsAdapter$RecentQueryViewHolder$onConfigure$1(this, query));
    }
}
