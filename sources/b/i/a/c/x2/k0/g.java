package b.i.a.c.x2.k0;

import androidx.annotation.Nullable;
import b.i.a.c.j1;
import b.i.a.c.j1$b;

/* JADX INFO: compiled from: Ac3Reader.java */
/* JADX INFO: loaded from: classes3.dex */
public final class g implements o {
    public final b.i.a.c.f3.w a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b.i.a.c.f3.x f1249b;

    @Nullable
    public final String c;
    public String d;
    public b.i.a.c.x2.w e;
    public int f;
    public int g;
    public boolean h;
    public long i;
    public j1 j;
    public int k;
    public long l;

    public g(@Nullable String str) {
        b.i.a.c.f3.w wVar = new b.i.a.c.f3.w(new byte[128]);
        this.a = wVar;
        this.f1249b = new b.i.a.c.f3.x(wVar.a);
        this.f = 0;
        this.l = -9223372036854775807L;
        this.c = str;
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
    @Override // b.i.a.c.x2.k0.o
    public void b(b.i.a.c.f3.x xVar) {
        int i;
        int i2;
        int i3;
        String str;
        int iG;
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
        b.c.a.a0.d.H(this.e);
        while (xVar.a() > 0) {
            int i13 = this.f;
            if (i13 == 0) {
                while (true) {
                    if (xVar.a() <= 0) {
                        z2 = false;
                        break;
                    }
                    if (this.h) {
                        int iT = xVar.t();
                        if (iT == 119) {
                            this.h = false;
                            z2 = true;
                            break;
                        }
                        this.h = iT == 11;
                    } else {
                        this.h = xVar.t() == 11;
                    }
                }
                if (z2) {
                    this.f = 1;
                    byte[] bArr = this.f1249b.a;
                    bArr[0] = 11;
                    bArr[1] = 119;
                    this.g = 2;
                }
            } else if (i13 == 1) {
                byte[] bArr2 = this.f1249b.a;
                int iMin = Math.min(xVar.a(), 128 - this.g);
                System.arraycopy(xVar.a, xVar.f984b, bArr2, this.g, iMin);
                xVar.f984b += iMin;
                int i14 = this.g + iMin;
                this.g = i14;
                if (i14 == 128) {
                    this.a.k(0);
                    b.i.a.c.f3.w wVar = this.a;
                    int iE = wVar.e();
                    wVar.m(40);
                    boolean z3 = wVar.g(5) > 10;
                    wVar.k(iE);
                    int i15 = -1;
                    if (z3) {
                        wVar.m(16);
                        int iG2 = wVar.g(2);
                        if (iG2 == 0) {
                            i15 = 0;
                        } else if (iG2 == 1) {
                            i15 = 1;
                        } else if (iG2 == 2) {
                            i15 = 2;
                        }
                        wVar.m(3);
                        iG = (wVar.g(11) + 1) * 2;
                        int iG3 = wVar.g(2);
                        if (iG3 == 3) {
                            i6 = b.i.a.c.t2.m.c[wVar.g(2)];
                            i5 = 6;
                            i4 = 3;
                        } else {
                            int iG4 = wVar.g(2);
                            i4 = iG4;
                            i5 = b.i.a.c.t2.m.a[iG4];
                            i6 = b.i.a.c.t2.m.f1123b[iG3];
                        }
                        i3 = i5 * 256;
                        int iG5 = wVar.g(3);
                        boolean zF = wVar.f();
                        i2 = b.i.a.c.t2.m.d[iG5] + (zF ? 1 : 0);
                        wVar.m(10);
                        if (wVar.f()) {
                            wVar.m(8);
                        }
                        if (iG5 == 0) {
                            wVar.m(5);
                            if (wVar.f()) {
                                wVar.m(8);
                            }
                        }
                        if (i15 == 1 && wVar.f()) {
                            wVar.m(16);
                        }
                        if (wVar.f()) {
                            if (iG5 > 2) {
                                wVar.m(2);
                            }
                            if ((iG5 & 1) == 0 || iG5 <= 2) {
                                i9 = 6;
                            } else {
                                i9 = 6;
                                wVar.m(6);
                            }
                            if ((iG5 & 4) != 0) {
                                wVar.m(i9);
                            }
                            if (zF && wVar.f()) {
                                wVar.m(5);
                            }
                            if (i15 == 0) {
                                if (wVar.f()) {
                                    i10 = 6;
                                    wVar.m(6);
                                } else {
                                    i10 = 6;
                                }
                                if (iG5 == 0 && wVar.f()) {
                                    wVar.m(i10);
                                }
                                if (wVar.f()) {
                                    wVar.m(i10);
                                }
                                int iG6 = wVar.g(2);
                                if (iG6 == 1) {
                                    wVar.m(5);
                                } else if (iG6 == 2) {
                                    wVar.m(12);
                                } else {
                                    if (iG6 == 3) {
                                        int iG7 = wVar.g(5);
                                        if (wVar.f()) {
                                            wVar.m(5);
                                            if (wVar.f()) {
                                                wVar.m(4);
                                            }
                                            if (wVar.f()) {
                                                wVar.m(4);
                                            }
                                            if (wVar.f()) {
                                                wVar.m(4);
                                            }
                                            if (wVar.f()) {
                                                wVar.m(4);
                                            }
                                            if (wVar.f()) {
                                                wVar.m(4);
                                            }
                                            if (wVar.f()) {
                                                wVar.m(4);
                                            }
                                            if (wVar.f()) {
                                                wVar.m(4);
                                            }
                                            if (wVar.f()) {
                                                if (wVar.f()) {
                                                    wVar.m(4);
                                                }
                                                if (wVar.f()) {
                                                    wVar.m(4);
                                                }
                                            }
                                        }
                                        if (wVar.f()) {
                                            wVar.m(5);
                                            if (wVar.f()) {
                                                wVar.m(7);
                                                if (wVar.f()) {
                                                    wVar.m(8);
                                                }
                                            }
                                        }
                                        i11 = 2;
                                        wVar.m((iG7 + 2) * 8);
                                        wVar.c();
                                    }
                                    if (iG5 < i11) {
                                        if (wVar.f()) {
                                            wVar.m(14);
                                        }
                                        if (iG5 == 0 && wVar.f()) {
                                            wVar.m(14);
                                        }
                                    }
                                    if (wVar.f()) {
                                        if (i4 == 0) {
                                            wVar.m(5);
                                        } else {
                                            for (i12 = 0; i12 < i5; i12++) {
                                                if (wVar.f()) {
                                                    wVar.m(5);
                                                }
                                            }
                                        }
                                    }
                                }
                                i11 = 2;
                                if (iG5 < i11) {
                                    if (wVar.f()) {
                                        wVar.m(14);
                                    }
                                    if (iG5 == 0) {
                                        wVar.m(14);
                                    }
                                }
                                if (wVar.f()) {
                                    if (i4 == 0) {
                                        wVar.m(5);
                                    } else {
                                        while (i12 < i5) {
                                            if (wVar.f()) {
                                                wVar.m(5);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        if (wVar.f()) {
                            wVar.m(5);
                            if (iG5 == 2) {
                                wVar.m(4);
                            }
                            if (iG5 >= 6) {
                                wVar.m(2);
                            }
                            if (wVar.f()) {
                                i8 = 8;
                                wVar.m(8);
                            } else {
                                i8 = 8;
                            }
                            if (iG5 == 0 && wVar.f()) {
                                wVar.m(i8);
                            }
                            if (iG3 < 3) {
                                wVar.l();
                            }
                        }
                        if (i15 == 0 && i4 != 3) {
                            wVar.l();
                        }
                        if (i15 == 2 && (i4 == 3 || wVar.f())) {
                            i7 = 6;
                            wVar.m(6);
                        } else {
                            i7 = 6;
                        }
                        str = (wVar.f() && wVar.g(i7) == 1 && wVar.g(8) == 1) ? "audio/eac3-joc" : "audio/eac3";
                        i15 = i6;
                    } else {
                        wVar.m(32);
                        int iG8 = wVar.g(2);
                        String str2 = iG8 == 3 ? null : "audio/ac3";
                        int iA = b.i.a.c.t2.m.a(iG8, wVar.g(6));
                        wVar.m(8);
                        int iG9 = wVar.g(3);
                        if ((iG9 & 1) == 0 || iG9 == 1) {
                            i = 2;
                        } else {
                            i = 2;
                            wVar.m(2);
                        }
                        if ((iG9 & 4) != 0) {
                            wVar.m(i);
                        }
                        if (iG9 == i) {
                            wVar.m(i);
                        }
                        int[] iArr = b.i.a.c.t2.m.f1123b;
                        i15 = iG8 < iArr.length ? iArr[iG8] : -1;
                        i2 = b.i.a.c.t2.m.d[iG9] + (wVar.f() ? 1 : 0);
                        i3 = 1536;
                        str = str2;
                        iG = iA;
                    }
                    int i16 = i2;
                    j1 j1Var = this.j;
                    if (j1Var == null || i16 != j1Var.J || i15 != j1Var.K || !b.i.a.c.f3.e0.a(str, j1Var.w)) {
                        j1$b j1_b = new j1$b();
                        j1_b.a = this.d;
                        j1_b.k = str;
                        j1_b.f1023x = i16;
                        j1_b.f1024y = i15;
                        j1_b.c = this.c;
                        j1 j1VarA = j1_b.a();
                        this.j = j1VarA;
                        this.e.e(j1VarA);
                    }
                    this.k = iG;
                    this.i = (((long) i3) * 1000000) / ((long) this.j.K);
                    this.f1249b.E(0);
                    this.e.c(this.f1249b, 128);
                    this.f = 2;
                }
            } else if (i13 == 2) {
                int iMin2 = Math.min(xVar.a(), this.k - this.g);
                this.e.c(xVar, iMin2);
                int i17 = this.g + iMin2;
                this.g = i17;
                int i18 = this.k;
                if (i17 == i18) {
                    long j = this.l;
                    if (j != -9223372036854775807L) {
                        this.e.d(j, 1, i18, 0, null);
                        this.l += this.i;
                    }
                    this.f = 0;
                }
            }
        }
    }

    @Override // b.i.a.c.x2.k0.o
    public void c() {
        this.f = 0;
        this.g = 0;
        this.h = false;
        this.l = -9223372036854775807L;
    }

    @Override // b.i.a.c.x2.k0.o
    public void d() {
    }

    @Override // b.i.a.c.x2.k0.o
    public void e(b.i.a.c.x2.j jVar, i0$d i0_d) {
        i0_d.a();
        this.d = i0_d.b();
        this.e = jVar.p(i0_d.c(), 1);
    }

    @Override // b.i.a.c.x2.k0.o
    public void f(long j, int i) {
        if (j != -9223372036854775807L) {
            this.l = j;
        }
    }
}
