package com.discord.utilities.color;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.fragment.app.Fragment;
import com.discord.models.domain.ModelAuditLogEntry;
import java.util.Iterator;
import p507d0.p580t.C12141k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: ColorCompat.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ColorCompatKt {
    @ColorInt
    public static final int getColor(Fragment fragment, @ColorRes int i) {
        C12238m.checkNotNullParameter(fragment, "$this$getColor");
        return ColorCompat.getColor(fragment, i);
    }

    public static final void setDrawableColor(TextView textView, @ColorInt int i) {
        C12238m.checkNotNullParameter(textView, "$this$setDrawableColor");
        Drawable[] compoundDrawables = textView.getCompoundDrawables();
        C12238m.checkNotNullExpressionValue(compoundDrawables, "compoundDrawables");
        Iterator it = C12141k.filterNotNull(compoundDrawables).iterator();
        while (it.hasNext()) {
            ((Drawable) it.next()).setColorFilter(new PorterDuffColorFilter(i, PorterDuff.Mode.SRC_IN));
        }
    }

    public static final void setTint(Drawable drawable, @ColorInt int i, boolean z2) {
        C12238m.checkNotNullParameter(drawable, "$this$setTint");
        if (!z2) {
            drawable.mutate();
        }
        DrawableCompat.setTint(drawable, i);
    }

    public static /* synthetic */ void setTint$default(Drawable drawable, int i, boolean z2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z2 = false;
        }
        setTint(drawable, i, z2);
    }

    public static final void tintWithColor(ImageView imageView, int i) {
        C12238m.checkNotNullParameter(imageView, "$this$tintWithColor");
        imageView.setImageTintList(ColorStateList.valueOf(i));
    }

    public static final void tintWithColorResource(ImageView imageView, int i) {
        C12238m.checkNotNullParameter(imageView, "$this$tintWithColorResource");
        tintWithColor(imageView, ColorCompat.getColor(imageView, i));
    }
}
