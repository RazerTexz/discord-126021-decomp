package org.webrtc;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager$NetworkCallback;
import android.net.Network;
import android.os.Build$VERSION;
import androidx.annotation.Nullable;
import b.d.b.a.a;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class NetworkMonitorAutoDetect extends BroadcastReceiver implements NetworkChangeDetector {
    private static final long INVALID_NET_ID = -1;
    private static final String TAG = "NetworkMonitorAutoDetect";

    @Nullable
    private final ConnectivityManager$NetworkCallback allNetworkCallback;
    private NetworkChangeDetector$ConnectionType connectionType;
    private NetworkMonitorAutoDetect$ConnectivityManagerDelegate connectivityManagerDelegate;
    private final Context context;
    private final IntentFilter intentFilter;
    private boolean isRegistered;

    @Nullable
    private final ConnectivityManager$NetworkCallback mobileNetworkCallback;
    private final NetworkChangeDetector$Observer observer;
    private NetworkMonitorAutoDetect$WifiDirectManagerDelegate wifiDirectManagerDelegate;
    private NetworkMonitorAutoDetect$WifiManagerDelegate wifiManagerDelegate;
    private String wifiSSID;

    @SuppressLint({"NewApi"})
    public NetworkMonitorAutoDetect(NetworkChangeDetector$Observer networkChangeDetector$Observer, Context context) {
        this.observer = networkChangeDetector$Observer;
        this.context = context;
        this.connectivityManagerDelegate = new NetworkMonitorAutoDetect$ConnectivityManagerDelegate(context);
        this.wifiManagerDelegate = new NetworkMonitorAutoDetect$WifiManagerDelegate(context);
        NetworkMonitorAutoDetect$NetworkState networkState = this.connectivityManagerDelegate.getNetworkState();
        this.connectionType = getConnectionType(networkState);
        this.wifiSSID = getWifiSSID(networkState);
        this.intentFilter = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
        if (PeerConnectionFactory.fieldTrialsFindFullName("IncludeWifiDirect").equals(PeerConnectionFactory.TRIAL_ENABLED)) {
            this.wifiDirectManagerDelegate = new NetworkMonitorAutoDetect$WifiDirectManagerDelegate(networkChangeDetector$Observer, context);
        }
        registerReceiver();
        if (!this.connectivityManagerDelegate.supportNetworkCallback()) {
            this.mobileNetworkCallback = null;
            this.allNetworkCallback = null;
            return;
        }
        ConnectivityManager$NetworkCallback connectivityManager$NetworkCallback = new ConnectivityManager$NetworkCallback();
        try {
            this.connectivityManagerDelegate.requestMobileNetwork(connectivityManager$NetworkCallback);
        } catch (SecurityException unused) {
            Logging.w(TAG, "Unable to obtain permission to request a cellular network.");
            connectivityManager$NetworkCallback = null;
        }
        this.mobileNetworkCallback = connectivityManager$NetworkCallback;
        NetworkMonitorAutoDetect$SimpleNetworkCallback networkMonitorAutoDetect$SimpleNetworkCallback = new NetworkMonitorAutoDetect$SimpleNetworkCallback(this, null);
        this.allNetworkCallback = networkMonitorAutoDetect$SimpleNetworkCallback;
        this.connectivityManagerDelegate.registerNetworkCallback(networkMonitorAutoDetect$SimpleNetworkCallback);
    }

    public static /* synthetic */ long access$000(Network network) {
        return networkToNetId(network);
    }

    public static /* synthetic */ NetworkChangeDetector$Observer access$100(NetworkMonitorAutoDetect networkMonitorAutoDetect) {
        return networkMonitorAutoDetect.observer;
    }

    public static /* synthetic */ NetworkMonitorAutoDetect$ConnectivityManagerDelegate access$200(NetworkMonitorAutoDetect networkMonitorAutoDetect) {
        return networkMonitorAutoDetect.connectivityManagerDelegate;
    }

    public static /* synthetic */ NetworkChangeDetector$ConnectionType access$400(NetworkMonitorAutoDetect$NetworkState networkMonitorAutoDetect$NetworkState) {
        return getUnderlyingConnectionTypeForVpn(networkMonitorAutoDetect$NetworkState);
    }

    private void connectionTypeChanged(NetworkMonitorAutoDetect$NetworkState networkMonitorAutoDetect$NetworkState) {
        NetworkChangeDetector$ConnectionType connectionType = getConnectionType(networkMonitorAutoDetect$NetworkState);
        String wifiSSID = getWifiSSID(networkMonitorAutoDetect$NetworkState);
        if (connectionType == this.connectionType && wifiSSID.equals(this.wifiSSID)) {
            return;
        }
        this.connectionType = connectionType;
        this.wifiSSID = wifiSSID;
        StringBuilder sbU = a.U("Network connectivity changed, type is: ");
        sbU.append(this.connectionType);
        Logging.d(TAG, sbU.toString());
        this.observer.onConnectionTypeChanged(connectionType);
    }

    private static NetworkChangeDetector$ConnectionType getConnectionType(boolean z2, int i, int i2) {
        if (!z2) {
            return NetworkChangeDetector$ConnectionType.CONNECTION_NONE;
        }
        if (i == 0) {
            switch (i2) {
                case 1:
                case 2:
                case 4:
                case 7:
                case 11:
                case 16:
                    return NetworkChangeDetector$ConnectionType.CONNECTION_2G;
                case 3:
                case 5:
                case 6:
                case 8:
                case 9:
                case 10:
                case 12:
                case 14:
                case 15:
                case 17:
                    return NetworkChangeDetector$ConnectionType.CONNECTION_3G;
                case 13:
                case 18:
                    return NetworkChangeDetector$ConnectionType.CONNECTION_4G;
                case 19:
                default:
                    return NetworkChangeDetector$ConnectionType.CONNECTION_UNKNOWN_CELLULAR;
                case 20:
                    return NetworkChangeDetector$ConnectionType.CONNECTION_5G;
            }
        }
        if (i == 1) {
            return NetworkChangeDetector$ConnectionType.CONNECTION_WIFI;
        }
        if (i == 6) {
            return NetworkChangeDetector$ConnectionType.CONNECTION_4G;
        }
        if (i == 7) {
            return NetworkChangeDetector$ConnectionType.CONNECTION_BLUETOOTH;
        }
        if (i != 9) {
            return i != 17 ? NetworkChangeDetector$ConnectionType.CONNECTION_UNKNOWN : NetworkChangeDetector$ConnectionType.CONNECTION_VPN;
        }
        return NetworkChangeDetector$ConnectionType.CONNECTION_ETHERNET;
    }

    private static NetworkChangeDetector$ConnectionType getUnderlyingConnectionTypeForVpn(NetworkMonitorAutoDetect$NetworkState networkMonitorAutoDetect$NetworkState) {
        return networkMonitorAutoDetect$NetworkState.getNetworkType() != 17 ? NetworkChangeDetector$ConnectionType.CONNECTION_NONE : getConnectionType(networkMonitorAutoDetect$NetworkState.isConnected(), networkMonitorAutoDetect$NetworkState.getUnderlyingNetworkTypeForVpn(), networkMonitorAutoDetect$NetworkState.getUnderlyingNetworkSubtypeForVpn());
    }

    private String getWifiSSID(NetworkMonitorAutoDetect$NetworkState networkMonitorAutoDetect$NetworkState) {
        return getConnectionType(networkMonitorAutoDetect$NetworkState) != NetworkChangeDetector$ConnectionType.CONNECTION_WIFI ? "" : this.wifiManagerDelegate.getWifiSSID();
    }

    @SuppressLint({"NewApi"})
    private static long networkToNetId(Network network) {
        return Build$VERSION.SDK_INT >= 23 ? network.getNetworkHandle() : Integer.parseInt(network.toString());
    }

    private void registerReceiver() {
        if (this.isRegistered) {
            return;
        }
        this.isRegistered = true;
        this.context.registerReceiver(this, this.intentFilter);
    }

    private void unregisterReceiver() {
        if (this.isRegistered) {
            this.isRegistered = false;
            this.context.unregisterReceiver(this);
        }
    }

    @Override // org.webrtc.NetworkChangeDetector
    public void destroy() {
        ConnectivityManager$NetworkCallback connectivityManager$NetworkCallback = this.allNetworkCallback;
        if (connectivityManager$NetworkCallback != null) {
            this.connectivityManagerDelegate.releaseCallback(connectivityManager$NetworkCallback);
        }
        ConnectivityManager$NetworkCallback connectivityManager$NetworkCallback2 = this.mobileNetworkCallback;
        if (connectivityManager$NetworkCallback2 != null) {
            this.connectivityManagerDelegate.releaseCallback(connectivityManager$NetworkCallback2);
        }
        NetworkMonitorAutoDetect$WifiDirectManagerDelegate networkMonitorAutoDetect$WifiDirectManagerDelegate = this.wifiDirectManagerDelegate;
        if (networkMonitorAutoDetect$WifiDirectManagerDelegate != null) {
            networkMonitorAutoDetect$WifiDirectManagerDelegate.release();
        }
        unregisterReceiver();
    }

    @Override // org.webrtc.NetworkChangeDetector
    @Nullable
    public List<NetworkChangeDetector$NetworkInformation> getActiveNetworkList() {
        List<NetworkChangeDetector$NetworkInformation> activeNetworkList = this.connectivityManagerDelegate.getActiveNetworkList();
        if (activeNetworkList == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(activeNetworkList);
        NetworkMonitorAutoDetect$WifiDirectManagerDelegate networkMonitorAutoDetect$WifiDirectManagerDelegate = this.wifiDirectManagerDelegate;
        if (networkMonitorAutoDetect$WifiDirectManagerDelegate != null) {
            arrayList.addAll(networkMonitorAutoDetect$WifiDirectManagerDelegate.getActiveNetworkList());
        }
        return arrayList;
    }

    @Override // org.webrtc.NetworkChangeDetector
    public NetworkChangeDetector$ConnectionType getCurrentConnectionType() {
        return getConnectionType(getCurrentNetworkState());
    }

    public NetworkMonitorAutoDetect$NetworkState getCurrentNetworkState() {
        return this.connectivityManagerDelegate.getNetworkState();
    }

    public long getDefaultNetId() {
        return this.connectivityManagerDelegate.getDefaultNetId();
    }

    public boolean isReceiverRegisteredForTesting() {
        return this.isRegistered;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        NetworkMonitorAutoDetect$NetworkState currentNetworkState = getCurrentNetworkState();
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
            connectionTypeChanged(currentNetworkState);
        }
    }

    public void setConnectivityManagerDelegateForTests(NetworkMonitorAutoDetect$ConnectivityManagerDelegate networkMonitorAutoDetect$ConnectivityManagerDelegate) {
        this.connectivityManagerDelegate = networkMonitorAutoDetect$ConnectivityManagerDelegate;
    }

    public void setWifiManagerDelegateForTests(NetworkMonitorAutoDetect$WifiManagerDelegate networkMonitorAutoDetect$WifiManagerDelegate) {
        this.wifiManagerDelegate = networkMonitorAutoDetect$WifiManagerDelegate;
    }

    @Override // org.webrtc.NetworkChangeDetector
    public boolean supportNetworkCallback() {
        return this.connectivityManagerDelegate.supportNetworkCallback();
    }

    public static NetworkChangeDetector$ConnectionType getConnectionType(NetworkMonitorAutoDetect$NetworkState networkMonitorAutoDetect$NetworkState) {
        return getConnectionType(networkMonitorAutoDetect$NetworkState.isConnected(), networkMonitorAutoDetect$NetworkState.getNetworkType(), networkMonitorAutoDetect$NetworkState.getNetworkSubType());
    }
}
