package com.discord.stores;

import com.discord.api.sticker.Sticker;
import com.discord.api.sticker.StickerType;
import com.discord.models.sticker.dto.ModelStickerPack;
import com.discord.models.sticker.dto.ModelStickerStoreDirectory;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeckProvider;
import com.discord.utilities.error.Error;
import com.discord.utilities.frecency.FrecencyTracker;
import com.discord.utilities.media.MediaFrecencyTracker;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.persister.Persister;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.time.Clock;
import com.discord.utilities.time.ClockFactory;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p512d0.C11226f;
import p507d0.p580t.C12134g0;
import p507d0.p580t.C12136h0;
import p507d0.p580t.C12145m;
import p507d0.p580t.C12147n;
import p507d0.p580t.C12149o;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p637j0.p641k.InterfaceC12589b;
import p658rx.Observable;
import p658rx.Subscription;

/* JADX INFO: compiled from: StoreStickers.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreStickers extends StoreV2 {
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
    private Map<Long, ? extends StickerPackState> stickerPacks;
    private Map<Long, ? extends StickerPackState> stickerPacksSnapshot;
    private Map<Long, Sticker> stickersSnapshot;

    /* JADX INFO: compiled from: StoreStickers.kt */
    public static abstract class StickerPackState {

        /* JADX INFO: compiled from: StoreStickers.kt */
        public static final /* data */ class Loaded extends StickerPackState {
            private final ModelStickerPack stickerPack;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Loaded(ModelStickerPack modelStickerPack) {
                super(null);
                C12238m.checkNotNullParameter(modelStickerPack, "stickerPack");
                this.stickerPack = modelStickerPack;
            }

            public static /* synthetic */ Loaded copy$default(Loaded loaded, ModelStickerPack modelStickerPack, int i, Object obj) {
                if ((i & 1) != 0) {
                    modelStickerPack = loaded.stickerPack;
                }
                return loaded.copy(modelStickerPack);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final ModelStickerPack getStickerPack() {
                return this.stickerPack;
            }

            public final Loaded copy(ModelStickerPack stickerPack) {
                C12238m.checkNotNullParameter(stickerPack, "stickerPack");
                return new Loaded(stickerPack);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Loaded) && C12238m.areEqual(this.stickerPack, ((Loaded) other).stickerPack);
                }
                return true;
            }

            public final ModelStickerPack getStickerPack() {
                return this.stickerPack;
            }

            public int hashCode() {
                ModelStickerPack modelStickerPack = this.stickerPack;
                if (modelStickerPack != null) {
                    return modelStickerPack.hashCode();
                }
                return 0;
            }

            public String toString() {
                StringBuilder sbM833U = C1643a.m833U("Loaded(stickerPack=");
                sbM833U.append(this.stickerPack);
                sbM833U.append(")");
                return sbM833U.toString();
            }
        }

        /* JADX INFO: compiled from: StoreStickers.kt */
        public static final class Loading extends StickerPackState {
            public static final Loading INSTANCE = new Loading();

            private Loading() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: StoreStickers.kt */
        public static final class Unknown extends StickerPackState {
            public static final Unknown INSTANCE = new Unknown();

            private Unknown() {
                super(null);
            }
        }

        private StickerPackState() {
        }

        public /* synthetic */ StickerPackState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreStickers$fetchEnabledStickerDirectory$1 */
    /* JADX INFO: compiled from: StoreStickers.kt */
    public static final class C64231 extends AbstractC12240o implements Function1<ModelStickerStoreDirectory, Unit> {

        /* JADX INFO: renamed from: com.discord.stores.StoreStickers$fetchEnabledStickerDirectory$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: StoreStickers.kt */
        public static final class AnonymousClass1 extends AbstractC12240o implements Function0<Unit> {
            public final /* synthetic */ ModelStickerStoreDirectory $directory;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(ModelStickerStoreDirectory modelStickerStoreDirectory) {
                super(0);
                this.$directory = modelStickerStoreDirectory;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f27425a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                StoreStickers storeStickers = StoreStickers.this;
                storeStickers.lastFetchedEnabledPacks = storeStickers.clock.currentTimeMillis();
                StoreStickers.this.handleNewEnabledStickerDirectory(this.$directory.getStickerPacks());
            }
        }

        public C64231() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ModelStickerStoreDirectory modelStickerStoreDirectory) {
            invoke2(modelStickerStoreDirectory);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ModelStickerStoreDirectory modelStickerStoreDirectory) {
            C12238m.checkNotNullParameter(modelStickerStoreDirectory, "directory");
            StoreStickers.this.dispatcher.schedule(new AnonymousClass1(modelStickerStoreDirectory));
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreStickers$fetchStickerPack$1 */
    /* JADX INFO: compiled from: StoreStickers.kt */
    public static final class C64241 extends AbstractC12240o implements Function0<Unit> {
        public final /* synthetic */ long $stickerPackId;

        /* JADX INFO: renamed from: com.discord.stores.StoreStickers$fetchStickerPack$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: StoreStickers.kt */
        public static final class AnonymousClass1 extends AbstractC12240o implements Function1<ModelStickerPack, Unit> {

            /* JADX INFO: renamed from: com.discord.stores.StoreStickers$fetchStickerPack$1$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: StoreStickers.kt */
            public static final class C132631 extends AbstractC12240o implements Function0<Unit> {
                public final /* synthetic */ ModelStickerPack $newPack;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C132631(ModelStickerPack modelStickerPack) {
                    super(0);
                    this.$newPack = modelStickerPack;
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.f27425a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    StoreStickers.this.handleNewLoadedStickerPacks(C12145m.listOf(this.$newPack));
                }
            }

            public AnonymousClass1() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ModelStickerPack modelStickerPack) {
                invoke2(modelStickerPack);
                return Unit.f27425a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ModelStickerPack modelStickerPack) {
                C12238m.checkNotNullParameter(modelStickerPack, "newPack");
                StoreStickers.this.dispatcher.schedule(new C132631(modelStickerPack));
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C64241(long j) {
            super(0);
            this.$stickerPackId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreStickers.this.handleNewLoadingStickerPacks(C12145m.listOf(Long.valueOf(this.$stickerPackId)));
            ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.restSubscribeOn$default(StoreStickers.this.api.getStickerPack(this.$stickerPackId), false, 1, null), (Class<?>) StoreStickers.this.getClass(), (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new AnonymousClass1());
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreStickers$handleDeletedStickers$1 */
    /* JADX INFO: compiled from: StoreStickers.kt */
    public static final class C64251 extends AbstractC12240o implements Function0<Unit> {
        public final /* synthetic */ List $stickerIds;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C64251(List list) {
            super(0);
            this.$stickerIds = list;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            Iterator it = this.$stickerIds.iterator();
            while (it.hasNext()) {
                StoreStickers.this.frecency.removeEntry(String.valueOf(((Number) it.next()).longValue()));
            }
            StoreStickers.this.frecencyCache.set(StoreStickers.this.frecency, true);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreStickers$observeEnabledStickerPacks$1 */
    /* JADX INFO: compiled from: StoreStickers.kt */
    public static final class C64261 extends AbstractC12240o implements Function0<List<? extends ModelStickerPack>> {
        public C64261() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final List<? extends ModelStickerPack> invoke() {
            return StoreStickers.this.enabledStickerPacksSnapshot;
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreStickers$observeStickerPack$1 */
    /* JADX INFO: compiled from: StoreStickers.kt */
    public static final class C64281 extends AbstractC12240o implements Function0<Unit> {
        public final /* synthetic */ long $stickerPackId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C64281(long j) {
            super(0);
            this.$stickerPackId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            if (StoreStickers.this.stickerPacks.containsKey(Long.valueOf(this.$stickerPackId))) {
                return;
            }
            StoreStickers.this.fetchStickerPack(this.$stickerPackId);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreStickers$observeStickerPack$2 */
    /* JADX INFO: compiled from: StoreStickers.kt */
    public static final class C64292 extends AbstractC12240o implements Function0<StickerPackState> {
        public final /* synthetic */ long $stickerPackId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C64292(long j) {
            super(0);
            this.$stickerPackId = j;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final StickerPackState invoke() {
            StickerPackState stickerPackState = (StickerPackState) StoreStickers.this.stickerPacks.get(Long.valueOf(this.$stickerPackId));
            return stickerPackState != null ? stickerPackState : StickerPackState.Unknown.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreStickers$observeStickerPacks$1 */
    /* JADX INFO: compiled from: StoreStickers.kt */
    public static final class C64301 extends AbstractC12240o implements Function0<List<? extends StickerPackState>> {
        public C64301() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final List<? extends StickerPackState> invoke() {
            return C12163u.toList(StoreStickers.this.stickerPacks.values());
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreStickers$onStickerUsed$1 */
    /* JADX INFO: compiled from: StoreStickers.kt */
    public static final class C64311 extends AbstractC12240o implements Function0<Unit> {
        public final /* synthetic */ Sticker $sticker;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C64311(Sticker sticker) {
            super(0);
            this.$sticker = sticker;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            FrecencyTracker.track$default(StoreStickers.this.frecency, String.valueOf(this.$sticker.getId()), 0L, 2, null);
            StoreStickers.this.frecencyCache.set(StoreStickers.this.frecency, true);
        }
    }

    public /* synthetic */ StoreStickers(Dispatcher dispatcher, RestAPI restAPI, ObservationDeck observationDeck, Clock clock, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(dispatcher, (i & 2) != 0 ? RestAPI.INSTANCE.getApi() : restAPI, (i & 4) != 0 ? ObservationDeckProvider.get() : observationDeck, (i & 8) != 0 ? ClockFactory.get() : clock);
    }

    public final void fetchEnabledStickerDirectory() {
        if (this.lastFetchedEnabledPacks + 300000 >= this.clock.currentTimeMillis()) {
            return;
        }
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.restSubscribeOn$default(this.api.getStickerPacks(), false, 1, null), (Class<?>) StoreStickers.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C64231());
    }

    public final void fetchStickerPack(long stickerPackId) {
        this.dispatcher.schedule(new C64241(stickerPackId));
    }

    public final List<ModelStickerPack> getEnabledStickerPacks() {
        return this.enabledStickerPacksSnapshot;
    }

    public final List<Sticker> getEnabledStickers() {
        return this.enabledStickerPacksStickersSnapshot;
    }

    public final StickerPackState getStickerPack(long stickerPackId) {
        return this.stickerPacksSnapshot.get(Long.valueOf(stickerPackId));
    }

    public final Map<Long, StickerPackState> getStickerPacks() {
        return this.stickerPacksSnapshot;
    }

    public final Map<Long, Sticker> getStickers() {
        return this.stickersSnapshot;
    }

    public final void handleDeletedStickers(List<Long> stickerIds) {
        C12238m.checkNotNullParameter(stickerIds, "stickerIds");
        this.dispatcher.schedule(new C64251(stickerIds));
    }

    public final void handleFetchedSticker(Sticker sticker) {
        if (sticker == null || sticker.getType() != StickerType.STANDARD) {
            return;
        }
        Long packId = sticker.getPackId();
        C12238m.checkNotNull(packId);
        fetchStickerPack(packId.longValue());
    }

    @StoreThread
    public final void handleNewEnabledStickerDirectory(List<ModelStickerPack> enabledPacks) {
        C12238m.checkNotNullParameter(enabledPacks, "enabledPacks");
        handleNewLoadedStickerPacks(enabledPacks);
        this.enabledStickerPacks = enabledPacks;
        markChanged();
    }

    @StoreThread
    public final void handleNewLoadedStickerPacks(List<ModelStickerPack> newStickerPacks) {
        C12238m.checkNotNullParameter(newStickerPacks, "newStickerPacks");
        Map<Long, ? extends StickerPackState> mutableMap = C12136h0.toMutableMap(this.stickerPacks);
        for (ModelStickerPack modelStickerPack : newStickerPacks) {
            StickerPackState stickerPackState = this.stickerPacks.get(Long.valueOf(modelStickerPack.getId()));
            if (stickerPackState == null || !(stickerPackState instanceof StickerPackState.Loaded) || ((StickerPackState.Loaded) stickerPackState).getStickerPack().getStoreListing() == null) {
                mutableMap.put(Long.valueOf(modelStickerPack.getId()), new StickerPackState.Loaded(modelStickerPack));
            }
        }
        this.stickerPacks = mutableMap;
        markChanged();
    }

    @StoreThread
    public final void handleNewLoadingStickerPacks(List<Long> stickerPackIds) {
        C12238m.checkNotNullParameter(stickerPackIds, "stickerPackIds");
        Map<Long, ? extends StickerPackState> mutableMap = C12136h0.toMutableMap(this.stickerPacks);
        Iterator<T> it = stickerPackIds.iterator();
        while (it.hasNext()) {
            mutableMap.put(Long.valueOf(((Number) it.next()).longValue()), StickerPackState.Loading.INSTANCE);
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
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new C64261(), 14, null);
    }

    public final Observable<List<Long>> observeFrequentlyUsedStickerIds() {
        Observable observableM11083G = this.frecencyCache.getObservable().m11083G(new InterfaceC12589b<MediaFrecencyTracker, List<? extends Long>>() { // from class: com.discord.stores.StoreStickers.observeFrequentlyUsedStickerIds.1
            @Override // p637j0.p641k.InterfaceC12589b
            public final List<Long> call(MediaFrecencyTracker mediaFrecencyTracker) {
                Collection sortedKeys$default = FrecencyTracker.getSortedKeys$default(mediaFrecencyTracker, 0L, 1, null);
                ArrayList arrayList = new ArrayList(C12149o.collectionSizeOrDefault(sortedKeys$default, 10));
                Iterator<T> it = sortedKeys$default.iterator();
                while (it.hasNext()) {
                    arrayList.add(Long.valueOf(Long.parseLong((String) it.next())));
                }
                return arrayList;
            }
        });
        C12238m.checkNotNullExpressionValue(observableM11083G, "frecencyCache.getObserva…ckerId.toLong() }\n      }");
        return observableM11083G;
    }

    public final Observable<StickerPackState> observeStickerPack(long stickerPackId) {
        this.dispatcher.schedule(new C64281(stickerPackId));
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new C64292(stickerPackId), 14, null);
    }

    public final Observable<List<StickerPackState>> observeStickerPacks() {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new C64301(), 14, null);
    }

    public final void onStickerUsed(Sticker sticker) {
        C12238m.checkNotNullParameter(sticker, "sticker");
        this.dispatcher.schedule(new C64311(sticker));
    }

    @Override // com.discord.stores.StoreV2
    @StoreThread
    public void snapshotData() {
        HashMap map = new HashMap(this.stickerPacks);
        this.stickerPacksSnapshot = map;
        Collection collectionValues = map.values();
        ArrayList arrayList = new ArrayList();
        for (Object obj : collectionValues) {
            if (obj instanceof StickerPackState.Loaded) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(C12149o.collectionSizeOrDefault(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(((StickerPackState.Loaded) it.next()).getStickerPack().getStickers());
        }
        List listFlatten = C12149o.flatten(arrayList2);
        LinkedHashMap linkedHashMap = new LinkedHashMap(C11226f.coerceAtLeast(C12134g0.mapCapacity(C12149o.collectionSizeOrDefault(listFlatten, 10)), 16));
        for (Object obj2 : listFlatten) {
            linkedHashMap.put(Long.valueOf(((Sticker) obj2).getId()), obj2);
        }
        this.stickersSnapshot = linkedHashMap;
        this.enabledStickerPacksSnapshot = new ArrayList(this.enabledStickerPacks);
        List<ModelStickerPack> list = this.enabledStickerPacks;
        ArrayList arrayList3 = new ArrayList(C12149o.collectionSizeOrDefault(list, 10));
        Iterator<T> it2 = list.iterator();
        while (it2.hasNext()) {
            arrayList3.add(((ModelStickerPack) it2.next()).getStickers());
        }
        this.enabledStickerPacksStickersSnapshot = new ArrayList(C12149o.flatten(arrayList3));
    }

    public StoreStickers(Dispatcher dispatcher, RestAPI restAPI, ObservationDeck observationDeck, Clock clock) {
        C12238m.checkNotNullParameter(dispatcher, "dispatcher");
        C12238m.checkNotNullParameter(restAPI, "api");
        C12238m.checkNotNullParameter(observationDeck, "observationDeck");
        C12238m.checkNotNullParameter(clock, "clock");
        this.dispatcher = dispatcher;
        this.api = restAPI;
        this.observationDeck = observationDeck;
        this.clock = clock;
        this.stickerPacks = C12136h0.emptyMap();
        this.stickerPacksSnapshot = C12136h0.emptyMap();
        this.stickersSnapshot = C12136h0.emptyMap();
        Persister<MediaFrecencyTracker> persister = new Persister<>("STICKER_HISTORY_V1", new MediaFrecencyTracker(20, 1));
        this.frecencyCache = persister;
        this.frecency = persister.get();
        this.enabledStickerPacks = C12147n.emptyList();
        this.enabledStickerPacksSnapshot = C12147n.emptyList();
        this.enabledStickerPacksStickersSnapshot = C12147n.emptyList();
    }
}
