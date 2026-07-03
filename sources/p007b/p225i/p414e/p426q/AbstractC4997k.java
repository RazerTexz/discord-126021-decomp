package p007b.p225i.p414e.p426q;

import com.google.zxing.ChecksumException;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.ReaderException;
import com.google.zxing.Result;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;
import java.util.Objects;
import p007b.p225i.p414e.AbstractC4951f;
import p007b.p225i.p414e.C4948c;
import p007b.p225i.p414e.C4956k;
import p007b.p225i.p414e.EnumC4949d;
import p007b.p225i.p414e.EnumC4955j;
import p007b.p225i.p414e.InterfaceC4954i;
import p007b.p225i.p414e.p418n.C4962a;
import p007b.p225i.p414e.p418n.C4969h;

/* JADX INFO: renamed from: b.i.e.q.k */
/* JADX INFO: compiled from: OneDReader.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC4997k implements InterfaceC4954i {
    /* JADX INFO: renamed from: d */
    public static float m6996d(int[] iArr, int[] iArr2, float f) {
        int length = iArr.length;
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            i += iArr[i3];
            i2 += iArr2[i3];
        }
        if (i < i2) {
            return Float.POSITIVE_INFINITY;
        }
        float f2 = i;
        float f3 = f2 / i2;
        float f4 = f * f3;
        float f5 = 0.0f;
        for (int i4 = 0; i4 < length; i4++) {
            int i5 = iArr[i4];
            float f6 = iArr2[i4] * f3;
            float f7 = i5;
            float f8 = f7 > f6 ? f7 - f6 : f6 - f7;
            if (f8 > f4) {
                return Float.POSITIVE_INFINITY;
            }
            f5 += f8;
        }
        return f5 / f2;
    }

    /* JADX INFO: renamed from: e */
    public static void m6997e(C4962a c4962a, int i, int[] iArr) throws NotFoundException {
        int length = iArr.length;
        int i2 = 0;
        Arrays.fill(iArr, 0, length, 0);
        int i3 = c4962a.f13228k;
        if (i >= i3) {
            throw NotFoundException.f21665l;
        }
        boolean z2 = !c4962a.m6935b(i);
        while (i < i3) {
            if (c4962a.m6935b(i) == z2) {
                i2++;
                if (i2 == length) {
                    break;
                }
                iArr[i2] = 1;
                z2 = !z2;
            } else {
                iArr[i2] = iArr[i2] + 1;
            }
            i++;
        }
        if (i2 != length) {
            if (i2 != length - 1 || i != i3) {
                throw NotFoundException.f21665l;
            }
        }
    }

    /* JADX INFO: renamed from: f */
    public static void m6998f(C4962a c4962a, int i, int[] iArr) throws NotFoundException {
        int length = iArr.length;
        boolean zM6935b = c4962a.m6935b(i);
        while (i > 0 && length >= 0) {
            i--;
            if (c4962a.m6935b(i) != zM6935b) {
                length--;
                zM6935b = !zM6935b;
            }
        }
        if (length >= 0) {
            throw NotFoundException.f21665l;
        }
        m6997e(c4962a, i + 1, iArr);
    }

    @Override // p007b.p225i.p414e.InterfaceC4954i
    /* JADX INFO: renamed from: a */
    public Result mo6919a(C4948c c4948c, Map<EnumC4949d, ?> map) throws NotFoundException, FormatException {
        EnumC4955j enumC4955j = EnumC4955j.ORIENTATION;
        try {
            return m6999c(c4948c, map);
        } catch (NotFoundException e) {
            if (!(map != null && map.containsKey(EnumC4949d.TRY_HARDER)) || !c4948c.f13171a.f13170a.mo6917c()) {
                throw e;
            }
            AbstractC4951f abstractC4951fMo6918d = c4948c.f13171a.f13170a.mo6918d();
            Objects.requireNonNull((C4969h) c4948c.f13171a);
            Result resultM6999c = m6999c(new C4948c(new C4969h(abstractC4951fMo6918d)), map);
            Map<EnumC4955j, Object> map2 = resultM6999c.f21672e;
            int iIntValue = 270;
            if (map2 != null && map2.containsKey(enumC4955j)) {
                iIntValue = (((Integer) map2.get(enumC4955j)).intValue() + 270) % 360;
            }
            resultM6999c.m9262b(enumC4955j, Integer.valueOf(iIntValue));
            C4956k[] c4956kArr = resultM6999c.f21670c;
            if (c4956kArr != null) {
                int i = abstractC4951fMo6918d.f13187b;
                for (int i2 = 0; i2 < c4956kArr.length; i2++) {
                    c4956kArr[i2] = new C4956k((i - c4956kArr[i2].f13208b) - 1.0f, c4956kArr[i2].f13207a);
                }
            }
            return resultM6999c;
        }
    }

    /* JADX INFO: renamed from: b */
    public abstract Result mo6983b(int i, C4962a c4962a, Map<EnumC4949d, ?> map) throws NotFoundException, ChecksumException, FormatException;

    /* JADX WARN: Code duplicated, block: B:37:0x0075  */
    /* JADX INFO: renamed from: c */
    public final Result m6999c(C4948c c4948c, Map<EnumC4949d, ?> map) throws NotFoundException {
        Map<EnumC4949d, ?> map2;
        int i;
        C4948c c4948c2 = c4948c;
        Map<EnumC4949d, ?> map3 = map;
        AbstractC4951f abstractC4951f = c4948c2.f13171a.f13170a;
        int i2 = abstractC4951f.f13186a;
        int i3 = abstractC4951f.f13187b;
        C4962a c4962a = new C4962a(i2);
        int i4 = 1;
        boolean z2 = map3 != null && map3.containsKey(EnumC4949d.TRY_HARDER);
        int iMax = Math.max(1, i3 >> (z2 ? 8 : 5));
        int i5 = z2 ? i3 : 15;
        int i6 = i3 / 2;
        int i7 = 0;
        while (i7 < i5) {
            int i8 = i7 + 1;
            int i9 = i8 / 2;
            if (!((i7 & 1) == 0)) {
                i9 = -i9;
            }
            int i10 = (i9 * iMax) + i6;
            if (i10 < 0 || i10 >= i3) {
                break;
            }
            try {
                c4962a = c4948c2.m6914b(i10, c4962a);
                int i11 = 0;
                while (i11 < 2) {
                    if (i11 == i4) {
                        c4962a.m6939i();
                        if (map3 != null) {
                            EnumC4949d enumC4949d = EnumC4949d.NEED_RESULT_POINT_CALLBACK;
                            if (map3.containsKey(enumC4949d)) {
                                EnumMap enumMap = new EnumMap(EnumC4949d.class);
                                enumMap.putAll(map3);
                                enumMap.remove(enumC4949d);
                                map3 = enumMap;
                            }
                        }
                    }
                    try {
                        Result resultMo6983b = mo6983b(i10, c4962a, map3);
                        if (i11 == i4) {
                            resultMo6983b.m9262b(EnumC4955j.ORIENTATION, 180);
                            C4956k[] c4956kArr = resultMo6983b.f21670c;
                            if (c4956kArr != null) {
                                float f = i2;
                                map2 = map3;
                                try {
                                    i = i3;
                                    try {
                                        c4956kArr[0] = new C4956k((f - c4956kArr[0].f13207a) - 1.0f, c4956kArr[0].f13208b);
                                        try {
                                            c4956kArr[1] = new C4956k((f - c4956kArr[1].f13207a) - 1.0f, c4956kArr[1].f13208b);
                                        } catch (ReaderException unused) {
                                            continue;
                                            i11++;
                                            map3 = map2;
                                            i3 = i;
                                            i4 = 1;
                                        }
                                    } catch (ReaderException unused2) {
                                        i11++;
                                        map3 = map2;
                                        i3 = i;
                                        i4 = 1;
                                    }
                                } catch (ReaderException unused3) {
                                    i = i3;
                                    i11++;
                                    map3 = map2;
                                    i3 = i;
                                    i4 = 1;
                                }
                            }
                        }
                        return resultMo6983b;
                    } catch (ReaderException unused4) {
                        map2 = map3;
                    }
                }
            } catch (NotFoundException unused5) {
            }
            c4948c2 = c4948c;
            i7 = i8;
            i3 = i3;
            i4 = 1;
        }
        throw NotFoundException.f21665l;
    }

    @Override // p007b.p225i.p414e.InterfaceC4954i
    public void reset() {
    }
}
