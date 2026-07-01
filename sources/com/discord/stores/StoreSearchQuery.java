package com.discord.stores;

import android.content.Context;
import com.discord.models.domain.ModelSearchResponse;
import com.discord.models.message.Message;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.search.network.SearchFetcher;
import com.discord.utilities.search.network.SearchQuery;
import com.discord.utilities.search.network.state.QueryFetchState;
import com.discord.utilities.search.network.state.SearchState;
import com.discord.utilities.search.strings.SearchStringProvider;
import d0.g0.t;
import d0.t.o;
import d0.t.u;
import d0.z.d.m;
import j0.l.e.k;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import rx.Observable;
import rx.Subscription;
import rx.subjects.BehaviorSubject;
import rx.subjects.SerializedSubject;

/* JADX INFO: compiled from: StoreSearchQuery.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreSearchQuery {
    public static final StoreSearchQuery$Companion Companion = new StoreSearchQuery$Companion(null);
    private static final SearchState SEARCH_STATE_NONE = new SearchState(QueryFetchState.NONE, null, null, null, null, false, 0, 126, null);
    private SearchState currentSearchState;
    private Subscription querySubscription;
    private final SearchFetcher searchFetcher;
    private final SerializedSubject<SearchState, SearchState> searchStateSubject;

    public StoreSearchQuery(SearchFetcher searchFetcher) {
        m.checkNotNullParameter(searchFetcher, "searchFetcher");
        this.searchFetcher = searchFetcher;
        SearchState searchState = SEARCH_STATE_NONE;
        this.searchStateSubject = new SerializedSubject<>(BehaviorSubject.l0(searchState));
        this.currentSearchState = searchState;
    }

    public static final /* synthetic */ Subscription access$getQuerySubscription$p(StoreSearchQuery storeSearchQuery) {
        return storeSearchQuery.querySubscription;
    }

    public static final /* synthetic */ void access$handleError(StoreSearchQuery storeSearchQuery) {
        storeSearchQuery.handleError();
    }

    public static final /* synthetic */ void access$handleResponse(StoreSearchQuery storeSearchQuery, SearchQuery searchQuery, ModelSearchResponse modelSearchResponse, boolean z2) {
        storeSearchQuery.handleResponse(searchQuery, modelSearchResponse, z2);
    }

    public static final /* synthetic */ void access$performInitialLoad(StoreSearchQuery storeSearchQuery, StoreSearch$SearchTarget storeSearch$SearchTarget, SearchQuery searchQuery) {
        storeSearchQuery.performInitialLoad(storeSearch$SearchTarget, searchQuery);
    }

    public static final /* synthetic */ void access$setQuerySubscription$p(StoreSearchQuery storeSearchQuery, Subscription subscription) {
        storeSearchQuery.querySubscription = subscription;
    }

    private final void handleError() {
        updateAndPublish(new SearchState(QueryFetchState.FAILED, null, null, null, null, false, 0, 126, null));
    }

    private final synchronized void handleResponse(SearchQuery searchQuery, ModelSearchResponse response, boolean isInitialLoad) {
        SearchState searchState;
        int totalResults;
        List arrayList;
        Integer errorCode = response.getErrorCode();
        if (errorCode == null) {
            if (isInitialLoad) {
                totalResults = response.getTotalResults();
                arrayList = new ArrayList();
            } else {
                totalResults = this.currentSearchState.getTotalResults();
                List<Message> hits = this.currentSearchState.getHits();
                if (hits == null || (arrayList = u.toMutableList((Collection) hits)) == null) {
                    arrayList = new ArrayList();
                }
            }
            int i = totalResults;
            List list = arrayList;
            List<com.discord.api.message.Message> hits2 = response.getHits();
            ArrayList arrayList2 = new ArrayList(o.collectionSizeOrDefault(hits2, 10));
            Iterator<T> it = hits2.iterator();
            while (it.hasNext()) {
                arrayList2.add(new Message((com.discord.api.message.Message) it.next()));
            }
            list.addAll(arrayList2);
            searchState = new SearchState(QueryFetchState.COMPLETED, searchQuery, response.getThreads(), response.getMembers(), list, i > list.size(), i);
        } else {
            searchState = errorCode.intValue() == 111000 ? new SearchState(QueryFetchState.INDEXING, searchQuery, null, null, null, false, 0, 124, null) : new SearchState(QueryFetchState.FAILED, searchQuery, null, null, null, false, 0, 124, null);
        }
        updateAndPublish(searchState);
    }

    private final void makeQuery(SearchQuery query, StoreSearch$SearchTarget searchTarget, Long oldestMessageId, boolean isInitialLoad) {
        ObservableExtensionsKt.appSubscribe$default(this.searchFetcher.makeQuery(searchTarget, oldestMessageId, query), (Context) null, "makeQuery", new StoreSearchQuery$makeQuery$2(this), new StoreSearchQuery$makeQuery$1(this, query, isInitialLoad), new StoreSearchQuery$makeQuery$3(this), (Function0) null, (Function0) null, 97, (Object) null);
    }

    public static /* synthetic */ void makeQuery$default(StoreSearchQuery storeSearchQuery, SearchQuery searchQuery, StoreSearch$SearchTarget storeSearch$SearchTarget, Long l, boolean z2, int i, Object obj) {
        if ((i & 4) != 0) {
            l = null;
        }
        if ((i & 8) != 0) {
            z2 = true;
        }
        storeSearchQuery.makeQuery(searchQuery, storeSearch$SearchTarget, l, z2);
    }

    private final void performInitialLoad(StoreSearch$SearchTarget searchTarget, SearchQuery query) {
        unsubscribe();
        makeQuery$default(this, query, searchTarget, null, false, 12, null);
    }

    private final synchronized void unsubscribe() {
        Subscription subscription = this.querySubscription;
        if (subscription != null) {
            subscription.unsubscribe();
        }
    }

    private final synchronized void updateAndPublish(SearchState searchState) {
        this.currentSearchState = searchState;
        this.searchStateSubject.k.onNext(searchState);
    }

    public final void clear() {
        unsubscribe();
        updateAndPublish(SEARCH_STATE_NONE);
    }

    public final Observable<SearchState> getState() {
        Observable<SearchState> observableR = this.searchStateSubject.r();
        m.checkNotNullExpressionValue(observableR, "searchStateSubject\n        .distinctUntilChanged()");
        return observableR;
    }

    public final synchronized void loadMore(StoreSearch$SearchTarget searchTarget, long oldestMessageId) {
        m.checkNotNullParameter(searchTarget, "searchTarget");
        SearchQuery searchQuery = this.currentSearchState.getSearchQuery();
        if (searchQuery != null) {
            if (this.currentSearchState.getQueryFetchState() != QueryFetchState.COMPLETED) {
                return;
            }
            if (this.currentSearchState.getHasMore()) {
                unsubscribe();
                updateAndPublish(new SearchState(QueryFetchState.LOADING_MORE, searchQuery, this.currentSearchState.getThreads(), this.currentSearchState.getThreadMembers(), this.currentSearchState.getHits(), false, this.currentSearchState.getTotalResults()));
                makeQuery(searchQuery, searchTarget, Long.valueOf(oldestMessageId), false);
            }
        }
    }

    public final void parseAndQuery(StoreSearch searchStore, StoreSearch$SearchTarget searchTarget, String queryString, SearchStringProvider searchStringProvider, boolean includeNsfw) {
        m.checkNotNullParameter(searchStore, "searchStore");
        m.checkNotNullParameter(searchTarget, "searchTarget");
        m.checkNotNullParameter(queryString, "queryString");
        m.checkNotNullParameter(searchStringProvider, "searchStringProvider");
        unsubscribe();
        if (!(!t.isBlank(queryString))) {
            updateAndPublish(new SearchState(QueryFetchState.NONE, null, null, null, null, false, 0, 126, null));
            return;
        }
        updateAndPublish(new SearchState(QueryFetchState.IN_PROGRESS, null, null, null, null, false, 0, 126, null));
        Observable observableZ = Observable.j0(new k(queryString).G(new StoreSearchQuery$parseAndQuery$1(searchStringProvider)), searchStore.getStoreSearchData().get(), new StoreSearchQuery$parseAndQuery$2(searchStore, searchTarget, includeNsfw)).k(b.a.d.o.c(StoreSearchQuery$parseAndQuery$3.INSTANCE, null, 1L, TimeUnit.SECONDS)).Z(1);
        m.checkNotNullExpressionValue(observableZ, "Observable\n            .…   )\n            .take(1)");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.computationBuffered(observableZ), (Context) null, "parseAndQuery", (Function1) null, new StoreSearchQuery$parseAndQuery$4(this, searchTarget), (Function1) null, (Function0) null, (Function0) null, 117, (Object) null);
    }
}
