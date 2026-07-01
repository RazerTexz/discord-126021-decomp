package b.f.g.e;

import android.annotation.TargetApi;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable$Callback;
import android.graphics.drawable.Drawable$ConstantState;

/* JADX INFO: compiled from: ForwardingDrawable.java */
/* JADX INFO: loaded from: classes.dex */
public class g extends Drawable implements Drawable$Callback, e0, d0, d {
    public static final Matrix j = new Matrix();
    public Drawable k;
    public final e l = new e();
    public e0 m;

    public g(Drawable drawable) {
        this.k = drawable;
        b.c.a.a0.d.X1(drawable, this, this);
    }

    @Override // b.f.g.e.d0
    public void b(e0 e0Var) {
        this.m = e0Var;
    }

    @Override // b.f.g.e.e0
    public void d(Matrix matrix) {
        n(matrix);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Drawable drawable = this.k;
        if (drawable != null) {
            drawable.draw(canvas);
        }
    }

    @Override // b.f.g.e.d
    public Drawable g(Drawable drawable) {
        return o(drawable);
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable$ConstantState getConstantState() {
        Drawable drawable = this.k;
        return drawable == null ? super.getConstantState() : drawable.getConstantState();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable getCurrent() {
        return this.k;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        Drawable drawable = this.k;
        return drawable == null ? super.getIntrinsicHeight() : drawable.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        Drawable drawable = this.k;
        return drawable == null ? super.getIntrinsicWidth() : drawable.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        Drawable drawable = this.k;
        if (drawable == null) {
            return 0;
        }
        return drawable.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        Drawable drawable = this.k;
        return drawable == null ? super.getPadding(rect) : drawable.getPadding(rect);
    }

    @Override // b.f.g.e.e0
    public void h(RectF rectF) {
        e0 e0Var = this.m;
        if (e0Var != null) {
            e0Var.h(rectF);
        } else {
            rectF.set(getBounds());
        }
    }

    @Override // android.graphics.drawable.Drawable$Callback
    public void invalidateDrawable(Drawable drawable) {
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        Drawable drawable = this.k;
        if (drawable == null) {
            return false;
        }
        return drawable.isStateful();
    }

    @Override // b.f.g.e.d
    public Drawable l() {
        return this.k;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        Drawable drawable = this.k;
        if (drawable != null) {
            drawable.mutate();
        }
        return this;
    }

    public void n(Matrix matrix) {
        e0 e0Var = this.m;
        if (e0Var != null) {
            e0Var.d(matrix);
        } else {
            matrix.reset();
        }
    }

    public Drawable o(Drawable drawable) {
        Drawable drawable2 = this.k;
        b.c.a.a0.d.X1(drawable2, null, null);
        b.c.a.a0.d.X1(drawable, null, null);
        b.c.a.a0.d.Z1(drawable, this.l);
        b.c.a.a0.d.L(drawable, this);
        b.c.a.a0.d.X1(drawable, this, this);
        this.k = drawable;
        invalidateSelf();
        return drawable2;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        Drawable drawable = this.k;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLevelChange(int i) {
        Drawable drawable = this.k;
        return drawable == null ? super.onLevelChange(i) : drawable.setLevel(i);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        Drawable drawable = this.k;
        return drawable == null ? super.onStateChange(iArr) : drawable.setState(iArr);
    }

    @Override // android.graphics.drawable.Drawable$Callback
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j2) {
        scheduleSelf(runnable, j2);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.l.a = i;
        Drawable drawable = this.k;
        if (drawable != null) {
            drawable.setAlpha(i);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        e eVar = this.l;
        eVar.c = colorFilter;
        eVar.f506b = colorFilter != null;
        Drawable drawable = this.k;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z2) {
        this.l.d = z2 ? 1 : 0;
        Drawable drawable = this.k;
        if (drawable != null) {
            drawable.setDither(z2);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z2) {
        this.l.e = z2 ? 1 : 0;
        Drawable drawable = this.k;
        if (drawable != null) {
            drawable.setFilterBitmap(z2);
        }
    }

    @Override // android.graphics.drawable.Drawable
    @TargetApi(21)
    public void setHotspot(float f, float f2) {
        Drawable drawable = this.k;
        if (drawable != null) {
            drawable.setHotspot(f, f2);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z2, boolean z3) {
        boolean visible = super.setVisible(z2, z3);
        Drawable drawable = this.k;
        return drawable == null ? visible : drawable.setVisible(z2, z3);
    }

    @Override // android.graphics.drawable.Drawable$Callback
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        unscheduleSelf(runnable);
    }
}
