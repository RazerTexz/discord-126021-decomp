package com.facebook.imagepipeline.nativecode;

import android.graphics.Bitmap;
import b.c.a.a0.d;
import b.f.d.d.c;
import b.f.j.m.a;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
@c
public class Bitmaps {
    static {
        List<String> list = a.a;
        b.f.m.n.a.c("imagepipeline");
    }

    @c
    public static void copyBitmap(Bitmap bitmap, Bitmap bitmap2) {
        d.i(Boolean.valueOf(bitmap2.getConfig() == bitmap.getConfig()));
        d.i(Boolean.valueOf(bitmap.isMutable()));
        d.i(Boolean.valueOf(bitmap.getWidth() == bitmap2.getWidth()));
        d.i(Boolean.valueOf(bitmap.getHeight() == bitmap2.getHeight()));
        nativeCopyBitmap(bitmap, bitmap.getRowBytes(), bitmap2, bitmap2.getRowBytes(), bitmap.getHeight());
    }

    @c
    private static native void nativeCopyBitmap(Bitmap bitmap, int i, Bitmap bitmap2, int i2, int i3);
}
