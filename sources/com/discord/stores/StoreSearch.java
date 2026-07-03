package com.discord.stores;

import com.discord.api.user.NsfwAllowance;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.stores.updates.ObservationDeck;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.search.history.MGPreferenceSearchHistoryCache;
import com.discord.utilities.search.history.SearchHistoryCache;
import com.discord.utilities.search.network.SearchFetcher;
import com.discord.utilities.search.network.state.QueryFetchState;
import com.discord.utilities.search.network.state.SearchState;
import com.discord.utilities.search.query.node.QueryNode;
import com.discord.utilities.search.strings.SearchStringProvider;
import com.discord.utilities.search.suggestion.SearchSuggestionEngine;
import com.discord.widgets.chat.AutocompleteSelectionTypes;
import java.util.Collection;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import p001a0.p002a.p003a.C0002b;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p580t.C12147n;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;
import p637j0.p641k.InterfaceC12589b;
import p637j0.p642l.p647e.C12721k;
import p658rx.Observable;
import p658rx.Subscription;
import p658rx.subjects.BehaviorSubject;
import p658rx.subjects.SerializedSubject;

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
            C12238m.checkNotNullParameter(type, "type");
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
            C12238m.checkNotNullParameter(type, "type");
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
            return C12238m.areEqual(this.type, searchTarget.type) && this.id == searchTarget.id;
        }

        public final long getId() {
            return this.id;
        }

        public final Type getType() {
            return this.type;
        }

        public int hashCode() {
            Type type = this.type;
            return C0002b.m3a(this.id) + ((type != null ? type.hashCode() : 0) * 31);
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("SearchTarget(type=");
            sbM833U.append(this.type);
            sbM833U.append(", id=");
            return C1643a.m815C(sbM833U, this.id, ")");
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

    /* JADX INFO: renamed from: com.discord.stores.StoreSearch$init$4 */
    /* JADX INFO: compiled from: StoreSearch.kt */
    public static final /* synthetic */ class C63804 extends C12236k implements Function1<Subscription, Unit> {
        public C63804(StoreSearch storeSearch) {
            super(1, storeSearch, StoreSearch.class, "handleSubscription", "handleSubscription(Lrx/Subscription;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Subscription subscription) {
            invoke2(subscription);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Subscription subscription) {
            ((StoreSearch) this.receiver).handleSubscription(subscription);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreSearch$init$5 */
    /* JADX INFO: compiled from: StoreSearch.kt */
    public static final class C63815 extends AbstractC12240o implements Function1<DisplayState, Unit> {
        public C63815() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(DisplayState displayState) {
            invoke2(displayState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(DisplayState displayState) {
            if (displayState != DisplayState.RESULTS) {
                StoreSearch.this.getStoreSearchQuery().clear();
            }
            StoreSearch storeSearch = StoreSearch.this;
            C12238m.checkNotNullExpressionValue(displayState, "it");
            storeSearch.onStateChanged(displayState);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreSearch$init$6 */
    /* JADX INFO: compiled from: StoreSearch.kt */
    public static final class C63826 extends AbstractC12240o implements Function1<SearchState, Unit> {

        /* JADX INFO: renamed from: com.discord.stores.StoreSearch$init$6$1, reason: invalid class name */
        /* JADX INFO: compiled from: StoreSearch.kt */
        public static final class AnonymousClass1 extends AbstractC12240o implements Function0<Unit> {
            public final /* synthetic */ SearchState $searchState;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(SearchState searchState) {
                super(0);
                this.$searchState = searchState;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f27425a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                StoreSearch.this.stream.handleSearchFinish(this.$searchState);
            }
        }

        public C63826() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(SearchState searchState) {
            invoke2(searchState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SearchState searchState) {
            C12238m.checkNotNullParameter(searchState, "searchState");
            StoreSearch.this.dispatcher.schedule(new AnonymousClass1(searchState));
        }
    }

    public StoreSearch(StoreSearchData storeSearchData, StoreSearchInput storeSearchInput, StoreSearchQuery storeSearchQuery, StoreStream storeStream, Dispatcher dispatcher, StoreGuildsNsfw storeGuildsNsfw, StoreUser storeUser, SearchHistoryCache searchHistoryCache) {
        C12238m.checkNotNullParameter(storeSearchData, "storeSearchData");
        C12238m.checkNotNullParameter(storeSearchInput, "storeSearchInput");
        C12238m.checkNotNullParameter(storeSearchQuery, "storeSearchQuery");
        C12238m.checkNotNullParameter(storeStream, "stream");
        C12238m.checkNotNullParameter(dispatcher, "dispatcher");
        C12238m.checkNotNullParameter(storeGuildsNsfw, "storeGuildsNsfw");
        C12238m.checkNotNullParameter(storeUser, "storeUser");
        C12238m.checkNotNullParameter(searchHistoryCache, "historyCache");
        this.storeSearchData = storeSearchData;
        this.storeSearchInput = storeSearchInput;
        this.storeSearchQuery = storeSearchQuery;
        this.stream = storeStream;
        this.dispatcher = dispatcher;
        this.storeGuildsNsfw = storeGuildsNsfw;
        this.storeUser = storeUser;
        this.historyCache = searchHistoryCache;
        this.displayStateSubject = new SerializedSubject<>(BehaviorSubject.m11130l0(DisplayState.SUGGESTIONS));
        this.searchTargetSubject = new SerializedSubject<>(BehaviorSubject.m11129k0());
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
        if (C12238m.areEqual(this.searchTarget, searchTarget)) {
            return;
        }
        updateTarget(searchTarget);
        this.storeSearchData.init(searchTarget);
        this.storeSearchInput.init(searchStringProvider);
        Observable observableM11064I = Observable.m11064I(this.storeSearchQuery.getState().m11118y(new InterfaceC12589b<SearchState, Boolean>() { // from class: com.discord.stores.StoreSearch.init.1
            @Override // p637j0.p641k.InterfaceC12589b
            public final Boolean call(SearchState searchState) {
                return Boolean.valueOf(searchState.getQueryFetchState() != QueryFetchState.NONE);
            }
        }).m11083G(new InterfaceC12589b<SearchState, DisplayState>() { // from class: com.discord.stores.StoreSearch.init.2
            @Override // p637j0.p641k.InterfaceC12589b
            public final DisplayState call(SearchState searchState) {
                return DisplayState.RESULTS;
            }
        }), this.storeSearchInput.getCurrentParsedInput().m11083G(new InterfaceC12589b<List<? extends QueryNode>, DisplayState>() { // from class: com.discord.stores.StoreSearch.init.3
            @Override // p637j0.p641k.InterfaceC12589b
            public final DisplayState call(List<? extends QueryNode> list) {
                return DisplayState.SUGGESTIONS;
            }
        }));
        C12238m.checkNotNullExpressionValue(observableM11064I, "Observable\n        .merg…splayState.SUGGESTIONS })");
        ObservableExtensionsKt.appSubscribe(observableM11064I, (Class<?>) getClass(), (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : new C63804(this)), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C63815());
        ObservableExtensionsKt.appSubscribe(this.storeSearchQuery.getState(), (Class<?>) getClass(), (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C63826());
    }

    private final void onStateChanged(DisplayState displayState) {
        this.displayStateSubject.f27653k.onNext(displayState);
    }

    private final synchronized void updateTarget(SearchTarget searchTarget) {
        this.searchTarget = searchTarget;
        this.searchTargetSubject.f27653k.onNext(searchTarget);
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
        Observable<DisplayState> observableM11112r = ObservableExtensionsKt.computationLatest(this.displayStateSubject).m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r, "displayStateSubject\n    …  .distinctUntilChanged()");
        return observableM11112r;
    }

    public final Observable<Collection<List<QueryNode>>> getHistory() {
        Observable observableM11099Y = this.searchTargetSubject.m11099Y(new InterfaceC12589b<SearchTarget, Observable<? extends Collection<? extends List<? extends QueryNode>>>>() { // from class: com.discord.stores.StoreSearch.getHistory.1
            @Override // p637j0.p641k.InterfaceC12589b
            public final Observable<? extends Collection<List<QueryNode>>> call(SearchTarget searchTarget) {
                return searchTarget != null ? StoreSearch.this.historyCache.getHistory(searchTarget) : new C12721k(C12147n.emptyList());
            }
        });
        C12238m.checkNotNullExpressionValue(observableM11099Y, "searchTargetSubject\n    …())\n          }\n        }");
        return observableM11099Y;
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
        C12238m.checkNotNullParameter(searchStringProvider, "searchStringProvider");
        init(new SearchTarget(SearchTarget.Type.CHANNEL, channelId), searchStringProvider);
        SearchSuggestionEngine.INSTANCE.setTargetGuildId(null);
    }

    public final void initForGuild(long guildId, SearchStringProvider searchStringProvider) {
        C12238m.checkNotNullParameter(searchStringProvider, "searchStringProvider");
        init(new SearchTarget(SearchTarget.Type.GUILD, guildId), searchStringProvider);
        SearchSuggestionEngine.INSTANCE.setTargetGuildId(Long.valueOf(guildId));
    }

    public final void loadInitial(String queryString, SearchStringProvider searchStringProvider) {
        C12238m.checkNotNullParameter(queryString, "queryString");
        C12238m.checkNotNullParameter(searchStringProvider, "searchStringProvider");
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
        C12238m.checkNotNullParameter(searchTarget, "searchTarget");
        C12238m.checkNotNullParameter(query, "query");
        this.historyCache.persistQuery(searchTarget, query);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StoreSearch(StoreStream storeStream, Dispatcher dispatcher, StoreGuildsNsfw storeGuildsNsfw, StoreUser storeUser, ObservationDeck observationDeck, StoreChannels storeChannels, StoreGuilds storeGuilds) {
        this(new StoreSearchData(observationDeck, storeChannels, storeUser, storeGuilds), new StoreSearchInput(), new StoreSearchQuery(new SearchFetcher()), storeStream, dispatcher, storeGuildsNsfw, storeUser, new MGPreferenceSearchHistoryCache());
        C12238m.checkNotNullParameter(storeStream, "stream");
        C12238m.checkNotNullParameter(dispatcher, "dispatcher");
        C12238m.checkNotNullParameter(storeGuildsNsfw, "storeGuildsNsfw");
        C12238m.checkNotNullParameter(storeUser, "storeUser");
        C12238m.checkNotNullParameter(observationDeck, "observationDeck");
        C12238m.checkNotNullParameter(storeChannels, "storeChannels");
        C12238m.checkNotNullParameter(storeGuilds, "storeGuilds");
    }
}
