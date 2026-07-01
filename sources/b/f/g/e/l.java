package b.f.g.e;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint$Style;
import android.graphics.Path;
import android.graphics.Path$Direction;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import androidx.annotation.VisibleForTesting;
import java.util.Arrays;

/* JADX INFO: compiled from: RoundedColorDrawable.java */
/* JADX INFO: loaded from: classes.dex */
public class l extends Drawable implements j {

    @VisibleForTesting
    public float[] l;
    public int v;
    public final float[] j = new float[8];

    @VisibleForTesting
    public final float[] k = new float[8];

    @VisibleForTesting
    public final Paint m = new Paint(1);
    public boolean n = false;
    public float o = 0.0f;
    public float p = 0.0f;
    public int q = 0;
    public boolean r = false;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f511s = false;

    @VisibleForTesting
    public final Path t = new Path();

    @VisibleForTesting
    public final Path u = new Path();
    public final RectF w = new RectF();

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f512x = 255;

    public l(int i) {
        this.v = 0;
        if (this.v != i) {
            this.v = i;
            invalidateSelf();
        }
    }

    @Override // b.f.g.e.j
    public void a(int i, float f) {
        if (this.q != i) {
            this.q = i;
            invalidateSelf();
        }
        if (this.o != f) {
            this.o = f;
            b();
            invalidateSelf();
        }
    }

    public final void b() {
        float[] fArr;
        float[] fArr2;
        this.t.reset();
        this.u.reset();
        this.w.set(getBounds());
        RectF rectF = this.w;
        float f = this.o;
        rectF.inset(f / 2.0f, f / 2.0f);
        int i = 0;
        if (this.n) {
            this.u.addCircle(this.w.centerX(), this.w.centerY(), Math.min(this.w.width(), this.w.height()) / 2.0f, Path$Direction.CW);
        } else {
            int i2 = 0;
            while (true) {
                fArr = this.k;
                if (i2 >= fArr.length) {
                    break;
                }
                fArr[i2] = (this.j[i2] + this.p) - (this.o / 2.0f);
                i2++;
            }
            this.u.addRoundRect(this.w, fArr, Path$Direction.CW);
        }
        RectF rectF2 = this.w;
        float f2 = this.o;
        rectF2.inset((-f2) / 2.0f, (-f2) / 2.0f);
        float f3 = this.p + (this.r ? this.o : 0.0f);
        this.w.inset(f3, f3);
        if (this.n) {
            this.t.addCircle(this.w.centerX(), this.w.centerY(), Math.min(this.w.width(), this.w.height()) / 2.0f, Path$Direction.CW);
        } else if (this.r) {
            if (this.l == null) {
                this.l = new float[8];
            }
            while (true) {
                fArr2 = this.l;
                if (i >= fArr2.length) {
                    break;
                }
                fArr2[i] = this.j[i] - this.o;
                i++;
            }
            this.t.addRoundRect(this.w, fArr2, Path$Direction.CW);
        } else {
            this.t.addRoundRect(this.w, this.j, Path$Direction.CW);
        }
        float f4 = -f3;
        this.w.inset(f4, f4);
    }

    @Override // b.f.g.e.j
    public void c(boolean z2) {
        this.n = z2;
        b();
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.m.setColor(b.c.a.a0.d.m1(this.v, this.f512x));
        this.m.setStyle(Paint$Style.FILL);
        this.m.setFilterBitmap(this.f511s);
        canvas.drawPath(this.t, this.m);
        if (this.o != 0.0f) {
            this.m.setColor(b.c.a.a0.d.m1(this.q, this.f512x));
            this.m.setStyle(Paint$Style.STROKE);
            this.m.setStrokeWidth(this.o);
            canvas.drawPath(this.u, this.m);
        }
    }

    @Override // b.f.g.e.j
    public void e(boolean z2) {
        if (this.f511s != z2) {
            this.f511s = z2;
            invalidateSelf();
        }
    }

    @Override // b.f.g.e.j
    public void f(boolean z2) {
        if (this.r != z2) {
            this.r = z2;
            b();
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f512x;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        int iM1 = b.c.a.a0.d.m1(this.v, this.f512x) >>> 24;
        if (iM1 == 255) {
            return -1;
        }
        return iM1 == 0 ? -2 : -3;
    }

    @Override // b.f.g.e.j
    public void i(float f) {
        if (this.p != f) {
            this.p = f;
            b();
            invalidateSelf();
        }
    }

    @Override // b.f.g.e.j
    public void j(float f) {
        b.c.a.a0.d.k(f >= 0.0f, "radius should be non negative");
        Arrays.fill(this.j, f);
        b();
        invalidateSelf();
    }

    @Override // b.f.g.e.j
    public void m(float[] fArr) {
        if (fArr == null) {
            Arrays.fill(this.j, 0.0f);
        } else {
            b.c.a.a0.d.k(fArr.length == 8, "radii should have exactly 8 values");
            System.arraycopy(fArr, 0, this.j, 0, 8);
        }
        b();
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        b();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        if (i != this.f512x) {
            this.f512x = i;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }
}
