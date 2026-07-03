package com.google.android.exoplayer2.util;

import android.graphics.SurfaceTexture;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.os.Handler;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes3.dex */
@RequiresApi(17)
public final class EGLSurfaceTexture implements SurfaceTexture.OnFrameAvailableListener, Runnable {

    /* JADX INFO: renamed from: j */
    public static final int[] f20273j = {12352, 4, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 0, 12327, 12344, 12339, 4, 12344};

    /* JADX INFO: renamed from: k */
    public final Handler f20274k;

    /* JADX INFO: renamed from: l */
    public final int[] f20275l = new int[1];

    /* JADX INFO: renamed from: m */
    @Nullable
    public EGLDisplay f20276m;

    /* JADX INFO: renamed from: n */
    @Nullable
    public EGLContext f20277n;

    /* JADX INFO: renamed from: o */
    @Nullable
    public EGLSurface f20278o;

    /* JADX INFO: renamed from: p */
    @Nullable
    public SurfaceTexture f20279p;

    public static final class GlException extends RuntimeException {
        public GlException(String str, C10775a c10775a) {
            super(str);
        }
    }

    public EGLSurfaceTexture(Handler handler) {
        this.f20274k = handler;
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        this.f20274k.post(this);
    }

    @Override // java.lang.Runnable
    public void run() {
        SurfaceTexture surfaceTexture = this.f20279p;
        if (surfaceTexture != null) {
            try {
                surfaceTexture.updateTexImage();
            } catch (RuntimeException unused) {
            }
        }
    }
}
