package b.o.a.w;

import android.view.SurfaceHolder;

/* JADX INFO: renamed from: b.o.a.w.g, reason: use source file name */
/* JADX INFO: compiled from: SurfaceCameraPreview.java */
/* JADX INFO: loaded from: classes3.dex */
public class SurfaceCameraPreview implements SurfaceHolder.Callback {
    public final /* synthetic */ SurfaceCameraPreview2 j;

    public SurfaceCameraPreview(SurfaceCameraPreview2 surfaceCameraPreview2) {
        this.j = surfaceCameraPreview2;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        SurfaceCameraPreview2.j.a(1, "callback:", "surfaceChanged", "w:", Integer.valueOf(i2), "h:", Integer.valueOf(i3), "dispatched:", Boolean.valueOf(this.j.k));
        SurfaceCameraPreview2 surfaceCameraPreview2 = this.j;
        if (surfaceCameraPreview2.k) {
            surfaceCameraPreview2.h(i2, i3);
        } else {
            surfaceCameraPreview2.f(i2, i3);
            this.j.k = true;
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        SurfaceCameraPreview2.j.a(1, "callback: surfaceCreated.");
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        SurfaceCameraPreview2.j.a(1, "callback: surfaceDestroyed");
        this.j.g();
        this.j.k = false;
    }
}
