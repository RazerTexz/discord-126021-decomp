package com.google.android.exoplayer2.video;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.os.Handler;
import android.view.Surface;
import androidx.annotation.RequiresApi;
import b.c.a.a0.d;
import b.i.a.c.f3.e0;
import com.google.android.exoplayer2.util.EGLSurfaceTexture;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
@RequiresApi(17)
public final class DummySurface extends Surface {
    public static int j;
    public static boolean k;
    public final boolean l;
    public final DummySurface$b m;
    public boolean n;

    public DummySurface(DummySurface$b dummySurface$b, SurfaceTexture surfaceTexture, boolean z2, DummySurface$a dummySurface$a) {
        super(surfaceTexture);
        this.m = dummySurface$b;
        this.l = z2;
    }

    public static int a(Context context) {
        String strEglQueryString;
        String strEglQueryString2;
        int i = e0.a;
        boolean z2 = false;
        if (!(i >= 24 && (i >= 26 || !("samsung".equals(e0.c) || "XT1650".equals(e0.d))) && ((i >= 26 || context.getPackageManager().hasSystemFeature("android.hardware.vr.high_performance")) && (strEglQueryString2 = EGL14.eglQueryString(EGL14.eglGetDisplay(0), 12373)) != null && strEglQueryString2.contains("EGL_EXT_protected_content")))) {
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
        d.D(!z2 || b(context));
        DummySurface$b dummySurface$b = new DummySurface$b();
        int i = z2 ? j : 0;
        dummySurface$b.start();
        Handler handler = new Handler(dummySurface$b.getLooper(), dummySurface$b);
        dummySurface$b.k = handler;
        dummySurface$b.j = new EGLSurfaceTexture(handler);
        synchronized (dummySurface$b) {
            dummySurface$b.k.obtainMessage(1, i, 0).sendToTarget();
            while (dummySurface$b.n == null && dummySurface$b.m == null && dummySurface$b.l == null) {
                try {
                    dummySurface$b.wait();
                } catch (InterruptedException unused) {
                    z3 = true;
                }
            }
        }
        if (z3) {
            Thread.currentThread().interrupt();
        }
        RuntimeException runtimeException = dummySurface$b.m;
        if (runtimeException != null) {
            throw runtimeException;
        }
        Error error = dummySurface$b.l;
        if (error != null) {
            throw error;
        }
        DummySurface dummySurface = dummySurface$b.n;
        Objects.requireNonNull(dummySurface);
        return dummySurface;
    }

    @Override // android.view.Surface
    public void release() {
        super.release();
        synchronized (this.m) {
            if (!this.n) {
                DummySurface$b dummySurface$b = this.m;
                Objects.requireNonNull(dummySurface$b.k);
                dummySurface$b.k.sendEmptyMessage(2);
                this.n = true;
            }
        }
    }
}
