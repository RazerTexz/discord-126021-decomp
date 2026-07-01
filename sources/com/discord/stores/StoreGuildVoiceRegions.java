package com.discord.stores;

import com.discord.models.domain.ModelVoiceRegion;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck$UpdateSource;
import com.discord.stores.updates.ObservationDeckProvider;
import d0.t.g0;
import d0.t.h0;
import d0.t.n;
import d0.z.d.m;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map$Entry;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: StoreGuildVoiceRegions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGuildVoiceRegions extends StoreV2 {
    private final Dispatcher dispatcher;
    private Map<Long, ? extends List<? extends ModelVoiceRegion>> guildVoiceRegionsSnapshot;
    private final HashMap<Long, StoreGuildVoiceRegions$State> guildVoiceRegionsState;
    private final ObservationDeck observationDeck;

    public /* synthetic */ StoreGuildVoiceRegions(Dispatcher dispatcher, ObservationDeck observationDeck, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(dispatcher, (i & 2) != 0 ? ObservationDeckProvider.get() : observationDeck);
    }

    public static final /* synthetic */ Dispatcher access$getDispatcher$p(StoreGuildVoiceRegions storeGuildVoiceRegions) {
        return storeGuildVoiceRegions.dispatcher;
    }

    public static final /* synthetic */ HashMap access$getGuildVoiceRegionsState$p(StoreGuildVoiceRegions storeGuildVoiceRegions) {
        return storeGuildVoiceRegions.guildVoiceRegionsState;
    }

    public static final /* synthetic */ void access$handleGuildVoiceRegions(StoreGuildVoiceRegions storeGuildVoiceRegions, long j, List list) {
        storeGuildVoiceRegions.handleGuildVoiceRegions(j, list);
    }

    public static final /* synthetic */ void access$handleGuildVoiceRegionsFetchFailed(StoreGuildVoiceRegions storeGuildVoiceRegions, long j) {
        storeGuildVoiceRegions.handleGuildVoiceRegionsFetchFailed(j);
    }

    public static final /* synthetic */ void access$handleGuildVoiceRegionsFetchStart(StoreGuildVoiceRegions storeGuildVoiceRegions, long j) {
        storeGuildVoiceRegions.handleGuildVoiceRegionsFetchStart(j);
    }

    @StoreThread
    private final void handleGuildVoiceRegions(long guildId, List<? extends ModelVoiceRegion> voiceRegions) {
        this.guildVoiceRegionsState.put(Long.valueOf(guildId), new StoreGuildVoiceRegions$State$Loaded(voiceRegions));
        markChanged();
    }

    @StoreThread
    private final void handleGuildVoiceRegionsFetchFailed(long guildId) {
        this.guildVoiceRegionsState.put(Long.valueOf(guildId), StoreGuildVoiceRegions$State$Failure.INSTANCE);
        markChanged();
    }

    @StoreThread
    private final void handleGuildVoiceRegionsFetchStart(long guildId) {
        this.guildVoiceRegionsState.put(Long.valueOf(guildId), StoreGuildVoiceRegions$State$Fetching.INSTANCE);
        markChanged();
    }

    public final void fetchIfNonexisting(long guildId) {
        this.dispatcher.schedule(new StoreGuildVoiceRegions$fetchIfNonexisting$1(this, guildId));
    }

    public final List<ModelVoiceRegion> getGuildVoiceRegions(long guildId) {
        List<ModelVoiceRegion> list = (List) this.guildVoiceRegionsSnapshot.get(Long.valueOf(guildId));
        return list != null ? list : n.emptyList();
    }

    public final Observable<List<ModelVoiceRegion>> observeGuildVoiceRegions(long guildId) {
        Observable<List<ModelVoiceRegion>> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck$UpdateSource[]{this}, false, null, null, new StoreGuildVoiceRegions$observeGuildVoiceRegions$1(this, guildId), 14, null).r();
        m.checkNotNullExpressionValue(observableR, "observationDeck.connectR… }.distinctUntilChanged()");
        return observableR;
    }

    @Override // com.discord.stores.StoreV2
    public void snapshotData() {
        List<ModelVoiceRegion> listEmptyList;
        super.snapshotData();
        HashMap<Long, StoreGuildVoiceRegions$State> map = this.guildVoiceRegionsState;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map$Entry<Long, StoreGuildVoiceRegions$State> map$Entry : map.entrySet()) {
            if (map$Entry.getValue() instanceof StoreGuildVoiceRegions$State$Loaded) {
                linkedHashMap.put(map$Entry.getKey(), map$Entry.getValue());
            }
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(g0.mapCapacity(linkedHashMap.size()));
        for (Map$Entry map$Entry2 : linkedHashMap.entrySet()) {
            Object key = map$Entry2.getKey();
            Object value = map$Entry2.getValue();
            if (!(value instanceof StoreGuildVoiceRegions$State$Loaded)) {
                value = null;
            }
            StoreGuildVoiceRegions$State$Loaded storeGuildVoiceRegions$State$Loaded = (StoreGuildVoiceRegions$State$Loaded) value;
            if (storeGuildVoiceRegions$State$Loaded == null || (listEmptyList = storeGuildVoiceRegions$State$Loaded.getData()) == null) {
                listEmptyList = n.emptyList();
            }
            linkedHashMap2.put(key, listEmptyList);
        }
        this.guildVoiceRegionsSnapshot = linkedHashMap2;
    }

    public StoreGuildVoiceRegions(Dispatcher dispatcher, ObservationDeck observationDeck) {
        m.checkNotNullParameter(dispatcher, "dispatcher");
        m.checkNotNullParameter(observationDeck, "observationDeck");
        this.dispatcher = dispatcher;
        this.observationDeck = observationDeck;
        this.guildVoiceRegionsSnapshot = h0.emptyMap();
        this.guildVoiceRegionsState = new HashMap<>();
    }
}
