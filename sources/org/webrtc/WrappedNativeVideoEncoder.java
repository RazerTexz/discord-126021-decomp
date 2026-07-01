package org.webrtc;

import h0.c.r0;

/* JADX INFO: loaded from: classes3.dex */
public abstract class WrappedNativeVideoEncoder implements VideoEncoder {
    @Override // org.webrtc.VideoEncoder
    public abstract long createNativeVideoEncoder();

    @Override // org.webrtc.VideoEncoder
    public final VideoCodecStatus encode(VideoFrame videoFrame, VideoEncoder$EncodeInfo videoEncoder$EncodeInfo) {
        throw new UnsupportedOperationException("Not implemented.");
    }

    @Override // org.webrtc.VideoEncoder
    public final String getImplementationName() {
        throw new UnsupportedOperationException("Not implemented.");
    }

    @Override // org.webrtc.VideoEncoder
    public /* synthetic */ VideoEncoder$ResolutionBitrateLimits[] getResolutionBitrateLimits() {
        return r0.b(this);
    }

    @Override // org.webrtc.VideoEncoder
    public final VideoEncoder$ScalingSettings getScalingSettings() {
        throw new UnsupportedOperationException("Not implemented.");
    }

    @Override // org.webrtc.VideoEncoder
    public final VideoCodecStatus initEncode(VideoEncoder$Settings videoEncoder$Settings, VideoEncoder$Callback videoEncoder$Callback) {
        throw new UnsupportedOperationException("Not implemented.");
    }

    @Override // org.webrtc.VideoEncoder
    public abstract boolean isHardwareEncoder();

    @Override // org.webrtc.VideoEncoder
    public final VideoCodecStatus release() {
        throw new UnsupportedOperationException("Not implemented.");
    }

    @Override // org.webrtc.VideoEncoder
    public final VideoCodecStatus setRateAllocation(VideoEncoder$BitrateAllocation videoEncoder$BitrateAllocation, int i) {
        throw new UnsupportedOperationException("Not implemented.");
    }
}
