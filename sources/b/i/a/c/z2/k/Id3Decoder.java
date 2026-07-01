package b.i.a.c.z2.k;

import android.util.Log;
import androidx.annotation.Nullable;
import b.d.b.a.outline;
import b.i.a.c.f3.ParsableBitArray;
import b.i.a.c.f3.ParsableByteArray;
import b.i.a.c.f3.Util2;
import b.i.a.c.z2.MetadataInputBuffer;
import b.i.a.c.z2.SimpleMetadataDecoder;
import b.i.a.f.e.o.f;
import com.adjust.sdk.Constants;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.id3.ApicFrame;
import com.google.android.exoplayer2.metadata.id3.BinaryFrame;
import com.google.android.exoplayer2.metadata.id3.ChapterFrame;
import com.google.android.exoplayer2.metadata.id3.ChapterTocFrame;
import com.google.android.exoplayer2.metadata.id3.CommentFrame;
import com.google.android.exoplayer2.metadata.id3.GeobFrame;
import com.google.android.exoplayer2.metadata.id3.Id3Frame;
import com.google.android.exoplayer2.metadata.id3.MlltFrame;
import com.google.android.exoplayer2.metadata.id3.PrivFrame;
import com.google.android.exoplayer2.metadata.id3.TextInformationFrame;
import com.google.android.exoplayer2.metadata.id3.UrlLinkFrame;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

/* JADX INFO: renamed from: b.i.a.c.z2.k.b, reason: use source file name */
/* JADX INFO: compiled from: Id3Decoder.java */
/* JADX INFO: loaded from: classes3.dex */
public final class Id3Decoder extends SimpleMetadataDecoder {
    public static final /* synthetic */ int a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public final a f1324b;

    /* JADX INFO: renamed from: b.i.a.c.z2.k.b$a */
    /* JADX INFO: compiled from: Id3Decoder.java */
    public interface a {
        boolean a(int i, int i2, int i3, int i4, int i5);
    }

    /* JADX INFO: renamed from: b.i.a.c.z2.k.b$b */
    /* JADX INFO: compiled from: Id3Decoder.java */
    public static final class b {
        public final int a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f1325b;
        public final int c;

        public b(int i, boolean z2, int i2) {
            this.a = i;
            this.f1325b = z2;
            this.c = i2;
        }
    }

    public Id3Decoder() {
        this.f1324b = null;
    }

    public static byte[] c(byte[] bArr, int i, int i2) {
        return i2 <= i ? Util2.f : Arrays.copyOfRange(bArr, i, i2);
    }

    public static ApicFrame e(ParsableByteArray parsableByteArray, int i, int i2) throws UnsupportedEncodingException {
        int iW;
        String strConcat;
        int iT = parsableByteArray.t();
        String strT = t(iT);
        int i3 = i - 1;
        byte[] bArr = new byte[i3];
        System.arraycopy(parsableByteArray.a, parsableByteArray.f984b, bArr, 0, i3);
        parsableByteArray.f984b += i3;
        if (i2 == 2) {
            String strValueOf = String.valueOf(f.u1(new String(bArr, 0, 3, "ISO-8859-1")));
            String strConcat2 = strValueOf.length() != 0 ? "image/".concat(strValueOf) : new String("image/");
            if ("image/jpg".equals(strConcat2)) {
                strConcat2 = "image/jpeg";
            }
            strConcat = strConcat2;
            iW = 2;
        } else {
            iW = w(bArr, 0);
            String strU1 = f.u1(new String(bArr, 0, iW, "ISO-8859-1"));
            if (strU1.indexOf(47) == -1) {
                strConcat = strU1.length() != 0 ? "image/".concat(strU1) : new String("image/");
            } else {
                strConcat = strU1;
            }
        }
        int i4 = bArr[iW + 1] & 255;
        int i5 = iW + 2;
        int iV = v(bArr, i5, iT);
        return new ApicFrame(strConcat, new String(bArr, i5, iV - i5, strT), i4, c(bArr, s(iT) + iV, i3));
    }

    public static BinaryFrame f(ParsableByteArray parsableByteArray, int i, String str) {
        byte[] bArr = new byte[i];
        System.arraycopy(parsableByteArray.a, parsableByteArray.f984b, bArr, 0, i);
        parsableByteArray.f984b += i;
        return new BinaryFrame(str, bArr);
    }

    public static ChapterFrame g(ParsableByteArray parsableByteArray, int i, int i2, boolean z2, int i3, @Nullable a aVar) throws UnsupportedEncodingException {
        int i4 = parsableByteArray.f984b;
        int iW = w(parsableByteArray.a, i4);
        String str = new String(parsableByteArray.a, i4, iW - i4, "ISO-8859-1");
        parsableByteArray.E(iW + 1);
        int iF = parsableByteArray.f();
        int iF2 = parsableByteArray.f();
        long jU = parsableByteArray.u();
        long j = jU == 4294967295L ? -1L : jU;
        long jU2 = parsableByteArray.u();
        long j2 = jU2 == 4294967295L ? -1L : jU2;
        ArrayList arrayList = new ArrayList();
        int i5 = i4 + i;
        while (parsableByteArray.f984b < i5) {
            Id3Frame id3FrameJ = j(i2, parsableByteArray, z2, i3, aVar);
            if (id3FrameJ != null) {
                arrayList.add(id3FrameJ);
            }
        }
        return new ChapterFrame(str, iF, iF2, j, j2, (Id3Frame[]) arrayList.toArray(new Id3Frame[0]));
    }

    public static ChapterTocFrame h(ParsableByteArray parsableByteArray, int i, int i2, boolean z2, int i3, @Nullable a aVar) throws UnsupportedEncodingException {
        int i4 = parsableByteArray.f984b;
        int iW = w(parsableByteArray.a, i4);
        String str = new String(parsableByteArray.a, i4, iW - i4, "ISO-8859-1");
        parsableByteArray.E(iW + 1);
        int iT = parsableByteArray.t();
        boolean z3 = (iT & 2) != 0;
        boolean z4 = (iT & 1) != 0;
        int iT2 = parsableByteArray.t();
        String[] strArr = new String[iT2];
        for (int i5 = 0; i5 < iT2; i5++) {
            int i6 = parsableByteArray.f984b;
            int iW2 = w(parsableByteArray.a, i6);
            strArr[i5] = new String(parsableByteArray.a, i6, iW2 - i6, "ISO-8859-1");
            parsableByteArray.E(iW2 + 1);
        }
        ArrayList arrayList = new ArrayList();
        int i7 = i4 + i;
        while (parsableByteArray.f984b < i7) {
            Id3Frame id3FrameJ = j(i2, parsableByteArray, z2, i3, aVar);
            if (id3FrameJ != null) {
                arrayList.add(id3FrameJ);
            }
        }
        return new ChapterTocFrame(str, z3, z4, strArr, (Id3Frame[]) arrayList.toArray(new Id3Frame[0]));
    }

    @Nullable
    public static CommentFrame i(ParsableByteArray parsableByteArray, int i) throws UnsupportedEncodingException {
        if (i < 4) {
            return null;
        }
        int iT = parsableByteArray.t();
        String strT = t(iT);
        byte[] bArr = new byte[3];
        System.arraycopy(parsableByteArray.a, parsableByteArray.f984b, bArr, 0, 3);
        parsableByteArray.f984b += 3;
        String str = new String(bArr, 0, 3);
        int i2 = i - 4;
        byte[] bArr2 = new byte[i2];
        System.arraycopy(parsableByteArray.a, parsableByteArray.f984b, bArr2, 0, i2);
        parsableByteArray.f984b += i2;
        int iV = v(bArr2, 0, iT);
        String str2 = new String(bArr2, 0, iV, strT);
        int iS = s(iT) + iV;
        return new CommentFrame(str, str2, n(bArr2, iS, v(bArr2, iS, iT), strT));
    }

    /* JADX WARN: Code duplicated, block: B:133:0x0190  */
    /* JADX WARN: Code duplicated, block: B:140:0x01a1 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:141:0x01a3  */
    /* JADX WARN: Code duplicated, block: B:146:0x01bb A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:147:0x01bd A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:151:0x01d3 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:152:0x01d5  */
    /* JADX WARN: Code duplicated, block: B:157:0x01e2 A[Catch: all -> 0x0126, UnsupportedEncodingException -> 0x021a, Merged into TryCatch #0 {all -> 0x0126, UnsupportedEncodingException -> 0x021a, blocks: (B:91:0x0114, B:159:0x01ec, B:162:0x021a, B:93:0x011c, B:102:0x0135, B:104:0x013d, B:112:0x0157, B:121:0x016f, B:132:0x018a, B:139:0x019c, B:145:0x01ab, B:150:0x01c3, B:156:0x01dd, B:157:0x01e2), top: B:169:0x010a }] */
    @Nullable
    public static Id3Frame j(int i, ParsableByteArray parsableByteArray, boolean z2, int i2, @Nullable a aVar) {
        int iW;
        int i3;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        Id3Frame id3FrameF;
        int iT = parsableByteArray.t();
        int iT2 = parsableByteArray.t();
        int iT3 = parsableByteArray.t();
        int iT4 = i >= 3 ? parsableByteArray.t() : 0;
        if (i == 4) {
            iW = parsableByteArray.w();
            if (!z2) {
                iW = (((iW >> 24) & 255) << 21) | (iW & 255) | (((iW >> 8) & 255) << 7) | (((iW >> 16) & 255) << 14);
            }
        } else {
            iW = i == 3 ? parsableByteArray.w() : parsableByteArray.v();
        }
        int iX = iW;
        int iY = i >= 3 ? parsableByteArray.y() : 0;
        if (iT == 0 && iT2 == 0 && iT3 == 0 && iT4 == 0 && iX == 0 && iY == 0) {
            parsableByteArray.E(parsableByteArray.c);
            return null;
        }
        int i4 = parsableByteArray.f984b + iX;
        if (i4 > parsableByteArray.c) {
            Log.w("Id3Decoder", "Frame size exceeds remaining tag data");
            parsableByteArray.E(parsableByteArray.c);
            return null;
        }
        if (aVar != null) {
            i3 = i4;
            if (!aVar.a(i, iT, iT2, iT3, iT4)) {
                parsableByteArray.E(i3);
                return null;
            }
        } else {
            i3 = i4;
        }
        if (i == 3) {
            int i5 = iY;
            z4 = (i5 & 128) != 0;
            z5 = (i5 & 64) != 0;
            z3 = (i5 & 32) != 0;
            z7 = z4;
            z6 = false;
        } else {
            int i6 = iY;
            if (i == 4) {
                boolean z8 = (i6 & 64) != 0;
                boolean z9 = (i6 & 8) != 0;
                boolean z10 = (i6 & 4) != 0;
                z6 = (i6 & 2) != 0;
                boolean z11 = (i6 & 1) != 0;
                z3 = z8;
                z4 = z11;
                z7 = z9;
                z5 = z10;
            } else {
                z3 = false;
                z4 = false;
                z5 = false;
                z6 = false;
                z7 = false;
            }
        }
        if (z7 || z5) {
            Log.w((String) r4, "Skipping unsupported compressed or encrypted frame");
            parsableByteArray.E(i3);
            return null;
        }
        if (z3) {
            iX--;
            parsableByteArray.F(1);
        }
        if (z4) {
            iX -= 4;
            parsableByteArray.F(4);
        }
        if (z6) {
            iX = x(parsableByteArray, iX);
        }
        try {
            if (iT == 84 && iT2 == 88 && iT3 == 88 && (i == 2 || iT4 == 88)) {
                id3FrameF = p(parsableByteArray, iX);
            } else if (iT == 84) {
                id3FrameF = o(parsableByteArray, iX, u(i, iT, iT2, iT3, iT4));
            } else if (iT == 87 && iT2 == 88 && iT3 == 88 && (i == 2 || iT4 == 88)) {
                id3FrameF = r(parsableByteArray, iX);
            } else if (iT == 87) {
                id3FrameF = q(parsableByteArray, iX, u(i, iT, iT2, iT3, iT4));
            } else if (iT == 80 && iT2 == 82 && iT3 == 73 && iT4 == 86) {
                id3FrameF = m(parsableByteArray, iX);
            } else if (iT == 71 && iT2 == 69 && iT3 == 79 && (iT4 == 66 || i == 2)) {
                id3FrameF = k(parsableByteArray, iX);
            } else if (i == 2) {
                if (iT == 80 && iT2 == 73 && iT3 == 67) {
                    id3FrameF = e(parsableByteArray, iX, i);
                } else if (iT != 67 && iT2 == 79 && iT3 == 77 && (iT4 == 77 || i == 2)) {
                    id3FrameF = i(parsableByteArray, iX);
                } else if (iT != 67 && iT2 == 72 && iT3 == 65 && iT4 == 80) {
                    id3FrameF = g(parsableByteArray, iX, i, z2, i2, aVar);
                } else if (iT != 67 && iT2 == 84 && iT3 == 79 && iT4 == 67) {
                    id3FrameF = h(parsableByteArray, iX, i, z2, i2, aVar);
                } else if (iT != 77 && iT2 == 76 && iT3 == 76 && iT4 == 84) {
                    id3FrameF = l(parsableByteArray, iX);
                } else {
                    id3FrameF = f(parsableByteArray, iX, u(i, iT, iT2, iT3, iT4));
                }
            } else if (iT == 65 && iT2 == 80 && iT3 == 73 && iT4 == 67) {
                id3FrameF = e(parsableByteArray, iX, i);
            } else if (iT != 67) {
                if (iT != 67) {
                    if (iT != 67) {
                        if (iT != 77) {
                            id3FrameF = f(parsableByteArray, iX, u(i, iT, iT2, iT3, iT4));
                        } else {
                            id3FrameF = f(parsableByteArray, iX, u(i, iT, iT2, iT3, iT4));
                        }
                    } else if (iT != 77) {
                        id3FrameF = f(parsableByteArray, iX, u(i, iT, iT2, iT3, iT4));
                    } else {
                        id3FrameF = f(parsableByteArray, iX, u(i, iT, iT2, iT3, iT4));
                    }
                } else if (iT != 67) {
                    if (iT != 77) {
                        id3FrameF = f(parsableByteArray, iX, u(i, iT, iT2, iT3, iT4));
                    } else {
                        id3FrameF = f(parsableByteArray, iX, u(i, iT, iT2, iT3, iT4));
                    }
                } else if (iT != 77) {
                    id3FrameF = f(parsableByteArray, iX, u(i, iT, iT2, iT3, iT4));
                } else {
                    id3FrameF = f(parsableByteArray, iX, u(i, iT, iT2, iT3, iT4));
                }
            } else if (iT != 67) {
                if (iT != 67) {
                    if (iT != 77) {
                        id3FrameF = f(parsableByteArray, iX, u(i, iT, iT2, iT3, iT4));
                    } else {
                        id3FrameF = f(parsableByteArray, iX, u(i, iT, iT2, iT3, iT4));
                    }
                } else if (iT != 77) {
                    id3FrameF = f(parsableByteArray, iX, u(i, iT, iT2, iT3, iT4));
                } else {
                    id3FrameF = f(parsableByteArray, iX, u(i, iT, iT2, iT3, iT4));
                }
            } else if (iT != 67) {
                if (iT != 77) {
                    id3FrameF = f(parsableByteArray, iX, u(i, iT, iT2, iT3, iT4));
                } else {
                    id3FrameF = f(parsableByteArray, iX, u(i, iT, iT2, iT3, iT4));
                }
            } else if (iT != 77) {
                id3FrameF = f(parsableByteArray, iX, u(i, iT, iT2, iT3, iT4));
            } else {
                id3FrameF = f(parsableByteArray, iX, u(i, iT, iT2, iT3, iT4));
            }
            if (id3FrameF == null) {
                String strU = u(i, iT, iT2, iT3, iT4);
                StringBuilder sb = new StringBuilder(String.valueOf(strU).length() + 50);
                sb.append("Failed to decode frame: id=");
                sb.append(strU);
                sb.append(", frameSize=");
                sb.append(iX);
                Log.w("Id3Decoder", sb.toString());
            }
            parsableByteArray.E(i3);
            return id3FrameF;
        } catch (UnsupportedEncodingException unused) {
            Log.w((String) r4, "Unsupported character encoding");
            return null;
        } finally {
            parsableByteArray.E(i3);
        }
    }

    public static GeobFrame k(ParsableByteArray parsableByteArray, int i) throws UnsupportedEncodingException {
        int iT = parsableByteArray.t();
        String strT = t(iT);
        int i2 = i - 1;
        byte[] bArr = new byte[i2];
        System.arraycopy(parsableByteArray.a, parsableByteArray.f984b, bArr, 0, i2);
        parsableByteArray.f984b += i2;
        int iW = w(bArr, 0);
        String str = new String(bArr, 0, iW, "ISO-8859-1");
        int i3 = iW + 1;
        int iV = v(bArr, i3, iT);
        String strN = n(bArr, i3, iV, strT);
        int iS = s(iT) + iV;
        int iV2 = v(bArr, iS, iT);
        return new GeobFrame(str, strN, n(bArr, iS, iV2, strT), c(bArr, s(iT) + iV2, i2));
    }

    public static MlltFrame l(ParsableByteArray parsableByteArray, int i) {
        int iY = parsableByteArray.y();
        int iV = parsableByteArray.v();
        int iV2 = parsableByteArray.v();
        int iT = parsableByteArray.t();
        int iT2 = parsableByteArray.t();
        ParsableBitArray parsableBitArray = new ParsableBitArray();
        parsableBitArray.j(parsableByteArray.a, parsableByteArray.c);
        parsableBitArray.k(parsableByteArray.f984b * 8);
        int i2 = ((i - 10) * 8) / (iT + iT2);
        int[] iArr = new int[i2];
        int[] iArr2 = new int[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            int iG = parsableBitArray.g(iT);
            int iG2 = parsableBitArray.g(iT2);
            iArr[i3] = iG;
            iArr2[i3] = iG2;
        }
        return new MlltFrame(iY, iV, iV2, iArr, iArr2);
    }

    public static PrivFrame m(ParsableByteArray parsableByteArray, int i) throws UnsupportedEncodingException {
        byte[] bArr = new byte[i];
        System.arraycopy(parsableByteArray.a, parsableByteArray.f984b, bArr, 0, i);
        parsableByteArray.f984b += i;
        int iW = w(bArr, 0);
        return new PrivFrame(new String(bArr, 0, iW, "ISO-8859-1"), c(bArr, iW + 1, i));
    }

    public static String n(byte[] bArr, int i, int i2, String str) throws UnsupportedEncodingException {
        return (i2 <= i || i2 > bArr.length) ? "" : new String(bArr, i, i2 - i, str);
    }

    @Nullable
    public static TextInformationFrame o(ParsableByteArray parsableByteArray, int i, String str) throws UnsupportedEncodingException {
        if (i < 1) {
            return null;
        }
        int iT = parsableByteArray.t();
        String strT = t(iT);
        int i2 = i - 1;
        byte[] bArr = new byte[i2];
        System.arraycopy(parsableByteArray.a, parsableByteArray.f984b, bArr, 0, i2);
        parsableByteArray.f984b += i2;
        return new TextInformationFrame(str, null, new String(bArr, 0, v(bArr, 0, iT), strT));
    }

    @Nullable
    public static TextInformationFrame p(ParsableByteArray parsableByteArray, int i) throws UnsupportedEncodingException {
        if (i < 1) {
            return null;
        }
        int iT = parsableByteArray.t();
        String strT = t(iT);
        int i2 = i - 1;
        byte[] bArr = new byte[i2];
        System.arraycopy(parsableByteArray.a, parsableByteArray.f984b, bArr, 0, i2);
        parsableByteArray.f984b += i2;
        int iV = v(bArr, 0, iT);
        String str = new String(bArr, 0, iV, strT);
        int iS = s(iT) + iV;
        return new TextInformationFrame("TXXX", str, n(bArr, iS, v(bArr, iS, iT), strT));
    }

    public static UrlLinkFrame q(ParsableByteArray parsableByteArray, int i, String str) throws UnsupportedEncodingException {
        byte[] bArr = new byte[i];
        System.arraycopy(parsableByteArray.a, parsableByteArray.f984b, bArr, 0, i);
        parsableByteArray.f984b += i;
        return new UrlLinkFrame(str, null, new String(bArr, 0, w(bArr, 0), "ISO-8859-1"));
    }

    @Nullable
    public static UrlLinkFrame r(ParsableByteArray parsableByteArray, int i) throws UnsupportedEncodingException {
        if (i < 1) {
            return null;
        }
        int iT = parsableByteArray.t();
        String strT = t(iT);
        int i2 = i - 1;
        byte[] bArr = new byte[i2];
        System.arraycopy(parsableByteArray.a, parsableByteArray.f984b, bArr, 0, i2);
        parsableByteArray.f984b += i2;
        int iV = v(bArr, 0, iT);
        String str = new String(bArr, 0, iV, strT);
        int iS = s(iT) + iV;
        return new UrlLinkFrame("WXXX", str, n(bArr, iS, w(bArr, iS), "ISO-8859-1"));
    }

    public static int s(int i) {
        return (i == 0 || i == 3) ? 1 : 2;
    }

    public static String t(int i) {
        if (i == 1) {
            return "UTF-16";
        }
        if (i != 2) {
            return i != 3 ? "ISO-8859-1" : Constants.ENCODING;
        }
        return "UTF-16BE";
    }

    public static String u(int i, int i2, int i3, int i4, int i5) {
        return i == 2 ? String.format(Locale.US, "%c%c%c", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)) : String.format(Locale.US, "%c%c%c%c", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5));
    }

    public static int v(byte[] bArr, int i, int i2) {
        int iW = w(bArr, i);
        if (i2 == 0 || i2 == 3) {
            return iW;
        }
        while (iW < bArr.length - 1) {
            if ((iW - i) % 2 == 0 && bArr[iW + 1] == 0) {
                return iW;
            }
            iW = w(bArr, iW + 1);
        }
        return bArr.length;
    }

    public static int w(byte[] bArr, int i) {
        while (i < bArr.length) {
            if (bArr[i] == 0) {
                return i;
            }
            i++;
        }
        return bArr.length;
    }

    public static int x(ParsableByteArray parsableByteArray, int i) {
        byte[] bArr = parsableByteArray.a;
        int i2 = parsableByteArray.f984b;
        int i3 = i2;
        while (true) {
            int i4 = i3 + 1;
            if (i4 >= i2 + i) {
                return i;
            }
            if ((bArr[i3] & 255) == 255 && bArr[i4] == 0) {
                System.arraycopy(bArr, i3 + 2, bArr, i4, (i - (i3 - i2)) - 2);
                i--;
            }
            i3 = i4;
        }
    }

    public static boolean y(ParsableByteArray parsableByteArray, int i, int i2, boolean z2) {
        int iV;
        long jV;
        int iY;
        int i3;
        int i4 = parsableByteArray.f984b;
        while (true) {
            try {
                boolean z3 = true;
                if (parsableByteArray.a() < i2) {
                    parsableByteArray.E(i4);
                    return true;
                }
                if (i >= 3) {
                    iV = parsableByteArray.f();
                    jV = parsableByteArray.u();
                    iY = parsableByteArray.y();
                } else {
                    iV = parsableByteArray.v();
                    jV = parsableByteArray.v();
                    iY = 0;
                }
                if (iV == 0 && jV == 0 && iY == 0) {
                    parsableByteArray.E(i4);
                    return true;
                }
                if (i == 4 && !z2) {
                    if ((8421504 & jV) != 0) {
                        parsableByteArray.E(i4);
                        return false;
                    }
                    jV = (((jV >> 24) & 255) << 21) | (jV & 255) | (((jV >> 8) & 255) << 7) | (((jV >> 16) & 255) << 14);
                }
                if (i == 4) {
                    i3 = (iY & 64) != 0 ? 1 : 0;
                    if ((iY & 1) == 0) {
                        z3 = false;
                    }
                } else {
                    if (i == 3) {
                        i3 = (iY & 32) != 0 ? 1 : 0;
                        if ((iY & 128) == 0) {
                        }
                    } else {
                        i3 = 0;
                    }
                    z3 = false;
                }
                if (z3) {
                    i3 += 4;
                }
                if (jV < i3) {
                    parsableByteArray.E(i4);
                    return false;
                }
                if (parsableByteArray.a() < jV) {
                    parsableByteArray.E(i4);
                    return false;
                }
                parsableByteArray.F((int) jV);
            } catch (Throwable th) {
                parsableByteArray.E(i4);
                throw th;
            }
        }
    }

    @Override // b.i.a.c.z2.SimpleMetadataDecoder
    @Nullable
    public Metadata b(MetadataInputBuffer metadataInputBuffer, ByteBuffer byteBuffer) {
        return d(byteBuffer.array(), byteBuffer.limit());
    }

    /* JADX WARN: Code duplicated, block: B:45:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:50:0x00c1 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:51:0x00c2  */
    /* JADX WARN: Code duplicated, block: B:53:0x00c8  */
    /* JADX WARN: Code duplicated, block: B:56:0x00cf  */
    /* JADX WARN: Code duplicated, block: B:59:0x00df  */
    /* JADX WARN: Code duplicated, block: B:68:0x00fb  */
    /* JADX WARN: Code duplicated, block: B:74:0x0105 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:76:0x00f5 A[SYNTHETIC] */
    @Nullable
    public Metadata d(byte[] bArr, int i) {
        boolean z2;
        b bVar;
        int i2;
        int iX;
        Id3Frame id3FrameJ;
        ArrayList arrayList = new ArrayList();
        ParsableByteArray parsableByteArray = new ParsableByteArray(bArr, i);
        boolean z3 = false;
        if (parsableByteArray.a() < 10) {
            Log.w("Id3Decoder", "Data too short to be an ID3 tag");
        } else {
            int iV = parsableByteArray.v();
            if (iV == 4801587) {
                int iT = parsableByteArray.t();
                parsableByteArray.F(1);
                int iT2 = parsableByteArray.t();
                int iS = parsableByteArray.s();
                if (iT == 2) {
                    if ((iT2 & 64) != 0) {
                        Log.w("Id3Decoder", "Skipped ID3 tag with majorVersion=2 and undefined compression scheme");
                    } else {
                        if (iT < 4 || (iT2 & 128) == 0) {
                            z2 = false;
                        } else {
                            z2 = true;
                        }
                        bVar = new b(iT, z2, iS);
                    }
                } else {
                    if (iT == 3) {
                        if ((iT2 & 64) != 0) {
                            int iF = parsableByteArray.f();
                            parsableByteArray.F(iF);
                            iS -= iF + 4;
                        }
                    } else if (iT == 4) {
                        if ((iT2 & 64) != 0) {
                            int iS2 = parsableByteArray.s();
                            parsableByteArray.F(iS2 - 4);
                            iS -= iS2;
                        }
                        if ((iT2 & 16) != 0) {
                            iS -= 10;
                        }
                    } else {
                        outline.g0(57, "Skipped ID3 tag with unsupported majorVersion=", iT, "Id3Decoder");
                    }
                    if (iT < 4) {
                        z2 = false;
                    } else {
                        z2 = false;
                    }
                    bVar = new b(iT, z2, iS);
                }
                if (bVar == null) {
                    return null;
                }
                int i3 = parsableByteArray.f984b;
                i2 = bVar.a == 2 ? 6 : 10;
                iX = bVar.c;
                if (bVar.f1325b) {
                    iX = x(parsableByteArray, iX);
                }
                parsableByteArray.D(i3 + iX);
                if (!y(parsableByteArray, bVar.a, i2, false)) {
                    if (bVar.a == 4 || !y(parsableByteArray, 4, i2, true)) {
                        outline.g0(56, "Failed to validate ID3 tag with majorVersion=", bVar.a, "Id3Decoder");
                        return null;
                    }
                    z3 = true;
                }
                while (parsableByteArray.a() >= i2) {
                    id3FrameJ = j(bVar.a, parsableByteArray, z3, i2, this.f1324b);
                    if (id3FrameJ != null) {
                        arrayList.add(id3FrameJ);
                    }
                }
                return new Metadata(arrayList);
            }
            String strValueOf = String.valueOf(String.format("%06X", Integer.valueOf(iV)));
            Log.w("Id3Decoder", strValueOf.length() != 0 ? "Unexpected first three bytes of ID3 tag header: 0x".concat(strValueOf) : new String("Unexpected first three bytes of ID3 tag header: 0x"));
        }
        bVar = null;
        if (bVar == null) {
            return null;
        }
        int i4 = parsableByteArray.f984b;
        if (bVar.a == 2) {
        }
        iX = bVar.c;
        if (bVar.f1325b) {
            iX = x(parsableByteArray, iX);
        }
        parsableByteArray.D(i4 + iX);
        if (!y(parsableByteArray, bVar.a, i2, false)) {
            if (bVar.a == 4) {
            }
            outline.g0(56, "Failed to validate ID3 tag with majorVersion=", bVar.a, "Id3Decoder");
            return null;
        }
        while (parsableByteArray.a() >= i2) {
            id3FrameJ = j(bVar.a, parsableByteArray, z3, i2, this.f1324b);
            if (id3FrameJ != null) {
                arrayList.add(id3FrameJ);
            }
        }
        return new Metadata(arrayList);
    }

    public Id3Decoder(@Nullable a aVar) {
        this.f1324b = aVar;
    }
}
