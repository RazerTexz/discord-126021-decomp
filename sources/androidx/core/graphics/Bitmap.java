package androidx.core.graphics;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorSpace;
import android.graphics.Point;
import android.graphics.PointF;
import androidx.annotation.ColorInt;
import androidx.annotation.RequiresApi;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: androidx.core.graphics.BitmapKt, reason: use source file name */
/* JADX INFO: compiled from: Bitmap.kt */
/* JADX INFO: loaded from: classes.dex */
public final class Bitmap {
    public static final android.graphics.Bitmap applyCanvas(android.graphics.Bitmap bitmap, Function1<? super Canvas, Unit> function1) {
        Intrinsics3.checkNotNullParameter(bitmap, "<this>");
        Intrinsics3.checkNotNullParameter(function1, "block");
        function1.invoke(new Canvas(bitmap));
        return bitmap;
    }

    public static final boolean contains(android.graphics.Bitmap bitmap, Point point) {
        int i;
        Intrinsics3.checkNotNullParameter(bitmap, "<this>");
        Intrinsics3.checkNotNullParameter(point, "p");
        int i2 = point.x;
        return i2 >= 0 && i2 < bitmap.getWidth() && (i = point.y) >= 0 && i < bitmap.getHeight();
    }

    public static final android.graphics.Bitmap createBitmap(int i, int i2, Bitmap.Config config) {
        Intrinsics3.checkNotNullParameter(config, "config");
        android.graphics.Bitmap bitmapCreateBitmap = android.graphics.Bitmap.createBitmap(i, i2, config);
        Intrinsics3.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(width, height, config)");
        return bitmapCreateBitmap;
    }

    public static /* synthetic */ android.graphics.Bitmap createBitmap$default(int i, int i2, Bitmap.Config config, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            config = Bitmap.Config.ARGB_8888;
        }
        Intrinsics3.checkNotNullParameter(config, "config");
        android.graphics.Bitmap bitmapCreateBitmap = android.graphics.Bitmap.createBitmap(i, i2, config);
        Intrinsics3.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(width, height, config)");
        return bitmapCreateBitmap;
    }

    public static final int get(android.graphics.Bitmap bitmap, int i, int i2) {
        Intrinsics3.checkNotNullParameter(bitmap, "<this>");
        return bitmap.getPixel(i, i2);
    }

    public static final android.graphics.Bitmap scale(android.graphics.Bitmap bitmap, int i, int i2, boolean z2) {
        Intrinsics3.checkNotNullParameter(bitmap, "<this>");
        android.graphics.Bitmap bitmapCreateScaledBitmap = android.graphics.Bitmap.createScaledBitmap(bitmap, i, i2, z2);
        Intrinsics3.checkNotNullExpressionValue(bitmapCreateScaledBitmap, "createScaledBitmap(this, width, height, filter)");
        return bitmapCreateScaledBitmap;
    }

    public static /* synthetic */ android.graphics.Bitmap scale$default(android.graphics.Bitmap bitmap, int i, int i2, boolean z2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z2 = true;
        }
        Intrinsics3.checkNotNullParameter(bitmap, "<this>");
        android.graphics.Bitmap bitmapCreateScaledBitmap = android.graphics.Bitmap.createScaledBitmap(bitmap, i, i2, z2);
        Intrinsics3.checkNotNullExpressionValue(bitmapCreateScaledBitmap, "createScaledBitmap(this, width, height, filter)");
        return bitmapCreateScaledBitmap;
    }

    public static final void set(android.graphics.Bitmap bitmap, int i, int i2, @ColorInt int i3) {
        Intrinsics3.checkNotNullParameter(bitmap, "<this>");
        bitmap.setPixel(i, i2, i3);
    }

    public static final boolean contains(android.graphics.Bitmap bitmap, PointF pointF) {
        Intrinsics3.checkNotNullParameter(bitmap, "<this>");
        Intrinsics3.checkNotNullParameter(pointF, "p");
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
    public static final android.graphics.Bitmap createBitmap(int i, int i2, Bitmap.Config config, boolean z2, ColorSpace colorSpace) {
        Intrinsics3.checkNotNullParameter(config, "config");
        Intrinsics3.checkNotNullParameter(colorSpace, "colorSpace");
        android.graphics.Bitmap bitmapCreateBitmap = android.graphics.Bitmap.createBitmap(i, i2, config, z2, colorSpace);
        Intrinsics3.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(width, height, config, hasAlpha, colorSpace)");
        return bitmapCreateBitmap;
    }

    public static /* synthetic */ android.graphics.Bitmap createBitmap$default(int i, int i2, Bitmap.Config config, boolean z2, ColorSpace colorSpace, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            config = Bitmap.Config.ARGB_8888;
        }
        if ((i3 & 8) != 0) {
            z2 = true;
        }
        if ((i3 & 16) != 0) {
            colorSpace = ColorSpace.get(ColorSpace.Named.SRGB);
            Intrinsics3.checkNotNullExpressionValue(colorSpace, "get(ColorSpace.Named.SRGB)");
        }
        Intrinsics3.checkNotNullParameter(config, "config");
        Intrinsics3.checkNotNullParameter(colorSpace, "colorSpace");
        android.graphics.Bitmap bitmapCreateBitmap = android.graphics.Bitmap.createBitmap(i, i2, config, z2, colorSpace);
        Intrinsics3.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(width, height, config, hasAlpha, colorSpace)");
        return bitmapCreateBitmap;
    }
}
