package b.i.e.n.k;

import b.i.a.f.e.o.f;
import b.i.e.ResultPoint;
import b.i.e.n.BitMatrix;
import com.google.zxing.NotFoundException;

/* JADX INFO: renamed from: b.i.e.n.k.a, reason: use source file name */
/* JADX INFO: compiled from: WhiteRectangleDetector.java */
/* JADX INFO: loaded from: classes3.dex */
public final class WhiteRectangleDetector {
    public final BitMatrix a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f1840b;
    public final int c;
    public final int d;
    public final int e;
    public final int f;
    public final int g;

    public WhiteRectangleDetector(BitMatrix bitMatrix, int i, int i2, int i3) throws NotFoundException {
        this.a = bitMatrix;
        int i4 = bitMatrix.k;
        this.f1840b = i4;
        int i5 = bitMatrix.j;
        this.c = i5;
        int i6 = i / 2;
        int i7 = i2 - i6;
        this.d = i7;
        int i8 = i2 + i6;
        this.e = i8;
        int i9 = i3 - i6;
        this.g = i9;
        int i10 = i3 + i6;
        this.f = i10;
        if (i9 < 0 || i7 < 0 || i10 >= i4 || i8 >= i5) {
            throw NotFoundException.l;
        }
    }

    public final boolean a(int i, int i2, int i3, boolean z2) {
        if (z2) {
            while (i <= i2) {
                if (this.a.f(i, i3)) {
                    return true;
                }
                i++;
            }
            return false;
        }
        while (i <= i2) {
            if (this.a.f(i3, i)) {
                return true;
            }
            i++;
        }
        return false;
    }

    public ResultPoint[] b() throws NotFoundException {
        boolean z2;
        int i = this.d;
        int i2 = this.e;
        int i3 = this.g;
        int i4 = this.f;
        boolean z3 = true;
        boolean z4 = false;
        boolean z5 = false;
        boolean z6 = false;
        boolean z7 = false;
        boolean z8 = false;
        while (true) {
            if (!z3) {
                z2 = false;
                break;
            }
            boolean zA = true;
            boolean z9 = false;
            while (true) {
                if ((!zA && z4) || i2 >= this.c) {
                    break;
                }
                zA = a(i3, i4, i2, false);
                if (zA) {
                    i2++;
                    z4 = true;
                    z9 = true;
                } else if (!z4) {
                    i2++;
                }
            }
            if (i2 < this.c) {
                boolean zA2 = true;
                while (true) {
                    if ((!zA2 && z5) || i4 >= this.f1840b) {
                        break;
                    }
                    zA2 = a(i, i2, i4, true);
                    if (zA2) {
                        i4++;
                        z5 = true;
                        z9 = true;
                    } else if (!z5) {
                        i4++;
                    }
                }
                if (i4 < this.f1840b) {
                    boolean zA3 = true;
                    while (true) {
                        if ((!zA3 && z6) || i < 0) {
                            break;
                        }
                        zA3 = a(i3, i4, i, false);
                        if (zA3) {
                            i--;
                            z6 = true;
                            z9 = true;
                        } else if (!z6) {
                            i--;
                        }
                    }
                    if (i >= 0) {
                        z3 = z9;
                        boolean zA4 = true;
                        while (true) {
                            if ((!zA4 && z8) || i3 < 0) {
                                break;
                            }
                            zA4 = a(i, i2, i3, true);
                            if (zA4) {
                                i3--;
                                z3 = true;
                                z8 = true;
                            } else if (!z8) {
                                i3--;
                            }
                        }
                        if (i3 >= 0) {
                            if (z3) {
                                z7 = true;
                            }
                        }
                    }
                }
            }
            z2 = true;
            break;
        }
        if (z2 || !z7) {
            throw NotFoundException.l;
        }
        int i5 = i2 - i;
        ResultPoint resultPointC = null;
        ResultPoint resultPointC2 = null;
        for (int i6 = 1; resultPointC2 == null && i6 < i5; i6++) {
            resultPointC2 = c(i, i4 - i6, i + i6, i4);
        }
        if (resultPointC2 == null) {
            throw NotFoundException.l;
        }
        ResultPoint resultPointC3 = null;
        for (int i7 = 1; resultPointC3 == null && i7 < i5; i7++) {
            resultPointC3 = c(i, i3 + i7, i + i7, i3);
        }
        if (resultPointC3 == null) {
            throw NotFoundException.l;
        }
        ResultPoint resultPointC4 = null;
        for (int i8 = 1; resultPointC4 == null && i8 < i5; i8++) {
            resultPointC4 = c(i2, i3 + i8, i2 - i8, i3);
        }
        if (resultPointC4 == null) {
            throw NotFoundException.l;
        }
        for (int i9 = 1; resultPointC == null && i9 < i5; i9++) {
            resultPointC = c(i2, i4 - i9, i2 - i9, i4);
        }
        if (resultPointC == null) {
            throw NotFoundException.l;
        }
        float f = resultPointC.a;
        float f2 = resultPointC.f1826b;
        float f3 = resultPointC2.a;
        float f4 = resultPointC2.f1826b;
        float f5 = resultPointC4.a;
        float f6 = resultPointC4.f1826b;
        float f7 = resultPointC3.a;
        float f8 = resultPointC3.f1826b;
        return f < ((float) this.c) / 2.0f ? new ResultPoint[]{new ResultPoint(f7 - 1.0f, f8 + 1.0f), new ResultPoint(f3 + 1.0f, f4 + 1.0f), new ResultPoint(f5 - 1.0f, f6 - 1.0f), new ResultPoint(f + 1.0f, f2 - 1.0f)} : new ResultPoint[]{new ResultPoint(f7 + 1.0f, f8 + 1.0f), new ResultPoint(f3 + 1.0f, f4 - 1.0f), new ResultPoint(f5 - 1.0f, f6 + 1.0f), new ResultPoint(f - 1.0f, f2 - 1.0f)};
    }

    public final ResultPoint c(float f, float f2, float f3, float f4) {
        int iZ0 = f.Z0(f.Q(f, f2, f3, f4));
        float f5 = iZ0;
        float f6 = (f3 - f) / f5;
        float f7 = (f4 - f2) / f5;
        for (int i = 0; i < iZ0; i++) {
            float f8 = i;
            int iZ1 = f.Z0((f8 * f6) + f);
            int iZ2 = f.Z0((f8 * f7) + f2);
            if (this.a.f(iZ1, iZ2)) {
                return new ResultPoint(iZ1, iZ2);
            }
        }
        return null;
    }
}
