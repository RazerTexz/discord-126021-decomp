package com.discord.stores;

import a0.a.a.b;
import b.d.b.a.outline;
import com.discord.api.user.NsfwAllowance;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.stores.updates.ObservationDeck;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.error.Error;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.search.history.MGPreferenceSearchHistoryCache;
import com.discord.utilities.search.history.SearchHistoryCache;
import com.discord.utilities.search.network.SearchFetcher;
import com.discord.utilities.search.network.state.QueryFetchState;
import com.discord.utilities.search.network.state.SearchState;
import com.discord.utilities.search.query.node.QueryNode;
import com.discord.utilities.search.strings.SearchStringProvider;
import com.discord.utilities.search.suggestion.SearchSuggestionEngine;
import com.discord.widgets.chat.AutocompleteUtils;
import d0.t.Collections2;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.k.Func1;
import j0.l.e.ScalarSynchronousObservable;
import java.util.Collection;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import rx.Observable;
import rx.Subscription;
import rx.subjects.BehaviorSubject;
import rx.subjects.SerializedSubject;

/* JADX INFO: compiled from: StoreSearch.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreSearch {
    private final Dispatcher dispatcher;
    private final SerializedSubject<DisplayState, DisplayState> displayStateSubject;
    private final SearchHistoryCache historyCache;
    private SearchTarget searchTarget;
    private final SerializedSubject<SearchTarget, SearchTarget> searchTargetSubject;
    private final StoreGuildsNsfw storeGuildsNsfw;
    private final StoreSearchData storeSearchData;
    private final StoreSearchInput storeSearchInput;
    private final StoreSearchQuery storeSearchQuery;
    private final StoreUser storeUser;
    private final StoreStream stream;
    private Subscription subscription;

    /* JADX INFO: compiled from: StoreSearch.kt */
    public enum DisplayState {
        SUGGESTIONS,
        RESULTS
    }

    /* JADX INFO: compiled from: StoreSearch.kt */
    public static final /* data */ class SearchTarget {
        private final long id;
        private final Type type;

        /* JADX INFO: compiled from: StoreSearch.kt */
        public enum Type {
            GUILD,
            CHANNEL
        }

        public SearchTarget(Type type, long j) {
            Intrinsics3.checkNotNullParameter(type, "type");
            this.type = type;
            this.id = j;
        }

        public static /* synthetic */ SearchTarget copy$default(SearchTarget searchTarget, Type type, long j, int i, Object obj) {
            if ((i & 1) != 0) {
                type = searchTarget.type;
            }
            if ((i & 2) != 0) {
                j = searchTarget.id;
            }
            return searchTarget.copy(type, j);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Type getType() {
            return this.type;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final long getId() {
            return this.id;
        }

        public final SearchTarget copy(Type type, long id2) {
            Intrinsics3.checkNotNullParameter(type, "type");
            return new SearchTarget(type, id2);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SearchTarget)) {
                return false;
            }
            SearchTarget searchTarget = (SearchTarget) other;
            return Intrinsics3.areEqual(this.type, searchTarget.type) && this.id == searchTarget.id;
        }

        public final long getId() {
            return this.id;
        }

        public final Type getType() {
            return this.type;
        }

        public int hashCode() {
            Type type = this.type;
            return b.a(this.id) + ((type != null ? type.hashCode() : 0) * 31);
        }

        public String toString() {
            StringBuilder sbU = outline.U("SearchTarget(type=");
            sbU.append(this.type);
            sbU.append(", id=");
            return outline.C(sbU, this.id, ")");
        }
    }

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            SearchTarget.Type.values();
            int[] iArr = new int[2];
            $EnumSwitchMapping$0 = iArr;
            iArr[SearchTarget.Type.GUILD.ordinal()] = 1;
            iArr[SearchTarget.Type.CHANNEL.ordinal()] = 2;
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreSearch$init$4, reason: invalid class name */
    /* JADX INFO: compiled from: StoreSearch.kt */
    public static final /* synthetic */ class AnonymousClass4 extends FunctionReferenceImpl implements Function1<Subscription, Unit> {
        public AnonymousClass4(StoreSearch storeSearch) {
            super(1, storeSearch, StoreSearch.class, "handleSubscription", "handleSubscription(Lrx/Subscription;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Subscription subscription) {
            invoke2(subscription);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Subscription subscription) {
            ((StoreSearch) this.receiver).handleSubscription(subscription);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreSearch$init$5, reason: invalid class name */
    /* JADX INFO: compiled from: StoreSearch.kt */
    public static final class AnonymousClass5 extends Lambda implements Function1<DisplayState, Unit> {
        public AnonymousClass5() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(DisplayState displayState) {
            invoke2(displayState);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(DisplayState displayState) {
            if (displayState != DisplayState.RESULTS) {
                StoreSearch.this.getStoreSearchQuery().clear();
            }
            StoreSearch storeSearch = StoreSearch.this;
            Intrinsics3.checkNotNullExpressionValue(displayState, "it");
            storeSearch.onStateChanged(displayState);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreSearch$init$6, reason: invalid class name */
    /* JADX INFO: compiled from: StoreSearch.kt */
    public static final class AnonymousClass6 extends Lambda implements Function1<SearchState, Unit> {

        /* JADX INFO: renamed from: com.discord.stores.StoreSearch$init$6$1, reason: invalid class name */
        /* JADX INFO: compiled from: StoreSearch.kt */
        public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
            public final /* synthetic */ SearchState $searchState;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(SearchState searchState) {
                super(0);
                this.$searchState = searchState;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                StoreSearch.this.stream.handleSearchFinish(this.$searchState);
            }
        }

        public AnonymousClass6() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(SearchState searchState) {
            invoke2(searchState);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SearchState searchState) {
            Intrinsics3.checkNotNullParameter(searchState, "searchState");
            StoreSearch.this.dispatcher.schedule(new AnonymousClass1(searchState));
        }
    }

    public StoreSearch(StoreSearchData storeSearchData, StoreSearchInput storeSearchInput, StoreSearchQuery storeSearchQuery, StoreStream storeStream, Dispatcher dispatcher, StoreGuildsNsfw storeGuildsNsfw, StoreUser storeUser, SearchHistoryCache searchHistoryCache) {
        Intrinsics3.checkNotNullParameter(storeSearchData, "storeSearchData");
        Intrinsics3.checkNotNullParameter(storeSearchInput, "storeSearchInput");
        Intrinsics3.checkNotNullParameter(storeSearchQuery, "storeSearchQuery");
        Intrinsics3.checkNotNullParameter(storeStream, "stream");
        Intrinsics3.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics3.checkNotNullParameter(storeGuildsNsfw, "storeGuildsNsfw");
        Intrinsics3.checkNotNullParameter(storeUser, "storeUser");
        Intrinsics3.checkNotNullParameter(searchHistoryCache, "historyCache");
        this.storeSearchData = storeSearchData;
        this.storeSearchInput = storeSearchInput;
        this.storeSearchQuery = storeSearchQuery;
        this.stream = storeStream;
        this.dispatcher = dispatcher;
        this.storeGuildsNsfw = storeGuildsNsfw;
        this.storeUser = storeUser;
        this.historyCache = searchHistoryCache;
        this.displayStateSubject = new SerializedSubject<>(BehaviorSubject.l0(DisplayState.SUGGESTIONS));
        this.searchTargetSubject = new SerializedSubject<>(BehaviorSubject.k0());
    }

    private final synchronized void handleSubscription(Subscription subscription) {
        Subscription subscription2 = this.subscription;
        if (subscription2 != null) {
            subscription2.unsubscribe();
        }
        this.subscription = subscription;
    }

    private final boolean includeNsfw(SearchTarget searchTarget) {
        if (this.storeUser.getMeSnapshot().getNsfwAllowance() == NsfwAllowance.DISALLOWED) {
            return false;
        }
        int iOrdinal = searchTarget.getType().ordinal();
        if (iOrdinal == 0) {
            return this.storeGuildsNsfw.isGuildNsfwGateAgreed(searchTarget.getId());
        }
        if (iOrdinal == 1) {
            return true;
        }
        throw new NoWhenBranchMatchedException();
    }

    private final synchronized void init(SearchTarget searchTarget, SearchStringProvider searchStringProvider) {
        if (Intrinsics3.areEqual(this.searchTarget, searchTarget)) {
            return;
        }
        updateTarget(searchTarget);
        this.storeSearchData.init(searchTarget);
        this.storeSearchInput.init(searchStringProvider);
        Observable observableI = Observable.I(this.storeSearchQuery.getState().y(new Func1<SearchState, Boolean>() { // from class: com.discord.stores.StoreSearch.init.1
            @Override // j0.k.Func1
            public final Boolean call(SearchState searchState) {
                return Boolean.valueOf(searchState.getQueryFetchState() != QueryFetchState.NONE);
            }
        }).G(new Func1<SearchState, DisplayState>() { // from class: com.discord.stores.StoreSearch.init.2
            @Override // j0.k.Func1
            public final DisplayState call(SearchState searchState) {
                return DisplayState.RESULTS;
            }
        }), this.storeSearchInput.getCurrentParsedInput().G(new Func1<List<? extends QueryNode>, DisplayState>() { // from class: com.discord.stores.StoreSearch.init.3
            @Override // j0.k.Func1
            public final DisplayState call(List<? extends QueryNode> list) {
                return DisplayState.SUGGESTIONS;
            }
        }));
        Intrinsics3.checkNotNullExpressionValue(observableI, "Observable\n        .merg…splayState.SUGGESTIONS })");
        ObservableExtensionsKt.appSubscribe(observableI, (Class<?>) getClass(), (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : new AnonymousClass4(this)), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass5());
        ObservableExtensionsKt.appSubscribe(this.storeSearchQuery.getState(), (Class<?>) getClass(), (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass6());
    }

    private final void onStateChanged(DisplayState displayState) {
        this.displayStateSubject.k.onNext(displayState);
    }

    private final synchronized void updateTarget(SearchTarget searchTarget) {
        this.searchTarget = searchTarget;
        this.searchTargetSubject.k.onNext(searchTarget);
    }

    public final synchronized void clear() {
        updateTarget(null);
        handleSubscription(null);
        onStateChanged(DisplayState.SUGGESTIONS);
        this.storeSearchQuery.clear();
        this.storeSearchInput.clear();
        this.storeSearchData.clear();
    }

    public final void clearHistory() {
        SearchHistoryCache searchHistoryCache = this.historyCache;
        SearchTarget searchTarget = this.searchTarget;
        if (searchTarget != null) {
            searchHistoryCache.clear(searchTarget);
        }
    }

    public final Observable<DisplayState> getDisplayState() {
        Observable<DisplayState> observableR = ObservableExtensionsKt.computationLatest(this.displayStateSubject).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "displayStateSubject\n    …  .distinctUntilChanged()");
        return observableR;
    }

    public final Observable<Collection<List<QueryNode>>> getHistory() {
        Observable observableY = this.searchTargetSubject.Y(new Func1<SearchTarget, Observable<? extends Collection<? extends List<? extends QueryNode>>>>() { // from class: com.discord.stores.StoreSearch.getHistory.1
            @Override // j0.k.Func1
            public final Observable<? extends Collection<List<QueryNode>>> call(SearchTarget searchTarget) {
                return searchTarget != null ? StoreSearch.this.historyCache.getHistory(searchTarget) : new ScalarSynchronousObservable(Collections2.emptyList());
            }
        });
        Intrinsics3.checkNotNullExpressionValue(observableY, "searchTargetSubject\n    …())\n          }\n        }");
        return observableY;
    }

    public final StoreSearchData getStoreSearchData() {
        return this.storeSearchData;
    }

    public final StoreSearchInput getStoreSearchInput() {
        return this.storeSearchInput;
    }

    public final StoreSearchQuery getStoreSearchQuery() {
        return this.storeSearchQuery;
    }

    public final void initForChannel(long channelId, SearchStringProvider searchStringProvider) {
        Intrinsics3.checkNotNullParameter(searchStringProvider, "searchStringProvider");
        init(new SearchTarget(SearchTarget.Type.CHANNEL, channelId), searchStringProvider);
        SearchSuggestionEngine.INSTANCE.setTargetGuildId(null);
    }

    public final void initForGuild(long guildId, SearchStringProvider searchStringProvider) {
        Intrinsics3.checkNotNullParameter(searchStringProvider, "searchStringProvider");
        init(new SearchTarget(SearchTarget.Type.GUILD, guildId), searchStringProvider);
        SearchSuggestionEngine.INSTANCE.setTargetGuildId(Long.valueOf(guildId));
    }

    public final void loadInitial(String queryString, SearchStringProvider searchStringProvider) {
        Intrinsics3.checkNotNullParameter(queryString, "queryString");
        Intrinsics3.checkNotNullParameter(searchStringProvider, "searchStringProvider");
        SearchTarget searchTarget = this.searchTarget;
        if (searchTarget != null) {
            this.storeSearchQuery.parseAndQuery(this, searchTarget, queryString, searchStringProvider, includeNsfw(searchTarget));
        }
    }

    public final void loadMore(long oldestMessageId) {
        SearchTarget searchTarget = this.searchTarget;
        if (searchTarget != null) {
            this.storeSearchQuery.loadMore(searchTarget, oldestMessageId);
        }
    }

    public final void persistQuery$app_productionGoogleRelease(SearchTarget searchTarget, List<? extends QueryNode> query) {
        Intrinsics3.checkNotNullParameter(searchTarget, "searchTarget");
        Intrinsics3.checkNotNullParameter(query, "query");
        this.historyCache.persistQuery(searchTarget, query);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StoreSearch(StoreStream storeStream, Dispatcher dispatcher, StoreGuildsNsfw storeGuildsNsfw, StoreUser storeUser, ObservationDeck observationDeck, StoreChannels storeChannels, StoreGuilds storeGuilds) {
        this(new StoreSearchData(observationDeck, storeChannels, storeUser, storeGuilds), new StoreSearchInput(), new StoreSearchQuery(new SearchFetcher()), storeStream, dispatcher, storeGuildsNsfw, storeUser, new MGPreferenceSearchHistoryCache());
        Intrinsics3.checkNotNullParameter(storeStream, "stream");
        Intrinsics3.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics3.checkNotNullParameter(storeGuildsNsfw, "storeGuildsNsfw");
        Intrinsics3.checkNotNullParameter(storeUser, "storeUser");
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        Intrinsics3.checkNotNullParameter(storeChannels, "storeChannels");
        Intrinsics3.checkNotNullParameter(storeGuilds, "storeGuilds");
    }
}
