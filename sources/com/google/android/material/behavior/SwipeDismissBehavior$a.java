package com.google.android.material.behavior;

import android.view.View;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import androidx.customview.widget.ViewDragHelper$Callback;

/* JADX INFO: loaded from: classes3.dex */
public class SwipeDismissBehavior$a extends ViewDragHelper$Callback {
    public int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f3028b = -1;
    public final /* synthetic */ SwipeDismissBehavior c;

    public SwipeDismissBehavior$a(SwipeDismissBehavior swipeDismissBehavior) {
        this.c = swipeDismissBehavior;
    }

    @Override // androidx.customview.widget.ViewDragHelper$Callback
    public int clampViewPositionHorizontal(@NonNull View view, int i, int i2) {
        int width;
        int width2;
        int width3;
        boolean z2 = ViewCompat.getLayoutDirection(view) == 1;
        int i3 = this.c.swipeDirection;
        if (i3 == 0) {
            if (z2) {
                width = this.a - view.getWidth();
                width2 = this.a;
            } else {
                width = this.a;
                width3 = view.getWidth();
                width2 = width3 + width;
            }
        } else if (i3 != 1) {
            width = this.a - view.getWidth();
            width2 = view.getWidth() + this.a;
        } else if (z2) {
            width = this.a;
            width3 = view.getWidth();
            width2 = width3 + width;
        } else {
            width = this.a - view.getWidth();
            width2 = this.a;
        }
        return SwipeDismissBehavior.clamp(width, i, width2);
    }

    @Override // androidx.customview.widget.ViewDragHelper$Callback
    public int clampViewPositionVertical(@NonNull View view, int i, int i2) {
        return view.getTop();
    }

    @Override // androidx.customview.widget.ViewDragHelper$Callback
    public int getViewHorizontalDragRange(@NonNull View view) {
        return view.getWidth();
    }

    @Override // androidx.customview.widget.ViewDragHelper$Callback
    public void onViewCaptured(@NonNull View view, int i) {
        this.f3028b = i;
        this.a = view.getLeft();
        ViewParent parent = view.getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
    }

    @Override // androidx.customview.widget.ViewDragHelper$Callback
    public void onViewDragStateChanged(int i) {
        SwipeDismissBehavior$OnDismissListener swipeDismissBehavior$OnDismissListener = this.c.listener;
        if (swipeDismissBehavior$OnDismissListener != null) {
            swipeDismissBehavior$OnDismissListener.onDragStateChanged(i);
        }
    }

    @Override // androidx.customview.widget.ViewDragHelper$Callback
    public void onViewPositionChanged(@NonNull View view, int i, int i2, int i3, int i4) {
        float width = (view.getWidth() * this.c.alphaStartSwipeDistance) + this.a;
        float width2 = (view.getWidth() * this.c.alphaEndSwipeDistance) + this.a;
        float f = i;
        if (f <= width) {
            view.setAlpha(1.0f);
        } else if (f >= width2) {
            view.setAlpha(0.0f);
        } else {
            view.setAlpha(SwipeDismissBehavior.clamp(0.0f, 1.0f - SwipeDismissBehavior.fraction(width, width2, f), 1.0f));
        }
    }

    /* JADX WARN: Code duplicated, block: B:17:0x002a  */
    /* JADX WARN: Code duplicated, block: B:18:0x002c  */
    @Override // androidx.customview.widget.ViewDragHelper$Callback
    public void onViewReleased(@NonNull View view, float f, float f2) {
        boolean z2;
        int i;
        SwipeDismissBehavior$OnDismissListener swipeDismissBehavior$OnDismissListener;
        this.f3028b = -1;
        int width = view.getWidth();
        boolean z3 = false;
        if (f != 0.0f) {
            boolean z4 = ViewCompat.getLayoutDirection(view) == 1;
            int i2 = this.c.swipeDirection;
            if (i2 != 2 && (i2 != 0 ? i2 != 1 || (!z4 ? f < 0.0f : f > 0.0f) : !z4 ? f > 0.0f : f < 0.0f)) {
                z2 = false;
            } else {
                z2 = true;
            }
        } else {
            if (Math.abs(view.getLeft() - this.a) >= Math.round(view.getWidth() * this.c.dragDismissThreshold)) {
                z2 = true;
            } else {
                z2 = false;
            }
        }
        if (z2) {
            int left = view.getLeft();
            int i3 = this.a;
            i = left < i3 ? i3 - width : i3 + width;
            z3 = true;
        } else {
            i = this.a;
        }
        if (this.c.viewDragHelper.settleCapturedViewAt(i, view.getTop())) {
            ViewCompat.postOnAnimation(view, new SwipeDismissBehavior$c(this.c, view, z3));
        } else {
            if (!z3 || (swipeDismissBehavior$OnDismissListener = this.c.listener) == null) {
                return;
            }
            swipeDismissBehavior$OnDismissListener.onDismiss(view);
        }
    }

    @Override // androidx.customview.widget.ViewDragHelper$Callback
    public boolean tryCaptureView(View view, int i) {
        int i2 = this.f3028b;
        return (i2 == -1 || i2 == i) && this.c.canSwipeDismissView(view);
    }
}
