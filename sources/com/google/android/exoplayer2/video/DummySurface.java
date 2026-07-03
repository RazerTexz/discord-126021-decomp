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
import com.google.android.exoplayer2.util.EGLSurfaceTexture;
import com.google.android.exoplayer2.util.GlUtil;
import java.util.Objects;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p225i.p226a.p242c.p259f3.C2738e0;
import p007b.p225i.p226a.p242c.p259f3.C2750q;

/* JADX INFO: loaded from: classes3.dex */
@RequiresApi(17)
public final class DummySurface extends Surface {

    /* JADX INFO: renamed from: j */
    public static int f20281j;

    /* JADX INFO: renamed from: k */
    public static boolean f20282k;

    /* JADX INFO: renamed from: l */
    public final boolean f20283l;

    /* JADX INFO: renamed from: m */
    public final HandlerThreadC10778b f20284m;

    /* JADX INFO: renamed from: n */
    public boolean f20285n;

    /* JADX INFO: renamed from: com.google.android.exoplayer2.video.DummySurface$b */
    public static class HandlerThreadC10778b extends HandlerThread implements Handler.Callback {

        /* JADX INFO: renamed from: j */
        public EGLSurfaceTexture f20286j;

        /* JADX INFO: renamed from: k */
        public Handler f20287k;

        /* JADX INFO: renamed from: l */
        @Nullable
        public Error f20288l;

        /* JADX INFO: renamed from: m */
        @Nullable
        public RuntimeException f20289m;

        /* JADX INFO: renamed from: n */
        @Nullable
        public DummySurface f20290n;

        public HandlerThreadC10778b() {
            super("ExoPlayer:DummySurface");
        }

        /* JADX INFO: renamed from: a */
        public final void m8953a(int i) {
            EGLSurface eGLSurfaceEglCreatePbufferSurface;
            Objects.requireNonNull(this.f20286j);
            EGLSurfaceTexture eGLSurfaceTexture = this.f20286j;
            Objects.requireNonNull(eGLSurfaceTexture);
            EGLDisplay eGLDisplayEglGetDisplay = EGL14.eglGetDisplay(0);
            if (eGLDisplayEglGetDisplay == null) {
                throw new EGLSurfaceTexture.GlException("eglGetDisplay failed", null);
            }
            int[] iArr = new int[2];
            if (!EGL14.eglInitialize(eGLDisplayEglGetDisplay, iArr, 0, iArr, 1)) {
                throw new EGLSurfaceTexture.GlException("eglInitialize failed", null);
            }
            eGLSurfaceTexture.f20276m = eGLDisplayEglGetDisplay;
            EGLConfig[] eGLConfigArr = new EGLConfig[1];
            int[] iArr2 = new int[1];
            boolean zEglChooseConfig = EGL14.eglChooseConfig(eGLDisplayEglGetDisplay, EGLSurfaceTexture.f20273j, 0, eGLConfigArr, 0, 1, iArr2, 0);
            if (!zEglChooseConfig || iArr2[0] <= 0 || eGLConfigArr[0] == null) {
                throw new EGLSurfaceTexture.GlException(C2738e0.m3003k("eglChooseConfig failed: success=%b, numConfigs[0]=%d, configs[0]=%s", Boolean.valueOf(zEglChooseConfig), Integer.valueOf(iArr2[0]), eGLConfigArr[0]), null);
            }
            EGLConfig eGLConfig = eGLConfigArr[0];
            EGLContext eGLContextEglCreateContext = EGL14.eglCreateContext(eGLSurfaceTexture.f20276m, eGLConfig, EGL14.EGL_NO_CONTEXT, i == 0 ? new int[]{12440, 2, 12344} : new int[]{12440, 2, 12992, 1, 12344}, 0);
            if (eGLContextEglCreateContext == null) {
                throw new EGLSurfaceTexture.GlException("eglCreateContext failed", null);
            }
            eGLSurfaceTexture.f20277n = eGLContextEglCreateContext;
            EGLDisplay eGLDisplay = eGLSurfaceTexture.f20276m;
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
            eGLSurfaceTexture.f20278o = eGLSurfaceEglCreatePbufferSurface;
            GLES20.glGenTextures(1, eGLSurfaceTexture.f20275l, 0);
            GlUtil.m8945a();
            SurfaceTexture surfaceTexture = new SurfaceTexture(eGLSurfaceTexture.f20275l[0]);
            eGLSurfaceTexture.f20279p = surfaceTexture;
            surfaceTexture.setOnFrameAvailableListener(eGLSurfaceTexture);
            SurfaceTexture surfaceTexture2 = this.f20286j.f20279p;
            Objects.requireNonNull(surfaceTexture2);
            this.f20290n = new DummySurface(this, surfaceTexture2, i != 0, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX INFO: renamed from: b */
        public final void m8954b() {
            Objects.requireNonNull(this.f20286j);
            EGLSurfaceTexture eGLSurfaceTexture = this.f20286j;
            eGLSurfaceTexture.f20274k.removeCallbacks(eGLSurfaceTexture);
            try {
                SurfaceTexture surfaceTexture = eGLSurfaceTexture.f20279p;
                if (surfaceTexture != null) {
                    surfaceTexture.release();
                    GLES20.glDeleteTextures(1, eGLSurfaceTexture.f20275l, 0);
                }
            } finally {
                EGLDisplay eGLDisplay = eGLSurfaceTexture.f20276m;
                if (eGLDisplay != null && !eGLDisplay.equals(EGL14.EGL_NO_DISPLAY)) {
                    EGLDisplay eGLDisplay2 = eGLSurfaceTexture.f20276m;
                    EGLSurface eGLSurface = EGL14.EGL_NO_SURFACE;
                    EGL14.eglMakeCurrent(eGLDisplay2, eGLSurface, eGLSurface, EGL14.EGL_NO_CONTEXT);
                }
                EGLSurface eGLSurface2 = eGLSurfaceTexture.f20278o;
                if (eGLSurface2 != null && !eGLSurface2.equals(EGL14.EGL_NO_SURFACE)) {
                    EGL14.eglDestroySurface(eGLSurfaceTexture.f20276m, eGLSurfaceTexture.f20278o);
                }
                EGLContext eGLContext = eGLSurfaceTexture.f20277n;
                if (eGLContext != null) {
                    EGL14.eglDestroyContext(eGLSurfaceTexture.f20276m, eGLContext);
                }
                if (C2738e0.f6708a >= 19) {
                    EGL14.eglReleaseThread();
                }
                EGLDisplay eGLDisplay3 = eGLSurfaceTexture.f20276m;
                if (eGLDisplay3 != null && !eGLDisplay3.equals(EGL14.EGL_NO_DISPLAY)) {
                    EGL14.eglTerminate(eGLSurfaceTexture.f20276m);
                }
                eGLSurfaceTexture.f20276m = null;
                eGLSurfaceTexture.f20277n = null;
                eGLSurfaceTexture.f20278o = null;
                eGLSurfaceTexture.f20279p = null;
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
                        m8954b();
                    } catch (Throwable th) {
                        try {
                            C2750q.m3039b("DummySurface", "Failed to release dummy surface", th);
                        } finally {
                            quit();
                        }
                    }
                    return true;
                }
                try {
                    m8953a(message.arg1);
                    synchronized (this) {
                        notify();
                    }
                } catch (Error e) {
                    C2750q.m3039b("DummySurface", "Failed to initialize dummy surface", e);
                    this.f20288l = e;
                    synchronized (this) {
                        notify();
                    }
                } catch (RuntimeException e2) {
                    C2750q.m3039b("DummySurface", "Failed to initialize dummy surface", e2);
                    this.f20289m = e2;
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

    public DummySurface(HandlerThreadC10778b handlerThreadC10778b, SurfaceTexture surfaceTexture, boolean z2, C10777a c10777a) {
        super(surfaceTexture);
        this.f20284m = handlerThreadC10778b;
        this.f20283l = z2;
    }

    /* JADX INFO: renamed from: a */
    public static int m8950a(Context context) {
        String strEglQueryString;
        String strEglQueryString2;
        int i = C2738e0.f6708a;
        boolean z2 = false;
        if (!(i >= 24 && (i >= 26 || !("samsung".equals(C2738e0.f6710c) || "XT1650".equals(C2738e0.f6711d))) && ((i >= 26 || context.getPackageManager().hasSystemFeature("android.hardware.vr.high_performance")) && (strEglQueryString2 = EGL14.eglQueryString(EGL14.eglGetDisplay(0), 12373)) != null && strEglQueryString2.contains("EGL_EXT_protected_content")))) {
            return 0;
        }
        if (i >= 17 && (strEglQueryString = EGL14.eglQueryString(EGL14.eglGetDisplay(0), 12373)) != null && strEglQueryString.contains("EGL_KHR_surfaceless_context")) {
            z2 = true;
        }
        return z2 ? 1 : 2;
    }

    /* JADX INFO: renamed from: b */
    public static synchronized boolean m8951b(Context context) {
        if (!f20282k) {
            f20281j = m8950a(context);
            f20282k = true;
        }
        return f20281j != 0;
    }

    /* JADX INFO: renamed from: c */
    public static DummySurface m8952c(Context context, boolean z2) {
        boolean z3 = false;
        C1460d.m426D(!z2 || m8951b(context));
        HandlerThreadC10778b handlerThreadC10778b = new HandlerThreadC10778b();
        int i = z2 ? f20281j : 0;
        handlerThreadC10778b.start();
        Handler handler = new Handler(handlerThreadC10778b.getLooper(), handlerThreadC10778b);
        handlerThreadC10778b.f20287k = handler;
        handlerThreadC10778b.f20286j = new EGLSurfaceTexture(handler);
        synchronized (handlerThreadC10778b) {
            handlerThreadC10778b.f20287k.obtainMessage(1, i, 0).sendToTarget();
            while (handlerThreadC10778b.f20290n == null && handlerThreadC10778b.f20289m == null && handlerThreadC10778b.f20288l == null) {
                try {
                    handlerThreadC10778b.wait();
                } catch (InterruptedException unused) {
                    z3 = true;
                }
            }
        }
        if (z3) {
            Thread.currentThread().interrupt();
        }
        RuntimeException runtimeException = handlerThreadC10778b.f20289m;
        if (runtimeException != null) {
            throw runtimeException;
        }
        Error error = handlerThreadC10778b.f20288l;
        if (error != null) {
            throw error;
        }
        DummySurface dummySurface = handlerThreadC10778b.f20290n;
        Objects.requireNonNull(dummySurface);
        return dummySurface;
    }

    @Override // android.view.Surface
    public void release() {
        super.release();
        synchronized (this.f20284m) {
            if (!this.f20285n) {
                HandlerThreadC10778b handlerThreadC10778b = this.f20284m;
                Objects.requireNonNull(handlerThreadC10778b.f20287k);
                handlerThreadC10778b.f20287k.sendEmptyMessage(2);
                this.f20285n = true;
            }
        }
    }
}
