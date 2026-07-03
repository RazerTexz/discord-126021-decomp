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
import com.google.android.material.C10817R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class ClockHandView extends View {

    /* JADX INFO: renamed from: j */
    public static final /* synthetic */ int f21197j = 0;

    /* JADX INFO: renamed from: A */
    public int f21198A;

    /* JADX INFO: renamed from: k */
    public ValueAnimator f21199k;

    /* JADX INFO: renamed from: l */
    public boolean f21200l;

    /* JADX INFO: renamed from: m */
    public float f21201m;

    /* JADX INFO: renamed from: n */
    public float f21202n;

    /* JADX INFO: renamed from: o */
    public boolean f21203o;

    /* JADX INFO: renamed from: p */
    public int f21204p;

    /* JADX INFO: renamed from: q */
    public final List<OnRotateListener> f21205q;

    /* JADX INFO: renamed from: r */
    public final int f21206r;

    /* JADX INFO: renamed from: s */
    public final float f21207s;

    /* JADX INFO: renamed from: t */
    public final Paint f21208t;

    /* JADX INFO: renamed from: u */
    public final RectF f21209u;

    /* JADX INFO: renamed from: v */
    @Px
    public final int f21210v;

    /* JADX INFO: renamed from: w */
    public float f21211w;

    /* JADX INFO: renamed from: x */
    public boolean f21212x;

    /* JADX INFO: renamed from: y */
    public OnActionUpListener f21213y;

    /* JADX INFO: renamed from: z */
    public double f21214z;

    public interface OnActionUpListener {
        void onActionUp(@FloatRange(from = 0.0d, m75to = 360.0d) float f, boolean z2);
    }

    public interface OnRotateListener {
        void onRotate(@FloatRange(from = 0.0d, m75to = 360.0d) float f, boolean z2);
    }

    /* JADX INFO: renamed from: com.google.android.material.timepicker.ClockHandView$a */
    public class C11021a implements ValueAnimator.AnimatorUpdateListener {
        public C11021a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            ClockHandView clockHandView = ClockHandView.this;
            int i = ClockHandView.f21197j;
            clockHandView.m9159c(fFloatValue, true);
        }
    }

    /* JADX INFO: renamed from: com.google.android.material.timepicker.ClockHandView$b */
    public class C11022b extends AnimatorListenerAdapter {
        public C11022b(ClockHandView clockHandView) {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            animator.end();
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public ClockHandView(Context context, @Nullable AttributeSet attributeSet) {
        int i = C10817R.attr.materialClockStyle;
        super(context, attributeSet, i);
        this.f21205q = new ArrayList();
        Paint paint = new Paint();
        this.f21208t = paint;
        this.f21209u = new RectF();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C10817R.styleable.ClockHandView, i, C10817R.style.Widget_MaterialComponents_TimePicker_Clock);
        this.f21198A = typedArrayObtainStyledAttributes.getDimensionPixelSize(C10817R.styleable.ClockHandView_materialCircleRadius, 0);
        this.f21206r = typedArrayObtainStyledAttributes.getDimensionPixelSize(C10817R.styleable.ClockHandView_selectorSize, 0);
        Resources resources = getResources();
        this.f21210v = resources.getDimensionPixelSize(C10817R.dimen.material_clock_hand_stroke_width);
        this.f21207s = resources.getDimensionPixelSize(C10817R.dimen.material_clock_hand_center_dot_radius);
        int color = typedArrayObtainStyledAttributes.getColor(C10817R.styleable.ClockHandView_clockHandColor, 0);
        paint.setAntiAlias(true);
        paint.setColor(color);
        m9158b(0.0f, false);
        this.f21204p = ViewConfiguration.get(context).getScaledTouchSlop();
        ViewCompat.setImportantForAccessibility(this, 2);
        typedArrayObtainStyledAttributes.recycle();
    }

    /* JADX INFO: renamed from: a */
    public final int m9157a(float f, float f2) {
        int degrees = ((int) Math.toDegrees(Math.atan2(f2 - (getHeight() / 2), f - (getWidth() / 2)))) + 90;
        return degrees < 0 ? degrees + 360 : degrees;
    }

    /* JADX INFO: renamed from: b */
    public void m9158b(@FloatRange(from = 0.0d, m75to = 360.0d) float f, boolean z2) {
        ValueAnimator valueAnimator = this.f21199k;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        if (!z2) {
            m9159c(f, false);
            return;
        }
        float f2 = this.f21211w;
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
        this.f21199k = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(200L);
        this.f21199k.addUpdateListener(new C11021a());
        this.f21199k.addListener(new C11022b(this));
        this.f21199k.start();
    }

    /* JADX INFO: renamed from: c */
    public final void m9159c(@FloatRange(from = 0.0d, m75to = 360.0d) float f, boolean z2) {
        float f2 = f % 360.0f;
        this.f21211w = f2;
        this.f21214z = Math.toRadians(f2 - 90.0f);
        int height = getHeight() / 2;
        float fCos = (this.f21198A * ((float) Math.cos(this.f21214z))) + (getWidth() / 2);
        float fSin = (this.f21198A * ((float) Math.sin(this.f21214z))) + height;
        RectF rectF = this.f21209u;
        int i = this.f21206r;
        rectF.set(fCos - i, fSin - i, fCos + i, fSin + i);
        Iterator<OnRotateListener> it = this.f21205q.iterator();
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
        float fCos = (this.f21198A * ((float) Math.cos(this.f21214z))) + f;
        float f2 = height;
        float fSin = (this.f21198A * ((float) Math.sin(this.f21214z))) + f2;
        this.f21208t.setStrokeWidth(0.0f);
        canvas.drawCircle(fCos, fSin, this.f21206r, this.f21208t);
        double dSin = Math.sin(this.f21214z);
        double dCos = Math.cos(this.f21214z);
        double d = this.f21198A - this.f21206r;
        this.f21208t.setStrokeWidth(this.f21210v);
        canvas.drawLine(f, f2, width + ((int) (dCos * d)), height + ((int) (d * dSin)), this.f21208t);
        canvas.drawCircle(f, f2, this.f21207s, this.f21208t);
    }

    @Override // android.view.View
    public void onLayout(boolean z2, int i, int i2, int i3, int i4) {
        super.onLayout(z2, i, i2, i3, i4);
        m9158b(this.f21211w, false);
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
                int i = (int) (x2 - this.f21201m);
                int i2 = (int) (y2 - this.f21202n);
                this.f21203o = (i2 * i2) + (i * i) > this.f21204p;
                z3 = this.f21212x;
                z2 = actionMasked == 1;
            } else {
                z2 = false;
                z3 = false;
            }
            z4 = false;
        } else {
            this.f21201m = x2;
            this.f21202n = y2;
            this.f21203o = true;
            this.f21212x = false;
            z2 = false;
            z3 = false;
            z4 = true;
        }
        boolean z6 = this.f21212x;
        float fM9157a = m9157a(x2, y2);
        boolean z7 = this.f21211w != fM9157a;
        if (z4 && z7) {
            z5 = true;
        } else if (z7 || z3) {
            if (z2 && this.f21200l) {
                z5 = true;
            }
            m9158b(fM9157a, z5);
            z5 = true;
        }
        boolean z8 = z5 | z6;
        this.f21212x = z8;
        if (z8 && z2 && (onActionUpListener = this.f21213y) != null) {
            onActionUpListener.onActionUp(m9157a(x2, y2), this.f21203o);
        }
        return true;
    }
}
