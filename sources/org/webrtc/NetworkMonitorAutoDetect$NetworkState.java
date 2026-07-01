package org.webrtc;

/* JADX INFO: loaded from: classes3.dex */
public class NetworkMonitorAutoDetect$NetworkState {
    private final boolean connected;
    private final int subtype;
    private final int type;
    private final int underlyingNetworkSubtypeForVpn;
    private final int underlyingNetworkTypeForVpn;

    public NetworkMonitorAutoDetect$NetworkState(boolean z2, int i, int i2, int i3, int i4) {
        this.connected = z2;
        this.type = i;
        this.subtype = i2;
        this.underlyingNetworkTypeForVpn = i3;
        this.underlyingNetworkSubtypeForVpn = i4;
    }

    public int getNetworkSubType() {
        return this.subtype;
    }

    public int getNetworkType() {
        return this.type;
    }

    public int getUnderlyingNetworkSubtypeForVpn() {
        return this.underlyingNetworkSubtypeForVpn;
    }

    public int getUnderlyingNetworkTypeForVpn() {
        return this.underlyingNetworkTypeForVpn;
    }

    public boolean isConnected() {
        return this.connected;
    }
}
