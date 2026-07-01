package b.i.e.r.e;

import b.i.e.ResultPoint;
import b.i.e.n.BitMatrix;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: renamed from: b.i.e.r.e.a, reason: use source file name */
/* JADX INFO: compiled from: Detector.java */
/* JADX INFO: loaded from: classes3.dex */
public final class Detector3 {
    public static final int[] a = {0, 4, 1, 5};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int[] f1884b = {6, 2, 7, 3};
    public static final int[] c = {8, 1, 1, 1, 1, 1, 1, 3};
    public static final int[] d = {7, 1, 1, 3, 1, 1, 1, 2, 1};

    public static List<ResultPoint[]> a(boolean z2, BitMatrix bitMatrix) {
        int i;
        int i2;
        float f;
        ArrayList<ResultPoint[]> arrayList = new ArrayList();
        int iMax = 0;
        loop0: while (true) {
            int i3 = 0;
            boolean z3 = false;
            while (true) {
                int i4 = bitMatrix.k;
                if (iMax >= i4) {
                    break loop0;
                }
                int i5 = bitMatrix.j;
                ResultPoint[] resultPointArr = new ResultPoint[8];
                ResultPoint[] resultPointArrC = c(bitMatrix, i4, i5, iMax, i3, c);
                int[] iArr = a;
                for (int i6 = 0; i6 < iArr.length; i6++) {
                    resultPointArr[iArr[i6]] = resultPointArrC[i6];
                }
                if (resultPointArr[4] != null) {
                    i2 = (int) resultPointArr[4].a;
                    i = (int) resultPointArr[4].f1826b;
                } else {
                    i = iMax;
                    i2 = i3;
                }
                ResultPoint[] resultPointArrC2 = c(bitMatrix, i4, i5, i, i2, d);
                int[] iArr2 = f1884b;
                for (int i7 = 0; i7 < iArr2.length; i7++) {
                    resultPointArr[iArr2[i7]] = resultPointArrC2[i7];
                }
                if (resultPointArr[0] != null || resultPointArr[3] != null) {
                    arrayList.add(resultPointArr);
                    if (!z2) {
                        break loop0;
                    }
                    if (resultPointArr[2] != null) {
                        i3 = (int) resultPointArr[2].a;
                        f = resultPointArr[2].f1826b;
                    } else {
                        i3 = (int) resultPointArr[4].a;
                        f = resultPointArr[4].f1826b;
                    }
                    iMax = (int) f;
                    z3 = true;
                }
            }
            if (!z3) {
                break;
            }
            for (ResultPoint[] resultPointArr2 : arrayList) {
                if (resultPointArr2[1] != null) {
                    iMax = (int) Math.max(iMax, resultPointArr2[1].f1826b);
                }
                if (resultPointArr2[3] != null) {
                    iMax = Math.max(iMax, (int) resultPointArr2[3].f1826b);
                }
            }
            iMax += 5;
        }
        return arrayList;
    }

    public static int[] b(BitMatrix bitMatrix, int i, int i2, int i3, boolean z2, int[] iArr, int[] iArr2) {
        Arrays.fill(iArr2, 0, iArr2.length, 0);
        int i4 = 0;
        while (bitMatrix.f(i, i2) && i > 0) {
            int i5 = i4 + 1;
            if (i4 >= 3) {
                break;
            }
            i--;
            i4 = i5;
        }
        int length = iArr.length;
        boolean z3 = z2;
        int i6 = 0;
        int i7 = i;
        while (i < i3) {
            if (bitMatrix.f(i, i2) != z3) {
                iArr2[i6] = iArr2[i6] + 1;
            } else {
                if (i6 != length - 1) {
                    i6++;
                } else {
                    if (d(iArr2, iArr, 0.8f) < 0.42f) {
                        return new int[]{i7, i};
                    }
                    i7 += iArr2[0] + iArr2[1];
                    int i8 = i6 - 1;
                    System.arraycopy(iArr2, 2, iArr2, 0, i8);
                    iArr2[i8] = 0;
                    iArr2[i6] = 0;
                    i6 = i8;
                }
                iArr2[i6] = 1;
                z3 = !z3;
            }
            i++;
        }
        if (i6 != length - 1 || d(iArr2, iArr, 0.8f) >= 0.42f) {
            return null;
        }
        return new int[]{i7, i - 1};
    }

    public static ResultPoint[] c(BitMatrix bitMatrix, int i, int i2, int i3, int i4, int[] iArr) {
        boolean z2;
        int i5;
        int i6;
        int i7;
        ResultPoint[] resultPointArr = new ResultPoint[4];
        int[] iArr2 = new int[iArr.length];
        int i8 = i3;
        while (true) {
            if (i8 >= i) {
                z2 = false;
                break;
            }
            int[] iArrB = b(bitMatrix, i4, i8, i2, false, iArr, iArr2);
            if (iArrB != null) {
                int i9 = i8;
                int[] iArr3 = iArrB;
                int i10 = i9;
                while (true) {
                    if (i10 <= 0) {
                        i7 = i10;
                        break;
                    }
                    int i11 = i10 - 1;
                    int[] iArrB2 = b(bitMatrix, i4, i11, i2, false, iArr, iArr2);
                    if (iArrB2 == null) {
                        i7 = i11 + 1;
                        break;
                    }
                    iArr3 = iArrB2;
                    i10 = i11;
                }
                float f = i7;
                resultPointArr[0] = new ResultPoint(iArr3[0], f);
                resultPointArr[1] = new ResultPoint(iArr3[1], f);
                i8 = i7;
                z2 = true;
                break;
            }
            i8 += 5;
        }
        int i12 = i8 + 1;
        if (z2) {
            int[] iArr4 = {(int) resultPointArr[0].a, (int) resultPointArr[1].a};
            int i13 = i12;
            int i14 = 0;
            while (true) {
                if (i13 >= i) {
                    i5 = i14;
                    i6 = i13;
                    break;
                }
                i5 = i14;
                i6 = i13;
                int[] iArrB3 = b(bitMatrix, iArr4[0], i13, i2, false, iArr, iArr2);
                if (iArrB3 != null && Math.abs(iArr4[0] - iArrB3[0]) < 5 && Math.abs(iArr4[1] - iArrB3[1]) < 5) {
                    iArr4 = iArrB3;
                    i14 = 0;
                } else {
                    if (i5 > 25) {
                        break;
                    }
                    i14 = i5 + 1;
                }
                i13 = i6 + 1;
            }
            i12 = i6 - (i5 + 1);
            float f2 = i12;
            resultPointArr[2] = new ResultPoint(iArr4[0], f2);
            resultPointArr[3] = new ResultPoint(iArr4[1], f2);
        }
        if (i12 - i8 < 10) {
            Arrays.fill(resultPointArr, (Object) null);
        }
        return resultPointArr;
    }

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
}
