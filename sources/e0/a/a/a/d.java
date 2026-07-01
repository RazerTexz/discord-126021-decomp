package e0.a.a.a;

import android.content.Context;
import android.graphics.Point;
import android.hardware.Camera;
import android.hardware.Camera$AutoFocusCallback;
import android.hardware.Camera$CameraInfo;
import android.hardware.Camera$Parameters;
import android.hardware.Camera$PreviewCallback;
import android.hardware.Camera$Size;
import android.os.Handler;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder$Callback;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup$LayoutParams;
import android.view.WindowManager;
import java.util.List;

/* JADX INFO: compiled from: CameraPreview.java */
/* JADX INFO: loaded from: classes3.dex */
public class d extends SurfaceView implements SurfaceHolder$Callback {
    public e j;
    public Handler k;
    public boolean l;
    public boolean m;
    public boolean n;
    public boolean o;
    public Camera$PreviewCallback p;
    public float q;
    public Runnable r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public Camera$AutoFocusCallback f3597s;

    public d(Context context, e eVar, Camera$PreviewCallback camera$PreviewCallback) {
        super(context);
        this.l = true;
        this.m = true;
        this.n = false;
        this.o = true;
        this.q = 0.1f;
        this.r = new d$a(this);
        this.f3597s = new d$b(this);
        this.j = eVar;
        this.p = camera$PreviewCallback;
        this.k = new Handler();
        getHolder().addCallback(this);
        getHolder().setType(3);
    }

    private Camera$Size getOptimalPreviewSize() {
        e eVar = this.j;
        Camera$Size camera$Size = null;
        if (eVar == null) {
            return null;
        }
        List<Camera$Size> supportedPreviewSizes = eVar.a.getParameters().getSupportedPreviewSizes();
        int width = getWidth();
        int height = getHeight();
        if (b.i.a.f.e.o.f.q0(getContext()) == 1) {
            height = width;
            width = height;
        }
        double d = ((double) width) / ((double) height);
        if (supportedPreviewSizes == null) {
            return null;
        }
        double dAbs = Double.MAX_VALUE;
        double dAbs2 = Double.MAX_VALUE;
        for (Camera$Size camera$Size2 : supportedPreviewSizes) {
            if (Math.abs((((double) camera$Size2.width) / ((double) camera$Size2.height)) - d) <= this.q && Math.abs(camera$Size2.height - height) < dAbs2) {
                dAbs2 = Math.abs(camera$Size2.height - height);
                camera$Size = camera$Size2;
            }
        }
        if (camera$Size == null) {
            for (Camera$Size camera$Size3 : supportedPreviewSizes) {
                if (Math.abs(camera$Size3.height - height) < dAbs) {
                    camera$Size = camera$Size3;
                    dAbs = Math.abs(camera$Size3.height - height);
                }
            }
        }
        return camera$Size;
    }

    public void a() {
        try {
            this.j.a.autoFocus(this.f3597s);
        } catch (RuntimeException unused) {
            b();
        }
    }

    public final void b() {
        this.k.postDelayed(this.r, 1000L);
    }

    public final void c(int i, int i2) {
        ViewGroup$LayoutParams layoutParams = getLayoutParams();
        if (getDisplayOrientation() % 180 != 0) {
            i2 = i;
            i = i2;
        }
        if (this.o) {
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

    public void d() {
        Camera$Size optimalPreviewSize = getOptimalPreviewSize();
        Camera$Parameters parameters = this.j.a.getParameters();
        parameters.setPreviewSize(optimalPreviewSize.width, optimalPreviewSize.height);
        this.j.a.setParameters(parameters);
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
            c((int) (f3 * f), i2);
        } else {
            c(i, (int) (f2 / f));
        }
    }

    public void e() {
        if (this.j != null) {
            try {
                this.l = false;
                getHolder().removeCallback(this);
                this.j.a.cancelAutoFocus();
                this.j.a.setOneShotPreviewCallback(null);
                this.j.a.stopPreview();
            } catch (Exception e) {
                Log.e("CameraPreview", e.toString(), e);
            }
        }
    }

    public int getDisplayOrientation() {
        int i = 0;
        if (this.j == null) {
            return 0;
        }
        Camera$CameraInfo camera$CameraInfo = new Camera$CameraInfo();
        int i2 = this.j.f3598b;
        if (i2 == -1) {
            Camera.getCameraInfo(0, camera$CameraInfo);
        } else {
            Camera.getCameraInfo(i2, camera$CameraInfo);
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
        return camera$CameraInfo.facing == 1 ? (360 - ((camera$CameraInfo.orientation + i) % 360)) % 360 : ((camera$CameraInfo.orientation - i) + 360) % 360;
    }

    public void setAspectTolerance(float f) {
        this.q = f;
    }

    public void setAutoFocus(boolean z2) {
        if (this.j == null || !this.l || z2 == this.m) {
            return;
        }
        this.m = z2;
        if (!z2) {
            Log.v("CameraPreview", "Cancelling autofocus");
            this.j.a.cancelAutoFocus();
        } else if (!this.n) {
            b();
        } else {
            Log.v("CameraPreview", "Starting autofocus");
            a();
        }
    }

    public void setShouldScaleToFill(boolean z2) {
        this.o = z2;
    }

    @Override // android.view.SurfaceHolder$Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        if (surfaceHolder.getSurface() == null) {
            return;
        }
        e();
        if (this.j != null) {
            try {
                getHolder().addCallback(this);
                this.l = true;
                d();
                this.j.a.setPreviewDisplay(getHolder());
                this.j.a.setDisplayOrientation(getDisplayOrientation());
                this.j.a.setOneShotPreviewCallback(this.p);
                this.j.a.startPreview();
                if (this.m) {
                    if (this.n) {
                        a();
                    } else {
                        b();
                    }
                }
            } catch (Exception e) {
                Log.e("CameraPreview", e.toString(), e);
            }
        }
    }

    @Override // android.view.SurfaceHolder$Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        this.n = true;
    }

    @Override // android.view.SurfaceHolder$Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.n = false;
        e();
    }
}
