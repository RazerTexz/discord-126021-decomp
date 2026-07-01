package com.discord.stores;

import b.d.b.a.outline;
import com.discord.api.sticker.Sticker;
import com.discord.api.sticker.StickerType;
import com.discord.models.sticker.dto.ModelStickerPack;
import com.discord.models.sticker.dto.ModelStickerStoreDirectory;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck4;
import com.discord.utilities.error.Error;
import com.discord.utilities.frecency.FrecencyTracker;
import com.discord.utilities.media.MediaFrecencyTracker;
import com.discord.utilities.persister.Persister;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.time.Clock;
import com.discord.utilities.time.ClockFactory;
import d0.d0._Ranges;
import d0.t.Collections2;
import d0.t.CollectionsJVM;
import d0.t.Iterables2;
import d0.t.Maps6;
import d0.t.MapsJVM;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.k.Func1;
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
import rx.Observable;
import rx.Subscription;

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
                Intrinsics3.checkNotNullParameter(modelStickerPack, "stickerPack");
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
                Intrinsics3.checkNotNullParameter(stickerPack, "stickerPack");
                return new Loaded(stickerPack);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Loaded) && Intrinsics3.areEqual(this.stickerPack, ((Loaded) other).stickerPack);
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
                StringBuilder sbU = outline.U("Loaded(stickerPack=");
                sbU.append(this.stickerPack);
                sbU.append(")");
                return sbU.toString();
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

    /* JADX INFO: renamed from: com.discord.stores.StoreStickers$fetchEnabledStickerDirectory$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreStickers.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<ModelStickerStoreDirectory, Unit> {

        /* JADX INFO: renamed from: com.discord.stores.StoreStickers$fetchEnabledStickerDirectory$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: StoreStickers.kt */
        public static final class C01741 extends Lambda implements Function0<Unit> {
            public final /* synthetic */ ModelStickerStoreDirectory $directory;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C01741(ModelStickerStoreDirectory modelStickerStoreDirectory) {
                super(0);
                this.$directory = modelStickerStoreDirectory;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                StoreStickers storeStickers = StoreStickers.this;
                storeStickers.lastFetchedEnabledPacks = storeStickers.clock.currentTimeMillis();
                StoreStickers.this.handleNewEnabledStickerDirectory(this.$directory.getStickerPacks());
            }
        }

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ModelStickerStoreDirectory modelStickerStoreDirectory) {
            invoke2(modelStickerStoreDirectory);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ModelStickerStoreDirectory modelStickerStoreDirectory) {
            Intrinsics3.checkNotNullParameter(modelStickerStoreDirectory, "directory");
            StoreStickers.this.dispatcher.schedule(new C01741(modelStickerStoreDirectory));
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreStickers$fetchStickerPack$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreStickers.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ long $stickerPackId;

        /* JADX INFO: renamed from: com.discord.stores.StoreStickers$fetchStickerPack$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: StoreStickers.kt */
        public static final class C01751 extends Lambda implements Function1<ModelStickerPack, Unit> {

            /* JADX INFO: renamed from: com.discord.stores.StoreStickers$fetchStickerPack$1$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: StoreStickers.kt */
            public static final class C01761 extends Lambda implements Function0<Unit> {
                public final /* synthetic */ ModelStickerPack $newPack;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C01761(ModelStickerPack modelStickerPack) {
                    super(0);
                    this.$newPack = modelStickerPack;
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    StoreStickers.this.handleNewLoadedStickerPacks(CollectionsJVM.listOf(this.$newPack));
                }
            }

            public C01751() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ModelStickerPack modelStickerPack) {
                invoke2(modelStickerPack);
                return Unit.a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ModelStickerPack modelStickerPack) {
                Intrinsics3.checkNotNullParameter(modelStickerPack, "newPack");
                StoreStickers.this.dispatcher.schedule(new C01761(modelStickerPack));
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j) {
            super(0);
            this.$stickerPackId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreStickers.this.handleNewLoadingStickerPacks(CollectionsJVM.listOf(Long.valueOf(this.$stickerPackId)));
            ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.restSubscribeOn$default(StoreStickers.this.api.getStickerPack(this.$stickerPackId), false, 1, null), (Class<?>) StoreStickers.this.getClass(), (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new C01751());
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreStickers$handleDeletedStickers$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreStickers.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ List $stickerIds;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(List list) {
            super(0);
            this.$stickerIds = list;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
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

    /* JADX INFO: renamed from: com.discord.stores.StoreStickers$observeEnabledStickerPacks$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreStickers.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<List<? extends ModelStickerPack>> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final List<? extends ModelStickerPack> invoke() {
            return StoreStickers.this.enabledStickerPacksSnapshot;
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreStickers$observeStickerPack$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreStickers.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ long $stickerPackId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j) {
            super(0);
            this.$stickerPackId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            if (StoreStickers.this.stickerPacks.containsKey(Long.valueOf(this.$stickerPackId))) {
                return;
            }
            StoreStickers.this.fetchStickerPack(this.$stickerPackId);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreStickers$observeStickerPack$2, reason: invalid class name */
    /* JADX INFO: compiled from: StoreStickers.kt */
    public static final class AnonymousClass2 extends Lambda implements Function0<StickerPackState> {
        public final /* synthetic */ long $stickerPackId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(long j) {
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

    /* JADX INFO: renamed from: com.discord.stores.StoreStickers$observeStickerPacks$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreStickers.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<List<? extends StickerPackState>> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final List<? extends StickerPackState> invoke() {
            return _Collections.toList(StoreStickers.this.stickerPacks.values());
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreStickers$onStickerUsed$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreStickers.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ Sticker $sticker;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Sticker sticker) {
            super(0);
            this.$sticker = sticker;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            FrecencyTracker.track$default(StoreStickers.this.frecency, String.valueOf(this.$sticker.getId()), 0L, 2, null);
            StoreStickers.this.frecencyCache.set(StoreStickers.this.frecency, true);
        }
    }

    public /* synthetic */ StoreStickers(Dispatcher dispatcher, RestAPI restAPI, ObservationDeck observationDeck, Clock clock, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(dispatcher, (i & 2) != 0 ? RestAPI.INSTANCE.getApi() : restAPI, (i & 4) != 0 ? ObservationDeck4.get() : observationDeck, (i & 8) != 0 ? ClockFactory.get() : clock);
    }

    public final void fetchEnabledStickerDirectory() {
        if (this.lastFetchedEnabledPacks + 300000 >= this.clock.currentTimeMillis()) {
            return;
        }
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.restSubscribeOn$default(this.api.getStickerPacks(), false, 1, null), (Class<?>) StoreStickers.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1());
    }

    public final void fetchStickerPack(long stickerPackId) {
        this.dispatcher.schedule(new AnonymousClass1(stickerPackId));
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
        Intrinsics3.checkNotNullParameter(stickerIds, "stickerIds");
        this.dispatcher.schedule(new AnonymousClass1(stickerIds));
    }

    public final void handleFetchedSticker(Sticker sticker) {
        if (sticker == null || sticker.getType() != StickerType.STANDARD) {
            return;
        }
        Long packId = sticker.getPackId();
        Intrinsics3.checkNotNull(packId);
        fetchStickerPack(packId.longValue());
    }

    @Store3
    public final void handleNewEnabledStickerDirectory(List<ModelStickerPack> enabledPacks) {
        Intrinsics3.checkNotNullParameter(enabledPacks, "enabledPacks");
        handleNewLoadedStickerPacks(enabledPacks);
        this.enabledStickerPacks = enabledPacks;
        markChanged();
    }

    @Store3
    public final void handleNewLoadedStickerPacks(List<ModelStickerPack> newStickerPacks) {
        Intrinsics3.checkNotNullParameter(newStickerPacks, "newStickerPacks");
        Map<Long, ? extends StickerPackState> mutableMap = Maps6.toMutableMap(this.stickerPacks);
        for (ModelStickerPack modelStickerPack : newStickerPacks) {
            StickerPackState stickerPackState = this.stickerPacks.get(Long.valueOf(modelStickerPack.getId()));
            if (stickerPackState == null || !(stickerPackState instanceof StickerPackState.Loaded) || ((StickerPackState.Loaded) stickerPackState).getStickerPack().getStoreListing() == null) {
                mutableMap.put(Long.valueOf(modelStickerPack.getId()), new StickerPackState.Loaded(modelStickerPack));
            }
        }
        this.stickerPacks = mutableMap;
        markChanged();
    }

    @Store3
    public final void handleNewLoadingStickerPacks(List<Long> stickerPackIds) {
        Intrinsics3.checkNotNullParameter(stickerPackIds, "stickerPackIds");
        Map<Long, ? extends StickerPackState> mutableMap = Maps6.toMutableMap(this.stickerPacks);
        Iterator<T> it = stickerPackIds.iterator();
        while (it.hasNext()) {
            mutableMap.put(Long.valueOf(((Number) it.next()).longValue()), StickerPackState.Loading.INSTANCE);
        }
        this.stickerPacks = mutableMap;
        markChanged();
    }

    @Store3
    public final void handlePreLogout() {
        Persister.clear$default(this.frecencyCache, false, 1, null);
    }

    public final void init() {
        fetchEnabledStickerDirectory();
    }

    public final Observable<List<ModelStickerPack>> observeEnabledStickerPacks() {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(), 14, null);
    }

    public final Observable<List<Long>> observeFrequentlyUsedStickerIds() {
        Observable observableG = this.frecencyCache.getObservable().G(new Func1<MediaFrecencyTracker, List<? extends Long>>() { // from class: com.discord.stores.StoreStickers.observeFrequentlyUsedStickerIds.1
            @Override // j0.k.Func1
            public final List<Long> call(MediaFrecencyTracker mediaFrecencyTracker) {
                Collection sortedKeys$default = FrecencyTracker.getSortedKeys$default(mediaFrecencyTracker, 0L, 1, null);
                ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(sortedKeys$default, 10));
                Iterator<T> it = sortedKeys$default.iterator();
                while (it.hasNext()) {
                    arrayList.add(Long.valueOf(Long.parseLong((String) it.next())));
                }
                return arrayList;
            }
        });
        Intrinsics3.checkNotNullExpressionValue(observableG, "frecencyCache.getObserva…ckerId.toLong() }\n      }");
        return observableG;
    }

    public final Observable<StickerPackState> observeStickerPack(long stickerPackId) {
        this.dispatcher.schedule(new AnonymousClass1(stickerPackId));
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass2(stickerPackId), 14, null);
    }

    public final Observable<List<StickerPackState>> observeStickerPacks() {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(), 14, null);
    }

    public final void onStickerUsed(Sticker sticker) {
        Intrinsics3.checkNotNullParameter(sticker, "sticker");
        this.dispatcher.schedule(new AnonymousClass1(sticker));
    }

    @Override // com.discord.stores.StoreV2
    @Store3
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
        ArrayList arrayList2 = new ArrayList(Iterables2.collectionSizeOrDefault(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(((StickerPackState.Loaded) it.next()).getStickerPack().getStickers());
        }
        List listFlatten = Iterables2.flatten(arrayList2);
        LinkedHashMap linkedHashMap = new LinkedHashMap(_Ranges.coerceAtLeast(MapsJVM.mapCapacity(Iterables2.collectionSizeOrDefault(listFlatten, 10)), 16));
        for (Object obj2 : listFlatten) {
            linkedHashMap.put(Long.valueOf(((Sticker) obj2).getId()), obj2);
        }
        this.stickersSnapshot = linkedHashMap;
        this.enabledStickerPacksSnapshot = new ArrayList(this.enabledStickerPacks);
        List<ModelStickerPack> list = this.enabledStickerPacks;
        ArrayList arrayList3 = new ArrayList(Iterables2.collectionSizeOrDefault(list, 10));
        Iterator<T> it2 = list.iterator();
        while (it2.hasNext()) {
            arrayList3.add(((ModelStickerPack) it2.next()).getStickers());
        }
        this.enabledStickerPacksStickersSnapshot = new ArrayList(Iterables2.flatten(arrayList3));
    }

    public StoreStickers(Dispatcher dispatcher, RestAPI restAPI, ObservationDeck observationDeck, Clock clock) {
        Intrinsics3.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics3.checkNotNullParameter(restAPI, "api");
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        Intrinsics3.checkNotNullParameter(clock, "clock");
        this.dispatcher = dispatcher;
        this.api = restAPI;
        this.observationDeck = observationDeck;
        this.clock = clock;
        this.stickerPacks = Maps6.emptyMap();
        this.stickerPacksSnapshot = Maps6.emptyMap();
        this.stickersSnapshot = Maps6.emptyMap();
        Persister<MediaFrecencyTracker> persister = new Persister<>("STICKER_HISTORY_V1", new MediaFrecencyTracker(20, 1));
        this.frecencyCache = persister;
        this.frecency = persister.get();
        this.enabledStickerPacks = Collections2.emptyList();
        this.enabledStickerPacksSnapshot = Collections2.emptyList();
        this.enabledStickerPacksStickersSnapshot = Collections2.emptyList();
    }
}
