package com.discord.utilities.search.suggestion.entries;

import b.d.b.a.outline;
import com.discord.utilities.search.query.node.QueryNode;
import com.discord.utilities.search.suggestion.entries.SearchSuggestion;
import d0.z.d.Intrinsics3;
import java.util.List;

/* JADX INFO: compiled from: RecentQuerySuggestion.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class RecentQuerySuggestion implements SearchSuggestion {
    private final SearchSuggestion.Category category;
    private final List<QueryNode> query;

    /* JADX WARN: Multi-variable type inference failed */
    public RecentQuerySuggestion(List<? extends QueryNode> list) {
        Intrinsics3.checkNotNullParameter(list, "query");
        this.query = list;
        this.category = SearchSuggestion.Category.RECENT_QUERY;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ RecentQuerySuggestion copy$default(RecentQuerySuggestion recentQuerySuggestion, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = recentQuerySuggestion.query;
        }
        return recentQuerySuggestion.copy(list);
    }

    public final List<QueryNode> component1() {
        return this.query;
    }

    public final RecentQuerySuggestion copy(List<? extends QueryNode> query) {
        Intrinsics3.checkNotNullParameter(query, "query");
        return new RecentQuerySuggestion(query);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof RecentQuerySuggestion) && Intrinsics3.areEqual(this.query, ((RecentQuerySuggestion) other).query);
        }
        return true;
    }

    @Override // com.discord.utilities.search.suggestion.entries.SearchSuggestion
    public SearchSuggestion.Category getCategory() {
        return this.category;
    }

    public final List<QueryNode> getQuery() {
        return this.query;
    }

    public int hashCode() {
        List<QueryNode> list = this.query;
        if (list != null) {
            return list.hashCode();
        }
        return 0;
    }

    public String toString() {
        return outline.L(outline.U("RecentQuerySuggestion(query="), this.query, ")");
    }
}
