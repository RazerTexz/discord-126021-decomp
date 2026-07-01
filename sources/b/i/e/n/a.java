package b.i.e.n;

import java.util.Arrays;

/* JADX INFO: compiled from: BitArray.java */
/* JADX INFO: loaded from: classes3.dex */
public final class a implements Cloneable {
    public int[] j;
    public int k;

    public a() {
        this.k = 0;
        this.j = new int[1];
    }

    public boolean b(int i) {
        return ((1 << (i & 31)) & this.j[i / 32]) != 0;
    }

    public Object clone() throws CloneNotSupportedException {
        return new a((int[]) this.j.clone(), this.k);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.k == aVar.k && Arrays.equals(this.j, aVar.j);
    }

    public int f(int i) {
        int i2 = this.k;
        if (i >= i2) {
            return i2;
        }
        int i3 = i / 32;
        int i4 = (~((1 << (i & 31)) - 1)) & this.j[i3];
        while (i4 == 0) {
            i3++;
            int[] iArr = this.j;
            if (i3 == iArr.length) {
                return this.k;
            }
            i4 = iArr[i3];
        }
        int iNumberOfTrailingZeros = Integer.numberOfTrailingZeros(i4) + (i3 << 5);
        int i5 = this.k;
        return iNumberOfTrailingZeros > i5 ? i5 : iNumberOfTrailingZeros;
    }

    public int g(int i) {
        int i2 = this.k;
        if (i >= i2) {
            return i2;
        }
        int i3 = i / 32;
        int i4 = (~((1 << (i & 31)) - 1)) & (~this.j[i3]);
        while (i4 == 0) {
            i3++;
            int[] iArr = this.j;
            if (i3 == iArr.length) {
                return this.k;
            }
            i4 = ~iArr[i3];
        }
        int iNumberOfTrailingZeros = Integer.numberOfTrailingZeros(i4) + (i3 << 5);
        int i5 = this.k;
        return iNumberOfTrailingZeros > i5 ? i5 : iNumberOfTrailingZeros;
    }

    public boolean h(int i, int i2, boolean z2) {
        if (i2 < i || i < 0 || i2 > this.k) {
            throw new IllegalArgumentException();
        }
        if (i2 == i) {
            return true;
        }
        int i3 = i2 - 1;
        int i4 = i / 32;
        int i5 = i3 / 32;
        int i6 = i4;
        while (i6 <= i5) {
            int i7 = (2 << (i6 >= i5 ? 31 & i3 : 31)) - (1 << (i6 > i4 ? 0 : i & 31));
            int i8 = this.j[i6] & i7;
            if (!z2) {
                i7 = 0;
            }
            if (i8 != i7) {
                return false;
            }
            i6++;
        }
        return true;
    }

    public int hashCode() {
        return Arrays.hashCode(this.j) + (this.k * 31);
    }

    public void i() {
        int[] iArr = new int[this.j.length];
        int i = (this.k - 1) / 32;
        int i2 = i + 1;
        for (int i3 = 0; i3 < i2; i3++) {
            long j = this.j[i3];
            long j2 = ((j & 1431655765) << 1) | ((j >> 1) & 1431655765);
            long j3 = ((j2 & 858993459) << 2) | ((j2 >> 2) & 858993459);
            long j4 = ((j3 & 252645135) << 4) | ((j3 >> 4) & 252645135);
            long j5 = ((j4 & 16711935) << 8) | ((j4 >> 8) & 16711935);
            iArr[i - i3] = (int) (((j5 & 65535) << 16) | ((j5 >> 16) & 65535));
        }
        int i4 = this.k;
        int i5 = i2 << 5;
        if (i4 != i5) {
            int i6 = i5 - i4;
            int i7 = iArr[0] >>> i6;
            for (int i8 = 1; i8 < i2; i8++) {
                int i9 = iArr[i8];
                iArr[i8 - 1] = i7 | (i9 << (32 - i6));
                i7 = i9 >>> i6;
            }
            iArr[i2 - 1] = i7;
        }
        this.j = iArr;
    }

    public void j(int i) {
        int[] iArr = this.j;
        int i2 = i / 32;
        iArr[i2] = (1 << (i & 31)) | iArr[i2];
    }

    public String toString() {
        int i = this.k;
        StringBuilder sb = new StringBuilder((i / 8) + i + 1);
        for (int i2 = 0; i2 < this.k; i2++) {
            if ((i2 & 7) == 0) {
                sb.append(' ');
            }
            sb.append(b(i2) ? 'X' : '.');
        }
        return sb.toString();
    }

    public a(int i) {
        this.k = i;
        this.j = new int[(i + 31) / 32];
    }

    public a(int[] iArr, int i) {
        this.j = iArr;
        this.k = i;
    }
}
