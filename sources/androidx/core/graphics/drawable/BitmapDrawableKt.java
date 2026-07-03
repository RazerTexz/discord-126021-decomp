package androidx.core.graphics.drawable;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: BitmapDrawable.kt */
/* JADX INFO: loaded from: classes.dex */
public final class BitmapDrawableKt {
    public static final BitmapDrawable toDrawable(Bitmap bitmap, Resources resources) {
        C12238m.checkNotNullParameter(bitmap, "<this>");
        C12238m.checkNotNullParameter(resources, "resources");
        return new BitmapDrawable(resources, bitmap);
    }
}
