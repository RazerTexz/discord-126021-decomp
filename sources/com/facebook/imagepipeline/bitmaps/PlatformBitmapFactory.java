package com.facebook.imagepipeline.bitmaps;

import android.graphics.Bitmap;
import com.facebook.common.references.CloseableReference;

/* JADX INFO: loaded from: classes2.dex */
public abstract class PlatformBitmapFactory {
    public CloseableReference a(int i, int i2, Bitmap.Config config) {
        return b(i, i2, config);
    }

    public abstract CloseableReference<Bitmap> b(int i, int i2, Bitmap.Config config);
}
