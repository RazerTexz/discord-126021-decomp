package com.google.android.material.textview;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StyleableRes;
import androidx.appcompat.widget.AppCompatTextView;
import com.google.android.material.C10817R;
import com.google.android.material.resources.MaterialAttributes;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;

/* JADX INFO: loaded from: classes3.dex */
public class MaterialTextView extends AppCompatTextView {
    public MaterialTextView(@NonNull Context context) {
        this(context, null);
    }

    private void applyLineHeightFromViewAppearance(@NonNull Resources.Theme theme, int i) {
        TypedArray typedArrayObtainStyledAttributes = theme.obtainStyledAttributes(i, C10817R.styleable.MaterialTextAppearance);
        int firstAvailableDimension = readFirstAvailableDimension(getContext(), typedArrayObtainStyledAttributes, C10817R.styleable.MaterialTextAppearance_android_lineHeight, C10817R.styleable.MaterialTextAppearance_lineHeight);
        typedArrayObtainStyledAttributes.recycle();
        if (firstAvailableDimension >= 0) {
            setLineHeight(firstAvailableDimension);
        }
    }

    private static boolean canApplyTextAppearanceLineHeight(Context context) {
        return MaterialAttributes.resolveBoolean(context, C10817R.attr.textAppearanceLineHeightEnabled, true);
    }

    private static int findViewAppearanceResourceId(@NonNull Resources.Theme theme, @Nullable AttributeSet attributeSet, int i, int i2) {
        TypedArray typedArrayObtainStyledAttributes = theme.obtainStyledAttributes(attributeSet, C10817R.styleable.MaterialTextView, i, i2);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(C10817R.styleable.MaterialTextView_android_textAppearance, -1);
        typedArrayObtainStyledAttributes.recycle();
        return resourceId;
    }

    private static int readFirstAvailableDimension(@NonNull Context context, @NonNull TypedArray typedArray, @NonNull @StyleableRes int... iArr) {
        int dimensionPixelSize = -1;
        for (int i = 0; i < iArr.length && dimensionPixelSize < 0; i++) {
            dimensionPixelSize = MaterialResources.getDimensionPixelSize(context, typedArray, iArr[i], -1);
        }
        return dimensionPixelSize;
    }

    private static boolean viewAttrsHasLineHeight(@NonNull Context context, @NonNull Resources.Theme theme, @Nullable AttributeSet attributeSet, int i, int i2) {
        TypedArray typedArrayObtainStyledAttributes = theme.obtainStyledAttributes(attributeSet, C10817R.styleable.MaterialTextView, i, i2);
        int firstAvailableDimension = readFirstAvailableDimension(context, typedArrayObtainStyledAttributes, C10817R.styleable.MaterialTextView_android_lineHeight, C10817R.styleable.MaterialTextView_lineHeight);
        typedArrayObtainStyledAttributes.recycle();
        return firstAvailableDimension != -1;
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView
    public void setTextAppearance(@NonNull Context context, int i) {
        super.setTextAppearance(context, i);
        if (canApplyTextAppearanceLineHeight(context)) {
            applyLineHeightFromViewAppearance(context.getTheme(), i);
        }
    }

    public MaterialTextView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.textViewStyle);
    }

    public MaterialTextView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public MaterialTextView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        int iFindViewAppearanceResourceId;
        super(MaterialThemeOverlay.wrap(context, attributeSet, i, i2), attributeSet, i);
        Context context2 = getContext();
        if (canApplyTextAppearanceLineHeight(context2)) {
            Resources.Theme theme = context2.getTheme();
            if (viewAttrsHasLineHeight(context2, theme, attributeSet, i, i2) || (iFindViewAppearanceResourceId = findViewAppearanceResourceId(theme, attributeSet, i, i2)) == -1) {
                return;
            }
            applyLineHeightFromViewAppearance(theme, iFindViewAppearanceResourceId);
        }
    }
}
