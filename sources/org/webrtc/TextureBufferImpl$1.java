package org.webrtc;

/* JADX INFO: loaded from: classes3.dex */
public class TextureBufferImpl$1 implements TextureBufferImpl$RefCountMonitor {
    public final /* synthetic */ Runnable val$releaseCallback;

    public TextureBufferImpl$1(Runnable runnable) {
        this.val$releaseCallback = runnable;
    }

    @Override // org.webrtc.TextureBufferImpl$RefCountMonitor
    public void onDestroy(TextureBufferImpl textureBufferImpl) {
        Runnable runnable = this.val$releaseCallback;
        if (runnable != null) {
            runnable.run();
        }
    }

    @Override // org.webrtc.TextureBufferImpl$RefCountMonitor
    public void onRelease(TextureBufferImpl textureBufferImpl) {
    }

    @Override // org.webrtc.TextureBufferImpl$RefCountMonitor
    public void onRetain(TextureBufferImpl textureBufferImpl) {
    }
}
