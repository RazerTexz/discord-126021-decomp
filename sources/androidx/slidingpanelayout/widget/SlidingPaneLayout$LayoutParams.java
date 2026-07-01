package androidx.slidingpanelayout.widget;

import android.R$attr;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.ViewGroup$LayoutParams;
import android.view.ViewGroup$MarginLayoutParams;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
public class SlidingPaneLayout$LayoutParams extends ViewGroup$MarginLayoutParams {
    private static final int[] ATTRS = {R$attr.layout_weight};
    public Paint dimPaint;
    public boolean dimWhenOffset;
    public boolean slideable;
    public float weight;

    public SlidingPaneLayout$LayoutParams() {
        super(-1, -1);
        this.weight = 0.0f;
    }

    public SlidingPaneLayout$LayoutParams(int i, int i2) {
        super(i, i2);
        this.weight = 0.0f;
    }

    public SlidingPaneLayout$LayoutParams(@NonNull ViewGroup$LayoutParams viewGroup$LayoutParams) {
        super(viewGroup$LayoutParams);
        this.weight = 0.0f;
    }

    public SlidingPaneLayout$LayoutParams(@NonNull ViewGroup$MarginLayoutParams viewGroup$MarginLayoutParams) {
        super(viewGroup$MarginLayoutParams);
        this.weight = 0.0f;
    }

    public SlidingPaneLayout$LayoutParams(@NonNull SlidingPaneLayout$LayoutParams slidingPaneLayout$LayoutParams) {
        super((ViewGroup$MarginLayoutParams) slidingPaneLayout$LayoutParams);
        this.weight = 0.0f;
        this.weight = slidingPaneLayout$LayoutParams.weight;
    }

    public SlidingPaneLayout$LayoutParams(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.weight = 0.0f;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ATTRS);
        this.weight = typedArrayObtainStyledAttributes.getFloat(0, 0.0f);
        typedArrayObtainStyledAttributes.recycle();
    }
}
