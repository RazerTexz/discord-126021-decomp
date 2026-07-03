package p007b.p109f.p132g.p142e;

import android.annotation.TargetApi;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import p007b.p085c.p086a.p087a0.C1460d;

/* JADX INFO: renamed from: b.f.g.e.g */
/* JADX INFO: compiled from: ForwardingDrawable.java */
/* JADX INFO: loaded from: classes.dex */
public class C1772g extends Drawable implements Drawable.Callback, InterfaceC1769e0, InterfaceC1767d0, InterfaceC1766d {

    /* JADX INFO: renamed from: j */
    public static final Matrix f3359j = new Matrix();

    /* JADX INFO: renamed from: k */
    public Drawable f3360k;

    /* JADX INFO: renamed from: l */
    public final C1768e f3361l = new C1768e();

    /* JADX INFO: renamed from: m */
    public InterfaceC1769e0 f3362m;

    public C1772g(Drawable drawable) {
        this.f3360k = drawable;
        C1460d.m488X1(drawable, this, this);
    }

    @Override // p007b.p109f.p132g.p142e.InterfaceC1767d0
    /* JADX INFO: renamed from: b */
    public void mo1094b(InterfaceC1769e0 interfaceC1769e0) {
        this.f3362m = interfaceC1769e0;
    }

    @Override // p007b.p109f.p132g.p142e.InterfaceC1769e0
    /* JADX INFO: renamed from: d */
    public void mo1096d(Matrix matrix) {
        m1103n(matrix);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Drawable drawable = this.f3360k;
        if (drawable != null) {
            drawable.draw(canvas);
        }
    }

    @Override // p007b.p109f.p132g.p142e.InterfaceC1766d
    /* JADX INFO: renamed from: g */
    public Drawable mo1090g(Drawable drawable) {
        return mo1104o(drawable);
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        Drawable drawable = this.f3360k;
        return drawable == null ? super.getConstantState() : drawable.getConstantState();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable getCurrent() {
        return this.f3360k;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        Drawable drawable = this.f3360k;
        return drawable == null ? super.getIntrinsicHeight() : drawable.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        Drawable drawable = this.f3360k;
        return drawable == null ? super.getIntrinsicWidth() : drawable.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        Drawable drawable = this.f3360k;
        if (drawable == null) {
            return 0;
        }
        return drawable.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        Drawable drawable = this.f3360k;
        return drawable == null ? super.getPadding(rect) : drawable.getPadding(rect);
    }

    @Override // p007b.p109f.p132g.p142e.InterfaceC1769e0
    /* JADX INFO: renamed from: h */
    public void mo1097h(RectF rectF) {
        InterfaceC1769e0 interfaceC1769e0 = this.f3362m;
        if (interfaceC1769e0 != null) {
            interfaceC1769e0.mo1097h(rectF);
        } else {
            rectF.set(getBounds());
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        Drawable drawable = this.f3360k;
        if (drawable == null) {
            return false;
        }
        return drawable.isStateful();
    }

    @Override // p007b.p109f.p132g.p142e.InterfaceC1766d
    /* JADX INFO: renamed from: l */
    public Drawable mo1091l() {
        return this.f3360k;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        Drawable drawable = this.f3360k;
        if (drawable != null) {
            drawable.mutate();
        }
        return this;
    }

    /* JADX INFO: renamed from: n */
    public void m1103n(Matrix matrix) {
        InterfaceC1769e0 interfaceC1769e0 = this.f3362m;
        if (interfaceC1769e0 != null) {
            interfaceC1769e0.mo1096d(matrix);
        } else {
            matrix.reset();
        }
    }

    /* JADX INFO: renamed from: o */
    public Drawable mo1104o(Drawable drawable) {
        Drawable drawable2 = this.f3360k;
        C1460d.m488X1(drawable2, null, null);
        C1460d.m488X1(drawable, null, null);
        C1460d.m494Z1(drawable, this.f3361l);
        C1460d.m450L(drawable, this);
        C1460d.m488X1(drawable, this, this);
        this.f3360k = drawable;
        invalidateSelf();
        return drawable2;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        Drawable drawable = this.f3360k;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLevelChange(int i) {
        Drawable drawable = this.f3360k;
        return drawable == null ? super.onLevelChange(i) : drawable.setLevel(i);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        Drawable drawable = this.f3360k;
        return drawable == null ? super.onStateChange(iArr) : drawable.setState(iArr);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        scheduleSelf(runnable, j);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.f3361l.f3339a = i;
        Drawable drawable = this.f3360k;
        if (drawable != null) {
            drawable.setAlpha(i);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        C1768e c1768e = this.f3361l;
        c1768e.f3341c = colorFilter;
        c1768e.f3340b = colorFilter != null;
        Drawable drawable = this.f3360k;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z2) {
        this.f3361l.f3342d = z2 ? 1 : 0;
        Drawable drawable = this.f3360k;
        if (drawable != null) {
            drawable.setDither(z2);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z2) {
        this.f3361l.f3343e = z2 ? 1 : 0;
        Drawable drawable = this.f3360k;
        if (drawable != null) {
            drawable.setFilterBitmap(z2);
        }
    }

    @Override // android.graphics.drawable.Drawable
    @TargetApi(21)
    public void setHotspot(float f, float f2) {
        Drawable drawable = this.f3360k;
        if (drawable != null) {
            drawable.setHotspot(f, f2);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z2, boolean z3) {
        boolean visible = super.setVisible(z2, z3);
        Drawable drawable = this.f3360k;
        return drawable == null ? visible : drawable.setVisible(z2, z3);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        unscheduleSelf(runnable);
    }
}
