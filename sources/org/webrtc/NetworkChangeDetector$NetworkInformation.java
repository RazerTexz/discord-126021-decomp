package org.webrtc;

/* JADX INFO: loaded from: classes3.dex */
public class NetworkChangeDetector$NetworkInformation {
    public final long handle;
    public final NetworkChangeDetector$IPAddress[] ipAddresses;
    public final String name;
    public final NetworkChangeDetector$ConnectionType type;
    public final NetworkChangeDetector$ConnectionType underlyingTypeForVpn;

    public NetworkChangeDetector$NetworkInformation(String str, NetworkChangeDetector$ConnectionType networkChangeDetector$ConnectionType, NetworkChangeDetector$ConnectionType networkChangeDetector$ConnectionType2, long j, NetworkChangeDetector$IPAddress[] networkChangeDetector$IPAddressArr) {
        this.name = str;
        this.type = networkChangeDetector$ConnectionType;
        this.underlyingTypeForVpn = networkChangeDetector$ConnectionType2;
        this.handle = j;
        this.ipAddresses = networkChangeDetector$IPAddressArr;
    }

    @CalledByNative("NetworkInformation")
    private NetworkChangeDetector$ConnectionType getConnectionType() {
        return this.type;
    }

    @CalledByNative("NetworkInformation")
    private long getHandle() {
        return this.handle;
    }

    @CalledByNative("NetworkInformation")
    private NetworkChangeDetector$IPAddress[] getIpAddresses() {
        return this.ipAddresses;
    }

    @CalledByNative("NetworkInformation")
    private String getName() {
        return this.name;
    }

    @CalledByNative("NetworkInformation")
    private NetworkChangeDetector$ConnectionType getUnderlyingConnectionTypeForVpn() {
        return this.underlyingTypeForVpn;
    }
}
