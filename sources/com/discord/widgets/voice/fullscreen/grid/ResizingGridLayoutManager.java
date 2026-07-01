package com.discord.widgets.voice.fullscreen.grid;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup$LayoutParams;
import android.view.ViewGroup$MarginLayoutParams;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView$LayoutParams;
import d0.d0.f;
import d0.z.d.m;

/* JADX INFO: compiled from: ResizingGridLayoutManager.kt */
/* JADX INFO: loaded from: classes.dex */
public class ResizingGridLayoutManager extends GridLayoutManager {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ResizingGridLayoutManager(Context context, int i, int i2) {
        super(context, i, i2, false);
        m.checkNotNullParameter(context, "context");
    }

    private final int getHorizontalSpace() {
        return (getWidth() - getPaddingRight()) - getPaddingLeft();
    }

    private final int getVerticalSpace() {
        return (getHeight() - getPaddingBottom()) - getPaddingTop();
    }

    private final int maxColumns() {
        return 4;
    }

    private final int maxRows() {
        return 4;
    }

    private final RecyclerView$LayoutParams spanLayoutSize(RecyclerView$LayoutParams layoutParams) {
        int orientation = getOrientation();
        if (orientation == 0) {
            spanLayoutSizeHorizontalOrientation(layoutParams);
        } else if (orientation == 1) {
            spanLayoutSizeVerticalOrientation(layoutParams);
        }
        return layoutParams;
    }

    private final RecyclerView$LayoutParams spanLayoutSizeHorizontalOrientation(RecyclerView$LayoutParams layoutParams) {
        int itemCount = 2;
        if (getItemCount() != 2) {
            itemCount = (getItemCount() % 2) + (getItemCount() / 2);
        }
        ((ViewGroup$MarginLayoutParams) layoutParams).width = f.coerceAtLeast(getHorizontalSpace() / itemCount, getHorizontalSpace() / maxColumns());
        return layoutParams;
    }

    private final RecyclerView$LayoutParams spanLayoutSizeVerticalOrientation(RecyclerView$LayoutParams layoutParams) {
        int itemCount = 2;
        if (getItemCount() != 2) {
            itemCount = (getItemCount() % 2) + (getItemCount() / 2);
        }
        ((ViewGroup$MarginLayoutParams) layoutParams).height = f.coerceAtLeast(getVerticalSpace() / itemCount, getVerticalSpace() / maxRows());
        return layoutParams;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView$LayoutManager
    public boolean canScrollHorizontally() {
        return getOrientation() == 0;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView$LayoutManager
    public boolean canScrollVertically() {
        return getOrientation() == 1;
    }

    @Override // androidx.recyclerview.widget.GridLayoutManager, androidx.recyclerview.widget.RecyclerView$LayoutManager
    public boolean checkLayoutParams(RecyclerView$LayoutParams lp) {
        m.checkNotNullParameter(lp, "lp");
        RecyclerView$LayoutParams recyclerView$LayoutParamsGenerateDefaultLayoutParams = generateDefaultLayoutParams();
        return super.checkLayoutParams(lp) && ((ViewGroup$MarginLayoutParams) recyclerView$LayoutParamsGenerateDefaultLayoutParams).width == ((ViewGroup$MarginLayoutParams) lp).width && ((ViewGroup$MarginLayoutParams) recyclerView$LayoutParamsGenerateDefaultLayoutParams).height == ((ViewGroup$MarginLayoutParams) lp).height;
    }

    @Override // androidx.recyclerview.widget.GridLayoutManager, androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView$LayoutManager
    public RecyclerView$LayoutParams generateDefaultLayoutParams() {
        RecyclerView$LayoutParams recyclerView$LayoutParamsGenerateDefaultLayoutParams = super.generateDefaultLayoutParams();
        m.checkNotNullExpressionValue(recyclerView$LayoutParamsGenerateDefaultLayoutParams, "super.generateDefaultLayoutParams()");
        return spanLayoutSize(recyclerView$LayoutParamsGenerateDefaultLayoutParams);
    }

    @Override // androidx.recyclerview.widget.GridLayoutManager, androidx.recyclerview.widget.RecyclerView$LayoutManager
    public RecyclerView$LayoutParams generateLayoutParams(Context c, AttributeSet attrs) {
        m.checkNotNullParameter(c, "c");
        m.checkNotNullParameter(attrs, "attrs");
        RecyclerView$LayoutParams recyclerView$LayoutParamsGenerateLayoutParams = super.generateLayoutParams(c, attrs);
        m.checkNotNullExpressionValue(recyclerView$LayoutParamsGenerateLayoutParams, "super.generateLayoutParams(c, attrs)");
        return spanLayoutSize(recyclerView$LayoutParamsGenerateLayoutParams);
    }

    @Override // androidx.recyclerview.widget.GridLayoutManager, androidx.recyclerview.widget.RecyclerView$LayoutManager
    public RecyclerView$LayoutParams generateLayoutParams(ViewGroup$LayoutParams lp) {
        m.checkNotNullParameter(lp, "lp");
        RecyclerView$LayoutParams recyclerView$LayoutParamsGenerateLayoutParams = super.generateLayoutParams(lp);
        m.checkNotNullExpressionValue(recyclerView$LayoutParamsGenerateLayoutParams, "super.generateLayoutParams(lp)");
        return spanLayoutSize(recyclerView$LayoutParamsGenerateLayoutParams);
    }
}
