package b.o.a.w;

import android.graphics.SurfaceTexture;

/* JADX INFO: compiled from: GlCameraPreview.java */
/* JADX INFO: loaded from: classes3.dex */
public class c$a implements Runnable {
    public final /* synthetic */ c j;

    public c$a(c cVar) {
        this.j = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        d$c d_c = this.j.k;
        SurfaceTexture surfaceTexture = d_c.j.k;
        if (surfaceTexture != null) {
            surfaceTexture.setOnFrameAvailableListener(null);
            d_c.j.k.release();
            d_c.j.k = null;
        }
        b.o.a.r.c cVar = d_c.j.l;
        if (cVar != null) {
            cVar.b();
            d_c.j.l = null;
        }
    }
}
