package org.webrtc;

import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class NetworkMonitor$2 implements NetworkChangeDetector$Observer {
    public final /* synthetic */ NetworkMonitor this$0;

    public NetworkMonitor$2(NetworkMonitor networkMonitor) {
        this.this$0 = networkMonitor;
    }

    @Override // org.webrtc.NetworkChangeDetector$Observer
    public void onConnectionTypeChanged(NetworkChangeDetector$ConnectionType networkChangeDetector$ConnectionType) {
        NetworkMonitor.access$100(this.this$0, networkChangeDetector$ConnectionType);
    }

    @Override // org.webrtc.NetworkChangeDetector$Observer
    public void onNetworkConnect(NetworkChangeDetector$NetworkInformation networkChangeDetector$NetworkInformation) {
        NetworkMonitor.access$200(this.this$0, networkChangeDetector$NetworkInformation);
    }

    @Override // org.webrtc.NetworkChangeDetector$Observer
    public void onNetworkDisconnect(long j) {
        NetworkMonitor.access$300(this.this$0, j);
    }

    @Override // org.webrtc.NetworkChangeDetector$Observer
    public void onNetworkPreference(List<NetworkChangeDetector$ConnectionType> list, int i) {
        NetworkMonitor.access$400(this.this$0, list, i);
    }
}
