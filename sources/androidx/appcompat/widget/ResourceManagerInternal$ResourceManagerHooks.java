package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff$Mode;
import android.graphics.drawable.Drawable;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.annotation.RestrictTo$Scope;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo$Scope.LIBRARY_GROUP_PREFIX})
public interface ResourceManagerInternal$ResourceManagerHooks {
    Drawable createDrawableFor(@NonNull ResourceManagerInternal resourceManagerInternal, @NonNull Context context, @DrawableRes int i);

    ColorStateList getTintListForDrawableRes(@NonNull Context context, @DrawableRes int i);

    PorterDuff$Mode getTintModeForDrawableRes(int i);

    boolean tintDrawable(@NonNull Context context, @DrawableRes int i, @NonNull Drawable drawable);

    boolean tintDrawableUsingColorFilter(@NonNull Context context, @DrawableRes int i, @NonNull Drawable drawable);
}
