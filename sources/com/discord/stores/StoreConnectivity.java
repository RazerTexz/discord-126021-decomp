package com.discord.stores;

import android.content.Context;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck$UpdateSource;
import com.discord.stores.updates.ObservationDeckProvider;
import com.discord.utilities.networking.NetworkMonitor;
import com.discord.utilities.networking.NetworkMonitor$State;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.time.Clock;
import d0.a0.a;
import d0.d0.f;
import d0.z.d.a0;
import d0.z.d.m;
import d0.z.d.s;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;
import rx.Observable;

/* JADX INFO: compiled from: StoreConnectivity.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreConnectivity extends StoreV2 {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a0.mutableProperty1(new s(StoreConnectivity.class, "state", "getState()Lcom/discord/stores/StoreConnectivity$DelayedState;", 0))};
    private static final StoreConnectivity$Companion Companion = new StoreConnectivity$Companion(null);

    @Deprecated
    public static final long DELAY_EXTENDED = 10000;

    @Deprecated
    public static final long DELAY_INTERVAL = 100;

    @Deprecated
    public static final long DELAY_NOMINAL = 1000;
    private boolean channelMessagesLoading;
    private final Clock clock;
    private NetworkMonitor$State deviceNetworkState;
    private final Dispatcher dispatcher;
    private boolean isReadyPayloadReceived;

    /* JADX INFO: renamed from: state$delegate, reason: from kotlin metadata */
    private final StoreV2$MarkChangedDelegate state;
    private long stateTriggeredDelay;
    private Long stateTriggeredTimeMillis;
    private final StoreStream stream;

    public StoreConnectivity(StoreStream storeStream, Dispatcher dispatcher, Clock clock) {
        m.checkNotNullParameter(storeStream, "stream");
        m.checkNotNullParameter(dispatcher, "dispatcher");
        m.checkNotNullParameter(clock, "clock");
        this.stream = storeStream;
        this.dispatcher = dispatcher;
        this.clock = clock;
        this.state = new StoreV2$MarkChangedDelegate(new StoreConnectivity$DelayedState(StoreConnectivity$State.CONNECTING, 10000L), null, 2, null);
        this.stateTriggeredDelay = 10000L;
        this.deviceNetworkState = NetworkMonitor$State.OFFLINE;
    }

    public static final /* synthetic */ StoreConnectivity$Companion access$Companion() {
        return Companion;
    }

    public static final /* synthetic */ boolean access$getChannelMessagesLoading$p(StoreConnectivity storeConnectivity) {
        return storeConnectivity.channelMessagesLoading;
    }

    public static final /* synthetic */ NetworkMonitor$State access$getDeviceNetworkState$p(StoreConnectivity storeConnectivity) {
        return storeConnectivity.deviceNetworkState;
    }

    public static final /* synthetic */ StoreConnectivity$DelayedState access$getState$p(StoreConnectivity storeConnectivity) {
        return storeConnectivity.getState();
    }

    public static final /* synthetic */ void access$handleChannelMessagesLoading(StoreConnectivity storeConnectivity, boolean z2) {
        storeConnectivity.handleChannelMessagesLoading(z2);
    }

    public static final /* synthetic */ void access$handleDeviceNetworkStateUpdated(StoreConnectivity storeConnectivity, NetworkMonitor$State networkMonitor$State) {
        storeConnectivity.handleDeviceNetworkStateUpdated(networkMonitor$State);
    }

    public static final /* synthetic */ void access$setChannelMessagesLoading$p(StoreConnectivity storeConnectivity, boolean z2) {
        storeConnectivity.channelMessagesLoading = z2;
    }

    public static final /* synthetic */ void access$setDeviceNetworkState$p(StoreConnectivity storeConnectivity, NetworkMonitor$State networkMonitor$State) {
        storeConnectivity.deviceNetworkState = networkMonitor$State;
    }

    public static final /* synthetic */ void access$setState$p(StoreConnectivity storeConnectivity, StoreConnectivity$DelayedState storeConnectivity$DelayedState) {
        storeConnectivity.setState(storeConnectivity$DelayedState);
    }

    public static final /* synthetic */ void access$updateConnectivityState(StoreConnectivity storeConnectivity) {
        storeConnectivity.updateConnectivityState();
    }

    private final long getNextStateDelayInitial(StoreConnectivity$DelayedState state, StoreConnectivity$State nextState) {
        int iOrdinal = nextState.ordinal();
        if (iOrdinal == 0) {
            return 1000L;
        }
        boolean z2 = true;
        if (iOrdinal == 1 || iOrdinal == 2) {
            return 1000L;
        }
        if (iOrdinal != 3) {
            throw new NoWhenBranchMatchedException();
        }
        StoreConnectivity$State state2 = state.getState();
        if (state2 != StoreConnectivity$State.OFFLINE && state2 != StoreConnectivity$State.OFFLINE_AIRPLANE_MODE) {
            z2 = false;
        }
        return (!z2 || getStateActiveMillis() <= 1000) ? 10000L : 1000L;
    }

    private final StoreConnectivity$DelayedState getState() {
        return (StoreConnectivity$DelayedState) this.state.getValue(this, $$delegatedProperties[0]);
    }

    private final long getStateActiveMillis() {
        Long l = this.stateTriggeredTimeMillis;
        if (l == null) {
            return 0L;
        }
        return this.clock.currentTimeMillis() - l.longValue();
    }

    private final long getStateDelay(long defaultDelay) {
        return f.coerceAtLeast(((long) a.roundToInt((defaultDelay - getStateActiveMillis()) / 100)) * 100, 0L);
    }

    private final void handleChannelMessagesLoading(boolean channelMessagesLoading) {
        this.dispatcher.schedule(new StoreConnectivity$handleChannelMessagesLoading$1(this, channelMessagesLoading));
    }

    private final void handleDeviceNetworkStateUpdated(NetworkMonitor$State state) {
        this.dispatcher.schedule(new StoreConnectivity$handleDeviceNetworkStateUpdated$1(this, state));
    }

    private final void setState(StoreConnectivity$DelayedState storeConnectivity$DelayedState) {
        this.state.setValue(this, $$delegatedProperties[0], storeConnectivity$DelayedState);
    }

    private final void updateConnectivityState() {
        StoreConnectivity$State storeConnectivity$State;
        NetworkMonitor$State networkMonitor$State = this.deviceNetworkState;
        if (networkMonitor$State == NetworkMonitor$State.OFFLINE) {
            storeConnectivity$State = StoreConnectivity$State.OFFLINE;
        } else if (networkMonitor$State == NetworkMonitor$State.OFFLINE_AIRPLANE_MODE) {
            storeConnectivity$State = StoreConnectivity$State.OFFLINE_AIRPLANE_MODE;
        } else {
            storeConnectivity$State = (!this.isReadyPayloadReceived || this.channelMessagesLoading) ? StoreConnectivity$State.CONNECTING : StoreConnectivity$State.ONLINE;
        }
        if (getState().getState() != storeConnectivity$State || this.stateTriggeredTimeMillis == null) {
            this.stateTriggeredTimeMillis = Long.valueOf(this.clock.currentTimeMillis());
            this.stateTriggeredDelay = getNextStateDelayInitial(getState(), storeConnectivity$State);
        }
        setState(new StoreConnectivity$DelayedState(storeConnectivity$State, getStateDelay(this.stateTriggeredDelay)));
    }

    @StoreThread
    public final void handleBackgrounded(boolean backgrounded) {
        if (backgrounded) {
            this.stateTriggeredDelay -= getStateActiveMillis();
        }
        if (this.stateTriggeredTimeMillis != null) {
            this.stateTriggeredTimeMillis = Long.valueOf(this.clock.currentTimeMillis());
        }
        updateConnectivityState();
    }

    @StoreThread
    public final void handleConnected(boolean connected) {
        if (connected) {
            return;
        }
        this.isReadyPayloadReceived = false;
        updateConnectivityState();
    }

    @StoreThread
    public final void handleConnectionReady(boolean connectionReady) {
        this.isReadyPayloadReceived = connectionReady;
        updateConnectivityState();
    }

    @StoreThread
    public final void init(NetworkMonitor networkMonitor) {
        m.checkNotNullParameter(networkMonitor, "networkMonitor");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.computationLatest(networkMonitor.observeState()), StoreConnectivity.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new StoreConnectivity$init$1(this), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(this.stream.getMessagesLoader().observeChannelMessagesLoading(), StoreConnectivity.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new StoreConnectivity$init$2(this), 62, (Object) null);
    }

    public final boolean isConnected() {
        return getState().getState() == StoreConnectivity$State.ONLINE;
    }

    public final Observable<StoreConnectivity$DelayedState> observeState() {
        Observable<StoreConnectivity$DelayedState> observableR = ObservationDeck.connectRx$default(ObservationDeckProvider.get(), new ObservationDeck$UpdateSource[]{this}, false, null, null, new StoreConnectivity$observeState$1(this), 14, null).r();
        m.checkNotNullExpressionValue(observableR, "ObservationDeckProvider\n…  .distinctUntilChanged()");
        return observableR;
    }
}
