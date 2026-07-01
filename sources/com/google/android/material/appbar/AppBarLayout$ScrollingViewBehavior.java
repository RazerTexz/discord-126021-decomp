package com.google.android.material.appbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior;
import androidx.coordinatorlayout.widget.CoordinatorLayout$LayoutParams;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat$AccessibilityActionCompat;
import b.i.a.g.a.b;
import com.google.android.material.R$styleable;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class AppBarLayout$ScrollingViewBehavior extends b {
    public AppBarLayout$ScrollingViewBehavior() {
    }

    private static int getAppBarLayoutOffset(@NonNull AppBarLayout appBarLayout) {
        CoordinatorLayout$Behavior behavior = ((CoordinatorLayout$LayoutParams) appBarLayout.getLayoutParams()).getBehavior();
        if (behavior instanceof AppBarLayout$BaseBehavior) {
            return ((AppBarLayout$BaseBehavior) behavior).getTopBottomOffsetForScrollingSibling();
        }
        return 0;
    }

    private void offsetChildAsNeeded(@NonNull View view, @NonNull View view2) {
        CoordinatorLayout$Behavior behavior = ((CoordinatorLayout$LayoutParams) view2.getLayoutParams()).getBehavior();
        if (behavior instanceof AppBarLayout$BaseBehavior) {
            ViewCompat.offsetTopAndBottom(view, (getVerticalLayoutGap() + (AppBarLayout$BaseBehavior.access$000((AppBarLayout$BaseBehavior) behavior) + (view2.getBottom() - view.getTop()))) - getOverlapPixelsForOffset(view2));
        }
    }

    private void updateLiftedStateIfNeeded(View view, View view2) {
        if (view2 instanceof AppBarLayout) {
            AppBarLayout appBarLayout = (AppBarLayout) view2;
            if (appBarLayout.isLiftOnScroll()) {
                appBarLayout.setLiftedState(appBarLayout.shouldLift(view));
            }
        }
    }

    @Override // b.i.a.g.a.b
    @Nullable
    public /* bridge */ /* synthetic */ View findFirstDependency(@NonNull List list) {
        return findFirstDependency((List<View>) list);
    }

    @Override // b.i.a.g.a.c
    public /* bridge */ /* synthetic */ int getLeftAndRightOffset() {
        return super.getLeftAndRightOffset();
    }

    @Override // b.i.a.g.a.b
    public float getOverlapRatioForOffset(View view) {
        int i;
        if (view instanceof AppBarLayout) {
            AppBarLayout appBarLayout = (AppBarLayout) view;
            int totalScrollRange = appBarLayout.getTotalScrollRange();
            int downNestedPreScrollRange = appBarLayout.getDownNestedPreScrollRange();
            int appBarLayoutOffset = getAppBarLayoutOffset(appBarLayout);
            if ((downNestedPreScrollRange == 0 || totalScrollRange + appBarLayoutOffset > downNestedPreScrollRange) && (i = totalScrollRange - downNestedPreScrollRange) != 0) {
                return (appBarLayoutOffset / i) + 1.0f;
            }
        }
        return 0.0f;
    }

    @Override // b.i.a.g.a.b
    public int getScrollRange(View view) {
        return view instanceof AppBarLayout ? ((AppBarLayout) view).getTotalScrollRange() : super.getScrollRange(view);
    }

    @Override // b.i.a.g.a.c
    public /* bridge */ /* synthetic */ int getTopAndBottomOffset() {
        return super.getTopAndBottomOffset();
    }

    @Override // b.i.a.g.a.c
    public /* bridge */ /* synthetic */ boolean isHorizontalOffsetEnabled() {
        return super.isHorizontalOffsetEnabled();
    }

    @Override // b.i.a.g.a.c
    public /* bridge */ /* synthetic */ boolean isVerticalOffsetEnabled() {
        return super.isVerticalOffsetEnabled();
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior
    public boolean layoutDependsOn(CoordinatorLayout coordinatorLayout, View view, View view2) {
        return view2 instanceof AppBarLayout;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior
    public boolean onDependentViewChanged(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, @NonNull View view2) {
        offsetChildAsNeeded(view, view2);
        updateLiftedStateIfNeeded(view, view2);
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior
    public void onDependentViewRemoved(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, @NonNull View view2) {
        if (view2 instanceof AppBarLayout) {
            ViewCompat.removeAccessibilityAction(coordinatorLayout, AccessibilityNodeInfoCompat$AccessibilityActionCompat.ACTION_SCROLL_FORWARD.getId());
            ViewCompat.removeAccessibilityAction(coordinatorLayout, AccessibilityNodeInfoCompat$AccessibilityActionCompat.ACTION_SCROLL_BACKWARD.getId());
        }
    }

    @Override // b.i.a.g.a.c, androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior
    public /* bridge */ /* synthetic */ boolean onLayoutChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, int i) {
        return super.onLayoutChild(coordinatorLayout, view, i);
    }

    @Override // b.i.a.g.a.b, androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior
    public /* bridge */ /* synthetic */ boolean onMeasureChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, int i, int i2, int i3, int i4) {
        return super.onMeasureChild(coordinatorLayout, view, i, i2, i3, i4);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior
    public boolean onRequestChildRectangleOnScreen(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, @NonNull Rect rect, boolean z2) {
        AppBarLayout appBarLayoutFindFirstDependency = findFirstDependency(coordinatorLayout.getDependencies(view));
        if (appBarLayoutFindFirstDependency != null) {
            rect.offset(view.getLeft(), view.getTop());
            Rect rect2 = this.tempRect1;
            rect2.set(0, 0, coordinatorLayout.getWidth(), coordinatorLayout.getHeight());
            if (!rect2.contains(rect)) {
                appBarLayoutFindFirstDependency.setExpanded(false, !z2);
                return true;
            }
        }
        return false;
    }

    @Override // b.i.a.g.a.c
    public /* bridge */ /* synthetic */ void setHorizontalOffsetEnabled(boolean z2) {
        super.setHorizontalOffsetEnabled(z2);
    }

    @Override // b.i.a.g.a.c
    public /* bridge */ /* synthetic */ boolean setLeftAndRightOffset(int i) {
        return super.setLeftAndRightOffset(i);
    }

    @Override // b.i.a.g.a.c
    public /* bridge */ /* synthetic */ boolean setTopAndBottomOffset(int i) {
        return super.setTopAndBottomOffset(i);
    }

    @Override // b.i.a.g.a.c
    public /* bridge */ /* synthetic */ void setVerticalOffsetEnabled(boolean z2) {
        super.setVerticalOffsetEnabled(z2);
    }

    public AppBarLayout$ScrollingViewBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ScrollingViewBehavior_Layout);
        setOverlayTop(typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.ScrollingViewBehavior_Layout_behavior_overlapTop, 0));
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // b.i.a.g.a.b
    @Nullable
    public AppBarLayout findFirstDependency(@NonNull List<View> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            View view = list.get(i);
            if (view instanceof AppBarLayout) {
                return (AppBarLayout) view;
            }
        }
        return null;
    }
}
