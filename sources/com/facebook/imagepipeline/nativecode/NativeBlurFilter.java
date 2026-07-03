package com.facebook.imagepipeline.nativecode;

import android.graphics.Bitmap;
import p007b.p109f.p115d.p119d.InterfaceC1680c;
import p007b.p109f.p190m.p191n.C2061a;

/* JADX INFO: loaded from: classes3.dex */
@InterfaceC1680c
public class NativeBlurFilter {
    static {
        C2061a.m1589c("native-filters");
    }

    @InterfaceC1680c
    private static native void nativeIterativeBoxBlur(Bitmap bitmap, int i, int i2);
}
