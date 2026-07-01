package org.webrtc;

/* JADX INFO: loaded from: classes3.dex */
public enum MediaSource$State {
    INITIALIZING,
    LIVE,
    ENDED,
    MUTED;

    @CalledByNative("State")
    public static MediaSource$State fromNativeIndex(int i) {
        return values()[i];
    }
}
