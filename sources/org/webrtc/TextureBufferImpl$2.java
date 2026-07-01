package org.webrtc;

/* JADX INFO: loaded from: classes3.dex */
public class TextureBufferImpl$2 implements TextureBufferImpl$RefCountMonitor {
    public final /* synthetic */ TextureBufferImpl this$0;

    public TextureBufferImpl$2(TextureBufferImpl textureBufferImpl) {
        this.this$0 = textureBufferImpl;
    }

    @Override // org.webrtc.TextureBufferImpl$RefCountMonitor
    public void onDestroy(TextureBufferImpl textureBufferImpl) {
        this.this$0.release();
    }

    @Override // org.webrtc.TextureBufferImpl$RefCountMonitor
    public void onRelease(TextureBufferImpl textureBufferImpl) {
        TextureBufferImpl.access$000(this.this$0).onRelease(this.this$0);
    }

    @Override // org.webrtc.TextureBufferImpl$RefCountMonitor
    public void onRetain(TextureBufferImpl textureBufferImpl) {
        TextureBufferImpl.access$000(this.this$0).onRetain(this.this$0);
    }
}
