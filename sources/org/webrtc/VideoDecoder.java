package org.webrtc;

/* JADX INFO: loaded from: classes3.dex */
public interface VideoDecoder {
    @CalledByNative
    long createNativeVideoDecoder();

    @CalledByNative
    VideoCodecStatus decode(EncodedImage encodedImage, VideoDecoder$DecodeInfo videoDecoder$DecodeInfo);

    @CalledByNative
    String getImplementationName();

    boolean getPrefersLateDecoding();

    @CalledByNative
    VideoCodecStatus initDecode(VideoDecoder$Settings videoDecoder$Settings, VideoDecoder$Callback videoDecoder$Callback);

    @CalledByNative
    VideoCodecStatus release();
}
