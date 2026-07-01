package com.google.android.exoplayer2.ui;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View$MeasureSpec;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeInfo$AccessibilityAction;
import androidx.annotation.ColorInt;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import b.c.a.a0.d;
import b.i.a.c.d3.b;
import b.i.a.c.d3.c;
import b.i.a.c.d3.o;
import b.i.a.c.d3.o$a;
import b.i.a.c.f3.e0;
import java.util.Collections;
import java.util.Formatter;
import java.util.Iterator;
import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: classes3.dex */
public class DefaultTimeBar extends View implements o {
    public final int A;
    public final int B;
    public final int C;
    public final StringBuilder D;
    public final Formatter E;
    public final Runnable F;
    public final CopyOnWriteArraySet<o$a> G;
    public final Point H;
    public final float I;
    public int J;
    public long K;
    public int L;
    public Rect M;
    public ValueAnimator N;
    public float O;
    public boolean P;
    public long Q;
    public long R;
    public long S;
    public long T;
    public int U;

    @Nullable
    public long[] V;

    @Nullable
    public boolean[] W;
    public final Rect j;
    public final Rect k;
    public final Rect l;
    public final Rect m;
    public final Paint n;
    public final Paint o;
    public final Paint p;
    public final Paint q;
    public final Paint r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Paint f2954s;

    @Nullable
    public final Drawable t;
    public final int u;
    public final int v;
    public final int w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final int f2955x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final int f2956y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final int f2957z;

    public DefaultTimeBar(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, attributeSet);
    }

    public static int c(float f, int i) {
        return (int) ((i * f) + 0.5f);
    }

    private long getPositionIncrement() {
        long j = this.K;
        if (j != -9223372036854775807L) {
            return j;
        }
        long j2 = this.R;
        if (j2 == -9223372036854775807L) {
            return 0L;
        }
        return j2 / ((long) this.J);
    }

    private String getProgressText() {
        return e0.u(this.D, this.E, this.S);
    }

    private long getScrubberPosition() {
        if (this.k.width() <= 0 || this.R == -9223372036854775807L) {
            return 0L;
        }
        return (((long) this.m.width()) * this.R) / ((long) this.k.width());
    }

    @Override // b.i.a.c.d3.o
    public void a(@Nullable long[] jArr, @Nullable boolean[] zArr, int i) {
        d.j(i == 0 || !(jArr == null || zArr == null));
        this.U = i;
        this.V = jArr;
        this.W = zArr;
        h();
    }

    @Override // b.i.a.c.d3.o
    public void b(o$a o_a) {
        this.G.add(o_a);
    }

    public final void d(float f) {
        Rect rect = this.m;
        Rect rect2 = this.k;
        rect.right = e0.h((int) f, rect2.left, rect2.right);
    }

    @Override // android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        i();
    }

    public final boolean e(long j) {
        long j2 = this.R;
        if (j2 <= 0) {
            return false;
        }
        long j3 = this.P ? this.Q : this.S;
        long jI = e0.i(j3 + j, 0L, j2);
        if (jI == j3) {
            return false;
        }
        if (this.P) {
            j(jI);
        } else {
            f(jI);
        }
        h();
        return true;
    }

    public final void f(long j) {
        this.Q = j;
        this.P = true;
        setPressed(true);
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
        Iterator<o$a> it = this.G.iterator();
        while (it.hasNext()) {
            it.next().m(this, j);
        }
    }

    public final void g(boolean z2) {
        removeCallbacks(this.F);
        this.P = false;
        setPressed(false);
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(false);
        }
        invalidate();
        Iterator<o$a> it = this.G.iterator();
        while (it.hasNext()) {
            it.next().l(this, this.Q, z2);
        }
    }

    @Override // b.i.a.c.d3.o
    public long getPreferredUpdateDelay() {
        int iWidth = (int) (this.k.width() / this.I);
        if (iWidth != 0) {
            long j = this.R;
            if (j != 0 && j != -9223372036854775807L) {
                return j / ((long) iWidth);
            }
        }
        return RecyclerView.FOREVER_NS;
    }

    public final void h() {
        this.l.set(this.k);
        this.m.set(this.k);
        long j = this.P ? this.Q : this.S;
        if (this.R > 0) {
            int iWidth = (int) ((((long) this.k.width()) * this.T) / this.R);
            Rect rect = this.l;
            Rect rect2 = this.k;
            rect.right = Math.min(rect2.left + iWidth, rect2.right);
            int iWidth2 = (int) ((((long) this.k.width()) * j) / this.R);
            Rect rect3 = this.m;
            Rect rect4 = this.k;
            rect3.right = Math.min(rect4.left + iWidth2, rect4.right);
        } else {
            Rect rect5 = this.l;
            int i = this.k.left;
            rect5.right = i;
            this.m.right = i;
        }
        invalidate(this.j);
    }

    public final void i() {
        Drawable drawable = this.t;
        if (drawable != null && drawable.isStateful() && this.t.setState(getDrawableState())) {
            invalidate();
        }
    }

    public final void j(long j) {
        if (this.Q == j) {
            return;
        }
        this.Q = j;
        Iterator<o$a> it = this.G.iterator();
        while (it.hasNext()) {
            it.next().k(this, j);
        }
    }

    @Override // android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.t;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        canvas.save();
        int iHeight = this.k.height();
        int iCenterY = this.k.centerY() - (iHeight / 2);
        int i = iHeight + iCenterY;
        if (this.R <= 0) {
            Rect rect = this.k;
            canvas.drawRect(rect.left, iCenterY, rect.right, i, this.p);
        } else {
            Rect rect2 = this.l;
            int i2 = rect2.left;
            int i3 = rect2.right;
            int iMax = Math.max(Math.max(this.k.left, i3), this.m.right);
            int i4 = this.k.right;
            if (iMax < i4) {
                canvas.drawRect(iMax, iCenterY, i4, i, this.p);
            }
            int iMax2 = Math.max(i2, this.m.right);
            if (i3 > iMax2) {
                canvas.drawRect(iMax2, iCenterY, i3, i, this.o);
            }
            if (this.m.width() > 0) {
                Rect rect3 = this.m;
                canvas.drawRect(rect3.left, iCenterY, rect3.right, i, this.n);
            }
            if (this.U != 0) {
                long[] jArr = this.V;
                Objects.requireNonNull(jArr);
                boolean[] zArr = this.W;
                Objects.requireNonNull(zArr);
                int i5 = this.f2955x / 2;
                for (int i6 = 0; i6 < this.U; i6++) {
                    int iWidth = ((int) ((((long) this.k.width()) * e0.i(jArr[i6], 0L, this.R)) / this.R)) - i5;
                    Rect rect4 = this.k;
                    int iMin = Math.min(rect4.width() - this.f2955x, Math.max(0, iWidth)) + rect4.left;
                    canvas.drawRect(iMin, iCenterY, iMin + this.f2955x, i, zArr[i6] ? this.r : this.q);
                }
            }
        }
        if (this.R > 0) {
            Rect rect5 = this.m;
            int iH = e0.h(rect5.right, rect5.left, this.k.right);
            int iCenterY2 = this.m.centerY();
            Drawable drawable = this.t;
            if (drawable == null) {
                canvas.drawCircle(iH, iCenterY2, (int) ((((this.P || isFocused()) ? this.A : isEnabled() ? this.f2956y : this.f2957z) * this.O) / 2.0f), this.f2954s);
            } else {
                int intrinsicWidth = ((int) (drawable.getIntrinsicWidth() * this.O)) / 2;
                int intrinsicHeight = ((int) (this.t.getIntrinsicHeight() * this.O)) / 2;
                this.t.setBounds(iH - intrinsicWidth, iCenterY2 - intrinsicHeight, iH + intrinsicWidth, iCenterY2 + intrinsicHeight);
                this.t.draw(canvas);
            }
        }
        canvas.restore();
    }

    @Override // android.view.View
    public void onFocusChanged(boolean z2, int i, @Nullable Rect rect) {
        super.onFocusChanged(z2, i, rect);
        if (!this.P || z2) {
            return;
        }
        g(false);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        if (accessibilityEvent.getEventType() == 4) {
            accessibilityEvent.getText().add(getProgressText());
        }
        accessibilityEvent.setClassName("android.widget.SeekBar");
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("android.widget.SeekBar");
        accessibilityNodeInfo.setContentDescription(getProgressText());
        if (this.R <= 0) {
            return;
        }
        if (e0.a >= 21) {
            accessibilityNodeInfo.addAction(AccessibilityNodeInfo$AccessibilityAction.ACTION_SCROLL_FORWARD);
            accessibilityNodeInfo.addAction(AccessibilityNodeInfo$AccessibilityAction.ACTION_SCROLL_BACKWARD);
        } else {
            accessibilityNodeInfo.addAction(4096);
            accessibilityNodeInfo.addAction(8192);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:11:0x001a  */
    /* JADX WARN: Code duplicated, block: B:13:0x0027  */
    /* JADX WARN: Code duplicated, block: B:15:0x002b  */
    @Override // android.view.View, android.view.KeyEvent$Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (isEnabled()) {
            long positionIncrement = getPositionIncrement();
            if (i != 66) {
                switch (i) {
                    case 21:
                        positionIncrement = -positionIncrement;
                        if (e(positionIncrement)) {
                            removeCallbacks(this.F);
                            postDelayed(this.F, 1000L);
                            return true;
                        }
                        break;
                    case 22:
                        if (e(positionIncrement)) {
                            removeCallbacks(this.F);
                            postDelayed(this.F, 1000L);
                            return true;
                        }
                        break;
                    case 23:
                        if (this.P) {
                            g(false);
                            return true;
                        }
                        break;
                }
            } else if (this.P) {
                g(false);
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.view.View
    public void onLayout(boolean z2, int i, int i2, int i3, int i4) {
        int paddingBottom;
        int iMax;
        Rect rect;
        int i5 = i3 - i;
        int i6 = i4 - i2;
        int paddingLeft = getPaddingLeft();
        int paddingRight = i5 - getPaddingRight();
        int i7 = this.B;
        if (this.w == 1) {
            paddingBottom = (i6 - getPaddingBottom()) - this.v;
            int paddingBottom2 = i6 - getPaddingBottom();
            int i8 = this.u;
            iMax = (paddingBottom2 - i8) - Math.max(i7 - (i8 / 2), 0);
        } else {
            paddingBottom = (i6 - this.v) / 2;
            iMax = (i6 - this.u) / 2;
        }
        this.j.set(paddingLeft, paddingBottom, paddingRight, this.v + paddingBottom);
        Rect rect2 = this.k;
        Rect rect3 = this.j;
        rect2.set(rect3.left + i7, iMax, rect3.right - i7, this.u + iMax);
        if (e0.a >= 29 && ((rect = this.M) == null || rect.width() != i5 || this.M.height() != i6)) {
            Rect rect4 = new Rect(0, 0, i5, i6);
            this.M = rect4;
            setSystemGestureExclusionRects(Collections.singletonList(rect4));
        }
        h();
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int mode = View$MeasureSpec.getMode(i2);
        int size = View$MeasureSpec.getSize(i2);
        if (mode == 0) {
            size = this.v;
        } else if (mode != 1073741824) {
            size = Math.min(this.v, size);
        }
        setMeasuredDimension(View$MeasureSpec.getSize(i), size);
        i();
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i) {
        Drawable drawable = this.t;
        if (drawable != null) {
            if (e0.a >= 23 && drawable.setLayoutDirection(i)) {
                invalidate();
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:23:0x005c  */
    /* JADX WARN: Code duplicated, block: B:25:0x0060  */
    /* JADX WARN: Code duplicated, block: B:27:0x0066  */
    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (isEnabled() && this.R > 0) {
            this.H.set((int) motionEvent.getX(), (int) motionEvent.getY());
            Point point = this.H;
            int i = point.x;
            int i2 = point.y;
            int action = motionEvent.getAction();
            if (action == 0) {
                float f = i;
                if (this.j.contains((int) f, i2)) {
                    d(f);
                    f(getScrubberPosition());
                    h();
                    invalidate();
                    return true;
                }
            } else if (action == 1) {
                if (this.P) {
                    g(motionEvent.getAction() == 3);
                    return true;
                }
            } else if (action != 2) {
                if (action == 3) {
                    if (this.P) {
                        g(motionEvent.getAction() == 3);
                        return true;
                    }
                }
            } else if (this.P) {
                if (i2 < this.C) {
                    int i3 = this.L;
                    d(((i - i3) / 3) + i3);
                } else {
                    this.L = i;
                    d(i);
                }
                j(getScrubberPosition());
                h();
                invalidate();
                return true;
            }
        }
        return false;
    }

    @Override // android.view.View
    public boolean performAccessibilityAction(int i, @Nullable Bundle bundle) {
        if (super.performAccessibilityAction(i, bundle)) {
            return true;
        }
        if (this.R <= 0) {
            return false;
        }
        if (i == 8192) {
            if (e(-getPositionIncrement())) {
                g(false);
            }
        } else {
            if (i != 4096) {
                return false;
            }
            if (e(getPositionIncrement())) {
                g(false);
            }
        }
        sendAccessibilityEvent(4);
        return true;
    }

    public void setAdMarkerColor(@ColorInt int i) {
        this.q.setColor(i);
        invalidate(this.j);
    }

    public void setBufferedColor(@ColorInt int i) {
        this.o.setColor(i);
        invalidate(this.j);
    }

    @Override // b.i.a.c.d3.o
    public void setBufferedPosition(long j) {
        if (this.T == j) {
            return;
        }
        this.T = j;
        h();
    }

    @Override // b.i.a.c.d3.o
    public void setDuration(long j) {
        if (this.R == j) {
            return;
        }
        this.R = j;
        if (this.P && j == -9223372036854775807L) {
            g(true);
        }
        h();
    }

    @Override // android.view.View, b.i.a.c.d3.o
    public void setEnabled(boolean z2) {
        super.setEnabled(z2);
        if (!this.P || z2) {
            return;
        }
        g(true);
    }

    public void setKeyCountIncrement(int i) {
        d.j(i > 0);
        this.J = i;
        this.K = -9223372036854775807L;
    }

    public void setKeyTimeIncrement(long j) {
        d.j(j > 0);
        this.J = -1;
        this.K = j;
    }

    public void setPlayedAdMarkerColor(@ColorInt int i) {
        this.r.setColor(i);
        invalidate(this.j);
    }

    public void setPlayedColor(@ColorInt int i) {
        this.n.setColor(i);
        invalidate(this.j);
    }

    @Override // b.i.a.c.d3.o
    public void setPosition(long j) {
        if (this.S == j) {
            return;
        }
        this.S = j;
        setContentDescription(getProgressText());
        h();
    }

    public void setScrubberColor(@ColorInt int i) {
        this.f2954s.setColor(i);
        invalidate(this.j);
    }

    public void setUnplayedColor(@ColorInt int i) {
        this.p.setColor(i);
        invalidate(this.j);
    }

    public DefaultTimeBar(Context context, @Nullable AttributeSet attributeSet, int i, @Nullable AttributeSet attributeSet2) {
        super(context, attributeSet, i);
        this.j = new Rect();
        this.k = new Rect();
        this.l = new Rect();
        this.m = new Rect();
        Paint paint = new Paint();
        this.n = paint;
        Paint paint2 = new Paint();
        this.o = paint2;
        Paint paint3 = new Paint();
        this.p = paint3;
        Paint paint4 = new Paint();
        this.q = paint4;
        Paint paint5 = new Paint();
        this.r = paint5;
        Paint paint6 = new Paint();
        this.f2954s = paint6;
        paint6.setAntiAlias(true);
        this.G = new CopyOnWriteArraySet<>();
        this.H = new Point();
        float f = context.getResources().getDisplayMetrics().density;
        this.I = f;
        this.C = c(f, -50);
        int iC = c(f, 4);
        int iC2 = c(f, 26);
        int iC3 = c(f, 4);
        int iC4 = c(f, 12);
        int iC5 = c(f, 0);
        int iC6 = c(f, 16);
        if (attributeSet2 != null) {
            TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet2, R$g.DefaultTimeBar, i, 0);
            try {
                Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(R$g.DefaultTimeBar_scrubber_drawable);
                this.t = drawable;
                if (drawable != null) {
                    int i2 = e0.a;
                    if (i2 >= 23) {
                        int layoutDirection = getLayoutDirection();
                        if (i2 >= 23) {
                            drawable.setLayoutDirection(layoutDirection);
                        }
                    }
                    iC2 = Math.max(drawable.getMinimumHeight(), iC2);
                }
                this.u = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$g.DefaultTimeBar_bar_height, iC);
                this.v = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$g.DefaultTimeBar_touch_target_height, iC2);
                this.w = typedArrayObtainStyledAttributes.getInt(R$g.DefaultTimeBar_bar_gravity, 0);
                this.f2955x = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$g.DefaultTimeBar_ad_marker_width, iC3);
                this.f2956y = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$g.DefaultTimeBar_scrubber_enabled_size, iC4);
                this.f2957z = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$g.DefaultTimeBar_scrubber_disabled_size, iC5);
                this.A = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$g.DefaultTimeBar_scrubber_dragged_size, iC6);
                int i3 = typedArrayObtainStyledAttributes.getInt(R$g.DefaultTimeBar_played_color, -1);
                int i4 = typedArrayObtainStyledAttributes.getInt(R$g.DefaultTimeBar_scrubber_color, -1);
                int i5 = typedArrayObtainStyledAttributes.getInt(R$g.DefaultTimeBar_buffered_color, -855638017);
                int i6 = typedArrayObtainStyledAttributes.getInt(R$g.DefaultTimeBar_unplayed_color, 872415231);
                int i7 = typedArrayObtainStyledAttributes.getInt(R$g.DefaultTimeBar_ad_marker_color, -1291845888);
                int i8 = typedArrayObtainStyledAttributes.getInt(R$g.DefaultTimeBar_played_ad_marker_color, 872414976);
                paint.setColor(i3);
                paint6.setColor(i4);
                paint2.setColor(i5);
                paint3.setColor(i6);
                paint4.setColor(i7);
                paint5.setColor(i8);
                typedArrayObtainStyledAttributes.recycle();
            } catch (Throwable th) {
                typedArrayObtainStyledAttributes.recycle();
                throw th;
            }
        } else {
            this.u = iC;
            this.v = iC2;
            this.w = 0;
            this.f2955x = iC3;
            this.f2956y = iC4;
            this.f2957z = iC5;
            this.A = iC6;
            paint.setColor(-1);
            paint6.setColor(-1);
            paint2.setColor(-855638017);
            paint3.setColor(872415231);
            paint4.setColor(-1291845888);
            paint5.setColor(872414976);
            this.t = null;
        }
        StringBuilder sb = new StringBuilder();
        this.D = sb;
        this.E = new Formatter(sb, Locale.getDefault());
        this.F = new b(this);
        Drawable drawable2 = this.t;
        if (drawable2 != null) {
            this.B = (drawable2.getMinimumWidth() + 1) / 2;
        } else {
            this.B = (Math.max(this.f2957z, Math.max(this.f2956y, this.A)) + 1) / 2;
        }
        this.O = 1.0f;
        ValueAnimator valueAnimator = new ValueAnimator();
        this.N = valueAnimator;
        valueAnimator.addUpdateListener(new c(this));
        this.R = -9223372036854775807L;
        this.K = -9223372036854775807L;
        this.J = 20;
        setFocusable(true);
        if (getImportantForAccessibility() == 0) {
            setImportantForAccessibility(1);
        }
    }
}
