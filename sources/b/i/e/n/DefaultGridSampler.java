package b.i.e.n;

import com.google.zxing.NotFoundException;
import java.util.Objects;

/* JADX INFO: renamed from: b.i.e.n.f, reason: use source file name */
/* JADX INFO: compiled from: DefaultGridSampler.java */
/* JADX INFO: loaded from: classes3.dex */
public final class DefaultGridSampler {
    public static DefaultGridSampler a = new DefaultGridSampler();

    /* JADX WARN: Code duplicated, block: B:29:0x009b  */
    /* JADX WARN: Code duplicated, block: B:30:0x009e A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:31:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:51:0x00d4  */
    /* JADX WARN: Code duplicated, block: B:52:0x00d7 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:53:0x00d9  */
    /* JADX WARN: Code duplicated, block: B:86:0x00a6 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:90:0x00df A[SYNTHETIC] */
    public BitMatrix a(BitMatrix bitMatrix, int i, int i2, PerspectiveTransform perspectiveTransform) throws NotFoundException {
        int i3 = i2;
        if (i <= 0 || i3 <= 0) {
            throw NotFoundException.l;
        }
        BitMatrix bitMatrix2 = new BitMatrix(i, i3);
        int i4 = i * 2;
        float[] fArr = new float[i4];
        int i5 = 0;
        while (i5 < i3) {
            float f = i5 + 0.5f;
            for (int i6 = 0; i6 < i4; i6 += 2) {
                fArr[i6] = (i6 / 2) + 0.5f;
                fArr[i6 + 1] = f;
            }
            Objects.requireNonNull(perspectiveTransform);
            float f2 = perspectiveTransform.a;
            float f3 = perspectiveTransform.f1838b;
            float f4 = perspectiveTransform.c;
            float f5 = perspectiveTransform.d;
            float f6 = perspectiveTransform.e;
            float f7 = perspectiveTransform.f;
            float f8 = perspectiveTransform.g;
            float f9 = perspectiveTransform.h;
            float f10 = perspectiveTransform.i;
            for (int i7 = 0; i7 < i4; i7 += 2) {
                float f11 = fArr[i7];
                int i8 = i7 + 1;
                float f12 = fArr[i8];
                float f13 = (f7 * f12) + (f4 * f11) + f10;
                fArr[i7] = (((f5 * f12) + (f2 * f11)) + f8) / f13;
                fArr[i8] = (((f12 * f6) + (f11 * f3)) + f9) / f13;
            }
            int i9 = bitMatrix.j;
            int i10 = bitMatrix.k;
            boolean z2 = true;
            for (int i11 = 0; i11 < i4 && z2; i11 += 2) {
                int i12 = (int) fArr[i11];
                int i13 = i11 + 1;
                int i14 = (int) fArr[i13];
                if (i12 < -1 || i12 > i9 || i14 < -1 || i14 > i10) {
                    throw NotFoundException.l;
                }
                if (i12 == -1) {
                    fArr[i11] = 0.0f;
                } else {
                    if (i12 == i9) {
                        fArr[i11] = i9 - 1;
                    } else {
                        z2 = false;
                    }
                    if (i14 == -1) {
                        fArr[i13] = 0.0f;
                    } else {
                        if (i14 == i10) {
                            fArr[i13] = i10 - 1;
                        }
                    }
                    z2 = true;
                }
                z2 = true;
                if (i14 == -1) {
                    fArr[i13] = 0.0f;
                } else {
                    if (i14 == i10) {
                        fArr[i13] = i10 - 1;
                    }
                }
                z2 = true;
            }
            boolean z3 = true;
            for (int i15 = i4 - 2; i15 >= 0 && z3; i15 -= 2) {
                int i16 = (int) fArr[i15];
                int i17 = i15 + 1;
                int i18 = (int) fArr[i17];
                if (i16 < -1 || i16 > i9 || i18 < -1 || i18 > i10) {
                    throw NotFoundException.l;
                }
                if (i16 == -1) {
                    fArr[i15] = 0.0f;
                } else {
                    if (i16 == i9) {
                        fArr[i15] = i9 - 1;
                    } else {
                        z3 = false;
                    }
                    if (i18 == -1) {
                        fArr[i17] = 0.0f;
                    } else {
                        if (i18 == i10) {
                            fArr[i17] = i10 - 1;
                        }
                    }
                    z3 = true;
                }
                z3 = true;
                if (i18 == -1) {
                    fArr[i17] = 0.0f;
                } else {
                    if (i18 == i10) {
                        fArr[i17] = i10 - 1;
                    }
                }
                z3 = true;
            }
            for (int i19 = 0; i19 < i4; i19 += 2) {
                try {
                    if (bitMatrix.f((int) fArr[i19], (int) fArr[i19 + 1])) {
                        bitMatrix2.j(i19 / 2, i5);
                    }
                } catch (ArrayIndexOutOfBoundsException unused) {
                    throw NotFoundException.l;
                }
            }
            i5++;
            i3 = i2;
        }
        return bitMatrix2;
    }
}
