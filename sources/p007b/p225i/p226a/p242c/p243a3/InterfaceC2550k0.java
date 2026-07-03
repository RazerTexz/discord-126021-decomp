package p007b.p225i.p226a.p242c.p243a3;

import java.util.Arrays;
import java.util.Random;

/* JADX INFO: renamed from: b.i.a.c.a3.k0 */
/* JADX INFO: compiled from: ShuffleOrder.java */
/* JADX INFO: loaded from: classes3.dex */
public interface InterfaceC2550k0 {
    /* JADX INFO: renamed from: a */
    InterfaceC2550k0 mo2543a(int i, int i2);

    /* JADX INFO: renamed from: b */
    int mo2544b();

    /* JADX INFO: renamed from: c */
    int mo2545c();

    /* JADX INFO: renamed from: d */
    int mo2546d(int i);

    /* JADX INFO: renamed from: e */
    int mo2547e(int i);

    /* JADX INFO: renamed from: f */
    InterfaceC2550k0 mo2548f(int i, int i2);

    /* JADX INFO: renamed from: g */
    int mo2549g();

    /* JADX INFO: renamed from: h */
    InterfaceC2550k0 mo2550h();

    /* JADX INFO: renamed from: b.i.a.c.a3.k0$a */
    /* JADX INFO: compiled from: ShuffleOrder.java */
    public static class a implements InterfaceC2550k0 {

        /* JADX INFO: renamed from: a */
        public final Random f5630a;

        /* JADX INFO: renamed from: b */
        public final int[] f5631b;

        /* JADX INFO: renamed from: c */
        public final int[] f5632c;

        public a(int[] iArr, Random random) {
            this.f5631b = iArr;
            this.f5630a = random;
            this.f5632c = new int[iArr.length];
            for (int i = 0; i < iArr.length; i++) {
                this.f5632c[iArr[i]] = i;
            }
        }

        @Override // p007b.p225i.p226a.p242c.p243a3.InterfaceC2550k0
        /* JADX INFO: renamed from: a */
        public InterfaceC2550k0 mo2543a(int i, int i2) {
            int i3 = i2 - i;
            int[] iArr = new int[this.f5631b.length - i3];
            int i4 = 0;
            int i5 = 0;
            while (true) {
                int[] iArr2 = this.f5631b;
                if (i4 >= iArr2.length) {
                    return new a(iArr, new Random(this.f5630a.nextLong()));
                }
                if (iArr2[i4] < i || iArr2[i4] >= i2) {
                    iArr[i4 - i5] = iArr2[i4] >= i ? iArr2[i4] - i3 : iArr2[i4];
                } else {
                    i5++;
                }
                i4++;
            }
        }

        @Override // p007b.p225i.p226a.p242c.p243a3.InterfaceC2550k0
        /* JADX INFO: renamed from: b */
        public int mo2544b() {
            return this.f5631b.length;
        }

        @Override // p007b.p225i.p226a.p242c.p243a3.InterfaceC2550k0
        /* JADX INFO: renamed from: c */
        public int mo2545c() {
            int[] iArr = this.f5631b;
            if (iArr.length > 0) {
                return iArr[0];
            }
            return -1;
        }

        @Override // p007b.p225i.p226a.p242c.p243a3.InterfaceC2550k0
        /* JADX INFO: renamed from: d */
        public int mo2546d(int i) {
            int i2 = this.f5632c[i] - 1;
            if (i2 >= 0) {
                return this.f5631b[i2];
            }
            return -1;
        }

        @Override // p007b.p225i.p226a.p242c.p243a3.InterfaceC2550k0
        /* JADX INFO: renamed from: e */
        public int mo2547e(int i) {
            int i2 = this.f5632c[i] + 1;
            int[] iArr = this.f5631b;
            if (i2 < iArr.length) {
                return iArr[i2];
            }
            return -1;
        }

        @Override // p007b.p225i.p226a.p242c.p243a3.InterfaceC2550k0
        /* JADX INFO: renamed from: f */
        public InterfaceC2550k0 mo2548f(int i, int i2) {
            int[] iArr = new int[i2];
            int[] iArr2 = new int[i2];
            int i3 = 0;
            int i4 = 0;
            while (i4 < i2) {
                iArr[i4] = this.f5630a.nextInt(this.f5631b.length + 1);
                int i5 = i4 + 1;
                int iNextInt = this.f5630a.nextInt(i5);
                iArr2[i4] = iArr2[iNextInt];
                iArr2[iNextInt] = i4 + i;
                i4 = i5;
            }
            Arrays.sort(iArr);
            int[] iArr3 = new int[this.f5631b.length + i2];
            int i6 = 0;
            int i7 = 0;
            while (true) {
                int[] iArr4 = this.f5631b;
                if (i3 >= iArr4.length + i2) {
                    return new a(iArr3, new Random(this.f5630a.nextLong()));
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

        @Override // p007b.p225i.p226a.p242c.p243a3.InterfaceC2550k0
        /* JADX INFO: renamed from: g */
        public int mo2549g() {
            int[] iArr = this.f5631b;
            if (iArr.length > 0) {
                return iArr[iArr.length - 1];
            }
            return -1;
        }

        @Override // p007b.p225i.p226a.p242c.p243a3.InterfaceC2550k0
        /* JADX INFO: renamed from: h */
        public InterfaceC2550k0 mo2550h() {
            return new a(0, new Random(this.f5630a.nextLong()));
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
