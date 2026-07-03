package p007b.p109f.p132g.p142e;

import android.annotation.TargetApi;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import java.util.Objects;
import p007b.p085c.p086a.p087a0.C1460d;

/* JADX INFO: renamed from: b.f.g.e.b */
/* JADX INFO: compiled from: ArrayDrawable.java */
/* JADX INFO: loaded from: classes.dex */
public class C1762b extends Drawable implements Drawable.Callback, InterfaceC1769e0, InterfaceC1767d0 {

    /* JADX INFO: renamed from: j */
    public InterfaceC1769e0 f3326j;

    /* JADX INFO: renamed from: l */
    public final Drawable[] f3328l;

    /* JADX INFO: renamed from: m */
    public final InterfaceC1766d[] f3329m;

    /* JADX INFO: renamed from: k */
    public final C1768e f3327k = new C1768e();

    /* JADX INFO: renamed from: n */
    public final Rect f3330n = new Rect();

    /* JADX INFO: renamed from: o */
    public boolean f3331o = false;

    /* JADX INFO: renamed from: p */
    public boolean f3332p = false;

    /* JADX INFO: renamed from: q */
    public boolean f3333q = false;

    public C1762b(Drawable[] drawableArr) {
        int i = 0;
        Objects.requireNonNull(drawableArr);
        this.f3328l = drawableArr;
        while (true) {
            Drawable[] drawableArr2 = this.f3328l;
            if (i >= drawableArr2.length) {
                this.f3329m = new InterfaceC1766d[drawableArr2.length];
                return;
            } else {
                C1460d.m488X1(drawableArr2[i], this, this);
                i++;
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public Drawable m1093a(int i) {
        C1460d.m527i(Boolean.valueOf(i >= 0));
        C1460d.m527i(Boolean.valueOf(i < this.f3328l.length));
        return this.f3328l[i];
    }

    @Override // p007b.p109f.p132g.p142e.InterfaceC1767d0
    /* JADX INFO: renamed from: b */
    public void mo1094b(InterfaceC1769e0 interfaceC1769e0) {
        this.f3326j = interfaceC1769e0;
    }

    /* JADX INFO: renamed from: c */
    public Drawable m1095c(int i, Drawable drawable) {
        C1460d.m527i(Boolean.valueOf(i >= 0));
        C1460d.m527i(Boolean.valueOf(i < this.f3328l.length));
        Drawable drawable2 = this.f3328l[i];
        if (drawable != drawable2) {
            if (drawable != null && this.f3333q) {
                drawable.mutate();
            }
            C1460d.m488X1(this.f3328l[i], null, null);
            C1460d.m488X1(drawable, null, null);
            C1460d.m494Z1(drawable, this.f3327k);
            C1460d.m450L(drawable, this);
            C1460d.m488X1(drawable, this, this);
            this.f3332p = false;
            this.f3328l[i] = drawable;
            invalidateSelf();
        }
        return drawable2;
    }

    @Override // p007b.p109f.p132g.p142e.InterfaceC1769e0
    /* JADX INFO: renamed from: d */
    public void mo1096d(Matrix matrix) {
        InterfaceC1769e0 interfaceC1769e0 = this.f3326j;
        if (interfaceC1769e0 != null) {
            interfaceC1769e0.mo1096d(matrix);
        } else {
            matrix.reset();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        int i = 0;
        while (true) {
            Drawable[] drawableArr = this.f3328l;
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
            Drawable[] drawableArr = this.f3328l;
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
            Drawable[] drawableArr = this.f3328l;
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
        if (this.f3328l.length == 0) {
            return -2;
        }
        int iResolveOpacity = -1;
        int i = 1;
        while (true) {
            Drawable[] drawableArr = this.f3328l;
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
        Rect rect2 = this.f3330n;
        while (true) {
            Drawable[] drawableArr = this.f3328l;
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

    @Override // p007b.p109f.p132g.p142e.InterfaceC1769e0
    /* JADX INFO: renamed from: h */
    public void mo1097h(RectF rectF) {
        InterfaceC1769e0 interfaceC1769e0 = this.f3326j;
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
        if (!this.f3332p) {
            this.f3331o = false;
            int i = 0;
            while (true) {
                Drawable[] drawableArr = this.f3328l;
                boolean z2 = true;
                if (i >= drawableArr.length) {
                    break;
                }
                Drawable drawable = drawableArr[i];
                boolean z3 = this.f3331o;
                if (drawable == null || !drawable.isStateful()) {
                    z2 = false;
                }
                this.f3331o = z3 | z2;
                i++;
            }
            this.f3332p = true;
        }
        return this.f3331o;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        int i = 0;
        while (true) {
            Drawable[] drawableArr = this.f3328l;
            if (i >= drawableArr.length) {
                this.f3333q = true;
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
            Drawable[] drawableArr = this.f3328l;
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
            Drawable[] drawableArr = this.f3328l;
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
            Drawable[] drawableArr = this.f3328l;
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
        this.f3327k.f3339a = i;
        int i2 = 0;
        while (true) {
            Drawable[] drawableArr = this.f3328l;
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
        C1768e c1768e = this.f3327k;
        c1768e.f3341c = colorFilter;
        int i = 0;
        c1768e.f3340b = colorFilter != null;
        while (true) {
            Drawable[] drawableArr = this.f3328l;
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
        this.f3327k.f3342d = z2 ? 1 : 0;
        int i = 0;
        while (true) {
            Drawable[] drawableArr = this.f3328l;
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
        this.f3327k.f3343e = z2 ? 1 : 0;
        int i = 0;
        while (true) {
            Drawable[] drawableArr = this.f3328l;
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
            Drawable[] drawableArr = this.f3328l;
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
            Drawable[] drawableArr = this.f3328l;
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
