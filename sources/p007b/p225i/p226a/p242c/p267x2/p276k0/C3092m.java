package p007b.p225i.p226a.p242c.p267x2.p276k0;

import androidx.annotation.Nullable;
import java.util.Arrays;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p225i.p226a.p242c.C2811j1;
import p007b.p225i.p226a.p242c.p259f3.C2756w;
import p007b.p225i.p226a.p242c.p259f3.C2757x;
import p007b.p225i.p226a.p242c.p263t2.C2940x;
import p007b.p225i.p226a.p242c.p267x2.InterfaceC3058j;
import p007b.p225i.p226a.p242c.p267x2.InterfaceC3122w;
import p007b.p225i.p226a.p242c.p267x2.p276k0.InterfaceC3087i0;

/* JADX INFO: renamed from: b.i.a.c.x2.k0.m */
/* JADX INFO: compiled from: DtsReader.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C3092m implements InterfaceC3094o {

    /* JADX INFO: renamed from: b */
    @Nullable
    public final String f8724b;

    /* JADX INFO: renamed from: c */
    public String f8725c;

    /* JADX INFO: renamed from: d */
    public InterfaceC3122w f8726d;

    /* JADX INFO: renamed from: f */
    public int f8728f;

    /* JADX INFO: renamed from: g */
    public int f8729g;

    /* JADX INFO: renamed from: h */
    public long f8730h;

    /* JADX INFO: renamed from: i */
    public C2811j1 f8731i;

    /* JADX INFO: renamed from: j */
    public int f8732j;

    /* JADX INFO: renamed from: a */
    public final C2757x f8723a = new C2757x(new byte[18]);

    /* JADX INFO: renamed from: e */
    public int f8727e = 0;

    /* JADX INFO: renamed from: k */
    public long f8733k = -9223372036854775807L;

    public C3092m(@Nullable String str) {
        this.f8724b = str;
    }

    /* JADX WARN: Code duplicated, block: B:71:0x0220  */
    /* JADX WARN: Code duplicated, block: B:74:0x022e  */
    /* JADX WARN: Code duplicated, block: B:76:0x0231  */
    /* JADX WARN: Code duplicated, block: B:78:0x0235  */
    /* JADX WARN: Code duplicated, block: B:79:0x023f  */
    /* JADX WARN: Code duplicated, block: B:80:0x0249  */
    /* JADX WARN: Code duplicated, block: B:82:0x0256  */
    @Override // p007b.p225i.p226a.p242c.p267x2.p276k0.InterfaceC3094o
    /* JADX INFO: renamed from: b */
    public void mo3758b(C2757x c2757x) {
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
        C2756w c2756w;
        int i7;
        int i8;
        boolean z3;
        C1460d.m438H(this.f8726d);
        while (c2757x.m3081a() > 0) {
            int i9 = this.f8727e;
            int i10 = 8;
            int i11 = 2;
            if (i9 == 0) {
                while (true) {
                    if (c2757x.m3081a() <= 0) {
                        z3 = false;
                        break;
                    }
                    int i12 = this.f8729g << 8;
                    this.f8729g = i12;
                    int iM3100t = i12 | c2757x.m3100t();
                    this.f8729g = iM3100t;
                    if (iM3100t == 2147385345 || iM3100t == -25230976 || iM3100t == 536864768 || iM3100t == -14745368) {
                        byte[] bArr = this.f8723a.f6793a;
                        bArr[0] = (byte) ((iM3100t >> 24) & 255);
                        bArr[1] = (byte) ((iM3100t >> 16) & 255);
                        bArr[2] = (byte) ((iM3100t >> 8) & 255);
                        bArr[3] = (byte) (iM3100t & 255);
                        this.f8728f = 4;
                        this.f8729g = 0;
                        z3 = true;
                        break;
                    }
                }
                if (z3) {
                    this.f8727e = 1;
                }
            } else if (i9 == 1) {
                byte[] bArr2 = this.f8723a.f6793a;
                int iMin = Math.min(c2757x.m3081a(), 18 - this.f8728f);
                System.arraycopy(c2757x.f6793a, c2757x.f6794b, bArr2, this.f8728f, iMin);
                c2757x.f6794b += iMin;
                int i13 = this.f8728f + iMin;
                this.f8728f = i13;
                if (i13 == 18) {
                    byte[] bArr3 = this.f8723a.f6793a;
                    if (this.f8731i == null) {
                        String str = this.f8725c;
                        String str2 = this.f8724b;
                        if (bArr3[0] == 127) {
                            c2756w = new C2756w(bArr3);
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
                            C2756w c2756w2 = new C2756w(bArrCopyOf);
                            if (bArrCopyOf[0] == 31) {
                                C2756w c2756w3 = new C2756w(bArrCopyOf);
                                while (c2756w3.m3062b() >= 16) {
                                    c2756w3.m3073m(i11);
                                    int iM3067g = c2756w3.m3067g(14) & 16383;
                                    int iMin2 = Math.min(8 - c2756w2.f6791c, 14);
                                    int i16 = c2756w2.f6791c;
                                    int i17 = (8 - i16) - iMin2;
                                    byte[] bArr4 = c2756w2.f6789a;
                                    int i18 = c2756w2.f6790b;
                                    bArr4[i18] = (byte) (((65280 >> i16) | ((1 << i17) - 1)) & bArr4[i18]);
                                    int i19 = 14 - iMin2;
                                    bArr4[i18] = (byte) (((iM3067g >>> i19) << i17) | bArr4[i18]);
                                    int i20 = i18 + 1;
                                    while (i19 > i10) {
                                        i19 -= 8;
                                        c2756w2.f6789a[i20] = (byte) (iM3067g >>> i19);
                                        i20++;
                                        i10 = 8;
                                    }
                                    int i21 = 8 - i19;
                                    byte[] bArr5 = c2756w2.f6789a;
                                    bArr5[i20] = (byte) (bArr5[i20] & ((1 << i21) - 1));
                                    bArr5[i20] = (byte) (((((1 << i19) - 1) & iM3067g) << i21) | bArr5[i20]);
                                    c2756w2.m3073m(14);
                                    c2756w2.m3061a();
                                    i10 = 8;
                                    i11 = 2;
                                }
                            }
                            int length = bArrCopyOf.length;
                            c2756w2.f6789a = bArrCopyOf;
                            c2756w2.f6790b = 0;
                            c2756w2.f6791c = 0;
                            c2756w2.f6792d = length;
                            c2756w = c2756w2;
                        }
                        c2756w.m3073m(60);
                        int i22 = C2940x.f7846a[c2756w.m3067g(6)];
                        int i23 = C2940x.f7847b[c2756w.m3067g(4)];
                        int iM3067g2 = c2756w.m3067g(5);
                        int[] iArr = C2940x.f7848c;
                        if (iM3067g2 >= iArr.length) {
                            i8 = -1;
                            i7 = 2;
                        } else {
                            int i24 = iArr[iM3067g2] * 1000;
                            i7 = 2;
                            i8 = i24 / 2;
                        }
                        c2756w.m3073m(10);
                        int i25 = i22 + (c2756w.m3067g(i7) > 0 ? 1 : 0);
                        C2811j1.b bVar = new C2811j1.b();
                        bVar.f7163a = str;
                        bVar.f7173k = "audio/vnd.dts";
                        bVar.f7168f = i8;
                        bVar.f7186x = i25;
                        bVar.f7187y = i23;
                        bVar.f7176n = null;
                        bVar.f7165c = str2;
                        C2811j1 c2811j1M3277a = bVar.m3277a();
                        this.f8731i = c2811j1M3277a;
                        this.f8726d.mo2526e(c2811j1M3277a);
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
                        this.f8732j = i3;
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
                            this.f8730h = (int) ((((long) ((((i5 >> 2) | i4) + 1) * 32)) * 1000000) / ((long) this.f8731i.f7137K));
                            this.f8723a.m3079E(0);
                            this.f8726d.mo2524c(this.f8723a, 18);
                            this.f8727e = 2;
                        } else {
                            i4 = (bArr3[5] & 1) << 6;
                            b4 = bArr3[4];
                        }
                        i5 = b4 & 252;
                        this.f8730h = (int) ((((long) ((((i5 >> 2) | i4) + 1) * 32)) * 1000000) / ((long) this.f8731i.f7137K));
                        this.f8723a.m3079E(0);
                        this.f8726d.mo2524c(this.f8723a, 18);
                        this.f8727e = 2;
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
                    this.f8732j = i3;
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
                        this.f8730h = (int) ((((long) ((((i5 >> 2) | i4) + 1) * 32)) * 1000000) / ((long) this.f8731i.f7137K));
                        this.f8723a.m3079E(0);
                        this.f8726d.mo2524c(this.f8723a, 18);
                        this.f8727e = 2;
                    } else {
                        i4 = (bArr3[5] & 1) << 6;
                        b4 = bArr3[4];
                    }
                    i5 = b4 & 252;
                    this.f8730h = (int) ((((long) ((((i5 >> 2) | i4) + 1) * 32)) * 1000000) / ((long) this.f8731i.f7137K));
                    this.f8723a.m3079E(0);
                    this.f8726d.mo2524c(this.f8723a, 18);
                    this.f8727e = 2;
                }
            } else {
                if (i9 != 2) {
                    throw new IllegalStateException();
                }
                int iMin3 = Math.min(c2757x.m3081a(), this.f8732j - this.f8728f);
                this.f8726d.mo2524c(c2757x, iMin3);
                int i28 = this.f8728f + iMin3;
                this.f8728f = i28;
                int i29 = this.f8732j;
                if (i28 == i29) {
                    long j = this.f8733k;
                    if (j != -9223372036854775807L) {
                        this.f8726d.mo2525d(j, 1, i29, 0, null);
                        this.f8733k += this.f8730h;
                    }
                    this.f8727e = 0;
                }
            }
        }
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.p276k0.InterfaceC3094o
    /* JADX INFO: renamed from: c */
    public void mo3759c() {
        this.f8727e = 0;
        this.f8728f = 0;
        this.f8729g = 0;
        this.f8733k = -9223372036854775807L;
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.p276k0.InterfaceC3094o
    /* JADX INFO: renamed from: d */
    public void mo3760d() {
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.p276k0.InterfaceC3094o
    /* JADX INFO: renamed from: e */
    public void mo3761e(InterfaceC3058j interfaceC3058j, InterfaceC3087i0.d dVar) {
        dVar.m3765a();
        this.f8725c = dVar.m3766b();
        this.f8726d = interfaceC3058j.mo2492p(dVar.m3767c(), 1);
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.p276k0.InterfaceC3094o
    /* JADX INFO: renamed from: f */
    public void mo3762f(long j, int i) {
        if (j != -9223372036854775807L) {
            this.f8733k = j;
        }
    }
}
