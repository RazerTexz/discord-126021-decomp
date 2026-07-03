package p596e0.p597a.p598a.p599a;

import android.content.Context;
import android.graphics.Point;
import android.hardware.Camera;
import android.os.Handler;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import java.util.List;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;

/* JADX INFO: renamed from: e0.a.a.a.d */
/* JADX INFO: compiled from: CameraPreview.java */
/* JADX INFO: loaded from: classes3.dex */
public class SurfaceHolderCallbackC12256d extends SurfaceView implements SurfaceHolder.Callback {

    /* JADX INFO: renamed from: j */
    public C12257e f25321j;

    /* JADX INFO: renamed from: k */
    public Handler f25322k;

    /* JADX INFO: renamed from: l */
    public boolean f25323l;

    /* JADX INFO: renamed from: m */
    public boolean f25324m;

    /* JADX INFO: renamed from: n */
    public boolean f25325n;

    /* JADX INFO: renamed from: o */
    public boolean f25326o;

    /* JADX INFO: renamed from: p */
    public Camera.PreviewCallback f25327p;

    /* JADX INFO: renamed from: q */
    public float f25328q;

    /* JADX INFO: renamed from: r */
    public Runnable f25329r;

    /* JADX INFO: renamed from: s */
    public Camera.AutoFocusCallback f25330s;

    /* JADX INFO: renamed from: e0.a.a.a.d$a */
    /* JADX INFO: compiled from: CameraPreview.java */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            SurfaceHolderCallbackC12256d surfaceHolderCallbackC12256d = SurfaceHolderCallbackC12256d.this;
            if (surfaceHolderCallbackC12256d.f25321j != null && surfaceHolderCallbackC12256d.f25323l && surfaceHolderCallbackC12256d.f25324m && surfaceHolderCallbackC12256d.f25325n) {
                surfaceHolderCallbackC12256d.m10095a();
            }
        }
    }

    /* JADX INFO: renamed from: e0.a.a.a.d$b */
    /* JADX INFO: compiled from: CameraPreview.java */
    public class b implements Camera.AutoFocusCallback {
        public b() {
        }

        @Override // android.hardware.Camera.AutoFocusCallback
        public void onAutoFocus(boolean z2, Camera camera) {
            SurfaceHolderCallbackC12256d.this.m10096b();
        }
    }

    public SurfaceHolderCallbackC12256d(Context context, C12257e c12257e, Camera.PreviewCallback previewCallback) {
        super(context);
        this.f25323l = true;
        this.f25324m = true;
        this.f25325n = false;
        this.f25326o = true;
        this.f25328q = 0.1f;
        this.f25329r = new a();
        this.f25330s = new b();
        this.f25321j = c12257e;
        this.f25327p = previewCallback;
        this.f25322k = new Handler();
        getHolder().addCallback(this);
        getHolder().setType(3);
    }

    private Camera.Size getOptimalPreviewSize() {
        C12257e c12257e = this.f25321j;
        Camera.Size size = null;
        if (c12257e == null) {
            return null;
        }
        List<Camera.Size> supportedPreviewSizes = c12257e.f25333a.getParameters().getSupportedPreviewSizes();
        int width = getWidth();
        int height = getHeight();
        if (C3404f.m4332q0(getContext()) == 1) {
            height = width;
            width = height;
        }
        double d = ((double) width) / ((double) height);
        if (supportedPreviewSizes == null) {
            return null;
        }
        double dAbs = Double.MAX_VALUE;
        double dAbs2 = Double.MAX_VALUE;
        for (Camera.Size size2 : supportedPreviewSizes) {
            if (Math.abs((((double) size2.width) / ((double) size2.height)) - d) <= this.f25328q && Math.abs(size2.height - height) < dAbs2) {
                dAbs2 = Math.abs(size2.height - height);
                size = size2;
            }
        }
        if (size == null) {
            for (Camera.Size size3 : supportedPreviewSizes) {
                if (Math.abs(size3.height - height) < dAbs) {
                    size = size3;
                    dAbs = Math.abs(size3.height - height);
                }
            }
        }
        return size;
    }

    /* JADX INFO: renamed from: a */
    public void m10095a() {
        try {
            this.f25321j.f25333a.autoFocus(this.f25330s);
        } catch (RuntimeException unused) {
            m10096b();
        }
    }

    /* JADX INFO: renamed from: b */
    public final void m10096b() {
        this.f25322k.postDelayed(this.f25329r, 1000L);
    }

    /* JADX INFO: renamed from: c */
    public final void m10097c(int i, int i2) {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (getDisplayOrientation() % 180 != 0) {
            i2 = i;
            i = i2;
        }
        if (this.f25326o) {
            float f = i;
            float width = ((View) getParent()).getWidth() / f;
            float f2 = i2;
            float height = ((View) getParent()).getHeight() / f2;
            if (width <= height) {
                width = height;
            }
            i = Math.round(f * width);
            i2 = Math.round(f2 * width);
        }
        layoutParams.width = i;
        layoutParams.height = i2;
        setLayoutParams(layoutParams);
    }

    /* JADX INFO: renamed from: d */
    public void m10098d() {
        Camera.Size optimalPreviewSize = getOptimalPreviewSize();
        Camera.Parameters parameters = this.f25321j.f25333a.getParameters();
        parameters.setPreviewSize(optimalPreviewSize.width, optimalPreviewSize.height);
        this.f25321j.f25333a.setParameters(parameters);
        Point point = new Point(getWidth(), getHeight());
        if (getDisplayOrientation() % 180 != 0) {
            point = new Point(point.y, point.x);
        }
        float f = optimalPreviewSize.width / optimalPreviewSize.height;
        int i = point.x;
        float f2 = i;
        int i2 = point.y;
        float f3 = i2;
        if (f2 / f3 > f) {
            m10097c((int) (f3 * f), i2);
        } else {
            m10097c(i, (int) (f2 / f));
        }
    }

    /* JADX INFO: renamed from: e */
    public void m10099e() {
        if (this.f25321j != null) {
            try {
                this.f25323l = false;
                getHolder().removeCallback(this);
                this.f25321j.f25333a.cancelAutoFocus();
                this.f25321j.f25333a.setOneShotPreviewCallback(null);
                this.f25321j.f25333a.stopPreview();
            } catch (Exception e) {
                Log.e("CameraPreview", e.toString(), e);
            }
        }
    }

    public int getDisplayOrientation() {
        int i = 0;
        if (this.f25321j == null) {
            return 0;
        }
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        int i2 = this.f25321j.f25334b;
        if (i2 == -1) {
            Camera.getCameraInfo(0, cameraInfo);
        } else {
            Camera.getCameraInfo(i2, cameraInfo);
        }
        int rotation = ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay().getRotation();
        if (rotation != 0) {
            if (rotation == 1) {
                i = 90;
            } else if (rotation == 2) {
                i = 180;
            } else if (rotation == 3) {
                i = 270;
            }
        }
        return cameraInfo.facing == 1 ? (360 - ((cameraInfo.orientation + i) % 360)) % 360 : ((cameraInfo.orientation - i) + 360) % 360;
    }

    public void setAspectTolerance(float f) {
        this.f25328q = f;
    }

    public void setAutoFocus(boolean z2) {
        if (this.f25321j == null || !this.f25323l || z2 == this.f25324m) {
            return;
        }
        this.f25324m = z2;
        if (!z2) {
            Log.v("CameraPreview", "Cancelling autofocus");
            this.f25321j.f25333a.cancelAutoFocus();
        } else if (!this.f25325n) {
            m10096b();
        } else {
            Log.v("CameraPreview", "Starting autofocus");
            m10095a();
        }
    }

    public void setShouldScaleToFill(boolean z2) {
        this.f25326o = z2;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        if (surfaceHolder.getSurface() == null) {
            return;
        }
        m10099e();
        if (this.f25321j != null) {
            try {
                getHolder().addCallback(this);
                this.f25323l = true;
                m10098d();
                this.f25321j.f25333a.setPreviewDisplay(getHolder());
                this.f25321j.f25333a.setDisplayOrientation(getDisplayOrientation());
                this.f25321j.f25333a.setOneShotPreviewCallback(this.f25327p);
                this.f25321j.f25333a.startPreview();
                if (this.f25324m) {
                    if (this.f25325n) {
                        m10095a();
                    } else {
                        m10096b();
                    }
                }
            } catch (Exception e) {
                Log.e("CameraPreview", e.toString(), e);
            }
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        this.f25325n = true;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.f25325n = false;
        m10099e();
    }
}
