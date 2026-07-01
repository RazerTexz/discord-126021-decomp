package b.i.a.c.x2.k0;

import b.i.a.c.j1$b;
import java.util.Collections;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* JADX INFO: compiled from: H265Reader.java */
/* JADX INFO: loaded from: classes3.dex */
public final class s implements o {
    public final e0 a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f1275b;
    public b.i.a.c.x2.w c;
    public s$a d;
    public boolean e;
    public long l;
    public final boolean[] f = new boolean[3];
    public final w g = new w(32, 128);
    public final w h = new w(33, 128);
    public final w i = new w(34, 128);
    public final w j = new w(39, 128);
    public final w k = new w(40, 128);
    public long m = -9223372036854775807L;
    public final b.i.a.c.f3.x n = new b.i.a.c.f3.x();

    public s(e0 e0Var) {
        this.a = e0Var;
    }

    @RequiresNonNull({"sampleReader"})
    public final void a(byte[] bArr, int i, int i2) {
        s$a s_a = this.d;
        if (s_a.f) {
            int i3 = s_a.d;
            int i4 = (i + 2) - i3;
            if (i4 < i2) {
                s_a.g = (bArr[i4] & 128) != 0;
                s_a.f = false;
            } else {
                s_a.d = (i2 - i) + i3;
            }
        }
        if (!this.e) {
            this.g.a(bArr, i, i2);
            this.h.a(bArr, i, i2);
            this.i.a(bArr, i, i2);
        }
        this.j.a(bArr, i, i2);
        this.k.a(bArr, i, i2);
    }

    /* JADX WARN: Code duplicated, block: B:166:0x0347  */
    @Override // b.i.a.c.x2.k0.o
    public void b(b.i.a.c.f3.x xVar) {
        long j;
        long j2;
        b.c.a.a0.d.H(this.c);
        int i = b.i.a.c.f3.e0.a;
        while (xVar.a() > 0) {
            int i2 = xVar.f984b;
            int i3 = xVar.c;
            byte[] bArr = xVar.a;
            this.l += (long) xVar.a();
            this.c.c(xVar, xVar.a());
            while (i2 < i3) {
                int iB = b.i.a.c.f3.u.b(bArr, i2, i3, this.f);
                if (iB == i3) {
                    a(bArr, i2, i3);
                    return;
                }
                int i4 = iB + 3;
                int i5 = (bArr[i4] & 126) >> 1;
                int i6 = iB - i2;
                if (i6 > 0) {
                    a(bArr, i2, iB);
                }
                int i7 = i3 - iB;
                long j3 = this.l - ((long) i7);
                int i8 = i6 < 0 ? -i6 : 0;
                long j4 = this.m;
                s$a s_a = this.d;
                boolean z2 = this.e;
                if (s_a.j && s_a.g) {
                    s_a.m = s_a.c;
                    s_a.j = false;
                } else if (s_a.h || s_a.g) {
                    if (z2 && s_a.i) {
                        s_a.a(((int) (j3 - s_a.f1276b)) + i7);
                    }
                    s_a.k = s_a.f1276b;
                    s_a.l = s_a.e;
                    s_a.m = s_a.c;
                    s_a.i = true;
                }
                if (this.e) {
                    j3 = j3;
                    j = j4;
                } else {
                    this.g.b(i8);
                    this.h.b(i8);
                    this.i.b(i8);
                    w wVar = this.g;
                    if (wVar.c) {
                        w wVar2 = this.h;
                        if (wVar2.c) {
                            w wVar3 = this.i;
                            if (wVar3.c) {
                                b.i.a.c.x2.w wVar4 = this.c;
                                String str = this.f1275b;
                                int i9 = wVar.e;
                                byte[] bArr2 = new byte[wVar2.e + i9 + wVar3.e];
                                System.arraycopy(wVar.d, 0, bArr2, 0, i9);
                                System.arraycopy(wVar2.d, 0, bArr2, wVar.e, wVar2.e);
                                System.arraycopy(wVar3.d, 0, bArr2, wVar.e + wVar2.e, wVar3.e);
                                b.i.a.c.f3.y yVar = new b.i.a.c.f3.y(wVar2.d, 0, wVar2.e);
                                yVar.j(44);
                                int iE = yVar.e(3);
                                yVar.i();
                                int iE2 = yVar.e(2);
                                boolean zD = yVar.d();
                                int iE3 = yVar.e(5);
                                int i10 = 0;
                                int i11 = 0;
                                for (int i12 = 32; i10 < i12; i12 = 32) {
                                    if (yVar.d()) {
                                        i11 |= 1 << i10;
                                    }
                                    i10++;
                                }
                                int[] iArr = new int[6];
                                for (int i13 = 0; i13 < 6; i13++) {
                                    iArr[i13] = yVar.e(8);
                                }
                                int iE4 = yVar.e(8);
                                int i14 = 0;
                                for (int i15 = 0; i15 < iE; i15++) {
                                    if (yVar.d()) {
                                        i14 += 89;
                                    }
                                    if (yVar.d()) {
                                        i14 += 8;
                                    }
                                }
                                yVar.j(i14);
                                if (iE > 0) {
                                    yVar.j((8 - iE) * 2);
                                }
                                yVar.f();
                                int iF = yVar.f();
                                if (iF == 3) {
                                    yVar.i();
                                }
                                int iF2 = yVar.f();
                                int iF3 = yVar.f();
                                if (yVar.d()) {
                                    int iF4 = yVar.f();
                                    int iF5 = yVar.f();
                                    int iF6 = yVar.f();
                                    int iF7 = yVar.f();
                                    iF2 -= (iF4 + iF5) * ((iF == 1 || iF == 2) ? 2 : 1);
                                    iF3 -= (iF6 + iF7) * (iF == 1 ? 2 : 1);
                                }
                                yVar.f();
                                yVar.f();
                                int iF8 = yVar.f();
                                for (int i16 = yVar.d() ? 0 : iE; i16 <= iE; i16++) {
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
                                    int i17 = 0;
                                    for (int i18 = 4; i17 < i18; i18 = 4) {
                                        int i19 = 0;
                                        while (i19 < 6) {
                                            if (yVar.d()) {
                                                int iMin = Math.min(64, 1 << ((i17 << 1) + 4));
                                                if (i17 > 1) {
                                                    yVar.g();
                                                }
                                                for (int i20 = 0; i20 < iMin; i20++) {
                                                    yVar.g();
                                                }
                                            } else {
                                                yVar.f();
                                            }
                                            i19 += i17 == 3 ? 3 : 1;
                                            j4 = j4;
                                        }
                                        i17++;
                                    }
                                }
                                j = j4;
                                yVar.j(2);
                                if (yVar.d()) {
                                    yVar.j(8);
                                    yVar.f();
                                    yVar.f();
                                    yVar.i();
                                }
                                int i21 = 0;
                                boolean zD2 = false;
                                int i22 = 0;
                                for (int iF9 = yVar.f(); i21 < iF9; iF9 = iF9) {
                                    if (i21 != 0) {
                                        zD2 = yVar.d();
                                    }
                                    if (zD2) {
                                        yVar.i();
                                        yVar.f();
                                        for (int i23 = 0; i23 <= i22; i23++) {
                                            if (yVar.d()) {
                                                yVar.i();
                                            }
                                        }
                                    } else {
                                        int iF10 = yVar.f();
                                        int iF11 = yVar.f();
                                        int i24 = iF10 + iF11;
                                        for (int i25 = 0; i25 < iF10; i25++) {
                                            yVar.f();
                                            yVar.i();
                                        }
                                        for (int i26 = 0; i26 < iF11; i26++) {
                                            yVar.f();
                                            yVar.i();
                                        }
                                        i22 = i24;
                                    }
                                    i21++;
                                }
                                if (yVar.d()) {
                                    for (int i27 = 0; i27 < yVar.f(); i27++) {
                                        yVar.j(iF8 + 4 + 1);
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
                                            float[] fArr = b.i.a.c.f3.u.f978b;
                                            if (iE5 < fArr.length) {
                                                f = fArr[iE5];
                                            } else {
                                                b.d.b.a.a.g0(46, "Unexpected aspect_ratio_idc value: ", iE5, "H265Reader");
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
                                        iF3 *= 2;
                                    }
                                }
                                String strB = b.i.a.c.f3.h.b(iE2, zD, iE3, i11, iArr, iE4);
                                j1$b j1_b = new j1$b();
                                j1_b.a = str;
                                j1_b.k = "video/hevc";
                                j1_b.h = strB;
                                j1_b.p = iF2;
                                j1_b.q = iF3;
                                j1_b.t = f;
                                j1_b.m = Collections.singletonList(bArr2);
                                wVar4.e(j1_b.a());
                                this.e = true;
                            } else {
                                j3 = j3;
                                j = j4;
                            }
                        } else {
                            j3 = j3;
                            j = j4;
                        }
                    } else {
                        j3 = j3;
                        j = j4;
                    }
                }
                if (this.j.b(i8)) {
                    w wVar5 = this.j;
                    this.n.C(this.j.d, b.i.a.c.f3.u.f(wVar5.d, wVar5.e));
                    this.n.F(5);
                    j2 = j;
                    b.c.a.a0.d.J(j2, this.n, this.a.f1246b);
                } else {
                    j2 = j;
                }
                if (this.k.b(i8)) {
                    w wVar6 = this.k;
                    this.n.C(this.k.d, b.i.a.c.f3.u.f(wVar6.d, wVar6.e));
                    this.n.F(5);
                    b.c.a.a0.d.J(j2, this.n, this.a.f1246b);
                }
                long j5 = this.m;
                s$a s_a2 = this.d;
                boolean z3 = this.e;
                s_a2.g = false;
                s_a2.h = false;
                s_a2.e = j5;
                s_a2.d = 0;
                s_a2.f1276b = j3;
                if (!(i5 < 32 || i5 == 40)) {
                    if (s_a2.i && !s_a2.j) {
                        if (z3) {
                            s_a2.a(i7);
                        }
                        s_a2.i = false;
                    }
                    if ((32 <= i5 && i5 <= 35) || i5 == 39) {
                        s_a2.h = !s_a2.j;
                        s_a2.j = true;
                    }
                }
                boolean z4 = i5 >= 16 && i5 <= 21;
                s_a2.c = z4;
                s_a2.f = z4 || i5 <= 9;
                if (!this.e) {
                    this.g.d(i5);
                    this.h.d(i5);
                    this.i.d(i5);
                }
                this.j.d(i5);
                this.k.d(i5);
                i3 = i3;
                bArr = bArr;
                i2 = i4;
            }
        }
    }

    @Override // b.i.a.c.x2.k0.o
    public void c() {
        this.l = 0L;
        this.m = -9223372036854775807L;
        b.i.a.c.f3.u.a(this.f);
        this.g.c();
        this.h.c();
        this.i.c();
        this.j.c();
        this.k.c();
        s$a s_a = this.d;
        if (s_a != null) {
            s_a.f = false;
            s_a.g = false;
            s_a.h = false;
            s_a.i = false;
            s_a.j = false;
        }
    }

    @Override // b.i.a.c.x2.k0.o
    public void d() {
    }

    @Override // b.i.a.c.x2.k0.o
    public void e(b.i.a.c.x2.j jVar, i0$d i0_d) {
        i0_d.a();
        this.f1275b = i0_d.b();
        b.i.a.c.x2.w wVarP = jVar.p(i0_d.c(), 2);
        this.c = wVarP;
        this.d = new s$a(wVarP);
        this.a.a(jVar, i0_d);
    }

    @Override // b.i.a.c.x2.k0.o
    public void f(long j, int i) {
        if (j != -9223372036854775807L) {
            this.m = j;
        }
    }
}
