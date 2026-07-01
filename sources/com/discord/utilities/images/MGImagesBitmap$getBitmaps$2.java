package com.discord.utilities.images;

import android.graphics.Bitmap;
import androidx.core.app.NotificationCompat;
import j0.k.b;
import kotlin.Pair;

/* JADX INFO: compiled from: MGImagesBitmap.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class MGImagesBitmap$getBitmaps$2<T, R> implements b<Pair<? extends String, ? extends Bitmap>, String> {
    public static final MGImagesBitmap$getBitmaps$2 INSTANCE = new MGImagesBitmap$getBitmaps$2();

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ String call(Pair<? extends String, ? extends Bitmap> pair) {
        return call2((Pair<String, Bitmap>) pair);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final String call2(Pair<String, Bitmap> pair) {
        return pair.getFirst();
    }
}
