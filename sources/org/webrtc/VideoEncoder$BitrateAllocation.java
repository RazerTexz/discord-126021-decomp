package org.webrtc;

/* JADX INFO: loaded from: classes3.dex */
public class VideoEncoder$BitrateAllocation {
    public final int[][] bitratesBbs;

    @CalledByNative("BitrateAllocation")
    public VideoEncoder$BitrateAllocation(int[][] iArr) {
        this.bitratesBbs = iArr;
    }

    public int getSum() {
        int i = 0;
        for (int[] iArr : this.bitratesBbs) {
            for (int i2 : iArr) {
                i += i2;
            }
        }
        return i;
    }
}
