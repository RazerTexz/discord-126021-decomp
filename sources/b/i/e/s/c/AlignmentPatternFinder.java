package b.i.e.s.c;

import b.i.e.ResultPointCallback;
import b.i.e.n.BitMatrix;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: renamed from: b.i.e.s.c.b, reason: use source file name */
/* JADX INFO: compiled from: AlignmentPatternFinder.java */
/* JADX INFO: loaded from: classes3.dex */
public final class AlignmentPatternFinder {
    public final BitMatrix a;
    public final int c;
    public final int d;
    public final int e;
    public final int f;
    public final float g;
    public final ResultPointCallback i;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<AlignmentPattern> f1893b = new ArrayList(5);
    public final int[] h = new int[3];

    public AlignmentPatternFinder(BitMatrix bitMatrix, int i, int i2, int i3, int i4, float f, ResultPointCallback resultPointCallback) {
        this.a = bitMatrix;
        this.c = i;
        this.d = i2;
        this.e = i3;
        this.f = i4;
        this.g = f;
        this.i = resultPointCallback;
    }

    public static float a(int[] iArr, int i) {
        return (i - iArr[2]) - (iArr[1] / 2.0f);
    }

    public final boolean b(int[] iArr) {
        float f = this.g;
        float f2 = f / 2.0f;
        for (int i = 0; i < 3; i++) {
            if (Math.abs(f - iArr[i]) >= f2) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:63:0x00fd  */
    public final AlignmentPattern c(int[] iArr, int i, int i2) {
        boolean z2;
        int i3 = iArr[0] + iArr[1] + iArr[2];
        float fA = a(iArr, i2);
        int i4 = (int) fA;
        int i5 = iArr[1] * 2;
        BitMatrix bitMatrix = this.a;
        int i6 = bitMatrix.k;
        int[] iArr2 = this.h;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        int i7 = i;
        while (i7 >= 0 && bitMatrix.f(i4, i7) && iArr2[1] <= i5) {
            iArr2[1] = iArr2[1] + 1;
            i7--;
        }
        float fA2 = Float.NaN;
        if (i7 >= 0 && iArr2[1] <= i5) {
            while (i7 >= 0 && !bitMatrix.f(i4, i7) && iArr2[0] <= i5) {
                iArr2[0] = iArr2[0] + 1;
                i7--;
            }
            if (iArr2[0] <= i5) {
                int i8 = i + 1;
                while (i8 < i6 && bitMatrix.f(i4, i8) && iArr2[1] <= i5) {
                    iArr2[1] = iArr2[1] + 1;
                    i8++;
                }
                if (i8 != i6 && iArr2[1] <= i5) {
                    while (i8 < i6 && !bitMatrix.f(i4, i8) && iArr2[2] <= i5) {
                        iArr2[2] = iArr2[2] + 1;
                        i8++;
                    }
                    if (iArr2[2] <= i5 && Math.abs(((iArr2[0] + iArr2[1]) + iArr2[2]) - i3) * 5 < i3 * 2 && b(iArr2)) {
                        fA2 = a(iArr2, i8);
                    }
                }
            }
        }
        if (Float.isNaN(fA2)) {
            return null;
        }
        float f = ((iArr[0] + iArr[1]) + iArr[2]) / 3.0f;
        for (AlignmentPattern alignmentPattern : this.f1893b) {
            if (Math.abs(fA2 - alignmentPattern.f1826b) > f || Math.abs(fA - alignmentPattern.a) > f) {
                z2 = false;
            } else {
                float fAbs = Math.abs(f - alignmentPattern.c);
                if (fAbs <= 1.0f || fAbs <= alignmentPattern.c) {
                    z2 = true;
                } else {
                    z2 = false;
                }
            }
            if (z2) {
                return new AlignmentPattern((alignmentPattern.a + fA) / 2.0f, (alignmentPattern.f1826b + fA2) / 2.0f, (alignmentPattern.c + f) / 2.0f);
            }
        }
        AlignmentPattern alignmentPattern2 = new AlignmentPattern(fA, fA2, f);
        this.f1893b.add(alignmentPattern2);
        ResultPointCallback resultPointCallback = this.i;
        if (resultPointCallback == null) {
            return null;
        }
        resultPointCallback.a(alignmentPattern2);
        return null;
    }
}
