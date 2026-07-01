package androidx.core.graphics;

import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import android.graphics.ImageDecoder$ImageInfo;
import android.graphics.ImageDecoder$Source;
import android.graphics.drawable.Drawable;
import androidx.annotation.RequiresApi;
import d0.z.d.m;
import java.io.IOException;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: ImageDecoder.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ImageDecoderKt {
    @RequiresApi(28)
    public static final Bitmap decodeBitmap(ImageDecoder$Source imageDecoder$Source, Function3<? super ImageDecoder, ? super ImageDecoder$ImageInfo, ? super ImageDecoder$Source, Unit> function3) throws IOException {
        m.checkNotNullParameter(imageDecoder$Source, "<this>");
        m.checkNotNullParameter(function3, "action");
        Bitmap bitmapDecodeBitmap = ImageDecoder.decodeBitmap(imageDecoder$Source, new ImageDecoderKt$decodeBitmap$1(function3));
        m.checkNotNullExpressionValue(bitmapDecodeBitmap, "crossinline action: ImageDecoder.(info: ImageInfo, source: Source) -> Unit\n): Bitmap {\n    return ImageDecoder.decodeBitmap(this) { decoder, info, source ->\n        decoder.action(info, source)\n    }");
        return bitmapDecodeBitmap;
    }

    @RequiresApi(28)
    public static final Drawable decodeDrawable(ImageDecoder$Source imageDecoder$Source, Function3<? super ImageDecoder, ? super ImageDecoder$ImageInfo, ? super ImageDecoder$Source, Unit> function3) throws IOException {
        m.checkNotNullParameter(imageDecoder$Source, "<this>");
        m.checkNotNullParameter(function3, "action");
        Drawable drawableDecodeDrawable = ImageDecoder.decodeDrawable(imageDecoder$Source, new ImageDecoderKt$decodeDrawable$1(function3));
        m.checkNotNullExpressionValue(drawableDecodeDrawable, "crossinline action: ImageDecoder.(info: ImageInfo, source: Source) -> Unit\n): Drawable {\n    return ImageDecoder.decodeDrawable(this) { decoder, info, source ->\n        decoder.action(info, source)\n    }");
        return drawableDecodeDrawable;
    }
}
