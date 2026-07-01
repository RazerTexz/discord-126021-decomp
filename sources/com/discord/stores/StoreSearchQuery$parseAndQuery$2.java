package com.discord.stores;

import androidx.core.app.NotificationCompat;
import com.discord.utilities.search.network.SearchQuery;
import com.discord.utilities.search.network.SearchQuery$Builder;
import com.discord.utilities.search.query.node.QueryNode;
import com.discord.utilities.search.query.node.QueryNode$Preprocessor;
import com.discord.utilities.search.validation.SearchData;
import d0.z.d.m;
import java.util.List;
import rx.functions.Func2;

/* JADX INFO: compiled from: StoreSearchQuery.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreSearchQuery$parseAndQuery$2<T1, T2, R> implements Func2<List<QueryNode>, SearchData, SearchQuery> {
    public final /* synthetic */ boolean $includeNsfw;
    public final /* synthetic */ StoreSearch $searchStore;
    public final /* synthetic */ StoreSearch$SearchTarget $searchTarget;

    public StoreSearchQuery$parseAndQuery$2(StoreSearch storeSearch, StoreSearch$SearchTarget storeSearch$SearchTarget, boolean z2) {
        this.$searchStore = storeSearch;
        this.$searchTarget = storeSearch$SearchTarget;
        this.$includeNsfw = z2;
    }

    @Override // rx.functions.Func2
    public /* bridge */ /* synthetic */ SearchQuery call(List<QueryNode> list, SearchData searchData) {
        return call2(list, searchData);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final SearchQuery call2(List<QueryNode> list, SearchData searchData) {
        QueryNode$Preprocessor queryNode$Preprocessor = QueryNode.Preprocessor;
        m.checkNotNullExpressionValue(list, "queryNodes");
        m.checkNotNullExpressionValue(searchData, "searchData");
        queryNode$Preprocessor.preprocess(list, searchData);
        this.$searchStore.persistQuery$app_productionGoogleRelease(this.$searchTarget, list);
        return new SearchQuery$Builder().setIncludeNsfw(this.$includeNsfw).buildFrom(list, searchData);
    }
}
