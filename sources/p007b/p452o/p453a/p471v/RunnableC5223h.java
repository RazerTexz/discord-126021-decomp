package p007b.p452o.p453a.p471v;

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
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Objects;
import p007b.p452o.p453a.C5113l;
import p007b.p452o.p453a.p467r.C5202c;
import p007b.p452o.p453a.p470u.C5214b;
import p007b.p452o.p453a.p470u.C5215c;
import p007b.p452o.p453a.p470u.InterfaceC5213a;
import p007b.p452o.p453a.p473x.C5236b;
import p007b.p452o.p475b.p476a.C5249a;
import p007b.p452o.p475b.p478c.C5257b;
import p007b.p452o.p475b.p478c.C5258c;
import p007b.p452o.p475b.p478c.C5259d;
import p007b.p452o.p475b.p478c.C5260e;
import p007b.p452o.p475b.p480e.C5267b;
import p507d0.p591y.C12201b;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: b.o.a.v.h */
/* JADX INFO: compiled from: SnapshotGlPictureRecorder.java */
/* JADX INFO: loaded from: classes3.dex */
public class RunnableC5223h implements Runnable {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ SurfaceTexture f14199j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ int f14200k;

    /* JADX INFO: renamed from: l */
    public final /* synthetic */ float f14201l;

    /* JADX INFO: renamed from: m */
    public final /* synthetic */ float f14202m;

    /* JADX INFO: renamed from: n */
    public final /* synthetic */ EGLContext f14203n;

    /* JADX INFO: renamed from: o */
    public final /* synthetic */ C5222g f14204o;

    public RunnableC5223h(C5222g c5222g, SurfaceTexture surfaceTexture, int i, float f, float f2, EGLContext eGLContext) {
        this.f14204o = c5222g;
        this.f14199j = surfaceTexture;
        this.f14200k = i;
        this.f14201l = f;
        this.f14202m = f2;
        this.f14203n = eGLContext;
    }

    @Override // java.lang.Runnable
    public void run() throws IOException {
        C5222g c5222g = this.f14204o;
        SurfaceTexture surfaceTexture = this.f14199j;
        int i = this.f14200k;
        float f = this.f14201l;
        float f2 = this.f14202m;
        EGLContext eGLContext = this.f14203n;
        Objects.requireNonNull(c5222g);
        SurfaceTexture surfaceTexture2 = new SurfaceTexture(9999);
        C5236b c5236b = c5222g.f14172j.f13718d;
        surfaceTexture2.setDefaultBufferSize(c5236b.f14251j, c5236b.f14252k);
        C5249a c5249a = new C5249a(eGLContext, 1);
        C5267b c5267b = new C5267b(c5249a, surfaceTexture2);
        C5249a c5249a2 = c5267b.f14327a;
        C5260e c5260e = c5267b.f14328b;
        Objects.requireNonNull(c5249a2);
        C12238m.checkNotNullParameter(c5260e, "eglSurface");
        if (c5249a2.f14260a == C5259d.f14272b) {
            Log.v("EglCore", "NOTE: makeSurfaceCurrent w/o display");
        }
        C5258c c5258c = c5249a2.f14260a;
        C5257b c5257b = c5249a2.f14261b;
        EGLDisplay eGLDisplay = c5258c.f14270a;
        EGLSurface eGLSurface = c5260e.f14290a;
        if (!EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, c5257b.f14269a)) {
            throw new RuntimeException("eglMakeCurrent failed");
        }
        float[] fArr = c5222g.f14197s.f14106b;
        surfaceTexture.getTransformMatrix(fArr);
        Matrix.translateM(fArr, 0, (1.0f - f) / 2.0f, (1.0f - f2) / 2.0f, 0.0f);
        Matrix.scaleM(fArr, 0, f, f2, 1.0f);
        Matrix.translateM(fArr, 0, 0.5f, 0.5f, 0.0f);
        Matrix.rotateM(fArr, 0, i + c5222g.f14172j.f13717c, 0.0f, 0.0f, 1.0f);
        Matrix.scaleM(fArr, 0, 1.0f, -1.0f, 1.0f);
        Matrix.translateM(fArr, 0, -0.5f, -0.5f, 0.0f);
        if (c5222g.f14195q) {
            C5214b c5214b = c5222g.f14196r;
            InterfaceC5213a.a aVar = InterfaceC5213a.a.PICTURE_SNAPSHOT;
            Objects.requireNonNull(c5214b);
            try {
                Canvas canvasLockCanvas = (Build.VERSION.SDK_INT < 23 || !((C5215c) c5214b.f14148b).getHardwareCanvasEnabled()) ? c5214b.f14150d.lockCanvas(null) : c5214b.f14150d.lockHardwareCanvas();
                canvasLockCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
                ((C5215c) c5214b.f14148b).m7412a(aVar, canvasLockCanvas);
                c5214b.f14150d.unlockCanvasAndPost(canvasLockCanvas);
            } catch (Surface.OutOfResourcesException e) {
                C5214b.f14147a.m7159a(2, "Got Surface.OutOfResourcesException while drawing video overlays", e);
            }
            synchronized (c5214b.f14153g) {
                GLES20.glBindTexture(36197, c5214b.f14152f.f14116a);
                c5214b.f14149c.updateTexImage();
            }
            c5214b.f14149c.getTransformMatrix(c5214b.f14151e.f14106b);
            Matrix.translateM(c5222g.f14196r.f14151e.f14106b, 0, 0.5f, 0.5f, 0.0f);
            Matrix.rotateM(c5222g.f14196r.f14151e.f14106b, 0, c5222g.f14172j.f13717c, 0.0f, 0.0f, 1.0f);
            Matrix.scaleM(c5222g.f14196r.f14151e.f14106b, 0, 1.0f, -1.0f, 1.0f);
            Matrix.translateM(c5222g.f14196r.f14151e.f14106b, 0, -0.5f, -0.5f, 0.0f);
        }
        c5222g.f14172j.f13717c = 0;
        long timestamp = surfaceTexture.getTimestamp() / 1000;
        AbstractC5224i.f14205m.m7159a(1, "takeFrame:", "timestampUs:", Long.valueOf(timestamp));
        c5222g.f14197s.m7399a(timestamp);
        if (c5222g.f14195q) {
            C5214b c5214b2 = c5222g.f14196r;
            Objects.requireNonNull(c5214b2);
            GLES20.glDisable(2884);
            GLES20.glDisable(2929);
            GLES20.glEnable(3042);
            GLES20.glBlendFunc(770, 771);
            synchronized (c5214b2.f14153g) {
                c5214b2.f14151e.m7399a(timestamp);
            }
        }
        C5113l.a aVar2 = c5222g.f14172j;
        Bitmap.CompressFormat compressFormat = Bitmap.CompressFormat.JPEG;
        C12238m.checkNotNullParameter(compressFormat, "format");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            c5267b.m7460a(byteArrayOutputStream, compressFormat);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            C12238m.checkNotNullExpressionValue(byteArray, "it.toByteArray()");
            C12201b.closeFinally(byteArrayOutputStream, null);
            aVar2.f13720f = byteArray;
            C5249a c5249a3 = c5267b.f14327a;
            C5260e c5260e2 = c5267b.f14328b;
            Objects.requireNonNull(c5249a3);
            C12238m.checkNotNullParameter(c5260e2, "eglSurface");
            EGL14.eglDestroySurface(c5249a3.f14260a.f14270a, c5260e2.f14290a);
            c5267b.f14328b = C5259d.f14273c;
            c5267b.f14330d = -1;
            c5267b.f14329c = -1;
            c5222g.f14197s.m7400b();
            surfaceTexture2.release();
            if (c5222g.f14195q) {
                C5214b c5214b3 = c5222g.f14196r;
                if (c5214b3.f14152f != null) {
                    GLES20.glBindTexture(36197, 0);
                    c5214b3.f14152f = null;
                }
                SurfaceTexture surfaceTexture3 = c5214b3.f14149c;
                if (surfaceTexture3 != null) {
                    surfaceTexture3.release();
                    c5214b3.f14149c = null;
                }
                Surface surface = c5214b3.f14150d;
                if (surface != null) {
                    surface.release();
                    c5214b3.f14150d = null;
                }
                C5202c c5202c = c5214b3.f14151e;
                if (c5202c != null) {
                    c5202c.m7400b();
                    c5214b3.f14151e = null;
                }
            }
            c5249a.m7453b();
            c5222g.mo7416b();
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                C12201b.closeFinally(byteArrayOutputStream, th);
                throw th2;
            }
        }
    }
}
