package androidx.recyclerview.widget;

import android.view.View;
import android.view.ViewGroup$MarginLayoutParams;

/* JADX INFO: loaded from: classes.dex */
public class OrientationHelper$2 extends OrientationHelper {
    public OrientationHelper$2(RecyclerView$LayoutManager recyclerView$LayoutManager) {
        super(recyclerView$LayoutManager, null);
    }

    @Override // androidx.recyclerview.widget.OrientationHelper
    public int getDecoratedEnd(View view) {
        return this.mLayoutManager.getDecoratedBottom(view) + ((ViewGroup$MarginLayoutParams) ((RecyclerView$LayoutParams) view.getLayoutParams())).bottomMargin;
    }

    @Override // androidx.recyclerview.widget.OrientationHelper
    public int getDecoratedMeasurement(View view) {
        RecyclerView$LayoutParams recyclerView$LayoutParams = (RecyclerView$LayoutParams) view.getLayoutParams();
        return this.mLayoutManager.getDecoratedMeasuredHeight(view) + ((ViewGroup$MarginLayoutParams) recyclerView$LayoutParams).topMargin + ((ViewGroup$MarginLayoutParams) recyclerView$LayoutParams).bottomMargin;
    }

    @Override // androidx.recyclerview.widget.OrientationHelper
    public int getDecoratedMeasurementInOther(View view) {
        RecyclerView$LayoutParams recyclerView$LayoutParams = (RecyclerView$LayoutParams) view.getLayoutParams();
        return this.mLayoutManager.getDecoratedMeasuredWidth(view) + ((ViewGroup$MarginLayoutParams) recyclerView$LayoutParams).leftMargin + ((ViewGroup$MarginLayoutParams) recyclerView$LayoutParams).rightMargin;
    }

    @Override // androidx.recyclerview.widget.OrientationHelper
    public int getDecoratedStart(View view) {
        return this.mLayoutManager.getDecoratedTop(view) - ((ViewGroup$MarginLayoutParams) ((RecyclerView$LayoutParams) view.getLayoutParams())).topMargin;
    }

    @Override // androidx.recyclerview.widget.OrientationHelper
    public int getEnd() {
        return this.mLayoutManager.getHeight();
    }

    @Override // androidx.recyclerview.widget.OrientationHelper
    public int getEndAfterPadding() {
        return this.mLayoutManager.getHeight() - this.mLayoutManager.getPaddingBottom();
    }

    @Override // androidx.recyclerview.widget.OrientationHelper
    public int getEndPadding() {
        return this.mLayoutManager.getPaddingBottom();
    }

    @Override // androidx.recyclerview.widget.OrientationHelper
    public int getMode() {
        return this.mLayoutManager.getHeightMode();
    }

    @Override // androidx.recyclerview.widget.OrientationHelper
    public int getModeInOther() {
        return this.mLayoutManager.getWidthMode();
    }

    @Override // androidx.recyclerview.widget.OrientationHelper
    public int getStartAfterPadding() {
        return this.mLayoutManager.getPaddingTop();
    }

    @Override // androidx.recyclerview.widget.OrientationHelper
    public int getTotalSpace() {
        return (this.mLayoutManager.getHeight() - this.mLayoutManager.getPaddingTop()) - this.mLayoutManager.getPaddingBottom();
    }

    @Override // androidx.recyclerview.widget.OrientationHelper
    public int getTransformedEndWithDecoration(View view) {
        this.mLayoutManager.getTransformedBoundingBox(view, true, this.mTmpRect);
        return this.mTmpRect.bottom;
    }

    @Override // androidx.recyclerview.widget.OrientationHelper
    public int getTransformedStartWithDecoration(View view) {
        this.mLayoutManager.getTransformedBoundingBox(view, true, this.mTmpRect);
        return this.mTmpRect.top;
    }

    @Override // androidx.recyclerview.widget.OrientationHelper
    public void offsetChild(View view, int i) {
        view.offsetTopAndBottom(i);
    }

    @Override // androidx.recyclerview.widget.OrientationHelper
    public void offsetChildren(int i) {
        this.mLayoutManager.offsetChildrenVertical(i);
    }
}
