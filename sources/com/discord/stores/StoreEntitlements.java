package com.discord.stores;

import com.discord.models.domain.ModelEntitlement;
import com.discord.restapi.RestAPIInterface;
import com.discord.stores.updates.ObservationDeck;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.rest.RestAPI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p580t.C12136h0;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p658rx.Observable;
import p658rx.Subscription;

/* JADX INFO: compiled from: StoreEntitlements.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreEntitlements extends StoreV2 {
    private final Dispatcher dispatcher;
    private Map<Long, List<ModelEntitlement>> entitlementMap;
    private Map<Long, ? extends List<ModelEntitlement>> giftEntitlementMap;
    private final ObservationDeck observationDeck;
    private final RestAPI restAPI;
    private State state;
    private State stateSnapshot;

    /* JADX INFO: compiled from: StoreEntitlements.kt */
    public static abstract class State {

        /* JADX INFO: compiled from: StoreEntitlements.kt */
        public static final class Failure extends State {
            public static final Failure INSTANCE = new Failure();

            private Failure() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: StoreEntitlements.kt */
        public static final /* data */ class Loaded extends State {
            private final Map<Long, List<ModelEntitlement>> giftableEntitlements;
            private final Map<Long, List<ModelEntitlement>> ownedEntitlements;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public Loaded(Map<Long, ? extends List<ModelEntitlement>> map, Map<Long, ? extends List<ModelEntitlement>> map2) {
                super(null);
                C12238m.checkNotNullParameter(map, "giftableEntitlements");
                C12238m.checkNotNullParameter(map2, "ownedEntitlements");
                this.giftableEntitlements = map;
                this.ownedEntitlements = map2;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Loaded copy$default(Loaded loaded, Map map, Map map2, int i, Object obj) {
                if ((i & 1) != 0) {
                    map = loaded.giftableEntitlements;
                }
                if ((i & 2) != 0) {
                    map2 = loaded.ownedEntitlements;
                }
                return loaded.copy(map, map2);
            }

            public final Map<Long, List<ModelEntitlement>> component1() {
                return this.giftableEntitlements;
            }

            public final Map<Long, List<ModelEntitlement>> component2() {
                return this.ownedEntitlements;
            }

            public final Loaded copy(Map<Long, ? extends List<ModelEntitlement>> giftableEntitlements, Map<Long, ? extends List<ModelEntitlement>> ownedEntitlements) {
                C12238m.checkNotNullParameter(giftableEntitlements, "giftableEntitlements");
                C12238m.checkNotNullParameter(ownedEntitlements, "ownedEntitlements");
                return new Loaded(giftableEntitlements, ownedEntitlements);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Loaded)) {
                    return false;
                }
                Loaded loaded = (Loaded) other;
                return C12238m.areEqual(this.giftableEntitlements, loaded.giftableEntitlements) && C12238m.areEqual(this.ownedEntitlements, loaded.ownedEntitlements);
            }

            public final Map<Long, List<ModelEntitlement>> getGiftableEntitlements() {
                return this.giftableEntitlements;
            }

            public final Map<Long, List<ModelEntitlement>> getOwnedEntitlements() {
                return this.ownedEntitlements;
            }

            public int hashCode() {
                Map<Long, List<ModelEntitlement>> map = this.giftableEntitlements;
                int iHashCode = (map != null ? map.hashCode() : 0) * 31;
                Map<Long, List<ModelEntitlement>> map2 = this.ownedEntitlements;
                return iHashCode + (map2 != null ? map2.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbM833U = C1643a.m833U("Loaded(giftableEntitlements=");
                sbM833U.append(this.giftableEntitlements);
                sbM833U.append(", ownedEntitlements=");
                return C1643a.m825M(sbM833U, this.ownedEntitlements, ")");
            }

            @Override // com.discord.stores.StoreEntitlements.State
            public Loaded deepCopy() {
                return copy(new HashMap(this.giftableEntitlements), new HashMap(this.ownedEntitlements));
            }
        }

        /* JADX INFO: compiled from: StoreEntitlements.kt */
        public static final class Loading extends State {
            public static final Loading INSTANCE = new Loading();

            private Loading() {
                super(null);
            }
        }

        private State() {
        }

        public State deepCopy() {
            return this;
        }

        public /* synthetic */ State(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreEntitlements$fetchMyEntitlementsForApplication$1 */
    /* JADX INFO: compiled from: StoreEntitlements.kt */
    public static final class C59051 extends AbstractC12240o implements Function0<Unit> {
        public C59051() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreEntitlements.this.handleFetchingState();
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreEntitlements$fetchMyEntitlementsForApplication$2 */
    /* JADX INFO: compiled from: StoreEntitlements.kt */
    public static final class C59062 extends AbstractC12240o implements Function1<Error, Unit> {

        /* JADX INFO: renamed from: com.discord.stores.StoreEntitlements$fetchMyEntitlementsForApplication$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: StoreEntitlements.kt */
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
                StoreEntitlements.this.handleFetchError();
            }
        }

        public C59062() {
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
            StoreEntitlements.this.dispatcher.schedule(new AnonymousClass1());
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreEntitlements$fetchMyEntitlementsForApplication$3 */
    /* JADX INFO: compiled from: StoreEntitlements.kt */
    public static final class C59073 extends AbstractC12240o implements Function1<List<? extends ModelEntitlement>, Unit> {
        public final /* synthetic */ long $applicationId;

        /* JADX INFO: renamed from: com.discord.stores.StoreEntitlements$fetchMyEntitlementsForApplication$3$1, reason: invalid class name */
        /* JADX INFO: compiled from: StoreEntitlements.kt */
        public static final class AnonymousClass1 extends AbstractC12240o implements Function0<Unit> {
            public final /* synthetic */ List $entitlements;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(List list) {
                super(0);
                this.$entitlements = list;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f27425a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                C59073 c59073 = C59073.this;
                StoreEntitlements.this.handleFetchEntitlementsSuccess(c59073.$applicationId, this.$entitlements);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C59073(long j) {
            super(1);
            this.$applicationId = j;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends ModelEntitlement> list) {
            invoke2((List<ModelEntitlement>) list);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<ModelEntitlement> list) {
            C12238m.checkNotNullParameter(list, "entitlements");
            StoreEntitlements.this.dispatcher.schedule(new AnonymousClass1(list));
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreEntitlements$fetchMyGiftEntitlements$1 */
    /* JADX INFO: compiled from: StoreEntitlements.kt */
    public static final class C59081 extends AbstractC12240o implements Function0<Unit> {
        public C59081() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreEntitlements.this.handleFetchingState();
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreEntitlements$fetchMyGiftEntitlements$2 */
    /* JADX INFO: compiled from: StoreEntitlements.kt */
    public static final class C59092 extends AbstractC12240o implements Function1<Error, Unit> {

        /* JADX INFO: renamed from: com.discord.stores.StoreEntitlements$fetchMyGiftEntitlements$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: StoreEntitlements.kt */
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
                StoreEntitlements.this.handleFetchError();
            }
        }

        public C59092() {
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
            StoreEntitlements.this.dispatcher.schedule(new AnonymousClass1());
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreEntitlements$fetchMyGiftEntitlements$3 */
    /* JADX INFO: compiled from: StoreEntitlements.kt */
    public static final class C59103 extends AbstractC12240o implements Function1<List<? extends ModelEntitlement>, Unit> {

        /* JADX INFO: renamed from: com.discord.stores.StoreEntitlements$fetchMyGiftEntitlements$3$1, reason: invalid class name */
        /* JADX INFO: compiled from: StoreEntitlements.kt */
        public static final class AnonymousClass1 extends AbstractC12240o implements Function0<Unit> {
            public final /* synthetic */ List $entitlements;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(List list) {
                super(0);
                this.$entitlements = list;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f27425a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                StoreEntitlements.this.handleFetchGiftsSuccess(this.$entitlements);
            }
        }

        public C59103() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends ModelEntitlement> list) {
            invoke2((List<ModelEntitlement>) list);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<ModelEntitlement> list) {
            C12238m.checkNotNullParameter(list, "entitlements");
            StoreEntitlements.this.dispatcher.schedule(new AnonymousClass1(list));
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreEntitlements$observeEntitlementState$1 */
    /* JADX INFO: compiled from: StoreEntitlements.kt */
    public static final class C59111 extends AbstractC12240o implements Function0<State> {
        public C59111() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final State invoke() {
            return StoreEntitlements.this.stateSnapshot;
        }
    }

    public /* synthetic */ StoreEntitlements(Dispatcher dispatcher, ObservationDeck observationDeck, RestAPI restAPI, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(dispatcher, observationDeck, (i & 4) != 0 ? RestAPI.INSTANCE.getApi() : restAPI);
    }

    public final void fetchMyEntitlementsForApplication(long applicationId) {
        this.dispatcher.schedule(new C59051());
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.restSubscribeOn$default(RestAPIInterface.DefaultImpls.getMyEntitlements$default(this.restAPI, applicationId, false, 2, null), false, 1, null), (Class<?>) StoreEntitlements.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new C59062()), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C59073(applicationId));
    }

    public final void fetchMyGiftEntitlements() {
        this.dispatcher.schedule(new C59081());
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.restSubscribeOn$default(this.restAPI.getGifts(), false, 1, null), (Class<?>) StoreEntitlements.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new C59092()), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C59103());
    }

    /* JADX INFO: renamed from: getEntitlementState, reason: from getter */
    public final State getStateSnapshot() {
        return this.stateSnapshot;
    }

    @StoreThread
    public final void handleFetchEntitlementsSuccess(long applicationId, List<ModelEntitlement> entitlements) {
        C12238m.checkNotNullParameter(entitlements, "entitlements");
        this.entitlementMap.put(Long.valueOf(applicationId), entitlements);
        this.state = new State.Loaded(this.giftEntitlementMap, this.entitlementMap);
        markChanged();
    }

    @StoreThread
    public final void handleFetchError() {
        this.state = State.Failure.INSTANCE;
        markChanged();
    }

    @StoreThread
    public final void handleFetchGiftsSuccess(List<ModelEntitlement> giftEntitlements) {
        C12238m.checkNotNullParameter(giftEntitlements, "giftEntitlements");
        HashMap map = new HashMap();
        for (ModelEntitlement modelEntitlement : giftEntitlements) {
            List arrayList = (List) map.get(Long.valueOf(modelEntitlement.getSkuId()));
            if (arrayList == null) {
                arrayList = new ArrayList();
            }
            arrayList.add(modelEntitlement);
            map.put(Long.valueOf(modelEntitlement.getSkuId()), arrayList);
        }
        this.giftEntitlementMap = map;
        this.state = new State.Loaded(map, this.entitlementMap);
        markChanged();
    }

    @StoreThread
    public final void handleFetchingState() {
        this.state = State.Loading.INSTANCE;
        markChanged();
    }

    public final Observable<State> observeEntitlementState() {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new C59111(), 14, null);
    }

    @Override // com.discord.stores.StoreV2
    @StoreThread
    public void snapshotData() {
        super.snapshotData();
        this.stateSnapshot = this.state.deepCopy();
    }

    public StoreEntitlements(Dispatcher dispatcher, ObservationDeck observationDeck, RestAPI restAPI) {
        C12238m.checkNotNullParameter(dispatcher, "dispatcher");
        C12238m.checkNotNullParameter(observationDeck, "observationDeck");
        C12238m.checkNotNullParameter(restAPI, "restAPI");
        this.dispatcher = dispatcher;
        this.observationDeck = observationDeck;
        this.restAPI = restAPI;
        this.giftEntitlementMap = C12136h0.emptyMap();
        this.entitlementMap = new LinkedHashMap();
        State.Loading loading = State.Loading.INSTANCE;
        this.state = loading;
        this.stateSnapshot = loading;
    }
}
