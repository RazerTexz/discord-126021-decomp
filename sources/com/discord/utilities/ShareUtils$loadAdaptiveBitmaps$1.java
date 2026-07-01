package com.discord.utilities;

import androidx.core.app.NotificationCompat;
import com.discord.utilities.colors.RepresentativeColors;
import com.discord.utilities.images.MGImagesBitmap$CloseableBitmaps;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.m;
import j0.k.b;
import rx.Observable;

/* JADX INFO: compiled from: ShareUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ShareUtils$loadAdaptiveBitmaps$1<T, R> implements b<MGImagesBitmap$CloseableBitmaps, Observable<? extends MGImagesBitmap$CloseableBitmaps>> {
    public final /* synthetic */ int $fillMargins;
    public final /* synthetic */ int $fullBitmapSize;
    public final /* synthetic */ int $iconSize;

    public ShareUtils$loadAdaptiveBitmaps$1(int i, int i2, int i3) {
        this.$iconSize = i;
        this.$fullBitmapSize = i2;
        this.$fillMargins = i3;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends MGImagesBitmap$CloseableBitmaps> call(MGImagesBitmap$CloseableBitmaps mGImagesBitmap$CloseableBitmaps) {
        return call2(mGImagesBitmap$CloseableBitmaps);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends MGImagesBitmap$CloseableBitmaps> call2(MGImagesBitmap$CloseableBitmaps mGImagesBitmap$CloseableBitmaps) {
        Observable<R> observableN = Observable.B(mGImagesBitmap$CloseableBitmaps.entrySet()).n(new ShareUtils$loadAdaptiveBitmaps$1$1(this, new RepresentativeColors()));
        m.checkNotNullExpressionValue(observableN, "Observable.from(iconBitm…        }\n              }");
        return ObservableExtensionsKt.toMap(observableN).G(new ShareUtils$loadAdaptiveBitmaps$1$2(mGImagesBitmap$CloseableBitmaps));
    }
}
