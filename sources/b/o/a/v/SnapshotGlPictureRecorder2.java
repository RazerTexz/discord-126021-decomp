package b.o.a.v;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.os.Build;
import android.util.Log;
import android.view.Surface;
import b.o.a.PictureResult;
import b.o.a.r.GlTextureDrawer;
import b.o.a.u.Overlay;
import b.o.a.u.OverlayDrawer;
import b.o.a.u.OverlayLayout;
import b.o.a.x.Size3;
import b.o.b.a.EglCore;
import b.o.b.c.egl2;
import b.o.b.c.egl3;
import b.o.b.c.egl4;
import b.o.b.c.egl5;
import b.o.b.e.EglWindowSurface;
import d0.y.Closeable;
import d0.z.d.Intrinsics3;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Objects;

/* JADX INFO: renamed from: b.o.a.v.h, reason: use source file name */
/* JADX INFO: compiled from: SnapshotGlPictureRecorder.java */
/* JADX INFO: loaded from: classes3.dex */
public class SnapshotGlPictureRecorder2 implements Runnable {
    public final /* synthetic */ SurfaceTexture j;
    public final /* synthetic */ int k;
    public final /* synthetic */ float l;
    public final /* synthetic */ float m;
    public final /* synthetic */ EGLContext n;
    public final /* synthetic */ SnapshotGlPictureRecorder o;

    public SnapshotGlPictureRecorder2(SnapshotGlPictureRecorder snapshotGlPictureRecorder, SurfaceTexture surfaceTexture, int i, float f, float f2, EGLContext eGLContext) {
        this.o = snapshotGlPictureRecorder;
        this.j = surfaceTexture;
        this.k = i;
        this.l = f;
        this.m = f2;
        this.n = eGLContext;
    }

    @Override // java.lang.Runnable
    public void run() throws IOException {
        SnapshotGlPictureRecorder snapshotGlPictureRecorder = this.o;
        SurfaceTexture surfaceTexture = this.j;
        int i = this.k;
        float f = this.l;
        float f2 = this.m;
        EGLContext eGLContext = this.n;
        Objects.requireNonNull(snapshotGlPictureRecorder);
        SurfaceTexture surfaceTexture2 = new SurfaceTexture(9999);
        Size3 size3 = snapshotGlPictureRecorder.j.d;
        surfaceTexture2.setDefaultBufferSize(size3.j, size3.k);
        EglCore eglCore = new EglCore(eGLContext, 1);
        EglWindowSurface eglWindowSurface = new EglWindowSurface(eglCore, surfaceTexture2);
        EglCore eglCore2 = eglWindowSurface.a;
        egl5 egl5Var = eglWindowSurface.f1967b;
        Objects.requireNonNull(eglCore2);
        Intrinsics3.checkNotNullParameter(egl5Var, "eglSurface");
        if (eglCore2.a == egl4.f1961b) {
            Log.v("EglCore", "NOTE: makeSurfaceCurrent w/o display");
        }
        egl3 egl3Var = eglCore2.a;
        egl2 egl2Var = eglCore2.f1959b;
        EGLDisplay eGLDisplay = egl3Var.a;
        EGLSurface eGLSurface = egl5Var.a;
        if (!EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, egl2Var.a)) {
            throw new RuntimeException("eglMakeCurrent failed");
        }
        float[] fArr = snapshotGlPictureRecorder.f1956s.f1950b;
        surfaceTexture.getTransformMatrix(fArr);
        Matrix.translateM(fArr, 0, (1.0f - f) / 2.0f, (1.0f - f2) / 2.0f, 0.0f);
        Matrix.scaleM(fArr, 0, f, f2, 1.0f);
        Matrix.translateM(fArr, 0, 0.5f, 0.5f, 0.0f);
        Matrix.rotateM(fArr, 0, i + snapshotGlPictureRecorder.j.c, 0.0f, 0.0f, 1.0f);
        Matrix.scaleM(fArr, 0, 1.0f, -1.0f, 1.0f);
        Matrix.translateM(fArr, 0, -0.5f, -0.5f, 0.0f);
        if (snapshotGlPictureRecorder.q) {
            OverlayDrawer overlayDrawer = snapshotGlPictureRecorder.r;
            Overlay.a aVar = Overlay.a.PICTURE_SNAPSHOT;
            Objects.requireNonNull(overlayDrawer);
            try {
                Canvas canvasLockCanvas = (Build.VERSION.SDK_INT < 23 || !((OverlayLayout) overlayDrawer.f1953b).getHardwareCanvasEnabled()) ? overlayDrawer.d.lockCanvas(null) : overlayDrawer.d.lockHardwareCanvas();
                canvasLockCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
                ((OverlayLayout) overlayDrawer.f1953b).a(aVar, canvasLockCanvas);
                overlayDrawer.d.unlockCanvasAndPost(canvasLockCanvas);
            } catch (Surface.OutOfResourcesException e) {
                OverlayDrawer.a.a(2, "Got Surface.OutOfResourcesException while drawing video overlays", e);
            }
            synchronized (overlayDrawer.g) {
                GLES20.glBindTexture(36197, overlayDrawer.f.a);
                overlayDrawer.c.updateTexImage();
            }
            overlayDrawer.c.getTransformMatrix(overlayDrawer.e.f1950b);
            Matrix.translateM(snapshotGlPictureRecorder.r.e.f1950b, 0, 0.5f, 0.5f, 0.0f);
            Matrix.rotateM(snapshotGlPictureRecorder.r.e.f1950b, 0, snapshotGlPictureRecorder.j.c, 0.0f, 0.0f, 1.0f);
            Matrix.scaleM(snapshotGlPictureRecorder.r.e.f1950b, 0, 1.0f, -1.0f, 1.0f);
            Matrix.translateM(snapshotGlPictureRecorder.r.e.f1950b, 0, -0.5f, -0.5f, 0.0f);
        }
        snapshotGlPictureRecorder.j.c = 0;
        long timestamp = surfaceTexture.getTimestamp() / 1000;
        SnapshotPictureRecorder.m.a(1, "takeFrame:", "timestampUs:", Long.valueOf(timestamp));
        snapshotGlPictureRecorder.f1956s.a(timestamp);
        if (snapshotGlPictureRecorder.q) {
            OverlayDrawer overlayDrawer2 = snapshotGlPictureRecorder.r;
            Objects.requireNonNull(overlayDrawer2);
            GLES20.glDisable(2884);
            GLES20.glDisable(2929);
            GLES20.glEnable(3042);
            GLES20.glBlendFunc(770, 771);
            synchronized (overlayDrawer2.g) {
                overlayDrawer2.e.a(timestamp);
            }
        }
        PictureResult.a aVar2 = snapshotGlPictureRecorder.j;
        Bitmap.CompressFormat compressFormat = Bitmap.CompressFormat.JPEG;
        Intrinsics3.checkNotNullParameter(compressFormat, "format");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            eglWindowSurface.a(byteArrayOutputStream, compressFormat);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            Intrinsics3.checkNotNullExpressionValue(byteArray, "it.toByteArray()");
            Closeable.closeFinally(byteArrayOutputStream, null);
            aVar2.f = byteArray;
            EglCore eglCore3 = eglWindowSurface.a;
            egl5 egl5Var2 = eglWindowSurface.f1967b;
            Objects.requireNonNull(eglCore3);
            Intrinsics3.checkNotNullParameter(egl5Var2, "eglSurface");
            EGL14.eglDestroySurface(eglCore3.a.a, egl5Var2.a);
            eglWindowSurface.f1967b = egl4.c;
            eglWindowSurface.d = -1;
            eglWindowSurface.c = -1;
            snapshotGlPictureRecorder.f1956s.b();
            surfaceTexture2.release();
            if (snapshotGlPictureRecorder.q) {
                OverlayDrawer overlayDrawer3 = snapshotGlPictureRecorder.r;
                if (overlayDrawer3.f != null) {
                    GLES20.glBindTexture(36197, 0);
                    overlayDrawer3.f = null;
                }
                SurfaceTexture surfaceTexture3 = overlayDrawer3.c;
                if (surfaceTexture3 != null) {
                    surfaceTexture3.release();
                    overlayDrawer3.c = null;
                }
                Surface surface = overlayDrawer3.d;
                if (surface != null) {
                    surface.release();
                    overlayDrawer3.d = null;
                }
                GlTextureDrawer glTextureDrawer = overlayDrawer3.e;
                if (glTextureDrawer != null) {
                    glTextureDrawer.b();
                    overlayDrawer3.e = null;
                }
            }
            eglCore.b();
            snapshotGlPictureRecorder.b();
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                Closeable.closeFinally(byteArrayOutputStream, th);
                throw th2;
            }
        }
    }
}
