package b.f.j.h;

import android.graphics.Bitmap;
import b.c.a.a0.AnimatableValueParser;
import b.f.i.DefaultImageFormats;
import b.f.i.ImageFormat;
import b.f.i.ImageFormatChecker;
import b.f.j.d.ImageDecodeOptions;
import b.f.j.j.CloseableImage;
import b.f.j.j.CloseableStaticBitmap;
import b.f.j.j.EncodedImage2;
import b.f.j.j.ImmutableQualityInfo;
import b.f.j.j.QualityInfo;
import b.f.j.n.PlatformDecoder;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.decoder.DecodeException;
import java.io.InputStream;
import java.util.Objects;

/* JADX INFO: renamed from: b.f.j.h.a, reason: use source file name */
/* JADX INFO: compiled from: DefaultImageDecoder.java */
/* JADX INFO: loaded from: classes.dex */
public class DefaultImageDecoder implements ImageDecoder2 {
    public final ImageDecoder2 a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageDecoder2 f588b;
    public final PlatformDecoder c;
    public final ImageDecoder2 d = new a();

    /* JADX INFO: renamed from: b.f.j.h.a$a */
    /* JADX INFO: compiled from: DefaultImageDecoder.java */
    public class a implements ImageDecoder2 {
        public a() {
        }

        @Override // b.f.j.h.ImageDecoder2
        public CloseableImage a(EncodedImage2 encodedImage2, int i, QualityInfo qualityInfo, ImageDecodeOptions imageDecodeOptions) {
            encodedImage2.x();
            ImageFormat imageFormat = encodedImage2.l;
            if (imageFormat == DefaultImageFormats.a) {
                CloseableReference<Bitmap> closeableReferenceB = DefaultImageDecoder.this.c.b(encodedImage2, imageDecodeOptions.d, null, i, null);
                try {
                    AnimatableValueParser.g1(null, closeableReferenceB);
                    encodedImage2.x();
                    int i2 = encodedImage2.m;
                    encodedImage2.x();
                    CloseableStaticBitmap closeableStaticBitmap = new CloseableStaticBitmap(closeableReferenceB, qualityInfo, i2, encodedImage2.n);
                    Boolean bool = Boolean.FALSE;
                    if (CloseableImage.j.contains("is_rounded")) {
                        closeableStaticBitmap.k.put("is_rounded", bool);
                    }
                    return closeableStaticBitmap;
                } finally {
                    closeableReferenceB.close();
                }
            }
            if (imageFormat != DefaultImageFormats.c) {
                if (imageFormat != DefaultImageFormats.j) {
                    if (imageFormat != ImageFormat.a) {
                        return DefaultImageDecoder.this.b(encodedImage2, imageDecodeOptions);
                    }
                    throw new DecodeException("unknown image format", encodedImage2);
                }
                ImageDecoder2 imageDecoder2 = DefaultImageDecoder.this.f588b;
                if (imageDecoder2 != null) {
                    return imageDecoder2.a(encodedImage2, i, qualityInfo, imageDecodeOptions);
                }
                throw new DecodeException("Animated WebP support not set up!", encodedImage2);
            }
            DefaultImageDecoder defaultImageDecoder = DefaultImageDecoder.this;
            Objects.requireNonNull(defaultImageDecoder);
            encodedImage2.x();
            if (encodedImage2.o != -1) {
                encodedImage2.x();
                if (encodedImage2.p != -1) {
                    Objects.requireNonNull(imageDecodeOptions);
                    ImageDecoder2 imageDecoder3 = defaultImageDecoder.a;
                    return imageDecoder3 != null ? imageDecoder3.a(encodedImage2, i, qualityInfo, imageDecodeOptions) : defaultImageDecoder.b(encodedImage2, imageDecodeOptions);
                }
            }
            throw new DecodeException("image width or height is incorrect", encodedImage2);
        }
    }

    public DefaultImageDecoder(ImageDecoder2 imageDecoder2, ImageDecoder2 imageDecoder3, PlatformDecoder platformDecoder) {
        this.a = imageDecoder2;
        this.f588b = imageDecoder3;
        this.c = platformDecoder;
    }

    @Override // b.f.j.h.ImageDecoder2
    public CloseableImage a(EncodedImage2 encodedImage2, int i, QualityInfo qualityInfo, ImageDecodeOptions imageDecodeOptions) {
        InputStream inputStreamE;
        Objects.requireNonNull(imageDecodeOptions);
        encodedImage2.x();
        ImageFormat imageFormat = encodedImage2.l;
        if ((imageFormat == null || imageFormat == ImageFormat.a) && (inputStreamE = encodedImage2.e()) != null) {
            encodedImage2.l = ImageFormatChecker.b(inputStreamE);
        }
        return this.d.a(encodedImage2, i, qualityInfo, imageDecodeOptions);
    }

    public CloseableStaticBitmap b(EncodedImage2 encodedImage2, ImageDecodeOptions imageDecodeOptions) {
        CloseableReference<Bitmap> closeableReferenceA = this.c.a(encodedImage2, imageDecodeOptions.d, null, null);
        try {
            AnimatableValueParser.g1(null, closeableReferenceA);
            QualityInfo qualityInfo = ImmutableQualityInfo.a;
            encodedImage2.x();
            int i = encodedImage2.m;
            encodedImage2.x();
            CloseableStaticBitmap closeableStaticBitmap = new CloseableStaticBitmap(closeableReferenceA, qualityInfo, i, encodedImage2.n);
            Boolean bool = Boolean.FALSE;
            if (CloseableImage.j.contains("is_rounded")) {
                closeableStaticBitmap.k.put("is_rounded", bool);
            }
            return closeableStaticBitmap;
        } finally {
            closeableReferenceA.close();
        }
    }
}
