package p007b.p225i.p414e.p430r.p433e;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import p007b.p225i.p414e.C4956k;
import p007b.p225i.p414e.p418n.C4963b;

/* JADX INFO: renamed from: b.i.e.r.e.a */
/* JADX INFO: compiled from: Detector.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C5047a {

    /* JADX INFO: renamed from: a */
    public static final int[] f13504a = {0, 4, 1, 5};

    /* JADX INFO: renamed from: b */
    public static final int[] f13505b = {6, 2, 7, 3};

    /* JADX INFO: renamed from: c */
    public static final int[] f13506c = {8, 1, 1, 1, 1, 1, 1, 3};

    /* JADX INFO: renamed from: d */
    public static final int[] f13507d = {7, 1, 1, 3, 1, 1, 1, 2, 1};

    /* JADX INFO: renamed from: a */
    public static List<C4956k[]> m7080a(boolean z2, C4963b c4963b) {
        int i;
        int i2;
        float f;
        ArrayList<C4956k[]> arrayList = new ArrayList();
        int iMax = 0;
        loop0: while (true) {
            int i3 = 0;
            boolean z3 = false;
            while (true) {
                int i4 = c4963b.f13230k;
                if (iMax >= i4) {
                    break loop0;
                }
                int i5 = c4963b.f13229j;
                C4956k[] c4956kArr = new C4956k[8];
                C4956k[] c4956kArrM7082c = m7082c(c4963b, i4, i5, iMax, i3, f13506c);
                int[] iArr = f13504a;
                for (int i6 = 0; i6 < iArr.length; i6++) {
                    c4956kArr[iArr[i6]] = c4956kArrM7082c[i6];
                }
                if (c4956kArr[4] != null) {
                    i2 = (int) c4956kArr[4].f13207a;
                    i = (int) c4956kArr[4].f13208b;
                } else {
                    i = iMax;
                    i2 = i3;
                }
                C4956k[] c4956kArrM7082c2 = m7082c(c4963b, i4, i5, i, i2, f13507d);
                int[] iArr2 = f13505b;
                for (int i7 = 0; i7 < iArr2.length; i7++) {
                    c4956kArr[iArr2[i7]] = c4956kArrM7082c2[i7];
                }
                if (c4956kArr[0] != null || c4956kArr[3] != null) {
                    arrayList.add(c4956kArr);
                    if (!z2) {
                        break loop0;
                    }
                    if (c4956kArr[2] != null) {
                        i3 = (int) c4956kArr[2].f13207a;
                        f = c4956kArr[2].f13208b;
                    } else {
                        i3 = (int) c4956kArr[4].f13207a;
                        f = c4956kArr[4].f13208b;
                    }
                    iMax = (int) f;
                    z3 = true;
                }
            }
            if (!z3) {
                break;
            }
            for (C4956k[] c4956kArr2 : arrayList) {
                if (c4956kArr2[1] != null) {
                    iMax = (int) Math.max(iMax, c4956kArr2[1].f13208b);
                }
                if (c4956kArr2[3] != null) {
                    iMax = Math.max(iMax, (int) c4956kArr2[3].f13208b);
                }
            }
            iMax += 5;
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: b */
    public static int[] m7081b(C4963b c4963b, int i, int i2, int i3, boolean z2, int[] iArr, int[] iArr2) {
        Arrays.fill(iArr2, 0, iArr2.length, 0);
        int i4 = 0;
        while (c4963b.m6942f(i, i2) && i > 0) {
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
            if (c4963b.m6942f(i, i2) != z3) {
                iArr2[i6] = iArr2[i6] + 1;
            } else {
                if (i6 != length - 1) {
                    i6++;
                } else {
                    if (m7083d(iArr2, iArr, 0.8f) < 0.42f) {
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
        if (i6 != length - 1 || m7083d(iArr2, iArr, 0.8f) >= 0.42f) {
            return null;
        }
        return new int[]{i7, i - 1};
    }

    /* JADX INFO: renamed from: c */
    public static C4956k[] m7082c(C4963b c4963b, int i, int i2, int i3, int i4, int[] iArr) {
        boolean z2;
        int i5;
        int i6;
        int i7;
        C4956k[] c4956kArr = new C4956k[4];
        int[] iArr2 = new int[iArr.length];
        int i8 = i3;
        while (true) {
            if (i8 >= i) {
                z2 = false;
                break;
            }
            int[] iArrM7081b = m7081b(c4963b, i4, i8, i2, false, iArr, iArr2);
            if (iArrM7081b != null) {
                int i9 = i8;
                int[] iArr3 = iArrM7081b;
                int i10 = i9;
                while (true) {
                    if (i10 <= 0) {
                        i7 = i10;
                        break;
                    }
                    int i11 = i10 - 1;
                    int[] iArrM7081b2 = m7081b(c4963b, i4, i11, i2, false, iArr, iArr2);
                    if (iArrM7081b2 == null) {
                        i7 = i11 + 1;
                        break;
                    }
                    iArr3 = iArrM7081b2;
                    i10 = i11;
                }
                float f = i7;
                c4956kArr[0] = new C4956k(iArr3[0], f);
                c4956kArr[1] = new C4956k(iArr3[1], f);
                i8 = i7;
                z2 = true;
                break;
            }
            i8 += 5;
        }
        int i12 = i8 + 1;
        if (z2) {
            int[] iArr4 = {(int) c4956kArr[0].f13207a, (int) c4956kArr[1].f13207a};
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
                int[] iArrM7081b3 = m7081b(c4963b, iArr4[0], i13, i2, false, iArr, iArr2);
                if (iArrM7081b3 != null && Math.abs(iArr4[0] - iArrM7081b3[0]) < 5 && Math.abs(iArr4[1] - iArrM7081b3[1]) < 5) {
                    iArr4 = iArrM7081b3;
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
            c4956kArr[2] = new C4956k(iArr4[0], f2);
            c4956kArr[3] = new C4956k(iArr4[1], f2);
        }
        if (i12 - i8 < 10) {
            Arrays.fill(c4956kArr, (Object) null);
        }
        return c4956kArr;
    }

    /* JADX INFO: renamed from: d */
    public static float m7083d(int[] iArr, int[] iArr2, float f) {
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
