package p007b.p225i.p414e.p434s.p436c;

import com.google.zxing.NotFoundException;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p007b.p225i.p414e.C4956k;
import p007b.p225i.p414e.InterfaceC4957l;
import p007b.p225i.p414e.p418n.C4963b;

/* JADX INFO: renamed from: b.i.e.s.c.c */
/* JADX INFO: compiled from: Detector.java */
/* JADX INFO: loaded from: classes3.dex */
public class C5061c {

    /* JADX INFO: renamed from: a */
    public final C4963b f13568a;

    /* JADX INFO: renamed from: b */
    public InterfaceC4957l f13569b;

    public C5061c(C4963b c4963b) {
        this.f13568a = c4963b;
    }

    /* JADX INFO: renamed from: a */
    public final float m7109a(C4956k c4956k, C4956k c4956k2) {
        float fM7112d = m7112d((int) c4956k.f13207a, (int) c4956k.f13208b, (int) c4956k2.f13207a, (int) c4956k2.f13208b);
        float fM7112d2 = m7112d((int) c4956k2.f13207a, (int) c4956k2.f13208b, (int) c4956k.f13207a, (int) c4956k.f13208b);
        if (Float.isNaN(fM7112d)) {
            return fM7112d2 / 7.0f;
        }
        return Float.isNaN(fM7112d2) ? fM7112d / 7.0f : (fM7112d + fM7112d2) / 14.0f;
    }

    /* JADX INFO: renamed from: b */
    public final C5059a m7110b(float f, int i, int i2, float f2) throws NotFoundException {
        C5059a c5059aM7108c;
        C5059a c5059aM7108c2;
        int i3 = (int) (f2 * f);
        int iMax = Math.max(0, i - i3);
        int iMin = Math.min(this.f13568a.f13229j - 1, i + i3) - iMax;
        float f3 = 3.0f * f;
        if (iMin < f3) {
            throw NotFoundException.f21665l;
        }
        int iMax2 = Math.max(0, i2 - i3);
        int iMin2 = Math.min(this.f13568a.f13230k - 1, i2 + i3) - iMax2;
        if (iMin2 < f3) {
            throw NotFoundException.f21665l;
        }
        C5060b c5060b = new C5060b(this.f13568a, iMax, iMax2, iMin, iMin2, f, this.f13569b);
        int i4 = c5060b.f13561c;
        int i5 = c5060b.f13564f;
        int i6 = c5060b.f13563e + i4;
        int i7 = (i5 / 2) + c5060b.f13562d;
        int[] iArr = new int[3];
        for (int i8 = 0; i8 < i5; i8++) {
            int i9 = ((i8 & 1) == 0 ? (i8 + 1) / 2 : -((i8 + 1) / 2)) + i7;
            iArr[0] = 0;
            iArr[1] = 0;
            iArr[2] = 0;
            int i10 = i4;
            while (i10 < i6 && !c5060b.f13559a.m6942f(i10, i9)) {
                i10++;
            }
            int i11 = 0;
            while (i10 < i6) {
                if (!c5060b.f13559a.m6942f(i10, i9)) {
                    if (i11 == 1) {
                        i11++;
                    }
                    iArr[i11] = iArr[i11] + 1;
                } else if (i11 == 1) {
                    iArr[1] = iArr[1] + 1;
                } else if (i11 != 2) {
                    i11++;
                    iArr[i11] = iArr[i11] + 1;
                } else {
                    if (c5060b.m7107b(iArr) && (c5059aM7108c2 = c5060b.m7108c(iArr, i9, i10)) != null) {
                        return c5059aM7108c2;
                    }
                    iArr[0] = iArr[2];
                    iArr[1] = 1;
                    iArr[2] = 0;
                    i11 = 1;
                }
                i10++;
            }
            if (c5060b.m7107b(iArr) && (c5059aM7108c = c5060b.m7108c(iArr, i9, i6)) != null) {
                return c5059aM7108c;
            }
        }
        if (c5060b.f13560b.isEmpty()) {
            throw NotFoundException.f21665l;
        }
        return c5060b.f13560b.get(0);
    }

    /* JADX INFO: renamed from: c */
    public final float m7111c(int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        int i8;
        int i9 = 1;
        boolean z2 = Math.abs(i4 - i2) > Math.abs(i3 - i);
        if (z2) {
            i6 = i;
            i5 = i2;
            i8 = i3;
            i7 = i4;
        } else {
            i5 = i;
            i6 = i2;
            i7 = i3;
            i8 = i4;
        }
        int iAbs = Math.abs(i7 - i5);
        int iAbs2 = Math.abs(i8 - i6);
        int i10 = (-iAbs) / 2;
        int i11 = i5 < i7 ? 1 : -1;
        int i12 = i6 < i8 ? 1 : -1;
        int i13 = i7 + i11;
        int i14 = i5;
        int i15 = i6;
        int i16 = 0;
        while (true) {
            if (i14 == i13) {
                i13 = i13;
                break;
            }
            if ((i16 == i9) == this.f13568a.m6942f(z2 ? i15 : i14, z2 ? i14 : i15)) {
                if (i16 == 2) {
                    return C3404f.m4240R(i14, i15, i5, i6);
                }
                i16++;
            }
            i10 += iAbs2;
            if (i10 > 0) {
                if (i15 == i8) {
                    break;
                }
                i15 += i12;
                i10 -= iAbs;
            }
            i14 += i11;
            i13 = i13;
            z2 = z2;
            i9 = 1;
        }
        if (i16 == 2) {
            return C3404f.m4240R(i13, i8, i5, i6);
        }
        return Float.NaN;
    }

    /* JADX INFO: renamed from: d */
    public final float m7112d(int i, int i2, int i3, int i4) {
        float f;
        float f2;
        float fM7111c = m7111c(i, i2, i3, i4);
        int i5 = i - (i3 - i);
        int i6 = 0;
        if (i5 < 0) {
            f = i / (i - i5);
            i5 = 0;
        } else {
            int i7 = this.f13568a.f13229j;
            if (i5 >= i7) {
                float f3 = ((i7 - 1) - i) / (i5 - i);
                int i8 = i7 - 1;
                f = f3;
                i5 = i8;
            } else {
                f = 1.0f;
            }
        }
        float f4 = i2;
        int i9 = (int) (f4 - ((i4 - i2) * f));
        if (i9 < 0) {
            f2 = f4 / (i2 - i9);
        } else {
            int i10 = this.f13568a.f13230k;
            if (i9 >= i10) {
                f2 = ((i10 - 1) - i2) / (i9 - i2);
                i6 = i10 - 1;
            } else {
                i6 = i9;
                f2 = 1.0f;
            }
        }
        return (m7111c(i, i2, (int) (((i5 - i) * f2) + i), i6) + fM7111c) - 1.0f;
    }
}
