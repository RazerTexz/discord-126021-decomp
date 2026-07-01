package com.facebook.imagepipeline.nativecode;

import android.graphics.Bitmap;
import b.f.d.d.c;
import b.f.m.n.a;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
@c
public class NativeRoundingFilter {
    static {
        a.c("native-filters");
    }

    @c
    private static native void nativeAddRoundedCornersFilter(Bitmap bitmap, int i, int i2, int i3, int i4);

    @c
    private static native void nativeToCircleFastFilter(Bitmap bitmap, boolean z2);

    @c
    private static native void nativeToCircleFilter(Bitmap bitmap, boolean z2);

    @c
    private static native void nativeToCircleWithBorderFilter(Bitmap bitmap, int i, int i2, boolean z2);

    @c
    public static void toCircle(Bitmap bitmap, boolean z2) {
        Objects.requireNonNull(bitmap);
        if (bitmap.getWidth() < 3 || bitmap.getHeight() < 3) {
            return;
        }
        nativeToCircleFilter(bitmap, z2);
    }

    @c
    public static void toCircleFast(Bitmap bitmap, boolean z2) {
        Objects.requireNonNull(bitmap);
        if (bitmap.getWidth() < 3 || bitmap.getHeight() < 3) {
            return;
        }
        nativeToCircleFastFilter(bitmap, z2);
    }
}
