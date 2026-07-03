package com.discord.widgets.guild_role_subscriptions;

import com.discord.stores.StoreGuildRoleSubscriptions;
import com.discord.stores.StoreStream;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeckProvider;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p008a.p018d.AbstractC0859d0;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p658rx.Observable;
import p658rx.Subscription;

/* JADX INFO: compiled from: PriceTierPickerBottomSheetViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class PriceTierPickerBottomSheetViewModel extends AbstractC0859d0<ViewState> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: com.discord.widgets.guild_role_subscriptions.PriceTierPickerBottomSheetViewModel$1 */
    /* JADX INFO: compiled from: PriceTierPickerBottomSheetViewModel.kt */
    public static final class C84381 extends AbstractC12240o implements Function1<StoreState, Unit> {
        public C84381() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreState storeState) {
            invoke2(storeState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreState storeState) {
            C12238m.checkNotNullParameter(storeState, "storeState");
            PriceTierPickerBottomSheetViewModel.this.handleStoreState(storeState);
        }
    }

    /* JADX INFO: compiled from: PriceTierPickerBottomSheetViewModel.kt */
    public static final class Companion {
        private Companion() {
        }

        private final Observable<StoreState> observeStoreState(ObservationDeck observationDeck, StoreGuildRoleSubscriptions storeGuildRoleSubscriptions) {
            return ObservationDeck.connectRx$default(observationDeck, new ObservationDeck.UpdateSource[]{storeGuildRoleSubscriptions}, false, null, null, new C8439xe1dc6f86(storeGuildRoleSubscriptions), 14, null);
        }

        public static /* synthetic */ Observable observeStoreState$default(Companion companion, ObservationDeck observationDeck, StoreGuildRoleSubscriptions storeGuildRoleSubscriptions, int i, Object obj) {
            if ((i & 1) != 0) {
                observationDeck = ObservationDeckProvider.get();
            }
            if ((i & 2) != 0) {
                storeGuildRoleSubscriptions = StoreStream.INSTANCE.getGuildRoleSubscriptions();
            }
            return companion.observeStoreState(observationDeck, storeGuildRoleSubscriptions);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: PriceTierPickerBottomSheetViewModel.kt */
    public static final /* data */ class StoreState {
        private final StoreGuildRoleSubscriptions.PriceTierState priceTierState;

        public StoreState(StoreGuildRoleSubscriptions.PriceTierState priceTierState) {
            C12238m.checkNotNullParameter(priceTierState, "priceTierState");
            this.priceTierState = priceTierState;
        }

        public static /* synthetic */ StoreState copy$default(StoreState storeState, StoreGuildRoleSubscriptions.PriceTierState priceTierState, int i, Object obj) {
            if ((i & 1) != 0) {
                priceTierState = storeState.priceTierState;
            }
            return storeState.copy(priceTierState);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final StoreGuildRoleSubscriptions.PriceTierState getPriceTierState() {
            return this.priceTierState;
        }

        public final StoreState copy(StoreGuildRoleSubscriptions.PriceTierState priceTierState) {
            C12238m.checkNotNullParameter(priceTierState, "priceTierState");
            return new StoreState(priceTierState);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof StoreState) && C12238m.areEqual(this.priceTierState, ((StoreState) other).priceTierState);
            }
            return true;
        }

        public final StoreGuildRoleSubscriptions.PriceTierState getPriceTierState() {
            return this.priceTierState;
        }

        public int hashCode() {
            StoreGuildRoleSubscriptions.PriceTierState priceTierState = this.priceTierState;
            if (priceTierState != null) {
                return priceTierState.hashCode();
            }
            return 0;
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("StoreState(priceTierState=");
            sbM833U.append(this.priceTierState);
            sbM833U.append(")");
            return sbM833U.toString();
        }
    }

    /* JADX INFO: compiled from: PriceTierPickerBottomSheetViewModel.kt */
    public static abstract class ViewState {

        /* JADX INFO: compiled from: PriceTierPickerBottomSheetViewModel.kt */
        public static final class Failed extends ViewState {
            public static final Failed INSTANCE = new Failed();

            private Failed() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: PriceTierPickerBottomSheetViewModel.kt */
        public static final /* data */ class Loaded extends ViewState {
            private final List<Integer> priceTiers;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Loaded(List<Integer> list) {
                super(null);
                C12238m.checkNotNullParameter(list, "priceTiers");
                this.priceTiers = list;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Loaded copy$default(Loaded loaded, List list, int i, Object obj) {
                if ((i & 1) != 0) {
                    list = loaded.priceTiers;
                }
                return loaded.copy(list);
            }

            public final List<Integer> component1() {
                return this.priceTiers;
            }

            public final Loaded copy(List<Integer> priceTiers) {
                C12238m.checkNotNullParameter(priceTiers, "priceTiers");
                return new Loaded(priceTiers);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Loaded) && C12238m.areEqual(this.priceTiers, ((Loaded) other).priceTiers);
                }
                return true;
            }

            public final List<Integer> getPriceTiers() {
                return this.priceTiers;
            }

            public int hashCode() {
                List<Integer> list = this.priceTiers;
                if (list != null) {
                    return list.hashCode();
                }
                return 0;
            }

            public String toString() {
                return C1643a.m824L(C1643a.m833U("Loaded(priceTiers="), this.priceTiers, ")");
            }
        }

        /* JADX INFO: compiled from: PriceTierPickerBottomSheetViewModel.kt */
        public static final class Loading extends ViewState {
            public static final Loading INSTANCE = new Loading();

            private Loading() {
                super(null);
            }
        }

        private ViewState() {
        }

        public /* synthetic */ ViewState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PriceTierPickerBottomSheetViewModel() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public /* synthetic */ PriceTierPickerBottomSheetViewModel(StoreGuildRoleSubscriptions storeGuildRoleSubscriptions, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? StoreStream.INSTANCE.getGuildRoleSubscriptions() : storeGuildRoleSubscriptions, (i & 2) != 0 ? Companion.observeStoreState$default(INSTANCE, null, null, 3, null) : observable);
    }

    private final void handleStoreState(StoreState storeState) {
        StoreGuildRoleSubscriptions.PriceTierState priceTierState = storeState.getPriceTierState();
        if (priceTierState instanceof StoreGuildRoleSubscriptions.PriceTierState.Loading) {
            updateViewState(ViewState.Loading.INSTANCE);
        } else if (priceTierState instanceof StoreGuildRoleSubscriptions.PriceTierState.Failed) {
            updateViewState(ViewState.Failed.INSTANCE);
        } else if (priceTierState instanceof StoreGuildRoleSubscriptions.PriceTierState.Loaded) {
            updateViewState(new ViewState.Loaded(((StoreGuildRoleSubscriptions.PriceTierState.Loaded) storeState.getPriceTierState()).getPriceTiers()));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PriceTierPickerBottomSheetViewModel(StoreGuildRoleSubscriptions storeGuildRoleSubscriptions, Observable<StoreState> observable) {
        super(null, 1, null);
        C12238m.checkNotNullParameter(storeGuildRoleSubscriptions, "storeGuildRoleSubscriptions");
        C12238m.checkNotNullParameter(observable, "storeObservable");
        storeGuildRoleSubscriptions.fetchPriceTiersIfNonExisting();
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observable), this, null, 2, null), (Class<?>) PriceTierPickerBottomSheetViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C84381());
    }
}
