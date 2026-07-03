package com.jaredrummler.android.colorpicker;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ComposeShader;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import androidx.constraintlayout.motion.widget.Key;
import androidx.core.view.ViewCompat;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p007b.p440k.p441a.p442a.C5074a;

/* JADX INFO: loaded from: classes3.dex */
public class ColorPickerView extends View {

    /* JADX INFO: renamed from: A */
    public int f21773A;

    /* JADX INFO: renamed from: B */
    public float f21774B;

    /* JADX INFO: renamed from: C */
    public float f21775C;

    /* JADX INFO: renamed from: D */
    public float f21776D;

    /* JADX INFO: renamed from: E */
    public boolean f21777E;

    /* JADX INFO: renamed from: F */
    public String f21778F;

    /* JADX INFO: renamed from: G */
    public int f21779G;

    /* JADX INFO: renamed from: H */
    public int f21780H;

    /* JADX INFO: renamed from: I */
    public Rect f21781I;

    /* JADX INFO: renamed from: J */
    public Rect f21782J;

    /* JADX INFO: renamed from: K */
    public Rect f21783K;

    /* JADX INFO: renamed from: L */
    public Rect f21784L;

    /* JADX INFO: renamed from: M */
    public Point f21785M;

    /* JADX INFO: renamed from: N */
    public C5074a f21786N;

    /* JADX INFO: renamed from: O */
    public InterfaceC11166c f21787O;

    /* JADX INFO: renamed from: j */
    public int f21788j;

    /* JADX INFO: renamed from: k */
    public int f21789k;

    /* JADX INFO: renamed from: l */
    public int f21790l;

    /* JADX INFO: renamed from: m */
    public int f21791m;

    /* JADX INFO: renamed from: n */
    public int f21792n;

    /* JADX INFO: renamed from: o */
    public int f21793o;

    /* JADX INFO: renamed from: p */
    public Paint f21794p;

    /* JADX INFO: renamed from: q */
    public Paint f21795q;

    /* JADX INFO: renamed from: r */
    public Paint f21796r;

    /* JADX INFO: renamed from: s */
    public Paint f21797s;

    /* JADX INFO: renamed from: t */
    public Paint f21798t;

    /* JADX INFO: renamed from: u */
    public Paint f21799u;

    /* JADX INFO: renamed from: v */
    public Shader f21800v;

    /* JADX INFO: renamed from: w */
    public Shader f21801w;

    /* JADX INFO: renamed from: x */
    public Shader f21802x;

    /* JADX INFO: renamed from: y */
    public C11165b f21803y;

    /* JADX INFO: renamed from: z */
    public C11165b f21804z;

    /* JADX INFO: renamed from: com.jaredrummler.android.colorpicker.ColorPickerView$b */
    public class C11165b {

        /* JADX INFO: renamed from: a */
        public Canvas f21805a;

        /* JADX INFO: renamed from: b */
        public Bitmap f21806b;

        /* JADX INFO: renamed from: c */
        public float f21807c;

        public C11165b(ColorPickerView colorPickerView, C11164a c11164a) {
        }
    }

    /* JADX INFO: renamed from: com.jaredrummler.android.colorpicker.ColorPickerView$c */
    public interface InterfaceC11166c {
    }

    public ColorPickerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.f21773A = 255;
        this.f21774B = 360.0f;
        this.f21775C = 0.0f;
        this.f21776D = 0.0f;
        this.f21777E = false;
        this.f21778F = null;
        this.f21779G = -4342339;
        this.f21780H = -9539986;
        this.f21785M = null;
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, C11167R.f.ColorPickerView);
        this.f21777E = typedArrayObtainStyledAttributes.getBoolean(C11167R.f.ColorPickerView_cpv_alphaChannelVisible, false);
        this.f21778F = typedArrayObtainStyledAttributes.getString(C11167R.f.ColorPickerView_cpv_alphaChannelText);
        this.f21779G = typedArrayObtainStyledAttributes.getColor(C11167R.f.ColorPickerView_cpv_sliderColor, -4342339);
        this.f21780H = typedArrayObtainStyledAttributes.getColor(C11167R.f.ColorPickerView_cpv_borderColor, -9539986);
        typedArrayObtainStyledAttributes.recycle();
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(new TypedValue().data, new int[]{android.R.attr.textColorSecondary});
        if (this.f21780H == -9539986) {
            this.f21780H = typedArrayObtainStyledAttributes2.getColor(0, -9539986);
        }
        if (this.f21779G == -4342339) {
            this.f21779G = typedArrayObtainStyledAttributes2.getColor(0, -4342339);
        }
        typedArrayObtainStyledAttributes2.recycle();
        this.f21788j = C3404f.m4243S(getContext(), 30.0f);
        this.f21789k = C3404f.m4243S(getContext(), 20.0f);
        this.f21790l = C3404f.m4243S(getContext(), 10.0f);
        this.f21791m = C3404f.m4243S(getContext(), 5.0f);
        this.f21793o = C3404f.m4243S(getContext(), 4.0f);
        this.f21792n = C3404f.m4243S(getContext(), 2.0f);
        this.f21794p = new Paint();
        this.f21795q = new Paint();
        this.f21798t = new Paint();
        this.f21796r = new Paint();
        this.f21797s = new Paint();
        this.f21799u = new Paint();
        this.f21795q.setStyle(Paint.Style.STROKE);
        this.f21795q.setStrokeWidth(C3404f.m4243S(getContext(), 2.0f));
        this.f21795q.setAntiAlias(true);
        this.f21798t.setColor(this.f21779G);
        this.f21798t.setStyle(Paint.Style.STROKE);
        this.f21798t.setStrokeWidth(C3404f.m4243S(getContext(), 2.0f));
        this.f21798t.setAntiAlias(true);
        this.f21797s.setColor(-14935012);
        this.f21797s.setTextSize(C3404f.m4243S(getContext(), 14.0f));
        this.f21797s.setAntiAlias(true);
        this.f21797s.setTextAlign(Paint.Align.CENTER);
        this.f21797s.setFakeBoldText(true);
        setFocusable(true);
        setFocusableInTouchMode(true);
    }

    private int getPreferredHeight() {
        int iM4243S = C3404f.m4243S(getContext(), 200.0f);
        return this.f21777E ? iM4243S + this.f21790l + this.f21789k : iM4243S;
    }

    private int getPreferredWidth() {
        return C3404f.m4243S(getContext(), 200.0f) + this.f21788j + this.f21790l;
    }

    /* JADX INFO: renamed from: a */
    public final boolean m9276a(MotionEvent motionEvent) {
        float f;
        Point point = this.f21785M;
        int i = 0;
        if (point == null) {
            return false;
        }
        int i2 = point.x;
        int i3 = point.y;
        float f2 = 0.0f;
        if (this.f21783K.contains(i2, i3)) {
            float y2 = motionEvent.getY();
            Rect rect = this.f21783K;
            float fHeight = rect.height();
            float f3 = rect.top;
            if (y2 >= f3) {
                f2 = y2 > ((float) rect.bottom) ? fHeight : y2 - f3;
            }
            this.f21774B = 360.0f - ((f2 * 360.0f) / fHeight);
        } else if (this.f21782J.contains(i2, i3)) {
            float x2 = motionEvent.getX();
            float y3 = motionEvent.getY();
            Rect rect2 = this.f21782J;
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
            this.f21775C = fArr[0];
            this.f21776D = fArr[1];
        } else {
            Rect rect3 = this.f21784L;
            if (rect3 == null || !rect3.contains(i2, i3)) {
                return false;
            }
            int x3 = (int) motionEvent.getX();
            Rect rect4 = this.f21784L;
            int iWidth = rect4.width();
            int i4 = rect4.left;
            if (x3 >= i4) {
                i = x3 > rect4.right ? iWidth : x3 - i4;
            }
            this.f21773A = 255 - ((i * 255) / iWidth);
        }
        return true;
    }

    /* JADX INFO: renamed from: b */
    public void m9277b(int i, boolean z2) {
        InterfaceC11166c interfaceC11166c;
        int iAlpha = Color.alpha(i);
        float[] fArr = new float[3];
        Color.RGBToHSV(Color.red(i), Color.green(i), Color.blue(i), fArr);
        this.f21773A = iAlpha;
        float f = fArr[0];
        this.f21774B = f;
        float f2 = fArr[1];
        this.f21775C = f2;
        float f3 = fArr[2];
        this.f21776D = f3;
        if (z2 && (interfaceC11166c = this.f21787O) != null) {
            ((ColorPickerDialog) interfaceC11166c).m9271k(Color.HSVToColor(iAlpha, new float[]{f, f2, f3}));
        }
        invalidate();
    }

    public String getAlphaSliderText() {
        return this.f21778F;
    }

    public int getBorderColor() {
        return this.f21780H;
    }

    public int getColor() {
        return Color.HSVToColor(this.f21773A, new float[]{this.f21774B, this.f21775C, this.f21776D});
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
        return this.f21779G;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Rect rect;
        if (this.f21781I.width() <= 0 || this.f21781I.height() <= 0) {
            return;
        }
        Rect rect2 = this.f21782J;
        this.f21799u.setColor(this.f21780H);
        Rect rect3 = this.f21781I;
        canvas.drawRect(rect3.left, rect3.top, rect2.right + 1, rect2.bottom + 1, this.f21799u);
        if (this.f21800v == null) {
            float f = rect2.left;
            this.f21800v = new LinearGradient(f, rect2.top, f, rect2.bottom, -1, ViewCompat.MEASURED_STATE_MASK, Shader.TileMode.CLAMP);
        }
        C11165b c11165b = this.f21803y;
        if (c11165b == null || c11165b.f21807c != this.f21774B) {
            if (c11165b == null) {
                this.f21803y = new C11165b(this, null);
            }
            C11165b c11165b2 = this.f21803y;
            if (c11165b2.f21806b == null) {
                c11165b2.f21806b = Bitmap.createBitmap(rect2.width(), rect2.height(), Bitmap.Config.ARGB_8888);
            }
            C11165b c11165b3 = this.f21803y;
            if (c11165b3.f21805a == null) {
                c11165b3.f21805a = new Canvas(this.f21803y.f21806b);
            }
            int iHSVToColor = Color.HSVToColor(new float[]{this.f21774B, 1.0f, 1.0f});
            float f2 = rect2.left;
            float f3 = rect2.top;
            this.f21801w = new LinearGradient(f2, f3, rect2.right, f3, -1, iHSVToColor, Shader.TileMode.CLAMP);
            this.f21794p.setShader(new ComposeShader(this.f21800v, this.f21801w, PorterDuff.Mode.MULTIPLY));
            C11165b c11165b4 = this.f21803y;
            c11165b4.f21805a.drawRect(0.0f, 0.0f, c11165b4.f21806b.getWidth(), this.f21803y.f21806b.getHeight(), this.f21794p);
            this.f21803y.f21807c = this.f21774B;
        }
        canvas.drawBitmap(this.f21803y.f21806b, (Rect) null, rect2, (Paint) null);
        float f4 = this.f21775C;
        float f5 = this.f21776D;
        Rect rect4 = this.f21782J;
        float fHeight = rect4.height();
        float fWidth = rect4.width();
        Point point = new Point();
        point.x = (int) ((f4 * fWidth) + rect4.left);
        point.y = (int) (((1.0f - f5) * fHeight) + rect4.top);
        this.f21795q.setColor(ViewCompat.MEASURED_STATE_MASK);
        canvas.drawCircle(point.x, point.y, this.f21791m - C3404f.m4243S(getContext(), 1.0f), this.f21795q);
        this.f21795q.setColor(-2236963);
        canvas.drawCircle(point.x, point.y, this.f21791m, this.f21795q);
        Rect rect5 = this.f21783K;
        this.f21799u.setColor(this.f21780H);
        canvas.drawRect(rect5.left - 1, rect5.top - 1, rect5.right + 1, rect5.bottom + 1, this.f21799u);
        if (this.f21804z == null) {
            C11165b c11165b5 = new C11165b(this, null);
            this.f21804z = c11165b5;
            c11165b5.f21806b = Bitmap.createBitmap(rect5.width(), rect5.height(), Bitmap.Config.ARGB_8888);
            this.f21804z.f21805a = new Canvas(this.f21804z.f21806b);
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
                C11165b c11165b6 = this.f21804z;
                float f7 = i2;
                c11165b6.f21805a.drawLine(0.0f, f7, c11165b6.f21806b.getWidth(), f7, paint);
            }
        }
        canvas.drawBitmap(this.f21804z.f21806b, (Rect) null, rect5, (Paint) null);
        float f8 = this.f21774B;
        Rect rect6 = this.f21783K;
        float fHeight2 = rect6.height();
        Point point2 = new Point();
        point2.y = (int) ((fHeight2 - ((f8 * fHeight2) / 360.0f)) + rect6.top);
        point2.x = rect6.left;
        RectF rectF = new RectF();
        int i3 = rect5.left;
        int i4 = this.f21792n;
        rectF.left = i3 - i4;
        rectF.right = rect5.right + i4;
        int i5 = point2.y;
        int i6 = this.f21793o / 2;
        rectF.top = i5 - i6;
        rectF.bottom = i6 + i5;
        canvas.drawRoundRect(rectF, 2.0f, 2.0f, this.f21798t);
        if (!this.f21777E || (rect = this.f21784L) == null || this.f21786N == null) {
            return;
        }
        this.f21799u.setColor(this.f21780H);
        canvas.drawRect(rect.left - 1, rect.top - 1, rect.right + 1, rect.bottom + 1, this.f21799u);
        this.f21786N.draw(canvas);
        float[] fArr = {this.f21774B, this.f21775C, this.f21776D};
        int iHSVToColor2 = Color.HSVToColor(fArr);
        int iHSVToColor3 = Color.HSVToColor(0, fArr);
        float f9 = rect.left;
        float f10 = rect.top;
        LinearGradient linearGradient = new LinearGradient(f9, f10, rect.right, f10, iHSVToColor2, iHSVToColor3, Shader.TileMode.CLAMP);
        this.f21802x = linearGradient;
        this.f21796r.setShader(linearGradient);
        canvas.drawRect(rect, this.f21796r);
        String str = this.f21778F;
        if (str != null && !str.equals("")) {
            canvas.drawText(this.f21778F, rect.centerX(), C3404f.m4243S(getContext(), 4.0f) + rect.centerY(), this.f21797s);
        }
        int i7 = this.f21773A;
        Rect rect7 = this.f21784L;
        float fWidth2 = rect7.width();
        Point point3 = new Point();
        point3.x = (int) ((fWidth2 - ((i7 * fWidth2) / 255.0f)) + rect7.left);
        point3.y = rect7.top;
        RectF rectF2 = new RectF();
        int i8 = point3.x;
        int i9 = this.f21793o / 2;
        rectF2.left = i8 - i9;
        rectF2.right = i9 + i8;
        int i10 = rect.top;
        int i11 = this.f21792n;
        rectF2.top = i10 - i11;
        rectF2.bottom = rect.bottom + i11;
        canvas.drawRoundRect(rectF2, 2.0f, 2.0f, this.f21798t);
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0054 A[PHI: r1
      0x0054: PHI (r1v9 int) = (r1v3 int), (r1v12 int) binds: [B:38:0x0087, B:20:0x0052] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:24:0x005a  */
    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int i3;
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size = (View.MeasureSpec.getSize(i) - getPaddingLeft()) - getPaddingRight();
        int size2 = (View.MeasureSpec.getSize(i2) - getPaddingBottom()) - getPaddingTop();
        if (mode != 1073741824 && mode2 != 1073741824) {
            int i4 = this.f21790l;
            int i5 = this.f21788j;
            i3 = size2 + i4 + i5;
            int i6 = (size - i4) - i5;
            if (this.f21777E) {
                int i7 = this.f21789k;
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
            int i8 = this.f21790l;
            int i9 = (size - i8) - this.f21788j;
            if (this.f21777E) {
                i9 += i8 + this.f21789k;
            }
            if (i9 <= size2) {
                size2 = i9;
            }
        } else if (mode2 == 1073741824 && mode != 1073741824) {
            int i10 = this.f21790l;
            i3 = size2 + i10 + this.f21788j;
            if (this.f21777E) {
                i3 -= i10 + this.f21789k;
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
            this.f21773A = bundle.getInt(Key.ALPHA);
            this.f21774B = bundle.getFloat("hue");
            this.f21775C = bundle.getFloat("sat");
            this.f21776D = bundle.getFloat("val");
            this.f21777E = bundle.getBoolean("show_alpha");
            this.f21778F = bundle.getString("alpha_text");
            parcelable = bundle.getParcelable("instanceState");
        }
        super.onRestoreInstanceState(parcelable);
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("instanceState", super.onSaveInstanceState());
        bundle.putInt(Key.ALPHA, this.f21773A);
        bundle.putFloat("hue", this.f21774B);
        bundle.putFloat("sat", this.f21775C);
        bundle.putFloat("val", this.f21776D);
        bundle.putBoolean("show_alpha", this.f21777E);
        bundle.putString("alpha_text", this.f21778F);
        return bundle;
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        Rect rect = new Rect();
        this.f21781I = rect;
        rect.left = getPaddingLeft();
        this.f21781I.right = i - getPaddingRight();
        this.f21781I.top = getPaddingTop();
        this.f21781I.bottom = i2 - getPaddingBottom();
        this.f21800v = null;
        this.f21801w = null;
        this.f21802x = null;
        this.f21803y = null;
        this.f21804z = null;
        Rect rect2 = this.f21781I;
        int i5 = rect2.left + 1;
        int i6 = rect2.top + 1;
        int i7 = rect2.bottom - 1;
        int i8 = rect2.right - 1;
        int i9 = this.f21790l;
        int i10 = (i8 - i9) - this.f21788j;
        if (this.f21777E) {
            i7 -= this.f21789k + i9;
        }
        this.f21782J = new Rect(i5, i6, i10, i7);
        Rect rect3 = this.f21781I;
        int i11 = rect3.right;
        this.f21783K = new Rect((i11 - this.f21788j) + 1, rect3.top + 1, i11 - 1, (rect3.bottom - 1) - (this.f21777E ? this.f21790l + this.f21789k : 0));
        if (this.f21777E) {
            Rect rect4 = this.f21781I;
            int i12 = rect4.left + 1;
            int i13 = rect4.bottom;
            this.f21784L = new Rect(i12, (i13 - this.f21789k) + 1, rect4.right - 1, i13 - 1);
            C5074a c5074a = new C5074a(C3404f.m4243S(getContext(), 4.0f));
            this.f21786N = c5074a;
            c5074a.setBounds(Math.round(this.f21784L.left), Math.round(this.f21784L.top), Math.round(this.f21784L.right), Math.round(this.f21784L.bottom));
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean zM9276a;
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f21785M = new Point((int) motionEvent.getX(), (int) motionEvent.getY());
            zM9276a = m9276a(motionEvent);
        } else if (action != 1) {
            zM9276a = action != 2 ? false : m9276a(motionEvent);
        } else {
            this.f21785M = null;
            zM9276a = m9276a(motionEvent);
        }
        if (!zM9276a) {
            return super.onTouchEvent(motionEvent);
        }
        InterfaceC11166c interfaceC11166c = this.f21787O;
        if (interfaceC11166c != null) {
            ((ColorPickerDialog) interfaceC11166c).m9271k(Color.HSVToColor(this.f21773A, new float[]{this.f21774B, this.f21775C, this.f21776D}));
        }
        invalidate();
        return true;
    }

    public void setAlphaSliderText(int i) {
        setAlphaSliderText(getContext().getString(i));
    }

    public void setAlphaSliderVisible(boolean z2) {
        if (this.f21777E != z2) {
            this.f21777E = z2;
            this.f21800v = null;
            this.f21801w = null;
            this.f21802x = null;
            this.f21804z = null;
            this.f21803y = null;
            requestLayout();
        }
    }

    public void setBorderColor(int i) {
        this.f21780H = i;
        invalidate();
    }

    public void setColor(int i) {
        m9277b(i, false);
    }

    public void setOnColorChangedListener(InterfaceC11166c interfaceC11166c) {
        this.f21787O = interfaceC11166c;
    }

    public void setSliderTrackerColor(int i) {
        this.f21779G = i;
        this.f21798t.setColor(i);
        invalidate();
    }

    public void setAlphaSliderText(String str) {
        this.f21778F = str;
        invalidate();
    }
}
