package org.webrtc;

/* JADX INFO: loaded from: classes3.dex */
public enum PeerConnection$IceConnectionState {
    NEW,
    CHECKING,
    CONNECTED,
    COMPLETED,
    FAILED,
    DISCONNECTED,
    CLOSED;

    @CalledByNative("IceConnectionState")
    public static PeerConnection$IceConnectionState fromNativeIndex(int i) {
        return values()[i];
    }
}
