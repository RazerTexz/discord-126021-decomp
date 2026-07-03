package p007b.p225i.p226a.p242c.p267x2.p276k0;

import androidx.annotation.Nullable;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p225i.p226a.p242c.C2811j1;
import p007b.p225i.p226a.p242c.p259f3.C2738e0;
import p007b.p225i.p226a.p242c.p259f3.C2756w;
import p007b.p225i.p226a.p242c.p259f3.C2757x;
import p007b.p225i.p226a.p242c.p263t2.C2929m;
import p007b.p225i.p226a.p242c.p267x2.InterfaceC3058j;
import p007b.p225i.p226a.p242c.p267x2.InterfaceC3122w;
import p007b.p225i.p226a.p242c.p267x2.p276k0.InterfaceC3087i0;

/* JADX INFO: renamed from: b.i.a.c.x2.k0.g */
/* JADX INFO: compiled from: Ac3Reader.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C3082g implements InterfaceC3094o {

    /* JADX INFO: renamed from: a */
    public final C2756w f8611a;

    /* JADX INFO: renamed from: b */
    public final C2757x f8612b;

    /* JADX INFO: renamed from: c */
    @Nullable
    public final String f8613c;

    /* JADX INFO: renamed from: d */
    public String f8614d;

    /* JADX INFO: renamed from: e */
    public InterfaceC3122w f8615e;

    /* JADX INFO: renamed from: f */
    public int f8616f;

    /* JADX INFO: renamed from: g */
    public int f8617g;

    /* JADX INFO: renamed from: h */
    public boolean f8618h;

    /* JADX INFO: renamed from: i */
    public long f8619i;

    /* JADX INFO: renamed from: j */
    public C2811j1 f8620j;

    /* JADX INFO: renamed from: k */
    public int f8621k;

    /* JADX INFO: renamed from: l */
    public long f8622l;

    public C3082g(@Nullable String str) {
        C2756w c2756w = new C2756w(new byte[128]);
        this.f8611a = c2756w;
        this.f8612b = new C2757x(c2756w.f6789a);
        this.f8616f = 0;
        this.f8622l = -9223372036854775807L;
        this.f8613c = str;
    }

    /* JADX WARN: Code duplicated, block: B:124:0x0204  */
    /* JADX WARN: Code duplicated, block: B:127:0x0212  */
    /* JADX WARN: Code duplicated, block: B:129:0x021a  */
    /* JADX WARN: Code duplicated, block: B:136:0x022e A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:137:0x0230  */
    /* JADX WARN: Code duplicated, block: B:138:0x0234  */
    /* JADX WARN: Code duplicated, block: B:140:0x0237  */
    /* JADX WARN: Code duplicated, block: B:142:0x023d  */
    /* JADX WARN: Code duplicated, block: B:256:0x0240 A[SYNTHETIC] */
    @Override // p007b.p225i.p226a.p242c.p267x2.p276k0.InterfaceC3094o
    /* JADX INFO: renamed from: b */
    public void mo3758b(C2757x c2757x) {
        int i;
        int i2;
        int i3;
        String str;
        int iM3067g;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        boolean z2;
        C1460d.m438H(this.f8615e);
        while (c2757x.m3081a() > 0) {
            int i13 = this.f8616f;
            if (i13 == 0) {
                while (true) {
                    if (c2757x.m3081a() <= 0) {
                        z2 = false;
                        break;
                    }
                    if (this.f8618h) {
                        int iM3100t = c2757x.m3100t();
                        if (iM3100t == 119) {
                            this.f8618h = false;
                            z2 = true;
                            break;
                        }
                        this.f8618h = iM3100t == 11;
                    } else {
                        this.f8618h = c2757x.m3100t() == 11;
                    }
                }
                if (z2) {
                    this.f8616f = 1;
                    byte[] bArr = this.f8612b.f6793a;
                    bArr[0] = 11;
                    bArr[1] = 119;
                    this.f8617g = 2;
                }
            } else if (i13 == 1) {
                byte[] bArr2 = this.f8612b.f6793a;
                int iMin = Math.min(c2757x.m3081a(), 128 - this.f8617g);
                System.arraycopy(c2757x.f6793a, c2757x.f6794b, bArr2, this.f8617g, iMin);
                c2757x.f6794b += iMin;
                int i14 = this.f8617g + iMin;
                this.f8617g = i14;
                if (i14 == 128) {
                    this.f8611a.m3071k(0);
                    C2756w c2756w = this.f8611a;
                    int iM3065e = c2756w.m3065e();
                    c2756w.m3073m(40);
                    boolean z3 = c2756w.m3067g(5) > 10;
                    c2756w.m3071k(iM3065e);
                    int i15 = -1;
                    if (z3) {
                        c2756w.m3073m(16);
                        int iM3067g2 = c2756w.m3067g(2);
                        if (iM3067g2 == 0) {
                            i15 = 0;
                        } else if (iM3067g2 == 1) {
                            i15 = 1;
                        } else if (iM3067g2 == 2) {
                            i15 = 2;
                        }
                        c2756w.m3073m(3);
                        iM3067g = (c2756w.m3067g(11) + 1) * 2;
                        int iM3067g3 = c2756w.m3067g(2);
                        if (iM3067g3 == 3) {
                            i6 = C2929m.f7771c[c2756w.m3067g(2)];
                            i5 = 6;
                            i4 = 3;
                        } else {
                            int iM3067g4 = c2756w.m3067g(2);
                            i4 = iM3067g4;
                            i5 = C2929m.f7769a[iM3067g4];
                            i6 = C2929m.f7770b[iM3067g3];
                        }
                        i3 = i5 * 256;
                        int iM3067g5 = c2756w.m3067g(3);
                        boolean zM3066f = c2756w.m3066f();
                        i2 = C2929m.f7772d[iM3067g5] + (zM3066f ? 1 : 0);
                        c2756w.m3073m(10);
                        if (c2756w.m3066f()) {
                            c2756w.m3073m(8);
                        }
                        if (iM3067g5 == 0) {
                            c2756w.m3073m(5);
                            if (c2756w.m3066f()) {
                                c2756w.m3073m(8);
                            }
                        }
                        if (i15 == 1 && c2756w.m3066f()) {
                            c2756w.m3073m(16);
                        }
                        if (c2756w.m3066f()) {
                            if (iM3067g5 > 2) {
                                c2756w.m3073m(2);
                            }
                            if ((iM3067g5 & 1) == 0 || iM3067g5 <= 2) {
                                i9 = 6;
                            } else {
                                i9 = 6;
                                c2756w.m3073m(6);
                            }
                            if ((iM3067g5 & 4) != 0) {
                                c2756w.m3073m(i9);
                            }
                            if (zM3066f && c2756w.m3066f()) {
                                c2756w.m3073m(5);
                            }
                            if (i15 == 0) {
                                if (c2756w.m3066f()) {
                                    i10 = 6;
                                    c2756w.m3073m(6);
                                } else {
                                    i10 = 6;
                                }
                                if (iM3067g5 == 0 && c2756w.m3066f()) {
                                    c2756w.m3073m(i10);
                                }
                                if (c2756w.m3066f()) {
                                    c2756w.m3073m(i10);
                                }
                                int iM3067g6 = c2756w.m3067g(2);
                                if (iM3067g6 == 1) {
                                    c2756w.m3073m(5);
                                } else if (iM3067g6 == 2) {
                                    c2756w.m3073m(12);
                                } else {
                                    if (iM3067g6 == 3) {
                                        int iM3067g7 = c2756w.m3067g(5);
                                        if (c2756w.m3066f()) {
                                            c2756w.m3073m(5);
                                            if (c2756w.m3066f()) {
                                                c2756w.m3073m(4);
                                            }
                                            if (c2756w.m3066f()) {
                                                c2756w.m3073m(4);
                                            }
                                            if (c2756w.m3066f()) {
                                                c2756w.m3073m(4);
                                            }
                                            if (c2756w.m3066f()) {
                                                c2756w.m3073m(4);
                                            }
                                            if (c2756w.m3066f()) {
                                                c2756w.m3073m(4);
                                            }
                                            if (c2756w.m3066f()) {
                                                c2756w.m3073m(4);
                                            }
                                            if (c2756w.m3066f()) {
                                                c2756w.m3073m(4);
                                            }
                                            if (c2756w.m3066f()) {
                                                if (c2756w.m3066f()) {
                                                    c2756w.m3073m(4);
                                                }
                                                if (c2756w.m3066f()) {
                                                    c2756w.m3073m(4);
                                                }
                                            }
                                        }
                                        if (c2756w.m3066f()) {
                                            c2756w.m3073m(5);
                                            if (c2756w.m3066f()) {
                                                c2756w.m3073m(7);
                                                if (c2756w.m3066f()) {
                                                    c2756w.m3073m(8);
                                                }
                                            }
                                        }
                                        i11 = 2;
                                        c2756w.m3073m((iM3067g7 + 2) * 8);
                                        c2756w.m3063c();
                                    }
                                    if (iM3067g5 < i11) {
                                        if (c2756w.m3066f()) {
                                            c2756w.m3073m(14);
                                        }
                                        if (iM3067g5 == 0 && c2756w.m3066f()) {
                                            c2756w.m3073m(14);
                                        }
                                    }
                                    if (c2756w.m3066f()) {
                                        if (i4 == 0) {
                                            c2756w.m3073m(5);
                                        } else {
                                            for (i12 = 0; i12 < i5; i12++) {
                                                if (c2756w.m3066f()) {
                                                    c2756w.m3073m(5);
                                                }
                                            }
                                        }
                                    }
                                }
                                i11 = 2;
                                if (iM3067g5 < i11) {
                                    if (c2756w.m3066f()) {
                                        c2756w.m3073m(14);
                                    }
                                    if (iM3067g5 == 0) {
                                        c2756w.m3073m(14);
                                    }
                                }
                                if (c2756w.m3066f()) {
                                    if (i4 == 0) {
                                        c2756w.m3073m(5);
                                    } else {
                                        while (i12 < i5) {
                                            if (c2756w.m3066f()) {
                                                c2756w.m3073m(5);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        if (c2756w.m3066f()) {
                            c2756w.m3073m(5);
                            if (iM3067g5 == 2) {
                                c2756w.m3073m(4);
                            }
                            if (iM3067g5 >= 6) {
                                c2756w.m3073m(2);
                            }
                            if (c2756w.m3066f()) {
                                i8 = 8;
                                c2756w.m3073m(8);
                            } else {
                                i8 = 8;
                            }
                            if (iM3067g5 == 0 && c2756w.m3066f()) {
                                c2756w.m3073m(i8);
                            }
                            if (iM3067g3 < 3) {
                                c2756w.m3072l();
                            }
                        }
                        if (i15 == 0 && i4 != 3) {
                            c2756w.m3072l();
                        }
                        if (i15 == 2 && (i4 == 3 || c2756w.m3066f())) {
                            i7 = 6;
                            c2756w.m3073m(6);
                        } else {
                            i7 = 6;
                        }
                        str = (c2756w.m3066f() && c2756w.m3067g(i7) == 1 && c2756w.m3067g(8) == 1) ? "audio/eac3-joc" : "audio/eac3";
                        i15 = i6;
                    } else {
                        c2756w.m3073m(32);
                        int iM3067g8 = c2756w.m3067g(2);
                        String str2 = iM3067g8 == 3 ? null : "audio/ac3";
                        int iM3491a = C2929m.m3491a(iM3067g8, c2756w.m3067g(6));
                        c2756w.m3073m(8);
                        int iM3067g9 = c2756w.m3067g(3);
                        if ((iM3067g9 & 1) == 0 || iM3067g9 == 1) {
                            i = 2;
                        } else {
                            i = 2;
                            c2756w.m3073m(2);
                        }
                        if ((iM3067g9 & 4) != 0) {
                            c2756w.m3073m(i);
                        }
                        if (iM3067g9 == i) {
                            c2756w.m3073m(i);
                        }
                        int[] iArr = C2929m.f7770b;
                        i15 = iM3067g8 < iArr.length ? iArr[iM3067g8] : -1;
                        i2 = C2929m.f7772d[iM3067g9] + (c2756w.m3066f() ? 1 : 0);
                        i3 = 1536;
                        str = str2;
                        iM3067g = iM3491a;
                    }
                    int i16 = i2;
                    C2811j1 c2811j1 = this.f8620j;
                    if (c2811j1 == null || i16 != c2811j1.f7136J || i15 != c2811j1.f7137K || !C2738e0.m2993a(str, c2811j1.f7155w)) {
                        C2811j1.b bVar = new C2811j1.b();
                        bVar.f7163a = this.f8614d;
                        bVar.f7173k = str;
                        bVar.f7186x = i16;
                        bVar.f7187y = i15;
                        bVar.f7165c = this.f8613c;
                        C2811j1 c2811j1M3277a = bVar.m3277a();
                        this.f8620j = c2811j1M3277a;
                        this.f8615e.mo2526e(c2811j1M3277a);
                    }
                    this.f8621k = iM3067g;
                    this.f8619i = (((long) i3) * 1000000) / ((long) this.f8620j.f7137K);
                    this.f8612b.m3079E(0);
                    this.f8615e.mo2524c(this.f8612b, 128);
                    this.f8616f = 2;
                }
            } else if (i13 == 2) {
                int iMin2 = Math.min(c2757x.m3081a(), this.f8621k - this.f8617g);
                this.f8615e.mo2524c(c2757x, iMin2);
                int i17 = this.f8617g + iMin2;
                this.f8617g = i17;
                int i18 = this.f8621k;
                if (i17 == i18) {
                    long j = this.f8622l;
                    if (j != -9223372036854775807L) {
                        this.f8615e.mo2525d(j, 1, i18, 0, null);
                        this.f8622l += this.f8619i;
                    }
                    this.f8616f = 0;
                }
            }
        }
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.p276k0.InterfaceC3094o
    /* JADX INFO: renamed from: c */
    public void mo3759c() {
        this.f8616f = 0;
        this.f8617g = 0;
        this.f8618h = false;
        this.f8622l = -9223372036854775807L;
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.p276k0.InterfaceC3094o
    /* JADX INFO: renamed from: d */
    public void mo3760d() {
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.p276k0.InterfaceC3094o
    /* JADX INFO: renamed from: e */
    public void mo3761e(InterfaceC3058j interfaceC3058j, InterfaceC3087i0.d dVar) {
        dVar.m3765a();
        this.f8614d = dVar.m3766b();
        this.f8615e = interfaceC3058j.mo2492p(dVar.m3767c(), 1);
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.p276k0.InterfaceC3094o
    /* JADX INFO: renamed from: f */
    public void mo3762f(long j, int i) {
        if (j != -9223372036854775807L) {
            this.f8622l = j;
        }
    }
}
