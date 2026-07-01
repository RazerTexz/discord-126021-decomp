package org.webrtc;

/* JADX INFO: loaded from: classes3.dex */
public class VideoEncoder$ResolutionBitrateLimits {
    public final int frameSizePixels;
    public final int maxBitrateBps;
    public final int minBitrateBps;
    public final int minStartBitrateBps;

    public VideoEncoder$ResolutionBitrateLimits(int i, int i2, int i3, int i4) {
        this.frameSizePixels = i;
        this.minStartBitrateBps = i2;
        this.minBitrateBps = i3;
        this.maxBitrateBps = i4;
    }

    @CalledByNative("ResolutionBitrateLimits")
    public int getFrameSizePixels() {
        return this.frameSizePixels;
    }

    @CalledByNative("ResolutionBitrateLimits")
    public int getMaxBitrateBps() {
        return this.maxBitrateBps;
    }

    @CalledByNative("ResolutionBitrateLimits")
    public int getMinBitrateBps() {
        return this.minBitrateBps;
    }

    @CalledByNative("ResolutionBitrateLimits")
    public int getMinStartBitrateBps() {
        return this.minStartBitrateBps;
    }
}
