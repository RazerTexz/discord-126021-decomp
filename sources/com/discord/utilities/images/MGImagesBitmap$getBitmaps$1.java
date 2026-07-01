package com.discord.utilities.images;

import android.graphics.Bitmap;
import androidx.core.app.NotificationCompat;
import j0.k.b;
import kotlin.Pair;
import rx.Observable;

/* JADX INFO: compiled from: MGImagesBitmap.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class MGImagesBitmap$getBitmaps$1<T, R> implements b<MGImagesBitmap$ImageRequest, Observable<? extends Pair<? extends String, ? extends Bitmap>>> {
    public static final MGImagesBitmap$getBitmaps$1 INSTANCE = new MGImagesBitmap$getBitmaps$1();

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends Pair<? extends String, ? extends Bitmap>> call(MGImagesBitmap$ImageRequest mGImagesBitmap$ImageRequest) {
        return call2(mGImagesBitmap$ImageRequest);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends Pair<String, Bitmap>> call2(MGImagesBitmap$ImageRequest mGImagesBitmap$ImageRequest) {
        return MGImagesBitmap.INSTANCE.getBitmap(mGImagesBitmap$ImageRequest.getImageUri(), mGImagesBitmap$ImageRequest.getRoundAsCircle()).G(new MGImagesBitmap$getBitmaps$1$1(mGImagesBitmap$ImageRequest));
    }
}
