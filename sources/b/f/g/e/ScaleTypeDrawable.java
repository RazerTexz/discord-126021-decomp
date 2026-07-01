package b.f.g.e;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import androidx.annotation.VisibleForTesting;
import b.c.a.a0.AnimatableValueParser;
import com.facebook.drawee.drawable.ScalingUtils$ScaleType;

/* JADX INFO: renamed from: b.f.g.e.p, reason: use source file name */
/* JADX INFO: compiled from: ScaleTypeDrawable.java */
/* JADX INFO: loaded from: classes.dex */
public class ScaleTypeDrawable extends ForwardingDrawable {

    @VisibleForTesting
    public ScalingUtils$ScaleType n;

    @VisibleForTesting
    public Object o;

    @VisibleForTesting
    public PointF p;

    @VisibleForTesting
    public int q;

    @VisibleForTesting
    public int r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @VisibleForTesting
    public Matrix f521s;
    public Matrix t;

    public ScaleTypeDrawable(Drawable drawable, ScalingUtils$ScaleType scalingUtils$ScaleType) {
        super(drawable);
        this.p = null;
        this.q = 0;
        this.r = 0;
        this.t = new Matrix();
        this.n = scalingUtils$ScaleType;
    }

    @Override // b.f.g.e.ForwardingDrawable, b.f.g.e.TransformCallback
    public void d(Matrix matrix) {
        n(matrix);
        q();
        Matrix matrix2 = this.f521s;
        if (matrix2 != null) {
            matrix.preConcat(matrix2);
        }
    }

    @Override // b.f.g.e.ForwardingDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        q();
        if (this.f521s == null) {
            Drawable drawable = this.k;
            if (drawable != null) {
                drawable.draw(canvas);
                return;
            }
            return;
        }
        int iSave = canvas.save();
        canvas.clipRect(getBounds());
        canvas.concat(this.f521s);
        Drawable drawable2 = this.k;
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
        canvas.restoreToCount(iSave);
    }

    @Override // b.f.g.e.ForwardingDrawable
    public Drawable o(Drawable drawable) {
        Drawable drawableO = super.o(drawable);
        p();
        return drawableO;
    }

    @Override // b.f.g.e.ForwardingDrawable, android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        p();
    }

    @VisibleForTesting
    public void p() {
        Drawable drawable = this.k;
        if (drawable == null) {
            this.r = 0;
            this.q = 0;
            this.f521s = null;
            return;
        }
        Rect bounds = getBounds();
        int iWidth = bounds.width();
        int iHeight = bounds.height();
        int intrinsicWidth = drawable.getIntrinsicWidth();
        this.q = intrinsicWidth;
        int intrinsicHeight = drawable.getIntrinsicHeight();
        this.r = intrinsicHeight;
        if (intrinsicWidth <= 0 || intrinsicHeight <= 0) {
            drawable.setBounds(bounds);
            this.f521s = null;
            return;
        }
        if (intrinsicWidth == iWidth && intrinsicHeight == iHeight) {
            drawable.setBounds(bounds);
            this.f521s = null;
            return;
        }
        ScalingUtils$ScaleType scalingUtils$ScaleType = this.n;
        ScalingUtils$ScaleType scalingUtils$ScaleType2 = ScalingUtils$ScaleType.a;
        if (scalingUtils$ScaleType == z.l) {
            drawable.setBounds(bounds);
            this.f521s = null;
            return;
        }
        drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
        ScalingUtils$ScaleType scalingUtils$ScaleType3 = this.n;
        Matrix matrix = this.t;
        PointF pointF = this.p;
        scalingUtils$ScaleType3.a(matrix, bounds, intrinsicWidth, intrinsicHeight, pointF != null ? pointF.x : 0.5f, pointF != null ? pointF.y : 0.5f);
        this.f521s = this.t;
    }

    public final void q() {
        boolean z2;
        ScalingUtils$ScaleType scalingUtils$ScaleType = this.n;
        boolean z3 = true;
        if (scalingUtils$ScaleType instanceof c0) {
            Object state = ((c0) scalingUtils$ScaleType).getState();
            z2 = state == null || !state.equals(this.o);
            this.o = state;
        } else {
            z2 = false;
        }
        Drawable drawable = this.k;
        if (drawable == null) {
            return;
        }
        if (this.q == drawable.getIntrinsicWidth() && this.r == drawable.getIntrinsicHeight()) {
            z3 = false;
        }
        if (z3 || z2) {
            p();
        }
    }

    public void r(ScalingUtils$ScaleType scalingUtils$ScaleType) {
        if (AnimatableValueParser.g0(this.n, scalingUtils$ScaleType)) {
            return;
        }
        this.n = scalingUtils$ScaleType;
        this.o = null;
        p();
        invalidateSelf();
    }
}
