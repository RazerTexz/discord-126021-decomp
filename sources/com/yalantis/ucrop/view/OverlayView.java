package com.yalantis.ucrop.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Region;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.ColorInt;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import com.yalantis.ucrop.C11199R;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p007b.p485q.p486a.p487h.InterfaceC5295d;
import p007b.p485q.p486a.p491l.C5309e;

/* JADX INFO: loaded from: classes3.dex */
public class OverlayView extends View {

    /* JADX INFO: renamed from: A */
    public Paint f22214A;

    /* JADX INFO: renamed from: B */
    public int f22215B;

    /* JADX INFO: renamed from: C */
    public float f22216C;

    /* JADX INFO: renamed from: D */
    public float f22217D;

    /* JADX INFO: renamed from: E */
    public int f22218E;

    /* JADX INFO: renamed from: F */
    public int f22219F;

    /* JADX INFO: renamed from: G */
    public int f22220G;

    /* JADX INFO: renamed from: H */
    public int f22221H;

    /* JADX INFO: renamed from: I */
    public InterfaceC5295d f22222I;

    /* JADX INFO: renamed from: J */
    public boolean f22223J;

    /* JADX INFO: renamed from: j */
    public final RectF f22224j;

    /* JADX INFO: renamed from: k */
    public final RectF f22225k;

    /* JADX INFO: renamed from: l */
    public int f22226l;

    /* JADX INFO: renamed from: m */
    public int f22227m;

    /* JADX INFO: renamed from: n */
    public float[] f22228n;

    /* JADX INFO: renamed from: o */
    public int f22229o;

    /* JADX INFO: renamed from: p */
    public int f22230p;

    /* JADX INFO: renamed from: q */
    public float f22231q;

    /* JADX INFO: renamed from: r */
    public float[] f22232r;

    /* JADX INFO: renamed from: s */
    public boolean f22233s;

    /* JADX INFO: renamed from: t */
    public boolean f22234t;

    /* JADX INFO: renamed from: u */
    public boolean f22235u;

    /* JADX INFO: renamed from: v */
    public int f22236v;

    /* JADX INFO: renamed from: w */
    public Path f22237w;

    /* JADX INFO: renamed from: x */
    public Paint f22238x;

    /* JADX INFO: renamed from: y */
    public Paint f22239y;

    /* JADX INFO: renamed from: z */
    public Paint f22240z;

    public OverlayView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.f22224j = new RectF();
        this.f22225k = new RectF();
        this.f22232r = null;
        this.f22237w = new Path();
        this.f22238x = new Paint(1);
        this.f22239y = new Paint(1);
        this.f22240z = new Paint(1);
        this.f22214A = new Paint(1);
        this.f22215B = 0;
        this.f22216C = -1.0f;
        this.f22217D = -1.0f;
        this.f22218E = -1;
        this.f22219F = getResources().getDimensionPixelSize(C11199R.b.ucrop_default_crop_rect_corner_touch_threshold);
        this.f22220G = getResources().getDimensionPixelSize(C11199R.b.ucrop_default_crop_rect_min_size);
        this.f22221H = getResources().getDimensionPixelSize(C11199R.b.ucrop_default_crop_rect_corner_touch_area_line_length);
    }

    /* JADX INFO: renamed from: a */
    public final void m9324a() {
        this.f22228n = C3404f.m4288f0(this.f22224j);
        C3404f.m4280d0(this.f22224j);
        this.f22232r = null;
        this.f22237w.reset();
        this.f22237w.addCircle(this.f22224j.centerX(), this.f22224j.centerY(), Math.min(this.f22224j.width(), this.f22224j.height()) / 2.0f, Path.Direction.CW);
    }

    @NonNull
    public RectF getCropViewRect() {
        return this.f22224j;
    }

    public int getFreestyleCropMode() {
        return this.f22215B;
    }

    public InterfaceC5295d getOverlayViewChangeListener() {
        return this.f22222I;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        if (this.f22235u) {
            canvas.clipPath(this.f22237w, Region.Op.DIFFERENCE);
        } else {
            canvas.clipRect(this.f22224j, Region.Op.DIFFERENCE);
        }
        canvas.drawColor(this.f22236v);
        canvas.restore();
        if (this.f22235u) {
            canvas.drawCircle(this.f22224j.centerX(), this.f22224j.centerY(), Math.min(this.f22224j.width(), this.f22224j.height()) / 2.0f, this.f22238x);
        }
        if (this.f22234t) {
            if (this.f22232r == null && !this.f22224j.isEmpty()) {
                this.f22232r = new float[(this.f22230p * 4) + (this.f22229o * 4)];
                int i = 0;
                for (int i2 = 0; i2 < this.f22229o; i2++) {
                    float[] fArr = this.f22232r;
                    int i3 = i + 1;
                    RectF rectF = this.f22224j;
                    fArr[i] = rectF.left;
                    int i4 = i3 + 1;
                    float f = i2 + 1.0f;
                    float fHeight = (f / (this.f22229o + 1)) * rectF.height();
                    RectF rectF2 = this.f22224j;
                    fArr[i3] = fHeight + rectF2.top;
                    float[] fArr2 = this.f22232r;
                    int i5 = i4 + 1;
                    fArr2[i4] = rectF2.right;
                    i = i5 + 1;
                    fArr2[i5] = ((f / (this.f22229o + 1)) * rectF2.height()) + this.f22224j.top;
                }
                for (int i6 = 0; i6 < this.f22230p; i6++) {
                    float[] fArr3 = this.f22232r;
                    int i7 = i + 1;
                    float f2 = i6 + 1.0f;
                    float fWidth = (f2 / (this.f22230p + 1)) * this.f22224j.width();
                    RectF rectF3 = this.f22224j;
                    fArr3[i] = fWidth + rectF3.left;
                    float[] fArr4 = this.f22232r;
                    int i8 = i7 + 1;
                    fArr4[i7] = rectF3.top;
                    int i9 = i8 + 1;
                    float fWidth2 = (f2 / (this.f22230p + 1)) * rectF3.width();
                    RectF rectF4 = this.f22224j;
                    fArr4[i8] = fWidth2 + rectF4.left;
                    i = i9 + 1;
                    this.f22232r[i9] = rectF4.bottom;
                }
            }
            float[] fArr5 = this.f22232r;
            if (fArr5 != null) {
                canvas.drawLines(fArr5, this.f22239y);
            }
        }
        if (this.f22233s) {
            canvas.drawRect(this.f22224j, this.f22240z);
        }
        if (this.f22215B != 0) {
            canvas.save();
            this.f22225k.set(this.f22224j);
            RectF rectF5 = this.f22225k;
            int i10 = this.f22221H;
            rectF5.inset(i10, -i10);
            canvas.clipRect(this.f22225k, Region.Op.DIFFERENCE);
            this.f22225k.set(this.f22224j);
            RectF rectF6 = this.f22225k;
            int i11 = this.f22221H;
            rectF6.inset(-i11, i11);
            canvas.clipRect(this.f22225k, Region.Op.DIFFERENCE);
            canvas.drawRect(this.f22224j, this.f22214A);
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
            this.f22226l = width - paddingLeft;
            this.f22227m = height - paddingTop;
            if (this.f22223J) {
                this.f22223J = false;
                setTargetAspectRatio(this.f22231q);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f22224j.isEmpty() || this.f22215B == 0) {
            return false;
        }
        float x2 = motionEvent.getX();
        float y2 = motionEvent.getY();
        if ((motionEvent.getAction() & 255) == 0) {
            double d = this.f22219F;
            int i = -1;
            for (int i2 = 0; i2 < 8; i2 += 2) {
                double dSqrt = Math.sqrt(Math.pow(y2 - this.f22228n[i2 + 1], 2.0d) + Math.pow(x2 - this.f22228n[i2], 2.0d));
                if (dSqrt < d) {
                    i = i2 / 2;
                    d = dSqrt;
                }
            }
            int i3 = (this.f22215B == 1 && i < 0 && this.f22224j.contains(x2, y2)) ? 4 : i;
            this.f22218E = i3;
            boolean z2 = i3 != -1;
            if (!z2) {
                this.f22216C = -1.0f;
                this.f22217D = -1.0f;
            } else if (this.f22216C < 0.0f) {
                this.f22216C = x2;
                this.f22217D = y2;
            }
            return z2;
        }
        if ((motionEvent.getAction() & 255) != 2 || motionEvent.getPointerCount() != 1 || this.f22218E == -1) {
            if ((motionEvent.getAction() & 255) != 1) {
                return false;
            }
            this.f22216C = -1.0f;
            this.f22217D = -1.0f;
            this.f22218E = -1;
            InterfaceC5295d interfaceC5295d = this.f22222I;
            if (interfaceC5295d == null) {
                return false;
            }
            ((C5309e) interfaceC5295d).f14500a.f22241j.setCropRect(this.f22224j);
            return false;
        }
        float fMin = Math.min(Math.max(x2, getPaddingLeft()), getWidth() - getPaddingRight());
        float fMin2 = Math.min(Math.max(y2, getPaddingTop()), getHeight() - getPaddingBottom());
        this.f22225k.set(this.f22224j);
        int i4 = this.f22218E;
        if (i4 == 0) {
            RectF rectF = this.f22225k;
            RectF rectF2 = this.f22224j;
            rectF.set(fMin, fMin2, rectF2.right, rectF2.bottom);
        } else if (i4 == 1) {
            RectF rectF3 = this.f22225k;
            RectF rectF4 = this.f22224j;
            rectF3.set(rectF4.left, fMin2, fMin, rectF4.bottom);
        } else if (i4 == 2) {
            RectF rectF5 = this.f22225k;
            RectF rectF6 = this.f22224j;
            rectF5.set(rectF6.left, rectF6.top, fMin, fMin2);
        } else {
            if (i4 != 3) {
                if (i4 == 4) {
                    this.f22225k.offset(fMin - this.f22216C, fMin2 - this.f22217D);
                    if (this.f22225k.left > getLeft() && this.f22225k.top > getTop() && this.f22225k.right < getRight() && this.f22225k.bottom < getBottom()) {
                        this.f22224j.set(this.f22225k);
                        m9324a();
                        postInvalidate();
                    }
                }
                this.f22216C = fMin;
                this.f22217D = fMin2;
                return true;
            }
            RectF rectF7 = this.f22225k;
            RectF rectF8 = this.f22224j;
            rectF7.set(fMin, rectF8.top, rectF8.right, fMin2);
        }
        boolean z3 = this.f22225k.height() >= ((float) this.f22220G);
        boolean z4 = this.f22225k.width() >= ((float) this.f22220G);
        RectF rectF9 = this.f22224j;
        rectF9.set(z4 ? this.f22225k.left : rectF9.left, z3 ? this.f22225k.top : rectF9.top, z4 ? this.f22225k.right : rectF9.right, z3 ? this.f22225k.bottom : rectF9.bottom);
        if (z3 || z4) {
            m9324a();
            postInvalidate();
        }
        this.f22216C = fMin;
        this.f22217D = fMin2;
        return true;
    }

    public void setCircleDimmedLayer(boolean z2) {
        this.f22235u = z2;
    }

    public void setCropFrameColor(@ColorInt int i) {
        this.f22240z.setColor(i);
    }

    public void setCropFrameStrokeWidth(@IntRange(from = 0) int i) {
        this.f22240z.setStrokeWidth(i);
    }

    public void setCropGridColor(@ColorInt int i) {
        this.f22239y.setColor(i);
    }

    public void setCropGridColumnCount(@IntRange(from = 0) int i) {
        this.f22230p = i;
        this.f22232r = null;
    }

    public void setCropGridRowCount(@IntRange(from = 0) int i) {
        this.f22229o = i;
        this.f22232r = null;
    }

    public void setCropGridStrokeWidth(@IntRange(from = 0) int i) {
        this.f22239y.setStrokeWidth(i);
    }

    public void setDimmedColor(@ColorInt int i) {
        this.f22236v = i;
    }

    @Deprecated
    public void setFreestyleCropEnabled(boolean z2) {
        this.f22215B = z2 ? 1 : 0;
    }

    public void setFreestyleCropMode(int i) {
        this.f22215B = i;
        postInvalidate();
    }

    public void setOverlayViewChangeListener(InterfaceC5295d interfaceC5295d) {
        this.f22222I = interfaceC5295d;
    }

    public void setShowCropFrame(boolean z2) {
        this.f22233s = z2;
    }

    public void setShowCropGrid(boolean z2) {
        this.f22234t = z2;
    }

    public void setTargetAspectRatio(float f) {
        this.f22231q = f;
        int i = this.f22226l;
        if (i <= 0) {
            this.f22223J = true;
            return;
        }
        int i2 = (int) (i / f);
        int i3 = this.f22227m;
        if (i2 > i3) {
            int i4 = (int) (i3 * f);
            int i5 = (i - i4) / 2;
            this.f22224j.set(getPaddingLeft() + i5, getPaddingTop(), getPaddingLeft() + i4 + i5, getPaddingTop() + this.f22227m);
        } else {
            int i6 = (i3 - i2) / 2;
            this.f22224j.set(getPaddingLeft(), getPaddingTop() + i6, getPaddingLeft() + this.f22226l, getPaddingTop() + i2 + i6);
        }
        InterfaceC5295d interfaceC5295d = this.f22222I;
        if (interfaceC5295d != null) {
            ((C5309e) interfaceC5295d).f14500a.f22241j.setCropRect(this.f22224j);
        }
        m9324a();
        postInvalidate();
    }
}
