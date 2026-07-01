package com.google.android.exoplayer2.util;

import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture$OnFrameAvailableListener;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.os.Handler;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes3.dex */
@RequiresApi(17)
public final class EGLSurfaceTexture implements SurfaceTexture$OnFrameAvailableListener, Runnable {
    public static final int[] j = {12352, 4, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 0, 12327, 12344, 12339, 4, 12344};
    public final Handler k;
    public final int[] l = new int[1];

    @Nullable
    public EGLDisplay m;

    @Nullable
    public EGLContext n;

    @Nullable
    public EGLSurface o;

    @Nullable
    public SurfaceTexture p;

    public EGLSurfaceTexture(Handler handler) {
        this.k = handler;
    }

    @Override // android.graphics.SurfaceTexture$OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        this.k.post(this);
    }

    @Override // java.lang.Runnable
    public void run() {
        SurfaceTexture surfaceTexture = this.p;
        if (surfaceTexture != null) {
            try {
                surfaceTexture.updateTexImage();
            } catch (RuntimeException unused) {
            }
        }
    }
}
