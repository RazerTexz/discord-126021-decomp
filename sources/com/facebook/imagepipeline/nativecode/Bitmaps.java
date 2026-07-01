package com.facebook.imagepipeline.nativecode;

import android.graphics.Bitmap;
import b.c.a.a0.AnimatableValueParser;
import b.f.d.d.DoNotStrip;
import b.f.j.m.ImagePipelineNativeLoader;
import b.f.m.n.NativeLoader;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
@DoNotStrip
public class Bitmaps {
    static {
        List<String> list = ImagePipelineNativeLoader.a;
        NativeLoader.c("imagepipeline");
    }

    @DoNotStrip
    public static void copyBitmap(Bitmap bitmap, Bitmap bitmap2) {
        AnimatableValueParser.i(Boolean.valueOf(bitmap2.getConfig() == bitmap.getConfig()));
        AnimatableValueParser.i(Boolean.valueOf(bitmap.isMutable()));
        AnimatableValueParser.i(Boolean.valueOf(bitmap.getWidth() == bitmap2.getWidth()));
        AnimatableValueParser.i(Boolean.valueOf(bitmap.getHeight() == bitmap2.getHeight()));
        nativeCopyBitmap(bitmap, bitmap.getRowBytes(), bitmap2, bitmap2.getRowBytes(), bitmap.getHeight());
    }

    @DoNotStrip
    private static native void nativeCopyBitmap(Bitmap bitmap, int i, Bitmap bitmap2, int i2, int i3);
}
