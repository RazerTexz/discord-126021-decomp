package androidx.core.graphics.drawable;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import androidx.annotation.Px;
import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: androidx.core.graphics.drawable.DrawableKt, reason: use source file name */
/* JADX INFO: compiled from: Drawable.kt */
/* JADX INFO: loaded from: classes.dex */
public final class Drawable {
    public static final Bitmap toBitmap(android.graphics.drawable.Drawable drawable, @Px int i, @Px int i2, Bitmap.Config config) {
        Intrinsics3.checkNotNullParameter(drawable, "<this>");
        if ((drawable instanceof BitmapDrawable) && (config == null || ((BitmapDrawable) drawable).getBitmap().getConfig() == config)) {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
            if (i == bitmapDrawable.getIntrinsicWidth() && i2 == bitmapDrawable.getIntrinsicHeight()) {
                Bitmap bitmap = bitmapDrawable.getBitmap();
                Intrinsics3.checkNotNullExpressionValue(bitmap, "bitmap");
                return bitmap;
            }
            Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmapDrawable.getBitmap(), i, i2, true);
            Intrinsics3.checkNotNullExpressionValue(bitmapCreateScaledBitmap, "createScaledBitmap(bitmap, width, height, true)");
            return bitmapCreateScaledBitmap;
        }
        Rect bounds = drawable.getBounds();
        Intrinsics3.checkNotNullExpressionValue(bounds, "bounds");
        int i3 = bounds.left;
        int i4 = bounds.top;
        int i5 = bounds.right;
        int i6 = bounds.bottom;
        if (config == null) {
            config = Bitmap.Config.ARGB_8888;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i, i2, config);
        drawable.setBounds(0, 0, i, i2);
        drawable.draw(new Canvas(bitmapCreateBitmap));
        drawable.setBounds(i3, i4, i5, i6);
        Intrinsics3.checkNotNullExpressionValue(bitmapCreateBitmap, "bitmap");
        return bitmapCreateBitmap;
    }

    public static /* synthetic */ Bitmap toBitmap$default(android.graphics.drawable.Drawable drawable, int i, int i2, Bitmap.Config config, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = drawable.getIntrinsicWidth();
        }
        if ((i3 & 2) != 0) {
            i2 = drawable.getIntrinsicHeight();
        }
        if ((i3 & 4) != 0) {
            config = null;
        }
        return toBitmap(drawable, i, i2, config);
    }

    public static final void updateBounds(android.graphics.drawable.Drawable drawable, @Px int i, @Px int i2, @Px int i3, @Px int i4) {
        Intrinsics3.checkNotNullParameter(drawable, "<this>");
        drawable.setBounds(i, i2, i3, i4);
    }

    public static /* synthetic */ void updateBounds$default(android.graphics.drawable.Drawable drawable, int i, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = drawable.getBounds().left;
        }
        if ((i5 & 2) != 0) {
            i2 = drawable.getBounds().top;
        }
        if ((i5 & 4) != 0) {
            i3 = drawable.getBounds().right;
        }
        if ((i5 & 8) != 0) {
            i4 = drawable.getBounds().bottom;
        }
        updateBounds(drawable, i, i2, i3, i4);
    }
}
