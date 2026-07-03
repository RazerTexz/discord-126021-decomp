package com.discord.stores;

import com.discord.models.domain.ModelAppliedGuildBoost;
import com.discord.models.domain.ModelGuildBoostSlot;
import com.discord.stores.updates.ObservationDeck;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.rest.RestAPI;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.C12116o;
import p507d0.p512d0.C11226f;
import p507d0.p580t.C12134g0;
import p507d0.p580t.C12136h0;
import p507d0.p580t.C12149o;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p658rx.Observable;
import p658rx.Subscription;

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
                C12238m.checkNotNullParameter(map, "boostSlotMap");
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
                C12238m.checkNotNullParameter(boostSlotMap, "boostSlotMap");
                return new Loaded(boostSlotMap);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Loaded) && C12238m.areEqual(this.boostSlotMap, ((Loaded) other).boostSlotMap);
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
                        if (C12238m.areEqual(premiumGuildSubscription != null ? Long.valueOf(premiumGuildSubscription.getGuildId()) : null, guildId)) {
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
                return C1643a.m825M(C1643a.m833U("Loaded(boostSlotMap="), this.boostSlotMap, ")");
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

    /* JADX INFO: renamed from: com.discord.stores.StoreGuildBoost$fetchUserGuildBoostState$1 */
    /* JADX INFO: compiled from: StoreGuildBoost.kt */
    public static final class C60171 extends AbstractC12240o implements Function0<Unit> {
        public C60171() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreGuildBoost.this.handleFetchingState();
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGuildBoost$fetchUserGuildBoostState$2 */
    /* JADX INFO: compiled from: StoreGuildBoost.kt */
    public static final class C60182 extends AbstractC12240o implements Function1<Error, Unit> {

        /* JADX INFO: renamed from: com.discord.stores.StoreGuildBoost$fetchUserGuildBoostState$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: StoreGuildBoost.kt */
        public static final class AnonymousClass1 extends AbstractC12240o implements Function0<Unit> {
            public AnonymousClass1() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f27425a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                StoreGuildBoost.this.handleFetchError();
            }
        }

        public C60182() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            C12238m.checkNotNullParameter(error, "it");
            StoreGuildBoost.this.getDispatcher().schedule(new AnonymousClass1());
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGuildBoost$fetchUserGuildBoostState$3 */
    /* JADX INFO: compiled from: StoreGuildBoost.kt */
    public static final class C60193 extends AbstractC12240o implements Function1<List<? extends ModelGuildBoostSlot>, Unit> {

        /* JADX INFO: renamed from: com.discord.stores.StoreGuildBoost$fetchUserGuildBoostState$3$1, reason: invalid class name */
        /* JADX INFO: compiled from: StoreGuildBoost.kt */
        public static final class AnonymousClass1 extends AbstractC12240o implements Function0<Unit> {
            public final /* synthetic */ List $subscriptionsSlots;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(List list) {
                super(0);
                this.$subscriptionsSlots = list;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f27425a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                StoreGuildBoost.this.handleFetchStateSuccess(this.$subscriptionsSlots);
            }
        }

        public C60193() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends ModelGuildBoostSlot> list) {
            invoke2((List<ModelGuildBoostSlot>) list);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<ModelGuildBoostSlot> list) {
            C12238m.checkNotNullParameter(list, "subscriptionsSlots");
            StoreGuildBoost.this.getDispatcher().schedule(new AnonymousClass1(list));
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGuildBoost$observeGuildBoostState$1 */
    /* JADX INFO: compiled from: StoreGuildBoost.kt */
    public static final class C60201 extends AbstractC12240o implements Function0<State> {
        public final /* synthetic */ Long $guildId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C60201(Long l) {
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

    /* JADX INFO: renamed from: com.discord.stores.StoreGuildBoost$updateGuildBoostSlot$1 */
    /* JADX INFO: compiled from: StoreGuildBoost.kt */
    public static final class C60211 extends AbstractC12240o implements Function0<Unit> {
        public final /* synthetic */ ModelGuildBoostSlot $newSlot;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C60211(ModelGuildBoostSlot modelGuildBoostSlot) {
            super(0);
            this.$newSlot = modelGuildBoostSlot;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            State state = StoreGuildBoost.this.state;
            if (state instanceof State.Loaded) {
                Map mapPlus = C12136h0.plus(((State.Loaded) state).getBoostSlotMap(), C12116o.m10073to(Long.valueOf(this.$newSlot.getId()), this.$newSlot));
                StoreGuildBoost.this.state = new State.Loaded(mapPlus);
                StoreGuildBoost.this.markChanged();
            }
        }
    }

    public StoreGuildBoost(Dispatcher dispatcher, ObservationDeck observationDeck) {
        C12238m.checkNotNullParameter(dispatcher, "dispatcher");
        C12238m.checkNotNullParameter(observationDeck, "observationDeck");
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
        this.dispatcher.schedule(new C60171());
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().getSubscriptionSlots(), false, 1, null), (Class<?>) StoreGuildBoost.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new C60182()), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C60193());
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

    @StoreThread
    public final void handleFetchError() {
        this.state = State.Failure.INSTANCE;
        markChanged();
    }

    @StoreThread
    public final void handleFetchStateSuccess(List<ModelGuildBoostSlot> guildBoostSlots) {
        C12238m.checkNotNullParameter(guildBoostSlots, "guildBoostSlots");
        LinkedHashMap linkedHashMap = new LinkedHashMap(C11226f.coerceAtLeast(C12134g0.mapCapacity(C12149o.collectionSizeOrDefault(guildBoostSlots, 10)), 16));
        for (Object obj : guildBoostSlots) {
            linkedHashMap.put(Long.valueOf(((ModelGuildBoostSlot) obj).getId()), obj);
        }
        this.state = new State.Loaded(linkedHashMap);
        markChanged();
    }

    @StoreThread
    public final void handleFetchingState() {
        this.state = State.Loading.INSTANCE;
        markChanged();
    }

    public final Observable<State> observeGuildBoostState(Long guildId) {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new C60201(guildId), 14, null);
    }

    @Override // com.discord.stores.StoreV2
    @StoreThread
    public void snapshotData() {
        State loaded = this.state;
        if (!(loaded instanceof State.Loading) && !(loaded instanceof State.Failure)) {
            if (!(loaded instanceof State.Loaded)) {
                throw new NoWhenBranchMatchedException();
            }
            loaded = new State.Loaded(C12136h0.toMap(((State.Loaded) loaded).getBoostSlotMap()));
        }
        this.stateSnapshot = loaded;
    }

    public final void updateGuildBoostSlot(ModelGuildBoostSlot newSlot) {
        C12238m.checkNotNullParameter(newSlot, "newSlot");
        this.dispatcher.schedule(new C60211(newSlot));
    }
}
