package com.google.android.material.bottomsheet;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.math.MathUtils;
import androidx.customview.widget.ViewDragHelper$Callback;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes3.dex */
public class BottomSheetBehavior$d extends ViewDragHelper$Callback {
    public final /* synthetic */ BottomSheetBehavior a;

    public BottomSheetBehavior$d(BottomSheetBehavior bottomSheetBehavior) {
        this.a = bottomSheetBehavior;
    }

    @Override // androidx.customview.widget.ViewDragHelper$Callback
    public int clampViewPositionHorizontal(@NonNull View view, int i, int i2) {
        return view.getLeft();
    }

    @Override // androidx.customview.widget.ViewDragHelper$Callback
    public int clampViewPositionVertical(@NonNull View view, int i, int i2) {
        int expandedOffset = this.a.getExpandedOffset();
        BottomSheetBehavior bottomSheetBehavior = this.a;
        return MathUtils.clamp(i, expandedOffset, bottomSheetBehavior.hideable ? bottomSheetBehavior.parentHeight : bottomSheetBehavior.collapsedOffset);
    }

    @Override // androidx.customview.widget.ViewDragHelper$Callback
    public int getViewVerticalDragRange(@NonNull View view) {
        BottomSheetBehavior bottomSheetBehavior = this.a;
        return bottomSheetBehavior.hideable ? bottomSheetBehavior.parentHeight : bottomSheetBehavior.collapsedOffset;
    }

    @Override // androidx.customview.widget.ViewDragHelper$Callback
    public void onViewDragStateChanged(int i) {
        if (i == 1 && BottomSheetBehavior.access$400(this.a)) {
            this.a.setStateInternal(1);
        }
    }

    @Override // androidx.customview.widget.ViewDragHelper$Callback
    public void onViewPositionChanged(@NonNull View view, int i, int i2, int i3, int i4) {
        this.a.dispatchOnSlide(i2);
    }

    @Override // androidx.customview.widget.ViewDragHelper$Callback
    public void onViewReleased(@NonNull View view, float f, float f2) {
        int i;
        int i2 = 4;
        if (f2 < 0.0f) {
            if (BottomSheetBehavior.access$500(this.a)) {
                i = this.a.fitToContentsOffset;
            } else {
                int top = view.getTop();
                BottomSheetBehavior bottomSheetBehavior = this.a;
                int i3 = bottomSheetBehavior.halfExpandedOffset;
                if (top > i3) {
                    i = i3;
                    i2 = 6;
                } else {
                    i = bottomSheetBehavior.expandedOffset;
                }
            }
            i2 = 3;
        } else {
            BottomSheetBehavior bottomSheetBehavior2 = this.a;
            if (bottomSheetBehavior2.hideable && bottomSheetBehavior2.shouldHide(view, f2)) {
                if (Math.abs(f) >= Math.abs(f2) || f2 <= 500.0f) {
                    int top2 = view.getTop();
                    BottomSheetBehavior bottomSheetBehavior3 = this.a;
                    if (!(top2 > (bottomSheetBehavior3.getExpandedOffset() + bottomSheetBehavior3.parentHeight) / 2)) {
                        if (BottomSheetBehavior.access$500(this.a)) {
                            i = this.a.fitToContentsOffset;
                        } else if (Math.abs(view.getTop() - this.a.expandedOffset) < Math.abs(view.getTop() - this.a.halfExpandedOffset)) {
                            i = this.a.expandedOffset;
                        } else {
                            i = this.a.halfExpandedOffset;
                            i2 = 6;
                        }
                        i2 = 3;
                    }
                }
                i = this.a.parentHeight;
                i2 = 5;
            } else if (f2 == 0.0f || Math.abs(f) > Math.abs(f2)) {
                int top3 = view.getTop();
                if (!BottomSheetBehavior.access$500(this.a)) {
                    BottomSheetBehavior bottomSheetBehavior4 = this.a;
                    int i4 = bottomSheetBehavior4.halfExpandedOffset;
                    if (top3 < i4) {
                        if (top3 < Math.abs(top3 - bottomSheetBehavior4.collapsedOffset)) {
                            i = this.a.expandedOffset;
                            i2 = 3;
                        } else {
                            i = this.a.halfExpandedOffset;
                        }
                    } else if (Math.abs(top3 - i4) < Math.abs(top3 - this.a.collapsedOffset)) {
                        i = this.a.halfExpandedOffset;
                    } else {
                        i = this.a.collapsedOffset;
                    }
                    i2 = 6;
                } else if (Math.abs(top3 - this.a.fitToContentsOffset) < Math.abs(top3 - this.a.collapsedOffset)) {
                    i = this.a.fitToContentsOffset;
                    i2 = 3;
                } else {
                    i = this.a.collapsedOffset;
                }
            } else if (BottomSheetBehavior.access$500(this.a)) {
                i = this.a.collapsedOffset;
            } else {
                int top4 = view.getTop();
                if (Math.abs(top4 - this.a.halfExpandedOffset) < Math.abs(top4 - this.a.collapsedOffset)) {
                    i = this.a.halfExpandedOffset;
                    i2 = 6;
                } else {
                    i = this.a.collapsedOffset;
                }
            }
        }
        this.a.startSettlingAnimation(view, i2, i, true);
    }

    @Override // androidx.customview.widget.ViewDragHelper$Callback
    public boolean tryCaptureView(@NonNull View view, int i) {
        BottomSheetBehavior bottomSheetBehavior = this.a;
        int i2 = bottomSheetBehavior.state;
        if (i2 == 1 || bottomSheetBehavior.touchingScrollingChild) {
            return false;
        }
        if (i2 == 3 && bottomSheetBehavior.activePointerId == i) {
            WeakReference<View> weakReference = bottomSheetBehavior.nestedScrollingChildRef;
            View view2 = weakReference != null ? weakReference.get() : null;
            if (view2 != null && view2.canScrollVertically(-1)) {
                return false;
            }
        }
        WeakReference<V> weakReference2 = this.a.viewRef;
        return weakReference2 != 0 && weakReference2.get() == view;
    }
}
