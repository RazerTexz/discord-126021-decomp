package b.i.e.n.l;

import java.util.Objects;

/* JADX INFO: renamed from: b.i.e.n.l.b, reason: use source file name */
/* JADX INFO: compiled from: GenericGFPoly.java */
/* JADX INFO: loaded from: classes3.dex */
public final class GenericGFPoly {
    public final GenericGF a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int[] f1842b;

    public GenericGFPoly(GenericGF genericGF, int[] iArr) {
        if (iArr.length == 0) {
            throw new IllegalArgumentException();
        }
        this.a = genericGF;
        int length = iArr.length;
        if (length <= 1 || iArr[0] != 0) {
            this.f1842b = iArr;
            return;
        }
        int i = 1;
        while (i < length && iArr[i] == 0) {
            i++;
        }
        if (i == length) {
            this.f1842b = new int[]{0};
            return;
        }
        int[] iArr2 = new int[length - i];
        this.f1842b = iArr2;
        System.arraycopy(iArr, i, iArr2, 0, iArr2.length);
    }

    public GenericGFPoly a(GenericGFPoly genericGFPoly) {
        if (!this.a.equals(genericGFPoly.a)) {
            throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
        }
        if (e()) {
            return genericGFPoly;
        }
        if (genericGFPoly.e()) {
            return this;
        }
        int[] iArr = this.f1842b;
        int[] iArr2 = genericGFPoly.f1842b;
        if (iArr.length <= iArr2.length) {
            iArr = iArr2;
            iArr2 = iArr;
        }
        int[] iArr3 = new int[iArr.length];
        int length = iArr.length - iArr2.length;
        System.arraycopy(iArr, 0, iArr3, 0, length);
        for (int i = length; i < iArr.length; i++) {
            iArr3[i] = iArr2[i - length] ^ iArr[i];
        }
        return new GenericGFPoly(this.a, iArr3);
    }

    public int b(int i) {
        if (i == 0) {
            return c(0);
        }
        if (i != 1) {
            int[] iArr = this.f1842b;
            int iC = iArr[0];
            int length = iArr.length;
            for (int i2 = 1; i2 < length; i2++) {
                iC = this.a.c(i, iC) ^ this.f1842b[i2];
            }
            return iC;
        }
        int i3 = 0;
        for (int i4 : this.f1842b) {
            GenericGF genericGF = GenericGF.a;
            i3 ^= i4;
        }
        return i3;
    }

    public int c(int i) {
        int[] iArr = this.f1842b;
        return iArr[(iArr.length - 1) - i];
    }

    public int d() {
        return this.f1842b.length - 1;
    }

    public boolean e() {
        return this.f1842b[0] == 0;
    }

    public GenericGFPoly f(int i) {
        if (i == 0) {
            return this.a.k;
        }
        if (i == 1) {
            return this;
        }
        int length = this.f1842b.length;
        int[] iArr = new int[length];
        for (int i2 = 0; i2 < length; i2++) {
            iArr[i2] = this.a.c(this.f1842b[i2], i);
        }
        return new GenericGFPoly(this.a, iArr);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(d() * 8);
        for (int iD = d(); iD >= 0; iD--) {
            int iC = c(iD);
            if (iC != 0) {
                if (iC < 0) {
                    sb.append(" - ");
                    iC = -iC;
                } else if (sb.length() > 0) {
                    sb.append(" + ");
                }
                if (iD == 0 || iC != 1) {
                    GenericGF genericGF = this.a;
                    Objects.requireNonNull(genericGF);
                    if (iC == 0) {
                        throw new IllegalArgumentException();
                    }
                    int i = genericGF.j[iC];
                    if (i == 0) {
                        sb.append('1');
                    } else if (i == 1) {
                        sb.append('a');
                    } else {
                        sb.append("a^");
                        sb.append(i);
                    }
                }
                if (iD != 0) {
                    if (iD == 1) {
                        sb.append('x');
                    } else {
                        sb.append("x^");
                        sb.append(iD);
                    }
                }
            }
        }
        return sb.toString();
    }
}
