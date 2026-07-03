package p507d0.p510c0;

import java.io.Serializable;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p588x.C12196b;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.c0.c */
/* JADX INFO: compiled from: Random.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC11216c {

    /* JADX INFO: renamed from: k */
    public static final a f22272k = new a(null);

    /* JADX INFO: renamed from: j */
    public static final AbstractC11216c f22271j = C12196b.f25252a.defaultPlatformRandom();

    /* JADX INFO: renamed from: d0.c0.c$a */
    /* JADX INFO: compiled from: Random.kt */
    public static final class a extends AbstractC11216c implements Serializable {

        /* JADX INFO: renamed from: d0.c0.c$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: Random.kt */
        public static final class C13299a implements Serializable {

            /* JADX INFO: renamed from: j */
            public static final C13299a f22273j = new C13299a();
            private static final long serialVersionUID = 0;

            private final Object readResolve() {
                return AbstractC11216c.f22272k;
            }
        }

        public a() {
        }

        private final Object writeReplace() {
            return C13299a.f22273j;
        }

        @Override // p507d0.p510c0.AbstractC11216c
        public int nextBits(int i) {
            return AbstractC11216c.f22271j.nextBits(i);
        }

        @Override // p507d0.p510c0.AbstractC11216c
        public byte[] nextBytes(byte[] bArr) {
            C12238m.checkNotNullParameter(bArr, "array");
            return AbstractC11216c.f22271j.nextBytes(bArr);
        }

        @Override // p507d0.p510c0.AbstractC11216c
        public int nextInt() {
            return AbstractC11216c.f22271j.nextInt();
        }

        @Override // p507d0.p510c0.AbstractC11216c
        public long nextLong() {
            return AbstractC11216c.f22271j.nextLong();
        }

        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        @Override // p507d0.p510c0.AbstractC11216c
        public byte[] nextBytes(int i) {
            return AbstractC11216c.f22271j.nextBytes(i);
        }

        @Override // p507d0.p510c0.AbstractC11216c
        public int nextInt(int i) {
            return AbstractC11216c.f22271j.nextInt(i);
        }

        @Override // p507d0.p510c0.AbstractC11216c
        public byte[] nextBytes(byte[] bArr, int i, int i2) {
            C12238m.checkNotNullParameter(bArr, "array");
            return AbstractC11216c.f22271j.nextBytes(bArr, i, i2);
        }

        @Override // p507d0.p510c0.AbstractC11216c
        public int nextInt(int i, int i2) {
            return AbstractC11216c.f22271j.nextInt(i, i2);
        }
    }

    public abstract int nextBits(int i);

    /* JADX WARN: Code duplicated, block: B:11:0x0015  */
    public byte[] nextBytes(byte[] bArr, int i, int i2) {
        boolean z2;
        C12238m.checkNotNullParameter(bArr, "array");
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
            throw new IllegalArgumentException(C1643a.m813A(C1643a.m835W("fromIndex (", i, ") or toIndex (", i2, ") are out of range: 0.."), bArr.length, '.').toString());
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
        C11217d.checkRangeBounds(i, i2);
        int i4 = i2 - i;
        if (i4 > 0 || i4 == Integer.MIN_VALUE) {
            if (((-i4) & i4) == i4) {
                iNextBits = nextBits(C11217d.fastLog2(i4));
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
        C12238m.checkNotNullParameter(bArr, "array");
        return nextBytes(bArr, 0, bArr.length);
    }

    public byte[] nextBytes(int i) {
        return nextBytes(new byte[i]);
    }
}
