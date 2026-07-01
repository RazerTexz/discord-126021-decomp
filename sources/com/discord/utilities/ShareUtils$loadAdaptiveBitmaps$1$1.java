package com.discord.utilities;

import android.graphics.Bitmap;
import androidx.core.app.NotificationCompat;
import com.discord.utilities.colors.RepresentativeColors;
import com.discord.utilities.rx.ObservableExtensionsKt$filterNull$1;
import com.discord.utilities.rx.ObservableExtensionsKt$filterNull$2;
import d0.z.d.m;
import j0.k.b;
import j0.l.e.k;
import java.util.Map$Entry;
import java.util.concurrent.TimeUnit;
import kotlin.Pair;
import rx.Observable;

/* JADX INFO: compiled from: ShareUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ShareUtils$loadAdaptiveBitmaps$1$1<T, R> implements b<Map$Entry<? extends String, ? extends Bitmap>, Observable<? extends Pair<? extends String, ? extends Bitmap>>> {
    public final /* synthetic */ RepresentativeColors $representativeColors;
    public final /* synthetic */ ShareUtils$loadAdaptiveBitmaps$1 this$0;

    public ShareUtils$loadAdaptiveBitmaps$1$1(ShareUtils$loadAdaptiveBitmaps$1 shareUtils$loadAdaptiveBitmaps$1, RepresentativeColors representativeColors) {
        this.this$0 = shareUtils$loadAdaptiveBitmaps$1;
        this.$representativeColors = representativeColors;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends Pair<? extends String, ? extends Bitmap>> call(Map$Entry<? extends String, ? extends Bitmap> map$Entry) {
        return call2((Map$Entry<String, Bitmap>) map$Entry);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends Pair<String, Bitmap>> call2(Map$Entry<String, Bitmap> map$Entry) {
        Observable<R> kVar;
        String key = map$Entry.getKey();
        Bitmap value = map$Entry.getValue();
        if (value.getWidth() <= 0 || value.getHeight() <= 0 || value.getPixel(0, 0) != 0) {
            kVar = new k(0);
        } else {
            RepresentativeColors.handleBitmap$default(this.$representativeColors, key, value, null, 4, null);
            Observable<R> observableG = this.$representativeColors.observeRepresentativeColor(key).y(ObservableExtensionsKt$filterNull$1.INSTANCE).G(ObservableExtensionsKt$filterNull$2.INSTANCE);
            m.checkNotNullExpressionValue(observableG, "filter { it != null }.map { it!! }");
            kVar = observableG.z().c0(2L, TimeUnit.SECONDS).M(ShareUtils$loadAdaptiveBitmaps$1$1$representativeColor$1.INSTANCE);
        }
        return kVar.G(new ShareUtils$loadAdaptiveBitmaps$1$1$1(this, key, value));
    }
}
