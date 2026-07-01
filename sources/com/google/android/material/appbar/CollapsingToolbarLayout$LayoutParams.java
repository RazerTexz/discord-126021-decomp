package com.google.android.material.appbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ViewGroup$LayoutParams;
import android.view.ViewGroup$MarginLayoutParams;
import android.widget.FrameLayout$LayoutParams;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.google.android.material.R$styleable;

/* JADX INFO: loaded from: classes3.dex */
public class CollapsingToolbarLayout$LayoutParams extends FrameLayout$LayoutParams {
    public static final int COLLAPSE_MODE_OFF = 0;
    public static final int COLLAPSE_MODE_PARALLAX = 2;
    public static final int COLLAPSE_MODE_PIN = 1;
    private static final float DEFAULT_PARALLAX_MULTIPLIER = 0.5f;
    public int collapseMode;
    public float parallaxMult;

    public CollapsingToolbarLayout$LayoutParams(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.collapseMode = 0;
        this.parallaxMult = 0.5f;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.CollapsingToolbarLayout_Layout);
        this.collapseMode = typedArrayObtainStyledAttributes.getInt(R$styleable.CollapsingToolbarLayout_Layout_layout_collapseMode, 0);
        setParallaxMultiplier(typedArrayObtainStyledAttributes.getFloat(R$styleable.CollapsingToolbarLayout_Layout_layout_collapseParallaxMultiplier, 0.5f));
        typedArrayObtainStyledAttributes.recycle();
    }

    public int getCollapseMode() {
        return this.collapseMode;
    }

    public float getParallaxMultiplier() {
        return this.parallaxMult;
    }

    public void setCollapseMode(int i) {
        this.collapseMode = i;
    }

    public void setParallaxMultiplier(float f) {
        this.parallaxMult = f;
    }

    public CollapsingToolbarLayout$LayoutParams(int i, int i2) {
        super(i, i2);
        this.collapseMode = 0;
        this.parallaxMult = 0.5f;
    }

    public CollapsingToolbarLayout$LayoutParams(int i, int i2, int i3) {
        super(i, i2, i3);
        this.collapseMode = 0;
        this.parallaxMult = 0.5f;
    }

    public CollapsingToolbarLayout$LayoutParams(@NonNull ViewGroup$LayoutParams viewGroup$LayoutParams) {
        super(viewGroup$LayoutParams);
        this.collapseMode = 0;
        this.parallaxMult = 0.5f;
    }

    public CollapsingToolbarLayout$LayoutParams(@NonNull ViewGroup$MarginLayoutParams viewGroup$MarginLayoutParams) {
        super(viewGroup$MarginLayoutParams);
        this.collapseMode = 0;
        this.parallaxMult = 0.5f;
    }

    @RequiresApi(19)
    public CollapsingToolbarLayout$LayoutParams(@NonNull FrameLayout$LayoutParams frameLayout$LayoutParams) {
        super(frameLayout$LayoutParams);
        this.collapseMode = 0;
        this.parallaxMult = 0.5f;
    }
}
