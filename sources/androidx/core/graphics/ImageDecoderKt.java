package androidx.core.graphics;

import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import android.graphics.drawable.Drawable;
import androidx.annotation.RequiresApi;
import java.io.IOException;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: ImageDecoder.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ImageDecoderKt {
    @RequiresApi(28)
    public static final Bitmap decodeBitmap(ImageDecoder.Source source, final Function3<? super ImageDecoder, ? super ImageDecoder.ImageInfo, ? super ImageDecoder.Source, Unit> function3) throws IOException {
        C12238m.checkNotNullParameter(source, "<this>");
        C12238m.checkNotNullParameter(function3, "action");
        Bitmap bitmapDecodeBitmap = ImageDecoder.decodeBitmap(source, new ImageDecoder.OnHeaderDecodedListener() { // from class: androidx.core.graphics.ImageDecoderKt.decodeBitmap.1
            @Override // android.graphics.ImageDecoder.OnHeaderDecodedListener
            public final void onHeaderDecoded(ImageDecoder imageDecoder, ImageDecoder.ImageInfo imageInfo, ImageDecoder.Source source2) {
                C12238m.checkNotNullParameter(imageDecoder, "decoder");
                C12238m.checkNotNullParameter(imageInfo, "info");
                C12238m.checkNotNullParameter(source2, "source");
                function3.invoke(imageDecoder, imageInfo, source2);
            }
        });
        C12238m.checkNotNullExpressionValue(bitmapDecodeBitmap, "crossinline action: ImageDecoder.(info: ImageInfo, source: Source) -> Unit\n): Bitmap {\n    return ImageDecoder.decodeBitmap(this) { decoder, info, source ->\n        decoder.action(info, source)\n    }");
        return bitmapDecodeBitmap;
    }

    @RequiresApi(28)
    public static final Drawable decodeDrawable(ImageDecoder.Source source, final Function3<? super ImageDecoder, ? super ImageDecoder.ImageInfo, ? super ImageDecoder.Source, Unit> function3) throws IOException {
        C12238m.checkNotNullParameter(source, "<this>");
        C12238m.checkNotNullParameter(function3, "action");
        Drawable drawableDecodeDrawable = ImageDecoder.decodeDrawable(source, new ImageDecoder.OnHeaderDecodedListener() { // from class: androidx.core.graphics.ImageDecoderKt.decodeDrawable.1
            @Override // android.graphics.ImageDecoder.OnHeaderDecodedListener
            public final void onHeaderDecoded(ImageDecoder imageDecoder, ImageDecoder.ImageInfo imageInfo, ImageDecoder.Source source2) {
                C12238m.checkNotNullParameter(imageDecoder, "decoder");
                C12238m.checkNotNullParameter(imageInfo, "info");
                C12238m.checkNotNullParameter(source2, "source");
                function3.invoke(imageDecoder, imageInfo, source2);
            }
        });
        C12238m.checkNotNullExpressionValue(drawableDecodeDrawable, "crossinline action: ImageDecoder.(info: ImageInfo, source: Source) -> Unit\n): Drawable {\n    return ImageDecoder.decodeDrawable(this) { decoder, info, source ->\n        decoder.action(info, source)\n    }");
        return drawableDecodeDrawable;
    }
}
