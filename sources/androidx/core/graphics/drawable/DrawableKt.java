package androidx.core.graphics.drawable;

import android.graphics.Bitmap;
import android.graphics.Bitmap$Config;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.annotation.Px;
import d0.z.d.m;

/* JADX INFO: compiled from: Drawable.kt */
/* JADX INFO: loaded from: classes.dex */
public final class DrawableKt {
    public static final Bitmap toBitmap(Drawable drawable, @Px int i, @Px int i2, Bitmap$Config bitmap$Config) {
        m.checkNotNullParameter(drawable, "<this>");
        if ((drawable instanceof BitmapDrawable) && (bitmap$Config == null || ((BitmapDrawable) drawable).getBitmap().getConfig() == bitmap$Config)) {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
            if (i == bitmapDrawable.getIntrinsicWidth() && i2 == bitmapDrawable.getIntrinsicHeight()) {
                Bitmap bitmap = bitmapDrawable.getBitmap();
                m.checkNotNullExpressionValue(bitmap, "bitmap");
                return bitmap;
            }
            Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmapDrawable.getBitmap(), i, i2, true);
            m.checkNotNullExpressionValue(bitmapCreateScaledBitmap, "createScaledBitmap(bitmap, width, height, true)");
            return bitmapCreateScaledBitmap;
        }
        Rect bounds = drawable.getBounds();
        m.checkNotNullExpressionValue(bounds, "bounds");
        int i3 = bounds.left;
        int i4 = bounds.top;
        int i5 = bounds.right;
        int i6 = bounds.bottom;
        if (bitmap$Config == null) {
            bitmap$Config = Bitmap$Config.ARGB_8888;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i, i2, bitmap$Config);
        drawable.setBounds(0, 0, i, i2);
        drawable.draw(new Canvas(bitmapCreateBitmap));
        drawable.setBounds(i3, i4, i5, i6);
        m.checkNotNullExpressionValue(bitmapCreateBitmap, "bitmap");
        return bitmapCreateBitmap;
    }

    public static /* synthetic */ Bitmap toBitmap$default(Drawable drawable, int i, int i2, Bitmap$Config bitmap$Config, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = drawable.getIntrinsicWidth();
        }
        if ((i3 & 2) != 0) {
            i2 = drawable.getIntrinsicHeight();
        }
        if ((i3 & 4) != 0) {
            bitmap$Config = null;
        }
        return toBitmap(drawable, i, i2, bitmap$Config);
    }

    public static final void updateBounds(Drawable drawable, @Px int i, @Px int i2, @Px int i3, @Px int i4) {
        m.checkNotNullParameter(drawable, "<this>");
        drawable.setBounds(i, i2, i3, i4);
    }

    public static /* synthetic */ void updateBounds$default(Drawable drawable, int i, int i2, int i3, int i4, int i5, Object obj) {
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
