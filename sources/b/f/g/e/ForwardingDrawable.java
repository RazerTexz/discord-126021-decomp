package b.f.g.e;

import android.annotation.TargetApi;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import b.c.a.a0.AnimatableValueParser;

/* JADX INFO: renamed from: b.f.g.e.g, reason: use source file name */
/* JADX INFO: compiled from: ForwardingDrawable.java */
/* JADX INFO: loaded from: classes.dex */
public class ForwardingDrawable extends Drawable implements Drawable.Callback, TransformCallback, TransformAwareDrawable, DrawableParent {
    public static final Matrix j = new Matrix();
    public Drawable k;
    public final DrawableProperties l = new DrawableProperties();
    public TransformCallback m;

    public ForwardingDrawable(Drawable drawable) {
        this.k = drawable;
        AnimatableValueParser.X1(drawable, this, this);
    }

    @Override // b.f.g.e.TransformAwareDrawable
    public void b(TransformCallback transformCallback) {
        this.m = transformCallback;
    }

    @Override // b.f.g.e.TransformCallback
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

    @Override // b.f.g.e.DrawableParent
    public Drawable g(Drawable drawable) {
        return o(drawable);
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
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

    @Override // b.f.g.e.TransformCallback
    public void h(RectF rectF) {
        TransformCallback transformCallback = this.m;
        if (transformCallback != null) {
            transformCallback.h(rectF);
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
        Drawable drawable = this.k;
        if (drawable == null) {
            return false;
        }
        return drawable.isStateful();
    }

    @Override // b.f.g.e.DrawableParent
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
        TransformCallback transformCallback = this.m;
        if (transformCallback != null) {
            transformCallback.d(matrix);
        } else {
            matrix.reset();
        }
    }

    public Drawable o(Drawable drawable) {
        Drawable drawable2 = this.k;
        AnimatableValueParser.X1(drawable2, null, null);
        AnimatableValueParser.X1(drawable, null, null);
        AnimatableValueParser.Z1(drawable, this.l);
        AnimatableValueParser.L(drawable, this);
        AnimatableValueParser.X1(drawable, this, this);
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

    @Override // android.graphics.drawable.Drawable.Callback
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
        DrawableProperties drawableProperties = this.l;
        drawableProperties.c = colorFilter;
        drawableProperties.f506b = colorFilter != null;
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

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        unscheduleSelf(runnable);
    }
}
