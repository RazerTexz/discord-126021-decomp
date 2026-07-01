package b.i.a.c.x2.k0;

import b.i.a.c.f3.u$b;
import b.i.a.c.f3.u$c;
import b.i.a.c.j1$b;
import java.util.ArrayList;
import java.util.Arrays;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* JADX INFO: compiled from: H264Reader.java */
/* JADX INFO: loaded from: classes3.dex */
public final class r implements o {
    public final e0 a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f1272b;
    public final boolean c;
    public long g;
    public String i;
    public b.i.a.c.x2.w j;
    public r$b k;
    public boolean l;
    public boolean n;
    public final boolean[] h = new boolean[3];
    public final w d = new w(7, 128);
    public final w e = new w(8, 128);
    public final w f = new w(6, 128);
    public long m = -9223372036854775807L;
    public final b.i.a.c.f3.x o = new b.i.a.c.f3.x();

    public r(e0 e0Var, boolean z2, boolean z3) {
        this.a = e0Var;
        this.f1272b = z2;
        this.c = z3;
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
    public final void a(byte[] bArr, int i, int i2) {
        boolean zD;
        boolean zD2;
        boolean z2;
        boolean z3;
        int iF;
        int i3;
        int iG;
        int i4;
        int iE;
        int iG2;
        int i5;
        int iG3;
        if (!this.l || this.k.c) {
            this.d.a(bArr, i, i2);
            this.e.a(bArr, i, i2);
        }
        this.f.a(bArr, i, i2);
        r$b r_b = this.k;
        if (r_b.k) {
            int i6 = i2 - i;
            byte[] bArr2 = r_b.g;
            int length = bArr2.length;
            int i7 = r_b.h + i6;
            if (length < i7) {
                r_b.g = Arrays.copyOf(bArr2, i7 * 2);
            }
            System.arraycopy(bArr, i, r_b.g, r_b.h, i6);
            int i8 = r_b.h + i6;
            r_b.h = i8;
            b.i.a.c.f3.y yVar = r_b.f;
            yVar.a = r_b.g;
            yVar.c = 0;
            yVar.f985b = i8;
            yVar.d = 0;
            yVar.a();
            if (r_b.f.b(8)) {
                r_b.f.i();
                int iE2 = r_b.f.e(2);
                r_b.f.j(5);
                if (r_b.f.c()) {
                    r_b.f.f();
                    if (r_b.f.c()) {
                        int iF2 = r_b.f.f();
                        if (!r_b.c) {
                            r_b.k = false;
                            r$b$a r_b_a = r_b.n;
                            r_b_a.e = iF2;
                            r_b_a.f1274b = true;
                            return;
                        }
                        if (r_b.f.c()) {
                            int iF3 = r_b.f.f();
                            if (r_b.e.indexOfKey(iF3) < 0) {
                                r_b.k = false;
                                return;
                            }
                            u$b u_b = r_b.e.get(iF3);
                            u$c u_c = r_b.d.get(u_b.f980b);
                            if (u_c.h) {
                                if (!r_b.f.b(2)) {
                                    return;
                                } else {
                                    r_b.f.j(2);
                                }
                            }
                            if (r_b.f.b(u_c.j)) {
                                int iE3 = r_b.f.e(u_c.j);
                                if (!u_c.i) {
                                    if (r_b.f.b(1)) {
                                        zD = r_b.f.d();
                                        if (zD) {
                                            if (!r_b.f.b(1)) {
                                                return;
                                            }
                                            zD2 = r_b.f.d();
                                            z2 = true;
                                        }
                                        if (r_b.i == 5) {
                                            z3 = true;
                                        } else {
                                            z3 = false;
                                        }
                                        if (z3) {
                                            iF = 0;
                                        } else if (!r_b.f.c()) {
                                            return;
                                        } else {
                                            iF = r_b.f.f();
                                        }
                                        i3 = u_c.k;
                                        if (i3 != 0) {
                                            if (i3 == 1 || u_c.m) {
                                                iG = 0;
                                            } else {
                                                if (!r_b.f.c()) {
                                                    return;
                                                }
                                                iG = r_b.f.g();
                                                if (u_b.c && !zD) {
                                                    if (!r_b.f.c()) {
                                                        return;
                                                    }
                                                    iG2 = r_b.f.g();
                                                    i5 = 0;
                                                    i4 = iG;
                                                    iE = 0;
                                                }
                                            }
                                            i4 = iG;
                                            iE = 0;
                                            iG2 = 0;
                                            i5 = 0;
                                        } else {
                                            if (!r_b.f.b(u_c.l)) {
                                                return;
                                            }
                                            iE = r_b.f.e(u_c.l);
                                            if (u_b.c || zD) {
                                                iG3 = 0;
                                            } else if (!r_b.f.c()) {
                                                return;
                                            } else {
                                                iG3 = r_b.f.g();
                                            }
                                            i5 = iG3;
                                            iG2 = 0;
                                            i4 = 0;
                                        }
                                        r$b$a r_b_a2 = r_b.n;
                                        r_b_a2.c = u_c;
                                        r_b_a2.d = iE2;
                                        r_b_a2.e = iF2;
                                        r_b_a2.f = iE3;
                                        r_b_a2.g = iF3;
                                        r_b_a2.h = zD;
                                        r_b_a2.i = z2;
                                        r_b_a2.j = zD2;
                                        r_b_a2.k = z3;
                                        r_b_a2.l = iF;
                                        r_b_a2.m = iE;
                                        r_b_a2.n = i5;
                                        r_b_a2.o = i4;
                                        r_b_a2.p = iG2;
                                        r_b_a2.a = true;
                                        r_b_a2.f1274b = true;
                                        r_b.k = false;
                                    }
                                    return;
                                }
                                zD = false;
                                zD2 = false;
                                z2 = false;
                                if (r_b.i == 5) {
                                    z3 = true;
                                } else {
                                    z3 = false;
                                }
                                if (z3) {
                                    iF = 0;
                                } else if (!r_b.f.c()) {
                                    return;
                                } else {
                                    iF = r_b.f.f();
                                }
                                i3 = u_c.k;
                                if (i3 != 0) {
                                    if (!r_b.f.b(u_c.l)) {
                                        return;
                                    }
                                    iE = r_b.f.e(u_c.l);
                                    if (u_b.c) {
                                        iG3 = 0;
                                    } else {
                                        iG3 = 0;
                                    }
                                    i5 = iG3;
                                    iG2 = 0;
                                    i4 = 0;
                                } else if (i3 == 1) {
                                    iG = 0;
                                    i4 = iG;
                                    iE = 0;
                                    iG2 = 0;
                                    i5 = 0;
                                } else {
                                    iG = 0;
                                    i4 = iG;
                                    iE = 0;
                                    iG2 = 0;
                                    i5 = 0;
                                }
                                r$b$a r_b_a3 = r_b.n;
                                r_b_a3.c = u_c;
                                r_b_a3.d = iE2;
                                r_b_a3.e = iF2;
                                r_b_a3.f = iE3;
                                r_b_a3.g = iF3;
                                r_b_a3.h = zD;
                                r_b_a3.i = z2;
                                r_b_a3.j = zD2;
                                r_b_a3.k = z3;
                                r_b_a3.l = iF;
                                r_b_a3.m = iE;
                                r_b_a3.n = i5;
                                r_b_a3.o = i4;
                                r_b_a3.p = iG2;
                                r_b_a3.a = true;
                                r_b_a3.f1274b = true;
                                r_b.k = false;
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
    @Override // b.i.a.c.x2.k0.o
    public void b(b.i.a.c.f3.x xVar) {
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
        b.c.a.a0.d.H(this.j);
        int i8 = b.i.a.c.f3.e0.a;
        int i9 = xVar.f984b;
        int i10 = xVar.c;
        byte[] bArr2 = xVar.a;
        this.g += (long) xVar.a();
        this.j.c(xVar, xVar.a());
        while (true) {
            int iB = b.i.a.c.f3.u.b(bArr2, i9, i10, this.h);
            if (iB == i10) {
                a(bArr2, i9, i10);
                return;
            }
            int i11 = iB + 3;
            int i12 = bArr2[i11] & 31;
            int i13 = iB - i9;
            if (i13 > 0) {
                a(bArr2, i9, iB);
            }
            int i14 = i10 - iB;
            long j3 = this.g - ((long) i14);
            int i15 = i13 < 0 ? -i13 : 0;
            long j4 = this.m;
            if (!this.l || this.k.c) {
                this.d.b(i15);
                this.e.b(i15);
                if (this.l) {
                    i = i10;
                    bArr = bArr2;
                    w wVar = this.d;
                    if (wVar.c) {
                        u$c u_cE = b.i.a.c.f3.u.e(wVar.d, 3, wVar.e);
                        this.k.d.append(u_cE.d, u_cE);
                        this.d.c();
                    } else {
                        w wVar2 = this.e;
                        if (wVar2.c) {
                            u$b u_bD = b.i.a.c.f3.u.d(wVar2.d, 3, wVar2.e);
                            this.k.e.append(u_bD.a, u_bD);
                            this.e.c();
                        }
                    }
                } else if (this.d.c && this.e.c) {
                    ArrayList arrayList = new ArrayList();
                    w wVar3 = this.d;
                    arrayList.add(Arrays.copyOf(wVar3.d, wVar3.e));
                    w wVar4 = this.e;
                    arrayList.add(Arrays.copyOf(wVar4.d, wVar4.e));
                    w wVar5 = this.d;
                    u$c u_cE2 = b.i.a.c.f3.u.e(wVar5.d, 3, wVar5.e);
                    w wVar6 = this.e;
                    u$b u_bD2 = b.i.a.c.f3.u.d(wVar6.d, 3, wVar6.e);
                    i = i10;
                    String strA = b.i.a.c.f3.h.a(u_cE2.a, u_cE2.f981b, u_cE2.c);
                    b.i.a.c.x2.w wVar7 = this.j;
                    j1$b j1_b = new j1$b();
                    bArr = bArr2;
                    j1_b.a = this.i;
                    j1_b.k = "video/avc";
                    j1_b.h = strA;
                    j1_b.p = u_cE2.e;
                    j1_b.q = u_cE2.f;
                    j1_b.t = u_cE2.g;
                    j1_b.m = arrayList;
                    wVar7.e(j1_b.a());
                    this.l = true;
                    this.k.d.append(u_cE2.d, u_cE2);
                    this.k.e.append(u_bD2.a, u_bD2);
                    this.d.c();
                    this.e.c();
                } else {
                    i = i10;
                    bArr = bArr2;
                }
            } else {
                i = i10;
                bArr = bArr2;
            }
            if (this.f.b(i15)) {
                w wVar8 = this.f;
                this.o.C(this.f.d, b.i.a.c.f3.u.f(wVar8.d, wVar8.e));
                this.o.E(4);
                b.c.a.a0.d.J(j4, this.o, this.a.f1246b);
            }
            r$b r_b = this.k;
            boolean z4 = this.l;
            boolean z5 = this.n;
            if (r_b.i == 9) {
                if (z4 && r_b.o) {
                    j = r_b.j;
                    i2 = i14 + ((int) (j3 - j));
                    j2 = r_b.q;
                    if (j2 != -9223372036854775807L) {
                        r_b.a.d(j2, r_b.r ? 1 : 0, (int) (j - r_b.p), i2, null);
                    }
                }
                r_b.p = r_b.j;
                r_b.q = r_b.l;
                r_b.r = false;
                r_b.o = true;
            } else if (r_b.c) {
                r$b$a r_b_a = r_b.n;
                r$b$a r_b_a2 = r_b.m;
                if (r_b_a.a) {
                    if (r_b_a2.a) {
                        u$c u_c = r_b_a.c;
                        b.c.a.a0.d.H(u_c);
                        u$c u_c2 = r_b_a2.c;
                        b.c.a.a0.d.H(u_c2);
                        if (r_b_a.f == r_b_a2.f && r_b_a.g == r_b_a2.g && r_b_a.h == r_b_a2.h && ((!r_b_a.i || !r_b_a2.i || r_b_a.j == r_b_a2.j) && (((i5 = r_b_a.d) == (i6 = r_b_a2.d) || (i5 != 0 && i6 != 0)) && (((i7 = u_c.k) != 0 || u_c2.k != 0 || (r_b_a.m == r_b_a2.m && r_b_a.n == r_b_a2.n)) && ((i7 != 1 || u_c2.k != 1 || (r_b_a.o == r_b_a2.o && r_b_a.p == r_b_a2.p)) && (z3 = r_b_a.k) == r_b_a2.k && (!z3 || r_b_a.l == r_b_a2.l)))))) {
                            z2 = false;
                        }
                    }
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2) {
                    if (z4) {
                        j = r_b.j;
                        i2 = i14 + ((int) (j3 - j));
                        j2 = r_b.q;
                        if (j2 != -9223372036854775807L) {
                            r_b.a.d(j2, r_b.r ? 1 : 0, (int) (j - r_b.p), i2, null);
                        }
                    }
                    r_b.p = r_b.j;
                    r_b.q = r_b.l;
                    r_b.r = false;
                    r_b.o = true;
                }
            }
            if (r_b.f1273b) {
                r$b$a r_b_a3 = r_b.n;
                z5 = r_b_a3.f1274b && ((i4 = r_b_a3.e) == 7 || i4 == 2);
            }
            boolean z6 = r_b.r;
            int i16 = r_b.i;
            boolean z7 = z6 | (i16 == 5 || (z5 && i16 == 1));
            r_b.r = z7;
            if (z7) {
                this.n = false;
            }
            long j5 = this.m;
            if (!this.l || this.k.c) {
                this.d.d(i12);
                this.e.d(i12);
            }
            this.f.d(i12);
            r$b r_b2 = this.k;
            r_b2.i = i12;
            r_b2.l = j5;
            r_b2.j = j3;
            if (r_b2.f1273b) {
                i3 = 1;
                if (i12 == 1) {
                    r$b$a r_b_a4 = r_b2.m;
                    r_b2.m = r_b2.n;
                    r_b2.n = r_b_a4;
                    r_b_a4.f1274b = false;
                    r_b_a4.a = false;
                    r_b2.h = 0;
                    r_b2.k = true;
                }
                i9 = i11;
                i10 = i;
                bArr2 = bArr;
            } else {
                i3 = 1;
            }
            if (r_b2.c && (i12 == 5 || i12 == i3 || i12 == 2)) {
                r$b$a r_b_a5 = r_b2.m;
                r_b2.m = r_b2.n;
                r_b2.n = r_b_a5;
                r_b_a5.f1274b = false;
                r_b_a5.a = false;
                r_b2.h = 0;
                r_b2.k = true;
            }
            i9 = i11;
            i10 = i;
            bArr2 = bArr;
        }
    }

    @Override // b.i.a.c.x2.k0.o
    public void c() {
        this.g = 0L;
        this.n = false;
        this.m = -9223372036854775807L;
        b.i.a.c.f3.u.a(this.h);
        this.d.c();
        this.e.c();
        this.f.c();
        r$b r_b = this.k;
        if (r_b != null) {
            r_b.k = false;
            r_b.o = false;
            r$b$a r_b_a = r_b.n;
            r_b_a.f1274b = false;
            r_b_a.a = false;
        }
    }

    @Override // b.i.a.c.x2.k0.o
    public void d() {
    }

    @Override // b.i.a.c.x2.k0.o
    public void e(b.i.a.c.x2.j jVar, i0$d i0_d) {
        i0_d.a();
        this.i = i0_d.b();
        b.i.a.c.x2.w wVarP = jVar.p(i0_d.c(), 2);
        this.j = wVarP;
        this.k = new r$b(wVarP, this.f1272b, this.c);
        this.a.a(jVar, i0_d);
    }

    @Override // b.i.a.c.x2.k0.o
    public void f(long j, int i) {
        if (j != -9223372036854775807L) {
            this.m = j;
        }
        this.n |= (i & 2) != 0;
    }
}
