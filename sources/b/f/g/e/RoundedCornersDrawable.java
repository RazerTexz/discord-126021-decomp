package b.f.g.e;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import androidx.annotation.VisibleForTesting;
import b.c.a.a0.AnimatableValueParser;
import java.util.Arrays;

/* JADX INFO: renamed from: b.f.g.e.m, reason: use source file name */
/* JADX INFO: compiled from: RoundedCornersDrawable.java */
/* JADX INFO: loaded from: classes.dex */
public class RoundedCornersDrawable extends ForwardingDrawable implements Rounded {
    public boolean A;
    public final Path B;
    public final Path C;
    public final RectF D;

    @VisibleForTesting
    public int n;
    public final RectF o;
    public RectF p;
    public Matrix q;
    public final float[] r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @VisibleForTesting
    public final float[] f513s;

    @VisibleForTesting
    public final Paint t;
    public boolean u;
    public float v;
    public int w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f514x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public float f515y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f516z;

    public RoundedCornersDrawable(Drawable drawable) {
        super(drawable);
        this.n = 1;
        this.o = new RectF();
        this.r = new float[8];
        this.f513s = new float[8];
        this.t = new Paint(1);
        this.u = false;
        this.v = 0.0f;
        this.w = 0;
        this.f514x = 0;
        this.f515y = 0.0f;
        this.f516z = false;
        this.A = false;
        this.B = new Path();
        this.C = new Path();
        this.D = new RectF();
    }

    @Override // b.f.g.e.Rounded
    public void a(int i, float f) {
        this.w = i;
        this.v = f;
        p();
        invalidateSelf();
    }

    @Override // b.f.g.e.Rounded
    public void c(boolean z2) {
        this.u = z2;
        p();
        invalidateSelf();
    }

    @Override // b.f.g.e.ForwardingDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.o.set(getBounds());
        int iH = b.c.a.y.b.h(this.n);
        if (iH == 0) {
            if (this.f516z) {
                RectF rectF = this.p;
                if (rectF == null) {
                    this.p = new RectF(this.o);
                    this.q = new Matrix();
                } else {
                    rectF.set(this.o);
                }
                RectF rectF2 = this.p;
                float f = this.v;
                rectF2.inset(f, f);
                this.q.setRectToRect(this.o, this.p, Matrix.ScaleToFit.FILL);
                int iSave = canvas.save();
                canvas.clipRect(this.o);
                canvas.concat(this.q);
                Drawable drawable = this.k;
                if (drawable != null) {
                    drawable.draw(canvas);
                }
                canvas.restoreToCount(iSave);
            } else {
                Drawable drawable2 = this.k;
                if (drawable2 != null) {
                    drawable2.draw(canvas);
                }
            }
            this.t.setStyle(Paint.Style.FILL);
            this.t.setColor(this.f514x);
            this.t.setStrokeWidth(0.0f);
            this.t.setFilterBitmap(this.A);
            this.B.setFillType(Path.FillType.EVEN_ODD);
            canvas.drawPath(this.B, this.t);
            if (this.u) {
                float fWidth = ((this.o.width() - this.o.height()) + this.v) / 2.0f;
                float fHeight = ((this.o.height() - this.o.width()) + this.v) / 2.0f;
                if (fWidth > 0.0f) {
                    RectF rectF3 = this.o;
                    float f2 = rectF3.left;
                    canvas.drawRect(f2, rectF3.top, f2 + fWidth, rectF3.bottom, this.t);
                    RectF rectF4 = this.o;
                    float f3 = rectF4.right;
                    canvas.drawRect(f3 - fWidth, rectF4.top, f3, rectF4.bottom, this.t);
                }
                if (fHeight > 0.0f) {
                    RectF rectF5 = this.o;
                    float f4 = rectF5.left;
                    float f5 = rectF5.top;
                    canvas.drawRect(f4, f5, rectF5.right, f5 + fHeight, this.t);
                    RectF rectF6 = this.o;
                    float f6 = rectF6.left;
                    float f7 = rectF6.bottom;
                    canvas.drawRect(f6, f7 - fHeight, rectF6.right, f7, this.t);
                }
            }
        } else if (iH == 1) {
            int iSave2 = canvas.save();
            canvas.clipPath(this.B);
            Drawable drawable3 = this.k;
            if (drawable3 != null) {
                drawable3.draw(canvas);
            }
            canvas.restoreToCount(iSave2);
        }
        if (this.w != 0) {
            this.t.setStyle(Paint.Style.STROKE);
            this.t.setColor(this.w);
            this.t.setStrokeWidth(this.v);
            this.B.setFillType(Path.FillType.EVEN_ODD);
            canvas.drawPath(this.C, this.t);
        }
    }

    @Override // b.f.g.e.Rounded
    public void e(boolean z2) {
        if (this.A != z2) {
            this.A = z2;
            invalidateSelf();
        }
    }

    @Override // b.f.g.e.Rounded
    public void f(boolean z2) {
        this.f516z = z2;
        p();
        invalidateSelf();
    }

    @Override // b.f.g.e.Rounded
    public void i(float f) {
        this.f515y = f;
        p();
        invalidateSelf();
    }

    @Override // b.f.g.e.Rounded
    public void j(float f) {
        Arrays.fill(this.r, f);
        p();
        invalidateSelf();
    }

    @Override // b.f.g.e.Rounded
    public void m(float[] fArr) {
        if (fArr == null) {
            Arrays.fill(this.r, 0.0f);
        } else {
            AnimatableValueParser.k(fArr.length == 8, "radii should have exactly 8 values");
            System.arraycopy(fArr, 0, this.r, 0, 8);
        }
        p();
        invalidateSelf();
    }

    @Override // b.f.g.e.ForwardingDrawable, android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        Drawable drawable = this.k;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
        p();
    }

    public final void p() {
        float[] fArr;
        this.B.reset();
        this.C.reset();
        this.D.set(getBounds());
        RectF rectF = this.D;
        float f = this.f515y;
        rectF.inset(f, f);
        if (this.n == 1) {
            this.B.addRect(this.D, Path.Direction.CW);
        }
        if (this.u) {
            this.B.addCircle(this.D.centerX(), this.D.centerY(), Math.min(this.D.width(), this.D.height()) / 2.0f, Path.Direction.CW);
        } else {
            this.B.addRoundRect(this.D, this.r, Path.Direction.CW);
        }
        RectF rectF2 = this.D;
        float f2 = -this.f515y;
        rectF2.inset(f2, f2);
        RectF rectF3 = this.D;
        float f3 = this.v / 2.0f;
        rectF3.inset(f3, f3);
        if (this.u) {
            this.C.addCircle(this.D.centerX(), this.D.centerY(), Math.min(this.D.width(), this.D.height()) / 2.0f, Path.Direction.CW);
        } else {
            int i = 0;
            while (true) {
                fArr = this.f513s;
                if (i >= fArr.length) {
                    break;
                }
                fArr[i] = (this.r[i] + this.f515y) - (this.v / 2.0f);
                i++;
            }
            this.C.addRoundRect(this.D, fArr, Path.Direction.CW);
        }
        RectF rectF4 = this.D;
        float f4 = (-this.v) / 2.0f;
        rectF4.inset(f4, f4);
    }
}
