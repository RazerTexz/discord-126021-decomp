package b.i.a.c.x2.i0;

import android.net.Uri;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import b.c.a.a0.AnimatableValueParser;
import b.d.b.a.outline;
import b.i.a.c.Format2;
import b.i.a.c.f3.NalUnitUtil;
import b.i.a.c.f3.ParsableByteArray;
import b.i.a.c.f3.Util2;
import b.i.a.c.t2.Ac4Util;
import b.i.a.c.x2.Extractor;
import b.i.a.c.x2.ExtractorInput;
import b.i.a.c.x2.ExtractorOutput;
import b.i.a.c.x2.ExtractorsFactory;
import b.i.a.c.x2.ExtractorsFactory2;
import b.i.a.c.x2.GaplessInfoHolder;
import b.i.a.c.x2.PositionHolder;
import b.i.a.c.x2.SeekMap;
import b.i.a.c.x2.SeekPoint;
import b.i.a.c.x2.TrackOutput2;
import b.i.a.c.x2.TrueHdSampleRechunker;
import b.i.a.c.x2.i0.Atom;
import b.i.a.c.x2.i0.SefReader;
import b.i.b.a.Function2;
import com.discord.api.permission.Permission;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.id3.Id3Frame;
import com.google.android.exoplayer2.metadata.id3.InternalFrame;
import com.google.android.exoplayer2.metadata.id3.TextInformationFrame;
import com.google.android.exoplayer2.metadata.mp4.MdtaMetadataEntry;
import com.google.android.exoplayer2.metadata.mp4.MotionPhotoMetadata;
import com.google.android.exoplayer2.metadata.mp4.SlowMotionData;
import com.google.android.exoplayer2.metadata.mp4.SmtaMetadataEntry;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: renamed from: b.i.a.c.x2.i0.i, reason: use source file name */
/* JADX INFO: compiled from: Mp4Extractor.java */
/* JADX INFO: loaded from: classes3.dex */
public final class Mp4Extractor implements Extractor, SeekMap {
    public static final /* synthetic */ int a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f1222b;
    public final ParsableByteArray c;
    public final ParsableByteArray d;
    public final ParsableByteArray e;
    public final ParsableByteArray f;
    public final ArrayDeque<Atom.a> g;
    public final SefReader h;
    public final List<Metadata.Entry> i;
    public int j;
    public int k;
    public long l;
    public int m;

    @Nullable
    public ParsableByteArray n;
    public int o;
    public int p;
    public int q;
    public int r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public ExtractorOutput f1223s;
    public a[] t;
    public long[][] u;
    public int v;
    public long w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f1224x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    @Nullable
    public MotionPhotoMetadata f1225y;

    /* JADX INFO: renamed from: b.i.a.c.x2.i0.i$a */
    /* JADX INFO: compiled from: Mp4Extractor.java */
    public static final class a {
        public final Track a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final TrackSampleTable f1226b;
        public final TrackOutput2 c;

        @Nullable
        public final TrueHdSampleRechunker d;
        public int e;

        public a(Track track, TrackSampleTable trackSampleTable, TrackOutput2 trackOutput2) {
            this.a = track;
            this.f1226b = trackSampleTable;
            this.c = trackOutput2;
            this.d = "audio/true-hd".equals(track.f.w) ? new TrueHdSampleRechunker() : null;
        }
    }

    static {
        b bVar = new ExtractorsFactory2() { // from class: b.i.a.c.x2.i0.b
            @Override // b.i.a.c.x2.ExtractorsFactory2
            public final Extractor[] a() {
                return new Extractor[]{new Mp4Extractor(0)};
            }

            @Override // b.i.a.c.x2.ExtractorsFactory2
            public /* synthetic */ Extractor[] b(Uri uri, Map map) {
                return ExtractorsFactory.a(this, uri, map);
            }
        };
    }

    public Mp4Extractor(int i) {
        this.f1222b = i;
        this.j = (i & 4) != 0 ? 3 : 0;
        this.h = new SefReader();
        this.i = new ArrayList();
        this.f = new ParsableByteArray(16);
        this.g = new ArrayDeque<>();
        this.c = new ParsableByteArray(NalUnitUtil.a);
        this.d = new ParsableByteArray(4);
        this.e = new ParsableByteArray();
        this.o = -1;
    }

    public static long k(TrackSampleTable trackSampleTable, long j, long j2) {
        int iA = trackSampleTable.a(j);
        if (iA == -1) {
            iA = trackSampleTable.b(j);
        }
        return iA == -1 ? j2 : Math.min(trackSampleTable.c[iA], j2);
    }

    @Override // b.i.a.c.x2.Extractor
    public boolean b(ExtractorInput extractorInput) throws IOException {
        return Sniffer2.a(extractorInput, false, (this.f1222b & 2) != 0);
    }

    @Override // b.i.a.c.x2.SeekMap
    public boolean c() {
        return true;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:235:0x04a2  */
    /* JADX WARN: Code duplicated, block: B:256:0x0523  */
    /* JADX WARN: Code duplicated, block: B:257:0x053a  */
    /* JADX WARN: Code duplicated, block: B:259:0x0540  */
    /* JADX WARN: Code duplicated, block: B:266:0x055a  */
    /* JADX WARN: Code duplicated, block: B:269:0x056e  */
    /* JADX WARN: Code duplicated, block: B:284:0x0596  */
    /* JADX WARN: Code duplicated, block: B:287:0x059c  */
    /* JADX WARN: Code duplicated, block: B:293:0x05ce  */
    /* JADX WARN: Code duplicated, block: B:297:0x05f2  */
    /* JADX WARN: Code duplicated, block: B:298:0x05f6  */
    /* JADX WARN: Code duplicated, block: B:300:0x05fc  */
    /* JADX WARN: Code duplicated, block: B:336:0x0653  */
    /* JADX WARN: Code duplicated, block: B:338:0x0656  */
    /* JADX WARN: Code duplicated, block: B:340:0x065a  */
    /* JADX WARN: Code duplicated, block: B:341:0x065c  */
    /* JADX WARN: Code duplicated, block: B:344:0x0669  */
    /* JADX WARN: Code duplicated, block: B:345:0x066b  */
    /* JADX WARN: Code duplicated, block: B:347:0x0689  */
    /* JADX WARN: Code duplicated, block: B:349:0x0699  */
    /* JADX WARN: Code duplicated, block: B:361:0x04a5 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:363:0x06bb A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:367:0x0006 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:43:0x00b1  */
    @Override // b.i.a.c.x2.Extractor
    public int e(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException {
        int i;
        char c;
        boolean z2;
        boolean z3;
        long j;
        long jB;
        Atom.a aVarPeek;
        long j2;
        int i2;
        int i3;
        boolean z4;
        boolean z5;
        long j3;
        long j4;
        boolean z6;
        boolean z7;
        boolean z8;
        long j5;
        long j6;
        long j7;
        ParsableByteArray parsableByteArray;
        int i4;
        while (true) {
            int i5 = this.j;
            int i6 = 4;
            int i7 = 2;
            if (i5 == 0) {
                if (this.m != 0) {
                    j = this.l;
                    if (j == 1) {
                        extractorInput.readFully(this.f.a, 8, 8);
                        this.m += 8;
                        this.l = this.f.x();
                    } else if (j == 0) {
                        jB = extractorInput.b();
                        if (jB == -1 && (aVarPeek = this.g.peek()) != null) {
                            jB = aVarPeek.f1209b;
                        }
                        if (jB != -1) {
                            this.l = (jB - extractorInput.getPosition()) + ((long) this.m);
                        }
                    }
                    j2 = this.l;
                    i2 = this.m;
                    if (j2 >= i2) {
                        throw ParserException.b("Atom size less than header length (unsupported).");
                    }
                    i3 = this.k;
                    if (i3 != 1836019574 || i3 == 1953653099 || i3 == 1835297121 || i3 == 1835626086 || i3 == 1937007212 || i3 == 1701082227 || i3 == 1835365473) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    if (z4) {
                        long position = extractorInput.getPosition();
                        j5 = this.l;
                        j6 = this.m;
                        j7 = (position + j5) - j6;
                        if (j5 != j6 && this.k == 1835365473) {
                            this.e.A(8);
                            extractorInput.o(this.e.a, 0, 8);
                            parsableByteArray = this.e;
                            byte[] bArr = AtomParsers.a;
                            i4 = parsableByteArray.f984b;
                            parsableByteArray.F(4);
                            if (parsableByteArray.f() != 1751411826) {
                                i4 += 4;
                            }
                            parsableByteArray.E(i4);
                            extractorInput.l(this.e.f984b);
                            extractorInput.k();
                        }
                        this.g.push(new Atom.a(this.k, j7));
                        if (this.l == this.m) {
                            l(j7);
                        } else {
                            j();
                        }
                    } else {
                        if (i3 != 1835296868 || i3 == 1836476516 || i3 == 1751411826 || i3 == 1937011556 || i3 == 1937011827 || i3 == 1937011571 || i3 == 1668576371 || i3 == 1701606260 || i3 == 1937011555 || i3 == 1937011578 || i3 == 1937013298 || i3 == 1937007471 || i3 == 1668232756 || i3 == 1953196132 || i3 == 1718909296 || i3 == 1969517665 || i3 == 1801812339 || i3 == 1768715124) {
                            z5 = true;
                        } else {
                            z5 = false;
                        }
                        if (z5) {
                            if (i2 == 8) {
                                z6 = true;
                            } else {
                                z6 = false;
                            }
                            AnimatableValueParser.D(z6);
                            if (this.l <= 2147483647L) {
                                z7 = true;
                            } else {
                                z7 = false;
                            }
                            AnimatableValueParser.D(z7);
                            ParsableByteArray parsableByteArray2 = new ParsableByteArray((int) this.l);
                            System.arraycopy(this.f.a, 0, parsableByteArray2.a, 0, 8);
                            this.n = parsableByteArray2;
                            this.j = 1;
                        } else {
                            long position2 = extractorInput.getPosition();
                            j3 = this.m;
                            j4 = position2 - j3;
                            if (this.k == 1836086884) {
                                this.f1225y = new MotionPhotoMetadata(0L, j4, -9223372036854775807L, j4 + j3, this.l - j3);
                            }
                            this.n = null;
                            this.j = 1;
                        }
                    }
                    z8 = true;
                } else if (extractorInput.c(this.f.a, 0, 8, true)) {
                    this.m = 8;
                    this.f.E(0);
                    this.l = this.f.u();
                    this.k = this.f.f();
                    j = this.l;
                    if (j == 1) {
                        extractorInput.readFully(this.f.a, 8, 8);
                        this.m += 8;
                        this.l = this.f.x();
                    } else if (j == 0) {
                        jB = extractorInput.b();
                        if (jB == -1) {
                            jB = aVarPeek.f1209b;
                        }
                        if (jB != -1) {
                            this.l = (jB - extractorInput.getPosition()) + ((long) this.m);
                        }
                    }
                    j2 = this.l;
                    i2 = this.m;
                    if (j2 >= i2) {
                        throw ParserException.b("Atom size less than header length (unsupported).");
                    }
                    i3 = this.k;
                    if (i3 != 1836019574) {
                        z4 = true;
                    } else {
                        z4 = true;
                    }
                    if (z4) {
                        long position3 = extractorInput.getPosition();
                        j5 = this.l;
                        j6 = this.m;
                        j7 = (position3 + j5) - j6;
                        if (j5 != j6) {
                            this.e.A(8);
                            extractorInput.o(this.e.a, 0, 8);
                            parsableByteArray = this.e;
                            byte[] bArr2 = AtomParsers.a;
                            i4 = parsableByteArray.f984b;
                            parsableByteArray.F(4);
                            if (parsableByteArray.f() != 1751411826) {
                                i4 += 4;
                            }
                            parsableByteArray.E(i4);
                            extractorInput.l(this.e.f984b);
                            extractorInput.k();
                        }
                        this.g.push(new Atom.a(this.k, j7));
                        if (this.l == this.m) {
                            l(j7);
                        } else {
                            j();
                        }
                    } else {
                        if (i3 != 1835296868) {
                            z5 = true;
                        } else {
                            z5 = true;
                        }
                        if (z5) {
                            if (i2 == 8) {
                                z6 = true;
                            } else {
                                z6 = false;
                            }
                            AnimatableValueParser.D(z6);
                            if (this.l <= 2147483647L) {
                                z7 = true;
                            } else {
                                z7 = false;
                            }
                            AnimatableValueParser.D(z7);
                            ParsableByteArray parsableByteArray3 = new ParsableByteArray((int) this.l);
                            System.arraycopy(this.f.a, 0, parsableByteArray3.a, 0, 8);
                            this.n = parsableByteArray3;
                            this.j = 1;
                        } else {
                            long position4 = extractorInput.getPosition();
                            j3 = this.m;
                            j4 = position4 - j3;
                            if (this.k == 1836086884) {
                                this.f1225y = new MotionPhotoMetadata(0L, j4, -9223372036854775807L, j4 + j3, this.l - j3);
                            }
                            this.n = null;
                            this.j = 1;
                        }
                    }
                    z8 = true;
                } else {
                    if (this.f1224x == 2 && (this.f1222b & 2) != 0) {
                        ExtractorOutput extractorOutput = this.f1223s;
                        Objects.requireNonNull(extractorOutput);
                        TrackOutput2 trackOutput2P = extractorOutput.p(0, 4);
                        MotionPhotoMetadata motionPhotoMetadata = this.f1225y;
                        Metadata metadata = motionPhotoMetadata == null ? null : new Metadata(motionPhotoMetadata);
                        Format2.b bVar = new Format2.b();
                        bVar.i = metadata;
                        trackOutput2P.e(bVar.a());
                        extractorOutput.j();
                        extractorOutput.a(new SeekMap.b(-9223372036854775807L, 0L));
                    }
                    z8 = false;
                }
                if (!z8) {
                    return -1;
                }
            } else {
                if (i5 != 1) {
                    if (i5 == 2) {
                        long position5 = extractorInput.getPosition();
                        if (this.o == -1) {
                            int i8 = -1;
                            boolean z9 = true;
                            int i9 = -1;
                            int i10 = 0;
                            long j8 = RecyclerView.FOREVER_NS;
                            boolean z10 = true;
                            long j9 = RecyclerView.FOREVER_NS;
                            long j10 = RecyclerView.FOREVER_NS;
                            while (true) {
                                a[] aVarArr = this.t;
                                int i11 = Util2.a;
                                if (i10 >= aVarArr.length) {
                                    break;
                                }
                                a aVar = aVarArr[i10];
                                int i12 = aVar.e;
                                TrackSampleTable trackSampleTable = aVar.f1226b;
                                if (i12 != trackSampleTable.f1233b) {
                                    long j11 = trackSampleTable.c[i12];
                                    long j12 = this.u[i10][i12];
                                    long j13 = j11 - position5;
                                    boolean z11 = j13 < 0 || j13 >= Permission.USE_EXTERNAL_EMOJIS;
                                    if ((!z11 && z9) || (z11 == z9 && j13 < j10)) {
                                        z9 = z11;
                                        j10 = j13;
                                        i9 = i10;
                                        j9 = j12;
                                    }
                                    if (j12 < j8) {
                                        z10 = z11;
                                        i8 = i10;
                                        j8 = j12;
                                    }
                                }
                                i10++;
                            }
                            if (j8 == RecyclerView.FOREVER_NS || !z10 || j9 < j8 + 10485760) {
                                i8 = i9;
                            }
                            this.o = i8;
                            if (i8 == -1) {
                                return -1;
                            }
                        }
                        a[] aVarArr2 = this.t;
                        int i13 = Util2.a;
                        a aVar2 = aVarArr2[this.o];
                        TrackOutput2 trackOutput2 = aVar2.c;
                        int i14 = aVar2.e;
                        TrackSampleTable trackSampleTable2 = aVar2.f1226b;
                        long j14 = trackSampleTable2.c[i14];
                        int i15 = trackSampleTable2.d[i14];
                        TrueHdSampleRechunker trueHdSampleRechunker = aVar2.d;
                        long j15 = (j14 - position5) + ((long) this.p);
                        if (j15 < 0 || j15 >= Permission.USE_EXTERNAL_EMOJIS) {
                            positionHolder.a = j14;
                            return 1;
                        }
                        if (aVar2.a.g == 1) {
                            j15 += 8;
                            i15 -= 8;
                        }
                        extractorInput.l((int) j15);
                        Track track = aVar2.a;
                        int i16 = track.j;
                        if (i16 == 0) {
                            if ("audio/ac4".equals(track.f.w)) {
                                if (this.q == 0) {
                                    Ac4Util.a(i15, this.e);
                                    trackOutput2.c(this.e, 7);
                                    this.q += 7;
                                }
                                i15 += 7;
                            } else if (trueHdSampleRechunker != null) {
                                trueHdSampleRechunker.c(extractorInput);
                            }
                            while (true) {
                                int i17 = this.q;
                                if (i17 >= i15) {
                                    break;
                                }
                                int iB = trackOutput2.b(extractorInput, i15 - i17, false);
                                this.p += iB;
                                this.q += iB;
                                this.r -= iB;
                            }
                        } else {
                            byte[] bArr3 = this.d.a;
                            bArr3[0] = 0;
                            bArr3[1] = 0;
                            bArr3[2] = 0;
                            int i18 = 4 - i16;
                            while (this.q < i15) {
                                int i19 = this.r;
                                if (i19 == 0) {
                                    extractorInput.readFully(bArr3, i18, i16);
                                    this.p += i16;
                                    this.d.E(0);
                                    int iF = this.d.f();
                                    if (iF < 0) {
                                        throw ParserException.a("Invalid NAL length", null);
                                    }
                                    this.r = iF;
                                    this.c.E(0);
                                    trackOutput2.c(this.c, 4);
                                    this.q += 4;
                                    i15 += i18;
                                } else {
                                    int iB2 = trackOutput2.b(extractorInput, i19, false);
                                    this.p += iB2;
                                    this.q += iB2;
                                    this.r -= iB2;
                                }
                            }
                        }
                        int i20 = i15;
                        TrackSampleTable trackSampleTable3 = aVar2.f1226b;
                        long j16 = trackSampleTable3.f[i14];
                        int i21 = trackSampleTable3.g[i14];
                        if (trueHdSampleRechunker != null) {
                            trueHdSampleRechunker.b(trackOutput2, j16, i21, i20, 0, null);
                            if (i14 + 1 == aVar2.f1226b.f1233b) {
                                trueHdSampleRechunker.a(trackOutput2, null);
                            }
                        } else {
                            trackOutput2.d(j16, i21, i20, 0, null);
                        }
                        aVar2.e++;
                        this.o = -1;
                        this.p = 0;
                        this.q = 0;
                        this.r = 0;
                        return 0;
                    }
                    if (i5 != 3) {
                        throw new IllegalStateException();
                    }
                    SefReader sefReader = this.h;
                    List<Metadata.Entry> list = this.i;
                    int i22 = sefReader.d;
                    if (i22 == 0) {
                        long jB2 = extractorInput.b();
                        positionHolder.a = (jB2 == -1 || jB2 < 8) ? 0L : jB2 - 8;
                        sefReader.d = 1;
                    } else if (i22 != 1) {
                        short s2 = 2819;
                        if (i22 == 2) {
                            long jB3 = extractorInput.b();
                            int i23 = (sefReader.e - 12) - 8;
                            ParsableByteArray parsableByteArray4 = new ParsableByteArray(i23);
                            extractorInput.readFully(parsableByteArray4.a, 0, i23);
                            int i24 = 0;
                            while (i24 < i23 / 12) {
                                parsableByteArray4.F(i7);
                                short sI = parsableByteArray4.i();
                                if (sI == 2192 || sI == 2816 || sI == 2817 || sI == s2 || sI == 2820) {
                                    sefReader.c.add(new SefReader.a(sI, (jB3 - ((long) sefReader.e)) - ((long) parsableByteArray4.h()), parsableByteArray4.h()));
                                } else {
                                    parsableByteArray4.F(8);
                                }
                                i24++;
                                s2 = 2819;
                                i7 = 2;
                            }
                            if (sefReader.c.isEmpty()) {
                                positionHolder.a = 0L;
                            } else {
                                sefReader.d = 3;
                                positionHolder.a = sefReader.c.get(0).a;
                            }
                        } else {
                            if (i22 != 3) {
                                throw new IllegalStateException();
                            }
                            long position6 = extractorInput.getPosition();
                            int iB3 = (int) ((extractorInput.b() - extractorInput.getPosition()) - ((long) sefReader.e));
                            ParsableByteArray parsableByteArray5 = new ParsableByteArray(iB3);
                            extractorInput.readFully(parsableByteArray5.a, 0, iB3);
                            int i25 = 0;
                            while (i25 < sefReader.c.size()) {
                                SefReader.a aVar3 = sefReader.c.get(i25);
                                List<Metadata.Entry> list2 = list;
                                parsableByteArray5.E((int) (aVar3.a - position6));
                                parsableByteArray5.F(i6);
                                int iH = parsableByteArray5.h();
                                switch (parsableByteArray5.q(iH)) {
                                    case "SlowMotion_Data":
                                        i = 0;
                                        break;
                                    case "Super_SlowMotion_Edit_Data":
                                        i = 1;
                                        break;
                                    case "Super_SlowMotion_Data":
                                        i = 2;
                                        break;
                                    case "Super_SlowMotion_Deflickering_On":
                                        i = 3;
                                        break;
                                    case "Super_SlowMotion_BGM":
                                        i = 4;
                                        break;
                                    default:
                                        i = -1;
                                        break;
                                }
                                if (i == 0) {
                                    c = 2192;
                                } else if (i == 1) {
                                    c = 2819;
                                } else if (i == 2) {
                                    c = 2816;
                                } else if (i == 3) {
                                    c = 2820;
                                } else {
                                    if (i != i6) {
                                        throw ParserException.a("Invalid SEF name", null);
                                    }
                                    c = 2817;
                                }
                                int i26 = aVar3.f1229b - (iH + 8);
                                if (c == 2192) {
                                    ArrayList arrayList = new ArrayList();
                                    List<String> listA = SefReader.f1228b.a(parsableByteArray5.q(i26));
                                    for (int i27 = 0; i27 < listA.size(); i27++) {
                                        List<String> listA2 = SefReader.a.a(listA.get(i27));
                                        if (listA2.size() != 3) {
                                            throw ParserException.a(null, null);
                                        }
                                        try {
                                            arrayList.add(new SlowMotionData.Segment(Long.parseLong(listA2.get(0)), Long.parseLong(listA2.get(1)), 1 << (Integer.parseInt(listA2.get(2)) - 1)));
                                        } catch (NumberFormatException e) {
                                            throw ParserException.a(null, e);
                                        }
                                    }
                                    list2.add(new SlowMotionData(arrayList));
                                } else if (c != 2816 && c != 2817 && c != 2819 && c != 2820) {
                                    throw new IllegalStateException();
                                }
                                i25++;
                                list = list2;
                                i6 = 4;
                            }
                            positionHolder.a = 0L;
                        }
                    } else {
                        byte[] bArr4 = new byte[8];
                        extractorInput.readFully(bArr4, 0, 8);
                        sefReader.e = ((bArr4[0] & 255) | ((bArr4[1] & 255) << 8) | ((bArr4[2] & 255) << 16) | ((bArr4[3] & 255) << 24)) + 8;
                        if (((bArr4[7] & 255) | ((bArr4[5] & 255) << 16) | ((bArr4[4] & 255) << 24) | ((bArr4[6] & 255) << 8)) != 1397048916) {
                            positionHolder.a = 0L;
                        } else {
                            positionHolder.a = extractorInput.getPosition() - ((long) (sefReader.e - 12));
                            sefReader.d = 2;
                        }
                    }
                    if (positionHolder.a == 0) {
                        j();
                    }
                    return 1;
                }
                long j17 = this.l - ((long) this.m);
                long position7 = extractorInput.getPosition() + j17;
                ParsableByteArray parsableByteArray6 = this.n;
                if (parsableByteArray6 != null) {
                    extractorInput.readFully(parsableByteArray6.a, this.m, (int) j17);
                    if (this.k == 1718909296) {
                        parsableByteArray6.E(8);
                        int iF2 = parsableByteArray6.f();
                        int i28 = iF2 != 1751476579 ? iF2 != 1903435808 ? 0 : 1 : 2;
                        if (i28 == 0) {
                            parsableByteArray6.F(4);
                            do {
                                if (parsableByteArray6.a() <= 0) {
                                    i28 = 0;
                                    break;
                                }
                                int iF3 = parsableByteArray6.f();
                                i28 = iF3 != 1751476579 ? iF3 != 1903435808 ? 0 : 1 : 2;
                            } while (i28 == 0);
                        }
                        this.f1224x = i28;
                    } else if (!this.g.isEmpty()) {
                        this.g.peek().c.add(new Atom.b(this.k, parsableByteArray6));
                    }
                } else {
                    if (j17 < Permission.USE_EXTERNAL_EMOJIS) {
                        extractorInput.l((int) j17);
                    } else {
                        positionHolder.a = extractorInput.getPosition() + j17;
                        z2 = true;
                    }
                    l(position7);
                    if (z2 || this.j == 2) {
                        z3 = false;
                    } else {
                        z3 = true;
                    }
                    if (z3) {
                        return 1;
                    }
                }
                z2 = false;
                l(position7);
                if (z2) {
                    z3 = false;
                } else {
                    z3 = false;
                }
                if (z3) {
                    return 1;
                }
            }
        }
    }

    @Override // b.i.a.c.x2.Extractor
    public void f(ExtractorOutput extractorOutput) {
        this.f1223s = extractorOutput;
    }

    @Override // b.i.a.c.x2.Extractor
    public void g(long j, long j2) {
        this.g.clear();
        this.m = 0;
        this.o = -1;
        this.p = 0;
        this.q = 0;
        this.r = 0;
        if (j == 0) {
            if (this.j != 3) {
                j();
                return;
            }
            SefReader sefReader = this.h;
            sefReader.c.clear();
            sefReader.d = 0;
            this.i.clear();
            return;
        }
        a[] aVarArr = this.t;
        if (aVarArr != null) {
            for (a aVar : aVarArr) {
                TrackSampleTable trackSampleTable = aVar.f1226b;
                int iA = trackSampleTable.a(j2);
                if (iA == -1) {
                    iA = trackSampleTable.b(j2);
                }
                aVar.e = iA;
                TrueHdSampleRechunker trueHdSampleRechunker = aVar.d;
                if (trueHdSampleRechunker != null) {
                    trueHdSampleRechunker.f1300b = false;
                    trueHdSampleRechunker.c = 0;
                }
            }
        }
    }

    @Override // b.i.a.c.x2.SeekMap
    public SeekMap.a h(long j) {
        long j2;
        long jK;
        long j3;
        long j4;
        int iB;
        long j5 = j;
        a[] aVarArr = this.t;
        Objects.requireNonNull(aVarArr);
        if (aVarArr.length == 0) {
            return new SeekMap.a(SeekPoint.a);
        }
        long j6 = -1;
        int i = this.v;
        if (i != -1) {
            TrackSampleTable trackSampleTable = this.t[i].f1226b;
            int iA = trackSampleTable.a(j5);
            if (iA == -1) {
                iA = trackSampleTable.b(j5);
            }
            if (iA == -1) {
                return new SeekMap.a(SeekPoint.a);
            }
            long j7 = trackSampleTable.f[iA];
            j2 = trackSampleTable.c[iA];
            if (j7 >= j5 || iA >= trackSampleTable.f1233b - 1 || (iB = trackSampleTable.b(j5)) == -1 || iB == iA) {
                j4 = -9223372036854775807L;
            } else {
                long j8 = trackSampleTable.f[iB];
                long j9 = trackSampleTable.c[iB];
                j4 = j8;
                j6 = j9;
            }
            jK = j6;
            j3 = j4;
            j5 = j7;
        } else {
            j2 = RecyclerView.FOREVER_NS;
            jK = -1;
            j3 = -9223372036854775807L;
        }
        int i2 = 0;
        while (true) {
            a[] aVarArr2 = this.t;
            if (i2 >= aVarArr2.length) {
                break;
            }
            if (i2 != this.v) {
                TrackSampleTable trackSampleTable2 = aVarArr2[i2].f1226b;
                long jK2 = k(trackSampleTable2, j5, j2);
                if (j3 != -9223372036854775807L) {
                    jK = k(trackSampleTable2, j3, jK);
                }
                j2 = jK2;
            }
            i2++;
        }
        SeekPoint seekPoint = new SeekPoint(j5, j2);
        return j3 == -9223372036854775807L ? new SeekMap.a(seekPoint) : new SeekMap.a(seekPoint, new SeekPoint(j3, jK));
    }

    @Override // b.i.a.c.x2.SeekMap
    public long i() {
        return this.w;
    }

    public final void j() {
        this.j = 0;
        this.m = 0;
    }

    /* JADX WARN: Code duplicated, block: B:155:0x02a8 A[Catch: all -> 0x022a, TryCatch #0 {all -> 0x022a, blocks: (B:38:0x00cb, B:40:0x00d1, B:42:0x00d6, B:45:0x00de, B:46:0x00e5, B:49:0x00f3, B:52:0x0100, B:55:0x010d, B:58:0x011d, B:61:0x012a, B:64:0x0135, B:67:0x0142, B:70:0x014e, B:73:0x015a, B:76:0x0166, B:79:0x0172, B:82:0x017e, B:85:0x018c, B:88:0x0199, B:91:0x01a5, B:96:0x01b7, B:98:0x01bb, B:100:0x01d0, B:103:0x01dd, B:107:0x01ec, B:115:0x01ff, B:153:0x0298, B:155:0x02a8, B:157:0x02b2, B:156:0x02ad, B:117:0x0219, B:119:0x0224, B:134:0x024a, B:137:0x0257, B:140:0x0263, B:143:0x026f, B:146:0x027b, B:149:0x0287, B:152:0x0291, B:159:0x02b7, B:160:0x02be), top: B:343:0x00cb }] */
    /* JADX WARN: Code duplicated, block: B:156:0x02ad A[Catch: all -> 0x022a, TryCatch #0 {all -> 0x022a, blocks: (B:38:0x00cb, B:40:0x00d1, B:42:0x00d6, B:45:0x00de, B:46:0x00e5, B:49:0x00f3, B:52:0x0100, B:55:0x010d, B:58:0x011d, B:61:0x012a, B:64:0x0135, B:67:0x0142, B:70:0x014e, B:73:0x015a, B:76:0x0166, B:79:0x0172, B:82:0x017e, B:85:0x018c, B:88:0x0199, B:91:0x01a5, B:96:0x01b7, B:98:0x01bb, B:100:0x01d0, B:103:0x01dd, B:107:0x01ec, B:115:0x01ff, B:153:0x0298, B:155:0x02a8, B:157:0x02b2, B:156:0x02ad, B:117:0x0219, B:119:0x0224, B:134:0x024a, B:137:0x0257, B:140:0x0263, B:143:0x026f, B:146:0x027b, B:149:0x0287, B:152:0x0291, B:159:0x02b7, B:160:0x02be), top: B:343:0x00cb }] */
    /* JADX WARN: Code duplicated, block: B:236:0x0494  */
    /* JADX WARN: Code duplicated, block: B:294:0x05ac  */
    /* JADX WARN: Code duplicated, block: B:43:0x00db  */
    public final void l(long j) throws ParserException {
        ArrayList arrayList;
        boolean z2;
        Metadata metadata;
        int i;
        Metadata metadata2;
        Metadata metadata3;
        Metadata metadata4;
        Metadata metadata5;
        int i2;
        ArrayList arrayList2;
        int i3;
        int i4;
        MdtaMetadataEntry mdtaMetadataEntry;
        ArrayList arrayList3;
        boolean z3;
        Metadata metadata6;
        boolean z4;
        Id3Frame id3FrameD;
        String strValueOf;
        String str;
        String str2;
        while (!this.g.isEmpty() && this.g.peek().f1209b == j) {
            Atom.a aVarPop = this.g.pop();
            if (aVarPop.a == 1836019574) {
                ArrayList arrayList4 = new ArrayList();
                boolean z5 = this.f1224x == 1;
                GaplessInfoHolder gaplessInfoHolder = new GaplessInfoHolder();
                Atom.b bVarC = aVarPop.c(1969517665);
                int i5 = 1768715124;
                int i6 = 1751411826;
                int i7 = 1835365473;
                int i8 = 4;
                int i9 = 8;
                Metadata metadata7 = null;
                if (bVarC != null) {
                    byte[] bArr = AtomParsers.a;
                    ParsableByteArray parsableByteArray = bVarC.f1210b;
                    parsableByteArray.E(8);
                    Metadata metadata8 = null;
                    String strO = null;
                    while (parsableByteArray.a() >= i9) {
                        int i10 = parsableByteArray.f984b;
                        int iF = parsableByteArray.f();
                        int i11 = i5;
                        int iF2 = parsableByteArray.f();
                        if (iF2 == i7) {
                            parsableByteArray.E(i10);
                            int i12 = i10 + iF;
                            parsableByteArray.F(i9);
                            int i13 = parsableByteArray.f984b;
                            parsableByteArray.F(i8);
                            if (parsableByteArray.f() != i6) {
                                i13 += 4;
                            }
                            parsableByteArray.E(i13);
                            int i14 = i11;
                            while (true) {
                                int i15 = parsableByteArray.f984b;
                                if (i15 < i12) {
                                    int iF3 = parsableByteArray.f();
                                    if (parsableByteArray.f() == i14) {
                                        parsableByteArray.E(i15);
                                        int i16 = i15 + iF3;
                                        parsableByteArray.F(i9);
                                        ArrayList arrayList5 = new ArrayList();
                                        while (true) {
                                            int i17 = parsableByteArray.f984b;
                                            if (i17 >= i16) {
                                                break;
                                            }
                                            int iF4 = parsableByteArray.f() + i17;
                                            int iF5 = parsableByteArray.f();
                                            int i18 = (iF5 >> 24) & 255;
                                            int i19 = i16;
                                            ArrayList arrayList6 = arrayList4;
                                            if (i18 == 169 || i18 == 253) {
                                                z4 = z5;
                                                int i20 = 16777215 & iF5;
                                                if (i20 == 6516084) {
                                                    id3FrameD = MetadataUtil.a(iF5, parsableByteArray);
                                                } else if (i20 == 7233901 || i20 == 7631467) {
                                                    id3FrameD = MetadataUtil.d(iF5, "TIT2", parsableByteArray);
                                                } else if (i20 == 6516589 || i20 == 7828084) {
                                                    id3FrameD = MetadataUtil.d(iF5, "TCOM", parsableByteArray);
                                                } else if (i20 == 6578553) {
                                                    id3FrameD = MetadataUtil.d(iF5, "TDRC", parsableByteArray);
                                                } else if (i20 == 4280916) {
                                                    id3FrameD = MetadataUtil.d(iF5, "TPE1", parsableByteArray);
                                                } else if (i20 == 7630703) {
                                                    id3FrameD = MetadataUtil.d(iF5, "TSSE", parsableByteArray);
                                                } else if (i20 == 6384738) {
                                                    id3FrameD = MetadataUtil.d(iF5, "TALB", parsableByteArray);
                                                } else if (i20 == 7108978) {
                                                    id3FrameD = MetadataUtil.d(iF5, "USLT", parsableByteArray);
                                                } else if (i20 == 6776174) {
                                                    id3FrameD = MetadataUtil.d(iF5, "TCON", parsableByteArray);
                                                } else if (i20 == 6779504) {
                                                    id3FrameD = MetadataUtil.d(iF5, "TIT1", parsableByteArray);
                                                } else {
                                                    strValueOf = String.valueOf(Atom.a(iF5));
                                                    if (strValueOf.length() != 0) {
                                                        str = "Skipped unknown metadata entry: ".concat(strValueOf);
                                                    } else {
                                                        str = new String("Skipped unknown metadata entry: ");
                                                    }
                                                    Log.d("MetadataUtil", str);
                                                    id3FrameD = null;
                                                }
                                            } else if (iF5 == 1735291493) {
                                                try {
                                                    int iF6 = MetadataUtil.f(parsableByteArray);
                                                    if (iF6 > 0) {
                                                        String[] strArr = MetadataUtil.a;
                                                        if (iF6 <= strArr.length) {
                                                            str2 = strArr[iF6 - 1];
                                                        } else {
                                                            str2 = strO;
                                                        }
                                                    } else {
                                                        str2 = strO;
                                                    }
                                                    if (str2 != null) {
                                                        id3FrameD = new TextInformationFrame("TCON", strO, str2);
                                                        z4 = z5;
                                                    } else {
                                                        Log.w("MetadataUtil", "Failed to parse standard genre code");
                                                        z4 = z5;
                                                        id3FrameD = null;
                                                    }
                                                } catch (Throwable th) {
                                                    parsableByteArray.E(iF4);
                                                    throw th;
                                                }
                                            } else {
                                                if (iF5 == 1684632427) {
                                                    id3FrameD = MetadataUtil.c(iF5, "TPOS", parsableByteArray);
                                                } else if (iF5 == 1953655662) {
                                                    id3FrameD = MetadataUtil.c(iF5, "TRCK", parsableByteArray);
                                                } else if (iF5 == 1953329263) {
                                                    id3FrameD = MetadataUtil.e(iF5, "TBPM", parsableByteArray, true, false);
                                                } else if (iF5 == 1668311404) {
                                                    id3FrameD = MetadataUtil.e(iF5, "TCMP", parsableByteArray, true, true);
                                                } else if (iF5 == 1668249202) {
                                                    id3FrameD = MetadataUtil.b(parsableByteArray);
                                                } else if (iF5 == 1631670868) {
                                                    id3FrameD = MetadataUtil.d(iF5, "TPE2", parsableByteArray);
                                                } else if (iF5 == 1936682605) {
                                                    id3FrameD = MetadataUtil.d(iF5, "TSOT", parsableByteArray);
                                                } else if (iF5 == 1936679276) {
                                                    id3FrameD = MetadataUtil.d(iF5, "TSO2", parsableByteArray);
                                                } else if (iF5 == 1936679282) {
                                                    id3FrameD = MetadataUtil.d(iF5, "TSOA", parsableByteArray);
                                                } else if (iF5 == 1936679265) {
                                                    id3FrameD = MetadataUtil.d(iF5, "TSOP", parsableByteArray);
                                                } else if (iF5 == 1936679791) {
                                                    id3FrameD = MetadataUtil.d(iF5, "TSOC", parsableByteArray);
                                                } else if (iF5 == 1920233063) {
                                                    id3FrameD = MetadataUtil.e(iF5, "ITUNESADVISORY", parsableByteArray, false, false);
                                                } else if (iF5 == 1885823344) {
                                                    id3FrameD = MetadataUtil.e(iF5, "ITUNESGAPLESS", parsableByteArray, false, true);
                                                } else if (iF5 == 1936683886) {
                                                    id3FrameD = MetadataUtil.d(iF5, "TVSHOWSORT", parsableByteArray);
                                                } else if (iF5 == 1953919848) {
                                                    id3FrameD = MetadataUtil.d(iF5, "TVSHOW", parsableByteArray);
                                                } else if (iF5 == 757935405) {
                                                    int i21 = -1;
                                                    int i22 = -1;
                                                    String strO2 = strO;
                                                    while (true) {
                                                        int i23 = parsableByteArray.f984b;
                                                        if (i23 >= iF4) {
                                                            break;
                                                        }
                                                        int iF7 = parsableByteArray.f();
                                                        int iF8 = parsableByteArray.f();
                                                        boolean z6 = z5;
                                                        parsableByteArray.F(4);
                                                        if (iF8 == 1835360622) {
                                                            strO = parsableByteArray.o(iF7 - 12);
                                                        } else if (iF8 == 1851878757) {
                                                            strO2 = parsableByteArray.o(iF7 - 12);
                                                        } else {
                                                            if (iF8 == 1684108385) {
                                                                i22 = iF7;
                                                                i21 = i23;
                                                            }
                                                            parsableByteArray.F(iF7 - 12);
                                                        }
                                                        z5 = z6;
                                                    }
                                                    z4 = z5;
                                                    if (strO == null || strO2 == null || i21 == -1) {
                                                        id3FrameD = null;
                                                    } else {
                                                        parsableByteArray.E(i21);
                                                        parsableByteArray.F(16);
                                                        id3FrameD = new InternalFrame(strO, strO2, parsableByteArray.o(i22 - 16));
                                                    }
                                                } else {
                                                    z4 = z5;
                                                    strValueOf = String.valueOf(Atom.a(iF5));
                                                    if (strValueOf.length() != 0) {
                                                        str = "Skipped unknown metadata entry: ".concat(strValueOf);
                                                    } else {
                                                        str = new String("Skipped unknown metadata entry: ");
                                                    }
                                                    Log.d("MetadataUtil", str);
                                                    id3FrameD = null;
                                                }
                                                z4 = z5;
                                            }
                                            parsableByteArray.E(iF4);
                                            if (id3FrameD != null) {
                                                arrayList5.add(id3FrameD);
                                            }
                                            strO = null;
                                            i16 = i19;
                                            arrayList4 = arrayList6;
                                            z5 = z4;
                                        }
                                        arrayList3 = arrayList4;
                                        z3 = z5;
                                        if (!arrayList5.isEmpty()) {
                                            metadata6 = new Metadata(arrayList5);
                                            break;
                                        }
                                        break;
                                    }
                                    parsableByteArray.E(i15 + iF3);
                                    i9 = 8;
                                    i14 = 1768715124;
                                    strO = null;
                                } else {
                                    arrayList3 = arrayList4;
                                    z3 = z5;
                                }
                                metadata6 = null;
                                break;
                            }
                            metadata7 = metadata6;
                        } else {
                            arrayList3 = arrayList4;
                            z3 = z5;
                            if (iF2 == 1936553057) {
                                parsableByteArray.E(i10);
                                int i24 = i10 + iF;
                                parsableByteArray.F(12);
                                while (true) {
                                    int i25 = parsableByteArray.f984b;
                                    if (i25 < i24) {
                                        int iF9 = parsableByteArray.f();
                                        if (parsableByteArray.f() != 1935766900) {
                                            parsableByteArray.E(i25 + iF9);
                                        } else if (iF9 >= 14) {
                                            parsableByteArray.F(5);
                                            int iT = parsableByteArray.t();
                                            if (iT == 12 || iT == 13) {
                                                float f = iT == 12 ? 240.0f : 120.0f;
                                                parsableByteArray.F(1);
                                                metadata8 = new Metadata(new SmtaMetadataEntry(f, parsableByteArray.t()));
                                                break;
                                            }
                                        }
                                    }
                                    metadata8 = null;
                                    break;
                                }
                            }
                        }
                        parsableByteArray.E(i10 + iF);
                        i9 = 8;
                        i5 = 1768715124;
                        i6 = 1751411826;
                        i7 = 1835365473;
                        strO = null;
                        i8 = 4;
                        arrayList4 = arrayList3;
                        z5 = z3;
                    }
                    arrayList = arrayList4;
                    z2 = z5;
                    Pair pairCreate = Pair.create(metadata7, metadata8);
                    metadata2 = (Metadata) pairCreate.first;
                    metadata = (Metadata) pairCreate.second;
                    if (metadata2 != null) {
                        gaplessInfoHolder.b(metadata2);
                    }
                    i = 1835365473;
                } else {
                    arrayList = arrayList4;
                    z2 = z5;
                    metadata = null;
                    i = 1835365473;
                    metadata2 = null;
                }
                Metadata metadata9 = metadata2;
                Atom.a aVarB = aVarPop.b(i);
                if (aVarB != null) {
                    byte[] bArr2 = AtomParsers.a;
                    Atom.b bVarC2 = aVarB.c(1751411826);
                    Atom.b bVarC3 = aVarB.c(1801812339);
                    Atom.b bVarC4 = aVarB.c(1768715124);
                    if (bVarC2 == null || bVarC3 == null || bVarC4 == null) {
                        metadata3 = metadata9;
                        metadata4 = null;
                    } else {
                        ParsableByteArray parsableByteArray2 = bVarC2.f1210b;
                        parsableByteArray2.E(16);
                        if (parsableByteArray2.f() != 1835299937) {
                            metadata3 = metadata9;
                        } else {
                            ParsableByteArray parsableByteArray3 = bVarC3.f1210b;
                            parsableByteArray3.E(12);
                            int iF10 = parsableByteArray3.f();
                            String[] strArr2 = new String[iF10];
                            for (int i26 = 0; i26 < iF10; i26++) {
                                int iF11 = parsableByteArray3.f();
                                parsableByteArray3.F(4);
                                strArr2[i26] = parsableByteArray3.q(iF11 - 8);
                            }
                            int i27 = 8;
                            ParsableByteArray parsableByteArray4 = bVarC4.f1210b;
                            parsableByteArray4.E(8);
                            ArrayList arrayList7 = new ArrayList();
                            while (parsableByteArray4.a() > i27) {
                                int i28 = parsableByteArray4.f984b;
                                int iF12 = parsableByteArray4.f();
                                int iF13 = parsableByteArray4.f() - 1;
                                if (iF13 < 0 || iF13 >= iF10) {
                                    i4 = iF10;
                                    strArr2 = strArr2;
                                    metadata9 = metadata9;
                                    outline.g0(52, "Skipped metadata with unknown key index: ", iF13, "AtomParsers");
                                } else {
                                    String str3 = strArr2[iF13];
                                    int i29 = i28 + iF12;
                                    while (true) {
                                        int i30 = parsableByteArray4.f984b;
                                        if (i30 >= i29) {
                                            i4 = iF10;
                                            mdtaMetadataEntry = null;
                                            break;
                                        }
                                        int iF14 = parsableByteArray4.f();
                                        i4 = iF10;
                                        if (parsableByteArray4.f() == 1684108385) {
                                            int iF15 = parsableByteArray4.f();
                                            int iF16 = parsableByteArray4.f();
                                            int i31 = iF14 - 16;
                                            byte[] bArr3 = new byte[i31];
                                            System.arraycopy(parsableByteArray4.a, parsableByteArray4.f984b, bArr3, 0, i31);
                                            parsableByteArray4.f984b += i31;
                                            mdtaMetadataEntry = new MdtaMetadataEntry(str3, bArr3, iF16, iF15);
                                            break;
                                        }
                                        parsableByteArray4.E(i30 + iF14);
                                        iF10 = i4;
                                    }
                                    if (mdtaMetadataEntry != null) {
                                        arrayList7.add(mdtaMetadataEntry);
                                    }
                                }
                                parsableByteArray4.E(i28 + iF12);
                                i27 = 8;
                                iF10 = i4;
                                strArr2 = strArr2;
                                metadata9 = metadata9;
                            }
                            metadata3 = metadata9;
                            if (!arrayList7.isEmpty()) {
                                metadata4 = new Metadata(arrayList7);
                            }
                        }
                        metadata4 = null;
                    }
                } else {
                    metadata3 = metadata9;
                    metadata4 = null;
                }
                Metadata metadata10 = metadata4;
                List<TrackSampleTable> listE = AtomParsers.e(aVarPop, gaplessInfoHolder, -9223372036854775807L, null, (this.f1222b & 1) != 0, z2, new Function2() { // from class: b.i.a.c.x2.i0.a
                    @Override // b.i.b.a.Function2
                    public final Object apply(Object obj) {
                        Track track = (Track) obj;
                        int i32 = Mp4Extractor.a;
                        return track;
                    }
                });
                ExtractorOutput extractorOutput = this.f1223s;
                Objects.requireNonNull(extractorOutput);
                ArrayList arrayList8 = (ArrayList) listE;
                int size = arrayList8.size();
                long jMax = -9223372036854775807L;
                long j2 = -9223372036854775807L;
                int i32 = 0;
                int size2 = -1;
                while (i32 < size) {
                    TrackSampleTable trackSampleTable = (TrackSampleTable) arrayList8.get(i32);
                    if (trackSampleTable.f1233b == 0) {
                        metadata5 = metadata;
                        arrayList2 = arrayList;
                    } else {
                        Track track = trackSampleTable.a;
                        Metadata metadata11 = metadata10;
                        int i33 = size2;
                        long j3 = track.e;
                        if (j3 == j2) {
                            j3 = trackSampleTable.h;
                        }
                        jMax = Math.max(jMax, j3);
                        a aVar = new a(track, trackSampleTable, extractorOutput.p(i32, track.f1230b));
                        int i34 = "audio/true-hd".equals(track.f.w) ? trackSampleTable.e * 16 : trackSampleTable.e + 30;
                        Format2.b bVarA = track.f.a();
                        bVarA.l = i34;
                        int i35 = track.f1230b;
                        if (i35 == 2 && j3 > 0 && (i3 = trackSampleTable.f1233b) > 1) {
                            bVarA.r = i3 / (j3 / 1000000.0f);
                        }
                        if (i35 == 1) {
                            int i36 = gaplessInfoHolder.f1294b;
                            if ((i36 == -1 || gaplessInfoHolder.c == -1) ? false : true) {
                                bVarA.A = i36;
                                bVarA.B = gaplessInfoHolder.c;
                            }
                        }
                        Metadata[] metadataArr = new Metadata[2];
                        metadataArr[0] = metadata;
                        metadataArr[1] = this.i.isEmpty() ? null : new Metadata(this.i);
                        Metadata metadata12 = new Metadata(new Metadata.Entry[0]);
                        if (i35 != 1) {
                            if (i35 == 2 && metadata11 != null) {
                                int i37 = 0;
                                metadata10 = metadata11;
                                while (true) {
                                    Metadata.Entry[] entryArr = metadata10.j;
                                    if (i37 >= entryArr.length) {
                                        metadata5 = metadata;
                                        break;
                                    }
                                    Metadata.Entry entry = entryArr[i37];
                                    if (entry instanceof MdtaMetadataEntry) {
                                        MdtaMetadataEntry mdtaMetadataEntry2 = (MdtaMetadataEntry) entry;
                                        metadata5 = metadata;
                                        if ("com.android.capture.fps".equals(mdtaMetadataEntry2.j)) {
                                            metadata12 = new Metadata(mdtaMetadataEntry2);
                                            break;
                                        }
                                    } else {
                                        metadata5 = metadata;
                                    }
                                    i37++;
                                    metadata = metadata5;
                                }
                            } else {
                                metadata5 = metadata;
                                metadata10 = metadata11;
                            }
                        } else if (metadata3 != null) {
                            metadata5 = metadata;
                            metadata10 = metadata11;
                            metadata12 = metadata3;
                        } else {
                            metadata5 = metadata;
                            metadata10 = metadata11;
                        }
                        for (int i38 = 0; i38 < 2; i38++) {
                            Metadata metadata13 = metadataArr[i38];
                            if (metadata13 != null) {
                                metadata12 = metadata12.a(metadata13.j);
                            }
                        }
                        if (metadata12.j.length > 0) {
                            bVarA.i = metadata12;
                        }
                        aVar.c.e(bVarA.a());
                        if (track.f1230b == 2) {
                            i2 = i33;
                            if (i2 == -1) {
                                size2 = arrayList.size();
                            }
                            arrayList2 = arrayList;
                            arrayList2.add(aVar);
                        } else {
                            i2 = i33;
                        }
                        size2 = i2;
                        arrayList2 = arrayList;
                        arrayList2.add(aVar);
                    }
                    i32++;
                    j2 = -9223372036854775807L;
                    arrayList = arrayList2;
                    arrayList8 = arrayList8;
                    size = size;
                    metadata = metadata5;
                }
                long j4 = 0;
                this.v = size2;
                this.w = jMax;
                a[] aVarArr = (a[]) arrayList.toArray(new a[0]);
                this.t = aVarArr;
                long[][] jArr = new long[aVarArr.length][];
                int[] iArr = new int[aVarArr.length];
                long[] jArr2 = new long[aVarArr.length];
                boolean[] zArr = new boolean[aVarArr.length];
                for (int i39 = 0; i39 < aVarArr.length; i39++) {
                    jArr[i39] = new long[aVarArr[i39].f1226b.f1233b];
                    jArr2[i39] = aVarArr[i39].f1226b.f[0];
                }
                int i40 = 0;
                while (i40 < aVarArr.length) {
                    long j5 = RecyclerView.FOREVER_NS;
                    int i41 = -1;
                    for (int i42 = 0; i42 < aVarArr.length; i42++) {
                        if (!zArr[i42] && jArr2[i42] <= j5) {
                            j5 = jArr2[i42];
                            i41 = i42;
                        }
                    }
                    int i43 = iArr[i41];
                    jArr[i41][i43] = j4;
                    j4 += (long) aVarArr[i41].f1226b.d[i43];
                    int i44 = i43 + 1;
                    iArr[i41] = i44;
                    if (i44 < jArr[i41].length) {
                        jArr2[i41] = aVarArr[i41].f1226b.f[i44];
                    } else {
                        zArr[i41] = true;
                        i40++;
                    }
                }
                this.u = jArr;
                extractorOutput.j();
                extractorOutput.a(this);
                this.g.clear();
                this.j = 2;
            } else if (!this.g.isEmpty()) {
                this.g.peek().d.add(aVarPop);
            }
        }
        if (this.j != 2) {
            j();
        }
    }

    @Override // b.i.a.c.x2.Extractor
    public void release() {
    }
}
