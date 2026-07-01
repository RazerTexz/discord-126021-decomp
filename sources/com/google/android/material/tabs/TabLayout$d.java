package com.google.android.material.tabs;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff$Mode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build$VERSION;
import android.view.View;
import android.view.View$MeasureSpec;
import android.widget.LinearLayout;
import android.widget.LinearLayout$LayoutParams;
import androidx.annotation.NonNull;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import b.i.a.g.i.b;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.internal.ViewUtils;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public class TabLayout$d extends LinearLayout {
    public ValueAnimator j;
    public int k;
    public float l;
    public int m;
    public final /* synthetic */ TabLayout n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TabLayout$d(TabLayout tabLayout, Context context) {
        super(context);
        this.n = tabLayout;
        this.k = -1;
        this.m = -1;
        setWillNotDraw(false);
    }

    public final void a() {
        View childAt = getChildAt(this.k);
        b bVarAccess$1200 = TabLayout.access$1200(this.n);
        TabLayout tabLayout = this.n;
        Drawable drawable = tabLayout.tabSelectedIndicator;
        Objects.requireNonNull(bVarAccess$1200);
        RectF rectFA = b.a(tabLayout, childAt);
        drawable.setBounds((int) rectFA.left, drawable.getBounds().top, (int) rectFA.right, drawable.getBounds().bottom);
    }

    public void b(int i) {
        Rect bounds = this.n.tabSelectedIndicator.getBounds();
        this.n.tabSelectedIndicator.setBounds(bounds.left, 0, bounds.right, i);
        requestLayout();
    }

    public final void c(View view, View view2, float f) {
        if (view != null && view.getWidth() > 0) {
            b bVarAccess$1200 = TabLayout.access$1200(this.n);
            TabLayout tabLayout = this.n;
            bVarAccess$1200.b(tabLayout, view, view2, f, tabLayout.tabSelectedIndicator);
        } else {
            Drawable drawable = this.n.tabSelectedIndicator;
            drawable.setBounds(-1, drawable.getBounds().top, -1, this.n.tabSelectedIndicator.getBounds().bottom);
        }
        ViewCompat.postInvalidateOnAnimation(this);
    }

    public final void d(boolean z2, int i, int i2) {
        View childAt = getChildAt(this.k);
        View childAt2 = getChildAt(i);
        if (childAt2 == null) {
            a();
            return;
        }
        TabLayout$d$a tabLayout$d$a = new TabLayout$d$a(this, childAt, childAt2);
        if (!z2) {
            this.j.removeAllUpdateListeners();
            this.j.addUpdateListener(tabLayout$d$a);
            return;
        }
        ValueAnimator valueAnimator = new ValueAnimator();
        this.j = valueAnimator;
        valueAnimator.setInterpolator(AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
        valueAnimator.setDuration(i2);
        valueAnimator.setFloatValues(0.0f, 1.0f);
        valueAnimator.addUpdateListener(tabLayout$d$a);
        valueAnimator.addListener(new TabLayout$d$b(this, i));
        valueAnimator.start();
    }

    @Override // android.view.View
    public void draw(@NonNull Canvas canvas) {
        int iHeight = this.n.tabSelectedIndicator.getBounds().height();
        if (iHeight < 0) {
            iHeight = this.n.tabSelectedIndicator.getIntrinsicHeight();
        }
        int i = this.n.tabIndicatorGravity;
        int height = 0;
        if (i == 0) {
            height = getHeight() - iHeight;
            iHeight = getHeight();
        } else if (i == 1) {
            height = (getHeight() - iHeight) / 2;
            iHeight = (getHeight() + iHeight) / 2;
        } else if (i != 2) {
            iHeight = i != 3 ? 0 : getHeight();
        }
        if (this.n.tabSelectedIndicator.getBounds().width() > 0) {
            Rect bounds = this.n.tabSelectedIndicator.getBounds();
            this.n.tabSelectedIndicator.setBounds(bounds.left, height, bounds.right, iHeight);
            TabLayout tabLayout = this.n;
            Drawable drawableWrap = tabLayout.tabSelectedIndicator;
            if (TabLayout.access$1400(tabLayout) != 0) {
                drawableWrap = DrawableCompat.wrap(drawableWrap);
                if (Build$VERSION.SDK_INT == 21) {
                    drawableWrap.setColorFilter(TabLayout.access$1400(this.n), PorterDuff$Mode.SRC_IN);
                } else {
                    DrawableCompat.setTint(drawableWrap, TabLayout.access$1400(this.n));
                }
            }
            drawableWrap.draw(canvas);
        }
        super.draw(canvas);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z2, int i, int i2, int i3, int i4) {
        super.onLayout(z2, i, i2, i3, i4);
        ValueAnimator valueAnimator = this.j;
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            a();
        } else {
            d(false, this.k, -1);
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (View$MeasureSpec.getMode(i) != 1073741824) {
            return;
        }
        TabLayout tabLayout = this.n;
        boolean z2 = true;
        if (tabLayout.tabGravity == 1 || tabLayout.mode == 2) {
            int childCount = getChildCount();
            int iMax = 0;
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = getChildAt(i3);
                if (childAt.getVisibility() == 0) {
                    iMax = Math.max(iMax, childAt.getMeasuredWidth());
                }
            }
            if (iMax <= 0) {
                return;
            }
            if (iMax * childCount <= getMeasuredWidth() - (((int) ViewUtils.dpToPx(getContext(), 16)) * 2)) {
                boolean z3 = false;
                for (int i4 = 0; i4 < childCount; i4++) {
                    LinearLayout$LayoutParams linearLayout$LayoutParams = (LinearLayout$LayoutParams) getChildAt(i4).getLayoutParams();
                    if (linearLayout$LayoutParams.width != iMax || linearLayout$LayoutParams.weight != 0.0f) {
                        linearLayout$LayoutParams.width = iMax;
                        linearLayout$LayoutParams.weight = 0.0f;
                        z3 = true;
                    }
                }
                z2 = z3;
            } else {
                TabLayout tabLayout2 = this.n;
                tabLayout2.tabGravity = 0;
                tabLayout2.updateTabViews(false);
            }
            if (z2) {
                super.onMeasure(i, i2);
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onRtlPropertiesChanged(int i) {
        super.onRtlPropertiesChanged(i);
        if (Build$VERSION.SDK_INT >= 23 || this.m == i) {
            return;
        }
        requestLayout();
        this.m = i;
    }
}
