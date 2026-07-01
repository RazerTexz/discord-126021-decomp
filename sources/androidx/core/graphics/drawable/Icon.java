package androidx.core.graphics.drawable;

import android.graphics.Bitmap;
import android.net.Uri;
import androidx.annotation.RequiresApi;
import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: androidx.core.graphics.drawable.IconKt, reason: use source file name */
/* JADX INFO: compiled from: Icon.kt */
/* JADX INFO: loaded from: classes.dex */
public final class Icon {
    @RequiresApi(26)
    public static final android.graphics.drawable.Icon toAdaptiveIcon(Bitmap bitmap) {
        Intrinsics3.checkNotNullParameter(bitmap, "<this>");
        android.graphics.drawable.Icon iconCreateWithAdaptiveBitmap = android.graphics.drawable.Icon.createWithAdaptiveBitmap(bitmap);
        Intrinsics3.checkNotNullExpressionValue(iconCreateWithAdaptiveBitmap, "createWithAdaptiveBitmap(this)");
        return iconCreateWithAdaptiveBitmap;
    }

    @RequiresApi(26)
    public static final android.graphics.drawable.Icon toIcon(Bitmap bitmap) {
        Intrinsics3.checkNotNullParameter(bitmap, "<this>");
        android.graphics.drawable.Icon iconCreateWithBitmap = android.graphics.drawable.Icon.createWithBitmap(bitmap);
        Intrinsics3.checkNotNullExpressionValue(iconCreateWithBitmap, "createWithBitmap(this)");
        return iconCreateWithBitmap;
    }

    @RequiresApi(26)
    public static final android.graphics.drawable.Icon toIcon(Uri uri) {
        Intrinsics3.checkNotNullParameter(uri, "<this>");
        android.graphics.drawable.Icon iconCreateWithContentUri = android.graphics.drawable.Icon.createWithContentUri(uri);
        Intrinsics3.checkNotNullExpressionValue(iconCreateWithContentUri, "createWithContentUri(this)");
        return iconCreateWithContentUri;
    }

    @RequiresApi(26)
    public static final android.graphics.drawable.Icon toIcon(byte[] bArr) {
        Intrinsics3.checkNotNullParameter(bArr, "<this>");
        android.graphics.drawable.Icon iconCreateWithData = android.graphics.drawable.Icon.createWithData(bArr, 0, bArr.length);
        Intrinsics3.checkNotNullExpressionValue(iconCreateWithData, "createWithData(this, 0, size)");
        return iconCreateWithData;
    }
}
