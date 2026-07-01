package org.webrtc;

/* JADX INFO: loaded from: classes3.dex */
public enum PeerConnection$PeerConnectionState {
    NEW,
    CONNECTING,
    CONNECTED,
    DISCONNECTED,
    FAILED,
    CLOSED;

    @CalledByNative("PeerConnectionState")
    public static PeerConnection$PeerConnectionState fromNativeIndex(int i) {
        return values()[i];
    }
}
