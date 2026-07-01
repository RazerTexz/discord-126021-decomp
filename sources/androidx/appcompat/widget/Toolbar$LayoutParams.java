package androidx.appcompat.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup$LayoutParams;
import android.view.ViewGroup$MarginLayoutParams;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar$LayoutParams;

/* JADX INFO: loaded from: classes.dex */
public class Toolbar$LayoutParams extends ActionBar$LayoutParams {
    public static final int CUSTOM = 0;
    public static final int EXPANDED = 2;
    public static final int SYSTEM = 1;
    public int mViewType;

    public Toolbar$LayoutParams(@NonNull Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mViewType = 0;
    }

    public void copyMarginsFromCompat(ViewGroup$MarginLayoutParams viewGroup$MarginLayoutParams) {
        ((ViewGroup$MarginLayoutParams) this).leftMargin = viewGroup$MarginLayoutParams.leftMargin;
        ((ViewGroup$MarginLayoutParams) this).topMargin = viewGroup$MarginLayoutParams.topMargin;
        ((ViewGroup$MarginLayoutParams) this).rightMargin = viewGroup$MarginLayoutParams.rightMargin;
        ((ViewGroup$MarginLayoutParams) this).bottomMargin = viewGroup$MarginLayoutParams.bottomMargin;
    }

    public Toolbar$LayoutParams(int i, int i2) {
        super(i, i2);
        this.mViewType = 0;
        this.gravity = 8388627;
    }

    public Toolbar$LayoutParams(int i, int i2, int i3) {
        super(i, i2);
        this.mViewType = 0;
        this.gravity = i3;
    }

    public Toolbar$LayoutParams(int i) {
        this(-2, -1, i);
    }

    public Toolbar$LayoutParams(Toolbar$LayoutParams toolbar$LayoutParams) {
        super((ActionBar$LayoutParams) toolbar$LayoutParams);
        this.mViewType = 0;
        this.mViewType = toolbar$LayoutParams.mViewType;
    }

    public Toolbar$LayoutParams(ActionBar$LayoutParams actionBar$LayoutParams) {
        super(actionBar$LayoutParams);
        this.mViewType = 0;
    }

    public Toolbar$LayoutParams(ViewGroup$MarginLayoutParams viewGroup$MarginLayoutParams) {
        super(viewGroup$MarginLayoutParams);
        this.mViewType = 0;
        copyMarginsFromCompat(viewGroup$MarginLayoutParams);
    }

    public Toolbar$LayoutParams(ViewGroup$LayoutParams viewGroup$LayoutParams) {
        super(viewGroup$LayoutParams);
        this.mViewType = 0;
    }
}
