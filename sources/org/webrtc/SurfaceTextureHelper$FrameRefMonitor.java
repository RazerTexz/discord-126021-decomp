package org.webrtc;

/* JADX INFO: loaded from: classes3.dex */
public interface SurfaceTextureHelper$FrameRefMonitor {
    void onDestroyBuffer(VideoFrame$TextureBuffer videoFrame$TextureBuffer);

    void onNewBuffer(VideoFrame$TextureBuffer videoFrame$TextureBuffer);

    void onReleaseBuffer(VideoFrame$TextureBuffer videoFrame$TextureBuffer);

    void onRetainBuffer(VideoFrame$TextureBuffer videoFrame$TextureBuffer);
}
