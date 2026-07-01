package com.discord.utilities.images;

import android.graphics.Bitmap;
import androidx.core.app.NotificationCompat;
import d0.o;
import j0.k.b;
import kotlin.Pair;

/* JADX INFO: compiled from: MGImagesBitmap.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class MGImagesBitmap$getBitmaps$1$1<T, R> implements b<Bitmap, Pair<? extends String, ? extends Bitmap>> {
    public final /* synthetic */ MGImagesBitmap$ImageRequest $imageRequest;

    public MGImagesBitmap$getBitmaps$1$1(MGImagesBitmap$ImageRequest mGImagesBitmap$ImageRequest) {
        this.$imageRequest = mGImagesBitmap$ImageRequest;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Pair<? extends String, ? extends Bitmap> call(Bitmap bitmap) {
        return call2(bitmap);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Pair<String, Bitmap> call2(Bitmap bitmap) {
        return o.to(this.$imageRequest.getImageUri(), bitmap);
    }
}
