package com.discord.stores;

import com.discord.models.domain.ModelChannelFollowerStats;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck$UpdateSource;
import com.discord.utilities.time.ClockFactory;
import d0.z.d.m;
import java.util.HashMap;
import java.util.Map;
import rx.Observable;

/* JADX INFO: compiled from: StoreChannelFollowerStats.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreChannelFollowerStats extends StoreV2 {
    public static final StoreChannelFollowerStats$Companion Companion = new StoreChannelFollowerStats$Companion(null);
    private static final int STALE_TIME_DIFF_MS = 3600000;
    private final Map<Long, StoreChannelFollowerStats$ChannelFollowerStatData> channelFollowerStatsState;
    private Map<Long, StoreChannelFollowerStats$ChannelFollowerStatData> channelFollowerStatsStateSnapshot;
    private final Dispatcher dispatcher;
    private final ObservationDeck observationDeck;

    public StoreChannelFollowerStats(Dispatcher dispatcher, ObservationDeck observationDeck) {
        m.checkNotNullParameter(dispatcher, "dispatcher");
        m.checkNotNullParameter(observationDeck, "observationDeck");
        this.dispatcher = dispatcher;
        this.observationDeck = observationDeck;
        this.channelFollowerStatsState = new HashMap();
        this.channelFollowerStatsStateSnapshot = new HashMap();
    }

    public static final /* synthetic */ Map access$getChannelFollowerStatsState$p(StoreChannelFollowerStats storeChannelFollowerStats) {
        return storeChannelFollowerStats.channelFollowerStatsState;
    }

    public static final /* synthetic */ Map access$getChannelFollowerStatsStateSnapshot$p(StoreChannelFollowerStats storeChannelFollowerStats) {
        return storeChannelFollowerStats.channelFollowerStatsStateSnapshot;
    }

    public static final /* synthetic */ Dispatcher access$getDispatcher$p(StoreChannelFollowerStats storeChannelFollowerStats) {
        return storeChannelFollowerStats.dispatcher;
    }

    public static final /* synthetic */ void access$handleChannelFollowerStatsFetchFailed(StoreChannelFollowerStats storeChannelFollowerStats, long j) {
        storeChannelFollowerStats.handleChannelFollowerStatsFetchFailed(j);
    }

    public static final /* synthetic */ void access$handleChannelFollowerStatsFetchStart(StoreChannelFollowerStats storeChannelFollowerStats, long j) {
        storeChannelFollowerStats.handleChannelFollowerStatsFetchStart(j);
    }

    public static final /* synthetic */ void access$handleChannelFollowerStatsFetchSuccess(StoreChannelFollowerStats storeChannelFollowerStats, long j, ModelChannelFollowerStats modelChannelFollowerStats) {
        storeChannelFollowerStats.handleChannelFollowerStatsFetchSuccess(j, modelChannelFollowerStats);
    }

    public static final /* synthetic */ boolean access$isExisting(StoreChannelFollowerStats storeChannelFollowerStats, long j) {
        return storeChannelFollowerStats.isExisting(j);
    }

    public static final /* synthetic */ boolean access$isStale(StoreChannelFollowerStats storeChannelFollowerStats, long j) {
        return storeChannelFollowerStats.isStale(j);
    }

    public static final /* synthetic */ void access$setChannelFollowerStatsStateSnapshot$p(StoreChannelFollowerStats storeChannelFollowerStats, Map map) {
        storeChannelFollowerStats.channelFollowerStatsStateSnapshot = map;
    }

    @StoreThread
    private final void fetchIfNonexistingOrStale(long channelId) {
        this.dispatcher.schedule(new StoreChannelFollowerStats$fetchIfNonexistingOrStale$1(this, channelId));
    }

    @StoreThread
    private final void handleChannelFollowerStatsFetchFailed(long channelId) {
        this.channelFollowerStatsState.put(Long.valueOf(channelId), new StoreChannelFollowerStats$ChannelFollowerStatData(StoreChannelFollowerStats$FetchState.FAILED, null, 2, null));
        markChanged();
    }

    @StoreThread
    private final void handleChannelFollowerStatsFetchStart(long channelId) {
        this.channelFollowerStatsState.put(Long.valueOf(channelId), new StoreChannelFollowerStats$ChannelFollowerStatData(StoreChannelFollowerStats$FetchState.FETCHING, null, 2, null));
        markChanged();
    }

    @StoreThread
    private final void handleChannelFollowerStatsFetchSuccess(long channelId, ModelChannelFollowerStats channelFollowerStats) {
        this.channelFollowerStatsState.put(Long.valueOf(channelId), new StoreChannelFollowerStats$ChannelFollowerStatData(StoreChannelFollowerStats$FetchState.SUCCEEDED, channelFollowerStats));
        markChanged();
    }

    @StoreThread
    private final boolean isExisting(long channelId) {
        StoreChannelFollowerStats$ChannelFollowerStatData storeChannelFollowerStats$ChannelFollowerStatData = this.channelFollowerStatsState.get(Long.valueOf(channelId));
        return (storeChannelFollowerStats$ChannelFollowerStatData == null || storeChannelFollowerStats$ChannelFollowerStatData.getFetchState() == StoreChannelFollowerStats$FetchState.FAILED) ? false : true;
    }

    @StoreThread
    private final boolean isStale(long channelId) {
        ModelChannelFollowerStats data;
        StoreChannelFollowerStats$ChannelFollowerStatData storeChannelFollowerStats$ChannelFollowerStatData = this.channelFollowerStatsState.get(Long.valueOf(channelId));
        return ((storeChannelFollowerStats$ChannelFollowerStatData == null || (data = storeChannelFollowerStats$ChannelFollowerStatData.getData()) == null) ? 0L : data.getLastFetched() + ((long) 3600000)) <= ClockFactory.get().currentTimeMillis();
    }

    public final void fetchChannelFollowerStats(long channelId) {
        fetchIfNonexistingOrStale(channelId);
    }

    public final Observable<ModelChannelFollowerStats> observeChannelFollowerStats(long channelId) {
        Observable<ModelChannelFollowerStats> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck$UpdateSource[]{this}, false, null, null, new StoreChannelFollowerStats$observeChannelFollowerStats$1(this, channelId), 14, null).r();
        m.checkNotNullExpressionValue(observableR, "observationDeck\n        …  .distinctUntilChanged()");
        return observableR;
    }

    @Override // com.discord.stores.StoreV2
    @StoreThread
    public void snapshotData() {
        this.channelFollowerStatsStateSnapshot = new HashMap(this.channelFollowerStatsState);
    }
}
