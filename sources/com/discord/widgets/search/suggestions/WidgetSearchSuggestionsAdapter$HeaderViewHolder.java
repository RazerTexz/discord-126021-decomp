package com.discord.widgets.search.suggestions;

import android.view.View;
import android.widget.TextView;
import com.discord.R$layout;
import com.discord.databinding.WidgetSearchSuggestionItemHeaderBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.utilities.mg_recycler.SingleTypePayload;
import com.discord.utilities.search.suggestion.entries.SearchSuggestion$Category;
import d0.z.d.m;
import java.util.Objects;

/* JADX INFO: compiled from: WidgetSearchSuggestionsAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSearchSuggestionsAdapter$HeaderViewHolder extends MGRecyclerViewHolder<WidgetSearchSuggestionsAdapter, MGRecyclerDataPayload> {
    private final WidgetSearchSuggestionItemHeaderBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetSearchSuggestionsAdapter$HeaderViewHolder(WidgetSearchSuggestionsAdapter widgetSearchSuggestionsAdapter) {
        super(R$layout.widget_search_suggestion_item_header, widgetSearchSuggestionsAdapter);
        m.checkNotNullParameter(widgetSearchSuggestionsAdapter, "searchSuggestionsAdapter");
        View view = this.itemView;
        Objects.requireNonNull(view, "rootView");
        TextView textView = (TextView) view;
        WidgetSearchSuggestionItemHeaderBinding widgetSearchSuggestionItemHeaderBinding = new WidgetSearchSuggestionItemHeaderBinding(textView, textView);
        m.checkNotNullExpressionValue(widgetSearchSuggestionItemHeaderBinding, "WidgetSearchSuggestionIt…derBinding.bind(itemView)");
        this.binding = widgetSearchSuggestionItemHeaderBinding;
    }

    private final int getCategoryLabel(SearchSuggestion$Category category) {
        if (category != null) {
            int iOrdinal = category.ordinal();
            if (iOrdinal == 0) {
                return 2131895347;
            }
            if (iOrdinal == 1) {
                return 2131895345;
            }
            if (iOrdinal == 2) {
                return 2131895341;
            }
            if (iOrdinal == 3) {
                return 2131895342;
            }
            if (iOrdinal == 4) {
                return 2131895339;
            }
            if (iOrdinal == 5) {
                return 2131895338;
            }
        }
        throw new IllegalArgumentException("couldn't resolve category: " + category);
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public /* bridge */ /* synthetic */ void onConfigure(int i, MGRecyclerDataPayload mGRecyclerDataPayload) {
        onConfigure2(i, mGRecyclerDataPayload);
    }

    /* JADX INFO: renamed from: onConfigure, reason: avoid collision after fix types in other method */
    public void onConfigure2(int position, MGRecyclerDataPayload data) {
        m.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        this.binding.f2524b.setText(getCategoryLabel((SearchSuggestion$Category) ((SingleTypePayload) data).getData()));
    }
}
