package org.webrtc;

/* JADX INFO: loaded from: classes3.dex */
public class PeerConnectionFactory$Options {
    public static final int ADAPTER_TYPE_ANY = 32;
    public static final int ADAPTER_TYPE_CELLULAR = 4;
    public static final int ADAPTER_TYPE_ETHERNET = 1;
    public static final int ADAPTER_TYPE_LOOPBACK = 16;
    public static final int ADAPTER_TYPE_UNKNOWN = 0;
    public static final int ADAPTER_TYPE_VPN = 8;
    public static final int ADAPTER_TYPE_WIFI = 2;
    public boolean disableEncryption;
    public boolean disableNetworkMonitor;
    public int networkIgnoreMask;

    @CalledByNative("Options")
    public boolean getDisableEncryption() {
        return this.disableEncryption;
    }

    @CalledByNative("Options")
    public boolean getDisableNetworkMonitor() {
        return this.disableNetworkMonitor;
    }

    @CalledByNative("Options")
    public int getNetworkIgnoreMask() {
        return this.networkIgnoreMask;
    }
}
