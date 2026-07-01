package org.webrtc;

/* JADX INFO: loaded from: classes3.dex */
public interface RTCStatsCollectorCallback {
    @CalledByNative
    void onStatsDelivered(RTCStatsReport rTCStatsReport);
}
