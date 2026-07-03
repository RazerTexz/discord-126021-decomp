package com.discord.stores;

import com.discord.models.domain.ModelSubscription;
import com.discord.stores.updates.ObservationDeck;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.rest.RestAPI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p658rx.Observable;
import p658rx.Subscription;

/* JADX INFO: compiled from: StoreSubscriptions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreSubscriptions extends StoreV2 {
    private final Dispatcher dispatcher;
    private final ObservationDeck observationDeck;
    private final RestAPI restAPI;
    private SubscriptionsState subscriptionsState;
    private SubscriptionsState subscriptionsStateSnapshot;

    /* JADX INFO: compiled from: StoreSubscriptions.kt */
    public static abstract class SubscriptionsState {

        /* JADX INFO: compiled from: StoreSubscriptions.kt */
        public static final class Failure extends SubscriptionsState {
            public static final Failure INSTANCE = new Failure();

            private Failure() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: StoreSubscriptions.kt */
        public static final /* data */ class Loaded extends SubscriptionsState {
            private final List<ModelSubscription> subscriptions;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Loaded(List<ModelSubscription> list) {
                super(null);
                C12238m.checkNotNullParameter(list, "subscriptions");
                this.subscriptions = list;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Loaded copy$default(Loaded loaded, List list, int i, Object obj) {
                if ((i & 1) != 0) {
                    list = loaded.subscriptions;
                }
                return loaded.copy(list);
            }

            public final List<ModelSubscription> component1() {
                return this.subscriptions;
            }

            public final Loaded copy(List<ModelSubscription> subscriptions) {
                C12238m.checkNotNullParameter(subscriptions, "subscriptions");
                return new Loaded(subscriptions);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Loaded) && C12238m.areEqual(this.subscriptions, ((Loaded) other).subscriptions);
                }
                return true;
            }

            public final ModelSubscription getPremiumSubscription() {
                Object next;
                Iterator<T> it = this.subscriptions.iterator();
                while (it.hasNext()) {
                    next = it.next();
                    if (((ModelSubscription) next).getType() == ModelSubscription.Type.PREMIUM) {
                        return (ModelSubscription) next;
                    }
                }
                next = null;
                return (ModelSubscription) next;
            }

            public final List<ModelSubscription> getSubscriptions() {
                return this.subscriptions;
            }

            public int hashCode() {
                List<ModelSubscription> list = this.subscriptions;
                if (list != null) {
                    return list.hashCode();
                }
                return 0;
            }

            public String toString() {
                return C1643a.m824L(C1643a.m833U("Loaded(subscriptions="), this.subscriptions, ")");
            }
        }

        /* JADX INFO: compiled from: StoreSubscriptions.kt */
        public static final class Loading extends SubscriptionsState {
            public static final Loading INSTANCE = new Loading();

            private Loading() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: StoreSubscriptions.kt */
        public static final class Unfetched extends SubscriptionsState {
            public static final Unfetched INSTANCE = new Unfetched();

            private Unfetched() {
                super(null);
            }
        }

        private SubscriptionsState() {
        }

        public /* synthetic */ SubscriptionsState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreSubscriptions$fetchSubscriptions$1 */
    /* JADX INFO: compiled from: StoreSubscriptions.kt */
    public static final class C65241 extends AbstractC12240o implements Function0<Unit> {

        /* JADX INFO: renamed from: com.discord.stores.StoreSubscriptions$fetchSubscriptions$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: StoreSubscriptions.kt */
        public static final class AnonymousClass1 extends AbstractC12240o implements Function1<List<? extends ModelSubscription>, Unit> {

            /* JADX INFO: renamed from: com.discord.stores.StoreSubscriptions$fetchSubscriptions$1$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: StoreSubscriptions.kt */
            public static final class C132641 extends AbstractC12240o implements Function0<Unit> {
                public final /* synthetic */ List $subscriptions;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C132641(List list) {
                    super(0);
                    this.$subscriptions = list;
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.f27425a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    StoreSubscriptions.this.handleSubscriptionsFetchSuccess(this.$subscriptions);
                }
            }

            public AnonymousClass1() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends ModelSubscription> list) {
                invoke2((List<ModelSubscription>) list);
                return Unit.f27425a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<ModelSubscription> list) {
                C12238m.checkNotNullParameter(list, "subscriptions");
                StoreSubscriptions.this.dispatcher.schedule(new C132641(list));
            }
        }

        /* JADX INFO: renamed from: com.discord.stores.StoreSubscriptions$fetchSubscriptions$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: StoreSubscriptions.kt */
        public static final class AnonymousClass2 extends AbstractC12240o implements Function1<Error, Unit> {

            /* JADX INFO: renamed from: com.discord.stores.StoreSubscriptions$fetchSubscriptions$1$2$1, reason: invalid class name */
            /* JADX INFO: compiled from: StoreSubscriptions.kt */
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
                    StoreSubscriptions.this.handleSubscriptionsFetchFailure();
                }
            }

            public AnonymousClass2() {
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
                StoreSubscriptions.this.dispatcher.schedule(new AnonymousClass1());
            }
        }

        public C65241() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            if (StoreSubscriptions.this.subscriptionsState instanceof SubscriptionsState.Loading) {
                return;
            }
            StoreSubscriptions.this.handleSubscriptionsFetchStart();
            ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.restSubscribeOn$default(StoreSubscriptions.this.restAPI.getSubscriptions(), false, 1, null), (Class<?>) StoreSubscriptions.this.getClass(), (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new AnonymousClass2()), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new AnonymousClass1());
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreSubscriptions$observeSubscriptions$1 */
    /* JADX INFO: compiled from: StoreSubscriptions.kt */
    public static final class C65251 extends AbstractC12240o implements Function0<SubscriptionsState> {
        public C65251() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final SubscriptionsState invoke() {
            return StoreSubscriptions.this.getSubscriptionsStateSnapshot();
        }
    }

    public StoreSubscriptions(ObservationDeck observationDeck, Dispatcher dispatcher, RestAPI restAPI) {
        C12238m.checkNotNullParameter(observationDeck, "observationDeck");
        C12238m.checkNotNullParameter(dispatcher, "dispatcher");
        C12238m.checkNotNullParameter(restAPI, "restAPI");
        this.observationDeck = observationDeck;
        this.dispatcher = dispatcher;
        this.restAPI = restAPI;
        SubscriptionsState.Unfetched unfetched = SubscriptionsState.Unfetched.INSTANCE;
        this.subscriptionsState = unfetched;
        this.subscriptionsStateSnapshot = unfetched;
    }

    @StoreThread
    private final void handleSubscriptionsFetchFailure() {
        this.subscriptionsState = SubscriptionsState.Failure.INSTANCE;
        markChanged();
    }

    @StoreThread
    private final void handleSubscriptionsFetchStart() {
        this.subscriptionsState = SubscriptionsState.Loading.INSTANCE;
        markChanged();
    }

    @StoreThread
    private final void handleSubscriptionsFetchSuccess(List<ModelSubscription> subscriptions) {
        this.subscriptionsState = new SubscriptionsState.Loaded(subscriptions);
        markChanged();
    }

    public final void fetchSubscriptions() {
        this.dispatcher.schedule(new C65241());
    }

    /* JADX INFO: renamed from: getSubscriptions, reason: from getter */
    public final SubscriptionsState getSubscriptionsStateSnapshot() {
        return this.subscriptionsStateSnapshot;
    }

    @StoreThread
    public final void handlePreLogout() {
        this.subscriptionsState = SubscriptionsState.Unfetched.INSTANCE;
        markChanged();
    }

    @StoreThread
    public final void handleUserSubscriptionsUpdate() {
        fetchSubscriptions();
    }

    public final boolean hasFetchedSubscriptions() {
        return this.subscriptionsStateSnapshot instanceof SubscriptionsState.Loaded;
    }

    public final boolean isFetchingSubscriptions() {
        return this.subscriptionsStateSnapshot instanceof SubscriptionsState.Loading;
    }

    public final Observable<SubscriptionsState> observeSubscriptions() {
        Observable<SubscriptionsState> observableM11112r = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new C65251(), 14, null).m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r, "observationDeck.connectR…  .distinctUntilChanged()");
        return observableM11112r;
    }

    @Override // com.discord.stores.StoreV2
    public void snapshotData() {
        super.snapshotData();
        SubscriptionsState subscriptionsStateCopy = this.subscriptionsState;
        if (subscriptionsStateCopy instanceof SubscriptionsState.Loaded) {
            SubscriptionsState.Loaded loaded = (SubscriptionsState.Loaded) subscriptionsStateCopy;
            subscriptionsStateCopy = loaded.copy(new ArrayList(loaded.getSubscriptions()));
        } else if (!C12238m.areEqual(subscriptionsStateCopy, SubscriptionsState.Failure.INSTANCE) && !C12238m.areEqual(subscriptionsStateCopy, SubscriptionsState.Loading.INSTANCE) && !C12238m.areEqual(subscriptionsStateCopy, SubscriptionsState.Unfetched.INSTANCE)) {
            throw new NoWhenBranchMatchedException();
        }
        this.subscriptionsStateSnapshot = subscriptionsStateCopy;
    }
}
