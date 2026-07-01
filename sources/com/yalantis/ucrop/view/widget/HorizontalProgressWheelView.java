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
import com.yalantis.ucrop.R;

/* JADX INFO: loaded from: classes3.dex */
public class HorizontalProgressWheelView extends View {
    public final Rect j;
    public a k;
    public float l;
    public Paint m;
    public Paint n;
    public int o;
    public int p;
    public int q;
    public boolean r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public float f3186s;
    public int t;

    public interface a {
        void a();

        void b(float f, float f2);

        void c();
    }

    public HorizontalProgressWheelView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.j = new Rect();
        this.t = ContextCompat.getColor(getContext(), R.a.ucrop_color_widget_rotate_mid_line);
        this.o = getContext().getResources().getDimensionPixelSize(R.b.ucrop_width_horizontal_wheel_progress_line);
        this.p = getContext().getResources().getDimensionPixelSize(R.b.ucrop_height_horizontal_wheel_progress_line);
        this.q = getContext().getResources().getDimensionPixelSize(R.b.ucrop_margin_horizontal_wheel_progress_line);
        Paint paint = new Paint(1);
        this.m = paint;
        paint.setStyle(Paint.Style.STROKE);
        this.m.setStrokeWidth(this.o);
        this.m.setColor(getResources().getColor(R.a.ucrop_color_progress_wheel_line));
        Paint paint2 = new Paint(this.m);
        this.n = paint2;
        paint2.setColor(this.t);
        this.n.setStrokeCap(Paint.Cap.ROUND);
        this.n.setStrokeWidth(getContext().getResources().getDimensionPixelSize(R.b.ucrop_width_middle_wheel_progress_line));
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.getClipBounds(this.j);
        int iWidth = this.j.width();
        int i = this.o;
        int i2 = this.q;
        int i3 = iWidth / (i + i2);
        float f = this.f3186s % (i2 + i);
        for (int i4 = 0; i4 < i3; i4++) {
            int i5 = i3 / 4;
            if (i4 < i5) {
                this.m.setAlpha((int) ((i4 / i5) * 255.0f));
            } else if (i4 > (i3 * 3) / 4) {
                this.m.setAlpha((int) (((i3 - i4) / i5) * 255.0f));
            } else {
                this.m.setAlpha(255);
            }
            float f2 = -f;
            Rect rect = this.j;
            float f3 = rect.left + f2 + ((this.o + this.q) * i4);
            float fCenterY = rect.centerY() - (this.p / 4.0f);
            Rect rect2 = this.j;
            canvas.drawLine(f3, fCenterY, f2 + rect2.left + ((this.o + this.q) * i4), (this.p / 4.0f) + rect2.centerY(), this.m);
        }
        canvas.drawLine(this.j.centerX(), this.j.centerY() - (this.p / 2.0f), this.j.centerX(), (this.p / 2.0f) + this.j.centerY(), this.n);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.l = motionEvent.getX();
        } else if (action == 1) {
            a aVar = this.k;
            if (aVar != null) {
                this.r = false;
                aVar.a();
            }
        } else if (action == 2) {
            float x2 = motionEvent.getX() - this.l;
            if (x2 != 0.0f) {
                if (!this.r) {
                    this.r = true;
                    a aVar2 = this.k;
                    if (aVar2 != null) {
                        aVar2.c();
                    }
                }
                this.f3186s -= x2;
                postInvalidate();
                this.l = motionEvent.getX();
                a aVar3 = this.k;
                if (aVar3 != null) {
                    aVar3.b(-x2, this.f3186s);
                }
            }
        }
        return true;
    }

    public void setMiddleLineColor(@ColorInt int i) {
        this.t = i;
        this.n.setColor(i);
        invalidate();
    }

    public void setScrollingListener(a aVar) {
        this.k = aVar;
    }
}
