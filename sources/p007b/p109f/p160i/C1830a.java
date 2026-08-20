package p007b.p109f.p160i;

import androidx.exifinterface.media.ExifInterface;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p109f.p115d.p128m.C1720c;

/* JADX INFO: renamed from: b.f.i.a */
/* JADX INFO: compiled from: DefaultImageFormatChecker.java */
/* JADX INFO: loaded from: classes.dex */
public class C1830a implements C1832c.a {

    /* JADX INFO: renamed from: a */
    public static final byte[] f3569a;

    /* JADX INFO: renamed from: b */
    public static final int f3570b;

    /* JADX INFO: renamed from: c */
    public static final byte[] f3571c;

    /* JADX INFO: renamed from: d */
    public static final int f3572d;

    /* JADX INFO: renamed from: e */
    public static final byte[] f3573e = C1460d.m511e("GIF87a");

    /* JADX INFO: renamed from: f */
    public static final byte[] f3574f = C1460d.m511e("GIF89a");

    /* JADX INFO: renamed from: g */
    public static final byte[] f3575g;

    /* JADX INFO: renamed from: h */
    public static final int f3576h;

    /* JADX INFO: renamed from: i */
    public static final byte[] f3577i;

    /* JADX INFO: renamed from: j */
    public static final int f3578j;

    /* JADX INFO: renamed from: k */
    public static final byte[] f3579k;

    /* JADX INFO: renamed from: l */
    public static final byte[][] f3580l;

    /* JADX INFO: renamed from: m */
    public static final byte[] f3581m;

    /* JADX INFO: renamed from: n */
    public static final byte[] f3582n;

    /* JADX INFO: renamed from: o */
    public static final int f3583o;

    /* JADX INFO: renamed from: p */
    public final int f3584p;

    static {
        byte[] bArr = {-1, -40, -1};
        f3569a = bArr;
        f3570b = bArr.length;
        byte[] bArr2 = {-119, 80, 78, 71, 13, 10, 26, 10};
        f3571c = bArr2;
        f3572d = bArr2.length;
        byte[] bArrM511e = C1460d.m511e("BM");
        f3575g = bArrM511e;
        f3576h = bArrM511e.length;
        byte[] bArr3 = {0, 0, 1, 0};
        f3577i = bArr3;
        f3578j = bArr3.length;
        f3579k = C1460d.m511e("ftyp");
        f3580l = new byte[][]{C1460d.m511e("heic"), C1460d.m511e("heix"), C1460d.m511e("hevc"), C1460d.m511e("hevx"), C1460d.m511e("mif1"), C1460d.m511e("msf1")};
        byte[] bArr4 = {73, 73, ExifInterface.START_CODE, 0};
        f3581m = bArr4;
        f3582n = new byte[]{77, 77, 0, ExifInterface.START_CODE};
        f3583o = bArr4.length;
    }

    public C1830a() {
        int[] iArr = {21, 20, f3570b, f3572d, 6, f3576h, f3578j, 12};
        C1460d.m527i(Boolean.TRUE);
        int i = iArr[0];
        for (int i2 = 1; i2 < 8; i2++) {
            if (iArr[i2] > i) {
                i = iArr[i2];
            }
        }
        this.f3584p = i;
    }

    /* JADX INFO: renamed from: c */
    public static C1832c m1169c(byte[] bArr, int i) {
        boolean z2 = false;
        C1460d.m527i(Boolean.valueOf(C1720c.m1014b(bArr, 0, i)));
        if (C1720c.m1016d(bArr, 12, C1720c.f3143e)) {
            return C1831b.f3590f;
        }
        if (C1720c.m1016d(bArr, 12, C1720c.f3144f)) {
            return C1831b.f3591g;
        }
        if (!(i >= 21 && C1720c.m1016d(bArr, 12, C1720c.f3145g))) {
            return C1832c.f3597a;
        }
        byte[] bArr2 = C1720c.f3145g;
        if (C1720c.m1016d(bArr, 12, bArr2) && ((bArr[20] & 2) == 2)) {
            return C1831b.f3594j;
        }
        boolean zM1016d = C1720c.m1016d(bArr, 12, bArr2);
        boolean z3 = (bArr[20] & 16) == 16;
        if (zM1016d && z3) {
            z2 = true;
        }
        return z2 ? C1831b.f3593i : C1831b.f3592h;
    }

    @Override // p007b.p109f.p160i.C1832c.a
    /* JADX INFO: renamed from: a */
    public int mo1170a() {
        return this.f3584p;
    }

    @Override // p007b.p109f.p160i.C1832c.a
    /* JADX INFO: renamed from: b */
    public final C1832c mo1171b(byte[] bArr, int i) {
        boolean z2;
        boolean z3 = false;
        if (C1720c.m1014b(bArr, 0, i)) {
            return m1169c(bArr, i);
        }
        byte[] bArr2 = f3569a;
        if (i >= bArr2.length && C1460d.m442I0(bArr, bArr2, 0)) {
            return C1831b.f3585a;
        }
        byte[] bArr3 = f3571c;
        if (i >= bArr3.length && C1460d.m442I0(bArr, bArr3, 0)) {
            return C1831b.f3586b;
        }
        if (i >= 6 && (C1460d.m442I0(bArr, f3573e, 0) || C1460d.m442I0(bArr, f3574f, 0))) {
            return C1831b.f3587c;
        }
        byte[] bArr4 = f3575g;
        if (i < bArr4.length ? false : C1460d.m442I0(bArr, bArr4, 0)) {
            return C1831b.f3588d;
        }
        byte[] bArr5 = f3577i;
        if (i < bArr5.length ? false : C1460d.m442I0(bArr, bArr5, 0)) {
            return C1831b.f3589e;
        }
        if (i < 12 || bArr[3] < 8 || !C1460d.m442I0(bArr, f3579k, 4)) {
            z2 = false;
            break;
        }
        byte[][] bArr6 = f3580l;
        int length = bArr6.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                z2 = false;
                break;
            }
            if (C1460d.m442I0(bArr, bArr6[i2], 8)) {
                z2 = true;
                break;
            }
            i2++;
        }
        if (z2) {
            return C1831b.f3595k;
        }
        if (i >= f3583o && (C1460d.m442I0(bArr, f3581m, 0) || C1460d.m442I0(bArr, f3582n, 0))) {
            z3 = true;
        }
        return z3 ? C1831b.f3596l : C1832c.f3597a;
    }
}
