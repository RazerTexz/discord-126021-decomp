package com.discord.widgets.search.suggestions;

import android.view.View;
import android.view.View$OnClickListener;
import com.discord.utilities.search.suggestion.entries.UserSuggestion;

/* JADX INFO: compiled from: WidgetSearchSuggestionsAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSearchSuggestionsAdapter$UserViewHolder$onConfigure$1 implements View$OnClickListener {
    public final /* synthetic */ UserSuggestion $userSuggestion;
    public final /* synthetic */ WidgetSearchSuggestionsAdapter$UserViewHolder this$0;

    public WidgetSearchSuggestionsAdapter$UserViewHolder$onConfigure$1(WidgetSearchSuggestionsAdapter$UserViewHolder widgetSearchSuggestionsAdapter$UserViewHolder, UserSuggestion userSuggestion) {
        this.this$0 = widgetSearchSuggestionsAdapter$UserViewHolder;
        this.$userSuggestion = userSuggestion;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetSearchSuggestionsAdapter$UserViewHolder.access$getAdapter$p(this.this$0).getOnUserClicked().invoke(this.$userSuggestion);
    }
}
