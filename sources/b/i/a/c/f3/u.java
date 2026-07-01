package b.i.a.c.f3;

import java.util.Arrays;

/* JADX INFO: compiled from: NalUnitUtil.java */
/* JADX INFO: loaded from: classes3.dex */
public final class u {
    public static final byte[] a = {0, 0, 0, 1};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final float[] f978b = {1.0f, 1.0f, 1.0909091f, 0.90909094f, 1.4545455f, 1.2121212f, 2.1818182f, 1.8181819f, 2.909091f, 2.4242425f, 1.6363636f, 1.3636364f, 1.939394f, 1.6161616f, 1.3333334f, 1.5f, 2.0f};
    public static final Object c = new Object();
    public static int[] d = new int[10];

    public static void a(boolean[] zArr) {
        zArr[0] = false;
        zArr[1] = false;
        zArr[2] = false;
    }

    public static int b(byte[] bArr, int i, int i2, boolean[] zArr) {
        int i3 = i2 - i;
        b.c.a.a0.d.D(i3 >= 0);
        if (i3 == 0) {
            return i2;
        }
        if (zArr[0]) {
            zArr[0] = false;
            zArr[1] = false;
            zArr[2] = false;
            return i - 3;
        }
        if (i3 > 1 && zArr[1] && bArr[i] == 1) {
            zArr[0] = false;
            zArr[1] = false;
            zArr[2] = false;
            return i - 2;
        }
        if (i3 > 2 && zArr[2] && bArr[i] == 0 && bArr[i + 1] == 1) {
            zArr[0] = false;
            zArr[1] = false;
            zArr[2] = false;
            return i - 1;
        }
        int i4 = i2 - 1;
        int i5 = i + 2;
        while (i5 < i4) {
            if ((bArr[i5] & 254) == 0) {
                int i6 = i5 - 2;
                if (bArr[i6] == 0 && bArr[i5 - 1] == 0 && bArr[i5] == 1) {
                    zArr[0] = false;
                    zArr[1] = false;
                    zArr[2] = false;
                    return i6;
                }
                i5 -= 2;
            }
            i5 += 3;
        }
        zArr[0] = i3 <= 2 ? !(i3 != 2 ? !(zArr[1] && bArr[i4] == 1) : !(zArr[2] && bArr[i2 + (-2)] == 0 && bArr[i4] == 1)) : bArr[i2 + (-3)] == 0 && bArr[i2 + (-2)] == 0 && bArr[i4] == 1;
        zArr[1] = i3 <= 1 ? zArr[2] && bArr[i4] == 0 : bArr[i2 + (-2)] == 0 && bArr[i4] == 0;
        zArr[2] = bArr[i4] == 0;
        return i2;
    }

    public static u$a c(byte[] bArr, int i, int i2) {
        int i3 = 2;
        y yVar = new y(bArr, i + 2, i2);
        yVar.j(4);
        int iE = yVar.e(3);
        yVar.i();
        int iE2 = yVar.e(2);
        boolean zD = yVar.d();
        int iE3 = yVar.e(5);
        int i4 = 0;
        for (int i5 = 0; i5 < 32; i5++) {
            if (yVar.d()) {
                i4 |= 1 << i5;
            }
        }
        int i6 = 6;
        int[] iArr = new int[6];
        for (int i7 = 0; i7 < 6; i7++) {
            iArr[i7] = yVar.e(8);
        }
        int iE4 = yVar.e(8);
        int i8 = 0;
        for (int i9 = 0; i9 < iE; i9++) {
            if (yVar.d()) {
                i8 += 89;
            }
            if (yVar.d()) {
                i8 += 8;
            }
        }
        yVar.j(i8);
        if (iE > 0) {
            yVar.j((8 - iE) * 2);
        }
        int iF = yVar.f();
        int iF2 = yVar.f();
        if (iF2 == 3) {
            yVar.i();
        }
        int iF3 = yVar.f();
        int iF4 = yVar.f();
        if (yVar.d()) {
            int iF5 = yVar.f();
            int iF6 = yVar.f();
            int iF7 = yVar.f();
            int iF8 = yVar.f();
            iF3 -= (iF5 + iF6) * ((iF2 == 1 || iF2 == 2) ? 2 : 1);
            iF4 -= (iF7 + iF8) * (iF2 == 1 ? 2 : 1);
        }
        yVar.f();
        yVar.f();
        int iF9 = yVar.f();
        for (int i10 = yVar.d() ? 0 : iE; i10 <= iE; i10++) {
            yVar.f();
            yVar.f();
            yVar.f();
        }
        yVar.f();
        yVar.f();
        yVar.f();
        yVar.f();
        yVar.f();
        yVar.f();
        if (yVar.d() && yVar.d()) {
            int i11 = 0;
            int i12 = 4;
            while (i11 < i12) {
                int i13 = 0;
                while (i13 < i6) {
                    if (yVar.d()) {
                        int iMin = Math.min(64, 1 << ((i11 << 1) + 4));
                        if (i11 > 1) {
                            yVar.g();
                        }
                        for (int i14 = 0; i14 < iMin; i14++) {
                            yVar.g();
                        }
                    } else {
                        yVar.f();
                    }
                    i13 += i11 == 3 ? 3 : 1;
                    i6 = 6;
                }
                i11++;
                i12 = 4;
                i6 = 6;
                i3 = 2;
            }
        }
        yVar.j(i3);
        if (yVar.d()) {
            yVar.j(8);
            yVar.f();
            yVar.f();
            yVar.i();
        }
        int iF10 = yVar.f();
        boolean zD2 = false;
        int i15 = 0;
        for (int i16 = 0; i16 < iF10; i16++) {
            if (i16 != 0) {
                zD2 = yVar.d();
            }
            if (zD2) {
                yVar.i();
                yVar.f();
                for (int i17 = 0; i17 <= i15; i17++) {
                    if (yVar.d()) {
                        yVar.i();
                    }
                }
            } else {
                int iF11 = yVar.f();
                int iF12 = yVar.f();
                int i18 = iF11 + iF12;
                for (int i19 = 0; i19 < iF11; i19++) {
                    yVar.f();
                    yVar.i();
                }
                for (int i20 = 0; i20 < iF12; i20++) {
                    yVar.f();
                    yVar.i();
                }
                i15 = i18;
            }
        }
        if (yVar.d()) {
            for (int i21 = 0; i21 < yVar.f(); i21++) {
                yVar.j(iF9 + 4 + 1);
            }
        }
        yVar.j(2);
        float f = 1.0f;
        if (yVar.d()) {
            if (yVar.d()) {
                int iE5 = yVar.e(8);
                if (iE5 == 255) {
                    int iE6 = yVar.e(16);
                    int iE7 = yVar.e(16);
                    if (iE6 != 0 && iE7 != 0) {
                        f = iE6 / iE7;
                    }
                } else {
                    float[] fArr = f978b;
                    if (iE5 < fArr.length) {
                        f = fArr[iE5];
                    } else {
                        b.d.b.a.a.g0(46, "Unexpected aspect_ratio_idc value: ", iE5, "NalUnitUtil");
                    }
                }
            }
            if (yVar.d()) {
                yVar.i();
            }
            if (yVar.d()) {
                yVar.j(4);
                if (yVar.d()) {
                    yVar.j(24);
                }
            }
            if (yVar.d()) {
                yVar.f();
                yVar.f();
            }
            yVar.i();
            if (yVar.d()) {
                iF4 *= 2;
            }
        }
        return new u$a(iE2, zD, iE3, i4, iArr, iE4, iF, iF3, iF4, f);
    }

    public static u$b d(byte[] bArr, int i, int i2) {
        y yVar = new y(bArr, i + 1, i2);
        int iF = yVar.f();
        int iF2 = yVar.f();
        yVar.i();
        return new u$b(iF, iF2, yVar.d());
    }

    /* JADX WARN: Code duplicated, block: B:64:0x00f8  */
    /* JADX WARN: Code duplicated, block: B:67:0x0108  */
    /* JADX WARN: Code duplicated, block: B:69:0x011a  */
    /* JADX WARN: Code duplicated, block: B:70:0x011e  */
    /* JADX WARN: Code duplicated, block: B:72:0x0123  */
    /* JADX WARN: Code duplicated, block: B:73:0x0127  */
    /* JADX WARN: Code duplicated, block: B:76:0x012d  */
    /* JADX WARN: Code duplicated, block: B:79:0x013c  */
    /* JADX WARN: Code duplicated, block: B:94:0x017d  */
    public static u$c e(byte[] bArr, int i, int i2) {
        int iF;
        boolean z2;
        int iF2;
        boolean z3;
        int i3;
        boolean zD;
        int i4;
        int i5;
        int i6;
        float f;
        int i7;
        int i8;
        y yVar = new y(bArr, i + 1, i2);
        int iE = yVar.e(8);
        int iE2 = yVar.e(8);
        int iE3 = yVar.e(8);
        int iF3 = yVar.f();
        if (iE == 100 || iE == 110 || iE == 122 || iE == 244 || iE == 44 || iE == 83 || iE == 86 || iE == 118 || iE == 128 || iE == 138) {
            iF = yVar.f();
            boolean zD2 = iF == 3 ? yVar.d() : false;
            yVar.f();
            yVar.f();
            yVar.i();
            if (yVar.d()) {
                int i9 = iF != 3 ? 8 : 12;
                int i10 = 0;
                while (i10 < i9) {
                    if (yVar.d()) {
                        int i11 = i10 < 6 ? 16 : 64;
                        int iG = 8;
                        int i12 = 8;
                        for (int i13 = 0; i13 < i11; i13++) {
                            if (iG != 0) {
                                iG = ((yVar.g() + i12) + 256) % 256;
                            }
                            if (iG != 0) {
                                i12 = iG;
                            }
                        }
                    }
                    i10++;
                }
            }
            z2 = zD2;
        } else {
            iF = 1;
            z2 = false;
        }
        int iF4 = yVar.f() + 4;
        int iF5 = yVar.f();
        if (iF5 != 0) {
            if (iF5 == 1) {
                boolean zD3 = yVar.d();
                yVar.g();
                yVar.g();
                long jF = yVar.f();
                iF5 = iF5;
                for (int i14 = 0; i14 < jF; i14++) {
                    yVar.f();
                }
                z3 = zD3;
                i3 = 0;
            } else {
                iF2 = 0;
            }
            yVar.f();
            yVar.i();
            int iF6 = yVar.f() + 1;
            int iF7 = yVar.f() + 1;
            zD = yVar.d();
            i4 = 2 - (zD ? 1 : 0);
            int i15 = iF7 * i4;
            if (!zD) {
                yVar.i();
            }
            yVar.i();
            i5 = iF6 * 16;
            i6 = i15 * 16;
            if (yVar.d()) {
                int iF8 = yVar.f();
                int iF9 = yVar.f();
                int iF10 = yVar.f();
                int iF11 = yVar.f();
                if (iF == 0) {
                    i8 = 1;
                } else {
                    if (iF == 3) {
                        i7 = 1;
                    } else {
                        i7 = 2;
                    }
                    i4 *= iF == 1 ? 2 : 1;
                    i8 = i7;
                }
                i5 -= (iF8 + iF9) * i8;
                i6 -= (iF10 + iF11) * i4;
            } else {
                i3 = i3;
            }
            int i16 = i5;
            int i17 = i6;
            if (yVar.d() || !yVar.d()) {
                f = 1.0f;
            } else {
                int iE4 = yVar.e(8);
                if (iE4 == 255) {
                    int iE5 = yVar.e(16);
                    int iE6 = yVar.e(16);
                    if (iE5 == 0 || iE6 == 0) {
                        f = 1.0f;
                    } else {
                        f = iE5 / iE6;
                    }
                } else {
                    float[] fArr = f978b;
                    if (iE4 < fArr.length) {
                        f = fArr[iE4];
                    } else {
                        b.d.b.a.a.g0(46, "Unexpected aspect_ratio_idc value: ", iE4, "NalUnitUtil");
                        f = 1.0f;
                    }
                }
            }
            return new u$c(iE, iE2, iE3, iF3, i16, i17, f, z2, zD, iF4, iF5, i3, z3);
        }
        iF2 = yVar.f() + 4;
        i3 = iF2;
        z3 = false;
        yVar.f();
        yVar.i();
        int iF12 = yVar.f() + 1;
        int iF13 = yVar.f() + 1;
        zD = yVar.d();
        i4 = 2 - (zD ? 1 : 0);
        int i18 = iF13 * i4;
        if (!zD) {
            yVar.i();
        }
        yVar.i();
        i5 = iF12 * 16;
        i6 = i18 * 16;
        if (yVar.d()) {
            int iF14 = yVar.f();
            int iF15 = yVar.f();
            int iF16 = yVar.f();
            int iF17 = yVar.f();
            if (iF == 0) {
                i8 = 1;
            } else {
                if (iF == 3) {
                    i7 = 1;
                } else {
                    i7 = 2;
                }
                i4 *= iF == 1 ? 2 : 1;
                i8 = i7;
            }
            i5 -= (iF14 + iF15) * i8;
            i6 -= (iF16 + iF17) * i4;
        } else {
            i3 = i3;
        }
        int i19 = i5;
        int i110 = i6;
        if (yVar.d()) {
            f = 1.0f;
        } else {
            f = 1.0f;
        }
        return new u$c(iE, iE2, iE3, iF3, i19, i110, f, z2, zD, iF4, iF5, i3, z3);
    }

    public static int f(byte[] bArr, int i) {
        int i2;
        synchronized (c) {
            int i3 = 0;
            int i4 = 0;
            while (i3 < i) {
                while (true) {
                    if (i3 >= i - 2) {
                        i3 = i;
                        break;
                    }
                    if (bArr[i3] == 0 && bArr[i3 + 1] == 0 && bArr[i3 + 2] == 3) {
                        break;
                    }
                    i3++;
                }
                if (i3 < i) {
                    int[] iArr = d;
                    if (iArr.length <= i4) {
                        d = Arrays.copyOf(iArr, iArr.length * 2);
                    }
                    d[i4] = i3;
                    i3 += 3;
                    i4++;
                }
            }
            i2 = i - i4;
            int i5 = 0;
            int i6 = 0;
            for (int i7 = 0; i7 < i4; i7++) {
                int i8 = d[i7] - i6;
                System.arraycopy(bArr, i6, bArr, i5, i8);
                int i9 = i5 + i8;
                int i10 = i9 + 1;
                bArr[i9] = 0;
                i5 = i10 + 1;
                bArr[i10] = 0;
                i6 += i8 + 3;
            }
            System.arraycopy(bArr, i6, bArr, i5, i2 - i5);
        }
        return i2;
    }
}
