package com.discord.utilities.fresco;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import b.f.b.a.SimpleCacheKey;
import b.f.j.q.BasePostprocessor;
import com.facebook.cache.common.CacheKey;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: GrayscalePostprocessor.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GrayscalePostprocessor extends BasePostprocessor {
    @Override // b.f.j.q.BasePostprocessor, b.f.j.q.Postprocessor
    public String getName() {
        String simpleName = GrayscalePostprocessor.class.getSimpleName();
        Intrinsics3.checkNotNullExpressionValue(simpleName, "javaClass.simpleName");
        return simpleName;
    }

    @Override // b.f.j.q.BasePostprocessor, b.f.j.q.Postprocessor
    public CacheKey getPostprocessorCacheKey() {
        return new SimpleCacheKey(getName());
    }

    @Override // b.f.j.q.BasePostprocessor
    public void process(Bitmap destBitmap, Bitmap sourceBitmap) {
        super.process(destBitmap, sourceBitmap);
        if (destBitmap == null || sourceBitmap == null) {
            return;
        }
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setSaturation(0.0f);
        Paint paint = new Paint();
        paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
        new Canvas(destBitmap).drawBitmap(sourceBitmap, 0.0f, 0.0f, paint);
    }
}
