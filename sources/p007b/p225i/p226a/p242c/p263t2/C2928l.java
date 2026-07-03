package p007b.p225i.p226a.p242c.p263t2;

import android.util.Log;
import com.google.android.exoplayer2.ParserException;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p226a.p242c.p259f3.C2756w;

/* JADX INFO: renamed from: b.i.a.c.t2.l */
/* JADX INFO: compiled from: AacUtil.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C2928l {

    /* JADX INFO: renamed from: a */
    public static final int[] f7764a = {96000, 88200, 64000, 48000, 44100, 32000, 24000, 22050, 16000, 12000, 11025, 8000, 7350};

    /* JADX INFO: renamed from: b */
    public static final int[] f7765b = {0, 1, 2, 3, 4, 5, 6, 8, -1, -1, -1, 7, 8, -1, 8, -1};

    /* JADX INFO: renamed from: b.i.a.c.t2.l$b */
    /* JADX INFO: compiled from: AacUtil.java */
    public static final class b {

        /* JADX INFO: renamed from: a */
        public final int f7766a;

        /* JADX INFO: renamed from: b */
        public final int f7767b;

        /* JADX INFO: renamed from: c */
        public final String f7768c;

        public b(int i, int i2, String str, a aVar) {
            this.f7766a = i;
            this.f7767b = i2;
            this.f7768c = str;
        }
    }

    /* JADX INFO: renamed from: a */
    public static int m3488a(C2756w c2756w) throws ParserException {
        int iM3067g = c2756w.m3067g(4);
        if (iM3067g == 15) {
            return c2756w.m3067g(24);
        }
        if (iM3067g < 13) {
            return f7764a[iM3067g];
        }
        throw ParserException.m8755a(null, null);
    }

    /* JADX INFO: renamed from: b */
    public static b m3489b(C2756w c2756w, boolean z2) throws ParserException {
        int iM3067g = c2756w.m3067g(5);
        if (iM3067g == 31) {
            iM3067g = c2756w.m3067g(6) + 32;
        }
        int iM3488a = m3488a(c2756w);
        int iM3067g2 = c2756w.m3067g(4);
        String strM851g = C1643a.m851g(19, "mp4a.40.", iM3067g);
        if (iM3067g == 5 || iM3067g == 29) {
            iM3488a = m3488a(c2756w);
            int iM3067g3 = c2756w.m3067g(5);
            if (iM3067g3 == 31) {
                iM3067g3 = c2756w.m3067g(6) + 32;
            }
            iM3067g = iM3067g3;
            if (iM3067g == 22) {
                iM3067g2 = c2756w.m3067g(4);
            }
        }
        if (z2) {
            if (iM3067g != 1 && iM3067g != 2 && iM3067g != 3 && iM3067g != 4 && iM3067g != 6 && iM3067g != 7 && iM3067g != 17) {
                switch (iM3067g) {
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                        break;
                    default:
                        StringBuilder sb = new StringBuilder(42);
                        sb.append("Unsupported audio object type: ");
                        sb.append(iM3067g);
                        throw ParserException.m8756b(sb.toString());
                }
            }
            if (c2756w.m3066f()) {
                Log.w("AacUtil", "Unexpected frameLengthFlag = 1");
            }
            if (c2756w.m3066f()) {
                c2756w.m3073m(14);
            }
            boolean zM3066f = c2756w.m3066f();
            if (iM3067g2 == 0) {
                throw new UnsupportedOperationException();
            }
            if (iM3067g == 6 || iM3067g == 20) {
                c2756w.m3073m(3);
            }
            if (zM3066f) {
                if (iM3067g == 22) {
                    c2756w.m3073m(16);
                }
                if (iM3067g == 17 || iM3067g == 19 || iM3067g == 20 || iM3067g == 23) {
                    c2756w.m3073m(3);
                }
                c2756w.m3073m(1);
            }
            switch (iM3067g) {
                case 17:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                    int iM3067g4 = c2756w.m3067g(2);
                    if (iM3067g4 == 2 || iM3067g4 == 3) {
                        StringBuilder sb2 = new StringBuilder(33);
                        sb2.append("Unsupported epConfig: ");
                        sb2.append(iM3067g4);
                        throw ParserException.m8756b(sb2.toString());
                    }
                    break;
            }
        }
        int i = f7765b[iM3067g2];
        if (i != -1) {
            return new b(iM3488a, i, strM851g, null);
        }
        throw ParserException.m8755a(null, null);
    }

    /* JADX INFO: renamed from: c */
    public static b m3490c(byte[] bArr) throws ParserException {
        return m3489b(new C2756w(bArr), false);
    }
}
