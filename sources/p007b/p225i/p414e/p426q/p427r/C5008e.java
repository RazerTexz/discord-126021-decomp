package p007b.p225i.p414e.p426q.p427r;

import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import org.objectweb.asm.Opcodes;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p007b.p225i.p414e.C4956k;
import p007b.p225i.p414e.EnumC4946a;
import p007b.p225i.p414e.EnumC4949d;
import p007b.p225i.p414e.InterfaceC4957l;
import p007b.p225i.p414e.p418n.C4962a;
import p007b.p225i.p414e.p426q.AbstractC4997k;

/* JADX INFO: renamed from: b.i.e.q.r.e */
/* JADX INFO: compiled from: RSS14Reader.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C5008e extends AbstractC5004a {

    /* JADX INFO: renamed from: g */
    public static final int[] f13412g = {1, 10, 34, 70, 126};

    /* JADX INFO: renamed from: h */
    public static final int[] f13413h = {4, 20, 48, 81};

    /* JADX INFO: renamed from: i */
    public static final int[] f13414i = {0, Opcodes.IF_ICMPLT, 961, 2015, 2715};

    /* JADX INFO: renamed from: j */
    public static final int[] f13415j = {0, 336, 1036, 1516};

    /* JADX INFO: renamed from: k */
    public static final int[] f13416k = {8, 6, 4, 3, 1};

    /* JADX INFO: renamed from: l */
    public static final int[] f13417l = {2, 4, 6, 8};

    /* JADX INFO: renamed from: m */
    public static final int[][] f13418m = {new int[]{3, 8, 2, 1}, new int[]{3, 5, 5, 1}, new int[]{3, 3, 7, 1}, new int[]{3, 1, 9, 1}, new int[]{2, 7, 4, 1}, new int[]{2, 5, 6, 1}, new int[]{2, 3, 8, 1}, new int[]{1, 5, 7, 1}, new int[]{1, 3, 9, 1}};

    /* JADX INFO: renamed from: n */
    public final List<C5007d> f13419n = new ArrayList();

    /* JADX INFO: renamed from: o */
    public final List<C5007d> f13420o = new ArrayList();

    /* JADX INFO: renamed from: k */
    public static void m7013k(Collection<C5007d> collection, C5007d c5007d) {
        if (c5007d == null) {
            return;
        }
        boolean z2 = false;
        for (C5007d c5007d2 : collection) {
            if (c5007d2.f13405a == c5007d.f13405a) {
                c5007d2.f13411d++;
                z2 = true;
                break;
            }
        }
        if (z2) {
            return;
        }
        collection.add(c5007d);
    }

    @Override // p007b.p225i.p414e.p426q.AbstractC4997k
    /* JADX INFO: renamed from: b */
    public Result mo6983b(int i, C4962a c4962a, Map<EnumC4949d, ?> map) throws NotFoundException {
        m7013k(this.f13419n, m7015m(c4962a, false, i, map));
        c4962a.m6939i();
        m7013k(this.f13420o, m7015m(c4962a, true, i, map));
        c4962a.m6939i();
        for (C5007d c5007d : this.f13419n) {
            if (c5007d.f13411d > 1) {
                for (C5007d c5007d2 : this.f13420o) {
                    if (c5007d2.f13411d > 1) {
                        int i2 = ((c5007d2.f13406b * 16) + c5007d.f13406b) % 79;
                        int i3 = (c5007d.f13410c.f13407a * 9) + c5007d2.f13410c.f13407a;
                        if (i3 > 72) {
                            i3--;
                        }
                        if (i3 > 8) {
                            i3--;
                        }
                        if (i2 == i3) {
                            String strValueOf = String.valueOf((((long) c5007d.f13405a) * 4537077) + ((long) c5007d2.f13405a));
                            StringBuilder sb = new StringBuilder(14);
                            for (int length = 13 - strValueOf.length(); length > 0; length--) {
                                sb.append('0');
                            }
                            sb.append(strValueOf);
                            int i4 = 0;
                            for (int i5 = 0; i5 < 13; i5++) {
                                int iCharAt = sb.charAt(i5) - '0';
                                if ((i5 & 1) == 0) {
                                    iCharAt *= 3;
                                }
                                i4 += iCharAt;
                            }
                            int i6 = 10 - (i4 % 10);
                            if (i6 == 10) {
                                i6 = 0;
                            }
                            sb.append(i6);
                            C4956k[] c4956kArr = c5007d.f13410c.f13409c;
                            C4956k[] c4956kArr2 = c5007d2.f13410c.f13409c;
                            return new Result(sb.toString(), null, new C4956k[]{c4956kArr[0], c4956kArr[1], c4956kArr2[0], c4956kArr2[1]}, EnumC4946a.RSS_14);
                        }
                    }
                }
            }
        }
        throw NotFoundException.f21665l;
    }

    /* JADX WARN: Code duplicated, block: B:49:0x00af A[PHI: r12 r13
      0x00af: PHI (r12v8 boolean) = (r12v6 boolean), (r12v20 boolean) binds: [B:48:0x00ad, B:36:0x0099] A[DONT_GENERATE, DONT_INLINE]
      0x00af: PHI (r13v3 boolean) = (r13v1 boolean), (r13v11 boolean) binds: [B:48:0x00ad, B:36:0x0099] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:51:0x00b4 A[PHI: r12 r13
      0x00b4: PHI (r12v9 boolean) = (r12v6 boolean), (r12v20 boolean) binds: [B:50:0x00b2, B:38:0x009c] A[DONT_GENERATE, DONT_INLINE]
      0x00b4: PHI (r13v4 boolean) = (r13v1 boolean), (r13v11 boolean) binds: [B:50:0x00b2, B:38:0x009c] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:52:0x00b6 A[PHI: r12 r13
      0x00b6: PHI (r12v16 boolean) = (r12v6 boolean), (r12v20 boolean) binds: [B:50:0x00b2, B:38:0x009c] A[DONT_GENERATE, DONT_INLINE]
      0x00b6: PHI (r13v9 boolean) = (r13v1 boolean), (r13v11 boolean) binds: [B:50:0x00b2, B:38:0x009c] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX INFO: renamed from: l */
    public final C5005b m7014l(C4962a c4962a, C5006c c5006c, boolean z2) throws NotFoundException {
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        int[] iArr = this.f13400b;
        for (int i = 0; i < iArr.length; i++) {
            iArr[i] = 0;
        }
        if (z2) {
            AbstractC4997k.m6998f(c4962a, c5006c.f13408b[0], iArr);
        } else {
            AbstractC4997k.m6997e(c4962a, c5006c.f13408b[1] + 1, iArr);
            int i2 = 0;
            for (int length = iArr.length - 1; i2 < length; length--) {
                int i3 = iArr[i2];
                iArr[i2] = iArr[length];
                iArr[length] = i3;
                i2++;
            }
        }
        int i4 = z2 ? 16 : 15;
        float fM4297h1 = C3404f.m4297h1(iArr) / i4;
        int[] iArr2 = this.f13403e;
        int[] iArr3 = this.f13404f;
        float[] fArr = this.f13401c;
        float[] fArr2 = this.f13402d;
        for (int i5 = 0; i5 < iArr.length; i5++) {
            float f = iArr[i5] / fM4297h1;
            int i6 = (int) (0.5f + f);
            if (i6 <= 0) {
                i6 = 1;
            } else if (i6 > 8) {
                i6 = 8;
            }
            int i7 = i5 / 2;
            if ((i5 & 1) == 0) {
                iArr2[i7] = i6;
                fArr[i7] = f - i6;
            } else {
                iArr3[i7] = i6;
                fArr2[i7] = f - i6;
            }
        }
        int iM4297h1 = C3404f.m4297h1(this.f13403e);
        int iM4297h2 = C3404f.m4297h1(this.f13404f);
        if (z2) {
            if (iM4297h1 > 12) {
                z3 = false;
                z4 = true;
            } else {
                z3 = iM4297h1 < 4;
                z4 = false;
            }
            if (iM4297h2 > 12) {
                z5 = false;
                z6 = true;
            } else {
                if (iM4297h2 < 4) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                z6 = false;
            }
        } else {
            if (iM4297h1 > 11) {
                z3 = false;
                z4 = true;
            } else {
                z3 = iM4297h1 < 5;
                z4 = false;
            }
            if (iM4297h2 > 10) {
                z5 = false;
                z6 = true;
            } else {
                if (iM4297h2 < 4) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                z6 = false;
            }
        }
        int i8 = (iM4297h1 + iM4297h2) - i4;
        boolean z7 = (iM4297h1 & 1) == z2;
        boolean z8 = (iM4297h2 & 1) == 1;
        if (i8 == 1) {
            if (z7) {
                if (z8) {
                    throw NotFoundException.f21665l;
                }
                z4 = true;
            } else {
                if (!z8) {
                    throw NotFoundException.f21665l;
                }
                z6 = true;
            }
        } else if (i8 != -1) {
            if (i8 != 0) {
                throw NotFoundException.f21665l;
            }
            if (z7) {
                if (!z8) {
                    throw NotFoundException.f21665l;
                }
                if (iM4297h1 < iM4297h2) {
                    z3 = true;
                    z6 = true;
                } else {
                    z5 = true;
                    z4 = true;
                }
            } else if (z8) {
                throw NotFoundException.f21665l;
            }
        } else if (z7) {
            if (z8) {
                throw NotFoundException.f21665l;
            }
            z3 = true;
        } else {
            if (!z8) {
                throw NotFoundException.f21665l;
            }
            z5 = true;
        }
        if (z3) {
            if (z4) {
                throw NotFoundException.f21665l;
            }
            AbstractC5004a.m7010h(this.f13403e, this.f13401c);
        }
        if (z4) {
            AbstractC5004a.m7009g(this.f13403e, this.f13401c);
        }
        if (z5) {
            if (z6) {
                throw NotFoundException.f21665l;
            }
            AbstractC5004a.m7010h(this.f13404f, this.f13401c);
        }
        if (z6) {
            AbstractC5004a.m7009g(this.f13404f, this.f13402d);
        }
        int i9 = 0;
        int i10 = 0;
        for (int length2 = iArr2.length - 1; length2 >= 0; length2--) {
            i9 = (i9 * 9) + iArr2[length2];
            i10 += iArr2[length2];
        }
        int i11 = 0;
        int i12 = 0;
        for (int length3 = iArr3.length - 1; length3 >= 0; length3--) {
            i11 = (i11 * 9) + iArr3[length3];
            i12 += iArr3[length3];
        }
        int i13 = (i11 * 3) + i9;
        if (!z2) {
            if ((i12 & 1) != 0 || i12 > 10 || i12 < 4) {
                throw NotFoundException.f21665l;
            }
            int i14 = (10 - i12) / 2;
            int i15 = f13417l[i14];
            return new C5005b((C3404f.m4328p0(iArr3, 9 - i15, false) * f13413h[i14]) + C3404f.m4328p0(iArr2, i15, true) + f13415j[i14], i13);
        }
        if ((i10 & 1) != 0 || i10 > 12 || i10 < 4) {
            throw NotFoundException.f21665l;
        }
        int i16 = (12 - i10) / 2;
        int i17 = f13416k[i16];
        return new C5005b((C3404f.m4328p0(iArr2, i17, false) * f13412g[i16]) + C3404f.m4328p0(iArr3, 9 - i17, true) + f13414i[i16], i13);
    }

    /* JADX INFO: renamed from: m */
    public final C5007d m7015m(C4962a c4962a, boolean z2, int i, Map<EnumC4949d, ?> map) {
        try {
            int[] iArrM7016n = m7016n(c4962a, z2);
            C5006c c5006cM7017o = m7017o(c4962a, i, z2, iArrM7016n);
            InterfaceC4957l interfaceC4957l = map == null ? null : (InterfaceC4957l) map.get(EnumC4949d.NEED_RESULT_POINT_CALLBACK);
            if (interfaceC4957l != null) {
                float f = (iArrM7016n[0] + iArrM7016n[1]) / 2.0f;
                if (z2) {
                    f = (c4962a.f13228k - 1) - f;
                }
                interfaceC4957l.m6924a(new C4956k(f, i));
            }
            C5005b c5005bM7014l = m7014l(c4962a, c5006cM7017o, true);
            C5005b c5005bM7014l2 = m7014l(c4962a, c5006cM7017o, false);
            return new C5007d((c5005bM7014l.f13405a * 1597) + c5005bM7014l2.f13405a, (c5005bM7014l2.f13406b * 4) + c5005bM7014l.f13406b, c5006cM7017o);
        } catch (NotFoundException unused) {
            return null;
        }
    }

    /* JADX INFO: renamed from: n */
    public final int[] m7016n(C4962a c4962a, boolean z2) throws NotFoundException {
        int[] iArr = this.f13399a;
        iArr[0] = 0;
        iArr[1] = 0;
        iArr[2] = 0;
        iArr[3] = 0;
        int i = c4962a.f13228k;
        int i2 = 0;
        boolean z3 = false;
        while (i2 < i) {
            z3 = !c4962a.m6935b(i2);
            if (z2 == z3) {
                break;
            }
            i2++;
        }
        int i3 = i2;
        int i4 = 0;
        while (i2 < i) {
            if (c4962a.m6935b(i2) != z3) {
                iArr[i4] = iArr[i4] + 1;
            } else {
                if (i4 != 3) {
                    i4++;
                } else {
                    if (AbstractC5004a.m7011i(iArr)) {
                        return new int[]{i3, i2};
                    }
                    i3 += iArr[0] + iArr[1];
                    iArr[0] = iArr[2];
                    iArr[1] = iArr[3];
                    iArr[2] = 0;
                    iArr[3] = 0;
                    i4--;
                }
                iArr[i4] = 1;
                z3 = !z3;
            }
            i2++;
        }
        throw NotFoundException.f21665l;
    }

    /* JADX INFO: renamed from: o */
    public final C5006c m7017o(C4962a c4962a, int i, boolean z2, int[] iArr) throws NotFoundException {
        int i2;
        int i3;
        boolean zM6935b = c4962a.m6935b(iArr[0]);
        int i4 = iArr[0] - 1;
        while (i4 >= 0 && zM6935b != c4962a.m6935b(i4)) {
            i4--;
        }
        int i5 = i4 + 1;
        int i6 = iArr[0] - i5;
        int[] iArr2 = this.f13399a;
        System.arraycopy(iArr2, 0, iArr2, 1, iArr2.length - 1);
        iArr2[0] = i6;
        int iM7012j = AbstractC5004a.m7012j(iArr2, f13418m);
        int i7 = iArr[1];
        if (z2) {
            int i8 = c4962a.f13228k;
            i2 = (i8 - 1) - i7;
            i3 = (i8 - 1) - i5;
        } else {
            i2 = i7;
            i3 = i5;
        }
        return new C5006c(iM7012j, new int[]{i5, iArr[1]}, i3, i2, i);
    }

    @Override // p007b.p225i.p414e.p426q.AbstractC4997k, p007b.p225i.p414e.InterfaceC4954i
    public void reset() {
        this.f13419n.clear();
        this.f13420o.clear();
    }
}
