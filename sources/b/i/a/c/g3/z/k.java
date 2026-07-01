package b.i.a.c.g3.z;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.opengl.GLSurfaceView;
import android.os.Handler;
import android.os.Looper;
import android.view.Surface;
import android.view.WindowManager;
import androidx.annotation.Nullable;
import b.i.a.c.f3.e0;
import b.i.a.c.g3.u;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: SphericalGLSurfaceView.java */
/* JADX INFO: loaded from: classes3.dex */
public final class k extends GLSurfaceView {
    public final CopyOnWriteArrayList<k$b> j;
    public final SensorManager k;

    @Nullable
    public final Sensor l;
    public final g m;
    public final Handler n;
    public final l o;
    public final j p;

    @Nullable
    public SurfaceTexture q;

    @Nullable
    public Surface r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f1005s;
    public boolean t;
    public boolean u;

    public k(Context context) {
        super(context, null);
        this.j = new CopyOnWriteArrayList<>();
        this.n = new Handler(Looper.getMainLooper());
        Object systemService = context.getSystemService("sensor");
        Objects.requireNonNull(systemService);
        SensorManager sensorManager = (SensorManager) systemService;
        this.k = sensorManager;
        Sensor defaultSensor = e0.a >= 18 ? sensorManager.getDefaultSensor(15) : null;
        this.l = defaultSensor == null ? sensorManager.getDefaultSensor(11) : defaultSensor;
        j jVar = new j();
        this.p = jVar;
        k$a k_a = new k$a(this, jVar);
        l lVar = new l(context, k_a, 25.0f);
        this.o = lVar;
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        Objects.requireNonNull(windowManager);
        this.m = new g(windowManager.getDefaultDisplay(), lVar, k_a);
        this.f1005s = true;
        setEGLContextClientVersion(2);
        setRenderer(k_a);
        setOnTouchListener(lVar);
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

    public d getCameraMotionListener() {
        return this.p;
    }

    public u getVideoFrameMetadataListener() {
        return this.p;
    }

    @Nullable
    public Surface getVideoSurface() {
        return this.r;
    }

    @Override // android.opengl.GLSurfaceView, android.view.SurfaceView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.n.post(new c(this));
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
