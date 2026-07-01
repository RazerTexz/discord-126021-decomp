package androidx.slidingpanelayout.widget;

import android.view.View;
import android.view.ViewGroup$MarginLayoutParams;
import androidx.customview.widget.ViewDragHelper$Callback;

/* JADX INFO: loaded from: classes.dex */
public class SlidingPaneLayout$DragHelperCallback extends ViewDragHelper$Callback {
    public final /* synthetic */ SlidingPaneLayout this$0;

    public SlidingPaneLayout$DragHelperCallback(SlidingPaneLayout slidingPaneLayout) {
        this.this$0 = slidingPaneLayout;
    }

    @Override // androidx.customview.widget.ViewDragHelper$Callback
    public int clampViewPositionHorizontal(View view, int i, int i2) {
        SlidingPaneLayout$LayoutParams slidingPaneLayout$LayoutParams = (SlidingPaneLayout$LayoutParams) this.this$0.mSlideableView.getLayoutParams();
        if (!this.this$0.isLayoutRtlSupport()) {
            int paddingLeft = this.this$0.getPaddingLeft() + ((ViewGroup$MarginLayoutParams) slidingPaneLayout$LayoutParams).leftMargin;
            return Math.min(Math.max(i, paddingLeft), this.this$0.mSlideRange + paddingLeft);
        }
        int width = this.this$0.getWidth() - (this.this$0.mSlideableView.getWidth() + (this.this$0.getPaddingRight() + ((ViewGroup$MarginLayoutParams) slidingPaneLayout$LayoutParams).rightMargin));
        return Math.max(Math.min(i, width), width - this.this$0.mSlideRange);
    }

    @Override // androidx.customview.widget.ViewDragHelper$Callback
    public int clampViewPositionVertical(View view, int i, int i2) {
        return view.getTop();
    }

    @Override // androidx.customview.widget.ViewDragHelper$Callback
    public int getViewHorizontalDragRange(View view) {
        return this.this$0.mSlideRange;
    }

    @Override // androidx.customview.widget.ViewDragHelper$Callback
    public void onEdgeDragStarted(int i, int i2) {
        SlidingPaneLayout slidingPaneLayout = this.this$0;
        slidingPaneLayout.mDragHelper.captureChildView(slidingPaneLayout.mSlideableView, i2);
    }

    @Override // androidx.customview.widget.ViewDragHelper$Callback
    public void onViewCaptured(View view, int i) {
        this.this$0.setAllChildrenVisible();
    }

    @Override // androidx.customview.widget.ViewDragHelper$Callback
    public void onViewDragStateChanged(int i) {
        if (this.this$0.mDragHelper.getViewDragState() == 0) {
            SlidingPaneLayout slidingPaneLayout = this.this$0;
            if (slidingPaneLayout.mSlideOffset != 0.0f) {
                slidingPaneLayout.dispatchOnPanelOpened(slidingPaneLayout.mSlideableView);
                this.this$0.mPreservedOpenState = true;
            } else {
                slidingPaneLayout.updateObscuredViewsVisibility(slidingPaneLayout.mSlideableView);
                SlidingPaneLayout slidingPaneLayout2 = this.this$0;
                slidingPaneLayout2.dispatchOnPanelClosed(slidingPaneLayout2.mSlideableView);
                this.this$0.mPreservedOpenState = false;
            }
        }
    }

    @Override // androidx.customview.widget.ViewDragHelper$Callback
    public void onViewPositionChanged(View view, int i, int i2, int i3, int i4) {
        this.this$0.onPanelDragged(i);
        this.this$0.invalidate();
    }

    @Override // androidx.customview.widget.ViewDragHelper$Callback
    public void onViewReleased(View view, float f, float f2) {
        int paddingLeft;
        SlidingPaneLayout$LayoutParams slidingPaneLayout$LayoutParams = (SlidingPaneLayout$LayoutParams) view.getLayoutParams();
        if (this.this$0.isLayoutRtlSupport()) {
            int paddingRight = this.this$0.getPaddingRight() + ((ViewGroup$MarginLayoutParams) slidingPaneLayout$LayoutParams).rightMargin;
            if (f < 0.0f || (f == 0.0f && this.this$0.mSlideOffset > 0.5f)) {
                paddingRight += this.this$0.mSlideRange;
            }
            paddingLeft = (this.this$0.getWidth() - paddingRight) - this.this$0.mSlideableView.getWidth();
        } else {
            paddingLeft = ((ViewGroup$MarginLayoutParams) slidingPaneLayout$LayoutParams).leftMargin + this.this$0.getPaddingLeft();
            if (f > 0.0f || (f == 0.0f && this.this$0.mSlideOffset > 0.5f)) {
                paddingLeft += this.this$0.mSlideRange;
            }
        }
        this.this$0.mDragHelper.settleCapturedViewAt(paddingLeft, view.getTop());
        this.this$0.invalidate();
    }

    @Override // androidx.customview.widget.ViewDragHelper$Callback
    public boolean tryCaptureView(View view, int i) {
        if (this.this$0.mIsUnableToDrag) {
            return false;
        }
        return ((SlidingPaneLayout$LayoutParams) view.getLayoutParams()).slideable;
    }
}
