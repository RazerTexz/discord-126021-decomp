package org.webrtc;

/* JADX INFO: loaded from: classes3.dex */
public class SurfaceTextureHelper$2 implements TextureBufferImpl$RefCountMonitor {
    public final /* synthetic */ SurfaceTextureHelper this$0;

    public SurfaceTextureHelper$2(SurfaceTextureHelper surfaceTextureHelper) {
        this.this$0 = surfaceTextureHelper;
    }

    @Override // org.webrtc.TextureBufferImpl$RefCountMonitor
    public void onDestroy(TextureBufferImpl textureBufferImpl) {
        SurfaceTextureHelper.access$200(this.this$0);
        if (SurfaceTextureHelper.access$100(this.this$0) != null) {
            SurfaceTextureHelper.access$100(this.this$0).onDestroyBuffer(textureBufferImpl);
        }
    }

    @Override // org.webrtc.TextureBufferImpl$RefCountMonitor
    public void onRelease(TextureBufferImpl textureBufferImpl) {
        if (SurfaceTextureHelper.access$100(this.this$0) != null) {
            SurfaceTextureHelper.access$100(this.this$0).onReleaseBuffer(textureBufferImpl);
        }
    }

    @Override // org.webrtc.TextureBufferImpl$RefCountMonitor
    public void onRetain(TextureBufferImpl textureBufferImpl) {
        if (SurfaceTextureHelper.access$100(this.this$0) != null) {
            SurfaceTextureHelper.access$100(this.this$0).onRetainBuffer(textureBufferImpl);
        }
    }
}
