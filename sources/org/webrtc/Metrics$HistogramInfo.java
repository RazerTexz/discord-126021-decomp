package org.webrtc;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class Metrics$HistogramInfo {
    public final int bucketCount;
    public final int max;
    public final int min;
    public final Map<Integer, Integer> samples = new HashMap();

    @CalledByNative("HistogramInfo")
    public Metrics$HistogramInfo(int i, int i2, int i3) {
        this.min = i;
        this.max = i2;
        this.bucketCount = i3;
    }

    @CalledByNative("HistogramInfo")
    public void addSample(int i, int i2) {
        this.samples.put(Integer.valueOf(i), Integer.valueOf(i2));
    }
}
