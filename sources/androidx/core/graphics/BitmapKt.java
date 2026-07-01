package androidx.core.graphics;

import android.graphics.Bitmap;
import android.graphics.Bitmap$Config;
import android.graphics.Canvas;
import android.graphics.ColorSpace;
import android.graphics.ColorSpace$Named;
import android.graphics.Point;
import android.graphics.PointF;
import androidx.annotation.ColorInt;
import androidx.annotation.RequiresApi;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: Bitmap.kt */
/* JADX INFO: loaded from: classes.dex */
public final class BitmapKt {
    public static final Bitmap applyCanvas(Bitmap bitmap, Function1<? super Canvas, Unit> function1) {
        m.checkNotNullParameter(bitmap, "<this>");
        m.checkNotNullParameter(function1, "block");
        function1.invoke(new Canvas(bitmap));
        return bitmap;
    }

    public static final boolean contains(Bitmap bitmap, Point point) {
        int i;
        m.checkNotNullParameter(bitmap, "<this>");
        m.checkNotNullParameter(point, "p");
        int i2 = point.x;
        return i2 >= 0 && i2 < bitmap.getWidth() && (i = point.y) >= 0 && i < bitmap.getHeight();
    }

    public static final Bitmap createBitmap(int i, int i2, Bitmap$Config bitmap$Config) {
        m.checkNotNullParameter(bitmap$Config, "config");
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i, i2, bitmap$Config);
        m.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(width, height, config)");
        return bitmapCreateBitmap;
    }

    public static /* synthetic */ Bitmap createBitmap$default(int i, int i2, Bitmap$Config bitmap$Config, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            bitmap$Config = Bitmap$Config.ARGB_8888;
        }
        m.checkNotNullParameter(bitmap$Config, "config");
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i, i2, bitmap$Config);
        m.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(width, height, config)");
        return bitmapCreateBitmap;
    }

    public static final int get(Bitmap bitmap, int i, int i2) {
        m.checkNotNullParameter(bitmap, "<this>");
        return bitmap.getPixel(i, i2);
    }

    public static final Bitmap scale(Bitmap bitmap, int i, int i2, boolean z2) {
        m.checkNotNullParameter(bitmap, "<this>");
        Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmap, i, i2, z2);
        m.checkNotNullExpressionValue(bitmapCreateScaledBitmap, "createScaledBitmap(this, width, height, filter)");
        return bitmapCreateScaledBitmap;
    }

    public static /* synthetic */ Bitmap scale$default(Bitmap bitmap, int i, int i2, boolean z2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z2 = true;
        }
        m.checkNotNullParameter(bitmap, "<this>");
        Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmap, i, i2, z2);
        m.checkNotNullExpressionValue(bitmapCreateScaledBitmap, "createScaledBitmap(this, width, height, filter)");
        return bitmapCreateScaledBitmap;
    }

    public static final void set(Bitmap bitmap, int i, int i2, @ColorInt int i3) {
        m.checkNotNullParameter(bitmap, "<this>");
        bitmap.setPixel(i, i2, i3);
    }

    public static final boolean contains(Bitmap bitmap, PointF pointF) {
        m.checkNotNullParameter(bitmap, "<this>");
        m.checkNotNullParameter(pointF, "p");
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
    public static final Bitmap createBitmap(int i, int i2, Bitmap$Config bitmap$Config, boolean z2, ColorSpace colorSpace) {
        m.checkNotNullParameter(bitmap$Config, "config");
        m.checkNotNullParameter(colorSpace, "colorSpace");
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i, i2, bitmap$Config, z2, colorSpace);
        m.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(width, height, config, hasAlpha, colorSpace)");
        return bitmapCreateBitmap;
    }

    public static /* synthetic */ Bitmap createBitmap$default(int i, int i2, Bitmap$Config bitmap$Config, boolean z2, ColorSpace colorSpace, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            bitmap$Config = Bitmap$Config.ARGB_8888;
        }
        if ((i3 & 8) != 0) {
            z2 = true;
        }
        if ((i3 & 16) != 0) {
            colorSpace = ColorSpace.get(ColorSpace$Named.SRGB);
            m.checkNotNullExpressionValue(colorSpace, "get(ColorSpace.Named.SRGB)");
        }
        m.checkNotNullParameter(bitmap$Config, "config");
        m.checkNotNullParameter(colorSpace, "colorSpace");
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i, i2, bitmap$Config, z2, colorSpace);
        m.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(width, height, config, hasAlpha, colorSpace)");
        return bitmapCreateBitmap;
    }
}
