package com.discord.stores;

import android.content.Context;
import com.discord.analytics.generated.events.network_action.TrackNetworkActionUserConnectionsUpdate;
import com.discord.analytics.generated.traits.TrackNetworkMetadataReceiver;
import com.discord.api.connectedaccounts.ConnectedAccount;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelPayload;
import com.discord.models.domain.ModelUrl;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeckProvider;
import com.discord.stores.utilities.RestCallStateKt;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.uri.UriHandler;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.function.UnaryOperator;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p580t.C12147n;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12227g;
import p507d0.p592z.p594d.C12238m;
import p507d0.p592z.p594d.p595g0.InterfaceC12228a;
import p658rx.Observable;
import p658rx.Subscription;

/* JADX INFO: compiled from: StoreUserConnections.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreUserConnections extends StoreV2 {
    private final Dispatcher dispatcher;
    private final ObservationDeck observationDeck;
    private State state;
    private State stateSnapshot;
    private final StoreStream stream;

    /* JADX INFO: compiled from: StoreUserConnections.kt */
    public static abstract class State implements List<ConnectedAccount>, InterfaceC12228a {
        private final List<ConnectedAccount> connectedAccounts;

        /* JADX INFO: compiled from: StoreUserConnections.kt */
        public static final /* data */ class ConnectedAccounts extends State {
            private final List<ConnectedAccount> connectedAccounts;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ConnectedAccounts(List<ConnectedAccount> list) {
                super(list, null);
                C12238m.checkNotNullParameter(list, "connectedAccounts");
                this.connectedAccounts = list;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ ConnectedAccounts copy$default(ConnectedAccounts connectedAccounts, List list, int i, Object obj) {
                if ((i & 1) != 0) {
                    list = connectedAccounts.getConnectedAccounts();
                }
                return connectedAccounts.copy(list);
            }

            public final List<ConnectedAccount> component1() {
                return getConnectedAccounts();
            }

            public final ConnectedAccounts copy(List<ConnectedAccount> connectedAccounts) {
                C12238m.checkNotNullParameter(connectedAccounts, "connectedAccounts");
                return new ConnectedAccounts(connectedAccounts);
            }

            @Override // java.util.List, java.util.Collection
            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof ConnectedAccounts) && C12238m.areEqual(getConnectedAccounts(), ((ConnectedAccounts) other).getConnectedAccounts());
                }
                return true;
            }

            @Override // com.discord.stores.StoreUserConnections.State
            public List<ConnectedAccount> getConnectedAccounts() {
                return this.connectedAccounts;
            }

            @Override // java.util.List, java.util.Collection
            public int hashCode() {
                List<ConnectedAccount> connectedAccounts = getConnectedAccounts();
                if (connectedAccounts != null) {
                    return connectedAccounts.hashCode();
                }
                return 0;
            }

            public String toString() {
                StringBuilder sbM833U = C1643a.m833U("ConnectedAccounts(connectedAccounts=");
                sbM833U.append(getConnectedAccounts());
                sbM833U.append(")");
                return sbM833U.toString();
            }
        }

        /* JADX INFO: compiled from: StoreUserConnections.kt */
        public static final class Loading extends State {
            public static final Loading INSTANCE = new Loading();

            private Loading() {
                super(C12147n.emptyList(), null);
            }
        }

        private State(List<ConnectedAccount> list) {
            this.connectedAccounts = list;
        }

        /* JADX INFO: renamed from: add, reason: avoid collision after fix types in other method */
        public void add2(int i, ConnectedAccount connectedAccount) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.List
        public /* synthetic */ void add(int i, ConnectedAccount connectedAccount) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public boolean add(ConnectedAccount connectedAccount) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.List, java.util.Collection
        public /* synthetic */ boolean add(Object obj) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.List
        public boolean addAll(int i, Collection<? extends ConnectedAccount> collection) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.List, java.util.Collection
        public boolean addAll(Collection<? extends ConnectedAccount> collection) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.List, java.util.Collection
        public void clear() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public boolean contains(ConnectedAccount element) {
            C12238m.checkNotNullParameter(element, "element");
            return this.connectedAccounts.contains(element);
        }

        @Override // java.util.List, java.util.Collection
        public final /* bridge */ boolean contains(Object obj) {
            if (obj instanceof ConnectedAccount) {
                return contains((ConnectedAccount) obj);
            }
            return false;
        }

        @Override // java.util.List, java.util.Collection
        public boolean containsAll(Collection<? extends Object> elements) {
            C12238m.checkNotNullParameter(elements, "elements");
            return this.connectedAccounts.containsAll(elements);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.List
        public ConnectedAccount get(int index) {
            ConnectedAccount connectedAccount = this.connectedAccounts.get(index);
            C12238m.checkNotNullExpressionValue(connectedAccount, "get(...)");
            return connectedAccount;
        }

        public List<ConnectedAccount> getConnectedAccounts() {
            return this.connectedAccounts;
        }

        public int getSize() {
            return this.connectedAccounts.size();
        }

        public int indexOf(ConnectedAccount element) {
            C12238m.checkNotNullParameter(element, "element");
            return this.connectedAccounts.indexOf(element);
        }

        @Override // java.util.List
        public final /* bridge */ int indexOf(Object obj) {
            if (obj instanceof ConnectedAccount) {
                return indexOf((ConnectedAccount) obj);
            }
            return -1;
        }

        @Override // java.util.List, java.util.Collection
        public boolean isEmpty() {
            return this.connectedAccounts.isEmpty();
        }

        @Override // java.util.List, java.util.Collection, java.lang.Iterable
        public Iterator<ConnectedAccount> iterator() {
            return this.connectedAccounts.iterator();
        }

        public int lastIndexOf(ConnectedAccount element) {
            C12238m.checkNotNullParameter(element, "element");
            return this.connectedAccounts.lastIndexOf(element);
        }

        @Override // java.util.List
        public final /* bridge */ int lastIndexOf(Object obj) {
            if (obj instanceof ConnectedAccount) {
                return lastIndexOf((ConnectedAccount) obj);
            }
            return -1;
        }

        @Override // java.util.List
        public ListIterator<ConnectedAccount> listIterator() {
            return this.connectedAccounts.listIterator();
        }

        @Override // java.util.List
        public ListIterator<ConnectedAccount> listIterator(int index) {
            return this.connectedAccounts.listIterator(index);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.List
        public ConnectedAccount remove(int i) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.List
        public /* synthetic */ ConnectedAccount remove(int i) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.List, java.util.Collection
        public boolean remove(Object obj) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.List, java.util.Collection
        public boolean removeAll(Collection<? extends Object> collection) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.List
        public void replaceAll(UnaryOperator<ConnectedAccount> unaryOperator) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.List, java.util.Collection
        public boolean retainAll(Collection<? extends Object> collection) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        /* JADX INFO: renamed from: set, reason: avoid collision after fix types in other method */
        public ConnectedAccount set2(int i, ConnectedAccount connectedAccount) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.List
        public /* synthetic */ ConnectedAccount set(int i, ConnectedAccount connectedAccount) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.List, java.util.Collection
        public final /* bridge */ int size() {
            return getSize();
        }

        @Override // java.util.List
        public void sort(Comparator<? super ConnectedAccount> comparator) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.List
        public List<ConnectedAccount> subList(int fromIndex, int toIndex) {
            return this.connectedAccounts.subList(fromIndex, toIndex);
        }

        @Override // java.util.List, java.util.Collection
        public Object[] toArray() {
            return C12227g.toArray(this);
        }

        @Override // java.util.List, java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            return (T[]) C12227g.toArray(this, tArr);
        }

        public /* synthetic */ State(List list, DefaultConstructorMarker defaultConstructorMarker) {
            this(list);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreUserConnections$authorizeConnection$1 */
    /* JADX INFO: compiled from: StoreUserConnections.kt */
    public static final class C65611 extends AbstractC12240o implements Function1<ModelUrl, Unit> {
        public final /* synthetic */ Context $context;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C65611(Context context) {
            super(1);
            this.$context = context;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ModelUrl modelUrl) {
            invoke2(modelUrl);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ModelUrl modelUrl) {
            C12238m.checkNotNullParameter(modelUrl, "response");
            UriHandler.handle$default(UriHandler.INSTANCE, this.$context, modelUrl.getUrl(), false, false, null, 28, null);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreUserConnections$deleteUserConnection$1 */
    /* JADX INFO: compiled from: StoreUserConnections.kt */
    public static final class C65621 extends AbstractC12240o implements Function1<Void, TrackNetworkMetadataReceiver> {
        public static final C65621 INSTANCE = new C65621();

        public C65621() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final TrackNetworkMetadataReceiver invoke(Void r7) {
            return new TrackNetworkActionUserConnectionsUpdate(null, null, null, null, 15);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreUserConnections$deleteUserConnection$2 */
    /* JADX INFO: compiled from: StoreUserConnections.kt */
    public static final class C65632 extends AbstractC12240o implements Function1<Void, Unit> {
        public C65632() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
            invoke2(r1);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Void r1) {
            StoreUserConnections.this.fetchConnectedAccounts();
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreUserConnections$fetchConnectedAccounts$1 */
    /* JADX INFO: compiled from: StoreUserConnections.kt */
    public static final class C65641 extends AbstractC12240o implements Function1<List<? extends ConnectedAccount>, Unit> {

        /* JADX INFO: renamed from: com.discord.stores.StoreUserConnections$fetchConnectedAccounts$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: StoreUserConnections.kt */
        public static final class AnonymousClass1 extends AbstractC12240o implements Function0<Unit> {
            public final /* synthetic */ List $connectedAccounts;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(List list) {
                super(0);
                this.$connectedAccounts = list;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f27425a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                StoreUserConnections.this.getStream().handleUserConnections(this.$connectedAccounts);
            }
        }

        public C65641() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends ConnectedAccount> list) {
            invoke2((List<ConnectedAccount>) list);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<ConnectedAccount> list) {
            C12238m.checkNotNullParameter(list, "connectedAccounts");
            StoreUserConnections.this.getDispatcher().schedule(new AnonymousClass1(list));
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreUserConnections$init$1 */
    /* JADX INFO: compiled from: StoreUserConnections.kt */
    public static final class C65651 extends AbstractC12240o implements Function1<Unit, Unit> {
        public C65651() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Unit unit) {
            invoke2(unit);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Unit unit) {
            StoreUserConnections.this.fetchConnectedAccounts();
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreUserConnections$observeConnectedAccounts$1 */
    /* JADX INFO: compiled from: StoreUserConnections.kt */
    public static final class C65661 extends AbstractC12240o implements Function0<State> {
        public C65661() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final State invoke() {
            return StoreUserConnections.this.getStateSnapshot();
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreUserConnections$updateUserConnection$1 */
    /* JADX INFO: compiled from: StoreUserConnections.kt */
    public static final class C65671 extends AbstractC12240o implements Function1<ConnectedAccount, TrackNetworkMetadataReceiver> {
        public final /* synthetic */ ConnectedAccount $connectedAccount;
        public final /* synthetic */ boolean $syncFriends;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C65671(ConnectedAccount connectedAccount, boolean z2) {
            super(1);
            this.$connectedAccount = connectedAccount;
            this.$syncFriends = z2;
        }

        @Override // kotlin.jvm.functions.Function1
        public final TrackNetworkMetadataReceiver invoke(ConnectedAccount connectedAccount) {
            return new TrackNetworkActionUserConnectionsUpdate(this.$connectedAccount.getName(), Boolean.valueOf(this.$syncFriends), null, null, 12);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreUserConnections$updateUserConnection$2 */
    /* JADX INFO: compiled from: StoreUserConnections.kt */
    public static final class C65682 extends AbstractC12240o implements Function1<ConnectedAccount, Unit> {
        public C65682() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ConnectedAccount connectedAccount) {
            invoke2(connectedAccount);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ConnectedAccount connectedAccount) {
            C12238m.checkNotNullParameter(connectedAccount, "it");
            StoreUserConnections.this.fetchConnectedAccounts();
        }
    }

    public /* synthetic */ StoreUserConnections(StoreStream storeStream, Dispatcher dispatcher, ObservationDeck observationDeck, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(storeStream, dispatcher, (i & 4) != 0 ? ObservationDeckProvider.get() : observationDeck);
    }

    public final void authorizeConnection(String platformName, Context context, String location) {
        C12238m.checkNotNullParameter(platformName, "platformName");
        C12238m.checkNotNullParameter(context, "context");
        C12238m.checkNotNullParameter(location, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        AnalyticsTracker.INSTANCE.trackConnectedAccountInitiated(platformName, location);
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().authorizeConnection(platformName), false, 1, null), (Class<?>) StoreUserConnections.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C65611(context));
    }

    public final void deleteUserConnection(String platformName, String connectionId) {
        C12238m.checkNotNullParameter(platformName, "platformName");
        C12238m.checkNotNullParameter(connectionId, "connectionId");
        ObservableExtensionsKt.appSubscribe(RestCallStateKt.logNetworkAction(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().deleteConnection(platformName, connectionId), false, 1, null), C65621.INSTANCE), (Class<?>) StoreUserConnections.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C65632());
    }

    public final void fetchConnectedAccounts() {
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().getConnections(), false, 1, null), (Class<?>) StoreUserConnections.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C65641());
    }

    /* JADX INFO: renamed from: getConnectedAccounts, reason: from getter */
    public final State getStateSnapshot() {
        return this.stateSnapshot;
    }

    public final Dispatcher getDispatcher() {
        return this.dispatcher;
    }

    public final StoreStream getStream() {
        return this.stream;
    }

    @StoreThread
    public final void handleConnectionOpen(ModelPayload payload) {
        C12238m.checkNotNullParameter(payload, "payload");
        List<ConnectedAccount> connectedAccounts = payload.getConnectedAccounts();
        C12238m.checkNotNullExpressionValue(connectedAccounts, "payload.connectedAccounts");
        handleUserConnections(connectedAccounts);
    }

    @StoreThread
    public final void handleUserConnections(List<ConnectedAccount> accounts) {
        C12238m.checkNotNullParameter(accounts, "accounts");
        this.state = new State.ConnectedAccounts(accounts);
        markChanged();
    }

    @Override // com.discord.stores.Store
    public void init(Context context) {
        C12238m.checkNotNullParameter(context, "context");
        super.init(context);
        ObservableExtensionsKt.appSubscribe(this.stream.getGatewaySocket().getUserConnectionUpdate(), (Class<?>) StoreUserConnections.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C65651());
    }

    public final Observable<State> observeConnectedAccounts() {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new C65661(), 14, null);
    }

    @Override // com.discord.stores.StoreV2
    @StoreThread
    public void snapshotData() {
        super.snapshotData();
        State state = this.state;
        State connectedAccounts = State.Loading.INSTANCE;
        if (!C12238m.areEqual(state, connectedAccounts)) {
            if (!(state instanceof State.ConnectedAccounts)) {
                throw new NoWhenBranchMatchedException();
            }
            connectedAccounts = new State.ConnectedAccounts(new ArrayList(state.getConnectedAccounts()));
        }
        this.stateSnapshot = connectedAccounts;
    }

    public final void updateUserConnection(ConnectedAccount connectedAccount, boolean syncFriends, boolean showActivity, boolean isVisible) {
        C12238m.checkNotNullParameter(connectedAccount, "connectedAccount");
        ObservableExtensionsKt.appSubscribe(RestCallStateKt.logNetworkAction(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().updateConnection(connectedAccount.getType(), connectedAccount.getId(), RestAPIParams.ConnectedAccount.INSTANCE.create(connectedAccount, syncFriends, showActivity, isVisible ? 1 : 0)), false, 1, null), new C65671(connectedAccount, syncFriends)), (Class<?>) StoreUserConnections.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C65682());
    }

    public StoreUserConnections(StoreStream storeStream, Dispatcher dispatcher, ObservationDeck observationDeck) {
        C12238m.checkNotNullParameter(storeStream, "stream");
        C12238m.checkNotNullParameter(dispatcher, "dispatcher");
        C12238m.checkNotNullParameter(observationDeck, "observationDeck");
        this.stream = storeStream;
        this.dispatcher = dispatcher;
        this.observationDeck = observationDeck;
        State.Loading loading = State.Loading.INSTANCE;
        this.state = loading;
        this.stateSnapshot = loading;
    }
}
