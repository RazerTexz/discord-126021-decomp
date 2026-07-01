package org.webrtc;

import android.annotation.SuppressLint;
import android.net.ConnectivityManager$NetworkCallback;
import android.net.LinkProperties;
import android.net.Network;
import android.net.NetworkCapabilities;
import b.d.b.a.a;

/* JADX INFO: loaded from: classes3.dex */
@SuppressLint({"NewApi"})
public class NetworkMonitorAutoDetect$SimpleNetworkCallback extends ConnectivityManager$NetworkCallback {
    public final /* synthetic */ NetworkMonitorAutoDetect this$0;

    private NetworkMonitorAutoDetect$SimpleNetworkCallback(NetworkMonitorAutoDetect networkMonitorAutoDetect) {
        this.this$0 = networkMonitorAutoDetect;
    }

    private void onNetworkChanged(Network network) {
        NetworkChangeDetector$NetworkInformation networkChangeDetector$NetworkInformationAccess$300 = NetworkMonitorAutoDetect$ConnectivityManagerDelegate.access$300(NetworkMonitorAutoDetect.access$200(this.this$0), network);
        if (networkChangeDetector$NetworkInformationAccess$300 != null) {
            NetworkMonitorAutoDetect.access$100(this.this$0).onNetworkConnect(networkChangeDetector$NetworkInformationAccess$300);
        }
    }

    @Override // android.net.ConnectivityManager$NetworkCallback
    public void onAvailable(Network network) {
        StringBuilder sbU = a.U("Network becomes available: ");
        sbU.append(network.toString());
        Logging.d("NetworkMonitorAutoDetect", sbU.toString());
        onNetworkChanged(network);
    }

    @Override // android.net.ConnectivityManager$NetworkCallback
    public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
        StringBuilder sbU = a.U("capabilities changed: ");
        sbU.append(networkCapabilities.toString());
        Logging.d("NetworkMonitorAutoDetect", sbU.toString());
        onNetworkChanged(network);
    }

    @Override // android.net.ConnectivityManager$NetworkCallback
    public void onLinkPropertiesChanged(Network network, LinkProperties linkProperties) {
        Logging.d("NetworkMonitorAutoDetect", "link properties changed");
        onNetworkChanged(network);
    }

    @Override // android.net.ConnectivityManager$NetworkCallback
    public void onLosing(Network network, int i) {
        StringBuilder sbU = a.U("Network ");
        sbU.append(network.toString());
        sbU.append(" is about to lose in ");
        sbU.append(i);
        sbU.append("ms");
        Logging.d("NetworkMonitorAutoDetect", sbU.toString());
    }

    @Override // android.net.ConnectivityManager$NetworkCallback
    public void onLost(Network network) {
        StringBuilder sbU = a.U("Network ");
        sbU.append(network.toString());
        sbU.append(" is disconnected");
        Logging.d("NetworkMonitorAutoDetect", sbU.toString());
        NetworkMonitorAutoDetect.access$100(this.this$0).onNetworkDisconnect(NetworkMonitorAutoDetect.access$000(network));
    }

    public /* synthetic */ NetworkMonitorAutoDetect$SimpleNetworkCallback(NetworkMonitorAutoDetect networkMonitorAutoDetect, NetworkMonitorAutoDetect$1 networkMonitorAutoDetect$1) {
        this(networkMonitorAutoDetect);
    }
}
