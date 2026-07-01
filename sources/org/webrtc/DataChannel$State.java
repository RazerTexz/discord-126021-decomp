package org.webrtc;

/* JADX INFO: loaded from: classes3.dex */
public enum DataChannel$State {
    CONNECTING,
    OPEN,
    CLOSING,
    CLOSED;

    @CalledByNative("State")
    public static DataChannel$State fromNativeIndex(int i) {
        return values()[i];
    }
}
