package org.webrtc;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.p2p.WifiP2pGroup;
import android.net.wifi.p2p.WifiP2pManager;
import android.os.Build$VERSION;
import androidx.annotation.Nullable;
import h0.c.q;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class NetworkMonitorAutoDetect$WifiDirectManagerDelegate extends BroadcastReceiver {
    private static final int WIFI_P2P_NETWORK_HANDLE = 0;
    private final Context context;
    private final NetworkChangeDetector$Observer observer;

    @Nullable
    private NetworkChangeDetector$NetworkInformation wifiP2pNetworkInfo;

    public NetworkMonitorAutoDetect$WifiDirectManagerDelegate(NetworkChangeDetector$Observer networkChangeDetector$Observer, Context context) {
        this.context = context;
        this.observer = networkChangeDetector$Observer;
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.wifi.p2p.STATE_CHANGED");
        intentFilter.addAction("android.net.wifi.p2p.CONNECTION_STATE_CHANGE");
        context.registerReceiver(this, intentFilter);
        if (Build$VERSION.SDK_INT > 28) {
            WifiP2pManager wifiP2pManager = (WifiP2pManager) context.getSystemService("wifip2p");
            wifiP2pManager.requestGroupInfo(wifiP2pManager.initialize(context, context.getMainLooper(), null), new q(this));
        }
    }

    private void onWifiP2pGroupChange(@Nullable WifiP2pGroup wifiP2pGroup) {
        if (wifiP2pGroup == null || wifiP2pGroup.getInterface() == null) {
            return;
        }
        try {
            ArrayList list = Collections.list(NetworkInterface.getByName(wifiP2pGroup.getInterface()).getInetAddresses());
            NetworkChangeDetector$IPAddress[] networkChangeDetector$IPAddressArr = new NetworkChangeDetector$IPAddress[list.size()];
            for (int i = 0; i < list.size(); i++) {
                networkChangeDetector$IPAddressArr[i] = new NetworkChangeDetector$IPAddress(((InetAddress) list.get(i)).getAddress());
            }
            NetworkChangeDetector$NetworkInformation networkChangeDetector$NetworkInformation = new NetworkChangeDetector$NetworkInformation(wifiP2pGroup.getInterface(), NetworkChangeDetector$ConnectionType.CONNECTION_WIFI, NetworkChangeDetector$ConnectionType.CONNECTION_NONE, 0L, networkChangeDetector$IPAddressArr);
            this.wifiP2pNetworkInfo = networkChangeDetector$NetworkInformation;
            this.observer.onNetworkConnect(networkChangeDetector$NetworkInformation);
        } catch (SocketException e) {
            Logging.e("NetworkMonitorAutoDetect", "Unable to get WifiP2p network interface", e);
        }
    }

    private void onWifiP2pStateChange(int i) {
        if (i == 1) {
            this.wifiP2pNetworkInfo = null;
            this.observer.onNetworkDisconnect(0L);
        }
    }

    public /* synthetic */ void a(WifiP2pGroup wifiP2pGroup) {
        onWifiP2pGroupChange(wifiP2pGroup);
    }

    public List<NetworkChangeDetector$NetworkInformation> getActiveNetworkList() {
        NetworkChangeDetector$NetworkInformation networkChangeDetector$NetworkInformation = this.wifiP2pNetworkInfo;
        return networkChangeDetector$NetworkInformation != null ? Collections.singletonList(networkChangeDetector$NetworkInformation) : Collections.emptyList();
    }

    @Override // android.content.BroadcastReceiver
    @SuppressLint({"InlinedApi"})
    public void onReceive(Context context, Intent intent) {
        if ("android.net.wifi.p2p.CONNECTION_STATE_CHANGE".equals(intent.getAction())) {
            onWifiP2pGroupChange((WifiP2pGroup) intent.getParcelableExtra("p2pGroupInfo"));
        } else if ("android.net.wifi.p2p.STATE_CHANGED".equals(intent.getAction())) {
            onWifiP2pStateChange(intent.getIntExtra("wifi_p2p_state", 0));
        }
    }

    public void release() {
        this.context.unregisterReceiver(this);
    }
}
