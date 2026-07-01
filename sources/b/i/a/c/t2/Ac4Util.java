package b.i.a.c.t2;

import androidx.core.view.PointerIconCompat;
import b.i.a.c.f3.ParsableBitArray;
import b.i.a.c.f3.ParsableByteArray;

/* JADX INFO: renamed from: b.i.a.c.t2.n, reason: use source file name */
/* JADX INFO: compiled from: Ac4Util.java */
/* JADX INFO: loaded from: classes3.dex */
public final class Ac4Util {
    public static final int[] a = {2002, 2000, 1920, 1601, 1600, PointerIconCompat.TYPE_CONTEXT_MENU, 1000, 960, 800, 800, 480, 400, 400, 2048};

    /* JADX INFO: renamed from: b.i.a.c.t2.n$b */
    /* JADX INFO: compiled from: Ac4Util.java */
    public static final class b {
        public final int a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f1124b;
        public final int c;

        public b(int i, int i2, int i3, int i4, int i5, a aVar) {
            this.a = i3;
            this.f1124b = i4;
            this.c = i5;
        }
    }

    public static void a(int i, ParsableByteArray parsableByteArray) {
        parsableByteArray.A(7);
        byte[] bArr = parsableByteArray.a;
        bArr[0] = -84;
        bArr[1] = 64;
        bArr[2] = -1;
        bArr[3] = -1;
        bArr[4] = (byte) ((i >> 16) & 255);
        bArr[5] = (byte) ((i >> 8) & 255);
        bArr[6] = (byte) (i & 255);
    }

    /* JADX WARN: Code duplicated, block: B:47:0x009b  */
    /* JADX WARN: Code duplicated, block: B:51:0x00a2  */
    /* JADX WARN: Code duplicated, block: B:52:0x00a5  */
    public static b b(ParsableBitArray parsableBitArray) {
        int i;
        int i2;
        int iG;
        int iG2 = parsableBitArray.g(16);
        int iG3 = parsableBitArray.g(16);
        if (iG3 == 65535) {
            iG3 = parsableBitArray.g(24);
            i = 7;
        } else {
            i = 4;
        }
        int i3 = iG3 + i;
        if (iG2 == 44097) {
            i3 += 2;
        }
        int i4 = i3;
        int iG4 = parsableBitArray.g(2);
        if (iG4 == 3) {
            int i5 = 0;
            while (true) {
                iG = parsableBitArray.g(2) + i5;
                if (!parsableBitArray.f()) {
                    break;
                }
                i5 = (iG + 1) << 2;
            }
            iG4 += iG;
        }
        int iG5 = parsableBitArray.g(10);
        if (parsableBitArray.f() && parsableBitArray.g(3) > 0) {
            parsableBitArray.m(2);
        }
        int i6 = parsableBitArray.f() ? 48000 : 44100;
        int iG6 = parsableBitArray.g(4);
        if (i6 == 44100 && iG6 == 13) {
            i2 = a[iG6];
        } else if (i6 == 48000) {
            int[] iArr = a;
            if (iG6 < iArr.length) {
                int i7 = iArr[iG6];
                int i8 = iG5 % 5;
                if (i8 == 1) {
                    if (iG6 != 3 || iG6 == 8) {
                        i7++;
                    }
                } else if (i8 != 2) {
                    if (i8 != 3) {
                        if (i8 == 4 && (iG6 == 3 || iG6 == 8 || iG6 == 11)) {
                            i7++;
                        }
                    } else if (iG6 != 3) {
                        i7++;
                    } else {
                        i7++;
                    }
                } else if (iG6 == 8 || iG6 == 11) {
                    i7++;
                }
                i2 = i7;
            } else {
                i2 = 0;
            }
        } else {
            i2 = 0;
        }
        return new b(iG4, 2, i6, i4, i2, null);
    }
}
