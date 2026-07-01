package b.i.e.r.d.k;

/* JADX INFO: renamed from: b.i.e.r.d.k.c, reason: use source file name */
/* JADX INFO: compiled from: ModulusPoly.java */
/* JADX INFO: loaded from: classes3.dex */
public final class ModulusPoly {
    public final ModulusGF a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int[] f1883b;

    public ModulusPoly(ModulusGF modulusGF, int[] iArr) {
        if (iArr.length == 0) {
            throw new IllegalArgumentException();
        }
        this.a = modulusGF;
        int length = iArr.length;
        if (length <= 1 || iArr[0] != 0) {
            this.f1883b = iArr;
            return;
        }
        int i = 1;
        while (i < length && iArr[i] == 0) {
            i++;
        }
        if (i == length) {
            this.f1883b = new int[]{0};
            return;
        }
        int[] iArr2 = new int[length - i];
        this.f1883b = iArr2;
        System.arraycopy(iArr, i, iArr2, 0, iArr2.length);
    }

    public ModulusPoly a(ModulusPoly modulusPoly) {
        if (!this.a.equals(modulusPoly.a)) {
            throw new IllegalArgumentException("ModulusPolys do not have same ModulusGF field");
        }
        if (e()) {
            return modulusPoly;
        }
        if (modulusPoly.e()) {
            return this;
        }
        int[] iArr = this.f1883b;
        int[] iArr2 = modulusPoly.f1883b;
        if (iArr.length <= iArr2.length) {
            iArr = iArr2;
            iArr2 = iArr;
        }
        int[] iArr3 = new int[iArr.length];
        int length = iArr.length - iArr2.length;
        System.arraycopy(iArr, 0, iArr3, 0, length);
        for (int i = length; i < iArr.length; i++) {
            iArr3[i] = this.a.a(iArr2[i - length], iArr[i]);
        }
        return new ModulusPoly(this.a, iArr3);
    }

    public int b(int i) {
        if (i == 0) {
            return c(0);
        }
        if (i == 1) {
            int iA = 0;
            for (int i2 : this.f1883b) {
                iA = this.a.a(iA, i2);
            }
            return iA;
        }
        int[] iArr = this.f1883b;
        int iA2 = iArr[0];
        int length = iArr.length;
        for (int i3 = 1; i3 < length; i3++) {
            ModulusGF modulusGF = this.a;
            iA2 = modulusGF.a(modulusGF.d(i, iA2), this.f1883b[i3]);
        }
        return iA2;
    }

    public int c(int i) {
        int[] iArr = this.f1883b;
        return iArr[(iArr.length - 1) - i];
    }

    public int d() {
        return this.f1883b.length - 1;
    }

    public boolean e() {
        return this.f1883b[0] == 0;
    }

    public ModulusPoly f(int i) {
        if (i == 0) {
            return this.a.d;
        }
        if (i == 1) {
            return this;
        }
        int length = this.f1883b.length;
        int[] iArr = new int[length];
        for (int i2 = 0; i2 < length; i2++) {
            iArr[i2] = this.a.d(this.f1883b[i2], i);
        }
        return new ModulusPoly(this.a, iArr);
    }

    public ModulusPoly g(ModulusPoly modulusPoly) {
        if (!this.a.equals(modulusPoly.a)) {
            throw new IllegalArgumentException("ModulusPolys do not have same ModulusGF field");
        }
        if (e() || modulusPoly.e()) {
            return this.a.d;
        }
        int[] iArr = this.f1883b;
        int length = iArr.length;
        int[] iArr2 = modulusPoly.f1883b;
        int length2 = iArr2.length;
        int[] iArr3 = new int[(length + length2) - 1];
        for (int i = 0; i < length; i++) {
            int i2 = iArr[i];
            for (int i3 = 0; i3 < length2; i3++) {
                int i4 = i + i3;
                ModulusGF modulusGF = this.a;
                iArr3[i4] = modulusGF.a(iArr3[i4], modulusGF.d(i2, iArr2[i3]));
            }
        }
        return new ModulusPoly(this.a, iArr3);
    }

    public ModulusPoly h() {
        int length = this.f1883b.length;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            iArr[i] = this.a.e(0, this.f1883b[i]);
        }
        return new ModulusPoly(this.a, iArr);
    }

    public ModulusPoly i(ModulusPoly modulusPoly) {
        if (this.a.equals(modulusPoly.a)) {
            return modulusPoly.e() ? this : a(modulusPoly.h());
        }
        throw new IllegalArgumentException("ModulusPolys do not have same ModulusGF field");
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
                    sb.append(iC);
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
