package com.discord.utilities.voice;

import android.graphics.Bitmap;
import androidx.core.app.NotificationCompat;
import com.discord.stores.StoreApplicationStreaming$ActiveApplicationStream;
import com.discord.utilities.images.ImageEncoder;
import d0.z.d.m;
import j0.k.b;
import j0.l.a.c;
import rx.Observable;

/* JADX INFO: compiled from: ScreenShareManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ScreenShareManager$uploadScreenSharePreviews$1<T, R> implements b<Bitmap, Observable<? extends Void>> {
    public final /* synthetic */ ScreenShareManager this$0;

    public ScreenShareManager$uploadScreenSharePreviews$1(ScreenShareManager screenShareManager) {
        this.this$0 = screenShareManager;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends Void> call(Bitmap bitmap) {
        return call2(bitmap);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends Void> call2(Bitmap bitmap) {
        ScreenShareManager$State screenShareManager$StateAccess$getPreviousState$p = ScreenShareManager.access$getPreviousState$p(this.this$0);
        StoreApplicationStreaming$ActiveApplicationStream activeStream = screenShareManager$StateAccess$getPreviousState$p != null ? screenShareManager$StateAccess$getPreviousState$p.getActiveStream() : null;
        if (activeStream == null) {
            return c.k;
        }
        ImageEncoder imageEncoderAccess$getImageEncoder$p = ScreenShareManager.access$getImageEncoder$p(this.this$0);
        m.checkNotNullExpressionValue(bitmap, "thumbnailBitmap");
        return ScreenShareManager.access$getRestAPI$p(this.this$0).postStreamPreview(activeStream.getStream().getEncodedStreamKey(), imageEncoderAccess$getImageEncoder$p.encodeBitmapAsJpegDataUrl(bitmap, 92));
    }
}
