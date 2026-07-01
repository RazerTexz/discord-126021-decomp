package b.f.g.e;

import android.annotation.TargetApi;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import b.c.a.a0.AnimatableValueParser;
import java.util.Objects;

/* JADX INFO: renamed from: b.f.g.e.b, reason: use source file name */
/* JADX INFO: compiled from: ArrayDrawable.java */
/* JADX INFO: loaded from: classes.dex */
public class ArrayDrawable2 extends Drawable implements Drawable.Callback, TransformCallback, TransformAwareDrawable {
    public TransformCallback j;
    public final Drawable[] l;
    public final DrawableParent[] m;
    public final DrawableProperties k = new DrawableProperties();
    public final Rect n = new Rect();
    public boolean o = false;
    public boolean p = false;
    public boolean q = false;

    public ArrayDrawable2(Drawable[] drawableArr) {
        int i = 0;
        Objects.requireNonNull(drawableArr);
        this.l = drawableArr;
        while (true) {
            Drawable[] drawableArr2 = this.l;
            if (i >= drawableArr2.length) {
                this.m = new DrawableParent[drawableArr2.length];
                return;
            } else {
                AnimatableValueParser.X1(drawableArr2[i], this, this);
                i++;
            }
        }
    }

    public Drawable a(int i) {
        AnimatableValueParser.i(Boolean.valueOf(i >= 0));
        AnimatableValueParser.i(Boolean.valueOf(i < this.l.length));
        return this.l[i];
    }

    @Override // b.f.g.e.TransformAwareDrawable
    public void b(TransformCallback transformCallback) {
        this.j = transformCallback;
    }

    public Drawable c(int i, Drawable drawable) {
        AnimatableValueParser.i(Boolean.valueOf(i >= 0));
        AnimatableValueParser.i(Boolean.valueOf(i < this.l.length));
        Drawable drawable2 = this.l[i];
        if (drawable != drawable2) {
            if (drawable != null && this.q) {
                drawable.mutate();
            }
            AnimatableValueParser.X1(this.l[i], null, null);
            AnimatableValueParser.X1(drawable, null, null);
            AnimatableValueParser.Z1(drawable, this.k);
            AnimatableValueParser.L(drawable, this);
            AnimatableValueParser.X1(drawable, this, this);
            this.p = false;
            this.l[i] = drawable;
            invalidateSelf();
        }
        return drawable2;
    }

    @Override // b.f.g.e.TransformCallback
    public void d(Matrix matrix) {
        TransformCallback transformCallback = this.j;
        if (transformCallback != null) {
            transformCallback.d(matrix);
        } else {
            matrix.reset();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        int i = 0;
        while (true) {
            Drawable[] drawableArr = this.l;
            if (i >= drawableArr.length) {
                return;
            }
            Drawable drawable = drawableArr[i];
            if (drawable != null) {
                drawable.draw(canvas);
            }
            i++;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        int i = 0;
        int iMax = -1;
        while (true) {
            Drawable[] drawableArr = this.l;
            if (i >= drawableArr.length) {
                break;
            }
            Drawable drawable = drawableArr[i];
            if (drawable != null) {
                iMax = Math.max(iMax, drawable.getIntrinsicHeight());
            }
            i++;
        }
        if (iMax > 0) {
            return iMax;
        }
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        int i = 0;
        int iMax = -1;
        while (true) {
            Drawable[] drawableArr = this.l;
            if (i >= drawableArr.length) {
                break;
            }
            Drawable drawable = drawableArr[i];
            if (drawable != null) {
                iMax = Math.max(iMax, drawable.getIntrinsicWidth());
            }
            i++;
        }
        if (iMax > 0) {
            return iMax;
        }
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        if (this.l.length == 0) {
            return -2;
        }
        int iResolveOpacity = -1;
        int i = 1;
        while (true) {
            Drawable[] drawableArr = this.l;
            if (i >= drawableArr.length) {
                return iResolveOpacity;
            }
            Drawable drawable = drawableArr[i];
            if (drawable != null) {
                iResolveOpacity = Drawable.resolveOpacity(iResolveOpacity, drawable.getOpacity());
            }
            i++;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        int i = 0;
        rect.left = 0;
        rect.top = 0;
        rect.right = 0;
        rect.bottom = 0;
        Rect rect2 = this.n;
        while (true) {
            Drawable[] drawableArr = this.l;
            if (i >= drawableArr.length) {
                return true;
            }
            Drawable drawable = drawableArr[i];
            if (drawable != null) {
                drawable.getPadding(rect2);
                rect.left = Math.max(rect.left, rect2.left);
                rect.top = Math.max(rect.top, rect2.top);
                rect.right = Math.max(rect.right, rect2.right);
                rect.bottom = Math.max(rect.bottom, rect2.bottom);
            }
            i++;
        }
    }

    @Override // b.f.g.e.TransformCallback
    public void h(RectF rectF) {
        TransformCallback transformCallback = this.j;
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
        if (!this.p) {
            this.o = false;
            int i = 0;
            while (true) {
                Drawable[] drawableArr = this.l;
                boolean z2 = true;
                if (i >= drawableArr.length) {
                    break;
                }
                Drawable drawable = drawableArr[i];
                boolean z3 = this.o;
                if (drawable == null || !drawable.isStateful()) {
                    z2 = false;
                }
                this.o = z3 | z2;
                i++;
            }
            this.p = true;
        }
        return this.o;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        int i = 0;
        while (true) {
            Drawable[] drawableArr = this.l;
            if (i >= drawableArr.length) {
                this.q = true;
                return this;
            }
            Drawable drawable = drawableArr[i];
            if (drawable != null) {
                drawable.mutate();
            }
            i++;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        int i = 0;
        while (true) {
            Drawable[] drawableArr = this.l;
            if (i >= drawableArr.length) {
                return;
            }
            Drawable drawable = drawableArr[i];
            if (drawable != null) {
                drawable.setBounds(rect);
            }
            i++;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLevelChange(int i) {
        int i2 = 0;
        boolean z2 = false;
        while (true) {
            Drawable[] drawableArr = this.l;
            if (i2 >= drawableArr.length) {
                return z2;
            }
            Drawable drawable = drawableArr[i2];
            if (drawable != null && drawable.setLevel(i)) {
                z2 = true;
            }
            i2++;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        int i = 0;
        boolean z2 = false;
        while (true) {
            Drawable[] drawableArr = this.l;
            if (i >= drawableArr.length) {
                return z2;
            }
            Drawable drawable = drawableArr[i];
            if (drawable != null && drawable.setState(iArr)) {
                z2 = true;
            }
            i++;
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        scheduleSelf(runnable, j);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.k.a = i;
        int i2 = 0;
        while (true) {
            Drawable[] drawableArr = this.l;
            if (i2 >= drawableArr.length) {
                return;
            }
            Drawable drawable = drawableArr[i2];
            if (drawable != null) {
                drawable.setAlpha(i);
            }
            i2++;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        DrawableProperties drawableProperties = this.k;
        drawableProperties.c = colorFilter;
        int i = 0;
        drawableProperties.f506b = colorFilter != null;
        while (true) {
            Drawable[] drawableArr = this.l;
            if (i >= drawableArr.length) {
                return;
            }
            Drawable drawable = drawableArr[i];
            if (drawable != null) {
                drawable.setColorFilter(colorFilter);
            }
            i++;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z2) {
        this.k.d = z2 ? 1 : 0;
        int i = 0;
        while (true) {
            Drawable[] drawableArr = this.l;
            if (i >= drawableArr.length) {
                return;
            }
            Drawable drawable = drawableArr[i];
            if (drawable != null) {
                drawable.setDither(z2);
            }
            i++;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z2) {
        this.k.e = z2 ? 1 : 0;
        int i = 0;
        while (true) {
            Drawable[] drawableArr = this.l;
            if (i >= drawableArr.length) {
                return;
            }
            Drawable drawable = drawableArr[i];
            if (drawable != null) {
                drawable.setFilterBitmap(z2);
            }
            i++;
        }
    }

    @Override // android.graphics.drawable.Drawable
    @TargetApi(21)
    public void setHotspot(float f, float f2) {
        int i = 0;
        while (true) {
            Drawable[] drawableArr = this.l;
            if (i >= drawableArr.length) {
                return;
            }
            Drawable drawable = drawableArr[i];
            if (drawable != null) {
                drawable.setHotspot(f, f2);
            }
            i++;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z2, boolean z3) {
        boolean visible = super.setVisible(z2, z3);
        int i = 0;
        while (true) {
            Drawable[] drawableArr = this.l;
            if (i >= drawableArr.length) {
                return visible;
            }
            Drawable drawable = drawableArr[i];
            if (drawable != null) {
                drawable.setVisible(z2, z3);
            }
            i++;
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        unscheduleSelf(runnable);
    }
}
