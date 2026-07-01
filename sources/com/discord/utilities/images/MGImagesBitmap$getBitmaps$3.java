package com.discord.utilities.images;

import android.graphics.Bitmap;
import androidx.core.app.NotificationCompat;
import j0.k.b;
import kotlin.Pair;

/* JADX INFO: compiled from: MGImagesBitmap.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class MGImagesBitmap$getBitmaps$3<T, R> implements b<Pair<? extends String, ? extends Bitmap>, Bitmap> {
    public static final MGImagesBitmap$getBitmaps$3 INSTANCE = new MGImagesBitmap$getBitmaps$3();

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Bitmap call(Pair<? extends String, ? extends Bitmap> pair) {
        return call2((Pair<String, Bitmap>) pair);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Bitmap call2(Pair<String, Bitmap> pair) {
        return pair.getSecond();
    }
}
