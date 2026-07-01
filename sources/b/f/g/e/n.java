package b.f.g.e;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Matrix$ScaleToFit;
import android.graphics.Path;
import android.graphics.Path$Direction;
import android.graphics.Path$FillType;
import android.graphics.PorterDuff$Mode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import java.util.Arrays;

/* JADX INFO: compiled from: RoundedDrawable.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class n extends Drawable implements j, d0 {

    @Nullable
    @VisibleForTesting
    public Matrix E;

    @Nullable
    @VisibleForTesting
    public Matrix F;

    @Nullable
    public e0 L;
    public final Drawable j;

    @Nullable
    @VisibleForTesting
    public float[] t;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    @Nullable
    @VisibleForTesting
    public RectF f519y;
    public boolean k = false;
    public boolean l = false;
    public float m = 0.0f;
    public final Path n = new Path();
    public boolean o = true;
    public int p = 0;
    public final Path q = new Path();
    public final float[] r = new float[8];

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @VisibleForTesting
    public final float[] f517s = new float[8];

    @VisibleForTesting
    public final RectF u = new RectF();

    @VisibleForTesting
    public final RectF v = new RectF();

    @VisibleForTesting
    public final RectF w = new RectF();

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    @VisibleForTesting
    public final RectF f518x = new RectF();

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    @VisibleForTesting
    public final Matrix f520z = new Matrix();

    @VisibleForTesting
    public final Matrix A = new Matrix();

    @VisibleForTesting
    public final Matrix B = new Matrix();

    @VisibleForTesting
    public final Matrix C = new Matrix();

    @VisibleForTesting
    public final Matrix D = new Matrix();

    @VisibleForTesting
    public final Matrix G = new Matrix();
    public float H = 0.0f;
    public boolean I = false;
    public boolean J = false;
    public boolean K = true;

    public n(Drawable drawable) {
        this.j = drawable;
    }

    @Override // b.f.g.e.j
    public void a(int i, float f) {
        if (this.p == i && this.m == f) {
            return;
        }
        this.p = i;
        this.m = f;
        this.K = true;
        invalidateSelf();
    }

    @Override // b.f.g.e.d0
    public void b(@Nullable e0 e0Var) {
        this.L = e0Var;
    }

    @Override // b.f.g.e.j
    public void c(boolean z2) {
        this.k = z2;
        this.K = true;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void clearColorFilter() {
        this.j.clearColorFilter();
    }

    @VisibleForTesting
    public boolean d() {
        return this.k || this.l || this.m > 0.0f;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        b.f.j.r.b.b();
        this.j.draw(canvas);
        b.f.j.r.b.b();
    }

    @Override // b.f.g.e.j
    public void e(boolean z2) {
        if (this.J != z2) {
            this.J = z2;
            invalidateSelf();
        }
    }

    @Override // b.f.g.e.j
    public void f(boolean z2) {
        if (this.I != z2) {
            this.I = z2;
            this.K = true;
            invalidateSelf();
        }
    }

    public void g() {
        float[] fArr;
        if (this.K) {
            this.q.reset();
            RectF rectF = this.u;
            float f = this.m;
            rectF.inset(f / 2.0f, f / 2.0f);
            if (this.k) {
                this.q.addCircle(this.u.centerX(), this.u.centerY(), Math.min(this.u.width(), this.u.height()) / 2.0f, Path$Direction.CW);
            } else {
                int i = 0;
                while (true) {
                    fArr = this.f517s;
                    if (i >= fArr.length) {
                        break;
                    }
                    fArr[i] = (this.r[i] + this.H) - (this.m / 2.0f);
                    i++;
                }
                this.q.addRoundRect(this.u, fArr, Path$Direction.CW);
            }
            RectF rectF2 = this.u;
            float f2 = this.m;
            rectF2.inset((-f2) / 2.0f, (-f2) / 2.0f);
            this.n.reset();
            float f3 = this.H + (this.I ? this.m : 0.0f);
            this.u.inset(f3, f3);
            if (this.k) {
                this.n.addCircle(this.u.centerX(), this.u.centerY(), Math.min(this.u.width(), this.u.height()) / 2.0f, Path$Direction.CW);
            } else if (this.I) {
                if (this.t == null) {
                    this.t = new float[8];
                }
                for (int i2 = 0; i2 < this.f517s.length; i2++) {
                    this.t[i2] = this.r[i2] - this.m;
                }
                this.n.addRoundRect(this.u, this.t, Path$Direction.CW);
            } else {
                this.n.addRoundRect(this.u, this.r, Path$Direction.CW);
            }
            float f4 = -f3;
            this.u.inset(f4, f4);
            this.n.setFillType(Path$FillType.WINDING);
            this.K = false;
        }
    }

    @Override // android.graphics.drawable.Drawable
    @RequiresApi(api = 19)
    public int getAlpha() {
        return this.j.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    @Nullable
    @RequiresApi(api = 21)
    public ColorFilter getColorFilter() {
        return this.j.getColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.j.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.j.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.j.getOpacity();
    }

    public void h() {
        Matrix matrix;
        e0 e0Var = this.L;
        if (e0Var != null) {
            e0Var.d(this.B);
            this.L.h(this.u);
        } else {
            this.B.reset();
            this.u.set(getBounds());
        }
        this.w.set(0.0f, 0.0f, getIntrinsicWidth(), getIntrinsicHeight());
        this.f518x.set(this.j.getBounds());
        this.f520z.setRectToRect(this.w, this.f518x, Matrix$ScaleToFit.FILL);
        if (this.I) {
            RectF rectF = this.f519y;
            if (rectF == null) {
                this.f519y = new RectF(this.u);
            } else {
                rectF.set(this.u);
            }
            RectF rectF2 = this.f519y;
            float f = this.m;
            rectF2.inset(f, f);
            if (this.E == null) {
                this.E = new Matrix();
            }
            this.E.setRectToRect(this.u, this.f519y, Matrix$ScaleToFit.FILL);
        } else {
            Matrix matrix2 = this.E;
            if (matrix2 != null) {
                matrix2.reset();
            }
        }
        if (!this.B.equals(this.C) || !this.f520z.equals(this.A) || ((matrix = this.E) != null && !matrix.equals(this.F))) {
            this.o = true;
            this.B.invert(this.D);
            this.G.set(this.B);
            if (this.I) {
                this.G.postConcat(this.E);
            }
            this.G.preConcat(this.f520z);
            this.C.set(this.B);
            this.A.set(this.f520z);
            if (this.I) {
                Matrix matrix3 = this.F;
                if (matrix3 == null) {
                    this.F = new Matrix(this.E);
                } else {
                    matrix3.set(this.E);
                }
            } else {
                Matrix matrix4 = this.F;
                if (matrix4 != null) {
                    matrix4.reset();
                }
            }
        }
        if (this.u.equals(this.v)) {
            return;
        }
        this.K = true;
        this.v.set(this.u);
    }

    @Override // b.f.g.e.j
    public void i(float f) {
        if (this.H != f) {
            this.H = f;
            this.K = true;
            invalidateSelf();
        }
    }

    @Override // b.f.g.e.j
    public void j(float f) {
        b.c.a.a0.d.B(f >= 0.0f);
        Arrays.fill(this.r, f);
        this.l = f != 0.0f;
        this.K = true;
        invalidateSelf();
    }

    @Override // b.f.g.e.j
    public void m(float[] fArr) {
        if (fArr == null) {
            Arrays.fill(this.r, 0.0f);
            this.l = false;
        } else {
            b.c.a.a0.d.k(fArr.length == 8, "radii should have exactly 8 values");
            System.arraycopy(fArr, 0, this.r, 0, 8);
            this.l = false;
            for (int i = 0; i < 8; i++) {
                this.l |= fArr[i] > 0.0f;
            }
        }
        this.K = true;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        this.j.setBounds(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.j.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(int i, @NonNull PorterDuff$Mode porterDuff$Mode) {
        this.j.setColorFilter(i, porterDuff$Mode);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        this.j.setColorFilter(colorFilter);
    }
}
