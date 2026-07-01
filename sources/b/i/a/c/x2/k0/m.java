package b.i.a.c.x2.k0;

import androidx.annotation.Nullable;
import b.i.a.c.j1;
import b.i.a.c.j1$b;
import java.util.Arrays;

/* JADX INFO: compiled from: DtsReader.java */
/* JADX INFO: loaded from: classes3.dex */
public final class m implements o {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public final String f1265b;
    public String c;
    public b.i.a.c.x2.w d;
    public int f;
    public int g;
    public long h;
    public j1 i;
    public int j;
    public final b.i.a.c.f3.x a = new b.i.a.c.f3.x(new byte[18]);
    public int e = 0;
    public long k = -9223372036854775807L;

    public m(@Nullable String str) {
        this.f1265b = str;
    }

    /* JADX WARN: Code duplicated, block: B:71:0x0220  */
    /* JADX WARN: Code duplicated, block: B:74:0x022e  */
    /* JADX WARN: Code duplicated, block: B:76:0x0231  */
    /* JADX WARN: Code duplicated, block: B:78:0x0235  */
    /* JADX WARN: Code duplicated, block: B:79:0x023f  */
    /* JADX WARN: Code duplicated, block: B:80:0x0249  */
    /* JADX WARN: Code duplicated, block: B:82:0x0256  */
    @Override // b.i.a.c.x2.k0.o
    public void b(b.i.a.c.f3.x xVar) {
        int i;
        int i2;
        byte b2;
        boolean z2;
        int i3;
        byte b3;
        int i4;
        byte b4;
        int i5;
        byte b5;
        int i6;
        byte b6;
        b.i.a.c.f3.w wVar;
        int i7;
        int i8;
        boolean z3;
        b.c.a.a0.d.H(this.d);
        while (xVar.a() > 0) {
            int i9 = this.e;
            int i10 = 8;
            int i11 = 2;
            if (i9 == 0) {
                while (true) {
                    if (xVar.a() <= 0) {
                        z3 = false;
                        break;
                    }
                    int i12 = this.g << 8;
                    this.g = i12;
                    int iT = i12 | xVar.t();
                    this.g = iT;
                    if (iT == 2147385345 || iT == -25230976 || iT == 536864768 || iT == -14745368) {
                        byte[] bArr = this.a.a;
                        bArr[0] = (byte) ((iT >> 24) & 255);
                        bArr[1] = (byte) ((iT >> 16) & 255);
                        bArr[2] = (byte) ((iT >> 8) & 255);
                        bArr[3] = (byte) (iT & 255);
                        this.f = 4;
                        this.g = 0;
                        z3 = true;
                        break;
                    }
                }
                if (z3) {
                    this.e = 1;
                }
            } else if (i9 == 1) {
                byte[] bArr2 = this.a.a;
                int iMin = Math.min(xVar.a(), 18 - this.f);
                System.arraycopy(xVar.a, xVar.f984b, bArr2, this.f, iMin);
                xVar.f984b += iMin;
                int i13 = this.f + iMin;
                this.f = i13;
                if (i13 == 18) {
                    byte[] bArr3 = this.a.a;
                    if (this.i == null) {
                        String str = this.c;
                        String str2 = this.f1265b;
                        if (bArr3[0] == 127) {
                            wVar = new b.i.a.c.f3.w(bArr3);
                        } else {
                            byte[] bArrCopyOf = Arrays.copyOf(bArr3, bArr3.length);
                            if (bArrCopyOf[0] == -2 || bArrCopyOf[0] == -1) {
                                for (int i14 = 0; i14 < bArrCopyOf.length - 1; i14 += 2) {
                                    byte b7 = bArrCopyOf[i14];
                                    int i15 = i14 + 1;
                                    bArrCopyOf[i14] = bArrCopyOf[i15];
                                    bArrCopyOf[i15] = b7;
                                }
                            }
                            b.i.a.c.f3.w wVar2 = new b.i.a.c.f3.w(bArrCopyOf);
                            if (bArrCopyOf[0] == 31) {
                                b.i.a.c.f3.w wVar3 = new b.i.a.c.f3.w(bArrCopyOf);
                                while (wVar3.b() >= 16) {
                                    wVar3.m(i11);
                                    int iG = wVar3.g(14) & 16383;
                                    int iMin2 = Math.min(8 - wVar2.c, 14);
                                    int i16 = wVar2.c;
                                    int i17 = (8 - i16) - iMin2;
                                    byte[] bArr4 = wVar2.a;
                                    int i18 = wVar2.f983b;
                                    bArr4[i18] = (byte) (((65280 >> i16) | ((1 << i17) - 1)) & bArr4[i18]);
                                    int i19 = 14 - iMin2;
                                    bArr4[i18] = (byte) (((iG >>> i19) << i17) | bArr4[i18]);
                                    int i20 = i18 + 1;
                                    while (i19 > i10) {
                                        i19 -= 8;
                                        wVar2.a[i20] = (byte) (iG >>> i19);
                                        i20++;
                                        i10 = 8;
                                    }
                                    int i21 = 8 - i19;
                                    byte[] bArr5 = wVar2.a;
                                    bArr5[i20] = (byte) (bArr5[i20] & ((1 << i21) - 1));
                                    bArr5[i20] = (byte) (((((1 << i19) - 1) & iG) << i21) | bArr5[i20]);
                                    wVar2.m(14);
                                    wVar2.a();
                                    i10 = 8;
                                    i11 = 2;
                                }
                            }
                            int length = bArrCopyOf.length;
                            wVar2.a = bArrCopyOf;
                            wVar2.f983b = 0;
                            wVar2.c = 0;
                            wVar2.d = length;
                            wVar = wVar2;
                        }
                        wVar.m(60);
                        int i22 = b.i.a.c.t2.x.a[wVar.g(6)];
                        int i23 = b.i.a.c.t2.x.f1136b[wVar.g(4)];
                        int iG2 = wVar.g(5);
                        int[] iArr = b.i.a.c.t2.x.c;
                        if (iG2 >= iArr.length) {
                            i8 = -1;
                            i7 = 2;
                        } else {
                            int i24 = iArr[iG2] * 1000;
                            i7 = 2;
                            i8 = i24 / 2;
                        }
                        wVar.m(10);
                        int i25 = i22 + (wVar.g(i7) > 0 ? 1 : 0);
                        j1$b j1_b = new j1$b();
                        j1_b.a = str;
                        j1_b.k = "audio/vnd.dts";
                        j1_b.f = i8;
                        j1_b.f1023x = i25;
                        j1_b.f1024y = i23;
                        j1_b.n = null;
                        j1_b.c = str2;
                        j1 j1VarA = j1_b.a();
                        this.i = j1VarA;
                        this.d.e(j1VarA);
                    }
                    byte b8 = bArr3[0];
                    if (b8 != -2) {
                        if (b8 == -1) {
                            i6 = ((3 & bArr3[7]) << 12) | ((bArr3[6] & 255) << 4);
                            b6 = bArr3[9];
                        } else if (b8 != 31) {
                            i = 4;
                            i2 = ((3 & bArr3[5]) << 12) | ((bArr3[6] & 255) << 4);
                            b2 = bArr3[7];
                        } else {
                            i6 = ((3 & bArr3[6]) << 12) | ((bArr3[7] & 255) << 4);
                            b6 = bArr3[8];
                        }
                        i3 = (i6 | ((b6 & 60) >> 2)) + 1;
                        z2 = true;
                        if (z2) {
                            i3 = (i3 * 16) / 14;
                        }
                        this.j = i3;
                        b3 = bArr3[0];
                        if (b3 != -2) {
                            if (b3 != -1) {
                                int i26 = (bArr3[4] & 7) << 4;
                                b5 = bArr3[7];
                                i4 = i26;
                            } else if (b3 != 31) {
                                i4 = (bArr3[4] & 1) << 6;
                                b4 = bArr3[5];
                            } else {
                                i4 = (7 & bArr3[5]) << 4;
                                b5 = bArr3[6];
                            }
                            i5 = b5 & 60;
                            this.h = (int) ((((long) ((((i5 >> 2) | i4) + 1) * 32)) * 1000000) / ((long) this.i.K));
                            this.a.E(0);
                            this.d.c(this.a, 18);
                            this.e = 2;
                        } else {
                            i4 = (bArr3[5] & 1) << 6;
                            b4 = bArr3[4];
                        }
                        i5 = b4 & 252;
                        this.h = (int) ((((long) ((((i5 >> 2) | i4) + 1) * 32)) * 1000000) / ((long) this.i.K));
                        this.a.E(0);
                        this.d.c(this.a, 18);
                        this.e = 2;
                    } else {
                        i = 4;
                        i2 = ((bArr3[4] & 3) << 12) | ((bArr3[7] & 255) << 4);
                        b2 = bArr3[6];
                    }
                    i3 = (i2 | ((b2 & 240) >> i)) + 1;
                    z2 = false;
                    if (z2) {
                        i3 = (i3 * 16) / 14;
                    }
                    this.j = i3;
                    b3 = bArr3[0];
                    if (b3 != -2) {
                        if (b3 != -1) {
                            int i27 = (bArr3[4] & 7) << 4;
                            b5 = bArr3[7];
                            i4 = i27;
                        } else if (b3 != 31) {
                            i4 = (bArr3[4] & 1) << 6;
                            b4 = bArr3[5];
                        } else {
                            i4 = (7 & bArr3[5]) << 4;
                            b5 = bArr3[6];
                        }
                        i5 = b5 & 60;
                        this.h = (int) ((((long) ((((i5 >> 2) | i4) + 1) * 32)) * 1000000) / ((long) this.i.K));
                        this.a.E(0);
                        this.d.c(this.a, 18);
                        this.e = 2;
                    } else {
                        i4 = (bArr3[5] & 1) << 6;
                        b4 = bArr3[4];
                    }
                    i5 = b4 & 252;
                    this.h = (int) ((((long) ((((i5 >> 2) | i4) + 1) * 32)) * 1000000) / ((long) this.i.K));
                    this.a.E(0);
                    this.d.c(this.a, 18);
                    this.e = 2;
                }
            } else {
                if (i9 != 2) {
                    throw new IllegalStateException();
                }
                int iMin3 = Math.min(xVar.a(), this.j - this.f);
                this.d.c(xVar, iMin3);
                int i28 = this.f + iMin3;
                this.f = i28;
                int i29 = this.j;
                if (i28 == i29) {
                    long j = this.k;
                    if (j != -9223372036854775807L) {
                        this.d.d(j, 1, i29, 0, null);
                        this.k += this.h;
                    }
                    this.e = 0;
                }
            }
        }
    }

    @Override // b.i.a.c.x2.k0.o
    public void c() {
        this.e = 0;
        this.f = 0;
        this.g = 0;
        this.k = -9223372036854775807L;
    }

    @Override // b.i.a.c.x2.k0.o
    public void d() {
    }

    @Override // b.i.a.c.x2.k0.o
    public void e(b.i.a.c.x2.j jVar, i0$d i0_d) {
        i0_d.a();
        this.c = i0_d.b();
        this.d = jVar.p(i0_d.c(), 1);
    }

    @Override // b.i.a.c.x2.k0.o
    public void f(long j, int i) {
        if (j != -9223372036854775807L) {
            this.k = j;
        }
    }
}
