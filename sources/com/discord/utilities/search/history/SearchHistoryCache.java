package com.discord.utilities.search.history;

import com.discord.stores.StoreSearch;
import com.discord.utilities.search.query.node.QueryNode;
import java.util.Collection;
import java.util.List;
import p658rx.Observable;

/* JADX INFO: compiled from: SearchHistoryCache.kt */
/* JADX INFO: loaded from: classes2.dex */
public interface SearchHistoryCache {
    void clear(StoreSearch.SearchTarget searchTarget);

    Observable<Collection<List<QueryNode>>> getHistory(StoreSearch.SearchTarget searchTarget);

    void persistQuery(StoreSearch.SearchTarget searchTarget, List<? extends QueryNode> query);
}
