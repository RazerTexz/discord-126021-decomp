package b.f.i;

import b.c.a.a0.AnimatableValueParser;
import b.f.d.d.Throwables;
import b.f.i.ImageFormat;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* JADX INFO: renamed from: b.f.i.d, reason: use source file name */
/* JADX INFO: compiled from: ImageFormatChecker.java */
/* JADX INFO: loaded from: classes.dex */
public class ImageFormatChecker {
    public static ImageFormatChecker a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f542b;
    public List<ImageFormat.a> c;
    public final DefaultImageFormatChecker d = new DefaultImageFormatChecker();

    public ImageFormatChecker() {
        d();
    }

    public static ImageFormat a(InputStream inputStream) throws IOException {
        int iB1;
        ImageFormatChecker imageFormatCheckerC = c();
        Objects.requireNonNull(imageFormatCheckerC);
        Objects.requireNonNull(inputStream);
        int i = imageFormatCheckerC.f542b;
        byte[] bArr = new byte[i];
        AnimatableValueParser.i(Boolean.valueOf(i >= i));
        if (inputStream.markSupported()) {
            try {
                inputStream.mark(i);
                iB1 = AnimatableValueParser.B1(inputStream, bArr, 0, i);
                inputStream.reset();
            } catch (Throwable th) {
                inputStream.reset();
                throw th;
            }
        } else {
            iB1 = AnimatableValueParser.B1(inputStream, bArr, 0, i);
        }
        ImageFormat imageFormatB = imageFormatCheckerC.d.b(bArr, iB1);
        if (imageFormatB != ImageFormat.a) {
            return imageFormatB;
        }
        List<ImageFormat.a> list = imageFormatCheckerC.c;
        if (list != null) {
            Iterator<ImageFormat.a> it = list.iterator();
            while (it.hasNext()) {
                ImageFormat imageFormatB2 = it.next().b(bArr, iB1);
                if (imageFormatB2 != null && imageFormatB2 != ImageFormat.a) {
                    return imageFormatB2;
                }
            }
        }
        return ImageFormat.a;
    }

    public static ImageFormat b(InputStream inputStream) {
        try {
            return a(inputStream);
        } catch (IOException e) {
            Throwables.a(e);
            throw new RuntimeException(e);
        }
    }

    public static synchronized ImageFormatChecker c() {
        if (a == null) {
            a = new ImageFormatChecker();
        }
        return a;
    }

    public final void d() {
        this.f542b = this.d.p;
        List<ImageFormat.a> list = this.c;
        if (list != null) {
            Iterator<ImageFormat.a> it = list.iterator();
            while (it.hasNext()) {
                this.f542b = Math.max(this.f542b, it.next().a());
            }
        }
    }
}
