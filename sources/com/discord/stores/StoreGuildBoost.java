package com.discord.stores;

import b.d.b.a.outline;
import com.discord.models.domain.ModelAppliedGuildBoost;
import com.discord.models.domain.ModelGuildBoostSlot;
import com.discord.stores.updates.ObservationDeck;
import com.discord.utilities.error.Error;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.Tuples;
import d0.d0._Ranges;
import d0.t.Iterables2;
import d0.t.Maps6;
import d0.t.MapsJVM;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.Subscription;

/* JADX INFO: compiled from: StoreGuildBoost.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGuildBoost extends StoreV2 {
    private final Dispatcher dispatcher;
    private final ObservationDeck observationDeck;
    private State state;
    private State stateSnapshot;

    /* JADX INFO: compiled from: StoreGuildBoost.kt */
    public static abstract class State {

        /* JADX INFO: compiled from: StoreGuildBoost.kt */
        public static final class Failure extends State {
            public static final Failure INSTANCE = new Failure();

            private Failure() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: StoreGuildBoost.kt */
        public static final /* data */ class Loaded extends State {
            private final Map<Long, ModelGuildBoostSlot> boostSlotMap;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Loaded(Map<Long, ModelGuildBoostSlot> map) {
                super(null);
                Intrinsics3.checkNotNullParameter(map, "boostSlotMap");
                this.boostSlotMap = map;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Loaded copy$default(Loaded loaded, Map map, int i, Object obj) {
                if ((i & 1) != 0) {
                    map = loaded.boostSlotMap;
                }
                return loaded.copy(map);
            }

            public final Map<Long, ModelGuildBoostSlot> component1() {
                return this.boostSlotMap;
            }

            public final Loaded copy(Map<Long, ModelGuildBoostSlot> boostSlotMap) {
                Intrinsics3.checkNotNullParameter(boostSlotMap, "boostSlotMap");
                return new Loaded(boostSlotMap);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Loaded) && Intrinsics3.areEqual(this.boostSlotMap, ((Loaded) other).boostSlotMap);
                }
                return true;
            }

            public final Loaded filterByGuildId(Long guildId) {
                Map<Long, ModelGuildBoostSlot> map;
                if (guildId == null) {
                    map = this.boostSlotMap;
                } else {
                    Map<Long, ModelGuildBoostSlot> map2 = this.boostSlotMap;
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    for (Map.Entry<Long, ModelGuildBoostSlot> entry : map2.entrySet()) {
                        ModelAppliedGuildBoost premiumGuildSubscription = entry.getValue().getPremiumGuildSubscription();
                        if (Intrinsics3.areEqual(premiumGuildSubscription != null ? Long.valueOf(premiumGuildSubscription.getGuildId()) : null, guildId)) {
                            linkedHashMap.put(entry.getKey(), entry.getValue());
                        }
                    }
                    map = linkedHashMap;
                }
                return new Loaded(map);
            }

            public final Map<Long, ModelGuildBoostSlot> getBoostSlotMap() {
                return this.boostSlotMap;
            }

            public int hashCode() {
                Map<Long, ModelGuildBoostSlot> map = this.boostSlotMap;
                if (map != null) {
                    return map.hashCode();
                }
                return 0;
            }

            public String toString() {
                return outline.M(outline.U("Loaded(boostSlotMap="), this.boostSlotMap, ")");
            }
        }

        /* JADX INFO: compiled from: StoreGuildBoost.kt */
        public static final class Loading extends State {
            public static final Loading INSTANCE = new Loading();

            private Loading() {
                super(null);
            }
        }

        private State() {
        }

        public /* synthetic */ State(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGuildBoost$fetchUserGuildBoostState$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreGuildBoost.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreGuildBoost.this.handleFetchingState();
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGuildBoost$fetchUserGuildBoostState$2, reason: invalid class name */
    /* JADX INFO: compiled from: StoreGuildBoost.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<Error, Unit> {

        /* JADX INFO: renamed from: com.discord.stores.StoreGuildBoost$fetchUserGuildBoostState$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: StoreGuildBoost.kt */
        public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
            public AnonymousClass1() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                StoreGuildBoost.this.handleFetchError();
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
            StoreGuildBoost.this.getDispatcher().schedule(new AnonymousClass1());
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGuildBoost$fetchUserGuildBoostState$3, reason: invalid class name */
    /* JADX INFO: compiled from: StoreGuildBoost.kt */
    public static final class AnonymousClass3 extends Lambda implements Function1<List<? extends ModelGuildBoostSlot>, Unit> {

        /* JADX INFO: renamed from: com.discord.stores.StoreGuildBoost$fetchUserGuildBoostState$3$1, reason: invalid class name */
        /* JADX INFO: compiled from: StoreGuildBoost.kt */
        public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
            public final /* synthetic */ List $subscriptionsSlots;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(List list) {
                super(0);
                this.$subscriptionsSlots = list;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                StoreGuildBoost.this.handleFetchStateSuccess(this.$subscriptionsSlots);
            }
        }

        public AnonymousClass3() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends ModelGuildBoostSlot> list) {
            invoke2((List<ModelGuildBoostSlot>) list);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<ModelGuildBoostSlot> list) {
            Intrinsics3.checkNotNullParameter(list, "subscriptionsSlots");
            StoreGuildBoost.this.getDispatcher().schedule(new AnonymousClass1(list));
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGuildBoost$observeGuildBoostState$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreGuildBoost.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<State> {
        public final /* synthetic */ Long $guildId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Long l) {
            super(0);
            this.$guildId = l;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final State invoke() {
            State stateSnapshot = StoreGuildBoost.this.getStateSnapshot();
            return stateSnapshot instanceof State.Loaded ? ((State.Loaded) stateSnapshot).filterByGuildId(this.$guildId) : stateSnapshot;
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGuildBoost$updateGuildBoostSlot$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreGuildBoost.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ ModelGuildBoostSlot $newSlot;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(ModelGuildBoostSlot modelGuildBoostSlot) {
            super(0);
            this.$newSlot = modelGuildBoostSlot;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            State state = StoreGuildBoost.this.state;
            if (state instanceof State.Loaded) {
                Map mapPlus = Maps6.plus(((State.Loaded) state).getBoostSlotMap(), Tuples.to(Long.valueOf(this.$newSlot.getId()), this.$newSlot));
                StoreGuildBoost.this.state = new State.Loaded(mapPlus);
                StoreGuildBoost.this.markChanged();
            }
        }
    }

    public StoreGuildBoost(Dispatcher dispatcher, ObservationDeck observationDeck) {
        Intrinsics3.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        this.dispatcher = dispatcher;
        this.observationDeck = observationDeck;
        State.Loading loading = State.Loading.INSTANCE;
        this.state = loading;
        this.stateSnapshot = loading;
    }

    public static /* synthetic */ State getGuildBoostsState$default(StoreGuildBoost storeGuildBoost, Long l, int i, Object obj) {
        if ((i & 1) != 0) {
            l = null;
        }
        return storeGuildBoost.getGuildBoostsState(l);
    }

    public static /* synthetic */ Observable observeGuildBoostState$default(StoreGuildBoost storeGuildBoost, Long l, int i, Object obj) {
        if ((i & 1) != 0) {
            l = null;
        }
        return storeGuildBoost.observeGuildBoostState(l);
    }

    public final void fetchUserGuildBoostState() {
        this.dispatcher.schedule(new AnonymousClass1());
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().getSubscriptionSlots(), false, 1, null), (Class<?>) StoreGuildBoost.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new AnonymousClass2()), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass3());
    }

    public final Dispatcher getDispatcher() {
        return this.dispatcher;
    }

    public final State getGuildBoostsState(Long guildId) {
        State stateSnapshot = getStateSnapshot();
        return stateSnapshot instanceof State.Loaded ? ((State.Loaded) stateSnapshot).filterByGuildId(guildId) : stateSnapshot;
    }

    public final ObservationDeck getObservationDeck() {
        return this.observationDeck;
    }

    /* JADX INFO: renamed from: getState, reason: from getter */
    public final State getStateSnapshot() {
        return this.stateSnapshot;
    }

    @Store3
    public final void handleFetchError() {
        this.state = State.Failure.INSTANCE;
        markChanged();
    }

    @Store3
    public final void handleFetchStateSuccess(List<ModelGuildBoostSlot> guildBoostSlots) {
        Intrinsics3.checkNotNullParameter(guildBoostSlots, "guildBoostSlots");
        LinkedHashMap linkedHashMap = new LinkedHashMap(_Ranges.coerceAtLeast(MapsJVM.mapCapacity(Iterables2.collectionSizeOrDefault(guildBoostSlots, 10)), 16));
        for (Object obj : guildBoostSlots) {
            linkedHashMap.put(Long.valueOf(((ModelGuildBoostSlot) obj).getId()), obj);
        }
        this.state = new State.Loaded(linkedHashMap);
        markChanged();
    }

    @Store3
    public final void handleFetchingState() {
        this.state = State.Loading.INSTANCE;
        markChanged();
    }

    public final Observable<State> observeGuildBoostState(Long guildId) {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(guildId), 14, null);
    }

    @Override // com.discord.stores.StoreV2
    @Store3
    public void snapshotData() {
        State loaded = this.state;
        if (!(loaded instanceof State.Loading) && !(loaded instanceof State.Failure)) {
            if (!(loaded instanceof State.Loaded)) {
                throw new NoWhenBranchMatchedException();
            }
            loaded = new State.Loaded(Maps6.toMap(((State.Loaded) loaded).getBoostSlotMap()));
        }
        this.stateSnapshot = loaded;
    }

    public final void updateGuildBoostSlot(ModelGuildBoostSlot newSlot) {
        Intrinsics3.checkNotNullParameter(newSlot, "newSlot");
        this.dispatcher.schedule(new AnonymousClass1(newSlot));
    }
}
