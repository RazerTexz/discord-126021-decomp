package org.webrtc;

import android.content.Context;

/* JADX INFO: loaded from: classes3.dex */
public class NetworkMonitor$1 implements NetworkChangeDetectorFactory {
    public final /* synthetic */ NetworkMonitor this$0;

    public NetworkMonitor$1(NetworkMonitor networkMonitor) {
        this.this$0 = networkMonitor;
    }

    @Override // org.webrtc.NetworkChangeDetectorFactory
    public NetworkChangeDetector create(NetworkChangeDetector$Observer networkChangeDetector$Observer, Context context) {
        return new NetworkMonitorAutoDetect(networkChangeDetector$Observer, context);
    }
}
