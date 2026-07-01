package b.i.a.c.t2;

import android.util.Log;
import b.d.b.a.outline;
import b.i.a.c.f3.ParsableBitArray;
import com.google.android.exoplayer2.ParserException;

/* JADX INFO: renamed from: b.i.a.c.t2.l, reason: use source file name */
/* JADX INFO: compiled from: AacUtil.java */
/* JADX INFO: loaded from: classes3.dex */
public final class AacUtil {
    public static final int[] a = {96000, 88200, 64000, 48000, 44100, 32000, 24000, 22050, 16000, 12000, 11025, 8000, 7350};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int[] f1121b = {0, 1, 2, 3, 4, 5, 6, 8, -1, -1, -1, 7, 8, -1, 8, -1};

    /* JADX INFO: renamed from: b.i.a.c.t2.l$b */
    /* JADX INFO: compiled from: AacUtil.java */
    public static final class b {
        public final int a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f1122b;
        public final String c;

        public b(int i, int i2, String str, a aVar) {
            this.a = i;
            this.f1122b = i2;
            this.c = str;
        }
    }

    public static int a(ParsableBitArray parsableBitArray) throws ParserException {
        int iG = parsableBitArray.g(4);
        if (iG == 15) {
            return parsableBitArray.g(24);
        }
        if (iG < 13) {
            return a[iG];
        }
        throw ParserException.a(null, null);
    }

    public static b b(ParsableBitArray parsableBitArray, boolean z2) throws ParserException {
        int iG = parsableBitArray.g(5);
        if (iG == 31) {
            iG = parsableBitArray.g(6) + 32;
        }
        int iA = a(parsableBitArray);
        int iG2 = parsableBitArray.g(4);
        String strG = outline.g(19, "mp4a.40.", iG);
        if (iG == 5 || iG == 29) {
            iA = a(parsableBitArray);
            int iG3 = parsableBitArray.g(5);
            if (iG3 == 31) {
                iG3 = parsableBitArray.g(6) + 32;
            }
            iG = iG3;
            if (iG == 22) {
                iG2 = parsableBitArray.g(4);
            }
        }
        if (z2) {
            if (iG != 1 && iG != 2 && iG != 3 && iG != 4 && iG != 6 && iG != 7 && iG != 17) {
                switch (iG) {
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                        break;
                    default:
                        StringBuilder sb = new StringBuilder(42);
                        sb.append("Unsupported audio object type: ");
                        sb.append(iG);
                        throw ParserException.b(sb.toString());
                }
            }
            if (parsableBitArray.f()) {
                Log.w("AacUtil", "Unexpected frameLengthFlag = 1");
            }
            if (parsableBitArray.f()) {
                parsableBitArray.m(14);
            }
            boolean zF = parsableBitArray.f();
            if (iG2 == 0) {
                throw new UnsupportedOperationException();
            }
            if (iG == 6 || iG == 20) {
                parsableBitArray.m(3);
            }
            if (zF) {
                if (iG == 22) {
                    parsableBitArray.m(16);
                }
                if (iG == 17 || iG == 19 || iG == 20 || iG == 23) {
                    parsableBitArray.m(3);
                }
                parsableBitArray.m(1);
            }
            switch (iG) {
                case 17:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                    int iG4 = parsableBitArray.g(2);
                    if (iG4 == 2 || iG4 == 3) {
                        StringBuilder sb2 = new StringBuilder(33);
                        sb2.append("Unsupported epConfig: ");
                        sb2.append(iG4);
                        throw ParserException.b(sb2.toString());
                    }
                    break;
            }
        }
        int i = f1121b[iG2];
        if (i != -1) {
            return new b(iA, i, strG, null);
        }
        throw ParserException.a(null, null);
    }

    public static b c(byte[] bArr) throws ParserException {
        return b(new ParsableBitArray(bArr), false);
    }
}
