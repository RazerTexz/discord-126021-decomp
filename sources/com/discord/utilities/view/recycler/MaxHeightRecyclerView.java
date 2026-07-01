package com.discord.utilities.view.recycler;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.utils.R;
import d0.a0.MathJVM;
import d0.z.d.Intrinsics3;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: MaxHeightRecyclerView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class MaxHeightRecyclerView extends RecyclerView {
    private int maxHeight;

    public MaxHeightRecyclerView(Context context) {
        this(context, null, 0, 6, null);
    }

    public MaxHeightRecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public /* synthetic */ MaxHeightRecyclerView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    private final int getHeightMaximum(Context context, AttributeSet attributeSet, int i) {
        if (attributeSet == null) {
            return 0;
        }
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.b.MaxHeightRecyclerView, i, 0);
        Intrinsics3.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "obtainStyledAttributes(a…lerView, defStyleAttr, 0)");
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.b.MaxHeightRecyclerView_max_height, 0);
        float f = typedArrayObtainStyledAttributes.getFloat(R.b.MaxHeightRecyclerView_max_height_screen_ratio, 0.0f);
        typedArrayObtainStyledAttributes.recycle();
        if (f <= 0.0f || f >= 1.0f) {
            return dimensionPixelSize;
        }
        Resources resources = context.getResources();
        Intrinsics3.checkNotNullExpressionValue(resources, "resources");
        return MathJVM.roundToInt(resources.getDisplayMetrics().heightPixels * f);
    }

    public final int getMaxHeight() {
        return this.maxHeight;
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int i = this.maxHeight;
        if (i > 0) {
            heightMeasureSpec = View.MeasureSpec.makeMeasureSpec(i, Integer.MIN_VALUE);
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    public final void setMaxHeight(int i) {
        this.maxHeight = i;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MaxHeightRecyclerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics3.checkNotNullParameter(context, "context");
        this.maxHeight = getHeightMaximum(context, attributeSet, 0);
    }
}
