package h0.c;

import java.util.Objects;
import org.webrtc.TextureBufferImpl;
import org.webrtc.TextureBufferImpl$RefCountMonitor;

/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class z implements Runnable {
    public final /* synthetic */ TextureBufferImpl j;
    public final /* synthetic */ TextureBufferImpl$RefCountMonitor k;

    public /* synthetic */ z(TextureBufferImpl textureBufferImpl, TextureBufferImpl$RefCountMonitor textureBufferImpl$RefCountMonitor) {
        this.j = textureBufferImpl;
        this.k = textureBufferImpl$RefCountMonitor;
    }

    @Override // java.lang.Runnable
    public final void run() {
        TextureBufferImpl textureBufferImpl = this.j;
        TextureBufferImpl$RefCountMonitor textureBufferImpl$RefCountMonitor = this.k;
        Objects.requireNonNull(textureBufferImpl);
        textureBufferImpl$RefCountMonitor.onDestroy(textureBufferImpl);
    }
}
