package androidx.core.graphics.drawable;

import android.graphics.Bitmap;
import android.graphics.drawable.Icon;
import android.net.Uri;
import androidx.annotation.RequiresApi;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: Icon.kt */
/* JADX INFO: loaded from: classes.dex */
public final class IconKt {
    @RequiresApi(26)
    public static final Icon toAdaptiveIcon(Bitmap bitmap) {
        C12238m.checkNotNullParameter(bitmap, "<this>");
        Icon iconCreateWithAdaptiveBitmap = Icon.createWithAdaptiveBitmap(bitmap);
        C12238m.checkNotNullExpressionValue(iconCreateWithAdaptiveBitmap, "createWithAdaptiveBitmap(this)");
        return iconCreateWithAdaptiveBitmap;
    }

    @RequiresApi(26)
    public static final Icon toIcon(Bitmap bitmap) {
        C12238m.checkNotNullParameter(bitmap, "<this>");
        Icon iconCreateWithBitmap = Icon.createWithBitmap(bitmap);
        C12238m.checkNotNullExpressionValue(iconCreateWithBitmap, "createWithBitmap(this)");
        return iconCreateWithBitmap;
    }

    @RequiresApi(26)
    public static final Icon toIcon(Uri uri) {
        C12238m.checkNotNullParameter(uri, "<this>");
        Icon iconCreateWithContentUri = Icon.createWithContentUri(uri);
        C12238m.checkNotNullExpressionValue(iconCreateWithContentUri, "createWithContentUri(this)");
        return iconCreateWithContentUri;
    }

    @RequiresApi(26)
    public static final Icon toIcon(byte[] bArr) {
        C12238m.checkNotNullParameter(bArr, "<this>");
        Icon iconCreateWithData = Icon.createWithData(bArr, 0, bArr.length);
        C12238m.checkNotNullExpressionValue(iconCreateWithData, "createWithData(this, 0, size)");
        return iconCreateWithData;
    }
}
