package com.google.android.exoplayer2.video;

import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.os.Handler;
import android.os.Handler$Callback;
import android.os.HandlerThread;
import android.os.Message;
import androidx.annotation.Nullable;
import b.i.a.c.f3.e0;
import b.i.a.c.f3.q;
import com.google.android.exoplayer2.util.EGLSurfaceTexture;
import com.google.android.exoplayer2.util.EGLSurfaceTexture$GlException;
import com.google.android.exoplayer2.util.GlUtil;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public class DummySurface$b extends HandlerThread implements Handler$Callback {
    public EGLSurfaceTexture j;
    public Handler k;

    @Nullable
    public Error l;

    @Nullable
    public RuntimeException m;

    @Nullable
    public DummySurface n;

    public DummySurface$b() {
        super("ExoPlayer:DummySurface");
    }

    public final void a(int i) {
        EGLSurface eGLSurfaceEglCreatePbufferSurface;
        Objects.requireNonNull(this.j);
        EGLSurfaceTexture eGLSurfaceTexture = this.j;
        Objects.requireNonNull(eGLSurfaceTexture);
        EGLDisplay eGLDisplayEglGetDisplay = EGL14.eglGetDisplay(0);
        if (eGLDisplayEglGetDisplay == null) {
            throw new EGLSurfaceTexture$GlException("eglGetDisplay failed", null);
        }
        int[] iArr = new int[2];
        if (!EGL14.eglInitialize(eGLDisplayEglGetDisplay, iArr, 0, iArr, 1)) {
            throw new EGLSurfaceTexture$GlException("eglInitialize failed", null);
        }
        eGLSurfaceTexture.m = eGLDisplayEglGetDisplay;
        EGLConfig[] eGLConfigArr = new EGLConfig[1];
        int[] iArr2 = new int[1];
        boolean zEglChooseConfig = EGL14.eglChooseConfig(eGLDisplayEglGetDisplay, EGLSurfaceTexture.j, 0, eGLConfigArr, 0, 1, iArr2, 0);
        if (!zEglChooseConfig || iArr2[0] <= 0 || eGLConfigArr[0] == null) {
            throw new EGLSurfaceTexture$GlException(e0.k("eglChooseConfig failed: success=%b, numConfigs[0]=%d, configs[0]=%s", Boolean.valueOf(zEglChooseConfig), Integer.valueOf(iArr2[0]), eGLConfigArr[0]), null);
        }
        EGLConfig eGLConfig = eGLConfigArr[0];
        EGLContext eGLContextEglCreateContext = EGL14.eglCreateContext(eGLSurfaceTexture.m, eGLConfig, EGL14.EGL_NO_CONTEXT, i == 0 ? new int[]{12440, 2, 12344} : new int[]{12440, 2, 12992, 1, 12344}, 0);
        if (eGLContextEglCreateContext == null) {
            throw new EGLSurfaceTexture$GlException("eglCreateContext failed", null);
        }
        eGLSurfaceTexture.n = eGLContextEglCreateContext;
        EGLDisplay eGLDisplay = eGLSurfaceTexture.m;
        if (i == 1) {
            eGLSurfaceEglCreatePbufferSurface = EGL14.EGL_NO_SURFACE;
        } else {
            eGLSurfaceEglCreatePbufferSurface = EGL14.eglCreatePbufferSurface(eGLDisplay, eGLConfig, i == 2 ? new int[]{12375, 1, 12374, 1, 12992, 1, 12344} : new int[]{12375, 1, 12374, 1, 12344}, 0);
            if (eGLSurfaceEglCreatePbufferSurface == null) {
                throw new EGLSurfaceTexture$GlException("eglCreatePbufferSurface failed", null);
            }
        }
        if (!EGL14.eglMakeCurrent(eGLDisplay, eGLSurfaceEglCreatePbufferSurface, eGLSurfaceEglCreatePbufferSurface, eGLContextEglCreateContext)) {
            throw new EGLSurfaceTexture$GlException("eglMakeCurrent failed", null);
        }
        eGLSurfaceTexture.o = eGLSurfaceEglCreatePbufferSurface;
        GLES20.glGenTextures(1, eGLSurfaceTexture.l, 0);
        GlUtil.a();
        SurfaceTexture surfaceTexture = new SurfaceTexture(eGLSurfaceTexture.l[0]);
        eGLSurfaceTexture.p = surfaceTexture;
        surfaceTexture.setOnFrameAvailableListener(eGLSurfaceTexture);
        SurfaceTexture surfaceTexture2 = this.j.p;
        Objects.requireNonNull(surfaceTexture2);
        this.n = new DummySurface(this, surfaceTexture2, i != 0, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void b() {
        Objects.requireNonNull(this.j);
        EGLSurfaceTexture eGLSurfaceTexture = this.j;
        eGLSurfaceTexture.k.removeCallbacks(eGLSurfaceTexture);
        try {
            SurfaceTexture surfaceTexture = eGLSurfaceTexture.p;
            if (surfaceTexture != null) {
                surfaceTexture.release();
                GLES20.glDeleteTextures(1, eGLSurfaceTexture.l, 0);
            }
        } finally {
            EGLDisplay eGLDisplay = eGLSurfaceTexture.m;
            if (eGLDisplay != null && !eGLDisplay.equals(EGL14.EGL_NO_DISPLAY)) {
                EGLDisplay eGLDisplay2 = eGLSurfaceTexture.m;
                EGLSurface eGLSurface = EGL14.EGL_NO_SURFACE;
                EGL14.eglMakeCurrent(eGLDisplay2, eGLSurface, eGLSurface, EGL14.EGL_NO_CONTEXT);
            }
            EGLSurface eGLSurface2 = eGLSurfaceTexture.o;
            if (eGLSurface2 != null && !eGLSurface2.equals(EGL14.EGL_NO_SURFACE)) {
                EGL14.eglDestroySurface(eGLSurfaceTexture.m, eGLSurfaceTexture.o);
            }
            EGLContext eGLContext = eGLSurfaceTexture.n;
            if (eGLContext != null) {
                EGL14.eglDestroyContext(eGLSurfaceTexture.m, eGLContext);
            }
            if (e0.a >= 19) {
                EGL14.eglReleaseThread();
            }
            EGLDisplay eGLDisplay3 = eGLSurfaceTexture.m;
            if (eGLDisplay3 != null && !eGLDisplay3.equals(EGL14.EGL_NO_DISPLAY)) {
                EGL14.eglTerminate(eGLSurfaceTexture.m);
            }
            eGLSurfaceTexture.m = null;
            eGLSurfaceTexture.n = null;
            eGLSurfaceTexture.o = null;
            eGLSurfaceTexture.p = null;
        }
    }

    @Override // android.os.Handler$Callback
    public boolean handleMessage(Message message) {
        int i = message.what;
        try {
            if (i != 1) {
                if (i != 2) {
                    return true;
                }
                try {
                    b();
                } catch (Throwable th) {
                    try {
                        q.b("DummySurface", "Failed to release dummy surface", th);
                    } finally {
                        quit();
                    }
                }
                return true;
            }
            try {
                a(message.arg1);
                synchronized (this) {
                    notify();
                }
            } catch (Error e) {
                q.b("DummySurface", "Failed to initialize dummy surface", e);
                this.l = e;
                synchronized (this) {
                    notify();
                }
            } catch (RuntimeException e2) {
                q.b("DummySurface", "Failed to initialize dummy surface", e2);
                this.m = e2;
                synchronized (this) {
                    notify();
                }
            }
            return true;
        } catch (Throwable th2) {
            synchronized (this) {
                notify();
                throw th2;
            }
        }
    }
}
