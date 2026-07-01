package com.yalantis.ucrop.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Path$Direction;
import android.graphics.RectF;
import android.graphics.Region$Op;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.ColorInt;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import b.i.a.f.e.o.f;
import b.q.a.h.d;
import b.q.a.l.e;
import com.yalantis.ucrop.R$b;

/* JADX INFO: loaded from: classes3.dex */
public class OverlayView extends View {
    public Paint A;
    public int B;
    public float C;
    public float D;
    public int E;
    public int F;
    public int G;
    public int H;
    public d I;
    public boolean J;
    public final RectF j;
    public final RectF k;
    public int l;
    public int m;
    public float[] n;
    public int o;
    public int p;
    public float q;
    public float[] r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f3182s;
    public boolean t;
    public boolean u;
    public int v;
    public Path w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public Paint f3183x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public Paint f3184y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public Paint f3185z;

    public OverlayView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.j = new RectF();
        this.k = new RectF();
        this.r = null;
        this.w = new Path();
        this.f3183x = new Paint(1);
        this.f3184y = new Paint(1);
        this.f3185z = new Paint(1);
        this.A = new Paint(1);
        this.B = 0;
        this.C = -1.0f;
        this.D = -1.0f;
        this.E = -1;
        this.F = getResources().getDimensionPixelSize(R$b.ucrop_default_crop_rect_corner_touch_threshold);
        this.G = getResources().getDimensionPixelSize(R$b.ucrop_default_crop_rect_min_size);
        this.H = getResources().getDimensionPixelSize(R$b.ucrop_default_crop_rect_corner_touch_area_line_length);
    }

    public final void a() {
        this.n = f.f0(this.j);
        f.d0(this.j);
        this.r = null;
        this.w.reset();
        this.w.addCircle(this.j.centerX(), this.j.centerY(), Math.min(this.j.width(), this.j.height()) / 2.0f, Path$Direction.CW);
    }

    @NonNull
    public RectF getCropViewRect() {
        return this.j;
    }

    public int getFreestyleCropMode() {
        return this.B;
    }

    public d getOverlayViewChangeListener() {
        return this.I;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        if (this.u) {
            canvas.clipPath(this.w, Region$Op.DIFFERENCE);
        } else {
            canvas.clipRect(this.j, Region$Op.DIFFERENCE);
        }
        canvas.drawColor(this.v);
        canvas.restore();
        if (this.u) {
            canvas.drawCircle(this.j.centerX(), this.j.centerY(), Math.min(this.j.width(), this.j.height()) / 2.0f, this.f3183x);
        }
        if (this.t) {
            if (this.r == null && !this.j.isEmpty()) {
                this.r = new float[(this.p * 4) + (this.o * 4)];
                int i = 0;
                for (int i2 = 0; i2 < this.o; i2++) {
                    float[] fArr = this.r;
                    int i3 = i + 1;
                    RectF rectF = this.j;
                    fArr[i] = rectF.left;
                    int i4 = i3 + 1;
                    float f = i2 + 1.0f;
                    float fHeight = (f / (this.o + 1)) * rectF.height();
                    RectF rectF2 = this.j;
                    fArr[i3] = fHeight + rectF2.top;
                    float[] fArr2 = this.r;
                    int i5 = i4 + 1;
                    fArr2[i4] = rectF2.right;
                    i = i5 + 1;
                    fArr2[i5] = ((f / (this.o + 1)) * rectF2.height()) + this.j.top;
                }
                for (int i6 = 0; i6 < this.p; i6++) {
                    float[] fArr3 = this.r;
                    int i7 = i + 1;
                    float f2 = i6 + 1.0f;
                    float fWidth = (f2 / (this.p + 1)) * this.j.width();
                    RectF rectF3 = this.j;
                    fArr3[i] = fWidth + rectF3.left;
                    float[] fArr4 = this.r;
                    int i8 = i7 + 1;
                    fArr4[i7] = rectF3.top;
                    int i9 = i8 + 1;
                    float fWidth2 = (f2 / (this.p + 1)) * rectF3.width();
                    RectF rectF4 = this.j;
                    fArr4[i8] = fWidth2 + rectF4.left;
                    i = i9 + 1;
                    this.r[i9] = rectF4.bottom;
                }
            }
            float[] fArr5 = this.r;
            if (fArr5 != null) {
                canvas.drawLines(fArr5, this.f3184y);
            }
        }
        if (this.f3182s) {
            canvas.drawRect(this.j, this.f3185z);
        }
        if (this.B != 0) {
            canvas.save();
            this.k.set(this.j);
            RectF rectF5 = this.k;
            int i10 = this.H;
            rectF5.inset(i10, -i10);
            canvas.clipRect(this.k, Region$Op.DIFFERENCE);
            this.k.set(this.j);
            RectF rectF6 = this.k;
            int i11 = this.H;
            rectF6.inset(-i11, i11);
            canvas.clipRect(this.k, Region$Op.DIFFERENCE);
            canvas.drawRect(this.j, this.A);
            canvas.restore();
        }
    }

    @Override // android.view.View
    public void onLayout(boolean z2, int i, int i2, int i3, int i4) {
        super.onLayout(z2, i, i2, i3, i4);
        if (z2) {
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int width = getWidth() - getPaddingRight();
            int height = getHeight() - getPaddingBottom();
            this.l = width - paddingLeft;
            this.m = height - paddingTop;
            if (this.J) {
                this.J = false;
                setTargetAspectRatio(this.q);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.j.isEmpty() || this.B == 0) {
            return false;
        }
        float x2 = motionEvent.getX();
        float y2 = motionEvent.getY();
        if ((motionEvent.getAction() & 255) == 0) {
            double d = this.F;
            int i = -1;
            for (int i2 = 0; i2 < 8; i2 += 2) {
                double dSqrt = Math.sqrt(Math.pow(y2 - this.n[i2 + 1], 2.0d) + Math.pow(x2 - this.n[i2], 2.0d));
                if (dSqrt < d) {
                    i = i2 / 2;
                    d = dSqrt;
                }
            }
            int i3 = (this.B == 1 && i < 0 && this.j.contains(x2, y2)) ? 4 : i;
            this.E = i3;
            boolean z2 = i3 != -1;
            if (!z2) {
                this.C = -1.0f;
                this.D = -1.0f;
            } else if (this.C < 0.0f) {
                this.C = x2;
                this.D = y2;
            }
            return z2;
        }
        if ((motionEvent.getAction() & 255) != 2 || motionEvent.getPointerCount() != 1 || this.E == -1) {
            if ((motionEvent.getAction() & 255) != 1) {
                return false;
            }
            this.C = -1.0f;
            this.D = -1.0f;
            this.E = -1;
            d dVar = this.I;
            if (dVar == null) {
                return false;
            }
            ((e) dVar).a.j.setCropRect(this.j);
            return false;
        }
        float fMin = Math.min(Math.max(x2, getPaddingLeft()), getWidth() - getPaddingRight());
        float fMin2 = Math.min(Math.max(y2, getPaddingTop()), getHeight() - getPaddingBottom());
        this.k.set(this.j);
        int i4 = this.E;
        if (i4 == 0) {
            RectF rectF = this.k;
            RectF rectF2 = this.j;
            rectF.set(fMin, fMin2, rectF2.right, rectF2.bottom);
        } else if (i4 == 1) {
            RectF rectF3 = this.k;
            RectF rectF4 = this.j;
            rectF3.set(rectF4.left, fMin2, fMin, rectF4.bottom);
        } else if (i4 == 2) {
            RectF rectF5 = this.k;
            RectF rectF6 = this.j;
            rectF5.set(rectF6.left, rectF6.top, fMin, fMin2);
        } else {
            if (i4 != 3) {
                if (i4 == 4) {
                    this.k.offset(fMin - this.C, fMin2 - this.D);
                    if (this.k.left > getLeft() && this.k.top > getTop() && this.k.right < getRight() && this.k.bottom < getBottom()) {
                        this.j.set(this.k);
                        a();
                        postInvalidate();
                    }
                }
                this.C = fMin;
                this.D = fMin2;
                return true;
            }
            RectF rectF7 = this.k;
            RectF rectF8 = this.j;
            rectF7.set(fMin, rectF8.top, rectF8.right, fMin2);
        }
        boolean z3 = this.k.height() >= ((float) this.G);
        boolean z4 = this.k.width() >= ((float) this.G);
        RectF rectF9 = this.j;
        rectF9.set(z4 ? this.k.left : rectF9.left, z3 ? this.k.top : rectF9.top, z4 ? this.k.right : rectF9.right, z3 ? this.k.bottom : rectF9.bottom);
        if (z3 || z4) {
            a();
            postInvalidate();
        }
        this.C = fMin;
        this.D = fMin2;
        return true;
    }

    public void setCircleDimmedLayer(boolean z2) {
        this.u = z2;
    }

    public void setCropFrameColor(@ColorInt int i) {
        this.f3185z.setColor(i);
    }

    public void setCropFrameStrokeWidth(@IntRange(from = 0) int i) {
        this.f3185z.setStrokeWidth(i);
    }

    public void setCropGridColor(@ColorInt int i) {
        this.f3184y.setColor(i);
    }

    public void setCropGridColumnCount(@IntRange(from = 0) int i) {
        this.p = i;
        this.r = null;
    }

    public void setCropGridRowCount(@IntRange(from = 0) int i) {
        this.o = i;
        this.r = null;
    }

    public void setCropGridStrokeWidth(@IntRange(from = 0) int i) {
        this.f3184y.setStrokeWidth(i);
    }

    public void setDimmedColor(@ColorInt int i) {
        this.v = i;
    }

    @Deprecated
    public void setFreestyleCropEnabled(boolean z2) {
        this.B = z2 ? 1 : 0;
    }

    public void setFreestyleCropMode(int i) {
        this.B = i;
        postInvalidate();
    }

    public void setOverlayViewChangeListener(d dVar) {
        this.I = dVar;
    }

    public void setShowCropFrame(boolean z2) {
        this.f3182s = z2;
    }

    public void setShowCropGrid(boolean z2) {
        this.t = z2;
    }

    public void setTargetAspectRatio(float f) {
        this.q = f;
        int i = this.l;
        if (i <= 0) {
            this.J = true;
            return;
        }
        int i2 = (int) (i / f);
        int i3 = this.m;
        if (i2 > i3) {
            int i4 = (int) (i3 * f);
            int i5 = (i - i4) / 2;
            this.j.set(getPaddingLeft() + i5, getPaddingTop(), getPaddingLeft() + i4 + i5, getPaddingTop() + this.m);
        } else {
            int i6 = (i3 - i2) / 2;
            this.j.set(getPaddingLeft(), getPaddingTop() + i6, getPaddingLeft() + this.l, getPaddingTop() + i2 + i6);
        }
        d dVar = this.I;
        if (dVar != null) {
            ((e) dVar).a.j.setCropRect(this.j);
        }
        a();
        postInvalidate();
    }
}
