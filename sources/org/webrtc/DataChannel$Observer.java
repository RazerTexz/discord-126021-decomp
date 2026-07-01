package org.webrtc;

/* JADX INFO: loaded from: classes3.dex */
public interface DataChannel$Observer {
    @CalledByNative("Observer")
    void onBufferedAmountChange(long j);

    @CalledByNative("Observer")
    void onMessage(DataChannel$Buffer dataChannel$Buffer);

    @CalledByNative("Observer")
    void onStateChange();
}
