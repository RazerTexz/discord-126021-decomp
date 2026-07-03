package p007b.p225i.p414e.p418n;

import java.util.Arrays;

/* JADX INFO: renamed from: b.i.e.n.b */
/* JADX INFO: compiled from: BitMatrix.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C4963b implements Cloneable {

    /* JADX INFO: renamed from: j */
    public final int f13229j;

    /* JADX INFO: renamed from: k */
    public final int f13230k;

    /* JADX INFO: renamed from: l */
    public final int f13231l;

    /* JADX INFO: renamed from: m */
    public final int[] f13232m;

    public C4963b(int i, int i2) {
        if (i <= 0 || i2 <= 0) {
            throw new IllegalArgumentException("Both dimensions must be greater than 0");
        }
        this.f13229j = i;
        this.f13230k = i2;
        int i3 = (i + 31) / 32;
        this.f13231l = i3;
        this.f13232m = new int[i3 * i2];
    }

    /* JADX INFO: renamed from: b */
    public void m6941b(int i, int i2) {
        int i3 = (i / 32) + (i2 * this.f13231l);
        int[] iArr = this.f13232m;
        iArr[i3] = (1 << (i & 31)) ^ iArr[i3];
    }

    public Object clone() throws CloneNotSupportedException {
        return new C4963b(this.f13229j, this.f13230k, this.f13231l, (int[]) this.f13232m.clone());
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C4963b)) {
            return false;
        }
        C4963b c4963b = (C4963b) obj;
        return this.f13229j == c4963b.f13229j && this.f13230k == c4963b.f13230k && this.f13231l == c4963b.f13231l && Arrays.equals(this.f13232m, c4963b.f13232m);
    }

    /* JADX INFO: renamed from: f */
    public boolean m6942f(int i, int i2) {
        return ((this.f13232m[(i / 32) + (i2 * this.f13231l)] >>> (i & 31)) & 1) != 0;
    }

    /* JADX INFO: renamed from: g */
    public int[] m6943g() {
        int length = this.f13232m.length - 1;
        while (length >= 0 && this.f13232m[length] == 0) {
            length--;
        }
        if (length < 0) {
            return null;
        }
        int i = this.f13231l;
        int i2 = length / i;
        int i3 = (length % i) << 5;
        int i4 = 31;
        while ((this.f13232m[length] >>> i4) == 0) {
            i4--;
        }
        return new int[]{i3 + i4, i2};
    }

    /* JADX INFO: renamed from: h */
    public C4962a m6944h(int i, C4962a c4962a) {
        int i2 = c4962a.f13228k;
        int i3 = this.f13229j;
        if (i2 < i3) {
            c4962a = new C4962a(i3);
        } else {
            int length = c4962a.f13227j.length;
            for (int i4 = 0; i4 < length; i4++) {
                c4962a.f13227j[i4] = 0;
            }
        }
        int i5 = i * this.f13231l;
        for (int i6 = 0; i6 < this.f13231l; i6++) {
            c4962a.f13227j[(i6 << 5) / 32] = this.f13232m[i5 + i6];
        }
        return c4962a;
    }

    public int hashCode() {
        int i = this.f13229j;
        return Arrays.hashCode(this.f13232m) + (((((((i * 31) + i) * 31) + this.f13230k) * 31) + this.f13231l) * 31);
    }

    /* JADX INFO: renamed from: i */
    public int[] m6945i() {
        int[] iArr;
        int i = 0;
        while (true) {
            iArr = this.f13232m;
            if (i >= iArr.length || iArr[i] != 0) {
                break;
            }
            i++;
        }
        if (i == iArr.length) {
            return null;
        }
        int i2 = this.f13231l;
        int i3 = i / i2;
        int i4 = (i % i2) << 5;
        int i5 = iArr[i];
        int i6 = 0;
        while ((i5 << (31 - i6)) == 0) {
            i6++;
        }
        return new int[]{i4 + i6, i3};
    }

    /* JADX INFO: renamed from: j */
    public void m6946j(int i, int i2) {
        int i3 = (i / 32) + (i2 * this.f13231l);
        int[] iArr = this.f13232m;
        iArr[i3] = (1 << (i & 31)) | iArr[i3];
    }

    /* JADX INFO: renamed from: k */
    public void m6947k(int i, int i2, int i3, int i4) {
        if (i2 < 0 || i < 0) {
            throw new IllegalArgumentException("Left and top must be nonnegative");
        }
        if (i4 <= 0 || i3 <= 0) {
            throw new IllegalArgumentException("Height and width must be at least 1");
        }
        int i5 = i3 + i;
        int i6 = i4 + i2;
        if (i6 > this.f13230k || i5 > this.f13229j) {
            throw new IllegalArgumentException("The region must fit inside the matrix");
        }
        while (i2 < i6) {
            int i7 = this.f13231l * i2;
            for (int i8 = i; i8 < i5; i8++) {
                int[] iArr = this.f13232m;
                int i9 = (i8 / 32) + i7;
                iArr[i9] = iArr[i9] | (1 << (i8 & 31));
            }
            i2++;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder((this.f13229j + 1) * this.f13230k);
        for (int i = 0; i < this.f13230k; i++) {
            for (int i2 = 0; i2 < this.f13229j; i2++) {
                sb.append(m6942f(i2, i) ? "X " : "  ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public C4963b(int i, int i2, int i3, int[] iArr) {
        this.f13229j = i;
        this.f13230k = i2;
        this.f13231l = i3;
        this.f13232m = iArr;
    }
}
