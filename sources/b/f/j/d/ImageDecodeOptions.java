package b.f.j.d;

import android.graphics.Bitmap;
import b.c.a.a0.AnimatableValueParser;
import b.d.b.a.outline;
import b.f.d.d.Objects2;

/* JADX INFO: renamed from: b.f.j.d.b, reason: use source file name */
/* JADX INFO: compiled from: ImageDecodeOptions.java */
/* JADX INFO: loaded from: classes.dex */
public class ImageDecodeOptions {
    public static final ImageDecodeOptions a = new ImageDecodeOptions(new ImageDecodeOptionsBuilder());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f564b = 100;
    public final int c = Integer.MAX_VALUE;
    public final Bitmap.Config d;
    public final Bitmap.Config e;

    public ImageDecodeOptions(ImageDecodeOptionsBuilder imageDecodeOptionsBuilder) {
        this.d = imageDecodeOptionsBuilder.a;
        this.e = imageDecodeOptionsBuilder.f565b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || ImageDecodeOptions.class != obj.getClass()) {
            return false;
        }
        ImageDecodeOptions imageDecodeOptions = (ImageDecodeOptions) obj;
        return this.f564b == imageDecodeOptions.f564b && this.c == imageDecodeOptions.c && this.d == imageDecodeOptions.d && this.e == imageDecodeOptions.e;
    }

    public int hashCode() {
        int iOrdinal = (this.d.ordinal() + (((((((((((this.f564b * 31) + this.c) * 31) + 0) * 31) + 0) * 31) + 0) * 31) + 0) * 31)) * 31;
        Bitmap.Config config = this.e;
        return ((((((iOrdinal + (config != null ? config.ordinal() : 0)) * 31) + 0) * 31) + 0) * 31) + 0;
    }

    public String toString() {
        StringBuilder sbU = outline.U("ImageDecodeOptions{");
        Objects2 objects2H2 = AnimatableValueParser.h2(this);
        objects2H2.a("minDecodeIntervalMs", this.f564b);
        objects2H2.a("maxDimensionPx", this.c);
        objects2H2.b("decodePreviewFrame", false);
        objects2H2.b("useLastFrameForPreview", false);
        objects2H2.b("decodeAllFrames", false);
        objects2H2.b("forceStaticImage", false);
        objects2H2.c("bitmapConfigName", this.d.name());
        objects2H2.c("animatedBitmapConfigName", this.e.name());
        objects2H2.c("customImageDecoder", null);
        objects2H2.c("bitmapTransformation", null);
        objects2H2.c("colorSpace", null);
        return outline.J(sbU, objects2H2.toString(), "}");
    }
}
