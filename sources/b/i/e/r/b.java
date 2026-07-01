package b.i.e.r;

import b.i.e.d;
import b.i.e.i;
import b.i.e.k;
import b.i.e.n.e;
import b.i.e.r.d.f;
import b.i.e.r.d.g;
import b.i.e.r.d.h;
import b.i.e.r.d.j;
import com.google.zxing.ChecksumException;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: PDF417Reader.java */
/* JADX INFO: loaded from: classes3.dex */
public final class b implements i {
    public static int b(k kVar, k kVar2) {
        if (kVar == null || kVar2 == null) {
            return 0;
        }
        return (int) Math.abs(kVar.a - kVar2.a);
    }

    public static int c(k kVar, k kVar2) {
        if (kVar == null || kVar2 == null) {
            return Integer.MAX_VALUE;
        }
        return (int) Math.abs(kVar.a - kVar2.a);
    }

    /* JADX WARN: Code duplicated, block: B:134:0x02bf  */
    /* JADX WARN: Code duplicated, block: B:136:0x02c2  */
    /* JADX WARN: Code duplicated, block: B:139:0x02e8  */
    /* JADX WARN: Code duplicated, block: B:140:0x030b  */
    /* JADX WARN: Code duplicated, block: B:141:0x0310  */
    /* JADX WARN: Code duplicated, block: B:39:0x0163  */
    /* JADX WARN: Code duplicated, block: B:42:0x016c  */
    @Override // b.i.e.i
    public Result a(b.i.e.c cVar, Map<d, ?> map) throws NotFoundException, ChecksumException, FormatException {
        b.i.e.r.d.c cVar2;
        f fVar;
        int i;
        boolean z2;
        e eVarB;
        int i2;
        Iterator<k[]> it;
        b.i.e.r.d.c cVar3;
        int i3;
        b.i.e.r.d.d dVar;
        int i4;
        int i5;
        int i6;
        g gVar;
        int i7;
        int i8;
        int i9;
        b.i.e.r.d.c cVar4;
        int i10;
        int i11;
        int i12;
        b.i.e.r.d.d dVarC;
        b.i.e.r.d.a aVarC;
        b.i.e.r.d.a aVarC2;
        ArrayList arrayList = new ArrayList();
        b.i.e.n.b bVarA = cVar.a();
        char c = 0;
        List<k[]> listA = b.i.e.r.e.a.a(false, bVarA);
        int i13 = 2;
        if (((ArrayList) listA).isEmpty()) {
            int i14 = bVarA.j;
            int i15 = bVarA.k;
            b.i.e.n.b bVar = new b.i.e.n.b(i14, i15, bVarA.l, (int[]) bVarA.m.clone());
            b.i.e.n.a aVar = new b.i.e.n.a(i14);
            b.i.e.n.a aVar2 = new b.i.e.n.a(i14);
            for (int i16 = 0; i16 < (i15 + 1) / 2; i16++) {
                aVar = bVar.h(i16, aVar);
                int i17 = (i15 - 1) - i16;
                aVar2 = bVar.h(i17, aVar2);
                aVar.i();
                aVar2.i();
                int[] iArr = aVar2.j;
                int[] iArr2 = bVar.m;
                int i18 = bVar.l;
                System.arraycopy(iArr, 0, iArr2, i16 * i18, i18);
                int[] iArr3 = aVar.j;
                int[] iArr4 = bVar.m;
                int i19 = bVar.l;
                System.arraycopy(iArr3, 0, iArr4, i17 * i19, i19);
            }
            listA = b.i.e.r.e.a.a(false, bVar);
            bVarA = bVar;
        }
        Iterator<k[]> it2 = listA.iterator();
        while (it2.hasNext()) {
            k[] next = it2.next();
            k kVar = next[4];
            k kVar2 = next[5];
            k kVar3 = next[6];
            k kVar4 = next[7];
            int iMin = Math.min(Math.min(c(next[c], next[4]), (c(next[6], next[i13]) * 17) / 18), Math.min(c(next[1], next[5]), (c(next[7], next[3]) * 17) / 18));
            int iMax = Math.max(Math.max(b(next[c], next[4]), (b(next[6], next[i13]) * 17) / 18), Math.max(b(next[1], next[5]), (b(next[7], next[3]) * 17) / 18));
            b.i.e.r.d.k.a aVar3 = j.a;
            b.i.e.r.d.c cVar5 = new b.i.e.r.d.c(bVarA, kVar, kVar2, kVar3, kVar4);
            f fVar2 = null;
            h hVarD = null;
            h hVarD2 = null;
            int i20 = 0;
            while (true) {
                if (i20 >= i13) {
                    cVar2 = cVar5;
                    fVar = fVar2;
                    break;
                }
                if (kVar != null) {
                    hVarD = j.d(bVarA, cVar5, kVar, true, iMin, iMax);
                }
                h hVar = hVarD;
                if (kVar3 != null) {
                    hVarD2 = j.d(bVarA, cVar5, kVar3, false, iMin, iMax);
                }
                if (hVar == null && hVarD2 == null) {
                    fVar2 = null;
                } else {
                    if (hVar == null || (aVarC = hVar.c()) == null) {
                        if (hVarD2 == null) {
                            aVarC = null;
                        } else {
                            aVarC = hVarD2.c();
                        }
                    } else if (hVarD2 != null && (aVarC2 = hVarD2.c()) != null && aVarC.a != aVarC2.a && aVarC.f1876b != aVarC2.f1876b && aVarC.e != aVarC2.e) {
                        aVarC = null;
                    }
                    if (aVarC == null) {
                        fVar2 = null;
                    } else {
                        b.i.e.r.d.c cVarA = j.a(hVar);
                        b.i.e.r.d.c cVarA2 = j.a(hVarD2);
                        if (cVarA == null) {
                            cVarA = cVarA2;
                        } else if (cVarA2 != null) {
                            cVarA = new b.i.e.r.d.c(cVarA.a, cVarA.f1877b, cVarA.c, cVarA2.d, cVarA2.e);
                        }
                        fVar2 = new f(aVarC, cVarA);
                    }
                }
                if (fVar2 == null) {
                    throw NotFoundException.l;
                }
                if (i20 != 0 || (cVar5 = fVar2.c) == null) {
                    cVar2 = cVar5;
                } else {
                    cVar2 = cVar5;
                    if (cVar5.h < cVar2.h || cVar5.i > cVar2.i) {
                        i20++;
                        hVarD = hVar;
                        i13 = 2;
                    }
                }
                fVar2.c = cVar2;
                fVar = fVar2;
                hVarD = hVar;
                break;
            }
            int i21 = fVar.d + 1;
            g[] gVarArr = fVar.f1880b;
            gVarArr[c] = hVarD;
            gVarArr[i21] = hVarD2;
            boolean z3 = hVarD != null;
            int i22 = iMin;
            int i23 = 1;
            while (i23 <= i21) {
                int i24 = z3 ? i23 : i21 - i23;
                if (fVar.f1880b[i24] == null) {
                    g hVar2 = (i24 == 0 || i24 == i21) ? new h(cVar2, i24 == 0) : new g(cVar2);
                    fVar.f1880b[i24] = hVar2;
                    int i25 = cVar2.h;
                    int i26 = i22;
                    int iMax2 = iMax;
                    int i27 = -1;
                    while (i25 <= cVar2.i) {
                        int i28 = z3 ? 1 : -1;
                        int i29 = i24 - i28;
                        if (j.e(fVar, i29)) {
                            g gVar2 = fVar.f1880b[i29];
                            dVar = gVar2.f1881b[i25 - gVar2.a.h];
                        } else {
                            dVar = null;
                        }
                        if (dVar != null) {
                            i5 = z3 ? dVar.f1878b : dVar.a;
                        } else {
                            b.i.e.r.d.d dVarA = fVar.f1880b[i24].a(i25);
                            if (dVarA != null) {
                                i5 = z3 ? dVarA.a : dVarA.f1878b;
                            } else {
                                if (j.e(fVar, i29)) {
                                    dVarA = fVar.f1880b[i29].a(i25);
                                }
                                if (dVarA == null) {
                                    int i30 = i24;
                                    int i31 = 0;
                                    while (true) {
                                        int i32 = i30 - i28;
                                        if (!j.e(fVar, i32)) {
                                            i4 = i25;
                                            if (!z3) {
                                                i5 = fVar.c.g;
                                                break;
                                            }
                                            i5 = fVar.c.f;
                                            break;
                                        }
                                        b.i.e.r.d.d[] dVarArr = fVar.f1880b[i32].f1881b;
                                        int length = dVarArr.length;
                                        i4 = i25;
                                        int i33 = 0;
                                        while (i33 < length) {
                                            int i34 = length;
                                            b.i.e.r.d.d dVar2 = dVarArr[i33];
                                            if (dVar2 != null) {
                                                i5 = ((dVar2.f1878b - dVar2.a) * i28 * i31) + (z3 ? dVar2.f1878b : dVar2.a);
                                                break;
                                            }
                                            i33++;
                                            length = i34;
                                        }
                                        i31++;
                                        i30 = i32;
                                        i25 = i4;
                                    }
                                } else {
                                    i5 = z3 ? dVarA.f1878b : dVarA.a;
                                }
                                if (i5 >= 0 || i5 > cVar2.g) {
                                    if (i27 != -1) {
                                        i10 = i27;
                                    } else {
                                        i6 = i26;
                                        gVar = hVar2;
                                        i7 = i24;
                                        i8 = i21;
                                        iMax2 = iMax2;
                                        i9 = i4;
                                        cVar4 = cVar2;
                                    }
                                    i26 = i6;
                                    i25 = i9 + 1;
                                    hVar2 = gVar;
                                    it2 = it2;
                                    cVar2 = cVar4;
                                    i24 = i7;
                                    i21 = i8;
                                } else {
                                    i10 = i5;
                                }
                                i11 = iMax2;
                                i9 = i4;
                                i12 = i26;
                                cVar4 = cVar2;
                                i7 = i24;
                                gVar = hVar2;
                                i8 = i21;
                                dVarC = j.c(bVarA, cVar2.f, cVar2.g, z3, i10, i9, i12, i11);
                                if (dVarC != null) {
                                    gVar.f1881b[i9 - gVar.a.h] = dVarC;
                                    int iMin2 = Math.min(i12, dVarC.f1878b - dVarC.a);
                                    iMax2 = Math.max(i11, dVarC.f1878b - dVarC.a);
                                    i26 = iMin2;
                                    i27 = i10;
                                } else {
                                    iMax2 = i11;
                                    i6 = i12;
                                    i26 = i6;
                                }
                                i25 = i9 + 1;
                                hVar2 = gVar;
                                it2 = it2;
                                cVar2 = cVar4;
                                i24 = i7;
                                i21 = i8;
                            }
                        }
                        i4 = i25;
                        if (i5 >= 0) {
                            if (i27 != -1) {
                                i10 = i27;
                                i11 = iMax2;
                                i9 = i4;
                                i12 = i26;
                                cVar4 = cVar2;
                                i7 = i24;
                                gVar = hVar2;
                                i8 = i21;
                                dVarC = j.c(bVarA, cVar2.f, cVar2.g, z3, i10, i9, i12, i11);
                                if (dVarC != null) {
                                    gVar.f1881b[i9 - gVar.a.h] = dVarC;
                                    int iMin3 = Math.min(i12, dVarC.f1878b - dVarC.a);
                                    iMax2 = Math.max(i11, dVarC.f1878b - dVarC.a);
                                    i26 = iMin3;
                                    i27 = i10;
                                } else {
                                    iMax2 = i11;
                                    i6 = i12;
                                }
                                i25 = i9 + 1;
                                hVar2 = gVar;
                                it2 = it2;
                                cVar2 = cVar4;
                                i24 = i7;
                                i21 = i8;
                            } else {
                                i6 = i26;
                                gVar = hVar2;
                                i7 = i24;
                                i8 = i21;
                                iMax2 = iMax2;
                                i9 = i4;
                                cVar4 = cVar2;
                            }
                        } else if (i27 != -1) {
                            i10 = i27;
                            i11 = iMax2;
                            i9 = i4;
                            i12 = i26;
                            cVar4 = cVar2;
                            i7 = i24;
                            gVar = hVar2;
                            i8 = i21;
                            dVarC = j.c(bVarA, cVar2.f, cVar2.g, z3, i10, i9, i12, i11);
                            if (dVarC != null) {
                                gVar.f1881b[i9 - gVar.a.h] = dVarC;
                                int iMin4 = Math.min(i12, dVarC.f1878b - dVarC.a);
                                iMax2 = Math.max(i11, dVarC.f1878b - dVarC.a);
                                i26 = iMin4;
                                i27 = i10;
                            } else {
                                iMax2 = i11;
                                i6 = i12;
                            }
                            i25 = i9 + 1;
                            hVar2 = gVar;
                            it2 = it2;
                            cVar2 = cVar4;
                            i24 = i7;
                            i21 = i8;
                        } else {
                            i6 = i26;
                            gVar = hVar2;
                            i7 = i24;
                            i8 = i21;
                            iMax2 = iMax2;
                            i9 = i4;
                            cVar4 = cVar2;
                        }
                        i26 = i6;
                        i25 = i9 + 1;
                        hVar2 = gVar;
                        it2 = it2;
                        cVar2 = cVar4;
                        i24 = i7;
                        i21 = i8;
                    }
                    it = it2;
                    cVar3 = cVar2;
                    i3 = i21;
                    iMax = iMax2;
                    i22 = i26;
                } else {
                    it = it2;
                    cVar3 = cVar2;
                    i3 = i21;
                }
                i23++;
                it2 = it;
                cVar2 = cVar3;
                i21 = i3;
            }
            Iterator<k[]> it3 = it2;
            b.i.e.r.d.b[][] bVarArr = (b.i.e.r.d.b[][]) Array.newInstance((Class<?>) b.i.e.r.d.b.class, fVar.a.e, fVar.d + 2);
            for (int i35 = 0; i35 < bVarArr.length; i35++) {
                for (int i36 = 0; i36 < bVarArr[i35].length; i36++) {
                    bVarArr[i35][i36] = new b.i.e.r.d.b();
                }
            }
            char c2 = 0;
            fVar.a(fVar.f1880b[0]);
            int i37 = 1;
            fVar.a(fVar.f1880b[fVar.d + 1]);
            int i38 = 928;
            while (true) {
                g[] gVarArr2 = fVar.f1880b;
                if (gVarArr2[c2] != null) {
                    int i39 = fVar.d + i37;
                    if (gVarArr2[i39] != null) {
                        b.i.e.r.d.d[] dVarArr2 = gVarArr2[c2].f1881b;
                        b.i.e.r.d.d[] dVarArr3 = gVarArr2[i39].f1881b;
                        for (int i40 = 0; i40 < dVarArr2.length; i40++) {
                            if (dVarArr2[i40] != null && dVarArr3[i40] != null && dVarArr2[i40].e == dVarArr3[i40].e) {
                                for (int i41 = 1; i41 <= fVar.d; i41++) {
                                    b.i.e.r.d.d dVar3 = fVar.f1880b[i41].f1881b[i40];
                                    if (dVar3 != null) {
                                        dVar3.e = dVarArr2[i40].e;
                                        if (!dVar3.a()) {
                                            fVar.f1880b[i41].f1881b[i40] = null;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                g[] gVarArr3 = fVar.f1880b;
                int i42 = 0;
                if (gVarArr3[0] != null) {
                    b.i.e.r.d.d[] dVarArr4 = gVarArr3[0].f1881b;
                    int i43 = 0;
                    for (int i44 = 0; i44 < dVarArr4.length; i44++) {
                        if (dVarArr4[i44] != null) {
                            int i45 = dVarArr4[i44].e;
                            int i46 = i43;
                            int iB = 0;
                            for (int i47 = 1; i47 < fVar.d + 1 && iB < 2; i47++) {
                                b.i.e.r.d.d dVar4 = fVar.f1880b[i47].f1881b[i44];
                                if (dVar4 != null) {
                                    iB = f.b(i45, iB, dVar4);
                                    if (!dVar4.a()) {
                                        i46++;
                                    }
                                }
                            }
                            i43 = i46;
                        }
                    }
                    i42 = i43;
                }
                g[] gVarArr4 = fVar.f1880b;
                int i48 = fVar.d + 1;
                if (gVarArr4[i48] == null) {
                    i = 0;
                } else {
                    b.i.e.r.d.d[] dVarArr5 = gVarArr4[i48].f1881b;
                    i = 0;
                    for (int i49 = 0; i49 < dVarArr5.length; i49++) {
                        if (dVarArr5[i49] != null) {
                            int i50 = dVarArr5[i49].e;
                            int i51 = i;
                            int iB2 = 0;
                            for (int i52 = fVar.d + 1; i52 > 0 && iB2 < 2; i52--) {
                                b.i.e.r.d.d dVar5 = fVar.f1880b[i52].f1881b[i49];
                                if (dVar5 != null) {
                                    iB2 = f.b(i50, iB2, dVar5);
                                    if (!dVar5.a()) {
                                        i51++;
                                    }
                                }
                            }
                            i = i51;
                        }
                    }
                }
                int i53 = i42 + i;
                if (i53 == 0) {
                    i53 = 0;
                } else {
                    for (int i54 = 1; i54 < fVar.d + 1; i54++) {
                        b.i.e.r.d.d[] dVarArr6 = fVar.f1880b[i54].f1881b;
                        for (int i55 = 0; i55 < dVarArr6.length; i55++) {
                            if (dVarArr6[i55] != null && !dVarArr6[i55].a()) {
                                b.i.e.r.d.d dVar6 = dVarArr6[i55];
                                g[] gVarArr5 = fVar.f1880b;
                                b.i.e.r.d.d[] dVarArr7 = gVarArr5[i54 - 1].f1881b;
                                int i56 = i54 + 1;
                                b.i.e.r.d.d[] dVarArr8 = gVarArr5[i56] != null ? gVarArr5[i56].f1881b : dVarArr7;
                                b.i.e.r.d.d[] dVarArr9 = new b.i.e.r.d.d[14];
                                dVarArr9[2] = dVarArr7[i55];
                                dVarArr9[3] = dVarArr8[i55];
                                if (i55 > 0) {
                                    int i57 = i55 - 1;
                                    dVarArr9[0] = dVarArr6[i57];
                                    dVarArr9[4] = dVarArr7[i57];
                                    dVarArr9[5] = dVarArr8[i57];
                                }
                                if (i55 > 1) {
                                    int i58 = i55 - 2;
                                    dVarArr9[8] = dVarArr6[i58];
                                    dVarArr9[10] = dVarArr7[i58];
                                    dVarArr9[11] = dVarArr8[i58];
                                }
                                if (i55 < dVarArr6.length - 1) {
                                    int i59 = i55 + 1;
                                    dVarArr9[1] = dVarArr6[i59];
                                    dVarArr9[6] = dVarArr7[i59];
                                    dVarArr9[7] = dVarArr8[i59];
                                }
                                if (i55 < dVarArr6.length - 2) {
                                    int i60 = i55 + 2;
                                    dVarArr9[9] = dVarArr6[i60];
                                    dVarArr9[12] = dVarArr7[i60];
                                    dVarArr9[13] = dVarArr8[i60];
                                }
                                int i61 = 0;
                                for (int i62 = 14; i61 < i62; i62 = 14) {
                                    b.i.e.r.d.d dVar7 = dVarArr9[i61];
                                    if (dVar7 != null && dVar7.a() && dVar7.c == dVar6.c) {
                                        dVar6.e = dVar7.e;
                                        z2 = true;
                                    } else {
                                        z2 = false;
                                    }
                                    if (z2) {
                                        break;
                                    }
                                    i61++;
                                }
                            }
                        }
                    }
                }
                if (i53 <= 0 || i53 >= i38) {
                    break;
                }
                i38 = i53;
                c2 = 0;
                i37 = 1;
            }
            int i63 = 0;
            for (g gVar3 : fVar.f1880b) {
                if (gVar3 != null) {
                    for (b.i.e.r.d.d dVar8 : gVar3.f1881b) {
                        if (dVar8 != null && (i2 = dVar8.e) >= 0 && i2 < bVarArr.length) {
                            bVarArr[i2][i63].b(dVar8.d);
                        }
                    }
                }
                i63++;
            }
            b.i.e.r.d.b bVar2 = bVarArr[0][1];
            int[] iArrA = bVar2.a();
            int i64 = fVar.d;
            b.i.e.r.d.a aVar4 = fVar.a;
            int i65 = (i64 * aVar4.e) - (2 << aVar4.f1876b);
            if (iArrA.length == 0) {
                if (i65 <= 0 || i65 > 928) {
                    throw NotFoundException.l;
                }
                bVar2.b(i65);
            } else if (iArrA[0] != i65) {
                bVar2.b(i65);
            }
            ArrayList arrayList2 = new ArrayList();
            int[] iArr5 = new int[fVar.a.e * fVar.d];
            ArrayList arrayList3 = new ArrayList();
            ArrayList arrayList4 = new ArrayList();
            for (int i66 = 0; i66 < fVar.a.e; i66++) {
                int i67 = 0;
                while (i67 < fVar.d) {
                    int i68 = i67 + 1;
                    int[] iArrA2 = bVarArr[i66][i68].a();
                    int i69 = (fVar.d * i66) + i67;
                    if (iArrA2.length == 0) {
                        arrayList2.add(Integer.valueOf(i69));
                    } else if (iArrA2.length == 1) {
                        iArr5[i69] = iArrA2[0];
                    } else {
                        arrayList4.add(Integer.valueOf(i69));
                        arrayList3.add(iArrA2);
                    }
                    i67 = i68;
                }
            }
            int size = arrayList3.size();
            int[][] iArr6 = new int[size][];
            for (int i70 = 0; i70 < size; i70++) {
                iArr6[i70] = (int[]) arrayList3.get(i70);
            }
            int i71 = fVar.a.f1876b;
            int[] iArrB = a.b(arrayList2);
            int[] iArrB2 = a.b(arrayList4);
            int length2 = iArrB2.length;
            int[] iArr7 = new int[length2];
            int i72 = 100;
            while (true) {
                int i73 = i72 - 1;
                if (i72 <= 0) {
                    throw ChecksumException.a();
                }
                for (int i74 = 0; i74 < length2; i74++) {
                    iArr5[iArrB2[i74]] = iArr6[i74][iArr7[i74]];
                }
                try {
                    eVarB = j.b(iArr5, i71, iArrB);
                } catch (ChecksumException unused) {
                    if (length2 == 0) {
                        throw ChecksumException.a();
                    }
                    for (int i75 = 0; i75 < length2; i75++) {
                        if (iArr7[i75] < iArr6[i75].length - 1) {
                            iArr7[i75] = iArr7[i75] + 1;
                            break;
                        }
                        iArr7[i75] = 0;
                        if (i75 == length2 - 1) {
                            throw ChecksumException.a();
                        }
                    }
                    i72 = i73;
                }
            }
            Result result = new Result(eVarB.c, eVarB.a, next, b.i.e.a.PDF_417);
            result.b(b.i.e.j.ERROR_CORRECTION_LEVEL, eVarB.e);
            c cVar6 = (c) eVarB.f;
            if (cVar6 != null) {
                result.b(b.i.e.j.PDF417_EXTRA_METADATA, cVar6);
            }
            arrayList.add(result);
            it2 = it3;
            c = 0;
            i13 = 2;
        }
        Result[] resultArr = (Result[]) arrayList.toArray(new Result[arrayList.size()]);
        if (resultArr == null || resultArr.length == 0 || resultArr[0] == null) {
            throw NotFoundException.l;
        }
        return resultArr[0];
    }

    @Override // b.i.e.i
    public void reset() {
    }
}
