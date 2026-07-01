package org.webrtc;

import h0.c.b0;

/* JADX INFO: loaded from: classes3.dex */
public class VideoDecoderWrapper {
    @CalledByNative
    public static VideoDecoder$Callback createDecoderCallback(long j) {
        return new b0(j);
    }

    public static /* synthetic */ void lambda$createDecoderCallback$0(long j, VideoFrame videoFrame, Integer num, Integer num2) {
        nativeOnDecodedFrame(j, videoFrame, num, num2);
    }

    private static native void nativeOnDecodedFrame(long j, VideoFrame videoFrame, Integer num, Integer num2);
}
