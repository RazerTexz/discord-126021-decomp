package com.google.android.exoplayer2.video;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.view.Surface;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import b.c.a.a0.AnimatableValueParser;
import b.i.a.c.f3.Log2;
import b.i.a.c.f3.Util2;
import com.google.android.exoplayer2.util.EGLSurfaceTexture;
import com.google.android.exoplayer2.util.GlUtil;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
@RequiresApi(17)
public final class DummySurface extends Surface {
    public static int j;
    public static boolean k;
    public final boolean l;
    public final b m;
    public boolean n;

    public static class b extends HandlerThread implements Handler.Callback {
        public EGLSurfaceTexture j;
        public Handler k;

        @Nullable
        public Error l;

        @Nullable
        public RuntimeException m;

        @Nullable
        public DummySurface n;

        public b() {
            super("ExoPlayer:DummySurface");
        }

        public final void a(int i) {
            EGLSurface eGLSurfaceEglCreatePbufferSurface;
            Objects.requireNonNull(this.j);
            EGLSurfaceTexture eGLSurfaceTexture = this.j;
            Objects.requireNonNull(eGLSurfaceTexture);
            EGLDisplay eGLDisplayEglGetDisplay = EGL14.eglGetDisplay(0);
            if (eGLDisplayEglGetDisplay == null) {
                throw new EGLSurfaceTexture.GlException("eglGetDisplay failed", null);
            }
            int[] iArr = new int[2];
            if (!EGL14.eglInitialize(eGLDisplayEglGetDisplay, iArr, 0, iArr, 1)) {
                throw new EGLSurfaceTexture.GlException("eglInitialize failed", null);
            }
            eGLSurfaceTexture.m = eGLDisplayEglGetDisplay;
            EGLConfig[] eGLConfigArr = new EGLConfig[1];
            int[] iArr2 = new int[1];
            boolean zEglChooseConfig = EGL14.eglChooseConfig(eGLDisplayEglGetDisplay, EGLSurfaceTexture.j, 0, eGLConfigArr, 0, 1, iArr2, 0);
            if (!zEglChooseConfig || iArr2[0] <= 0 || eGLConfigArr[0] == null) {
                throw new EGLSurfaceTexture.GlException(Util2.k("eglChooseConfig failed: success=%b, numConfigs[0]=%d, configs[0]=%s", Boolean.valueOf(zEglChooseConfig), Integer.valueOf(iArr2[0]), eGLConfigArr[0]), null);
            }
            EGLConfig eGLConfig = eGLConfigArr[0];
            EGLContext eGLContextEglCreateContext = EGL14.eglCreateContext(eGLSurfaceTexture.m, eGLConfig, EGL14.EGL_NO_CONTEXT, i == 0 ? new int[]{12440, 2, 12344} : new int[]{12440, 2, 12992, 1, 12344}, 0);
            if (eGLContextEglCreateContext == null) {
                throw new EGLSurfaceTexture.GlException("eglCreateContext failed", null);
            }
            eGLSurfaceTexture.n = eGLContextEglCreateContext;
            EGLDisplay eGLDisplay = eGLSurfaceTexture.m;
            if (i == 1) {
                eGLSurfaceEglCreatePbufferSurface = EGL14.EGL_NO_SURFACE;
            } else {
                eGLSurfaceEglCreatePbufferSurface = EGL14.eglCreatePbufferSurface(eGLDisplay, eGLConfig, i == 2 ? new int[]{12375, 1, 12374, 1, 12992, 1, 12344} : new int[]{12375, 1, 12374, 1, 12344}, 0);
                if (eGLSurfaceEglCreatePbufferSurface == null) {
                    throw new EGLSurfaceTexture.GlException("eglCreatePbufferSurface failed", null);
                }
            }
            if (!EGL14.eglMakeCurrent(eGLDisplay, eGLSurfaceEglCreatePbufferSurface, eGLSurfaceEglCreatePbufferSurface, eGLContextEglCreateContext)) {
                throw new EGLSurfaceTexture.GlException("eglMakeCurrent failed", null);
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
                if (Util2.a >= 19) {
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

        @Override // android.os.Handler.Callback
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
                            Log2.b("DummySurface", "Failed to release dummy surface", th);
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
                    Log2.b("DummySurface", "Failed to initialize dummy surface", e);
                    this.l = e;
                    synchronized (this) {
                        notify();
                    }
                } catch (RuntimeException e2) {
                    Log2.b("DummySurface", "Failed to initialize dummy surface", e2);
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

    public DummySurface(b bVar, SurfaceTexture surfaceTexture, boolean z2, a aVar) {
        super(surfaceTexture);
        this.m = bVar;
        this.l = z2;
    }

    public static int a(Context context) {
        String strEglQueryString;
        String strEglQueryString2;
        int i = Util2.a;
        boolean z2 = false;
        if (!(i >= 24 && (i >= 26 || !("samsung".equals(Util2.c) || "XT1650".equals(Util2.d))) && ((i >= 26 || context.getPackageManager().hasSystemFeature("android.hardware.vr.high_performance")) && (strEglQueryString2 = EGL14.eglQueryString(EGL14.eglGetDisplay(0), 12373)) != null && strEglQueryString2.contains("EGL_EXT_protected_content")))) {
            return 0;
        }
        if (i >= 17 && (strEglQueryString = EGL14.eglQueryString(EGL14.eglGetDisplay(0), 12373)) != null && strEglQueryString.contains("EGL_KHR_surfaceless_context")) {
            z2 = true;
        }
        return z2 ? 1 : 2;
    }

    public static synchronized boolean b(Context context) {
        if (!k) {
            j = a(context);
            k = true;
        }
        return j != 0;
    }

    public static DummySurface c(Context context, boolean z2) {
        boolean z3 = false;
        AnimatableValueParser.D(!z2 || b(context));
        b bVar = new b();
        int i = z2 ? j : 0;
        bVar.start();
        Handler handler = new Handler(bVar.getLooper(), bVar);
        bVar.k = handler;
        bVar.j = new EGLSurfaceTexture(handler);
        synchronized (bVar) {
            bVar.k.obtainMessage(1, i, 0).sendToTarget();
            while (bVar.n == null && bVar.m == null && bVar.l == null) {
                try {
                    bVar.wait();
                } catch (InterruptedException unused) {
                    z3 = true;
                }
            }
        }
        if (z3) {
            Thread.currentThread().interrupt();
        }
        RuntimeException runtimeException = bVar.m;
        if (runtimeException != null) {
            throw runtimeException;
        }
        Error error = bVar.l;
        if (error != null) {
            throw error;
        }
        DummySurface dummySurface = bVar.n;
        Objects.requireNonNull(dummySurface);
        return dummySurface;
    }

    @Override // android.view.Surface
    public void release() {
        super.release();
        synchronized (this.m) {
            if (!this.n) {
                b bVar = this.m;
                Objects.requireNonNull(bVar.k);
                bVar.k.sendEmptyMessage(2);
                this.n = true;
            }
        }
    }
}
