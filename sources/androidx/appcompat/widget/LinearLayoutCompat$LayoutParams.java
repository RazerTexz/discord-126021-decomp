package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ViewGroup$LayoutParams;
import android.view.ViewGroup$MarginLayoutParams;
import androidx.appcompat.R$styleable;

/* JADX INFO: loaded from: classes.dex */
public class LinearLayoutCompat$LayoutParams extends ViewGroup$MarginLayoutParams {
    public int gravity;
    public float weight;

    public LinearLayoutCompat$LayoutParams(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gravity = -1;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.LinearLayoutCompat_Layout);
        this.weight = typedArrayObtainStyledAttributes.getFloat(R$styleable.LinearLayoutCompat_Layout_android_layout_weight, 0.0f);
        this.gravity = typedArrayObtainStyledAttributes.getInt(R$styleable.LinearLayoutCompat_Layout_android_layout_gravity, -1);
        typedArrayObtainStyledAttributes.recycle();
    }

    public LinearLayoutCompat$LayoutParams(int i, int i2) {
        super(i, i2);
        this.gravity = -1;
        this.weight = 0.0f;
    }

    public LinearLayoutCompat$LayoutParams(int i, int i2, float f) {
        super(i, i2);
        this.gravity = -1;
        this.weight = f;
    }

    public LinearLayoutCompat$LayoutParams(ViewGroup$LayoutParams viewGroup$LayoutParams) {
        super(viewGroup$LayoutParams);
        this.gravity = -1;
    }

    public LinearLayoutCompat$LayoutParams(ViewGroup$MarginLayoutParams viewGroup$MarginLayoutParams) {
        super(viewGroup$MarginLayoutParams);
        this.gravity = -1;
    }

    public LinearLayoutCompat$LayoutParams(LinearLayoutCompat$LayoutParams linearLayoutCompat$LayoutParams) {
        super((ViewGroup$MarginLayoutParams) linearLayoutCompat$LayoutParams);
        this.gravity = -1;
        this.weight = linearLayoutCompat$LayoutParams.weight;
        this.gravity = linearLayoutCompat$LayoutParams.gravity;
    }
}
