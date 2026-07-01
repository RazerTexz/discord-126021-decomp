package androidx.core.graphics;

import android.graphics.ImageDecoder;
import android.graphics.ImageDecoder$ImageInfo;
import android.graphics.ImageDecoder$OnHeaderDecodedListener;
import android.graphics.ImageDecoder$Source;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: ImageDecoder.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ImageDecoderKt$decodeDrawable$1 implements ImageDecoder$OnHeaderDecodedListener {
    public final /* synthetic */ Function3<ImageDecoder, ImageDecoder$ImageInfo, ImageDecoder$Source, Unit> $action;

    /* JADX WARN: Multi-variable type inference failed */
    public ImageDecoderKt$decodeDrawable$1(Function3<? super ImageDecoder, ? super ImageDecoder$ImageInfo, ? super ImageDecoder$Source, Unit> function3) {
        this.$action = function3;
    }

    @Override // android.graphics.ImageDecoder$OnHeaderDecodedListener
    public final void onHeaderDecoded(ImageDecoder imageDecoder, ImageDecoder$ImageInfo imageDecoder$ImageInfo, ImageDecoder$Source imageDecoder$Source) {
        m.checkNotNullParameter(imageDecoder, "decoder");
        m.checkNotNullParameter(imageDecoder$ImageInfo, "info");
        m.checkNotNullParameter(imageDecoder$Source, "source");
        this.$action.invoke(imageDecoder, imageDecoder$ImageInfo, imageDecoder$Source);
    }
}
