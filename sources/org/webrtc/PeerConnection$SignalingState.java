package org.webrtc;

/* JADX INFO: loaded from: classes3.dex */
public enum PeerConnection$SignalingState {
    STABLE,
    HAVE_LOCAL_OFFER,
    HAVE_LOCAL_PRANSWER,
    HAVE_REMOTE_OFFER,
    HAVE_REMOTE_PRANSWER,
    CLOSED;

    @CalledByNative("SignalingState")
    public static PeerConnection$SignalingState fromNativeIndex(int i) {
        return values()[i];
    }
}
