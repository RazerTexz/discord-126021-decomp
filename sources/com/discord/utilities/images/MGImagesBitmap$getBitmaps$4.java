package com.discord.utilities.images;

import android.graphics.Bitmap;
import androidx.core.app.NotificationCompat;
import d0.z.d.m;
import j0.k.b;
import java.util.Map;

/* JADX INFO: compiled from: MGImagesBitmap.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class MGImagesBitmap$getBitmaps$4<T, R> implements b<Map<String, Bitmap>, MGImagesBitmap$CloseableBitmaps> {
    public static final MGImagesBitmap$getBitmaps$4 INSTANCE = new MGImagesBitmap$getBitmaps$4();

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ MGImagesBitmap$CloseableBitmaps call(Map<String, Bitmap> map) {
        return call2(map);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final MGImagesBitmap$CloseableBitmaps call2(Map<String, Bitmap> map) {
        m.checkNotNullExpressionValue(map, "it");
        return new MGImagesBitmap$CloseableBitmaps(map, false, 2, null);
    }
}
