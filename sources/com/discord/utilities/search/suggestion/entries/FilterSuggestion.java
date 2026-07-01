package com.discord.utilities.search.suggestion.entries;

import b.d.b.a.a;
import com.discord.utilities.search.query.FilterType;
import d0.z.d.m;

/* JADX INFO: compiled from: FilterSuggestion.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class FilterSuggestion implements SearchSuggestion {
    public static final FilterSuggestion$Companion Companion = new FilterSuggestion$Companion(null);
    private final SearchSuggestion$Category category;
    private final FilterType filterType;

    public FilterSuggestion(FilterType filterType) {
        m.checkNotNullParameter(filterType, "filterType");
        this.filterType = filterType;
        this.category = SearchSuggestion$Category.FILTER;
    }

    public static /* synthetic */ FilterSuggestion copy$default(FilterSuggestion filterSuggestion, FilterType filterType, int i, Object obj) {
        if ((i & 1) != 0) {
            filterType = filterSuggestion.filterType;
        }
        return filterSuggestion.copy(filterType);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final FilterType getFilterType() {
        return this.filterType;
    }

    public final FilterSuggestion copy(FilterType filterType) {
        m.checkNotNullParameter(filterType, "filterType");
        return new FilterSuggestion(filterType);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof FilterSuggestion) && m.areEqual(this.filterType, ((FilterSuggestion) other).filterType);
        }
        return true;
    }

    @Override // com.discord.utilities.search.suggestion.entries.SearchSuggestion
    public SearchSuggestion$Category getCategory() {
        return this.category;
    }

    public final FilterType getFilterType() {
        return this.filterType;
    }

    public int hashCode() {
        FilterType filterType = this.filterType;
        if (filterType != null) {
            return filterType.hashCode();
        }
        return 0;
    }

    public String toString() {
        StringBuilder sbU = a.U("FilterSuggestion(filterType=");
        sbU.append(this.filterType);
        sbU.append(")");
        return sbU.toString();
    }
}
