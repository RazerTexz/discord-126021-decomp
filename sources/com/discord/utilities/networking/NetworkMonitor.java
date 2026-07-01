package com.discord.utilities.networking;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkRequest;
import android.os.Build;
import com.discord.utilities.io.NetworkUtils;
import com.discord.utilities.logging.Logger;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.k.Func1;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import rx.Observable;
import rx.subjects.BehaviorSubject;

/* JADX INFO: compiled from: NetworkMonitor.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class NetworkMonitor {
    private Logger logger;
    private final BehaviorSubject<State> networkStateSubject;

    /* JADX INFO: compiled from: NetworkMonitor.kt */
    public enum State {
        ONLINE,
        OFFLINE,
        OFFLINE_AIRPLANE_MODE
    }

    /* JADX INFO: renamed from: com.discord.utilities.networking.NetworkMonitor$registerConnectivityNetworkMonitor$1, reason: invalid class name */
    /* JADX INFO: compiled from: NetworkMonitor.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ ConnectivityManager $connectivityManager;
        public final /* synthetic */ NetworkMonitor2 $networkCallback;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(ConnectivityManager connectivityManager, NetworkMonitor2 networkMonitor2) {
            super(0);
            this.$connectivityManager = connectivityManager;
            this.$networkCallback = networkMonitor2;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            try {
                this.$connectivityManager.registerNetworkCallback(new NetworkRequest.Builder().build(), this.$networkCallback);
            } catch (Exception e) {
                NetworkMonitor.this.logger.i("[NetworkMonitor]", "Unable to register network callback.", e);
            }
        }
    }

    public NetworkMonitor(Context context, Logger logger) {
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(logger, "logger");
        this.logger = logger;
        this.networkStateSubject = BehaviorSubject.l0(getState$default(this, context, null, 2, null));
        registerConnectivityNetworkMonitor(context);
    }

    private final State getState(Context context, Intent intent) {
        State state;
        NetworkUtils networkUtils = NetworkUtils.INSTANCE;
        if (networkUtils.isDeviceConnected(context, intent, this.logger)) {
            state = State.ONLINE;
        } else {
            state = networkUtils.isAirplaneModeOn(context) ? State.OFFLINE_AIRPLANE_MODE : State.OFFLINE;
        }
        Logger.i$default(this.logger, "[NetworkMonitor]", "Updating network state to " + state + ", API: " + Build.VERSION.SDK_INT, null, 4, null);
        return state;
    }

    public static /* synthetic */ State getState$default(NetworkMonitor networkMonitor, Context context, Intent intent, int i, Object obj) {
        if ((i & 2) != 0) {
            intent = null;
        }
        return networkMonitor.getState(context, intent);
    }

    private final void registerBroadcastAirplaneMode(Context context) {
        context.registerReceiver(new BroadcastReceiver() { // from class: com.discord.utilities.networking.NetworkMonitor.registerBroadcastAirplaneMode.1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context2, Intent intent) {
                Intrinsics3.checkNotNullParameter(context2, "context");
                Intrinsics3.checkNotNullParameter(intent, "intent");
                Logger.i$default(NetworkMonitor.this.logger, "[NetworkMonitor]", "Got airplane mode broadcast intent.", null, 4, null);
                NetworkMonitor.updateNetworkState$default(NetworkMonitor.this, context2, null, 2, null);
            }
        }, new IntentFilter("android.intent.action.AIRPLANE_MODE"));
    }

    private final void registerBroadcastConnectivityNetworkMonitor(Context context) {
        context.registerReceiver(new BroadcastReceiver() { // from class: com.discord.utilities.networking.NetworkMonitor.registerBroadcastConnectivityNetworkMonitor.1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context2, Intent intent) {
                Intrinsics3.checkNotNullParameter(context2, "context");
                Intrinsics3.checkNotNullParameter(intent, "intent");
                Logger.i$default(NetworkMonitor.this.logger, "[NetworkMonitor]", "Got connectivity action broadcast intent.", null, 4, null);
                NetworkMonitor.this.updateNetworkState(context2, intent);
            }
        }, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [android.net.ConnectivityManager$NetworkCallback, com.discord.utilities.networking.NetworkMonitor$registerConnectivityNetworkMonitor$networkCallback$1] */
    private final void registerConnectivityNetworkMonitor(final Context context) {
        Object systemService = context.getSystemService("connectivity");
        if (!(systemService instanceof ConnectivityManager)) {
            systemService = null;
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) systemService;
        if (connectivityManager != 0) {
            ?? r1 = new ConnectivityManager.NetworkCallback() { // from class: com.discord.utilities.networking.NetworkMonitor$registerConnectivityNetworkMonitor$networkCallback$1
                @Override // android.net.ConnectivityManager.NetworkCallback
                public void onAvailable(Network network) {
                    Intrinsics3.checkNotNullParameter(network, "network");
                    Logger.i$default(this.this$0.logger, "[NetworkMonitor]", "Network callback, onAvailable fired: " + network, null, 4, null);
                    NetworkMonitor.updateNetworkState$default(this.this$0, context, null, 2, null);
                }

                @Override // android.net.ConnectivityManager.NetworkCallback
                public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
                    Intrinsics3.checkNotNullParameter(network, "network");
                    Intrinsics3.checkNotNullParameter(networkCapabilities, "networkCapabilities");
                    Logger.i$default(this.this$0.logger, "[NetworkMonitor]", "Network callback, onCapabilitiesChanged fired: " + network, null, 4, null);
                    NetworkMonitor.updateNetworkState$default(this.this$0, context, null, 2, null);
                }

                @Override // android.net.ConnectivityManager.NetworkCallback
                public void onLost(Network network) {
                    Intrinsics3.checkNotNullParameter(network, "network");
                    Logger.i$default(this.this$0.logger, "[NetworkMonitor]", "Network callback, onLost fired: " + network, null, 4, null);
                    NetworkMonitor.updateNetworkState$default(this.this$0, context, null, 2, null);
                }

                @Override // android.net.ConnectivityManager.NetworkCallback
                public void onUnavailable() {
                    Logger.i$default(this.this$0.logger, "[NetworkMonitor]", "Network callback, onUnavailable fired.", null, 4, null);
                    NetworkMonitor.updateNetworkState$default(this.this$0, context, null, 2, null);
                }
            };
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(connectivityManager, r1);
            if (Build.VERSION.SDK_INT >= 24) {
                try {
                    connectivityManager.registerDefaultNetworkCallback(r1);
                } catch (Exception unused) {
                    anonymousClass1.invoke2();
                }
            } else {
                anonymousClass1.invoke2();
            }
            registerBroadcastConnectivityNetworkMonitor(context);
            registerBroadcastAirplaneMode(context);
        }
    }

    private final void updateNetworkState(Context context, Intent intent) {
        this.networkStateSubject.onNext(getState(context, intent));
    }

    public static /* synthetic */ void updateNetworkState$default(NetworkMonitor networkMonitor, Context context, Intent intent, int i, Object obj) {
        if ((i & 2) != 0) {
            intent = null;
        }
        networkMonitor.updateNetworkState(context, intent);
    }

    public final Observable<Boolean> observeIsConnected() {
        Observable<Boolean> observableR = observeState().G(new Func1<State, Boolean>() { // from class: com.discord.utilities.networking.NetworkMonitor.observeIsConnected.1
            @Override // j0.k.Func1
            public final Boolean call(State state) {
                return Boolean.valueOf(state == State.ONLINE);
            }
        }).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "observeState().map { sta… }.distinctUntilChanged()");
        return observableR;
    }

    public final Observable<State> observeState() {
        Observable<State> observableR = this.networkStateSubject.K().r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "networkStateSubject.onBa…().distinctUntilChanged()");
        return observableR;
    }
}
