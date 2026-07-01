package com.discord.utilities.search.network;

import com.discord.models.domain.ModelSearchResponse;
import com.discord.stores.StoreSearch$SearchTarget;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.m;
import j0.l.a.j;
import j0.l.a.y;
import j0.l.e.e$c;
import j0.p.a;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import rx.Observable;

/* JADX INFO: compiled from: SearchFetcher.kt */
/* JADX INFO: loaded from: classes2.dex */
public class SearchFetcher {
    private AtomicInteger indexingRetryCount = new AtomicInteger(0);

    public static final /* synthetic */ AtomicInteger access$getIndexingRetryCount$p(SearchFetcher searchFetcher) {
        return searchFetcher.indexingRetryCount;
    }

    public static final /* synthetic */ boolean access$isIndexing(SearchFetcher searchFetcher, ModelSearchResponse modelSearchResponse) {
        return searchFetcher.isIndexing(modelSearchResponse);
    }

    public static final /* synthetic */ void access$setIndexingRetryCount$p(SearchFetcher searchFetcher, AtomicInteger atomicInteger) {
        searchFetcher.indexingRetryCount = atomicInteger;
    }

    private final Observable<ModelSearchResponse> getRestObservable(StoreSearch$SearchTarget searchTarget, Long oldestMessageId, SearchQuery searchQuery) {
        SearchFetcher$getRestObservable$1 searchFetcher$getRestObservable$1 = SearchFetcher$getRestObservable$1.INSTANCE;
        Observable observableA = Observable.h0(new j(new SearchFetcher$getRestObservable$2(this))).A(new SearchFetcher$getRestObservable$3(searchTarget, oldestMessageId, searchQuery.getParams(), searchQuery));
        m.checkNotNullExpressionValue(observableA, "Observable\n        .defe…  )\n          }\n        }");
        return ObservableExtensionsKt.restSubscribeOn$default(observableA, false, 1, null);
    }

    private final boolean isIndexing(ModelSearchResponse modelSearchResponse) {
        Integer errorCode = modelSearchResponse.getErrorCode();
        return errorCode != null && errorCode.intValue() == 111000;
    }

    public Observable<ModelSearchResponse> makeQuery(StoreSearch$SearchTarget searchTarget, Long oldestMessageId, SearchQuery searchQuery) {
        m.checkNotNullParameter(searchTarget, "searchTarget");
        m.checkNotNullParameter(searchQuery, "searchQuery");
        AtomicLong atomicLong = new AtomicLong();
        Observable<ModelSearchResponse> observableU = getRestObservable(searchTarget, oldestMessageId, searchQuery).u(new SearchFetcher$makeQuery$1(this, atomicLong));
        e$c e_c = new e$c(new SearchFetcher$makeQuery$2(atomicLong));
        AtomicReference<a> atomicReference = a.a;
        Observable<ModelSearchResponse> observableB0 = Observable.h0(new y(observableU, e_c, false, true, j0.l.c.m.a)).b0(new SearchFetcher$makeQuery$3(this));
        m.checkNotNullExpressionValue(observableB0, "getRestObservable(search…ntil { !it.isIndexing() }");
        return observableB0;
    }
}
