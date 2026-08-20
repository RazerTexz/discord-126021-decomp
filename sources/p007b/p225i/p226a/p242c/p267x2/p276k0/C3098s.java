package p007b.p225i.p226a.p242c.p267x2.p276k0;

import java.util.Collections;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p226a.p242c.C2811j1;
import p007b.p225i.p226a.p242c.p259f3.C2738e0;
import p007b.p225i.p226a.p242c.p259f3.C2741h;
import p007b.p225i.p226a.p242c.p259f3.C2754u;
import p007b.p225i.p226a.p242c.p259f3.C2757x;
import p007b.p225i.p226a.p242c.p259f3.C2758y;
import p007b.p225i.p226a.p242c.p267x2.InterfaceC3058j;
import p007b.p225i.p226a.p242c.p267x2.InterfaceC3122w;

/* JADX INFO: renamed from: b.i.a.c.x2.k0.s */
/* JADX INFO: compiled from: H265Reader.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C3098s implements InterfaceC3094o {

    /* JADX INFO: renamed from: a */
    public final C3079e0 f8837a;

    /* JADX INFO: renamed from: b */
    public String f8838b;

    /* JADX INFO: renamed from: c */
    public InterfaceC3122w f8839c;

    /* JADX INFO: renamed from: d */
    public a f8840d;

    /* JADX INFO: renamed from: e */
    public boolean f8841e;

    /* JADX INFO: renamed from: l */
    public long f8848l;

    /* JADX INFO: renamed from: f */
    public final boolean[] f8842f = new boolean[3];

    /* JADX INFO: renamed from: g */
    public final C3102w f8843g = new C3102w(32, 128);

    /* JADX INFO: renamed from: h */
    public final C3102w f8844h = new C3102w(33, 128);

    /* JADX INFO: renamed from: i */
    public final C3102w f8845i = new C3102w(34, 128);

    /* JADX INFO: renamed from: j */
    public final C3102w f8846j = new C3102w(39, 128);

    /* JADX INFO: renamed from: k */
    public final C3102w f8847k = new C3102w(40, 128);

    /* JADX INFO: renamed from: m */
    public long f8849m = -9223372036854775807L;

    /* JADX INFO: renamed from: n */
    public final C2757x f8850n = new C2757x();

    /* JADX INFO: renamed from: b.i.a.c.x2.k0.s$a */
    /* JADX INFO: compiled from: H265Reader.java */
    public static final class a {

        /* JADX INFO: renamed from: a */
        public final InterfaceC3122w f8851a;

        /* JADX INFO: renamed from: b */
        public long f8852b;

        /* JADX INFO: renamed from: c */
        public boolean f8853c;

        /* JADX INFO: renamed from: d */
        public int f8854d;

        /* JADX INFO: renamed from: e */
        public long f8855e;

        /* JADX INFO: renamed from: f */
        public boolean f8856f;

        /* JADX INFO: renamed from: g */
        public boolean f8857g;

        /* JADX INFO: renamed from: h */
        public boolean f8858h;

        /* JADX INFO: renamed from: i */
        public boolean f8859i;

        /* JADX INFO: renamed from: j */
        public boolean f8860j;

        /* JADX INFO: renamed from: k */
        public long f8861k;

        /* JADX INFO: renamed from: l */
        public long f8862l;

        /* JADX INFO: renamed from: m */
        public boolean f8863m;

        public a(InterfaceC3122w interfaceC3122w) {
            this.f8851a = interfaceC3122w;
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        /* JADX INFO: renamed from: a */
        public final void m3785a(int i) {
            long j = this.f8862l;
            if (j == -9223372036854775807L) {
                return;
            }
            boolean z2 = this.f8863m;
            this.f8851a.mo2525d(j, z2 ? 1 : 0, (int) (this.f8852b - this.f8861k), i, null);
        }
    }

    public C3098s(C3079e0 c3079e0) {
        this.f8837a = c3079e0;
    }

    @RequiresNonNull({"sampleReader"})
    /* JADX INFO: renamed from: a */
    public final void m3784a(byte[] bArr, int i, int i2) {
        a aVar = this.f8840d;
        if (aVar.f8856f) {
            int i3 = aVar.f8854d;
            int i4 = (i + 2) - i3;
            if (i4 < i2) {
                aVar.f8857g = (bArr[i4] & 128) != 0;
                aVar.f8856f = false;
            } else {
                aVar.f8854d = (i2 - i) + i3;
            }
        }
        if (!this.f8841e) {
            this.f8843g.m3788a(bArr, i, i2);
            this.f8844h.m3788a(bArr, i, i2);
            this.f8845i.m3788a(bArr, i, i2);
        }
        this.f8846j.m3788a(bArr, i, i2);
        this.f8847k.m3788a(bArr, i, i2);
    }

    /* JADX WARN: Code duplicated, block: B:166:0x0347  */
    @Override // p007b.p225i.p226a.p242c.p267x2.p276k0.InterfaceC3094o
    /* JADX INFO: renamed from: b */
    public void mo3758b(C2757x c2757x) {
        long j;
        long j2;
        C1460d.m438H(this.f8839c);
        int i = C2738e0.f6708a;
        while (c2757x.m3081a() > 0) {
            int i2 = c2757x.f6794b;
            int i3 = c2757x.f6795c;
            byte[] bArr = c2757x.f6793a;
            this.f8848l += (long) c2757x.m3081a();
            this.f8839c.mo2524c(c2757x, c2757x.m3081a());
            while (i2 < i3) {
                int iM3055b = C2754u.m3055b(bArr, i2, i3, this.f8842f);
                if (iM3055b == i3) {
                    m3784a(bArr, i2, i3);
                    return;
                }
                int i4 = iM3055b + 3;
                int i5 = (bArr[i4] & 126) >> 1;
                int i6 = iM3055b - i2;
                if (i6 > 0) {
                    m3784a(bArr, i2, iM3055b);
                }
                int i7 = i3 - iM3055b;
                long j3 = this.f8848l - ((long) i7);
                int i8 = i6 < 0 ? -i6 : 0;
                long j4 = this.f8849m;
                a aVar = this.f8840d;
                boolean z2 = this.f8841e;
                if (aVar.f8860j && aVar.f8857g) {
                    aVar.f8863m = aVar.f8853c;
                    aVar.f8860j = false;
                } else if (aVar.f8858h || aVar.f8857g) {
                    if (z2 && aVar.f8859i) {
                        aVar.m3785a(((int) (j3 - aVar.f8852b)) + i7);
                    }
                    aVar.f8861k = aVar.f8852b;
                    aVar.f8862l = aVar.f8855e;
                    aVar.f8863m = aVar.f8853c;
                    aVar.f8859i = true;
                }
                if (this.f8841e) {
                    j3 = j3;
                    j = j4;
                } else {
                    this.f8843g.m3789b(i8);
                    this.f8844h.m3789b(i8);
                    this.f8845i.m3789b(i8);
                    C3102w c3102w = this.f8843g;
                    if (c3102w.f8905c) {
                        C3102w c3102w2 = this.f8844h;
                        if (c3102w2.f8905c) {
                            C3102w c3102w3 = this.f8845i;
                            if (c3102w3.f8905c) {
                                InterfaceC3122w interfaceC3122w = this.f8839c;
                                String str = this.f8838b;
                                int i9 = c3102w.f8907e;
                                byte[] bArr2 = new byte[c3102w2.f8907e + i9 + c3102w3.f8907e];
                                System.arraycopy(c3102w.f8906d, 0, bArr2, 0, i9);
                                System.arraycopy(c3102w2.f8906d, 0, bArr2, c3102w.f8907e, c3102w2.f8907e);
                                System.arraycopy(c3102w3.f8906d, 0, bArr2, c3102w.f8907e + c3102w2.f8907e, c3102w3.f8907e);
                                C2758y c2758y = new C2758y(c3102w2.f8906d, 0, c3102w2.f8907e);
                                c2758y.m3116j(44);
                                int iM3111e = c2758y.m3111e(3);
                                c2758y.m3115i();
                                int iM3111e2 = c2758y.m3111e(2);
                                boolean zM3110d = c2758y.m3110d();
                                int iM3111e3 = c2758y.m3111e(5);
                                int i10 = 0;
                                int i11 = 0;
                                for (int i12 = 32; i10 < i12; i12 = 32) {
                                    if (c2758y.m3110d()) {
                                        i11 |= 1 << i10;
                                    }
                                    i10++;
                                }
                                int[] iArr = new int[6];
                                for (int i13 = 0; i13 < 6; i13++) {
                                    iArr[i13] = c2758y.m3111e(8);
                                }
                                int iM3111e4 = c2758y.m3111e(8);
                                int i14 = 0;
                                for (int i15 = 0; i15 < iM3111e; i15++) {
                                    if (c2758y.m3110d()) {
                                        i14 += 89;
                                    }
                                    if (c2758y.m3110d()) {
                                        i14 += 8;
                                    }
                                }
                                c2758y.m3116j(i14);
                                if (iM3111e > 0) {
                                    c2758y.m3116j((8 - iM3111e) * 2);
                                }
                                c2758y.m3112f();
                                int iM3112f = c2758y.m3112f();
                                if (iM3112f == 3) {
                                    c2758y.m3115i();
                                }
                                int iM3112f2 = c2758y.m3112f();
                                int iM3112f3 = c2758y.m3112f();
                                if (c2758y.m3110d()) {
                                    int iM3112f4 = c2758y.m3112f();
                                    int iM3112f5 = c2758y.m3112f();
                                    int iM3112f6 = c2758y.m3112f();
                                    int iM3112f7 = c2758y.m3112f();
                                    iM3112f2 -= (iM3112f4 + iM3112f5) * ((iM3112f == 1 || iM3112f == 2) ? 2 : 1);
                                    iM3112f3 -= (iM3112f6 + iM3112f7) * (iM3112f == 1 ? 2 : 1);
                                }
                                c2758y.m3112f();
                                c2758y.m3112f();
                                int iM3112f8 = c2758y.m3112f();
                                for (int i16 = c2758y.m3110d() ? 0 : iM3111e; i16 <= iM3111e; i16++) {
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
                                    int i17 = 0;
                                    for (int i18 = 4; i17 < i18; i18 = 4) {
                                        int i19 = 0;
                                        while (i19 < 6) {
                                            if (c2758y.m3110d()) {
                                                int iMin = Math.min(64, 1 << ((i17 << 1) + 4));
                                                if (i17 > 1) {
                                                    c2758y.m3113g();
                                                }
                                                for (int i20 = 0; i20 < iMin; i20++) {
                                                    c2758y.m3113g();
                                                }
                                            } else {
                                                c2758y.m3112f();
                                            }
                                            i19 += i17 == 3 ? 3 : 1;
                                            j4 = j4;
                                        }
                                        i17++;
                                    }
                                }
                                j = j4;
                                c2758y.m3116j(2);
                                if (c2758y.m3110d()) {
                                    c2758y.m3116j(8);
                                    c2758y.m3112f();
                                    c2758y.m3112f();
                                    c2758y.m3115i();
                                }
                                int i21 = 0;
                                boolean zM3110d2 = false;
                                int i22 = 0;
                                for (int iM3112f9 = c2758y.m3112f(); i21 < iM3112f9; iM3112f9 = iM3112f9) {
                                    if (i21 != 0) {
                                        zM3110d2 = c2758y.m3110d();
                                    }
                                    if (zM3110d2) {
                                        c2758y.m3115i();
                                        c2758y.m3112f();
                                        for (int i23 = 0; i23 <= i22; i23++) {
                                            if (c2758y.m3110d()) {
                                                c2758y.m3115i();
                                            }
                                        }
                                    } else {
                                        int iM3112f10 = c2758y.m3112f();
                                        int iM3112f11 = c2758y.m3112f();
                                        int i24 = iM3112f10 + iM3112f11;
                                        for (int i25 = 0; i25 < iM3112f10; i25++) {
                                            c2758y.m3112f();
                                            c2758y.m3115i();
                                        }
                                        for (int i26 = 0; i26 < iM3112f11; i26++) {
                                            c2758y.m3112f();
                                            c2758y.m3115i();
                                        }
                                        i22 = i24;
                                    }
                                    i21++;
                                }
                                if (c2758y.m3110d()) {
                                    for (int i27 = 0; i27 < c2758y.m3112f(); i27++) {
                                        c2758y.m3116j(iM3112f8 + 4 + 1);
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
                                            float[] fArr = C2754u.f6754b;
                                            if (iM3111e5 < fArr.length) {
                                                f = fArr[iM3111e5];
                                            } else {
                                                C1643a.m852g0(46, "Unexpected aspect_ratio_idc value: ", iM3111e5, "H265Reader");
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
                                        iM3112f3 *= 2;
                                    }
                                }
                                String strM3023b = C2741h.m3023b(iM3111e2, zM3110d, iM3111e3, i11, iArr, iM3111e4);
                                C2811j1.b bVar = new C2811j1.b();
                                bVar.f7163a = str;
                                bVar.f7173k = "video/hevc";
                                bVar.f7170h = strM3023b;
                                bVar.f7178p = iM3112f2;
                                bVar.f7179q = iM3112f3;
                                bVar.f7182t = f;
                                bVar.f7175m = Collections.singletonList(bArr2);
                                interfaceC3122w.mo2526e(bVar.m3277a());
                                this.f8841e = true;
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
                if (this.f8846j.m3789b(i8)) {
                    C3102w c3102w4 = this.f8846j;
                    this.f8850n.m3077C(this.f8846j.f8906d, C2754u.m3059f(c3102w4.f8906d, c3102w4.f8907e));
                    this.f8850n.m3080F(5);
                    j2 = j;
                    C1460d.m444J(j2, this.f8850n, this.f8837a.f8603b);
                } else {
                    j2 = j;
                }
                if (this.f8847k.m3789b(i8)) {
                    C3102w c3102w5 = this.f8847k;
                    this.f8850n.m3077C(this.f8847k.f8906d, C2754u.m3059f(c3102w5.f8906d, c3102w5.f8907e));
                    this.f8850n.m3080F(5);
                    C1460d.m444J(j2, this.f8850n, this.f8837a.f8603b);
                }
                long j5 = this.f8849m;
                a aVar2 = this.f8840d;
                boolean z3 = this.f8841e;
                aVar2.f8857g = false;
                aVar2.f8858h = false;
                aVar2.f8855e = j5;
                aVar2.f8854d = 0;
                aVar2.f8852b = j3;
                if (!(i5 < 32 || i5 == 40)) {
                    if (aVar2.f8859i && !aVar2.f8860j) {
                        if (z3) {
                            aVar2.m3785a(i7);
                        }
                        aVar2.f8859i = false;
                    }
                    if ((32 <= i5 && i5 <= 35) || i5 == 39) {
                        aVar2.f8858h = !aVar2.f8860j;
                        aVar2.f8860j = true;
                    }
                }
                boolean z4 = i5 >= 16 && i5 <= 21;
                aVar2.f8853c = z4;
                aVar2.f8856f = z4 || i5 <= 9;
                if (!this.f8841e) {
                    this.f8843g.m3791d(i5);
                    this.f8844h.m3791d(i5);
                    this.f8845i.m3791d(i5);
                }
                this.f8846j.m3791d(i5);
                this.f8847k.m3791d(i5);
                i3 = i3;
                bArr = bArr;
                i2 = i4;
            }
        }
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.p276k0.InterfaceC3094o
    /* JADX INFO: renamed from: c */
    public void mo3759c() {
        this.f8848l = 0L;
        this.f8849m = -9223372036854775807L;
        C2754u.m3054a(this.f8842f);
        this.f8843g.m3790c();
        this.f8844h.m3790c();
        this.f8845i.m3790c();
        this.f8846j.m3790c();
        this.f8847k.m3790c();
        a aVar = this.f8840d;
        if (aVar != null) {
            aVar.f8856f = false;
            aVar.f8857g = false;
            aVar.f8858h = false;
            aVar.f8859i = false;
            aVar.f8860j = false;
        }
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.p276k0.InterfaceC3094o
    /* JADX INFO: renamed from: d */
    public void mo3760d() {
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.p276k0.InterfaceC3094o
    /* JADX INFO: renamed from: e */
    public void mo3761e(InterfaceC3058j interfaceC3058j, InterfaceC3087i0.d dVar) {
        dVar.m3765a();
        this.f8838b = dVar.m3766b();
        InterfaceC3122w interfaceC3122wMo2492p = interfaceC3058j.mo2492p(dVar.m3767c(), 2);
        this.f8839c = interfaceC3122wMo2492p;
        this.f8840d = new a(interfaceC3122wMo2492p);
        this.f8837a.m3757a(interfaceC3058j, dVar);
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.p276k0.InterfaceC3094o
    /* JADX INFO: renamed from: f */
    public void mo3762f(long j, int i) {
        if (j != -9223372036854775807L) {
            this.f8849m = j;
        }
    }
}
