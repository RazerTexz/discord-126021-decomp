package b.q.a.l;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.annotation.IntRange;
import androidx.annotation.Nullable;
import b.i.a.f.e.o.f;
import com.yalantis.ucrop.UCropActivity$a;
import java.util.Arrays;

/* JADX INFO: compiled from: CropImageView.java */
/* JADX INFO: loaded from: classes3.dex */
public class a extends c {
    public float A;
    public float B;
    public b.q.a.h.c C;
    public Runnable D;
    public Runnable E;
    public float F;
    public float G;
    public int H;
    public int I;
    public long J;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final RectF f1987y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final Matrix f1988z;

    public a(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // b.q.a.l.c
    public void d() {
        super.d();
        Drawable drawable = getDrawable();
        if (drawable == null) {
            return;
        }
        float intrinsicWidth = drawable.getIntrinsicWidth();
        float intrinsicHeight = drawable.getIntrinsicHeight();
        if (this.A == 0.0f) {
            this.A = intrinsicWidth / intrinsicHeight;
        }
        int i = this.n;
        float f = i;
        float f2 = this.A;
        int i2 = (int) (f / f2);
        int i3 = this.o;
        if (i2 > i3) {
            float f3 = i3;
            int i4 = (int) (f2 * f3);
            int i5 = (i - i4) / 2;
            this.f1987y.set(i5, 0.0f, i4 + i5, f3);
        } else {
            int i6 = (i3 - i2) / 2;
            this.f1987y.set(0.0f, i6, f, i2 + i6);
        }
        h(intrinsicWidth, intrinsicHeight);
        float fWidth = this.f1987y.width();
        float fHeight = this.f1987y.height();
        float fMax = Math.max(this.f1987y.width() / intrinsicWidth, this.f1987y.height() / intrinsicHeight);
        RectF rectF = this.f1987y;
        float f4 = ((fWidth - (intrinsicWidth * fMax)) / 2.0f) + rectF.left;
        float f5 = ((fHeight - (intrinsicHeight * fMax)) / 2.0f) + rectF.top;
        this.m.reset();
        this.m.postScale(fMax, fMax);
        this.m.postTranslate(f4, f5);
        setImageMatrix(this.m);
        b.q.a.h.c cVar = this.C;
        if (cVar != null) {
            ((d) cVar).a.k.setTargetAspectRatio(this.A);
        }
        c$a c_a = this.p;
        if (c_a != null) {
            ((UCropActivity$a) c_a).b(getCurrentScale());
            ((UCropActivity$a) this.p).a(getCurrentAngle());
        }
    }

    @Override // b.q.a.l.c
    public void f(float f, float f2, float f3) {
        if (f > 1.0f && getCurrentScale() * f <= getMaxScale()) {
            super.f(f, f2, f3);
        } else {
            if (f >= 1.0f || getCurrentScale() * f < getMinScale()) {
                return;
            }
            super.f(f, f2, f3);
        }
    }

    @Nullable
    public b.q.a.h.c getCropBoundsChangeListener() {
        return this.C;
    }

    public float getMaxScale() {
        return this.F;
    }

    public float getMinScale() {
        return this.G;
    }

    public float getTargetAspectRatio() {
        return this.A;
    }

    public final void h(float f, float f2) {
        float fMin = Math.min(Math.min(this.f1987y.width() / f, this.f1987y.width() / f2), Math.min(this.f1987y.height() / f2, this.f1987y.height() / f));
        this.G = fMin;
        this.F = fMin * this.B;
    }

    public void i() {
        removeCallbacks(this.D);
        removeCallbacks(this.E);
    }

    public boolean j(float[] fArr) {
        this.f1988z.reset();
        this.f1988z.setRotate(-getCurrentAngle());
        float[] fArrCopyOf = Arrays.copyOf(fArr, fArr.length);
        this.f1988z.mapPoints(fArrCopyOf);
        float[] fArrF0 = f.f0(this.f1987y);
        this.f1988z.mapPoints(fArrF0);
        return f.y1(fArrCopyOf).contains(f.y1(fArrF0));
    }

    public void k(float f) {
        e(f, this.f1987y.centerX(), this.f1987y.centerY());
    }

    public void l(float f, float f2, float f3) {
        if (f <= getMaxScale()) {
            f(f / getCurrentScale(), f2, f3);
        }
    }

    public void setCropBoundsChangeListener(@Nullable b.q.a.h.c cVar) {
        this.C = cVar;
    }

    public void setCropRect(RectF rectF) {
        this.A = rectF.width() / rectF.height();
        this.f1987y.set(rectF.left - getPaddingLeft(), rectF.top - getPaddingTop(), rectF.right - getPaddingRight(), rectF.bottom - getPaddingBottom());
        Drawable drawable = getDrawable();
        if (drawable != null) {
            h(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        }
        setImageToWrapCropBounds(true);
    }

    public void setImageToWrapCropBounds(boolean z2) {
        float f;
        float f2;
        float fMax;
        float f3;
        if (!this.t || j(this.j)) {
            return;
        }
        float[] fArr = this.k;
        float f4 = fArr[0];
        float f5 = fArr[1];
        float currentScale = getCurrentScale();
        float fCenterX = this.f1987y.centerX() - f4;
        float fCenterY = this.f1987y.centerY() - f5;
        this.f1988z.reset();
        this.f1988z.setTranslate(fCenterX, fCenterY);
        float[] fArr2 = this.j;
        float[] fArrCopyOf = Arrays.copyOf(fArr2, fArr2.length);
        this.f1988z.mapPoints(fArrCopyOf);
        boolean zJ = j(fArrCopyOf);
        if (zJ) {
            this.f1988z.reset();
            this.f1988z.setRotate(-getCurrentAngle());
            float[] fArr3 = this.j;
            float[] fArrCopyOf2 = Arrays.copyOf(fArr3, fArr3.length);
            float[] fArrF0 = f.f0(this.f1987y);
            this.f1988z.mapPoints(fArrCopyOf2);
            this.f1988z.mapPoints(fArrF0);
            RectF rectFY1 = f.y1(fArrCopyOf2);
            RectF rectFY2 = f.y1(fArrF0);
            float f6 = rectFY1.left - rectFY2.left;
            float f7 = rectFY1.top - rectFY2.top;
            float f8 = rectFY1.right - rectFY2.right;
            float f9 = rectFY1.bottom - rectFY2.bottom;
            float[] fArr4 = new float[4];
            if (f6 <= 0.0f) {
                f6 = 0.0f;
            }
            fArr4[0] = f6;
            if (f7 <= 0.0f) {
                f7 = 0.0f;
            }
            fArr4[1] = f7;
            if (f8 >= 0.0f) {
                f8 = 0.0f;
            }
            fArr4[2] = f8;
            if (f9 >= 0.0f) {
                f9 = 0.0f;
            }
            fArr4[3] = f9;
            this.f1988z.reset();
            this.f1988z.setRotate(getCurrentAngle());
            this.f1988z.mapPoints(fArr4);
            f2 = -(fArr4[0] + fArr4[2]);
            f3 = -(fArr4[1] + fArr4[3]);
            f = currentScale;
            fMax = 0.0f;
        } else {
            RectF rectF = new RectF(this.f1987y);
            this.f1988z.reset();
            this.f1988z.setRotate(getCurrentAngle());
            this.f1988z.mapRect(rectF);
            float[] fArr5 = this.j;
            f = currentScale;
            float[] fArr6 = {(float) Math.sqrt(Math.pow(fArr5[1] - fArr5[3], 2.0d) + Math.pow(fArr5[0] - fArr5[2], 2.0d)), (float) Math.sqrt(Math.pow(fArr5[3] - fArr5[5], 2.0d) + Math.pow(fArr5[2] - fArr5[4], 2.0d))};
            f2 = fCenterX;
            fMax = (Math.max(rectF.width() / fArr6[0], rectF.height() / fArr6[1]) * f) - f;
            f3 = fCenterY;
        }
        if (z2) {
            a$a a_a = new a$a(this, this.J, f4, f5, f2, f3, f, fMax, zJ);
            this.D = a_a;
            post(a_a);
        } else {
            g(f2, f3);
            if (zJ) {
                return;
            }
            l(f + fMax, this.f1987y.centerX(), this.f1987y.centerY());
        }
    }

    public void setImageToWrapCropBoundsAnimDuration(@IntRange(from = 100) long j) {
        if (j <= 0) {
            throw new IllegalArgumentException("Animation duration cannot be negative value.");
        }
        this.J = j;
    }

    public void setMaxResultImageSizeX(@IntRange(from = 10) int i) {
        this.H = i;
    }

    public void setMaxResultImageSizeY(@IntRange(from = 10) int i) {
        this.I = i;
    }

    public void setMaxScaleMultiplier(float f) {
        this.B = f;
    }

    public void setTargetAspectRatio(float f) {
        Drawable drawable = getDrawable();
        if (drawable == null) {
            this.A = f;
            return;
        }
        if (f == 0.0f) {
            this.A = drawable.getIntrinsicWidth() / drawable.getIntrinsicHeight();
        } else {
            this.A = f;
        }
        b.q.a.h.c cVar = this.C;
        if (cVar != null) {
            ((d) cVar).a.k.setTargetAspectRatio(this.A);
        }
    }

    public a(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1987y = new RectF();
        this.f1988z = new Matrix();
        this.B = 10.0f;
        this.E = null;
        this.H = 0;
        this.I = 0;
        this.J = 500L;
    }
}
