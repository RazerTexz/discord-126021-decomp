package b.i.e.s;

import b.i.e.c;
import b.i.e.d;
import b.i.e.i;
import b.i.e.k;
import b.i.e.l;
import b.i.e.n.b;
import b.i.e.s.b.e;
import b.i.e.s.b.j;
import b.i.e.s.c.e$b;
import b.i.e.s.c.e$c;
import b.i.e.s.c.f;
import com.google.zxing.ChecksumException;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: QRCodeReader.java */
/* JADX INFO: loaded from: classes3.dex */
public class a implements i {
    public static final k[] a = new k[0];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e f1885b = new e();

    @Override // b.i.e.i
    public final Result a(c cVar, Map<d, ?> map) throws NotFoundException, ChecksumException, FormatException {
        int i;
        b.i.e.s.c.a aVarB;
        float f;
        float f2;
        float f3;
        b.i.e.n.e eVarA;
        k[] kVarArr;
        int i2;
        int i3;
        if (map == null || !map.containsKey(d.PURE_BARCODE)) {
            b bVarA = cVar.a();
            b.i.e.s.c.c cVar2 = new b.i.e.s.c.c(bVarA);
            l lVar = map == null ? null : (l) map.get(d.NEED_RESULT_POINT_CALLBACK);
            cVar2.f1894b = lVar;
            b.i.e.s.c.e eVar = new b.i.e.s.c.e(bVarA, lVar);
            boolean z2 = map != null && map.containsKey(d.TRY_HARDER);
            int i4 = bVarA.k;
            int i5 = bVarA.j;
            int i6 = (i4 * 3) / 388;
            if (i6 < 3 || z2) {
                i6 = 3;
            }
            int[] iArr = new int[5];
            int i7 = i6 - 1;
            boolean zF = false;
            while (true) {
                int i8 = 4;
                if (i7 >= i4 || zF) {
                    break;
                }
                eVar.b(iArr);
                int i9 = 0;
                int i10 = 0;
                while (i9 < i5) {
                    if (eVar.a.f(i9, i7)) {
                        if ((i10 & 1) == 1) {
                            i10++;
                        }
                        iArr[i10] = iArr[i10] + 1;
                    } else if ((i10 & 1) != 0) {
                        iArr[i10] = iArr[i10] + 1;
                    } else if (i10 != i8) {
                        i10++;
                        iArr[i10] = iArr[i10] + 1;
                    } else if (b.i.e.s.c.e.c(iArr) && eVar.e(iArr, i7, i9)) {
                        if (eVar.c) {
                            zF = eVar.f();
                        } else {
                            if (eVar.f1895b.size() <= 1) {
                                i2 = 2;
                                i3 = 0;
                                break;
                            }
                            Iterator<b.i.e.s.c.d> it = eVar.f1895b.iterator();
                            b.i.e.s.c.d dVar = null;
                            while (true) {
                                if (!it.hasNext()) {
                                    i2 = 2;
                                    i3 = 0;
                                    break;
                                }
                                b.i.e.s.c.d next = it.next();
                                if (next.d >= 2) {
                                    if (dVar != null) {
                                        eVar.c = true;
                                        int iAbs = (int) (Math.abs(dVar.a - next.a) - Math.abs(dVar.f1826b - next.f1826b));
                                        i2 = 2;
                                        i3 = iAbs / 2;
                                        break;
                                    }
                                    dVar = next;
                                }
                            }
                            if (i3 > iArr[i2]) {
                                i7 += (i3 - iArr[i2]) - i2;
                                i9 = i5 - 1;
                            }
                        }
                        eVar.b(iArr);
                        i6 = 2;
                        i10 = 0;
                    } else {
                        eVar.g(iArr);
                        i10 = 3;
                    }
                    i9++;
                    i8 = 4;
                }
                if (b.i.e.s.c.e.c(iArr) && eVar.e(iArr, i7, i5)) {
                    i6 = iArr[0];
                    if (eVar.c) {
                        zF = eVar.f();
                    }
                }
                i7 += i6;
            }
            int size = eVar.f1895b.size();
            if (size < 3) {
                throw NotFoundException.l;
            }
            float f4 = 0.0f;
            if (size > 3) {
                Iterator<b.i.e.s.c.d> it2 = eVar.f1895b.iterator();
                float f5 = 0.0f;
                float f6 = 0.0f;
                while (it2.hasNext()) {
                    float f7 = it2.next().c;
                    f5 += f7;
                    f6 += f7 * f7;
                }
                float f8 = size;
                float f9 = f5 / f8;
                float fSqrt = (float) Math.sqrt((f6 / f8) - (f9 * f9));
                Collections.sort(eVar.f1895b, new e$c(f9, null));
                float fMax = Math.max(0.2f * f9, fSqrt);
                int i11 = 0;
                while (i11 < eVar.f1895b.size() && eVar.f1895b.size() > 3) {
                    if (Math.abs(eVar.f1895b.get(i11).c - f9) > fMax) {
                        eVar.f1895b.remove(i11);
                        i11--;
                    }
                    i11++;
                }
            }
            if (eVar.f1895b.size() > 3) {
                Iterator<b.i.e.s.c.d> it3 = eVar.f1895b.iterator();
                while (it3.hasNext()) {
                    f4 += it3.next().c;
                }
                Collections.sort(eVar.f1895b, new e$b(f4 / eVar.f1895b.size(), null));
                List<b.i.e.s.c.d> list = eVar.f1895b;
                i = 3;
                list.subList(3, list.size()).clear();
            } else {
                i = 3;
            }
            b.i.e.s.c.d[] dVarArr = new b.i.e.s.c.d[i];
            dVarArr[0] = eVar.f1895b.get(0);
            dVarArr[1] = eVar.f1895b.get(1);
            dVarArr[2] = eVar.f1895b.get(2);
            k.b(dVarArr);
            f fVar = new f(dVarArr);
            b.i.e.s.c.d dVar2 = fVar.f1896b;
            b.i.e.s.c.d dVar3 = fVar.c;
            b.i.e.s.c.d dVar4 = fVar.a;
            float fA = (cVar2.a(dVar2, dVar4) + cVar2.a(dVar2, dVar3)) / 2.0f;
            if (fA < 1.0f) {
                throw NotFoundException.l;
            }
            int iZ0 = ((b.i.a.f.e.o.f.Z0(b.i.a.f.e.o.f.Q(dVar2.a, dVar2.f1826b, dVar4.a, dVar4.f1826b) / fA) + b.i.a.f.e.o.f.Z0(b.i.a.f.e.o.f.Q(dVar2.a, dVar2.f1826b, dVar3.a, dVar3.f1826b) / fA)) / 2) + 7;
            int i12 = iZ0 & 3;
            if (i12 == 0) {
                iZ0++;
            } else if (i12 == 2) {
                iZ0--;
            } else if (i12 == 3) {
                throw NotFoundException.l;
            }
            int[] iArr2 = j.a;
            if (iZ0 % 4 != 1) {
                throw FormatException.a();
            }
            try {
                j jVarD = j.d((iZ0 - 17) / 4);
                int iC = jVarD.c() - 7;
                if (jVarD.d.length <= 0) {
                    aVarB = null;
                    break;
                }
                float f10 = dVar3.a;
                float f11 = dVar2.a;
                float f12 = (f10 - f11) + dVar4.a;
                float f13 = dVar3.f1826b;
                float f14 = dVar2.f1826b;
                float f15 = (f13 - f14) + dVar4.f1826b;
                float f16 = 1.0f - (3.0f / iC);
                int iA = (int) b.d.b.a.a.a(f12, f11, f16, f11);
                int iA2 = (int) b.d.b.a.a.a(f15, f14, f16, f14);
                int i13 = 4;
                while (true) {
                    if (i13 > 16) {
                        aVarB = null;
                        break;
                    }
                    try {
                        aVarB = cVar2.b(fA, iA, iA2, i13);
                        break;
                    } catch (NotFoundException unused) {
                        i13 <<= 1;
                    }
                }
                float f17 = iZ0 - 3.5f;
                if (aVarB != null) {
                    f = aVarB.a;
                    f2 = aVarB.f1826b;
                    f3 = f17 - 3.0f;
                } else {
                    f = (dVar3.a - dVar2.a) + dVar4.a;
                    f2 = (dVar3.f1826b - dVar2.f1826b) + dVar4.f1826b;
                    f3 = f17;
                }
                b bVarA2 = b.i.e.n.f.a.a(cVar2.a, iZ0, iZ0, b.i.e.n.i.a(3.5f, 3.5f, f17, 3.5f, f3, f3, 3.5f, f17, dVar2.a, dVar2.f1826b, dVar3.a, dVar3.f1826b, f, f2, dVar4.a, dVar4.f1826b));
                k[] kVarArr2 = aVarB == null ? new k[]{dVar4, dVar2, dVar3} : new k[]{dVar4, dVar2, dVar3, aVarB};
                eVarA = this.f1885b.a(bVarA2, map);
                kVarArr = kVarArr2;
            } catch (IllegalArgumentException unused2) {
                throw FormatException.a();
            }
        } else {
            b bVarA3 = cVar.a();
            int[] iArrI = bVarA3.i();
            int[] iArrG = bVarA3.g();
            if (iArrI == null || iArrG == null) {
                throw NotFoundException.l;
            }
            int i14 = bVarA3.k;
            int i15 = bVarA3.j;
            int i16 = iArrI[0];
            int i17 = iArrI[1];
            boolean z3 = true;
            int i18 = 0;
            while (i16 < i15 && i17 < i14) {
                if (z3 != bVarA3.f(i16, i17)) {
                    i18++;
                    if (i18 == 5) {
                        break;
                    }
                    z3 = !z3;
                }
                i16++;
                i17++;
            }
            if (i16 == i15 || i17 == i14) {
                throw NotFoundException.l;
            }
            float f18 = (i16 - iArrI[0]) / 7.0f;
            int i19 = iArrI[1];
            int i20 = iArrG[1];
            int i21 = iArrI[0];
            int i22 = iArrG[0];
            if (i21 >= i22 || i19 >= i20) {
                throw NotFoundException.l;
            }
            int i23 = i20 - i19;
            if (i23 != i22 - i21 && (i22 = i21 + i23) >= bVarA3.j) {
                throw NotFoundException.l;
            }
            int iRound = Math.round(((i22 - i21) + 1) / f18);
            int iRound2 = Math.round((i23 + 1) / f18);
            if (iRound <= 0 || iRound2 <= 0) {
                throw NotFoundException.l;
            }
            if (iRound2 != iRound) {
                throw NotFoundException.l;
            }
            int i24 = (int) (f18 / 2.0f);
            int i25 = i19 + i24;
            int i26 = i21 + i24;
            int i27 = (((int) ((iRound - 1) * f18)) + i26) - i22;
            if (i27 > 0) {
                if (i27 > i24) {
                    throw NotFoundException.l;
                }
                i26 -= i27;
            }
            int i28 = (((int) ((iRound2 - 1) * f18)) + i25) - i20;
            if (i28 > 0) {
                if (i28 > i24) {
                    throw NotFoundException.l;
                }
                i25 -= i28;
            }
            b bVar = new b(iRound, iRound2);
            for (int i29 = 0; i29 < iRound2; i29++) {
                int i30 = ((int) (i29 * f18)) + i25;
                for (int i31 = 0; i31 < iRound; i31++) {
                    if (bVarA3.f(((int) (i31 * f18)) + i26, i30)) {
                        bVar.j(i31, i29);
                    }
                }
            }
            eVarA = this.f1885b.a(bVar, map);
            kVarArr = a;
        }
        Object obj = eVarA.f;
        if ((obj instanceof b.i.e.s.b.i) && ((b.i.e.s.b.i) obj).a && kVarArr.length >= 3) {
            k kVar = kVarArr[0];
            kVarArr[0] = kVarArr[2];
            kVarArr[2] = kVar;
        }
        Result result = new Result(eVarA.c, eVarA.a, kVarArr, b.i.e.a.QR_CODE);
        List<byte[]> list2 = eVarA.d;
        if (list2 != null) {
            result.b(b.i.e.j.BYTE_SEGMENTS, list2);
        }
        String str = eVarA.e;
        if (str != null) {
            result.b(b.i.e.j.ERROR_CORRECTION_LEVEL, str);
        }
        if (eVarA.g >= 0 && eVarA.h >= 0) {
            result.b(b.i.e.j.STRUCTURED_APPEND_SEQUENCE, Integer.valueOf(eVarA.h));
            result.b(b.i.e.j.STRUCTURED_APPEND_PARITY, Integer.valueOf(eVarA.g));
        }
        return result;
    }

    @Override // b.i.e.i
    public void reset() {
    }
}
