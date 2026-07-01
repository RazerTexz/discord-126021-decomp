package org.webrtc;

/* JADX INFO: loaded from: classes3.dex */
public class NetworkChangeDetector$IPAddress {
    public final byte[] address;

    public NetworkChangeDetector$IPAddress(byte[] bArr) {
        this.address = bArr;
    }

    @CalledByNative("IPAddress")
    private byte[] getAddress() {
        return this.address;
    }
}
