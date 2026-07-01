package b.i.e.o;

import b.i.e.c;
import b.i.e.i;
import b.i.e.j;
import b.i.e.k;
import b.i.e.n.b;
import b.i.e.n.e;
import b.i.e.o.b.d;
import b.i.e.o.c.a$b;
import b.i.e.o.c.a$c;
import com.google.zxing.ChecksumException;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map$Entry;

/* JADX INFO: compiled from: DataMatrixReader.java */
/* JADX INFO: loaded from: classes3.dex */
public final class a implements i {
    public static final k[] a = new k[0];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d f1843b = new d();

    @Override // b.i.e.i
    public Result a(c cVar, Map<b.i.e.d, ?> map) throws NotFoundException, ChecksumException, FormatException {
        b bVarD;
        k[] kVarArr;
        e eVarA;
        if (map == null || !map.containsKey(b.i.e.d.PURE_BARCODE)) {
            b.i.e.o.c.a aVar = new b.i.e.o.c.a(cVar.a());
            k[] kVarArrB = aVar.f1850b.b();
            k kVar = kVarArrB[0];
            k kVar2 = kVarArrB[1];
            k kVar3 = kVarArrB[2];
            k kVar4 = kVarArrB[3];
            ArrayList arrayList = new ArrayList(4);
            arrayList.add(aVar.e(kVar, kVar2));
            arrayList.add(aVar.e(kVar, kVar3));
            arrayList.add(aVar.e(kVar2, kVar4));
            arrayList.add(aVar.e(kVar3, kVar4));
            Collections.sort(arrayList, new a$c(null));
            a$b a_b = (a$b) arrayList.get(0);
            a$b a_b2 = (a$b) arrayList.get(1);
            HashMap map2 = new HashMap();
            b.i.e.o.c.a.b(map2, a_b.a);
            b.i.e.o.c.a.b(map2, a_b.f1851b);
            b.i.e.o.c.a.b(map2, a_b2.a);
            b.i.e.o.c.a.b(map2, a_b2.f1851b);
            k kVar5 = null;
            k kVar6 = null;
            k kVar7 = null;
            for (Map$Entry map$Entry : map2.entrySet()) {
                k kVar8 = (k) map$Entry.getKey();
                if (((Integer) map$Entry.getValue()).intValue() == 2) {
                    kVar6 = kVar8;
                } else if (kVar5 == null) {
                    kVar5 = kVar8;
                } else {
                    kVar7 = kVar8;
                }
            }
            if (kVar5 == null || kVar6 == null || kVar7 == null) {
                throw NotFoundException.l;
            }
            k[] kVarArr2 = {kVar5, kVar6, kVar7};
            k.b(kVarArr2);
            k kVar9 = kVarArr2[0];
            k kVar10 = kVarArr2[1];
            k kVar11 = kVarArr2[2];
            if (map2.containsKey(kVar)) {
                kVar = map2.containsKey(kVar2) ? !map2.containsKey(kVar3) ? kVar3 : kVar4 : kVar2;
            }
            int i = aVar.e(kVar11, kVar).c;
            int i2 = aVar.e(kVar9, kVar).c;
            if ((i & 1) == 1) {
                i++;
            }
            int i3 = i + 2;
            if ((i2 & 1) == 1) {
                i2++;
            }
            int i4 = i2 + 2;
            if (i3 * 4 >= i4 * 7 || i4 * 4 >= i3 * 7) {
                float fA = b.i.e.o.c.a.a(kVar10, kVar9) / i3;
                int iA = b.i.e.o.c.a.a(kVar11, kVar);
                float f = kVar.a;
                float f2 = iA;
                float f3 = (f - kVar11.a) / f2;
                float f4 = kVar.f1826b;
                k kVar12 = new k((f3 * fA) + f, (fA * ((f4 - kVar11.f1826b) / f2)) + f4);
                float fA2 = b.i.e.o.c.a.a(kVar10, kVar11) / i4;
                int iA2 = b.i.e.o.c.a.a(kVar9, kVar);
                float f5 = kVar.a;
                float f6 = iA2;
                float f7 = (f5 - kVar9.a) / f6;
                float f8 = kVar.f1826b;
                k kVar13 = new k((f7 * fA2) + f5, (fA2 * ((f8 - kVar9.f1826b) / f6)) + f8);
                if (aVar.c(kVar12)) {
                    if (!aVar.c(kVar13) || Math.abs(i4 - aVar.e(kVar9, kVar12).c) + Math.abs(i3 - aVar.e(kVar11, kVar12).c) <= Math.abs(i4 - aVar.e(kVar9, kVar13).c) + Math.abs(i3 - aVar.e(kVar11, kVar13).c)) {
                        kVar13 = kVar12;
                    }
                } else if (!aVar.c(kVar13)) {
                    kVar13 = null;
                }
                if (kVar13 != null) {
                    kVar = kVar13;
                }
                int i5 = aVar.e(kVar11, kVar).c;
                int i6 = aVar.e(kVar9, kVar).c;
                if ((i5 & 1) == 1) {
                    i5++;
                }
                int i7 = i5;
                if ((i6 & 1) == 1) {
                    i6++;
                }
                bVarD = b.i.e.o.c.a.d(aVar.a, kVar11, kVar10, kVar9, kVar, i7, i6);
            } else {
                float fMin = Math.min(i4, i3);
                float fA3 = b.i.e.o.c.a.a(kVar10, kVar9) / fMin;
                int iA3 = b.i.e.o.c.a.a(kVar11, kVar);
                float f9 = kVar.a;
                float f10 = iA3;
                float f11 = (f9 - kVar11.a) / f10;
                float f12 = kVar.f1826b;
                k kVar14 = new k((f11 * fA3) + f9, (fA3 * ((f12 - kVar11.f1826b) / f10)) + f12);
                float fA4 = b.i.e.o.c.a.a(kVar10, kVar11) / fMin;
                int iA4 = b.i.e.o.c.a.a(kVar9, kVar);
                float f13 = kVar.a;
                float f14 = iA4;
                float f15 = (f13 - kVar9.a) / f14;
                float f16 = kVar.f1826b;
                k kVar15 = new k((f15 * fA4) + f13, (fA4 * ((f16 - kVar9.f1826b) / f14)) + f16);
                if (aVar.c(kVar14)) {
                    if (!aVar.c(kVar15) || Math.abs(aVar.e(kVar11, kVar14).c - aVar.e(kVar9, kVar14).c) <= Math.abs(aVar.e(kVar11, kVar15).c - aVar.e(kVar9, kVar15).c)) {
                        kVar15 = kVar14;
                    }
                } else if (!aVar.c(kVar15)) {
                    kVar15 = null;
                }
                if (kVar15 != null) {
                    kVar = kVar15;
                }
                int iMax = Math.max(aVar.e(kVar11, kVar).c, aVar.e(kVar9, kVar).c) + 1;
                if ((iMax & 1) == 1) {
                    iMax++;
                }
                int i8 = iMax;
                bVarD = b.i.e.o.c.a.d(aVar.a, kVar11, kVar10, kVar9, kVar, i8, i8);
            }
            kVarArr = new k[]{kVar11, kVar10, kVar9, kVar};
            eVarA = this.f1843b.a(bVarD);
        } else {
            b bVarA = cVar.a();
            int[] iArrI = bVarA.i();
            int[] iArrG = bVarA.g();
            if (iArrI == null || iArrG == null) {
                throw NotFoundException.l;
            }
            int i9 = bVarA.j;
            int i10 = iArrI[0];
            int i11 = iArrI[1];
            while (i10 < i9 && bVarA.f(i10, i11)) {
                i10++;
            }
            if (i10 == i9) {
                throw NotFoundException.l;
            }
            int i12 = i10 - iArrI[0];
            if (i12 == 0) {
                throw NotFoundException.l;
            }
            int i13 = iArrI[1];
            int i14 = iArrG[1];
            int i15 = iArrI[0];
            int i16 = ((iArrG[0] - i15) + 1) / i12;
            int i17 = ((i14 - i13) + 1) / i12;
            if (i16 <= 0 || i17 <= 0) {
                throw NotFoundException.l;
            }
            int i18 = i12 / 2;
            int i19 = i13 + i18;
            int i20 = i15 + i18;
            b bVar = new b(i16, i17);
            for (int i21 = 0; i21 < i17; i21++) {
                int i22 = (i21 * i12) + i19;
                for (int i23 = 0; i23 < i16; i23++) {
                    if (bVarA.f((i23 * i12) + i20, i22)) {
                        bVar.j(i23, i21);
                    }
                }
            }
            eVarA = this.f1843b.a(bVar);
            kVarArr = a;
        }
        Result result = new Result(eVarA.c, eVarA.a, kVarArr, b.i.e.a.DATA_MATRIX);
        List<byte[]> list = eVarA.d;
        if (list != null) {
            result.b(j.BYTE_SEGMENTS, list);
        }
        String str = eVarA.e;
        if (str != null) {
            result.b(j.ERROR_CORRECTION_LEVEL, str);
        }
        return result;
    }

    @Override // b.i.e.i
    public void reset() {
    }
}
