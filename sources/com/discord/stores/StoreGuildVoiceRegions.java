package com.discord.stores;

import b.d.b.a.outline;
import com.discord.models.domain.ModelVoiceRegion;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck4;
import com.discord.utilities.error.Error;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.t.Collections2;
import d0.t.Maps6;
import d0.t.MapsJVM;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.Subscription;

/* JADX INFO: compiled from: StoreGuildVoiceRegions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGuildVoiceRegions extends StoreV2 {
    private final Dispatcher dispatcher;
    private Map<Long, ? extends List<? extends ModelVoiceRegion>> guildVoiceRegionsSnapshot;
    private final HashMap<Long, State> guildVoiceRegionsState;
    private final ObservationDeck observationDeck;

    /* JADX INFO: compiled from: StoreGuildVoiceRegions.kt */
    public static abstract class State {

        /* JADX INFO: compiled from: StoreGuildVoiceRegions.kt */
        public static final class Failure extends State {
            public static final Failure INSTANCE = new Failure();

            private Failure() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: StoreGuildVoiceRegions.kt */
        public static final class Fetching extends State {
            public static final Fetching INSTANCE = new Fetching();

            private Fetching() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: StoreGuildVoiceRegions.kt */
        public static final /* data */ class Loaded extends State {
            private final List<ModelVoiceRegion> data;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public Loaded(List<? extends ModelVoiceRegion> list) {
                super(null);
                Intrinsics3.checkNotNullParameter(list, "data");
                this.data = list;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Loaded copy$default(Loaded loaded, List list, int i, Object obj) {
                if ((i & 1) != 0) {
                    list = loaded.data;
                }
                return loaded.copy(list);
            }

            public final List<ModelVoiceRegion> component1() {
                return this.data;
            }

            public final Loaded copy(List<? extends ModelVoiceRegion> data) {
                Intrinsics3.checkNotNullParameter(data, "data");
                return new Loaded(data);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Loaded) && Intrinsics3.areEqual(this.data, ((Loaded) other).data);
                }
                return true;
            }

            public final List<ModelVoiceRegion> getData() {
                return this.data;
            }

            public int hashCode() {
                List<ModelVoiceRegion> list = this.data;
                if (list != null) {
                    return list.hashCode();
                }
                return 0;
            }

            public String toString() {
                return outline.L(outline.U("Loaded(data="), this.data, ")");
            }
        }

        private State() {
        }

        public /* synthetic */ State(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGuildVoiceRegions$fetchIfNonexisting$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreGuildVoiceRegions.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ long $guildId;

        /* JADX INFO: renamed from: com.discord.stores.StoreGuildVoiceRegions$fetchIfNonexisting$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: StoreGuildVoiceRegions.kt */
        public static final class C01341 extends Lambda implements Function1<List<? extends ModelVoiceRegion>, Unit> {

            /* JADX INFO: renamed from: com.discord.stores.StoreGuildVoiceRegions$fetchIfNonexisting$1$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: StoreGuildVoiceRegions.kt */
            public static final class C01351 extends Lambda implements Function0<Unit> {
                public final /* synthetic */ List $voiceRegions;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C01351(List list) {
                    super(0);
                    this.$voiceRegions = list;
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                    StoreGuildVoiceRegions.this.handleGuildVoiceRegions(anonymousClass1.$guildId, this.$voiceRegions);
                }
            }

            public C01341() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends ModelVoiceRegion> list) {
                invoke2(list);
                return Unit.a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<? extends ModelVoiceRegion> list) {
                Intrinsics3.checkNotNullParameter(list, "voiceRegions");
                StoreGuildVoiceRegions.this.dispatcher.schedule(new C01351(list));
            }
        }

        /* JADX INFO: renamed from: com.discord.stores.StoreGuildVoiceRegions$fetchIfNonexisting$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: StoreGuildVoiceRegions.kt */
        public static final class AnonymousClass2 extends Lambda implements Function1<Error, Unit> {

            /* JADX INFO: renamed from: com.discord.stores.StoreGuildVoiceRegions$fetchIfNonexisting$1$2$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: StoreGuildVoiceRegions.kt */
            public static final class C01361 extends Lambda implements Function0<Unit> {
                public C01361() {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                    StoreGuildVoiceRegions.this.handleGuildVoiceRegionsFetchFailed(anonymousClass1.$guildId);
                }
            }

            public AnonymousClass2() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Error error) {
                invoke2(error);
                return Unit.a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Error error) {
                Intrinsics3.checkNotNullParameter(error, "it");
                StoreGuildVoiceRegions.this.dispatcher.schedule(new C01361());
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j) {
            super(0);
            this.$guildId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            State state = (State) StoreGuildVoiceRegions.this.guildVoiceRegionsState.get(Long.valueOf(this.$guildId));
            if ((state instanceof State.Loaded) || (state instanceof State.Fetching)) {
                return;
            }
            StoreGuildVoiceRegions.this.handleGuildVoiceRegionsFetchStart(this.$guildId);
            ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.restSubscribeOn(RestAPI.INSTANCE.getApi().getGuildVoiceRegions(this.$guildId), false), (Class<?>) StoreGuildVoiceRegions.this.getClass(), (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new AnonymousClass2()), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new C01341());
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGuildVoiceRegions$observeGuildVoiceRegions$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreGuildVoiceRegions.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<List<? extends ModelVoiceRegion>> {
        public final /* synthetic */ long $guildId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j) {
            super(0);
            this.$guildId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public final List<? extends ModelVoiceRegion> invoke() {
            return StoreGuildVoiceRegions.this.getGuildVoiceRegions(this.$guildId);
        }
    }

    public /* synthetic */ StoreGuildVoiceRegions(Dispatcher dispatcher, ObservationDeck observationDeck, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(dispatcher, (i & 2) != 0 ? ObservationDeck4.get() : observationDeck);
    }

    @Store3
    private final void handleGuildVoiceRegions(long guildId, List<? extends ModelVoiceRegion> voiceRegions) {
        this.guildVoiceRegionsState.put(Long.valueOf(guildId), new State.Loaded(voiceRegions));
        markChanged();
    }

    @Store3
    private final void handleGuildVoiceRegionsFetchFailed(long guildId) {
        this.guildVoiceRegionsState.put(Long.valueOf(guildId), State.Failure.INSTANCE);
        markChanged();
    }

    @Store3
    private final void handleGuildVoiceRegionsFetchStart(long guildId) {
        this.guildVoiceRegionsState.put(Long.valueOf(guildId), State.Fetching.INSTANCE);
        markChanged();
    }

    public final void fetchIfNonexisting(long guildId) {
        this.dispatcher.schedule(new AnonymousClass1(guildId));
    }

    public final List<ModelVoiceRegion> getGuildVoiceRegions(long guildId) {
        List<ModelVoiceRegion> list = (List) this.guildVoiceRegionsSnapshot.get(Long.valueOf(guildId));
        return list != null ? list : Collections2.emptyList();
    }

    public final Observable<List<ModelVoiceRegion>> observeGuildVoiceRegions(long guildId) {
        Observable<List<ModelVoiceRegion>> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(guildId), 14, null).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "observationDeck.connectR… }.distinctUntilChanged()");
        return observableR;
    }

    @Override // com.discord.stores.StoreV2
    public void snapshotData() {
        List<ModelVoiceRegion> listEmptyList;
        super.snapshotData();
        HashMap<Long, State> map = this.guildVoiceRegionsState;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<Long, State> entry : map.entrySet()) {
            if (entry.getValue() instanceof State.Loaded) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(MapsJVM.mapCapacity(linkedHashMap.size()));
        for (Map.Entry entry2 : linkedHashMap.entrySet()) {
            Object key = entry2.getKey();
            Object value = entry2.getValue();
            if (!(value instanceof State.Loaded)) {
                value = null;
            }
            State.Loaded loaded = (State.Loaded) value;
            if (loaded == null || (listEmptyList = loaded.getData()) == null) {
                listEmptyList = Collections2.emptyList();
            }
            linkedHashMap2.put(key, listEmptyList);
        }
        this.guildVoiceRegionsSnapshot = linkedHashMap2;
    }

    public StoreGuildVoiceRegions(Dispatcher dispatcher, ObservationDeck observationDeck) {
        Intrinsics3.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        this.dispatcher = dispatcher;
        this.observationDeck = observationDeck;
        this.guildVoiceRegionsSnapshot = Maps6.emptyMap();
        this.guildVoiceRegionsState = new HashMap<>();
    }
}
