package com.jaredrummler.android.colorpicker;

import android.R$attr;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap$Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ComposeShader;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Paint$Align;
import android.graphics.Paint$Style;
import android.graphics.Point;
import android.graphics.PorterDuff$Mode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Shader$TileMode;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.View$MeasureSpec;
import androidx.constraintlayout.motion.widget.Key;
import androidx.core.view.ViewCompat;
import b.i.a.f.e.o.f;
import b.k.a.a.a;

/* JADX INFO: loaded from: classes3.dex */
public class ColorPickerView extends View {
    public int A;
    public float B;
    public float C;
    public float D;
    public boolean E;
    public String F;
    public int G;
    public int H;
    public Rect I;
    public Rect J;
    public Rect K;
    public Rect L;
    public Point M;
    public a N;
    public ColorPickerView$c O;
    public int j;
    public int k;
    public int l;
    public int m;
    public int n;
    public int o;
    public Paint p;
    public Paint q;
    public Paint r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public Paint f3152s;
    public Paint t;
    public Paint u;
    public Shader v;
    public Shader w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public Shader f3153x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public ColorPickerView$b f3154y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public ColorPickerView$b f3155z;

    public ColorPickerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.A = 255;
        this.B = 360.0f;
        this.C = 0.0f;
        this.D = 0.0f;
        this.E = false;
        this.F = null;
        this.G = -4342339;
        this.H = -9539986;
        this.M = null;
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$f.ColorPickerView);
        this.E = typedArrayObtainStyledAttributes.getBoolean(R$f.ColorPickerView_cpv_alphaChannelVisible, false);
        this.F = typedArrayObtainStyledAttributes.getString(R$f.ColorPickerView_cpv_alphaChannelText);
        this.G = typedArrayObtainStyledAttributes.getColor(R$f.ColorPickerView_cpv_sliderColor, -4342339);
        this.H = typedArrayObtainStyledAttributes.getColor(R$f.ColorPickerView_cpv_borderColor, -9539986);
        typedArrayObtainStyledAttributes.recycle();
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(new TypedValue().data, new int[]{R$attr.textColorSecondary});
        if (this.H == -9539986) {
            this.H = typedArrayObtainStyledAttributes2.getColor(0, -9539986);
        }
        if (this.G == -4342339) {
            this.G = typedArrayObtainStyledAttributes2.getColor(0, -4342339);
        }
        typedArrayObtainStyledAttributes2.recycle();
        this.j = f.S(getContext(), 30.0f);
        this.k = f.S(getContext(), 20.0f);
        this.l = f.S(getContext(), 10.0f);
        this.m = f.S(getContext(), 5.0f);
        this.o = f.S(getContext(), 4.0f);
        this.n = f.S(getContext(), 2.0f);
        this.p = new Paint();
        this.q = new Paint();
        this.t = new Paint();
        this.r = new Paint();
        this.f3152s = new Paint();
        this.u = new Paint();
        this.q.setStyle(Paint$Style.STROKE);
        this.q.setStrokeWidth(f.S(getContext(), 2.0f));
        this.q.setAntiAlias(true);
        this.t.setColor(this.G);
        this.t.setStyle(Paint$Style.STROKE);
        this.t.setStrokeWidth(f.S(getContext(), 2.0f));
        this.t.setAntiAlias(true);
        this.f3152s.setColor(-14935012);
        this.f3152s.setTextSize(f.S(getContext(), 14.0f));
        this.f3152s.setAntiAlias(true);
        this.f3152s.setTextAlign(Paint$Align.CENTER);
        this.f3152s.setFakeBoldText(true);
        setFocusable(true);
        setFocusableInTouchMode(true);
    }

    private int getPreferredHeight() {
        int iS = f.S(getContext(), 200.0f);
        return this.E ? iS + this.l + this.k : iS;
    }

    private int getPreferredWidth() {
        return f.S(getContext(), 200.0f) + this.j + this.l;
    }

    public final boolean a(MotionEvent motionEvent) {
        float f;
        Point point = this.M;
        int i = 0;
        if (point == null) {
            return false;
        }
        int i2 = point.x;
        int i3 = point.y;
        float f2 = 0.0f;
        if (this.K.contains(i2, i3)) {
            float y2 = motionEvent.getY();
            Rect rect = this.K;
            float fHeight = rect.height();
            float f3 = rect.top;
            if (y2 >= f3) {
                f2 = y2 > ((float) rect.bottom) ? fHeight : y2 - f3;
            }
            this.B = 360.0f - ((f2 * 360.0f) / fHeight);
        } else if (this.J.contains(i2, i3)) {
            float x2 = motionEvent.getX();
            float y3 = motionEvent.getY();
            Rect rect2 = this.J;
            float[] fArr = new float[2];
            float fWidth = rect2.width();
            float fHeight2 = rect2.height();
            float f4 = rect2.left;
            if (x2 < f4) {
                f = 0.0f;
            } else {
                f = x2 > ((float) rect2.right) ? fWidth : x2 - f4;
            }
            float f5 = rect2.top;
            if (y3 >= f5) {
                f2 = y3 > ((float) rect2.bottom) ? fHeight2 : y3 - f5;
            }
            fArr[0] = (1.0f / fWidth) * f;
            fArr[1] = 1.0f - ((1.0f / fHeight2) * f2);
            this.C = fArr[0];
            this.D = fArr[1];
        } else {
            Rect rect3 = this.L;
            if (rect3 == null || !rect3.contains(i2, i3)) {
                return false;
            }
            int x3 = (int) motionEvent.getX();
            Rect rect4 = this.L;
            int iWidth = rect4.width();
            int i4 = rect4.left;
            if (x3 >= i4) {
                i = x3 > rect4.right ? iWidth : x3 - i4;
            }
            this.A = 255 - ((i * 255) / iWidth);
        }
        return true;
    }

    public void b(int i, boolean z2) {
        ColorPickerView$c colorPickerView$c;
        int iAlpha = Color.alpha(i);
        float[] fArr = new float[3];
        Color.RGBToHSV(Color.red(i), Color.green(i), Color.blue(i), fArr);
        this.A = iAlpha;
        float f = fArr[0];
        this.B = f;
        float f2 = fArr[1];
        this.C = f2;
        float f3 = fArr[2];
        this.D = f3;
        if (z2 && (colorPickerView$c = this.O) != null) {
            ((ColorPickerDialog) colorPickerView$c).k(Color.HSVToColor(iAlpha, new float[]{f, f2, f3}));
        }
        invalidate();
    }

    public String getAlphaSliderText() {
        return this.F;
    }

    public int getBorderColor() {
        return this.H;
    }

    public int getColor() {
        return Color.HSVToColor(this.A, new float[]{this.B, this.C, this.D});
    }

    @Override // android.view.View
    public int getPaddingBottom() {
        return Math.max(super.getPaddingBottom(), 0);
    }

    @Override // android.view.View
    public int getPaddingLeft() {
        return Math.max(super.getPaddingLeft(), 0);
    }

    @Override // android.view.View
    public int getPaddingRight() {
        return Math.max(super.getPaddingRight(), 0);
    }

    @Override // android.view.View
    public int getPaddingTop() {
        return Math.max(super.getPaddingTop(), 0);
    }

    public int getSliderTrackerColor() {
        return this.G;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Rect rect;
        if (this.I.width() <= 0 || this.I.height() <= 0) {
            return;
        }
        Rect rect2 = this.J;
        this.u.setColor(this.H);
        Rect rect3 = this.I;
        canvas.drawRect(rect3.left, rect3.top, rect2.right + 1, rect2.bottom + 1, this.u);
        if (this.v == null) {
            float f = rect2.left;
            this.v = new LinearGradient(f, rect2.top, f, rect2.bottom, -1, ViewCompat.MEASURED_STATE_MASK, Shader$TileMode.CLAMP);
        }
        ColorPickerView$b colorPickerView$b = this.f3154y;
        if (colorPickerView$b == null || colorPickerView$b.c != this.B) {
            if (colorPickerView$b == null) {
                this.f3154y = new ColorPickerView$b(this, null);
            }
            ColorPickerView$b colorPickerView$b2 = this.f3154y;
            if (colorPickerView$b2.f3156b == null) {
                colorPickerView$b2.f3156b = Bitmap.createBitmap(rect2.width(), rect2.height(), Bitmap$Config.ARGB_8888);
            }
            ColorPickerView$b colorPickerView$b3 = this.f3154y;
            if (colorPickerView$b3.a == null) {
                colorPickerView$b3.a = new Canvas(this.f3154y.f3156b);
            }
            int iHSVToColor = Color.HSVToColor(new float[]{this.B, 1.0f, 1.0f});
            float f2 = rect2.left;
            float f3 = rect2.top;
            this.w = new LinearGradient(f2, f3, rect2.right, f3, -1, iHSVToColor, Shader$TileMode.CLAMP);
            this.p.setShader(new ComposeShader(this.v, this.w, PorterDuff$Mode.MULTIPLY));
            ColorPickerView$b colorPickerView$b4 = this.f3154y;
            colorPickerView$b4.a.drawRect(0.0f, 0.0f, colorPickerView$b4.f3156b.getWidth(), this.f3154y.f3156b.getHeight(), this.p);
            this.f3154y.c = this.B;
        }
        canvas.drawBitmap(this.f3154y.f3156b, (Rect) null, rect2, (Paint) null);
        float f4 = this.C;
        float f5 = this.D;
        Rect rect4 = this.J;
        float fHeight = rect4.height();
        float fWidth = rect4.width();
        Point point = new Point();
        point.x = (int) ((f4 * fWidth) + rect4.left);
        point.y = (int) (((1.0f - f5) * fHeight) + rect4.top);
        this.q.setColor(ViewCompat.MEASURED_STATE_MASK);
        canvas.drawCircle(point.x, point.y, this.m - f.S(getContext(), 1.0f), this.q);
        this.q.setColor(-2236963);
        canvas.drawCircle(point.x, point.y, this.m, this.q);
        Rect rect5 = this.K;
        this.u.setColor(this.H);
        canvas.drawRect(rect5.left - 1, rect5.top - 1, rect5.right + 1, rect5.bottom + 1, this.u);
        if (this.f3155z == null) {
            ColorPickerView$b colorPickerView$b5 = new ColorPickerView$b(this, null);
            this.f3155z = colorPickerView$b5;
            colorPickerView$b5.f3156b = Bitmap.createBitmap(rect5.width(), rect5.height(), Bitmap$Config.ARGB_8888);
            this.f3155z.a = new Canvas(this.f3155z.f3156b);
            int iHeight = (int) (rect5.height() + 0.5f);
            int[] iArr = new int[iHeight];
            float f6 = 360.0f;
            for (int i = 0; i < iHeight; i++) {
                iArr[i] = Color.HSVToColor(new float[]{f6, 1.0f, 1.0f});
                f6 -= 360.0f / iHeight;
            }
            Paint paint = new Paint();
            paint.setStrokeWidth(0.0f);
            for (int i2 = 0; i2 < iHeight; i2++) {
                paint.setColor(iArr[i2]);
                ColorPickerView$b colorPickerView$b6 = this.f3155z;
                float f7 = i2;
                colorPickerView$b6.a.drawLine(0.0f, f7, colorPickerView$b6.f3156b.getWidth(), f7, paint);
            }
        }
        canvas.drawBitmap(this.f3155z.f3156b, (Rect) null, rect5, (Paint) null);
        float f8 = this.B;
        Rect rect6 = this.K;
        float fHeight2 = rect6.height();
        Point point2 = new Point();
        point2.y = (int) ((fHeight2 - ((f8 * fHeight2) / 360.0f)) + rect6.top);
        point2.x = rect6.left;
        RectF rectF = new RectF();
        int i3 = rect5.left;
        int i4 = this.n;
        rectF.left = i3 - i4;
        rectF.right = rect5.right + i4;
        int i5 = point2.y;
        int i6 = this.o / 2;
        rectF.top = i5 - i6;
        rectF.bottom = i6 + i5;
        canvas.drawRoundRect(rectF, 2.0f, 2.0f, this.t);
        if (!this.E || (rect = this.L) == null || this.N == null) {
            return;
        }
        this.u.setColor(this.H);
        canvas.drawRect(rect.left - 1, rect.top - 1, rect.right + 1, rect.bottom + 1, this.u);
        this.N.draw(canvas);
        float[] fArr = {this.B, this.C, this.D};
        int iHSVToColor2 = Color.HSVToColor(fArr);
        int iHSVToColor3 = Color.HSVToColor(0, fArr);
        float f9 = rect.left;
        float f10 = rect.top;
        LinearGradient linearGradient = new LinearGradient(f9, f10, rect.right, f10, iHSVToColor2, iHSVToColor3, Shader$TileMode.CLAMP);
        this.f3153x = linearGradient;
        this.r.setShader(linearGradient);
        canvas.drawRect(rect, this.r);
        String str = this.F;
        if (str != null && !str.equals("")) {
            canvas.drawText(this.F, rect.centerX(), f.S(getContext(), 4.0f) + rect.centerY(), this.f3152s);
        }
        int i7 = this.A;
        Rect rect7 = this.L;
        float fWidth2 = rect7.width();
        Point point3 = new Point();
        point3.x = (int) ((fWidth2 - ((i7 * fWidth2) / 255.0f)) + rect7.left);
        point3.y = rect7.top;
        RectF rectF2 = new RectF();
        int i8 = point3.x;
        int i9 = this.o / 2;
        rectF2.left = i8 - i9;
        rectF2.right = i9 + i8;
        int i10 = rect.top;
        int i11 = this.n;
        rectF2.top = i10 - i11;
        rectF2.bottom = rect.bottom + i11;
        canvas.drawRoundRect(rectF2, 2.0f, 2.0f, this.t);
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0054 A[PHI: r1
      0x0054: PHI (r1v9 int) = (r1v3 int), (r1v12 int) binds: [B:38:0x0087, B:20:0x0052] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:24:0x005a  */
    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int i3;
        int mode = View$MeasureSpec.getMode(i);
        int mode2 = View$MeasureSpec.getMode(i2);
        int size = (View$MeasureSpec.getSize(i) - getPaddingLeft()) - getPaddingRight();
        int size2 = (View$MeasureSpec.getSize(i2) - getPaddingBottom()) - getPaddingTop();
        if (mode != 1073741824 && mode2 != 1073741824) {
            int i4 = this.l;
            int i5 = this.j;
            i3 = size2 + i4 + i5;
            int i6 = (size - i4) - i5;
            if (this.E) {
                int i7 = this.k;
                i3 -= i4 + i7;
                i6 += i4 + i7;
            }
            boolean z2 = i3 <= size;
            boolean z3 = i6 <= size2;
            if (z2 && z3) {
                size2 = i6;
            } else if (!z3 && z2) {
                size = i3;
            } else if (!z2 && z3) {
                size2 = i6;
            }
        } else if (mode == 1073741824 && mode2 != 1073741824) {
            int i8 = this.l;
            int i9 = (size - i8) - this.j;
            if (this.E) {
                i9 += i8 + this.k;
            }
            if (i9 <= size2) {
                size2 = i9;
            }
        } else if (mode2 == 1073741824 && mode != 1073741824) {
            int i10 = this.l;
            i3 = size2 + i10 + this.j;
            if (this.E) {
                i3 -= i10 + this.k;
            }
            if (i3 <= size) {
                size = i3;
            }
        }
        setMeasuredDimension(getPaddingRight() + getPaddingLeft() + size, getPaddingBottom() + getPaddingTop() + size2);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            this.A = bundle.getInt(Key.ALPHA);
            this.B = bundle.getFloat("hue");
            this.C = bundle.getFloat("sat");
            this.D = bundle.getFloat("val");
            this.E = bundle.getBoolean("show_alpha");
            this.F = bundle.getString("alpha_text");
            parcelable = bundle.getParcelable("instanceState");
        }
        super.onRestoreInstanceState(parcelable);
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("instanceState", super.onSaveInstanceState());
        bundle.putInt(Key.ALPHA, this.A);
        bundle.putFloat("hue", this.B);
        bundle.putFloat("sat", this.C);
        bundle.putFloat("val", this.D);
        bundle.putBoolean("show_alpha", this.E);
        bundle.putString("alpha_text", this.F);
        return bundle;
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        Rect rect = new Rect();
        this.I = rect;
        rect.left = getPaddingLeft();
        this.I.right = i - getPaddingRight();
        this.I.top = getPaddingTop();
        this.I.bottom = i2 - getPaddingBottom();
        this.v = null;
        this.w = null;
        this.f3153x = null;
        this.f3154y = null;
        this.f3155z = null;
        Rect rect2 = this.I;
        int i5 = rect2.left + 1;
        int i6 = rect2.top + 1;
        int i7 = rect2.bottom - 1;
        int i8 = rect2.right - 1;
        int i9 = this.l;
        int i10 = (i8 - i9) - this.j;
        if (this.E) {
            i7 -= this.k + i9;
        }
        this.J = new Rect(i5, i6, i10, i7);
        Rect rect3 = this.I;
        int i11 = rect3.right;
        this.K = new Rect((i11 - this.j) + 1, rect3.top + 1, i11 - 1, (rect3.bottom - 1) - (this.E ? this.l + this.k : 0));
        if (this.E) {
            Rect rect4 = this.I;
            int i12 = rect4.left + 1;
            int i13 = rect4.bottom;
            this.L = new Rect(i12, (i13 - this.k) + 1, rect4.right - 1, i13 - 1);
            a aVar = new a(f.S(getContext(), 4.0f));
            this.N = aVar;
            aVar.setBounds(Math.round(this.L.left), Math.round(this.L.top), Math.round(this.L.right), Math.round(this.L.bottom));
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean zA;
        int action = motionEvent.getAction();
        if (action == 0) {
            this.M = new Point((int) motionEvent.getX(), (int) motionEvent.getY());
            zA = a(motionEvent);
        } else if (action != 1) {
            zA = action != 2 ? false : a(motionEvent);
        } else {
            this.M = null;
            zA = a(motionEvent);
        }
        if (!zA) {
            return super.onTouchEvent(motionEvent);
        }
        ColorPickerView$c colorPickerView$c = this.O;
        if (colorPickerView$c != null) {
            ((ColorPickerDialog) colorPickerView$c).k(Color.HSVToColor(this.A, new float[]{this.B, this.C, this.D}));
        }
        invalidate();
        return true;
    }

    public void setAlphaSliderText(int i) {
        setAlphaSliderText(getContext().getString(i));
    }

    public void setAlphaSliderVisible(boolean z2) {
        if (this.E != z2) {
            this.E = z2;
            this.v = null;
            this.w = null;
            this.f3153x = null;
            this.f3155z = null;
            this.f3154y = null;
            requestLayout();
        }
    }

    public void setBorderColor(int i) {
        this.H = i;
        invalidate();
    }

    public void setColor(int i) {
        b(i, false);
    }

    public void setOnColorChangedListener(ColorPickerView$c colorPickerView$c) {
        this.O = colorPickerView$c;
    }

    public void setSliderTrackerColor(int i) {
        this.G = i;
        this.t.setColor(i);
        invalidate();
    }

    public void setAlphaSliderText(String str) {
        this.F = str;
        invalidate();
    }
}
