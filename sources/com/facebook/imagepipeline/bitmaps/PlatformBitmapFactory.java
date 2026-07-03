package com.facebook.imagepipeline.bitmaps;

import android.graphics.Bitmap;
import com.facebook.common.references.CloseableReference;

/* JADX INFO: loaded from: classes2.dex */
public abstract class PlatformBitmapFactory {
    /* JADX INFO: renamed from: a */
    public CloseableReference m8695a(int i, int i2, Bitmap.Config config) {
        return mo1206b(i, i2, config);
    }

    /* JADX INFO: renamed from: b */
    public abstract CloseableReference<Bitmap> mo1206b(int i, int i2, Bitmap.Config config);
}
