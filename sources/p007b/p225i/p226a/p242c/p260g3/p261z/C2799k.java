package p007b.p225i.p226a.p242c.p260g3.p261z;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.opengl.Matrix;
import android.os.Handler;
import android.os.Looper;
import android.view.Surface;
import android.view.WindowManager;
import androidx.annotation.AnyThread;
import androidx.annotation.BinderThread;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.exoplayer2.util.GlUtil;
import java.nio.Buffer;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import p007b.p225i.p226a.p242c.p259f3.C2734c0;
import p007b.p225i.p226a.p242c.p259f3.C2738e0;
import p007b.p225i.p226a.p242c.p260g3.InterfaceC2784u;

/* JADX INFO: renamed from: b.i.a.c.g3.z.k */
/* JADX INFO: compiled from: SphericalGLSurfaceView.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C2799k extends GLSurfaceView {

    /* JADX INFO: renamed from: j */
    public final CopyOnWriteArrayList<b> f7021j;

    /* JADX INFO: renamed from: k */
    public final SensorManager f7022k;

    /* JADX INFO: renamed from: l */
    @Nullable
    public final Sensor f7023l;

    /* JADX INFO: renamed from: m */
    public final C2795g f7024m;

    /* JADX INFO: renamed from: n */
    public final Handler f7025n;

    /* JADX INFO: renamed from: o */
    public final ViewOnTouchListenerC2800l f7026o;

    /* JADX INFO: renamed from: p */
    public final C2798j f7027p;

    /* JADX INFO: renamed from: q */
    @Nullable
    public SurfaceTexture f7028q;

    /* JADX INFO: renamed from: r */
    @Nullable
    public Surface f7029r;

    /* JADX INFO: renamed from: s */
    public boolean f7030s;

    /* JADX INFO: renamed from: t */
    public boolean f7031t;

    /* JADX INFO: renamed from: u */
    public boolean f7032u;

    /* JADX INFO: renamed from: b.i.a.c.g3.z.k$a */
    /* JADX INFO: compiled from: SphericalGLSurfaceView.java */
    @VisibleForTesting
    public final class a implements GLSurfaceView.Renderer, ViewOnTouchListenerC2800l.a, C2795g.a {

        /* JADX INFO: renamed from: j */
        public final C2798j f7033j;

        /* JADX INFO: renamed from: m */
        public final float[] f7036m;

        /* JADX INFO: renamed from: n */
        public final float[] f7037n;

        /* JADX INFO: renamed from: o */
        public final float[] f7038o;

        /* JADX INFO: renamed from: p */
        public float f7039p;

        /* JADX INFO: renamed from: q */
        public float f7040q;

        /* JADX INFO: renamed from: k */
        public final float[] f7034k = new float[16];

        /* JADX INFO: renamed from: l */
        public final float[] f7035l = new float[16];

        /* JADX INFO: renamed from: r */
        public final float[] f7041r = new float[16];

        /* JADX INFO: renamed from: s */
        public final float[] f7042s = new float[16];

        public a(C2798j c2798j) {
            float[] fArr = new float[16];
            this.f7036m = fArr;
            float[] fArr2 = new float[16];
            this.f7037n = fArr2;
            float[] fArr3 = new float[16];
            this.f7038o = fArr3;
            this.f7033j = c2798j;
            Matrix.setIdentityM(fArr, 0);
            Matrix.setIdentityM(fArr2, 0);
            Matrix.setIdentityM(fArr3, 0);
            this.f7040q = 3.1415927f;
        }

        @Override // p007b.p225i.p226a.p242c.p260g3.p261z.C2795g.a
        @BinderThread
        /* JADX INFO: renamed from: a */
        public synchronized void mo3199a(float[] fArr, float f) {
            float[] fArr2 = this.f7036m;
            System.arraycopy(fArr, 0, fArr2, 0, fArr2.length);
            this.f7040q = -f;
            m3203b();
        }

        @AnyThread
        /* JADX INFO: renamed from: b */
        public final void m3203b() {
            Matrix.setRotateM(this.f7037n, 0, -this.f7039p, (float) Math.cos(this.f7040q), (float) Math.sin(this.f7040q), 0.0f);
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onDrawFrame(GL10 gl10) {
            float[] fArr;
            Long lM2969d;
            synchronized (this) {
                Matrix.multiplyMM(this.f7042s, 0, this.f7036m, 0, this.f7038o, 0);
                Matrix.multiplyMM(this.f7041r, 0, this.f7037n, 0, this.f7042s, 0);
            }
            Matrix.multiplyMM(this.f7035l, 0, this.f7034k, 0, this.f7041r, 0);
            C2798j c2798j = this.f7033j;
            float[] fArr2 = this.f7035l;
            Objects.requireNonNull(c2798j);
            GLES20.glClear(16384);
            GlUtil.m8945a();
            if (c2798j.f7008j.compareAndSet(true, false)) {
                SurfaceTexture surfaceTexture = c2798j.f7017s;
                Objects.requireNonNull(surfaceTexture);
                surfaceTexture.updateTexImage();
                GlUtil.m8945a();
                if (c2798j.f7009k.compareAndSet(true, false)) {
                    Matrix.setIdentityM(c2798j.f7014p, 0);
                }
                long timestamp = c2798j.f7017s.getTimestamp();
                C2734c0<Long> c2734c0 = c2798j.f7012n;
                synchronized (c2734c0) {
                    lM2969d = c2734c0.m2969d(timestamp, false);
                }
                Long l = lM2969d;
                if (l != null) {
                    C2794f c2794f = c2798j.f7011m;
                    float[] fArr3 = c2798j.f7014p;
                    float[] fArrM2970e = c2794f.f6970c.m2970e(l.longValue());
                    if (fArrM2970e != null) {
                        float[] fArr4 = c2794f.f6969b;
                        float f = fArrM2970e[0];
                        float f2 = -fArrM2970e[1];
                        float f3 = -fArrM2970e[2];
                        float length = Matrix.length(f, f2, f3);
                        if (length != 0.0f) {
                            Matrix.setRotateM(fArr4, 0, (float) Math.toDegrees(length), f / length, f2 / length, f3 / length);
                        } else {
                            Matrix.setIdentityM(fArr4, 0);
                        }
                        if (!c2794f.f6971d) {
                            C2794f.m3198a(c2794f.f6968a, c2794f.f6969b);
                            c2794f.f6971d = true;
                        }
                        Matrix.multiplyMM(fArr3, 0, c2794f.f6968a, 0, c2794f.f6969b, 0);
                    }
                }
                C2796h c2796hM2970e = c2798j.f7013o.m2970e(timestamp);
                if (c2796hM2970e != null) {
                    C2797i c2797i = c2798j.f7010l;
                    Objects.requireNonNull(c2797i);
                    if (C2797i.m3200a(c2796hM2970e)) {
                        c2797i.f6995h = c2796hM2970e.f6981c;
                        C2797i.a aVar = new C2797i.a(c2796hM2970e.f6979a.f6983a[0]);
                        c2797i.f6996i = aVar;
                        if (!c2796hM2970e.f6982d) {
                            aVar = new C2797i.a(c2796hM2970e.f6980b.f6983a[0]);
                        }
                        c2797i.f6997j = aVar;
                    }
                }
            }
            Matrix.multiplyMM(c2798j.f7015q, 0, fArr2, 0, c2798j.f7014p, 0);
            C2797i c2797i2 = c2798j.f7010l;
            int i = c2798j.f7016r;
            float[] fArr5 = c2798j.f7015q;
            C2797i.a aVar2 = c2797i2.f6996i;
            if (aVar2 == null) {
                return;
            }
            GlUtil.C10776a c10776a = c2797i2.f6998k;
            Objects.requireNonNull(c10776a);
            c10776a.m8949c();
            GlUtil.m8945a();
            GLES20.glEnableVertexAttribArray(c2797i2.f7001n);
            GLES20.glEnableVertexAttribArray(c2797i2.f7002o);
            GlUtil.m8945a();
            int i2 = c2797i2.f6995h;
            if (i2 == 1) {
                fArr = C2797i.f6991d;
            } else {
                fArr = i2 == 2 ? C2797i.f6993f : C2797i.f6990c;
            }
            GLES20.glUniformMatrix3fv(c2797i2.f7000m, 1, false, fArr, 0);
            GLES20.glUniformMatrix4fv(c2797i2.f6999l, 1, false, fArr5, 0);
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(36197, i);
            GLES20.glUniform1i(c2797i2.f7003p, 0);
            GlUtil.m8945a();
            GLES20.glVertexAttribPointer(c2797i2.f7001n, 3, 5126, false, 12, (Buffer) aVar2.f7005b);
            GlUtil.m8945a();
            GLES20.glVertexAttribPointer(c2797i2.f7002o, 2, 5126, false, 8, (Buffer) aVar2.f7006c);
            GlUtil.m8945a();
            GLES20.glDrawArrays(aVar2.f7007d, 0, aVar2.f7004a);
            GlUtil.m8945a();
            GLES20.glDisableVertexAttribArray(c2797i2.f7001n);
            GLES20.glDisableVertexAttribArray(c2797i2.f7002o);
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceChanged(GL10 gl10, int i, int i2) {
            GLES20.glViewport(0, 0, i, i2);
            float f = i / i2;
            Matrix.perspectiveM(this.f7034k, 0, f > 1.0f ? (float) (Math.toDegrees(Math.atan(Math.tan(Math.toRadians(45.0d)) / ((double) f))) * 2.0d) : 90.0f, f, 0.1f, 100.0f);
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public synchronized void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
            final C2799k c2799k = C2799k.this;
            final SurfaceTexture surfaceTextureM3201b = this.f7033j.m3201b();
            c2799k.f7025n.post(new Runnable() { // from class: b.i.a.c.g3.z.b
                @Override // java.lang.Runnable
                public final void run() {
                    C2799k c2799k2 = c2799k;
                    SurfaceTexture surfaceTexture = surfaceTextureM3201b;
                    SurfaceTexture surfaceTexture2 = c2799k2.f7028q;
                    Surface surface = c2799k2.f7029r;
                    Surface surface2 = new Surface(surfaceTexture);
                    c2799k2.f7028q = surfaceTexture;
                    c2799k2.f7029r = surface2;
                    Iterator<C2799k.b> it = c2799k2.f7021j.iterator();
                    while (it.hasNext()) {
                        it.next().mo3205u(surface2);
                    }
                    if (surfaceTexture2 != null) {
                        surfaceTexture2.release();
                    }
                    if (surface != null) {
                        surface.release();
                    }
                }
            });
        }
    }

    /* JADX INFO: renamed from: b.i.a.c.g3.z.k$b */
    /* JADX INFO: compiled from: SphericalGLSurfaceView.java */
    public interface b {
        /* JADX INFO: renamed from: q */
        void mo3204q(Surface surface);

        /* JADX INFO: renamed from: u */
        void mo3205u(Surface surface);
    }

    public C2799k(Context context) {
        super(context, null);
        this.f7021j = new CopyOnWriteArrayList<>();
        this.f7025n = new Handler(Looper.getMainLooper());
        Object systemService = context.getSystemService("sensor");
        Objects.requireNonNull(systemService);
        SensorManager sensorManager = (SensorManager) systemService;
        this.f7022k = sensorManager;
        Sensor defaultSensor = C2738e0.f6708a >= 18 ? sensorManager.getDefaultSensor(15) : null;
        this.f7023l = defaultSensor == null ? sensorManager.getDefaultSensor(11) : defaultSensor;
        C2798j c2798j = new C2798j();
        this.f7027p = c2798j;
        a aVar = new a(c2798j);
        ViewOnTouchListenerC2800l viewOnTouchListenerC2800l = new ViewOnTouchListenerC2800l(context, aVar, 25.0f);
        this.f7026o = viewOnTouchListenerC2800l;
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        Objects.requireNonNull(windowManager);
        this.f7024m = new C2795g(windowManager.getDefaultDisplay(), viewOnTouchListenerC2800l, aVar);
        this.f7030s = true;
        setEGLContextClientVersion(2);
        setRenderer(aVar);
        setOnTouchListener(viewOnTouchListenerC2800l);
    }

    /* JADX INFO: renamed from: a */
    public final void m3202a() {
        boolean z2 = this.f7030s && this.f7031t;
        Sensor sensor = this.f7023l;
        if (sensor == null || z2 == this.f7032u) {
            return;
        }
        if (z2) {
            this.f7022k.registerListener(this.f7024m, sensor, 0);
        } else {
            this.f7022k.unregisterListener(this.f7024m);
        }
        this.f7032u = z2;
    }

    public InterfaceC2792d getCameraMotionListener() {
        return this.f7027p;
    }

    public InterfaceC2784u getVideoFrameMetadataListener() {
        return this.f7027p;
    }

    @Nullable
    public Surface getVideoSurface() {
        return this.f7029r;
    }

    @Override // android.opengl.GLSurfaceView, android.view.SurfaceView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f7025n.post(new Runnable() { // from class: b.i.a.c.g3.z.c
            @Override // java.lang.Runnable
            public final void run() {
                C2799k c2799k = this.f6962j;
                Surface surface = c2799k.f7029r;
                if (surface != null) {
                    Iterator<C2799k.b> it = c2799k.f7021j.iterator();
                    while (it.hasNext()) {
                        it.next().mo3204q(surface);
                    }
                }
                SurfaceTexture surfaceTexture = c2799k.f7028q;
                if (surfaceTexture != null) {
                    surfaceTexture.release();
                }
                if (surface != null) {
                    surface.release();
                }
                c2799k.f7028q = null;
                c2799k.f7029r = null;
            }
        });
    }

    @Override // android.opengl.GLSurfaceView
    public void onPause() {
        this.f7031t = false;
        m3202a();
        super.onPause();
    }

    @Override // android.opengl.GLSurfaceView
    public void onResume() {
        super.onResume();
        this.f7031t = true;
        m3202a();
    }

    public void setDefaultStereoMode(int i) {
        this.f7027p.f7018t = i;
    }

    public void setUseSensorRotation(boolean z2) {
        this.f7030s = z2;
        m3202a();
    }
}
