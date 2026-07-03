package com.discord.stores;

import androidx.core.view.PointerIconCompat;
import com.discord.models.domain.ModelPaymentSource;
import com.discord.models.domain.PaymentSourceRaw;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeckProvider;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.rest.RestAPI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p580t.C12147n;
import p507d0.p580t.C12149o;
import p507d0.p580t.C12163u;
import p507d0.p582u.C12169a;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p637j0.p641k.InterfaceC12589b;
import p658rx.Observable;
import p658rx.Subscription;

/* JADX INFO: compiled from: StorePaymentSources.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StorePaymentSources extends StoreV2 {
    private final Dispatcher dispatcher;
    private final ObservationDeck observationDeck;
    private PaymentSourcesState paymentSourcesState;
    private PaymentSourcesState paymentSourcesStateSnapshot;
    private final RestAPI restAPI;

    /* JADX INFO: compiled from: StorePaymentSources.kt */
    public static abstract class PaymentSourcesState {

        /* JADX INFO: compiled from: StorePaymentSources.kt */
        public static final class Failure extends PaymentSourcesState {
            public static final Failure INSTANCE = new Failure();

            private Failure() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: StorePaymentSources.kt */
        public static final /* data */ class Loaded extends PaymentSourcesState {
            private final List<ModelPaymentSource> paymentSources;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public Loaded(List<? extends ModelPaymentSource> list) {
                super(null);
                C12238m.checkNotNullParameter(list, "paymentSources");
                this.paymentSources = list;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Loaded copy$default(Loaded loaded, List list, int i, Object obj) {
                if ((i & 1) != 0) {
                    list = loaded.paymentSources;
                }
                return loaded.copy(list);
            }

            public final List<ModelPaymentSource> component1() {
                return this.paymentSources;
            }

            public final Loaded copy(List<? extends ModelPaymentSource> paymentSources) {
                C12238m.checkNotNullParameter(paymentSources, "paymentSources");
                return new Loaded(paymentSources);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Loaded) && C12238m.areEqual(this.paymentSources, ((Loaded) other).paymentSources);
                }
                return true;
            }

            public final List<ModelPaymentSource> getPaymentSources() {
                return this.paymentSources;
            }

            public int hashCode() {
                List<ModelPaymentSource> list = this.paymentSources;
                if (list != null) {
                    return list.hashCode();
                }
                return 0;
            }

            public String toString() {
                return C1643a.m824L(C1643a.m833U("Loaded(paymentSources="), this.paymentSources, ")");
            }
        }

        /* JADX INFO: compiled from: StorePaymentSources.kt */
        public static final class Loading extends PaymentSourcesState {
            public static final Loading INSTANCE = new Loading();

            private Loading() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: StorePaymentSources.kt */
        public static final class Unfetched extends PaymentSourcesState {
            public static final Unfetched INSTANCE = new Unfetched();

            private Unfetched() {
                super(null);
            }
        }

        private PaymentSourcesState() {
        }

        public /* synthetic */ PaymentSourcesState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StorePaymentSources$fetchPaymentSources$1 */
    /* JADX INFO: compiled from: StorePaymentSources.kt */
    public static final class C63231 extends AbstractC12240o implements Function0<Unit> {

        /* JADX INFO: renamed from: com.discord.stores.StorePaymentSources$fetchPaymentSources$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: StorePaymentSources.kt */
        public static final class AnonymousClass2 extends AbstractC12240o implements Function1<List<? extends ModelPaymentSource>, Unit> {

            /* JADX INFO: renamed from: com.discord.stores.StorePaymentSources$fetchPaymentSources$1$2$1, reason: invalid class name */
            /* JADX INFO: compiled from: StorePaymentSources.kt */
            public static final class AnonymousClass1 extends AbstractC12240o implements Function0<Unit> {
                public final /* synthetic */ List $paymentSources;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public AnonymousClass1(List list) {
                    super(0);
                    this.$paymentSources = list;
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.f27425a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    StorePaymentSources storePaymentSources = StorePaymentSources.this;
                    List list = this.$paymentSources;
                    C12238m.checkNotNullExpressionValue(list, "paymentSources");
                    storePaymentSources.handlePaymentSourcesFetchSuccess(list);
                }
            }

            public AnonymousClass2() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends ModelPaymentSource> list) {
                invoke2(list);
                return Unit.f27425a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<? extends ModelPaymentSource> list) {
                StorePaymentSources.this.dispatcher.schedule(new AnonymousClass1(list));
            }
        }

        /* JADX INFO: renamed from: com.discord.stores.StorePaymentSources$fetchPaymentSources$1$3, reason: invalid class name */
        /* JADX INFO: compiled from: StorePaymentSources.kt */
        public static final class AnonymousClass3 extends AbstractC12240o implements Function1<Error, Unit> {

            /* JADX INFO: renamed from: com.discord.stores.StorePaymentSources$fetchPaymentSources$1$3$1, reason: invalid class name */
            /* JADX INFO: compiled from: StorePaymentSources.kt */
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
                    StorePaymentSources.this.handlePaymentSourcesFetchFailure();
                }
            }

            public AnonymousClass3() {
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
                StorePaymentSources.this.dispatcher.schedule(new AnonymousClass1());
            }
        }

        public C63231() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            if (StorePaymentSources.this.paymentSourcesState instanceof PaymentSourcesState.Loading) {
                return;
            }
            StorePaymentSources.this.handlePaymentSourcesFetchStart();
            Observable observableM11083G = ObservableExtensionsKt.restSubscribeOn$default(StorePaymentSources.this.restAPI.getPaymentSources(), false, 1, null).m11083G(new InterfaceC12589b<List<? extends PaymentSourceRaw>, List<? extends ModelPaymentSource>>() { // from class: com.discord.stores.StorePaymentSources.fetchPaymentSources.1.1
                @Override // p637j0.p641k.InterfaceC12589b
                public /* bridge */ /* synthetic */ List<? extends ModelPaymentSource> call(List<? extends PaymentSourceRaw> list) {
                    return call2((List<PaymentSourceRaw>) list);
                }

                /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
                public final List<ModelPaymentSource> call2(List<PaymentSourceRaw> list) {
                    StorePaymentSources storePaymentSources = StorePaymentSources.this;
                    C12238m.checkNotNullExpressionValue(list, "it");
                    return storePaymentSources.ensureDefaultPaymentSource(list);
                }
            });
            C12238m.checkNotNullExpressionValue(observableM11083G, "restAPI\n          .getPa…efaultPaymentSource(it) }");
            ObservableExtensionsKt.appSubscribe(observableM11083G, (Class<?>) StorePaymentSources.this.getClass(), (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new AnonymousClass3()), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new AnonymousClass2());
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StorePaymentSources$observePaymentSourcesState$1 */
    /* JADX INFO: compiled from: StorePaymentSources.kt */
    public static final class C63241 extends AbstractC12240o implements Function0<PaymentSourcesState> {
        public C63241() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final PaymentSourcesState invoke() {
            return StorePaymentSources.this.getPaymentSourcesStateSnapshot();
        }
    }

    public /* synthetic */ StorePaymentSources(Dispatcher dispatcher, ObservationDeck observationDeck, RestAPI restAPI, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(dispatcher, (i & 2) != 0 ? ObservationDeckProvider.get() : observationDeck, (i & 4) != 0 ? RestAPI.INSTANCE.getApi() : restAPI);
    }

    private final List<ModelPaymentSource> ensureDefaultPaymentSource(List<PaymentSourceRaw> rawPaymentSources) {
        if (rawPaymentSources.isEmpty()) {
            return C12147n.emptyList();
        }
        List mutableList = C12163u.toMutableList((Collection) C12163u.sortedWith(rawPaymentSources, new Comparator() { // from class: com.discord.stores.StorePaymentSources$ensureDefaultPaymentSource$$inlined$sortedBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return C12169a.compareValues(Integer.valueOf(!((PaymentSourceRaw) t).getDefault() ? 1 : 0), Integer.valueOf(!((PaymentSourceRaw) t2).getDefault() ? 1 : 0));
            }
        }));
        PaymentSourceRaw paymentSourceRaw = (PaymentSourceRaw) C12163u.first(mutableList);
        mutableList.set(0, paymentSourceRaw.copy((PointerIconCompat.TYPE_CROSSHAIR & 1) != 0 ? paymentSourceRaw.type : 0, (PointerIconCompat.TYPE_CROSSHAIR & 2) != 0 ? paymentSourceRaw.id : null, (PointerIconCompat.TYPE_CROSSHAIR & 4) != 0 ? paymentSourceRaw.invalid : false, (PointerIconCompat.TYPE_CROSSHAIR & 8) != 0 ? paymentSourceRaw.billingAddress : null, (PointerIconCompat.TYPE_CROSSHAIR & 16) != 0 ? paymentSourceRaw.default : true, (PointerIconCompat.TYPE_CROSSHAIR & 32) != 0 ? paymentSourceRaw.email : null, (PointerIconCompat.TYPE_CROSSHAIR & 64) != 0 ? paymentSourceRaw.brand : null, (PointerIconCompat.TYPE_CROSSHAIR & 128) != 0 ? paymentSourceRaw.last_4 : null, (PointerIconCompat.TYPE_CROSSHAIR & 256) != 0 ? paymentSourceRaw.expiresMonth : 0, (PointerIconCompat.TYPE_CROSSHAIR & 512) != 0 ? paymentSourceRaw.expiresYear : 0));
        ArrayList arrayList = new ArrayList(C12149o.collectionSizeOrDefault(mutableList, 10));
        Iterator it = mutableList.iterator();
        while (it.hasNext()) {
            arrayList.add(ModelPaymentSource.INSTANCE.wrap((PaymentSourceRaw) it.next()));
        }
        return arrayList;
    }

    @StoreThread
    private final void handlePaymentSourcesFetchFailure() {
        this.paymentSourcesState = PaymentSourcesState.Failure.INSTANCE;
        markChanged();
    }

    @StoreThread
    private final void handlePaymentSourcesFetchStart() {
        this.paymentSourcesState = PaymentSourcesState.Loading.INSTANCE;
        markChanged();
    }

    @StoreThread
    private final void handlePaymentSourcesFetchSuccess(List<? extends ModelPaymentSource> paymentSources) {
        this.paymentSourcesState = new PaymentSourcesState.Loaded(paymentSources);
        markChanged();
    }

    public final void fetchPaymentSources() {
        this.dispatcher.schedule(new C63231());
    }

    /* JADX INFO: renamed from: getPaymentSourcesState, reason: from getter */
    public final PaymentSourcesState getPaymentSourcesStateSnapshot() {
        return this.paymentSourcesStateSnapshot;
    }

    @StoreThread
    public final void handlePreLogout() {
        this.paymentSourcesState = PaymentSourcesState.Unfetched.INSTANCE;
        markChanged();
    }

    @StoreThread
    public final void handleUserPaymentSourcesUpdate() {
        fetchPaymentSources();
    }

    public final Observable<PaymentSourcesState> observePaymentSourcesState() {
        Observable<PaymentSourcesState> observableM11112r = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new C63241(), 14, null).m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r, "observationDeck.connectR… }.distinctUntilChanged()");
        return observableM11112r;
    }

    @Override // com.discord.stores.StoreV2
    @StoreThread
    public void snapshotData() {
        super.snapshotData();
        PaymentSourcesState paymentSourcesStateCopy = this.paymentSourcesState;
        if (paymentSourcesStateCopy instanceof PaymentSourcesState.Loaded) {
            PaymentSourcesState.Loaded loaded = (PaymentSourcesState.Loaded) paymentSourcesStateCopy;
            paymentSourcesStateCopy = loaded.copy(new ArrayList(loaded.getPaymentSources()));
        } else if (!C12238m.areEqual(paymentSourcesStateCopy, PaymentSourcesState.Loading.INSTANCE) && !C12238m.areEqual(paymentSourcesStateCopy, PaymentSourcesState.Failure.INSTANCE) && !C12238m.areEqual(paymentSourcesStateCopy, PaymentSourcesState.Unfetched.INSTANCE)) {
            throw new NoWhenBranchMatchedException();
        }
        this.paymentSourcesStateSnapshot = paymentSourcesStateCopy;
    }

    public StorePaymentSources(Dispatcher dispatcher, ObservationDeck observationDeck, RestAPI restAPI) {
        C12238m.checkNotNullParameter(dispatcher, "dispatcher");
        C12238m.checkNotNullParameter(observationDeck, "observationDeck");
        C12238m.checkNotNullParameter(restAPI, "restAPI");
        this.dispatcher = dispatcher;
        this.observationDeck = observationDeck;
        this.restAPI = restAPI;
        PaymentSourcesState.Unfetched unfetched = PaymentSourcesState.Unfetched.INSTANCE;
        this.paymentSourcesState = unfetched;
        this.paymentSourcesStateSnapshot = unfetched;
    }
}
