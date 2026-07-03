package com.discord.utilities.fresco;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import com.facebook.cache.common.CacheKey;
import p007b.p109f.p111b.p112a.C1656f;
import p007b.p109f.p161j.p182q.AbstractC2025a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: GrayscalePostprocessor.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GrayscalePostprocessor extends AbstractC2025a {
    @Override // p007b.p109f.p161j.p182q.AbstractC2025a, p007b.p109f.p161j.p182q.InterfaceC2026b
    public String getName() {
        String simpleName = GrayscalePostprocessor.class.getSimpleName();
        C12238m.checkNotNullExpressionValue(simpleName, "javaClass.simpleName");
        return simpleName;
    }

    @Override // p007b.p109f.p161j.p182q.AbstractC2025a, p007b.p109f.p161j.p182q.InterfaceC2026b
    public CacheKey getPostprocessorCacheKey() {
        return new C1656f(getName());
    }

    @Override // p007b.p109f.p161j.p182q.AbstractC2025a
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
