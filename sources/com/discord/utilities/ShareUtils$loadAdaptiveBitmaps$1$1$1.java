package com.discord.utilities;

import android.graphics.Bitmap;
import androidx.core.app.NotificationCompat;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.images.MGImages;
import d0.o;
import j0.k.b;
import kotlin.Pair;

/* JADX INFO: compiled from: ShareUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ShareUtils$loadAdaptiveBitmaps$1$1$1<T, R> implements b<Integer, Pair<? extends String, ? extends Bitmap>> {
    public final /* synthetic */ Bitmap $bitmap;
    public final /* synthetic */ String $url;
    public final /* synthetic */ ShareUtils$loadAdaptiveBitmaps$1$1 this$0;

    public ShareUtils$loadAdaptiveBitmaps$1$1$1(ShareUtils$loadAdaptiveBitmaps$1$1 shareUtils$loadAdaptiveBitmaps$1$1, String str, Bitmap bitmap) {
        this.this$0 = shareUtils$loadAdaptiveBitmaps$1$1;
        this.$url = str;
        this.$bitmap = bitmap;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Pair<? extends String, ? extends Bitmap> call(Integer num) {
        return call2(num);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Pair<String, Bitmap> call2(Integer num) {
        String str = this.$url;
        MGImages mGImages = MGImages.INSTANCE;
        Bitmap bitmap = this.$bitmap;
        ShareUtils$loadAdaptiveBitmaps$1 shareUtils$loadAdaptiveBitmaps$1 = this.this$0.this$0;
        int i = shareUtils$loadAdaptiveBitmaps$1.$iconSize;
        int i2 = shareUtils$loadAdaptiveBitmaps$1.$fullBitmapSize;
        return o.to(str, mGImages.centerBitmapInTransparentBitmap(bitmap, i, i, i2, i2, shareUtils$loadAdaptiveBitmaps$1.$fillMargins, num != null ? num.intValue() : 0));
    }
}
