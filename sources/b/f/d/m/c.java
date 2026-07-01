package b.f.d.m;

import java.io.UnsupportedEncodingException;

/* JADX INFO: compiled from: WebpSupportStatus.java */
/* JADX INFO: loaded from: classes.dex */
public class c {
    public static b a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f474b = false;
    public static final byte[] c = a("RIFF");
    public static final byte[] d = a("WEBP");
    public static final byte[] e = a("VP8 ");
    public static final byte[] f = a("VP8L");
    public static final byte[] g = a("VP8X");

    public static byte[] a(String str) {
        try {
            return str.getBytes("ASCII");
        } catch (UnsupportedEncodingException e2) {
            throw new RuntimeException("ASCII not found!", e2);
        }
    }

    public static boolean b(byte[] bArr, int i, int i2) {
        return i2 >= 20 && d(bArr, i, c) && d(bArr, i + 8, d);
    }

    public static b c() {
        if (f474b) {
            return a;
        }
        b bVar = null;
        try {
            bVar = (b) Class.forName("com.facebook.webpsupport.WebpBitmapFactoryImpl").newInstance();
        } catch (Throwable unused) {
        }
        f474b = true;
        return bVar;
    }

    public static boolean d(byte[] bArr, int i, byte[] bArr2) {
        if (bArr2 == null || bArr == null || bArr2.length + i > bArr.length) {
            return false;
        }
        for (int i2 = 0; i2 < bArr2.length; i2++) {
            if (bArr[i2 + i] != bArr2[i2]) {
                return false;
            }
        }
        return true;
    }
}
