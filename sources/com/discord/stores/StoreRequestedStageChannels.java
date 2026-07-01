package com.discord.stores;

import androidx.annotation.MainThread;
import b.i.a.f.e.o.f;
import com.discord.api.stageinstance.RecommendedStageInstance;
import com.discord.api.stageinstance.StageInstance;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck$UpdateSource;
import com.discord.stores.updates.ObservationDeckProvider;
import com.discord.utilities.rest.RestAPI;
import d0.t.h0;
import d0.t.u;
import d0.z.d.m;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Job;
import rx.Observable;
import s.a.a.n;
import s.a.k0;
import s.a.x0;

/* JADX INFO: compiled from: StoreRequestedStageChannels.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreRequestedStageChannels extends StoreV2 {
    public static final StoreRequestedStageChannels$Companion Companion = new StoreRequestedStageChannels$Companion(null);
    private static final long ENQUEUE_DEBOUNCE_DELAY_MS = 22;
    private final Dispatcher dispatcher;
    private Job enqueuedChannelFetchJob;
    private Set<Long> enqueuedChannelFetches;
    private final ObservationDeck observationDeck;
    private final Map<Long, StoreRequestedStageChannels$StageInstanceState> requestedStageChannels;
    private Map<Long, StoreRequestedStageChannels$StageInstanceState> requestedStageChannelsSnapshot;
    private final RestAPI restAPI;

    public /* synthetic */ StoreRequestedStageChannels(Dispatcher dispatcher, ObservationDeck observationDeck, RestAPI restAPI, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(dispatcher, (i & 2) != 0 ? ObservationDeckProvider.get() : observationDeck, (i & 4) != 0 ? RestAPI.Companion.getApi() : restAPI);
    }

    public static final /* synthetic */ Dispatcher access$getDispatcher$p(StoreRequestedStageChannels storeRequestedStageChannels) {
        return storeRequestedStageChannels.dispatcher;
    }

    public static final /* synthetic */ Set access$getEnqueuedChannelFetches$p(StoreRequestedStageChannels storeRequestedStageChannels) {
        return storeRequestedStageChannels.enqueuedChannelFetches;
    }

    public static final /* synthetic */ Map access$getRequestedStageChannelsSnapshot$p(StoreRequestedStageChannels storeRequestedStageChannels) {
        return storeRequestedStageChannels.requestedStageChannelsSnapshot;
    }

    public static final /* synthetic */ RestAPI access$getRestAPI$p(StoreRequestedStageChannels storeRequestedStageChannels) {
        return storeRequestedStageChannels.restAPI;
    }

    public static final /* synthetic */ void access$onLoaded(StoreRequestedStageChannels storeRequestedStageChannels, Set set, List list) {
        storeRequestedStageChannels.onLoaded(set, list);
    }

    public static final /* synthetic */ void access$setEnqueuedChannelFetches$p(StoreRequestedStageChannels storeRequestedStageChannels, Set set) {
        storeRequestedStageChannels.enqueuedChannelFetches = set;
    }

    public static final /* synthetic */ void access$setRequestedStageChannelsSnapshot$p(StoreRequestedStageChannels storeRequestedStageChannels, Map map) {
        storeRequestedStageChannels.requestedStageChannelsSnapshot = map;
    }

    public static final /* synthetic */ void access$updateStatus(StoreRequestedStageChannels storeRequestedStageChannels, Set set, StoreRequestedStageChannels$FetchStatus storeRequestedStageChannels$FetchStatus) {
        storeRequestedStageChannels.updateStatus(set, storeRequestedStageChannels$FetchStatus);
    }

    @StoreThread
    private final void onLoaded(Set<Long> channelIds, List<RecommendedStageInstance> stageInstances) {
        Set mutableSet = u.toMutableSet(channelIds);
        for (RecommendedStageInstance recommendedStageInstance : stageInstances) {
            this.requestedStageChannels.put(Long.valueOf(recommendedStageInstance.getInstance().getChannelId()), new StoreRequestedStageChannels$StageInstanceState(recommendedStageInstance, StoreRequestedStageChannels$FetchStatus.LOADED));
            mutableSet.remove(Long.valueOf(recommendedStageInstance.getInstance().getChannelId()));
        }
        Iterator it = mutableSet.iterator();
        while (it.hasNext()) {
            this.requestedStageChannels.put(Long.valueOf(((Number) it.next()).longValue()), new StoreRequestedStageChannels$StageInstanceState(null, StoreRequestedStageChannels$FetchStatus.LOADED));
        }
        markChanged();
    }

    @StoreThread
    private final void updateStatus(Set<Long> channelIds, StoreRequestedStageChannels$FetchStatus status) {
        Iterator<T> it = channelIds.iterator();
        while (it.hasNext()) {
            long jLongValue = ((Number) it.next()).longValue();
            StoreRequestedStageChannels$StageInstanceState storeRequestedStageChannels$StageInstanceState = this.requestedStageChannels.get(Long.valueOf(jLongValue));
            this.requestedStageChannels.put(Long.valueOf(jLongValue), new StoreRequestedStageChannels$StageInstanceState(storeRequestedStageChannels$StageInstanceState != null ? storeRequestedStageChannels$StageInstanceState.getStageInstance() : null, status));
        }
        markChanged();
    }

    @MainThread
    public final void enqueueStageChannelFetch(long channelId) {
        StoreRequestedStageChannels$StageInstanceState storeRequestedStageChannels$StageInstanceState = this.requestedStageChannelsSnapshot.get(Long.valueOf(channelId));
        if (storeRequestedStageChannels$StageInstanceState == null || storeRequestedStageChannels$StageInstanceState.isError()) {
            this.enqueuedChannelFetches.add(Long.valueOf(channelId));
            Job job = this.enqueuedChannelFetchJob;
            if (job == null || !job.a()) {
                x0 x0Var = x0.j;
                CoroutineDispatcher coroutineDispatcher = k0.a;
                this.enqueuedChannelFetchJob = f.H0(x0Var, n.f3830b, null, new StoreRequestedStageChannels$enqueueStageChannelFetch$1(this, null), 2, null);
            }
        }
    }

    public final void fetchStageChannels(Set<Long> channelIds) {
        m.checkNotNullParameter(channelIds, "channelIds");
        this.dispatcher.schedule(new StoreRequestedStageChannels$fetchStageChannels$1(this, channelIds));
    }

    public final Map<Long, StoreRequestedStageChannels$StageInstanceState> getRequestedInstanceStatesByChannel() {
        return this.requestedStageChannelsSnapshot;
    }

    public final StageInstance getStageInstanceForChannel(long channelId) {
        RecommendedStageInstance stageInstance;
        StoreRequestedStageChannels$StageInstanceState storeRequestedStageChannels$StageInstanceState = getRequestedInstanceStatesByChannel().get(Long.valueOf(channelId));
        if (storeRequestedStageChannels$StageInstanceState == null || (stageInstance = storeRequestedStageChannels$StageInstanceState.getStageInstance()) == null) {
            return null;
        }
        return stageInstance.getInstance();
    }

    public final Observable<StoreRequestedStageChannels$StageInstanceState> observeRequestedStageChannel(long channelId) {
        Observable observableG = observeRequestedStageChannels().G(new StoreRequestedStageChannels$observeRequestedStageChannel$1(channelId));
        m.checkNotNullExpressionValue(observableG, "observeRequestedStageCha…s().map { it[channelId] }");
        return observableG;
    }

    public final Observable<Map<Long, StoreRequestedStageChannels$StageInstanceState>> observeRequestedStageChannels() {
        Observable<Map<Long, StoreRequestedStageChannels$StageInstanceState>> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck$UpdateSource[]{this}, false, null, null, new StoreRequestedStageChannels$observeRequestedStageChannels$1(this), 14, null).r();
        m.checkNotNullExpressionValue(observableR, "observationDeck.connectR… }.distinctUntilChanged()");
        return observableR;
    }

    @Override // com.discord.stores.StoreV2
    public void snapshotData() {
        super.snapshotData();
        this.requestedStageChannelsSnapshot = h0.toMap(this.requestedStageChannels);
    }

    public StoreRequestedStageChannels(Dispatcher dispatcher, ObservationDeck observationDeck, RestAPI restAPI) {
        m.checkNotNullParameter(dispatcher, "dispatcher");
        m.checkNotNullParameter(observationDeck, "observationDeck");
        m.checkNotNullParameter(restAPI, "restAPI");
        this.dispatcher = dispatcher;
        this.observationDeck = observationDeck;
        this.restAPI = restAPI;
        this.requestedStageChannels = new LinkedHashMap();
        this.requestedStageChannelsSnapshot = h0.emptyMap();
        this.enqueuedChannelFetches = new LinkedHashSet();
    }
}
