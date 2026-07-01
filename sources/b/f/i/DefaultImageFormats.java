package b.f.i;

import com.discord.utilities.icon.IconUtils;

/* JADX INFO: renamed from: b.f.i.b, reason: use source file name */
/* JADX INFO: compiled from: DefaultImageFormats.java */
/* JADX INFO: loaded from: classes.dex */
public final class DefaultImageFormats {
    public static final ImageFormat a = new ImageFormat("JPEG", "jpeg");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ImageFormat f540b = new ImageFormat("PNG", "png");
    public static final ImageFormat c = new ImageFormat("GIF", IconUtils.ANIMATED_IMAGE_EXTENSION);
    public static final ImageFormat d = new ImageFormat("BMP", "bmp");
    public static final ImageFormat e = new ImageFormat("ICO", "ico");
    public static final ImageFormat f = new ImageFormat("WEBP_SIMPLE", "webp");
    public static final ImageFormat g = new ImageFormat("WEBP_LOSSLESS", "webp");
    public static final ImageFormat h = new ImageFormat("WEBP_EXTENDED", "webp");
    public static final ImageFormat i = new ImageFormat("WEBP_EXTENDED_WITH_ALPHA", "webp");
    public static final ImageFormat j = new ImageFormat("WEBP_ANIMATED", "webp");
    public static final ImageFormat k = new ImageFormat("HEIF", "heif");
    public static final ImageFormat l = new ImageFormat("DNG", "dng");

    public static boolean a(ImageFormat imageFormat) {
        return imageFormat == f || imageFormat == g || imageFormat == h || imageFormat == i;
    }
}
