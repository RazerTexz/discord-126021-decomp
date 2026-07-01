package b.o.a.w;

import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture$OnFrameAvailableListener;
import android.opengl.GLSurfaceView;

/* JADX INFO: compiled from: GlCameraPreview.java */
/* JADX INFO: loaded from: classes3.dex */
public class d$c$b implements SurfaceTexture$OnFrameAvailableListener {
    public final /* synthetic */ d$c j;

    public d$c$b(d$c d_c) {
        this.j = d_c;
    }

    @Override // android.graphics.SurfaceTexture$OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        ((GLSurfaceView) this.j.j.c).requestRender();
    }
}
