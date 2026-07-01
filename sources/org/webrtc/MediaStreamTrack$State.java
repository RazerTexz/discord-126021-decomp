package org.webrtc;

/* JADX INFO: loaded from: classes3.dex */
public enum MediaStreamTrack$State {
    LIVE,
    ENDED;

    @CalledByNative("State")
    public static MediaStreamTrack$State fromNativeIndex(int i) {
        return values()[i];
    }
}
