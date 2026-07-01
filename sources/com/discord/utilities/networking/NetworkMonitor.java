package com.discord.utilities.networking;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Build$VERSION;
import com.discord.utilities.io.NetworkUtils;
import com.discord.utilities.logging.Logger;
import d0.z.d.m;
import rx.Observable;
import rx.subjects.BehaviorSubject;

/* JADX INFO: compiled from: NetworkMonitor.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class NetworkMonitor {
    private Logger logger;
    private final BehaviorSubject<NetworkMonitor$State> networkStateSubject;

    public NetworkMonitor(Context context, Logger logger) {
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(logger, "logger");
        this.logger = logger;
        this.networkStateSubject = BehaviorSubject.l0(getState$default(this, context, null, 2, null));
        registerConnectivityNetworkMonitor(context);
    }

    public static final /* synthetic */ Logger access$getLogger$p(NetworkMonitor networkMonitor) {
        return networkMonitor.logger;
    }

    public static final /* synthetic */ void access$setLogger$p(NetworkMonitor networkMonitor, Logger logger) {
        networkMonitor.logger = logger;
    }

    public static final /* synthetic */ void access$updateNetworkState(NetworkMonitor networkMonitor, Context context, Intent intent) {
        networkMonitor.updateNetworkState(context, intent);
    }

    private final NetworkMonitor$State getState(Context context, Intent intent) {
        NetworkMonitor$State networkMonitor$State;
        NetworkUtils networkUtils = NetworkUtils.INSTANCE;
        if (networkUtils.isDeviceConnected(context, intent, this.logger)) {
            networkMonitor$State = NetworkMonitor$State.ONLINE;
        } else {
            networkMonitor$State = networkUtils.isAirplaneModeOn(context) ? NetworkMonitor$State.OFFLINE_AIRPLANE_MODE : NetworkMonitor$State.OFFLINE;
        }
        Logger.i$default(this.logger, "[NetworkMonitor]", "Updating network state to " + networkMonitor$State + ", API: " + Build$VERSION.SDK_INT, null, 4, null);
        return networkMonitor$State;
    }

    public static /* synthetic */ NetworkMonitor$State getState$default(NetworkMonitor networkMonitor, Context context, Intent intent, int i, Object obj) {
        if ((i & 2) != 0) {
            intent = null;
        }
        return networkMonitor.getState(context, intent);
    }

    private final void registerBroadcastAirplaneMode(Context context) {
        context.registerReceiver(new NetworkMonitor$registerBroadcastAirplaneMode$1(this), new IntentFilter("android.intent.action.AIRPLANE_MODE"));
    }

    private final void registerBroadcastConnectivityNetworkMonitor(Context context) {
        context.registerReceiver(new NetworkMonitor$registerBroadcastConnectivityNetworkMonitor$1(this), new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    }

    private final void registerConnectivityNetworkMonitor(Context context) {
        Object systemService = context.getSystemService("connectivity");
        if (!(systemService instanceof ConnectivityManager)) {
            systemService = null;
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) systemService;
        if (connectivityManager != null) {
            NetworkMonitor$registerConnectivityNetworkMonitor$networkCallback$1 networkMonitor$registerConnectivityNetworkMonitor$networkCallback$1 = new NetworkMonitor$registerConnectivityNetworkMonitor$networkCallback$1(this, context);
            NetworkMonitor$registerConnectivityNetworkMonitor$1 networkMonitor$registerConnectivityNetworkMonitor$1 = new NetworkMonitor$registerConnectivityNetworkMonitor$1(this, connectivityManager, networkMonitor$registerConnectivityNetworkMonitor$networkCallback$1);
            if (Build$VERSION.SDK_INT >= 24) {
                try {
                    connectivityManager.registerDefaultNetworkCallback(networkMonitor$registerConnectivityNetworkMonitor$networkCallback$1);
                } catch (Exception unused) {
                    networkMonitor$registerConnectivityNetworkMonitor$1.invoke2();
                }
            } else {
                networkMonitor$registerConnectivityNetworkMonitor$1.invoke2();
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
        Observable<Boolean> observableR = observeState().G(NetworkMonitor$observeIsConnected$1.INSTANCE).r();
        m.checkNotNullExpressionValue(observableR, "observeState().map { sta… }.distinctUntilChanged()");
        return observableR;
    }

    public final Observable<NetworkMonitor$State> observeState() {
        Observable<NetworkMonitor$State> observableR = this.networkStateSubject.K().r();
        m.checkNotNullExpressionValue(observableR, "networkStateSubject.onBa…().distinctUntilChanged()");
        return observableR;
    }
}
