package org.webrtc;

/* JADX INFO: loaded from: classes3.dex */
public interface TextureBufferImpl$RefCountMonitor {
    void onDestroy(TextureBufferImpl textureBufferImpl);

    void onRelease(TextureBufferImpl textureBufferImpl);

    void onRetain(TextureBufferImpl textureBufferImpl);
}
