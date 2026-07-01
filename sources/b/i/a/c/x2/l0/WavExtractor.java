package b.i.a.c.x2.l0;

import android.net.Uri;
import android.util.Log;
import android.util.Pair;
import b.c.a.a0.AnimatableValueParser;
import b.d.b.a.outline;
import b.i.a.c.Format2;
import b.i.a.c.f3.ParsableByteArray;
import b.i.a.c.f3.Util2;
import b.i.a.c.x2.Extractor;
import b.i.a.c.x2.ExtractorInput;
import b.i.a.c.x2.ExtractorOutput;
import b.i.a.c.x2.ExtractorsFactory;
import b.i.a.c.x2.ExtractorsFactory2;
import b.i.a.c.x2.PositionHolder;
import b.i.a.c.x2.TrackOutput2;
import com.google.android.exoplayer2.ParserException;
import java.io.IOException;
import java.util.Map;
import java.util.Objects;
import org.objectweb.asm.Opcodes;

/* JADX INFO: renamed from: b.i.a.c.x2.l0.b, reason: use source file name */
/* JADX INFO: compiled from: WavExtractor.java */
/* JADX INFO: loaded from: classes3.dex */
public final class WavExtractor implements Extractor {
    public ExtractorOutput a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TrackOutput2 f1285b;
    public b d;
    public int c = 0;
    public int e = -1;
    public long f = -1;

    /* JADX INFO: renamed from: b.i.a.c.x2.l0.b$a */
    /* JADX INFO: compiled from: WavExtractor.java */
    public static final class a implements b {
        public static final int[] a = {-1, -1, -1, -1, 2, 4, 6, 8, -1, -1, -1, -1, 2, 4, 6, 8};

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final int[] f1286b = {7, 8, 9, 10, 11, 12, 13, 14, 16, 17, 19, 21, 23, 25, 28, 31, 34, 37, 41, 45, 50, 55, 60, 66, 73, 80, 88, 97, 107, 118, 130, Opcodes.D2L, 157, Opcodes.LRETURN, Opcodes.ARRAYLENGTH, 209, 230, 253, 279, 307, 337, 371, 408, 449, 494, 544, 598, 658, 724, 796, 876, 963, 1060, 1166, 1282, 1411, 1552, 1707, 1878, 2066, 2272, 2499, 2749, 3024, 3327, 3660, 4026, 4428, 4871, 5358, 5894, 6484, 7132, 7845, 8630, 9493, 10442, 11487, 12635, 13899, 15289, 16818, 18500, 20350, 22385, 24623, 27086, 29794, 32767};
        public final ExtractorOutput c;
        public final TrackOutput2 d;
        public final WavFormat e;
        public final int f;
        public final byte[] g;
        public final ParsableByteArray h;
        public final int i;
        public final Format2 j;
        public int k;
        public long l;
        public int m;
        public long n;

        public a(ExtractorOutput extractorOutput, TrackOutput2 trackOutput2, WavFormat wavFormat) throws ParserException {
            this.c = extractorOutput;
            this.d = trackOutput2;
            this.e = wavFormat;
            int iMax = Math.max(1, wavFormat.c / 10);
            this.i = iMax;
            byte[] bArr = wavFormat.f;
            int length = bArr.length;
            byte b2 = bArr[0];
            byte b3 = bArr[1];
            int i = ((bArr[3] & 255) << 8) | (bArr[2] & 255);
            this.f = i;
            int i2 = wavFormat.f1288b;
            int i3 = (((wavFormat.d - (i2 * 4)) * 8) / (wavFormat.e * i2)) + 1;
            if (i != i3) {
                throw ParserException.a(outline.h(56, "Expected frames per block: ", i3, "; got: ", i), null);
            }
            int iF = Util2.f(iMax, i);
            this.g = new byte[wavFormat.d * iF];
            this.h = new ParsableByteArray(i * 2 * i2 * iF);
            int i4 = wavFormat.c;
            int i5 = ((wavFormat.d * i4) * 8) / i;
            Format2.b bVar = new Format2.b();
            bVar.k = "audio/raw";
            bVar.f = i5;
            bVar.g = i5;
            bVar.l = iMax * 2 * i2;
            bVar.f1023x = wavFormat.f1288b;
            bVar.f1024y = i4;
            bVar.f1025z = 2;
            this.j = bVar.a();
        }

        @Override // b.i.a.c.x2.l0.WavExtractor.b
        public void a(long j) {
            this.k = 0;
            this.l = j;
            this.m = 0;
            this.n = 0L;
        }

        @Override // b.i.a.c.x2.l0.WavExtractor.b
        public void b(int i, long j) {
            this.c.a(new WavSeekMap(this.e, this.f, i, j));
            this.d.e(this.j);
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x003f -> B:12:0x0041). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Not found exit edge by exit block: B:7:0x0029
            	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.checkLoopExits(LoopRegionMaker.java:272)
            	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.makeLoopRegion(LoopRegionMaker.java:237)
            	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:80)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeMthRegion(RegionMaker.java:49)
            	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:25)
            */
        @Override // b.i.a.c.x2.l0.WavExtractor.b
        public boolean c(b.i.a.c.x2.ExtractorInput r19, long r20) throws java.io.IOException {
            /*
                Method dump skipped, instruction units count: 364
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: b.i.a.c.x2.l0.WavExtractor.a.c(b.i.a.c.x2.i, long):boolean");
        }

        public final int d(int i) {
            return i / (this.e.f1288b * 2);
        }

        public final void e(int i) {
            long jF = this.l + Util2.F(this.n, 1000000L, this.e.c);
            int i2 = i * 2 * this.e.f1288b;
            this.d.d(jF, 1, i2, this.m - i2, null);
            this.n += (long) i;
            this.m -= i2;
        }
    }

    /* JADX INFO: renamed from: b.i.a.c.x2.l0.b$b */
    /* JADX INFO: compiled from: WavExtractor.java */
    public interface b {
        void a(long j);

        void b(int i, long j) throws ParserException;

        boolean c(ExtractorInput extractorInput, long j) throws IOException;
    }

    /* JADX INFO: renamed from: b.i.a.c.x2.l0.b$c */
    /* JADX INFO: compiled from: WavExtractor.java */
    public static final class c implements b {
        public final ExtractorOutput a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final TrackOutput2 f1287b;
        public final WavFormat c;
        public final Format2 d;
        public final int e;
        public long f;
        public int g;
        public long h;

        public c(ExtractorOutput extractorOutput, TrackOutput2 trackOutput2, WavFormat wavFormat, String str, int i) throws ParserException {
            this.a = extractorOutput;
            this.f1287b = trackOutput2;
            this.c = wavFormat;
            int i2 = (wavFormat.f1288b * wavFormat.e) / 8;
            int i3 = wavFormat.d;
            if (i3 != i2) {
                throw ParserException.a(outline.h(50, "Expected block size: ", i2, "; got: ", i3), null);
            }
            int i4 = wavFormat.c * i2;
            int i5 = i4 * 8;
            int iMax = Math.max(i2, i4 / 10);
            this.e = iMax;
            Format2.b bVar = new Format2.b();
            bVar.k = str;
            bVar.f = i5;
            bVar.g = i5;
            bVar.l = iMax;
            bVar.f1023x = wavFormat.f1288b;
            bVar.f1024y = wavFormat.c;
            bVar.f1025z = i;
            this.d = bVar.a();
        }

        @Override // b.i.a.c.x2.l0.WavExtractor.b
        public void a(long j) {
            this.f = j;
            this.g = 0;
            this.h = 0L;
        }

        @Override // b.i.a.c.x2.l0.WavExtractor.b
        public void b(int i, long j) {
            this.a.a(new WavSeekMap(this.c, 1, i, j));
            this.f1287b.e(this.d);
        }

        @Override // b.i.a.c.x2.l0.WavExtractor.b
        public boolean c(ExtractorInput extractorInput, long j) throws IOException {
            int i;
            int i2;
            long j2 = j;
            while (j2 > 0 && (i = this.g) < (i2 = this.e)) {
                int iB = this.f1287b.b(extractorInput, (int) Math.min(i2 - i, j2), true);
                if (iB == -1) {
                    j2 = 0;
                } else {
                    this.g += iB;
                    j2 -= (long) iB;
                }
            }
            WavFormat wavFormat = this.c;
            int i3 = wavFormat.d;
            int i4 = this.g / i3;
            if (i4 > 0) {
                long jF = this.f + Util2.F(this.h, 1000000L, wavFormat.c);
                int i5 = i4 * i3;
                int i6 = this.g - i5;
                this.f1287b.d(jF, 1, i5, i6, null);
                this.h += (long) i4;
                this.g = i6;
            }
            return j2 <= 0;
        }
    }

    static {
        b.i.a.c.x2.l0.a aVar = new ExtractorsFactory2() { // from class: b.i.a.c.x2.l0.a
            @Override // b.i.a.c.x2.ExtractorsFactory2
            public final Extractor[] a() {
                return new Extractor[]{new WavExtractor()};
            }

            @Override // b.i.a.c.x2.ExtractorsFactory2
            public /* synthetic */ Extractor[] b(Uri uri, Map map) {
                return ExtractorsFactory.a(this, uri, map);
            }
        };
    }

    @Override // b.i.a.c.x2.Extractor
    public boolean b(ExtractorInput extractorInput) throws IOException {
        return AnimatableValueParser.r(extractorInput);
    }

    /* JADX WARN: Code duplicated, block: B:65:0x01b8  */
    @Override // b.i.a.c.x2.Extractor
    public int e(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException {
        byte[] bArr;
        int iR;
        int i;
        AnimatableValueParser.H(this.f1285b);
        int i2 = Util2.a;
        int i3 = this.c;
        if (i3 == 0) {
            AnimatableValueParser.D(extractorInput.getPosition() == 0);
            int i4 = this.e;
            if (i4 != -1) {
                extractorInput.l(i4);
                this.c = 3;
            } else {
                if (!AnimatableValueParser.r(extractorInput)) {
                    throw ParserException.a("Unsupported or unrecognized wav file type.", null);
                }
                extractorInput.l((int) (extractorInput.f() - extractorInput.getPosition()));
                this.c = 1;
            }
            return 0;
        }
        if (i3 == 1) {
            ParsableByteArray parsableByteArray = new ParsableByteArray(16);
            WavHeaderReader wavHeaderReaderA = WavHeaderReader.a(extractorInput, parsableByteArray);
            while (wavHeaderReaderA.a != 1718449184) {
                extractorInput.l(((int) wavHeaderReaderA.f1289b) + 8);
                wavHeaderReaderA = WavHeaderReader.a(extractorInput, parsableByteArray);
            }
            AnimatableValueParser.D(wavHeaderReaderA.f1289b >= 16);
            extractorInput.o(parsableByteArray.a, 0, 16);
            parsableByteArray.E(0);
            int iL = parsableByteArray.l();
            int iL2 = parsableByteArray.l();
            int iK = parsableByteArray.k();
            int iK2 = parsableByteArray.k();
            int iL3 = parsableByteArray.l();
            int iL4 = parsableByteArray.l();
            int i5 = ((int) wavHeaderReaderA.f1289b) - 16;
            if (i5 > 0) {
                bArr = new byte[i5];
                extractorInput.o(bArr, 0, i5);
            } else {
                bArr = Util2.f;
            }
            extractorInput.l((int) (extractorInput.f() - extractorInput.getPosition()));
            WavFormat wavFormat = new WavFormat(iL, iL2, iK, iK2, iL3, iL4, bArr);
            if (iL == 17) {
                this.d = new a(this.a, this.f1285b, wavFormat);
            } else if (iL == 6) {
                this.d = new c(this.a, this.f1285b, wavFormat, "audio/g711-alaw", -1);
            } else if (iL == 7) {
                this.d = new c(this.a, this.f1285b, wavFormat, "audio/g711-mlaw", -1);
            } else {
                if (iL == 1) {
                    iR = Util2.r(iL4);
                    i = iR;
                } else if (iL == 3) {
                    iR = iL4 == 32 ? 4 : 0;
                    i = iR;
                } else if (iL != 65534) {
                    i = 0;
                } else {
                    iR = Util2.r(iL4);
                    i = iR;
                }
                if (i == 0) {
                    StringBuilder sb = new StringBuilder(40);
                    sb.append("Unsupported WAV format type: ");
                    sb.append(iL);
                    throw ParserException.b(sb.toString());
                }
                this.d = new c(this.a, this.f1285b, wavFormat, "audio/raw", i);
            }
            this.c = 2;
            return 0;
        }
        if (i3 != 2) {
            if (i3 != 3) {
                throw new IllegalStateException();
            }
            AnimatableValueParser.D(this.f != -1);
            long position = this.f - extractorInput.getPosition();
            b bVar = this.d;
            Objects.requireNonNull(bVar);
            return bVar.c(extractorInput, position) ? -1 : 0;
        }
        extractorInput.k();
        ParsableByteArray parsableByteArray2 = new ParsableByteArray(8);
        WavHeaderReader wavHeaderReaderA2 = WavHeaderReader.a(extractorInput, parsableByteArray2);
        while (true) {
            int i6 = wavHeaderReaderA2.a;
            if (i6 == 1684108385) {
                extractorInput.l(8);
                long position2 = extractorInput.getPosition();
                long j = wavHeaderReaderA2.f1289b + position2;
                long jB = extractorInput.b();
                if (jB != -1 && j > jB) {
                    StringBuilder sbR = outline.R(69, "Data exceeds input length: ", j, ", ");
                    sbR.append(jB);
                    Log.w("WavHeaderReader", sbR.toString());
                    j = jB;
                }
                Pair pairCreate = Pair.create(Long.valueOf(position2), Long.valueOf(j));
                this.e = ((Long) pairCreate.first).intValue();
                this.f = ((Long) pairCreate.second).longValue();
                b bVar2 = this.d;
                Objects.requireNonNull(bVar2);
                bVar2.b(this.e, this.f);
                this.c = 3;
                return 0;
            }
            outline.g0(39, "Ignoring unknown WAV chunk: ", i6, "WavHeaderReader");
            long j2 = wavHeaderReaderA2.f1289b + 8;
            if (j2 > 2147483647L) {
                int i7 = wavHeaderReaderA2.a;
                StringBuilder sb2 = new StringBuilder(51);
                sb2.append("Chunk is too large (~2GB+) to skip; id: ");
                sb2.append(i7);
                throw ParserException.b(sb2.toString());
            }
            extractorInput.l((int) j2);
            wavHeaderReaderA2 = WavHeaderReader.a(extractorInput, parsableByteArray2);
        }
    }

    @Override // b.i.a.c.x2.Extractor
    public void f(ExtractorOutput extractorOutput) {
        this.a = extractorOutput;
        this.f1285b = extractorOutput.p(0, 1);
        extractorOutput.j();
    }

    @Override // b.i.a.c.x2.Extractor
    public void g(long j, long j2) {
        this.c = j == 0 ? 0 : 3;
        b bVar = this.d;
        if (bVar != null) {
            bVar.a(j2);
        }
    }

    @Override // b.i.a.c.x2.Extractor
    public void release() {
    }
}
