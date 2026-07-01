package com.discord.stores;

import android.content.Context;
import com.discord.api.sticker.Sticker;
import com.discord.api.sticker.StickerType;
import com.discord.models.sticker.dto.ModelStickerPack;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck$UpdateSource;
import com.discord.stores.updates.ObservationDeckProvider;
import com.discord.utilities.media.MediaFrecencyTracker;
import com.discord.utilities.persister.Persister;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.time.Clock;
import com.discord.utilities.time.ClockFactory;
import d0.d0.f;
import d0.t.g0;
import d0.t.h0;
import d0.t.n;
import d0.t.o;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: StoreStickers.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreStickers extends StoreV2 {
    public static final StoreStickers$Companion Companion = new StoreStickers$Companion(null);
    private static final long FETCH_ENABLED_STICKER_PACKS_DELAY = 300000;
    private static final int MAX_FREQUENTLY_USED_STICKERS = 20;
    private final RestAPI api;
    private final Clock clock;
    private final Dispatcher dispatcher;
    private List<ModelStickerPack> enabledStickerPacks;
    private List<ModelStickerPack> enabledStickerPacksSnapshot;
    private List<Sticker> enabledStickerPacksStickersSnapshot;
    private final MediaFrecencyTracker frecency;
    private final Persister<MediaFrecencyTracker> frecencyCache;
    private long lastFetchedEnabledPacks;
    private final ObservationDeck observationDeck;
    private Map<Long, ? extends StoreStickers$StickerPackState> stickerPacks;
    private Map<Long, ? extends StoreStickers$StickerPackState> stickerPacksSnapshot;
    private Map<Long, Sticker> stickersSnapshot;

    public /* synthetic */ StoreStickers(Dispatcher dispatcher, RestAPI restAPI, ObservationDeck observationDeck, Clock clock, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(dispatcher, (i & 2) != 0 ? RestAPI.Companion.getApi() : restAPI, (i & 4) != 0 ? ObservationDeckProvider.get() : observationDeck, (i & 8) != 0 ? ClockFactory.get() : clock);
    }

    public static final /* synthetic */ RestAPI access$getApi$p(StoreStickers storeStickers) {
        return storeStickers.api;
    }

    public static final /* synthetic */ Clock access$getClock$p(StoreStickers storeStickers) {
        return storeStickers.clock;
    }

    public static final /* synthetic */ Dispatcher access$getDispatcher$p(StoreStickers storeStickers) {
        return storeStickers.dispatcher;
    }

    public static final /* synthetic */ List access$getEnabledStickerPacksSnapshot$p(StoreStickers storeStickers) {
        return storeStickers.enabledStickerPacksSnapshot;
    }

    public static final /* synthetic */ MediaFrecencyTracker access$getFrecency$p(StoreStickers storeStickers) {
        return storeStickers.frecency;
    }

    public static final /* synthetic */ Persister access$getFrecencyCache$p(StoreStickers storeStickers) {
        return storeStickers.frecencyCache;
    }

    public static final /* synthetic */ long access$getLastFetchedEnabledPacks$p(StoreStickers storeStickers) {
        return storeStickers.lastFetchedEnabledPacks;
    }

    public static final /* synthetic */ Map access$getStickerPacks$p(StoreStickers storeStickers) {
        return storeStickers.stickerPacks;
    }

    public static final /* synthetic */ void access$setEnabledStickerPacksSnapshot$p(StoreStickers storeStickers, List list) {
        storeStickers.enabledStickerPacksSnapshot = list;
    }

    public static final /* synthetic */ void access$setLastFetchedEnabledPacks$p(StoreStickers storeStickers, long j) {
        storeStickers.lastFetchedEnabledPacks = j;
    }

    public static final /* synthetic */ void access$setStickerPacks$p(StoreStickers storeStickers, Map map) {
        storeStickers.stickerPacks = map;
    }

    public final void fetchEnabledStickerDirectory() {
        if (this.lastFetchedEnabledPacks + 300000 >= this.clock.currentTimeMillis()) {
            return;
        }
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(this.api.getStickerPacks(), false, 1, null), StoreStickers.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new StoreStickers$fetchEnabledStickerDirectory$1(this), 62, (Object) null);
    }

    public final void fetchStickerPack(long stickerPackId) {
        this.dispatcher.schedule(new StoreStickers$fetchStickerPack$1(this, stickerPackId));
    }

    public final List<ModelStickerPack> getEnabledStickerPacks() {
        return this.enabledStickerPacksSnapshot;
    }

    public final List<Sticker> getEnabledStickers() {
        return this.enabledStickerPacksStickersSnapshot;
    }

    public final StoreStickers$StickerPackState getStickerPack(long stickerPackId) {
        return this.stickerPacksSnapshot.get(Long.valueOf(stickerPackId));
    }

    public final Map<Long, StoreStickers$StickerPackState> getStickerPacks() {
        return this.stickerPacksSnapshot;
    }

    public final Map<Long, Sticker> getStickers() {
        return this.stickersSnapshot;
    }

    public final void handleDeletedStickers(List<Long> stickerIds) {
        m.checkNotNullParameter(stickerIds, "stickerIds");
        this.dispatcher.schedule(new StoreStickers$handleDeletedStickers$1(this, stickerIds));
    }

    public final void handleFetchedSticker(Sticker sticker) {
        if (sticker == null || sticker.getType() != StickerType.STANDARD) {
            return;
        }
        Long packId = sticker.getPackId();
        m.checkNotNull(packId);
        fetchStickerPack(packId.longValue());
    }

    @StoreThread
    public final void handleNewEnabledStickerDirectory(List<ModelStickerPack> enabledPacks) {
        m.checkNotNullParameter(enabledPacks, "enabledPacks");
        handleNewLoadedStickerPacks(enabledPacks);
        this.enabledStickerPacks = enabledPacks;
        markChanged();
    }

    @StoreThread
    public final void handleNewLoadedStickerPacks(List<ModelStickerPack> newStickerPacks) {
        m.checkNotNullParameter(newStickerPacks, "newStickerPacks");
        Map<Long, ? extends StoreStickers$StickerPackState> mutableMap = h0.toMutableMap(this.stickerPacks);
        for (ModelStickerPack modelStickerPack : newStickerPacks) {
            StoreStickers$StickerPackState storeStickers$StickerPackState = this.stickerPacks.get(Long.valueOf(modelStickerPack.getId()));
            if (storeStickers$StickerPackState == null || !(storeStickers$StickerPackState instanceof StoreStickers$StickerPackState$Loaded) || ((StoreStickers$StickerPackState$Loaded) storeStickers$StickerPackState).getStickerPack().getStoreListing() == null) {
                mutableMap.put(Long.valueOf(modelStickerPack.getId()), new StoreStickers$StickerPackState$Loaded(modelStickerPack));
            }
        }
        this.stickerPacks = mutableMap;
        markChanged();
    }

    @StoreThread
    public final void handleNewLoadingStickerPacks(List<Long> stickerPackIds) {
        m.checkNotNullParameter(stickerPackIds, "stickerPackIds");
        Map<Long, ? extends StoreStickers$StickerPackState> mutableMap = h0.toMutableMap(this.stickerPacks);
        Iterator<T> it = stickerPackIds.iterator();
        while (it.hasNext()) {
            mutableMap.put(Long.valueOf(((Number) it.next()).longValue()), StoreStickers$StickerPackState$Loading.INSTANCE);
        }
        this.stickerPacks = mutableMap;
        markChanged();
    }

    @StoreThread
    public final void handlePreLogout() {
        Persister.clear$default(this.frecencyCache, false, 1, null);
    }

    public final void init() {
        fetchEnabledStickerDirectory();
    }

    public final Observable<List<ModelStickerPack>> observeEnabledStickerPacks() {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck$UpdateSource[]{this}, false, null, null, new StoreStickers$observeEnabledStickerPacks$1(this), 14, null);
    }

    public final Observable<List<Long>> observeFrequentlyUsedStickerIds() {
        Observable observableG = this.frecencyCache.getObservable().G(StoreStickers$observeFrequentlyUsedStickerIds$1.INSTANCE);
        m.checkNotNullExpressionValue(observableG, "frecencyCache.getObserva…ckerId.toLong() }\n      }");
        return observableG;
    }

    public final Observable<StoreStickers$StickerPackState> observeStickerPack(long stickerPackId) {
        this.dispatcher.schedule(new StoreStickers$observeStickerPack$1(this, stickerPackId));
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck$UpdateSource[]{this}, false, null, null, new StoreStickers$observeStickerPack$2(this, stickerPackId), 14, null);
    }

    public final Observable<List<StoreStickers$StickerPackState>> observeStickerPacks() {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck$UpdateSource[]{this}, false, null, null, new StoreStickers$observeStickerPacks$1(this), 14, null);
    }

    public final void onStickerUsed(Sticker sticker) {
        m.checkNotNullParameter(sticker, "sticker");
        this.dispatcher.schedule(new StoreStickers$onStickerUsed$1(this, sticker));
    }

    @Override // com.discord.stores.StoreV2
    @StoreThread
    public void snapshotData() {
        HashMap map = new HashMap(this.stickerPacks);
        this.stickerPacksSnapshot = map;
        Collection collectionValues = map.values();
        ArrayList arrayList = new ArrayList();
        for (Object obj : collectionValues) {
            if (obj instanceof StoreStickers$StickerPackState$Loaded) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(o.collectionSizeOrDefault(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(((StoreStickers$StickerPackState$Loaded) it.next()).getStickerPack().getStickers());
        }
        List listFlatten = o.flatten(arrayList2);
        LinkedHashMap linkedHashMap = new LinkedHashMap(f.coerceAtLeast(g0.mapCapacity(o.collectionSizeOrDefault(listFlatten, 10)), 16));
        for (Object obj2 : listFlatten) {
            linkedHashMap.put(Long.valueOf(((Sticker) obj2).getId()), obj2);
        }
        this.stickersSnapshot = linkedHashMap;
        this.enabledStickerPacksSnapshot = new ArrayList(this.enabledStickerPacks);
        List<ModelStickerPack> list = this.enabledStickerPacks;
        ArrayList arrayList3 = new ArrayList(o.collectionSizeOrDefault(list, 10));
        Iterator<T> it2 = list.iterator();
        while (it2.hasNext()) {
            arrayList3.add(((ModelStickerPack) it2.next()).getStickers());
        }
        this.enabledStickerPacksStickersSnapshot = new ArrayList(o.flatten(arrayList3));
    }

    public StoreStickers(Dispatcher dispatcher, RestAPI restAPI, ObservationDeck observationDeck, Clock clock) {
        m.checkNotNullParameter(dispatcher, "dispatcher");
        m.checkNotNullParameter(restAPI, "api");
        m.checkNotNullParameter(observationDeck, "observationDeck");
        m.checkNotNullParameter(clock, "clock");
        this.dispatcher = dispatcher;
        this.api = restAPI;
        this.observationDeck = observationDeck;
        this.clock = clock;
        this.stickerPacks = h0.emptyMap();
        this.stickerPacksSnapshot = h0.emptyMap();
        this.stickersSnapshot = h0.emptyMap();
        Persister<MediaFrecencyTracker> persister = new Persister<>("STICKER_HISTORY_V1", new MediaFrecencyTracker(20, 1));
        this.frecencyCache = persister;
        this.frecency = persister.get();
        this.enabledStickerPacks = n.emptyList();
        this.enabledStickerPacksSnapshot = n.emptyList();
        this.enabledStickerPacksStickersSnapshot = n.emptyList();
    }
}
