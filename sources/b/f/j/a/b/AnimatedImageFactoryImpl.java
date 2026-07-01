package b.f.j.a.b;

import android.graphics.Bitmap;
import b.f.j.a.a.AnimatedImage;
import b.f.j.a.a.AnimatedImageResultBuilder;
import b.f.j.a.c.AnimatedDrawableBackendProvider;
import b.f.j.d.ImageDecodeOptions;
import b.f.j.j.CloseableAnimatedImage;
import b.f.j.j.CloseableImage;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import java.util.Objects;

/* JADX INFO: renamed from: b.f.j.a.b.e, reason: use source file name */
/* JADX INFO: compiled from: AnimatedImageFactoryImpl.java */
/* JADX INFO: loaded from: classes2.dex */
public class AnimatedImageFactoryImpl implements AnimatedImageFactory {
    public static AnimatedImageDecoder a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static AnimatedImageDecoder f547b;
    public final AnimatedDrawableBackendProvider c;
    public final PlatformBitmapFactory d;

    static {
        AnimatedImageDecoder animatedImageDecoder;
        AnimatedImageDecoder animatedImageDecoder2 = null;
        try {
            animatedImageDecoder = (AnimatedImageDecoder) Class.forName("com.facebook.animated.gif.GifImage").newInstance();
        } catch (Throwable unused) {
            animatedImageDecoder = null;
        }
        a = animatedImageDecoder;
        try {
            animatedImageDecoder2 = (AnimatedImageDecoder) Class.forName("com.facebook.animated.webp.WebPImage").newInstance();
        } catch (Throwable unused2) {
        }
        f547b = animatedImageDecoder2;
    }

    public AnimatedImageFactoryImpl(AnimatedDrawableBackendProvider animatedDrawableBackendProvider, PlatformBitmapFactory platformBitmapFactory) {
        this.c = animatedDrawableBackendProvider;
        this.d = platformBitmapFactory;
    }

    public final CloseableImage a(ImageDecodeOptions imageDecodeOptions, AnimatedImage animatedImage, Bitmap.Config config) {
        try {
            Objects.requireNonNull(imageDecodeOptions);
            AnimatedImageResultBuilder animatedImageResultBuilder = new AnimatedImageResultBuilder(animatedImage);
            animatedImageResultBuilder.f545b = CloseableReference.n(null);
            animatedImageResultBuilder.d = 0;
            animatedImageResultBuilder.c = CloseableReference.q(null);
            animatedImageResultBuilder.e = null;
            return new CloseableAnimatedImage(animatedImageResultBuilder.a());
        } finally {
            Class<CloseableReference> cls = CloseableReference.j;
            CloseableReference.t(null);
        }
    }
}
