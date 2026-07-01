package b.i.a.c.x2.i0;

import android.util.Log;
import android.util.Pair;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import b.c.a.a0.AnimatableValueParser;
import b.d.b.a.outline;
import b.i.a.c.Format2;
import b.i.a.c.f3.MimeTypes;
import b.i.a.c.f3.ParsableBitArray;
import b.i.a.c.f3.ParsableByteArray;
import b.i.a.c.f3.Util2;
import b.i.a.c.g3.AvcConfig;
import b.i.a.c.g3.ColorInfo;
import b.i.a.c.g3.DolbyVisionConfig;
import b.i.a.c.g3.HevcConfig;
import b.i.a.c.t2.AacUtil;
import b.i.a.c.t2.Ac3Util;
import b.i.a.c.x2.GaplessInfoHolder;
import b.i.a.c.x2.i0.Atom;
import b.i.b.a.Function2;
import b.i.b.b.ImmutableList2;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.drm.DrmInitData;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import org.objectweb.asm.Opcodes;

/* JADX INFO: renamed from: b.i.a.c.x2.i0.e, reason: use source file name */
/* JADX INFO: compiled from: AtomParsers.java */
/* JADX INFO: loaded from: classes3.dex */
public final class AtomParsers {
    public static final byte[] a = Util2.w("OpusHead");

    /* JADX INFO: renamed from: b.i.a.c.x2.i0.e$a */
    /* JADX INFO: compiled from: AtomParsers.java */
    public interface a {
        int a();

        int b();

        int c();
    }

    /* JADX INFO: renamed from: b.i.a.c.x2.i0.e$b */
    /* JADX INFO: compiled from: AtomParsers.java */
    public static final class b {
        public final TrackEncryptionBox[] a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Nullable
        public Format2 f1211b;
        public int c;
        public int d = 0;

        public b(int i) {
            this.a = new TrackEncryptionBox[i];
        }
    }

    /* JADX INFO: renamed from: b.i.a.c.x2.i0.e$c */
    /* JADX INFO: compiled from: AtomParsers.java */
    public static final class c implements a {
        public final int a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f1212b;
        public final ParsableByteArray c;

        public c(Atom.b bVar, Format2 format2) {
            ParsableByteArray parsableByteArray = bVar.f1210b;
            this.c = parsableByteArray;
            parsableByteArray.E(12);
            int iW = parsableByteArray.w();
            if ("audio/raw".equals(format2.w)) {
                int iS = Util2.s(format2.L, format2.J);
                if (iW == 0 || iW % iS != 0) {
                    Log.w("AtomParsers", outline.h(88, "Audio sample size mismatch. stsd sample size: ", iS, ", stsz sample size: ", iW));
                    iW = iS;
                }
            }
            this.a = iW == 0 ? -1 : iW;
            this.f1212b = parsableByteArray.w();
        }

        @Override // b.i.a.c.x2.i0.AtomParsers.a
        public int a() {
            return this.a;
        }

        @Override // b.i.a.c.x2.i0.AtomParsers.a
        public int b() {
            return this.f1212b;
        }

        @Override // b.i.a.c.x2.i0.AtomParsers.a
        public int c() {
            int i = this.a;
            return i == -1 ? this.c.w() : i;
        }
    }

    /* JADX INFO: renamed from: b.i.a.c.x2.i0.e$d */
    /* JADX INFO: compiled from: AtomParsers.java */
    public static final class d implements a {
        public final ParsableByteArray a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f1213b;
        public final int c;
        public int d;
        public int e;

        public d(Atom.b bVar) {
            ParsableByteArray parsableByteArray = bVar.f1210b;
            this.a = parsableByteArray;
            parsableByteArray.E(12);
            this.c = parsableByteArray.w() & 255;
            this.f1213b = parsableByteArray.w();
        }

        @Override // b.i.a.c.x2.i0.AtomParsers.a
        public int a() {
            return -1;
        }

        @Override // b.i.a.c.x2.i0.AtomParsers.a
        public int b() {
            return this.f1213b;
        }

        @Override // b.i.a.c.x2.i0.AtomParsers.a
        public int c() {
            int i = this.c;
            if (i == 8) {
                return this.a.t();
            }
            if (i == 16) {
                return this.a.y();
            }
            int i2 = this.d;
            this.d = i2 + 1;
            if (i2 % 2 != 0) {
                return this.e & 15;
            }
            int iT = this.a.t();
            this.e = iT;
            return (iT & 240) >> 4;
        }
    }

    public static Pair<String, byte[]> a(ParsableByteArray parsableByteArray, int i) {
        parsableByteArray.E(i + 8 + 4);
        parsableByteArray.F(1);
        b(parsableByteArray);
        parsableByteArray.F(2);
        int iT = parsableByteArray.t();
        if ((iT & 128) != 0) {
            parsableByteArray.F(2);
        }
        if ((iT & 64) != 0) {
            parsableByteArray.F(parsableByteArray.y());
        }
        if ((iT & 32) != 0) {
            parsableByteArray.F(2);
        }
        parsableByteArray.F(1);
        b(parsableByteArray);
        String strD = MimeTypes.d(parsableByteArray.t());
        if ("audio/mpeg".equals(strD) || "audio/vnd.dts".equals(strD) || "audio/vnd.dts.hd".equals(strD)) {
            return Pair.create(strD, null);
        }
        parsableByteArray.F(12);
        parsableByteArray.F(1);
        int iB = b(parsableByteArray);
        byte[] bArr = new byte[iB];
        System.arraycopy(parsableByteArray.a, parsableByteArray.f984b, bArr, 0, iB);
        parsableByteArray.f984b += iB;
        return Pair.create(strD, bArr);
    }

    public static int b(ParsableByteArray parsableByteArray) {
        int iT = parsableByteArray.t();
        int i = iT & Opcodes.LAND;
        while ((iT & 128) == 128) {
            iT = parsableByteArray.t();
            i = (i << 7) | (iT & Opcodes.LAND);
        }
        return i;
    }

    @Nullable
    public static Pair<Integer, TrackEncryptionBox> c(ParsableByteArray parsableByteArray, int i, int i2) throws ParserException {
        TrackEncryptionBox trackEncryptionBox;
        Pair<Integer, TrackEncryptionBox> pairCreate;
        int i3;
        int i4;
        byte[] bArr;
        int i5 = parsableByteArray.f984b;
        while (i5 - i < i2) {
            parsableByteArray.E(i5);
            int iF = parsableByteArray.f();
            int i6 = 1;
            AnimatableValueParser.q(iF > 0, "childAtomSize must be positive");
            if (parsableByteArray.f() == 1936289382) {
                int i7 = i5 + 8;
                int i8 = -1;
                int i9 = 0;
                String strQ = null;
                Integer numValueOf = null;
                while (i7 - i5 < iF) {
                    parsableByteArray.E(i7);
                    int iF2 = parsableByteArray.f();
                    int iF3 = parsableByteArray.f();
                    if (iF3 == 1718775137) {
                        numValueOf = Integer.valueOf(parsableByteArray.f());
                    } else if (iF3 == 1935894637) {
                        parsableByteArray.F(4);
                        strQ = parsableByteArray.q(4);
                    } else if (iF3 == 1935894633) {
                        i8 = i7;
                        i9 = iF2;
                    }
                    i7 += iF2;
                }
                if ("cenc".equals(strQ) || "cbc1".equals(strQ) || "cens".equals(strQ) || "cbcs".equals(strQ)) {
                    AnimatableValueParser.q(numValueOf != null, "frma atom is mandatory");
                    AnimatableValueParser.q(i8 != -1, "schi atom is mandatory");
                    int i10 = i8 + 8;
                    while (true) {
                        if (i10 - i8 >= i9) {
                            trackEncryptionBox = null;
                            break;
                        }
                        parsableByteArray.E(i10);
                        int iF4 = parsableByteArray.f();
                        if (parsableByteArray.f() == 1952804451) {
                            int iF5 = (parsableByteArray.f() >> 24) & 255;
                            parsableByteArray.F(i6);
                            if (iF5 == 0) {
                                parsableByteArray.F(i6);
                                i3 = 0;
                                i4 = 0;
                            } else {
                                int iT = parsableByteArray.t();
                                int i11 = (iT & 240) >> 4;
                                i3 = iT & 15;
                                i4 = i11;
                            }
                            boolean z2 = parsableByteArray.t() == i6;
                            int iT2 = parsableByteArray.t();
                            byte[] bArr2 = new byte[16];
                            System.arraycopy(parsableByteArray.a, parsableByteArray.f984b, bArr2, 0, 16);
                            parsableByteArray.f984b += 16;
                            if (z2 && iT2 == 0) {
                                int iT3 = parsableByteArray.t();
                                byte[] bArr3 = new byte[iT3];
                                System.arraycopy(parsableByteArray.a, parsableByteArray.f984b, bArr3, 0, iT3);
                                parsableByteArray.f984b += iT3;
                                bArr = bArr3;
                            } else {
                                bArr = null;
                            }
                            trackEncryptionBox = new TrackEncryptionBox(z2, strQ, iT2, bArr2, i4, i3, bArr);
                            break;
                        }
                        i10 += iF4;
                        i6 = 1;
                    }
                    AnimatableValueParser.q(trackEncryptionBox != null, "tenc atom is mandatory");
                    int i12 = Util2.a;
                    pairCreate = Pair.create(numValueOf, trackEncryptionBox);
                } else {
                    pairCreate = null;
                }
                if (pairCreate != null) {
                    return pairCreate;
                }
            }
            i5 += iF;
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:232:0x0374  */
    /* JADX WARN: Code duplicated, block: B:234:0x037d  */
    /* JADX WARN: Code duplicated, block: B:235:0x0383  */
    /* JADX WARN: Code duplicated, block: B:238:0x0396  */
    /* JADX WARN: Code duplicated, block: B:239:0x03c4  */
    /* JADX WARN: Code duplicated, block: B:241:0x03cf  */
    /* JADX WARN: Code duplicated, block: B:247:0x03e4  */
    /* JADX WARN: Code duplicated, block: B:249:0x0409  */
    /* JADX WARN: Code duplicated, block: B:251:0x0424  */
    /* JADX WARN: Code duplicated, block: B:253:0x0429  */
    /* JADX WARN: Code duplicated, block: B:255:0x0452  */
    /* JADX WARN: Code duplicated, block: B:266:0x0479  */
    /* JADX WARN: Code duplicated, block: B:268:0x0493  */
    /* JADX WARN: Code duplicated, block: B:270:0x0498  */
    /* JADX WARN: Code duplicated, block: B:272:0x04af  */
    /* JADX WARN: Code duplicated, block: B:273:0x04b3  */
    /* JADX WARN: Code duplicated, block: B:277:0x04d4  */
    /* JADX WARN: Code duplicated, block: B:279:0x04d9 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:280:0x04db  */
    /* JADX WARN: Code duplicated, block: B:283:0x04ea  */
    /* JADX WARN: Code duplicated, block: B:285:0x04ef  */
    /* JADX WARN: Code duplicated, block: B:286:0x050a  */
    /* JADX WARN: Code duplicated, block: B:288:0x0511  */
    /* JADX WARN: Code duplicated, block: B:290:0x0531  */
    /* JADX WARN: Code duplicated, block: B:292:0x0536  */
    /* JADX WARN: Code duplicated, block: B:293:0x0569  */
    /* JADX WARN: Code duplicated, block: B:295:0x0570  */
    /* JADX WARN: Code duplicated, block: B:297:0x05c3 A[PHI: r6 r26
      0x05c3: PHI (r6v42 int) = (r6v18 int), (r6v44 int) binds: [B:294:0x056e, B:276:0x04d0] A[DONT_GENERATE, DONT_INLINE]
      0x05c3: PHI (r26v22 java.lang.String) = (r26v17 java.lang.String), (r26v23 java.lang.String) binds: [B:294:0x056e, B:276:0x04d0] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:299:0x05ce  */
    /* JADX WARN: Code duplicated, block: B:301:0x05d7  */
    /* JADX WARN: Code duplicated, block: B:302:0x05df  */
    /* JADX WARN: Code duplicated, block: B:304:0x05e4  */
    /* JADX WARN: Code duplicated, block: B:305:0x05e6  */
    /* JADX WARN: Code duplicated, block: B:309:0x05f0  */
    /* JADX WARN: Code duplicated, block: B:311:0x05f9  */
    /* JADX WARN: Code duplicated, block: B:312:0x05fb  */
    /* JADX WARN: Code duplicated, block: B:316:0x060e A[LOOP:2: B:307:0x05ea->B:316:0x060e, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:319:0x061e  */
    /* JADX WARN: Code duplicated, block: B:321:0x062d  */
    /* JADX WARN: Code duplicated, block: B:323:0x0635  */
    /* JADX WARN: Code duplicated, block: B:324:0x0646  */
    /* JADX WARN: Code duplicated, block: B:515:0x04e0 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:524:0x0616 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:525:0x060c A[SYNTHETIC] */
    public static b d(ParsableByteArray parsableByteArray, int i, int i2, String str, @Nullable DrmInitData drmInitData, boolean z2) throws ParserException {
        int i3;
        int i4;
        int i5;
        DrmInitData drmInitDataA;
        String str2;
        byte[] bArr;
        int i6;
        int i7;
        int i8;
        int i9;
        b bVar;
        float f;
        List<byte[]> listU;
        int i10;
        List<byte[]> list;
        String str3;
        int iY;
        int iRound;
        int iW;
        int i11;
        int i12;
        int i13;
        DrmInitData drmInitDataA2;
        String str4;
        int i14;
        int i15;
        int iIntValue;
        String str5;
        int i16;
        String str6;
        List<byte[]> listU2;
        int i17;
        int i18;
        int iF;
        boolean z3;
        int iF2;
        int i19;
        int i20;
        String str7;
        int i21;
        int i22;
        int i23;
        List<byte[]> listG;
        int i24;
        boolean z4;
        int i25;
        int iF3;
        boolean z5;
        byte[] bArr2;
        String str8;
        int iIntValue2;
        ImmutableList2 immutableList2U;
        int i26;
        int iT;
        int i27;
        String str9;
        int iT2;
        int i28;
        ImmutableList2 immutableList2U2;
        String str10;
        parsableByteArray.E(12);
        int iF4 = parsableByteArray.f();
        b bVar2 = new b(iF4);
        int i29 = 0;
        while (i29 < iF4) {
            int i30 = parsableByteArray.f984b;
            int iF5 = parsableByteArray.f();
            String str11 = "childAtomSize must be positive";
            AnimatableValueParser.q(iF5 > 0, "childAtomSize must be positive");
            int iF6 = parsableByteArray.f();
            if (iF6 == 1635148593 || iF6 == 1635148595 || iF6 == 1701733238 || iF6 == 1831958048 || iF6 == 1836070006 || iF6 == 1752589105 || iF6 == 1751479857 || iF6 == 1932670515 || iF6 == 1211250227 || iF6 == 1987063864 || iF6 == 1987063865 || iF6 == 1635135537 || iF6 == 1685479798 || iF6 == 1685479729 || iF6 == 1685481573 || iF6 == 1685481521) {
                iF4 = iF4;
                i3 = i29;
                parsableByteArray.E(i30 + 8 + 8);
                parsableByteArray.F(16);
                int iY2 = parsableByteArray.y();
                int iY3 = parsableByteArray.y();
                parsableByteArray.F(50);
                int i31 = parsableByteArray.f984b;
                if (iF6 == 1701733238) {
                    Pair<Integer, TrackEncryptionBox> pairC = c(parsableByteArray, i4, i5);
                    if (pairC != null) {
                        iF6 = ((Integer) pairC.first).intValue();
                        if (drmInitData == null) {
                            i4 = i30;
                            i5 = iF5;
                            drmInitDataA = null;
                        } else {
                            i4 = i30;
                            i5 = iF5;
                            drmInitDataA = drmInitData.a(((TrackEncryptionBox) pairC.second).f1231b);
                        }
                        bVar2.a[i3] = (TrackEncryptionBox) pairC.second;
                    } else {
                        i4 = i30;
                        i5 = iF5;
                        drmInitDataA = drmInitData;
                    }
                    parsableByteArray.E(i31);
                } else {
                    i4 = i30;
                    i5 = iF5;
                    drmInitDataA = drmInitData;
                }
                if (iF6 == 1831958048) {
                    str2 = "video/mpeg";
                } else {
                    str2 = iF6 == 1211250227 ? "video/3gpp" : null;
                }
                float fW = 1.0f;
                ByteBuffer byteBufferOrder = null;
                boolean z6 = false;
                DrmInitData drmInitData2 = drmInitDataA;
                byte[] bArrCopyOfRange = null;
                String str12 = null;
                List<byte[]> list2 = null;
                int iB = -1;
                int i32 = -1;
                int i33 = -1;
                int i34 = -1;
                while (true) {
                    if (i31 - i4 >= i5) {
                        bArr = bArrCopyOfRange;
                        i6 = i34;
                        break;
                    }
                    parsableByteArray.E(i31);
                    int i35 = parsableByteArray.f984b;
                    i6 = i34;
                    int iF7 = parsableByteArray.f();
                    bArr = bArrCopyOfRange;
                    if (iF7 == 0 && parsableByteArray.f984b - i4 == i5) {
                        break;
                    }
                    AnimatableValueParser.q(iF7 > 0, str11);
                    int iF8 = parsableByteArray.f();
                    String str13 = str11;
                    if (iF8 == 1635148611) {
                        AnimatableValueParser.q(str2 == null, null);
                        parsableByteArray.E(i35 + 8);
                        AvcConfig avcConfigB = AvcConfig.b(parsableByteArray);
                        list = avcConfigB.a;
                        bVar2.c = avcConfigB.f986b;
                        if (!z6) {
                            fW = avcConfigB.e;
                        }
                        str12 = avcConfigB.f;
                        str3 = "video/avc";
                    } else if (iF8 == 1752589123) {
                        AnimatableValueParser.q(str2 == null, null);
                        parsableByteArray.E(i35 + 8);
                        HevcConfig hevcConfigA = HevcConfig.a(parsableByteArray);
                        list = hevcConfigA.a;
                        bVar2.c = hevcConfigA.f989b;
                        if (!z6) {
                            fW = hevcConfigA.c;
                        }
                        str12 = hevcConfigA.d;
                        str3 = "video/hevc";
                    } else {
                        if (iF8 == 1685480259 || iF8 == 1685485123) {
                            iY2 = iY2;
                            iY3 = iY3;
                            bVar2 = bVar2;
                            i4 = i4;
                            i5 = i5;
                            iF6 = iF6;
                            f = fW;
                            DolbyVisionConfig dolbyVisionConfigA = DolbyVisionConfig.a(parsableByteArray);
                            if (dolbyVisionConfigA != null) {
                                str2 = "video/dolby-vision";
                                str12 = dolbyVisionConfigA.a;
                            }
                        } else {
                            if (iF8 == 1987076931) {
                                AnimatableValueParser.q(str2 == null, null);
                                str3 = iF6 == 1987063864 ? "video/x-vnd.on2.vp8" : "video/x-vnd.on2.vp9";
                                list = list2;
                            } else {
                                if (iF8 == 1635135811) {
                                    AnimatableValueParser.q(str2 == null, null);
                                    str2 = "video/av01";
                                } else if (iF8 == 1668050025) {
                                    if (byteBufferOrder == null) {
                                        byteBufferOrder = ByteBuffer.allocate(25).order(ByteOrder.LITTLE_ENDIAN);
                                    }
                                    ByteBuffer byteBuffer = byteBufferOrder;
                                    byteBuffer.position(21);
                                    byteBuffer.putShort(parsableByteArray.p());
                                    byteBuffer.putShort(parsableByteArray.p());
                                    byteBufferOrder = byteBuffer;
                                } else if (iF8 == 1835295606) {
                                    if (byteBufferOrder == null) {
                                        byteBufferOrder = ByteBuffer.allocate(25).order(ByteOrder.LITTLE_ENDIAN);
                                    }
                                    ByteBuffer byteBuffer2 = byteBufferOrder;
                                    short sP = parsableByteArray.p();
                                    short sP2 = parsableByteArray.p();
                                    short sP3 = parsableByteArray.p();
                                    short sP4 = parsableByteArray.p();
                                    short sP5 = parsableByteArray.p();
                                    short sP6 = parsableByteArray.p();
                                    float f2 = fW;
                                    short sP7 = parsableByteArray.p();
                                    short sP8 = parsableByteArray.p();
                                    long jU = parsableByteArray.u();
                                    long jU2 = parsableByteArray.u();
                                    byteBuffer2.position(1);
                                    byteBuffer2.putShort(sP5);
                                    byteBuffer2.putShort(sP6);
                                    byteBuffer2.putShort(sP);
                                    byteBuffer2.putShort(sP2);
                                    byteBuffer2.putShort(sP3);
                                    byteBuffer2.putShort(sP4);
                                    byteBuffer2.putShort(sP7);
                                    byteBuffer2.putShort(sP8);
                                    byteBuffer2.putShort((short) (jU / 10000));
                                    byteBuffer2.putShort((short) (jU2 / 10000));
                                    byteBufferOrder = byteBuffer2;
                                    list = list2;
                                    fW = f2;
                                    list2 = list;
                                    bArrCopyOfRange = bArr;
                                } else {
                                    iY2 = iY2;
                                    iY3 = iY3;
                                    bVar2 = bVar2;
                                    i4 = i4;
                                    i5 = i5;
                                    iF6 = iF6;
                                    f = fW;
                                    if (iF8 == 1681012275) {
                                        AnimatableValueParser.q(str2 == null, null);
                                        str2 = "video/3gpp";
                                    } else if (iF8 == 1702061171) {
                                        AnimatableValueParser.q(str2 == null, null);
                                        Pair<String, byte[]> pairA = a(parsableByteArray, i35);
                                        str2 = (String) pairA.first;
                                        byte[] bArr3 = (byte[]) pairA.second;
                                        listU = bArr3 != null ? ImmutableList2.u(bArr3) : list2;
                                        bArrCopyOfRange = bArr;
                                        list2 = listU;
                                        fW = f;
                                    } else if (iF8 == 1885434736) {
                                        parsableByteArray.E(i35 + 8);
                                        fW = parsableByteArray.w() / parsableByteArray.w();
                                        bArrCopyOfRange = bArr;
                                        z6 = true;
                                    } else {
                                        if (iF8 == 1937126244) {
                                            int i36 = i35 + 8;
                                            while (true) {
                                                if (i36 - i35 >= iF7) {
                                                    bArrCopyOfRange = null;
                                                    break;
                                                }
                                                parsableByteArray.E(i36);
                                                int iF9 = parsableByteArray.f();
                                                if (parsableByteArray.f() == 1886547818) {
                                                    bArrCopyOfRange = Arrays.copyOfRange(parsableByteArray.a, i36, iF9 + i36);
                                                    break;
                                                }
                                                i36 += iF9;
                                            }
                                            listU = list2;
                                        } else if (iF8 == 1936995172) {
                                            int iT3 = parsableByteArray.t();
                                            parsableByteArray.F(3);
                                            if (iT3 == 0) {
                                                int iT4 = parsableByteArray.t();
                                                if (iT4 == 0) {
                                                    i10 = 0;
                                                } else if (iT4 == 1) {
                                                    i10 = 1;
                                                } else if (iT4 == 2) {
                                                    i10 = 2;
                                                } else if (iT4 == 3) {
                                                    i10 = 3;
                                                }
                                            }
                                            i6 = i10;
                                            bArrCopyOfRange = bArr;
                                        } else if (iF8 == 1668246642) {
                                            int iF10 = parsableByteArray.f();
                                            if (iF10 == 1852009592 || iF10 == 1852009571) {
                                                int iY4 = parsableByteArray.y();
                                                int iY5 = parsableByteArray.y();
                                                parsableByteArray.F(2);
                                                boolean z7 = iF7 == 19 && (parsableByteArray.t() & 128) != 0;
                                                int iA = ColorInfo.a(iY4);
                                                int i37 = z7 ? 1 : 2;
                                                i33 = iA;
                                                iB = ColorInfo.b(iY5);
                                                i32 = i37;
                                            } else {
                                                String strValueOf = String.valueOf(Atom.a(iF10));
                                                Log.w("AtomParsers", strValueOf.length() != 0 ? "Unsupported color type: ".concat(strValueOf) : new String("Unsupported color type: "));
                                            }
                                        }
                                        list2 = listU;
                                        fW = f;
                                    }
                                }
                                list = list2;
                                list2 = list;
                                bArrCopyOfRange = bArr;
                            }
                            i31 += iF7;
                            i34 = i6;
                            str11 = str13;
                            iF6 = iF6;
                            i4 = i4;
                            i5 = i5;
                            bVar2 = bVar2;
                            iY3 = iY3;
                            iY2 = iY2;
                        }
                        i10 = i6;
                        i6 = i10;
                        bArrCopyOfRange = bArr;
                        list2 = listU;
                        fW = f;
                        i31 += iF7;
                        i34 = i6;
                        str11 = str13;
                        iF6 = iF6;
                        i4 = i4;
                        i5 = i5;
                        bVar2 = bVar2;
                        iY3 = iY3;
                        iY2 = iY2;
                    }
                    str2 = str3;
                    list2 = list;
                    bArrCopyOfRange = bArr;
                    i31 += iF7;
                    i34 = i6;
                    str11 = str13;
                    iF6 = iF6;
                    i4 = i4;
                    i5 = i5;
                    bVar2 = bVar2;
                    iY3 = iY3;
                    iY2 = iY2;
                }
                float f3 = fW;
                if (str2 == null) {
                    bVar = bVar2;
                } else {
                    Format2.b bVar3 = new Format2.b();
                    bVar3.b(i);
                    bVar3.k = str2;
                    bVar3.h = str12;
                    bVar3.p = iY2;
                    bVar3.q = i7;
                    bVar3.t = f3;
                    bVar3.f1022s = i2;
                    bVar3.u = bArr;
                    bVar3.v = i6;
                    bVar3.m = list2;
                    bVar3.n = drmInitData2;
                    int i38 = i33;
                    if (i38 == -1) {
                        i9 = i32;
                        i8 = iB;
                        if (i9 != -1 || i8 != -1 || byteBufferOrder != null) {
                        }
                        Format2 format2A = bVar3.a();
                        bVar = bVar2;
                        bVar.f1211b = format2A;
                    } else {
                        i7 = iY3;
                        i8 = iB;
                        i9 = i32;
                    }
                    i7 = iY3;
                    bVar3.w = new ColorInfo(i38, i9, i8, byteBufferOrder != null ? byteBufferOrder.array() : null);
                    Format2 format2A2 = bVar3.a();
                    bVar = bVar2;
                    bVar.f1211b = format2A2;
                }
            } else if (iF6 == 1836069985 || iF6 == 1701733217 || iF6 == 1633889587 || iF6 == 1700998451 || iF6 == 1633889588 || iF6 == 1835823201 || iF6 == 1685353315 || iF6 == 1685353317 || iF6 == 1685353320 || iF6 == 1685353324 || iF6 == 1685353336 || iF6 == 1935764850 || iF6 == 1935767394 || iF6 == 1819304813 || iF6 == 1936684916 || iF6 == 1953984371 || iF6 == 778924082 || iF6 == 778924083 || iF6 == 1835557169 || iF6 == 1835560241 || iF6 == 1634492771 || iF6 == 1634492791 || iF6 == 1970037111 || iF6 == 1332770163 || iF6 == 1716281667) {
                parsableByteArray.E(i30 + 8 + 8);
                if (z2) {
                    iY = parsableByteArray.y();
                    parsableByteArray.F(6);
                } else {
                    parsableByteArray.F(8);
                    iY = 0;
                }
                if (iY == 0 || iY == 1) {
                    int iY6 = parsableByteArray.y();
                    parsableByteArray.F(6);
                    byte[] bArr4 = parsableByteArray.a;
                    int i39 = parsableByteArray.f984b;
                    int i40 = i39 + 1;
                    parsableByteArray.f984b = i40;
                    int i41 = (bArr4[i39] & 255) << 8;
                    int i42 = i40 + 1;
                    parsableByteArray.f984b = i42;
                    iRound = (bArr4[i40] & 255) | i41;
                    int i43 = i42 + 2;
                    parsableByteArray.f984b = i43;
                    parsableByteArray.E(i43 - 4);
                    int iF11 = parsableByteArray.f();
                    if (iY == 1) {
                        parsableByteArray.F(16);
                    }
                    iW = iY6;
                    i11 = iF11;
                } else {
                    if (iY == 2) {
                        parsableByteArray.F(16);
                        iRound = (int) Math.round(Double.longBitsToDouble(parsableByteArray.m()));
                        iW = parsableByteArray.w();
                        parsableByteArray.F(20);
                        i11 = 0;
                    } else {
                        iF4 = iF4;
                        i3 = i29;
                        i13 = i30;
                        i12 = iF5;
                    }
                    bVar = bVar2;
                    i4 = i13;
                    i5 = i12;
                }
                int i44 = parsableByteArray.f984b;
                if (iF6 == 1701733217) {
                    Pair<Integer, TrackEncryptionBox> pairC2 = c(parsableByteArray, i30, iF5);
                    if (pairC2 != null) {
                        int iIntValue3 = ((Integer) pairC2.first).intValue();
                        drmInitDataA2 = drmInitData == 0 ? null : drmInitData.a(((TrackEncryptionBox) pairC2.second).f1231b);
                        bVar2.a[i29] = (TrackEncryptionBox) pairC2.second;
                        iF6 = iIntValue3;
                    } else {
                        drmInitDataA2 = drmInitData;
                    }
                    parsableByteArray.E(i44);
                } else {
                    drmInitDataA2 = drmInitData;
                }
                String str14 = "audio/ac3";
                String str15 = "audio/raw";
                int i45 = iW;
                if (iF6 == 1633889587) {
                    str15 = "audio/ac3";
                } else if (iF6 == 1700998451) {
                    str15 = "audio/eac3";
                } else if (iF6 == 1633889588) {
                    str15 = "audio/ac4";
                } else {
                    if (iF6 == 1685353315) {
                        str4 = "audio/vnd.dts";
                    } else if (iF6 == 1685353320 || iF6 == 1685353324) {
                        str4 = "audio/vnd.dts.hd";
                    } else if (iF6 == 1685353317) {
                        str4 = "audio/vnd.dts.hd;profile=lbr";
                    } else if (iF6 == 1685353336) {
                        str4 = "audio/vnd.dts.uhd;profile=p2";
                    } else if (iF6 == 1935764850) {
                        str4 = "audio/3gpp";
                    } else if (iF6 == 1935767394) {
                        str4 = "audio/amr-wb";
                    } else {
                        if (iF6 == 1819304813 || iF6 == 1936684916) {
                            i14 = 2;
                        } else if (iF6 == 1953984371) {
                            i14 = 268435456;
                        } else if (iF6 == 778924082 || iF6 == 778924083) {
                            str4 = "audio/mpeg";
                        } else if (iF6 == 1835557169) {
                            str4 = "audio/mha1";
                        } else if (iF6 == 1835560241) {
                            str4 = "audio/mhm1";
                        } else if (iF6 == 1634492771) {
                            str4 = "audio/alac";
                        } else if (iF6 == 1634492791) {
                            str4 = "audio/g711-alaw";
                        } else if (iF6 == 1970037111) {
                            str4 = "audio/g711-mlaw";
                        } else if (iF6 == 1332770163) {
                            str4 = "audio/opus";
                        } else if (iF6 == 1716281667) {
                            str4 = "audio/flac";
                        } else if (iF6 == 1835823201) {
                            str4 = "audio/true-hd";
                        } else {
                            i14 = -1;
                            str15 = null;
                        }
                        i15 = iRound;
                        iIntValue = i45;
                        str5 = null;
                        i3 = i29;
                        String str16 = str15;
                        i16 = i14;
                        str6 = str16;
                        listU2 = null;
                        i17 = i44;
                        while (i17 - i30 < iF5) {
                            parsableByteArray.E(i17);
                            iF = parsableByteArray.f();
                            if (iF > 0) {
                                z3 = true;
                            } else {
                                z3 = false;
                            }
                            AnimatableValueParser.q(z3, str11);
                            iF2 = parsableByteArray.f();
                            int i46 = i30;
                            if (iF2 == 1835557187) {
                                int i47 = iF - 13;
                                byte[] bArr5 = new byte[i47];
                                parsableByteArray.E(i17 + 13);
                                System.arraycopy(parsableByteArray.a, parsableByteArray.f984b, bArr5, 0, i47);
                                parsableByteArray.f984b += i47;
                                listU2 = ImmutableList2.u(bArr5);
                                str11 = str11;
                                i23 = iF;
                                i15 = i15;
                                str14 = str14;
                                i22 = i11;
                            } else {
                                i19 = i15;
                                i20 = iF;
                                str7 = str11;
                                if (iF2 != 1702061171) {
                                    if (z2 || iF2 != 2002876005) {
                                        if (iF2 == 1684103987) {
                                            parsableByteArray.E(i17 + 8);
                                            String string = Integer.toString(i);
                                            int i48 = Ac3Util.f1123b[(parsableByteArray.t() & Opcodes.CHECKCAST) >> 6];
                                            iT2 = parsableByteArray.t();
                                            i28 = Ac3Util.d[(iT2 & 56) >> 3];
                                            if ((iT2 & 4) != 0) {
                                                i28++;
                                            }
                                            Format2.b bVar4 = new Format2.b();
                                            bVar4.a = string;
                                            bVar4.k = str14;
                                            bVar4.f1023x = i28;
                                            bVar4.f1024y = i48;
                                            bVar4.n = drmInitDataA2;
                                            bVar4.c = str;
                                            bVar2.f1211b = bVar4.a();
                                        } else if (iF2 == 1684366131) {
                                            parsableByteArray.E(i17 + 8);
                                            String string2 = Integer.toString(i);
                                            parsableByteArray.F(2);
                                            int i49 = Ac3Util.f1123b[(parsableByteArray.t() & Opcodes.CHECKCAST) >> 6];
                                            iT = parsableByteArray.t();
                                            i27 = Ac3Util.d[(iT & 14) >> 1];
                                            if ((iT & 1) != 0) {
                                                i27++;
                                            }
                                            if (((parsableByteArray.t() & 30) >> 1) > 0 && (parsableByteArray.t() & 2) != 0) {
                                                i27 += 2;
                                            }
                                            if (parsableByteArray.a() > 0 || (parsableByteArray.t() & 1) == 0) {
                                                str9 = "audio/eac3";
                                            } else {
                                                str9 = "audio/eac3-joc";
                                            }
                                            Format2.b bVar5 = new Format2.b();
                                            bVar5.a = string2;
                                            bVar5.k = str9;
                                            bVar5.f1023x = i27;
                                            bVar5.f1024y = i49;
                                            bVar5.n = drmInitDataA2;
                                            bVar5.c = str;
                                            bVar2.f1211b = bVar5.a();
                                        } else {
                                            if (iF2 == 1684103988) {
                                                parsableByteArray.E(i17 + 8);
                                                String string3 = Integer.toString(i);
                                                parsableByteArray.F(1);
                                                if (((parsableByteArray.t() & 32) >> 5) == 1) {
                                                    i26 = 48000;
                                                } else {
                                                    i26 = 44100;
                                                }
                                                Format2.b bVar6 = new Format2.b();
                                                bVar6.a = string3;
                                                bVar6.k = "audio/ac4";
                                                bVar6.f1023x = 2;
                                                bVar6.f1024y = i26;
                                                bVar6.n = drmInitDataA2;
                                                bVar6.c = str;
                                                bVar2.f1211b = bVar6.a();
                                            } else {
                                                if (iF2 == 1684892784) {
                                                    if (i11 > 0) {
                                                        throw outline.w0(60, "Invalid sample rate for Dolby TrueHD MLP stream: ", i11, null);
                                                    }
                                                    iIntValue = 2;
                                                    i15 = i11;
                                                    listG = listU2;
                                                } else if (iF2 == 1684305011) {
                                                    Format2.b bVar7 = new Format2.b();
                                                    bVar7.b(i);
                                                    bVar7.k = str6;
                                                    bVar7.f1023x = iIntValue;
                                                    iIntValue2 = i19;
                                                    bVar7.f1024y = iIntValue2;
                                                    bVar7.n = drmInitDataA2;
                                                    bVar7.c = str;
                                                    bVar2.f1211b = bVar7.a();
                                                    str14 = str14;
                                                    i15 = iIntValue2;
                                                    listG = listU2;
                                                } else {
                                                    iIntValue2 = i19;
                                                    if (iF2 == 1682927731) {
                                                        int i50 = i20 - 8;
                                                        byte[] bArr6 = a;
                                                        byte[] bArrCopyOf = Arrays.copyOf(bArr6, bArr6.length + i50);
                                                        parsableByteArray.E(i17 + 8);
                                                        parsableByteArray.e(bArrCopyOf, bArr6.length, i50);
                                                        listG = AnimatableValueParser.g(bArrCopyOf);
                                                        i15 = iIntValue2;
                                                    } else {
                                                        if (iF2 == 1684425825) {
                                                            int i51 = i20 - 12;
                                                            byte[] bArr7 = new byte[i51 + 4];
                                                            bArr7[0] = 102;
                                                            bArr7[1] = 76;
                                                            bArr7[2] = 97;
                                                            bArr7[3] = 67;
                                                            parsableByteArray.E(i17 + 12);
                                                            str14 = str14;
                                                            System.arraycopy(parsableByteArray.a, parsableByteArray.f984b, bArr7, 4, i51);
                                                            parsableByteArray.f984b += i51;
                                                            immutableList2U = ImmutableList2.u(bArr7);
                                                        } else {
                                                            str14 = str14;
                                                            if (iF2 == 1634492771) {
                                                                int i52 = i20 - 12;
                                                                byte[] bArr8 = new byte[i52];
                                                                parsableByteArray.E(i17 + 12);
                                                                System.arraycopy(parsableByteArray.a, parsableByteArray.f984b, bArr8, 0, i52);
                                                                parsableByteArray.f984b += i52;
                                                                ParsableByteArray parsableByteArray2 = new ParsableByteArray(bArr8);
                                                                parsableByteArray2.E(9);
                                                                int iT5 = parsableByteArray2.t();
                                                                parsableByteArray2.E(20);
                                                                Pair pairCreate = Pair.create(Integer.valueOf(parsableByteArray2.w()), Integer.valueOf(iT5));
                                                                iIntValue2 = ((Integer) pairCreate.first).intValue();
                                                                iIntValue = ((Integer) pairCreate.second).intValue();
                                                                immutableList2U = ImmutableList2.u(bArr8);
                                                            } else {
                                                                i15 = iIntValue2;
                                                                listG = listU2;
                                                            }
                                                        }
                                                        int i53 = iIntValue2;
                                                        listG = immutableList2U;
                                                        i15 = i53;
                                                    }
                                                }
                                                str14 = str14;
                                            }
                                            str11 = str7;
                                            i23 = i20;
                                            i22 = i11;
                                        }
                                        iIntValue2 = i19;
                                        str14 = str14;
                                        i15 = iIntValue2;
                                        listG = listU2;
                                        str11 = str7;
                                        i23 = i20;
                                        i22 = i11;
                                    } else {
                                        i21 = 1702061171;
                                    }
                                    listU2 = listG;
                                } else {
                                    i21 = 1702061171;
                                }
                                if (iF2 == i21) {
                                    i24 = i17;
                                    str11 = str7;
                                    i23 = i20;
                                    i22 = i11;
                                } else {
                                    i24 = parsableByteArray.f984b;
                                    if (i24 >= i17) {
                                        z4 = true;
                                    } else {
                                        z4 = false;
                                    }
                                    AnimatableValueParser.q(z4, null);
                                    while (true) {
                                        i23 = i20;
                                        if (i24 - i17 < i23) {
                                            str11 = str7;
                                            i22 = i11;
                                            i25 = -1;
                                            i24 = -1;
                                            break;
                                        }
                                        parsableByteArray.E(i24);
                                        iF3 = parsableByteArray.f();
                                        if (iF3 > 0) {
                                            z5 = true;
                                        } else {
                                            z5 = false;
                                        }
                                        str11 = str7;
                                        AnimatableValueParser.q(z5, str11);
                                        i22 = i11;
                                        if (parsableByteArray.f() == 1702061171) {
                                            i24 += iF3;
                                            i20 = i23;
                                            i11 = i22;
                                            str7 = str11;
                                        }
                                    }
                                    if (i24 != i25) {
                                        Pair<String, byte[]> pairA2 = a(parsableByteArray, i24);
                                        str6 = (String) pairA2.first;
                                        bArr2 = (byte[]) pairA2.second;
                                        if (bArr2 != null) {
                                            if ("audio/mp4a-latm".equals(str6)) {
                                                AacUtil.b bVarB = AacUtil.b(new ParsableBitArray(bArr2), false);
                                                i19 = bVarB.a;
                                                iIntValue = bVarB.f1122b;
                                                str8 = bVarB.c;
                                            } else {
                                                str8 = str5;
                                            }
                                            listU2 = ImmutableList2.u(bArr2);
                                            str5 = str8;
                                            i15 = i19;
                                        }
                                    }
                                    i15 = i19;
                                    listG = listU2;
                                    listU2 = listG;
                                }
                                i25 = -1;
                                if (i24 != i25) {
                                    Pair<String, byte[]> pairA3 = a(parsableByteArray, i24);
                                    str6 = (String) pairA3.first;
                                    bArr2 = (byte[]) pairA3.second;
                                    if (bArr2 != null) {
                                        if ("audio/mp4a-latm".equals(str6)) {
                                            AacUtil.b bVarB2 = AacUtil.b(new ParsableBitArray(bArr2), false);
                                            i19 = bVarB2.a;
                                            iIntValue = bVarB2.f1122b;
                                            str8 = bVarB2.c;
                                        } else {
                                            str8 = str5;
                                        }
                                        listU2 = ImmutableList2.u(bArr2);
                                        str5 = str8;
                                        i15 = i19;
                                    }
                                }
                                i15 = i19;
                                listG = listU2;
                                listU2 = listG;
                            }
                            i17 += i23;
                            i30 = i46;
                            iF5 = iF5;
                            i11 = i22;
                            str14 = str14;
                        }
                        i18 = i15;
                        i13 = i30;
                        i12 = iF5;
                        if (bVar2.f1211b == null && str6 != null) {
                            Format2.b bVar8 = new Format2.b();
                            bVar8.b(i);
                            bVar8.k = str6;
                            bVar8.h = str5;
                            bVar8.f1023x = iIntValue;
                            bVar8.f1024y = i18;
                            bVar8.f1025z = i16;
                            bVar8.m = listU2;
                            bVar8.n = drmInitDataA2;
                            bVar8.c = str;
                            bVar2.f1211b = bVar8.a();
                        }
                        bVar = bVar2;
                        i4 = i13;
                        i5 = i12;
                    }
                    str15 = str4;
                }
                i14 = -1;
                i15 = iRound;
                iIntValue = i45;
                str5 = null;
                i3 = i29;
                String str17 = str15;
                i16 = i14;
                str6 = str17;
                listU2 = null;
                i17 = i44;
                while (i17 - i30 < iF5) {
                    parsableByteArray.E(i17);
                    iF = parsableByteArray.f();
                    if (iF > 0) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    AnimatableValueParser.q(z3, str11);
                    iF2 = parsableByteArray.f();
                    int i410 = i30;
                    if (iF2 == 1835557187) {
                        int i411 = iF - 13;
                        byte[] bArr9 = new byte[i411];
                        parsableByteArray.E(i17 + 13);
                        System.arraycopy(parsableByteArray.a, parsableByteArray.f984b, bArr9, 0, i411);
                        parsableByteArray.f984b += i411;
                        listU2 = ImmutableList2.u(bArr9);
                        str11 = str11;
                        i23 = iF;
                        i15 = i15;
                        str14 = str14;
                        i22 = i11;
                    } else {
                        i19 = i15;
                        i20 = iF;
                        str7 = str11;
                        if (iF2 != 1702061171) {
                            if (z2) {
                            }
                            if (iF2 == 1684103987) {
                                parsableByteArray.E(i17 + 8);
                                String string4 = Integer.toString(i);
                                int i412 = Ac3Util.f1123b[(parsableByteArray.t() & Opcodes.CHECKCAST) >> 6];
                                iT2 = parsableByteArray.t();
                                i28 = Ac3Util.d[(iT2 & 56) >> 3];
                                if ((iT2 & 4) != 0) {
                                    i28++;
                                }
                                Format2.b bVar9 = new Format2.b();
                                bVar9.a = string4;
                                bVar9.k = str14;
                                bVar9.f1023x = i28;
                                bVar9.f1024y = i412;
                                bVar9.n = drmInitDataA2;
                                bVar9.c = str;
                                bVar2.f1211b = bVar9.a();
                            } else if (iF2 == 1684366131) {
                                parsableByteArray.E(i17 + 8);
                                String string5 = Integer.toString(i);
                                parsableByteArray.F(2);
                                int i413 = Ac3Util.f1123b[(parsableByteArray.t() & Opcodes.CHECKCAST) >> 6];
                                iT = parsableByteArray.t();
                                i27 = Ac3Util.d[(iT & 14) >> 1];
                                if ((iT & 1) != 0) {
                                    i27++;
                                }
                                if (((parsableByteArray.t() & 30) >> 1) > 0) {
                                    i27 += 2;
                                }
                                if (parsableByteArray.a() > 0) {
                                    str9 = "audio/eac3";
                                } else {
                                    str9 = "audio/eac3";
                                }
                                Format2.b bVar10 = new Format2.b();
                                bVar10.a = string5;
                                bVar10.k = str9;
                                bVar10.f1023x = i27;
                                bVar10.f1024y = i413;
                                bVar10.n = drmInitDataA2;
                                bVar10.c = str;
                                bVar2.f1211b = bVar10.a();
                            } else {
                                if (iF2 == 1684103988) {
                                    parsableByteArray.E(i17 + 8);
                                    String string6 = Integer.toString(i);
                                    parsableByteArray.F(1);
                                    if (((parsableByteArray.t() & 32) >> 5) == 1) {
                                        i26 = 48000;
                                    } else {
                                        i26 = 44100;
                                    }
                                    Format2.b bVar11 = new Format2.b();
                                    bVar11.a = string6;
                                    bVar11.k = "audio/ac4";
                                    bVar11.f1023x = 2;
                                    bVar11.f1024y = i26;
                                    bVar11.n = drmInitDataA2;
                                    bVar11.c = str;
                                    bVar2.f1211b = bVar11.a();
                                } else {
                                    if (iF2 == 1684892784) {
                                        if (i11 > 0) {
                                            throw outline.w0(60, "Invalid sample rate for Dolby TrueHD MLP stream: ", i11, null);
                                        }
                                        iIntValue = 2;
                                        i15 = i11;
                                        listG = listU2;
                                    } else if (iF2 == 1684305011) {
                                        Format2.b bVar12 = new Format2.b();
                                        bVar12.b(i);
                                        bVar12.k = str6;
                                        bVar12.f1023x = iIntValue;
                                        iIntValue2 = i19;
                                        bVar12.f1024y = iIntValue2;
                                        bVar12.n = drmInitDataA2;
                                        bVar12.c = str;
                                        bVar2.f1211b = bVar12.a();
                                        str14 = str14;
                                        i15 = iIntValue2;
                                        listG = listU2;
                                    } else {
                                        iIntValue2 = i19;
                                        if (iF2 == 1682927731) {
                                            int i54 = i20 - 8;
                                            byte[] bArr10 = a;
                                            byte[] bArrCopyOf2 = Arrays.copyOf(bArr10, bArr10.length + i54);
                                            parsableByteArray.E(i17 + 8);
                                            parsableByteArray.e(bArrCopyOf2, bArr10.length, i54);
                                            listG = AnimatableValueParser.g(bArrCopyOf2);
                                            i15 = iIntValue2;
                                        } else {
                                            if (iF2 == 1684425825) {
                                                int i55 = i20 - 12;
                                                byte[] bArr11 = new byte[i55 + 4];
                                                bArr11[0] = 102;
                                                bArr11[1] = 76;
                                                bArr11[2] = 97;
                                                bArr11[3] = 67;
                                                parsableByteArray.E(i17 + 12);
                                                str14 = str14;
                                                System.arraycopy(parsableByteArray.a, parsableByteArray.f984b, bArr11, 4, i55);
                                                parsableByteArray.f984b += i55;
                                                immutableList2U = ImmutableList2.u(bArr11);
                                            } else {
                                                str14 = str14;
                                                if (iF2 == 1634492771) {
                                                    int i56 = i20 - 12;
                                                    byte[] bArr12 = new byte[i56];
                                                    parsableByteArray.E(i17 + 12);
                                                    System.arraycopy(parsableByteArray.a, parsableByteArray.f984b, bArr12, 0, i56);
                                                    parsableByteArray.f984b += i56;
                                                    ParsableByteArray parsableByteArray3 = new ParsableByteArray(bArr12);
                                                    parsableByteArray3.E(9);
                                                    int iT6 = parsableByteArray3.t();
                                                    parsableByteArray3.E(20);
                                                    Pair pairCreate2 = Pair.create(Integer.valueOf(parsableByteArray3.w()), Integer.valueOf(iT6));
                                                    iIntValue2 = ((Integer) pairCreate2.first).intValue();
                                                    iIntValue = ((Integer) pairCreate2.second).intValue();
                                                    immutableList2U = ImmutableList2.u(bArr12);
                                                } else {
                                                    i15 = iIntValue2;
                                                    listG = listU2;
                                                }
                                            }
                                            int i57 = iIntValue2;
                                            listG = immutableList2U;
                                            i15 = i57;
                                        }
                                    }
                                    str14 = str14;
                                }
                                str11 = str7;
                                i23 = i20;
                                i22 = i11;
                                listU2 = listG;
                            }
                            iIntValue2 = i19;
                            str14 = str14;
                            i15 = iIntValue2;
                            listG = listU2;
                            str11 = str7;
                            i23 = i20;
                            i22 = i11;
                            listU2 = listG;
                        } else {
                            i21 = 1702061171;
                        }
                        if (iF2 == i21) {
                            i24 = i17;
                            str11 = str7;
                            i23 = i20;
                            i22 = i11;
                        } else {
                            i24 = parsableByteArray.f984b;
                            if (i24 >= i17) {
                                z4 = true;
                            } else {
                                z4 = false;
                            }
                            AnimatableValueParser.q(z4, null);
                            while (true) {
                                i23 = i20;
                                if (i24 - i17 < i23) {
                                    str11 = str7;
                                    i22 = i11;
                                    i25 = -1;
                                    i24 = -1;
                                    break;
                                }
                                parsableByteArray.E(i24);
                                iF3 = parsableByteArray.f();
                                if (iF3 > 0) {
                                    z5 = true;
                                } else {
                                    z5 = false;
                                }
                                str11 = str7;
                                AnimatableValueParser.q(z5, str11);
                                i22 = i11;
                                if (parsableByteArray.f() == 1702061171) {
                                    i24 += iF3;
                                    i20 = i23;
                                    i11 = i22;
                                    str7 = str11;
                                }
                            }
                            if (i24 != i25) {
                                Pair<String, byte[]> pairA4 = a(parsableByteArray, i24);
                                str6 = (String) pairA4.first;
                                bArr2 = (byte[]) pairA4.second;
                                if (bArr2 != null) {
                                    if ("audio/mp4a-latm".equals(str6)) {
                                        AacUtil.b bVarB3 = AacUtil.b(new ParsableBitArray(bArr2), false);
                                        i19 = bVarB3.a;
                                        iIntValue = bVarB3.f1122b;
                                        str8 = bVarB3.c;
                                    } else {
                                        str8 = str5;
                                    }
                                    listU2 = ImmutableList2.u(bArr2);
                                    str5 = str8;
                                    i15 = i19;
                                }
                            }
                            i15 = i19;
                            listG = listU2;
                            listU2 = listG;
                        }
                        i25 = -1;
                        if (i24 != i25) {
                            Pair<String, byte[]> pairA5 = a(parsableByteArray, i24);
                            str6 = (String) pairA5.first;
                            bArr2 = (byte[]) pairA5.second;
                            if (bArr2 != null) {
                                if ("audio/mp4a-latm".equals(str6)) {
                                    AacUtil.b bVarB4 = AacUtil.b(new ParsableBitArray(bArr2), false);
                                    i19 = bVarB4.a;
                                    iIntValue = bVarB4.f1122b;
                                    str8 = bVarB4.c;
                                } else {
                                    str8 = str5;
                                }
                                listU2 = ImmutableList2.u(bArr2);
                                str5 = str8;
                                i15 = i19;
                            }
                        }
                        i15 = i19;
                        listG = listU2;
                        listU2 = listG;
                    }
                    i17 += i23;
                    i30 = i410;
                    iF5 = iF5;
                    i11 = i22;
                    str14 = str14;
                }
                i18 = i15;
                i13 = i30;
                i12 = iF5;
                if (bVar2.f1211b == null) {
                    Format2.b bVar13 = new Format2.b();
                    bVar13.b(i);
                    bVar13.k = str6;
                    bVar13.h = str5;
                    bVar13.f1023x = iIntValue;
                    bVar13.f1024y = i18;
                    bVar13.f1025z = i16;
                    bVar13.m = listU2;
                    bVar13.n = drmInitDataA2;
                    bVar13.c = str;
                    bVar2.f1211b = bVar13.a();
                }
                bVar = bVar2;
                i4 = i13;
                i5 = i12;
            } else {
                if (iF6 == 1414810956 || iF6 == 1954034535 || iF6 == 2004251764 || iF6 == 1937010800 || iF6 == 1664495672) {
                    parsableByteArray.E(i30 + 8 + 8);
                    long j = RecyclerView.FOREVER_NS;
                    String str18 = "application/ttml+xml";
                    if (iF6 == 1414810956) {
                        immutableList2U2 = null;
                        str10 = str18;
                    } else if (iF6 == 1954034535) {
                        int i58 = (iF5 - 8) - 8;
                        byte[] bArr13 = new byte[i58];
                        System.arraycopy(parsableByteArray.a, parsableByteArray.f984b, bArr13, 0, i58);
                        parsableByteArray.f984b += i58;
                        immutableList2U2 = ImmutableList2.u(bArr13);
                        str10 = "application/x-quicktime-tx3g";
                    } else {
                        if (iF6 == 2004251764) {
                            str18 = "application/x-mp4-vtt";
                        } else if (iF6 == 1937010800) {
                            j = 0;
                        } else {
                            if (iF6 != 1664495672) {
                                throw new IllegalStateException();
                            }
                            bVar2.d = 1;
                            str18 = "application/x-mp4-cea-608";
                        }
                        immutableList2U2 = null;
                        str10 = str18;
                    }
                    Format2.b bVar14 = new Format2.b();
                    bVar14.b(i);
                    bVar14.k = str10;
                    bVar14.c = str;
                    bVar14.o = j;
                    bVar14.m = immutableList2U2;
                    bVar2.f1211b = bVar14.a();
                } else if (iF6 == 1835365492) {
                    parsableByteArray.E(i30 + 8 + 8);
                    if (iF6 == 1835365492) {
                        parsableByteArray.n();
                        String strN = parsableByteArray.n();
                        if (strN != null) {
                            Format2.b bVar15 = new Format2.b();
                            bVar15.b(i);
                            bVar15.k = strN;
                            bVar2.f1211b = bVar15.a();
                        }
                    }
                } else if (iF6 == 1667329389) {
                    Format2.b bVar16 = new Format2.b();
                    bVar16.b(i);
                    bVar16.k = "application/x-camera-motion";
                    bVar2.f1211b = bVar16.a();
                }
                iF4 = iF4;
                bVar = bVar2;
                i3 = i29;
                i4 = i30;
                i5 = iF5;
            }
            parsableByteArray.E(i4 + i5);
            i29 = i3 + 1;
            bVar2 = bVar;
            iF4 = iF4;
        }
        return bVar2;
    }

    /* JADX WARN: Code duplicated, block: B:117:0x0284  */
    /* JADX WARN: Code duplicated, block: B:120:0x028e  */
    /* JADX WARN: Code duplicated, block: B:121:0x0292  */
    /* JADX WARN: Code duplicated, block: B:173:0x03f0  */
    /* JADX WARN: Code duplicated, block: B:175:0x03f3  */
    /* JADX WARN: Code duplicated, block: B:178:0x0400  */
    /* JADX WARN: Code duplicated, block: B:179:0x0402 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:180:0x0404  */
    /* JADX WARN: Code duplicated, block: B:181:0x0409  */
    /* JADX WARN: Code duplicated, block: B:183:0x040f  */
    /* JADX WARN: Code duplicated, block: B:185:0x041b  */
    /* JADX WARN: Code duplicated, block: B:186:0x0422  */
    /* JADX WARN: Code duplicated, block: B:189:0x0426 A[LOOP:2: B:176:0x03fc->B:189:0x0426, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:192:0x0433 A[LOOP:3: B:191:0x0431->B:192:0x0433, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:195:0x044c  */
    /* JADX WARN: Code duplicated, block: B:197:0x045e A[LOOP:5: B:196:0x045c->B:197:0x045e, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:200:0x04a2  */
    /* JADX WARN: Code duplicated, block: B:203:0x04dc  */
    /* JADX WARN: Code duplicated, block: B:205:0x04e6  */
    /* JADX WARN: Code duplicated, block: B:207:0x04ec  */
    /* JADX WARN: Code duplicated, block: B:208:0x04ef A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:209:0x04f1  */
    /* JADX WARN: Code duplicated, block: B:210:0x04f6  */
    /* JADX WARN: Code duplicated, block: B:212:0x04fc  */
    /* JADX WARN: Code duplicated, block: B:214:0x0508  */
    /* JADX WARN: Code duplicated, block: B:215:0x050f  */
    /* JADX WARN: Code duplicated, block: B:219:0x0516 A[LOOP:12: B:204:0x04e4->B:219:0x0516, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:223:0x0539 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:224:0x053b A[ADDED_TO_REGION, LOOP:13: B:224:0x053b->B:226:0x053f, LOOP_START, PHI: r19 r37 r38
      0x053b: PHI (r19v7 int) = (r19v3 int), (r19v8 int) binds: [B:223:0x0539, B:226:0x053f] A[DONT_GENERATE, DONT_INLINE]
      0x053b: PHI (r37v4 int) = (r37v1 int), (r37v5 int) binds: [B:223:0x0539, B:226:0x053f] A[DONT_GENERATE, DONT_INLINE]
      0x053b: PHI (r38v3 int) = (r38v1 int), (r38v5 int) binds: [B:223:0x0539, B:226:0x053f] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:230:0x055a  */
    /* JADX WARN: Code duplicated, block: B:233:0x0566  */
    /* JADX WARN: Code duplicated, block: B:234:0x0568  */
    /* JADX WARN: Code duplicated, block: B:237:0x056f  */
    /* JADX WARN: Code duplicated, block: B:239:0x0576  */
    /* JADX WARN: Code duplicated, block: B:248:0x05c0 A[DONT_INVERT, LOOP:14: B:248:0x05c0->B:252:0x05ca, LOOP_START, PHI: r19
      0x05c0: PHI (r19v4 int) = (r19v3 int), (r19v5 int) binds: [B:247:0x05be, B:252:0x05ca] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:249:0x05c2  */
    /* JADX WARN: Code duplicated, block: B:252:0x05ca A[LOOP:14: B:248:0x05c0->B:252:0x05ca, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:253:0x05d0 A[EDGE_INSN: B:253:0x05d0->B:254:0x05d1 BREAK  A[LOOP:14: B:248:0x05c0->B:252:0x05ca]] */
    /* JADX WARN: Code duplicated, block: B:263:0x05e3  */
    /* JADX WARN: Code duplicated, block: B:266:0x05eb  */
    /* JADX WARN: Code duplicated, block: B:267:0x05ee  */
    /* JADX WARN: Code duplicated, block: B:272:0x0652  */
    /* JADX WARN: Code duplicated, block: B:273:0x0664  */
    /* JADX WARN: Code duplicated, block: B:300:0x0720  */
    /* JADX WARN: Code duplicated, block: B:303:0x072c  */
    /* JADX WARN: Code duplicated, block: B:313:0x0775  */
    /* JADX WARN: Code duplicated, block: B:314:0x0777  */
    /* JADX WARN: Code duplicated, block: B:318:0x078c  */
    /* JADX WARN: Code duplicated, block: B:320:0x0797  */
    /* JADX WARN: Code duplicated, block: B:323:0x07be  */
    /* JADX WARN: Code duplicated, block: B:328:0x07d6  */
    /* JADX WARN: Code duplicated, block: B:329:0x07d8  */
    /* JADX WARN: Code duplicated, block: B:331:0x07e1  */
    /* JADX WARN: Code duplicated, block: B:335:0x07f6  */
    /* JADX WARN: Code duplicated, block: B:336:0x07f8  */
    /* JADX WARN: Code duplicated, block: B:339:0x07fd  */
    /* JADX WARN: Code duplicated, block: B:340:0x0801  */
    /* JADX WARN: Code duplicated, block: B:342:0x0804  */
    /* JADX WARN: Code duplicated, block: B:343:0x0807  */
    /* JADX WARN: Code duplicated, block: B:345:0x080a  */
    /* JADX WARN: Code duplicated, block: B:346:0x080c  */
    /* JADX WARN: Code duplicated, block: B:348:0x0810  */
    /* JADX WARN: Code duplicated, block: B:349:0x0813  */
    /* JADX WARN: Code duplicated, block: B:353:0x0820  */
    /* JADX WARN: Code duplicated, block: B:355:0x082c  */
    /* JADX WARN: Code duplicated, block: B:356:0x083e  */
    /* JADX WARN: Code duplicated, block: B:359:0x0848  */
    /* JADX WARN: Code duplicated, block: B:361:0x0879  */
    /* JADX WARN: Code duplicated, block: B:380:0x042b A[EDGE_INSN: B:380:0x042b->B:190:0x042b BREAK  A[LOOP:2: B:176:0x03fc->B:189:0x0426], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:385:0x07f0 A[EDGE_INSN: B:385:0x07f0->B:333:0x07f0 BREAK  A[LOOP:7: B:316:0x0787->B:332:0x07e9], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:393:0x0880 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:396:0x0521 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:400:0x051d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:401:0x051f A[EDGE_INSN: B:401:0x051f->B:221:0x051f BREAK  A[LOOP:12: B:204:0x04e4->B:219:0x0516], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:404:0x05d0 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:405:0x05c8 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:61:0x0111 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:62:0x0113 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:66:0x011e A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:67:0x0120 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:71:0x012b  */
    /* JADX WARN: Code duplicated, block: B:74:0x0136  */
    /* JADX WARN: Code duplicated, block: B:75:0x0139  */
    /* JADX WARN: Code duplicated, block: B:78:0x014c  */
    /* JADX WARN: Code duplicated, block: B:79:0x014f  */
    /* JADX WARN: Code duplicated, block: B:7:0x0021  */
    /* JADX WARN: Code duplicated, block: B:83:0x0162  */
    /* JADX WARN: Code duplicated, block: B:86:0x019c  */
    /* JADX WARN: Code duplicated, block: B:87:0x019f  */
    /* JADX WARN: Code duplicated, block: B:90:0x01aa  */
    /* JADX WARN: Code duplicated, block: B:91:0x01ac  */
    public static List<TrackSampleTable> e(Atom.a aVar, GaplessInfoHolder gaplessInfoHolder, long j, @Nullable DrmInitData drmInitData, boolean z2, boolean z3, Function2<Track, Track> function2) throws ParserException {
        int i;
        Track track;
        a dVar;
        boolean z4;
        int iW;
        int iW2;
        int iW3;
        int i2;
        int iA;
        ArrayList arrayList;
        boolean z5;
        long[] jArrCopyOf;
        int[] iArrCopyOf;
        long[] jArrCopyOf2;
        int[] iArrCopyOf2;
        int i3;
        int i4;
        int iW4;
        long j2;
        long j3;
        long jU;
        int i5;
        int i6;
        int iW5;
        int i7;
        int i8;
        int iF;
        int iW6;
        int i9;
        int i10;
        int i11;
        boolean z6;
        int i12;
        Track track2;
        String str;
        int[] iArr;
        int i13;
        long[] jArr;
        int[] iArr2;
        long j4;
        boolean z7;
        int i14;
        int iW7;
        int i15;
        int i16;
        int iW8;
        int i17;
        long jF;
        long[] jArr2;
        int i18;
        int[] iArr3;
        long[] jArr3;
        long[] jArr4;
        boolean z8;
        int[] iArr4;
        int[] iArr5;
        long[] jArr5;
        int i19;
        boolean z9;
        int i20;
        int i21;
        long[] jArr6;
        int[] iArr6;
        boolean z10;
        boolean z11;
        long[] jArr7;
        int[] iArr7;
        int i22;
        int[] iArr8;
        long[] jArr8;
        int i23;
        int i24;
        long j5;
        TrackSampleTable trackSampleTable;
        long j6;
        int i25;
        int i26;
        int[] iArr9;
        boolean z12;
        int i27;
        long j7;
        int[] iArr10;
        boolean z13;
        TrackSampleTable trackSampleTable2;
        long[] jArr9;
        int[] iArr11;
        int iW9;
        long jU2;
        int i28;
        int iW10;
        boolean z14;
        long j8;
        int i29;
        int i30;
        int iF2;
        int[] iArr12;
        long[] jArr10;
        int[] iArr13;
        int i31;
        int i32;
        int i33;
        int i34;
        int iMax;
        int i35;
        long j9;
        ArrayList arrayList2;
        boolean z15;
        long jU3;
        int i36;
        int iF3;
        int i37;
        long j10;
        ParsableByteArray parsableByteArray;
        int i38;
        long jU4;
        long jF2;
        int iF4;
        int i39;
        int i40;
        Pair pairCreate;
        b bVarD;
        long[] jArr11;
        long[] jArr12;
        Atom.a aVarB;
        Pair pairCreate2;
        ArrayList arrayList3 = new ArrayList();
        int i41 = 0;
        while (i41 < aVar.d.size()) {
            Atom.a aVar2 = aVar.d.get(i41);
            if (aVar2.a != 1953653099) {
                arrayList2 = arrayList3;
                i2 = i41;
            } else {
                Atom.b bVarC = aVar.c(1836476516);
                Objects.requireNonNull(bVarC);
                Atom.a aVarB2 = aVar2.b(1835297121);
                Objects.requireNonNull(aVarB2);
                Atom.b bVarC2 = aVarB2.c(1751411826);
                Objects.requireNonNull(bVarC2);
                ParsableByteArray parsableByteArray2 = bVarC2.f1210b;
                parsableByteArray2.E(16);
                int iF5 = parsableByteArray2.f();
                if (iF5 == 1936684398) {
                    i = 1;
                } else if (iF5 == 1986618469) {
                    i = 2;
                } else if (iF5 == 1952807028 || iF5 == 1935832172 || iF5 == 1937072756 || iF5 == 1668047728) {
                    i = 3;
                } else {
                    i = iF5 == 1835365473 ? 5 : -1;
                }
                if (i == -1) {
                    track = null;
                } else {
                    Atom.b bVarC3 = aVar2.c(1953196132);
                    Objects.requireNonNull(bVarC3);
                    ParsableByteArray parsableByteArray3 = bVarC3.f1210b;
                    parsableByteArray3.E(8);
                    int iF6 = (parsableByteArray3.f() >> 24) & 255;
                    parsableByteArray3.F(iF6 != 0 ? 16 : 8);
                    int iF7 = parsableByteArray3.f();
                    parsableByteArray3.F(4);
                    int i42 = parsableByteArray3.f984b;
                    int i43 = iF6 == 0 ? 4 : 8;
                    int i44 = 0;
                    while (true) {
                        if (i44 >= i43) {
                            z15 = true;
                            break;
                        }
                        if (parsableByteArray3.a[i42 + i44] != -1) {
                            z15 = false;
                            break;
                        }
                        i44++;
                    }
                    if (z15) {
                        parsableByteArray3.F(i43);
                    } else {
                        jU3 = iF6 == 0 ? parsableByteArray3.u() : parsableByteArray3.x();
                        if (jU3 != 0) {
                            i36 = 16;
                        }
                        parsableByteArray3.F(i36);
                        iF3 = parsableByteArray3.f();
                        int iF8 = parsableByteArray3.f();
                        parsableByteArray3.F(4);
                        int iF9 = parsableByteArray3.f();
                        int iF10 = parsableByteArray3.f();
                        if (iF3 != 0 && iF8 == 65536 && iF9 == -65536 && iF10 == 0) {
                            i37 = 90;
                        } else if (iF3 != 0 && iF8 == -65536 && iF9 == 65536 && iF10 == 0) {
                            i37 = 270;
                        } else if (iF3 != -65536 && iF8 == 0 && iF9 == 0 && iF10 == -65536) {
                            i37 = 180;
                        } else {
                            i37 = 0;
                        }
                        if (j == -9223372036854775807L) {
                            j10 = jU3;
                        } else {
                            j10 = j;
                        }
                        parsableByteArray = bVarC.f1210b;
                        parsableByteArray.E(8);
                        if (((parsableByteArray.f() >> 24) & 255) == 0) {
                            i38 = 8;
                        } else {
                            i38 = 16;
                        }
                        parsableByteArray.F(i38);
                        jU4 = parsableByteArray.u();
                        jF2 = j10 != -9223372036854775807L ? Util2.F(j10, 1000000L, jU4) : -9223372036854775807L;
                        Atom.a aVarB3 = aVarB2.b(1835626086);
                        Objects.requireNonNull(aVarB3);
                        Atom.a aVarB4 = aVarB3.b(1937007212);
                        Objects.requireNonNull(aVarB4);
                        Atom.b bVarC4 = aVarB2.c(1835296868);
                        Objects.requireNonNull(bVarC4);
                        ParsableByteArray parsableByteArray4 = bVarC4.f1210b;
                        parsableByteArray4.E(8);
                        iF4 = (parsableByteArray4.f() >> 24) & 255;
                        if (iF4 == 0) {
                            i39 = 8;
                        } else {
                            i39 = 16;
                        }
                        parsableByteArray4.F(i39);
                        long jU5 = parsableByteArray4.u();
                        if (iF4 == 0) {
                            i40 = 4;
                        } else {
                            i40 = 8;
                        }
                        parsableByteArray4.F(i40);
                        int iY = parsableByteArray4.y();
                        StringBuilder sb = new StringBuilder(3);
                        sb.append((char) (((iY >> 10) & 31) + 96));
                        sb.append((char) (((iY >> 5) & 31) + 96));
                        sb.append((char) ((iY & 31) + 96));
                        pairCreate = Pair.create(Long.valueOf(jU5), sb.toString());
                        Atom.b bVarC5 = aVarB4.c(1937011556);
                        Objects.requireNonNull(bVarC5);
                        bVarD = d(bVarC5.f1210b, iF7, i37, (String) pairCreate.second, drmInitData, z3);
                        if (!z2 || (aVarB = aVar2.b(1701082227)) == null) {
                            jArr11 = null;
                            jArr12 = null;
                        } else {
                            Atom.b bVarC6 = aVarB.c(1701606260);
                            if (bVarC6 == null) {
                                pairCreate2 = null;
                            } else {
                                ParsableByteArray parsableByteArray5 = bVarC6.f1210b;
                                parsableByteArray5.E(8);
                                int iF11 = (parsableByteArray5.f() >> 24) & 255;
                                int iW11 = parsableByteArray5.w();
                                long[] jArr13 = new long[iW11];
                                long[] jArr14 = new long[iW11];
                                int i45 = 0;
                                while (i45 < iW11) {
                                    jArr13[i45] = iF11 == 1 ? parsableByteArray5.x() : parsableByteArray5.u();
                                    jArr14[i45] = iF11 == 1 ? parsableByteArray5.m() : parsableByteArray5.f();
                                    if (parsableByteArray5.p() != 1) {
                                        throw new IllegalArgumentException("Unsupported media rate.");
                                    }
                                    parsableByteArray5.F(2);
                                    i45++;
                                    iF11 = iF11;
                                    iW11 = iW11;
                                }
                                pairCreate2 = Pair.create(jArr13, jArr14);
                            }
                            if (pairCreate2 != null) {
                                long[] jArr15 = (long[]) pairCreate2.first;
                                jArr12 = (long[]) pairCreate2.second;
                                jArr11 = jArr15;
                            } else {
                                jArr11 = null;
                                jArr12 = null;
                            }
                        }
                        if (bVarD.f1211b == null) {
                            track = null;
                        } else {
                            track = new Track(iF7, i, ((Long) pairCreate.first).longValue(), jU4, jF2, bVarD.f1211b, bVarD.d, bVarD.a, bVarD.c, jArr11, jArr12);
                        }
                    }
                    i36 = 16;
                    jU3 = -9223372036854775807L;
                    parsableByteArray3.F(i36);
                    iF3 = parsableByteArray3.f();
                    int iF12 = parsableByteArray3.f();
                    parsableByteArray3.F(4);
                    int iF13 = parsableByteArray3.f();
                    int iF14 = parsableByteArray3.f();
                    if (iF3 != 0) {
                        if (iF3 != 0) {
                            if (iF3 != -65536) {
                                i37 = 0;
                            } else {
                                i37 = 0;
                            }
                        } else if (iF3 != -65536) {
                            i37 = 0;
                        } else {
                            i37 = 0;
                        }
                    } else if (iF3 != 0) {
                        if (iF3 != -65536) {
                            i37 = 0;
                        } else {
                            i37 = 0;
                        }
                    } else if (iF3 != -65536) {
                        i37 = 0;
                    } else {
                        i37 = 0;
                    }
                    if (j == -9223372036854775807L) {
                        j10 = jU3;
                    } else {
                        j10 = j;
                    }
                    parsableByteArray = bVarC.f1210b;
                    parsableByteArray.E(8);
                    if (((parsableByteArray.f() >> 24) & 255) == 0) {
                        i38 = 8;
                    } else {
                        i38 = 16;
                    }
                    parsableByteArray.F(i38);
                    jU4 = parsableByteArray.u();
                    jF2 = j10 != -9223372036854775807L ? Util2.F(j10, 1000000L, jU4) : -9223372036854775807L;
                    Atom.a aVarB5 = aVarB2.b(1835626086);
                    Objects.requireNonNull(aVarB5);
                    Atom.a aVarB6 = aVarB5.b(1937007212);
                    Objects.requireNonNull(aVarB6);
                    Atom.b bVarC7 = aVarB2.c(1835296868);
                    Objects.requireNonNull(bVarC7);
                    ParsableByteArray parsableByteArray6 = bVarC7.f1210b;
                    parsableByteArray6.E(8);
                    iF4 = (parsableByteArray6.f() >> 24) & 255;
                    if (iF4 == 0) {
                        i39 = 8;
                    } else {
                        i39 = 16;
                    }
                    parsableByteArray6.F(i39);
                    long jU6 = parsableByteArray6.u();
                    if (iF4 == 0) {
                        i40 = 4;
                    } else {
                        i40 = 8;
                    }
                    parsableByteArray6.F(i40);
                    int iY2 = parsableByteArray6.y();
                    StringBuilder sb2 = new StringBuilder(3);
                    sb2.append((char) (((iY2 >> 10) & 31) + 96));
                    sb2.append((char) (((iY2 >> 5) & 31) + 96));
                    sb2.append((char) ((iY2 & 31) + 96));
                    pairCreate = Pair.create(Long.valueOf(jU6), sb2.toString());
                    Atom.b bVarC8 = aVarB6.c(1937011556);
                    Objects.requireNonNull(bVarC8);
                    bVarD = d(bVarC8.f1210b, iF7, i37, (String) pairCreate.second, drmInitData, z3);
                    if (z2) {
                        jArr11 = null;
                        jArr12 = null;
                    } else {
                        jArr11 = null;
                        jArr12 = null;
                    }
                    if (bVarD.f1211b == null) {
                        track = null;
                    } else {
                        track = new Track(iF7, i, ((Long) pairCreate.first).longValue(), jU4, jF2, bVarD.f1211b, bVarD.d, bVarD.a, bVarD.c, jArr11, jArr12);
                    }
                }
                Track trackApply = function2.apply(track);
                if (trackApply == null) {
                    arrayList2 = arrayList3;
                    i2 = i41;
                } else {
                    Atom.a aVarB7 = aVar2.b(1835297121);
                    Objects.requireNonNull(aVarB7);
                    Atom.a aVarB8 = aVarB7.b(1835626086);
                    Objects.requireNonNull(aVarB8);
                    Atom.a aVarB9 = aVarB8.b(1937007212);
                    Objects.requireNonNull(aVarB9);
                    Atom.b bVarC9 = aVarB9.c(1937011578);
                    if (bVarC9 != null) {
                        dVar = new c(bVarC9, trackApply.f);
                    } else {
                        Atom.b bVarC10 = aVarB9.c(1937013298);
                        if (bVarC10 == null) {
                            throw ParserException.a("Track has no sample table size information", null);
                        }
                        dVar = new d(bVarC10);
                    }
                    int iB = dVar.b();
                    if (iB == 0) {
                        trackSampleTable = new TrackSampleTable(trackApply, new long[0], new int[0], 0, new long[0], new int[0], 0L);
                        arrayList = arrayList3;
                        i2 = i41;
                    } else {
                        Atom.b bVarC11 = aVarB9.c(1937007471);
                        if (bVarC11 == null) {
                            bVarC11 = aVarB9.c(1668232756);
                            Objects.requireNonNull(bVarC11);
                            z4 = true;
                        } else {
                            z4 = false;
                        }
                        ParsableByteArray parsableByteArray7 = bVarC11.f1210b;
                        Atom.b bVarC12 = aVarB9.c(1937011555);
                        Objects.requireNonNull(bVarC12);
                        ParsableByteArray parsableByteArray8 = bVarC12.f1210b;
                        Atom.b bVarC13 = aVarB9.c(1937011827);
                        Objects.requireNonNull(bVarC13);
                        ParsableByteArray parsableByteArray9 = bVarC13.f1210b;
                        Atom.b bVarC14 = aVarB9.c(1937011571);
                        ParsableByteArray parsableByteArray10 = bVarC14 != null ? bVarC14.f1210b : null;
                        Atom.b bVarC15 = aVarB9.c(1668576371);
                        ParsableByteArray parsableByteArray11 = bVarC15 != null ? bVarC15.f1210b : null;
                        parsableByteArray7.E(12);
                        int iW12 = parsableByteArray7.w();
                        parsableByteArray8.E(12);
                        int iW13 = parsableByteArray8.w();
                        AnimatableValueParser.q(parsableByteArray8.f() == 1, "first_chunk must be 1");
                        parsableByteArray9.E(12);
                        int iW14 = parsableByteArray9.w() - 1;
                        int iW15 = parsableByteArray9.w();
                        int i46 = iW13;
                        int iW16 = parsableByteArray9.w();
                        if (parsableByteArray11 != null) {
                            parsableByteArray11.E(12);
                            iW = parsableByteArray11.w();
                        } else {
                            iW = 0;
                        }
                        if (parsableByteArray10 != null) {
                            parsableByteArray10.E(12);
                            iW2 = parsableByteArray10.w();
                            if (iW2 > 0) {
                                iW3 = parsableByteArray10.w() - 1;
                            } else {
                                parsableByteArray10 = null;
                            }
                            i2 = i41;
                            iA = dVar.a();
                            arrayList = arrayList3;
                            String str2 = trackApply.f.w;
                            if (iA == -1 && (("audio/raw".equals(str2) || "audio/g711-mlaw".equals(str2) || "audio/g711-alaw".equals(str2)) && iW14 == 0 && iW == 0 && iW2 == 0)) {
                                z5 = true;
                            } else {
                                z5 = false;
                            }
                            if (z5) {
                                jArr9 = new long[iW12];
                                iArr11 = new int[iW12];
                                iW9 = 0;
                                jU2 = 0;
                                i28 = -1;
                                iW10 = 0;
                                while (true) {
                                    i28++;
                                    if (i28 == iW12) {
                                        z14 = false;
                                    } else {
                                        if (z4) {
                                            jU2 = parsableByteArray7.x();
                                        } else {
                                            jU2 = parsableByteArray7.u();
                                        }
                                        if (i28 == iW9) {
                                            iW10 = parsableByteArray8.w();
                                            parsableByteArray8.F(4);
                                            i46--;
                                            if (i46 > 0) {
                                                iW9 = parsableByteArray8.w() - 1;
                                            } else {
                                                iW9 = -1;
                                            }
                                        }
                                        z14 = true;
                                    }
                                    if (z14) {
                                        break;
                                    }
                                    jArr9[i28] = jU2;
                                    iArr11[i28] = iW10;
                                }
                                j8 = iW16;
                                i29 = 8192 / iA;
                                iF2 = 0;
                                for (i30 = 0; i30 < iW12; i30++) {
                                    iF2 += Util2.f(iArr11[i30], i29);
                                }
                                jArr = new long[iF2];
                                iArr12 = new int[iF2];
                                jArr10 = new long[iF2];
                                iArr13 = new int[iF2];
                                i31 = 0;
                                i32 = 0;
                                i33 = 0;
                                i34 = 0;
                                while (i31 < iW12) {
                                    int i47 = iArr11[i31];
                                    long j11 = jArr9[i31];
                                    long[] jArr16 = jArr9;
                                    int[] iArr14 = iArr11;
                                    iMax = i34;
                                    i35 = i47;
                                    j9 = j11;
                                    while (i35 > 0) {
                                        int iMin = Math.min(i29, i35);
                                        jArr[i33] = j9;
                                        iArr12[i33] = iA * iMin;
                                        iMax = Math.max(iMax, iArr12[i33]);
                                        jArr10[i33] = ((long) i32) * j8;
                                        iArr13[i33] = 1;
                                        j9 += (long) iArr12[i33];
                                        i32 += iMin;
                                        i35 -= iMin;
                                        i33++;
                                        i29 = i29;
                                        iA = iA;
                                    }
                                    i31++;
                                    i34 = iMax;
                                    jArr9 = jArr16;
                                    iArr11 = iArr14;
                                }
                                j4 = j8 * ((long) i32);
                                iArr2 = iArr13;
                                iArr = iArr12;
                                jArrCopyOf2 = jArr10;
                                i13 = i34;
                                track2 = trackApply;
                            } else {
                                jArrCopyOf = new long[iB];
                                iArrCopyOf = new int[iB];
                                jArrCopyOf2 = new long[iB];
                                int i48 = iW2;
                                iArrCopyOf2 = new int[iB];
                                i3 = 0;
                                i4 = 0;
                                iW4 = 0;
                                j2 = 0;
                                j3 = 0;
                                jU = 0;
                                i5 = -1;
                                i6 = iW16;
                                iW5 = iW15;
                                i7 = iW3;
                                i8 = i48;
                                iF = 0;
                                iW6 = 0;
                                int i49 = iW14;
                                i9 = iW;
                                i10 = 0;
                                i11 = 0;
                                while (i10 < iB) {
                                    z7 = true;
                                    int i50 = i3;
                                    i14 = iB;
                                    iW7 = i50;
                                    while (true) {
                                        if (i4 == 0) {
                                            i15 = i7;
                                            break;
                                        }
                                        i15 = i7;
                                        i17 = i5 + 1;
                                        if (i17 == iW12) {
                                            z7 = false;
                                        } else {
                                            if (z4) {
                                                jU = parsableByteArray7.x();
                                            } else {
                                                jU = parsableByteArray7.u();
                                            }
                                            if (i17 == iW7) {
                                                iW4 = parsableByteArray8.w();
                                                parsableByteArray8.F(4);
                                                i46--;
                                                if (i46 > 0) {
                                                    iW7 = parsableByteArray8.w() - 1;
                                                } else {
                                                    iW7 = -1;
                                                }
                                            }
                                            z7 = true;
                                        }
                                        i5 = i17;
                                        if (z7) {
                                            break;
                                        }
                                        i4 = iW4;
                                        j3 = jU;
                                        i7 = i15;
                                    }
                                    if (!z7) {
                                        Log.w("AtomParsers", "Unexpected end of chunk data");
                                        jArrCopyOf = Arrays.copyOf(jArrCopyOf, i10);
                                        iArrCopyOf = Arrays.copyOf(iArrCopyOf, i10);
                                        jArrCopyOf2 = Arrays.copyOf(jArrCopyOf2, i10);
                                        iArrCopyOf2 = Arrays.copyOf(iArrCopyOf2, i10);
                                        iB = i10;
                                        break;
                                    }
                                    if (parsableByteArray11 != null) {
                                        while (iW6 == 0 && i9 > 0) {
                                            iW6 = parsableByteArray11.w();
                                            iF = parsableByteArray11.f();
                                            i9--;
                                        }
                                        iW6--;
                                    }
                                    int i51 = iF;
                                    jArrCopyOf[i10] = j3;
                                    iArrCopyOf[i10] = dVar.c();
                                    if (iArrCopyOf[i10] > i11) {
                                        i11 = iArrCopyOf[i10];
                                    }
                                    ParsableByteArray parsableByteArray12 = parsableByteArray7;
                                    boolean z16 = z4;
                                    jArrCopyOf2[i10] = j2 + ((long) i51);
                                    if (parsableByteArray10 == null) {
                                        i16 = 1;
                                    } else {
                                        i16 = 0;
                                    }
                                    iArrCopyOf2[i10] = i16;
                                    iW8 = i15;
                                    if (i10 == iW8) {
                                        iArrCopyOf2[i10] = 1;
                                        i8--;
                                        if (i8 > 0) {
                                            Objects.requireNonNull(parsableByteArray10);
                                            iW8 = parsableByteArray10.w() - 1;
                                        }
                                    }
                                    long[] jArr17 = jArrCopyOf2;
                                    int iF15 = i6;
                                    int i52 = iW7;
                                    j2 += (long) iF15;
                                    iW5--;
                                    if (iW5 != 0 && i49 > 0) {
                                        i49--;
                                        iW5 = parsableByteArray9.w();
                                        iF15 = parsableByteArray9.f();
                                    }
                                    j3 += (long) iArrCopyOf[i10];
                                    i4--;
                                    i10++;
                                    iF = i51;
                                    iB = i14;
                                    i3 = i52;
                                    jArrCopyOf2 = jArr17;
                                    i6 = iF15;
                                    z4 = z16;
                                    i7 = iW8;
                                    parsableByteArray7 = parsableByteArray12;
                                }
                                int i53 = i4;
                                long j12 = j2 + ((long) iF);
                                if (parsableByteArray11 != null) {
                                    z6 = true;
                                    break;
                                }
                                while (true) {
                                    if (i9 > 0) {
                                        z6 = true;
                                        break;
                                    }
                                    if (parsableByteArray11.w() != 0) {
                                        z6 = false;
                                        break;
                                    }
                                    parsableByteArray11.f();
                                    i9--;
                                }
                                if (i8 != 0 && iW5 == 0 && i53 == 0 && i49 == 0) {
                                    i12 = iW6;
                                    if (i12 == 0 && z6) {
                                        track2 = trackApply;
                                    }
                                    iArr = iArrCopyOf;
                                    i13 = i11;
                                    jArr = jArrCopyOf;
                                    iArr2 = iArrCopyOf2;
                                    j4 = j12;
                                } else {
                                    i12 = iW6;
                                }
                                track2 = trackApply;
                                int i54 = track2.a;
                                if (z6) {
                                    str = "";
                                } else {
                                    str = ", ctts invalid";
                                }
                                StringBuilder sb3 = new StringBuilder(str.length() + 262);
                                sb3.append("Inconsistent stbl box for track ");
                                sb3.append(i54);
                                sb3.append(": remainingSynchronizationSamples ");
                                sb3.append(i8);
                                sb3.append(", remainingSamplesAtTimestampDelta ");
                                sb3.append(iW5);
                                sb3.append(", remainingSamplesInChunk ");
                                sb3.append(i53);
                                sb3.append(", remainingTimestampDeltaChanges ");
                                sb3.append(i49);
                                sb3.append(", remainingSamplesAtTimestampOffset ");
                                sb3.append(i12);
                                outline.r0(sb3, str, "AtomParsers");
                                iArr = iArrCopyOf;
                                i13 = i11;
                                jArr = jArrCopyOf;
                                iArr2 = iArrCopyOf2;
                                j4 = j12;
                            }
                            jF = Util2.F(j4, 1000000L, track2.c);
                            jArr2 = track2.h;
                            if (jArr2 == null) {
                                Util2.G(jArrCopyOf2, 1000000L, track2.c);
                                trackSampleTable = new TrackSampleTable(track2, jArr, iArr, i13, jArrCopyOf2, iArr2, jF);
                            } else {
                                if (jArr2.length == 1 || track2.f1230b != 1 || jArrCopyOf2.length < 2) {
                                    i18 = i13;
                                    iArr3 = iArr2;
                                    jArr3 = jArr;
                                } else {
                                    long[] jArr18 = track2.i;
                                    Objects.requireNonNull(jArr18);
                                    long j13 = jArr18[0];
                                    jArr3 = jArr;
                                    i18 = i13;
                                    iArr3 = iArr2;
                                    long jF3 = Util2.F(track2.h[0], track2.c, track2.d) + j13;
                                    int length = jArrCopyOf2.length - 1;
                                    if (jArrCopyOf2[0] <= j13 && j13 < jArrCopyOf2[Util2.h(4, 0, length)] && jArrCopyOf2[Util2.h(jArrCopyOf2.length - 4, 0, length)] < jF3 && jF3 <= j4) {
                                        long j14 = j4 - jF3;
                                        long jF4 = Util2.F(j13 - jArrCopyOf2[0], track2.f.K, track2.c);
                                        long jF5 = Util2.F(j14, track2.f.K, track2.c);
                                        if ((jF4 != 0 || jF5 != 0) && jF4 <= 2147483647L && jF5 <= 2147483647L) {
                                            gaplessInfoHolder.f1294b = (int) jF4;
                                            gaplessInfoHolder.c = (int) jF5;
                                            Util2.G(jArrCopyOf2, 1000000L, track2.c);
                                            trackSampleTable2 = new TrackSampleTable(track2, jArr3, iArr, i18, jArrCopyOf2, iArr3, Util2.F(track2.h[0], 1000000L, track2.d));
                                        }
                                        trackSampleTable = trackSampleTable2;
                                    }
                                }
                                jArr4 = track2.h;
                                if (jArr4.length == 1 || jArr4[0] != 0) {
                                    if (track2.f1230b == 1) {
                                        z8 = true;
                                    } else {
                                        z8 = false;
                                    }
                                    iArr4 = new int[jArr4.length];
                                    iArr5 = new int[jArr4.length];
                                    jArr5 = track2.i;
                                    Objects.requireNonNull(jArr5);
                                    i19 = 0;
                                    z9 = false;
                                    i20 = 0;
                                    i21 = 0;
                                    while (true) {
                                        jArr6 = track2.h;
                                        if (i19 >= jArr6.length) {
                                            break;
                                        }
                                        z12 = z9;
                                        i27 = i20;
                                        j7 = jArr5[i19];
                                        if (j7 != -1) {
                                            iArr10 = iArr5;
                                            long jF6 = Util2.F(jArr6[i19], track2.c, track2.d);
                                            iArr4[i19] = Util2.e(jArrCopyOf2, j7, true, true);
                                            iArr10[i19] = Util2.b(jArrCopyOf2, j7 + jF6, z8, false);
                                            while (iArr4[i19] < iArr10[i19] && (iArr3[iArr4[i19]] & 1) == 0) {
                                                iArr4[i19] = iArr4[i19] + 1;
                                            }
                                            int i55 = (iArr10[i19] - iArr4[i19]) + i27;
                                            if (i21 != iArr4[i19]) {
                                                z13 = true;
                                            } else {
                                                z13 = false;
                                            }
                                            i20 = i55;
                                            i21 = iArr10[i19];
                                            z9 = z12 | z13;
                                        } else {
                                            iArr10 = iArr5;
                                            i20 = i27;
                                            z9 = z12;
                                        }
                                        i19++;
                                        iArr5 = iArr10;
                                    }
                                    iArr6 = iArr5;
                                    boolean z17 = z9;
                                    if (i20 != iB) {
                                        z10 = true;
                                    } else {
                                        z10 = false;
                                    }
                                    z11 = z17 | z10;
                                    if (z11) {
                                        jArr7 = new long[i20];
                                    } else {
                                        jArr7 = jArr3;
                                    }
                                    if (z11) {
                                        iArr7 = new int[i20];
                                    } else {
                                        iArr7 = iArr;
                                    }
                                    if (z11) {
                                        i22 = 0;
                                    } else {
                                        i22 = i18;
                                    }
                                    if (z11) {
                                        iArr8 = new int[i20];
                                    } else {
                                        iArr8 = iArr3;
                                    }
                                    jArr8 = new long[i20];
                                    i23 = 0;
                                    i24 = 0;
                                    j5 = 0;
                                    while (i23 < track2.h.length) {
                                        j6 = track2.i[i23];
                                        i25 = iArr4[i23];
                                        int[] iArr15 = iArr4;
                                        i26 = iArr6[i23];
                                        if (z11) {
                                            int i56 = i26 - i25;
                                            System.arraycopy(jArr3, i25, jArr7, i24, i56);
                                            System.arraycopy(iArr, i25, iArr7, i24, i56);
                                            iArr9 = iArr3;
                                            System.arraycopy(iArr9, i25, iArr8, i24, i56);
                                        } else {
                                            iArr9 = iArr3;
                                        }
                                        i22 = i22;
                                        while (i25 < i26) {
                                            int[] iArr16 = iArr8;
                                            int i57 = i26;
                                            int[] iArr17 = iArr9;
                                            long[] jArr19 = jArrCopyOf2;
                                            long j15 = j5;
                                            jArr8[i24] = Util2.F(j5, 1000000L, track2.d) + Util2.F(Math.max(0L, jArrCopyOf2[i25] - j6), 1000000L, track2.c);
                                            if (!z11 && iArr7[i24] > i22) {
                                                i22 = iArr[i25];
                                            }
                                            i24++;
                                            i25++;
                                            iArr8 = iArr16;
                                            j5 = j15;
                                            jArrCopyOf2 = jArr19;
                                            iArr9 = iArr17;
                                            i26 = i57;
                                        }
                                        j5 += track2.h[i23];
                                        i23++;
                                        iArr4 = iArr15;
                                        iArr8 = iArr8;
                                        iArr3 = iArr9;
                                        jArr3 = jArr3;
                                    }
                                    trackSampleTable = new TrackSampleTable(track2, jArr7, iArr7, i22, jArr8, iArr8, Util2.F(j5, 1000000L, track2.d));
                                } else {
                                    long[] jArr20 = track2.i;
                                    Objects.requireNonNull(jArr20);
                                    long j16 = jArr20[0];
                                    for (int i58 = 0; i58 < jArrCopyOf2.length; i58++) {
                                        jArrCopyOf2[i58] = Util2.F(jArrCopyOf2[i58] - j16, 1000000L, track2.c);
                                    }
                                    trackSampleTable2 = new TrackSampleTable(track2, jArr3, iArr, i18, jArrCopyOf2, iArr3, Util2.F(j4 - j16, 1000000L, track2.c));
                                    trackSampleTable = trackSampleTable2;
                                }
                            }
                        } else {
                            iW2 = 0;
                        }
                        iW3 = -1;
                        i2 = i41;
                        iA = dVar.a();
                        arrayList = arrayList3;
                        String str3 = trackApply.f.w;
                        if (iA == -1) {
                            z5 = false;
                        } else {
                            z5 = false;
                        }
                        if (z5) {
                            jArr9 = new long[iW12];
                            iArr11 = new int[iW12];
                            iW9 = 0;
                            jU2 = 0;
                            i28 = -1;
                            iW10 = 0;
                            while (true) {
                                i28++;
                                if (i28 == iW12) {
                                    z14 = false;
                                } else {
                                    if (z4) {
                                        jU2 = parsableByteArray7.x();
                                    } else {
                                        jU2 = parsableByteArray7.u();
                                    }
                                    if (i28 == iW9) {
                                        iW10 = parsableByteArray8.w();
                                        parsableByteArray8.F(4);
                                        i46--;
                                        if (i46 > 0) {
                                            iW9 = parsableByteArray8.w() - 1;
                                        } else {
                                            iW9 = -1;
                                        }
                                    }
                                    z14 = true;
                                }
                                if (z14) {
                                    break;
                                    break;
                                }
                                jArr9[i28] = jU2;
                                iArr11[i28] = iW10;
                            }
                            j8 = iW16;
                            i29 = 8192 / iA;
                            iF2 = 0;
                            while (i30 < iW12) {
                                iF2 += Util2.f(iArr11[i30], i29);
                            }
                            jArr = new long[iF2];
                            iArr12 = new int[iF2];
                            jArr10 = new long[iF2];
                            iArr13 = new int[iF2];
                            i31 = 0;
                            i32 = 0;
                            i33 = 0;
                            i34 = 0;
                            while (i31 < iW12) {
                                int i410 = iArr11[i31];
                                long j17 = jArr9[i31];
                                long[] jArr110 = jArr9;
                                int[] iArr18 = iArr11;
                                iMax = i34;
                                i35 = i410;
                                j9 = j17;
                                while (i35 > 0) {
                                    int iMin2 = Math.min(i29, i35);
                                    jArr[i33] = j9;
                                    iArr12[i33] = iA * iMin2;
                                    iMax = Math.max(iMax, iArr12[i33]);
                                    jArr10[i33] = ((long) i32) * j8;
                                    iArr13[i33] = 1;
                                    j9 += (long) iArr12[i33];
                                    i32 += iMin2;
                                    i35 -= iMin2;
                                    i33++;
                                    i29 = i29;
                                    iA = iA;
                                }
                                i31++;
                                i34 = iMax;
                                jArr9 = jArr110;
                                iArr11 = iArr18;
                            }
                            j4 = j8 * ((long) i32);
                            iArr2 = iArr13;
                            iArr = iArr12;
                            jArrCopyOf2 = jArr10;
                            i13 = i34;
                            track2 = trackApply;
                        } else {
                            jArrCopyOf = new long[iB];
                            iArrCopyOf = new int[iB];
                            jArrCopyOf2 = new long[iB];
                            int i411 = iW2;
                            iArrCopyOf2 = new int[iB];
                            i3 = 0;
                            i4 = 0;
                            iW4 = 0;
                            j2 = 0;
                            j3 = 0;
                            jU = 0;
                            i5 = -1;
                            i6 = iW16;
                            iW5 = iW15;
                            i7 = iW3;
                            i8 = i411;
                            iF = 0;
                            iW6 = 0;
                            int i412 = iW14;
                            i9 = iW;
                            i10 = 0;
                            i11 = 0;
                            while (i10 < iB) {
                                z7 = true;
                                int i59 = i3;
                                i14 = iB;
                                iW7 = i59;
                                while (true) {
                                    if (i4 == 0) {
                                        i15 = i7;
                                        break;
                                    }
                                    i15 = i7;
                                    i17 = i5 + 1;
                                    if (i17 == iW12) {
                                        z7 = false;
                                    } else {
                                        if (z4) {
                                            jU = parsableByteArray7.x();
                                        } else {
                                            jU = parsableByteArray7.u();
                                        }
                                        if (i17 == iW7) {
                                            iW4 = parsableByteArray8.w();
                                            parsableByteArray8.F(4);
                                            i46--;
                                            if (i46 > 0) {
                                                iW7 = parsableByteArray8.w() - 1;
                                            } else {
                                                iW7 = -1;
                                            }
                                        }
                                        z7 = true;
                                    }
                                    i5 = i17;
                                    if (z7) {
                                        break;
                                        break;
                                    }
                                    i4 = iW4;
                                    j3 = jU;
                                    i7 = i15;
                                }
                                if (!z7) {
                                    Log.w("AtomParsers", "Unexpected end of chunk data");
                                    jArrCopyOf = Arrays.copyOf(jArrCopyOf, i10);
                                    iArrCopyOf = Arrays.copyOf(iArrCopyOf, i10);
                                    jArrCopyOf2 = Arrays.copyOf(jArrCopyOf2, i10);
                                    iArrCopyOf2 = Arrays.copyOf(iArrCopyOf2, i10);
                                    iB = i10;
                                    break;
                                }
                                if (parsableByteArray11 != null) {
                                    while (iW6 == 0) {
                                        iW6 = parsableByteArray11.w();
                                        iF = parsableByteArray11.f();
                                        i9--;
                                    }
                                    iW6--;
                                }
                                int i510 = iF;
                                jArrCopyOf[i10] = j3;
                                iArrCopyOf[i10] = dVar.c();
                                if (iArrCopyOf[i10] > i11) {
                                    i11 = iArrCopyOf[i10];
                                }
                                ParsableByteArray parsableByteArray13 = parsableByteArray7;
                                boolean z18 = z4;
                                jArrCopyOf2[i10] = j2 + ((long) i510);
                                if (parsableByteArray10 == null) {
                                    i16 = 1;
                                } else {
                                    i16 = 0;
                                }
                                iArrCopyOf2[i10] = i16;
                                iW8 = i15;
                                if (i10 == iW8) {
                                    iArrCopyOf2[i10] = 1;
                                    i8--;
                                    if (i8 > 0) {
                                        Objects.requireNonNull(parsableByteArray10);
                                        iW8 = parsableByteArray10.w() - 1;
                                    }
                                }
                                long[] jArr111 = jArrCopyOf2;
                                int iF16 = i6;
                                int i511 = iW7;
                                j2 += (long) iF16;
                                iW5--;
                                if (iW5 != 0) {
                                }
                                j3 += (long) iArrCopyOf[i10];
                                i4--;
                                i10++;
                                iF = i510;
                                iB = i14;
                                i3 = i511;
                                jArrCopyOf2 = jArr111;
                                i6 = iF16;
                                z4 = z18;
                                i7 = iW8;
                                parsableByteArray7 = parsableByteArray13;
                            }
                            int i512 = i4;
                            long j18 = j2 + ((long) iF);
                            if (parsableByteArray11 != null) {
                                z6 = true;
                                break;
                            }
                            while (true) {
                                if (i9 > 0) {
                                    z6 = true;
                                    break;
                                }
                                if (parsableByteArray11.w() != 0) {
                                    z6 = false;
                                    break;
                                }
                                parsableByteArray11.f();
                                i9--;
                            }
                            if (i8 != 0) {
                                i12 = iW6;
                                track2 = trackApply;
                                int i513 = track2.a;
                                if (z6) {
                                    str = ", ctts invalid";
                                } else {
                                    str = "";
                                }
                                StringBuilder sb4 = new StringBuilder(str.length() + 262);
                                sb4.append("Inconsistent stbl box for track ");
                                sb4.append(i513);
                                sb4.append(": remainingSynchronizationSamples ");
                                sb4.append(i8);
                                sb4.append(", remainingSamplesAtTimestampDelta ");
                                sb4.append(iW5);
                                sb4.append(", remainingSamplesInChunk ");
                                sb4.append(i512);
                                sb4.append(", remainingTimestampDeltaChanges ");
                                sb4.append(i412);
                                sb4.append(", remainingSamplesAtTimestampOffset ");
                                sb4.append(i12);
                                outline.r0(sb4, str, "AtomParsers");
                            } else {
                                i12 = iW6;
                                track2 = trackApply;
                                int i514 = track2.a;
                                if (z6) {
                                    str = ", ctts invalid";
                                } else {
                                    str = "";
                                }
                                StringBuilder sb5 = new StringBuilder(str.length() + 262);
                                sb5.append("Inconsistent stbl box for track ");
                                sb5.append(i514);
                                sb5.append(": remainingSynchronizationSamples ");
                                sb5.append(i8);
                                sb5.append(", remainingSamplesAtTimestampDelta ");
                                sb5.append(iW5);
                                sb5.append(", remainingSamplesInChunk ");
                                sb5.append(i512);
                                sb5.append(", remainingTimestampDeltaChanges ");
                                sb5.append(i412);
                                sb5.append(", remainingSamplesAtTimestampOffset ");
                                sb5.append(i12);
                                outline.r0(sb5, str, "AtomParsers");
                            }
                            iArr = iArrCopyOf;
                            i13 = i11;
                            jArr = jArrCopyOf;
                            iArr2 = iArrCopyOf2;
                            j4 = j18;
                        }
                        jF = Util2.F(j4, 1000000L, track2.c);
                        jArr2 = track2.h;
                        if (jArr2 == null) {
                            Util2.G(jArrCopyOf2, 1000000L, track2.c);
                            trackSampleTable = new TrackSampleTable(track2, jArr, iArr, i13, jArrCopyOf2, iArr2, jF);
                        } else {
                            if (jArr2.length == 1) {
                                i18 = i13;
                                iArr3 = iArr2;
                                jArr3 = jArr;
                                jArr4 = track2.h;
                                if (jArr4.length == 1) {
                                }
                                if (track2.f1230b == 1) {
                                    z8 = true;
                                } else {
                                    z8 = false;
                                }
                                iArr4 = new int[jArr4.length];
                                iArr5 = new int[jArr4.length];
                                jArr5 = track2.i;
                                Objects.requireNonNull(jArr5);
                                i19 = 0;
                                z9 = false;
                                i20 = 0;
                                i21 = 0;
                                while (true) {
                                    jArr6 = track2.h;
                                    if (i19 >= jArr6.length) {
                                        break;
                                        break;
                                    }
                                    z12 = z9;
                                    i27 = i20;
                                    j7 = jArr5[i19];
                                    if (j7 != -1) {
                                        iArr10 = iArr5;
                                        long jF7 = Util2.F(jArr6[i19], track2.c, track2.d);
                                        iArr4[i19] = Util2.e(jArrCopyOf2, j7, true, true);
                                        iArr10[i19] = Util2.b(jArrCopyOf2, j7 + jF7, z8, false);
                                        while (iArr4[i19] < iArr10[i19]) {
                                            iArr4[i19] = iArr4[i19] + 1;
                                        }
                                        int i515 = (iArr10[i19] - iArr4[i19]) + i27;
                                        if (i21 != iArr4[i19]) {
                                            z13 = true;
                                        } else {
                                            z13 = false;
                                        }
                                        i20 = i515;
                                        i21 = iArr10[i19];
                                        z9 = z12 | z13;
                                    } else {
                                        iArr10 = iArr5;
                                        i20 = i27;
                                        z9 = z12;
                                    }
                                    i19++;
                                    iArr5 = iArr10;
                                }
                                iArr6 = iArr5;
                                boolean z19 = z9;
                                if (i20 != iB) {
                                    z10 = true;
                                } else {
                                    z10 = false;
                                }
                                z11 = z19 | z10;
                                if (z11) {
                                    jArr7 = new long[i20];
                                } else {
                                    jArr7 = jArr3;
                                }
                                if (z11) {
                                    iArr7 = new int[i20];
                                } else {
                                    iArr7 = iArr;
                                }
                                if (z11) {
                                    i22 = 0;
                                } else {
                                    i22 = i18;
                                }
                                if (z11) {
                                    iArr8 = new int[i20];
                                } else {
                                    iArr8 = iArr3;
                                }
                                jArr8 = new long[i20];
                                i23 = 0;
                                i24 = 0;
                                j5 = 0;
                                while (i23 < track2.h.length) {
                                    j6 = track2.i[i23];
                                    i25 = iArr4[i23];
                                    int[] iArr19 = iArr4;
                                    i26 = iArr6[i23];
                                    if (z11) {
                                        int i516 = i26 - i25;
                                        System.arraycopy(jArr3, i25, jArr7, i24, i516);
                                        System.arraycopy(iArr, i25, iArr7, i24, i516);
                                        iArr9 = iArr3;
                                        System.arraycopy(iArr9, i25, iArr8, i24, i516);
                                    } else {
                                        iArr9 = iArr3;
                                    }
                                    i22 = i22;
                                    while (i25 < i26) {
                                        int[] iArr110 = iArr8;
                                        int i517 = i26;
                                        int[] iArr111 = iArr9;
                                        long[] jArr112 = jArrCopyOf2;
                                        long j19 = j5;
                                        jArr8[i24] = Util2.F(j5, 1000000L, track2.d) + Util2.F(Math.max(0L, jArrCopyOf2[i25] - j6), 1000000L, track2.c);
                                        if (!z11) {
                                        }
                                        i24++;
                                        i25++;
                                        iArr8 = iArr110;
                                        j5 = j19;
                                        jArrCopyOf2 = jArr112;
                                        iArr9 = iArr111;
                                        i26 = i517;
                                    }
                                    j5 += track2.h[i23];
                                    i23++;
                                    iArr4 = iArr19;
                                    iArr8 = iArr8;
                                    iArr3 = iArr9;
                                    jArr3 = jArr3;
                                }
                                trackSampleTable = new TrackSampleTable(track2, jArr7, iArr7, i22, jArr8, iArr8, Util2.F(j5, 1000000L, track2.d));
                            } else {
                                i18 = i13;
                                iArr3 = iArr2;
                                jArr3 = jArr;
                                jArr4 = track2.h;
                                if (jArr4.length == 1) {
                                }
                                if (track2.f1230b == 1) {
                                    z8 = true;
                                } else {
                                    z8 = false;
                                }
                                iArr4 = new int[jArr4.length];
                                iArr5 = new int[jArr4.length];
                                jArr5 = track2.i;
                                Objects.requireNonNull(jArr5);
                                i19 = 0;
                                z9 = false;
                                i20 = 0;
                                i21 = 0;
                                while (true) {
                                    jArr6 = track2.h;
                                    if (i19 >= jArr6.length) {
                                        break;
                                        break;
                                    }
                                    z12 = z9;
                                    i27 = i20;
                                    j7 = jArr5[i19];
                                    if (j7 != -1) {
                                        iArr10 = iArr5;
                                        long jF8 = Util2.F(jArr6[i19], track2.c, track2.d);
                                        iArr4[i19] = Util2.e(jArrCopyOf2, j7, true, true);
                                        iArr10[i19] = Util2.b(jArrCopyOf2, j7 + jF8, z8, false);
                                        while (iArr4[i19] < iArr10[i19]) {
                                            iArr4[i19] = iArr4[i19] + 1;
                                        }
                                        int i518 = (iArr10[i19] - iArr4[i19]) + i27;
                                        if (i21 != iArr4[i19]) {
                                            z13 = true;
                                        } else {
                                            z13 = false;
                                        }
                                        i20 = i518;
                                        i21 = iArr10[i19];
                                        z9 = z12 | z13;
                                    } else {
                                        iArr10 = iArr5;
                                        i20 = i27;
                                        z9 = z12;
                                    }
                                    i19++;
                                    iArr5 = iArr10;
                                }
                                iArr6 = iArr5;
                                boolean z110 = z9;
                                if (i20 != iB) {
                                    z10 = true;
                                } else {
                                    z10 = false;
                                }
                                z11 = z110 | z10;
                                if (z11) {
                                    jArr7 = new long[i20];
                                } else {
                                    jArr7 = jArr3;
                                }
                                if (z11) {
                                    iArr7 = new int[i20];
                                } else {
                                    iArr7 = iArr;
                                }
                                if (z11) {
                                    i22 = 0;
                                } else {
                                    i22 = i18;
                                }
                                if (z11) {
                                    iArr8 = new int[i20];
                                } else {
                                    iArr8 = iArr3;
                                }
                                jArr8 = new long[i20];
                                i23 = 0;
                                i24 = 0;
                                j5 = 0;
                                while (i23 < track2.h.length) {
                                    j6 = track2.i[i23];
                                    i25 = iArr4[i23];
                                    int[] iArr112 = iArr4;
                                    i26 = iArr6[i23];
                                    if (z11) {
                                        int i519 = i26 - i25;
                                        System.arraycopy(jArr3, i25, jArr7, i24, i519);
                                        System.arraycopy(iArr, i25, iArr7, i24, i519);
                                        iArr9 = iArr3;
                                        System.arraycopy(iArr9, i25, iArr8, i24, i519);
                                    } else {
                                        iArr9 = iArr3;
                                    }
                                    i22 = i22;
                                    while (i25 < i26) {
                                        int[] iArr113 = iArr8;
                                        int i5110 = i26;
                                        int[] iArr114 = iArr9;
                                        long[] jArr113 = jArrCopyOf2;
                                        long j110 = j5;
                                        jArr8[i24] = Util2.F(j5, 1000000L, track2.d) + Util2.F(Math.max(0L, jArrCopyOf2[i25] - j6), 1000000L, track2.c);
                                        if (!z11) {
                                        }
                                        i24++;
                                        i25++;
                                        iArr8 = iArr113;
                                        j5 = j110;
                                        jArrCopyOf2 = jArr113;
                                        iArr9 = iArr114;
                                        i26 = i5110;
                                    }
                                    j5 += track2.h[i23];
                                    i23++;
                                    iArr4 = iArr112;
                                    iArr8 = iArr8;
                                    iArr3 = iArr9;
                                    jArr3 = jArr3;
                                }
                                trackSampleTable = new TrackSampleTable(track2, jArr7, iArr7, i22, jArr8, iArr8, Util2.F(j5, 1000000L, track2.d));
                            }
                            trackSampleTable = trackSampleTable2;
                        }
                    }
                    arrayList2 = arrayList;
                    arrayList2.add(trackSampleTable);
                }
            }
            i41 = i2 + 1;
            arrayList3 = arrayList2;
        }
        return arrayList3;
    }
}
