package com.discord.widgets.search.suggestions;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.discord.R$id;
import com.discord.R$layout;
import com.discord.databinding.WidgetSearchSuggestionsItemChannelBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.utilities.mg_recycler.SingleTypePayload;
import com.discord.utilities.search.suggestion.entries.ChannelSuggestion;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetSearchSuggestionsAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSearchSuggestionsAdapter$InChannelViewHolder extends MGRecyclerViewHolder<WidgetSearchSuggestionsAdapter, MGRecyclerDataPayload> {
    private final WidgetSearchSuggestionsItemChannelBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetSearchSuggestionsAdapter$InChannelViewHolder(WidgetSearchSuggestionsAdapter widgetSearchSuggestionsAdapter) {
        super(R$layout.widget_search_suggestions_item_channel, widgetSearchSuggestionsAdapter);
        m.checkNotNullParameter(widgetSearchSuggestionsAdapter, "searchSuggestionsAdapter");
        View view = this.itemView;
        RelativeLayout relativeLayout = (RelativeLayout) view;
        int i = R$id.search_suggestions_item_channel_icon;
        ImageView imageView = (ImageView) view.findViewById(R$id.search_suggestions_item_channel_icon);
        if (imageView != null) {
            i = R$id.search_suggestions_item_channel_text;
            TextView textView = (TextView) view.findViewById(R$id.search_suggestions_item_channel_text);
            if (textView != null) {
                WidgetSearchSuggestionsItemChannelBinding widgetSearchSuggestionsItemChannelBinding = new WidgetSearchSuggestionsItemChannelBinding((RelativeLayout) view, relativeLayout, imageView, textView);
                m.checkNotNullExpressionValue(widgetSearchSuggestionsItemChannelBinding, "WidgetSearchSuggestionsI…nelBinding.bind(itemView)");
                this.binding = widgetSearchSuggestionsItemChannelBinding;
                return;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static final /* synthetic */ WidgetSearchSuggestionsAdapter access$getAdapter$p(WidgetSearchSuggestionsAdapter$InChannelViewHolder widgetSearchSuggestionsAdapter$InChannelViewHolder) {
        return (WidgetSearchSuggestionsAdapter) widgetSearchSuggestionsAdapter$InChannelViewHolder.adapter;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public /* bridge */ /* synthetic */ void onConfigure(int i, MGRecyclerDataPayload mGRecyclerDataPayload) {
        onConfigure2(i, mGRecyclerDataPayload);
    }

    /* JADX INFO: renamed from: onConfigure, reason: avoid collision after fix types in other method */
    public void onConfigure2(int position, MGRecyclerDataPayload data) {
        m.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        ChannelSuggestion channelSuggestion = (ChannelSuggestion) ((SingleTypePayload) data).getData();
        TextView textView = this.binding.c;
        m.checkNotNullExpressionValue(textView, "binding.searchSuggestionsItemChannelText");
        textView.setText(channelSuggestion.getChannelName());
        this.binding.f2527b.setOnClickListener(new WidgetSearchSuggestionsAdapter$InChannelViewHolder$onConfigure$1(this, channelSuggestion));
    }
}
