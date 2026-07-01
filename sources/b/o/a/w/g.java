package b.o.a.w;

import android.view.SurfaceHolder;
import android.view.SurfaceHolder$Callback;

/* JADX INFO: compiled from: SurfaceCameraPreview.java */
/* JADX INFO: loaded from: classes3.dex */
public class g implements SurfaceHolder$Callback {
    public final /* synthetic */ h j;

    public g(h hVar) {
        this.j = hVar;
    }

    @Override // android.view.SurfaceHolder$Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        h.j.a(1, "callback:", "surfaceChanged", "w:", Integer.valueOf(i2), "h:", Integer.valueOf(i3), "dispatched:", Boolean.valueOf(this.j.k));
        h hVar = this.j;
        if (hVar.k) {
            hVar.h(i2, i3);
        } else {
            hVar.f(i2, i3);
            this.j.k = true;
        }
    }

    @Override // android.view.SurfaceHolder$Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        h.j.a(1, "callback: surfaceCreated.");
    }

    @Override // android.view.SurfaceHolder$Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        h.j.a(1, "callback: surfaceDestroyed");
        this.j.g();
        this.j.k = false;
    }
}
