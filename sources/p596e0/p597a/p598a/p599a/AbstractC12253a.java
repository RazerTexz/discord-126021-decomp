package p596e0.p597a.p598a.p599a;

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
import me.dm7.barcodescanner.core.C12923R;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;

/* JADX INFO: renamed from: e0.a.a.a.a */
/* JADX INFO: compiled from: BarcodeScannerView.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC12253a extends FrameLayout implements Camera.PreviewCallback {

    /* JADX INFO: renamed from: A */
    public float f25296A;

    /* JADX INFO: renamed from: B */
    public int f25297B;

    /* JADX INFO: renamed from: C */
    public float f25298C;

    /* JADX INFO: renamed from: j */
    public C12257e f25299j;

    /* JADX INFO: renamed from: k */
    public SurfaceHolderCallbackC12256d f25300k;

    /* JADX INFO: renamed from: l */
    public InterfaceC12258f f25301l;

    /* JADX INFO: renamed from: m */
    public Rect f25302m;

    /* JADX INFO: renamed from: n */
    public HandlerThreadC12255c f25303n;

    /* JADX INFO: renamed from: o */
    public Boolean f25304o;

    /* JADX INFO: renamed from: p */
    public boolean f25305p;

    /* JADX INFO: renamed from: q */
    public boolean f25306q;

    /* JADX INFO: renamed from: r */
    public boolean f25307r;

    /* JADX INFO: renamed from: s */
    @ColorInt
    public int f25308s;

    /* JADX INFO: renamed from: t */
    @ColorInt
    public int f25309t;

    /* JADX INFO: renamed from: u */
    public int f25310u;

    /* JADX INFO: renamed from: v */
    public int f25311v;

    /* JADX INFO: renamed from: w */
    public int f25312w;

    /* JADX INFO: renamed from: x */
    public boolean f25313x;

    /* JADX INFO: renamed from: y */
    public int f25314y;

    /* JADX INFO: renamed from: z */
    public boolean f25315z;

    public AbstractC12253a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f25305p = true;
        this.f25306q = true;
        this.f25307r = true;
        this.f25308s = getResources().getColor(C12923R.a.viewfinder_laser);
        this.f25309t = getResources().getColor(C12923R.a.viewfinder_border);
        this.f25310u = getResources().getColor(C12923R.a.viewfinder_mask);
        this.f25311v = getResources().getInteger(C12923R.b.viewfinder_border_width);
        this.f25312w = getResources().getInteger(C12923R.b.viewfinder_border_length);
        this.f25313x = false;
        this.f25314y = 0;
        this.f25315z = false;
        this.f25296A = 1.0f;
        this.f25297B = 0;
        this.f25298C = 0.1f;
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, C12923R.c.BarcodeScannerView, 0, 0);
        try {
            setShouldScaleToFill(typedArrayObtainStyledAttributes.getBoolean(C12923R.c.BarcodeScannerView_shouldScaleToFill, true));
            this.f25307r = typedArrayObtainStyledAttributes.getBoolean(C12923R.c.BarcodeScannerView_laserEnabled, this.f25307r);
            this.f25308s = typedArrayObtainStyledAttributes.getColor(C12923R.c.BarcodeScannerView_laserColor, this.f25308s);
            this.f25309t = typedArrayObtainStyledAttributes.getColor(C12923R.c.BarcodeScannerView_borderColor, this.f25309t);
            this.f25310u = typedArrayObtainStyledAttributes.getColor(C12923R.c.BarcodeScannerView_maskColor, this.f25310u);
            this.f25311v = typedArrayObtainStyledAttributes.getDimensionPixelSize(C12923R.c.BarcodeScannerView_borderWidth, this.f25311v);
            this.f25312w = typedArrayObtainStyledAttributes.getDimensionPixelSize(C12923R.c.BarcodeScannerView_borderLength, this.f25312w);
            this.f25313x = typedArrayObtainStyledAttributes.getBoolean(C12923R.c.BarcodeScannerView_roundedCorner, this.f25313x);
            this.f25314y = typedArrayObtainStyledAttributes.getDimensionPixelSize(C12923R.c.BarcodeScannerView_cornerRadius, this.f25314y);
            this.f25315z = typedArrayObtainStyledAttributes.getBoolean(C12923R.c.BarcodeScannerView_squaredFinder, this.f25315z);
            this.f25296A = typedArrayObtainStyledAttributes.getFloat(C12923R.c.BarcodeScannerView_borderAlpha, this.f25296A);
            this.f25297B = typedArrayObtainStyledAttributes.getDimensionPixelSize(C12923R.c.BarcodeScannerView_finderOffset, this.f25297B);
            typedArrayObtainStyledAttributes.recycle();
            C12259g c12259g = new C12259g(getContext());
            c12259g.setBorderColor(this.f25309t);
            c12259g.setLaserColor(this.f25308s);
            c12259g.setLaserEnabled(this.f25307r);
            c12259g.setBorderStrokeWidth(this.f25311v);
            c12259g.setBorderLineLength(this.f25312w);
            c12259g.setMaskColor(this.f25310u);
            c12259g.setBorderCornerRounded(this.f25313x);
            c12259g.setBorderCornerRadius(this.f25314y);
            c12259g.setSquareViewFinder(this.f25315z);
            c12259g.setViewFinderOffset(this.f25297B);
            this.f25301l = c12259g;
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
    }

    /* JADX INFO: renamed from: a */
    public void m10094a() {
        if (this.f25299j != null) {
            this.f25300k.m10099e();
            SurfaceHolderCallbackC12256d surfaceHolderCallbackC12256d = this.f25300k;
            surfaceHolderCallbackC12256d.f25321j = null;
            surfaceHolderCallbackC12256d.f25327p = null;
            this.f25299j.f25333a.release();
            this.f25299j = null;
        }
        HandlerThreadC12255c handlerThreadC12255c = this.f25303n;
        if (handlerThreadC12255c != null) {
            handlerThreadC12255c.quit();
            this.f25303n = null;
        }
    }

    public boolean getFlash() {
        C12257e c12257e = this.f25299j;
        return c12257e != null && C3404f.m4196C0(c12257e.f25333a) && this.f25299j.f25333a.getParameters().getFlashMode().equals("torch");
    }

    public int getRotationCount() {
        return this.f25300k.getDisplayOrientation() / 90;
    }

    public void setAspectTolerance(float f) {
        this.f25298C = f;
    }

    public void setAutoFocus(boolean z2) {
        this.f25305p = z2;
        SurfaceHolderCallbackC12256d surfaceHolderCallbackC12256d = this.f25300k;
        if (surfaceHolderCallbackC12256d != null) {
            surfaceHolderCallbackC12256d.setAutoFocus(z2);
        }
    }

    public void setBorderAlpha(float f) {
        this.f25296A = f;
        ((C12259g) this.f25301l).setBorderAlpha(f);
        C12259g c12259g = (C12259g) this.f25301l;
        c12259g.m10100a();
        c12259g.invalidate();
    }

    public void setBorderColor(int i) {
        this.f25309t = i;
        ((C12259g) this.f25301l).setBorderColor(i);
        C12259g c12259g = (C12259g) this.f25301l;
        c12259g.m10100a();
        c12259g.invalidate();
    }

    public void setBorderCornerRadius(int i) {
        this.f25314y = i;
        ((C12259g) this.f25301l).setBorderCornerRadius(i);
        C12259g c12259g = (C12259g) this.f25301l;
        c12259g.m10100a();
        c12259g.invalidate();
    }

    public void setBorderLineLength(int i) {
        this.f25312w = i;
        ((C12259g) this.f25301l).setBorderLineLength(i);
        C12259g c12259g = (C12259g) this.f25301l;
        c12259g.m10100a();
        c12259g.invalidate();
    }

    public void setBorderStrokeWidth(int i) {
        this.f25311v = i;
        ((C12259g) this.f25301l).setBorderStrokeWidth(i);
        C12259g c12259g = (C12259g) this.f25301l;
        c12259g.m10100a();
        c12259g.invalidate();
    }

    public void setFlash(boolean z2) {
        this.f25304o = Boolean.valueOf(z2);
        C12257e c12257e = this.f25299j;
        if (c12257e == null || !C3404f.m4196C0(c12257e.f25333a)) {
            return;
        }
        Camera.Parameters parameters = this.f25299j.f25333a.getParameters();
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
        this.f25299j.f25333a.setParameters(parameters);
    }

    public void setIsBorderCornerRounded(boolean z2) {
        this.f25313x = z2;
        ((C12259g) this.f25301l).setBorderCornerRounded(z2);
        C12259g c12259g = (C12259g) this.f25301l;
        c12259g.m10100a();
        c12259g.invalidate();
    }

    public void setLaserColor(int i) {
        this.f25308s = i;
        ((C12259g) this.f25301l).setLaserColor(i);
        C12259g c12259g = (C12259g) this.f25301l;
        c12259g.m10100a();
        c12259g.invalidate();
    }

    public void setLaserEnabled(boolean z2) {
        this.f25307r = z2;
        ((C12259g) this.f25301l).setLaserEnabled(z2);
        C12259g c12259g = (C12259g) this.f25301l;
        c12259g.m10100a();
        c12259g.invalidate();
    }

    public void setMaskColor(int i) {
        this.f25310u = i;
        ((C12259g) this.f25301l).setMaskColor(i);
        C12259g c12259g = (C12259g) this.f25301l;
        c12259g.m10100a();
        c12259g.invalidate();
    }

    public void setShouldScaleToFill(boolean z2) {
        this.f25306q = z2;
    }

    public void setSquareViewFinder(boolean z2) {
        this.f25315z = z2;
        ((C12259g) this.f25301l).setSquareViewFinder(z2);
        C12259g c12259g = (C12259g) this.f25301l;
        c12259g.m10100a();
        c12259g.invalidate();
    }

    public void setupCameraPreview(C12257e c12257e) {
        this.f25299j = c12257e;
        if (c12257e != null) {
            setupLayout(c12257e);
            C12259g c12259g = (C12259g) this.f25301l;
            c12259g.m10100a();
            c12259g.invalidate();
            Boolean bool = this.f25304o;
            if (bool != null) {
                setFlash(bool.booleanValue());
            }
            setAutoFocus(this.f25305p);
        }
    }

    public final void setupLayout(C12257e c12257e) {
        removeAllViews();
        SurfaceHolderCallbackC12256d surfaceHolderCallbackC12256d = new SurfaceHolderCallbackC12256d(getContext(), c12257e, this);
        this.f25300k = surfaceHolderCallbackC12256d;
        surfaceHolderCallbackC12256d.setAspectTolerance(this.f25298C);
        this.f25300k.setShouldScaleToFill(this.f25306q);
        if (this.f25306q) {
            addView(this.f25300k);
        } else {
            RelativeLayout relativeLayout = new RelativeLayout(getContext());
            relativeLayout.setGravity(17);
            relativeLayout.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
            relativeLayout.addView(this.f25300k);
            addView(relativeLayout);
        }
        Object obj = this.f25301l;
        if (!(obj instanceof View)) {
            throw new IllegalArgumentException("IViewFinder object returned by 'createViewFinderView()' should be instance of android.view.View");
        }
        addView((View) obj);
    }
}
