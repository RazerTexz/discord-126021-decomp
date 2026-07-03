package com.discord.stores;

import com.android.billingclient.api.SkuDetails;
import com.discord.stores.updates.ObservationDeck;
import com.discord.utilities.billing.GooglePlayInAppSkus;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p512d0.C11226f;
import p507d0.p580t.C12134g0;
import p507d0.p580t.C12136h0;
import p507d0.p580t.C12149o;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p658rx.Observable;

/* JADX INFO: compiled from: StoreGooglePlaySkuDetails.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGooglePlaySkuDetails extends StoreV2 {
    private final Dispatcher dispatcher;
    private final ObservationDeck observationDeck;
    private State skuState;
    private State skuStateSnapshot;

    /* JADX INFO: compiled from: StoreGooglePlaySkuDetails.kt */
    public static abstract class State {

        /* JADX INFO: compiled from: StoreGooglePlaySkuDetails.kt */
        public static final class Failure extends State {
            public static final Failure INSTANCE = new Failure();

            private Failure() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: StoreGooglePlaySkuDetails.kt */
        public static final /* data */ class Loaded extends State {
            private final Map<String, SkuDetails> skuDetails;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public Loaded(Map<String, ? extends SkuDetails> map) {
                super(null);
                C12238m.checkNotNullParameter(map, "skuDetails");
                this.skuDetails = map;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Loaded copy$default(Loaded loaded, Map map, int i, Object obj) {
                if ((i & 1) != 0) {
                    map = loaded.skuDetails;
                }
                return loaded.copy(map);
            }

            public final Map<String, SkuDetails> component1() {
                return this.skuDetails;
            }

            public final Loaded copy(Map<String, ? extends SkuDetails> skuDetails) {
                C12238m.checkNotNullParameter(skuDetails, "skuDetails");
                return new Loaded(skuDetails);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Loaded) && C12238m.areEqual(this.skuDetails, ((Loaded) other).skuDetails);
                }
                return true;
            }

            public final Map<String, SkuDetails> getSkuDetails() {
                return this.skuDetails;
            }

            public int hashCode() {
                Map<String, SkuDetails> map = this.skuDetails;
                if (map != null) {
                    return map.hashCode();
                }
                return 0;
            }

            public String toString() {
                return C1643a.m825M(C1643a.m833U("Loaded(skuDetails="), this.skuDetails, ")");
            }
        }

        /* JADX INFO: compiled from: StoreGooglePlaySkuDetails.kt */
        public static final class Uninitialized extends State {
            public static final Uninitialized INSTANCE = new Uninitialized();

            private Uninitialized() {
                super(null);
            }
        }

        private State() {
        }

        public /* synthetic */ State(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGooglePlaySkuDetails$handleError$1 */
    /* JADX INFO: compiled from: StoreGooglePlaySkuDetails.kt */
    public static final class C60141 extends AbstractC12240o implements Function0<Unit> {
        public C60141() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreGooglePlaySkuDetails.this.handleFetchError();
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGooglePlaySkuDetails$observeState$1 */
    /* JADX INFO: compiled from: StoreGooglePlaySkuDetails.kt */
    public static final class C60151 extends AbstractC12240o implements Function0<State> {
        public C60151() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final State invoke() {
            return StoreGooglePlaySkuDetails.this.getSkuStateSnapshot();
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGooglePlaySkuDetails$updateSkuDetails$1 */
    /* JADX INFO: compiled from: StoreGooglePlaySkuDetails.kt */
    public static final class C60161 extends AbstractC12240o implements Function0<Unit> {
        public final /* synthetic */ List $skuDetails;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C60161(List list) {
            super(0);
            this.$skuDetails = list;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreGooglePlaySkuDetails.this.handleFetchSuccess(this.$skuDetails);
        }
    }

    public StoreGooglePlaySkuDetails(ObservationDeck observationDeck, Dispatcher dispatcher) {
        C12238m.checkNotNullParameter(observationDeck, "observationDeck");
        C12238m.checkNotNullParameter(dispatcher, "dispatcher");
        this.observationDeck = observationDeck;
        this.dispatcher = dispatcher;
        State.Uninitialized uninitialized = State.Uninitialized.INSTANCE;
        this.skuState = uninitialized;
        this.skuStateSnapshot = uninitialized;
    }

    /* JADX INFO: renamed from: getState, reason: from getter */
    public final State getSkuStateSnapshot() {
        return this.skuStateSnapshot;
    }

    public final void handleError() {
        this.dispatcher.schedule(new C60141());
    }

    @StoreThread
    public final void handleFetchError() {
        this.skuState = State.Failure.INSTANCE;
        markChanged();
    }

    @StoreThread
    public final void handleFetchSuccess(List<? extends SkuDetails> newSkuDetails) {
        C12238m.checkNotNullParameter(newSkuDetails, "newSkuDetails");
        State state = this.skuState;
        if (!(state instanceof State.Loaded)) {
            state = null;
        }
        State.Loaded loaded = (State.Loaded) state;
        Map<String, SkuDetails> skuDetails = loaded != null ? loaded.getSkuDetails() : null;
        if (skuDetails == null) {
            skuDetails = C12136h0.emptyMap();
        }
        Map<String, ? extends SkuDetails> mutableMap = C12136h0.toMutableMap(skuDetails);
        LinkedHashMap linkedHashMap = new LinkedHashMap(C11226f.coerceAtLeast(C12134g0.mapCapacity(C12149o.collectionSizeOrDefault(newSkuDetails, 10)), 16));
        for (Object obj : newSkuDetails) {
            linkedHashMap.put(((SkuDetails) obj).m7503d(), obj);
        }
        mutableMap.putAll(linkedHashMap);
        GooglePlayInAppSkus.INSTANCE.populateSkuDetails(mutableMap);
        this.skuState = new State.Loaded(mutableMap);
        markChanged();
    }

    public final Observable<State> observeState() {
        Observable<State> observableM11112r = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new C60151(), 14, null).m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r, "observationDeck.connectR…  .distinctUntilChanged()");
        return observableM11112r;
    }

    @Override // com.discord.stores.StoreV2
    public void snapshotData() {
        super.snapshotData();
        State stateCopy = this.skuState;
        if (stateCopy instanceof State.Loaded) {
            State.Loaded loaded = (State.Loaded) stateCopy;
            stateCopy = loaded.copy(new HashMap(loaded.getSkuDetails()));
        } else if (!C12238m.areEqual(stateCopy, State.Uninitialized.INSTANCE) && !C12238m.areEqual(stateCopy, State.Failure.INSTANCE)) {
            throw new NoWhenBranchMatchedException();
        }
        this.skuStateSnapshot = stateCopy;
    }

    public final void updateSkuDetails(List<? extends SkuDetails> skuDetails) {
        C12238m.checkNotNullParameter(skuDetails, "skuDetails");
        this.dispatcher.schedule(new C60161(skuDetails));
    }
}
