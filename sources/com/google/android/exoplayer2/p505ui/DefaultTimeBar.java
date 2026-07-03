package com.google.android.exoplayer2.p505ui;

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
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.annotation.ColorInt;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.exoplayer2.p505ui.DefaultTimeBar;
import java.util.Collections;
import java.util.Formatter;
import java.util.Iterator;
import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArraySet;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p225i.p226a.p242c.p256d3.InterfaceC2671o;
import p007b.p225i.p226a.p242c.p259f3.C2738e0;

/* JADX INFO: loaded from: classes3.dex */
public class DefaultTimeBar extends View implements InterfaceC2671o {

    /* JADX INFO: renamed from: A */
    public final int f20063A;

    /* JADX INFO: renamed from: B */
    public final int f20064B;

    /* JADX INFO: renamed from: C */
    public final int f20065C;

    /* JADX INFO: renamed from: D */
    public final StringBuilder f20066D;

    /* JADX INFO: renamed from: E */
    public final Formatter f20067E;

    /* JADX INFO: renamed from: F */
    public final Runnable f20068F;

    /* JADX INFO: renamed from: G */
    public final CopyOnWriteArraySet<InterfaceC2671o.a> f20069G;

    /* JADX INFO: renamed from: H */
    public final Point f20070H;

    /* JADX INFO: renamed from: I */
    public final float f20071I;

    /* JADX INFO: renamed from: J */
    public int f20072J;

    /* JADX INFO: renamed from: K */
    public long f20073K;

    /* JADX INFO: renamed from: L */
    public int f20074L;

    /* JADX INFO: renamed from: M */
    public Rect f20075M;

    /* JADX INFO: renamed from: N */
    public ValueAnimator f20076N;

    /* JADX INFO: renamed from: O */
    public float f20077O;

    /* JADX INFO: renamed from: P */
    public boolean f20078P;

    /* JADX INFO: renamed from: Q */
    public long f20079Q;

    /* JADX INFO: renamed from: R */
    public long f20080R;

    /* JADX INFO: renamed from: S */
    public long f20081S;

    /* JADX INFO: renamed from: T */
    public long f20082T;

    /* JADX INFO: renamed from: U */
    public int f20083U;

    /* JADX INFO: renamed from: V */
    @Nullable
    public long[] f20084V;

    /* JADX INFO: renamed from: W */
    @Nullable
    public boolean[] f20085W;

    /* JADX INFO: renamed from: j */
    public final Rect f20086j;

    /* JADX INFO: renamed from: k */
    public final Rect f20087k;

    /* JADX INFO: renamed from: l */
    public final Rect f20088l;

    /* JADX INFO: renamed from: m */
    public final Rect f20089m;

    /* JADX INFO: renamed from: n */
    public final Paint f20090n;

    /* JADX INFO: renamed from: o */
    public final Paint f20091o;

    /* JADX INFO: renamed from: p */
    public final Paint f20092p;

    /* JADX INFO: renamed from: q */
    public final Paint f20093q;

    /* JADX INFO: renamed from: r */
    public final Paint f20094r;

    /* JADX INFO: renamed from: s */
    public final Paint f20095s;

    /* JADX INFO: renamed from: t */
    @Nullable
    public final Drawable f20096t;

    /* JADX INFO: renamed from: u */
    public final int f20097u;

    /* JADX INFO: renamed from: v */
    public final int f20098v;

    /* JADX INFO: renamed from: w */
    public final int f20099w;

    /* JADX INFO: renamed from: x */
    public final int f20100x;

    /* JADX INFO: renamed from: y */
    public final int f20101y;

    /* JADX INFO: renamed from: z */
    public final int f20102z;

    public DefaultTimeBar(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, attributeSet);
    }

    /* JADX INFO: renamed from: c */
    public static int m8885c(float f, int i) {
        return (int) ((i * f) + 0.5f);
    }

    private long getPositionIncrement() {
        long j = this.f20073K;
        if (j != -9223372036854775807L) {
            return j;
        }
        long j2 = this.f20080R;
        if (j2 == -9223372036854775807L) {
            return 0L;
        }
        return j2 / ((long) this.f20072J);
    }

    private String getProgressText() {
        return C2738e0.m3013u(this.f20066D, this.f20067E, this.f20081S);
    }

    private long getScrubberPosition() {
        if (this.f20087k.width() <= 0 || this.f20080R == -9223372036854775807L) {
            return 0L;
        }
        return (((long) this.f20089m.width()) * this.f20080R) / ((long) this.f20087k.width());
    }

    @Override // p007b.p225i.p226a.p242c.p256d3.InterfaceC2671o
    /* JADX INFO: renamed from: a */
    public void mo2761a(@Nullable long[] jArr, @Nullable boolean[] zArr, int i) {
        C1460d.m531j(i == 0 || !(jArr == null || zArr == null));
        this.f20083U = i;
        this.f20084V = jArr;
        this.f20085W = zArr;
        m8890h();
    }

    @Override // p007b.p225i.p226a.p242c.p256d3.InterfaceC2671o
    /* JADX INFO: renamed from: b */
    public void mo2762b(InterfaceC2671o.a aVar) {
        this.f20069G.add(aVar);
    }

    /* JADX INFO: renamed from: d */
    public final void m8886d(float f) {
        Rect rect = this.f20089m;
        Rect rect2 = this.f20087k;
        rect.right = C2738e0.m3000h((int) f, rect2.left, rect2.right);
    }

    @Override // android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        m8891i();
    }

    /* JADX INFO: renamed from: e */
    public final boolean m8887e(long j) {
        long j2 = this.f20080R;
        if (j2 <= 0) {
            return false;
        }
        long j3 = this.f20078P ? this.f20079Q : this.f20081S;
        long jM3001i = C2738e0.m3001i(j3 + j, 0L, j2);
        if (jM3001i == j3) {
            return false;
        }
        if (this.f20078P) {
            m8892j(jM3001i);
        } else {
            m8888f(jM3001i);
        }
        m8890h();
        return true;
    }

    /* JADX INFO: renamed from: f */
    public final void m8888f(long j) {
        this.f20079Q = j;
        this.f20078P = true;
        setPressed(true);
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
        Iterator<InterfaceC2671o.a> it = this.f20069G.iterator();
        while (it.hasNext()) {
            it.next().mo2765m(this, j);
        }
    }

    /* JADX INFO: renamed from: g */
    public final void m8889g(boolean z2) {
        removeCallbacks(this.f20068F);
        this.f20078P = false;
        setPressed(false);
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(false);
        }
        invalidate();
        Iterator<InterfaceC2671o.a> it = this.f20069G.iterator();
        while (it.hasNext()) {
            it.next().mo2764l(this, this.f20079Q, z2);
        }
    }

    @Override // p007b.p225i.p226a.p242c.p256d3.InterfaceC2671o
    public long getPreferredUpdateDelay() {
        int iWidth = (int) (this.f20087k.width() / this.f20071I);
        if (iWidth != 0) {
            long j = this.f20080R;
            if (j != 0 && j != -9223372036854775807L) {
                return j / ((long) iWidth);
            }
        }
        return RecyclerView.FOREVER_NS;
    }

    /* JADX INFO: renamed from: h */
    public final void m8890h() {
        this.f20088l.set(this.f20087k);
        this.f20089m.set(this.f20087k);
        long j = this.f20078P ? this.f20079Q : this.f20081S;
        if (this.f20080R > 0) {
            int iWidth = (int) ((((long) this.f20087k.width()) * this.f20082T) / this.f20080R);
            Rect rect = this.f20088l;
            Rect rect2 = this.f20087k;
            rect.right = Math.min(rect2.left + iWidth, rect2.right);
            int iWidth2 = (int) ((((long) this.f20087k.width()) * j) / this.f20080R);
            Rect rect3 = this.f20089m;
            Rect rect4 = this.f20087k;
            rect3.right = Math.min(rect4.left + iWidth2, rect4.right);
        } else {
            Rect rect5 = this.f20088l;
            int i = this.f20087k.left;
            rect5.right = i;
            this.f20089m.right = i;
        }
        invalidate(this.f20086j);
    }

    /* JADX INFO: renamed from: i */
    public final void m8891i() {
        Drawable drawable = this.f20096t;
        if (drawable != null && drawable.isStateful() && this.f20096t.setState(getDrawableState())) {
            invalidate();
        }
    }

    /* JADX INFO: renamed from: j */
    public final void m8892j(long j) {
        if (this.f20079Q == j) {
            return;
        }
        this.f20079Q = j;
        Iterator<InterfaceC2671o.a> it = this.f20069G.iterator();
        while (it.hasNext()) {
            it.next().mo2763k(this, j);
        }
    }

    @Override // android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f20096t;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        canvas.save();
        int iHeight = this.f20087k.height();
        int iCenterY = this.f20087k.centerY() - (iHeight / 2);
        int i = iHeight + iCenterY;
        if (this.f20080R <= 0) {
            Rect rect = this.f20087k;
            canvas.drawRect(rect.left, iCenterY, rect.right, i, this.f20092p);
        } else {
            Rect rect2 = this.f20088l;
            int i2 = rect2.left;
            int i3 = rect2.right;
            int iMax = Math.max(Math.max(this.f20087k.left, i3), this.f20089m.right);
            int i4 = this.f20087k.right;
            if (iMax < i4) {
                canvas.drawRect(iMax, iCenterY, i4, i, this.f20092p);
            }
            int iMax2 = Math.max(i2, this.f20089m.right);
            if (i3 > iMax2) {
                canvas.drawRect(iMax2, iCenterY, i3, i, this.f20091o);
            }
            if (this.f20089m.width() > 0) {
                Rect rect3 = this.f20089m;
                canvas.drawRect(rect3.left, iCenterY, rect3.right, i, this.f20090n);
            }
            if (this.f20083U != 0) {
                long[] jArr = this.f20084V;
                Objects.requireNonNull(jArr);
                boolean[] zArr = this.f20085W;
                Objects.requireNonNull(zArr);
                int i5 = this.f20100x / 2;
                for (int i6 = 0; i6 < this.f20083U; i6++) {
                    int iWidth = ((int) ((((long) this.f20087k.width()) * C2738e0.m3001i(jArr[i6], 0L, this.f20080R)) / this.f20080R)) - i5;
                    Rect rect4 = this.f20087k;
                    int iMin = Math.min(rect4.width() - this.f20100x, Math.max(0, iWidth)) + rect4.left;
                    canvas.drawRect(iMin, iCenterY, iMin + this.f20100x, i, zArr[i6] ? this.f20094r : this.f20093q);
                }
            }
        }
        if (this.f20080R > 0) {
            Rect rect5 = this.f20089m;
            int iM3000h = C2738e0.m3000h(rect5.right, rect5.left, this.f20087k.right);
            int iCenterY2 = this.f20089m.centerY();
            Drawable drawable = this.f20096t;
            if (drawable == null) {
                canvas.drawCircle(iM3000h, iCenterY2, (int) ((((this.f20078P || isFocused()) ? this.f20063A : isEnabled() ? this.f20101y : this.f20102z) * this.f20077O) / 2.0f), this.f20095s);
            } else {
                int intrinsicWidth = ((int) (drawable.getIntrinsicWidth() * this.f20077O)) / 2;
                int intrinsicHeight = ((int) (this.f20096t.getIntrinsicHeight() * this.f20077O)) / 2;
                this.f20096t.setBounds(iM3000h - intrinsicWidth, iCenterY2 - intrinsicHeight, iM3000h + intrinsicWidth, iCenterY2 + intrinsicHeight);
                this.f20096t.draw(canvas);
            }
        }
        canvas.restore();
    }

    @Override // android.view.View
    public void onFocusChanged(boolean z2, int i, @Nullable Rect rect) {
        super.onFocusChanged(z2, i, rect);
        if (!this.f20078P || z2) {
            return;
        }
        m8889g(false);
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
        if (this.f20080R <= 0) {
            return;
        }
        if (C2738e0.f6708a >= 21) {
            accessibilityNodeInfo.addAction(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_FORWARD);
            accessibilityNodeInfo.addAction(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_BACKWARD);
        } else {
            accessibilityNodeInfo.addAction(4096);
            accessibilityNodeInfo.addAction(8192);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:11:0x001a  */
    /* JADX WARN: Code duplicated, block: B:13:0x0027  */
    /* JADX WARN: Code duplicated, block: B:15:0x002b  */
    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (isEnabled()) {
            long positionIncrement = getPositionIncrement();
            if (i != 66) {
                switch (i) {
                    case 21:
                        positionIncrement = -positionIncrement;
                        if (m8887e(positionIncrement)) {
                            removeCallbacks(this.f20068F);
                            postDelayed(this.f20068F, 1000L);
                            return true;
                        }
                        break;
                    case 22:
                        if (m8887e(positionIncrement)) {
                            removeCallbacks(this.f20068F);
                            postDelayed(this.f20068F, 1000L);
                            return true;
                        }
                        break;
                    case 23:
                        if (this.f20078P) {
                            m8889g(false);
                            return true;
                        }
                        break;
                }
            } else if (this.f20078P) {
                m8889g(false);
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
        int i7 = this.f20064B;
        if (this.f20099w == 1) {
            paddingBottom = (i6 - getPaddingBottom()) - this.f20098v;
            int paddingBottom2 = i6 - getPaddingBottom();
            int i8 = this.f20097u;
            iMax = (paddingBottom2 - i8) - Math.max(i7 - (i8 / 2), 0);
        } else {
            paddingBottom = (i6 - this.f20098v) / 2;
            iMax = (i6 - this.f20097u) / 2;
        }
        this.f20086j.set(paddingLeft, paddingBottom, paddingRight, this.f20098v + paddingBottom);
        Rect rect2 = this.f20087k;
        Rect rect3 = this.f20086j;
        rect2.set(rect3.left + i7, iMax, rect3.right - i7, this.f20097u + iMax);
        if (C2738e0.f6708a >= 29 && ((rect = this.f20075M) == null || rect.width() != i5 || this.f20075M.height() != i6)) {
            Rect rect4 = new Rect(0, 0, i5, i6);
            this.f20075M = rect4;
            setSystemGestureExclusionRects(Collections.singletonList(rect4));
        }
        m8890h();
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        if (mode == 0) {
            size = this.f20098v;
        } else if (mode != 1073741824) {
            size = Math.min(this.f20098v, size);
        }
        setMeasuredDimension(View.MeasureSpec.getSize(i), size);
        m8891i();
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i) {
        Drawable drawable = this.f20096t;
        if (drawable != null) {
            if (C2738e0.f6708a >= 23 && drawable.setLayoutDirection(i)) {
                invalidate();
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:23:0x005c  */
    /* JADX WARN: Code duplicated, block: B:25:0x0060  */
    /* JADX WARN: Code duplicated, block: B:27:0x0066  */
    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (isEnabled() && this.f20080R > 0) {
            this.f20070H.set((int) motionEvent.getX(), (int) motionEvent.getY());
            Point point = this.f20070H;
            int i = point.x;
            int i2 = point.y;
            int action = motionEvent.getAction();
            if (action == 0) {
                float f = i;
                if (this.f20086j.contains((int) f, i2)) {
                    m8886d(f);
                    m8888f(getScrubberPosition());
                    m8890h();
                    invalidate();
                    return true;
                }
            } else if (action == 1) {
                if (this.f20078P) {
                    m8889g(motionEvent.getAction() == 3);
                    return true;
                }
            } else if (action != 2) {
                if (action == 3) {
                    if (this.f20078P) {
                        m8889g(motionEvent.getAction() == 3);
                        return true;
                    }
                }
            } else if (this.f20078P) {
                if (i2 < this.f20065C) {
                    int i3 = this.f20074L;
                    m8886d(((i - i3) / 3) + i3);
                } else {
                    this.f20074L = i;
                    m8886d(i);
                }
                m8892j(getScrubberPosition());
                m8890h();
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
        if (this.f20080R <= 0) {
            return false;
        }
        if (i == 8192) {
            if (m8887e(-getPositionIncrement())) {
                m8889g(false);
            }
        } else {
            if (i != 4096) {
                return false;
            }
            if (m8887e(getPositionIncrement())) {
                m8889g(false);
            }
        }
        sendAccessibilityEvent(4);
        return true;
    }

    public void setAdMarkerColor(@ColorInt int i) {
        this.f20093q.setColor(i);
        invalidate(this.f20086j);
    }

    public void setBufferedColor(@ColorInt int i) {
        this.f20091o.setColor(i);
        invalidate(this.f20086j);
    }

    @Override // p007b.p225i.p226a.p242c.p256d3.InterfaceC2671o
    public void setBufferedPosition(long j) {
        if (this.f20082T == j) {
            return;
        }
        this.f20082T = j;
        m8890h();
    }

    @Override // p007b.p225i.p226a.p242c.p256d3.InterfaceC2671o
    public void setDuration(long j) {
        if (this.f20080R == j) {
            return;
        }
        this.f20080R = j;
        if (this.f20078P && j == -9223372036854775807L) {
            m8889g(true);
        }
        m8890h();
    }

    @Override // android.view.View, p007b.p225i.p226a.p242c.p256d3.InterfaceC2671o
    public void setEnabled(boolean z2) {
        super.setEnabled(z2);
        if (!this.f20078P || z2) {
            return;
        }
        m8889g(true);
    }

    public void setKeyCountIncrement(int i) {
        C1460d.m531j(i > 0);
        this.f20072J = i;
        this.f20073K = -9223372036854775807L;
    }

    public void setKeyTimeIncrement(long j) {
        C1460d.m531j(j > 0);
        this.f20072J = -1;
        this.f20073K = j;
    }

    public void setPlayedAdMarkerColor(@ColorInt int i) {
        this.f20094r.setColor(i);
        invalidate(this.f20086j);
    }

    public void setPlayedColor(@ColorInt int i) {
        this.f20090n.setColor(i);
        invalidate(this.f20086j);
    }

    @Override // p007b.p225i.p226a.p242c.p256d3.InterfaceC2671o
    public void setPosition(long j) {
        if (this.f20081S == j) {
            return;
        }
        this.f20081S = j;
        setContentDescription(getProgressText());
        m8890h();
    }

    public void setScrubberColor(@ColorInt int i) {
        this.f20095s.setColor(i);
        invalidate(this.f20086j);
    }

    public void setUnplayedColor(@ColorInt int i) {
        this.f20092p.setColor(i);
        invalidate(this.f20086j);
    }

    public DefaultTimeBar(Context context, @Nullable AttributeSet attributeSet, int i, @Nullable AttributeSet attributeSet2) {
        super(context, attributeSet, i);
        this.f20086j = new Rect();
        this.f20087k = new Rect();
        this.f20088l = new Rect();
        this.f20089m = new Rect();
        Paint paint = new Paint();
        this.f20090n = paint;
        Paint paint2 = new Paint();
        this.f20091o = paint2;
        Paint paint3 = new Paint();
        this.f20092p = paint3;
        Paint paint4 = new Paint();
        this.f20093q = paint4;
        Paint paint5 = new Paint();
        this.f20094r = paint5;
        Paint paint6 = new Paint();
        this.f20095s = paint6;
        paint6.setAntiAlias(true);
        this.f20069G = new CopyOnWriteArraySet<>();
        this.f20070H = new Point();
        float f = context.getResources().getDisplayMetrics().density;
        this.f20071I = f;
        this.f20065C = m8885c(f, -50);
        int iM8885c = m8885c(f, 4);
        int iM8885c2 = m8885c(f, 26);
        int iM8885c3 = m8885c(f, 4);
        int iM8885c4 = m8885c(f, 12);
        int iM8885c5 = m8885c(f, 0);
        int iM8885c6 = m8885c(f, 16);
        if (attributeSet2 != null) {
            TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet2, C10759R.g.DefaultTimeBar, i, 0);
            try {
                Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(C10759R.g.DefaultTimeBar_scrubber_drawable);
                this.f20096t = drawable;
                if (drawable != null) {
                    int i2 = C2738e0.f6708a;
                    if (i2 >= 23) {
                        int layoutDirection = getLayoutDirection();
                        if (i2 >= 23) {
                            drawable.setLayoutDirection(layoutDirection);
                        }
                    }
                    iM8885c2 = Math.max(drawable.getMinimumHeight(), iM8885c2);
                }
                this.f20097u = typedArrayObtainStyledAttributes.getDimensionPixelSize(C10759R.g.DefaultTimeBar_bar_height, iM8885c);
                this.f20098v = typedArrayObtainStyledAttributes.getDimensionPixelSize(C10759R.g.DefaultTimeBar_touch_target_height, iM8885c2);
                this.f20099w = typedArrayObtainStyledAttributes.getInt(C10759R.g.DefaultTimeBar_bar_gravity, 0);
                this.f20100x = typedArrayObtainStyledAttributes.getDimensionPixelSize(C10759R.g.DefaultTimeBar_ad_marker_width, iM8885c3);
                this.f20101y = typedArrayObtainStyledAttributes.getDimensionPixelSize(C10759R.g.DefaultTimeBar_scrubber_enabled_size, iM8885c4);
                this.f20102z = typedArrayObtainStyledAttributes.getDimensionPixelSize(C10759R.g.DefaultTimeBar_scrubber_disabled_size, iM8885c5);
                this.f20063A = typedArrayObtainStyledAttributes.getDimensionPixelSize(C10759R.g.DefaultTimeBar_scrubber_dragged_size, iM8885c6);
                int i3 = typedArrayObtainStyledAttributes.getInt(C10759R.g.DefaultTimeBar_played_color, -1);
                int i4 = typedArrayObtainStyledAttributes.getInt(C10759R.g.DefaultTimeBar_scrubber_color, -1);
                int i5 = typedArrayObtainStyledAttributes.getInt(C10759R.g.DefaultTimeBar_buffered_color, -855638017);
                int i6 = typedArrayObtainStyledAttributes.getInt(C10759R.g.DefaultTimeBar_unplayed_color, 872415231);
                int i7 = typedArrayObtainStyledAttributes.getInt(C10759R.g.DefaultTimeBar_ad_marker_color, -1291845888);
                int i8 = typedArrayObtainStyledAttributes.getInt(C10759R.g.DefaultTimeBar_played_ad_marker_color, 872414976);
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
            this.f20097u = iM8885c;
            this.f20098v = iM8885c2;
            this.f20099w = 0;
            this.f20100x = iM8885c3;
            this.f20101y = iM8885c4;
            this.f20102z = iM8885c5;
            this.f20063A = iM8885c6;
            paint.setColor(-1);
            paint6.setColor(-1);
            paint2.setColor(-855638017);
            paint3.setColor(872415231);
            paint4.setColor(-1291845888);
            paint5.setColor(872414976);
            this.f20096t = null;
        }
        StringBuilder sb = new StringBuilder();
        this.f20066D = sb;
        this.f20067E = new Formatter(sb, Locale.getDefault());
        this.f20068F = new Runnable() { // from class: b.i.a.c.d3.b
            @Override // java.lang.Runnable
            public final void run() {
                this.f6336j.m8889g(false);
            }
        };
        Drawable drawable2 = this.f20096t;
        if (drawable2 != null) {
            this.f20064B = (drawable2.getMinimumWidth() + 1) / 2;
        } else {
            this.f20064B = (Math.max(this.f20102z, Math.max(this.f20101y, this.f20063A)) + 1) / 2;
        }
        this.f20077O = 1.0f;
        ValueAnimator valueAnimator = new ValueAnimator();
        this.f20076N = valueAnimator;
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: b.i.a.c.d3.c
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                DefaultTimeBar defaultTimeBar = this.f6337a;
                Objects.requireNonNull(defaultTimeBar);
                defaultTimeBar.f20077O = ((Float) valueAnimator2.getAnimatedValue()).floatValue();
                defaultTimeBar.invalidate(defaultTimeBar.f20086j);
            }
        });
        this.f20080R = -9223372036854775807L;
        this.f20073K = -9223372036854775807L;
        this.f20072J = 20;
        setFocusable(true);
        if (getImportantForAccessibility() == 0) {
            setImportantForAccessibility(1);
        }
    }
}
