package b.f.i;

import androidx.exifinterface.media.ExifInterface;

/* JADX INFO: compiled from: DefaultImageFormatChecker.java */
/* JADX INFO: loaded from: classes.dex */
public class a implements c$a {
    public static final byte[] a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f539b;
    public static final byte[] c;
    public static final int d;
    public static final byte[] e = b.c.a.a0.d.e("GIF87a");
    public static final byte[] f = b.c.a.a0.d.e("GIF89a");
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
        byte[] bArrE = b.c.a.a0.d.e("BM");
        g = bArrE;
        h = bArrE.length;
        byte[] bArr3 = {0, 0, 1, 0};
        i = bArr3;
        j = bArr3.length;
        k = b.c.a.a0.d.e("ftyp");
        l = new byte[][]{b.c.a.a0.d.e("heic"), b.c.a.a0.d.e("heix"), b.c.a.a0.d.e("hevc"), b.c.a.a0.d.e("hevx"), b.c.a.a0.d.e("mif1"), b.c.a.a0.d.e("msf1")};
        byte[] bArr4 = {73, 73, ExifInterface.START_CODE, 0};
        m = bArr4;
        n = new byte[]{77, 77, 0, ExifInterface.START_CODE};
        o = bArr4.length;
    }

    public a() {
        int[] iArr = {21, 20, f539b, d, 6, h, j, 12};
        b.c.a.a0.d.i(Boolean.TRUE);
        int i2 = iArr[0];
        for (int i3 = 1; i3 < 8; i3++) {
            if (iArr[i3] > i2) {
                i2 = iArr[i3];
            }
        }
        this.p = i2;
    }

    public static c c(byte[] bArr, int i2) {
        boolean z2 = false;
        b.c.a.a0.d.i(Boolean.valueOf(b.f.d.m.c.b(bArr, 0, i2)));
        if (b.f.d.m.c.d(bArr, 12, b.f.d.m.c.e)) {
            return b.f;
        }
        if (b.f.d.m.c.d(bArr, 12, b.f.d.m.c.f)) {
            return b.g;
        }
        if (!(i2 >= 21 && b.f.d.m.c.d(bArr, 12, b.f.d.m.c.g))) {
            return c.a;
        }
        byte[] bArr2 = b.f.d.m.c.g;
        if (b.f.d.m.c.d(bArr, 12, bArr2) && ((bArr[20] & 2) == 2)) {
            return b.j;
        }
        boolean zD = b.f.d.m.c.d(bArr, 12, bArr2);
        boolean z3 = (bArr[20] & 16) == 16;
        if (zD && z3) {
            z2 = true;
        }
        return z2 ? b.i : b.h;
    }

    @Override // b.f.i.c$a
    public int a() {
        return this.p;
    }

    @Override // b.f.i.c$a
    public final c b(byte[] bArr, int i2) {
        boolean z2;
        boolean z3 = false;
        if (b.f.d.m.c.b(bArr, 0, i2)) {
            return c(bArr, i2);
        }
        byte[] bArr2 = a;
        if (i2 >= bArr2.length && b.c.a.a0.d.I0(bArr, bArr2, 0)) {
            return b.a;
        }
        byte[] bArr3 = c;
        if (i2 >= bArr3.length && b.c.a.a0.d.I0(bArr, bArr3, 0)) {
            return b.f540b;
        }
        if (i2 >= 6 && (b.c.a.a0.d.I0(bArr, e, 0) || b.c.a.a0.d.I0(bArr, f, 0))) {
            return b.c;
        }
        byte[] bArr4 = g;
        if (i2 < bArr4.length ? false : b.c.a.a0.d.I0(bArr, bArr4, 0)) {
            return b.d;
        }
        byte[] bArr5 = i;
        if (i2 < bArr5.length ? false : b.c.a.a0.d.I0(bArr, bArr5, 0)) {
            return b.e;
        }
        if (i2 < 12 || bArr[3] < 8 || !b.c.a.a0.d.I0(bArr, k, 4)) {
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
            if (b.c.a.a0.d.I0(bArr, bArr6[i3], 8)) {
                z2 = true;
                break;
            }
            i3++;
        }
        if (z2) {
            return b.k;
        }
        if (i2 >= o && (b.c.a.a0.d.I0(bArr, m, 0) || b.c.a.a0.d.I0(bArr, n, 0))) {
            z3 = true;
        }
        return z3 ? b.l : c.a;
    }
}
