package com.facebook.imagepipeline.bitmaps;

import android.graphics.Bitmap;
import android.graphics.Bitmap$Config;
import com.facebook.common.references.CloseableReference;

/* JADX INFO: loaded from: classes2.dex */
public abstract class PlatformBitmapFactory {
    public CloseableReference a(int i, int i2, Bitmap$Config bitmap$Config) {
        return b(i, i2, bitmap$Config);
    }

    public abstract CloseableReference<Bitmap> b(int i, int i2, Bitmap$Config bitmap$Config);
}
