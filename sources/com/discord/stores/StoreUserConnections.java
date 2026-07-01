package com.discord.stores;

import android.content.Context;
import com.discord.api.connectedaccounts.ConnectedAccount;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelPayload;
import com.discord.restapi.RestAPIParams$ConnectedAccount;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck$UpdateSource;
import com.discord.stores.updates.ObservationDeckProvider;
import com.discord.stores.utilities.RestCallStateKt;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: StoreUserConnections.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreUserConnections extends StoreV2 {
    private final Dispatcher dispatcher;
    private final ObservationDeck observationDeck;
    private StoreUserConnections$State state;
    private StoreUserConnections$State stateSnapshot;
    private final StoreStream stream;

    public /* synthetic */ StoreUserConnections(StoreStream storeStream, Dispatcher dispatcher, ObservationDeck observationDeck, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(storeStream, dispatcher, (i & 4) != 0 ? ObservationDeckProvider.get() : observationDeck);
    }

    public final void authorizeConnection(String platformName, Context context, String location) {
        m.checkNotNullParameter(platformName, "platformName");
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(location, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        AnalyticsTracker.INSTANCE.trackConnectedAccountInitiated(platformName, location);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.Companion.getApi().authorizeConnection(platformName), false, 1, null), StoreUserConnections.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new StoreUserConnections$authorizeConnection$1(context), 62, (Object) null);
    }

    public final void deleteUserConnection(String platformName, String connectionId) {
        m.checkNotNullParameter(platformName, "platformName");
        m.checkNotNullParameter(connectionId, "connectionId");
        ObservableExtensionsKt.appSubscribe$default(RestCallStateKt.logNetworkAction(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.Companion.getApi().deleteConnection(platformName, connectionId), false, 1, null), StoreUserConnections$deleteUserConnection$1.INSTANCE), StoreUserConnections.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new StoreUserConnections$deleteUserConnection$2(this), 62, (Object) null);
    }

    public final void fetchConnectedAccounts() {
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.Companion.getApi().getConnections(), false, 1, null), StoreUserConnections.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new StoreUserConnections$fetchConnectedAccounts$1(this), 62, (Object) null);
    }

    /* JADX INFO: renamed from: getConnectedAccounts, reason: from getter */
    public final StoreUserConnections$State getStateSnapshot() {
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
        m.checkNotNullParameter(payload, "payload");
        List<ConnectedAccount> connectedAccounts = payload.getConnectedAccounts();
        m.checkNotNullExpressionValue(connectedAccounts, "payload.connectedAccounts");
        handleUserConnections(connectedAccounts);
    }

    @StoreThread
    public final void handleUserConnections(List<ConnectedAccount> accounts) {
        m.checkNotNullParameter(accounts, "accounts");
        this.state = new StoreUserConnections$State$ConnectedAccounts(accounts);
        markChanged();
    }

    @Override // com.discord.stores.Store
    public void init(Context context) {
        m.checkNotNullParameter(context, "context");
        super.init(context);
        ObservableExtensionsKt.appSubscribe$default(this.stream.getGatewaySocket().getUserConnectionUpdate(), StoreUserConnections.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new StoreUserConnections$init$1(this), 62, (Object) null);
    }

    public final Observable<StoreUserConnections$State> observeConnectedAccounts() {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck$UpdateSource[]{this}, false, null, null, new StoreUserConnections$observeConnectedAccounts$1(this), 14, null);
    }

    @Override // com.discord.stores.StoreV2
    @StoreThread
    public void snapshotData() {
        super.snapshotData();
        StoreUserConnections$State storeUserConnections$State = this.state;
        StoreUserConnections$State storeUserConnections$State$ConnectedAccounts = StoreUserConnections$State$Loading.INSTANCE;
        if (!m.areEqual(storeUserConnections$State, storeUserConnections$State$ConnectedAccounts)) {
            if (!(storeUserConnections$State instanceof StoreUserConnections$State$ConnectedAccounts)) {
                throw new NoWhenBranchMatchedException();
            }
            storeUserConnections$State$ConnectedAccounts = new StoreUserConnections$State$ConnectedAccounts(new ArrayList(storeUserConnections$State.getConnectedAccounts()));
        }
        this.stateSnapshot = storeUserConnections$State$ConnectedAccounts;
    }

    public final void updateUserConnection(ConnectedAccount connectedAccount, boolean syncFriends, boolean showActivity, boolean isVisible) {
        m.checkNotNullParameter(connectedAccount, "connectedAccount");
        ObservableExtensionsKt.appSubscribe$default(RestCallStateKt.logNetworkAction(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.Companion.getApi().updateConnection(connectedAccount.getType(), connectedAccount.getId(), RestAPIParams$ConnectedAccount.Companion.create(connectedAccount, syncFriends, showActivity, isVisible ? 1 : 0)), false, 1, null), new StoreUserConnections$updateUserConnection$1(connectedAccount, syncFriends)), StoreUserConnections.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new StoreUserConnections$updateUserConnection$2(this), 62, (Object) null);
    }

    public StoreUserConnections(StoreStream storeStream, Dispatcher dispatcher, ObservationDeck observationDeck) {
        m.checkNotNullParameter(storeStream, "stream");
        m.checkNotNullParameter(dispatcher, "dispatcher");
        m.checkNotNullParameter(observationDeck, "observationDeck");
        this.stream = storeStream;
        this.dispatcher = dispatcher;
        this.observationDeck = observationDeck;
        StoreUserConnections$State$Loading storeUserConnections$State$Loading = StoreUserConnections$State$Loading.INSTANCE;
        this.state = storeUserConnections$State$Loading;
        this.stateSnapshot = storeUserConnections$State$Loading;
    }
}
