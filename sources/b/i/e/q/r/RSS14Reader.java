package b.i.e.q.r;

import b.i.a.f.e.o.f;
import b.i.e.BarcodeFormat;
import b.i.e.DecodeHintType;
import b.i.e.ResultPoint;
import b.i.e.ResultPointCallback;
import b.i.e.n.BitArray;
import b.i.e.q.OneDReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import org.objectweb.asm.Opcodes;

/* JADX INFO: renamed from: b.i.e.q.r.e, reason: use source file name */
/* JADX INFO: compiled from: RSS14Reader.java */
/* JADX INFO: loaded from: classes3.dex */
public final class RSS14Reader extends AbstractRSSReader {
    public static final int[] g = {1, 10, 34, 70, 126};
    public static final int[] h = {4, 20, 48, 81};
    public static final int[] i = {0, Opcodes.IF_ICMPLT, 961, 2015, 2715};
    public static final int[] j = {0, 336, 1036, 1516};
    public static final int[] k = {8, 6, 4, 3, 1};
    public static final int[] l = {2, 4, 6, 8};
    public static final int[][] m = {new int[]{3, 8, 2, 1}, new int[]{3, 5, 5, 1}, new int[]{3, 3, 7, 1}, new int[]{3, 1, 9, 1}, new int[]{2, 7, 4, 1}, new int[]{2, 5, 6, 1}, new int[]{2, 3, 8, 1}, new int[]{1, 5, 7, 1}, new int[]{1, 3, 9, 1}};
    public final List<Pair3> n = new ArrayList();
    public final List<Pair3> o = new ArrayList();

    public static void k(Collection<Pair3> collection, Pair3 pair3) {
        if (pair3 == null) {
            return;
        }
        boolean z2 = false;
        for (Pair3 pair4 : collection) {
            if (pair4.a == pair3.a) {
                pair4.d++;
                z2 = true;
                break;
            }
        }
        if (z2) {
            return;
        }
        collection.add(pair3);
    }

    @Override // b.i.e.q.OneDReader
    public Result b(int i2, BitArray bitArray, Map<DecodeHintType, ?> map) throws NotFoundException {
        k(this.n, m(bitArray, false, i2, map));
        bitArray.i();
        k(this.o, m(bitArray, true, i2, map));
        bitArray.i();
        for (Pair3 pair3 : this.n) {
            if (pair3.d > 1) {
                for (Pair3 pair4 : this.o) {
                    if (pair4.d > 1) {
                        int i3 = ((pair4.f1863b * 16) + pair3.f1863b) % 79;
                        int i4 = (pair3.c.a * 9) + pair4.c.a;
                        if (i4 > 72) {
                            i4--;
                        }
                        if (i4 > 8) {
                            i4--;
                        }
                        if (i3 == i4) {
                            String strValueOf = String.valueOf((((long) pair3.a) * 4537077) + ((long) pair4.a));
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
                            ResultPoint[] resultPointArr = pair3.c.c;
                            ResultPoint[] resultPointArr2 = pair4.c.c;
                            return new Result(sb.toString(), null, new ResultPoint[]{resultPointArr[0], resultPointArr[1], resultPointArr2[0], resultPointArr2[1]}, BarcodeFormat.RSS_14);
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
    public final DataCharacter l(BitArray bitArray, FinderPattern finderPattern, boolean z2) throws NotFoundException {
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        int[] iArr = this.f1862b;
        for (int i2 = 0; i2 < iArr.length; i2++) {
            iArr[i2] = 0;
        }
        if (z2) {
            OneDReader.f(bitArray, finderPattern.f1864b[0], iArr);
        } else {
            OneDReader.e(bitArray, finderPattern.f1864b[1] + 1, iArr);
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
            AbstractRSSReader.h(this.e, this.c);
        }
        if (z4) {
            AbstractRSSReader.g(this.e, this.c);
        }
        if (z5) {
            if (z6) {
                throw NotFoundException.l;
            }
            AbstractRSSReader.h(this.f, this.c);
        }
        if (z6) {
            AbstractRSSReader.g(this.f, this.d);
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
            return new DataCharacter((f.p0(iArr3, 9 - i16, false) * h[i15]) + f.p0(iArr2, i16, true) + j[i15], i14);
        }
        if ((i11 & 1) != 0 || i11 > 12 || i11 < 4) {
            throw NotFoundException.l;
        }
        int i17 = (12 - i11) / 2;
        int i18 = k[i17];
        return new DataCharacter((f.p0(iArr2, i18, false) * g[i17]) + f.p0(iArr3, 9 - i18, true) + i[i17], i14);
    }

    public final Pair3 m(BitArray bitArray, boolean z2, int i2, Map<DecodeHintType, ?> map) {
        try {
            int[] iArrN = n(bitArray, z2);
            FinderPattern finderPatternO = o(bitArray, i2, z2, iArrN);
            ResultPointCallback resultPointCallback = map == null ? null : (ResultPointCallback) map.get(DecodeHintType.NEED_RESULT_POINT_CALLBACK);
            if (resultPointCallback != null) {
                float f = (iArrN[0] + iArrN[1]) / 2.0f;
                if (z2) {
                    f = (bitArray.k - 1) - f;
                }
                resultPointCallback.a(new ResultPoint(f, i2));
            }
            DataCharacter dataCharacterL = l(bitArray, finderPatternO, true);
            DataCharacter dataCharacterL2 = l(bitArray, finderPatternO, false);
            return new Pair3((dataCharacterL.a * 1597) + dataCharacterL2.a, (dataCharacterL2.f1863b * 4) + dataCharacterL.f1863b, finderPatternO);
        } catch (NotFoundException unused) {
            return null;
        }
    }

    public final int[] n(BitArray bitArray, boolean z2) throws NotFoundException {
        int[] iArr = this.a;
        iArr[0] = 0;
        iArr[1] = 0;
        iArr[2] = 0;
        iArr[3] = 0;
        int i2 = bitArray.k;
        int i3 = 0;
        boolean z3 = false;
        while (i3 < i2) {
            z3 = !bitArray.b(i3);
            if (z2 == z3) {
                break;
            }
            i3++;
        }
        int i4 = i3;
        int i5 = 0;
        while (i3 < i2) {
            if (bitArray.b(i3) != z3) {
                iArr[i5] = iArr[i5] + 1;
            } else {
                if (i5 != 3) {
                    i5++;
                } else {
                    if (AbstractRSSReader.i(iArr)) {
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

    public final FinderPattern o(BitArray bitArray, int i2, boolean z2, int[] iArr) throws NotFoundException {
        int i3;
        int i4;
        boolean zB = bitArray.b(iArr[0]);
        int i5 = iArr[0] - 1;
        while (i5 >= 0 && zB != bitArray.b(i5)) {
            i5--;
        }
        int i6 = i5 + 1;
        int i7 = iArr[0] - i6;
        int[] iArr2 = this.a;
        System.arraycopy(iArr2, 0, iArr2, 1, iArr2.length - 1);
        iArr2[0] = i7;
        int iJ = AbstractRSSReader.j(iArr2, m);
        int i8 = iArr[1];
        if (z2) {
            int i9 = bitArray.k;
            i3 = (i9 - 1) - i8;
            i4 = (i9 - 1) - i6;
        } else {
            i3 = i8;
            i4 = i6;
        }
        return new FinderPattern(iJ, new int[]{i6, iArr[1]}, i4, i3, i2);
    }

    @Override // b.i.e.q.OneDReader, b.i.e.Reader
    public void reset() {
        this.n.clear();
        this.o.clear();
    }
}
