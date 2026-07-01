package org.webrtc;

/* JADX INFO: loaded from: classes3.dex */
public interface StatsObserver {
    @CalledByNative
    void onComplete(StatsReport[] statsReportArr);
}
