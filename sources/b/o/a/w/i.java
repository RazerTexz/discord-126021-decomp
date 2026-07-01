package b.o.a.w;

import android.graphics.SurfaceTexture;
import android.view.TextureView$SurfaceTextureListener;

/* JADX INFO: compiled from: TextureCameraPreview.java */
/* JADX INFO: loaded from: classes3.dex */
public class i implements TextureView$SurfaceTextureListener {
    public final /* synthetic */ j j;

    public i(j jVar) {
        this.j = jVar;
    }

    @Override // android.view.TextureView$SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        this.j.f(i, i2);
    }

    @Override // android.view.TextureView$SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        this.j.g();
        return true;
    }

    @Override // android.view.TextureView$SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        this.j.h(i, i2);
    }

    @Override // android.view.TextureView$SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }
}
