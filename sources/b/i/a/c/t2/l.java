package b.i.a.c.t2;

import android.util.Log;
import com.google.android.exoplayer2.ParserException;

/* JADX INFO: compiled from: AacUtil.java */
/* JADX INFO: loaded from: classes3.dex */
public final class l {
    public static final int[] a = {96000, 88200, 64000, 48000, 44100, 32000, 24000, 22050, 16000, 12000, 11025, 8000, 7350};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int[] f1121b = {0, 1, 2, 3, 4, 5, 6, 8, -1, -1, -1, 7, 8, -1, 8, -1};

    public static int a(b.i.a.c.f3.w wVar) throws ParserException {
        int iG = wVar.g(4);
        if (iG == 15) {
            return wVar.g(24);
        }
        if (iG < 13) {
            return a[iG];
        }
        throw ParserException.a(null, null);
    }

    public static l$b b(b.i.a.c.f3.w wVar, boolean z2) throws ParserException {
        int iG = wVar.g(5);
        if (iG == 31) {
            iG = wVar.g(6) + 32;
        }
        int iA = a(wVar);
        int iG2 = wVar.g(4);
        String strG = b.d.b.a.a.g(19, "mp4a.40.", iG);
        if (iG == 5 || iG == 29) {
            iA = a(wVar);
            int iG3 = wVar.g(5);
            if (iG3 == 31) {
                iG3 = wVar.g(6) + 32;
            }
            iG = iG3;
            if (iG == 22) {
                iG2 = wVar.g(4);
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
            if (wVar.f()) {
                Log.w("AacUtil", "Unexpected frameLengthFlag = 1");
            }
            if (wVar.f()) {
                wVar.m(14);
            }
            boolean zF = wVar.f();
            if (iG2 == 0) {
                throw new UnsupportedOperationException();
            }
            if (iG == 6 || iG == 20) {
                wVar.m(3);
            }
            if (zF) {
                if (iG == 22) {
                    wVar.m(16);
                }
                if (iG == 17 || iG == 19 || iG == 20 || iG == 23) {
                    wVar.m(3);
                }
                wVar.m(1);
            }
            switch (iG) {
                case 17:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                    int iG4 = wVar.g(2);
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
            return new l$b(iA, i, strG, null);
        }
        throw ParserException.a(null, null);
    }

    public static l$b c(byte[] bArr) throws ParserException {
        return b(new b.i.a.c.f3.w(bArr), false);
    }
}
