package org.webrtc;

import androidx.annotation.Nullable;
import h0.c.c0;

/* JADX INFO: loaded from: classes3.dex */
public class VideoEncoderWrapper {
    @CalledByNative
    public static VideoEncoder$Callback createEncoderCallback(long j) {
        return new c0(j);
    }

    @Nullable
    @CalledByNative
    public static Integer getScalingSettingsHigh(VideoEncoder$ScalingSettings videoEncoder$ScalingSettings) {
        return videoEncoder$ScalingSettings.high;
    }

    @Nullable
    @CalledByNative
    public static Integer getScalingSettingsLow(VideoEncoder$ScalingSettings videoEncoder$ScalingSettings) {
        return videoEncoder$ScalingSettings.low;
    }

    @CalledByNative
    public static boolean getScalingSettingsOn(VideoEncoder$ScalingSettings videoEncoder$ScalingSettings) {
        return videoEncoder$ScalingSettings.on;
    }

    public static /* synthetic */ void lambda$createEncoderCallback$0(long j, EncodedImage encodedImage, VideoEncoder$CodecSpecificInfo videoEncoder$CodecSpecificInfo) {
        nativeOnEncodedFrame(j, encodedImage);
    }

    private static native void nativeOnEncodedFrame(long j, EncodedImage encodedImage);
}
