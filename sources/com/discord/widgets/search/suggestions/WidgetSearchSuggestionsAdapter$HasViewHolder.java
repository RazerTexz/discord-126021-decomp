package com.discord.widgets.search.suggestions;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.discord.R$id;
import com.discord.R$layout;
import com.discord.databinding.WidgetSearchSuggestionsItemHasBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.utilities.mg_recycler.SingleTypePayload;
import com.discord.utilities.search.strings.ContextSearchStringProvider;
import com.discord.utilities.search.strings.SearchStringProvider;
import com.discord.utilities.search.suggestion.entries.HasSuggestion;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetSearchSuggestionsAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSearchSuggestionsAdapter$HasViewHolder extends MGRecyclerViewHolder<WidgetSearchSuggestionsAdapter, MGRecyclerDataPayload> {
    public static final WidgetSearchSuggestionsAdapter$HasViewHolder$Companion Companion = new WidgetSearchSuggestionsAdapter$HasViewHolder$Companion(null);
    private final WidgetSearchSuggestionsItemHasBinding binding;
    private final SearchStringProvider searchStringProvider;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetSearchSuggestionsAdapter$HasViewHolder(WidgetSearchSuggestionsAdapter widgetSearchSuggestionsAdapter) {
        super(R$layout.widget_search_suggestions_item_has, widgetSearchSuggestionsAdapter);
        m.checkNotNullParameter(widgetSearchSuggestionsAdapter, "searchSuggestionsAdapter");
        View view = this.itemView;
        RelativeLayout relativeLayout = (RelativeLayout) view;
        int i = R$id.search_suggestions_item_has_icon;
        ImageView imageView = (ImageView) view.findViewById(R$id.search_suggestions_item_has_icon);
        if (imageView != null) {
            i = R$id.search_suggestions_item_has_text;
            TextView textView = (TextView) view.findViewById(R$id.search_suggestions_item_has_text);
            if (textView != null) {
                WidgetSearchSuggestionsItemHasBinding widgetSearchSuggestionsItemHasBinding = new WidgetSearchSuggestionsItemHasBinding((RelativeLayout) view, relativeLayout, imageView, textView);
                m.checkNotNullExpressionValue(widgetSearchSuggestionsItemHasBinding, "WidgetSearchSuggestionsI…HasBinding.bind(itemView)");
                this.binding = widgetSearchSuggestionsItemHasBinding;
                m.checkNotNullExpressionValue(relativeLayout, "binding.searchSuggestionItemHasContainer");
                Context context = relativeLayout.getContext();
                m.checkNotNullExpressionValue(context, "binding.searchSuggestionItemHasContainer.context");
                this.searchStringProvider = new ContextSearchStringProvider(context);
                return;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static final /* synthetic */ WidgetSearchSuggestionsAdapter access$getAdapter$p(WidgetSearchSuggestionsAdapter$HasViewHolder widgetSearchSuggestionsAdapter$HasViewHolder) {
        return (WidgetSearchSuggestionsAdapter) widgetSearchSuggestionsAdapter$HasViewHolder.adapter;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public /* bridge */ /* synthetic */ void onConfigure(int i, MGRecyclerDataPayload mGRecyclerDataPayload) {
        onConfigure2(i, mGRecyclerDataPayload);
    }

    @SuppressLint({"SetTextI18n"})
    /* JADX INFO: renamed from: onConfigure, reason: avoid collision after fix types in other method */
    public void onConfigure2(int position, MGRecyclerDataPayload data) {
        m.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        HasSuggestion hasSuggestion = (HasSuggestion) ((SingleTypePayload) data).getData();
        TextView textView = this.binding.d;
        m.checkNotNullExpressionValue(textView, "binding.searchSuggestionsItemHasText");
        textView.setText(hasSuggestion.getHasAnswerOption().getLocalizedInputText(this.searchStringProvider));
        this.binding.c.setImageResource(WidgetSearchSuggestionsAdapter$HasViewHolder$Companion.access$getIconRes(Companion, hasSuggestion.getHasAnswerOption()));
        this.binding.f2528b.setOnClickListener(new WidgetSearchSuggestionsAdapter$HasViewHolder$onConfigure$1(this, hasSuggestion));
    }
}
