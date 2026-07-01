package com.discord.widgets.settings.billing;

import b.a.d.AppViewModel;
import b.d.b.a.outline;
import com.discord.models.domain.ModelPaymentSource;
import com.discord.models.domain.ModelSubscription;
import com.discord.stores.StorePaymentSources;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreSubscriptions;
import com.discord.utilities.error.Error;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.settings.billing.PaymentSourceAdapter;
import d0.t.Collections2;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.Subscription;
import rx.functions.Func2;

/* JADX INFO: compiled from: SettingsBillingViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SettingsBillingViewModel extends AppViewModel<ViewState> {
    private final StorePaymentSources storePaymentSources;
    private final StoreSubscriptions storeSubscriptions;

    /* JADX INFO: renamed from: com.discord.widgets.settings.billing.SettingsBillingViewModel$2, reason: invalid class name */
    /* JADX INFO: compiled from: SettingsBillingViewModel.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<StoreState, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreState storeState) {
            invoke2(storeState);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreState storeState) {
            Intrinsics3.checkNotNullParameter(storeState, "storeState");
            SettingsBillingViewModel.this.handleStoreState(storeState);
        }
    }

    /* JADX INFO: compiled from: SettingsBillingViewModel.kt */
    public static final /* data */ class StoreState {
        private final StorePaymentSources.PaymentSourcesState paymentSourceState;
        private final StoreSubscriptions.SubscriptionsState subscriptionsState;

        public StoreState(StorePaymentSources.PaymentSourcesState paymentSourcesState, StoreSubscriptions.SubscriptionsState subscriptionsState) {
            Intrinsics3.checkNotNullParameter(paymentSourcesState, "paymentSourceState");
            Intrinsics3.checkNotNullParameter(subscriptionsState, "subscriptionsState");
            this.paymentSourceState = paymentSourcesState;
            this.subscriptionsState = subscriptionsState;
        }

        public static /* synthetic */ StoreState copy$default(StoreState storeState, StorePaymentSources.PaymentSourcesState paymentSourcesState, StoreSubscriptions.SubscriptionsState subscriptionsState, int i, Object obj) {
            if ((i & 1) != 0) {
                paymentSourcesState = storeState.paymentSourceState;
            }
            if ((i & 2) != 0) {
                subscriptionsState = storeState.subscriptionsState;
            }
            return storeState.copy(paymentSourcesState, subscriptionsState);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final StorePaymentSources.PaymentSourcesState getPaymentSourceState() {
            return this.paymentSourceState;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final StoreSubscriptions.SubscriptionsState getSubscriptionsState() {
            return this.subscriptionsState;
        }

        public final StoreState copy(StorePaymentSources.PaymentSourcesState paymentSourceState, StoreSubscriptions.SubscriptionsState subscriptionsState) {
            Intrinsics3.checkNotNullParameter(paymentSourceState, "paymentSourceState");
            Intrinsics3.checkNotNullParameter(subscriptionsState, "subscriptionsState");
            return new StoreState(paymentSourceState, subscriptionsState);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StoreState)) {
                return false;
            }
            StoreState storeState = (StoreState) other;
            return Intrinsics3.areEqual(this.paymentSourceState, storeState.paymentSourceState) && Intrinsics3.areEqual(this.subscriptionsState, storeState.subscriptionsState);
        }

        public final StorePaymentSources.PaymentSourcesState getPaymentSourceState() {
            return this.paymentSourceState;
        }

        public final StoreSubscriptions.SubscriptionsState getSubscriptionsState() {
            return this.subscriptionsState;
        }

        public int hashCode() {
            StorePaymentSources.PaymentSourcesState paymentSourcesState = this.paymentSourceState;
            int iHashCode = (paymentSourcesState != null ? paymentSourcesState.hashCode() : 0) * 31;
            StoreSubscriptions.SubscriptionsState subscriptionsState = this.subscriptionsState;
            return iHashCode + (subscriptionsState != null ? subscriptionsState.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("StoreState(paymentSourceState=");
            sbU.append(this.paymentSourceState);
            sbU.append(", subscriptionsState=");
            sbU.append(this.subscriptionsState);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* JADX INFO: compiled from: SettingsBillingViewModel.kt */
    public static abstract class ViewState {

        /* JADX INFO: compiled from: SettingsBillingViewModel.kt */
        public static final class Failure extends ViewState {
            public static final Failure INSTANCE = new Failure();

            private Failure() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: SettingsBillingViewModel.kt */
        public static final /* data */ class Loaded extends ViewState {
            private final List<PaymentSourceAdapter.Item> paymentSourceItems;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public Loaded(List<? extends PaymentSourceAdapter.Item> list) {
                super(null);
                Intrinsics3.checkNotNullParameter(list, "paymentSourceItems");
                this.paymentSourceItems = list;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Loaded copy$default(Loaded loaded, List list, int i, Object obj) {
                if ((i & 1) != 0) {
                    list = loaded.paymentSourceItems;
                }
                return loaded.copy(list);
            }

            public final List<PaymentSourceAdapter.Item> component1() {
                return this.paymentSourceItems;
            }

            public final Loaded copy(List<? extends PaymentSourceAdapter.Item> paymentSourceItems) {
                Intrinsics3.checkNotNullParameter(paymentSourceItems, "paymentSourceItems");
                return new Loaded(paymentSourceItems);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Loaded) && Intrinsics3.areEqual(this.paymentSourceItems, ((Loaded) other).paymentSourceItems);
                }
                return true;
            }

            public final List<PaymentSourceAdapter.Item> getPaymentSourceItems() {
                return this.paymentSourceItems;
            }

            public int hashCode() {
                List<PaymentSourceAdapter.Item> list = this.paymentSourceItems;
                if (list != null) {
                    return list.hashCode();
                }
                return 0;
            }

            public String toString() {
                return outline.L(outline.U("Loaded(paymentSourceItems="), this.paymentSourceItems, ")");
            }
        }

        /* JADX INFO: compiled from: SettingsBillingViewModel.kt */
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

    public SettingsBillingViewModel() {
        this(null, null, null, 7, null);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ SettingsBillingViewModel(StorePaymentSources storePaymentSources, StoreSubscriptions storeSubscriptions, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        storePaymentSources = (i & 1) != 0 ? StoreStream.INSTANCE.getPaymentSources() : storePaymentSources;
        storeSubscriptions = (i & 2) != 0 ? StoreStream.INSTANCE.getSubscriptions() : storeSubscriptions;
        if ((i & 4) != 0) {
            StoreStream.Companion companion = StoreStream.INSTANCE;
            observable = Observable.j(companion.getPaymentSources().observePaymentSourcesState(), companion.getSubscriptions().observeSubscriptions(), new Func2<StorePaymentSources.PaymentSourcesState, StoreSubscriptions.SubscriptionsState, StoreState>() { // from class: com.discord.widgets.settings.billing.SettingsBillingViewModel.1
                @Override // rx.functions.Func2
                public final StoreState call(StorePaymentSources.PaymentSourcesState paymentSourcesState, StoreSubscriptions.SubscriptionsState subscriptionsState) {
                    Intrinsics3.checkNotNullExpressionValue(paymentSourcesState, "paymentSourcesState");
                    Intrinsics3.checkNotNullExpressionValue(subscriptionsState, "subscriptionsState");
                    return new StoreState(paymentSourcesState, subscriptionsState);
                }
            });
            Intrinsics3.checkNotNullExpressionValue(observable, "Observable\n      .combin…nsState\n        )\n      }");
        }
        this(storePaymentSources, storeSubscriptions, observable);
    }

    private final void fetchData() {
        this.storePaymentSources.fetchPaymentSources();
        this.storeSubscriptions.fetchSubscriptions();
    }

    private final List<PaymentSourceAdapter.Item> generateListItems(List<? extends ModelPaymentSource> paymentSources, ModelSubscription premiumSubscription) {
        ArrayList arrayList = new ArrayList();
        if (!paymentSources.isEmpty()) {
            int i = 0;
            for (Object obj : paymentSources) {
                int i2 = i + 1;
                if (i < 0) {
                    Collections2.throwIndexOverflow();
                }
                ModelPaymentSource modelPaymentSource = (ModelPaymentSource) obj;
                PaymentSourceAdapter.PaymentSourceHeader.Type type = i != 0 ? i != 1 ? null : PaymentSourceAdapter.PaymentSourceHeader.Type.OTHER : PaymentSourceAdapter.PaymentSourceHeader.Type.DEFAULT;
                PaymentSourceAdapter.PaymentSourceHeader paymentSourceHeader = type != null ? new PaymentSourceAdapter.PaymentSourceHeader(type) : null;
                if (paymentSourceHeader != null) {
                    arrayList.add(paymentSourceHeader);
                }
                arrayList.add(new PaymentSourceAdapter.PaymentSourceItem(modelPaymentSource, Intrinsics3.areEqual(modelPaymentSource.getId(), premiumSubscription != null ? premiumSubscription.getPaymentSourceId() : null) && !premiumSubscription.getStatus().isCanceled()));
                i = i2;
            }
            arrayList.add(new PaymentSourceAdapter.PaymentSourceAddItem());
        }
        return arrayList;
    }

    private final void handleStoreState(StoreState storeState) {
        StorePaymentSources.PaymentSourcesState paymentSourceState = storeState.getPaymentSourceState();
        StoreSubscriptions.SubscriptionsState subscriptionsState = storeState.getSubscriptionsState();
        if ((paymentSourceState instanceof StorePaymentSources.PaymentSourcesState.Loaded) && (subscriptionsState instanceof StoreSubscriptions.SubscriptionsState.Loaded)) {
            updateViewState(new ViewState.Loaded(generateListItems(((StorePaymentSources.PaymentSourcesState.Loaded) paymentSourceState).getPaymentSources(), ((StoreSubscriptions.SubscriptionsState.Loaded) subscriptionsState).getPremiumSubscription())));
        } else if ((paymentSourceState instanceof StorePaymentSources.PaymentSourcesState.Failure) || (subscriptionsState instanceof StoreSubscriptions.SubscriptionsState.Failure)) {
            updateViewState(ViewState.Failure.INSTANCE);
        } else {
            updateViewState(ViewState.Loading.INSTANCE);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SettingsBillingViewModel(StorePaymentSources storePaymentSources, StoreSubscriptions storeSubscriptions, Observable<StoreState> observable) {
        super(ViewState.Loading.INSTANCE);
        Intrinsics3.checkNotNullParameter(storePaymentSources, "storePaymentSources");
        Intrinsics3.checkNotNullParameter(storeSubscriptions, "storeSubscriptions");
        Intrinsics3.checkNotNullParameter(observable, "storeObservable");
        this.storePaymentSources = storePaymentSources;
        this.storeSubscriptions = storeSubscriptions;
        fetchData();
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observable), this, null, 2, null), (Class<?>) SettingsBillingViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass2());
    }
}
