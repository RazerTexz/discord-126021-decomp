package org.webrtc;

/* JADX INFO: loaded from: classes3.dex */
public enum PeerConnection$IceGatheringState {
    NEW,
    GATHERING,
    COMPLETE;

    @CalledByNative("IceGatheringState")
    public static PeerConnection$IceGatheringState fromNativeIndex(int i) {
        return values()[i];
    }
}
