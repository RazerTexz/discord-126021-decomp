package p007b.p452o.p453a.p472w;

import android.graphics.SurfaceTexture;
import android.view.TextureView;

/* JADX INFO: renamed from: b.o.a.w.i */
/* JADX INFO: compiled from: TextureCameraPreview.java */
/* JADX INFO: loaded from: classes3.dex */
public class TextureViewSurfaceTextureListenerC5233i implements TextureView.SurfaceTextureListener {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ C5234j f14241j;

    public TextureViewSurfaceTextureListenerC5233i(C5234j c5234j) {
        this.f14241j = c5234j;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        this.f14241j.m7426f(i, i2);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        this.f14241j.m7427g();
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        this.f14241j.m7428h(i, i2);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }
}
