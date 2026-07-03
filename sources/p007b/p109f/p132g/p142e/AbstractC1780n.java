package p007b.p109f.p132g.p142e;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import java.util.Arrays;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p109f.p161j.p183r.C2030b;

/* JADX INFO: renamed from: b.f.g.e.n */
/* JADX INFO: compiled from: RoundedDrawable.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1780n extends Drawable implements InterfaceC1776j, InterfaceC1767d0 {

    /* JADX INFO: renamed from: E */
    @Nullable
    @VisibleForTesting
    public Matrix f3410E;

    /* JADX INFO: renamed from: F */
    @Nullable
    @VisibleForTesting
    public Matrix f3411F;

    /* JADX INFO: renamed from: L */
    @Nullable
    public InterfaceC1769e0 f3417L;

    /* JADX INFO: renamed from: j */
    public final Drawable f3418j;

    /* JADX INFO: renamed from: t */
    @Nullable
    @VisibleForTesting
    public float[] f3428t;

    /* JADX INFO: renamed from: y */
    @Nullable
    @VisibleForTesting
    public RectF f3433y;

    /* JADX INFO: renamed from: k */
    public boolean f3419k = false;

    /* JADX INFO: renamed from: l */
    public boolean f3420l = false;

    /* JADX INFO: renamed from: m */
    public float f3421m = 0.0f;

    /* JADX INFO: renamed from: n */
    public final Path f3422n = new Path();

    /* JADX INFO: renamed from: o */
    public boolean f3423o = true;

    /* JADX INFO: renamed from: p */
    public int f3424p = 0;

    /* JADX INFO: renamed from: q */
    public final Path f3425q = new Path();

    /* JADX INFO: renamed from: r */
    public final float[] f3426r = new float[8];

    /* JADX INFO: renamed from: s */
    @VisibleForTesting
    public final float[] f3427s = new float[8];

    /* JADX INFO: renamed from: u */
    @VisibleForTesting
    public final RectF f3429u = new RectF();

    /* JADX INFO: renamed from: v */
    @VisibleForTesting
    public final RectF f3430v = new RectF();

    /* JADX INFO: renamed from: w */
    @VisibleForTesting
    public final RectF f3431w = new RectF();

    /* JADX INFO: renamed from: x */
    @VisibleForTesting
    public final RectF f3432x = new RectF();

    /* JADX INFO: renamed from: z */
    @VisibleForTesting
    public final Matrix f3434z = new Matrix();

    /* JADX INFO: renamed from: A */
    @VisibleForTesting
    public final Matrix f3406A = new Matrix();

    /* JADX INFO: renamed from: B */
    @VisibleForTesting
    public final Matrix f3407B = new Matrix();

    /* JADX INFO: renamed from: C */
    @VisibleForTesting
    public final Matrix f3408C = new Matrix();

    /* JADX INFO: renamed from: D */
    @VisibleForTesting
    public final Matrix f3409D = new Matrix();

    /* JADX INFO: renamed from: G */
    @VisibleForTesting
    public final Matrix f3412G = new Matrix();

    /* JADX INFO: renamed from: H */
    public float f3413H = 0.0f;

    /* JADX INFO: renamed from: I */
    public boolean f3414I = false;

    /* JADX INFO: renamed from: J */
    public boolean f3415J = false;

    /* JADX INFO: renamed from: K */
    public boolean f3416K = true;

    public AbstractC1780n(Drawable drawable) {
        this.f3418j = drawable;
    }

    @Override // p007b.p109f.p132g.p142e.InterfaceC1776j
    /* JADX INFO: renamed from: a */
    public void mo1106a(int i, float f) {
        if (this.f3424p == i && this.f3421m == f) {
            return;
        }
        this.f3424p = i;
        this.f3421m = f;
        this.f3416K = true;
        invalidateSelf();
    }

    @Override // p007b.p109f.p132g.p142e.InterfaceC1767d0
    /* JADX INFO: renamed from: b */
    public void mo1094b(@Nullable InterfaceC1769e0 interfaceC1769e0) {
        this.f3417L = interfaceC1769e0;
    }

    @Override // p007b.p109f.p132g.p142e.InterfaceC1776j
    /* JADX INFO: renamed from: c */
    public void mo1107c(boolean z2) {
        this.f3419k = z2;
        this.f3416K = true;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void clearColorFilter() {
        this.f3418j.clearColorFilter();
    }

    @VisibleForTesting
    /* JADX INFO: renamed from: d */
    public boolean mo1113d() {
        return this.f3419k || this.f3420l || this.f3421m > 0.0f;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        C2030b.m1527b();
        this.f3418j.draw(canvas);
        C2030b.m1527b();
    }

    @Override // p007b.p109f.p132g.p142e.InterfaceC1776j
    /* JADX INFO: renamed from: e */
    public void mo1108e(boolean z2) {
        if (this.f3415J != z2) {
            this.f3415J = z2;
            invalidateSelf();
        }
    }

    @Override // p007b.p109f.p132g.p142e.InterfaceC1776j
    /* JADX INFO: renamed from: f */
    public void mo1109f(boolean z2) {
        if (this.f3414I != z2) {
            this.f3414I = z2;
            this.f3416K = true;
            invalidateSelf();
        }
    }

    /* JADX INFO: renamed from: g */
    public void m1116g() {
        float[] fArr;
        if (this.f3416K) {
            this.f3425q.reset();
            RectF rectF = this.f3429u;
            float f = this.f3421m;
            rectF.inset(f / 2.0f, f / 2.0f);
            if (this.f3419k) {
                this.f3425q.addCircle(this.f3429u.centerX(), this.f3429u.centerY(), Math.min(this.f3429u.width(), this.f3429u.height()) / 2.0f, Path.Direction.CW);
            } else {
                int i = 0;
                while (true) {
                    fArr = this.f3427s;
                    if (i >= fArr.length) {
                        break;
                    }
                    fArr[i] = (this.f3426r[i] + this.f3413H) - (this.f3421m / 2.0f);
                    i++;
                }
                this.f3425q.addRoundRect(this.f3429u, fArr, Path.Direction.CW);
            }
            RectF rectF2 = this.f3429u;
            float f2 = this.f3421m;
            rectF2.inset((-f2) / 2.0f, (-f2) / 2.0f);
            this.f3422n.reset();
            float f3 = this.f3413H + (this.f3414I ? this.f3421m : 0.0f);
            this.f3429u.inset(f3, f3);
            if (this.f3419k) {
                this.f3422n.addCircle(this.f3429u.centerX(), this.f3429u.centerY(), Math.min(this.f3429u.width(), this.f3429u.height()) / 2.0f, Path.Direction.CW);
            } else if (this.f3414I) {
                if (this.f3428t == null) {
                    this.f3428t = new float[8];
                }
                for (int i2 = 0; i2 < this.f3427s.length; i2++) {
                    this.f3428t[i2] = this.f3426r[i2] - this.f3421m;
                }
                this.f3422n.addRoundRect(this.f3429u, this.f3428t, Path.Direction.CW);
            } else {
                this.f3422n.addRoundRect(this.f3429u, this.f3426r, Path.Direction.CW);
            }
            float f4 = -f3;
            this.f3429u.inset(f4, f4);
            this.f3422n.setFillType(Path.FillType.WINDING);
            this.f3416K = false;
        }
    }

    @Override // android.graphics.drawable.Drawable
    @RequiresApi(api = 19)
    public int getAlpha() {
        return this.f3418j.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    @Nullable
    @RequiresApi(api = 21)
    public ColorFilter getColorFilter() {
        return this.f3418j.getColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f3418j.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f3418j.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.f3418j.getOpacity();
    }

    /* JADX INFO: renamed from: h */
    public void m1117h() {
        Matrix matrix;
        InterfaceC1769e0 interfaceC1769e0 = this.f3417L;
        if (interfaceC1769e0 != null) {
            interfaceC1769e0.mo1096d(this.f3407B);
            this.f3417L.mo1097h(this.f3429u);
        } else {
            this.f3407B.reset();
            this.f3429u.set(getBounds());
        }
        this.f3431w.set(0.0f, 0.0f, getIntrinsicWidth(), getIntrinsicHeight());
        this.f3432x.set(this.f3418j.getBounds());
        this.f3434z.setRectToRect(this.f3431w, this.f3432x, Matrix.ScaleToFit.FILL);
        if (this.f3414I) {
            RectF rectF = this.f3433y;
            if (rectF == null) {
                this.f3433y = new RectF(this.f3429u);
            } else {
                rectF.set(this.f3429u);
            }
            RectF rectF2 = this.f3433y;
            float f = this.f3421m;
            rectF2.inset(f, f);
            if (this.f3410E == null) {
                this.f3410E = new Matrix();
            }
            this.f3410E.setRectToRect(this.f3429u, this.f3433y, Matrix.ScaleToFit.FILL);
        } else {
            Matrix matrix2 = this.f3410E;
            if (matrix2 != null) {
                matrix2.reset();
            }
        }
        if (!this.f3407B.equals(this.f3408C) || !this.f3434z.equals(this.f3406A) || ((matrix = this.f3410E) != null && !matrix.equals(this.f3411F))) {
            this.f3423o = true;
            this.f3407B.invert(this.f3409D);
            this.f3412G.set(this.f3407B);
            if (this.f3414I) {
                this.f3412G.postConcat(this.f3410E);
            }
            this.f3412G.preConcat(this.f3434z);
            this.f3408C.set(this.f3407B);
            this.f3406A.set(this.f3434z);
            if (this.f3414I) {
                Matrix matrix3 = this.f3411F;
                if (matrix3 == null) {
                    this.f3411F = new Matrix(this.f3410E);
                } else {
                    matrix3.set(this.f3410E);
                }
            } else {
                Matrix matrix4 = this.f3411F;
                if (matrix4 != null) {
                    matrix4.reset();
                }
            }
        }
        if (this.f3429u.equals(this.f3430v)) {
            return;
        }
        this.f3416K = true;
        this.f3430v.set(this.f3429u);
    }

    @Override // p007b.p109f.p132g.p142e.InterfaceC1776j
    /* JADX INFO: renamed from: i */
    public void mo1110i(float f) {
        if (this.f3413H != f) {
            this.f3413H = f;
            this.f3416K = true;
            invalidateSelf();
        }
    }

    @Override // p007b.p109f.p132g.p142e.InterfaceC1776j
    /* JADX INFO: renamed from: j */
    public void mo1111j(float f) {
        C1460d.m419B(f >= 0.0f);
        Arrays.fill(this.f3426r, f);
        this.f3420l = f != 0.0f;
        this.f3416K = true;
        invalidateSelf();
    }

    @Override // p007b.p109f.p132g.p142e.InterfaceC1776j
    /* JADX INFO: renamed from: m */
    public void mo1112m(float[] fArr) {
        if (fArr == null) {
            Arrays.fill(this.f3426r, 0.0f);
            this.f3420l = false;
        } else {
            C1460d.m535k(fArr.length == 8, "radii should have exactly 8 values");
            System.arraycopy(fArr, 0, this.f3426r, 0, 8);
            this.f3420l = false;
            for (int i = 0; i < 8; i++) {
                this.f3420l |= fArr[i] > 0.0f;
            }
        }
        this.f3416K = true;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        this.f3418j.setBounds(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.f3418j.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(int i, @NonNull PorterDuff.Mode mode) {
        this.f3418j.setColorFilter(i, mode);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        this.f3418j.setColorFilter(colorFilter);
    }
}
