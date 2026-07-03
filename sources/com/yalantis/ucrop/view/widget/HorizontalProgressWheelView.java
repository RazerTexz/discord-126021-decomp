package com.yalantis.ucrop.view.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.ColorInt;
import androidx.core.content.ContextCompat;
import com.yalantis.ucrop.C11199R;

/* JADX INFO: loaded from: classes3.dex */
public class HorizontalProgressWheelView extends View {

    /* JADX INFO: renamed from: j */
    public final Rect f22250j;

    /* JADX INFO: renamed from: k */
    public InterfaceC11207a f22251k;

    /* JADX INFO: renamed from: l */
    public float f22252l;

    /* JADX INFO: renamed from: m */
    public Paint f22253m;

    /* JADX INFO: renamed from: n */
    public Paint f22254n;

    /* JADX INFO: renamed from: o */
    public int f22255o;

    /* JADX INFO: renamed from: p */
    public int f22256p;

    /* JADX INFO: renamed from: q */
    public int f22257q;

    /* JADX INFO: renamed from: r */
    public boolean f22258r;

    /* JADX INFO: renamed from: s */
    public float f22259s;

    /* JADX INFO: renamed from: t */
    public int f22260t;

    /* JADX INFO: renamed from: com.yalantis.ucrop.view.widget.HorizontalProgressWheelView$a */
    public interface InterfaceC11207a {
        /* JADX INFO: renamed from: a */
        void mo7468a();

        /* JADX INFO: renamed from: b */
        void mo7469b(float f, float f2);

        /* JADX INFO: renamed from: c */
        void mo7470c();
    }

    public HorizontalProgressWheelView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.f22250j = new Rect();
        this.f22260t = ContextCompat.getColor(getContext(), C11199R.a.ucrop_color_widget_rotate_mid_line);
        this.f22255o = getContext().getResources().getDimensionPixelSize(C11199R.b.ucrop_width_horizontal_wheel_progress_line);
        this.f22256p = getContext().getResources().getDimensionPixelSize(C11199R.b.ucrop_height_horizontal_wheel_progress_line);
        this.f22257q = getContext().getResources().getDimensionPixelSize(C11199R.b.ucrop_margin_horizontal_wheel_progress_line);
        Paint paint = new Paint(1);
        this.f22253m = paint;
        paint.setStyle(Paint.Style.STROKE);
        this.f22253m.setStrokeWidth(this.f22255o);
        this.f22253m.setColor(getResources().getColor(C11199R.a.ucrop_color_progress_wheel_line));
        Paint paint2 = new Paint(this.f22253m);
        this.f22254n = paint2;
        paint2.setColor(this.f22260t);
        this.f22254n.setStrokeCap(Paint.Cap.ROUND);
        this.f22254n.setStrokeWidth(getContext().getResources().getDimensionPixelSize(C11199R.b.ucrop_width_middle_wheel_progress_line));
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.getClipBounds(this.f22250j);
        int iWidth = this.f22250j.width();
        int i = this.f22255o;
        int i2 = this.f22257q;
        int i3 = iWidth / (i + i2);
        float f = this.f22259s % (i2 + i);
        for (int i4 = 0; i4 < i3; i4++) {
            int i5 = i3 / 4;
            if (i4 < i5) {
                this.f22253m.setAlpha((int) ((i4 / i5) * 255.0f));
            } else if (i4 > (i3 * 3) / 4) {
                this.f22253m.setAlpha((int) (((i3 - i4) / i5) * 255.0f));
            } else {
                this.f22253m.setAlpha(255);
            }
            float f2 = -f;
            Rect rect = this.f22250j;
            float f3 = rect.left + f2 + ((this.f22255o + this.f22257q) * i4);
            float fCenterY = rect.centerY() - (this.f22256p / 4.0f);
            Rect rect2 = this.f22250j;
            canvas.drawLine(f3, fCenterY, f2 + rect2.left + ((this.f22255o + this.f22257q) * i4), (this.f22256p / 4.0f) + rect2.centerY(), this.f22253m);
        }
        canvas.drawLine(this.f22250j.centerX(), this.f22250j.centerY() - (this.f22256p / 2.0f), this.f22250j.centerX(), (this.f22256p / 2.0f) + this.f22250j.centerY(), this.f22254n);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f22252l = motionEvent.getX();
        } else if (action == 1) {
            InterfaceC11207a interfaceC11207a = this.f22251k;
            if (interfaceC11207a != null) {
                this.f22258r = false;
                interfaceC11207a.mo7468a();
            }
        } else if (action == 2) {
            float x2 = motionEvent.getX() - this.f22252l;
            if (x2 != 0.0f) {
                if (!this.f22258r) {
                    this.f22258r = true;
                    InterfaceC11207a interfaceC11207a2 = this.f22251k;
                    if (interfaceC11207a2 != null) {
                        interfaceC11207a2.mo7470c();
                    }
                }
                this.f22259s -= x2;
                postInvalidate();
                this.f22252l = motionEvent.getX();
                InterfaceC11207a interfaceC11207a3 = this.f22251k;
                if (interfaceC11207a3 != null) {
                    interfaceC11207a3.mo7469b(-x2, this.f22259s);
                }
            }
        }
        return true;
    }

    public void setMiddleLineColor(@ColorInt int i) {
        this.f22260t = i;
        this.f22254n.setColor(i);
        invalidate();
    }

    public void setScrollingListener(InterfaceC11207a interfaceC11207a) {
        this.f22251k = interfaceC11207a;
    }
}
