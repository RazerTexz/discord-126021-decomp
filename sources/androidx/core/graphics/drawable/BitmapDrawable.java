package androidx.core.graphics.drawable;

import android.content.res.Resources;
import android.graphics.Bitmap;
import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: androidx.core.graphics.drawable.BitmapDrawableKt, reason: use source file name */
/* JADX INFO: compiled from: BitmapDrawable.kt */
/* JADX INFO: loaded from: classes.dex */
public final class BitmapDrawable {
    public static final android.graphics.drawable.BitmapDrawable toDrawable(Bitmap bitmap, Resources resources) {
        Intrinsics3.checkNotNullParameter(bitmap, "<this>");
        Intrinsics3.checkNotNullParameter(resources, "resources");
        return new android.graphics.drawable.BitmapDrawable(resources, bitmap);
    }
}
