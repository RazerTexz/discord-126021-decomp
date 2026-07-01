package com.discord.utilities.view.scrolling;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import androidx.viewpager2.widget.ViewPager2;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: NestedScrollableHost.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class NestedScrollableHost extends FrameLayout {
    private float initialX;
    private float initialY;
    private int touchSlop;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NestedScrollableHost(Context context) {
        super(context);
        Intrinsics3.checkNotNullParameter(context, "context");
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        Intrinsics3.checkNotNullExpressionValue(viewConfiguration, "ViewConfiguration.get(context)");
        this.touchSlop = viewConfiguration.getScaledTouchSlop();
    }

    private final boolean canChildScroll(int orientation, float delta) {
        int i = -((int) Math.signum(delta));
        if (orientation == 0) {
            View child = getChild();
            if (child != null) {
                return child.canScrollHorizontally(i);
            }
            return false;
        }
        if (orientation != 1) {
            throw new IllegalArgumentException();
        }
        View child2 = getChild();
        if (child2 != null) {
            return child2.canScrollVertically(i);
        }
        return false;
    }

    private final View getChild() {
        if (getChildCount() > 0) {
            return getChildAt(0);
        }
        return null;
    }

    private final ViewPager2 getParentViewPager() {
        Object parent = getParent();
        if (!(parent instanceof View)) {
            parent = null;
        }
        View view = (View) parent;
        while (view != null && !(view instanceof ViewPager2)) {
            Object parent2 = view.getParent();
            if (!(parent2 instanceof View)) {
                parent2 = null;
            }
            view = (View) parent2;
        }
        return (ViewPager2) (view instanceof ViewPager2 ? view : null);
    }

    private final void handleInterceptTouchEvent(MotionEvent e) {
        ViewPager2 parentViewPager = getParentViewPager();
        if (parentViewPager != null) {
            int orientation = parentViewPager.getOrientation();
            if (canChildScroll(orientation, -1.0f) || canChildScroll(orientation, 1.0f)) {
                if (e.getAction() == 0) {
                    this.initialX = e.getX();
                    this.initialY = e.getY();
                    getParent().requestDisallowInterceptTouchEvent(true);
                    return;
                }
                if (e.getAction() == 2) {
                    float x2 = e.getX() - this.initialX;
                    float y2 = e.getY() - this.initialY;
                    boolean z2 = orientation == 0;
                    float fAbs = Math.abs(x2) * (z2 ? 0.5f : 1.0f);
                    float fAbs2 = Math.abs(y2) * (z2 ? 1.0f : 0.5f);
                    int i = this.touchSlop;
                    if (fAbs > i || fAbs2 > i) {
                        if (z2 == (fAbs2 > fAbs)) {
                            getParent().requestDisallowInterceptTouchEvent(false);
                            return;
                        }
                        if (!z2) {
                            x2 = y2;
                        }
                        if (canChildScroll(orientation, x2)) {
                            getParent().requestDisallowInterceptTouchEvent(true);
                        } else {
                            getParent().requestDisallowInterceptTouchEvent(false);
                        }
                    }
                }
            }
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent e) {
        Intrinsics3.checkNotNullParameter(e, "e");
        handleInterceptTouchEvent(e);
        return super.onInterceptTouchEvent(e);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NestedScrollableHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics3.checkNotNullParameter(context, "context");
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        Intrinsics3.checkNotNullExpressionValue(viewConfiguration, "ViewConfiguration.get(context)");
        this.touchSlop = viewConfiguration.getScaledTouchSlop();
    }
}
