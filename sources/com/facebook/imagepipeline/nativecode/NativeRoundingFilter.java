package com.facebook.imagepipeline.nativecode;

import android.graphics.Bitmap;
import b.f.d.d.DoNotStrip;
import b.f.m.n.NativeLoader;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
@DoNotStrip
public class NativeRoundingFilter {
    static {
        NativeLoader.c("native-filters");
    }

    @DoNotStrip
    private static native void nativeAddRoundedCornersFilter(Bitmap bitmap, int i, int i2, int i3, int i4);

    @DoNotStrip
    private static native void nativeToCircleFastFilter(Bitmap bitmap, boolean z2);

    @DoNotStrip
    private static native void nativeToCircleFilter(Bitmap bitmap, boolean z2);

    @DoNotStrip
    private static native void nativeToCircleWithBorderFilter(Bitmap bitmap, int i, int i2, boolean z2);

    @DoNotStrip
    public static void toCircle(Bitmap bitmap, boolean z2) {
        Objects.requireNonNull(bitmap);
        if (bitmap.getWidth() < 3 || bitmap.getHeight() < 3) {
            return;
        }
        nativeToCircleFilter(bitmap, z2);
    }

    @DoNotStrip
    public static void toCircleFast(Bitmap bitmap, boolean z2) {
        Objects.requireNonNull(bitmap);
        if (bitmap.getWidth() < 3 || bitmap.getHeight() < 3) {
            return;
        }
        nativeToCircleFastFilter(bitmap, z2);
    }
}
