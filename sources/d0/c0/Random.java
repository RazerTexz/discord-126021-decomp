package d0.c0;

import b.d.b.a.outline;
import d0.x.PlatformImplementations2;
import d0.z.d.Intrinsics3;
import java.io.Serializable;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: renamed from: d0.c0.c, reason: use source file name */
/* JADX INFO: compiled from: Random.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class Random {
    public static final a k = new a(null);
    public static final Random j = PlatformImplementations2.a.defaultPlatformRandom();

    /* JADX INFO: renamed from: d0.c0.c$a */
    /* JADX INFO: compiled from: Random.kt */
    public static final class a extends Random implements Serializable {

        /* JADX INFO: renamed from: d0.c0.c$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: Random.kt */
        public static final class C0372a implements Serializable {
            public static final C0372a j = new C0372a();
            private static final long serialVersionUID = 0;

            private final Object readResolve() {
                return Random.k;
            }
        }

        public a() {
        }

        private final Object writeReplace() {
            return C0372a.j;
        }

        @Override // d0.c0.Random
        public int nextBits(int i) {
            return Random.j.nextBits(i);
        }

        @Override // d0.c0.Random
        public byte[] nextBytes(byte[] bArr) {
            Intrinsics3.checkNotNullParameter(bArr, "array");
            return Random.j.nextBytes(bArr);
        }

        @Override // d0.c0.Random
        public int nextInt() {
            return Random.j.nextInt();
        }

        @Override // d0.c0.Random
        public long nextLong() {
            return Random.j.nextLong();
        }

        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        @Override // d0.c0.Random
        public byte[] nextBytes(int i) {
            return Random.j.nextBytes(i);
        }

        @Override // d0.c0.Random
        public int nextInt(int i) {
            return Random.j.nextInt(i);
        }

        @Override // d0.c0.Random
        public byte[] nextBytes(byte[] bArr, int i, int i2) {
            Intrinsics3.checkNotNullParameter(bArr, "array");
            return Random.j.nextBytes(bArr, i, i2);
        }

        @Override // d0.c0.Random
        public int nextInt(int i, int i2) {
            return Random.j.nextInt(i, i2);
        }
    }

    public abstract int nextBits(int i);

    /* JADX WARN: Code duplicated, block: B:11:0x0015  */
    public byte[] nextBytes(byte[] bArr, int i, int i2) {
        boolean z2;
        Intrinsics3.checkNotNullParameter(bArr, "array");
        int length = bArr.length;
        if (i >= 0 && length >= i) {
            int length2 = bArr.length;
            if (i2 >= 0 && length2 >= i2) {
                z2 = true;
            } else {
                z2 = false;
            }
        } else {
            z2 = false;
        }
        if (!z2) {
            throw new IllegalArgumentException(outline.A(outline.W("fromIndex (", i, ") or toIndex (", i2, ") are out of range: 0.."), bArr.length, '.').toString());
        }
        if (!(i <= i2)) {
            throw new IllegalArgumentException(("fromIndex (" + i + ") must be not greater than toIndex (" + i2 + ").").toString());
        }
        int i3 = (i2 - i) / 4;
        for (int i4 = 0; i4 < i3; i4++) {
            int iNextInt = nextInt();
            bArr[i] = (byte) iNextInt;
            bArr[i + 1] = (byte) (iNextInt >>> 8);
            bArr[i + 2] = (byte) (iNextInt >>> 16);
            bArr[i + 3] = (byte) (iNextInt >>> 24);
            i += 4;
        }
        int i5 = i2 - i;
        int iNextBits = nextBits(i5 * 8);
        for (int i6 = 0; i6 < i5; i6++) {
            bArr[i + i6] = (byte) (iNextBits >>> (i6 * 8));
        }
        return bArr;
    }

    public abstract int nextInt();

    public int nextInt(int i) {
        return nextInt(0, i);
    }

    public long nextLong() {
        return (((long) nextInt()) << 32) + ((long) nextInt());
    }

    public int nextInt(int i, int i2) {
        int iNextInt;
        int i3;
        int iNextBits;
        Random2.checkRangeBounds(i, i2);
        int i4 = i2 - i;
        if (i4 > 0 || i4 == Integer.MIN_VALUE) {
            if (((-i4) & i4) == i4) {
                iNextBits = nextBits(Random2.fastLog2(i4));
            } else {
                do {
                    iNextInt = nextInt() >>> 1;
                    i3 = iNextInt % i4;
                } while ((i4 - 1) + (iNextInt - i3) < 0);
                iNextBits = i3;
            }
            return i + iNextBits;
        }
        while (true) {
            int iNextInt2 = nextInt();
            if (i <= iNextInt2 && i2 > iNextInt2) {
                return iNextInt2;
            }
        }
    }

    public byte[] nextBytes(byte[] bArr) {
        Intrinsics3.checkNotNullParameter(bArr, "array");
        return nextBytes(bArr, 0, bArr.length);
    }

    public byte[] nextBytes(int i) {
        return nextBytes(new byte[i]);
    }
}
