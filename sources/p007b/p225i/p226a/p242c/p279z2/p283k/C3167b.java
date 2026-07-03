package p007b.p225i.p226a.p242c.p279z2.p283k;

import android.util.Log;
import androidx.annotation.Nullable;
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
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p226a.p242c.p259f3.C2738e0;
import p007b.p225i.p226a.p242c.p259f3.C2756w;
import p007b.p225i.p226a.p242c.p259f3.C2757x;
import p007b.p225i.p226a.p242c.p279z2.AbstractC3161g;
import p007b.p225i.p226a.p242c.p279z2.C3158d;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;

/* JADX INFO: renamed from: b.i.a.c.z2.k.b */
/* JADX INFO: compiled from: Id3Decoder.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C3167b extends AbstractC3161g {

    /* JADX INFO: renamed from: a */
    public static final /* synthetic */ int f9154a = 0;

    /* JADX INFO: renamed from: b */
    @Nullable
    public final a f9155b;

    /* JADX INFO: renamed from: b.i.a.c.z2.k.b$a */
    /* JADX INFO: compiled from: Id3Decoder.java */
    public interface a {
        /* JADX INFO: renamed from: a */
        boolean mo3688a(int i, int i2, int i3, int i4, int i5);
    }

    /* JADX INFO: renamed from: b.i.a.c.z2.k.b$b */
    /* JADX INFO: compiled from: Id3Decoder.java */
    public static final class b {

        /* JADX INFO: renamed from: a */
        public final int f9156a;

        /* JADX INFO: renamed from: b */
        public final boolean f9157b;

        /* JADX INFO: renamed from: c */
        public final int f9158c;

        public b(int i, boolean z2, int i2) {
            this.f9156a = i;
            this.f9157b = z2;
            this.f9158c = i2;
        }
    }

    public C3167b() {
        this.f9155b = null;
    }

    /* JADX INFO: renamed from: c */
    public static byte[] m3900c(byte[] bArr, int i, int i2) {
        return i2 <= i ? C2738e0.f6713f : Arrays.copyOfRange(bArr, i, i2);
    }

    /* JADX INFO: renamed from: e */
    public static ApicFrame m3901e(C2757x c2757x, int i, int i2) throws UnsupportedEncodingException {
        int iM3919w;
        String strConcat;
        int iM3100t = c2757x.m3100t();
        String strM3916t = m3916t(iM3100t);
        int i3 = i - 1;
        byte[] bArr = new byte[i3];
        System.arraycopy(c2757x.f6793a, c2757x.f6794b, bArr, 0, i3);
        c2757x.f6794b += i3;
        if (i2 == 2) {
            String strValueOf = String.valueOf(C3404f.m4349u1(new String(bArr, 0, 3, "ISO-8859-1")));
            String strConcat2 = strValueOf.length() != 0 ? "image/".concat(strValueOf) : new String("image/");
            if ("image/jpg".equals(strConcat2)) {
                strConcat2 = "image/jpeg";
            }
            strConcat = strConcat2;
            iM3919w = 2;
        } else {
            iM3919w = m3919w(bArr, 0);
            String strM4349u1 = C3404f.m4349u1(new String(bArr, 0, iM3919w, "ISO-8859-1"));
            if (strM4349u1.indexOf(47) == -1) {
                strConcat = strM4349u1.length() != 0 ? "image/".concat(strM4349u1) : new String("image/");
            } else {
                strConcat = strM4349u1;
            }
        }
        int i4 = bArr[iM3919w + 1] & 255;
        int i5 = iM3919w + 2;
        int iM3918v = m3918v(bArr, i5, iM3100t);
        return new ApicFrame(strConcat, new String(bArr, i5, iM3918v - i5, strM3916t), i4, m3900c(bArr, m3915s(iM3100t) + iM3918v, i3));
    }

    /* JADX INFO: renamed from: f */
    public static BinaryFrame m3902f(C2757x c2757x, int i, String str) {
        byte[] bArr = new byte[i];
        System.arraycopy(c2757x.f6793a, c2757x.f6794b, bArr, 0, i);
        c2757x.f6794b += i;
        return new BinaryFrame(str, bArr);
    }

    /* JADX INFO: renamed from: g */
    public static ChapterFrame m3903g(C2757x c2757x, int i, int i2, boolean z2, int i3, @Nullable a aVar) throws UnsupportedEncodingException {
        int i4 = c2757x.f6794b;
        int iM3919w = m3919w(c2757x.f6793a, i4);
        String str = new String(c2757x.f6793a, i4, iM3919w - i4, "ISO-8859-1");
        c2757x.m3079E(iM3919w + 1);
        int iM3086f = c2757x.m3086f();
        int iM3086f2 = c2757x.m3086f();
        long jM3101u = c2757x.m3101u();
        long j = jM3101u == 4294967295L ? -1L : jM3101u;
        long jM3101u2 = c2757x.m3101u();
        long j2 = jM3101u2 == 4294967295L ? -1L : jM3101u2;
        ArrayList arrayList = new ArrayList();
        int i5 = i4 + i;
        while (c2757x.f6794b < i5) {
            Id3Frame id3FrameM3906j = m3906j(i2, c2757x, z2, i3, aVar);
            if (id3FrameM3906j != null) {
                arrayList.add(id3FrameM3906j);
            }
        }
        return new ChapterFrame(str, iM3086f, iM3086f2, j, j2, (Id3Frame[]) arrayList.toArray(new Id3Frame[0]));
    }

    /* JADX INFO: renamed from: h */
    public static ChapterTocFrame m3904h(C2757x c2757x, int i, int i2, boolean z2, int i3, @Nullable a aVar) throws UnsupportedEncodingException {
        int i4 = c2757x.f6794b;
        int iM3919w = m3919w(c2757x.f6793a, i4);
        String str = new String(c2757x.f6793a, i4, iM3919w - i4, "ISO-8859-1");
        c2757x.m3079E(iM3919w + 1);
        int iM3100t = c2757x.m3100t();
        boolean z3 = (iM3100t & 2) != 0;
        boolean z4 = (iM3100t & 1) != 0;
        int iM3100t2 = c2757x.m3100t();
        String[] strArr = new String[iM3100t2];
        for (int i5 = 0; i5 < iM3100t2; i5++) {
            int i6 = c2757x.f6794b;
            int iM3919w2 = m3919w(c2757x.f6793a, i6);
            strArr[i5] = new String(c2757x.f6793a, i6, iM3919w2 - i6, "ISO-8859-1");
            c2757x.m3079E(iM3919w2 + 1);
        }
        ArrayList arrayList = new ArrayList();
        int i7 = i4 + i;
        while (c2757x.f6794b < i7) {
            Id3Frame id3FrameM3906j = m3906j(i2, c2757x, z2, i3, aVar);
            if (id3FrameM3906j != null) {
                arrayList.add(id3FrameM3906j);
            }
        }
        return new ChapterTocFrame(str, z3, z4, strArr, (Id3Frame[]) arrayList.toArray(new Id3Frame[0]));
    }

    @Nullable
    /* JADX INFO: renamed from: i */
    public static CommentFrame m3905i(C2757x c2757x, int i) throws UnsupportedEncodingException {
        if (i < 4) {
            return null;
        }
        int iM3100t = c2757x.m3100t();
        String strM3916t = m3916t(iM3100t);
        byte[] bArr = new byte[3];
        System.arraycopy(c2757x.f6793a, c2757x.f6794b, bArr, 0, 3);
        c2757x.f6794b += 3;
        String str = new String(bArr, 0, 3);
        int i2 = i - 4;
        byte[] bArr2 = new byte[i2];
        System.arraycopy(c2757x.f6793a, c2757x.f6794b, bArr2, 0, i2);
        c2757x.f6794b += i2;
        int iM3918v = m3918v(bArr2, 0, iM3100t);
        String str2 = new String(bArr2, 0, iM3918v, strM3916t);
        int iM3915s = m3915s(iM3100t) + iM3918v;
        return new CommentFrame(str, str2, m3910n(bArr2, iM3915s, m3918v(bArr2, iM3915s, iM3100t), strM3916t));
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
    /* JADX INFO: renamed from: j */
    public static Id3Frame m3906j(int i, C2757x c2757x, boolean z2, int i2, @Nullable a aVar) {
        int iM3103w;
        int i3;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        Id3Frame id3FrameM3902f;
        int iM3100t = c2757x.m3100t();
        int iM3100t2 = c2757x.m3100t();
        int iM3100t3 = c2757x.m3100t();
        int iM3100t4 = i >= 3 ? c2757x.m3100t() : 0;
        if (i == 4) {
            iM3103w = c2757x.m3103w();
            if (!z2) {
                iM3103w = (((iM3103w >> 24) & 255) << 21) | (iM3103w & 255) | (((iM3103w >> 8) & 255) << 7) | (((iM3103w >> 16) & 255) << 14);
            }
        } else {
            iM3103w = i == 3 ? c2757x.m3103w() : c2757x.m3102v();
        }
        int iM3920x = iM3103w;
        int iM3105y = i >= 3 ? c2757x.m3105y() : 0;
        if (iM3100t == 0 && iM3100t2 == 0 && iM3100t3 == 0 && iM3100t4 == 0 && iM3920x == 0 && iM3105y == 0) {
            c2757x.m3079E(c2757x.f6795c);
            return null;
        }
        int i4 = c2757x.f6794b + iM3920x;
        if (i4 > c2757x.f6795c) {
            Log.w("Id3Decoder", "Frame size exceeds remaining tag data");
            c2757x.m3079E(c2757x.f6795c);
            return null;
        }
        if (aVar != null) {
            i3 = i4;
            if (!aVar.mo3688a(i, iM3100t, iM3100t2, iM3100t3, iM3100t4)) {
                c2757x.m3079E(i3);
                return null;
            }
        } else {
            i3 = i4;
        }
        if (i == 3) {
            int i5 = iM3105y;
            z4 = (i5 & 128) != 0;
            z5 = (i5 & 64) != 0;
            z3 = (i5 & 32) != 0;
            z7 = z4;
            z6 = false;
        } else {
            int i6 = iM3105y;
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
            c2757x.m3079E(i3);
            return null;
        }
        if (z3) {
            iM3920x--;
            c2757x.m3080F(1);
        }
        if (z4) {
            iM3920x -= 4;
            c2757x.m3080F(4);
        }
        if (z6) {
            iM3920x = m3920x(c2757x, iM3920x);
        }
        try {
            if (iM3100t == 84 && iM3100t2 == 88 && iM3100t3 == 88 && (i == 2 || iM3100t4 == 88)) {
                id3FrameM3902f = m3912p(c2757x, iM3920x);
            } else if (iM3100t == 84) {
                id3FrameM3902f = m3911o(c2757x, iM3920x, m3917u(i, iM3100t, iM3100t2, iM3100t3, iM3100t4));
            } else if (iM3100t == 87 && iM3100t2 == 88 && iM3100t3 == 88 && (i == 2 || iM3100t4 == 88)) {
                id3FrameM3902f = m3914r(c2757x, iM3920x);
            } else if (iM3100t == 87) {
                id3FrameM3902f = m3913q(c2757x, iM3920x, m3917u(i, iM3100t, iM3100t2, iM3100t3, iM3100t4));
            } else if (iM3100t == 80 && iM3100t2 == 82 && iM3100t3 == 73 && iM3100t4 == 86) {
                id3FrameM3902f = m3909m(c2757x, iM3920x);
            } else if (iM3100t == 71 && iM3100t2 == 69 && iM3100t3 == 79 && (iM3100t4 == 66 || i == 2)) {
                id3FrameM3902f = m3907k(c2757x, iM3920x);
            } else if (i == 2) {
                if (iM3100t == 80 && iM3100t2 == 73 && iM3100t3 == 67) {
                    id3FrameM3902f = m3901e(c2757x, iM3920x, i);
                } else if (iM3100t != 67 && iM3100t2 == 79 && iM3100t3 == 77 && (iM3100t4 == 77 || i == 2)) {
                    id3FrameM3902f = m3905i(c2757x, iM3920x);
                } else if (iM3100t != 67 && iM3100t2 == 72 && iM3100t3 == 65 && iM3100t4 == 80) {
                    id3FrameM3902f = m3903g(c2757x, iM3920x, i, z2, i2, aVar);
                } else if (iM3100t != 67 && iM3100t2 == 84 && iM3100t3 == 79 && iM3100t4 == 67) {
                    id3FrameM3902f = m3904h(c2757x, iM3920x, i, z2, i2, aVar);
                } else if (iM3100t != 77 && iM3100t2 == 76 && iM3100t3 == 76 && iM3100t4 == 84) {
                    id3FrameM3902f = m3908l(c2757x, iM3920x);
                } else {
                    id3FrameM3902f = m3902f(c2757x, iM3920x, m3917u(i, iM3100t, iM3100t2, iM3100t3, iM3100t4));
                }
            } else if (iM3100t == 65 && iM3100t2 == 80 && iM3100t3 == 73 && iM3100t4 == 67) {
                id3FrameM3902f = m3901e(c2757x, iM3920x, i);
            } else if (iM3100t != 67) {
                if (iM3100t != 67) {
                    if (iM3100t != 67) {
                        if (iM3100t != 77) {
                            id3FrameM3902f = m3902f(c2757x, iM3920x, m3917u(i, iM3100t, iM3100t2, iM3100t3, iM3100t4));
                        } else {
                            id3FrameM3902f = m3902f(c2757x, iM3920x, m3917u(i, iM3100t, iM3100t2, iM3100t3, iM3100t4));
                        }
                    } else if (iM3100t != 77) {
                        id3FrameM3902f = m3902f(c2757x, iM3920x, m3917u(i, iM3100t, iM3100t2, iM3100t3, iM3100t4));
                    } else {
                        id3FrameM3902f = m3902f(c2757x, iM3920x, m3917u(i, iM3100t, iM3100t2, iM3100t3, iM3100t4));
                    }
                } else if (iM3100t != 67) {
                    if (iM3100t != 77) {
                        id3FrameM3902f = m3902f(c2757x, iM3920x, m3917u(i, iM3100t, iM3100t2, iM3100t3, iM3100t4));
                    } else {
                        id3FrameM3902f = m3902f(c2757x, iM3920x, m3917u(i, iM3100t, iM3100t2, iM3100t3, iM3100t4));
                    }
                } else if (iM3100t != 77) {
                    id3FrameM3902f = m3902f(c2757x, iM3920x, m3917u(i, iM3100t, iM3100t2, iM3100t3, iM3100t4));
                } else {
                    id3FrameM3902f = m3902f(c2757x, iM3920x, m3917u(i, iM3100t, iM3100t2, iM3100t3, iM3100t4));
                }
            } else if (iM3100t != 67) {
                if (iM3100t != 67) {
                    if (iM3100t != 77) {
                        id3FrameM3902f = m3902f(c2757x, iM3920x, m3917u(i, iM3100t, iM3100t2, iM3100t3, iM3100t4));
                    } else {
                        id3FrameM3902f = m3902f(c2757x, iM3920x, m3917u(i, iM3100t, iM3100t2, iM3100t3, iM3100t4));
                    }
                } else if (iM3100t != 77) {
                    id3FrameM3902f = m3902f(c2757x, iM3920x, m3917u(i, iM3100t, iM3100t2, iM3100t3, iM3100t4));
                } else {
                    id3FrameM3902f = m3902f(c2757x, iM3920x, m3917u(i, iM3100t, iM3100t2, iM3100t3, iM3100t4));
                }
            } else if (iM3100t != 67) {
                if (iM3100t != 77) {
                    id3FrameM3902f = m3902f(c2757x, iM3920x, m3917u(i, iM3100t, iM3100t2, iM3100t3, iM3100t4));
                } else {
                    id3FrameM3902f = m3902f(c2757x, iM3920x, m3917u(i, iM3100t, iM3100t2, iM3100t3, iM3100t4));
                }
            } else if (iM3100t != 77) {
                id3FrameM3902f = m3902f(c2757x, iM3920x, m3917u(i, iM3100t, iM3100t2, iM3100t3, iM3100t4));
            } else {
                id3FrameM3902f = m3902f(c2757x, iM3920x, m3917u(i, iM3100t, iM3100t2, iM3100t3, iM3100t4));
            }
            if (id3FrameM3902f == null) {
                String strM3917u = m3917u(i, iM3100t, iM3100t2, iM3100t3, iM3100t4);
                StringBuilder sb = new StringBuilder(String.valueOf(strM3917u).length() + 50);
                sb.append("Failed to decode frame: id=");
                sb.append(strM3917u);
                sb.append(", frameSize=");
                sb.append(iM3920x);
                Log.w("Id3Decoder", sb.toString());
            }
            c2757x.m3079E(i3);
            return id3FrameM3902f;
        } catch (UnsupportedEncodingException unused) {
            Log.w((String) r4, "Unsupported character encoding");
            return null;
        } finally {
            c2757x.m3079E(i3);
        }
    }

    /* JADX INFO: renamed from: k */
    public static GeobFrame m3907k(C2757x c2757x, int i) throws UnsupportedEncodingException {
        int iM3100t = c2757x.m3100t();
        String strM3916t = m3916t(iM3100t);
        int i2 = i - 1;
        byte[] bArr = new byte[i2];
        System.arraycopy(c2757x.f6793a, c2757x.f6794b, bArr, 0, i2);
        c2757x.f6794b += i2;
        int iM3919w = m3919w(bArr, 0);
        String str = new String(bArr, 0, iM3919w, "ISO-8859-1");
        int i3 = iM3919w + 1;
        int iM3918v = m3918v(bArr, i3, iM3100t);
        String strM3910n = m3910n(bArr, i3, iM3918v, strM3916t);
        int iM3915s = m3915s(iM3100t) + iM3918v;
        int iM3918v2 = m3918v(bArr, iM3915s, iM3100t);
        return new GeobFrame(str, strM3910n, m3910n(bArr, iM3915s, iM3918v2, strM3916t), m3900c(bArr, m3915s(iM3100t) + iM3918v2, i2));
    }

    /* JADX INFO: renamed from: l */
    public static MlltFrame m3908l(C2757x c2757x, int i) {
        int iM3105y = c2757x.m3105y();
        int iM3102v = c2757x.m3102v();
        int iM3102v2 = c2757x.m3102v();
        int iM3100t = c2757x.m3100t();
        int iM3100t2 = c2757x.m3100t();
        C2756w c2756w = new C2756w();
        c2756w.m3070j(c2757x.f6793a, c2757x.f6795c);
        c2756w.m3071k(c2757x.f6794b * 8);
        int i2 = ((i - 10) * 8) / (iM3100t + iM3100t2);
        int[] iArr = new int[i2];
        int[] iArr2 = new int[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            int iM3067g = c2756w.m3067g(iM3100t);
            int iM3067g2 = c2756w.m3067g(iM3100t2);
            iArr[i3] = iM3067g;
            iArr2[i3] = iM3067g2;
        }
        return new MlltFrame(iM3105y, iM3102v, iM3102v2, iArr, iArr2);
    }

    /* JADX INFO: renamed from: m */
    public static PrivFrame m3909m(C2757x c2757x, int i) throws UnsupportedEncodingException {
        byte[] bArr = new byte[i];
        System.arraycopy(c2757x.f6793a, c2757x.f6794b, bArr, 0, i);
        c2757x.f6794b += i;
        int iM3919w = m3919w(bArr, 0);
        return new PrivFrame(new String(bArr, 0, iM3919w, "ISO-8859-1"), m3900c(bArr, iM3919w + 1, i));
    }

    /* JADX INFO: renamed from: n */
    public static String m3910n(byte[] bArr, int i, int i2, String str) throws UnsupportedEncodingException {
        return (i2 <= i || i2 > bArr.length) ? "" : new String(bArr, i, i2 - i, str);
    }

    @Nullable
    /* JADX INFO: renamed from: o */
    public static TextInformationFrame m3911o(C2757x c2757x, int i, String str) throws UnsupportedEncodingException {
        if (i < 1) {
            return null;
        }
        int iM3100t = c2757x.m3100t();
        String strM3916t = m3916t(iM3100t);
        int i2 = i - 1;
        byte[] bArr = new byte[i2];
        System.arraycopy(c2757x.f6793a, c2757x.f6794b, bArr, 0, i2);
        c2757x.f6794b += i2;
        return new TextInformationFrame(str, null, new String(bArr, 0, m3918v(bArr, 0, iM3100t), strM3916t));
    }

    @Nullable
    /* JADX INFO: renamed from: p */
    public static TextInformationFrame m3912p(C2757x c2757x, int i) throws UnsupportedEncodingException {
        if (i < 1) {
            return null;
        }
        int iM3100t = c2757x.m3100t();
        String strM3916t = m3916t(iM3100t);
        int i2 = i - 1;
        byte[] bArr = new byte[i2];
        System.arraycopy(c2757x.f6793a, c2757x.f6794b, bArr, 0, i2);
        c2757x.f6794b += i2;
        int iM3918v = m3918v(bArr, 0, iM3100t);
        String str = new String(bArr, 0, iM3918v, strM3916t);
        int iM3915s = m3915s(iM3100t) + iM3918v;
        return new TextInformationFrame("TXXX", str, m3910n(bArr, iM3915s, m3918v(bArr, iM3915s, iM3100t), strM3916t));
    }

    /* JADX INFO: renamed from: q */
    public static UrlLinkFrame m3913q(C2757x c2757x, int i, String str) throws UnsupportedEncodingException {
        byte[] bArr = new byte[i];
        System.arraycopy(c2757x.f6793a, c2757x.f6794b, bArr, 0, i);
        c2757x.f6794b += i;
        return new UrlLinkFrame(str, null, new String(bArr, 0, m3919w(bArr, 0), "ISO-8859-1"));
    }

    @Nullable
    /* JADX INFO: renamed from: r */
    public static UrlLinkFrame m3914r(C2757x c2757x, int i) throws UnsupportedEncodingException {
        if (i < 1) {
            return null;
        }
        int iM3100t = c2757x.m3100t();
        String strM3916t = m3916t(iM3100t);
        int i2 = i - 1;
        byte[] bArr = new byte[i2];
        System.arraycopy(c2757x.f6793a, c2757x.f6794b, bArr, 0, i2);
        c2757x.f6794b += i2;
        int iM3918v = m3918v(bArr, 0, iM3100t);
        String str = new String(bArr, 0, iM3918v, strM3916t);
        int iM3915s = m3915s(iM3100t) + iM3918v;
        return new UrlLinkFrame("WXXX", str, m3910n(bArr, iM3915s, m3919w(bArr, iM3915s), "ISO-8859-1"));
    }

    /* JADX INFO: renamed from: s */
    public static int m3915s(int i) {
        return (i == 0 || i == 3) ? 1 : 2;
    }

    /* JADX INFO: renamed from: t */
    public static String m3916t(int i) {
        if (i == 1) {
            return "UTF-16";
        }
        if (i != 2) {
            return i != 3 ? "ISO-8859-1" : Constants.ENCODING;
        }
        return "UTF-16BE";
    }

    /* JADX INFO: renamed from: u */
    public static String m3917u(int i, int i2, int i3, int i4, int i5) {
        return i == 2 ? String.format(Locale.US, "%c%c%c", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)) : String.format(Locale.US, "%c%c%c%c", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5));
    }

    /* JADX INFO: renamed from: v */
    public static int m3918v(byte[] bArr, int i, int i2) {
        int iM3919w = m3919w(bArr, i);
        if (i2 == 0 || i2 == 3) {
            return iM3919w;
        }
        while (iM3919w < bArr.length - 1) {
            if ((iM3919w - i) % 2 == 0 && bArr[iM3919w + 1] == 0) {
                return iM3919w;
            }
            iM3919w = m3919w(bArr, iM3919w + 1);
        }
        return bArr.length;
    }

    /* JADX INFO: renamed from: w */
    public static int m3919w(byte[] bArr, int i) {
        while (i < bArr.length) {
            if (bArr[i] == 0) {
                return i;
            }
            i++;
        }
        return bArr.length;
    }

    /* JADX INFO: renamed from: x */
    public static int m3920x(C2757x c2757x, int i) {
        byte[] bArr = c2757x.f6793a;
        int i2 = c2757x.f6794b;
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

    /* JADX INFO: renamed from: y */
    public static boolean m3921y(C2757x c2757x, int i, int i2, boolean z2) {
        int iM3102v;
        long jM3102v;
        int iM3105y;
        int i3;
        int i4 = c2757x.f6794b;
        while (true) {
            try {
                boolean z3 = true;
                if (c2757x.m3081a() < i2) {
                    c2757x.m3079E(i4);
                    return true;
                }
                if (i >= 3) {
                    iM3102v = c2757x.m3086f();
                    jM3102v = c2757x.m3101u();
                    iM3105y = c2757x.m3105y();
                } else {
                    iM3102v = c2757x.m3102v();
                    jM3102v = c2757x.m3102v();
                    iM3105y = 0;
                }
                if (iM3102v == 0 && jM3102v == 0 && iM3105y == 0) {
                    c2757x.m3079E(i4);
                    return true;
                }
                if (i == 4 && !z2) {
                    if ((8421504 & jM3102v) != 0) {
                        c2757x.m3079E(i4);
                        return false;
                    }
                    jM3102v = (((jM3102v >> 24) & 255) << 21) | (jM3102v & 255) | (((jM3102v >> 8) & 255) << 7) | (((jM3102v >> 16) & 255) << 14);
                }
                if (i == 4) {
                    i3 = (iM3105y & 64) != 0 ? 1 : 0;
                    if ((iM3105y & 1) == 0) {
                        z3 = false;
                    }
                } else {
                    if (i == 3) {
                        i3 = (iM3105y & 32) != 0 ? 1 : 0;
                        if ((iM3105y & 128) == 0) {
                        }
                    } else {
                        i3 = 0;
                    }
                    z3 = false;
                }
                if (z3) {
                    i3 += 4;
                }
                if (jM3102v < i3) {
                    c2757x.m3079E(i4);
                    return false;
                }
                if (c2757x.m3081a() < jM3102v) {
                    c2757x.m3079E(i4);
                    return false;
                }
                c2757x.m3080F((int) jM3102v);
            } catch (Throwable th) {
                c2757x.m3079E(i4);
                throw th;
            }
        }
    }

    @Override // p007b.p225i.p226a.p242c.p279z2.AbstractC3161g
    @Nullable
    /* JADX INFO: renamed from: b */
    public Metadata mo3899b(C3158d c3158d, ByteBuffer byteBuffer) {
        return m3922d(byteBuffer.array(), byteBuffer.limit());
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
    /* JADX INFO: renamed from: d */
    public Metadata m3922d(byte[] bArr, int i) {
        boolean z2;
        b bVar;
        int i2;
        int iM3920x;
        Id3Frame id3FrameM3906j;
        ArrayList arrayList = new ArrayList();
        C2757x c2757x = new C2757x(bArr, i);
        boolean z3 = false;
        if (c2757x.m3081a() < 10) {
            Log.w("Id3Decoder", "Data too short to be an ID3 tag");
        } else {
            int iM3102v = c2757x.m3102v();
            if (iM3102v == 4801587) {
                int iM3100t = c2757x.m3100t();
                c2757x.m3080F(1);
                int iM3100t2 = c2757x.m3100t();
                int iM3099s = c2757x.m3099s();
                if (iM3100t == 2) {
                    if ((iM3100t2 & 64) != 0) {
                        Log.w("Id3Decoder", "Skipped ID3 tag with majorVersion=2 and undefined compression scheme");
                    } else {
                        if (iM3100t < 4 || (iM3100t2 & 128) == 0) {
                            z2 = false;
                        } else {
                            z2 = true;
                        }
                        bVar = new b(iM3100t, z2, iM3099s);
                    }
                } else {
                    if (iM3100t == 3) {
                        if ((iM3100t2 & 64) != 0) {
                            int iM3086f = c2757x.m3086f();
                            c2757x.m3080F(iM3086f);
                            iM3099s -= iM3086f + 4;
                        }
                    } else if (iM3100t == 4) {
                        if ((iM3100t2 & 64) != 0) {
                            int iM3099s2 = c2757x.m3099s();
                            c2757x.m3080F(iM3099s2 - 4);
                            iM3099s -= iM3099s2;
                        }
                        if ((iM3100t2 & 16) != 0) {
                            iM3099s -= 10;
                        }
                    } else {
                        C1643a.m852g0(57, "Skipped ID3 tag with unsupported majorVersion=", iM3100t, "Id3Decoder");
                    }
                    if (iM3100t < 4) {
                        z2 = false;
                    } else {
                        z2 = false;
                    }
                    bVar = new b(iM3100t, z2, iM3099s);
                }
                if (bVar == null) {
                    return null;
                }
                int i3 = c2757x.f6794b;
                i2 = bVar.f9156a == 2 ? 6 : 10;
                iM3920x = bVar.f9158c;
                if (bVar.f9157b) {
                    iM3920x = m3920x(c2757x, iM3920x);
                }
                c2757x.m3078D(i3 + iM3920x);
                if (!m3921y(c2757x, bVar.f9156a, i2, false)) {
                    if (bVar.f9156a == 4 || !m3921y(c2757x, 4, i2, true)) {
                        C1643a.m852g0(56, "Failed to validate ID3 tag with majorVersion=", bVar.f9156a, "Id3Decoder");
                        return null;
                    }
                    z3 = true;
                }
                while (c2757x.m3081a() >= i2) {
                    id3FrameM3906j = m3906j(bVar.f9156a, c2757x, z3, i2, this.f9155b);
                    if (id3FrameM3906j != null) {
                        arrayList.add(id3FrameM3906j);
                    }
                }
                return new Metadata(arrayList);
            }
            String strValueOf = String.valueOf(String.format("%06X", Integer.valueOf(iM3102v)));
            Log.w("Id3Decoder", strValueOf.length() != 0 ? "Unexpected first three bytes of ID3 tag header: 0x".concat(strValueOf) : new String("Unexpected first three bytes of ID3 tag header: 0x"));
        }
        bVar = null;
        if (bVar == null) {
            return null;
        }
        int i4 = c2757x.f6794b;
        if (bVar.f9156a == 2) {
        }
        iM3920x = bVar.f9158c;
        if (bVar.f9157b) {
            iM3920x = m3920x(c2757x, iM3920x);
        }
        c2757x.m3078D(i4 + iM3920x);
        if (!m3921y(c2757x, bVar.f9156a, i2, false)) {
            if (bVar.f9156a == 4) {
            }
            C1643a.m852g0(56, "Failed to validate ID3 tag with majorVersion=", bVar.f9156a, "Id3Decoder");
            return null;
        }
        while (c2757x.m3081a() >= i2) {
            id3FrameM3906j = m3906j(bVar.f9156a, c2757x, z3, i2, this.f9155b);
            if (id3FrameM3906j != null) {
                arrayList.add(id3FrameM3906j);
            }
        }
        return new Metadata(arrayList);
    }

    public C3167b(@Nullable a aVar) {
        this.f9155b = aVar;
    }
}
