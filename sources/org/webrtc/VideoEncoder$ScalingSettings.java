package org.webrtc;

import androidx.annotation.Nullable;
import b.d.b.a.a;

/* JADX INFO: loaded from: classes3.dex */
public class VideoEncoder$ScalingSettings {
    public static final VideoEncoder$ScalingSettings OFF = new VideoEncoder$ScalingSettings();

    @Nullable
    public final Integer high;

    @Nullable
    public final Integer low;
    public final boolean on;

    public VideoEncoder$ScalingSettings(int i, int i2) {
        this.on = true;
        this.low = Integer.valueOf(i);
        this.high = Integer.valueOf(i2);
    }

    public String toString() {
        if (!this.on) {
            return "OFF";
        }
        StringBuilder sbU = a.U("[ ");
        sbU.append(this.low);
        sbU.append(", ");
        return a.F(sbU, this.high, " ]");
    }

    private VideoEncoder$ScalingSettings() {
        this.on = false;
        this.low = null;
        this.high = null;
    }

    @Deprecated
    public VideoEncoder$ScalingSettings(boolean z2) {
        this.on = z2;
        this.low = null;
        this.high = null;
    }

    @Deprecated
    public VideoEncoder$ScalingSettings(boolean z2, int i, int i2) {
        this.on = z2;
        this.low = Integer.valueOf(i);
        this.high = Integer.valueOf(i2);
    }
}
