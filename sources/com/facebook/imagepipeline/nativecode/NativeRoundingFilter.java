package com.facebook.imagepipeline.nativecode;

import android.graphics.Bitmap;
import java.util.Objects;
import p007b.p109f.p115d.p119d.InterfaceC1680c;
import p007b.p109f.p190m.p191n.C2061a;

/* JADX INFO: loaded from: classes3.dex */
@InterfaceC1680c
public class NativeRoundingFilter {
    static {
        C2061a.m1589c("native-filters");
    }

    @InterfaceC1680c
    private static native void nativeAddRoundedCornersFilter(Bitmap bitmap, int i, int i2, int i3, int i4);

    @InterfaceC1680c
    private static native void nativeToCircleFastFilter(Bitmap bitmap, boolean z2);

    @InterfaceC1680c
    private static native void nativeToCircleFilter(Bitmap bitmap, boolean z2);

    @InterfaceC1680c
    private static native void nativeToCircleWithBorderFilter(Bitmap bitmap, int i, int i2, boolean z2);

    @InterfaceC1680c
    public static void toCircle(Bitmap bitmap, boolean z2) {
        Objects.requireNonNull(bitmap);
        if (bitmap.getWidth() < 3 || bitmap.getHeight() < 3) {
            return;
        }
        nativeToCircleFilter(bitmap, z2);
    }

    @InterfaceC1680c
    public static void toCircleFast(Bitmap bitmap, boolean z2) {
        Objects.requireNonNull(bitmap);
        if (bitmap.getWidth() < 3 || bitmap.getHeight() < 3) {
            return;
        }
        nativeToCircleFastFilter(bitmap, z2);
    }
}
