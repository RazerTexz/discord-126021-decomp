package com.discord.widgets.search.suggestions;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: WidgetSearchSuggestionsAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSearchSuggestionsAdapter$HistoryHeaderViewHolder$onConfigure$1 implements View$OnClickListener {
    public final /* synthetic */ WidgetSearchSuggestionsAdapter$HistoryHeaderViewHolder this$0;

    public WidgetSearchSuggestionsAdapter$HistoryHeaderViewHolder$onConfigure$1(WidgetSearchSuggestionsAdapter$HistoryHeaderViewHolder widgetSearchSuggestionsAdapter$HistoryHeaderViewHolder) {
        this.this$0 = widgetSearchSuggestionsAdapter$HistoryHeaderViewHolder;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetSearchSuggestionsAdapter$HistoryHeaderViewHolder.access$getAdapter$p(this.this$0).getOnClearHistoryClicked().invoke();
    }
}
