package com.discord.stores;

import androidx.core.view.PointerIconCompat;
import b.d.b.a.outline;
import com.discord.models.domain.ModelPaymentSource;
import com.discord.models.domain.ModelPaymentSource3;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck4;
import com.discord.utilities.error.Error;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.t.Collections2;
import d0.t.Iterables2;
import d0.t._Collections;
import d0.u.a;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.k.Func1;
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
import rx.Observable;
import rx.Subscription;

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
                Intrinsics3.checkNotNullParameter(list, "paymentSources");
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
                Intrinsics3.checkNotNullParameter(paymentSources, "paymentSources");
                return new Loaded(paymentSources);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Loaded) && Intrinsics3.areEqual(this.paymentSources, ((Loaded) other).paymentSources);
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
                return outline.L(outline.U("Loaded(paymentSources="), this.paymentSources, ")");
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

    /* JADX INFO: renamed from: com.discord.stores.StorePaymentSources$fetchPaymentSources$1, reason: invalid class name */
    /* JADX INFO: compiled from: StorePaymentSources.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {

        /* JADX INFO: renamed from: com.discord.stores.StorePaymentSources$fetchPaymentSources$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: StorePaymentSources.kt */
        public static final class AnonymousClass2 extends Lambda implements Function1<List<? extends ModelPaymentSource>, Unit> {

            /* JADX INFO: renamed from: com.discord.stores.StorePaymentSources$fetchPaymentSources$1$2$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: StorePaymentSources.kt */
            public static final class C01631 extends Lambda implements Function0<Unit> {
                public final /* synthetic */ List $paymentSources;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C01631(List list) {
                    super(0);
                    this.$paymentSources = list;
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    StorePaymentSources storePaymentSources = StorePaymentSources.this;
                    List list = this.$paymentSources;
                    Intrinsics3.checkNotNullExpressionValue(list, "paymentSources");
                    storePaymentSources.handlePaymentSourcesFetchSuccess(list);
                }
            }

            public AnonymousClass2() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends ModelPaymentSource> list) {
                invoke2(list);
                return Unit.a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<? extends ModelPaymentSource> list) {
                StorePaymentSources.this.dispatcher.schedule(new C01631(list));
            }
        }

        /* JADX INFO: renamed from: com.discord.stores.StorePaymentSources$fetchPaymentSources$1$3, reason: invalid class name */
        /* JADX INFO: compiled from: StorePaymentSources.kt */
        public static final class AnonymousClass3 extends Lambda implements Function1<Error, Unit> {

            /* JADX INFO: renamed from: com.discord.stores.StorePaymentSources$fetchPaymentSources$1$3$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: StorePaymentSources.kt */
            public static final class C01641 extends Lambda implements Function0<Unit> {
                public C01641() {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.a;
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
                return Unit.a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Error error) {
                Intrinsics3.checkNotNullParameter(error, "it");
                StorePaymentSources.this.dispatcher.schedule(new C01641());
            }
        }

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
            if (StorePaymentSources.this.paymentSourcesState instanceof PaymentSourcesState.Loading) {
                return;
            }
            StorePaymentSources.this.handlePaymentSourcesFetchStart();
            Observable observableG = ObservableExtensionsKt.restSubscribeOn$default(StorePaymentSources.this.restAPI.getPaymentSources(), false, 1, null).G(new Func1<List<? extends ModelPaymentSource3>, List<? extends ModelPaymentSource>>() { // from class: com.discord.stores.StorePaymentSources.fetchPaymentSources.1.1
                @Override // j0.k.Func1
                public /* bridge */ /* synthetic */ List<? extends ModelPaymentSource> call(List<? extends ModelPaymentSource3> list) {
                    return call2((List<ModelPaymentSource3>) list);
                }

                /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
                public final List<ModelPaymentSource> call2(List<ModelPaymentSource3> list) {
                    StorePaymentSources storePaymentSources = StorePaymentSources.this;
                    Intrinsics3.checkNotNullExpressionValue(list, "it");
                    return storePaymentSources.ensureDefaultPaymentSource(list);
                }
            });
            Intrinsics3.checkNotNullExpressionValue(observableG, "restAPI\n          .getPa…efaultPaymentSource(it) }");
            ObservableExtensionsKt.appSubscribe(observableG, (Class<?>) StorePaymentSources.this.getClass(), (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new AnonymousClass3()), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass2());
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StorePaymentSources$observePaymentSourcesState$1, reason: invalid class name */
    /* JADX INFO: compiled from: StorePaymentSources.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<PaymentSourcesState> {
        public AnonymousClass1() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final PaymentSourcesState invoke() {
            return StorePaymentSources.this.getPaymentSourcesStateSnapshot();
        }
    }

    public /* synthetic */ StorePaymentSources(Dispatcher dispatcher, ObservationDeck observationDeck, RestAPI restAPI, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(dispatcher, (i & 2) != 0 ? ObservationDeck4.get() : observationDeck, (i & 4) != 0 ? RestAPI.INSTANCE.getApi() : restAPI);
    }

    private final List<ModelPaymentSource> ensureDefaultPaymentSource(List<ModelPaymentSource3> rawPaymentSources) {
        if (rawPaymentSources.isEmpty()) {
            return Collections2.emptyList();
        }
        List mutableList = _Collections.toMutableList((Collection) _Collections.sortedWith(rawPaymentSources, new Comparator() { // from class: com.discord.stores.StorePaymentSources$ensureDefaultPaymentSource$$inlined$sortedBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return a.compareValues(Integer.valueOf(!((ModelPaymentSource3) t).getDefault() ? 1 : 0), Integer.valueOf(!((ModelPaymentSource3) t2).getDefault() ? 1 : 0));
            }
        }));
        ModelPaymentSource3 modelPaymentSource3 = (ModelPaymentSource3) _Collections.first(mutableList);
        mutableList.set(0, modelPaymentSource3.copy((PointerIconCompat.TYPE_CROSSHAIR & 1) != 0 ? modelPaymentSource3.type : 0, (PointerIconCompat.TYPE_CROSSHAIR & 2) != 0 ? modelPaymentSource3.id : null, (PointerIconCompat.TYPE_CROSSHAIR & 4) != 0 ? modelPaymentSource3.invalid : false, (PointerIconCompat.TYPE_CROSSHAIR & 8) != 0 ? modelPaymentSource3.billingAddress : null, (PointerIconCompat.TYPE_CROSSHAIR & 16) != 0 ? modelPaymentSource3.default : true, (PointerIconCompat.TYPE_CROSSHAIR & 32) != 0 ? modelPaymentSource3.email : null, (PointerIconCompat.TYPE_CROSSHAIR & 64) != 0 ? modelPaymentSource3.brand : null, (PointerIconCompat.TYPE_CROSSHAIR & 128) != 0 ? modelPaymentSource3.last_4 : null, (PointerIconCompat.TYPE_CROSSHAIR & 256) != 0 ? modelPaymentSource3.expiresMonth : 0, (PointerIconCompat.TYPE_CROSSHAIR & 512) != 0 ? modelPaymentSource3.expiresYear : 0));
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(mutableList, 10));
        Iterator it = mutableList.iterator();
        while (it.hasNext()) {
            arrayList.add(ModelPaymentSource.INSTANCE.wrap((ModelPaymentSource3) it.next()));
        }
        return arrayList;
    }

    @Store3
    private final void handlePaymentSourcesFetchFailure() {
        this.paymentSourcesState = PaymentSourcesState.Failure.INSTANCE;
        markChanged();
    }

    @Store3
    private final void handlePaymentSourcesFetchStart() {
        this.paymentSourcesState = PaymentSourcesState.Loading.INSTANCE;
        markChanged();
    }

    @Store3
    private final void handlePaymentSourcesFetchSuccess(List<? extends ModelPaymentSource> paymentSources) {
        this.paymentSourcesState = new PaymentSourcesState.Loaded(paymentSources);
        markChanged();
    }

    public final void fetchPaymentSources() {
        this.dispatcher.schedule(new AnonymousClass1());
    }

    /* JADX INFO: renamed from: getPaymentSourcesState, reason: from getter */
    public final PaymentSourcesState getPaymentSourcesStateSnapshot() {
        return this.paymentSourcesStateSnapshot;
    }

    @Store3
    public final void handlePreLogout() {
        this.paymentSourcesState = PaymentSourcesState.Unfetched.INSTANCE;
        markChanged();
    }

    @Store3
    public final void handleUserPaymentSourcesUpdate() {
        fetchPaymentSources();
    }

    public final Observable<PaymentSourcesState> observePaymentSourcesState() {
        Observable<PaymentSourcesState> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(), 14, null).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "observationDeck.connectR… }.distinctUntilChanged()");
        return observableR;
    }

    @Override // com.discord.stores.StoreV2
    @Store3
    public void snapshotData() {
        super.snapshotData();
        PaymentSourcesState paymentSourcesStateCopy = this.paymentSourcesState;
        if (paymentSourcesStateCopy instanceof PaymentSourcesState.Loaded) {
            PaymentSourcesState.Loaded loaded = (PaymentSourcesState.Loaded) paymentSourcesStateCopy;
            paymentSourcesStateCopy = loaded.copy(new ArrayList(loaded.getPaymentSources()));
        } else if (!Intrinsics3.areEqual(paymentSourcesStateCopy, PaymentSourcesState.Loading.INSTANCE) && !Intrinsics3.areEqual(paymentSourcesStateCopy, PaymentSourcesState.Failure.INSTANCE) && !Intrinsics3.areEqual(paymentSourcesStateCopy, PaymentSourcesState.Unfetched.INSTANCE)) {
            throw new NoWhenBranchMatchedException();
        }
        this.paymentSourcesStateSnapshot = paymentSourcesStateCopy;
    }

    public StorePaymentSources(Dispatcher dispatcher, ObservationDeck observationDeck, RestAPI restAPI) {
        Intrinsics3.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        Intrinsics3.checkNotNullParameter(restAPI, "restAPI");
        this.dispatcher = dispatcher;
        this.observationDeck = observationDeck;
        this.restAPI = restAPI;
        PaymentSourcesState.Unfetched unfetched = PaymentSourcesState.Unfetched.INSTANCE;
        this.paymentSourcesState = unfetched;
        this.paymentSourcesStateSnapshot = unfetched;
    }
}
