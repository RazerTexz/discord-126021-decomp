package org.webrtc;

import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public interface NetworkChangeDetector$Observer {
    void onConnectionTypeChanged(NetworkChangeDetector$ConnectionType networkChangeDetector$ConnectionType);

    void onNetworkConnect(NetworkChangeDetector$NetworkInformation networkChangeDetector$NetworkInformation);

    void onNetworkDisconnect(long j);

    void onNetworkPreference(List<NetworkChangeDetector$ConnectionType> list, int i);
}
