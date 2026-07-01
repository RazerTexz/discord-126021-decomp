package h0.a.a;

import com.discord.widgets.chat.input.MentionUtilsKt;
import org.objectweb.asm.Opcodes;

/* JADX INFO: compiled from: MethodWriter.java */
/* JADX INFO: loaded from: classes3.dex */
public final class r extends q {
    public static final int[] c = {0, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 1, 1, 1, 2, 2, 1, 1, 1, 0, 0, 1, 2, 1, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, -1, 0, -1, -1, -1, -1, -1, -2, -1, -2, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -3, -4, -3, -4, -3, -3, -3, -3, -1, -2, 1, 1, 1, 2, 2, 2, 0, -1, -2, -1, -2, -1, -2, -1, -2, -1, -2, -1, -2, -1, -2, -1, -2, -1, -2, -1, -2, 0, 0, 0, 0, -1, -1, -1, -1, -1, -1, -1, -2, -1, -2, -1, -2, 0, 1, 0, 1, -1, -1, 0, 0, 1, 1, -1, 0, -1, 0, 0, 0, -3, -1, -1, -3, -3, -1, -1, -1, -1, -1, -1, -2, -2, -2, -2, -2, -2, -2, -2, 0, 1, 0, -1, -1, -1, -2, -1, -2, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, -1, -1, 0, 0, -1, -1, 0, 0};
    public final int A;
    public a B;
    public a C;
    public int D;
    public a[] E;
    public int F;
    public a[] G;
    public a H;
    public a I;
    public c J;
    public int K;
    public c L;
    public b M;
    public final int N;
    public p O;
    public p P;
    public p Q;
    public int R;
    public int S;
    public int T;
    public int U;
    public int[] V;
    public int[] W;
    public boolean X;
    public boolean Y;
    public int Z;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public int f3716a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public int f3717b0;
    public final v d;
    public final int e;
    public final int f;
    public final String g;
    public final int h;
    public final String i;
    public int j;
    public int k;
    public final c l;
    public o m;
    public o n;
    public int o;
    public c p;
    public int q;
    public c r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f3718s;
    public c t;
    public int u;
    public c v;
    public a w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public a f3719x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final int f3720y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final int[] f3721z;

    public r(v vVar, int i, String str, String str2, String str3, String[] strArr, int i2) {
        super(Opcodes.ASM7);
        this.l = new c();
        this.d = vVar;
        this.e = "<init>".equals(str) ? 262144 | i : i;
        this.f = vVar.l(str);
        this.g = str;
        this.h = vVar.l(str2);
        this.i = str2;
        this.A = str3 == null ? 0 : vVar.l(str3);
        if (strArr == null || strArr.length <= 0) {
            this.f3720y = 0;
            this.f3721z = null;
        } else {
            int length = strArr.length;
            this.f3720y = length;
            this.f3721z = new int[length];
            for (int i3 = 0; i3 < this.f3720y; i3++) {
                this.f3721z[i3] = vVar.c(strArr[i3]).a;
            }
        }
        this.N = i2;
        if (i2 != 0) {
            int iB = w.b(str2) >> 2;
            iB = (i & 8) != 0 ? iB - 1 : iB;
            this.k = iB;
            this.T = iB;
            p pVar = new p();
            this.O = pVar;
            i(pVar);
        }
    }

    public int A(int i, int i2, int i3) {
        int i4 = i2 + 3 + i3;
        int[] iArr = this.W;
        if (iArr == null || iArr.length < i4) {
            this.W = new int[i4];
        }
        int[] iArr2 = this.W;
        iArr2[0] = i;
        iArr2[1] = i2;
        iArr2[2] = i3;
        return 3;
    }

    public final void B(p pVar, p[] pVarArr) {
        p pVar2 = this.Q;
        if (pVar2 != null) {
            int i = this.N;
            if (i == 4) {
                pVar2.k.b(Opcodes.LOOKUPSWITCH, 0, null, null);
                u(0, pVar);
                p pVarB = pVar.b();
                pVarB.f3714b = (short) (pVarB.f3714b | 2);
                for (p pVar3 : pVarArr) {
                    u(0, pVar3);
                    p pVarB2 = pVar3.b();
                    pVarB2.f3714b = (short) (pVarB2.f3714b | 2);
                }
            } else if (i == 1) {
                int i2 = this.R - 1;
                this.R = i2;
                u(i2, pVar);
                for (p pVar4 : pVarArr) {
                    u(this.R, pVar4);
                }
            }
            v();
        }
    }

    @Override // h0.a.a.q
    public a a(String str, boolean z2) {
        c cVar = new c();
        cVar.j(this.d.l(str));
        cVar.j(0);
        if (z2) {
            a aVar = new a(this.d, true, cVar, this.B);
            this.B = aVar;
            return aVar;
        }
        a aVar2 = new a(this.d, true, cVar, this.C);
        this.C = aVar2;
        return aVar2;
    }

    @Override // h0.a.a.q
    public void b(int i, String str, String str2, String str3) {
        int i2;
        int i3;
        this.Z = this.l.f3699b;
        v$a v_aH = this.d.h(9, str, str2, str3);
        this.l.e(i, v_aH.a);
        p pVar = this.Q;
        if (pVar != null) {
            int i4 = this.N;
            if (i4 == 4 || i4 == 3) {
                pVar.k.b(i, 0, v_aH, this.d);
                return;
            }
            char cCharAt = str3.charAt(0);
            int i5 = -2;
            switch (i) {
                case Opcodes.GETSTATIC /* 178 */:
                    i2 = this.R + ((cCharAt == 'D' || cCharAt == 'J') ? 2 : 1);
                    break;
                case Opcodes.PUTSTATIC /* 179 */:
                    i3 = this.R;
                    if (cCharAt != 'D' && cCharAt != 'J') {
                        i5 = -1;
                    }
                    i2 = i3 + i5;
                    break;
                case 180:
                    i2 = this.R + ((cCharAt == 'D' || cCharAt == 'J') ? 1 : 0);
                    break;
                default:
                    i3 = this.R;
                    if (cCharAt == 'D' || cCharAt == 'J') {
                        i5 = -3;
                    }
                    i2 = i3 + i5;
                    break;
            }
            if (i2 > this.S) {
                this.S = i2;
            }
            this.R = i2;
        }
    }

    @Override // h0.a.a.q
    public void c(int i, int i2, Object[] objArr, int i3, Object[] objArr2) {
        int i4;
        int i5 = this.N;
        if (i5 == 4) {
            return;
        }
        int i6 = 3;
        if (i5 == 3) {
            p pVar = this.Q;
            m mVar = pVar.k;
            if (mVar == null) {
                i iVar = new i(pVar);
                pVar.k = iVar;
                iVar.n(this.d, this.e, this.i, i2);
                this.Q.k.a(this);
            } else {
                if (i == -1) {
                    v vVar = this.d;
                    int i7 = 0;
                    for (int i8 = 0; i8 < i2; i8++) {
                        int i9 = i7 + 1;
                        mVar.f3711b[i7] = m.c(vVar, objArr[i8]);
                        if (objArr[i8] == t.e || objArr[i8] == t.d) {
                            mVar.f3711b[i9] = 16777216;
                            i7 = i9 + 1;
                        } else {
                            i7 = i9;
                        }
                    }
                    while (true) {
                        int[] iArr = mVar.f3711b;
                        if (i7 >= iArr.length) {
                            break;
                        }
                        iArr[i7] = 16777216;
                        i7++;
                    }
                    int i10 = 0;
                    for (int i11 = 0; i11 < i3; i11++) {
                        if (objArr2[i11] == t.e || objArr2[i11] == t.d) {
                            i10++;
                        }
                    }
                    mVar.c = new int[i10 + i3];
                    int i12 = 0;
                    for (int i13 = 0; i13 < i3; i13++) {
                        int i14 = i12 + 1;
                        mVar.c[i12] = m.c(vVar, objArr2[i13]);
                        if (objArr2[i13] == t.e || objArr2[i13] == t.d) {
                            mVar.c[i14] = 16777216;
                            i12 = i14 + 1;
                        } else {
                            i12 = i14;
                        }
                    }
                    mVar.g = (short) 0;
                    mVar.h = 0;
                }
                this.Q.k.a(this);
            }
        } else if (i == -1) {
            if (this.V == null) {
                int iB = w.b(this.i) >> 2;
                m mVar2 = new m(new p());
                mVar2.n(this.d, this.e, this.i, iB);
                mVar2.a(this);
            }
            this.T = i2;
            A(this.l.f3699b, i2, i3);
            int i15 = 0;
            while (i15 < i2) {
                this.W[i6] = m.c(this.d, objArr[i15]);
                i15++;
                i6++;
            }
            int i16 = 0;
            while (i16 < i3) {
                this.W[i6] = m.c(this.d, objArr2[i16]);
                i16++;
                i6++;
            }
            z();
        } else {
            if (this.v == null) {
                this.v = new c();
                i4 = this.l.f3699b;
            } else {
                i4 = (this.l.f3699b - this.U) - 1;
                if (i4 < 0) {
                    if (i != 3) {
                        throw new IllegalStateException();
                    }
                    return;
                }
            }
            if (i == 0) {
                this.T = i2;
                c cVar = this.v;
                cVar.g(255);
                cVar.j(i4);
                cVar.j(i2);
                for (int i17 = 0; i17 < i2; i17++) {
                    x(objArr[i17]);
                }
                this.v.j(i3);
                for (int i18 = 0; i18 < i3; i18++) {
                    x(objArr2[i18]);
                }
            } else if (i == 1) {
                this.T += i2;
                c cVar2 = this.v;
                cVar2.g(i2 + 251);
                cVar2.j(i4);
                for (int i19 = 0; i19 < i2; i19++) {
                    x(objArr[i19]);
                }
            } else if (i == 2) {
                this.T -= i2;
                c cVar3 = this.v;
                cVar3.g(251 - i2);
                cVar3.j(i4);
            } else if (i != 3) {
                if (i != 4) {
                    throw new IllegalArgumentException();
                }
                if (i4 < 64) {
                    this.v.g(i4 + 64);
                } else {
                    c cVar4 = this.v;
                    cVar4.g(247);
                    cVar4.j(i4);
                }
                x(objArr2[0]);
            } else if (i4 < 64) {
                this.v.g(i4);
            } else {
                c cVar5 = this.v;
                cVar5.g(251);
                cVar5.j(i4);
            }
            this.U = this.l.f3699b;
            this.u++;
        }
        if (this.N == 2) {
            this.R = i3;
            for (int i20 = 0; i20 < i3; i20++) {
                if (objArr2[i20] == t.e || objArr2[i20] == t.d) {
                    this.R++;
                }
            }
            int i21 = this.R;
            if (i21 > this.S) {
                this.S = i21;
            }
        }
        this.j = Math.max(this.j, i3);
        this.k = Math.max(this.k, this.T);
    }

    @Override // h0.a.a.q
    public void d(int i, int i2) {
        int i3;
        int i4;
        c cVar = this.l;
        this.Z = cVar.f3699b;
        if (i > 255 || i2 > 127 || i2 < -128) {
            cVar.g(196);
            cVar.e(Opcodes.IINC, i);
            cVar.j(i2);
        } else {
            cVar.g(Opcodes.IINC);
            cVar.c(i, i2);
        }
        p pVar = this.Q;
        if (pVar != null && ((i4 = this.N) == 4 || i4 == 3)) {
            pVar.k.b(Opcodes.IINC, i, null, null);
        }
        if (this.N == 0 || (i3 = i + 1) <= this.k) {
            return;
        }
        this.k = i3;
    }

    @Override // h0.a.a.q
    public void e(int i) {
        c cVar = this.l;
        this.Z = cVar.f3699b;
        cVar.g(i);
        p pVar = this.Q;
        if (pVar != null) {
            int i2 = this.N;
            if (i2 == 4 || i2 == 3) {
                pVar.k.b(i, 0, null, null);
            } else {
                int i3 = this.R + c[i];
                if (i3 > this.S) {
                    this.S = i3;
                }
                this.R = i3;
            }
            if ((i < 172 || i > 177) && i != 191) {
                return;
            }
            v();
        }
    }

    @Override // h0.a.a.q
    public a f(int i, x xVar, String str, boolean z2) {
        c cVar = new c();
        b.i.a.f.e.o.f.W0((i & (-16776961)) | (this.Z << 8), cVar);
        x.a(xVar, cVar);
        cVar.j(this.d.l(str));
        cVar.j(0);
        if (z2) {
            a aVar = new a(this.d, true, cVar, this.w);
            this.w = aVar;
            return aVar;
        }
        a aVar2 = new a(this.d, true, cVar, this.f3719x);
        this.f3719x = aVar2;
        return aVar2;
    }

    @Override // h0.a.a.q
    public void g(int i, int i2) {
        c cVar = this.l;
        this.Z = cVar.f3699b;
        if (i == 17) {
            cVar.e(i, i2);
        } else {
            cVar.c(i, i2);
        }
        p pVar = this.Q;
        if (pVar != null) {
            int i3 = this.N;
            if (i3 == 4 || i3 == 3) {
                pVar.k.b(i, i2, null, null);
            } else if (i != 188) {
                int i4 = this.R + 1;
                if (i4 > this.S) {
                    this.S = i4;
                }
                this.R = i4;
            }
        }
    }

    @Override // h0.a.a.q
    public void h(int i, p pVar) {
        boolean z2;
        c cVar = this.l;
        int i2 = cVar.f3699b;
        this.Z = i2;
        int i3 = i >= 200 ? i - 33 : i;
        if ((pVar.f3714b & 4) == 0 || pVar.e - i2 >= -32768) {
            if (i3 != i) {
                cVar.g(i);
                c cVar2 = this.l;
                pVar.e(cVar2, cVar2.f3699b - 1, true);
            } else {
                cVar.g(i3);
                c cVar3 = this.l;
                pVar.e(cVar3, cVar3.f3699b - 1, false);
            }
            z2 = false;
        } else {
            if (i3 == 167) {
                cVar.g(200);
            } else {
                if (i3 == 168) {
                    cVar.g(201);
                } else {
                    cVar.g(i3 >= 198 ? i3 ^ 1 : ((i3 + 1) ^ 1) - 1);
                    this.l.j(8);
                    this.l.g(220);
                    this.Y = true;
                    z2 = true;
                }
                c cVar4 = this.l;
                pVar.e(cVar4, cVar4.f3699b - 1, true);
            }
            z2 = false;
            c cVar5 = this.l;
            pVar.e(cVar5, cVar5.f3699b - 1, true);
        }
        p pVar2 = this.Q;
        if (pVar2 != null) {
            int i4 = this.N;
            p pVar3 = null;
            if (i4 == 4) {
                pVar2.k.b(i3, 0, null, null);
                p pVarB = pVar.b();
                pVarB.f3714b = (short) (pVarB.f3714b | 2);
                u(0, pVar);
                if (i3 != 167) {
                    pVar3 = new p();
                }
            } else if (i4 == 3) {
                pVar2.k.b(i3, 0, null, null);
            } else if (i4 == 2) {
                this.R += c[i3];
            } else if (i3 == 168) {
                short s2 = pVar.f3714b;
                if ((s2 & 32) == 0) {
                    pVar.f3714b = (short) (s2 | 32);
                    this.X = true;
                }
                pVar2.f3714b = (short) (pVar2.f3714b | 16);
                u(this.R + 1, pVar);
                pVar3 = new p();
            } else {
                int i5 = this.R + c[i3];
                this.R = i5;
                u(i5, pVar);
            }
            if (pVar3 != null) {
                if (z2) {
                    pVar3.f3714b = (short) (pVar3.f3714b | 2);
                }
                i(pVar3);
            }
            if (i3 == 167) {
                v();
            }
        }
    }

    @Override // h0.a.a.q
    public void i(p pVar) {
        boolean z2 = this.Y;
        c cVar = this.l;
        this.Y = z2 | pVar.f(cVar.a, cVar.f3699b);
        short s2 = pVar.f3714b;
        if ((s2 & 1) != 0) {
            return;
        }
        int i = this.N;
        if (i == 4) {
            p pVar2 = this.Q;
            if (pVar2 != null) {
                if (pVar.e == pVar2.e) {
                    pVar2.f3714b = (short) ((s2 & 2) | pVar2.f3714b);
                    pVar.k = pVar2.k;
                    return;
                }
                u(0, pVar);
            }
            p pVar3 = this.P;
            if (pVar3 != null) {
                if (pVar.e == pVar3.e) {
                    pVar3.f3714b = (short) (pVar3.f3714b | (pVar.f3714b & 2));
                    pVar.k = pVar3.k;
                    this.Q = pVar3;
                    return;
                }
                pVar3.l = pVar;
            }
            this.P = pVar;
            this.Q = pVar;
            pVar.k = new m(pVar);
            return;
        }
        if (i == 3) {
            p pVar4 = this.Q;
            if (pVar4 == null) {
                this.Q = pVar;
                return;
            } else {
                pVar4.k.a = pVar;
                return;
            }
        }
        if (i != 1) {
            if (i == 2 && this.Q == null) {
                this.Q = pVar;
                return;
            }
            return;
        }
        p pVar5 = this.Q;
        if (pVar5 != null) {
            pVar5.i = (short) this.S;
            u(this.R, pVar);
        }
        this.Q = pVar;
        this.R = 0;
        this.S = 0;
        p pVar6 = this.P;
        if (pVar6 != null) {
            pVar6.l = pVar;
        }
        this.P = pVar;
    }

    @Override // h0.a.a.q
    public void j(Object obj) {
        char cCharAt;
        this.Z = this.l.f3699b;
        u uVarB = this.d.b(obj);
        int i = uVarB.a;
        int i2 = uVarB.f3724b;
        boolean z2 = i2 == 5 || i2 == 6 || (i2 == 17 && ((cCharAt = uVarB.e.charAt(0)) == 'J' || cCharAt == 'D'));
        if (z2) {
            this.l.e(20, i);
        } else if (i >= 256) {
            this.l.e(19, i);
        } else {
            this.l.c(18, i);
        }
        p pVar = this.Q;
        if (pVar != null) {
            int i3 = this.N;
            if (i3 == 4 || i3 == 3) {
                pVar.k.b(18, 0, uVarB, this.d);
                return;
            }
            int i4 = this.R + (z2 ? 2 : 1);
            if (i4 > this.S) {
                this.S = i4;
            }
            this.R = i4;
        }
    }

    @Override // h0.a.a.q
    public void k(int i, p pVar) {
        if (this.p == null) {
            this.p = new c();
        }
        this.o++;
        this.p.j(pVar.e);
        this.p.j(i);
    }

    @Override // h0.a.a.q
    public void l(String str, String str2, String str3, p pVar, p pVar2, int i) {
        if (str3 != null) {
            if (this.t == null) {
                this.t = new c();
            }
            this.f3718s++;
            c cVar = this.t;
            cVar.j(pVar.e);
            cVar.j(pVar2.e - pVar.e);
            cVar.j(this.d.l(str));
            cVar.j(this.d.l(str3));
            cVar.j(i);
        }
        if (this.r == null) {
            this.r = new c();
        }
        this.q++;
        c cVar2 = this.r;
        cVar2.j(pVar.e);
        cVar2.j(pVar2.e - pVar.e);
        cVar2.j(this.d.l(str));
        cVar2.j(this.d.l(str2));
        cVar2.j(i);
        if (this.N != 0) {
            char cCharAt = str2.charAt(0);
            int i2 = i + ((cCharAt == 'J' || cCharAt == 'D') ? 2 : 1);
            if (i2 > this.k) {
                this.k = i2;
            }
        }
    }

    @Override // h0.a.a.q
    public a m(int i, x xVar, p[] pVarArr, p[] pVarArr2, int[] iArr, String str, boolean z2) {
        c cVar = new c();
        cVar.g(i >>> 24);
        cVar.j(pVarArr.length);
        for (int i2 = 0; i2 < pVarArr.length; i2++) {
            cVar.j(pVarArr[i2].e);
            cVar.j(pVarArr2[i2].e - pVarArr[i2].e);
            cVar.j(iArr[i2]);
        }
        x.a(xVar, cVar);
        cVar.j(this.d.l(str));
        cVar.j(0);
        if (z2) {
            a aVar = new a(this.d, true, cVar, this.w);
            this.w = aVar;
            return aVar;
        }
        a aVar2 = new a(this.d, true, cVar, this.f3719x);
        this.f3719x = aVar2;
        return aVar2;
    }

    @Override // h0.a.a.q
    public void n(int i, int i2) {
        int i3 = this.N;
        if (i3 == 4) {
            o oVar = this.m;
            while (true) {
                if (oVar == null) {
                    break;
                }
                String str = oVar.e;
                int iN = 33554432 | this.d.n(str != null ? str : "java/lang/Throwable");
                p pVarB = oVar.c.b();
                pVarB.f3714b = (short) (pVarB.f3714b | 2);
                p pVarB2 = oVar.f3713b.b();
                for (p pVarB3 = oVar.a.b(); pVarB3 != pVarB2; pVarB3 = pVarB3.l) {
                    pVarB3.m = new j(iN, pVarB, pVarB3.m);
                }
                oVar = oVar.f;
            }
            m mVar = this.O.k;
            mVar.n(this.d, this.e, this.i, this.k);
            mVar.a(this);
            p pVar = this.O;
            pVar.n = p.a;
            int iMax = 0;
            while (pVar != p.a) {
                p pVar2 = pVar.n;
                pVar.n = null;
                pVar.f3714b = (short) (pVar.f3714b | 8);
                int length = pVar.k.c.length + pVar.i;
                if (length > iMax) {
                    iMax = length;
                }
                for (j jVar = pVar.m; jVar != null; jVar = jVar.c) {
                    p pVarB4 = jVar.f3709b.b();
                    if (pVar.k.h(this.d, pVarB4.k, jVar.a) && pVarB4.n == null) {
                        pVarB4.n = pVar2;
                        pVar2 = pVarB4;
                    }
                }
                pVar = pVar2;
            }
            for (p pVar3 = this.O; pVar3 != null; pVar3 = pVar3.l) {
                if ((pVar3.f3714b & 10) == 10) {
                    pVar3.k.a(this);
                }
                if ((pVar3.f3714b & 8) == 0) {
                    p pVar4 = pVar3.l;
                    int i4 = pVar3.e;
                    int i5 = (pVar4 == null ? this.l.f3699b : pVar4.e) - 1;
                    if (i5 >= i4) {
                        for (int i6 = i4; i6 < i5; i6++) {
                            this.l.a[i6] = 0;
                        }
                        this.l.a[i5] = -65;
                        A(i4, 0, 1);
                        this.W[3] = this.d.n("java/lang/Throwable") | 33554432;
                        z();
                        this.m = o.a(this.m, pVar3, pVar4);
                        iMax = Math.max(iMax, 1);
                    }
                }
            }
            this.j = iMax;
            return;
        }
        if (i3 != 1) {
            if (i3 == 2) {
                this.j = this.S;
                return;
            } else {
                this.j = i;
                this.k = i2;
                return;
            }
        }
        for (o oVar2 = this.m; oVar2 != null; oVar2 = oVar2.f) {
            p pVar5 = oVar2.c;
            p pVar6 = oVar2.f3713b;
            for (p pVar7 = oVar2.a; pVar7 != pVar6; pVar7 = pVar7.l) {
                if ((pVar7.f3714b & 16) == 0) {
                    pVar7.m = new j(Integer.MAX_VALUE, pVar5, pVar7.m);
                } else {
                    j jVar2 = pVar7.m.c;
                    jVar2.c = new j(Integer.MAX_VALUE, pVar5, jVar2.c);
                }
            }
        }
        if (this.X) {
            this.O.c((short) 1);
            short s2 = 1;
            for (short s3 = 1; s3 <= s2; s3 = (short) (s3 + 1)) {
                for (p pVar8 = this.O; pVar8 != null; pVar8 = pVar8.l) {
                    if ((pVar8.f3714b & 16) != 0 && pVar8.j == s3) {
                        p pVar9 = pVar8.m.c.f3709b;
                        if (pVar9.j == 0) {
                            s2 = (short) (s2 + 1);
                            pVar9.c(s2);
                        }
                    }
                }
            }
            for (p pVar10 = this.O; pVar10 != null; pVar10 = pVar10.l) {
                if ((pVar10.f3714b & 16) != 0) {
                    p pVarD = pVar10.m.c.f3709b;
                    p pVar11 = p.a;
                    pVarD.n = pVar11;
                    while (pVarD != p.a) {
                        p pVar12 = pVarD.n;
                        pVarD.n = pVar11;
                        if ((pVarD.f3714b & 64) != 0 && pVarD.j != pVar10.j) {
                            pVarD.m = new j(pVarD.h, pVar10.m.f3709b, pVarD.m);
                        }
                        pVar11 = pVarD;
                        pVarD = pVarD.d(pVar12);
                    }
                    while (pVar11 != p.a) {
                        p pVar13 = pVar11.n;
                        pVar11.n = null;
                        pVar11 = pVar13;
                    }
                }
            }
        }
        p pVar14 = this.O;
        pVar14.n = p.a;
        int i7 = this.j;
        while (pVar14 != p.a) {
            p pVar15 = pVar14.n;
            short s4 = pVar14.g;
            int i8 = pVar14.i + s4;
            if (i8 > i7) {
                i7 = i8;
            }
            j jVar3 = pVar14.m;
            if ((pVar14.f3714b & 16) != 0) {
                jVar3 = jVar3.c;
            }
            pVar14 = pVar15;
            while (jVar3 != null) {
                p pVar16 = jVar3.f3709b;
                if (pVar16.n == null) {
                    int i9 = jVar3.a;
                    pVar16.g = (short) (i9 == Integer.MAX_VALUE ? 1 : i9 + s4);
                    pVar16.n = pVar14;
                    pVar14 = pVar16;
                }
                jVar3 = jVar3.c;
            }
        }
        this.j = i7;
    }

    @Override // h0.a.a.q
    public void p(int i, String str, String str2, String str3, boolean z2) {
        this.Z = this.l.f3699b;
        v$a v_aH = this.d.h(z2 ? 11 : 10, str, str2, str3);
        if (i == 185) {
            c cVar = this.l;
            cVar.e(Opcodes.INVOKEINTERFACE, v_aH.a);
            cVar.c(v_aH.a() >> 2, 0);
        } else {
            this.l.e(i, v_aH.a);
        }
        p pVar = this.Q;
        if (pVar != null) {
            int i2 = this.N;
            if (i2 == 4 || i2 == 3) {
                pVar.k.b(i, 0, v_aH, this.d);
                return;
            }
            int iA = v_aH.a();
            int i3 = (iA & 3) - (iA >> 2);
            int i4 = i == 184 ? this.R + i3 + 1 : this.R + i3;
            if (i4 > this.S) {
                this.S = i4;
            }
            this.R = i4;
        }
    }

    @Override // h0.a.a.q
    public void q(int i, int i2, p pVar, p... pVarArr) {
        c cVar = this.l;
        this.Z = cVar.f3699b;
        cVar.g(Opcodes.TABLESWITCH);
        cVar.h(null, 0, (4 - (this.l.f3699b % 4)) % 4);
        pVar.e(this.l, this.Z, true);
        c cVar2 = this.l;
        cVar2.i(i);
        cVar2.i(i2);
        for (p pVar2 : pVarArr) {
            pVar2.e(this.l, this.Z, true);
        }
        B(pVar, pVarArr);
    }

    @Override // h0.a.a.q
    public a r(int i, x xVar, String str, boolean z2) {
        c cVar = new c();
        b.i.a.f.e.o.f.W0(i, cVar);
        x.a(xVar, cVar);
        cVar.j(this.d.l(str));
        cVar.j(0);
        if (z2) {
            a aVar = new a(this.d, true, cVar, this.H);
            this.H = aVar;
            return aVar;
        }
        a aVar2 = new a(this.d, true, cVar, this.I);
        this.I = aVar2;
        return aVar2;
    }

    @Override // h0.a.a.q
    public void s(int i, String str) {
        this.Z = this.l.f3699b;
        u uVarM = this.d.m(7, str);
        this.l.e(i, uVarM.a);
        p pVar = this.Q;
        if (pVar != null) {
            int i2 = this.N;
            if (i2 == 4 || i2 == 3) {
                pVar.k.b(i, this.Z, uVarM, this.d);
            } else if (i == 187) {
                int i3 = this.R + 1;
                if (i3 > this.S) {
                    this.S = i3;
                }
                this.R = i3;
            }
        }
    }

    @Override // h0.a.a.q
    public void t(int i, int i2) {
        c cVar = this.l;
        this.Z = cVar.f3699b;
        if (i2 < 4 && i != 169) {
            cVar.g((i < 54 ? ((i - 21) << 2) + 26 : ((i - 54) << 2) + 59) + i2);
        } else if (i2 >= 256) {
            cVar.g(196);
            cVar.e(i, i2);
        } else {
            cVar.c(i, i2);
        }
        p pVar = this.Q;
        if (pVar != null) {
            int i3 = this.N;
            if (i3 == 4 || i3 == 3) {
                pVar.k.b(i, i2, null, null);
            } else if (i == 169) {
                pVar.f3714b = (short) (pVar.f3714b | 64);
                pVar.h = (short) this.R;
                v();
            } else {
                int i4 = this.R + c[i];
                if (i4 > this.S) {
                    this.S = i4;
                }
                this.R = i4;
            }
        }
        int i5 = this.N;
        if (i5 != 0) {
            int i6 = (i == 22 || i == 24 || i == 55 || i == 57) ? i2 + 2 : i2 + 1;
            if (i6 > this.k) {
                this.k = i6;
            }
        }
        if (i < 54 || i5 != 4 || this.m == null) {
            return;
        }
        i(new p());
    }

    public final void u(int i, p pVar) {
        p pVar2 = this.Q;
        pVar2.m = new j(i, pVar, pVar2.m);
    }

    public final void v() {
        int i = this.N;
        if (i != 4) {
            if (i == 1) {
                this.Q.i = (short) this.S;
                this.Q = null;
                return;
            }
            return;
        }
        p pVar = new p();
        pVar.k = new m(pVar);
        c cVar = this.l;
        pVar.f(cVar.a, cVar.f3699b);
        this.P.l = pVar;
        this.P = pVar;
        this.Q = null;
    }

    public final void w(int i, int i2) {
        while (i < i2) {
            v vVar = this.d;
            int i3 = this.W[i];
            c cVar = this.v;
            int i4 = ((-268435456) & i3) >> 28;
            if (i4 == 0) {
                int i5 = i3 & 1048575;
                int i6 = i3 & 251658240;
                if (i6 == 16777216) {
                    cVar.g(i5);
                } else if (i6 == 33554432) {
                    cVar.g(7);
                    cVar.j(vVar.c(vVar.l[i5].e).a);
                } else {
                    if (i6 != 50331648) {
                        throw new AssertionError();
                    }
                    cVar.g(8);
                    cVar.j((int) vVar.l[i5].f);
                }
            } else {
                StringBuilder sb = new StringBuilder();
                while (true) {
                    int i7 = i4 - 1;
                    if (i4 > 0) {
                        sb.append('[');
                        i4 = i7;
                    } else {
                        if ((i3 & 251658240) == 33554432) {
                            sb.append('L');
                            sb.append(vVar.l[i3 & 1048575].e);
                            sb.append(';');
                        } else {
                            int i8 = i3 & 1048575;
                            if (i8 == 1) {
                                sb.append('I');
                            } else if (i8 == 2) {
                                sb.append('F');
                            } else if (i8 == 3) {
                                sb.append('D');
                            } else if (i8 != 4) {
                                switch (i8) {
                                    case 9:
                                        sb.append('Z');
                                        break;
                                    case 10:
                                        sb.append('B');
                                        break;
                                    case 11:
                                        sb.append('C');
                                        break;
                                    case 12:
                                        sb.append('S');
                                        break;
                                    default:
                                        throw new AssertionError();
                                }
                            } else {
                                sb.append('J');
                            }
                        }
                        cVar.g(7);
                        cVar.j(vVar.c(sb.toString()).a);
                    }
                }
            }
            i++;
        }
    }

    public final void x(Object obj) {
        if (obj instanceof Integer) {
            this.v.g(((Integer) obj).intValue());
            return;
        }
        if (obj instanceof String) {
            c cVar = this.v;
            cVar.g(7);
            cVar.j(this.d.c((String) obj).a);
        } else {
            c cVar2 = this.v;
            cVar2.g(8);
            cVar2.j(((p) obj).e);
        }
    }

    public void y(c cVar) {
        int i;
        boolean z2 = this.d.c < 49;
        cVar.j((~(z2 ? 4096 : 0)) & this.e);
        cVar.j(this.f);
        cVar.j(this.h);
        int i2 = this.f3716a0;
        if (i2 != 0) {
            cVar.h(this.d.f3725b.a, i2, this.f3717b0);
            return;
        }
        int iC = this.l.f3699b > 0 ? 1 : 0;
        if (this.f3720y > 0) {
            iC++;
        }
        int i3 = this.e;
        if ((i3 & 4096) != 0 && z2) {
            iC++;
        }
        if (this.A != 0) {
            iC++;
        }
        if ((i3 & 131072) != 0) {
            iC++;
        }
        if (this.B != null) {
            iC++;
        }
        if (this.C != null) {
            iC++;
        }
        if (this.E != null) {
            iC++;
        }
        if (this.G != null) {
            iC++;
        }
        if (this.H != null) {
            iC++;
        }
        if (this.I != null) {
            iC++;
        }
        if (this.J != null) {
            iC++;
        }
        if (this.L != null) {
            iC++;
        }
        b bVar = this.M;
        if (bVar != null) {
            iC += bVar.c();
        }
        cVar.j(iC);
        int i4 = this.l.f3699b;
        if (i4 > 0) {
            int i5 = i4 + 10;
            int i6 = 0;
            for (o oVar = this.m; oVar != null; oVar = oVar.f) {
                i6++;
            }
            int iA = (i6 * 8) + 2 + i5;
            c cVar2 = this.v;
            if (cVar2 != null) {
                iA += cVar2.f3699b + 8;
                i = 1;
            } else {
                i = 0;
            }
            c cVar3 = this.p;
            if (cVar3 != null) {
                iA += cVar3.f3699b + 8;
                i++;
            }
            c cVar4 = this.r;
            if (cVar4 != null) {
                iA += cVar4.f3699b + 8;
                i++;
            }
            c cVar5 = this.t;
            if (cVar5 != null) {
                iA += cVar5.f3699b + 8;
                i++;
            }
            a aVar = this.w;
            if (aVar != null) {
                iA += aVar.a("RuntimeVisibleTypeAnnotations");
                i++;
            }
            a aVar2 = this.f3719x;
            if (aVar2 != null) {
                iA += aVar2.a("RuntimeInvisibleTypeAnnotations");
                i++;
            }
            b.d.b.a.a.t0(this.d, "Code", cVar, iA);
            cVar.j(this.j);
            cVar.j(this.k);
            cVar.i(this.l.f3699b);
            c cVar6 = this.l;
            cVar.h(cVar6.a, 0, cVar6.f3699b);
            o oVar2 = this.m;
            int i7 = 0;
            for (o oVar3 = oVar2; oVar3 != null; oVar3 = oVar3.f) {
                i7++;
            }
            cVar.j(i7);
            while (oVar2 != null) {
                cVar.j(oVar2.a.e);
                cVar.j(oVar2.f3713b.e);
                cVar.j(oVar2.c.e);
                cVar.j(oVar2.d);
                oVar2 = oVar2.f;
            }
            cVar.j(i);
            if (this.v != null) {
                v vVar = this.d;
                cVar.j(vVar.l(vVar.c >= 50 ? "StackMapTable" : "StackMap"));
                cVar.i(this.v.f3699b + 2);
                cVar.j(this.u);
                c cVar7 = this.v;
                cVar.h(cVar7.a, 0, cVar7.f3699b);
            }
            if (this.p != null) {
                cVar.j(this.d.l("LineNumberTable"));
                cVar.i(this.p.f3699b + 2);
                cVar.j(this.o);
                c cVar8 = this.p;
                cVar.h(cVar8.a, 0, cVar8.f3699b);
            }
            if (this.r != null) {
                cVar.j(this.d.l("LocalVariableTable"));
                cVar.i(this.r.f3699b + 2);
                cVar.j(this.q);
                c cVar9 = this.r;
                cVar.h(cVar9.a, 0, cVar9.f3699b);
            }
            if (this.t != null) {
                cVar.j(this.d.l("LocalVariableTypeTable"));
                cVar.i(this.t.f3699b + 2);
                cVar.j(this.f3718s);
                c cVar10 = this.t;
                cVar.h(cVar10.a, 0, cVar10.f3699b);
            }
            a aVar3 = this.w;
            if (aVar3 != null) {
                aVar3.c(this.d.l("RuntimeVisibleTypeAnnotations"), cVar);
            }
            a aVar4 = this.f3719x;
            if (aVar4 != null) {
                aVar4.c(this.d.l("RuntimeInvisibleTypeAnnotations"), cVar);
            }
        }
        if (this.f3720y > 0) {
            cVar.j(this.d.l("Exceptions"));
            cVar.i((this.f3720y * 2) + 2);
            cVar.j(this.f3720y);
            for (int i8 : this.f3721z) {
                cVar.j(i8);
            }
        }
        if ((4096 & this.e) != 0 && z2) {
            b.d.b.a.a.t0(this.d, "Synthetic", cVar, 0);
        }
        if (this.A != 0) {
            b.d.b.a.a.t0(this.d, "Signature", cVar, 2);
            cVar.j(this.A);
        }
        if ((this.e & 131072) != 0) {
            b.d.b.a.a.t0(this.d, "Deprecated", cVar, 0);
        }
        a aVar5 = this.B;
        if (aVar5 != null) {
            aVar5.c(this.d.l("RuntimeVisibleAnnotations"), cVar);
        }
        a aVar6 = this.C;
        if (aVar6 != null) {
            aVar6.c(this.d.l("RuntimeInvisibleAnnotations"), cVar);
        }
        if (this.E != null) {
            int iL = this.d.l("RuntimeVisibleParameterAnnotations");
            a[] aVarArr = this.E;
            int length = this.D;
            if (length == 0) {
                length = aVarArr.length;
            }
            a.d(iL, aVarArr, length, cVar);
        }
        if (this.G != null) {
            int iL2 = this.d.l("RuntimeInvisibleParameterAnnotations");
            a[] aVarArr2 = this.G;
            int length2 = this.F;
            if (length2 == 0) {
                length2 = aVarArr2.length;
            }
            a.d(iL2, aVarArr2, length2, cVar);
        }
        a aVar7 = this.H;
        if (aVar7 != null) {
            aVar7.c(this.d.l("RuntimeVisibleTypeAnnotations"), cVar);
        }
        a aVar8 = this.I;
        if (aVar8 != null) {
            aVar8.c(this.d.l("RuntimeInvisibleTypeAnnotations"), cVar);
        }
        if (this.J != null) {
            cVar.j(this.d.l("AnnotationDefault"));
            cVar.i(this.J.f3699b);
            c cVar11 = this.J;
            cVar.h(cVar11.a, 0, cVar11.f3699b);
        }
        if (this.L != null) {
            cVar.j(this.d.l("MethodParameters"));
            cVar.i(this.L.f3699b + 1);
            cVar.g(this.K);
            c cVar12 = this.L;
            cVar.h(cVar12.a, 0, cVar12.f3699b);
        }
        b bVar2 = this.M;
        if (bVar2 != null) {
            bVar2.d(this.d, cVar);
        }
    }

    /* JADX WARN: Code duplicated, block: B:29:0x007a  */
    public void z() {
        char c2;
        int[] iArr = this.V;
        if (iArr != null) {
            if (this.v == null) {
                this.v = new c();
            }
            int[] iArr2 = this.W;
            int i = iArr2[1];
            int i2 = iArr2[2];
            if (this.d.c < 50) {
                c cVar = this.v;
                cVar.j(iArr2[0]);
                cVar.j(i);
                int i3 = i + 3;
                w(3, i3);
                this.v.j(i2);
                w(i3, i2 + i3);
            } else {
                int i4 = this.u == 0 ? iArr2[0] : (iArr2[0] - iArr[0]) - 1;
                int i5 = iArr[1];
                int i6 = i - i5;
                if (i2 == 0) {
                    switch (i6) {
                        case -3:
                        case -2:
                        case -1:
                            c2 = 248;
                            break;
                        case 0:
                            c2 = i4 < 64 ? (char) 0 : (char) 251;
                            break;
                        case 1:
                        case 2:
                        case 3:
                            c2 = 252;
                            break;
                        default:
                            c2 = 255;
                            break;
                    }
                } else if (i6 == 0 && i2 == 1) {
                    c2 = i4 < 63 ? MentionUtilsKt.MENTIONS_CHAR : (char) 247;
                } else {
                    c2 = 255;
                }
                if (c2 != 255) {
                    int i7 = 3;
                    for (int i8 = 0; i8 < i5 && i8 < i; i8++) {
                        if (this.W[i7] != this.V[i7]) {
                            c2 = 255;
                        } else {
                            i7++;
                        }
                    }
                }
                if (c2 == 0) {
                    this.v.g(i4);
                } else if (c2 == '@') {
                    this.v.g(i4 + 64);
                    w(i + 3, i + 4);
                } else if (c2 == 247) {
                    c cVar2 = this.v;
                    cVar2.g(247);
                    cVar2.j(i4);
                    w(i + 3, i + 4);
                } else if (c2 == 248) {
                    c cVar3 = this.v;
                    cVar3.g(i6 + 251);
                    cVar3.j(i4);
                } else if (c2 == 251) {
                    c cVar4 = this.v;
                    cVar4.g(251);
                    cVar4.j(i4);
                } else if (c2 != 252) {
                    c cVar5 = this.v;
                    cVar5.g(255);
                    cVar5.j(i4);
                    cVar5.j(i);
                    int i9 = i + 3;
                    w(3, i9);
                    this.v.j(i2);
                    w(i9, i2 + i9);
                } else {
                    c cVar6 = this.v;
                    cVar6.g(i6 + 251);
                    cVar6.j(i4);
                    w(i5 + 3, i + 3);
                }
            }
            this.u++;
        }
        this.V = this.W;
        this.W = null;
    }
}
