package h0.c;

import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture$OnFrameAvailableListener;
import org.webrtc.SurfaceTextureHelper;

/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class r implements SurfaceTexture$OnFrameAvailableListener {
    public final /* synthetic */ SurfaceTextureHelper j;

    public /* synthetic */ r(SurfaceTextureHelper surfaceTextureHelper) {
        this.j = surfaceTextureHelper;
    }

    @Override // android.graphics.SurfaceTexture$OnFrameAvailableListener
    public final void onFrameAvailable(SurfaceTexture surfaceTexture) {
        this.j.c(surfaceTexture);
    }
}
