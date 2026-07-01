package e0.a.a.a;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.hardware.Camera;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.annotation.ColorInt;
import androidx.core.view.ViewCompat;
import me.dm7.barcodescanner.core.R;

/* JADX INFO: renamed from: e0.a.a.a.a, reason: use source file name */
/* JADX INFO: compiled from: BarcodeScannerView.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class BarcodeScannerView extends FrameLayout implements Camera.PreviewCallback {
    public float A;
    public int B;
    public float C;
    public CameraWrapper j;
    public CameraPreview2 k;
    public IViewFinder l;
    public Rect m;
    public CameraHandlerThread2 n;
    public Boolean o;
    public boolean p;
    public boolean q;
    public boolean r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @ColorInt
    public int f3593s;

    @ColorInt
    public int t;
    public int u;
    public int v;
    public int w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f3594x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f3595y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f3596z;

    public BarcodeScannerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.p = true;
        this.q = true;
        this.r = true;
        this.f3593s = getResources().getColor(R.a.viewfinder_laser);
        this.t = getResources().getColor(R.a.viewfinder_border);
        this.u = getResources().getColor(R.a.viewfinder_mask);
        this.v = getResources().getInteger(R.b.viewfinder_border_width);
        this.w = getResources().getInteger(R.b.viewfinder_border_length);
        this.f3594x = false;
        this.f3595y = 0;
        this.f3596z = false;
        this.A = 1.0f;
        this.B = 0;
        this.C = 0.1f;
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.c.BarcodeScannerView, 0, 0);
        try {
            setShouldScaleToFill(typedArrayObtainStyledAttributes.getBoolean(R.c.BarcodeScannerView_shouldScaleToFill, true));
            this.r = typedArrayObtainStyledAttributes.getBoolean(R.c.BarcodeScannerView_laserEnabled, this.r);
            this.f3593s = typedArrayObtainStyledAttributes.getColor(R.c.BarcodeScannerView_laserColor, this.f3593s);
            this.t = typedArrayObtainStyledAttributes.getColor(R.c.BarcodeScannerView_borderColor, this.t);
            this.u = typedArrayObtainStyledAttributes.getColor(R.c.BarcodeScannerView_maskColor, this.u);
            this.v = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.c.BarcodeScannerView_borderWidth, this.v);
            this.w = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.c.BarcodeScannerView_borderLength, this.w);
            this.f3594x = typedArrayObtainStyledAttributes.getBoolean(R.c.BarcodeScannerView_roundedCorner, this.f3594x);
            this.f3595y = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.c.BarcodeScannerView_cornerRadius, this.f3595y);
            this.f3596z = typedArrayObtainStyledAttributes.getBoolean(R.c.BarcodeScannerView_squaredFinder, this.f3596z);
            this.A = typedArrayObtainStyledAttributes.getFloat(R.c.BarcodeScannerView_borderAlpha, this.A);
            this.B = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.c.BarcodeScannerView_finderOffset, this.B);
            typedArrayObtainStyledAttributes.recycle();
            ViewFinderView viewFinderView = new ViewFinderView(getContext());
            viewFinderView.setBorderColor(this.t);
            viewFinderView.setLaserColor(this.f3593s);
            viewFinderView.setLaserEnabled(this.r);
            viewFinderView.setBorderStrokeWidth(this.v);
            viewFinderView.setBorderLineLength(this.w);
            viewFinderView.setMaskColor(this.u);
            viewFinderView.setBorderCornerRounded(this.f3594x);
            viewFinderView.setBorderCornerRadius(this.f3595y);
            viewFinderView.setSquareViewFinder(this.f3596z);
            viewFinderView.setViewFinderOffset(this.B);
            this.l = viewFinderView;
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
    }

    public void a() {
        if (this.j != null) {
            this.k.e();
            CameraPreview2 cameraPreview2 = this.k;
            cameraPreview2.j = null;
            cameraPreview2.p = null;
            this.j.a.release();
            this.j = null;
        }
        CameraHandlerThread2 cameraHandlerThread2 = this.n;
        if (cameraHandlerThread2 != null) {
            cameraHandlerThread2.quit();
            this.n = null;
        }
    }

    public boolean getFlash() {
        CameraWrapper cameraWrapper = this.j;
        return cameraWrapper != null && b.i.a.f.e.o.f.C0(cameraWrapper.a) && this.j.a.getParameters().getFlashMode().equals("torch");
    }

    public int getRotationCount() {
        return this.k.getDisplayOrientation() / 90;
    }

    public void setAspectTolerance(float f) {
        this.C = f;
    }

    public void setAutoFocus(boolean z2) {
        this.p = z2;
        CameraPreview2 cameraPreview2 = this.k;
        if (cameraPreview2 != null) {
            cameraPreview2.setAutoFocus(z2);
        }
    }

    public void setBorderAlpha(float f) {
        this.A = f;
        ((ViewFinderView) this.l).setBorderAlpha(f);
        ViewFinderView viewFinderView = (ViewFinderView) this.l;
        viewFinderView.a();
        viewFinderView.invalidate();
    }

    public void setBorderColor(int i) {
        this.t = i;
        ((ViewFinderView) this.l).setBorderColor(i);
        ViewFinderView viewFinderView = (ViewFinderView) this.l;
        viewFinderView.a();
        viewFinderView.invalidate();
    }

    public void setBorderCornerRadius(int i) {
        this.f3595y = i;
        ((ViewFinderView) this.l).setBorderCornerRadius(i);
        ViewFinderView viewFinderView = (ViewFinderView) this.l;
        viewFinderView.a();
        viewFinderView.invalidate();
    }

    public void setBorderLineLength(int i) {
        this.w = i;
        ((ViewFinderView) this.l).setBorderLineLength(i);
        ViewFinderView viewFinderView = (ViewFinderView) this.l;
        viewFinderView.a();
        viewFinderView.invalidate();
    }

    public void setBorderStrokeWidth(int i) {
        this.v = i;
        ((ViewFinderView) this.l).setBorderStrokeWidth(i);
        ViewFinderView viewFinderView = (ViewFinderView) this.l;
        viewFinderView.a();
        viewFinderView.invalidate();
    }

    public void setFlash(boolean z2) {
        this.o = Boolean.valueOf(z2);
        CameraWrapper cameraWrapper = this.j;
        if (cameraWrapper == null || !b.i.a.f.e.o.f.C0(cameraWrapper.a)) {
            return;
        }
        Camera.Parameters parameters = this.j.a.getParameters();
        if (z2) {
            if (parameters.getFlashMode().equals("torch")) {
                return;
            } else {
                parameters.setFlashMode("torch");
            }
        } else if (parameters.getFlashMode().equals("off")) {
            return;
        } else {
            parameters.setFlashMode("off");
        }
        this.j.a.setParameters(parameters);
    }

    public void setIsBorderCornerRounded(boolean z2) {
        this.f3594x = z2;
        ((ViewFinderView) this.l).setBorderCornerRounded(z2);
        ViewFinderView viewFinderView = (ViewFinderView) this.l;
        viewFinderView.a();
        viewFinderView.invalidate();
    }

    public void setLaserColor(int i) {
        this.f3593s = i;
        ((ViewFinderView) this.l).setLaserColor(i);
        ViewFinderView viewFinderView = (ViewFinderView) this.l;
        viewFinderView.a();
        viewFinderView.invalidate();
    }

    public void setLaserEnabled(boolean z2) {
        this.r = z2;
        ((ViewFinderView) this.l).setLaserEnabled(z2);
        ViewFinderView viewFinderView = (ViewFinderView) this.l;
        viewFinderView.a();
        viewFinderView.invalidate();
    }

    public void setMaskColor(int i) {
        this.u = i;
        ((ViewFinderView) this.l).setMaskColor(i);
        ViewFinderView viewFinderView = (ViewFinderView) this.l;
        viewFinderView.a();
        viewFinderView.invalidate();
    }

    public void setShouldScaleToFill(boolean z2) {
        this.q = z2;
    }

    public void setSquareViewFinder(boolean z2) {
        this.f3596z = z2;
        ((ViewFinderView) this.l).setSquareViewFinder(z2);
        ViewFinderView viewFinderView = (ViewFinderView) this.l;
        viewFinderView.a();
        viewFinderView.invalidate();
    }

    public void setupCameraPreview(CameraWrapper cameraWrapper) {
        this.j = cameraWrapper;
        if (cameraWrapper != null) {
            setupLayout(cameraWrapper);
            ViewFinderView viewFinderView = (ViewFinderView) this.l;
            viewFinderView.a();
            viewFinderView.invalidate();
            Boolean bool = this.o;
            if (bool != null) {
                setFlash(bool.booleanValue());
            }
            setAutoFocus(this.p);
        }
    }

    public final void setupLayout(CameraWrapper cameraWrapper) {
        removeAllViews();
        CameraPreview2 cameraPreview2 = new CameraPreview2(getContext(), cameraWrapper, this);
        this.k = cameraPreview2;
        cameraPreview2.setAspectTolerance(this.C);
        this.k.setShouldScaleToFill(this.q);
        if (this.q) {
            addView(this.k);
        } else {
            RelativeLayout relativeLayout = new RelativeLayout(getContext());
            relativeLayout.setGravity(17);
            relativeLayout.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
            relativeLayout.addView(this.k);
            addView(relativeLayout);
        }
        Object obj = this.l;
        if (!(obj instanceof View)) {
            throw new IllegalArgumentException("IViewFinder object returned by 'createViewFinderView()' should be instance of android.view.View");
        }
        addView((View) obj);
    }
}
