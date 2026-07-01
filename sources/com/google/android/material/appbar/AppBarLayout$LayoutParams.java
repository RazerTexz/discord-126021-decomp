package com.google.android.material.appbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ViewGroup$LayoutParams;
import android.view.ViewGroup$MarginLayoutParams;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.LinearLayout$LayoutParams;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.google.android.material.R$styleable;

/* JADX INFO: loaded from: classes3.dex */
public class AppBarLayout$LayoutParams extends LinearLayout$LayoutParams {
    public static final int COLLAPSIBLE_FLAGS = 10;
    public static final int FLAG_QUICK_RETURN = 5;
    public static final int FLAG_SNAP = 17;
    public static final int SCROLL_FLAG_ENTER_ALWAYS = 4;
    public static final int SCROLL_FLAG_ENTER_ALWAYS_COLLAPSED = 8;
    public static final int SCROLL_FLAG_EXIT_UNTIL_COLLAPSED = 2;
    public static final int SCROLL_FLAG_NO_SCROLL = 0;
    public static final int SCROLL_FLAG_SCROLL = 1;
    public static final int SCROLL_FLAG_SNAP = 16;
    public static final int SCROLL_FLAG_SNAP_MARGINS = 32;
    public int scrollFlags;
    public Interpolator scrollInterpolator;

    public AppBarLayout$LayoutParams(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.scrollFlags = 1;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.AppBarLayout_Layout);
        this.scrollFlags = typedArrayObtainStyledAttributes.getInt(R$styleable.AppBarLayout_Layout_layout_scrollFlags, 0);
        int i = R$styleable.AppBarLayout_Layout_layout_scrollInterpolator;
        if (typedArrayObtainStyledAttributes.hasValue(i)) {
            this.scrollInterpolator = AnimationUtils.loadInterpolator(context, typedArrayObtainStyledAttributes.getResourceId(i, 0));
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    public int getScrollFlags() {
        return this.scrollFlags;
    }

    public Interpolator getScrollInterpolator() {
        return this.scrollInterpolator;
    }

    public boolean isCollapsible() {
        int i = this.scrollFlags;
        return (i & 1) == 1 && (i & 10) != 0;
    }

    public void setScrollFlags(int i) {
        this.scrollFlags = i;
    }

    public void setScrollInterpolator(Interpolator interpolator) {
        this.scrollInterpolator = interpolator;
    }

    public AppBarLayout$LayoutParams(int i, int i2) {
        super(i, i2);
        this.scrollFlags = 1;
    }

    public AppBarLayout$LayoutParams(int i, int i2, float f) {
        super(i, i2, f);
        this.scrollFlags = 1;
    }

    public AppBarLayout$LayoutParams(ViewGroup$LayoutParams viewGroup$LayoutParams) {
        super(viewGroup$LayoutParams);
        this.scrollFlags = 1;
    }

    public AppBarLayout$LayoutParams(ViewGroup$MarginLayoutParams viewGroup$MarginLayoutParams) {
        super(viewGroup$MarginLayoutParams);
        this.scrollFlags = 1;
    }

    @RequiresApi(19)
    public AppBarLayout$LayoutParams(LinearLayout$LayoutParams linearLayout$LayoutParams) {
        super(linearLayout$LayoutParams);
        this.scrollFlags = 1;
    }

    @RequiresApi(19)
    public AppBarLayout$LayoutParams(@NonNull AppBarLayout$LayoutParams appBarLayout$LayoutParams) {
        super((LinearLayout$LayoutParams) appBarLayout$LayoutParams);
        this.scrollFlags = 1;
        this.scrollFlags = appBarLayout$LayoutParams.scrollFlags;
        this.scrollInterpolator = appBarLayout$LayoutParams.scrollInterpolator;
    }
}
