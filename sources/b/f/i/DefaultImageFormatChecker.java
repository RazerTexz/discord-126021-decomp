package b.f.i;

import androidx.exifinterface.media.ExifInterface;
import b.c.a.a0.AnimatableValueParser;
import b.f.d.m.WebpSupportStatus;
import b.f.i.ImageFormat;

/* JADX INFO: renamed from: b.f.i.a, reason: use source file name */
/* JADX INFO: compiled from: DefaultImageFormatChecker.java */
/* JADX INFO: loaded from: classes.dex */
public class DefaultImageFormatChecker implements ImageFormat.a {
    public static final byte[] a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f539b;
    public static final byte[] c;
    public static final int d;
    public static final byte[] e = AnimatableValueParser.e("GIF87a");
    public static final byte[] f = AnimatableValueParser.e("GIF89a");
    public static final byte[] g;
    public static final int h;
    public static final byte[] i;
    public static final int j;
    public static final byte[] k;
    public static final byte[][] l;
    public static final byte[] m;
    public static final byte[] n;
    public static final int o;
    public final int p;

    static {
        byte[] bArr = {-1, -40, -1};
        a = bArr;
        f539b = bArr.length;
        byte[] bArr2 = {-119, 80, 78, 71, 13, 10, 26, 10};
        c = bArr2;
        d = bArr2.length;
        byte[] bArrE = AnimatableValueParser.e("BM");
        g = bArrE;
        h = bArrE.length;
        byte[] bArr3 = {0, 0, 1, 0};
        i = bArr3;
        j = bArr3.length;
        k = AnimatableValueParser.e("ftyp");
        l = new byte[][]{AnimatableValueParser.e("heic"), AnimatableValueParser.e("heix"), AnimatableValueParser.e("hevc"), AnimatableValueParser.e("hevx"), AnimatableValueParser.e("mif1"), AnimatableValueParser.e("msf1")};
        byte[] bArr4 = {73, 73, ExifInterface.START_CODE, 0};
        m = bArr4;
        n = new byte[]{77, 77, 0, ExifInterface.START_CODE};
        o = bArr4.length;
    }

    public DefaultImageFormatChecker() {
        int[] iArr = {21, 20, f539b, d, 6, h, j, 12};
        AnimatableValueParser.i(Boolean.TRUE);
        int i2 = iArr[0];
        for (int i3 = 1; i3 < 8; i3++) {
            if (iArr[i3] > i2) {
                i2 = iArr[i3];
            }
        }
        this.p = i2;
    }

    public static ImageFormat c(byte[] bArr, int i2) {
        boolean z2 = false;
        AnimatableValueParser.i(Boolean.valueOf(WebpSupportStatus.b(bArr, 0, i2)));
        if (WebpSupportStatus.d(bArr, 12, WebpSupportStatus.e)) {
            return DefaultImageFormats.f;
        }
        if (WebpSupportStatus.d(bArr, 12, WebpSupportStatus.f)) {
            return DefaultImageFormats.g;
        }
        if (!(i2 >= 21 && WebpSupportStatus.d(bArr, 12, WebpSupportStatus.g))) {
            return ImageFormat.a;
        }
        byte[] bArr2 = WebpSupportStatus.g;
        if (WebpSupportStatus.d(bArr, 12, bArr2) && ((bArr[20] & 2) == 2)) {
            return DefaultImageFormats.j;
        }
        boolean zD = WebpSupportStatus.d(bArr, 12, bArr2);
        boolean z3 = (bArr[20] & 16) == 16;
        if (zD && z3) {
            z2 = true;
        }
        return z2 ? DefaultImageFormats.i : DefaultImageFormats.h;
    }

    @Override // b.f.i.ImageFormat.a
    public int a() {
        return this.p;
    }

    @Override // b.f.i.ImageFormat.a
    public final ImageFormat b(byte[] bArr, int i2) {
        boolean z2;
        boolean z3 = false;
        if (WebpSupportStatus.b(bArr, 0, i2)) {
            return c(bArr, i2);
        }
        byte[] bArr2 = a;
        if (i2 >= bArr2.length && AnimatableValueParser.I0(bArr, bArr2, 0)) {
            return DefaultImageFormats.a;
        }
        byte[] bArr3 = c;
        if (i2 >= bArr3.length && AnimatableValueParser.I0(bArr, bArr3, 0)) {
            return DefaultImageFormats.f540b;
        }
        if (i2 >= 6 && (AnimatableValueParser.I0(bArr, e, 0) || AnimatableValueParser.I0(bArr, f, 0))) {
            return DefaultImageFormats.c;
        }
        byte[] bArr4 = g;
        if (i2 < bArr4.length ? false : AnimatableValueParser.I0(bArr, bArr4, 0)) {
            return DefaultImageFormats.d;
        }
        byte[] bArr5 = i;
        if (i2 < bArr5.length ? false : AnimatableValueParser.I0(bArr, bArr5, 0)) {
            return DefaultImageFormats.e;
        }
        if (i2 < 12 || bArr[3] < 8 || !AnimatableValueParser.I0(bArr, k, 4)) {
            z2 = false;
            break;
        }
        byte[][] bArr6 = l;
        int length = bArr6.length;
        int i3 = 0;
        while (true) {
            if (i3 >= length) {
                z2 = false;
                break;
            }
            if (AnimatableValueParser.I0(bArr, bArr6[i3], 8)) {
                z2 = true;
                break;
            }
            i3++;
        }
        if (z2) {
            return DefaultImageFormats.k;
        }
        if (i2 >= o && (AnimatableValueParser.I0(bArr, m, 0) || AnimatableValueParser.I0(bArr, n, 0))) {
            z3 = true;
        }
        return z3 ? DefaultImageFormats.l : ImageFormat.a;
    }
}
