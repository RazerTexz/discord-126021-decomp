package b.i.a.c.t2;

import b.c.a.a0.AnimatableValueParser;
import com.discord.utilities.rest.SendUtils;
import java.util.Arrays;

/* JADX INFO: renamed from: b.i.a.c.t2.d0, reason: use source file name */
/* JADX INFO: compiled from: Sonic.java */
/* JADX INFO: loaded from: classes3.dex */
public final class Sonic {
    public final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f1118b;
    public final float c;
    public final float d;
    public final float e;
    public final int f;
    public final int g;
    public final int h;
    public final short[] i;
    public short[] j;
    public int k;
    public short[] l;
    public int m;
    public short[] n;
    public int o;
    public int p;
    public int q;
    public int r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f1119s;
    public int t;
    public int u;
    public int v;

    public Sonic(int i, int i2, float f, float f2, int i3) {
        this.a = i;
        this.f1118b = i2;
        this.c = f;
        this.d = f2;
        this.e = i / i3;
        this.f = i / 400;
        int i4 = i / 65;
        this.g = i4;
        int i5 = i4 * 2;
        this.h = i5;
        this.i = new short[i5];
        this.j = new short[i5 * i2];
        this.l = new short[i5 * i2];
        this.n = new short[i5 * i2];
    }

    public static void e(int i, int i2, short[] sArr, int i3, short[] sArr2, int i4, short[] sArr3, int i5) {
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

    public final void a(short[] sArr, int i, int i2) {
        short[] sArrC = c(this.l, this.m, i2);
        this.l = sArrC;
        int i3 = this.f1118b;
        System.arraycopy(sArr, i * i3, sArrC, this.m * i3, i3 * i2);
        this.m += i2;
    }

    public final void b(short[] sArr, int i, int i2) {
        int i3 = this.h / i2;
        int i4 = this.f1118b;
        int i5 = i2 * i4;
        int i6 = i * i4;
        for (int i7 = 0; i7 < i3; i7++) {
            int i8 = 0;
            for (int i9 = 0; i9 < i5; i9++) {
                i8 += sArr[(i7 * i5) + i6 + i9];
            }
            this.i[i7] = (short) (i8 / i5);
        }
    }

    public final short[] c(short[] sArr, int i, int i2) {
        int length = sArr.length;
        int i3 = this.f1118b;
        int i4 = length / i3;
        return i + i2 <= i4 ? sArr : Arrays.copyOf(sArr, (((i4 * 3) / 2) + i2) * i3);
    }

    public final int d(short[] sArr, int i, int i2, int i3) {
        int i4 = i * this.f1118b;
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
        this.u = i5 / i7;
        this.v = i8 / i6;
        return i7;
    }

    public final void f() {
        int iD;
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7 = this.m;
        float f = this.c;
        float f2 = this.d;
        float f3 = f / f2;
        float f4 = this.e * f2;
        double d = f3;
        float f5 = 1.0f;
        int i8 = 1;
        if (d > 1.00001d || d < 0.99999d) {
            int i9 = this.k;
            if (i9 >= this.h) {
                int i10 = 0;
                while (true) {
                    int i11 = this.r;
                    if (i11 > 0) {
                        int iMin = Math.min(this.h, i11);
                        a(this.j, i10, iMin);
                        this.r -= iMin;
                        i10 += iMin;
                    } else {
                        short[] sArr = this.j;
                        int i12 = this.a;
                        int i13 = i12 > 4000 ? i12 / SendUtils.MAX_MESSAGE_CHARACTER_COUNT_PREMIUM : 1;
                        if (this.f1118b == i8 && i13 == i8) {
                            iD = d(sArr, i10, this.f, this.g);
                        } else {
                            b(sArr, i10, i13);
                            int iD2 = d(this.i, 0, this.f / i13, this.g / i13);
                            if (i13 != i8) {
                                int i14 = iD2 * i13;
                                int i15 = i13 * 4;
                                int i16 = i14 - i15;
                                int i17 = i14 + i15;
                                int i18 = this.f;
                                if (i16 < i18) {
                                    i16 = i18;
                                }
                                int i19 = this.g;
                                if (i17 > i19) {
                                    i17 = i19;
                                }
                                if (this.f1118b == i8) {
                                    iD = d(sArr, i10, i16, i17);
                                } else {
                                    b(sArr, i10, i8);
                                    iD = d(this.i, 0, i16, i17);
                                }
                            } else {
                                iD = iD2;
                            }
                        }
                        int i20 = this.u;
                        int i21 = i20 != 0 && this.f1119s != 0 && this.v <= i20 * 3 && i20 * 2 > this.t * 3 ? this.f1119s : iD;
                        this.t = i20;
                        this.f1119s = iD;
                        if (d > 1.0d) {
                            short[] sArr2 = this.j;
                            if (f3 >= 2.0f) {
                                i2 = (int) (i21 / (f3 - f5));
                            } else {
                                this.r = (int) (((2.0f - f3) * i21) / (f3 - f5));
                                i2 = i21;
                            }
                            short[] sArrC = c(this.l, this.m, i2);
                            this.l = sArrC;
                            int i22 = i2;
                            e(i2, this.f1118b, sArrC, this.m, sArr2, i10, sArr2, i10 + i21);
                            this.m += i22;
                            i10 = i21 + i22 + i10;
                        } else {
                            int i23 = i21;
                            short[] sArr3 = this.j;
                            if (f3 < 0.5f) {
                                i = (int) ((i23 * f3) / (f5 - f3));
                            } else {
                                this.r = (int) ((((2.0f * f3) - f5) * i23) / (f5 - f3));
                                i = i23;
                            }
                            int i24 = i23 + i;
                            short[] sArrC2 = c(this.l, this.m, i24);
                            this.l = sArrC2;
                            int i25 = this.f1118b;
                            System.arraycopy(sArr3, i10 * i25, sArrC2, this.m * i25, i25 * i23);
                            e(i, this.f1118b, this.l, this.m + i23, sArr3, i10 + i23, sArr3, i10);
                            this.m += i24;
                            i10 += i;
                        }
                    }
                    if (this.h + i10 > i9) {
                        break;
                    }
                    f5 = 1.0f;
                    i8 = 1;
                }
                int i26 = this.k - i10;
                short[] sArr4 = this.j;
                int i27 = this.f1118b;
                System.arraycopy(sArr4, i10 * i27, sArr4, 0, i27 * i26);
                this.k = i26;
            }
            f5 = 1.0f;
        } else {
            a(this.j, 0, this.k);
            this.k = 0;
        }
        if (f4 == f5 || this.m == i7) {
            return;
        }
        int i28 = this.a;
        int i29 = (int) (i28 / f4);
        while (true) {
            if (i29 <= 16384 && i28 <= 16384) {
                break;
            }
            i29 /= 2;
            i28 /= 2;
        }
        int i30 = this.m - i7;
        short[] sArrC3 = c(this.n, this.o, i30);
        this.n = sArrC3;
        short[] sArr5 = this.l;
        int i31 = this.f1118b;
        System.arraycopy(sArr5, i7 * i31, sArrC3, this.o * i31, i31 * i30);
        this.m = i7;
        this.o += i30;
        int i32 = 0;
        while (true) {
            i3 = this.o;
            i4 = i3 - 1;
            if (i32 >= i4) {
                break;
            }
            while (true) {
                i5 = this.p + 1;
                int i33 = i5 * i29;
                i6 = this.q;
                if (i33 <= i6 * i28) {
                    break;
                }
                this.l = c(this.l, this.m, 1);
                int i34 = 0;
                while (true) {
                    int i35 = this.f1118b;
                    if (i34 < i35) {
                        short[] sArr6 = this.l;
                        int i36 = (this.m * i35) + i34;
                        short[] sArr7 = this.n;
                        int i37 = (i32 * i35) + i34;
                        short s2 = sArr7[i37];
                        short s3 = sArr7[i37 + i35];
                        int i38 = this.q * i28;
                        int i39 = this.p;
                        int i40 = i39 * i29;
                        int i41 = (i39 + 1) * i29;
                        int i42 = i41 - i38;
                        int i43 = i41 - i40;
                        sArr6[i36] = (short) ((((i43 - i42) * s3) + (s2 * i42)) / i43);
                        i34++;
                    }
                }
                this.q++;
                this.m++;
            }
            this.p = i5;
            if (i5 == i28) {
                this.p = 0;
                AnimatableValueParser.D(i6 == i29);
                this.q = 0;
            }
            i32++;
        }
        if (i4 == 0) {
            return;
        }
        short[] sArr8 = this.n;
        int i44 = this.f1118b;
        System.arraycopy(sArr8, i4 * i44, sArr8, 0, (i3 - i4) * i44);
        this.o -= i4;
    }
}
