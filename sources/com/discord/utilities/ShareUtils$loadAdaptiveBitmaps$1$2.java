package com.discord.utilities;

import android.graphics.Bitmap;
import androidx.core.app.NotificationCompat;
import com.discord.utilities.images.MGImagesBitmap$CloseableBitmaps;
import d0.z.d.m;
import j0.k.b;
import java.util.Map;

/* JADX INFO: compiled from: ShareUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ShareUtils$loadAdaptiveBitmaps$1$2<T, R> implements b<Map<String, ? extends Bitmap>, MGImagesBitmap$CloseableBitmaps> {
    public final /* synthetic */ MGImagesBitmap$CloseableBitmaps $iconBitmaps;

    public ShareUtils$loadAdaptiveBitmaps$1$2(MGImagesBitmap$CloseableBitmaps mGImagesBitmap$CloseableBitmaps) {
        this.$iconBitmaps = mGImagesBitmap$CloseableBitmaps;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ MGImagesBitmap$CloseableBitmaps call(Map<String, ? extends Bitmap> map) {
        return call2((Map<String, Bitmap>) map);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final MGImagesBitmap$CloseableBitmaps call2(Map<String, Bitmap> map) {
        this.$iconBitmaps.close();
        m.checkNotNullExpressionValue(map, "bitmaps");
        return new MGImagesBitmap$CloseableBitmaps(map, false);
    }
}
