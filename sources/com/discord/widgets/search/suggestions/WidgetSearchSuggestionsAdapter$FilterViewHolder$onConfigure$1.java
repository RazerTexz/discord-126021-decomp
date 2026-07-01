package com.discord.widgets.search.suggestions;

import android.view.View;
import android.view.View$OnClickListener;
import com.discord.utilities.search.query.FilterType;

/* JADX INFO: compiled from: WidgetSearchSuggestionsAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSearchSuggestionsAdapter$FilterViewHolder$onConfigure$1 implements View$OnClickListener {
    public final /* synthetic */ FilterType $filterType;
    public final /* synthetic */ WidgetSearchSuggestionsAdapter$FilterViewHolder this$0;

    public WidgetSearchSuggestionsAdapter$FilterViewHolder$onConfigure$1(WidgetSearchSuggestionsAdapter$FilterViewHolder widgetSearchSuggestionsAdapter$FilterViewHolder, FilterType filterType) {
        this.this$0 = widgetSearchSuggestionsAdapter$FilterViewHolder;
        this.$filterType = filterType;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetSearchSuggestionsAdapter$FilterViewHolder.access$getAdapter$p(this.this$0).getOnFilterClicked().invoke(this.$filterType);
    }
}
