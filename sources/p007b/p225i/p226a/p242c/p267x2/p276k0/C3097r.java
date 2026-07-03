package p007b.p225i.p226a.p242c.p267x2.p276k0;

import android.util.SparseArray;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Arrays;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p225i.p226a.p242c.C2811j1;
import p007b.p225i.p226a.p242c.p259f3.C2738e0;
import p007b.p225i.p226a.p242c.p259f3.C2741h;
import p007b.p225i.p226a.p242c.p259f3.C2754u;
import p007b.p225i.p226a.p242c.p259f3.C2757x;
import p007b.p225i.p226a.p242c.p259f3.C2758y;
import p007b.p225i.p226a.p242c.p267x2.InterfaceC3058j;
import p007b.p225i.p226a.p242c.p267x2.InterfaceC3122w;
import p007b.p225i.p226a.p242c.p267x2.p276k0.InterfaceC3087i0;

/* JADX INFO: renamed from: b.i.a.c.x2.k0.r */
/* JADX INFO: compiled from: H264Reader.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C3097r implements InterfaceC3094o {

    /* JADX INFO: renamed from: a */
    public final C3079e0 f8788a;

    /* JADX INFO: renamed from: b */
    public final boolean f8789b;

    /* JADX INFO: renamed from: c */
    public final boolean f8790c;

    /* JADX INFO: renamed from: g */
    public long f8794g;

    /* JADX INFO: renamed from: i */
    public String f8796i;

    /* JADX INFO: renamed from: j */
    public InterfaceC3122w f8797j;

    /* JADX INFO: renamed from: k */
    public b f8798k;

    /* JADX INFO: renamed from: l */
    public boolean f8799l;

    /* JADX INFO: renamed from: n */
    public boolean f8801n;

    /* JADX INFO: renamed from: h */
    public final boolean[] f8795h = new boolean[3];

    /* JADX INFO: renamed from: d */
    public final C3102w f8791d = new C3102w(7, 128);

    /* JADX INFO: renamed from: e */
    public final C3102w f8792e = new C3102w(8, 128);

    /* JADX INFO: renamed from: f */
    public final C3102w f8793f = new C3102w(6, 128);

    /* JADX INFO: renamed from: m */
    public long f8800m = -9223372036854775807L;

    /* JADX INFO: renamed from: o */
    public final C2757x f8802o = new C2757x();

    /* JADX INFO: renamed from: b.i.a.c.x2.k0.r$b */
    /* JADX INFO: compiled from: H264Reader.java */
    public static final class b {

        /* JADX INFO: renamed from: a */
        public final InterfaceC3122w f8803a;

        /* JADX INFO: renamed from: b */
        public final boolean f8804b;

        /* JADX INFO: renamed from: c */
        public final boolean f8805c;

        /* JADX INFO: renamed from: f */
        public final C2758y f8808f;

        /* JADX INFO: renamed from: g */
        public byte[] f8809g;

        /* JADX INFO: renamed from: h */
        public int f8810h;

        /* JADX INFO: renamed from: i */
        public int f8811i;

        /* JADX INFO: renamed from: j */
        public long f8812j;

        /* JADX INFO: renamed from: l */
        public long f8814l;

        /* JADX INFO: renamed from: p */
        public long f8818p;

        /* JADX INFO: renamed from: q */
        public long f8819q;

        /* JADX INFO: renamed from: r */
        public boolean f8820r;

        /* JADX INFO: renamed from: d */
        public final SparseArray<C2754u.c> f8806d = new SparseArray<>();

        /* JADX INFO: renamed from: e */
        public final SparseArray<C2754u.b> f8807e = new SparseArray<>();

        /* JADX INFO: renamed from: m */
        public a f8815m = new a(null);

        /* JADX INFO: renamed from: n */
        public a f8816n = new a(null);

        /* JADX INFO: renamed from: k */
        public boolean f8813k = false;

        /* JADX INFO: renamed from: o */
        public boolean f8817o = false;

        /* JADX INFO: renamed from: b.i.a.c.x2.k0.r$b$a */
        /* JADX INFO: compiled from: H264Reader.java */
        public static final class a {

            /* JADX INFO: renamed from: a */
            public boolean f8821a;

            /* JADX INFO: renamed from: b */
            public boolean f8822b;

            /* JADX INFO: renamed from: c */
            @Nullable
            public C2754u.c f8823c;

            /* JADX INFO: renamed from: d */
            public int f8824d;

            /* JADX INFO: renamed from: e */
            public int f8825e;

            /* JADX INFO: renamed from: f */
            public int f8826f;

            /* JADX INFO: renamed from: g */
            public int f8827g;

            /* JADX INFO: renamed from: h */
            public boolean f8828h;

            /* JADX INFO: renamed from: i */
            public boolean f8829i;

            /* JADX INFO: renamed from: j */
            public boolean f8830j;

            /* JADX INFO: renamed from: k */
            public boolean f8831k;

            /* JADX INFO: renamed from: l */
            public int f8832l;

            /* JADX INFO: renamed from: m */
            public int f8833m;

            /* JADX INFO: renamed from: n */
            public int f8834n;

            /* JADX INFO: renamed from: o */
            public int f8835o;

            /* JADX INFO: renamed from: p */
            public int f8836p;

            public a(a aVar) {
            }
        }

        public b(InterfaceC3122w interfaceC3122w, boolean z2, boolean z3) {
            this.f8803a = interfaceC3122w;
            this.f8804b = z2;
            this.f8805c = z3;
            byte[] bArr = new byte[128];
            this.f8809g = bArr;
            this.f8808f = new C2758y(bArr, 0, 0);
            a aVar = this.f8816n;
            aVar.f8822b = false;
            aVar.f8821a = false;
        }
    }

    public C3097r(C3079e0 c3079e0, boolean z2, boolean z3) {
        this.f8788a = c3079e0;
        this.f8789b = z2;
        this.f8790c = z3;
    }

    /* JADX WARN: Code duplicated, block: B:105:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:106:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:55:0x0126  */
    /* JADX WARN: Code duplicated, block: B:56:0x0128  */
    /* JADX WARN: Code duplicated, block: B:58:0x012b  */
    /* JADX WARN: Code duplicated, block: B:61:0x0135  */
    /* JADX WARN: Code duplicated, block: B:62:0x013c  */
    /* JADX WARN: Code duplicated, block: B:65:0x0141  */
    /* JADX WARN: Code duplicated, block: B:68:0x014d  */
    /* JADX WARN: Code duplicated, block: B:75:0x016c  */
    /* JADX WARN: Code duplicated, block: B:77:0x0171  */
    /* JADX WARN: Code duplicated, block: B:90:0x01a0  */
    @RequiresNonNull({"sampleReader"})
    /* JADX INFO: renamed from: a */
    public final void m3783a(byte[] bArr, int i, int i2) {
        boolean zM3110d;
        boolean zM3110d2;
        boolean z2;
        boolean z3;
        int iM3112f;
        int i3;
        int iM3113g;
        int i4;
        int iM3111e;
        int iM3113g2;
        int i5;
        int iM3113g3;
        if (!this.f8799l || this.f8798k.f8805c) {
            this.f8791d.m3788a(bArr, i, i2);
            this.f8792e.m3788a(bArr, i, i2);
        }
        this.f8793f.m3788a(bArr, i, i2);
        b bVar = this.f8798k;
        if (bVar.f8813k) {
            int i6 = i2 - i;
            byte[] bArr2 = bVar.f8809g;
            int length = bArr2.length;
            int i7 = bVar.f8810h + i6;
            if (length < i7) {
                bVar.f8809g = Arrays.copyOf(bArr2, i7 * 2);
            }
            System.arraycopy(bArr, i, bVar.f8809g, bVar.f8810h, i6);
            int i8 = bVar.f8810h + i6;
            bVar.f8810h = i8;
            C2758y c2758y = bVar.f8808f;
            c2758y.f6796a = bVar.f8809g;
            c2758y.f6798c = 0;
            c2758y.f6797b = i8;
            c2758y.f6799d = 0;
            c2758y.m3107a();
            if (bVar.f8808f.m3108b(8)) {
                bVar.f8808f.m3115i();
                int iM3111e2 = bVar.f8808f.m3111e(2);
                bVar.f8808f.m3116j(5);
                if (bVar.f8808f.m3109c()) {
                    bVar.f8808f.m3112f();
                    if (bVar.f8808f.m3109c()) {
                        int iM3112f2 = bVar.f8808f.m3112f();
                        if (!bVar.f8805c) {
                            bVar.f8813k = false;
                            b.a aVar = bVar.f8816n;
                            aVar.f8825e = iM3112f2;
                            aVar.f8822b = true;
                            return;
                        }
                        if (bVar.f8808f.m3109c()) {
                            int iM3112f3 = bVar.f8808f.m3112f();
                            if (bVar.f8807e.indexOfKey(iM3112f3) < 0) {
                                bVar.f8813k = false;
                                return;
                            }
                            C2754u.b bVar2 = bVar.f8807e.get(iM3112f3);
                            C2754u.c cVar = bVar.f8806d.get(bVar2.f6767b);
                            if (cVar.f6776h) {
                                if (!bVar.f8808f.m3108b(2)) {
                                    return;
                                } else {
                                    bVar.f8808f.m3116j(2);
                                }
                            }
                            if (bVar.f8808f.m3108b(cVar.f6778j)) {
                                int iM3111e3 = bVar.f8808f.m3111e(cVar.f6778j);
                                if (!cVar.f6777i) {
                                    if (bVar.f8808f.m3108b(1)) {
                                        zM3110d = bVar.f8808f.m3110d();
                                        if (zM3110d) {
                                            if (!bVar.f8808f.m3108b(1)) {
                                                return;
                                            }
                                            zM3110d2 = bVar.f8808f.m3110d();
                                            z2 = true;
                                        }
                                        if (bVar.f8811i == 5) {
                                            z3 = true;
                                        } else {
                                            z3 = false;
                                        }
                                        if (z3) {
                                            iM3112f = 0;
                                        } else if (!bVar.f8808f.m3109c()) {
                                            return;
                                        } else {
                                            iM3112f = bVar.f8808f.m3112f();
                                        }
                                        i3 = cVar.f6779k;
                                        if (i3 != 0) {
                                            if (i3 == 1 || cVar.f6781m) {
                                                iM3113g = 0;
                                            } else {
                                                if (!bVar.f8808f.m3109c()) {
                                                    return;
                                                }
                                                iM3113g = bVar.f8808f.m3113g();
                                                if (bVar2.f6768c && !zM3110d) {
                                                    if (!bVar.f8808f.m3109c()) {
                                                        return;
                                                    }
                                                    iM3113g2 = bVar.f8808f.m3113g();
                                                    i5 = 0;
                                                    i4 = iM3113g;
                                                    iM3111e = 0;
                                                }
                                            }
                                            i4 = iM3113g;
                                            iM3111e = 0;
                                            iM3113g2 = 0;
                                            i5 = 0;
                                        } else {
                                            if (!bVar.f8808f.m3108b(cVar.f6780l)) {
                                                return;
                                            }
                                            iM3111e = bVar.f8808f.m3111e(cVar.f6780l);
                                            if (bVar2.f6768c || zM3110d) {
                                                iM3113g3 = 0;
                                            } else if (!bVar.f8808f.m3109c()) {
                                                return;
                                            } else {
                                                iM3113g3 = bVar.f8808f.m3113g();
                                            }
                                            i5 = iM3113g3;
                                            iM3113g2 = 0;
                                            i4 = 0;
                                        }
                                        b.a aVar2 = bVar.f8816n;
                                        aVar2.f8823c = cVar;
                                        aVar2.f8824d = iM3111e2;
                                        aVar2.f8825e = iM3112f2;
                                        aVar2.f8826f = iM3111e3;
                                        aVar2.f8827g = iM3112f3;
                                        aVar2.f8828h = zM3110d;
                                        aVar2.f8829i = z2;
                                        aVar2.f8830j = zM3110d2;
                                        aVar2.f8831k = z3;
                                        aVar2.f8832l = iM3112f;
                                        aVar2.f8833m = iM3111e;
                                        aVar2.f8834n = i5;
                                        aVar2.f8835o = i4;
                                        aVar2.f8836p = iM3113g2;
                                        aVar2.f8821a = true;
                                        aVar2.f8822b = true;
                                        bVar.f8813k = false;
                                    }
                                    return;
                                }
                                zM3110d = false;
                                zM3110d2 = false;
                                z2 = false;
                                if (bVar.f8811i == 5) {
                                    z3 = true;
                                } else {
                                    z3 = false;
                                }
                                if (z3) {
                                    iM3112f = 0;
                                } else if (!bVar.f8808f.m3109c()) {
                                    return;
                                } else {
                                    iM3112f = bVar.f8808f.m3112f();
                                }
                                i3 = cVar.f6779k;
                                if (i3 != 0) {
                                    if (!bVar.f8808f.m3108b(cVar.f6780l)) {
                                        return;
                                    }
                                    iM3111e = bVar.f8808f.m3111e(cVar.f6780l);
                                    if (bVar2.f6768c) {
                                        iM3113g3 = 0;
                                    } else {
                                        iM3113g3 = 0;
                                    }
                                    i5 = iM3113g3;
                                    iM3113g2 = 0;
                                    i4 = 0;
                                } else if (i3 == 1) {
                                    iM3113g = 0;
                                    i4 = iM3113g;
                                    iM3111e = 0;
                                    iM3113g2 = 0;
                                    i5 = 0;
                                } else {
                                    iM3113g = 0;
                                    i4 = iM3113g;
                                    iM3111e = 0;
                                    iM3113g2 = 0;
                                    i5 = 0;
                                }
                                b.a aVar3 = bVar.f8816n;
                                aVar3.f8823c = cVar;
                                aVar3.f8824d = iM3111e2;
                                aVar3.f8825e = iM3112f2;
                                aVar3.f8826f = iM3111e3;
                                aVar3.f8827g = iM3112f3;
                                aVar3.f8828h = zM3110d;
                                aVar3.f8829i = z2;
                                aVar3.f8830j = zM3110d2;
                                aVar3.f8831k = z3;
                                aVar3.f8832l = iM3112f;
                                aVar3.f8833m = iM3111e;
                                aVar3.f8834n = i5;
                                aVar3.f8835o = i4;
                                aVar3.f8836p = iM3113g2;
                                aVar3.f8821a = true;
                                aVar3.f8822b = true;
                                bVar.f8813k = false;
                            }
                        }
                    }
                }
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:131:0x0292  */
    /* JADX WARN: Code duplicated, block: B:19:0x0055  */
    /* JADX WARN: Code duplicated, block: B:84:0x01ee  */
    /* JADX WARN: Code duplicated, block: B:87:0x01f3  */
    /* JADX WARN: Code duplicated, block: B:93:0x020c  */
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
    @Override // p007b.p225i.p226a.p242c.p267x2.p276k0.InterfaceC3094o
    /* JADX INFO: renamed from: b */
    public void mo3758b(C2757x c2757x) {
        int i;
        byte[] bArr;
        long j;
        int i2;
        long j2;
        int i3;
        int i4;
        boolean z2;
        int i5;
        int i6;
        int i7;
        boolean z3;
        C1460d.m438H(this.f8797j);
        int i8 = C2738e0.f6708a;
        int i9 = c2757x.f6794b;
        int i10 = c2757x.f6795c;
        byte[] bArr2 = c2757x.f6793a;
        this.f8794g += (long) c2757x.m3081a();
        this.f8797j.mo2524c(c2757x, c2757x.m3081a());
        while (true) {
            int iM3055b = C2754u.m3055b(bArr2, i9, i10, this.f8795h);
            if (iM3055b == i10) {
                m3783a(bArr2, i9, i10);
                return;
            }
            int i11 = iM3055b + 3;
            int i12 = bArr2[i11] & 31;
            int i13 = iM3055b - i9;
            if (i13 > 0) {
                m3783a(bArr2, i9, iM3055b);
            }
            int i14 = i10 - iM3055b;
            long j3 = this.f8794g - ((long) i14);
            int i15 = i13 < 0 ? -i13 : 0;
            long j4 = this.f8800m;
            if (!this.f8799l || this.f8798k.f8805c) {
                this.f8791d.m3789b(i15);
                this.f8792e.m3789b(i15);
                if (this.f8799l) {
                    i = i10;
                    bArr = bArr2;
                    C3102w c3102w = this.f8791d;
                    if (c3102w.f8905c) {
                        C2754u.c cVarM3058e = C2754u.m3058e(c3102w.f8906d, 3, c3102w.f8907e);
                        this.f8798k.f8806d.append(cVarM3058e.f6772d, cVarM3058e);
                        this.f8791d.m3790c();
                    } else {
                        C3102w c3102w2 = this.f8792e;
                        if (c3102w2.f8905c) {
                            C2754u.b bVarM3057d = C2754u.m3057d(c3102w2.f8906d, 3, c3102w2.f8907e);
                            this.f8798k.f8807e.append(bVarM3057d.f6766a, bVarM3057d);
                            this.f8792e.m3790c();
                        }
                    }
                } else if (this.f8791d.f8905c && this.f8792e.f8905c) {
                    ArrayList arrayList = new ArrayList();
                    C3102w c3102w3 = this.f8791d;
                    arrayList.add(Arrays.copyOf(c3102w3.f8906d, c3102w3.f8907e));
                    C3102w c3102w4 = this.f8792e;
                    arrayList.add(Arrays.copyOf(c3102w4.f8906d, c3102w4.f8907e));
                    C3102w c3102w5 = this.f8791d;
                    C2754u.c cVarM3058e2 = C2754u.m3058e(c3102w5.f8906d, 3, c3102w5.f8907e);
                    C3102w c3102w6 = this.f8792e;
                    C2754u.b bVarM3057d2 = C2754u.m3057d(c3102w6.f8906d, 3, c3102w6.f8907e);
                    i = i10;
                    String strM3022a = C2741h.m3022a(cVarM3058e2.f6769a, cVarM3058e2.f6770b, cVarM3058e2.f6771c);
                    InterfaceC3122w interfaceC3122w = this.f8797j;
                    C2811j1.b bVar = new C2811j1.b();
                    bArr = bArr2;
                    bVar.f7163a = this.f8796i;
                    bVar.f7173k = "video/avc";
                    bVar.f7170h = strM3022a;
                    bVar.f7178p = cVarM3058e2.f6773e;
                    bVar.f7179q = cVarM3058e2.f6774f;
                    bVar.f7182t = cVarM3058e2.f6775g;
                    bVar.f7175m = arrayList;
                    interfaceC3122w.mo2526e(bVar.m3277a());
                    this.f8799l = true;
                    this.f8798k.f8806d.append(cVarM3058e2.f6772d, cVarM3058e2);
                    this.f8798k.f8807e.append(bVarM3057d2.f6766a, bVarM3057d2);
                    this.f8791d.m3790c();
                    this.f8792e.m3790c();
                } else {
                    i = i10;
                    bArr = bArr2;
                }
            } else {
                i = i10;
                bArr = bArr2;
            }
            if (this.f8793f.m3789b(i15)) {
                C3102w c3102w7 = this.f8793f;
                this.f8802o.m3077C(this.f8793f.f8906d, C2754u.m3059f(c3102w7.f8906d, c3102w7.f8907e));
                this.f8802o.m3079E(4);
                C1460d.m444J(j4, this.f8802o, this.f8788a.f8603b);
            }
            b bVar2 = this.f8798k;
            boolean z4 = this.f8799l;
            boolean z5 = this.f8801n;
            if (bVar2.f8811i == 9) {
                if (z4 && bVar2.f8817o) {
                    j = bVar2.f8812j;
                    i2 = i14 + ((int) (j3 - j));
                    j2 = bVar2.f8819q;
                    if (j2 != -9223372036854775807L) {
                        bVar2.f8803a.mo2525d(j2, bVar2.f8820r ? 1 : 0, (int) (j - bVar2.f8818p), i2, null);
                    }
                }
                bVar2.f8818p = bVar2.f8812j;
                bVar2.f8819q = bVar2.f8814l;
                bVar2.f8820r = false;
                bVar2.f8817o = true;
            } else if (bVar2.f8805c) {
                b.a aVar = bVar2.f8816n;
                b.a aVar2 = bVar2.f8815m;
                if (aVar.f8821a) {
                    if (aVar2.f8821a) {
                        C2754u.c cVar = aVar.f8823c;
                        C1460d.m438H(cVar);
                        C2754u.c cVar2 = aVar2.f8823c;
                        C1460d.m438H(cVar2);
                        if (aVar.f8826f == aVar2.f8826f && aVar.f8827g == aVar2.f8827g && aVar.f8828h == aVar2.f8828h && ((!aVar.f8829i || !aVar2.f8829i || aVar.f8830j == aVar2.f8830j) && (((i5 = aVar.f8824d) == (i6 = aVar2.f8824d) || (i5 != 0 && i6 != 0)) && (((i7 = cVar.f6779k) != 0 || cVar2.f6779k != 0 || (aVar.f8833m == aVar2.f8833m && aVar.f8834n == aVar2.f8834n)) && ((i7 != 1 || cVar2.f6779k != 1 || (aVar.f8835o == aVar2.f8835o && aVar.f8836p == aVar2.f8836p)) && (z3 = aVar.f8831k) == aVar2.f8831k && (!z3 || aVar.f8832l == aVar2.f8832l)))))) {
                            z2 = false;
                        }
                    }
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2) {
                    if (z4) {
                        j = bVar2.f8812j;
                        i2 = i14 + ((int) (j3 - j));
                        j2 = bVar2.f8819q;
                        if (j2 != -9223372036854775807L) {
                            bVar2.f8803a.mo2525d(j2, bVar2.f8820r ? 1 : 0, (int) (j - bVar2.f8818p), i2, null);
                        }
                    }
                    bVar2.f8818p = bVar2.f8812j;
                    bVar2.f8819q = bVar2.f8814l;
                    bVar2.f8820r = false;
                    bVar2.f8817o = true;
                }
            }
            if (bVar2.f8804b) {
                b.a aVar3 = bVar2.f8816n;
                z5 = aVar3.f8822b && ((i4 = aVar3.f8825e) == 7 || i4 == 2);
            }
            boolean z6 = bVar2.f8820r;
            int i16 = bVar2.f8811i;
            boolean z7 = z6 | (i16 == 5 || (z5 && i16 == 1));
            bVar2.f8820r = z7;
            if (z7) {
                this.f8801n = false;
            }
            long j5 = this.f8800m;
            if (!this.f8799l || this.f8798k.f8805c) {
                this.f8791d.m3791d(i12);
                this.f8792e.m3791d(i12);
            }
            this.f8793f.m3791d(i12);
            b bVar3 = this.f8798k;
            bVar3.f8811i = i12;
            bVar3.f8814l = j5;
            bVar3.f8812j = j3;
            if (bVar3.f8804b) {
                i3 = 1;
                if (i12 == 1) {
                    b.a aVar4 = bVar3.f8815m;
                    bVar3.f8815m = bVar3.f8816n;
                    bVar3.f8816n = aVar4;
                    aVar4.f8822b = false;
                    aVar4.f8821a = false;
                    bVar3.f8810h = 0;
                    bVar3.f8813k = true;
                }
                i9 = i11;
                i10 = i;
                bArr2 = bArr;
            } else {
                i3 = 1;
            }
            if (bVar3.f8805c && (i12 == 5 || i12 == i3 || i12 == 2)) {
                b.a aVar5 = bVar3.f8815m;
                bVar3.f8815m = bVar3.f8816n;
                bVar3.f8816n = aVar5;
                aVar5.f8822b = false;
                aVar5.f8821a = false;
                bVar3.f8810h = 0;
                bVar3.f8813k = true;
            }
            i9 = i11;
            i10 = i;
            bArr2 = bArr;
        }
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.p276k0.InterfaceC3094o
    /* JADX INFO: renamed from: c */
    public void mo3759c() {
        this.f8794g = 0L;
        this.f8801n = false;
        this.f8800m = -9223372036854775807L;
        C2754u.m3054a(this.f8795h);
        this.f8791d.m3790c();
        this.f8792e.m3790c();
        this.f8793f.m3790c();
        b bVar = this.f8798k;
        if (bVar != null) {
            bVar.f8813k = false;
            bVar.f8817o = false;
            b.a aVar = bVar.f8816n;
            aVar.f8822b = false;
            aVar.f8821a = false;
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
        this.f8796i = dVar.m3766b();
        InterfaceC3122w interfaceC3122wMo2492p = interfaceC3058j.mo2492p(dVar.m3767c(), 2);
        this.f8797j = interfaceC3122wMo2492p;
        this.f8798k = new b(interfaceC3122wMo2492p, this.f8789b, this.f8790c);
        this.f8788a.m3757a(interfaceC3058j, dVar);
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.p276k0.InterfaceC3094o
    /* JADX INFO: renamed from: f */
    public void mo3762f(long j, int i) {
        if (j != -9223372036854775807L) {
            this.f8800m = j;
        }
        this.f8801n |= (i & 2) != 0;
    }
}
