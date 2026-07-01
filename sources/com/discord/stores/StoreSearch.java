package com.discord.stores;

import android.content.Context;
import com.discord.api.user.NsfwAllowance;
import com.discord.stores.updates.ObservationDeck;
import com.discord.utilities.analytics.Traits$Payment$Type;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.search.history.MGPreferenceSearchHistoryCache;
import com.discord.utilities.search.history.SearchHistoryCache;
import com.discord.utilities.search.network.SearchFetcher;
import com.discord.utilities.search.query.node.QueryNode;
import com.discord.utilities.search.strings.SearchStringProvider;
import com.discord.utilities.search.suggestion.SearchSuggestionEngine;
import d0.z.d.m;
import java.util.Collection;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
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
    private final SerializedSubject<StoreSearch$DisplayState, StoreSearch$DisplayState> displayStateSubject;
    private final SearchHistoryCache historyCache;
    private StoreSearch$SearchTarget searchTarget;
    private final SerializedSubject<StoreSearch$SearchTarget, StoreSearch$SearchTarget> searchTargetSubject;
    private final StoreGuildsNsfw storeGuildsNsfw;
    private final StoreSearchData storeSearchData;
    private final StoreSearchInput storeSearchInput;
    private final StoreSearchQuery storeSearchQuery;
    private final StoreUser storeUser;
    private final StoreStream stream;
    private Subscription subscription;

    public StoreSearch(StoreSearchData storeSearchData, StoreSearchInput storeSearchInput, StoreSearchQuery storeSearchQuery, StoreStream storeStream, Dispatcher dispatcher, StoreGuildsNsfw storeGuildsNsfw, StoreUser storeUser, SearchHistoryCache searchHistoryCache) {
        m.checkNotNullParameter(storeSearchData, "storeSearchData");
        m.checkNotNullParameter(storeSearchInput, "storeSearchInput");
        m.checkNotNullParameter(storeSearchQuery, "storeSearchQuery");
        m.checkNotNullParameter(storeStream, "stream");
        m.checkNotNullParameter(dispatcher, "dispatcher");
        m.checkNotNullParameter(storeGuildsNsfw, "storeGuildsNsfw");
        m.checkNotNullParameter(storeUser, "storeUser");
        m.checkNotNullParameter(searchHistoryCache, "historyCache");
        this.storeSearchData = storeSearchData;
        this.storeSearchInput = storeSearchInput;
        this.storeSearchQuery = storeSearchQuery;
        this.stream = storeStream;
        this.dispatcher = dispatcher;
        this.storeGuildsNsfw = storeGuildsNsfw;
        this.storeUser = storeUser;
        this.historyCache = searchHistoryCache;
        this.displayStateSubject = new SerializedSubject<>(BehaviorSubject.l0(StoreSearch$DisplayState.SUGGESTIONS));
        this.searchTargetSubject = new SerializedSubject<>(BehaviorSubject.k0());
    }

    public static final /* synthetic */ Dispatcher access$getDispatcher$p(StoreSearch storeSearch) {
        return storeSearch.dispatcher;
    }

    public static final /* synthetic */ SearchHistoryCache access$getHistoryCache$p(StoreSearch storeSearch) {
        return storeSearch.historyCache;
    }

    public static final /* synthetic */ StoreStream access$getStream$p(StoreSearch storeSearch) {
        return storeSearch.stream;
    }

    public static final /* synthetic */ void access$handleSubscription(StoreSearch storeSearch, Subscription subscription) {
        storeSearch.handleSubscription(subscription);
    }

    public static final /* synthetic */ void access$onStateChanged(StoreSearch storeSearch, StoreSearch$DisplayState storeSearch$DisplayState) {
        storeSearch.onStateChanged(storeSearch$DisplayState);
    }

    private final synchronized void handleSubscription(Subscription subscription) {
        Subscription subscription2 = this.subscription;
        if (subscription2 != null) {
            subscription2.unsubscribe();
        }
        this.subscription = subscription;
    }

    private final boolean includeNsfw(StoreSearch$SearchTarget storeSearch$SearchTarget) {
        if (this.storeUser.getMeSnapshot().getNsfwAllowance() == NsfwAllowance.DISALLOWED) {
            return false;
        }
        int iOrdinal = storeSearch$SearchTarget.getType().ordinal();
        if (iOrdinal == 0) {
            return this.storeGuildsNsfw.isGuildNsfwGateAgreed(storeSearch$SearchTarget.getId());
        }
        if (iOrdinal == 1) {
            return true;
        }
        throw new NoWhenBranchMatchedException();
    }

    private final synchronized void init(StoreSearch$SearchTarget searchTarget, SearchStringProvider searchStringProvider) {
        if (m.areEqual(this.searchTarget, searchTarget)) {
            return;
        }
        updateTarget(searchTarget);
        this.storeSearchData.init(searchTarget);
        this.storeSearchInput.init(searchStringProvider);
        Observable observableI = Observable.I(this.storeSearchQuery.getState().y(StoreSearch$init$1.INSTANCE).G(StoreSearch$init$2.INSTANCE), this.storeSearchInput.getCurrentParsedInput().G(StoreSearch$init$3.INSTANCE));
        m.checkNotNullExpressionValue(observableI, "Observable\n        .merg…splayState.SUGGESTIONS })");
        ObservableExtensionsKt.appSubscribe$default(observableI, getClass(), (Context) null, new StoreSearch$init$4(this), (Function1) null, (Function0) null, (Function0) null, new StoreSearch$init$5(this), 58, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(this.storeSearchQuery.getState(), getClass(), (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new StoreSearch$init$6(this), 62, (Object) null);
    }

    private final void onStateChanged(StoreSearch$DisplayState displayState) {
        this.displayStateSubject.k.onNext(displayState);
    }

    private final synchronized void updateTarget(StoreSearch$SearchTarget searchTarget) {
        this.searchTarget = searchTarget;
        this.searchTargetSubject.k.onNext(searchTarget);
    }

    public final synchronized void clear() {
        updateTarget(null);
        handleSubscription(null);
        onStateChanged(StoreSearch$DisplayState.SUGGESTIONS);
        this.storeSearchQuery.clear();
        this.storeSearchInput.clear();
        this.storeSearchData.clear();
    }

    public final void clearHistory() {
        SearchHistoryCache searchHistoryCache = this.historyCache;
        StoreSearch$SearchTarget storeSearch$SearchTarget = this.searchTarget;
        if (storeSearch$SearchTarget != null) {
            searchHistoryCache.clear(storeSearch$SearchTarget);
        }
    }

    public final Observable<StoreSearch$DisplayState> getDisplayState() {
        Observable<StoreSearch$DisplayState> observableR = ObservableExtensionsKt.computationLatest(this.displayStateSubject).r();
        m.checkNotNullExpressionValue(observableR, "displayStateSubject\n    …  .distinctUntilChanged()");
        return observableR;
    }

    public final Observable<Collection<List<QueryNode>>> getHistory() {
        Observable observableY = this.searchTargetSubject.Y(new StoreSearch$getHistory$1(this));
        m.checkNotNullExpressionValue(observableY, "searchTargetSubject\n    …())\n          }\n        }");
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
        m.checkNotNullParameter(searchStringProvider, "searchStringProvider");
        init(new StoreSearch$SearchTarget(StoreSearch$SearchTarget$Type.CHANNEL, channelId), searchStringProvider);
        SearchSuggestionEngine.INSTANCE.setTargetGuildId(null);
    }

    public final void initForGuild(long guildId, SearchStringProvider searchStringProvider) {
        m.checkNotNullParameter(searchStringProvider, "searchStringProvider");
        init(new StoreSearch$SearchTarget(StoreSearch$SearchTarget$Type.GUILD, guildId), searchStringProvider);
        SearchSuggestionEngine.INSTANCE.setTargetGuildId(Long.valueOf(guildId));
    }

    public final void loadInitial(String queryString, SearchStringProvider searchStringProvider) {
        m.checkNotNullParameter(queryString, "queryString");
        m.checkNotNullParameter(searchStringProvider, "searchStringProvider");
        StoreSearch$SearchTarget storeSearch$SearchTarget = this.searchTarget;
        if (storeSearch$SearchTarget != null) {
            this.storeSearchQuery.parseAndQuery(this, storeSearch$SearchTarget, queryString, searchStringProvider, includeNsfw(storeSearch$SearchTarget));
        }
    }

    public final void loadMore(long oldestMessageId) {
        StoreSearch$SearchTarget storeSearch$SearchTarget = this.searchTarget;
        if (storeSearch$SearchTarget != null) {
            this.storeSearchQuery.loadMore(storeSearch$SearchTarget, oldestMessageId);
        }
    }

    public final void persistQuery$app_productionGoogleRelease(StoreSearch$SearchTarget searchTarget, List<? extends QueryNode> query) {
        m.checkNotNullParameter(searchTarget, "searchTarget");
        m.checkNotNullParameter(query, "query");
        this.historyCache.persistQuery(searchTarget, query);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StoreSearch(StoreStream storeStream, Dispatcher dispatcher, StoreGuildsNsfw storeGuildsNsfw, StoreUser storeUser, ObservationDeck observationDeck, StoreChannels storeChannels, StoreGuilds storeGuilds) {
        this(new StoreSearchData(observationDeck, storeChannels, storeUser, storeGuilds), new StoreSearchInput(), new StoreSearchQuery(new SearchFetcher()), storeStream, dispatcher, storeGuildsNsfw, storeUser, new MGPreferenceSearchHistoryCache());
        m.checkNotNullParameter(storeStream, "stream");
        m.checkNotNullParameter(dispatcher, "dispatcher");
        m.checkNotNullParameter(storeGuildsNsfw, "storeGuildsNsfw");
        m.checkNotNullParameter(storeUser, "storeUser");
        m.checkNotNullParameter(observationDeck, "observationDeck");
        m.checkNotNullParameter(storeChannels, "storeChannels");
        m.checkNotNullParameter(storeGuilds, "storeGuilds");
    }
}
