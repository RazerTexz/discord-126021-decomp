package com.discord.widgets.voice.fullscreen.grid;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import p507d0.p512d0.C11226f;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: ResizingGridLayoutManager.kt */
/* JADX INFO: loaded from: classes.dex */
public class ResizingGridLayoutManager extends GridLayoutManager {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ResizingGridLayoutManager(Context context, int i, int i2) {
        super(context, i, i2, false);
        C12238m.checkNotNullParameter(context, "context");
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

    private final RecyclerView.LayoutParams spanLayoutSize(RecyclerView.LayoutParams layoutParams) {
        int orientation = getOrientation();
        if (orientation == 0) {
            spanLayoutSizeHorizontalOrientation(layoutParams);
        } else if (orientation == 1) {
            spanLayoutSizeVerticalOrientation(layoutParams);
        }
        return layoutParams;
    }

    private final RecyclerView.LayoutParams spanLayoutSizeHorizontalOrientation(RecyclerView.LayoutParams layoutParams) {
        int itemCount = 2;
        if (getItemCount() != 2) {
            itemCount = (getItemCount() % 2) + (getItemCount() / 2);
        }
        ((ViewGroup.MarginLayoutParams) layoutParams).width = C11226f.coerceAtLeast(getHorizontalSpace() / itemCount, getHorizontalSpace() / maxColumns());
        return layoutParams;
    }

    private final RecyclerView.LayoutParams spanLayoutSizeVerticalOrientation(RecyclerView.LayoutParams layoutParams) {
        int itemCount = 2;
        if (getItemCount() != 2) {
            itemCount = (getItemCount() % 2) + (getItemCount() / 2);
        }
        ((ViewGroup.MarginLayoutParams) layoutParams).height = C11226f.coerceAtLeast(getVerticalSpace() / itemCount, getVerticalSpace() / maxRows());
        return layoutParams;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean canScrollHorizontally() {
        return getOrientation() == 0;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean canScrollVertically() {
        return getOrientation() == 1;
    }

    @Override // androidx.recyclerview.widget.GridLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean checkLayoutParams(RecyclerView.LayoutParams lp) {
        C12238m.checkNotNullParameter(lp, "lp");
        RecyclerView.LayoutParams layoutParamsGenerateDefaultLayoutParams = generateDefaultLayoutParams();
        return super.checkLayoutParams(lp) && ((ViewGroup.MarginLayoutParams) layoutParamsGenerateDefaultLayoutParams).width == ((ViewGroup.MarginLayoutParams) lp).width && ((ViewGroup.MarginLayoutParams) layoutParamsGenerateDefaultLayoutParams).height == ((ViewGroup.MarginLayoutParams) lp).height;
    }

    @Override // androidx.recyclerview.widget.GridLayoutManager, androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        RecyclerView.LayoutParams layoutParamsGenerateDefaultLayoutParams = super.generateDefaultLayoutParams();
        C12238m.checkNotNullExpressionValue(layoutParamsGenerateDefaultLayoutParams, "super.generateDefaultLayoutParams()");
        return spanLayoutSize(layoutParamsGenerateDefaultLayoutParams);
    }

    @Override // androidx.recyclerview.widget.GridLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateLayoutParams(Context c, AttributeSet attrs) {
        C12238m.checkNotNullParameter(c, "c");
        C12238m.checkNotNullParameter(attrs, "attrs");
        RecyclerView.LayoutParams layoutParamsGenerateLayoutParams = super.generateLayoutParams(c, attrs);
        C12238m.checkNotNullExpressionValue(layoutParamsGenerateLayoutParams, "super.generateLayoutParams(c, attrs)");
        return spanLayoutSize(layoutParamsGenerateLayoutParams);
    }

    @Override // androidx.recyclerview.widget.GridLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateLayoutParams(ViewGroup.LayoutParams lp) {
        C12238m.checkNotNullParameter(lp, "lp");
        RecyclerView.LayoutParams layoutParamsGenerateLayoutParams = super.generateLayoutParams(lp);
        C12238m.checkNotNullExpressionValue(layoutParamsGenerateLayoutParams, "super.generateLayoutParams(lp)");
        return spanLayoutSize(layoutParamsGenerateLayoutParams);
    }
}
