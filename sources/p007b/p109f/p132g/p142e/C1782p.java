package p007b.p109f.p132g.p142e;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import androidx.annotation.VisibleForTesting;
import com.facebook.drawee.drawable.ScalingUtils$ScaleType;
import p007b.p085c.p086a.p087a0.C1460d;

/* JADX INFO: renamed from: b.f.g.e.p */
/* JADX INFO: compiled from: ScaleTypeDrawable.java */
/* JADX INFO: loaded from: classes.dex */
public class C1782p extends C1772g {

    /* JADX INFO: renamed from: n */
    @VisibleForTesting
    public ScalingUtils$ScaleType f3435n;

    /* JADX INFO: renamed from: o */
    @VisibleForTesting
    public Object f3436o;

    /* JADX INFO: renamed from: p */
    @VisibleForTesting
    public PointF f3437p;

    /* JADX INFO: renamed from: q */
    @VisibleForTesting
    public int f3438q;

    /* JADX INFO: renamed from: r */
    @VisibleForTesting
    public int f3439r;

    /* JADX INFO: renamed from: s */
    @VisibleForTesting
    public Matrix f3440s;

    /* JADX INFO: renamed from: t */
    public Matrix f3441t;

    public C1782p(Drawable drawable, ScalingUtils$ScaleType scalingUtils$ScaleType) {
        super(drawable);
        this.f3437p = null;
        this.f3438q = 0;
        this.f3439r = 0;
        this.f3441t = new Matrix();
        this.f3435n = scalingUtils$ScaleType;
    }

    @Override // p007b.p109f.p132g.p142e.C1772g, p007b.p109f.p132g.p142e.InterfaceC1769e0
    /* JADX INFO: renamed from: d */
    public void mo1096d(Matrix matrix) {
        m1103n(matrix);
        m1119q();
        Matrix matrix2 = this.f3440s;
        if (matrix2 != null) {
            matrix.preConcat(matrix2);
        }
    }

    @Override // p007b.p109f.p132g.p142e.C1772g, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        m1119q();
        if (this.f3440s == null) {
            Drawable drawable = this.f3360k;
            if (drawable != null) {
                drawable.draw(canvas);
                return;
            }
            return;
        }
        int iSave = canvas.save();
        canvas.clipRect(getBounds());
        canvas.concat(this.f3440s);
        Drawable drawable2 = this.f3360k;
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
        canvas.restoreToCount(iSave);
    }

    @Override // p007b.p109f.p132g.p142e.C1772g
    /* JADX INFO: renamed from: o */
    public Drawable mo1104o(Drawable drawable) {
        Drawable drawableMo1104o = super.mo1104o(drawable);
        m1118p();
        return drawableMo1104o;
    }

    @Override // p007b.p109f.p132g.p142e.C1772g, android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        m1118p();
    }

    @VisibleForTesting
    /* JADX INFO: renamed from: p */
    public void m1118p() {
        Drawable drawable = this.f3360k;
        if (drawable == null) {
            this.f3439r = 0;
            this.f3438q = 0;
            this.f3440s = null;
            return;
        }
        Rect bounds = getBounds();
        int iWidth = bounds.width();
        int iHeight = bounds.height();
        int intrinsicWidth = drawable.getIntrinsicWidth();
        this.f3438q = intrinsicWidth;
        int intrinsicHeight = drawable.getIntrinsicHeight();
        this.f3439r = intrinsicHeight;
        if (intrinsicWidth <= 0 || intrinsicHeight <= 0) {
            drawable.setBounds(bounds);
            this.f3440s = null;
            return;
        }
        if (intrinsicWidth == iWidth && intrinsicHeight == iHeight) {
            drawable.setBounds(bounds);
            this.f3440s = null;
            return;
        }
        ScalingUtils$ScaleType scalingUtils$ScaleType = this.f3435n;
        ScalingUtils$ScaleType scalingUtils$ScaleType2 = ScalingUtils$ScaleType.f19495a;
        if (scalingUtils$ScaleType == C1792z.f3450l) {
            drawable.setBounds(bounds);
            this.f3440s = null;
            return;
        }
        drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
        ScalingUtils$ScaleType scalingUtils$ScaleType3 = this.f3435n;
        Matrix matrix = this.f3441t;
        PointF pointF = this.f3437p;
        scalingUtils$ScaleType3.mo1121a(matrix, bounds, intrinsicWidth, intrinsicHeight, pointF != null ? pointF.x : 0.5f, pointF != null ? pointF.y : 0.5f);
        this.f3440s = this.f3441t;
    }

    /* JADX INFO: renamed from: q */
    public final void m1119q() {
        boolean z2;
        ScalingUtils$ScaleType scalingUtils$ScaleType = this.f3435n;
        boolean z3 = true;
        if (scalingUtils$ScaleType instanceof InterfaceC1765c0) {
            Object state = ((InterfaceC1765c0) scalingUtils$ScaleType).getState();
            z2 = state == null || !state.equals(this.f3436o);
            this.f3436o = state;
        } else {
            z2 = false;
        }
        Drawable drawable = this.f3360k;
        if (drawable == null) {
            return;
        }
        if (this.f3438q == drawable.getIntrinsicWidth() && this.f3439r == drawable.getIntrinsicHeight()) {
            z3 = false;
        }
        if (z3 || z2) {
            m1118p();
        }
    }

    /* JADX INFO: renamed from: r */
    public void m1120r(ScalingUtils$ScaleType scalingUtils$ScaleType) {
        if (C1460d.m520g0(this.f3435n, scalingUtils$ScaleType)) {
            return;
        }
        this.f3435n = scalingUtils$ScaleType;
        this.f3436o = null;
        m1118p();
        invalidateSelf();
    }
}
