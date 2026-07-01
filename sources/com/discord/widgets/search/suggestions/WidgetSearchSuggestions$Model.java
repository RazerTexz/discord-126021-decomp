package com.discord.widgets.search.suggestions;

import b.d.b.a.a;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.utilities.search.query.node.QueryNode;
import com.discord.utilities.search.suggestion.entries.ChannelSuggestion;
import com.discord.utilities.search.suggestion.entries.FilterSuggestion;
import com.discord.utilities.search.suggestion.entries.HasSuggestion;
import com.discord.utilities.search.suggestion.entries.RecentQuerySuggestion;
import com.discord.utilities.search.suggestion.entries.SearchSuggestion;
import com.discord.utilities.search.suggestion.entries.SearchSuggestion$Category;
import com.discord.utilities.search.suggestion.entries.UserSuggestion;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: WidgetSearchSuggestions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetSearchSuggestions$Model {
    public static final WidgetSearchSuggestions$Model$Companion Companion = new WidgetSearchSuggestions$Model$Companion(null);
    private final List<QueryNode> query;
    private final List<SearchSuggestion> suggestionEntries;
    private final List<MGRecyclerDataPayload> suggestionItems;

    /* JADX WARN: Multi-variable type inference failed */
    public WidgetSearchSuggestions$Model(List<QueryNode> list, List<? extends SearchSuggestion> list2) {
        m.checkNotNullParameter(list, "query");
        m.checkNotNullParameter(list2, "suggestionEntries");
        this.query = list;
        this.suggestionEntries = list2;
        this.suggestionItems = new ArrayList();
        SearchSuggestion$Category searchSuggestion$Category = null;
        for (SearchSuggestion searchSuggestion : list2) {
            SearchSuggestion$Category category = searchSuggestion.getCategory();
            if (searchSuggestion$Category == null || category != searchSuggestion$Category) {
                this.suggestionItems.add(WidgetSearchSuggestionsAdapter.Companion.getHeaderItem(category));
                searchSuggestion$Category = category;
            }
            int iOrdinal = category.ordinal();
            if (iOrdinal == 0) {
                this.suggestionItems.add(WidgetSearchSuggestionsAdapter.Companion.getFilterItem((FilterSuggestion) searchSuggestion));
            } else if (iOrdinal == 1 || iOrdinal == 2) {
                this.suggestionItems.add(WidgetSearchSuggestionsAdapter.Companion.getUserItem((UserSuggestion) searchSuggestion));
            } else if (iOrdinal == 3) {
                this.suggestionItems.add(WidgetSearchSuggestionsAdapter.Companion.getHasItem((HasSuggestion) searchSuggestion));
            } else if (iOrdinal == 5) {
                this.suggestionItems.add(WidgetSearchSuggestionsAdapter.Companion.getInChannelItem((ChannelSuggestion) searchSuggestion));
            } else if (iOrdinal == 6) {
                this.suggestionItems.add(WidgetSearchSuggestionsAdapter.Companion.getRecentQueryItem((RecentQuerySuggestion) searchSuggestion));
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WidgetSearchSuggestions$Model copy$default(WidgetSearchSuggestions$Model widgetSearchSuggestions$Model, List list, List list2, int i, Object obj) {
        if ((i & 1) != 0) {
            list = widgetSearchSuggestions$Model.query;
        }
        if ((i & 2) != 0) {
            list2 = widgetSearchSuggestions$Model.suggestionEntries;
        }
        return widgetSearchSuggestions$Model.copy(list, list2);
    }

    public final List<QueryNode> component1() {
        return this.query;
    }

    public final List<SearchSuggestion> component2() {
        return this.suggestionEntries;
    }

    public final WidgetSearchSuggestions$Model copy(List<QueryNode> query, List<? extends SearchSuggestion> suggestionEntries) {
        m.checkNotNullParameter(query, "query");
        m.checkNotNullParameter(suggestionEntries, "suggestionEntries");
        return new WidgetSearchSuggestions$Model(query, suggestionEntries);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetSearchSuggestions$Model)) {
            return false;
        }
        WidgetSearchSuggestions$Model widgetSearchSuggestions$Model = (WidgetSearchSuggestions$Model) other;
        return m.areEqual(this.query, widgetSearchSuggestions$Model.query) && m.areEqual(this.suggestionEntries, widgetSearchSuggestions$Model.suggestionEntries);
    }

    public final List<QueryNode> getQuery() {
        return this.query;
    }

    public final List<SearchSuggestion> getSuggestionEntries() {
        return this.suggestionEntries;
    }

    public final List<MGRecyclerDataPayload> getSuggestionItems() {
        return this.suggestionItems;
    }

    public int hashCode() {
        List<QueryNode> list = this.query;
        int iHashCode = (list != null ? list.hashCode() : 0) * 31;
        List<SearchSuggestion> list2 = this.suggestionEntries;
        return iHashCode + (list2 != null ? list2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("Model(query=");
        sbU.append(this.query);
        sbU.append(", suggestionEntries=");
        return a.L(sbU, this.suggestionEntries, ")");
    }
}
