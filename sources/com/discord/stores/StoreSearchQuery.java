package com.discord.stores;

import com.discord.models.domain.ModelSearchResponse;
import com.discord.models.message.Message;
import com.discord.simpleast.core.parser.Parser;
import com.discord.stores.StoreSearch;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.search.network.SearchFetcher;
import com.discord.utilities.search.network.SearchQuery;
import com.discord.utilities.search.network.state.QueryFetchState;
import com.discord.utilities.search.network.state.SearchState;
import com.discord.utilities.search.query.node.QueryNode;
import com.discord.utilities.search.query.parsing.QueryParser;
import com.discord.utilities.search.strings.SearchStringProvider;
import com.discord.utilities.search.validation.SearchData;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import p007b.p008a.p018d.C0879o;
import p507d0.p579g0.C12103t;
import p507d0.p580t.C12149o;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p637j0.p641k.InterfaceC12589b;
import p637j0.p642l.p647e.C12721k;
import p658rx.Observable;
import p658rx.Subscription;
import p658rx.functions.Func2;
import p658rx.subjects.BehaviorSubject;
import p658rx.subjects.SerializedSubject;

/* JADX INFO: compiled from: StoreSearchQuery.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreSearchQuery {
    private static final SearchState SEARCH_STATE_NONE = new SearchState(QueryFetchState.NONE, null, null, null, null, false, 0, 126, null);
    private SearchState currentSearchState;
    private Subscription querySubscription;
    private final SearchFetcher searchFetcher;
    private final SerializedSubject<SearchState, SearchState> searchStateSubject;

    /* JADX INFO: renamed from: com.discord.stores.StoreSearchQuery$makeQuery$1 */
    /* JADX INFO: compiled from: StoreSearchQuery.kt */
    public static final class C63931 extends AbstractC12240o implements Function1<ModelSearchResponse, Unit> {
        public final /* synthetic */ boolean $isInitialLoad;
        public final /* synthetic */ SearchQuery $query;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C63931(SearchQuery searchQuery, boolean z2) {
            super(1);
            this.$query = searchQuery;
            this.$isInitialLoad = z2;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ModelSearchResponse modelSearchResponse) {
            invoke2(modelSearchResponse);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ModelSearchResponse modelSearchResponse) {
            C12238m.checkNotNullParameter(modelSearchResponse, "searchResponse");
            StoreSearchQuery.this.handleResponse(this.$query, modelSearchResponse, this.$isInitialLoad);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreSearchQuery$makeQuery$2 */
    /* JADX INFO: compiled from: StoreSearchQuery.kt */
    public static final class C63942 extends AbstractC12240o implements Function1<Subscription, Unit> {
        public C63942() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Subscription subscription) {
            invoke2(subscription);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Subscription subscription) {
            C12238m.checkNotNullParameter(subscription, Traits.Payment.Type.SUBSCRIPTION);
            StoreSearchQuery.this.querySubscription = subscription;
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreSearchQuery$makeQuery$3 */
    /* JADX INFO: compiled from: StoreSearchQuery.kt */
    public static final class C63953 extends AbstractC12240o implements Function1<Error, Unit> {
        public C63953() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            C12238m.checkNotNullParameter(error, "it");
            StoreSearchQuery.this.handleError();
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreSearchQuery$parseAndQuery$3 */
    /* JADX INFO: compiled from: StoreSearchQuery.kt */
    public static final class C63983 extends AbstractC12240o implements Function1<SearchQuery, Boolean> {
        public static final C63983 INSTANCE = new C63983();

        public C63983() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Boolean invoke(SearchQuery searchQuery) {
            return Boolean.valueOf(invoke2(searchQuery));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2(SearchQuery searchQuery) {
            return searchQuery != null && searchQuery.isValid();
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreSearchQuery$parseAndQuery$4 */
    /* JADX INFO: compiled from: StoreSearchQuery.kt */
    public static final class C63994 extends AbstractC12240o implements Function1<SearchQuery, Unit> {
        public final /* synthetic */ StoreSearch.SearchTarget $searchTarget;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C63994(StoreSearch.SearchTarget searchTarget) {
            super(1);
            this.$searchTarget = searchTarget;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(SearchQuery searchQuery) {
            invoke2(searchQuery);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SearchQuery searchQuery) {
            if (searchQuery == null) {
                StoreSearchQuery.this.handleError();
            } else {
                StoreSearchQuery.this.performInitialLoad(this.$searchTarget, searchQuery);
            }
        }
    }

    public StoreSearchQuery(SearchFetcher searchFetcher) {
        C12238m.checkNotNullParameter(searchFetcher, "searchFetcher");
        this.searchFetcher = searchFetcher;
        SearchState searchState = SEARCH_STATE_NONE;
        this.searchStateSubject = new SerializedSubject<>(BehaviorSubject.m11130l0(searchState));
        this.currentSearchState = searchState;
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
                if (hits == null || (arrayList = C12163u.toMutableList((Collection) hits)) == null) {
                    arrayList = new ArrayList();
                }
            }
            int i = totalResults;
            List list = arrayList;
            List<com.discord.api.message.Message> hits2 = response.getHits();
            ArrayList arrayList2 = new ArrayList(C12149o.collectionSizeOrDefault(hits2, 10));
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

    private final void makeQuery(SearchQuery query, StoreSearch.SearchTarget searchTarget, Long oldestMessageId, boolean isInitialLoad) {
        ObservableExtensionsKt.appSubscribe(this.searchFetcher.makeQuery(searchTarget, oldestMessageId, query), (117 & 1) != 0 ? null : null, "makeQuery", (Function1<? super Subscription, Unit>) ((117 & 4) != 0 ? null : new C63942()), new C63931(query, isInitialLoad), (Function1<? super Error, Unit>) ((117 & 16) != 0 ? null : new C63953()), (Function0<Unit>) ((117 & 32) != 0 ? ObservableExtensionsKt.C68813.INSTANCE : null), (Function0<Unit>) ((117 & 64) != 0 ? ObservableExtensionsKt.C68824.INSTANCE : null));
    }

    public static /* synthetic */ void makeQuery$default(StoreSearchQuery storeSearchQuery, SearchQuery searchQuery, StoreSearch.SearchTarget searchTarget, Long l, boolean z2, int i, Object obj) {
        if ((i & 4) != 0) {
            l = null;
        }
        if ((i & 8) != 0) {
            z2 = true;
        }
        storeSearchQuery.makeQuery(searchQuery, searchTarget, l, z2);
    }

    private final void performInitialLoad(StoreSearch.SearchTarget searchTarget, SearchQuery query) {
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
        this.searchStateSubject.f27653k.onNext(searchState);
    }

    public final void clear() {
        unsubscribe();
        updateAndPublish(SEARCH_STATE_NONE);
    }

    public final Observable<SearchState> getState() {
        Observable<SearchState> observableM11112r = this.searchStateSubject.m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r, "searchStateSubject\n        .distinctUntilChanged()");
        return observableM11112r;
    }

    public final synchronized void loadMore(StoreSearch.SearchTarget searchTarget, long oldestMessageId) {
        C12238m.checkNotNullParameter(searchTarget, "searchTarget");
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

    public final void parseAndQuery(final StoreSearch searchStore, final StoreSearch.SearchTarget searchTarget, String queryString, final SearchStringProvider searchStringProvider, final boolean includeNsfw) {
        C12238m.checkNotNullParameter(searchStore, "searchStore");
        C12238m.checkNotNullParameter(searchTarget, "searchTarget");
        C12238m.checkNotNullParameter(queryString, "queryString");
        C12238m.checkNotNullParameter(searchStringProvider, "searchStringProvider");
        unsubscribe();
        if (!(!C12103t.isBlank(queryString))) {
            updateAndPublish(new SearchState(QueryFetchState.NONE, null, null, null, null, false, 0, 126, null));
            return;
        }
        updateAndPublish(new SearchState(QueryFetchState.IN_PROGRESS, null, null, null, null, false, 0, 126, null));
        Observable observableM11100Z = Observable.m11077j0(new C12721k(queryString).m11083G(new InterfaceC12589b<String, List<QueryNode>>() { // from class: com.discord.stores.StoreSearchQuery.parseAndQuery.1
            @Override // p637j0.p641k.InterfaceC12589b
            public final List<QueryNode> call(String str) {
                QueryParser queryParser = new QueryParser(searchStringProvider);
                C12238m.checkNotNullExpressionValue(str, "it");
                return Parser.parse$default(queryParser, str, null, null, 4, null);
            }
        }), searchStore.getStoreSearchData().get(), new Func2<List<QueryNode>, SearchData, SearchQuery>() { // from class: com.discord.stores.StoreSearchQuery.parseAndQuery.2
            @Override // p658rx.functions.Func2
            public final SearchQuery call(List<QueryNode> list, SearchData searchData) {
                QueryNode.Companion companion = QueryNode.INSTANCE;
                C12238m.checkNotNullExpressionValue(list, "queryNodes");
                C12238m.checkNotNullExpressionValue(searchData, "searchData");
                companion.preprocess(list, searchData);
                searchStore.persistQuery$app_productionGoogleRelease(searchTarget, list);
                return new SearchQuery.Builder().setIncludeNsfw(includeNsfw).buildFrom(list, searchData);
            }
        }).m11108k(C0879o.m177c(C63983.INSTANCE, null, 1L, TimeUnit.SECONDS)).m11100Z(1);
        C12238m.checkNotNullExpressionValue(observableM11100Z, "Observable\n            .…   )\n            .take(1)");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.computationBuffered(observableM11100Z), (117 & 1) != 0 ? null : null, "parseAndQuery", (Function1<? super Subscription, Unit>) ((117 & 4) != 0 ? null : null), new C63994(searchTarget), (Function1<? super Error, Unit>) ((117 & 16) != 0 ? null : null), (Function0<Unit>) ((117 & 32) != 0 ? ObservableExtensionsKt.C68813.INSTANCE : null), (Function0<Unit>) ((117 & 64) != 0 ? ObservableExtensionsKt.C68824.INSTANCE : null));
    }
}
