package com.facebook.imagepipeline.nativecode;

import android.graphics.Bitmap;
import b.f.d.d.c;
import b.f.m.n.a;

/* JADX INFO: loaded from: classes3.dex */
@c
public class NativeBlurFilter {
    static {
        a.c("native-filters");
    }

    @c
    private static native void nativeIterativeBoxBlur(Bitmap bitmap, int i, int i2);
}
