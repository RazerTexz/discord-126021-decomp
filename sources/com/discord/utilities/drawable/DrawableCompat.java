package com.discord.utilities.drawable;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.AttrRes;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.widget.TextViewCompat;
import com.discord.utilities.color.ColorCompat2;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: DrawableCompat.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class DrawableCompat {
    private static final void applyCompoundDrawablesTint(TextView textView) {
        ColorStateList compoundDrawableTintList = TextViewCompat.getCompoundDrawableTintList(textView);
        if (compoundDrawableTintList != null) {
            TextViewCompat.setCompoundDrawableTintList(textView, compoundDrawableTintList);
        }
    }

    public static final Drawable getDrawable(Context context, @DrawableRes int i, @ColorInt int i2) {
        return getDrawable$default(context, i, i2, false, 4, null);
    }

    public static final Drawable getDrawable(Context context, @DrawableRes int i, @ColorInt int i2, boolean z2) {
        Intrinsics3.checkNotNullParameter(context, "$this$getDrawable");
        Drawable drawable = AppCompatResources.getDrawable(context, i);
        if (drawable != null) {
            ColorCompat2.setTint(drawable, i2, z2);
        }
        return drawable;
    }

    public static /* synthetic */ Drawable getDrawable$default(Context context, int i, int i2, boolean z2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z2 = false;
        }
        return getDrawable(context, i, i2, z2);
    }

    public static final int getThemedDrawableRes(Context context, @AttrRes int i) {
        return getThemedDrawableRes$default(context, i, 0, 2, (Object) null);
    }

    public static final int getThemedDrawableRes(Context context, @AttrRes int i, int i2) {
        Intrinsics3.checkNotNullParameter(context, "$this$getThemedDrawableRes");
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(new int[]{i});
        Intrinsics3.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "obtainStyledAttributes(intArrayOf(attrResId))");
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, i2);
        typedArrayObtainStyledAttributes.recycle();
        return resourceId;
    }

    @DrawableRes
    public static final int getThemedDrawableRes(View view, @AttrRes int i) {
        return getThemedDrawableRes$default(view, i, 0, 2, (Object) null);
    }

    public static /* synthetic */ int getThemedDrawableRes$default(Context context, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        return getThemedDrawableRes(context, i, i2);
    }

    public static final void setCompoundDrawablesCompat(TextView textView, @DrawableRes int i, @DrawableRes int i2, @DrawableRes int i3, @DrawableRes int i4) {
        Intrinsics3.checkNotNullParameter(textView, "$this$setCompoundDrawablesCompat");
        TextViewCompat.setCompoundDrawablesRelativeWithIntrinsicBounds(textView, i, i2, i3, i4);
        applyCompoundDrawablesTint(textView);
    }

    public static /* synthetic */ void setCompoundDrawablesCompat$default(TextView textView, int i, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = 0;
        }
        if ((i5 & 2) != 0) {
            i2 = 0;
        }
        if ((i5 & 4) != 0) {
            i3 = 0;
        }
        if ((i5 & 8) != 0) {
            i4 = 0;
        }
        setCompoundDrawablesCompat(textView, i, i2, i3, i4);
    }

    public static /* synthetic */ int getThemedDrawableRes$default(View view, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        return getThemedDrawableRes(view, i, i2);
    }

    public static /* synthetic */ void setCompoundDrawablesCompat$default(TextView textView, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4, int i, Object obj) {
        if ((i & 1) != 0) {
            drawable = null;
        }
        if ((i & 2) != 0) {
            drawable2 = null;
        }
        if ((i & 4) != 0) {
            drawable3 = null;
        }
        if ((i & 8) != 0) {
            drawable4 = null;
        }
        setCompoundDrawablesCompat(textView, drawable, drawable2, drawable3, drawable4);
    }

    @DrawableRes
    public static final int getThemedDrawableRes(View view, @AttrRes int i, int i2) {
        Intrinsics3.checkNotNullParameter(view, "$this$getThemedDrawableRes");
        Context context = view.getContext();
        Intrinsics3.checkNotNullExpressionValue(context, "context");
        return getThemedDrawableRes(context, i, i2);
    }

    public static final void setCompoundDrawablesCompat(TextView textView, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        Intrinsics3.checkNotNullParameter(textView, "$this$setCompoundDrawablesCompat");
        TextViewCompat.setCompoundDrawablesRelativeWithIntrinsicBounds(textView, drawable, drawable2, drawable3, drawable4);
        applyCompoundDrawablesTint(textView);
    }
}
