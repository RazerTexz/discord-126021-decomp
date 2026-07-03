package com.google.android.material.progressindicator;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.StyleRes;
import com.google.android.material.C10817R;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.resources.MaterialResources;
import p007b.p100d.p104b.p105a.C1643a;

/* JADX INFO: loaded from: classes3.dex */
public final class CircularProgressIndicatorSpec extends BaseProgressIndicatorSpec {
    public int indicatorDirection;

    @Px
    public int indicatorInset;

    @Px
    public int indicatorSize;

    public CircularProgressIndicatorSpec(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, C10817R.attr.circularProgressIndicatorStyle);
    }

    @Override // com.google.android.material.progressindicator.BaseProgressIndicatorSpec
    public void validateSpec() {
        if (this.indicatorSize >= this.trackThickness * 2) {
            return;
        }
        StringBuilder sbM833U = C1643a.m833U("The indicatorSize (");
        sbM833U.append(this.indicatorSize);
        sbM833U.append(" px) cannot be less than twice of the trackThickness (");
        throw new IllegalArgumentException(C1643a.m814B(sbM833U, this.trackThickness, " px)."));
    }

    public CircularProgressIndicatorSpec(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i) {
        this(context, attributeSet, i, CircularProgressIndicator.DEF_STYLE_RES);
    }

    public CircularProgressIndicatorSpec(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i, @StyleRes int i2) {
        super(context, attributeSet, i, i2);
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(C10817R.dimen.mtrl_progress_circular_size_medium);
        int dimensionPixelSize2 = context.getResources().getDimensionPixelSize(C10817R.dimen.mtrl_progress_circular_inset_medium);
        TypedArray typedArrayObtainStyledAttributes = ThemeEnforcement.obtainStyledAttributes(context, attributeSet, C10817R.styleable.CircularProgressIndicator, i, i2, new int[0]);
        this.indicatorSize = MaterialResources.getDimensionPixelSize(context, typedArrayObtainStyledAttributes, C10817R.styleable.CircularProgressIndicator_indicatorSize, dimensionPixelSize);
        this.indicatorInset = MaterialResources.getDimensionPixelSize(context, typedArrayObtainStyledAttributes, C10817R.styleable.CircularProgressIndicator_indicatorInset, dimensionPixelSize2);
        this.indicatorDirection = typedArrayObtainStyledAttributes.getInt(C10817R.styleable.CircularProgressIndicator_indicatorDirectionCircular, 0);
        typedArrayObtainStyledAttributes.recycle();
        validateSpec();
    }
}
