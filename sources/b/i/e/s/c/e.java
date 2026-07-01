package b.i.e.s.c;

import b.i.e.l;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: FinderPatternFinder.java */
/* JADX INFO: loaded from: classes3.dex */
public class e {
    public final b.i.e.n.b a;
    public boolean c;
    public final l e;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<d> f1895b = new ArrayList();
    public final int[] d = new int[5];

    public e(b.i.e.n.b bVar, l lVar) {
        this.a = bVar;
        this.e = lVar;
    }

    public static float a(int[] iArr, int i) {
        return ((i - iArr[4]) - iArr[3]) - (iArr[2] / 2.0f);
    }

    public static boolean c(int[] iArr) {
        int i = 0;
        for (int i2 = 0; i2 < 5; i2++) {
            int i3 = iArr[i2];
            if (i3 == 0) {
                return false;
            }
            i += i3;
        }
        if (i < 7) {
            return false;
        }
        float f = i / 7.0f;
        float f2 = f / 2.0f;
        return Math.abs(f - ((float) iArr[0])) < f2 && Math.abs(f - ((float) iArr[1])) < f2 && Math.abs((f * 3.0f) - ((float) iArr[2])) < 3.0f * f2 && Math.abs(f - ((float) iArr[3])) < f2 && Math.abs(f - ((float) iArr[4])) < f2;
    }

    public final void b(int[] iArr) {
        for (int i = 0; i < iArr.length; i++) {
            iArr[i] = 0;
        }
    }

    public final int[] d() {
        b(this.d);
        return this.d;
    }

    /* JADX WARN: Code duplicated, block: B:122:0x01af  */
    /* JADX WARN: Code duplicated, block: B:198:0x02d9  */
    /* JADX WARN: Code duplicated, block: B:212:0x031f  */
    /* JADX WARN: Code duplicated, block: B:61:0x00e3  */
    public final boolean e(int[] iArr, int i, int i2) {
        float fA;
        float fA2;
        boolean z2;
        boolean z3;
        boolean z4;
        int i3;
        int i4;
        int i5;
        int i6 = iArr[0] + iArr[1] + iArr[2] + iArr[3] + iArr[4];
        int iA = (int) a(iArr, i2);
        int i7 = iArr[2];
        b.i.e.n.b bVar = this.a;
        int i8 = bVar.k;
        int[] iArrD = d();
        int i9 = i;
        while (i9 >= 0 && bVar.f(iA, i9)) {
            iArrD[2] = iArrD[2] + 1;
            i9--;
        }
        if (i9 < 0) {
            fA = Float.NaN;
        } else {
            while (i9 >= 0 && !bVar.f(iA, i9) && iArrD[1] <= i7) {
                iArrD[1] = iArrD[1] + 1;
                i9--;
            }
            if (i9 < 0 || iArrD[1] > i7) {
                fA = Float.NaN;
            } else {
                while (i9 >= 0 && bVar.f(iA, i9) && iArrD[0] <= i7) {
                    iArrD[0] = iArrD[0] + 1;
                    i9--;
                }
                if (iArrD[0] > i7) {
                    fA = Float.NaN;
                } else {
                    int i10 = i + 1;
                    while (i10 < i8 && bVar.f(iA, i10)) {
                        iArrD[2] = iArrD[2] + 1;
                        i10++;
                    }
                    if (i10 == i8) {
                        fA = Float.NaN;
                    } else {
                        while (i10 < i8 && !bVar.f(iA, i10) && iArrD[3] < i7) {
                            iArrD[3] = iArrD[3] + 1;
                            i10++;
                        }
                        if (i10 == i8 || iArrD[3] >= i7) {
                            fA = Float.NaN;
                        } else {
                            while (i10 < i8 && bVar.f(iA, i10) && iArrD[4] < i7) {
                                iArrD[4] = iArrD[4] + 1;
                                i10++;
                            }
                            if (iArrD[4] < i7 && Math.abs(((((iArrD[0] + iArrD[1]) + iArrD[2]) + iArrD[3]) + iArrD[4]) - i6) * 5 < i6 * 2 && c(iArrD)) {
                                fA = a(iArrD, i10);
                            } else {
                                fA = Float.NaN;
                            }
                        }
                    }
                }
            }
        }
        if (Float.isNaN(fA)) {
            return false;
        }
        int i11 = (int) fA;
        int i12 = iArr[2];
        b.i.e.n.b bVar2 = this.a;
        int i13 = bVar2.j;
        int[] iArrD2 = d();
        int i14 = iA;
        while (i14 >= 0 && bVar2.f(i14, i11)) {
            iArrD2[2] = iArrD2[2] + 1;
            i14--;
        }
        if (i14 < 0) {
            fA2 = Float.NaN;
        } else {
            while (i14 >= 0 && !bVar2.f(i14, i11) && iArrD2[1] <= i12) {
                iArrD2[1] = iArrD2[1] + 1;
                i14--;
            }
            if (i14 < 0 || iArrD2[1] > i12) {
                fA2 = Float.NaN;
            } else {
                while (i14 >= 0 && bVar2.f(i14, i11) && iArrD2[0] <= i12) {
                    iArrD2[0] = iArrD2[0] + 1;
                    i14--;
                }
                if (iArrD2[0] > i12) {
                    fA2 = Float.NaN;
                } else {
                    int i15 = iA + 1;
                    while (i15 < i13 && bVar2.f(i15, i11)) {
                        iArrD2[2] = iArrD2[2] + 1;
                        i15++;
                    }
                    if (i15 == i13) {
                        fA2 = Float.NaN;
                    } else {
                        while (i15 < i13 && !bVar2.f(i15, i11) && iArrD2[3] < i12) {
                            iArrD2[3] = iArrD2[3] + 1;
                            i15++;
                        }
                        if (i15 == i13 || iArrD2[3] >= i12) {
                            fA2 = Float.NaN;
                        } else {
                            while (i15 < i13 && bVar2.f(i15, i11) && iArrD2[4] < i12) {
                                iArrD2[4] = iArrD2[4] + 1;
                                i15++;
                            }
                            if (iArrD2[4] < i12 && Math.abs(((((iArrD2[0] + iArrD2[1]) + iArrD2[2]) + iArrD2[3]) + iArrD2[4]) - i6) * 5 < i6 && c(iArrD2)) {
                                fA2 = a(iArrD2, i15);
                            } else {
                                fA2 = Float.NaN;
                            }
                        }
                    }
                }
            }
        }
        if (Float.isNaN(fA2)) {
            return false;
        }
        int i16 = (int) fA2;
        int[] iArrD3 = d();
        int i17 = 0;
        while (i11 >= i17 && i16 >= i17 && this.a.f(i16 - i17, i11 - i17)) {
            iArrD3[2] = iArrD3[2] + 1;
            i17++;
        }
        if (iArrD3[2] != 0) {
            while (i11 >= i17 && i16 >= i17 && !this.a.f(i16 - i17, i11 - i17)) {
                iArrD3[1] = iArrD3[1] + 1;
                i17++;
            }
            if (iArrD3[1] != 0) {
                while (i11 >= i17 && i16 >= i17 && this.a.f(i16 - i17, i11 - i17)) {
                    iArrD3[0] = iArrD3[0] + 1;
                    i17++;
                }
                if (iArrD3[0] != 0) {
                    b.i.e.n.b bVar3 = this.a;
                    int i18 = bVar3.k;
                    int i19 = bVar3.j;
                    int i20 = 1;
                    while (true) {
                        int i21 = i11 + i20;
                        if (i21 >= i18 || (i5 = i16 + i20) >= i19 || !this.a.f(i5, i21)) {
                            break;
                        }
                        iArrD3[2] = iArrD3[2] + 1;
                        i20++;
                    }
                    while (true) {
                        int i22 = i11 + i20;
                        if (i22 >= i18 || (i4 = i16 + i20) >= i19 || this.a.f(i4, i22)) {
                            break;
                        }
                        iArrD3[3] = iArrD3[3] + 1;
                        i20++;
                    }
                    if (iArrD3[3] != 0) {
                        while (true) {
                            int i23 = i11 + i20;
                            if (i23 >= i18 || (i3 = i16 + i20) >= i19 || !this.a.f(i3, i23)) {
                                break;
                            }
                            iArrD3[4] = iArrD3[4] + 1;
                            i20++;
                        }
                        if (iArrD3[4] != 0) {
                            int i24 = 0;
                            int i25 = 0;
                            while (true) {
                                if (i24 >= 5) {
                                    if (i25 >= 7) {
                                        float f = i25 / 7.0f;
                                        float f2 = f / 1.333f;
                                        if (Math.abs(f - iArrD3[0]) < f2 && Math.abs(f - iArrD3[1]) < f2 && Math.abs((f * 3.0f) - iArrD3[2]) < 3.0f * f2 && Math.abs(f - iArrD3[3]) < f2 && Math.abs(f - iArrD3[4]) < f2) {
                                            z2 = true;
                                            break;
                                        }
                                        break;
                                    }
                                    break;
                                }
                                int i26 = iArrD3[i24];
                                if (i26 != 0) {
                                    i25 += i26;
                                    i24++;
                                }
                                z2 = false;
                                break;
                            }
                        } else {
                            z2 = false;
                            break;
                        }
                    } else {
                        z2 = false;
                        break;
                    }
                } else {
                    z2 = false;
                    break;
                }
            } else {
                z2 = false;
                break;
            }
        } else {
            z2 = false;
            break;
        }
        if (!z2) {
            return false;
        }
        float f3 = i6 / 7.0f;
        int i27 = 0;
        while (true) {
            if (i27 >= this.f1895b.size()) {
                z3 = false;
                break;
            }
            d dVar = this.f1895b.get(i27);
            if (Math.abs(fA - dVar.f1826b) > f3 || Math.abs(fA2 - dVar.a) > f3) {
                z4 = false;
            } else {
                float fAbs = Math.abs(f3 - dVar.c);
                if (fAbs <= 1.0f || fAbs <= dVar.c) {
                    z4 = true;
                } else {
                    z4 = false;
                }
            }
            if (z4) {
                List<d> list = this.f1895b;
                int i28 = dVar.d;
                int i29 = i28 + 1;
                float f4 = i28;
                float f5 = i29;
                list.set(i27, new d(((dVar.a * f4) + fA2) / f5, ((dVar.f1826b * f4) + fA) / f5, ((f4 * dVar.c) + f3) / f5, i29));
                z3 = true;
                break;
            }
            i27++;
        }
        if (!z3) {
            d dVar2 = new d(fA2, fA, f3);
            this.f1895b.add(dVar2);
            l lVar = this.e;
            if (lVar != null) {
                lVar.a(dVar2);
            }
        }
        return true;
    }

    public final boolean f() {
        int size = this.f1895b.size();
        float fAbs = 0.0f;
        int i = 0;
        float f = 0.0f;
        for (d dVar : this.f1895b) {
            if (dVar.d >= 2) {
                i++;
                f += dVar.c;
            }
        }
        if (i < 3) {
            return false;
        }
        float f2 = f / size;
        Iterator<d> it = this.f1895b.iterator();
        while (it.hasNext()) {
            fAbs += Math.abs(it.next().c - f2);
        }
        return fAbs <= f * 0.05f;
    }

    public final void g(int[] iArr) {
        iArr[0] = iArr[2];
        iArr[1] = iArr[3];
        iArr[2] = iArr[4];
        iArr[3] = 1;
        iArr[4] = 0;
    }
}
