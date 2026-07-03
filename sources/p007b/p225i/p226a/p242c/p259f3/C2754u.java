package p007b.p225i.p226a.p242c.p259f3;

import java.util.Arrays;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p100d.p104b.p105a.C1643a;

/* JADX INFO: renamed from: b.i.a.c.f3.u */
/* JADX INFO: compiled from: NalUnitUtil.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C2754u {

    /* JADX INFO: renamed from: a */
    public static final byte[] f6753a = {0, 0, 0, 1};

    /* JADX INFO: renamed from: b */
    public static final float[] f6754b = {1.0f, 1.0f, 1.0909091f, 0.90909094f, 1.4545455f, 1.2121212f, 2.1818182f, 1.8181819f, 2.909091f, 2.4242425f, 1.6363636f, 1.3636364f, 1.939394f, 1.6161616f, 1.3333334f, 1.5f, 2.0f};

    /* JADX INFO: renamed from: c */
    public static final Object f6755c = new Object();

    /* JADX INFO: renamed from: d */
    public static int[] f6756d = new int[10];

    /* JADX INFO: renamed from: b.i.a.c.f3.u$a */
    /* JADX INFO: compiled from: NalUnitUtil.java */
    public static final class a {

        /* JADX INFO: renamed from: a */
        public final int f6757a;

        /* JADX INFO: renamed from: b */
        public final boolean f6758b;

        /* JADX INFO: renamed from: c */
        public final int f6759c;

        /* JADX INFO: renamed from: d */
        public final int f6760d;

        /* JADX INFO: renamed from: e */
        public final int[] f6761e;

        /* JADX INFO: renamed from: f */
        public final int f6762f;

        /* JADX INFO: renamed from: g */
        public final int f6763g;

        /* JADX INFO: renamed from: h */
        public final int f6764h;

        /* JADX INFO: renamed from: i */
        public final float f6765i;

        public a(int i, boolean z2, int i2, int i3, int[] iArr, int i4, int i5, int i6, int i7, float f) {
            this.f6757a = i;
            this.f6758b = z2;
            this.f6759c = i2;
            this.f6760d = i3;
            this.f6761e = iArr;
            this.f6762f = i4;
            this.f6763g = i6;
            this.f6764h = i7;
            this.f6765i = f;
        }
    }

    /* JADX INFO: renamed from: b.i.a.c.f3.u$b */
    /* JADX INFO: compiled from: NalUnitUtil.java */
    public static final class b {

        /* JADX INFO: renamed from: a */
        public final int f6766a;

        /* JADX INFO: renamed from: b */
        public final int f6767b;

        /* JADX INFO: renamed from: c */
        public final boolean f6768c;

        public b(int i, int i2, boolean z2) {
            this.f6766a = i;
            this.f6767b = i2;
            this.f6768c = z2;
        }
    }

    /* JADX INFO: renamed from: b.i.a.c.f3.u$c */
    /* JADX INFO: compiled from: NalUnitUtil.java */
    public static final class c {

        /* JADX INFO: renamed from: a */
        public final int f6769a;

        /* JADX INFO: renamed from: b */
        public final int f6770b;

        /* JADX INFO: renamed from: c */
        public final int f6771c;

        /* JADX INFO: renamed from: d */
        public final int f6772d;

        /* JADX INFO: renamed from: e */
        public final int f6773e;

        /* JADX INFO: renamed from: f */
        public final int f6774f;

        /* JADX INFO: renamed from: g */
        public final float f6775g;

        /* JADX INFO: renamed from: h */
        public final boolean f6776h;

        /* JADX INFO: renamed from: i */
        public final boolean f6777i;

        /* JADX INFO: renamed from: j */
        public final int f6778j;

        /* JADX INFO: renamed from: k */
        public final int f6779k;

        /* JADX INFO: renamed from: l */
        public final int f6780l;

        /* JADX INFO: renamed from: m */
        public final boolean f6781m;

        public c(int i, int i2, int i3, int i4, int i5, int i6, float f, boolean z2, boolean z3, int i7, int i8, int i9, boolean z4) {
            this.f6769a = i;
            this.f6770b = i2;
            this.f6771c = i3;
            this.f6772d = i4;
            this.f6773e = i5;
            this.f6774f = i6;
            this.f6775g = f;
            this.f6776h = z2;
            this.f6777i = z3;
            this.f6778j = i7;
            this.f6779k = i8;
            this.f6780l = i9;
            this.f6781m = z4;
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m3054a(boolean[] zArr) {
        zArr[0] = false;
        zArr[1] = false;
        zArr[2] = false;
    }

    /* JADX INFO: renamed from: b */
    public static int m3055b(byte[] bArr, int i, int i2, boolean[] zArr) {
        int i3 = i2 - i;
        C1460d.m426D(i3 >= 0);
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

    /* JADX INFO: renamed from: c */
    public static a m3056c(byte[] bArr, int i, int i2) {
        int i3 = 2;
        C2758y c2758y = new C2758y(bArr, i + 2, i2);
        c2758y.m3116j(4);
        int iM3111e = c2758y.m3111e(3);
        c2758y.m3115i();
        int iM3111e2 = c2758y.m3111e(2);
        boolean zM3110d = c2758y.m3110d();
        int iM3111e3 = c2758y.m3111e(5);
        int i4 = 0;
        for (int i5 = 0; i5 < 32; i5++) {
            if (c2758y.m3110d()) {
                i4 |= 1 << i5;
            }
        }
        int i6 = 6;
        int[] iArr = new int[6];
        for (int i7 = 0; i7 < 6; i7++) {
            iArr[i7] = c2758y.m3111e(8);
        }
        int iM3111e4 = c2758y.m3111e(8);
        int i8 = 0;
        for (int i9 = 0; i9 < iM3111e; i9++) {
            if (c2758y.m3110d()) {
                i8 += 89;
            }
            if (c2758y.m3110d()) {
                i8 += 8;
            }
        }
        c2758y.m3116j(i8);
        if (iM3111e > 0) {
            c2758y.m3116j((8 - iM3111e) * 2);
        }
        int iM3112f = c2758y.m3112f();
        int iM3112f2 = c2758y.m3112f();
        if (iM3112f2 == 3) {
            c2758y.m3115i();
        }
        int iM3112f3 = c2758y.m3112f();
        int iM3112f4 = c2758y.m3112f();
        if (c2758y.m3110d()) {
            int iM3112f5 = c2758y.m3112f();
            int iM3112f6 = c2758y.m3112f();
            int iM3112f7 = c2758y.m3112f();
            int iM3112f8 = c2758y.m3112f();
            iM3112f3 -= (iM3112f5 + iM3112f6) * ((iM3112f2 == 1 || iM3112f2 == 2) ? 2 : 1);
            iM3112f4 -= (iM3112f7 + iM3112f8) * (iM3112f2 == 1 ? 2 : 1);
        }
        c2758y.m3112f();
        c2758y.m3112f();
        int iM3112f9 = c2758y.m3112f();
        for (int i10 = c2758y.m3110d() ? 0 : iM3111e; i10 <= iM3111e; i10++) {
            c2758y.m3112f();
            c2758y.m3112f();
            c2758y.m3112f();
        }
        c2758y.m3112f();
        c2758y.m3112f();
        c2758y.m3112f();
        c2758y.m3112f();
        c2758y.m3112f();
        c2758y.m3112f();
        if (c2758y.m3110d() && c2758y.m3110d()) {
            int i11 = 0;
            int i12 = 4;
            while (i11 < i12) {
                int i13 = 0;
                while (i13 < i6) {
                    if (c2758y.m3110d()) {
                        int iMin = Math.min(64, 1 << ((i11 << 1) + 4));
                        if (i11 > 1) {
                            c2758y.m3113g();
                        }
                        for (int i14 = 0; i14 < iMin; i14++) {
                            c2758y.m3113g();
                        }
                    } else {
                        c2758y.m3112f();
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
        c2758y.m3116j(i3);
        if (c2758y.m3110d()) {
            c2758y.m3116j(8);
            c2758y.m3112f();
            c2758y.m3112f();
            c2758y.m3115i();
        }
        int iM3112f10 = c2758y.m3112f();
        boolean zM3110d2 = false;
        int i15 = 0;
        for (int i16 = 0; i16 < iM3112f10; i16++) {
            if (i16 != 0) {
                zM3110d2 = c2758y.m3110d();
            }
            if (zM3110d2) {
                c2758y.m3115i();
                c2758y.m3112f();
                for (int i17 = 0; i17 <= i15; i17++) {
                    if (c2758y.m3110d()) {
                        c2758y.m3115i();
                    }
                }
            } else {
                int iM3112f11 = c2758y.m3112f();
                int iM3112f12 = c2758y.m3112f();
                int i18 = iM3112f11 + iM3112f12;
                for (int i19 = 0; i19 < iM3112f11; i19++) {
                    c2758y.m3112f();
                    c2758y.m3115i();
                }
                for (int i20 = 0; i20 < iM3112f12; i20++) {
                    c2758y.m3112f();
                    c2758y.m3115i();
                }
                i15 = i18;
            }
        }
        if (c2758y.m3110d()) {
            for (int i21 = 0; i21 < c2758y.m3112f(); i21++) {
                c2758y.m3116j(iM3112f9 + 4 + 1);
            }
        }
        c2758y.m3116j(2);
        float f = 1.0f;
        if (c2758y.m3110d()) {
            if (c2758y.m3110d()) {
                int iM3111e5 = c2758y.m3111e(8);
                if (iM3111e5 == 255) {
                    int iM3111e6 = c2758y.m3111e(16);
                    int iM3111e7 = c2758y.m3111e(16);
                    if (iM3111e6 != 0 && iM3111e7 != 0) {
                        f = iM3111e6 / iM3111e7;
                    }
                } else {
                    float[] fArr = f6754b;
                    if (iM3111e5 < fArr.length) {
                        f = fArr[iM3111e5];
                    } else {
                        C1643a.m852g0(46, "Unexpected aspect_ratio_idc value: ", iM3111e5, "NalUnitUtil");
                    }
                }
            }
            if (c2758y.m3110d()) {
                c2758y.m3115i();
            }
            if (c2758y.m3110d()) {
                c2758y.m3116j(4);
                if (c2758y.m3110d()) {
                    c2758y.m3116j(24);
                }
            }
            if (c2758y.m3110d()) {
                c2758y.m3112f();
                c2758y.m3112f();
            }
            c2758y.m3115i();
            if (c2758y.m3110d()) {
                iM3112f4 *= 2;
            }
        }
        return new a(iM3111e2, zM3110d, iM3111e3, i4, iArr, iM3111e4, iM3112f, iM3112f3, iM3112f4, f);
    }

    /* JADX INFO: renamed from: d */
    public static b m3057d(byte[] bArr, int i, int i2) {
        C2758y c2758y = new C2758y(bArr, i + 1, i2);
        int iM3112f = c2758y.m3112f();
        int iM3112f2 = c2758y.m3112f();
        c2758y.m3115i();
        return new b(iM3112f, iM3112f2, c2758y.m3110d());
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
    /* JADX INFO: renamed from: e */
    public static c m3058e(byte[] bArr, int i, int i2) {
        int iM3112f;
        boolean z2;
        int iM3112f2;
        boolean z3;
        int i3;
        boolean zM3110d;
        int i4;
        int i5;
        int i6;
        float f;
        int i7;
        int i8;
        C2758y c2758y = new C2758y(bArr, i + 1, i2);
        int iM3111e = c2758y.m3111e(8);
        int iM3111e2 = c2758y.m3111e(8);
        int iM3111e3 = c2758y.m3111e(8);
        int iM3112f3 = c2758y.m3112f();
        if (iM3111e == 100 || iM3111e == 110 || iM3111e == 122 || iM3111e == 244 || iM3111e == 44 || iM3111e == 83 || iM3111e == 86 || iM3111e == 118 || iM3111e == 128 || iM3111e == 138) {
            iM3112f = c2758y.m3112f();
            boolean zM3110d2 = iM3112f == 3 ? c2758y.m3110d() : false;
            c2758y.m3112f();
            c2758y.m3112f();
            c2758y.m3115i();
            if (c2758y.m3110d()) {
                int i9 = iM3112f != 3 ? 8 : 12;
                int i10 = 0;
                while (i10 < i9) {
                    if (c2758y.m3110d()) {
                        int i11 = i10 < 6 ? 16 : 64;
                        int iM3113g = 8;
                        int i12 = 8;
                        for (int i13 = 0; i13 < i11; i13++) {
                            if (iM3113g != 0) {
                                iM3113g = ((c2758y.m3113g() + i12) + 256) % 256;
                            }
                            if (iM3113g != 0) {
                                i12 = iM3113g;
                            }
                        }
                    }
                    i10++;
                }
            }
            z2 = zM3110d2;
        } else {
            iM3112f = 1;
            z2 = false;
        }
        int iM3112f4 = c2758y.m3112f() + 4;
        int iM3112f5 = c2758y.m3112f();
        if (iM3112f5 != 0) {
            if (iM3112f5 == 1) {
                boolean zM3110d3 = c2758y.m3110d();
                c2758y.m3113g();
                c2758y.m3113g();
                long jM3112f = c2758y.m3112f();
                iM3112f5 = iM3112f5;
                for (int i14 = 0; i14 < jM3112f; i14++) {
                    c2758y.m3112f();
                }
                z3 = zM3110d3;
                i3 = 0;
            } else {
                iM3112f2 = 0;
            }
            c2758y.m3112f();
            c2758y.m3115i();
            int iM3112f6 = c2758y.m3112f() + 1;
            int iM3112f7 = c2758y.m3112f() + 1;
            zM3110d = c2758y.m3110d();
            i4 = 2 - (zM3110d ? 1 : 0);
            int i15 = iM3112f7 * i4;
            if (!zM3110d) {
                c2758y.m3115i();
            }
            c2758y.m3115i();
            i5 = iM3112f6 * 16;
            i6 = i15 * 16;
            if (c2758y.m3110d()) {
                int iM3112f8 = c2758y.m3112f();
                int iM3112f9 = c2758y.m3112f();
                int iM3112f10 = c2758y.m3112f();
                int iM3112f11 = c2758y.m3112f();
                if (iM3112f == 0) {
                    i8 = 1;
                } else {
                    if (iM3112f == 3) {
                        i7 = 1;
                    } else {
                        i7 = 2;
                    }
                    i4 *= iM3112f == 1 ? 2 : 1;
                    i8 = i7;
                }
                i5 -= (iM3112f8 + iM3112f9) * i8;
                i6 -= (iM3112f10 + iM3112f11) * i4;
            } else {
                i3 = i3;
            }
            int i16 = i5;
            int i17 = i6;
            if (c2758y.m3110d() || !c2758y.m3110d()) {
                f = 1.0f;
            } else {
                int iM3111e4 = c2758y.m3111e(8);
                if (iM3111e4 == 255) {
                    int iM3111e5 = c2758y.m3111e(16);
                    int iM3111e6 = c2758y.m3111e(16);
                    if (iM3111e5 == 0 || iM3111e6 == 0) {
                        f = 1.0f;
                    } else {
                        f = iM3111e5 / iM3111e6;
                    }
                } else {
                    float[] fArr = f6754b;
                    if (iM3111e4 < fArr.length) {
                        f = fArr[iM3111e4];
                    } else {
                        C1643a.m852g0(46, "Unexpected aspect_ratio_idc value: ", iM3111e4, "NalUnitUtil");
                        f = 1.0f;
                    }
                }
            }
            return new c(iM3111e, iM3111e2, iM3111e3, iM3112f3, i16, i17, f, z2, zM3110d, iM3112f4, iM3112f5, i3, z3);
        }
        iM3112f2 = c2758y.m3112f() + 4;
        i3 = iM3112f2;
        z3 = false;
        c2758y.m3112f();
        c2758y.m3115i();
        int iM3112f12 = c2758y.m3112f() + 1;
        int iM3112f13 = c2758y.m3112f() + 1;
        zM3110d = c2758y.m3110d();
        i4 = 2 - (zM3110d ? 1 : 0);
        int i18 = iM3112f13 * i4;
        if (!zM3110d) {
            c2758y.m3115i();
        }
        c2758y.m3115i();
        i5 = iM3112f12 * 16;
        i6 = i18 * 16;
        if (c2758y.m3110d()) {
            int iM3112f14 = c2758y.m3112f();
            int iM3112f15 = c2758y.m3112f();
            int iM3112f16 = c2758y.m3112f();
            int iM3112f17 = c2758y.m3112f();
            if (iM3112f == 0) {
                i8 = 1;
            } else {
                if (iM3112f == 3) {
                    i7 = 1;
                } else {
                    i7 = 2;
                }
                i4 *= iM3112f == 1 ? 2 : 1;
                i8 = i7;
            }
            i5 -= (iM3112f14 + iM3112f15) * i8;
            i6 -= (iM3112f16 + iM3112f17) * i4;
        } else {
            i3 = i3;
        }
        int i19 = i5;
        int i110 = i6;
        if (c2758y.m3110d()) {
            f = 1.0f;
        } else {
            f = 1.0f;
        }
        return new c(iM3111e, iM3111e2, iM3111e3, iM3112f3, i19, i110, f, z2, zM3110d, iM3112f4, iM3112f5, i3, z3);
    }

    /* JADX INFO: renamed from: f */
    public static int m3059f(byte[] bArr, int i) {
        int i2;
        synchronized (f6755c) {
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
                    int[] iArr = f6756d;
                    if (iArr.length <= i4) {
                        f6756d = Arrays.copyOf(iArr, iArr.length * 2);
                    }
                    f6756d[i4] = i3;
                    i3 += 3;
                    i4++;
                }
            }
            i2 = i - i4;
            int i5 = 0;
            int i6 = 0;
            for (int i7 = 0; i7 < i4; i7++) {
                int i8 = f6756d[i7] - i6;
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
