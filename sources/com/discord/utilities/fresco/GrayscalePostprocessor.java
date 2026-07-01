package com.discord.utilities.fresco;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import b.f.b.a.f;
import b.f.j.q.a;
import com.facebook.cache.common.CacheKey;
import d0.z.d.m;

/* JADX INFO: compiled from: GrayscalePostprocessor.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GrayscalePostprocessor extends a {
    @Override // b.f.j.q.a, b.f.j.q.b
    public String getName() {
        String simpleName = GrayscalePostprocessor.class.getSimpleName();
        m.checkNotNullExpressionValue(simpleName, "javaClass.simpleName");
        return simpleName;
    }

    @Override // b.f.j.q.a, b.f.j.q.b
    public CacheKey getPostprocessorCacheKey() {
        return new f(getName());
    }

    @Override // b.f.j.q.a
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
