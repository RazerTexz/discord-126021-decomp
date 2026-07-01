package b.i.a.c.a3;

import java.util.Arrays;
import java.util.Random;

/* JADX INFO: renamed from: b.i.a.c.a3.k0, reason: use source file name */
/* JADX INFO: compiled from: ShuffleOrder.java */
/* JADX INFO: loaded from: classes3.dex */
public interface ShuffleOrder {
    ShuffleOrder a(int i, int i2);

    int b();

    int c();

    int d(int i);

    int e(int i);

    ShuffleOrder f(int i, int i2);

    int g();

    ShuffleOrder h();

    /* JADX INFO: renamed from: b.i.a.c.a3.k0$a */
    /* JADX INFO: compiled from: ShuffleOrder.java */
    public static class a implements ShuffleOrder {
        public final Random a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int[] f826b;
        public final int[] c;

        public a(int[] iArr, Random random) {
            this.f826b = iArr;
            this.a = random;
            this.c = new int[iArr.length];
            for (int i = 0; i < iArr.length; i++) {
                this.c[iArr[i]] = i;
            }
        }

        @Override // b.i.a.c.a3.ShuffleOrder
        public ShuffleOrder a(int i, int i2) {
            int i3 = i2 - i;
            int[] iArr = new int[this.f826b.length - i3];
            int i4 = 0;
            int i5 = 0;
            while (true) {
                int[] iArr2 = this.f826b;
                if (i4 >= iArr2.length) {
                    return new a(iArr, new Random(this.a.nextLong()));
                }
                if (iArr2[i4] < i || iArr2[i4] >= i2) {
                    iArr[i4 - i5] = iArr2[i4] >= i ? iArr2[i4] - i3 : iArr2[i4];
                } else {
                    i5++;
                }
                i4++;
            }
        }

        @Override // b.i.a.c.a3.ShuffleOrder
        public int b() {
            return this.f826b.length;
        }

        @Override // b.i.a.c.a3.ShuffleOrder
        public int c() {
            int[] iArr = this.f826b;
            if (iArr.length > 0) {
                return iArr[0];
            }
            return -1;
        }

        @Override // b.i.a.c.a3.ShuffleOrder
        public int d(int i) {
            int i2 = this.c[i] - 1;
            if (i2 >= 0) {
                return this.f826b[i2];
            }
            return -1;
        }

        @Override // b.i.a.c.a3.ShuffleOrder
        public int e(int i) {
            int i2 = this.c[i] + 1;
            int[] iArr = this.f826b;
            if (i2 < iArr.length) {
                return iArr[i2];
            }
            return -1;
        }

        @Override // b.i.a.c.a3.ShuffleOrder
        public ShuffleOrder f(int i, int i2) {
            int[] iArr = new int[i2];
            int[] iArr2 = new int[i2];
            int i3 = 0;
            int i4 = 0;
            while (i4 < i2) {
                iArr[i4] = this.a.nextInt(this.f826b.length + 1);
                int i5 = i4 + 1;
                int iNextInt = this.a.nextInt(i5);
                iArr2[i4] = iArr2[iNextInt];
                iArr2[iNextInt] = i4 + i;
                i4 = i5;
            }
            Arrays.sort(iArr);
            int[] iArr3 = new int[this.f826b.length + i2];
            int i6 = 0;
            int i7 = 0;
            while (true) {
                int[] iArr4 = this.f826b;
                if (i3 >= iArr4.length + i2) {
                    return new a(iArr3, new Random(this.a.nextLong()));
                }
                if (i6 >= i2 || i7 != iArr[i6]) {
                    int i8 = i7 + 1;
                    iArr3[i3] = iArr4[i7];
                    if (iArr3[i3] >= i) {
                        iArr3[i3] = iArr3[i3] + i2;
                    }
                    i7 = i8;
                } else {
                    iArr3[i3] = iArr2[i6];
                    i6++;
                }
                i3++;
            }
        }

        @Override // b.i.a.c.a3.ShuffleOrder
        public int g() {
            int[] iArr = this.f826b;
            if (iArr.length > 0) {
                return iArr[iArr.length - 1];
            }
            return -1;
        }

        @Override // b.i.a.c.a3.ShuffleOrder
        public ShuffleOrder h() {
            return new a(0, new Random(this.a.nextLong()));
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public a(int i, Random random) {
            int[] iArr = new int[i];
            int i2 = 0;
            while (i2 < i) {
                int i3 = i2 + 1;
                int iNextInt = random.nextInt(i3);
                iArr[i2] = iArr[iNextInt];
                iArr[iNextInt] = i2;
                i2 = i3;
            }
            this(iArr, random);
        }
    }
}
