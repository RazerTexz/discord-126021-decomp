package androidx.core.graphics;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorSpace;
import android.graphics.Point;
import android.graphics.PointF;
import androidx.annotation.ColorInt;
import androidx.annotation.RequiresApi;
import com.discord.models.domain.ModelAuditLogEntry;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: Bitmap.kt */
/* JADX INFO: loaded from: classes.dex */
public final class BitmapKt {
    public static final Bitmap applyCanvas(Bitmap bitmap, Function1<? super Canvas, Unit> function1) {
        C12238m.checkNotNullParameter(bitmap, "<this>");
        C12238m.checkNotNullParameter(function1, "block");
        function1.invoke(new Canvas(bitmap));
        return bitmap;
    }

    public static final boolean contains(Bitmap bitmap, Point point) {
        int i;
        C12238m.checkNotNullParameter(bitmap, "<this>");
        C12238m.checkNotNullParameter(point, "p");
        int i2 = point.x;
        return i2 >= 0 && i2 < bitmap.getWidth() && (i = point.y) >= 0 && i < bitmap.getHeight();
    }

    public static final Bitmap createBitmap(int i, int i2, Bitmap.Config config) {
        C12238m.checkNotNullParameter(config, "config");
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i, i2, config);
        C12238m.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(width, height, config)");
        return bitmapCreateBitmap;
    }

    public static /* synthetic */ Bitmap createBitmap$default(int i, int i2, Bitmap.Config config, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            config = Bitmap.Config.ARGB_8888;
        }
        C12238m.checkNotNullParameter(config, "config");
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i, i2, config);
        C12238m.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(width, height, config)");
        return bitmapCreateBitmap;
    }

    public static final int get(Bitmap bitmap, int i, int i2) {
        C12238m.checkNotNullParameter(bitmap, "<this>");
        return bitmap.getPixel(i, i2);
    }

    public static final Bitmap scale(Bitmap bitmap, int i, int i2, boolean z2) {
        C12238m.checkNotNullParameter(bitmap, "<this>");
        Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmap, i, i2, z2);
        C12238m.checkNotNullExpressionValue(bitmapCreateScaledBitmap, "createScaledBitmap(this, width, height, filter)");
        return bitmapCreateScaledBitmap;
    }

    public static /* synthetic */ Bitmap scale$default(Bitmap bitmap, int i, int i2, boolean z2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z2 = true;
        }
        C12238m.checkNotNullParameter(bitmap, "<this>");
        Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmap, i, i2, z2);
        C12238m.checkNotNullExpressionValue(bitmapCreateScaledBitmap, "createScaledBitmap(this, width, height, filter)");
        return bitmapCreateScaledBitmap;
    }

    public static final void set(Bitmap bitmap, int i, int i2, @ColorInt int i3) {
        C12238m.checkNotNullParameter(bitmap, "<this>");
        bitmap.setPixel(i, i2, i3);
    }

    public static final boolean contains(Bitmap bitmap, PointF pointF) {
        C12238m.checkNotNullParameter(bitmap, "<this>");
        C12238m.checkNotNullParameter(pointF, "p");
        float f = pointF.x;
        if (f >= 0.0f && f < bitmap.getWidth()) {
            float f2 = pointF.y;
            if (f2 >= 0.0f && f2 < bitmap.getHeight()) {
                return true;
            }
        }
        return false;
    }

    @RequiresApi(26)
    public static final Bitmap createBitmap(int i, int i2, Bitmap.Config config, boolean z2, ColorSpace colorSpace) {
        C12238m.checkNotNullParameter(config, "config");
        C12238m.checkNotNullParameter(colorSpace, "colorSpace");
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i, i2, config, z2, colorSpace);
        C12238m.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(width, height, config, hasAlpha, colorSpace)");
        return bitmapCreateBitmap;
    }

    public static /* synthetic */ Bitmap createBitmap$default(int i, int i2, Bitmap.Config config, boolean z2, ColorSpace colorSpace, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            config = Bitmap.Config.ARGB_8888;
        }
        if ((i3 & 8) != 0) {
            z2 = true;
        }
        if ((i3 & 16) != 0) {
            colorSpace = ColorSpace.get(ColorSpace.Named.SRGB);
            C12238m.checkNotNullExpressionValue(colorSpace, "get(ColorSpace.Named.SRGB)");
        }
        C12238m.checkNotNullParameter(config, "config");
        C12238m.checkNotNullParameter(colorSpace, "colorSpace");
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i, i2, config, z2, colorSpace);
        C12238m.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(width, height, config, hasAlpha, colorSpace)");
        return bitmapCreateBitmap;
    }
}
