package com.google.android.material.timepicker;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.annotation.FloatRange;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class ClockHandView extends View {
    public static final /* synthetic */ int j = 0;
    public int A;
    public ValueAnimator k;
    public boolean l;
    public float m;
    public float n;
    public boolean o;
    public int p;
    public final List<OnRotateListener> q;
    public final int r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final float f3074s;
    public final Paint t;
    public final RectF u;

    @Px
    public final int v;
    public float w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f3075x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public OnActionUpListener f3076y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public double f3077z;

    public interface OnActionUpListener {
        void onActionUp(@FloatRange(from = 0.0d, to = 360.0d) float f, boolean z2);
    }

    public interface OnRotateListener {
        void onRotate(@FloatRange(from = 0.0d, to = 360.0d) float f, boolean z2);
    }

    public class a implements ValueAnimator.AnimatorUpdateListener {
        public a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            ClockHandView clockHandView = ClockHandView.this;
            int i = ClockHandView.j;
            clockHandView.c(fFloatValue, true);
        }
    }

    public class b extends AnimatorListenerAdapter {
        public b(ClockHandView clockHandView) {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            animator.end();
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public ClockHandView(Context context, @Nullable AttributeSet attributeSet) {
        int i = R.attr.materialClockStyle;
        super(context, attributeSet, i);
        this.q = new ArrayList();
        Paint paint = new Paint();
        this.t = paint;
        this.u = new RectF();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ClockHandView, i, R.style.Widget_MaterialComponents_TimePicker_Clock);
        this.A = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.ClockHandView_materialCircleRadius, 0);
        this.r = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.ClockHandView_selectorSize, 0);
        Resources resources = getResources();
        this.v = resources.getDimensionPixelSize(R.dimen.material_clock_hand_stroke_width);
        this.f3074s = resources.getDimensionPixelSize(R.dimen.material_clock_hand_center_dot_radius);
        int color = typedArrayObtainStyledAttributes.getColor(R.styleable.ClockHandView_clockHandColor, 0);
        paint.setAntiAlias(true);
        paint.setColor(color);
        b(0.0f, false);
        this.p = ViewConfiguration.get(context).getScaledTouchSlop();
        ViewCompat.setImportantForAccessibility(this, 2);
        typedArrayObtainStyledAttributes.recycle();
    }

    public final int a(float f, float f2) {
        int degrees = ((int) Math.toDegrees(Math.atan2(f2 - (getHeight() / 2), f - (getWidth() / 2)))) + 90;
        return degrees < 0 ? degrees + 360 : degrees;
    }

    public void b(@FloatRange(from = 0.0d, to = 360.0d) float f, boolean z2) {
        ValueAnimator valueAnimator = this.k;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        if (!z2) {
            c(f, false);
            return;
        }
        float f2 = this.w;
        if (Math.abs(f2 - f) > 180.0f) {
            if (f2 > 180.0f && f < 180.0f) {
                f += 360.0f;
            }
            if (f2 < 180.0f && f > 180.0f) {
                f2 += 360.0f;
            }
        }
        Pair pair = new Pair(Float.valueOf(f2), Float.valueOf(f));
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(((Float) pair.first).floatValue(), ((Float) pair.second).floatValue());
        this.k = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(200L);
        this.k.addUpdateListener(new a());
        this.k.addListener(new b(this));
        this.k.start();
    }

    public final void c(@FloatRange(from = 0.0d, to = 360.0d) float f, boolean z2) {
        float f2 = f % 360.0f;
        this.w = f2;
        this.f3077z = Math.toRadians(f2 - 90.0f);
        int height = getHeight() / 2;
        float fCos = (this.A * ((float) Math.cos(this.f3077z))) + (getWidth() / 2);
        float fSin = (this.A * ((float) Math.sin(this.f3077z))) + height;
        RectF rectF = this.u;
        int i = this.r;
        rectF.set(fCos - i, fSin - i, fCos + i, fSin + i);
        Iterator<OnRotateListener> it = this.q.iterator();
        while (it.hasNext()) {
            it.next().onRotate(f2, z2);
        }
        invalidate();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int height = getHeight() / 2;
        int width = getWidth() / 2;
        float f = width;
        float fCos = (this.A * ((float) Math.cos(this.f3077z))) + f;
        float f2 = height;
        float fSin = (this.A * ((float) Math.sin(this.f3077z))) + f2;
        this.t.setStrokeWidth(0.0f);
        canvas.drawCircle(fCos, fSin, this.r, this.t);
        double dSin = Math.sin(this.f3077z);
        double dCos = Math.cos(this.f3077z);
        double d = this.A - this.r;
        this.t.setStrokeWidth(this.v);
        canvas.drawLine(f, f2, width + ((int) (dCos * d)), height + ((int) (d * dSin)), this.t);
        canvas.drawCircle(f, f2, this.f3074s, this.t);
    }

    @Override // android.view.View
    public void onLayout(boolean z2, int i, int i2, int i3, int i4) {
        super.onLayout(z2, i, i2, i3, i4);
        b(this.w, false);
    }

    @Override // android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z2;
        boolean z3;
        boolean z4;
        OnActionUpListener onActionUpListener;
        int actionMasked = motionEvent.getActionMasked();
        float x2 = motionEvent.getX();
        float y2 = motionEvent.getY();
        boolean z5 = false;
        if (actionMasked != 0) {
            if (actionMasked == 1 || actionMasked == 2) {
                int i = (int) (x2 - this.m);
                int i2 = (int) (y2 - this.n);
                this.o = (i2 * i2) + (i * i) > this.p;
                z3 = this.f3075x;
                z2 = actionMasked == 1;
            } else {
                z2 = false;
                z3 = false;
            }
            z4 = false;
        } else {
            this.m = x2;
            this.n = y2;
            this.o = true;
            this.f3075x = false;
            z2 = false;
            z3 = false;
            z4 = true;
        }
        boolean z6 = this.f3075x;
        float fA = a(x2, y2);
        boolean z7 = this.w != fA;
        if (z4 && z7) {
            z5 = true;
        } else if (z7 || z3) {
            if (z2 && this.l) {
                z5 = true;
            }
            b(fA, z5);
            z5 = true;
        }
        boolean z8 = z5 | z6;
        this.f3075x = z8;
        if (z8 && z2 && (onActionUpListener = this.f3076y) != null) {
            onActionUpListener.onActionUp(a(x2, y2), this.o);
        }
        return true;
    }
}
