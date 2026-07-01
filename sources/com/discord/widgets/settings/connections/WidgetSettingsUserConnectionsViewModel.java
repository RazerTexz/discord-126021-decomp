package com.discord.widgets.settings.connections;

import b.a.d.AppViewModel;
import b.d.b.a.outline;
import com.discord.api.connectedaccounts.ConnectedAccount;
import com.discord.api.connectedaccounts.ConnectedAccountIntegration;
import com.discord.api.connectedaccounts.ConnectedIntegrationGuild;
import com.discord.models.guild.Guild;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUserConnections;
import com.discord.utilities.error.Error;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.settings.connections.WidgetSettingsUserConnectionsViewModel;
import d0.t.Maps6;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.Subscription;
import rx.functions.Func2;
import rx.subjects.BehaviorSubject;

/* JADX INFO: compiled from: WidgetSettingsUserConnectionsViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsUserConnectionsViewModel extends AppViewModel<ViewState> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final BehaviorSubject<Map<String, JoinStatus>> joinStateSubject;
    private final Map<String, JoinStatus> joinStatusMap;
    private final RestAPI restApi;

    /* JADX INFO: renamed from: com.discord.widgets.settings.connections.WidgetSettingsUserConnectionsViewModel$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetSettingsUserConnectionsViewModel.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<List<? extends ConnectionState>, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends ConnectionState> list) {
            invoke2((List<ConnectionState>) list);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<ConnectionState> list) {
            WidgetSettingsUserConnectionsViewModel widgetSettingsUserConnectionsViewModel = WidgetSettingsUserConnectionsViewModel.this;
            Intrinsics3.checkNotNullExpressionValue(list, "storeState");
            widgetSettingsUserConnectionsViewModel.handleConnectionsState(list);
        }
    }

    /* JADX INFO: compiled from: WidgetSettingsUserConnectionsViewModel.kt */
    public static final class Companion {
        private Companion() {
        }

        private final Observable<StoreState> observeStores() {
            StoreStream.Companion companion = StoreStream.INSTANCE;
            Observable<StoreState> observableJ = Observable.j(companion.getUserConnections().observeConnectedAccounts(), companion.getGuilds().observeGuilds(), new Func2<StoreUserConnections.State, Map<Long, ? extends Guild>, StoreState>() { // from class: com.discord.widgets.settings.connections.WidgetSettingsUserConnectionsViewModel$Companion$observeStores$1
                @Override // rx.functions.Func2
                public /* bridge */ /* synthetic */ WidgetSettingsUserConnectionsViewModel.StoreState call(StoreUserConnections.State state, Map<Long, ? extends Guild> map) {
                    return call2(state, (Map<Long, Guild>) map);
                }

                /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
                public final WidgetSettingsUserConnectionsViewModel.StoreState call2(StoreUserConnections.State state, Map<Long, Guild> map) {
                    Intrinsics3.checkNotNullExpressionValue(state, "accounts");
                    ArrayList arrayList = new ArrayList();
                    for (ConnectedAccount connectedAccount : state) {
                        if (!Intrinsics3.areEqual(connectedAccount.getType(), "contacts")) {
                            arrayList.add(connectedAccount);
                        }
                    }
                    Intrinsics3.checkNotNullExpressionValue(map, "guilds");
                    return new WidgetSettingsUserConnectionsViewModel.StoreState(arrayList, map);
                }
            });
            Intrinsics3.checkNotNullExpressionValue(observableJ, "Observable.combineLatest…= \"contacts\" }, guilds) }");
            return observableJ;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: WidgetSettingsUserConnectionsViewModel.kt */
    public static final /* data */ class ConnectionState {
        private final ConnectedAccount connection;
        private final Map<String, JoinStatus> integrationGuildJoinStatus;

        /* JADX WARN: Multi-variable type inference failed */
        public ConnectionState(ConnectedAccount connectedAccount, Map<String, ? extends JoinStatus> map) {
            Intrinsics3.checkNotNullParameter(connectedAccount, "connection");
            Intrinsics3.checkNotNullParameter(map, "integrationGuildJoinStatus");
            this.connection = connectedAccount;
            this.integrationGuildJoinStatus = map;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ConnectionState copy$default(ConnectionState connectionState, ConnectedAccount connectedAccount, Map map, int i, Object obj) {
            if ((i & 1) != 0) {
                connectedAccount = connectionState.connection;
            }
            if ((i & 2) != 0) {
                map = connectionState.integrationGuildJoinStatus;
            }
            return connectionState.copy(connectedAccount, map);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final ConnectedAccount getConnection() {
            return this.connection;
        }

        public final Map<String, JoinStatus> component2() {
            return this.integrationGuildJoinStatus;
        }

        public final ConnectionState copy(ConnectedAccount connection, Map<String, ? extends JoinStatus> integrationGuildJoinStatus) {
            Intrinsics3.checkNotNullParameter(connection, "connection");
            Intrinsics3.checkNotNullParameter(integrationGuildJoinStatus, "integrationGuildJoinStatus");
            return new ConnectionState(connection, integrationGuildJoinStatus);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ConnectionState)) {
                return false;
            }
            ConnectionState connectionState = (ConnectionState) other;
            return Intrinsics3.areEqual(this.connection, connectionState.connection) && Intrinsics3.areEqual(this.integrationGuildJoinStatus, connectionState.integrationGuildJoinStatus);
        }

        public final ConnectedAccount getConnection() {
            return this.connection;
        }

        public final Map<String, JoinStatus> getIntegrationGuildJoinStatus() {
            return this.integrationGuildJoinStatus;
        }

        public int hashCode() {
            ConnectedAccount connectedAccount = this.connection;
            int iHashCode = (connectedAccount != null ? connectedAccount.hashCode() : 0) * 31;
            Map<String, JoinStatus> map = this.integrationGuildJoinStatus;
            return iHashCode + (map != null ? map.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("ConnectionState(connection=");
            sbU.append(this.connection);
            sbU.append(", integrationGuildJoinStatus=");
            return outline.M(sbU, this.integrationGuildJoinStatus, ")");
        }
    }

    /* JADX INFO: compiled from: WidgetSettingsUserConnectionsViewModel.kt */
    public static abstract class JoinStatus {

        /* JADX INFO: compiled from: WidgetSettingsUserConnectionsViewModel.kt */
        public static final class JoinFailed extends JoinStatus {
            public static final JoinFailed INSTANCE = new JoinFailed();

            private JoinFailed() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: WidgetSettingsUserConnectionsViewModel.kt */
        public static final class Joined extends JoinStatus {
            public static final Joined INSTANCE = new Joined();

            private Joined() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: WidgetSettingsUserConnectionsViewModel.kt */
        public static final class Joining extends JoinStatus {
            public static final Joining INSTANCE = new Joining();

            private Joining() {
                super(null);
            }
        }

        private JoinStatus() {
        }

        public /* synthetic */ JoinStatus(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: WidgetSettingsUserConnectionsViewModel.kt */
    public static final /* data */ class StoreState {
        private final List<ConnectedAccount> connectedAccounts;
        private final Map<Long, Guild> guilds;

        public StoreState(List<ConnectedAccount> list, Map<Long, Guild> map) {
            Intrinsics3.checkNotNullParameter(list, "connectedAccounts");
            Intrinsics3.checkNotNullParameter(map, "guilds");
            this.connectedAccounts = list;
            this.guilds = map;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ StoreState copy$default(StoreState storeState, List list, Map map, int i, Object obj) {
            if ((i & 1) != 0) {
                list = storeState.connectedAccounts;
            }
            if ((i & 2) != 0) {
                map = storeState.guilds;
            }
            return storeState.copy(list, map);
        }

        public final List<ConnectedAccount> component1() {
            return this.connectedAccounts;
        }

        public final Map<Long, Guild> component2() {
            return this.guilds;
        }

        public final StoreState copy(List<ConnectedAccount> connectedAccounts, Map<Long, Guild> guilds) {
            Intrinsics3.checkNotNullParameter(connectedAccounts, "connectedAccounts");
            Intrinsics3.checkNotNullParameter(guilds, "guilds");
            return new StoreState(connectedAccounts, guilds);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StoreState)) {
                return false;
            }
            StoreState storeState = (StoreState) other;
            return Intrinsics3.areEqual(this.connectedAccounts, storeState.connectedAccounts) && Intrinsics3.areEqual(this.guilds, storeState.guilds);
        }

        public final List<ConnectedAccount> getConnectedAccounts() {
            return this.connectedAccounts;
        }

        public final Map<Long, Guild> getGuilds() {
            return this.guilds;
        }

        public int hashCode() {
            List<ConnectedAccount> list = this.connectedAccounts;
            int iHashCode = (list != null ? list.hashCode() : 0) * 31;
            Map<Long, Guild> map = this.guilds;
            return iHashCode + (map != null ? map.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("StoreState(connectedAccounts=");
            sbU.append(this.connectedAccounts);
            sbU.append(", guilds=");
            return outline.M(sbU, this.guilds, ")");
        }
    }

    /* JADX INFO: compiled from: WidgetSettingsUserConnectionsViewModel.kt */
    public static abstract class ViewState {

        /* JADX INFO: compiled from: WidgetSettingsUserConnectionsViewModel.kt */
        public static final class Empty extends ViewState {
            public static final Empty INSTANCE = new Empty();

            private Empty() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: WidgetSettingsUserConnectionsViewModel.kt */
        public static final /* data */ class Loaded extends ViewState {
            private final List<ConnectionState> data;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Loaded(List<ConnectionState> list) {
                super(null);
                Intrinsics3.checkNotNullParameter(list, "data");
                this.data = list;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Loaded copy$default(Loaded loaded, List list, int i, Object obj) {
                if ((i & 1) != 0) {
                    list = loaded.data;
                }
                return loaded.copy(list);
            }

            public final List<ConnectionState> component1() {
                return this.data;
            }

            public final Loaded copy(List<ConnectionState> data) {
                Intrinsics3.checkNotNullParameter(data, "data");
                return new Loaded(data);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Loaded) && Intrinsics3.areEqual(this.data, ((Loaded) other).data);
                }
                return true;
            }

            public final List<ConnectionState> getData() {
                return this.data;
            }

            public int hashCode() {
                List<ConnectionState> list = this.data;
                if (list != null) {
                    return list.hashCode();
                }
                return 0;
            }

            public String toString() {
                return outline.L(outline.U("Loaded(data="), this.data, ")");
            }
        }

        /* JADX INFO: compiled from: WidgetSettingsUserConnectionsViewModel.kt */
        public static final class Uninitialized extends ViewState {
            public static final Uninitialized INSTANCE = new Uninitialized();

            private Uninitialized() {
                super(null);
            }
        }

        private ViewState() {
        }

        public /* synthetic */ ViewState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.connections.WidgetSettingsUserConnectionsViewModel$joinConnectionIntegrationGuild$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetSettingsUserConnectionsViewModel.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<Error, Unit> {
        public final /* synthetic */ String $integrationId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(String str) {
            super(1);
            this.$integrationId = str;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "it");
            WidgetSettingsUserConnectionsViewModel.this.joinStatusMap.put(this.$integrationId, JoinStatus.JoinFailed.INSTANCE);
            WidgetSettingsUserConnectionsViewModel.this.joinStateSubject.onNext(WidgetSettingsUserConnectionsViewModel.this.joinStatusMap);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.connections.WidgetSettingsUserConnectionsViewModel$joinConnectionIntegrationGuild$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetSettingsUserConnectionsViewModel.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<Void, Unit> {
        public final /* synthetic */ String $integrationId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(String str) {
            super(1);
            this.$integrationId = str;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
            invoke2(r1);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Void r3) {
            WidgetSettingsUserConnectionsViewModel.this.joinStatusMap.put(this.$integrationId, JoinStatus.Joined.INSTANCE);
            WidgetSettingsUserConnectionsViewModel.this.joinStateSubject.onNext(WidgetSettingsUserConnectionsViewModel.this.joinStatusMap);
        }
    }

    public WidgetSettingsUserConnectionsViewModel() {
        this(null, null, null, 7, null);
    }

    public /* synthetic */ WidgetSettingsUserConnectionsViewModel(Observable observable, StoreUserConnections storeUserConnections, RestAPI restAPI, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? INSTANCE.observeStores() : observable, (i & 2) != 0 ? StoreStream.INSTANCE.getUserConnections() : storeUserConnections, (i & 4) != 0 ? RestAPI.INSTANCE.getApi() : restAPI);
    }

    private final List<ConnectionState> combineState(StoreState storeState, Map<String, ? extends JoinStatus> joinMap) {
        ArrayList arrayList = new ArrayList();
        for (ConnectedAccount connectedAccount : storeState.getConnectedAccounts()) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            List<ConnectedAccountIntegration> listC = connectedAccount.c();
            if (listC != null) {
                for (ConnectedAccountIntegration connectedAccountIntegration : listC) {
                    ConnectedIntegrationGuild guild = connectedAccountIntegration.getGuild();
                    if (guild != null) {
                        if (storeState.getGuilds().containsKey(Long.valueOf(guild.getId()))) {
                            linkedHashMap.put(connectedAccountIntegration.getId(), JoinStatus.Joined.INSTANCE);
                        }
                        JoinStatus joinStatus = joinMap.get(connectedAccountIntegration.getId());
                        if (joinStatus != null) {
                            linkedHashMap.put(connectedAccountIntegration.getId(), joinStatus);
                        }
                    }
                }
            }
            arrayList.add(new ConnectionState(connectedAccount, linkedHashMap));
        }
        return arrayList;
    }

    private final void handleConnectionsState(List<ConnectionState> state) {
        if (state == null || state.isEmpty()) {
            updateViewState(ViewState.Empty.INSTANCE);
        } else {
            updateViewState(new ViewState.Loaded(state));
        }
    }

    public final void joinConnectionIntegrationGuild(String integrationId) {
        Intrinsics3.checkNotNullParameter(integrationId, "integrationId");
        this.joinStatusMap.put(integrationId, JoinStatus.Joining.INSTANCE);
        this.joinStateSubject.onNext(this.joinStatusMap);
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.restSubscribeOn$default(this.restApi.joinGuildFromIntegration(integrationId), false, 1, null), (Class<?>) WidgetSettingsUserConnectionsViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new AnonymousClass1(integrationId)), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass2(integrationId));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetSettingsUserConnectionsViewModel(Observable<StoreState> observable, StoreUserConnections storeUserConnections, RestAPI restAPI) {
        super(ViewState.Uninitialized.INSTANCE);
        Intrinsics3.checkNotNullParameter(observable, "storeStateObservable");
        Intrinsics3.checkNotNullParameter(storeUserConnections, "storeUserConnections");
        Intrinsics3.checkNotNullParameter(restAPI, "restApi");
        this.restApi = restAPI;
        this.joinStatusMap = new LinkedHashMap();
        BehaviorSubject<Map<String, JoinStatus>> behaviorSubjectL0 = BehaviorSubject.l0(Maps6.emptyMap());
        this.joinStateSubject = behaviorSubjectL0;
        storeUserConnections.fetchConnectedAccounts();
        Observable observableJ = Observable.j(observable, behaviorSubjectL0, new Func2<StoreState, Map<String, ? extends JoinStatus>, List<? extends ConnectionState>>() { // from class: com.discord.widgets.settings.connections.WidgetSettingsUserConnectionsViewModel.1
            @Override // rx.functions.Func2
            public final List<ConnectionState> call(StoreState storeState, Map<String, ? extends JoinStatus> map) {
                WidgetSettingsUserConnectionsViewModel widgetSettingsUserConnectionsViewModel = WidgetSettingsUserConnectionsViewModel.this;
                Intrinsics3.checkNotNullExpressionValue(storeState, "storeState");
                Intrinsics3.checkNotNullExpressionValue(map, "joinMap");
                return widgetSettingsUserConnectionsViewModel.combineState(storeState, map);
            }
        });
        Intrinsics3.checkNotNullExpressionValue(observableJ, "Observable.combineLatest…te(storeState, joinMap) }");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observableJ), this, null, 2, null), (Class<?>) WidgetSettingsUserConnectionsViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass2());
    }
}
