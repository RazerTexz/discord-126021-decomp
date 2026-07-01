package b.i.e.n;

import java.util.Arrays;

/* JADX INFO: renamed from: b.i.e.n.b, reason: use source file name */
/* JADX INFO: compiled from: BitMatrix.java */
/* JADX INFO: loaded from: classes3.dex */
public final class BitMatrix implements Cloneable {
    public final int j;
    public final int k;
    public final int l;
    public final int[] m;

    public BitMatrix(int i, int i2) {
        if (i <= 0 || i2 <= 0) {
            throw new IllegalArgumentException("Both dimensions must be greater than 0");
        }
        this.j = i;
        this.k = i2;
        int i3 = (i + 31) / 32;
        this.l = i3;
        this.m = new int[i3 * i2];
    }

    public void b(int i, int i2) {
        int i3 = (i / 32) + (i2 * this.l);
        int[] iArr = this.m;
        iArr[i3] = (1 << (i & 31)) ^ iArr[i3];
    }

    public Object clone() throws CloneNotSupportedException {
        return new BitMatrix(this.j, this.k, this.l, (int[]) this.m.clone());
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof BitMatrix)) {
            return false;
        }
        BitMatrix bitMatrix = (BitMatrix) obj;
        return this.j == bitMatrix.j && this.k == bitMatrix.k && this.l == bitMatrix.l && Arrays.equals(this.m, bitMatrix.m);
    }

    public boolean f(int i, int i2) {
        return ((this.m[(i / 32) + (i2 * this.l)] >>> (i & 31)) & 1) != 0;
    }

    public int[] g() {
        int length = this.m.length - 1;
        while (length >= 0 && this.m[length] == 0) {
            length--;
        }
        if (length < 0) {
            return null;
        }
        int i = this.l;
        int i2 = length / i;
        int i3 = (length % i) << 5;
        int i4 = 31;
        while ((this.m[length] >>> i4) == 0) {
            i4--;
        }
        return new int[]{i3 + i4, i2};
    }

    public BitArray h(int i, BitArray bitArray) {
        int i2 = bitArray.k;
        int i3 = this.j;
        if (i2 < i3) {
            bitArray = new BitArray(i3);
        } else {
            int length = bitArray.j.length;
            for (int i4 = 0; i4 < length; i4++) {
                bitArray.j[i4] = 0;
            }
        }
        int i5 = i * this.l;
        for (int i6 = 0; i6 < this.l; i6++) {
            bitArray.j[(i6 << 5) / 32] = this.m[i5 + i6];
        }
        return bitArray;
    }

    public int hashCode() {
        int i = this.j;
        return Arrays.hashCode(this.m) + (((((((i * 31) + i) * 31) + this.k) * 31) + this.l) * 31);
    }

    public int[] i() {
        int[] iArr;
        int i = 0;
        while (true) {
            iArr = this.m;
            if (i >= iArr.length || iArr[i] != 0) {
                break;
            }
            i++;
        }
        if (i == iArr.length) {
            return null;
        }
        int i2 = this.l;
        int i3 = i / i2;
        int i4 = (i % i2) << 5;
        int i5 = iArr[i];
        int i6 = 0;
        while ((i5 << (31 - i6)) == 0) {
            i6++;
        }
        return new int[]{i4 + i6, i3};
    }

    public void j(int i, int i2) {
        int i3 = (i / 32) + (i2 * this.l);
        int[] iArr = this.m;
        iArr[i3] = (1 << (i & 31)) | iArr[i3];
    }

    public void k(int i, int i2, int i3, int i4) {
        if (i2 < 0 || i < 0) {
            throw new IllegalArgumentException("Left and top must be nonnegative");
        }
        if (i4 <= 0 || i3 <= 0) {
            throw new IllegalArgumentException("Height and width must be at least 1");
        }
        int i5 = i3 + i;
        int i6 = i4 + i2;
        if (i6 > this.k || i5 > this.j) {
            throw new IllegalArgumentException("The region must fit inside the matrix");
        }
        while (i2 < i6) {
            int i7 = this.l * i2;
            for (int i8 = i; i8 < i5; i8++) {
                int[] iArr = this.m;
                int i9 = (i8 / 32) + i7;
                iArr[i9] = iArr[i9] | (1 << (i8 & 31));
            }
            i2++;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder((this.j + 1) * this.k);
        for (int i = 0; i < this.k; i++) {
            for (int i2 = 0; i2 < this.j; i2++) {
                sb.append(f(i2, i) ? "X " : "  ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public BitMatrix(int i, int i2, int i3, int[] iArr) {
        this.j = i;
        this.k = i2;
        this.l = i3;
        this.m = iArr;
    }
}
