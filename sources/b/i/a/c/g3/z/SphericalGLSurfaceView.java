package b.i.a.c.g3.z;

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
import b.i.a.c.f3.TimedValueQueue;
import b.i.a.c.f3.Util2;
import b.i.a.c.g3.VideoFrameMetadataListener;
import b.i.a.c.g3.z.OrientationListener;
import b.i.a.c.g3.z.ProjectionRenderer;
import b.i.a.c.g3.z.SphericalGLSurfaceView;
import b.i.a.c.g3.z.TouchTracker;
import com.google.android.exoplayer2.util.GlUtil;
import java.nio.Buffer;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/* JADX INFO: renamed from: b.i.a.c.g3.z.k, reason: use source file name */
/* JADX INFO: compiled from: SphericalGLSurfaceView.java */
/* JADX INFO: loaded from: classes3.dex */
public final class SphericalGLSurfaceView extends GLSurfaceView {
    public final CopyOnWriteArrayList<b> j;
    public final SensorManager k;

    @Nullable
    public final Sensor l;
    public final OrientationListener m;
    public final Handler n;
    public final TouchTracker o;
    public final SceneRenderer p;

    @Nullable
    public SurfaceTexture q;

    @Nullable
    public Surface r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f1005s;
    public boolean t;
    public boolean u;

    /* JADX INFO: renamed from: b.i.a.c.g3.z.k$a */
    /* JADX INFO: compiled from: SphericalGLSurfaceView.java */
    @VisibleForTesting
    public final class a implements GLSurfaceView.Renderer, TouchTracker.a, OrientationListener.a {
        public final SceneRenderer j;
        public final float[] m;
        public final float[] n;
        public final float[] o;
        public float p;
        public float q;
        public final float[] k = new float[16];
        public final float[] l = new float[16];
        public final float[] r = new float[16];

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public final float[] f1006s = new float[16];

        public a(SceneRenderer sceneRenderer) {
            float[] fArr = new float[16];
            this.m = fArr;
            float[] fArr2 = new float[16];
            this.n = fArr2;
            float[] fArr3 = new float[16];
            this.o = fArr3;
            this.j = sceneRenderer;
            Matrix.setIdentityM(fArr, 0);
            Matrix.setIdentityM(fArr2, 0);
            Matrix.setIdentityM(fArr3, 0);
            this.q = 3.1415927f;
        }

        @Override // b.i.a.c.g3.z.OrientationListener.a
        @BinderThread
        public synchronized void a(float[] fArr, float f) {
            float[] fArr2 = this.m;
            System.arraycopy(fArr, 0, fArr2, 0, fArr2.length);
            this.q = -f;
            b();
        }

        @AnyThread
        public final void b() {
            Matrix.setRotateM(this.n, 0, -this.p, (float) Math.cos(this.q), (float) Math.sin(this.q), 0.0f);
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onDrawFrame(GL10 gl10) {
            float[] fArr;
            Long lD;
            synchronized (this) {
                Matrix.multiplyMM(this.f1006s, 0, this.m, 0, this.o, 0);
                Matrix.multiplyMM(this.r, 0, this.n, 0, this.f1006s, 0);
            }
            Matrix.multiplyMM(this.l, 0, this.k, 0, this.r, 0);
            SceneRenderer sceneRenderer = this.j;
            float[] fArr2 = this.l;
            Objects.requireNonNull(sceneRenderer);
            GLES20.glClear(16384);
            GlUtil.a();
            if (sceneRenderer.j.compareAndSet(true, false)) {
                SurfaceTexture surfaceTexture = sceneRenderer.f1004s;
                Objects.requireNonNull(surfaceTexture);
                surfaceTexture.updateTexImage();
                GlUtil.a();
                if (sceneRenderer.k.compareAndSet(true, false)) {
                    Matrix.setIdentityM(sceneRenderer.p, 0);
                }
                long timestamp = sceneRenderer.f1004s.getTimestamp();
                TimedValueQueue<Long> timedValueQueue = sceneRenderer.n;
                synchronized (timedValueQueue) {
                    lD = timedValueQueue.d(timestamp, false);
                }
                Long l = lD;
                if (l != null) {
                    FrameRotationQueue frameRotationQueue = sceneRenderer.m;
                    float[] fArr3 = sceneRenderer.p;
                    float[] fArrE = frameRotationQueue.c.e(l.longValue());
                    if (fArrE != null) {
                        float[] fArr4 = frameRotationQueue.f998b;
                        float f = fArrE[0];
                        float f2 = -fArrE[1];
                        float f3 = -fArrE[2];
                        float length = Matrix.length(f, f2, f3);
                        if (length != 0.0f) {
                            Matrix.setRotateM(fArr4, 0, (float) Math.toDegrees(length), f / length, f2 / length, f3 / length);
                        } else {
                            Matrix.setIdentityM(fArr4, 0);
                        }
                        if (!frameRotationQueue.d) {
                            FrameRotationQueue.a(frameRotationQueue.a, frameRotationQueue.f998b);
                            frameRotationQueue.d = true;
                        }
                        Matrix.multiplyMM(fArr3, 0, frameRotationQueue.a, 0, frameRotationQueue.f998b, 0);
                    }
                }
                Projection projectionE = sceneRenderer.o.e(timestamp);
                if (projectionE != null) {
                    ProjectionRenderer projectionRenderer = sceneRenderer.l;
                    Objects.requireNonNull(projectionRenderer);
                    if (ProjectionRenderer.a(projectionE)) {
                        projectionRenderer.h = projectionE.c;
                        ProjectionRenderer.a aVar = new ProjectionRenderer.a(projectionE.a.a[0]);
                        projectionRenderer.i = aVar;
                        if (!projectionE.d) {
                            aVar = new ProjectionRenderer.a(projectionE.f1000b.a[0]);
                        }
                        projectionRenderer.j = aVar;
                    }
                }
            }
            Matrix.multiplyMM(sceneRenderer.q, 0, fArr2, 0, sceneRenderer.p, 0);
            ProjectionRenderer projectionRenderer2 = sceneRenderer.l;
            int i = sceneRenderer.r;
            float[] fArr5 = sceneRenderer.q;
            ProjectionRenderer.a aVar2 = projectionRenderer2.i;
            if (aVar2 == null) {
                return;
            }
            GlUtil.a aVar3 = projectionRenderer2.k;
            Objects.requireNonNull(aVar3);
            aVar3.c();
            GlUtil.a();
            GLES20.glEnableVertexAttribArray(projectionRenderer2.n);
            GLES20.glEnableVertexAttribArray(projectionRenderer2.o);
            GlUtil.a();
            int i2 = projectionRenderer2.h;
            if (i2 == 1) {
                fArr = ProjectionRenderer.d;
            } else {
                fArr = i2 == 2 ? ProjectionRenderer.f : ProjectionRenderer.c;
            }
            GLES20.glUniformMatrix3fv(projectionRenderer2.m, 1, false, fArr, 0);
            GLES20.glUniformMatrix4fv(projectionRenderer2.l, 1, false, fArr5, 0);
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(36197, i);
            GLES20.glUniform1i(projectionRenderer2.p, 0);
            GlUtil.a();
            GLES20.glVertexAttribPointer(projectionRenderer2.n, 3, 5126, false, 12, (Buffer) aVar2.f1003b);
            GlUtil.a();
            GLES20.glVertexAttribPointer(projectionRenderer2.o, 2, 5126, false, 8, (Buffer) aVar2.c);
            GlUtil.a();
            GLES20.glDrawArrays(aVar2.d, 0, aVar2.a);
            GlUtil.a();
            GLES20.glDisableVertexAttribArray(projectionRenderer2.n);
            GLES20.glDisableVertexAttribArray(projectionRenderer2.o);
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceChanged(GL10 gl10, int i, int i2) {
            GLES20.glViewport(0, 0, i, i2);
            float f = i / i2;
            Matrix.perspectiveM(this.k, 0, f > 1.0f ? (float) (Math.toDegrees(Math.atan(Math.tan(Math.toRadians(45.0d)) / ((double) f))) * 2.0d) : 90.0f, f, 0.1f, 100.0f);
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public synchronized void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
            final SphericalGLSurfaceView sphericalGLSurfaceView = SphericalGLSurfaceView.this;
            final SurfaceTexture surfaceTextureB = this.j.b();
            sphericalGLSurfaceView.n.post(new Runnable() { // from class: b.i.a.c.g3.z.b
                @Override // java.lang.Runnable
                public final void run() {
                    SphericalGLSurfaceView sphericalGLSurfaceView2 = sphericalGLSurfaceView;
                    SurfaceTexture surfaceTexture = surfaceTextureB;
                    SurfaceTexture surfaceTexture2 = sphericalGLSurfaceView2.q;
                    Surface surface = sphericalGLSurfaceView2.r;
                    Surface surface2 = new Surface(surfaceTexture);
                    sphericalGLSurfaceView2.q = surfaceTexture;
                    sphericalGLSurfaceView2.r = surface2;
                    Iterator<SphericalGLSurfaceView.b> it = sphericalGLSurfaceView2.j.iterator();
                    while (it.hasNext()) {
                        it.next().u(surface2);
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
        void q(Surface surface);

        void u(Surface surface);
    }

    public SphericalGLSurfaceView(Context context) {
        super(context, null);
        this.j = new CopyOnWriteArrayList<>();
        this.n = new Handler(Looper.getMainLooper());
        Object systemService = context.getSystemService("sensor");
        Objects.requireNonNull(systemService);
        SensorManager sensorManager = (SensorManager) systemService;
        this.k = sensorManager;
        Sensor defaultSensor = Util2.a >= 18 ? sensorManager.getDefaultSensor(15) : null;
        this.l = defaultSensor == null ? sensorManager.getDefaultSensor(11) : defaultSensor;
        SceneRenderer sceneRenderer = new SceneRenderer();
        this.p = sceneRenderer;
        a aVar = new a(sceneRenderer);
        TouchTracker touchTracker = new TouchTracker(context, aVar, 25.0f);
        this.o = touchTracker;
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        Objects.requireNonNull(windowManager);
        this.m = new OrientationListener(windowManager.getDefaultDisplay(), touchTracker, aVar);
        this.f1005s = true;
        setEGLContextClientVersion(2);
        setRenderer(aVar);
        setOnTouchListener(touchTracker);
    }

    public final void a() {
        boolean z2 = this.f1005s && this.t;
        Sensor sensor = this.l;
        if (sensor == null || z2 == this.u) {
            return;
        }
        if (z2) {
            this.k.registerListener(this.m, sensor, 0);
        } else {
            this.k.unregisterListener(this.m);
        }
        this.u = z2;
    }

    public CameraMotionListener getCameraMotionListener() {
        return this.p;
    }

    public VideoFrameMetadataListener getVideoFrameMetadataListener() {
        return this.p;
    }

    @Nullable
    public Surface getVideoSurface() {
        return this.r;
    }

    @Override // android.opengl.GLSurfaceView, android.view.SurfaceView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.n.post(new Runnable() { // from class: b.i.a.c.g3.z.c
            @Override // java.lang.Runnable
            public final void run() {
                SphericalGLSurfaceView sphericalGLSurfaceView = this.j;
                Surface surface = sphericalGLSurfaceView.r;
                if (surface != null) {
                    Iterator<SphericalGLSurfaceView.b> it = sphericalGLSurfaceView.j.iterator();
                    while (it.hasNext()) {
                        it.next().q(surface);
                    }
                }
                SurfaceTexture surfaceTexture = sphericalGLSurfaceView.q;
                if (surfaceTexture != null) {
                    surfaceTexture.release();
                }
                if (surface != null) {
                    surface.release();
                }
                sphericalGLSurfaceView.q = null;
                sphericalGLSurfaceView.r = null;
            }
        });
    }

    @Override // android.opengl.GLSurfaceView
    public void onPause() {
        this.t = false;
        a();
        super.onPause();
    }

    @Override // android.opengl.GLSurfaceView
    public void onResume() {
        super.onResume();
        this.t = true;
        a();
    }

    public void setDefaultStereoMode(int i) {
        this.p.t = i;
    }

    public void setUseSensorRotation(boolean z2) {
        this.f1005s = z2;
        a();
    }
}
