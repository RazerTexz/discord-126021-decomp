package b.i.a.c.x2.h0;

import android.net.Uri;
import android.util.Log;
import androidx.annotation.Nullable;
import b.c.a.a0.AnimatableValueParser;
import b.d.b.a.outline;
import b.i.a.c.Format2;
import b.i.a.c.f3.ParsableByteArray;
import b.i.a.c.f3.Util2;
import b.i.a.c.t2.MpegAudioUtil;
import b.i.a.c.x2.DummyTrackOutput;
import b.i.a.c.x2.Extractor;
import b.i.a.c.x2.ExtractorInput;
import b.i.a.c.x2.ExtractorOutput;
import b.i.a.c.x2.ExtractorsFactory;
import b.i.a.c.x2.ExtractorsFactory2;
import b.i.a.c.x2.GaplessInfoHolder;
import b.i.a.c.x2.Id3Peeker;
import b.i.a.c.x2.PositionHolder;
import b.i.a.c.x2.TrackOutput2;
import b.i.a.c.x2.h0.Seeker;
import b.i.a.c.z2.k.Id3Decoder;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.id3.MlltFrame;
import com.google.android.exoplayer2.metadata.id3.TextInformationFrame;
import java.io.EOFException;
import java.io.IOException;
import java.util.Map;
import java.util.Objects;
import org.objectweb.asm.Opcodes;

/* JADX INFO: renamed from: b.i.a.c.x2.h0.f, reason: use source file name */
/* JADX INFO: compiled from: Mp3Extractor.java */
/* JADX INFO: loaded from: classes3.dex */
public final class Mp3Extractor implements Extractor {
    public static final Id3Decoder.a a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f1205b;
    public final long c;
    public final ParsableByteArray d;
    public final MpegAudioUtil.a e;
    public final GaplessInfoHolder f;
    public final Id3Peeker g;
    public final TrackOutput2 h;
    public ExtractorOutput i;
    public TrackOutput2 j;
    public TrackOutput2 k;
    public int l;

    @Nullable
    public Metadata m;
    public long n;
    public long o;
    public long p;
    public int q;
    public Seeker r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f1206s;
    public boolean t;
    public long u;

    static {
        a aVar = new ExtractorsFactory2() { // from class: b.i.a.c.x2.h0.a
            @Override // b.i.a.c.x2.ExtractorsFactory2
            public final Extractor[] a() {
                return new Extractor[]{new Mp3Extractor(0)};
            }

            @Override // b.i.a.c.x2.ExtractorsFactory2
            public /* synthetic */ Extractor[] b(Uri uri, Map map) {
                return ExtractorsFactory.a(this, uri, map);
            }
        };
        a = new Id3Decoder.a() { // from class: b.i.a.c.x2.h0.b
            @Override // b.i.a.c.z2.k.Id3Decoder.a
            public final boolean a(int i, int i2, int i3, int i4, int i5) {
                Id3Decoder.a aVar2 = Mp3Extractor.a;
                return (i2 == 67 && i3 == 79 && i4 == 77 && (i5 == 77 || i == 2)) || (i2 == 77 && i3 == 76 && i4 == 76 && (i5 == 84 || i == 2));
            }
        };
    }

    public Mp3Extractor() {
        this(0);
    }

    public static long d(@Nullable Metadata metadata) {
        if (metadata == null) {
            return -9223372036854775807L;
        }
        int length = metadata.j.length;
        for (int i = 0; i < length; i++) {
            Metadata.Entry entry = metadata.j[i];
            if (entry instanceof TextInformationFrame) {
                TextInformationFrame textInformationFrame = (TextInformationFrame) entry;
                if (textInformationFrame.j.equals("TLEN")) {
                    return Util2.B(Long.parseLong(textInformationFrame.l));
                }
            }
        }
        return -9223372036854775807L;
    }

    public static boolean h(int i, long j) {
        return ((long) (i & (-128000))) == (j & (-128000));
    }

    public final long a(long j) {
        return ((j * 1000000) / ((long) this.e.d)) + this.n;
    }

    @Override // b.i.a.c.x2.Extractor
    public boolean b(ExtractorInput extractorInput) throws IOException {
        return j(extractorInput, true);
    }

    public final Seeker c(ExtractorInput extractorInput, boolean z2) throws IOException {
        extractorInput.o(this.d.a, 0, 4);
        this.d.E(0);
        this.e.a(this.d.f());
        return new ConstantBitrateSeeker(extractorInput.b(), extractorInput.getPosition(), this.e, z2);
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0230  */
    /* JADX WARN: Code duplicated, block: B:103:0x023b  */
    /* JADX WARN: Code duplicated, block: B:10:0x001e  */
    /* JADX WARN: Code duplicated, block: B:110:0x0253  */
    /* JADX WARN: Code duplicated, block: B:112:0x0259  */
    /* JADX WARN: Code duplicated, block: B:116:0x027c A[LOOP:2: B:115:0x027a->B:116:0x027c, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:118:0x029f A[LOOP:1: B:111:0x0257->B:118:0x029f, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:119:0x02a4 A[EDGE_INSN: B:119:0x02a4->B:120:0x02a5 BREAK  A[LOOP:1: B:111:0x0257->B:118:0x029f]] */
    /* JADX WARN: Code duplicated, block: B:122:0x02a9  */
    /* JADX WARN: Code duplicated, block: B:123:0x02af  */
    /* JADX WARN: Code duplicated, block: B:125:0x02b5 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:126:0x02b7  */
    /* JADX WARN: Code duplicated, block: B:128:0x02bd A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:129:0x02bf  */
    /* JADX WARN: Code duplicated, block: B:12:0x003b  */
    /* JADX WARN: Code duplicated, block: B:130:0x02ca  */
    /* JADX WARN: Code duplicated, block: B:132:0x02dc A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:133:0x02de  */
    /* JADX WARN: Code duplicated, block: B:134:0x02e0 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:136:0x02e3  */
    /* JADX WARN: Code duplicated, block: B:142:0x02f2  */
    /* JADX WARN: Code duplicated, block: B:144:0x02f8  */
    /* JADX WARN: Code duplicated, block: B:145:0x02fa  */
    /* JADX WARN: Code duplicated, block: B:149:0x032f  */
    /* JADX WARN: Code duplicated, block: B:14:0x003f  */
    /* JADX WARN: Code duplicated, block: B:150:0x0331  */
    /* JADX WARN: Code duplicated, block: B:152:0x0343  */
    /* JADX WARN: Code duplicated, block: B:154:0x034d  */
    /* JADX WARN: Code duplicated, block: B:156:0x0357  */
    /* JADX WARN: Code duplicated, block: B:159:0x0360  */
    /* JADX WARN: Code duplicated, block: B:15:0x0042  */
    /* JADX WARN: Code duplicated, block: B:162:0x036b  */
    /* JADX WARN: Code duplicated, block: B:184:0x040a  */
    /* JADX WARN: Code duplicated, block: B:187:0x0418  */
    /* JADX WARN: Code duplicated, block: B:18:0x0047  */
    /* JADX WARN: Code duplicated, block: B:190:0x0420  */
    /* JADX WARN: Code duplicated, block: B:208:0x0261 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:209:0x02a4 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:21:0x0058  */
    /* JADX WARN: Code duplicated, block: B:25:0x0064  */
    /* JADX WARN: Code duplicated, block: B:27:0x006a  */
    /* JADX WARN: Code duplicated, block: B:29:0x0073  */
    /* JADX WARN: Code duplicated, block: B:30:0x0077  */
    /* JADX WARN: Code duplicated, block: B:69:0x0160  */
    /* JADX WARN: Code duplicated, block: B:71:0x0179  */
    /* JADX WARN: Code duplicated, block: B:7:0x0016 A[PHI: r1
      0x0016: PHI (r1v3 b.i.a.c.x2.h0.f) = (r1v2 b.i.a.c.x2.h0.f), (r1v6 b.i.a.c.x2.h0.f), (r1v6 b.i.a.c.x2.h0.f) binds: [B:6:0x0014, B:185:0x0414, B:160:0x0367] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:87:0x01e7  */
    /* JADX WARN: Code duplicated, block: B:89:0x01ee  */
    /* JADX WARN: Code duplicated, block: B:91:0x01f5  */
    /* JADX WARN: Code duplicated, block: B:94:0x01fb  */
    /* JADX WARN: Code duplicated, block: B:96:0x01fe  */
    /* JADX WARN: Code duplicated, block: B:98:0x0229 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:99:0x022b  */
    @Override // b.i.a.c.x2.Extractor
    public int e(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException {
        Mp3Extractor mp3Extractor;
        int i;
        ExtractorInput extractorInput2;
        long position;
        long j;
        int iB;
        int i2;
        int iF;
        ParsableByteArray parsableByteArray;
        MpegAudioUtil.a aVar;
        int i3;
        int iF2;
        int iF3;
        Seeker seekerC;
        GaplessInfoHolder gaplessInfoHolder;
        boolean z2;
        int i4;
        GaplessInfoHolder gaplessInfoHolder2;
        int i5;
        int i6;
        int iW;
        XingSeeker xingSeeker;
        Metadata metadata;
        long position2;
        MlltSeeker mlltSeeker;
        boolean z3;
        long jD;
        long jI;
        long jA;
        Metadata metadata2;
        int length;
        int i7;
        Metadata.Entry entry;
        MlltFrame mlltFrame;
        int length2;
        long[] jArr;
        long[] jArr2;
        long j2;
        int i8;
        int iT;
        AnimatableValueParser.H(this.j);
        int i9 = Util2.a;
        if (this.l == 0) {
            try {
                j(extractorInput, false);
                if (this.r == null) {
                    parsableByteArray = new ParsableByteArray(this.e.c);
                    extractorInput.o(parsableByteArray.a, 0, this.e.c);
                    aVar = this.e;
                    i3 = 21;
                    if ((aVar.a & 1) != 0) {
                        if (aVar.e != 1) {
                            i3 = 36;
                        }
                    } else if (aVar.e == 1) {
                        i3 = 13;
                    }
                    if (parsableByteArray.c >= i3 + 4) {
                        parsableByteArray.E(i3);
                        iF2 = parsableByteArray.f();
                        if (iF2 != 1483304551 && iF2 != 1231971951) {
                            if (parsableByteArray.c >= 40) {
                                parsableByteArray.E(36);
                                if (parsableByteArray.f() == 1447187017) {
                                    iF2 = 1447187017;
                                } else {
                                    iF2 = 0;
                                }
                            } else {
                                iF2 = 0;
                            }
                        }
                    } else if (parsableByteArray.c >= 40) {
                        parsableByteArray.E(36);
                        if (parsableByteArray.f() == 1447187017) {
                            iF2 = 1447187017;
                        } else {
                            iF2 = 0;
                        }
                    } else {
                        iF2 = 0;
                    }
                    String str = ", ";
                    if (iF2 != 1483304551 || iF2 == 1231971951) {
                        mp3Extractor = this;
                        long jB = extractorInput.b();
                        long position3 = extractorInput.getPosition();
                        MpegAudioUtil.a aVar2 = mp3Extractor.e;
                        int i10 = aVar2.g;
                        int i11 = aVar2.d;
                        iF3 = parsableByteArray.f();
                        if ((iF3 & 1) == 1 || (iW = parsableByteArray.w()) == 0) {
                            seekerC = null;
                        } else {
                            long jF = Util2.F(iW, ((long) i10) * 1000000, i11);
                            if ((iF3 & 6) != 6) {
                                xingSeeker = new XingSeeker(position3, aVar2.c, jF, -1L, null);
                            } else {
                                long jU = parsableByteArray.u();
                                long[] jArr3 = new long[100];
                                for (int i12 = 0; i12 < 100; i12++) {
                                    jArr3[i12] = parsableByteArray.t();
                                }
                                if (jB != -1) {
                                    long j3 = position3 + jU;
                                    if (jB != j3) {
                                        StringBuilder sbR = outline.R(67, "XING data size mismatch: ", jB, ", ");
                                        sbR.append(j3);
                                        Log.w("XingSeeker", sbR.toString());
                                    }
                                }
                                xingSeeker = new XingSeeker(position3, aVar2.c, jF, jU, jArr3);
                            }
                            seekerC = xingSeeker;
                        }
                        if (seekerC != null) {
                            gaplessInfoHolder = mp3Extractor.f;
                            if (gaplessInfoHolder.f1294b != -1 || gaplessInfoHolder.c == -1) {
                                z2 = false;
                            } else {
                                z2 = true;
                            }
                            if (z2) {
                                extractorInput2 = extractorInput;
                            } else {
                                extractorInput.k();
                                extractorInput2 = extractorInput;
                                extractorInput2.g(i4 + Opcodes.F2D);
                                extractorInput2.o(mp3Extractor.d.a, 0, 3);
                                mp3Extractor.d.E(0);
                                gaplessInfoHolder2 = mp3Extractor.f;
                                int iV = mp3Extractor.d.v();
                                Objects.requireNonNull(gaplessInfoHolder2);
                                i5 = iV >> 12;
                                i6 = iV & 4095;
                                if (i5 <= 0 || i6 > 0) {
                                    i4 = i3;
                                    gaplessInfoHolder2.f1294b = i5;
                                    gaplessInfoHolder2.c = i6;
                                }
                            }
                        } else {
                            extractorInput2 = extractorInput;
                        }
                        extractorInput2.l(mp3Extractor.e.c);
                        if (seekerC != null && !seekerC.c() && iF2 == 1231971951) {
                            seekerC = mp3Extractor.c(extractorInput2, false);
                        }
                    } else if (iF2 == 1447187017) {
                        long jB2 = extractorInput.b();
                        long position4 = extractorInput.getPosition();
                        MpegAudioUtil.a aVar3 = this.e;
                        parsableByteArray.F(10);
                        int iF4 = parsableByteArray.f();
                        if (iF4 <= 0) {
                            seekerC = null;
                            break;
                        }
                        int i13 = aVar3.d;
                        long jF2 = Util2.F(iF4, ((long) (i13 >= 32000 ? 1152 : 576)) * 1000000, i13);
                        int iY = parsableByteArray.y();
                        int iY2 = parsableByteArray.y();
                        int iY3 = parsableByteArray.y();
                        parsableByteArray.F(2);
                        long j4 = ((long) aVar3.c) + position4;
                        long[] jArr4 = new long[iY];
                        long[] jArr5 = new long[iY];
                        int i14 = 0;
                        long j5 = position4;
                        while (true) {
                            if (i14 >= iY) {
                                String str2 = str;
                                long j6 = jB2;
                                if (j6 != -1 && j6 != j5) {
                                    StringBuilder sbR2 = outline.R(67, "VBRI data size mismatch: ", j6, str2);
                                    sbR2.append(j5);
                                    Log.w("VbriSeeker", sbR2.toString());
                                }
                                seekerC = new VbriSeeker(jArr4, jArr5, jF2, j5);
                                break;
                            }
                            String str3 = str;
                            long j7 = jB2;
                            jArr4[i14] = (((long) i14) * jF2) / ((long) iY);
                            jArr5[i14] = Math.max(j5, j4);
                            if (iY3 == 1) {
                                iT = parsableByteArray.t();
                            } else if (iY3 == 2) {
                                iT = parsableByteArray.y();
                            } else if (iY3 == 3) {
                                iT = parsableByteArray.v();
                            } else {
                                if (iY3 != 4) {
                                    seekerC = null;
                                    break;
                                }
                                iT = parsableByteArray.w();
                            }
                            j5 += (long) (iT * iY2);
                            i14++;
                            str = str3;
                            jB2 = j7;
                        }
                        mp3Extractor = this;
                        extractorInput.l(mp3Extractor.e.c);
                        extractorInput2 = extractorInput;
                    } else {
                        mp3Extractor = this;
                        extractorInput.k();
                        extractorInput2 = extractorInput;
                        seekerC = null;
                    }
                    metadata = mp3Extractor.m;
                    position2 = extractorInput.getPosition();
                    if (metadata != null) {
                        mlltSeeker = null;
                        break;
                    }
                    length = metadata.j.length;
                    i7 = 0;
                    while (true) {
                        if (i7 < length) {
                            mlltSeeker = null;
                            break;
                        }
                        entry = metadata.j[i7];
                        if (entry instanceof MlltFrame) {
                            mlltFrame = (MlltFrame) entry;
                            long jD2 = d(metadata);
                            length2 = mlltFrame.n.length;
                            int i15 = length2 + 1;
                            jArr = new long[i15];
                            jArr2 = new long[i15];
                            jArr[0] = position2;
                            jArr2[0] = 0;
                            j2 = 0;
                            for (i8 = 1; i8 <= length2; i8++) {
                                int i16 = i8 - 1;
                                position2 += (long) (mlltFrame.l + mlltFrame.n[i16]);
                                j2 += (long) (mlltFrame.m + mlltFrame.o[i16]);
                                jArr[i8] = position2;
                                jArr2[i8] = j2;
                            }
                            mlltSeeker = new MlltSeeker(jArr, jArr2, jD2);
                            break;
                        }
                        i7++;
                    }
                    if (mp3Extractor.f1206s) {
                        seekerC = new Seeker.a();
                    } else {
                        if ((mp3Extractor.f1205b & 4) != 0) {
                            if (mlltSeeker != null) {
                                jD = mlltSeeker.c;
                            } else {
                                if (seekerC != null) {
                                    jI = seekerC.i();
                                    jA = seekerC.a();
                                } else {
                                    jD = d(mp3Extractor.m);
                                }
                                seekerC = new IndexSeeker(jI, extractorInput.getPosition(), jA);
                            }
                            jI = jD;
                            jA = -1;
                            seekerC = new IndexSeeker(jI, extractorInput.getPosition(), jA);
                        } else if (mlltSeeker != null) {
                            seekerC = mlltSeeker;
                        } else if (seekerC == null) {
                            seekerC = null;
                        }
                        if (seekerC != null || (!seekerC.c() && (mp3Extractor.f1205b & 1) != 0)) {
                            if ((mp3Extractor.f1205b & 2) != 0) {
                                z3 = true;
                            } else {
                                z3 = false;
                            }
                            seekerC = mp3Extractor.c(extractorInput2, z3);
                        }
                    }
                    mp3Extractor.r = seekerC;
                    mp3Extractor.i.a(seekerC);
                    TrackOutput2 trackOutput2 = mp3Extractor.k;
                    Format2.b bVar = new Format2.b();
                    MpegAudioUtil.a aVar4 = mp3Extractor.e;
                    bVar.k = aVar4.f1116b;
                    bVar.l = 4096;
                    bVar.f1023x = aVar4.e;
                    bVar.f1024y = aVar4.d;
                    GaplessInfoHolder gaplessInfoHolder3 = mp3Extractor.f;
                    bVar.A = gaplessInfoHolder3.f1294b;
                    bVar.B = gaplessInfoHolder3.c;
                    if ((mp3Extractor.f1205b & 8) != 0) {
                        metadata2 = null;
                    } else {
                        metadata2 = mp3Extractor.m;
                    }
                    bVar.i = metadata2;
                    trackOutput2.e(bVar.a());
                    mp3Extractor.p = extractorInput.getPosition();
                } else {
                    extractorInput2 = extractorInput;
                    mp3Extractor = this;
                    if (mp3Extractor.p != 0) {
                        position = extractorInput.getPosition();
                        j = mp3Extractor.p;
                        if (position < j) {
                            extractorInput2.l((int) (j - position));
                        }
                    }
                }
                if (mp3Extractor.q == 0) {
                    extractorInput.k();
                    if (i(extractorInput)) {
                        i = -1;
                    } else {
                        mp3Extractor.d.E(0);
                        iF = mp3Extractor.d.f();
                        if (h(iF, mp3Extractor.l) || MpegAudioUtil.a(iF) == -1) {
                            extractorInput2.l(1);
                            mp3Extractor.l = 0;
                        } else {
                            mp3Extractor.e.a(iF);
                            if (mp3Extractor.n == -9223372036854775807L) {
                                mp3Extractor.n = mp3Extractor.r.d(extractorInput.getPosition());
                                if (mp3Extractor.c != -9223372036854775807L) {
                                    mp3Extractor.n = (mp3Extractor.c - mp3Extractor.r.d(0L)) + mp3Extractor.n;
                                }
                            }
                            MpegAudioUtil.a aVar5 = mp3Extractor.e;
                            mp3Extractor.q = aVar5.c;
                            Seeker seeker = mp3Extractor.r;
                            if (seeker instanceof IndexSeeker) {
                                IndexSeeker indexSeeker = (IndexSeeker) seeker;
                                long jA2 = mp3Extractor.a(mp3Extractor.o + ((long) aVar5.g));
                                long position5 = extractorInput.getPosition() + ((long) mp3Extractor.e.c);
                                if (!indexSeeker.b(jA2)) {
                                    indexSeeker.f1203b.a(jA2);
                                    indexSeeker.c.a(position5);
                                }
                                if (mp3Extractor.t && indexSeeker.b(mp3Extractor.u)) {
                                    mp3Extractor.t = false;
                                    mp3Extractor.k = mp3Extractor.j;
                                }
                            }
                            iB = mp3Extractor.k.b(extractorInput2, mp3Extractor.q, true);
                            if (iB == -1) {
                                i = -1;
                            } else {
                                i2 = mp3Extractor.q - iB;
                                mp3Extractor.q = i2;
                                if (i2 <= 0) {
                                    mp3Extractor.k.d(mp3Extractor.a(mp3Extractor.o), 1, mp3Extractor.e.c, 0, null);
                                    mp3Extractor.o += (long) mp3Extractor.e.g;
                                    mp3Extractor.q = 0;
                                }
                            }
                        }
                        i = 0;
                    }
                } else {
                    iB = mp3Extractor.k.b(extractorInput2, mp3Extractor.q, true);
                    if (iB == -1) {
                        i = -1;
                    } else {
                        i2 = mp3Extractor.q - iB;
                        mp3Extractor.q = i2;
                        if (i2 <= 0) {
                            mp3Extractor.k.d(mp3Extractor.a(mp3Extractor.o), 1, mp3Extractor.e.c, 0, null);
                            mp3Extractor.o += (long) mp3Extractor.e.g;
                            mp3Extractor.q = 0;
                        }
                        i = 0;
                    }
                }
            } catch (EOFException unused) {
                mp3Extractor = this;
            }
        } else {
            if (this.r == null) {
                parsableByteArray = new ParsableByteArray(this.e.c);
                extractorInput.o(parsableByteArray.a, 0, this.e.c);
                aVar = this.e;
                i3 = 21;
                if ((aVar.a & 1) != 0) {
                    if (aVar.e != 1) {
                        i3 = 36;
                    }
                } else if (aVar.e == 1) {
                    i3 = 13;
                }
                if (parsableByteArray.c >= i3 + 4) {
                    parsableByteArray.E(i3);
                    iF2 = parsableByteArray.f();
                    if (iF2 != 1483304551) {
                        if (parsableByteArray.c >= 40) {
                            parsableByteArray.E(36);
                            if (parsableByteArray.f() == 1447187017) {
                                iF2 = 1447187017;
                            } else {
                                iF2 = 0;
                            }
                        } else {
                            iF2 = 0;
                        }
                    }
                } else if (parsableByteArray.c >= 40) {
                    parsableByteArray.E(36);
                    if (parsableByteArray.f() == 1447187017) {
                        iF2 = 1447187017;
                    } else {
                        iF2 = 0;
                    }
                } else {
                    iF2 = 0;
                }
                String str4 = ", ";
                if (iF2 != 1483304551) {
                    mp3Extractor = this;
                    long jB3 = extractorInput.b();
                    long position6 = extractorInput.getPosition();
                    MpegAudioUtil.a aVar6 = mp3Extractor.e;
                    int i17 = aVar6.g;
                    int i18 = aVar6.d;
                    iF3 = parsableByteArray.f();
                    if ((iF3 & 1) == 1) {
                        seekerC = null;
                    } else {
                        seekerC = null;
                    }
                    if (seekerC != null) {
                        gaplessInfoHolder = mp3Extractor.f;
                        if (gaplessInfoHolder.f1294b != -1) {
                            z2 = false;
                        } else {
                            z2 = false;
                        }
                        if (z2) {
                            extractorInput.k();
                            extractorInput2 = extractorInput;
                            extractorInput2.g(i4 + Opcodes.F2D);
                            extractorInput2.o(mp3Extractor.d.a, 0, 3);
                            mp3Extractor.d.E(0);
                            gaplessInfoHolder2 = mp3Extractor.f;
                            int iV2 = mp3Extractor.d.v();
                            Objects.requireNonNull(gaplessInfoHolder2);
                            i5 = iV2 >> 12;
                            i6 = iV2 & 4095;
                            if (i5 <= 0) {
                                i4 = i3;
                                gaplessInfoHolder2.f1294b = i5;
                                gaplessInfoHolder2.c = i6;
                            } else {
                                i4 = i3;
                                gaplessInfoHolder2.f1294b = i5;
                                gaplessInfoHolder2.c = i6;
                            }
                        } else {
                            extractorInput2 = extractorInput;
                        }
                    } else {
                        extractorInput2 = extractorInput;
                    }
                    extractorInput2.l(mp3Extractor.e.c);
                    if (seekerC != null) {
                        seekerC = mp3Extractor.c(extractorInput2, false);
                    }
                } else {
                    mp3Extractor = this;
                    long jB4 = extractorInput.b();
                    long position7 = extractorInput.getPosition();
                    MpegAudioUtil.a aVar7 = mp3Extractor.e;
                    int i19 = aVar7.g;
                    int i110 = aVar7.d;
                    iF3 = parsableByteArray.f();
                    if ((iF3 & 1) == 1) {
                        seekerC = null;
                    } else {
                        seekerC = null;
                    }
                    if (seekerC != null) {
                        gaplessInfoHolder = mp3Extractor.f;
                        if (gaplessInfoHolder.f1294b != -1) {
                            z2 = false;
                        } else {
                            z2 = false;
                        }
                        if (z2) {
                            extractorInput.k();
                            extractorInput2 = extractorInput;
                            extractorInput2.g(i4 + Opcodes.F2D);
                            extractorInput2.o(mp3Extractor.d.a, 0, 3);
                            mp3Extractor.d.E(0);
                            gaplessInfoHolder2 = mp3Extractor.f;
                            int iV3 = mp3Extractor.d.v();
                            Objects.requireNonNull(gaplessInfoHolder2);
                            i5 = iV3 >> 12;
                            i6 = iV3 & 4095;
                            if (i5 <= 0) {
                                i4 = i3;
                                gaplessInfoHolder2.f1294b = i5;
                                gaplessInfoHolder2.c = i6;
                            } else {
                                i4 = i3;
                                gaplessInfoHolder2.f1294b = i5;
                                gaplessInfoHolder2.c = i6;
                            }
                        } else {
                            extractorInput2 = extractorInput;
                        }
                    } else {
                        extractorInput2 = extractorInput;
                    }
                    extractorInput2.l(mp3Extractor.e.c);
                    if (seekerC != null) {
                        seekerC = mp3Extractor.c(extractorInput2, false);
                    }
                }
                metadata = mp3Extractor.m;
                position2 = extractorInput.getPosition();
                if (metadata != null) {
                    mlltSeeker = null;
                    break;
                }
                length = metadata.j.length;
                i7 = 0;
                while (true) {
                    if (i7 < length) {
                        mlltSeeker = null;
                        break;
                    }
                    entry = metadata.j[i7];
                    if (entry instanceof MlltFrame) {
                        mlltFrame = (MlltFrame) entry;
                        long jD3 = d(metadata);
                        length2 = mlltFrame.n.length;
                        int i111 = length2 + 1;
                        jArr = new long[i111];
                        jArr2 = new long[i111];
                        jArr[0] = position2;
                        jArr2[0] = 0;
                        j2 = 0;
                        while (i8 <= length2) {
                            int i112 = i8 - 1;
                            position2 += (long) (mlltFrame.l + mlltFrame.n[i112]);
                            j2 += (long) (mlltFrame.m + mlltFrame.o[i112]);
                            jArr[i8] = position2;
                            jArr2[i8] = j2;
                        }
                        mlltSeeker = new MlltSeeker(jArr, jArr2, jD3);
                        break;
                    }
                    i7++;
                }
                if (mp3Extractor.f1206s) {
                    seekerC = new Seeker.a();
                } else {
                    if ((mp3Extractor.f1205b & 4) != 0) {
                        if (mlltSeeker != null) {
                            jD = mlltSeeker.c;
                        } else {
                            if (seekerC != null) {
                                jI = seekerC.i();
                                jA = seekerC.a();
                            } else {
                                jD = d(mp3Extractor.m);
                            }
                            seekerC = new IndexSeeker(jI, extractorInput.getPosition(), jA);
                        }
                        jI = jD;
                        jA = -1;
                        seekerC = new IndexSeeker(jI, extractorInput.getPosition(), jA);
                    } else if (mlltSeeker != null) {
                        seekerC = mlltSeeker;
                    } else if (seekerC == null) {
                        seekerC = null;
                    }
                    if (seekerC != null) {
                        if ((mp3Extractor.f1205b & 2) != 0) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        seekerC = mp3Extractor.c(extractorInput2, z3);
                    } else {
                        if ((mp3Extractor.f1205b & 2) != 0) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        seekerC = mp3Extractor.c(extractorInput2, z3);
                    }
                }
                mp3Extractor.r = seekerC;
                mp3Extractor.i.a(seekerC);
                TrackOutput2 trackOutput3 = mp3Extractor.k;
                Format2.b bVar2 = new Format2.b();
                MpegAudioUtil.a aVar8 = mp3Extractor.e;
                bVar2.k = aVar8.f1116b;
                bVar2.l = 4096;
                bVar2.f1023x = aVar8.e;
                bVar2.f1024y = aVar8.d;
                GaplessInfoHolder gaplessInfoHolder4 = mp3Extractor.f;
                bVar2.A = gaplessInfoHolder4.f1294b;
                bVar2.B = gaplessInfoHolder4.c;
                if ((mp3Extractor.f1205b & 8) != 0) {
                    metadata2 = null;
                } else {
                    metadata2 = mp3Extractor.m;
                }
                bVar2.i = metadata2;
                trackOutput3.e(bVar2.a());
                mp3Extractor.p = extractorInput.getPosition();
            } else {
                extractorInput2 = extractorInput;
                mp3Extractor = this;
                if (mp3Extractor.p != 0) {
                    position = extractorInput.getPosition();
                    j = mp3Extractor.p;
                    if (position < j) {
                        extractorInput2.l((int) (j - position));
                    }
                }
            }
            if (mp3Extractor.q == 0) {
                extractorInput.k();
                if (i(extractorInput)) {
                    i = -1;
                } else {
                    mp3Extractor.d.E(0);
                    iF = mp3Extractor.d.f();
                    if (h(iF, mp3Extractor.l)) {
                    }
                    extractorInput2.l(1);
                    mp3Extractor.l = 0;
                    i = 0;
                }
            } else {
                iB = mp3Extractor.k.b(extractorInput2, mp3Extractor.q, true);
                if (iB == -1) {
                    i = -1;
                } else {
                    i2 = mp3Extractor.q - iB;
                    mp3Extractor.q = i2;
                    if (i2 <= 0) {
                        mp3Extractor.k.d(mp3Extractor.a(mp3Extractor.o), 1, mp3Extractor.e.c, 0, null);
                        mp3Extractor.o += (long) mp3Extractor.e.g;
                        mp3Extractor.q = 0;
                    }
                    i = 0;
                }
            }
        }
        if (i == -1 && (mp3Extractor.r instanceof IndexSeeker)) {
            long jA3 = mp3Extractor.a(mp3Extractor.o);
            if (mp3Extractor.r.i() != jA3) {
                Seeker seeker2 = mp3Extractor.r;
                ((IndexSeeker) seeker2).d = jA3;
                mp3Extractor.i.a(seeker2);
            }
        }
        return i;
    }

    @Override // b.i.a.c.x2.Extractor
    public void f(ExtractorOutput extractorOutput) {
        this.i = extractorOutput;
        TrackOutput2 trackOutput2P = extractorOutput.p(0, 1);
        this.j = trackOutput2P;
        this.k = trackOutput2P;
        this.i.j();
    }

    @Override // b.i.a.c.x2.Extractor
    public void g(long j, long j2) {
        this.l = 0;
        this.n = -9223372036854775807L;
        this.o = 0L;
        this.q = 0;
        this.u = j2;
        Seeker seeker = this.r;
        if (!(seeker instanceof IndexSeeker) || ((IndexSeeker) seeker).b(j2)) {
            return;
        }
        this.t = true;
        this.k = this.h;
    }

    public final boolean i(ExtractorInput extractorInput) throws IOException {
        Seeker seeker = this.r;
        if (seeker != null) {
            long jA = seeker.a();
            if (jA != -1 && extractorInput.f() > jA - 4) {
                return true;
            }
        }
        try {
            return !extractorInput.e(this.d.a, 0, 4, true);
        } catch (EOFException unused) {
            return true;
        }
    }

    public final boolean j(ExtractorInput extractorInput, boolean z2) throws IOException {
        int i;
        int iF;
        int iA;
        int i2 = z2 ? 32768 : 131072;
        extractorInput.k();
        if (extractorInput.getPosition() == 0) {
            Metadata metadataA = this.g.a(extractorInput, (this.f1205b & 8) == 0 ? null : a);
            this.m = metadataA;
            if (metadataA != null) {
                this.f.b(metadataA);
            }
            iF = (int) extractorInput.f();
            if (!z2) {
                extractorInput.l(iF);
            }
            i = 0;
        } else {
            i = 0;
            iF = 0;
        }
        int i3 = 0;
        int i4 = 0;
        while (true) {
            if (i(extractorInput)) {
                if (i3 > 0) {
                    break;
                }
                throw new EOFException();
            }
            this.d.E(0);
            int iF2 = this.d.f();
            if ((i == 0 || h(iF2, i)) && (iA = MpegAudioUtil.a(iF2)) != -1) {
                i3++;
                if (i3 != 1) {
                    if (i3 == 4) {
                        break;
                    }
                } else {
                    this.e.a(iF2);
                    i = iF2;
                }
                extractorInput.g(iA - 4);
            } else {
                int i5 = i4 + 1;
                if (i4 == i2) {
                    if (z2) {
                        return false;
                    }
                    throw ParserException.a("Searched too many bytes.", null);
                }
                if (z2) {
                    extractorInput.k();
                    extractorInput.g(iF + i5);
                } else {
                    extractorInput.l(1);
                }
                i4 = i5;
                i = 0;
                i3 = 0;
            }
        }
        if (z2) {
            extractorInput.l(iF + i4);
        } else {
            extractorInput.k();
        }
        this.l = i;
        return true;
    }

    @Override // b.i.a.c.x2.Extractor
    public void release() {
    }

    public Mp3Extractor(int i) {
        this.f1205b = (i & 2) != 0 ? i | 1 : i;
        this.c = -9223372036854775807L;
        this.d = new ParsableByteArray(10);
        this.e = new MpegAudioUtil.a();
        this.f = new GaplessInfoHolder();
        this.n = -9223372036854775807L;
        this.g = new Id3Peeker();
        DummyTrackOutput dummyTrackOutput = new DummyTrackOutput();
        this.h = dummyTrackOutput;
        this.k = dummyTrackOutput;
    }
}
