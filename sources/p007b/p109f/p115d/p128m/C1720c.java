package p007b.p109f.p115d.p128m;

import java.io.UnsupportedEncodingException;

/* JADX INFO: renamed from: b.f.d.m.c */
/* JADX INFO: compiled from: WebpSupportStatus.java */
/* JADX INFO: loaded from: classes.dex */
public class C1720c {

    /* JADX INFO: renamed from: a */
    public static InterfaceC1719b f3139a = null;

    /* JADX INFO: renamed from: b */
    public static boolean f3140b = false;

    /* JADX INFO: renamed from: c */
    public static final byte[] f3141c = m1013a("RIFF");

    /* JADX INFO: renamed from: d */
    public static final byte[] f3142d = m1013a("WEBP");

    /* JADX INFO: renamed from: e */
    public static final byte[] f3143e = m1013a("VP8 ");

    /* JADX INFO: renamed from: f */
    public static final byte[] f3144f = m1013a("VP8L");

    /* JADX INFO: renamed from: g */
    public static final byte[] f3145g = m1013a("VP8X");

    /* JADX INFO: renamed from: a */
    public static byte[] m1013a(String str) {
        try {
            return str.getBytes("ASCII");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("ASCII not found!", e);
        }
    }

    /* JADX INFO: renamed from: b */
    public static boolean m1014b(byte[] bArr, int i, int i2) {
        return i2 >= 20 && m1016d(bArr, i, f3141c) && m1016d(bArr, i + 8, f3142d);
    }

    /* JADX INFO: renamed from: c */
    public static InterfaceC1719b m1015c() {
        if (f3140b) {
            return f3139a;
        }
        InterfaceC1719b interfaceC1719b = null;
        try {
            interfaceC1719b = (InterfaceC1719b) Class.forName("com.facebook.webpsupport.WebpBitmapFactoryImpl").newInstance();
        } catch (Throwable unused) {
        }
        f3140b = true;
        return interfaceC1719b;
    }

    /* JADX INFO: renamed from: d */
    public static boolean m1016d(byte[] bArr, int i, byte[] bArr2) {
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
