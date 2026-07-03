package p007b.p452o.p453a.p472w;

import android.view.SurfaceHolder;

/* JADX INFO: renamed from: b.o.a.w.g */
/* JADX INFO: compiled from: SurfaceCameraPreview.java */
/* JADX INFO: loaded from: classes3.dex */
public class SurfaceHolderCallbackC5231g implements SurfaceHolder.Callback {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ C5232h f14237j;

    public SurfaceHolderCallbackC5231g(C5232h c5232h) {
        this.f14237j = c5232h;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        C5232h.f14238j.m7159a(1, "callback:", "surfaceChanged", "w:", Integer.valueOf(i2), "h:", Integer.valueOf(i3), "dispatched:", Boolean.valueOf(this.f14237j.f14239k));
        C5232h c5232h = this.f14237j;
        if (c5232h.f14239k) {
            c5232h.m7428h(i2, i3);
        } else {
            c5232h.m7426f(i2, i3);
            this.f14237j.f14239k = true;
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        C5232h.f14238j.m7159a(1, "callback: surfaceCreated.");
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        C5232h.f14238j.m7159a(1, "callback: surfaceDestroyed");
        this.f14237j.m7427g();
        this.f14237j.f14239k = false;
    }
}
