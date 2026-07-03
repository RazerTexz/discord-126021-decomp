package p007b.p109f.p132g.p142e;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import androidx.annotation.VisibleForTesting;
import java.util.Arrays;
import p007b.p085c.p086a.p087a0.C1460d;

/* JADX INFO: renamed from: b.f.g.e.l */
/* JADX INFO: compiled from: RoundedColorDrawable.java */
/* JADX INFO: loaded from: classes.dex */
public class C1778l extends Drawable implements InterfaceC1776j {

    /* JADX INFO: renamed from: l */
    @VisibleForTesting
    public float[] f3376l;

    /* JADX INFO: renamed from: v */
    public int f3386v;

    /* JADX INFO: renamed from: j */
    public final float[] f3374j = new float[8];

    /* JADX INFO: renamed from: k */
    @VisibleForTesting
    public final float[] f3375k = new float[8];

    /* JADX INFO: renamed from: m */
    @VisibleForTesting
    public final Paint f3377m = new Paint(1);

    /* JADX INFO: renamed from: n */
    public boolean f3378n = false;

    /* JADX INFO: renamed from: o */
    public float f3379o = 0.0f;

    /* JADX INFO: renamed from: p */
    public float f3380p = 0.0f;

    /* JADX INFO: renamed from: q */
    public int f3381q = 0;

    /* JADX INFO: renamed from: r */
    public boolean f3382r = false;

    /* JADX INFO: renamed from: s */
    public boolean f3383s = false;

    /* JADX INFO: renamed from: t */
    @VisibleForTesting
    public final Path f3384t = new Path();

    /* JADX INFO: renamed from: u */
    @VisibleForTesting
    public final Path f3385u = new Path();

    /* JADX INFO: renamed from: w */
    public final RectF f3387w = new RectF();

    /* JADX INFO: renamed from: x */
    public int f3388x = 255;

    public C1778l(int i) {
        this.f3386v = 0;
        if (this.f3386v != i) {
            this.f3386v = i;
            invalidateSelf();
        }
    }

    @Override // p007b.p109f.p132g.p142e.InterfaceC1776j
    /* JADX INFO: renamed from: a */
    public void mo1106a(int i, float f) {
        if (this.f3381q != i) {
            this.f3381q = i;
            invalidateSelf();
        }
        if (this.f3379o != f) {
            this.f3379o = f;
            m1114b();
            invalidateSelf();
        }
    }

    /* JADX INFO: renamed from: b */
    public final void m1114b() {
        float[] fArr;
        float[] fArr2;
        this.f3384t.reset();
        this.f3385u.reset();
        this.f3387w.set(getBounds());
        RectF rectF = this.f3387w;
        float f = this.f3379o;
        rectF.inset(f / 2.0f, f / 2.0f);
        int i = 0;
        if (this.f3378n) {
            this.f3385u.addCircle(this.f3387w.centerX(), this.f3387w.centerY(), Math.min(this.f3387w.width(), this.f3387w.height()) / 2.0f, Path.Direction.CW);
        } else {
            int i2 = 0;
            while (true) {
                fArr = this.f3375k;
                if (i2 >= fArr.length) {
                    break;
                }
                fArr[i2] = (this.f3374j[i2] + this.f3380p) - (this.f3379o / 2.0f);
                i2++;
            }
            this.f3385u.addRoundRect(this.f3387w, fArr, Path.Direction.CW);
        }
        RectF rectF2 = this.f3387w;
        float f2 = this.f3379o;
        rectF2.inset((-f2) / 2.0f, (-f2) / 2.0f);
        float f3 = this.f3380p + (this.f3382r ? this.f3379o : 0.0f);
        this.f3387w.inset(f3, f3);
        if (this.f3378n) {
            this.f3384t.addCircle(this.f3387w.centerX(), this.f3387w.centerY(), Math.min(this.f3387w.width(), this.f3387w.height()) / 2.0f, Path.Direction.CW);
        } else if (this.f3382r) {
            if (this.f3376l == null) {
                this.f3376l = new float[8];
            }
            while (true) {
                fArr2 = this.f3376l;
                if (i >= fArr2.length) {
                    break;
                }
                fArr2[i] = this.f3374j[i] - this.f3379o;
                i++;
            }
            this.f3384t.addRoundRect(this.f3387w, fArr2, Path.Direction.CW);
        } else {
            this.f3384t.addRoundRect(this.f3387w, this.f3374j, Path.Direction.CW);
        }
        float f4 = -f3;
        this.f3387w.inset(f4, f4);
    }

    @Override // p007b.p109f.p132g.p142e.InterfaceC1776j
    /* JADX INFO: renamed from: c */
    public void mo1107c(boolean z2) {
        this.f3378n = z2;
        m1114b();
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.f3377m.setColor(C1460d.m545m1(this.f3386v, this.f3388x));
        this.f3377m.setStyle(Paint.Style.FILL);
        this.f3377m.setFilterBitmap(this.f3383s);
        canvas.drawPath(this.f3384t, this.f3377m);
        if (this.f3379o != 0.0f) {
            this.f3377m.setColor(C1460d.m545m1(this.f3381q, this.f3388x));
            this.f3377m.setStyle(Paint.Style.STROKE);
            this.f3377m.setStrokeWidth(this.f3379o);
            canvas.drawPath(this.f3385u, this.f3377m);
        }
    }

    @Override // p007b.p109f.p132g.p142e.InterfaceC1776j
    /* JADX INFO: renamed from: e */
    public void mo1108e(boolean z2) {
        if (this.f3383s != z2) {
            this.f3383s = z2;
            invalidateSelf();
        }
    }

    @Override // p007b.p109f.p132g.p142e.InterfaceC1776j
    /* JADX INFO: renamed from: f */
    public void mo1109f(boolean z2) {
        if (this.f3382r != z2) {
            this.f3382r = z2;
            m1114b();
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f3388x;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        int iM545m1 = C1460d.m545m1(this.f3386v, this.f3388x) >>> 24;
        if (iM545m1 == 255) {
            return -1;
        }
        return iM545m1 == 0 ? -2 : -3;
    }

    @Override // p007b.p109f.p132g.p142e.InterfaceC1776j
    /* JADX INFO: renamed from: i */
    public void mo1110i(float f) {
        if (this.f3380p != f) {
            this.f3380p = f;
            m1114b();
            invalidateSelf();
        }
    }

    @Override // p007b.p109f.p132g.p142e.InterfaceC1776j
    /* JADX INFO: renamed from: j */
    public void mo1111j(float f) {
        C1460d.m535k(f >= 0.0f, "radius should be non negative");
        Arrays.fill(this.f3374j, f);
        m1114b();
        invalidateSelf();
    }

    @Override // p007b.p109f.p132g.p142e.InterfaceC1776j
    /* JADX INFO: renamed from: m */
    public void mo1112m(float[] fArr) {
        if (fArr == null) {
            Arrays.fill(this.f3374j, 0.0f);
        } else {
            C1460d.m535k(fArr.length == 8, "radii should have exactly 8 values");
            System.arraycopy(fArr, 0, this.f3374j, 0, 8);
        }
        m1114b();
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        m1114b();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        if (i != this.f3388x) {
            this.f3388x = i;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }
}
