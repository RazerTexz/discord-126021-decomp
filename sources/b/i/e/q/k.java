package b.i.e.q;

import com.google.zxing.ChecksumException;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.ReaderException;
import com.google.zxing.Result;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: OneDReader.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class k implements b.i.e.i {
    public static float d(int[] iArr, int[] iArr2, float f) {
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

    public static void e(b.i.e.n.a aVar, int i, int[] iArr) throws NotFoundException {
        int length = iArr.length;
        int i2 = 0;
        Arrays.fill(iArr, 0, length, 0);
        int i3 = aVar.k;
        if (i >= i3) {
            throw NotFoundException.l;
        }
        boolean z2 = !aVar.b(i);
        while (i < i3) {
            if (aVar.b(i) == z2) {
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
                throw NotFoundException.l;
            }
        }
    }

    public static void f(b.i.e.n.a aVar, int i, int[] iArr) throws NotFoundException {
        int length = iArr.length;
        boolean zB = aVar.b(i);
        while (i > 0 && length >= 0) {
            i--;
            if (aVar.b(i) != zB) {
                length--;
                zB = !zB;
            }
        }
        if (length >= 0) {
            throw NotFoundException.l;
        }
        e(aVar, i + 1, iArr);
    }

    @Override // b.i.e.i
    public Result a(b.i.e.c cVar, Map<b.i.e.d, ?> map) throws NotFoundException, FormatException {
        b.i.e.j jVar = b.i.e.j.ORIENTATION;
        try {
            return c(cVar, map);
        } catch (NotFoundException e) {
            if (!(map != null && map.containsKey(b.i.e.d.TRY_HARDER)) || !cVar.a.a.c()) {
                throw e;
            }
            b.i.e.f fVarD = cVar.a.a.d();
            Objects.requireNonNull((b.i.e.n.h) cVar.a);
            Result resultC = c(new b.i.e.c(new b.i.e.n.h(fVarD)), map);
            Map<b.i.e.j, Object> map2 = resultC.e;
            int iIntValue = 270;
            if (map2 != null && map2.containsKey(jVar)) {
                iIntValue = (((Integer) map2.get(jVar)).intValue() + 270) % 360;
            }
            resultC.b(jVar, Integer.valueOf(iIntValue));
            b.i.e.k[] kVarArr = resultC.c;
            if (kVarArr != null) {
                int i = fVarD.f1823b;
                for (int i2 = 0; i2 < kVarArr.length; i2++) {
                    kVarArr[i2] = new b.i.e.k((i - kVarArr[i2].f1826b) - 1.0f, kVarArr[i2].a);
                }
            }
            return resultC;
        }
    }

    public abstract Result b(int i, b.i.e.n.a aVar, Map<b.i.e.d, ?> map) throws NotFoundException, ChecksumException, FormatException;

    /* JADX WARN: Code duplicated, block: B:37:0x0075  */
    public final Result c(b.i.e.c cVar, Map<b.i.e.d, ?> map) throws NotFoundException {
        Map<b.i.e.d, ?> map2;
        int i;
        b.i.e.c cVar2 = cVar;
        Map<b.i.e.d, ?> map3 = map;
        b.i.e.f fVar = cVar2.a.a;
        int i2 = fVar.a;
        int i3 = fVar.f1823b;
        b.i.e.n.a aVar = new b.i.e.n.a(i2);
        int i4 = 1;
        boolean z2 = map3 != null && map3.containsKey(b.i.e.d.TRY_HARDER);
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
                aVar = cVar2.b(i10, aVar);
                int i11 = 0;
                while (i11 < 2) {
                    if (i11 == i4) {
                        aVar.i();
                        if (map3 != null) {
                            b.i.e.d dVar = b.i.e.d.NEED_RESULT_POINT_CALLBACK;
                            if (map3.containsKey(dVar)) {
                                EnumMap enumMap = new EnumMap(b.i.e.d.class);
                                enumMap.putAll(map3);
                                enumMap.remove(dVar);
                                map3 = enumMap;
                            }
                        }
                    }
                    try {
                        Result resultB = b(i10, aVar, map3);
                        if (i11 == i4) {
                            resultB.b(b.i.e.j.ORIENTATION, 180);
                            b.i.e.k[] kVarArr = resultB.c;
                            if (kVarArr != null) {
                                float f = i2;
                                map2 = map3;
                                try {
                                    i = i3;
                                    try {
                                        kVarArr[0] = new b.i.e.k((f - kVarArr[0].a) - 1.0f, kVarArr[0].f1826b);
                                        try {
                                            kVarArr[1] = new b.i.e.k((f - kVarArr[1].a) - 1.0f, kVarArr[1].f1826b);
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
                        return resultB;
                    } catch (ReaderException unused4) {
                        map2 = map3;
                    }
                }
            } catch (NotFoundException unused5) {
            }
            cVar2 = cVar;
            i7 = i8;
            i3 = i3;
            i4 = 1;
        }
        throw NotFoundException.l;
    }

    @Override // b.i.e.i
    public void reset() {
    }
}
