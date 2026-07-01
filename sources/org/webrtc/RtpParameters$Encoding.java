package org.webrtc;

import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public class RtpParameters$Encoding {
    public boolean active;
    public double bitratePriority;

    @Nullable
    public Integer maxBitrateBps;

    @Nullable
    public Integer maxFramerate;

    @Nullable
    public Integer minBitrateBps;
    public int networkPriority;

    @Nullable
    public Integer numTemporalLayers;

    @Nullable
    public String rid;

    @Nullable
    public Double scaleResolutionDownBy;
    public Long ssrc;

    public RtpParameters$Encoding(String str, boolean z2, Double d) {
        this.active = true;
        this.bitratePriority = 1.0d;
        this.networkPriority = 1;
        this.rid = str;
        this.active = z2;
        this.scaleResolutionDownBy = d;
    }

    @CalledByNative("Encoding")
    public boolean getActive() {
        return this.active;
    }

    @CalledByNative("Encoding")
    public double getBitratePriority() {
        return this.bitratePriority;
    }

    @Nullable
    @CalledByNative("Encoding")
    public Integer getMaxBitrateBps() {
        return this.maxBitrateBps;
    }

    @Nullable
    @CalledByNative("Encoding")
    public Integer getMaxFramerate() {
        return this.maxFramerate;
    }

    @Nullable
    @CalledByNative("Encoding")
    public Integer getMinBitrateBps() {
        return this.minBitrateBps;
    }

    @CalledByNative("Encoding")
    public int getNetworkPriority() {
        return this.networkPriority;
    }

    @Nullable
    @CalledByNative("Encoding")
    public Integer getNumTemporalLayers() {
        return this.numTemporalLayers;
    }

    @Nullable
    @CalledByNative("Encoding")
    public String getRid() {
        return this.rid;
    }

    @Nullable
    @CalledByNative("Encoding")
    public Double getScaleResolutionDownBy() {
        return this.scaleResolutionDownBy;
    }

    @CalledByNative("Encoding")
    public Long getSsrc() {
        return this.ssrc;
    }

    @CalledByNative("Encoding")
    public RtpParameters$Encoding(String str, boolean z2, double d, int i, Integer num, Integer num2, Integer num3, Integer num4, Double d2, Long l) {
        this.active = true;
        this.bitratePriority = 1.0d;
        this.networkPriority = 1;
        this.rid = str;
        this.active = z2;
        this.bitratePriority = d;
        this.networkPriority = i;
        this.maxBitrateBps = num;
        this.minBitrateBps = num2;
        this.maxFramerate = num3;
        this.numTemporalLayers = num4;
        this.scaleResolutionDownBy = d2;
        this.ssrc = l;
    }
}
