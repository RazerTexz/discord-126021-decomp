package org.webrtc;

/* JADX INFO: loaded from: classes3.dex */
public interface VideoFrame$Buffer extends RefCounted {
    @CalledByNative("Buffer")
    VideoFrame$Buffer cropAndScale(int i, int i2, int i3, int i4, int i5, int i6);

    @CalledByNative("Buffer")
    int getHeight();

    @CalledByNative("Buffer")
    int getWidth();

    @Override // org.webrtc.RefCounted
    @CalledByNative("Buffer")
    void release();

    @Override // org.webrtc.RefCounted
    @CalledByNative("Buffer")
    void retain();

    @CalledByNative("Buffer")
    VideoFrame$I420Buffer toI420();
}
