package androidx.core.graphics;

import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import android.graphics.drawable.Drawable;
import androidx.annotation.RequiresApi;
import d0.z.d.Intrinsics3;
import java.io.IOException;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;

/* JADX INFO: renamed from: androidx.core.graphics.ImageDecoderKt, reason: use source file name */
/* JADX INFO: compiled from: ImageDecoder.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ImageDecoder {
    @RequiresApi(28)
    public static final Bitmap decodeBitmap(ImageDecoder.Source source, final Function3<? super android.graphics.ImageDecoder, ? super ImageDecoder.ImageInfo, ? super ImageDecoder.Source, Unit> function3) throws IOException {
        Intrinsics3.checkNotNullParameter(source, "<this>");
        Intrinsics3.checkNotNullParameter(function3, "action");
        Bitmap bitmapDecodeBitmap = android.graphics.ImageDecoder.decodeBitmap(source, new ImageDecoder.OnHeaderDecodedListener() { // from class: androidx.core.graphics.ImageDecoderKt.decodeBitmap.1
            @Override // android.graphics.ImageDecoder.OnHeaderDecodedListener
            public final void onHeaderDecoded(android.graphics.ImageDecoder imageDecoder, ImageDecoder.ImageInfo imageInfo, ImageDecoder.Source source2) {
                Intrinsics3.checkNotNullParameter(imageDecoder, "decoder");
                Intrinsics3.checkNotNullParameter(imageInfo, "info");
                Intrinsics3.checkNotNullParameter(source2, "source");
                function3.invoke(imageDecoder, imageInfo, source2);
            }
        });
        Intrinsics3.checkNotNullExpressionValue(bitmapDecodeBitmap, "crossinline action: ImageDecoder.(info: ImageInfo, source: Source) -> Unit\n): Bitmap {\n    return ImageDecoder.decodeBitmap(this) { decoder, info, source ->\n        decoder.action(info, source)\n    }");
        return bitmapDecodeBitmap;
    }

    @RequiresApi(28)
    public static final Drawable decodeDrawable(ImageDecoder.Source source, final Function3<? super android.graphics.ImageDecoder, ? super ImageDecoder.ImageInfo, ? super ImageDecoder.Source, Unit> function3) throws IOException {
        Intrinsics3.checkNotNullParameter(source, "<this>");
        Intrinsics3.checkNotNullParameter(function3, "action");
        Drawable drawableDecodeDrawable = android.graphics.ImageDecoder.decodeDrawable(source, new ImageDecoder.OnHeaderDecodedListener() { // from class: androidx.core.graphics.ImageDecoderKt.decodeDrawable.1
            @Override // android.graphics.ImageDecoder.OnHeaderDecodedListener
            public final void onHeaderDecoded(android.graphics.ImageDecoder imageDecoder, ImageDecoder.ImageInfo imageInfo, ImageDecoder.Source source2) {
                Intrinsics3.checkNotNullParameter(imageDecoder, "decoder");
                Intrinsics3.checkNotNullParameter(imageInfo, "info");
                Intrinsics3.checkNotNullParameter(source2, "source");
                function3.invoke(imageDecoder, imageInfo, source2);
            }
        });
        Intrinsics3.checkNotNullExpressionValue(drawableDecodeDrawable, "crossinline action: ImageDecoder.(info: ImageInfo, source: Source) -> Unit\n): Drawable {\n    return ImageDecoder.decodeDrawable(this) { decoder, info, source ->\n        decoder.action(info, source)\n    }");
        return drawableDecodeDrawable;
    }
}
