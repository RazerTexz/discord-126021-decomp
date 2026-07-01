package com.discord.widgets.search.suggestions;

import com.discord.utilities.mg_recycler.SingleTypePayload;
import com.discord.utilities.search.suggestion.entries.ChannelSuggestion;
import com.discord.utilities.search.suggestion.entries.FilterSuggestion;
import com.discord.utilities.search.suggestion.entries.HasSuggestion;
import com.discord.utilities.search.suggestion.entries.RecentQuerySuggestion;
import com.discord.utilities.search.suggestion.entries.SearchSuggestion$Category;
import com.discord.utilities.search.suggestion.entries.UserSuggestion;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetSearchSuggestionsAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSearchSuggestionsAdapter$Companion {
    private WidgetSearchSuggestionsAdapter$Companion() {
    }

    public final SingleTypePayload<FilterSuggestion> getFilterItem(FilterSuggestion data) {
        m.checkNotNullParameter(data, "data");
        return new SingleTypePayload<>(data, data.getCategory().name(), 2);
    }

    public final SingleTypePayload<HasSuggestion> getHasItem(HasSuggestion data) {
        m.checkNotNullParameter(data, "data");
        return new SingleTypePayload<>(data, data.getHasAnswerOption().name(), 5);
    }

    public final SingleTypePayload<SearchSuggestion$Category> getHeaderItem(SearchSuggestion$Category category) {
        m.checkNotNullParameter(category, "category");
        return new SingleTypePayload<>(category, category.name(), category == SearchSuggestion$Category.RECENT_QUERY ? 1 : 0);
    }

    public final SingleTypePayload<ChannelSuggestion> getInChannelItem(ChannelSuggestion data) {
        m.checkNotNullParameter(data, "data");
        return new SingleTypePayload<>(data, String.valueOf(data.getChannelId()), 4);
    }

    public final SingleTypePayload<RecentQuerySuggestion> getRecentQueryItem(RecentQuerySuggestion data) {
        m.checkNotNullParameter(data, "data");
        return new SingleTypePayload<>(data, String.valueOf(data.hashCode()), 6);
    }

    public final SingleTypePayload<UserSuggestion> getUserItem(UserSuggestion data) {
        m.checkNotNullParameter(data, "data");
        return new SingleTypePayload<>(data, data.getTargetType().name() + data.getUserId(), 3);
    }

    public /* synthetic */ WidgetSearchSuggestionsAdapter$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
