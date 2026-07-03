package p007b.p225i.p226a.p242c.p263t2;

import androidx.core.view.PointerIconCompat;
import p007b.p225i.p226a.p242c.p259f3.C2756w;
import p007b.p225i.p226a.p242c.p259f3.C2757x;

/* JADX INFO: renamed from: b.i.a.c.t2.n */
/* JADX INFO: compiled from: Ac4Util.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C2930n {

    /* JADX INFO: renamed from: a */
    public static final int[] f7775a = {2002, 2000, 1920, 1601, 1600, PointerIconCompat.TYPE_CONTEXT_MENU, 1000, 960, 800, 800, 480, 400, 400, 2048};

    /* JADX INFO: renamed from: b.i.a.c.t2.n$b */
    /* JADX INFO: compiled from: Ac4Util.java */
    public static final class b {

        /* JADX INFO: renamed from: a */
        public final int f7776a;

        /* JADX INFO: renamed from: b */
        public final int f7777b;

        /* JADX INFO: renamed from: c */
        public final int f7778c;

        public b(int i, int i2, int i3, int i4, int i5, a aVar) {
            this.f7776a = i3;
            this.f7777b = i4;
            this.f7778c = i5;
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m3492a(int i, C2757x c2757x) {
        c2757x.m3075A(7);
        byte[] bArr = c2757x.f6793a;
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
    /* JADX INFO: renamed from: b */
    public static b m3493b(C2756w c2756w) {
        int i;
        int i2;
        int iM3067g;
        int iM3067g2 = c2756w.m3067g(16);
        int iM3067g3 = c2756w.m3067g(16);
        if (iM3067g3 == 65535) {
            iM3067g3 = c2756w.m3067g(24);
            i = 7;
        } else {
            i = 4;
        }
        int i3 = iM3067g3 + i;
        if (iM3067g2 == 44097) {
            i3 += 2;
        }
        int i4 = i3;
        int iM3067g4 = c2756w.m3067g(2);
        if (iM3067g4 == 3) {
            int i5 = 0;
            while (true) {
                iM3067g = c2756w.m3067g(2) + i5;
                if (!c2756w.m3066f()) {
                    break;
                }
                i5 = (iM3067g + 1) << 2;
            }
            iM3067g4 += iM3067g;
        }
        int iM3067g5 = c2756w.m3067g(10);
        if (c2756w.m3066f() && c2756w.m3067g(3) > 0) {
            c2756w.m3073m(2);
        }
        int i6 = c2756w.m3066f() ? 48000 : 44100;
        int iM3067g6 = c2756w.m3067g(4);
        if (i6 == 44100 && iM3067g6 == 13) {
            i2 = f7775a[iM3067g6];
        } else if (i6 == 48000) {
            int[] iArr = f7775a;
            if (iM3067g6 < iArr.length) {
                int i7 = iArr[iM3067g6];
                int i8 = iM3067g5 % 5;
                if (i8 == 1) {
                    if (iM3067g6 != 3 || iM3067g6 == 8) {
                        i7++;
                    }
                } else if (i8 != 2) {
                    if (i8 != 3) {
                        if (i8 == 4 && (iM3067g6 == 3 || iM3067g6 == 8 || iM3067g6 == 11)) {
                            i7++;
                        }
                    } else if (iM3067g6 != 3) {
                        i7++;
                    } else {
                        i7++;
                    }
                } else if (iM3067g6 == 8 || iM3067g6 == 11) {
                    i7++;
                }
                i2 = i7;
            } else {
                i2 = 0;
            }
        } else {
            i2 = 0;
        }
        return new b(iM3067g4, 2, i6, i4, i2, null);
    }
}
