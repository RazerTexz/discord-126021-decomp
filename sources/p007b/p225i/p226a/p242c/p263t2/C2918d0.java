package p007b.p225i.p226a.p242c.p263t2;

import com.discord.utilities.rest.SendUtils;
import java.util.Arrays;
import p007b.p085c.p086a.p087a0.C1460d;

/* JADX INFO: renamed from: b.i.a.c.t2.d0 */
/* JADX INFO: compiled from: Sonic.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C2918d0 {

    /* JADX INFO: renamed from: a */
    public final int f7702a;

    /* JADX INFO: renamed from: b */
    public final int f7703b;

    /* JADX INFO: renamed from: c */
    public final float f7704c;

    /* JADX INFO: renamed from: d */
    public final float f7705d;

    /* JADX INFO: renamed from: e */
    public final float f7706e;

    /* JADX INFO: renamed from: f */
    public final int f7707f;

    /* JADX INFO: renamed from: g */
    public final int f7708g;

    /* JADX INFO: renamed from: h */
    public final int f7709h;

    /* JADX INFO: renamed from: i */
    public final short[] f7710i;

    /* JADX INFO: renamed from: j */
    public short[] f7711j;

    /* JADX INFO: renamed from: k */
    public int f7712k;

    /* JADX INFO: renamed from: l */
    public short[] f7713l;

    /* JADX INFO: renamed from: m */
    public int f7714m;

    /* JADX INFO: renamed from: n */
    public short[] f7715n;

    /* JADX INFO: renamed from: o */
    public int f7716o;

    /* JADX INFO: renamed from: p */
    public int f7717p;

    /* JADX INFO: renamed from: q */
    public int f7718q;

    /* JADX INFO: renamed from: r */
    public int f7719r;

    /* JADX INFO: renamed from: s */
    public int f7720s;

    /* JADX INFO: renamed from: t */
    public int f7721t;

    /* JADX INFO: renamed from: u */
    public int f7722u;

    /* JADX INFO: renamed from: v */
    public int f7723v;

    public C2918d0(int i, int i2, float f, float f2, int i3) {
        this.f7702a = i;
        this.f7703b = i2;
        this.f7704c = f;
        this.f7705d = f2;
        this.f7706e = i / i3;
        this.f7707f = i / 400;
        int i4 = i / 65;
        this.f7708g = i4;
        int i5 = i4 * 2;
        this.f7709h = i5;
        this.f7710i = new short[i5];
        this.f7711j = new short[i5 * i2];
        this.f7713l = new short[i5 * i2];
        this.f7715n = new short[i5 * i2];
    }

    /* JADX INFO: renamed from: e */
    public static void m3479e(int i, int i2, short[] sArr, int i3, short[] sArr2, int i4, short[] sArr3, int i5) {
        for (int i6 = 0; i6 < i2; i6++) {
            int i7 = (i3 * i2) + i6;
            int i8 = (i5 * i2) + i6;
            int i9 = (i4 * i2) + i6;
            for (int i10 = 0; i10 < i; i10++) {
                sArr[i7] = (short) (((sArr3[i8] * i10) + ((i - i10) * sArr2[i9])) / i);
                i7 += i2;
                i9 += i2;
                i8 += i2;
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m3480a(short[] sArr, int i, int i2) {
        short[] sArrM3482c = m3482c(this.f7713l, this.f7714m, i2);
        this.f7713l = sArrM3482c;
        int i3 = this.f7703b;
        System.arraycopy(sArr, i * i3, sArrM3482c, this.f7714m * i3, i3 * i2);
        this.f7714m += i2;
    }

    /* JADX INFO: renamed from: b */
    public final void m3481b(short[] sArr, int i, int i2) {
        int i3 = this.f7709h / i2;
        int i4 = this.f7703b;
        int i5 = i2 * i4;
        int i6 = i * i4;
        for (int i7 = 0; i7 < i3; i7++) {
            int i8 = 0;
            for (int i9 = 0; i9 < i5; i9++) {
                i8 += sArr[(i7 * i5) + i6 + i9];
            }
            this.f7710i[i7] = (short) (i8 / i5);
        }
    }

    /* JADX INFO: renamed from: c */
    public final short[] m3482c(short[] sArr, int i, int i2) {
        int length = sArr.length;
        int i3 = this.f7703b;
        int i4 = length / i3;
        return i + i2 <= i4 ? sArr : Arrays.copyOf(sArr, (((i4 * 3) / 2) + i2) * i3);
    }

    /* JADX INFO: renamed from: d */
    public final int m3483d(short[] sArr, int i, int i2, int i3) {
        int i4 = i * this.f7703b;
        int i5 = 1;
        int i6 = 255;
        int i7 = 0;
        int i8 = 0;
        while (i2 <= i3) {
            int iAbs = 0;
            for (int i9 = 0; i9 < i2; i9++) {
                iAbs += Math.abs(sArr[i4 + i9] - sArr[(i4 + i2) + i9]);
            }
            if (iAbs * i7 < i5 * i2) {
                i7 = i2;
                i5 = iAbs;
            }
            if (iAbs * i6 > i8 * i2) {
                i6 = i2;
                i8 = iAbs;
            }
            i2++;
        }
        this.f7722u = i5 / i7;
        this.f7723v = i8 / i6;
        return i7;
    }

    /* JADX INFO: renamed from: f */
    public final void m3484f() {
        int iM3483d;
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7 = this.f7714m;
        float f = this.f7704c;
        float f2 = this.f7705d;
        float f3 = f / f2;
        float f4 = this.f7706e * f2;
        double d = f3;
        float f5 = 1.0f;
        int i8 = 1;
        if (d > 1.00001d || d < 0.99999d) {
            int i9 = this.f7712k;
            if (i9 >= this.f7709h) {
                int i10 = 0;
                while (true) {
                    int i11 = this.f7719r;
                    if (i11 > 0) {
                        int iMin = Math.min(this.f7709h, i11);
                        m3480a(this.f7711j, i10, iMin);
                        this.f7719r -= iMin;
                        i10 += iMin;
                    } else {
                        short[] sArr = this.f7711j;
                        int i12 = this.f7702a;
                        int i13 = i12 > 4000 ? i12 / SendUtils.MAX_MESSAGE_CHARACTER_COUNT_PREMIUM : 1;
                        if (this.f7703b == i8 && i13 == i8) {
                            iM3483d = m3483d(sArr, i10, this.f7707f, this.f7708g);
                        } else {
                            m3481b(sArr, i10, i13);
                            int iM3483d2 = m3483d(this.f7710i, 0, this.f7707f / i13, this.f7708g / i13);
                            if (i13 != i8) {
                                int i14 = iM3483d2 * i13;
                                int i15 = i13 * 4;
                                int i16 = i14 - i15;
                                int i17 = i14 + i15;
                                int i18 = this.f7707f;
                                if (i16 < i18) {
                                    i16 = i18;
                                }
                                int i19 = this.f7708g;
                                if (i17 > i19) {
                                    i17 = i19;
                                }
                                if (this.f7703b == i8) {
                                    iM3483d = m3483d(sArr, i10, i16, i17);
                                } else {
                                    m3481b(sArr, i10, i8);
                                    iM3483d = m3483d(this.f7710i, 0, i16, i17);
                                }
                            } else {
                                iM3483d = iM3483d2;
                            }
                        }
                        int i20 = this.f7722u;
                        int i21 = i20 != 0 && this.f7720s != 0 && this.f7723v <= i20 * 3 && i20 * 2 > this.f7721t * 3 ? this.f7720s : iM3483d;
                        this.f7721t = i20;
                        this.f7720s = iM3483d;
                        if (d > 1.0d) {
                            short[] sArr2 = this.f7711j;
                            if (f3 >= 2.0f) {
                                i2 = (int) (i21 / (f3 - f5));
                            } else {
                                this.f7719r = (int) (((2.0f - f3) * i21) / (f3 - f5));
                                i2 = i21;
                            }
                            short[] sArrM3482c = m3482c(this.f7713l, this.f7714m, i2);
                            this.f7713l = sArrM3482c;
                            int i22 = i2;
                            m3479e(i2, this.f7703b, sArrM3482c, this.f7714m, sArr2, i10, sArr2, i10 + i21);
                            this.f7714m += i22;
                            i10 = i21 + i22 + i10;
                        } else {
                            int i23 = i21;
                            short[] sArr3 = this.f7711j;
                            if (f3 < 0.5f) {
                                i = (int) ((i23 * f3) / (f5 - f3));
                            } else {
                                this.f7719r = (int) ((((2.0f * f3) - f5) * i23) / (f5 - f3));
                                i = i23;
                            }
                            int i24 = i23 + i;
                            short[] sArrM3482c2 = m3482c(this.f7713l, this.f7714m, i24);
                            this.f7713l = sArrM3482c2;
                            int i25 = this.f7703b;
                            System.arraycopy(sArr3, i10 * i25, sArrM3482c2, this.f7714m * i25, i25 * i23);
                            m3479e(i, this.f7703b, this.f7713l, this.f7714m + i23, sArr3, i10 + i23, sArr3, i10);
                            this.f7714m += i24;
                            i10 += i;
                        }
                    }
                    if (this.f7709h + i10 > i9) {
                        break;
                    }
                    f5 = 1.0f;
                    i8 = 1;
                }
                int i26 = this.f7712k - i10;
                short[] sArr4 = this.f7711j;
                int i27 = this.f7703b;
                System.arraycopy(sArr4, i10 * i27, sArr4, 0, i27 * i26);
                this.f7712k = i26;
            }
            f5 = 1.0f;
        } else {
            m3480a(this.f7711j, 0, this.f7712k);
            this.f7712k = 0;
        }
        if (f4 == f5 || this.f7714m == i7) {
            return;
        }
        int i28 = this.f7702a;
        int i29 = (int) (i28 / f4);
        while (true) {
            if (i29 <= 16384 && i28 <= 16384) {
                break;
            }
            i29 /= 2;
            i28 /= 2;
        }
        int i30 = this.f7714m - i7;
        short[] sArrM3482c3 = m3482c(this.f7715n, this.f7716o, i30);
        this.f7715n = sArrM3482c3;
        short[] sArr5 = this.f7713l;
        int i31 = this.f7703b;
        System.arraycopy(sArr5, i7 * i31, sArrM3482c3, this.f7716o * i31, i31 * i30);
        this.f7714m = i7;
        this.f7716o += i30;
        int i32 = 0;
        while (true) {
            i3 = this.f7716o;
            i4 = i3 - 1;
            if (i32 >= i4) {
                break;
            }
            while (true) {
                i5 = this.f7717p + 1;
                int i33 = i5 * i29;
                i6 = this.f7718q;
                if (i33 <= i6 * i28) {
                    break;
                }
                this.f7713l = m3482c(this.f7713l, this.f7714m, 1);
                int i34 = 0;
                while (true) {
                    int i35 = this.f7703b;
                    if (i34 < i35) {
                        short[] sArr6 = this.f7713l;
                        int i36 = (this.f7714m * i35) + i34;
                        short[] sArr7 = this.f7715n;
                        int i37 = (i32 * i35) + i34;
                        short s2 = sArr7[i37];
                        short s3 = sArr7[i37 + i35];
                        int i38 = this.f7718q * i28;
                        int i39 = this.f7717p;
                        int i40 = i39 * i29;
                        int i41 = (i39 + 1) * i29;
                        int i42 = i41 - i38;
                        int i43 = i41 - i40;
                        sArr6[i36] = (short) ((((i43 - i42) * s3) + (s2 * i42)) / i43);
                        i34++;
                    }
                }
                this.f7718q++;
                this.f7714m++;
            }
            this.f7717p = i5;
            if (i5 == i28) {
                this.f7717p = 0;
                C1460d.m426D(i6 == i29);
                this.f7718q = 0;
            }
            i32++;
        }
        if (i4 == 0) {
            return;
        }
        short[] sArr8 = this.f7715n;
        int i44 = this.f7703b;
        System.arraycopy(sArr8, i4 * i44, sArr8, 0, (i3 - i4) * i44);
        this.f7716o -= i4;
    }
}
