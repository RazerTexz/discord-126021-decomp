package b.i.e.m.d;

import b.i.a.f.e.o.f;
import b.i.e.k;
import b.i.e.n.b;
import b.i.e.n.i;
import b.i.e.n.l.c;
import com.google.zxing.NotFoundException;
import com.google.zxing.common.reedsolomon.ReedSolomonException;
import org.objectweb.asm.Opcodes;

/* JADX INFO: compiled from: Detector.java */
/* JADX INFO: loaded from: classes3.dex */
public final class a {
    public static final int[] a = {3808, 476, 2107, 1799};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f1828b;
    public boolean c;
    public int d;
    public int e;
    public int f;
    public int g;

    public a(b bVar) {
        this.f1828b = bVar;
    }

    public static k[] b(k[] kVarArr, int i, int i2) {
        float f = i2 / (i * 2.0f);
        float f2 = kVarArr[0].a - kVarArr[2].a;
        float f3 = kVarArr[0].f1826b - kVarArr[2].f1826b;
        float f4 = (kVarArr[0].a + kVarArr[2].a) / 2.0f;
        float f5 = (kVarArr[0].f1826b + kVarArr[2].f1826b) / 2.0f;
        float f6 = f2 * f;
        float f7 = f3 * f;
        k kVar = new k(f4 + f6, f5 + f7);
        k kVar2 = new k(f4 - f6, f5 - f7);
        float f8 = kVarArr[1].a - kVarArr[3].a;
        float f9 = kVarArr[1].f1826b - kVarArr[3].f1826b;
        float f10 = (kVarArr[1].a + kVarArr[3].a) / 2.0f;
        float f11 = (kVarArr[1].f1826b + kVarArr[3].f1826b) / 2.0f;
        float f12 = f8 * f;
        float f13 = f * f9;
        return new k[]{kVar, new k(f10 + f12, f11 + f13), kVar2, new k(f10 - f12, f11 - f13)};
    }

    public b.i.e.m.a a(boolean z2) throws NotFoundException {
        k kVar;
        k kVar2;
        k kVar3;
        k kVar4;
        k kVar5;
        k kVar6;
        k kVar7;
        k kVar8;
        int i;
        long j;
        int i2;
        int i3 = 2;
        int i4 = -1;
        int i5 = 1;
        try {
            b bVar = this.f1828b;
            k[] kVarArrB = new b.i.e.n.k.a(bVar, 10, bVar.j / 2, bVar.k / 2).b();
            kVar4 = kVarArrB[0];
            kVar3 = kVarArrB[1];
            kVar2 = kVarArrB[2];
            kVar = kVarArrB[3];
        } catch (NotFoundException unused) {
            b bVar2 = this.f1828b;
            int i6 = bVar2.j / 2;
            int i7 = bVar2.k / 2;
            int i8 = i7 - 7;
            int i9 = i6 + 7 + 1;
            int i10 = i9;
            int i11 = i8;
            while (true) {
                i11--;
                if (!f(i10, i11) || this.f1828b.f(i10, i11)) {
                    break;
                }
                i10++;
            }
            int i12 = i10 - 1;
            int i13 = i11 + 1;
            while (f(i12, i13) && !this.f1828b.f(i12, i13)) {
                i12++;
            }
            int i14 = i12 - 1;
            while (f(i14, i13) && !this.f1828b.f(i14, i13)) {
                i13--;
            }
            k kVar9 = new k(i14, i13 + 1);
            int i15 = i7 + 7;
            int i16 = i15;
            while (true) {
                i16++;
                if (!f(i9, i16) || this.f1828b.f(i9, i16)) {
                    break;
                }
                i9++;
            }
            int i17 = i9 - 1;
            int i18 = i16 - 1;
            while (f(i17, i18) && !this.f1828b.f(i17, i18)) {
                i17++;
            }
            int i19 = i17 - 1;
            while (f(i19, i18) && !this.f1828b.f(i19, i18)) {
                i18++;
            }
            k kVar10 = new k(i19, i18 - 1);
            int i20 = i6 - 7;
            int i21 = i20 - 1;
            while (true) {
                i15++;
                if (!f(i21, i15) || this.f1828b.f(i21, i15)) {
                    break;
                }
                i21--;
            }
            int i22 = i21 + 1;
            int i23 = i15 - 1;
            while (f(i22, i23) && !this.f1828b.f(i22, i23)) {
                i22--;
            }
            int i24 = i22 + 1;
            while (f(i24, i23) && !this.f1828b.f(i24, i23)) {
                i23++;
            }
            k kVar11 = new k(i24, i23 - 1);
            do {
                i20--;
                i8--;
                if (!f(i20, i8)) {
                    break;
                }
            } while (!this.f1828b.f(i20, i8));
            int i25 = i20 + 1;
            int i26 = i8 + 1;
            while (f(i25, i26) && !this.f1828b.f(i25, i26)) {
                i25--;
            }
            int i27 = i25 + 1;
            while (f(i27, i26) && !this.f1828b.f(i27, i26)) {
                i26--;
            }
            kVar = new k(i27, i26 + 1);
            kVar2 = kVar11;
            kVar3 = kVar10;
            kVar4 = kVar9;
        }
        int iZ0 = f.Z0((((kVar4.a + kVar.a) + kVar3.a) + kVar2.a) / 4.0f);
        int iZ1 = f.Z0((((kVar4.f1826b + kVar.f1826b) + kVar3.f1826b) + kVar2.f1826b) / 4.0f);
        try {
            k[] kVarArrB2 = new b.i.e.n.k.a(this.f1828b, 15, iZ0, iZ1).b();
            kVar6 = kVarArrB2[0];
            kVar8 = kVarArrB2[1];
            kVar7 = kVarArrB2[2];
            kVar5 = kVarArrB2[3];
        } catch (NotFoundException unused2) {
            int i28 = iZ1 - 7;
            int i29 = iZ0 + 7 + 1;
            int i30 = i29;
            int i31 = i28;
            while (true) {
                i31--;
                if (!f(i30, i31) || this.f1828b.f(i30, i31)) {
                    break;
                }
                i30++;
            }
            int i32 = i30 - 1;
            int i33 = i31 + 1;
            while (f(i32, i33) && !this.f1828b.f(i32, i33)) {
                i32++;
            }
            int i34 = i32 - 1;
            while (f(i34, i33) && !this.f1828b.f(i34, i33)) {
                i33--;
            }
            k kVar12 = new k(i34, i33 + 1);
            int i35 = iZ1 + 7;
            int i36 = i35;
            while (true) {
                i36++;
                if (!f(i29, i36) || this.f1828b.f(i29, i36)) {
                    break;
                }
                i29++;
            }
            int i37 = i29 - 1;
            int i38 = i36 - 1;
            while (f(i37, i38) && !this.f1828b.f(i37, i38)) {
                i37++;
            }
            int i39 = i37 - 1;
            while (f(i39, i38) && !this.f1828b.f(i39, i38)) {
                i38++;
            }
            k kVar13 = new k(i39, i38 - 1);
            int i40 = iZ0 - 7;
            int i41 = i40 - 1;
            while (true) {
                i35++;
                if (!f(i41, i35) || this.f1828b.f(i41, i35)) {
                    break;
                }
                i41--;
            }
            int i42 = i41 + 1;
            int i43 = i35 - 1;
            while (f(i42, i43) && !this.f1828b.f(i42, i43)) {
                i42--;
            }
            int i44 = i42 + 1;
            while (f(i44, i43) && !this.f1828b.f(i44, i43)) {
                i43++;
            }
            k kVar14 = new k(i44, i43 - 1);
            do {
                i40--;
                i28--;
                if (!f(i40, i28)) {
                    break;
                }
            } while (!this.f1828b.f(i40, i28));
            int i45 = i40 + 1;
            int i46 = i28 + 1;
            while (f(i45, i46) && !this.f1828b.f(i45, i46)) {
                i45--;
            }
            int i47 = i45 + 1;
            while (f(i47, i46) && !this.f1828b.f(i47, i46)) {
                i46--;
            }
            kVar5 = new k(i47, i46 + 1);
            kVar6 = kVar12;
            kVar7 = kVar14;
            kVar8 = kVar13;
        }
        a$a a_a = new a$a(f.Z0((((kVar6.a + kVar5.a) + kVar8.a) + kVar7.a) / 4.0f), f.Z0((((kVar6.f1826b + kVar5.f1826b) + kVar8.f1826b) + kVar7.f1826b) / 4.0f));
        this.f = 1;
        a$a a_a2 = a_a;
        a$a a_a3 = a_a2;
        a$a a_a4 = a_a3;
        boolean z3 = true;
        while (this.f < 9) {
            a$a a_aE = e(a_a, z3, i5, i4);
            a$a a_aE2 = e(a_a2, z3, i5, i5);
            a$a a_aE3 = e(a_a3, z3, i4, i5);
            a$a a_aE4 = e(a_a4, z3, i4, i4);
            if (this.f > i3) {
                double dR = (f.R(a_aE4.a, a_aE4.f1829b, a_aE.a, a_aE.f1829b) * this.f) / (f.R(a_a4.a, a_a4.f1829b, a_a.a, a_a.f1829b) * (this.f + i3));
                if (dR < 0.75d || dR > 1.25d) {
                    break;
                }
                a$a a_a5 = new a$a(a_aE.a - 3, a_aE.f1829b + 3);
                a$a a_a6 = new a$a(a_aE2.a - 3, a_aE2.f1829b - 3);
                a$a a_a7 = new a$a(a_aE3.a + 3, a_aE3.f1829b - 3);
                a$a a_a8 = new a$a(a_aE4.a + 3, a_aE4.f1829b + 3);
                int iC = c(a_a8, a_a5);
                if (!(iC != 0 && c(a_a5, a_a6) == iC && c(a_a6, a_a7) == iC && c(a_a7, a_a8) == iC)) {
                    break;
                }
            }
            z3 = !z3;
            this.f++;
            a_a4 = a_aE4;
            a_a2 = a_aE2;
            a_a3 = a_aE3;
            a_a = a_aE;
            i3 = 2;
            i4 = -1;
            i5 = 1;
        }
        int i48 = this.f;
        if (i48 != 5 && i48 != 7) {
            throw NotFoundException.l;
        }
        this.c = i48 == 5;
        int i49 = i48 * 2;
        k[] kVarArrB3 = b(new k[]{new k(a_a.a + 0.5f, a_a.f1829b - 0.5f), new k(a_a2.a + 0.5f, a_a2.f1829b + 0.5f), new k(a_a3.a - 0.5f, a_a3.f1829b + 0.5f), new k(a_a4.a - 0.5f, a_a4.f1829b - 0.5f)}, i49 - 3, i49);
        if (z2) {
            k kVar15 = kVarArrB3[0];
            kVarArrB3[0] = kVarArrB3[2];
            kVarArrB3[2] = kVar15;
        }
        if (!g(kVarArrB3[0]) || !g(kVarArrB3[1]) || !g(kVarArrB3[2]) || !g(kVarArrB3[3])) {
            throw NotFoundException.l;
        }
        int i50 = this.f * 2;
        int[] iArr = {h(kVarArrB3[0], kVarArrB3[1], i50), h(kVarArrB3[1], kVarArrB3[2], i50), h(kVarArrB3[2], kVarArrB3[3], i50), h(kVarArrB3[3], kVarArrB3[0], i50)};
        int i51 = 0;
        for (int i52 = 0; i52 < 4; i52++) {
            int i53 = iArr[i52];
            i51 = (i51 << 3) + ((i53 >> (i50 - 2)) << 1) + (i53 & 1);
        }
        int i54 = ((i51 & 1) << 11) + (i51 >> 1);
        for (int i55 = 0; i55 < 4; i55++) {
            if (Integer.bitCount(a[i55] ^ i54) <= 2) {
                this.g = i55;
                long j2 = 0;
                for (int i56 = 0; i56 < 4; i56++) {
                    int i57 = iArr[(this.g + i56) % 4];
                    if (this.c) {
                        j = j2 << 7;
                        i2 = (i57 >> 1) & Opcodes.LAND;
                    } else {
                        j = j2 << 10;
                        i2 = ((i57 >> 1) & 31) + ((i57 >> 2) & 992);
                    }
                    j2 = j + ((long) i2);
                }
                int i58 = 7;
                if (this.c) {
                    i = 2;
                } else {
                    i = 4;
                    i58 = 10;
                }
                int i59 = i58 - i;
                int[] iArr2 = new int[i58];
                while (true) {
                    i58--;
                    if (i58 < 0) {
                        try {
                            break;
                        } catch (ReedSolomonException unused3) {
                            throw NotFoundException.l;
                        }
                    }
                    iArr2[i58] = ((int) j2) & 15;
                    j2 >>= 4;
                }
                new c(b.i.e.n.l.a.d).a(iArr2, i59);
                int i60 = 0;
                for (int i61 = 0; i61 < i; i61++) {
                    i60 = (i60 << 4) + iArr2[i61];
                }
                if (this.c) {
                    this.d = (i60 >> 6) + 1;
                    this.e = (i60 & 63) + 1;
                } else {
                    this.d = (i60 >> 11) + 1;
                    this.e = (i60 & 2047) + 1;
                }
                b bVar3 = this.f1828b;
                int i62 = this.g;
                k kVar16 = kVarArrB3[i62 % 4];
                k kVar17 = kVarArrB3[(i62 + 1) % 4];
                k kVar18 = kVarArrB3[(i62 + 2) % 4];
                k kVar19 = kVarArrB3[(i62 + 3) % 4];
                b.i.e.n.f fVar = b.i.e.n.f.a;
                int iD = d();
                float f = iD / 2.0f;
                float f2 = this.f;
                float f3 = f - f2;
                float f4 = f + f2;
                return new b.i.e.m.a(fVar.a(bVar3, iD, iD, i.a(f3, f3, f4, f3, f4, f4, f3, f4, kVar16.a, kVar16.f1826b, kVar17.a, kVar17.f1826b, kVar18.a, kVar18.f1826b, kVar19.a, kVar19.f1826b)), b(kVarArrB3, this.f * 2, d()), this.c, this.e, this.d);
            }
        }
        throw NotFoundException.l;
    }

    public final int c(a$a a_a, a$a a_a2) {
        float fR = f.R(a_a.a, a_a.f1829b, a_a2.a, a_a2.f1829b);
        int i = a_a2.a;
        int i2 = a_a.a;
        float f = (i - i2) / fR;
        int i3 = a_a2.f1829b;
        int i4 = a_a.f1829b;
        float f2 = (i3 - i4) / fR;
        float f3 = i2;
        float f4 = i4;
        boolean zF = this.f1828b.f(i2, i4);
        int iCeil = (int) Math.ceil(fR);
        int i5 = 0;
        for (int i6 = 0; i6 < iCeil; i6++) {
            f3 += f;
            f4 += f2;
            if (this.f1828b.f(f.Z0(f3), f.Z0(f4)) != zF) {
                i5++;
            }
        }
        float f5 = i5 / fR;
        if (f5 <= 0.1f || f5 >= 0.9f) {
            return (f5 <= 0.1f) == zF ? 1 : -1;
        }
        return 0;
    }

    public final int d() {
        if (this.c) {
            return (this.d * 4) + 11;
        }
        int i = this.d;
        if (i <= 4) {
            return (i * 4) + 15;
        }
        return ((((i - 4) / 8) + 1) * 2) + (i * 4) + 15;
    }

    public final a$a e(a$a a_a, boolean z2, int i, int i2) {
        int i3 = a_a.a + i;
        int i4 = a_a.f1829b;
        while (true) {
            i4 += i2;
            if (!f(i3, i4) || this.f1828b.f(i3, i4) != z2) {
                break;
            }
            i3 += i;
        }
        int i5 = i3 - i;
        int i6 = i4 - i2;
        while (f(i5, i6) && this.f1828b.f(i5, i6) == z2) {
            i5 += i;
        }
        int i7 = i5 - i;
        while (f(i7, i6) && this.f1828b.f(i7, i6) == z2) {
            i6 += i2;
        }
        return new a$a(i7, i6 - i2);
    }

    public final boolean f(int i, int i2) {
        if (i < 0) {
            return false;
        }
        b bVar = this.f1828b;
        return i < bVar.j && i2 > 0 && i2 < bVar.k;
    }

    public final boolean g(k kVar) {
        return f(f.Z0(kVar.a), f.Z0(kVar.f1826b));
    }

    public final int h(k kVar, k kVar2, int i) {
        float fQ = f.Q(kVar.a, kVar.f1826b, kVar2.a, kVar2.f1826b);
        float f = fQ / i;
        float f2 = kVar.a;
        float f3 = kVar.f1826b;
        float f4 = ((kVar2.a - f2) * f) / fQ;
        float f5 = ((kVar2.f1826b - f3) * f) / fQ;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            float f6 = i3;
            if (this.f1828b.f(f.Z0((f6 * f4) + f2), f.Z0((f6 * f5) + f3))) {
                i2 |= 1 << ((i - i3) - 1);
            }
        }
        return i2;
    }
}
