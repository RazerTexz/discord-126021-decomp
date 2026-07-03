package p007b.p225i.p414e.p415m.p417d;

import com.google.zxing.NotFoundException;
import com.google.zxing.common.reedsolomon.ReedSolomonException;
import org.objectweb.asm.Opcodes;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p007b.p225i.p414e.C4956k;
import p007b.p225i.p414e.p415m.C4958a;
import p007b.p225i.p414e.p418n.C4963b;
import p007b.p225i.p414e.p418n.C4967f;
import p007b.p225i.p414e.p418n.C4970i;
import p007b.p225i.p414e.p418n.p419k.C4972a;
import p007b.p225i.p414e.p418n.p420l.C4973a;
import p007b.p225i.p414e.p418n.p420l.C4975c;

/* JADX INFO: renamed from: b.i.e.m.d.a */
/* JADX INFO: compiled from: Detector.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C4961a {

    /* JADX INFO: renamed from: a */
    public static final int[] f13218a = {3808, 476, 2107, 1799};

    /* JADX INFO: renamed from: b */
    public final C4963b f13219b;

    /* JADX INFO: renamed from: c */
    public boolean f13220c;

    /* JADX INFO: renamed from: d */
    public int f13221d;

    /* JADX INFO: renamed from: e */
    public int f13222e;

    /* JADX INFO: renamed from: f */
    public int f13223f;

    /* JADX INFO: renamed from: g */
    public int f13224g;

    /* JADX INFO: renamed from: b.i.e.m.d.a$a */
    /* JADX INFO: compiled from: Detector.java */
    public static final class a {

        /* JADX INFO: renamed from: a */
        public final int f13225a;

        /* JADX INFO: renamed from: b */
        public final int f13226b;

        public a(int i, int i2) {
            this.f13225a = i;
            this.f13226b = i2;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("<");
            sb.append(this.f13225a);
            sb.append(' ');
            return C1643a.m813A(sb, this.f13226b, '>');
        }
    }

    public C4961a(C4963b c4963b) {
        this.f13219b = c4963b;
    }

    /* JADX INFO: renamed from: b */
    public static C4956k[] m6927b(C4956k[] c4956kArr, int i, int i2) {
        float f = i2 / (i * 2.0f);
        float f2 = c4956kArr[0].f13207a - c4956kArr[2].f13207a;
        float f3 = c4956kArr[0].f13208b - c4956kArr[2].f13208b;
        float f4 = (c4956kArr[0].f13207a + c4956kArr[2].f13207a) / 2.0f;
        float f5 = (c4956kArr[0].f13208b + c4956kArr[2].f13208b) / 2.0f;
        float f6 = f2 * f;
        float f7 = f3 * f;
        C4956k c4956k = new C4956k(f4 + f6, f5 + f7);
        C4956k c4956k2 = new C4956k(f4 - f6, f5 - f7);
        float f8 = c4956kArr[1].f13207a - c4956kArr[3].f13207a;
        float f9 = c4956kArr[1].f13208b - c4956kArr[3].f13208b;
        float f10 = (c4956kArr[1].f13207a + c4956kArr[3].f13207a) / 2.0f;
        float f11 = (c4956kArr[1].f13208b + c4956kArr[3].f13208b) / 2.0f;
        float f12 = f8 * f;
        float f13 = f * f9;
        return new C4956k[]{c4956k, new C4956k(f10 + f12, f11 + f13), c4956k2, new C4956k(f10 - f12, f11 - f13)};
    }

    /* JADX INFO: renamed from: a */
    public C4958a m6928a(boolean z2) throws NotFoundException {
        C4956k c4956k;
        C4956k c4956k2;
        C4956k c4956k3;
        C4956k c4956k4;
        C4956k c4956k5;
        C4956k c4956k6;
        C4956k c4956k7;
        C4956k c4956k8;
        int i;
        long j;
        int i2;
        int i3 = 2;
        int i4 = -1;
        int i5 = 1;
        try {
            C4963b c4963b = this.f13219b;
            C4956k[] c4956kArrM6957b = new C4972a(c4963b, 10, c4963b.f13229j / 2, c4963b.f13230k / 2).m6957b();
            c4956k4 = c4956kArrM6957b[0];
            c4956k3 = c4956kArrM6957b[1];
            c4956k2 = c4956kArrM6957b[2];
            c4956k = c4956kArrM6957b[3];
        } catch (NotFoundException unused) {
            C4963b c4963b2 = this.f13219b;
            int i6 = c4963b2.f13229j / 2;
            int i7 = c4963b2.f13230k / 2;
            int i8 = i7 - 7;
            int i9 = i6 + 7 + 1;
            int i10 = i9;
            int i11 = i8;
            while (true) {
                i11--;
                if (!m6932f(i10, i11) || this.f13219b.m6942f(i10, i11)) {
                    break;
                }
                i10++;
            }
            int i12 = i10 - 1;
            int i13 = i11 + 1;
            while (m6932f(i12, i13) && !this.f13219b.m6942f(i12, i13)) {
                i12++;
            }
            int i14 = i12 - 1;
            while (m6932f(i14, i13) && !this.f13219b.m6942f(i14, i13)) {
                i13--;
            }
            C4956k c4956k9 = new C4956k(i14, i13 + 1);
            int i15 = i7 + 7;
            int i16 = i15;
            while (true) {
                i16++;
                if (!m6932f(i9, i16) || this.f13219b.m6942f(i9, i16)) {
                    break;
                }
                i9++;
            }
            int i17 = i9 - 1;
            int i18 = i16 - 1;
            while (m6932f(i17, i18) && !this.f13219b.m6942f(i17, i18)) {
                i17++;
            }
            int i19 = i17 - 1;
            while (m6932f(i19, i18) && !this.f13219b.m6942f(i19, i18)) {
                i18++;
            }
            C4956k c4956k10 = new C4956k(i19, i18 - 1);
            int i20 = i6 - 7;
            int i21 = i20 - 1;
            while (true) {
                i15++;
                if (!m6932f(i21, i15) || this.f13219b.m6942f(i21, i15)) {
                    break;
                }
                i21--;
            }
            int i22 = i21 + 1;
            int i23 = i15 - 1;
            while (m6932f(i22, i23) && !this.f13219b.m6942f(i22, i23)) {
                i22--;
            }
            int i24 = i22 + 1;
            while (m6932f(i24, i23) && !this.f13219b.m6942f(i24, i23)) {
                i23++;
            }
            C4956k c4956k11 = new C4956k(i24, i23 - 1);
            do {
                i20--;
                i8--;
                if (!m6932f(i20, i8)) {
                    break;
                }
            } while (!this.f13219b.m6942f(i20, i8));
            int i25 = i20 + 1;
            int i26 = i8 + 1;
            while (m6932f(i25, i26) && !this.f13219b.m6942f(i25, i26)) {
                i25--;
            }
            int i27 = i25 + 1;
            while (m6932f(i27, i26) && !this.f13219b.m6942f(i27, i26)) {
                i26--;
            }
            c4956k = new C4956k(i27, i26 + 1);
            c4956k2 = c4956k11;
            c4956k3 = c4956k10;
            c4956k4 = c4956k9;
        }
        int iM4265Z0 = C3404f.m4265Z0((((c4956k4.f13207a + c4956k.f13207a) + c4956k3.f13207a) + c4956k2.f13207a) / 4.0f);
        int iM4265Z1 = C3404f.m4265Z0((((c4956k4.f13208b + c4956k.f13208b) + c4956k3.f13208b) + c4956k2.f13208b) / 4.0f);
        try {
            C4956k[] c4956kArrM6957b2 = new C4972a(this.f13219b, 15, iM4265Z0, iM4265Z1).m6957b();
            c4956k6 = c4956kArrM6957b2[0];
            c4956k8 = c4956kArrM6957b2[1];
            c4956k7 = c4956kArrM6957b2[2];
            c4956k5 = c4956kArrM6957b2[3];
        } catch (NotFoundException unused2) {
            int i28 = iM4265Z1 - 7;
            int i29 = iM4265Z0 + 7 + 1;
            int i30 = i29;
            int i31 = i28;
            while (true) {
                i31--;
                if (!m6932f(i30, i31) || this.f13219b.m6942f(i30, i31)) {
                    break;
                }
                i30++;
            }
            int i32 = i30 - 1;
            int i33 = i31 + 1;
            while (m6932f(i32, i33) && !this.f13219b.m6942f(i32, i33)) {
                i32++;
            }
            int i34 = i32 - 1;
            while (m6932f(i34, i33) && !this.f13219b.m6942f(i34, i33)) {
                i33--;
            }
            C4956k c4956k12 = new C4956k(i34, i33 + 1);
            int i35 = iM4265Z1 + 7;
            int i36 = i35;
            while (true) {
                i36++;
                if (!m6932f(i29, i36) || this.f13219b.m6942f(i29, i36)) {
                    break;
                }
                i29++;
            }
            int i37 = i29 - 1;
            int i38 = i36 - 1;
            while (m6932f(i37, i38) && !this.f13219b.m6942f(i37, i38)) {
                i37++;
            }
            int i39 = i37 - 1;
            while (m6932f(i39, i38) && !this.f13219b.m6942f(i39, i38)) {
                i38++;
            }
            C4956k c4956k13 = new C4956k(i39, i38 - 1);
            int i40 = iM4265Z0 - 7;
            int i41 = i40 - 1;
            while (true) {
                i35++;
                if (!m6932f(i41, i35) || this.f13219b.m6942f(i41, i35)) {
                    break;
                }
                i41--;
            }
            int i42 = i41 + 1;
            int i43 = i35 - 1;
            while (m6932f(i42, i43) && !this.f13219b.m6942f(i42, i43)) {
                i42--;
            }
            int i44 = i42 + 1;
            while (m6932f(i44, i43) && !this.f13219b.m6942f(i44, i43)) {
                i43++;
            }
            C4956k c4956k14 = new C4956k(i44, i43 - 1);
            do {
                i40--;
                i28--;
                if (!m6932f(i40, i28)) {
                    break;
                }
            } while (!this.f13219b.m6942f(i40, i28));
            int i45 = i40 + 1;
            int i46 = i28 + 1;
            while (m6932f(i45, i46) && !this.f13219b.m6942f(i45, i46)) {
                i45--;
            }
            int i47 = i45 + 1;
            while (m6932f(i47, i46) && !this.f13219b.m6942f(i47, i46)) {
                i46--;
            }
            c4956k5 = new C4956k(i47, i46 + 1);
            c4956k6 = c4956k12;
            c4956k7 = c4956k14;
            c4956k8 = c4956k13;
        }
        a aVar = new a(C3404f.m4265Z0((((c4956k6.f13207a + c4956k5.f13207a) + c4956k8.f13207a) + c4956k7.f13207a) / 4.0f), C3404f.m4265Z0((((c4956k6.f13208b + c4956k5.f13208b) + c4956k8.f13208b) + c4956k7.f13208b) / 4.0f));
        this.f13223f = 1;
        a aVar2 = aVar;
        a aVar3 = aVar2;
        a aVar4 = aVar3;
        boolean z3 = true;
        while (this.f13223f < 9) {
            a aVarM6931e = m6931e(aVar, z3, i5, i4);
            a aVarM6931e2 = m6931e(aVar2, z3, i5, i5);
            a aVarM6931e3 = m6931e(aVar3, z3, i4, i5);
            a aVarM6931e4 = m6931e(aVar4, z3, i4, i4);
            if (this.f13223f > i3) {
                double dM4240R = (C3404f.m4240R(aVarM6931e4.f13225a, aVarM6931e4.f13226b, aVarM6931e.f13225a, aVarM6931e.f13226b) * this.f13223f) / (C3404f.m4240R(aVar4.f13225a, aVar4.f13226b, aVar.f13225a, aVar.f13226b) * (this.f13223f + i3));
                if (dM4240R < 0.75d || dM4240R > 1.25d) {
                    break;
                }
                a aVar5 = new a(aVarM6931e.f13225a - 3, aVarM6931e.f13226b + 3);
                a aVar6 = new a(aVarM6931e2.f13225a - 3, aVarM6931e2.f13226b - 3);
                a aVar7 = new a(aVarM6931e3.f13225a + 3, aVarM6931e3.f13226b - 3);
                a aVar8 = new a(aVarM6931e4.f13225a + 3, aVarM6931e4.f13226b + 3);
                int iM6929c = m6929c(aVar8, aVar5);
                if (!(iM6929c != 0 && m6929c(aVar5, aVar6) == iM6929c && m6929c(aVar6, aVar7) == iM6929c && m6929c(aVar7, aVar8) == iM6929c)) {
                    break;
                }
            }
            z3 = !z3;
            this.f13223f++;
            aVar4 = aVarM6931e4;
            aVar2 = aVarM6931e2;
            aVar3 = aVarM6931e3;
            aVar = aVarM6931e;
            i3 = 2;
            i4 = -1;
            i5 = 1;
        }
        int i48 = this.f13223f;
        if (i48 != 5 && i48 != 7) {
            throw NotFoundException.f21665l;
        }
        this.f13220c = i48 == 5;
        int i49 = i48 * 2;
        C4956k[] c4956kArrM6927b = m6927b(new C4956k[]{new C4956k(aVar.f13225a + 0.5f, aVar.f13226b - 0.5f), new C4956k(aVar2.f13225a + 0.5f, aVar2.f13226b + 0.5f), new C4956k(aVar3.f13225a - 0.5f, aVar3.f13226b + 0.5f), new C4956k(aVar4.f13225a - 0.5f, aVar4.f13226b - 0.5f)}, i49 - 3, i49);
        if (z2) {
            C4956k c4956k15 = c4956kArrM6927b[0];
            c4956kArrM6927b[0] = c4956kArrM6927b[2];
            c4956kArrM6927b[2] = c4956k15;
        }
        if (!m6933g(c4956kArrM6927b[0]) || !m6933g(c4956kArrM6927b[1]) || !m6933g(c4956kArrM6927b[2]) || !m6933g(c4956kArrM6927b[3])) {
            throw NotFoundException.f21665l;
        }
        int i50 = this.f13223f * 2;
        int[] iArr = {m6934h(c4956kArrM6927b[0], c4956kArrM6927b[1], i50), m6934h(c4956kArrM6927b[1], c4956kArrM6927b[2], i50), m6934h(c4956kArrM6927b[2], c4956kArrM6927b[3], i50), m6934h(c4956kArrM6927b[3], c4956kArrM6927b[0], i50)};
        int i51 = 0;
        for (int i52 = 0; i52 < 4; i52++) {
            int i53 = iArr[i52];
            i51 = (i51 << 3) + ((i53 >> (i50 - 2)) << 1) + (i53 & 1);
        }
        int i54 = ((i51 & 1) << 11) + (i51 >> 1);
        for (int i55 = 0; i55 < 4; i55++) {
            if (Integer.bitCount(f13218a[i55] ^ i54) <= 2) {
                this.f13224g = i55;
                long j2 = 0;
                for (int i56 = 0; i56 < 4; i56++) {
                    int i57 = iArr[(this.f13224g + i56) % 4];
                    if (this.f13220c) {
                        j = j2 << 7;
                        i2 = (i57 >> 1) & Opcodes.LAND;
                    } else {
                        j = j2 << 10;
                        i2 = ((i57 >> 1) & 31) + ((i57 >> 2) & 992);
                    }
                    j2 = j + ((long) i2);
                }
                int i58 = 7;
                if (this.f13220c) {
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
                            throw NotFoundException.f21665l;
                        }
                    }
                    iArr2[i58] = ((int) j2) & 15;
                    j2 >>= 4;
                }
                new C4975c(C4973a.f13302d).m6968a(iArr2, i59);
                int i60 = 0;
                for (int i61 = 0; i61 < i; i61++) {
                    i60 = (i60 << 4) + iArr2[i61];
                }
                if (this.f13220c) {
                    this.f13221d = (i60 >> 6) + 1;
                    this.f13222e = (i60 & 63) + 1;
                } else {
                    this.f13221d = (i60 >> 11) + 1;
                    this.f13222e = (i60 & 2047) + 1;
                }
                C4963b c4963b3 = this.f13219b;
                int i62 = this.f13224g;
                C4956k c4956k16 = c4956kArrM6927b[i62 % 4];
                C4956k c4956k17 = c4956kArrM6927b[(i62 + 1) % 4];
                C4956k c4956k18 = c4956kArrM6927b[(i62 + 2) % 4];
                C4956k c4956k19 = c4956kArrM6927b[(i62 + 3) % 4];
                C4967f c4967f = C4967f.f13274a;
                int iM6930d = m6930d();
                float f = iM6930d / 2.0f;
                float f2 = this.f13223f;
                float f3 = f - f2;
                float f4 = f + f2;
                return new C4958a(c4967f.m6951a(c4963b3, iM6930d, iM6930d, C4970i.m6954a(f3, f3, f4, f3, f4, f4, f3, f4, c4956k16.f13207a, c4956k16.f13208b, c4956k17.f13207a, c4956k17.f13208b, c4956k18.f13207a, c4956k18.f13208b, c4956k19.f13207a, c4956k19.f13208b)), m6927b(c4956kArrM6927b, this.f13223f * 2, m6930d()), this.f13220c, this.f13222e, this.f13221d);
            }
        }
        throw NotFoundException.f21665l;
    }

    /* JADX INFO: renamed from: c */
    public final int m6929c(a aVar, a aVar2) {
        float fM4240R = C3404f.m4240R(aVar.f13225a, aVar.f13226b, aVar2.f13225a, aVar2.f13226b);
        int i = aVar2.f13225a;
        int i2 = aVar.f13225a;
        float f = (i - i2) / fM4240R;
        int i3 = aVar2.f13226b;
        int i4 = aVar.f13226b;
        float f2 = (i3 - i4) / fM4240R;
        float f3 = i2;
        float f4 = i4;
        boolean zM6942f = this.f13219b.m6942f(i2, i4);
        int iCeil = (int) Math.ceil(fM4240R);
        int i5 = 0;
        for (int i6 = 0; i6 < iCeil; i6++) {
            f3 += f;
            f4 += f2;
            if (this.f13219b.m6942f(C3404f.m4265Z0(f3), C3404f.m4265Z0(f4)) != zM6942f) {
                i5++;
            }
        }
        float f5 = i5 / fM4240R;
        if (f5 <= 0.1f || f5 >= 0.9f) {
            return (f5 <= 0.1f) == zM6942f ? 1 : -1;
        }
        return 0;
    }

    /* JADX INFO: renamed from: d */
    public final int m6930d() {
        if (this.f13220c) {
            return (this.f13221d * 4) + 11;
        }
        int i = this.f13221d;
        if (i <= 4) {
            return (i * 4) + 15;
        }
        return ((((i - 4) / 8) + 1) * 2) + (i * 4) + 15;
    }

    /* JADX INFO: renamed from: e */
    public final a m6931e(a aVar, boolean z2, int i, int i2) {
        int i3 = aVar.f13225a + i;
        int i4 = aVar.f13226b;
        while (true) {
            i4 += i2;
            if (!m6932f(i3, i4) || this.f13219b.m6942f(i3, i4) != z2) {
                break;
            }
            i3 += i;
        }
        int i5 = i3 - i;
        int i6 = i4 - i2;
        while (m6932f(i5, i6) && this.f13219b.m6942f(i5, i6) == z2) {
            i5 += i;
        }
        int i7 = i5 - i;
        while (m6932f(i7, i6) && this.f13219b.m6942f(i7, i6) == z2) {
            i6 += i2;
        }
        return new a(i7, i6 - i2);
    }

    /* JADX INFO: renamed from: f */
    public final boolean m6932f(int i, int i2) {
        if (i < 0) {
            return false;
        }
        C4963b c4963b = this.f13219b;
        return i < c4963b.f13229j && i2 > 0 && i2 < c4963b.f13230k;
    }

    /* JADX INFO: renamed from: g */
    public final boolean m6933g(C4956k c4956k) {
        return m6932f(C3404f.m4265Z0(c4956k.f13207a), C3404f.m4265Z0(c4956k.f13208b));
    }

    /* JADX INFO: renamed from: h */
    public final int m6934h(C4956k c4956k, C4956k c4956k2, int i) {
        float fM4237Q = C3404f.m4237Q(c4956k.f13207a, c4956k.f13208b, c4956k2.f13207a, c4956k2.f13208b);
        float f = fM4237Q / i;
        float f2 = c4956k.f13207a;
        float f3 = c4956k.f13208b;
        float f4 = ((c4956k2.f13207a - f2) * f) / fM4237Q;
        float f5 = ((c4956k2.f13208b - f3) * f) / fM4237Q;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            float f6 = i3;
            if (this.f13219b.m6942f(C3404f.m4265Z0((f6 * f4) + f2), C3404f.m4265Z0((f6 * f5) + f3))) {
                i2 |= 1 << ((i - i3) - 1);
            }
        }
        return i2;
    }
}
