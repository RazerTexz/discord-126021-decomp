package b.i.e.s.c;

import b.i.e.l;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: AlignmentPatternFinder.java */
/* JADX INFO: loaded from: classes3.dex */
public final class b {
    public final b.i.e.n.b a;
    public final int c;
    public final int d;
    public final int e;
    public final int f;
    public final float g;
    public final l i;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<a> f1893b = new ArrayList(5);
    public final int[] h = new int[3];

    public b(b.i.e.n.b bVar, int i, int i2, int i3, int i4, float f, l lVar) {
        this.a = bVar;
        this.c = i;
        this.d = i2;
        this.e = i3;
        this.f = i4;
        this.g = f;
        this.i = lVar;
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
    public final a c(int[] iArr, int i, int i2) {
        boolean z2;
        int i3 = iArr[0] + iArr[1] + iArr[2];
        float fA = a(iArr, i2);
        int i4 = (int) fA;
        int i5 = iArr[1] * 2;
        b.i.e.n.b bVar = this.a;
        int i6 = bVar.k;
        int[] iArr2 = this.h;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        int i7 = i;
        while (i7 >= 0 && bVar.f(i4, i7) && iArr2[1] <= i5) {
            iArr2[1] = iArr2[1] + 1;
            i7--;
        }
        float fA2 = Float.NaN;
        if (i7 >= 0 && iArr2[1] <= i5) {
            while (i7 >= 0 && !bVar.f(i4, i7) && iArr2[0] <= i5) {
                iArr2[0] = iArr2[0] + 1;
                i7--;
            }
            if (iArr2[0] <= i5) {
                int i8 = i + 1;
                while (i8 < i6 && bVar.f(i4, i8) && iArr2[1] <= i5) {
                    iArr2[1] = iArr2[1] + 1;
                    i8++;
                }
                if (i8 != i6 && iArr2[1] <= i5) {
                    while (i8 < i6 && !bVar.f(i4, i8) && iArr2[2] <= i5) {
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
        for (a aVar : this.f1893b) {
            if (Math.abs(fA2 - aVar.f1826b) > f || Math.abs(fA - aVar.a) > f) {
                z2 = false;
            } else {
                float fAbs = Math.abs(f - aVar.c);
                if (fAbs <= 1.0f || fAbs <= aVar.c) {
                    z2 = true;
                } else {
                    z2 = false;
                }
            }
            if (z2) {
                return new a((aVar.a + fA) / 2.0f, (aVar.f1826b + fA2) / 2.0f, (aVar.c + f) / 2.0f);
            }
        }
        a aVar2 = new a(fA, fA2, f);
        this.f1893b.add(aVar2);
        l lVar = this.i;
        if (lVar == null) {
            return null;
        }
        lVar.a(aVar2);
        return null;
    }
}
