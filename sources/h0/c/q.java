package h0.c;

import android.net.wifi.p2p.WifiP2pGroup;
import android.net.wifi.p2p.WifiP2pManager$GroupInfoListener;
import org.webrtc.NetworkMonitorAutoDetect$WifiDirectManagerDelegate;

/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class q implements WifiP2pManager$GroupInfoListener {
    public final /* synthetic */ NetworkMonitorAutoDetect$WifiDirectManagerDelegate a;

    public /* synthetic */ q(NetworkMonitorAutoDetect$WifiDirectManagerDelegate networkMonitorAutoDetect$WifiDirectManagerDelegate) {
        this.a = networkMonitorAutoDetect$WifiDirectManagerDelegate;
    }

    @Override // android.net.wifi.p2p.WifiP2pManager$GroupInfoListener
    public final void onGroupInfoAvailable(WifiP2pGroup wifiP2pGroup) {
        this.a.a(wifiP2pGroup);
    }
}
