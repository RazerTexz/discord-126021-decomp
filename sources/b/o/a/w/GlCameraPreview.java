package b.o.a.w;

import android.graphics.SurfaceTexture;
import android.opengl.GLSurfaceView;
import android.view.SurfaceHolder;
import b.o.a.r.GlTextureDrawer;
import b.o.a.w.GlCameraPreview2;

/* JADX INFO: renamed from: b.o.a.w.c, reason: use source file name */
/* JADX INFO: compiled from: GlCameraPreview.java */
/* JADX INFO: loaded from: classes3.dex */
public class GlCameraPreview implements SurfaceHolder.Callback {
    public final /* synthetic */ GLSurfaceView j;
    public final /* synthetic */ GlCameraPreview2.c k;
    public final /* synthetic */ GlCameraPreview2 l;

    /* JADX INFO: renamed from: b.o.a.w.c$a */
    /* JADX INFO: compiled from: GlCameraPreview.java */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            GlCameraPreview2.c cVar = GlCameraPreview.this.k;
            SurfaceTexture surfaceTexture = GlCameraPreview2.this.k;
            if (surfaceTexture != null) {
                surfaceTexture.setOnFrameAvailableListener(null);
                GlCameraPreview2.this.k.release();
                GlCameraPreview2.this.k = null;
            }
            GlTextureDrawer glTextureDrawer = GlCameraPreview2.this.l;
            if (glTextureDrawer != null) {
                glTextureDrawer.b();
                GlCameraPreview2.this.l = null;
            }
        }
    }

    public GlCameraPreview(GlCameraPreview2 glCameraPreview2, GLSurfaceView gLSurfaceView, GlCameraPreview2.c cVar) {
        this.l = glCameraPreview2;
        this.j = gLSurfaceView;
        this.k = cVar;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.l.g();
        this.j.queueEvent(new a());
        this.l.j = false;
    }
}
