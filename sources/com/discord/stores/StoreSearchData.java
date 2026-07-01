package com.discord.stores;

import android.content.Context;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck$UpdateSource;
import com.discord.utilities.analytics.Traits$Payment$Type;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.rx.ObservableWithLeadingEdgeThrottle;
import com.discord.utilities.search.validation.SearchData;
import com.discord.utilities.search.validation.SearchData$Builder;
import d0.z.d.m;
import java.util.concurrent.TimeUnit;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import rx.Observable;
import rx.Subscription;
import rx.subjects.BehaviorSubject;
import rx.subjects.Subject;

/* JADX INFO: compiled from: StoreSearchData.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreSearchData {
    private final ObservationDeck observationDeck;
    private final Subject<SearchData, SearchData> searchDataSubject;
    private final StoreChannels storeChannels;
    private final StoreGuilds storeGuilds;
    private final StoreUser storeUser;
    private Subscription subscription;

    public StoreSearchData(ObservationDeck observationDeck, StoreChannels storeChannels, StoreUser storeUser, StoreGuilds storeGuilds) {
        m.checkNotNullParameter(observationDeck, "observationDeck");
        m.checkNotNullParameter(storeChannels, "storeChannels");
        m.checkNotNullParameter(storeUser, "storeUser");
        m.checkNotNullParameter(storeGuilds, "storeGuilds");
        this.observationDeck = observationDeck;
        this.storeChannels = storeChannels;
        this.storeUser = storeUser;
        this.storeGuilds = storeGuilds;
        BehaviorSubject behaviorSubjectL0 = BehaviorSubject.l0(new SearchData(null, null, null, null, null, 31, null));
        m.checkNotNullExpressionValue(behaviorSubjectL0, "BehaviorSubject.create(SearchData())");
        this.searchDataSubject = behaviorSubjectL0;
    }

    public static final /* synthetic */ StoreChannels access$getStoreChannels$p(StoreSearchData storeSearchData) {
        return storeSearchData.storeChannels;
    }

    public static final /* synthetic */ StoreGuilds access$getStoreGuilds$p(StoreSearchData storeSearchData) {
        return storeSearchData.storeGuilds;
    }

    public static final /* synthetic */ StoreUser access$getStoreUser$p(StoreSearchData storeSearchData) {
        return storeSearchData.storeUser;
    }

    public static final /* synthetic */ void access$handleNewData(StoreSearchData storeSearchData, SearchData searchData) {
        storeSearchData.handleNewData(searchData);
    }

    public static final /* synthetic */ void access$handleSubscription(StoreSearchData storeSearchData, Subscription subscription) {
        storeSearchData.handleSubscription(subscription);
    }

    private final Observable<SearchData> getChannelSearchData(long channelId) {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck$UpdateSource[]{this.storeChannels, this.storeUser, this.storeGuilds}, false, null, null, new StoreSearchData$getChannelSearchData$1(this, channelId), 14, null);
    }

    private final Observable<SearchData> getGuildSearchData(long guildId) {
        StoreStream$Companion storeStream$Companion = StoreStream.Companion;
        Observable<SearchData> observableCombineLatest = ObservableWithLeadingEdgeThrottle.combineLatest(storeStream$Companion.getGuilds().observeComputed(guildId), storeStream$Companion.getUsers().observeAllUsers(), StoreChannels.observeChannelsForGuild$default(storeStream$Companion.getChannels(), guildId, null, 2, null).G(StoreSearchData$getGuildSearchData$1.INSTANCE), storeStream$Companion.getPermissions().observeChannelPermissionsForGuild(guildId), new StoreSearchData$sam$rx_functions_Func4$0(new StoreSearchData$getGuildSearchData$2(new SearchData$Builder())), 3L, TimeUnit.SECONDS);
        m.checkNotNullExpressionValue(observableCombineLatest, "ObservableWithLeadingEdg…3, TimeUnit.SECONDS\n    )");
        return observableCombineLatest;
    }

    private final void handleNewData(SearchData searchData) {
        this.searchDataSubject.onNext(searchData);
    }

    private final synchronized void handleSubscription(Subscription subscription) {
        Subscription subscription2 = this.subscription;
        if (subscription2 != null) {
            subscription2.unsubscribe();
        }
        this.subscription = subscription;
    }

    public final void clear() {
        handleSubscription(null);
        handleNewData(new SearchData(null, null, null, null, null, 31, null));
    }

    public final Observable<SearchData> get() {
        return this.searchDataSubject;
    }

    public final void init(StoreSearch$SearchTarget searchTarget) {
        Observable<SearchData> guildSearchData;
        m.checkNotNullParameter(searchTarget, "searchTarget");
        int iOrdinal = searchTarget.getType().ordinal();
        if (iOrdinal == 0) {
            guildSearchData = getGuildSearchData(searchTarget.getId());
        } else {
            if (iOrdinal != 1) {
                throw new NoWhenBranchMatchedException();
            }
            guildSearchData = getChannelSearchData(searchTarget.getId());
        }
        Observable observableR = ObservableExtensionsKt.computationBuffered(guildSearchData).r();
        m.checkNotNullExpressionValue(observableR, "searchDataObservable\n   …  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(observableR, StoreSearchData.class, (Context) null, new StoreSearchData$init$1(this), (Function1) null, (Function0) null, (Function0) null, new StoreSearchData$init$2(this), 58, (Object) null);
    }
}
