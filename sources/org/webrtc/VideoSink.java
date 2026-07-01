package org.webrtc;

/* JADX INFO: loaded from: classes3.dex */
public interface VideoSink {
    @CalledByNative
    void onFrame(VideoFrame videoFrame);
}
