package p007b.p109f.p132g.p142e;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import androidx.annotation.VisibleForTesting;
import java.util.Arrays;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p085c.p086a.p095y.C1563b;

/* JADX INFO: renamed from: b.f.g.e.m */
/* JADX INFO: compiled from: RoundedCornersDrawable.java */
/* JADX INFO: loaded from: classes.dex */
public class C1779m extends C1772g implements InterfaceC1776j {

    /* JADX INFO: renamed from: A */
    public boolean f3389A;

    /* JADX INFO: renamed from: B */
    public final Path f3390B;

    /* JADX INFO: renamed from: C */
    public final Path f3391C;

    /* JADX INFO: renamed from: D */
    public final RectF f3392D;

    /* JADX INFO: renamed from: n */
    @VisibleForTesting
    public int f3393n;

    /* JADX INFO: renamed from: o */
    public final RectF f3394o;

    /* JADX INFO: renamed from: p */
    public RectF f3395p;

    /* JADX INFO: renamed from: q */
    public Matrix f3396q;

    /* JADX INFO: renamed from: r */
    public final float[] f3397r;

    /* JADX INFO: renamed from: s */
    @VisibleForTesting
    public final float[] f3398s;

    /* JADX INFO: renamed from: t */
    @VisibleForTesting
    public final Paint f3399t;

    /* JADX INFO: renamed from: u */
    public boolean f3400u;

    /* JADX INFO: renamed from: v */
    public float f3401v;

    /* JADX INFO: renamed from: w */
    public int f3402w;

    /* JADX INFO: renamed from: x */
    public int f3403x;

    /* JADX INFO: renamed from: y */
    public float f3404y;

    /* JADX INFO: renamed from: z */
    public boolean f3405z;

    public C1779m(Drawable drawable) {
        super(drawable);
        this.f3393n = 1;
        this.f3394o = new RectF();
        this.f3397r = new float[8];
        this.f3398s = new float[8];
        this.f3399t = new Paint(1);
        this.f3400u = false;
        this.f3401v = 0.0f;
        this.f3402w = 0;
        this.f3403x = 0;
        this.f3404y = 0.0f;
        this.f3405z = false;
        this.f3389A = false;
        this.f3390B = new Path();
        this.f3391C = new Path();
        this.f3392D = new RectF();
    }

    @Override // p007b.p109f.p132g.p142e.InterfaceC1776j
    /* JADX INFO: renamed from: a */
    public void mo1106a(int i, float f) {
        this.f3402w = i;
        this.f3401v = f;
        m1115p();
        invalidateSelf();
    }

    @Override // p007b.p109f.p132g.p142e.InterfaceC1776j
    /* JADX INFO: renamed from: c */
    public void mo1107c(boolean z2) {
        this.f3400u = z2;
        m1115p();
        invalidateSelf();
    }

    @Override // p007b.p109f.p132g.p142e.C1772g, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.f3394o.set(getBounds());
        int iM758h = C1563b.m758h(this.f3393n);
        if (iM758h == 0) {
            if (this.f3405z) {
                RectF rectF = this.f3395p;
                if (rectF == null) {
                    this.f3395p = new RectF(this.f3394o);
                    this.f3396q = new Matrix();
                } else {
                    rectF.set(this.f3394o);
                }
                RectF rectF2 = this.f3395p;
                float f = this.f3401v;
                rectF2.inset(f, f);
                this.f3396q.setRectToRect(this.f3394o, this.f3395p, Matrix.ScaleToFit.FILL);
                int iSave = canvas.save();
                canvas.clipRect(this.f3394o);
                canvas.concat(this.f3396q);
                Drawable drawable = this.f3360k;
                if (drawable != null) {
                    drawable.draw(canvas);
                }
                canvas.restoreToCount(iSave);
            } else {
                Drawable drawable2 = this.f3360k;
                if (drawable2 != null) {
                    drawable2.draw(canvas);
                }
            }
            this.f3399t.setStyle(Paint.Style.FILL);
            this.f3399t.setColor(this.f3403x);
            this.f3399t.setStrokeWidth(0.0f);
            this.f3399t.setFilterBitmap(this.f3389A);
            this.f3390B.setFillType(Path.FillType.EVEN_ODD);
            canvas.drawPath(this.f3390B, this.f3399t);
            if (this.f3400u) {
                float fWidth = ((this.f3394o.width() - this.f3394o.height()) + this.f3401v) / 2.0f;
                float fHeight = ((this.f3394o.height() - this.f3394o.width()) + this.f3401v) / 2.0f;
                if (fWidth > 0.0f) {
                    RectF rectF3 = this.f3394o;
                    float f2 = rectF3.left;
                    canvas.drawRect(f2, rectF3.top, f2 + fWidth, rectF3.bottom, this.f3399t);
                    RectF rectF4 = this.f3394o;
                    float f3 = rectF4.right;
                    canvas.drawRect(f3 - fWidth, rectF4.top, f3, rectF4.bottom, this.f3399t);
                }
                if (fHeight > 0.0f) {
                    RectF rectF5 = this.f3394o;
                    float f4 = rectF5.left;
                    float f5 = rectF5.top;
                    canvas.drawRect(f4, f5, rectF5.right, f5 + fHeight, this.f3399t);
                    RectF rectF6 = this.f3394o;
                    float f6 = rectF6.left;
                    float f7 = rectF6.bottom;
                    canvas.drawRect(f6, f7 - fHeight, rectF6.right, f7, this.f3399t);
                }
            }
        } else if (iM758h == 1) {
            int iSave2 = canvas.save();
            canvas.clipPath(this.f3390B);
            Drawable drawable3 = this.f3360k;
            if (drawable3 != null) {
                drawable3.draw(canvas);
            }
            canvas.restoreToCount(iSave2);
        }
        if (this.f3402w != 0) {
            this.f3399t.setStyle(Paint.Style.STROKE);
            this.f3399t.setColor(this.f3402w);
            this.f3399t.setStrokeWidth(this.f3401v);
            this.f3390B.setFillType(Path.FillType.EVEN_ODD);
            canvas.drawPath(this.f3391C, this.f3399t);
        }
    }

    @Override // p007b.p109f.p132g.p142e.InterfaceC1776j
    /* JADX INFO: renamed from: e */
    public void mo1108e(boolean z2) {
        if (this.f3389A != z2) {
            this.f3389A = z2;
            invalidateSelf();
        }
    }

    @Override // p007b.p109f.p132g.p142e.InterfaceC1776j
    /* JADX INFO: renamed from: f */
    public void mo1109f(boolean z2) {
        this.f3405z = z2;
        m1115p();
        invalidateSelf();
    }

    @Override // p007b.p109f.p132g.p142e.InterfaceC1776j
    /* JADX INFO: renamed from: i */
    public void mo1110i(float f) {
        this.f3404y = f;
        m1115p();
        invalidateSelf();
    }

    @Override // p007b.p109f.p132g.p142e.InterfaceC1776j
    /* JADX INFO: renamed from: j */
    public void mo1111j(float f) {
        Arrays.fill(this.f3397r, f);
        m1115p();
        invalidateSelf();
    }

    @Override // p007b.p109f.p132g.p142e.InterfaceC1776j
    /* JADX INFO: renamed from: m */
    public void mo1112m(float[] fArr) {
        if (fArr == null) {
            Arrays.fill(this.f3397r, 0.0f);
        } else {
            C1460d.m535k(fArr.length == 8, "radii should have exactly 8 values");
            System.arraycopy(fArr, 0, this.f3397r, 0, 8);
        }
        m1115p();
        invalidateSelf();
    }

    @Override // p007b.p109f.p132g.p142e.C1772g, android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        Drawable drawable = this.f3360k;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
        m1115p();
    }

    /* JADX INFO: renamed from: p */
    public final void m1115p() {
        float[] fArr;
        this.f3390B.reset();
        this.f3391C.reset();
        this.f3392D.set(getBounds());
        RectF rectF = this.f3392D;
        float f = this.f3404y;
        rectF.inset(f, f);
        if (this.f3393n == 1) {
            this.f3390B.addRect(this.f3392D, Path.Direction.CW);
        }
        if (this.f3400u) {
            this.f3390B.addCircle(this.f3392D.centerX(), this.f3392D.centerY(), Math.min(this.f3392D.width(), this.f3392D.height()) / 2.0f, Path.Direction.CW);
        } else {
            this.f3390B.addRoundRect(this.f3392D, this.f3397r, Path.Direction.CW);
        }
        RectF rectF2 = this.f3392D;
        float f2 = -this.f3404y;
        rectF2.inset(f2, f2);
        RectF rectF3 = this.f3392D;
        float f3 = this.f3401v / 2.0f;
        rectF3.inset(f3, f3);
        if (this.f3400u) {
            this.f3391C.addCircle(this.f3392D.centerX(), this.f3392D.centerY(), Math.min(this.f3392D.width(), this.f3392D.height()) / 2.0f, Path.Direction.CW);
        } else {
            int i = 0;
            while (true) {
                fArr = this.f3398s;
                if (i >= fArr.length) {
                    break;
                }
                fArr[i] = (this.f3397r[i] + this.f3404y) - (this.f3401v / 2.0f);
                i++;
            }
            this.f3391C.addRoundRect(this.f3392D, fArr, Path.Direction.CW);
        }
        RectF rectF4 = this.f3392D;
        float f4 = (-this.f3401v) / 2.0f;
        rectF4.inset(f4, f4);
    }
}
