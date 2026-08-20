package p617h0.p618a.p619a;

import com.discord.widgets.chat.input.MentionUtilsKt;
import org.objectweb.asm.Opcodes;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;

/* JADX INFO: renamed from: h0.a.a.r */
/* JADX INFO: compiled from: MethodWriter.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C12429r extends AbstractC12428q {

    /* JADX INFO: renamed from: c */
    public static final int[] f26264c = {0, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 1, 1, 1, 2, 2, 1, 1, 1, 0, 0, 1, 2, 1, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, -1, 0, -1, -1, -1, -1, -1, -2, -1, -2, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -3, -4, -3, -4, -3, -3, -3, -3, -1, -2, 1, 1, 1, 2, 2, 2, 0, -1, -2, -1, -2, -1, -2, -1, -2, -1, -2, -1, -2, -1, -2, -1, -2, -1, -2, -1, -2, 0, 0, 0, 0, -1, -1, -1, -1, -1, -1, -1, -2, -1, -2, -1, -2, 0, 1, 0, 1, -1, -1, 0, 0, 1, 1, -1, 0, -1, 0, 0, 0, -3, -1, -1, -3, -3, -1, -1, -1, -1, -1, -1, -2, -2, -2, -2, -2, -2, -2, -2, 0, 1, 0, -1, -1, -1, -2, -1, -2, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, -1, -1, 0, 0, -1, -1, 0, 0};

    /* JADX INFO: renamed from: A */
    public final int f26265A;

    /* JADX INFO: renamed from: B */
    public C12412a f26266B;

    /* JADX INFO: renamed from: C */
    public C12412a f26267C;

    /* JADX INFO: renamed from: D */
    public int f26268D;

    /* JADX INFO: renamed from: E */
    public C12412a[] f26269E;

    /* JADX INFO: renamed from: F */
    public int f26270F;

    /* JADX INFO: renamed from: G */
    public C12412a[] f26271G;

    /* JADX INFO: renamed from: H */
    public C12412a f26272H;

    /* JADX INFO: renamed from: I */
    public C12412a f26273I;

    /* JADX INFO: renamed from: J */
    public C12414c f26274J;

    /* JADX INFO: renamed from: K */
    public int f26275K;

    /* JADX INFO: renamed from: L */
    public C12414c f26276L;

    /* JADX INFO: renamed from: M */
    public C12413b f26277M;

    /* JADX INFO: renamed from: N */
    public final int f26278N;

    /* JADX INFO: renamed from: O */
    public C12427p f26279O;

    /* JADX INFO: renamed from: P */
    public C12427p f26280P;

    /* JADX INFO: renamed from: Q */
    public C12427p f26281Q;

    /* JADX INFO: renamed from: R */
    public int f26282R;

    /* JADX INFO: renamed from: S */
    public int f26283S;

    /* JADX INFO: renamed from: T */
    public int f26284T;

    /* JADX INFO: renamed from: U */
    public int f26285U;

    /* JADX INFO: renamed from: V */
    public int[] f26286V;

    /* JADX INFO: renamed from: W */
    public int[] f26287W;

    /* JADX INFO: renamed from: X */
    public boolean f26288X;

    /* JADX INFO: renamed from: Y */
    public boolean f26289Y;

    /* JADX INFO: renamed from: Z */
    public int f26290Z;

    /* JADX INFO: renamed from: a0 */
    public int f26291a0;

    /* JADX INFO: renamed from: b0 */
    public int f26292b0;

    /* JADX INFO: renamed from: d */
    public final C12433v f26293d;

    /* JADX INFO: renamed from: e */
    public final int f26294e;

    /* JADX INFO: renamed from: f */
    public final int f26295f;

    /* JADX INFO: renamed from: g */
    public final String f26296g;

    /* JADX INFO: renamed from: h */
    public final int f26297h;

    /* JADX INFO: renamed from: i */
    public final String f26298i;

    /* JADX INFO: renamed from: j */
    public int f26299j;

    /* JADX INFO: renamed from: k */
    public int f26300k;

    /* JADX INFO: renamed from: l */
    public final C12414c f26301l;

    /* JADX INFO: renamed from: m */
    public C12426o f26302m;

    /* JADX INFO: renamed from: n */
    public C12426o f26303n;

    /* JADX INFO: renamed from: o */
    public int f26304o;

    /* JADX INFO: renamed from: p */
    public C12414c f26305p;

    /* JADX INFO: renamed from: q */
    public int f26306q;

    /* JADX INFO: renamed from: r */
    public C12414c f26307r;

    /* JADX INFO: renamed from: s */
    public int f26308s;

    /* JADX INFO: renamed from: t */
    public C12414c f26309t;

    /* JADX INFO: renamed from: u */
    public int f26310u;

    /* JADX INFO: renamed from: v */
    public C12414c f26311v;

    /* JADX INFO: renamed from: w */
    public C12412a f26312w;

    /* JADX INFO: renamed from: x */
    public C12412a f26313x;

    /* JADX INFO: renamed from: y */
    public final int f26314y;

    /* JADX INFO: renamed from: z */
    public final int[] f26315z;

    public C12429r(C12433v c12433v, int i, String str, String str2, String str3, String[] strArr, int i2) {
        super(Opcodes.ASM7);
        this.f26301l = new C12414c();
        this.f26293d = c12433v;
        this.f26294e = "<init>".equals(str) ? 262144 | i : i;
        this.f26295f = c12433v.m10637l(str);
        this.f26296g = str;
        this.f26297h = c12433v.m10637l(str2);
        this.f26298i = str2;
        this.f26265A = str3 == null ? 0 : c12433v.m10637l(str3);
        if (strArr == null || strArr.length <= 0) {
            this.f26314y = 0;
            this.f26315z = null;
        } else {
            int length = strArr.length;
            this.f26314y = length;
            this.f26315z = new int[length];
            for (int i3 = 0; i3 < this.f26314y; i3++) {
                this.f26315z[i3] = c12433v.m10628c(strArr[i3]).f26340a;
            }
        }
        this.f26278N = i2;
        if (i2 != 0) {
            int iM10645b = C12434w.m10645b(str2) >> 2;
            iM10645b = (i & 8) != 0 ? iM10645b - 1 : iM10645b;
            this.f26300k = iM10645b;
            this.f26284T = iM10645b;
            C12427p c12427p = new C12427p();
            this.f26279O = c12427p;
            mo10601i(c12427p);
        }
    }

    /* JADX INFO: renamed from: A */
    public int m10613A(int i, int i2, int i3) {
        int i4 = i2 + 3 + i3;
        int[] iArr = this.f26287W;
        if (iArr == null || iArr.length < i4) {
            this.f26287W = new int[i4];
        }
        int[] iArr2 = this.f26287W;
        iArr2[0] = i;
        iArr2[1] = i2;
        iArr2[2] = i3;
        return 3;
    }

    /* JADX INFO: renamed from: B */
    public final void m10614B(C12427p c12427p, C12427p[] c12427pArr) {
        C12427p c12427p2 = this.f26281Q;
        if (c12427p2 != null) {
            int i = this.f26278N;
            if (i == 4) {
                c12427p2.f26258k.mo10569b(Opcodes.LOOKUPSWITCH, 0, null, null);
                m10615u(0, c12427p);
                C12427p c12427pM10588b = c12427p.m10588b();
                c12427pM10588b.f26249b = (short) (c12427pM10588b.f26249b | 2);
                for (C12427p c12427p3 : c12427pArr) {
                    m10615u(0, c12427p3);
                    C12427p c12427pM10588b2 = c12427p3.m10588b();
                    c12427pM10588b2.f26249b = (short) (c12427pM10588b2.f26249b | 2);
                }
            } else if (i == 1) {
                int i2 = this.f26282R - 1;
                this.f26282R = i2;
                m10615u(i2, c12427p);
                for (C12427p c12427p4 : c12427pArr) {
                    m10615u(this.f26282R, c12427p4);
                }
            }
            m10616v();
        }
    }

    @Override // p617h0.p618a.p619a.AbstractC12428q
    /* JADX INFO: renamed from: a */
    public C12412a mo10593a(String str, boolean z2) {
        C12414c c12414c = new C12414c();
        c12414c.m10538j(this.f26293d.m10637l(str));
        c12414c.m10538j(0);
        if (z2) {
            C12412a c12412a = new C12412a(this.f26293d, true, c12414c, this.f26266B);
            this.f26266B = c12412a;
            return c12412a;
        }
        C12412a c12412a2 = new C12412a(this.f26293d, true, c12414c, this.f26267C);
        this.f26267C = c12412a2;
        return c12412a2;
    }

    @Override // p617h0.p618a.p619a.AbstractC12428q
    /* JADX INFO: renamed from: b */
    public void mo10594b(int i, String str, String str2, String str3) {
        int i2;
        int i3;
        this.f26290Z = this.f26301l.f26154b;
        C12433v.a aVarM10633h = this.f26293d.m10633h(9, str, str2, str3);
        this.f26301l.m10533e(i, aVarM10633h.f26340a);
        C12427p c12427p = this.f26281Q;
        if (c12427p != null) {
            int i4 = this.f26278N;
            if (i4 == 4 || i4 == 3) {
                c12427p.f26258k.mo10569b(i, 0, aVarM10633h, this.f26293d);
                return;
            }
            char cCharAt = str3.charAt(0);
            int i5 = -2;
            switch (i) {
                case Opcodes.GETSTATIC /* 178 */:
                    i2 = this.f26282R + ((cCharAt == 'D' || cCharAt == 'J') ? 2 : 1);
                    break;
                case Opcodes.PUTSTATIC /* 179 */:
                    i3 = this.f26282R;
                    if (cCharAt != 'D' && cCharAt != 'J') {
                        i5 = -1;
                    }
                    i2 = i3 + i5;
                    break;
                case 180:
                    i2 = this.f26282R + ((cCharAt == 'D' || cCharAt == 'J') ? 1 : 0);
                    break;
                default:
                    i3 = this.f26282R;
                    if (cCharAt == 'D' || cCharAt == 'J') {
                        i5 = -3;
                    }
                    i2 = i3 + i5;
                    break;
            }
            if (i2 > this.f26283S) {
                this.f26283S = i2;
            }
            this.f26282R = i2;
        }
    }

    @Override // p617h0.p618a.p619a.AbstractC12428q
    /* JADX INFO: renamed from: c */
    public void mo10595c(int i, int i2, Object[] objArr, int i3, Object[] objArr2) {
        int i4;
        int i5 = this.f26278N;
        if (i5 == 4) {
            return;
        }
        int i6 = 3;
        if (i5 == 3) {
            C12427p c12427p = this.f26281Q;
            C12424m c12424m = c12427p.f26258k;
            if (c12424m == null) {
                C12420i c12420i = new C12420i(c12427p);
                c12427p.f26258k = c12420i;
                c12420i.m10584n(this.f26293d, this.f26294e, this.f26298i, i2);
                this.f26281Q.f26258k.m10575a(this);
            } else {
                if (i == -1) {
                    C12433v c12433v = this.f26293d;
                    int i7 = 0;
                    for (int i8 = 0; i8 < i2; i8++) {
                        int i9 = i7 + 1;
                        c12424m.f26229b[i7] = C12424m.m10572c(c12433v, objArr[i8]);
                        if (objArr[i8] == InterfaceC12431t.f26337e || objArr[i8] == InterfaceC12431t.f26336d) {
                            c12424m.f26229b[i9] = 16777216;
                            i7 = i9 + 1;
                        } else {
                            i7 = i9;
                        }
                    }
                    while (true) {
                        int[] iArr = c12424m.f26229b;
                        if (i7 >= iArr.length) {
                            break;
                        }
                        iArr[i7] = 16777216;
                        i7++;
                    }
                    int i10 = 0;
                    for (int i11 = 0; i11 < i3; i11++) {
                        if (objArr2[i11] == InterfaceC12431t.f26337e || objArr2[i11] == InterfaceC12431t.f26336d) {
                            i10++;
                        }
                    }
                    c12424m.f26230c = new int[i10 + i3];
                    int i12 = 0;
                    for (int i13 = 0; i13 < i3; i13++) {
                        int i14 = i12 + 1;
                        c12424m.f26230c[i12] = C12424m.m10572c(c12433v, objArr2[i13]);
                        if (objArr2[i13] == InterfaceC12431t.f26337e || objArr2[i13] == InterfaceC12431t.f26336d) {
                            c12424m.f26230c[i14] = 16777216;
                            i12 = i14 + 1;
                        } else {
                            i12 = i14;
                        }
                    }
                    c12424m.f26234g = (short) 0;
                    c12424m.f26235h = 0;
                }
                this.f26281Q.f26258k.m10575a(this);
            }
        } else if (i == -1) {
            if (this.f26286V == null) {
                int iM10645b = C12434w.m10645b(this.f26298i) >> 2;
                C12424m c12424m2 = new C12424m(new C12427p());
                c12424m2.m10584n(this.f26293d, this.f26294e, this.f26298i, iM10645b);
                c12424m2.m10575a(this);
            }
            this.f26284T = i2;
            m10613A(this.f26301l.f26154b, i2, i3);
            int i15 = 0;
            while (i15 < i2) {
                this.f26287W[i6] = C12424m.m10572c(this.f26293d, objArr[i15]);
                i15++;
                i6++;
            }
            int i16 = 0;
            while (i16 < i3) {
                this.f26287W[i6] = C12424m.m10572c(this.f26293d, objArr2[i16]);
                i16++;
                i6++;
            }
            m10620z();
        } else {
            if (this.f26311v == null) {
                this.f26311v = new C12414c();
                i4 = this.f26301l.f26154b;
            } else {
                i4 = (this.f26301l.f26154b - this.f26285U) - 1;
                if (i4 < 0) {
                    if (i != 3) {
                        throw new IllegalStateException();
                    }
                    return;
                }
            }
            if (i == 0) {
                this.f26284T = i2;
                C12414c c12414c = this.f26311v;
                c12414c.m10535g(255);
                c12414c.m10538j(i4);
                c12414c.m10538j(i2);
                for (int i17 = 0; i17 < i2; i17++) {
                    m10618x(objArr[i17]);
                }
                this.f26311v.m10538j(i3);
                for (int i18 = 0; i18 < i3; i18++) {
                    m10618x(objArr2[i18]);
                }
            } else if (i == 1) {
                this.f26284T += i2;
                C12414c c12414c2 = this.f26311v;
                c12414c2.m10535g(i2 + 251);
                c12414c2.m10538j(i4);
                for (int i19 = 0; i19 < i2; i19++) {
                    m10618x(objArr[i19]);
                }
            } else if (i == 2) {
                this.f26284T -= i2;
                C12414c c12414c3 = this.f26311v;
                c12414c3.m10535g(251 - i2);
                c12414c3.m10538j(i4);
            } else if (i != 3) {
                if (i != 4) {
                    throw new IllegalArgumentException();
                }
                if (i4 < 64) {
                    this.f26311v.m10535g(i4 + 64);
                } else {
                    C12414c c12414c4 = this.f26311v;
                    c12414c4.m10535g(247);
                    c12414c4.m10538j(i4);
                }
                m10618x(objArr2[0]);
            } else if (i4 < 64) {
                this.f26311v.m10535g(i4);
            } else {
                C12414c c12414c5 = this.f26311v;
                c12414c5.m10535g(251);
                c12414c5.m10538j(i4);
            }
            this.f26285U = this.f26301l.f26154b;
            this.f26310u++;
        }
        if (this.f26278N == 2) {
            this.f26282R = i3;
            for (int i20 = 0; i20 < i3; i20++) {
                if (objArr2[i20] == InterfaceC12431t.f26337e || objArr2[i20] == InterfaceC12431t.f26336d) {
                    this.f26282R++;
                }
            }
            int i21 = this.f26282R;
            if (i21 > this.f26283S) {
                this.f26283S = i21;
            }
        }
        this.f26299j = Math.max(this.f26299j, i3);
        this.f26300k = Math.max(this.f26300k, this.f26284T);
    }

    @Override // p617h0.p618a.p619a.AbstractC12428q
    /* JADX INFO: renamed from: d */
    public void mo10596d(int i, int i2) {
        int i3;
        int i4;
        C12414c c12414c = this.f26301l;
        this.f26290Z = c12414c.f26154b;
        if (i > 255 || i2 > 127 || i2 < -128) {
            c12414c.m10535g(196);
            c12414c.m10533e(Opcodes.IINC, i);
            c12414c.m10538j(i2);
        } else {
            c12414c.m10535g(Opcodes.IINC);
            c12414c.m10531c(i, i2);
        }
        C12427p c12427p = this.f26281Q;
        if (c12427p != null && ((i4 = this.f26278N) == 4 || i4 == 3)) {
            c12427p.f26258k.mo10569b(Opcodes.IINC, i, null, null);
        }
        if (this.f26278N == 0 || (i3 = i + 1) <= this.f26300k) {
            return;
        }
        this.f26300k = i3;
    }

    @Override // p617h0.p618a.p619a.AbstractC12428q
    /* JADX INFO: renamed from: e */
    public void mo10597e(int i) {
        C12414c c12414c = this.f26301l;
        this.f26290Z = c12414c.f26154b;
        c12414c.m10535g(i);
        C12427p c12427p = this.f26281Q;
        if (c12427p != null) {
            int i2 = this.f26278N;
            if (i2 == 4 || i2 == 3) {
                c12427p.f26258k.mo10569b(i, 0, null, null);
            } else {
                int i3 = this.f26282R + f26264c[i];
                if (i3 > this.f26283S) {
                    this.f26283S = i3;
                }
                this.f26282R = i3;
            }
            if ((i < 172 || i > 177) && i != 191) {
                return;
            }
            m10616v();
        }
    }

    @Override // p617h0.p618a.p619a.AbstractC12428q
    /* JADX INFO: renamed from: f */
    public C12412a mo10598f(int i, C12435x c12435x, String str, boolean z2) {
        C12414c c12414c = new C12414c();
        C3404f.m4256W0((i & (-16776961)) | (this.f26290Z << 8), c12414c);
        C12435x.m10655a(c12435x, c12414c);
        c12414c.m10538j(this.f26293d.m10637l(str));
        c12414c.m10538j(0);
        if (z2) {
            C12412a c12412a = new C12412a(this.f26293d, true, c12414c, this.f26312w);
            this.f26312w = c12412a;
            return c12412a;
        }
        C12412a c12412a2 = new C12412a(this.f26293d, true, c12414c, this.f26313x);
        this.f26313x = c12412a2;
        return c12412a2;
    }

    @Override // p617h0.p618a.p619a.AbstractC12428q
    /* JADX INFO: renamed from: g */
    public void mo10599g(int i, int i2) {
        C12414c c12414c = this.f26301l;
        this.f26290Z = c12414c.f26154b;
        if (i == 17) {
            c12414c.m10533e(i, i2);
        } else {
            c12414c.m10531c(i, i2);
        }
        C12427p c12427p = this.f26281Q;
        if (c12427p != null) {
            int i3 = this.f26278N;
            if (i3 == 4 || i3 == 3) {
                c12427p.f26258k.mo10569b(i, i2, null, null);
            } else if (i != 188) {
                int i4 = this.f26282R + 1;
                if (i4 > this.f26283S) {
                    this.f26283S = i4;
                }
                this.f26282R = i4;
            }
        }
    }

    @Override // p617h0.p618a.p619a.AbstractC12428q
    /* JADX INFO: renamed from: h */
    public void mo10600h(int i, C12427p c12427p) {
        boolean z2;
        C12414c c12414c = this.f26301l;
        int i2 = c12414c.f26154b;
        this.f26290Z = i2;
        int i3 = i >= 200 ? i - 33 : i;
        if ((c12427p.f26249b & 4) == 0 || c12427p.f26252e - i2 >= -32768) {
            if (i3 != i) {
                c12414c.m10535g(i);
                C12414c c12414c2 = this.f26301l;
                c12427p.m10591e(c12414c2, c12414c2.f26154b - 1, true);
            } else {
                c12414c.m10535g(i3);
                C12414c c12414c3 = this.f26301l;
                c12427p.m10591e(c12414c3, c12414c3.f26154b - 1, false);
            }
            z2 = false;
        } else {
            if (i3 == 167) {
                c12414c.m10535g(200);
            } else {
                if (i3 == 168) {
                    c12414c.m10535g(201);
                } else {
                    c12414c.m10535g(i3 >= 198 ? i3 ^ 1 : ((i3 + 1) ^ 1) - 1);
                    this.f26301l.m10538j(8);
                    this.f26301l.m10535g(220);
                    this.f26289Y = true;
                    z2 = true;
                }
                C12414c c12414c4 = this.f26301l;
                c12427p.m10591e(c12414c4, c12414c4.f26154b - 1, true);
            }
            z2 = false;
            C12414c c12414c5 = this.f26301l;
            c12427p.m10591e(c12414c5, c12414c5.f26154b - 1, true);
        }
        C12427p c12427p2 = this.f26281Q;
        if (c12427p2 != null) {
            int i4 = this.f26278N;
            C12427p c12427p3 = null;
            if (i4 == 4) {
                c12427p2.f26258k.mo10569b(i3, 0, null, null);
                C12427p c12427pM10588b = c12427p.m10588b();
                c12427pM10588b.f26249b = (short) (c12427pM10588b.f26249b | 2);
                m10615u(0, c12427p);
                if (i3 != 167) {
                    c12427p3 = new C12427p();
                }
            } else if (i4 == 3) {
                c12427p2.f26258k.mo10569b(i3, 0, null, null);
            } else if (i4 == 2) {
                this.f26282R += f26264c[i3];
            } else if (i3 == 168) {
                short s2 = c12427p.f26249b;
                if ((s2 & 32) == 0) {
                    c12427p.f26249b = (short) (s2 | 32);
                    this.f26288X = true;
                }
                c12427p2.f26249b = (short) (c12427p2.f26249b | 16);
                m10615u(this.f26282R + 1, c12427p);
                c12427p3 = new C12427p();
            } else {
                int i5 = this.f26282R + f26264c[i3];
                this.f26282R = i5;
                m10615u(i5, c12427p);
            }
            if (c12427p3 != null) {
                if (z2) {
                    c12427p3.f26249b = (short) (c12427p3.f26249b | 2);
                }
                mo10601i(c12427p3);
            }
            if (i3 == 167) {
                m10616v();
            }
        }
    }

    @Override // p617h0.p618a.p619a.AbstractC12428q
    /* JADX INFO: renamed from: i */
    public void mo10601i(C12427p c12427p) {
        boolean z2 = this.f26289Y;
        C12414c c12414c = this.f26301l;
        this.f26289Y = z2 | c12427p.m10592f(c12414c.f26153a, c12414c.f26154b);
        short s2 = c12427p.f26249b;
        if ((s2 & 1) != 0) {
            return;
        }
        int i = this.f26278N;
        if (i == 4) {
            C12427p c12427p2 = this.f26281Q;
            if (c12427p2 != null) {
                if (c12427p.f26252e == c12427p2.f26252e) {
                    c12427p2.f26249b = (short) ((s2 & 2) | c12427p2.f26249b);
                    c12427p.f26258k = c12427p2.f26258k;
                    return;
                }
                m10615u(0, c12427p);
            }
            C12427p c12427p3 = this.f26280P;
            if (c12427p3 != null) {
                if (c12427p.f26252e == c12427p3.f26252e) {
                    c12427p3.f26249b = (short) (c12427p3.f26249b | (c12427p.f26249b & 2));
                    c12427p.f26258k = c12427p3.f26258k;
                    this.f26281Q = c12427p3;
                    return;
                }
                c12427p3.f26259l = c12427p;
            }
            this.f26280P = c12427p;
            this.f26281Q = c12427p;
            c12427p.f26258k = new C12424m(c12427p);
            return;
        }
        if (i == 3) {
            C12427p c12427p4 = this.f26281Q;
            if (c12427p4 == null) {
                this.f26281Q = c12427p;
                return;
            } else {
                c12427p4.f26258k.f26228a = c12427p;
                return;
            }
        }
        if (i != 1) {
            if (i == 2 && this.f26281Q == null) {
                this.f26281Q = c12427p;
                return;
            }
            return;
        }
        C12427p c12427p5 = this.f26281Q;
        if (c12427p5 != null) {
            c12427p5.f26256i = (short) this.f26283S;
            m10615u(this.f26282R, c12427p);
        }
        this.f26281Q = c12427p;
        this.f26282R = 0;
        this.f26283S = 0;
        C12427p c12427p6 = this.f26280P;
        if (c12427p6 != null) {
            c12427p6.f26259l = c12427p;
        }
        this.f26280P = c12427p;
    }

    @Override // p617h0.p618a.p619a.AbstractC12428q
    /* JADX INFO: renamed from: j */
    public void mo10602j(Object obj) {
        char cCharAt;
        this.f26290Z = this.f26301l.f26154b;
        AbstractC12432u abstractC12432uM10627b = this.f26293d.m10627b(obj);
        int i = abstractC12432uM10627b.f26340a;
        int i2 = abstractC12432uM10627b.f26341b;
        boolean z2 = i2 == 5 || i2 == 6 || (i2 == 17 && ((cCharAt = abstractC12432uM10627b.f26344e.charAt(0)) == 'J' || cCharAt == 'D'));
        if (z2) {
            this.f26301l.m10533e(20, i);
        } else if (i >= 256) {
            this.f26301l.m10533e(19, i);
        } else {
            this.f26301l.m10531c(18, i);
        }
        C12427p c12427p = this.f26281Q;
        if (c12427p != null) {
            int i3 = this.f26278N;
            if (i3 == 4 || i3 == 3) {
                c12427p.f26258k.mo10569b(18, 0, abstractC12432uM10627b, this.f26293d);
                return;
            }
            int i4 = this.f26282R + (z2 ? 2 : 1);
            if (i4 > this.f26283S) {
                this.f26283S = i4;
            }
            this.f26282R = i4;
        }
    }

    @Override // p617h0.p618a.p619a.AbstractC12428q
    /* JADX INFO: renamed from: k */
    public void mo10603k(int i, C12427p c12427p) {
        if (this.f26305p == null) {
            this.f26305p = new C12414c();
        }
        this.f26304o++;
        this.f26305p.m10538j(c12427p.f26252e);
        this.f26305p.m10538j(i);
    }

    @Override // p617h0.p618a.p619a.AbstractC12428q
    /* JADX INFO: renamed from: l */
    public void mo10604l(String str, String str2, String str3, C12427p c12427p, C12427p c12427p2, int i) {
        if (str3 != null) {
            if (this.f26309t == null) {
                this.f26309t = new C12414c();
            }
            this.f26308s++;
            C12414c c12414c = this.f26309t;
            c12414c.m10538j(c12427p.f26252e);
            c12414c.m10538j(c12427p2.f26252e - c12427p.f26252e);
            c12414c.m10538j(this.f26293d.m10637l(str));
            c12414c.m10538j(this.f26293d.m10637l(str3));
            c12414c.m10538j(i);
        }
        if (this.f26307r == null) {
            this.f26307r = new C12414c();
        }
        this.f26306q++;
        C12414c c12414c2 = this.f26307r;
        c12414c2.m10538j(c12427p.f26252e);
        c12414c2.m10538j(c12427p2.f26252e - c12427p.f26252e);
        c12414c2.m10538j(this.f26293d.m10637l(str));
        c12414c2.m10538j(this.f26293d.m10637l(str2));
        c12414c2.m10538j(i);
        if (this.f26278N != 0) {
            char cCharAt = str2.charAt(0);
            int i2 = i + ((cCharAt == 'J' || cCharAt == 'D') ? 2 : 1);
            if (i2 > this.f26300k) {
                this.f26300k = i2;
            }
        }
    }

    @Override // p617h0.p618a.p619a.AbstractC12428q
    /* JADX INFO: renamed from: m */
    public C12412a mo10605m(int i, C12435x c12435x, C12427p[] c12427pArr, C12427p[] c12427pArr2, int[] iArr, String str, boolean z2) {
        C12414c c12414c = new C12414c();
        c12414c.m10535g(i >>> 24);
        c12414c.m10538j(c12427pArr.length);
        for (int i2 = 0; i2 < c12427pArr.length; i2++) {
            c12414c.m10538j(c12427pArr[i2].f26252e);
            c12414c.m10538j(c12427pArr2[i2].f26252e - c12427pArr[i2].f26252e);
            c12414c.m10538j(iArr[i2]);
        }
        C12435x.m10655a(c12435x, c12414c);
        c12414c.m10538j(this.f26293d.m10637l(str));
        c12414c.m10538j(0);
        if (z2) {
            C12412a c12412a = new C12412a(this.f26293d, true, c12414c, this.f26312w);
            this.f26312w = c12412a;
            return c12412a;
        }
        C12412a c12412a2 = new C12412a(this.f26293d, true, c12414c, this.f26313x);
        this.f26313x = c12412a2;
        return c12412a2;
    }

    @Override // p617h0.p618a.p619a.AbstractC12428q
    /* JADX INFO: renamed from: n */
    public void mo10606n(int i, int i2) {
        int i3 = this.f26278N;
        if (i3 == 4) {
            C12426o c12426o = this.f26302m;
            while (true) {
                if (c12426o == null) {
                    break;
                }
                String str = c12426o.f26246e;
                int iM10639n = 33554432 | this.f26293d.m10639n(str != null ? str : "java/lang/Throwable");
                C12427p c12427pM10588b = c12426o.f26244c.m10588b();
                c12427pM10588b.f26249b = (short) (c12427pM10588b.f26249b | 2);
                C12427p c12427pM10588b2 = c12426o.f26243b.m10588b();
                for (C12427p c12427pM10588b3 = c12426o.f26242a.m10588b(); c12427pM10588b3 != c12427pM10588b2; c12427pM10588b3 = c12427pM10588b3.f26259l) {
                    c12427pM10588b3.f26260m = new C12421j(iM10639n, c12427pM10588b, c12427pM10588b3.f26260m);
                }
                c12426o = c12426o.f26247f;
            }
            C12424m c12424m = this.f26279O.f26258k;
            c12424m.m10584n(this.f26293d, this.f26294e, this.f26298i, this.f26300k);
            c12424m.m10575a(this);
            C12427p c12427p = this.f26279O;
            c12427p.f26261n = C12427p.f26248a;
            int iMax = 0;
            while (c12427p != C12427p.f26248a) {
                C12427p c12427p2 = c12427p.f26261n;
                c12427p.f26261n = null;
                c12427p.f26249b = (short) (c12427p.f26249b | 8);
                int length = c12427p.f26258k.f26230c.length + c12427p.f26256i;
                if (length > iMax) {
                    iMax = length;
                }
                for (C12421j c12421j = c12427p.f26260m; c12421j != null; c12421j = c12421j.f26215c) {
                    C12427p c12427pM10588b4 = c12421j.f26214b.m10588b();
                    if (c12427p.f26258k.m10578h(this.f26293d, c12427pM10588b4.f26258k, c12421j.f26213a) && c12427pM10588b4.f26261n == null) {
                        c12427pM10588b4.f26261n = c12427p2;
                        c12427p2 = c12427pM10588b4;
                    }
                }
                c12427p = c12427p2;
            }
            for (C12427p c12427p3 = this.f26279O; c12427p3 != null; c12427p3 = c12427p3.f26259l) {
                if ((c12427p3.f26249b & 10) == 10) {
                    c12427p3.f26258k.m10575a(this);
                }
                if ((c12427p3.f26249b & 8) == 0) {
                    C12427p c12427p4 = c12427p3.f26259l;
                    int i4 = c12427p3.f26252e;
                    int i5 = (c12427p4 == null ? this.f26301l.f26154b : c12427p4.f26252e) - 1;
                    if (i5 >= i4) {
                        for (int i6 = i4; i6 < i5; i6++) {
                            this.f26301l.f26153a[i6] = 0;
                        }
                        this.f26301l.f26153a[i5] = -65;
                        m10613A(i4, 0, 1);
                        this.f26287W[3] = this.f26293d.m10639n("java/lang/Throwable") | 33554432;
                        m10620z();
                        this.f26302m = C12426o.m10586a(this.f26302m, c12427p3, c12427p4);
                        iMax = Math.max(iMax, 1);
                    }
                }
            }
            this.f26299j = iMax;
            return;
        }
        if (i3 != 1) {
            if (i3 == 2) {
                this.f26299j = this.f26283S;
                return;
            } else {
                this.f26299j = i;
                this.f26300k = i2;
                return;
            }
        }
        for (C12426o c12426o2 = this.f26302m; c12426o2 != null; c12426o2 = c12426o2.f26247f) {
            C12427p c12427p5 = c12426o2.f26244c;
            C12427p c12427p6 = c12426o2.f26243b;
            for (C12427p c12427p7 = c12426o2.f26242a; c12427p7 != c12427p6; c12427p7 = c12427p7.f26259l) {
                if ((c12427p7.f26249b & 16) == 0) {
                    c12427p7.f26260m = new C12421j(Integer.MAX_VALUE, c12427p5, c12427p7.f26260m);
                } else {
                    C12421j c12421j2 = c12427p7.f26260m.f26215c;
                    c12421j2.f26215c = new C12421j(Integer.MAX_VALUE, c12427p5, c12421j2.f26215c);
                }
            }
        }
        if (this.f26288X) {
            this.f26279O.m10589c((short) 1);
            short s2 = 1;
            for (short s3 = 1; s3 <= s2; s3 = (short) (s3 + 1)) {
                for (C12427p c12427p8 = this.f26279O; c12427p8 != null; c12427p8 = c12427p8.f26259l) {
                    if ((c12427p8.f26249b & 16) != 0 && c12427p8.f26257j == s3) {
                        C12427p c12427p9 = c12427p8.f26260m.f26215c.f26214b;
                        if (c12427p9.f26257j == 0) {
                            s2 = (short) (s2 + 1);
                            c12427p9.m10589c(s2);
                        }
                    }
                }
            }
            for (C12427p c12427p10 = this.f26279O; c12427p10 != null; c12427p10 = c12427p10.f26259l) {
                if ((c12427p10.f26249b & 16) != 0) {
                    C12427p c12427pM10590d = c12427p10.f26260m.f26215c.f26214b;
                    C12427p c12427p11 = C12427p.f26248a;
                    c12427pM10590d.f26261n = c12427p11;
                    while (c12427pM10590d != C12427p.f26248a) {
                        C12427p c12427p12 = c12427pM10590d.f26261n;
                        c12427pM10590d.f26261n = c12427p11;
                        if ((c12427pM10590d.f26249b & 64) != 0 && c12427pM10590d.f26257j != c12427p10.f26257j) {
                            c12427pM10590d.f26260m = new C12421j(c12427pM10590d.f26255h, c12427p10.f26260m.f26214b, c12427pM10590d.f26260m);
                        }
                        c12427p11 = c12427pM10590d;
                        c12427pM10590d = c12427pM10590d.m10590d(c12427p12);
                    }
                    while (c12427p11 != C12427p.f26248a) {
                        C12427p c12427p13 = c12427p11.f26261n;
                        c12427p11.f26261n = null;
                        c12427p11 = c12427p13;
                    }
                }
            }
        }
        C12427p c12427p14 = this.f26279O;
        c12427p14.f26261n = C12427p.f26248a;
        int i7 = this.f26299j;
        while (c12427p14 != C12427p.f26248a) {
            C12427p c12427p15 = c12427p14.f26261n;
            short s4 = c12427p14.f26254g;
            int i8 = c12427p14.f26256i + s4;
            if (i8 > i7) {
                i7 = i8;
            }
            C12421j c12421j3 = c12427p14.f26260m;
            if ((c12427p14.f26249b & 16) != 0) {
                c12421j3 = c12421j3.f26215c;
            }
            c12427p14 = c12427p15;
            while (c12421j3 != null) {
                C12427p c12427p16 = c12421j3.f26214b;
                if (c12427p16.f26261n == null) {
                    int i9 = c12421j3.f26213a;
                    c12427p16.f26254g = (short) (i9 == Integer.MAX_VALUE ? 1 : i9 + s4);
                    c12427p16.f26261n = c12427p14;
                    c12427p14 = c12427p16;
                }
                c12421j3 = c12421j3.f26215c;
            }
        }
        this.f26299j = i7;
    }

    @Override // p617h0.p618a.p619a.AbstractC12428q
    /* JADX INFO: renamed from: p */
    public void mo10608p(int i, String str, String str2, String str3, boolean z2) {
        this.f26290Z = this.f26301l.f26154b;
        C12433v.a aVarM10633h = this.f26293d.m10633h(z2 ? 11 : 10, str, str2, str3);
        if (i == 185) {
            C12414c c12414c = this.f26301l;
            c12414c.m10533e(Opcodes.INVOKEINTERFACE, aVarM10633h.f26340a);
            c12414c.m10531c(aVarM10633h.m10621a() >> 2, 0);
        } else {
            this.f26301l.m10533e(i, aVarM10633h.f26340a);
        }
        C12427p c12427p = this.f26281Q;
        if (c12427p != null) {
            int i2 = this.f26278N;
            if (i2 == 4 || i2 == 3) {
                c12427p.f26258k.mo10569b(i, 0, aVarM10633h, this.f26293d);
                return;
            }
            int iM10621a = aVarM10633h.m10621a();
            int i3 = (iM10621a & 3) - (iM10621a >> 2);
            int i4 = i == 184 ? this.f26282R + i3 + 1 : this.f26282R + i3;
            if (i4 > this.f26283S) {
                this.f26283S = i4;
            }
            this.f26282R = i4;
        }
    }

    @Override // p617h0.p618a.p619a.AbstractC12428q
    /* JADX INFO: renamed from: q */
    public void mo10609q(int i, int i2, C12427p c12427p, C12427p... c12427pArr) {
        C12414c c12414c = this.f26301l;
        this.f26290Z = c12414c.f26154b;
        c12414c.m10535g(Opcodes.TABLESWITCH);
        c12414c.m10536h(null, 0, (4 - (this.f26301l.f26154b % 4)) % 4);
        c12427p.m10591e(this.f26301l, this.f26290Z, true);
        C12414c c12414c2 = this.f26301l;
        c12414c2.m10537i(i);
        c12414c2.m10537i(i2);
        for (C12427p c12427p2 : c12427pArr) {
            c12427p2.m10591e(this.f26301l, this.f26290Z, true);
        }
        m10614B(c12427p, c12427pArr);
    }

    @Override // p617h0.p618a.p619a.AbstractC12428q
    /* JADX INFO: renamed from: r */
    public C12412a mo10610r(int i, C12435x c12435x, String str, boolean z2) {
        C12414c c12414c = new C12414c();
        C3404f.m4256W0(i, c12414c);
        C12435x.m10655a(c12435x, c12414c);
        c12414c.m10538j(this.f26293d.m10637l(str));
        c12414c.m10538j(0);
        if (z2) {
            C12412a c12412a = new C12412a(this.f26293d, true, c12414c, this.f26272H);
            this.f26272H = c12412a;
            return c12412a;
        }
        C12412a c12412a2 = new C12412a(this.f26293d, true, c12414c, this.f26273I);
        this.f26273I = c12412a2;
        return c12412a2;
    }

    @Override // p617h0.p618a.p619a.AbstractC12428q
    /* JADX INFO: renamed from: s */
    public void mo10611s(int i, String str) {
        this.f26290Z = this.f26301l.f26154b;
        AbstractC12432u abstractC12432uM10638m = this.f26293d.m10638m(7, str);
        this.f26301l.m10533e(i, abstractC12432uM10638m.f26340a);
        C12427p c12427p = this.f26281Q;
        if (c12427p != null) {
            int i2 = this.f26278N;
            if (i2 == 4 || i2 == 3) {
                c12427p.f26258k.mo10569b(i, this.f26290Z, abstractC12432uM10638m, this.f26293d);
            } else if (i == 187) {
                int i3 = this.f26282R + 1;
                if (i3 > this.f26283S) {
                    this.f26283S = i3;
                }
                this.f26282R = i3;
            }
        }
    }

    @Override // p617h0.p618a.p619a.AbstractC12428q
    /* JADX INFO: renamed from: t */
    public void mo10612t(int i, int i2) {
        C12414c c12414c = this.f26301l;
        this.f26290Z = c12414c.f26154b;
        if (i2 < 4 && i != 169) {
            c12414c.m10535g((i < 54 ? ((i - 21) << 2) + 26 : ((i - 54) << 2) + 59) + i2);
        } else if (i2 >= 256) {
            c12414c.m10535g(196);
            c12414c.m10533e(i, i2);
        } else {
            c12414c.m10531c(i, i2);
        }
        C12427p c12427p = this.f26281Q;
        if (c12427p != null) {
            int i3 = this.f26278N;
            if (i3 == 4 || i3 == 3) {
                c12427p.f26258k.mo10569b(i, i2, null, null);
            } else if (i == 169) {
                c12427p.f26249b = (short) (c12427p.f26249b | 64);
                c12427p.f26255h = (short) this.f26282R;
                m10616v();
            } else {
                int i4 = this.f26282R + f26264c[i];
                if (i4 > this.f26283S) {
                    this.f26283S = i4;
                }
                this.f26282R = i4;
            }
        }
        int i5 = this.f26278N;
        if (i5 != 0) {
            int i6 = (i == 22 || i == 24 || i == 55 || i == 57) ? i2 + 2 : i2 + 1;
            if (i6 > this.f26300k) {
                this.f26300k = i6;
            }
        }
        if (i < 54 || i5 != 4 || this.f26302m == null) {
            return;
        }
        mo10601i(new C12427p());
    }

    /* JADX INFO: renamed from: u */
    public final void m10615u(int i, C12427p c12427p) {
        C12427p c12427p2 = this.f26281Q;
        c12427p2.f26260m = new C12421j(i, c12427p, c12427p2.f26260m);
    }

    /* JADX INFO: renamed from: v */
    public final void m10616v() {
        int i = this.f26278N;
        if (i != 4) {
            if (i == 1) {
                this.f26281Q.f26256i = (short) this.f26283S;
                this.f26281Q = null;
                return;
            }
            return;
        }
        C12427p c12427p = new C12427p();
        c12427p.f26258k = new C12424m(c12427p);
        C12414c c12414c = this.f26301l;
        c12427p.m10592f(c12414c.f26153a, c12414c.f26154b);
        this.f26280P.f26259l = c12427p;
        this.f26280P = c12427p;
        this.f26281Q = null;
    }

    /* JADX INFO: renamed from: w */
    public final void m10617w(int i, int i2) {
        while (i < i2) {
            C12433v c12433v = this.f26293d;
            int i3 = this.f26287W[i];
            C12414c c12414c = this.f26311v;
            int i4 = ((-268435456) & i3) >> 28;
            if (i4 == 0) {
                int i5 = i3 & 1048575;
                int i6 = i3 & 251658240;
                if (i6 == 16777216) {
                    c12414c.m10535g(i5);
                } else if (i6 == 33554432) {
                    c12414c.m10535g(7);
                    c12414c.m10538j(c12433v.m10628c(c12433v.f26358l[i5].f26344e).f26340a);
                } else {
                    if (i6 != 50331648) {
                        throw new AssertionError();
                    }
                    c12414c.m10535g(8);
                    c12414c.m10538j((int) c12433v.f26358l[i5].f26345f);
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
                            sb.append(c12433v.f26358l[i3 & 1048575].f26344e);
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
                        c12414c.m10535g(7);
                        c12414c.m10538j(c12433v.m10628c(sb.toString()).f26340a);
                    }
                }
            }
            i++;
        }
    }

    /* JADX INFO: renamed from: x */
    public final void m10618x(Object obj) {
        if (obj instanceof Integer) {
            this.f26311v.m10535g(((Integer) obj).intValue());
            return;
        }
        if (obj instanceof String) {
            C12414c c12414c = this.f26311v;
            c12414c.m10535g(7);
            c12414c.m10538j(this.f26293d.m10628c((String) obj).f26340a);
        } else {
            C12414c c12414c2 = this.f26311v;
            c12414c2.m10535g(8);
            c12414c2.m10538j(((C12427p) obj).f26252e);
        }
    }

    /* JADX INFO: renamed from: y */
    public void m10619y(C12414c c12414c) {
        int i;
        boolean z2 = this.f26293d.f26349c < 49;
        c12414c.m10538j((~(z2 ? 4096 : 0)) & this.f26294e);
        c12414c.m10538j(this.f26295f);
        c12414c.m10538j(this.f26297h);
        int i2 = this.f26291a0;
        if (i2 != 0) {
            c12414c.m10536h(this.f26293d.f26348b.f26155a, i2, this.f26292b0);
            return;
        }
        int iM10525c = this.f26301l.f26154b > 0 ? 1 : 0;
        if (this.f26314y > 0) {
            iM10525c++;
        }
        int i3 = this.f26294e;
        if ((i3 & 4096) != 0 && z2) {
            iM10525c++;
        }
        if (this.f26265A != 0) {
            iM10525c++;
        }
        if ((i3 & 131072) != 0) {
            iM10525c++;
        }
        if (this.f26266B != null) {
            iM10525c++;
        }
        if (this.f26267C != null) {
            iM10525c++;
        }
        if (this.f26269E != null) {
            iM10525c++;
        }
        if (this.f26271G != null) {
            iM10525c++;
        }
        if (this.f26272H != null) {
            iM10525c++;
        }
        if (this.f26273I != null) {
            iM10525c++;
        }
        if (this.f26274J != null) {
            iM10525c++;
        }
        if (this.f26276L != null) {
            iM10525c++;
        }
        C12413b c12413b = this.f26277M;
        if (c12413b != null) {
            iM10525c += c12413b.m10525c();
        }
        c12414c.m10538j(iM10525c);
        int i4 = this.f26301l.f26154b;
        if (i4 > 0) {
            int i5 = i4 + 10;
            int i6 = 0;
            for (C12426o c12426o = this.f26302m; c12426o != null; c12426o = c12426o.f26247f) {
                i6++;
            }
            int iM10518a = (i6 * 8) + 2 + i5;
            C12414c c12414c2 = this.f26311v;
            if (c12414c2 != null) {
                iM10518a += c12414c2.f26154b + 8;
                i = 1;
            } else {
                i = 0;
            }
            C12414c c12414c3 = this.f26305p;
            if (c12414c3 != null) {
                iM10518a += c12414c3.f26154b + 8;
                i++;
            }
            C12414c c12414c4 = this.f26307r;
            if (c12414c4 != null) {
                iM10518a += c12414c4.f26154b + 8;
                i++;
            }
            C12414c c12414c5 = this.f26309t;
            if (c12414c5 != null) {
                iM10518a += c12414c5.f26154b + 8;
                i++;
            }
            C12412a c12412a = this.f26312w;
            if (c12412a != null) {
                iM10518a += c12412a.m10518a("RuntimeVisibleTypeAnnotations");
                i++;
            }
            C12412a c12412a2 = this.f26313x;
            if (c12412a2 != null) {
                iM10518a += c12412a2.m10518a("RuntimeInvisibleTypeAnnotations");
                i++;
            }
            C1643a.m878t0(this.f26293d, "Code", c12414c, iM10518a);
            c12414c.m10538j(this.f26299j);
            c12414c.m10538j(this.f26300k);
            c12414c.m10537i(this.f26301l.f26154b);
            C12414c c12414c6 = this.f26301l;
            c12414c.m10536h(c12414c6.f26153a, 0, c12414c6.f26154b);
            C12426o c12426o2 = this.f26302m;
            int i7 = 0;
            for (C12426o c12426o3 = c12426o2; c12426o3 != null; c12426o3 = c12426o3.f26247f) {
                i7++;
            }
            c12414c.m10538j(i7);
            while (c12426o2 != null) {
                c12414c.m10538j(c12426o2.f26242a.f26252e);
                c12414c.m10538j(c12426o2.f26243b.f26252e);
                c12414c.m10538j(c12426o2.f26244c.f26252e);
                c12414c.m10538j(c12426o2.f26245d);
                c12426o2 = c12426o2.f26247f;
            }
            c12414c.m10538j(i);
            if (this.f26311v != null) {
                C12433v c12433v = this.f26293d;
                c12414c.m10538j(c12433v.m10637l(c12433v.f26349c >= 50 ? "StackMapTable" : "StackMap"));
                c12414c.m10537i(this.f26311v.f26154b + 2);
                c12414c.m10538j(this.f26310u);
                C12414c c12414c7 = this.f26311v;
                c12414c.m10536h(c12414c7.f26153a, 0, c12414c7.f26154b);
            }
            if (this.f26305p != null) {
                c12414c.m10538j(this.f26293d.m10637l("LineNumberTable"));
                c12414c.m10537i(this.f26305p.f26154b + 2);
                c12414c.m10538j(this.f26304o);
                C12414c c12414c8 = this.f26305p;
                c12414c.m10536h(c12414c8.f26153a, 0, c12414c8.f26154b);
            }
            if (this.f26307r != null) {
                c12414c.m10538j(this.f26293d.m10637l("LocalVariableTable"));
                c12414c.m10537i(this.f26307r.f26154b + 2);
                c12414c.m10538j(this.f26306q);
                C12414c c12414c9 = this.f26307r;
                c12414c.m10536h(c12414c9.f26153a, 0, c12414c9.f26154b);
            }
            if (this.f26309t != null) {
                c12414c.m10538j(this.f26293d.m10637l("LocalVariableTypeTable"));
                c12414c.m10537i(this.f26309t.f26154b + 2);
                c12414c.m10538j(this.f26308s);
                C12414c c12414c10 = this.f26309t;
                c12414c.m10536h(c12414c10.f26153a, 0, c12414c10.f26154b);
            }
            C12412a c12412a3 = this.f26312w;
            if (c12412a3 != null) {
                c12412a3.m10519c(this.f26293d.m10637l("RuntimeVisibleTypeAnnotations"), c12414c);
            }
            C12412a c12412a4 = this.f26313x;
            if (c12412a4 != null) {
                c12412a4.m10519c(this.f26293d.m10637l("RuntimeInvisibleTypeAnnotations"), c12414c);
            }
        }
        if (this.f26314y > 0) {
            c12414c.m10538j(this.f26293d.m10637l("Exceptions"));
            c12414c.m10537i((this.f26314y * 2) + 2);
            c12414c.m10538j(this.f26314y);
            for (int i8 : this.f26315z) {
                c12414c.m10538j(i8);
            }
        }
        if ((4096 & this.f26294e) != 0 && z2) {
            C1643a.m878t0(this.f26293d, "Synthetic", c12414c, 0);
        }
        if (this.f26265A != 0) {
            C1643a.m878t0(this.f26293d, "Signature", c12414c, 2);
            c12414c.m10538j(this.f26265A);
        }
        if ((this.f26294e & 131072) != 0) {
            C1643a.m878t0(this.f26293d, "Deprecated", c12414c, 0);
        }
        C12412a c12412a5 = this.f26266B;
        if (c12412a5 != null) {
            c12412a5.m10519c(this.f26293d.m10637l("RuntimeVisibleAnnotations"), c12414c);
        }
        C12412a c12412a6 = this.f26267C;
        if (c12412a6 != null) {
            c12412a6.m10519c(this.f26293d.m10637l("RuntimeInvisibleAnnotations"), c12414c);
        }
        if (this.f26269E != null) {
            int iM10637l = this.f26293d.m10637l("RuntimeVisibleParameterAnnotations");
            C12412a[] c12412aArr = this.f26269E;
            int length = this.f26268D;
            if (length == 0) {
                length = c12412aArr.length;
            }
            C12412a.m10517d(iM10637l, c12412aArr, length, c12414c);
        }
        if (this.f26271G != null) {
            int iM10637l2 = this.f26293d.m10637l("RuntimeInvisibleParameterAnnotations");
            C12412a[] c12412aArr2 = this.f26271G;
            int length2 = this.f26270F;
            if (length2 == 0) {
                length2 = c12412aArr2.length;
            }
            C12412a.m10517d(iM10637l2, c12412aArr2, length2, c12414c);
        }
        C12412a c12412a7 = this.f26272H;
        if (c12412a7 != null) {
            c12412a7.m10519c(this.f26293d.m10637l("RuntimeVisibleTypeAnnotations"), c12414c);
        }
        C12412a c12412a8 = this.f26273I;
        if (c12412a8 != null) {
            c12412a8.m10519c(this.f26293d.m10637l("RuntimeInvisibleTypeAnnotations"), c12414c);
        }
        if (this.f26274J != null) {
            c12414c.m10538j(this.f26293d.m10637l("AnnotationDefault"));
            c12414c.m10537i(this.f26274J.f26154b);
            C12414c c12414c11 = this.f26274J;
            c12414c.m10536h(c12414c11.f26153a, 0, c12414c11.f26154b);
        }
        if (this.f26276L != null) {
            c12414c.m10538j(this.f26293d.m10637l("MethodParameters"));
            c12414c.m10537i(this.f26276L.f26154b + 1);
            c12414c.m10535g(this.f26275K);
            C12414c c12414c12 = this.f26276L;
            c12414c.m10536h(c12414c12.f26153a, 0, c12414c12.f26154b);
        }
        C12413b c12413b2 = this.f26277M;
        if (c12413b2 != null) {
            c12413b2.m10526d(this.f26293d, c12414c);
        }
    }

    /* JADX WARN: Code duplicated, block: B:29:0x007a  */
    /* JADX INFO: renamed from: z */
    public void m10620z() {
        char c;
        int[] iArr = this.f26286V;
        if (iArr != null) {
            if (this.f26311v == null) {
                this.f26311v = new C12414c();
            }
            int[] iArr2 = this.f26287W;
            int i = iArr2[1];
            int i2 = iArr2[2];
            if (this.f26293d.f26349c < 50) {
                C12414c c12414c = this.f26311v;
                c12414c.m10538j(iArr2[0]);
                c12414c.m10538j(i);
                int i3 = i + 3;
                m10617w(3, i3);
                this.f26311v.m10538j(i2);
                m10617w(i3, i2 + i3);
            } else {
                int i4 = this.f26310u == 0 ? iArr2[0] : (iArr2[0] - iArr[0]) - 1;
                int i5 = iArr[1];
                int i6 = i - i5;
                if (i2 == 0) {
                    switch (i6) {
                        case -3:
                        case -2:
                        case -1:
                            c = 248;
                            break;
                        case 0:
                            c = i4 < 64 ? (char) 0 : (char) 251;
                            break;
                        case 1:
                        case 2:
                        case 3:
                            c = 252;
                            break;
                        default:
                            c = 255;
                            break;
                    }
                } else if (i6 == 0 && i2 == 1) {
                    c = i4 < 63 ? MentionUtilsKt.MENTIONS_CHAR : (char) 247;
                } else {
                    c = 255;
                }
                if (c != 255) {
                    int i7 = 3;
                    for (int i8 = 0; i8 < i5 && i8 < i; i8++) {
                        if (this.f26287W[i7] != this.f26286V[i7]) {
                            c = 255;
                        } else {
                            i7++;
                        }
                    }
                }
                if (c == 0) {
                    this.f26311v.m10535g(i4);
                } else if (c == '@') {
                    this.f26311v.m10535g(i4 + 64);
                    m10617w(i + 3, i + 4);
                } else if (c == 247) {
                    C12414c c12414c2 = this.f26311v;
                    c12414c2.m10535g(247);
                    c12414c2.m10538j(i4);
                    m10617w(i + 3, i + 4);
                } else if (c == 248) {
                    C12414c c12414c3 = this.f26311v;
                    c12414c3.m10535g(i6 + 251);
                    c12414c3.m10538j(i4);
                } else if (c == 251) {
                    C12414c c12414c4 = this.f26311v;
                    c12414c4.m10535g(251);
                    c12414c4.m10538j(i4);
                } else if (c != 252) {
                    C12414c c12414c5 = this.f26311v;
                    c12414c5.m10535g(255);
                    c12414c5.m10538j(i4);
                    c12414c5.m10538j(i);
                    int i9 = i + 3;
                    m10617w(3, i9);
                    this.f26311v.m10538j(i2);
                    m10617w(i9, i2 + i9);
                } else {
                    C12414c c12414c6 = this.f26311v;
                    c12414c6.m10535g(i6 + 251);
                    c12414c6.m10538j(i4);
                    m10617w(i5 + 3, i + 3);
                }
            }
            this.f26310u++;
        }
        this.f26286V = this.f26287W;
        this.f26287W = null;
    }
}
