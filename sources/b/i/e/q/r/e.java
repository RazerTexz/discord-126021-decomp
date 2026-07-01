package b.i.e.q.r;

import b.i.a.f.e.o.f;
import b.i.e.k;
import b.i.e.l;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import org.objectweb.asm.Opcodes;

/* JADX INFO: compiled from: RSS14Reader.java */
/* JADX INFO: loaded from: classes3.dex */
public final class e extends a {
    public static final int[] g = {1, 10, 34, 70, 126};
    public static final int[] h = {4, 20, 48, 81};
    public static final int[] i = {0, Opcodes.IF_ICMPLT, 961, 2015, 2715};
    public static final int[] j = {0, 336, 1036, 1516};
    public static final int[] k = {8, 6, 4, 3, 1};
    public static final int[] l = {2, 4, 6, 8};
    public static final int[][] m = {new int[]{3, 8, 2, 1}, new int[]{3, 5, 5, 1}, new int[]{3, 3, 7, 1}, new int[]{3, 1, 9, 1}, new int[]{2, 7, 4, 1}, new int[]{2, 5, 6, 1}, new int[]{2, 3, 8, 1}, new int[]{1, 5, 7, 1}, new int[]{1, 3, 9, 1}};
    public final List<d> n = new ArrayList();
    public final List<d> o = new ArrayList();

    public static void k(Collection<d> collection, d dVar) {
        if (dVar == null) {
            return;
        }
        boolean z2 = false;
        for (d dVar2 : collection) {
            if (dVar2.a == dVar.a) {
                dVar2.d++;
                z2 = true;
                break;
            }
        }
        if (z2) {
            return;
        }
        collection.add(dVar);
    }

    @Override // b.i.e.q.k
    public Result b(int i2, b.i.e.n.a aVar, Map<b.i.e.d, ?> map) throws NotFoundException {
        k(this.n, m(aVar, false, i2, map));
        aVar.i();
        k(this.o, m(aVar, true, i2, map));
        aVar.i();
        for (d dVar : this.n) {
            if (dVar.d > 1) {
                for (d dVar2 : this.o) {
                    if (dVar2.d > 1) {
                        int i3 = ((dVar2.f1863b * 16) + dVar.f1863b) % 79;
                        int i4 = (dVar.c.a * 9) + dVar2.c.a;
                        if (i4 > 72) {
                            i4--;
                        }
                        if (i4 > 8) {
                            i4--;
                        }
                        if (i3 == i4) {
                            String strValueOf = String.valueOf((((long) dVar.a) * 4537077) + ((long) dVar2.a));
                            StringBuilder sb = new StringBuilder(14);
                            for (int length = 13 - strValueOf.length(); length > 0; length--) {
                                sb.append('0');
                            }
                            sb.append(strValueOf);
                            int i5 = 0;
                            for (int i6 = 0; i6 < 13; i6++) {
                                int iCharAt = sb.charAt(i6) - '0';
                                if ((i6 & 1) == 0) {
                                    iCharAt *= 3;
                                }
                                i5 += iCharAt;
                            }
                            int i7 = 10 - (i5 % 10);
                            if (i7 == 10) {
                                i7 = 0;
                            }
                            sb.append(i7);
                            k[] kVarArr = dVar.c.c;
                            k[] kVarArr2 = dVar2.c.c;
                            return new Result(sb.toString(), null, new k[]{kVarArr[0], kVarArr[1], kVarArr2[0], kVarArr2[1]}, b.i.e.a.RSS_14);
                        }
                    }
                }
            }
        }
        throw NotFoundException.l;
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
    public final b l(b.i.e.n.a aVar, c cVar, boolean z2) throws NotFoundException {
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        int[] iArr = this.f1862b;
        for (int i2 = 0; i2 < iArr.length; i2++) {
            iArr[i2] = 0;
        }
        if (z2) {
            b.i.e.q.k.f(aVar, cVar.f1864b[0], iArr);
        } else {
            b.i.e.q.k.e(aVar, cVar.f1864b[1] + 1, iArr);
            int i3 = 0;
            for (int length = iArr.length - 1; i3 < length; length--) {
                int i4 = iArr[i3];
                iArr[i3] = iArr[length];
                iArr[length] = i4;
                i3++;
            }
        }
        int i5 = z2 ? 16 : 15;
        float fH1 = f.h1(iArr) / i5;
        int[] iArr2 = this.e;
        int[] iArr3 = this.f;
        float[] fArr = this.c;
        float[] fArr2 = this.d;
        for (int i6 = 0; i6 < iArr.length; i6++) {
            float f = iArr[i6] / fH1;
            int i7 = (int) (0.5f + f);
            if (i7 <= 0) {
                i7 = 1;
            } else if (i7 > 8) {
                i7 = 8;
            }
            int i8 = i6 / 2;
            if ((i6 & 1) == 0) {
                iArr2[i8] = i7;
                fArr[i8] = f - i7;
            } else {
                iArr3[i8] = i7;
                fArr2[i8] = f - i7;
            }
        }
        int iH1 = f.h1(this.e);
        int iH2 = f.h1(this.f);
        if (z2) {
            if (iH1 > 12) {
                z3 = false;
                z4 = true;
            } else {
                z3 = iH1 < 4;
                z4 = false;
            }
            if (iH2 > 12) {
                z5 = false;
                z6 = true;
            } else {
                if (iH2 < 4) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                z6 = false;
            }
        } else {
            if (iH1 > 11) {
                z3 = false;
                z4 = true;
            } else {
                z3 = iH1 < 5;
                z4 = false;
            }
            if (iH2 > 10) {
                z5 = false;
                z6 = true;
            } else {
                if (iH2 < 4) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                z6 = false;
            }
        }
        int i9 = (iH1 + iH2) - i5;
        boolean z7 = (iH1 & 1) == z2;
        boolean z8 = (iH2 & 1) == 1;
        if (i9 == 1) {
            if (z7) {
                if (z8) {
                    throw NotFoundException.l;
                }
                z4 = true;
            } else {
                if (!z8) {
                    throw NotFoundException.l;
                }
                z6 = true;
            }
        } else if (i9 != -1) {
            if (i9 != 0) {
                throw NotFoundException.l;
            }
            if (z7) {
                if (!z8) {
                    throw NotFoundException.l;
                }
                if (iH1 < iH2) {
                    z3 = true;
                    z6 = true;
                } else {
                    z5 = true;
                    z4 = true;
                }
            } else if (z8) {
                throw NotFoundException.l;
            }
        } else if (z7) {
            if (z8) {
                throw NotFoundException.l;
            }
            z3 = true;
        } else {
            if (!z8) {
                throw NotFoundException.l;
            }
            z5 = true;
        }
        if (z3) {
            if (z4) {
                throw NotFoundException.l;
            }
            a.h(this.e, this.c);
        }
        if (z4) {
            a.g(this.e, this.c);
        }
        if (z5) {
            if (z6) {
                throw NotFoundException.l;
            }
            a.h(this.f, this.c);
        }
        if (z6) {
            a.g(this.f, this.d);
        }
        int i10 = 0;
        int i11 = 0;
        for (int length2 = iArr2.length - 1; length2 >= 0; length2--) {
            i10 = (i10 * 9) + iArr2[length2];
            i11 += iArr2[length2];
        }
        int i12 = 0;
        int i13 = 0;
        for (int length3 = iArr3.length - 1; length3 >= 0; length3--) {
            i12 = (i12 * 9) + iArr3[length3];
            i13 += iArr3[length3];
        }
        int i14 = (i12 * 3) + i10;
        if (!z2) {
            if ((i13 & 1) != 0 || i13 > 10 || i13 < 4) {
                throw NotFoundException.l;
            }
            int i15 = (10 - i13) / 2;
            int i16 = l[i15];
            return new b((f.p0(iArr3, 9 - i16, false) * h[i15]) + f.p0(iArr2, i16, true) + j[i15], i14);
        }
        if ((i11 & 1) != 0 || i11 > 12 || i11 < 4) {
            throw NotFoundException.l;
        }
        int i17 = (12 - i11) / 2;
        int i18 = k[i17];
        return new b((f.p0(iArr2, i18, false) * g[i17]) + f.p0(iArr3, 9 - i18, true) + i[i17], i14);
    }

    public final d m(b.i.e.n.a aVar, boolean z2, int i2, Map<b.i.e.d, ?> map) {
        try {
            int[] iArrN = n(aVar, z2);
            c cVarO = o(aVar, i2, z2, iArrN);
            l lVar = map == null ? null : (l) map.get(b.i.e.d.NEED_RESULT_POINT_CALLBACK);
            if (lVar != null) {
                float f = (iArrN[0] + iArrN[1]) / 2.0f;
                if (z2) {
                    f = (aVar.k - 1) - f;
                }
                lVar.a(new k(f, i2));
            }
            b bVarL = l(aVar, cVarO, true);
            b bVarL2 = l(aVar, cVarO, false);
            return new d((bVarL.a * 1597) + bVarL2.a, (bVarL2.f1863b * 4) + bVarL.f1863b, cVarO);
        } catch (NotFoundException unused) {
            return null;
        }
    }

    public final int[] n(b.i.e.n.a aVar, boolean z2) throws NotFoundException {
        int[] iArr = this.a;
        iArr[0] = 0;
        iArr[1] = 0;
        iArr[2] = 0;
        iArr[3] = 0;
        int i2 = aVar.k;
        int i3 = 0;
        boolean z3 = false;
        while (i3 < i2) {
            z3 = !aVar.b(i3);
            if (z2 == z3) {
                break;
            }
            i3++;
        }
        int i4 = i3;
        int i5 = 0;
        while (i3 < i2) {
            if (aVar.b(i3) != z3) {
                iArr[i5] = iArr[i5] + 1;
            } else {
                if (i5 != 3) {
                    i5++;
                } else {
                    if (a.i(iArr)) {
                        return new int[]{i4, i3};
                    }
                    i4 += iArr[0] + iArr[1];
                    iArr[0] = iArr[2];
                    iArr[1] = iArr[3];
                    iArr[2] = 0;
                    iArr[3] = 0;
                    i5--;
                }
                iArr[i5] = 1;
                z3 = !z3;
            }
            i3++;
        }
        throw NotFoundException.l;
    }

    public final c o(b.i.e.n.a aVar, int i2, boolean z2, int[] iArr) throws NotFoundException {
        int i3;
        int i4;
        boolean zB = aVar.b(iArr[0]);
        int i5 = iArr[0] - 1;
        while (i5 >= 0 && zB != aVar.b(i5)) {
            i5--;
        }
        int i6 = i5 + 1;
        int i7 = iArr[0] - i6;
        int[] iArr2 = this.a;
        System.arraycopy(iArr2, 0, iArr2, 1, iArr2.length - 1);
        iArr2[0] = i7;
        int iJ = a.j(iArr2, m);
        int i8 = iArr[1];
        if (z2) {
            int i9 = aVar.k;
            i3 = (i9 - 1) - i8;
            i4 = (i9 - 1) - i6;
        } else {
            i3 = i8;
            i4 = i6;
        }
        return new c(iJ, new int[]{i6, iArr[1]}, i4, i3, i2);
    }

    @Override // b.i.e.q.k, b.i.e.i
    public void reset() {
        this.n.clear();
        this.o.clear();
    }
}
