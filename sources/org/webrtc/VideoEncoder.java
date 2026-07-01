package org.webrtc;

/* JADX INFO: loaded from: classes3.dex */
public interface VideoEncoder {
    @CalledByNative
    long createNativeVideoEncoder();

    @CalledByNative
    VideoCodecStatus encode(VideoFrame videoFrame, VideoEncoder$EncodeInfo videoEncoder$EncodeInfo);

    @CalledByNative
    String getImplementationName();

    @CalledByNative
    VideoEncoder$ResolutionBitrateLimits[] getResolutionBitrateLimits();

    @CalledByNative
    VideoEncoder$ScalingSettings getScalingSettings();

    @CalledByNative
    VideoCodecStatus initEncode(VideoEncoder$Settings videoEncoder$Settings, VideoEncoder$Callback videoEncoder$Callback);

    @CalledByNative
    boolean isHardwareEncoder();

    @CalledByNative
    VideoCodecStatus release();

    @CalledByNative
    VideoCodecStatus setRateAllocation(VideoEncoder$BitrateAllocation videoEncoder$BitrateAllocation, int i);
}
