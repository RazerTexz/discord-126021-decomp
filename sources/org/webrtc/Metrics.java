package org.webrtc;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class Metrics {
    private static final String TAG = "Metrics";
    public final Map<String, Metrics$HistogramInfo> map = new HashMap();

    @CalledByNative
    public Metrics() {
    }

    @CalledByNative
    private void add(String str, Metrics$HistogramInfo metrics$HistogramInfo) {
        this.map.put(str, metrics$HistogramInfo);
    }

    public static void enable() {
        nativeEnable();
    }

    public static Metrics getAndReset() {
        return nativeGetAndReset();
    }

    private static native void nativeEnable();

    private static native Metrics nativeGetAndReset();
}
