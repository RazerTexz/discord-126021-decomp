package b.o.a.w;

import android.graphics.SurfaceTexture;
import android.view.TextureView;

/* JADX INFO: renamed from: b.o.a.w.i, reason: use source file name */
/* JADX INFO: compiled from: TextureCameraPreview.java */
/* JADX INFO: loaded from: classes3.dex */
public class TextureCameraPreview implements TextureView.SurfaceTextureListener {
    public final /* synthetic */ TextureCameraPreview2 j;

    public TextureCameraPreview(TextureCameraPreview2 textureCameraPreview2) {
        this.j = textureCameraPreview2;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        this.j.f(i, i2);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        this.j.g();
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        this.j.h(i, i2);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }
}
