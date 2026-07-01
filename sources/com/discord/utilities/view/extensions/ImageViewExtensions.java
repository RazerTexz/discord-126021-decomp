package com.discord.utilities.view.extensions;

import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.widget.ImageView;
import androidx.annotation.FloatRange;
import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: com.discord.utilities.view.extensions.ImageViewExtensionsKt, reason: use source file name */
/* JADX INFO: compiled from: ImageViewExtensions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ImageViewExtensions {
    public static final void setGrayscale(ImageView imageView, boolean z2) {
        Intrinsics3.checkNotNullParameter(imageView, "$this$setGrayscale");
        setSaturation(imageView, z2 ? 0.0f : 1.0f);
    }

    public static final void setSaturation(ImageView imageView, @FloatRange(from = 0.0d, to = 3.4028234663852886E38d) float f) {
        Intrinsics3.checkNotNullParameter(imageView, "$this$setSaturation");
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setSaturation(f);
        imageView.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
    }
}
