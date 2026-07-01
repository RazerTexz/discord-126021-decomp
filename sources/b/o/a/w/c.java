package b.o.a.w;

import android.opengl.GLSurfaceView;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder$Callback;

/* JADX INFO: compiled from: GlCameraPreview.java */
/* JADX INFO: loaded from: classes3.dex */
public class c implements SurfaceHolder$Callback {
    public final /* synthetic */ GLSurfaceView j;
    public final /* synthetic */ d$c k;
    public final /* synthetic */ d l;

    public c(d dVar, GLSurfaceView gLSurfaceView, d$c d_c) {
        this.l = dVar;
        this.j = gLSurfaceView;
        this.k = d_c;
    }

    @Override // android.view.SurfaceHolder$Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
    }

    @Override // android.view.SurfaceHolder$Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
    }

    @Override // android.view.SurfaceHolder$Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.l.g();
        this.j.queueEvent(new c$a(this));
        this.l.j = false;
    }
}
