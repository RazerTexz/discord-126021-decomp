package p007b.p225i.p414e.p421o;

import com.google.zxing.ChecksumException;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import p007b.p225i.p414e.C4948c;
import p007b.p225i.p414e.C4956k;
import p007b.p225i.p414e.EnumC4946a;
import p007b.p225i.p414e.EnumC4949d;
import p007b.p225i.p414e.EnumC4955j;
import p007b.p225i.p414e.InterfaceC4954i;
import p007b.p225i.p414e.p418n.C4963b;
import p007b.p225i.p414e.p418n.C4966e;
import p007b.p225i.p414e.p421o.p422b.C4980d;
import p007b.p225i.p414e.p421o.p423c.C4982a;

/* JADX INFO: renamed from: b.i.e.o.a */
/* JADX INFO: compiled from: DataMatrixReader.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C4976a implements InterfaceC4954i {

    /* JADX INFO: renamed from: a */
    public static final C4956k[] f13317a = new C4956k[0];

    /* JADX INFO: renamed from: b */
    public final C4980d f13318b = new C4980d();

    @Override // p007b.p225i.p414e.InterfaceC4954i
    /* JADX INFO: renamed from: a */
    public Result mo6919a(C4948c c4948c, Map<EnumC4949d, ?> map) throws NotFoundException, ChecksumException, FormatException {
        C4963b c4963bM6976d;
        C4956k[] c4956kArr;
        C4966e c4966eM6973a;
        if (map == null || !map.containsKey(EnumC4949d.PURE_BARCODE)) {
            C4982a c4982a = new C4982a(c4948c.m6913a());
            C4956k[] c4956kArrM6957b = c4982a.f13343b.m6957b();
            C4956k c4956k = c4956kArrM6957b[0];
            C4956k c4956k2 = c4956kArrM6957b[1];
            C4956k c4956k3 = c4956kArrM6957b[2];
            C4956k c4956k4 = c4956kArrM6957b[3];
            ArrayList arrayList = new ArrayList(4);
            arrayList.add(c4982a.m6978e(c4956k, c4956k2));
            arrayList.add(c4982a.m6978e(c4956k, c4956k3));
            arrayList.add(c4982a.m6978e(c4956k2, c4956k4));
            arrayList.add(c4982a.m6978e(c4956k3, c4956k4));
            Collections.sort(arrayList, new C4982a.c(null));
            C4982a.b bVar = (C4982a.b) arrayList.get(0);
            C4982a.b bVar2 = (C4982a.b) arrayList.get(1);
            HashMap map2 = new HashMap();
            C4982a.m6975b(map2, bVar.f13344a);
            C4982a.m6975b(map2, bVar.f13345b);
            C4982a.m6975b(map2, bVar2.f13344a);
            C4982a.m6975b(map2, bVar2.f13345b);
            C4956k c4956k5 = null;
            C4956k c4956k6 = null;
            C4956k c4956k7 = null;
            for (Map.Entry entry : map2.entrySet()) {
                C4956k c4956k8 = (C4956k) entry.getKey();
                if (((Integer) entry.getValue()).intValue() == 2) {
                    c4956k6 = c4956k8;
                } else if (c4956k5 == null) {
                    c4956k5 = c4956k8;
                } else {
                    c4956k7 = c4956k8;
                }
            }
            if (c4956k5 == null || c4956k6 == null || c4956k7 == null) {
                throw NotFoundException.f21665l;
            }
            C4956k[] c4956kArr2 = {c4956k5, c4956k6, c4956k7};
            C4956k.m6923b(c4956kArr2);
            C4956k c4956k9 = c4956kArr2[0];
            C4956k c4956k10 = c4956kArr2[1];
            C4956k c4956k11 = c4956kArr2[2];
            if (map2.containsKey(c4956k)) {
                c4956k = map2.containsKey(c4956k2) ? !map2.containsKey(c4956k3) ? c4956k3 : c4956k4 : c4956k2;
            }
            int i = c4982a.m6978e(c4956k11, c4956k).f13346c;
            int i2 = c4982a.m6978e(c4956k9, c4956k).f13346c;
            if ((i & 1) == 1) {
                i++;
            }
            int i3 = i + 2;
            if ((i2 & 1) == 1) {
                i2++;
            }
            int i4 = i2 + 2;
            if (i3 * 4 >= i4 * 7 || i4 * 4 >= i3 * 7) {
                float fM6974a = C4982a.m6974a(c4956k10, c4956k9) / i3;
                int iM6974a = C4982a.m6974a(c4956k11, c4956k);
                float f = c4956k.f13207a;
                float f2 = iM6974a;
                float f3 = (f - c4956k11.f13207a) / f2;
                float f4 = c4956k.f13208b;
                C4956k c4956k12 = new C4956k((f3 * fM6974a) + f, (fM6974a * ((f4 - c4956k11.f13208b) / f2)) + f4);
                float fM6974a2 = C4982a.m6974a(c4956k10, c4956k11) / i4;
                int iM6974a2 = C4982a.m6974a(c4956k9, c4956k);
                float f5 = c4956k.f13207a;
                float f6 = iM6974a2;
                float f7 = (f5 - c4956k9.f13207a) / f6;
                float f8 = c4956k.f13208b;
                C4956k c4956k13 = new C4956k((f7 * fM6974a2) + f5, (fM6974a2 * ((f8 - c4956k9.f13208b) / f6)) + f8);
                if (c4982a.m6977c(c4956k12)) {
                    if (!c4982a.m6977c(c4956k13) || Math.abs(i4 - c4982a.m6978e(c4956k9, c4956k12).f13346c) + Math.abs(i3 - c4982a.m6978e(c4956k11, c4956k12).f13346c) <= Math.abs(i4 - c4982a.m6978e(c4956k9, c4956k13).f13346c) + Math.abs(i3 - c4982a.m6978e(c4956k11, c4956k13).f13346c)) {
                        c4956k13 = c4956k12;
                    }
                } else if (!c4982a.m6977c(c4956k13)) {
                    c4956k13 = null;
                }
                if (c4956k13 != null) {
                    c4956k = c4956k13;
                }
                int i5 = c4982a.m6978e(c4956k11, c4956k).f13346c;
                int i6 = c4982a.m6978e(c4956k9, c4956k).f13346c;
                if ((i5 & 1) == 1) {
                    i5++;
                }
                int i7 = i5;
                if ((i6 & 1) == 1) {
                    i6++;
                }
                c4963bM6976d = C4982a.m6976d(c4982a.f13342a, c4956k11, c4956k10, c4956k9, c4956k, i7, i6);
            } else {
                float fMin = Math.min(i4, i3);
                float fM6974a3 = C4982a.m6974a(c4956k10, c4956k9) / fMin;
                int iM6974a3 = C4982a.m6974a(c4956k11, c4956k);
                float f9 = c4956k.f13207a;
                float f10 = iM6974a3;
                float f11 = (f9 - c4956k11.f13207a) / f10;
                float f12 = c4956k.f13208b;
                C4956k c4956k14 = new C4956k((f11 * fM6974a3) + f9, (fM6974a3 * ((f12 - c4956k11.f13208b) / f10)) + f12);
                float fM6974a4 = C4982a.m6974a(c4956k10, c4956k11) / fMin;
                int iM6974a4 = C4982a.m6974a(c4956k9, c4956k);
                float f13 = c4956k.f13207a;
                float f14 = iM6974a4;
                float f15 = (f13 - c4956k9.f13207a) / f14;
                float f16 = c4956k.f13208b;
                C4956k c4956k15 = new C4956k((f15 * fM6974a4) + f13, (fM6974a4 * ((f16 - c4956k9.f13208b) / f14)) + f16);
                if (c4982a.m6977c(c4956k14)) {
                    if (!c4982a.m6977c(c4956k15) || Math.abs(c4982a.m6978e(c4956k11, c4956k14).f13346c - c4982a.m6978e(c4956k9, c4956k14).f13346c) <= Math.abs(c4982a.m6978e(c4956k11, c4956k15).f13346c - c4982a.m6978e(c4956k9, c4956k15).f13346c)) {
                        c4956k15 = c4956k14;
                    }
                } else if (!c4982a.m6977c(c4956k15)) {
                    c4956k15 = null;
                }
                if (c4956k15 != null) {
                    c4956k = c4956k15;
                }
                int iMax = Math.max(c4982a.m6978e(c4956k11, c4956k).f13346c, c4982a.m6978e(c4956k9, c4956k).f13346c) + 1;
                if ((iMax & 1) == 1) {
                    iMax++;
                }
                int i8 = iMax;
                c4963bM6976d = C4982a.m6976d(c4982a.f13342a, c4956k11, c4956k10, c4956k9, c4956k, i8, i8);
            }
            c4956kArr = new C4956k[]{c4956k11, c4956k10, c4956k9, c4956k};
            c4966eM6973a = this.f13318b.m6973a(c4963bM6976d);
        } else {
            C4963b c4963bM6913a = c4948c.m6913a();
            int[] iArrM6945i = c4963bM6913a.m6945i();
            int[] iArrM6943g = c4963bM6913a.m6943g();
            if (iArrM6945i == null || iArrM6943g == null) {
                throw NotFoundException.f21665l;
            }
            int i9 = c4963bM6913a.f13229j;
            int i10 = iArrM6945i[0];
            int i11 = iArrM6945i[1];
            while (i10 < i9 && c4963bM6913a.m6942f(i10, i11)) {
                i10++;
            }
            if (i10 == i9) {
                throw NotFoundException.f21665l;
            }
            int i12 = i10 - iArrM6945i[0];
            if (i12 == 0) {
                throw NotFoundException.f21665l;
            }
            int i13 = iArrM6945i[1];
            int i14 = iArrM6943g[1];
            int i15 = iArrM6945i[0];
            int i16 = ((iArrM6943g[0] - i15) + 1) / i12;
            int i17 = ((i14 - i13) + 1) / i12;
            if (i16 <= 0 || i17 <= 0) {
                throw NotFoundException.f21665l;
            }
            int i18 = i12 / 2;
            int i19 = i13 + i18;
            int i20 = i15 + i18;
            C4963b c4963b = new C4963b(i16, i17);
            for (int i21 = 0; i21 < i17; i21++) {
                int i22 = (i21 * i12) + i19;
                for (int i23 = 0; i23 < i16; i23++) {
                    if (c4963bM6913a.m6942f((i23 * i12) + i20, i22)) {
                        c4963b.m6946j(i23, i21);
                    }
                }
            }
            c4966eM6973a = this.f13318b.m6973a(c4963b);
            c4956kArr = f13317a;
        }
        Result result = new Result(c4966eM6973a.f13268c, c4966eM6973a.f13266a, c4956kArr, EnumC4946a.DATA_MATRIX);
        List<byte[]> list = c4966eM6973a.f13269d;
        if (list != null) {
            result.m9262b(EnumC4955j.BYTE_SEGMENTS, list);
        }
        String str = c4966eM6973a.f13270e;
        if (str != null) {
            result.m9262b(EnumC4955j.ERROR_CORRECTION_LEVEL, str);
        }
        return result;
    }

    @Override // p007b.p225i.p414e.InterfaceC4954i
    public void reset() {
    }
}
