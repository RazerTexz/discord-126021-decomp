package b.i.a.c.x2.d0;

import android.net.Uri;
import androidx.annotation.Nullable;
import b.c.a.a0.AnimatableValueParser;
import b.i.a.c.f3.ParsableBitArray;
import b.i.a.c.f3.ParsableByteArray;
import b.i.a.c.f3.Util2;
import b.i.a.c.x2.Extractor;
import b.i.a.c.x2.ExtractorInput;
import b.i.a.c.x2.ExtractorOutput;
import b.i.a.c.x2.ExtractorsFactory;
import b.i.a.c.x2.ExtractorsFactory2;
import b.i.a.c.x2.FlacFrameReader;
import b.i.a.c.x2.FlacSeekTableSeekMap;
import b.i.a.c.x2.FlacStreamMetadata;
import b.i.a.c.x2.PositionHolder;
import b.i.a.c.x2.SeekMap;
import b.i.a.c.x2.TrackOutput2;
import b.i.b.a.Charsets;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.flac.PictureFrame;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: renamed from: b.i.a.c.x2.d0.d, reason: use source file name */
/* JADX INFO: compiled from: FlacExtractor.java */
/* JADX INFO: loaded from: classes3.dex */
public final class FlacExtractor implements Extractor {
    public final byte[] a = new byte[42];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ParsableByteArray f1169b = new ParsableByteArray(new byte[32768], 0);
    public final boolean c;
    public final FlacFrameReader.a d;
    public ExtractorOutput e;
    public TrackOutput2 f;
    public int g;

    @Nullable
    public Metadata h;
    public FlacStreamMetadata i;
    public int j;
    public int k;
    public FlacBinarySearchSeeker l;
    public int m;
    public long n;

    static {
        a aVar = new ExtractorsFactory2() { // from class: b.i.a.c.x2.d0.a
            @Override // b.i.a.c.x2.ExtractorsFactory2
            public final Extractor[] a() {
                return new Extractor[]{new FlacExtractor(0)};
            }

            @Override // b.i.a.c.x2.ExtractorsFactory2
            public /* synthetic */ Extractor[] b(Uri uri, Map map) {
                return ExtractorsFactory.a(this, uri, map);
            }
        };
    }

    public FlacExtractor(int i) {
        this.c = (i & 1) != 0;
        this.d = new FlacFrameReader.a();
        this.g = 0;
    }

    public final void a() {
        long j = this.n * 1000000;
        FlacStreamMetadata flacStreamMetadata = this.i;
        int i = Util2.a;
        this.f.d(j / ((long) flacStreamMetadata.e), 1, this.m, 0, null);
    }

    @Override // b.i.a.c.x2.Extractor
    public boolean b(ExtractorInput extractorInput) throws IOException {
        AnimatableValueParser.y1(extractorInput, false);
        byte[] bArr = new byte[4];
        extractorInput.o(bArr, 0, 4);
        return (((((((long) bArr[0]) & 255) << 24) | ((((long) bArr[1]) & 255) << 16)) | ((((long) bArr[2]) & 255) << 8)) | (255 & ((long) bArr[3]))) == 1716281667;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v15 */
    /* JADX WARN: Type inference failed for: r4v8, types: [boolean, int] */
    @Override // b.i.a.c.x2.Extractor
    public int e(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException {
        boolean z2;
        FlacStreamMetadata flacStreamMetadata;
        SeekMap bVar;
        long j;
        boolean zB;
        int i = this.g;
        boolean z3 = true;
        ?? r4 = 0;
        if (i == 0) {
            boolean z4 = !this.c;
            extractorInput.k();
            long jF = extractorInput.f();
            Metadata metadataY1 = AnimatableValueParser.y1(extractorInput, z4);
            extractorInput.l((int) (extractorInput.f() - jF));
            this.h = metadataY1;
            this.g = 1;
            return 0;
        }
        if (i == 1) {
            byte[] bArr = this.a;
            extractorInput.o(bArr, 0, bArr.length);
            extractorInput.k();
            this.g = 2;
            return 0;
        }
        int i2 = 4;
        int i3 = 3;
        if (i == 2) {
            byte[] bArr2 = new byte[4];
            extractorInput.readFully(bArr2, 0, 4);
            if ((((((long) bArr2[0]) & 255) << 24) | ((((long) bArr2[1]) & 255) << 16) | ((((long) bArr2[2]) & 255) << 8) | (((long) bArr2[3]) & 255)) != 1716281667) {
                throw ParserException.a("Failed to read FLAC stream marker.", null);
            }
            this.g = 3;
            return 0;
        }
        int i4 = 7;
        if (i == 3) {
            FlacStreamMetadata flacStreamMetadataB = this.i;
            boolean z5 = false;
            while (!z5) {
                extractorInput.k();
                ParsableBitArray parsableBitArray = new ParsableBitArray(new byte[i2]);
                extractorInput.o(parsableBitArray.a, r4, i2);
                boolean zF = parsableBitArray.f();
                int iG = parsableBitArray.g(i4);
                int iG2 = parsableBitArray.g(24) + i2;
                if (iG == 0) {
                    byte[] bArr3 = new byte[38];
                    extractorInput.readFully(bArr3, r4, 38);
                    flacStreamMetadataB = new FlacStreamMetadata(bArr3, i2);
                } else {
                    if (flacStreamMetadataB == null) {
                        throw new IllegalArgumentException();
                    }
                    if (iG == i3) {
                        ParsableByteArray parsableByteArray = new ParsableByteArray(iG2);
                        extractorInput.readFully(parsableByteArray.a, r4, iG2);
                        flacStreamMetadataB = flacStreamMetadataB.b(AnimatableValueParser.L1(parsableByteArray));
                    } else {
                        if (iG == i2) {
                            ParsableByteArray parsableByteArray2 = new ParsableByteArray(iG2);
                            extractorInput.readFully(parsableByteArray2.a, r4, iG2);
                            parsableByteArray2.F(i2);
                            z2 = zF;
                            flacStreamMetadata = new FlacStreamMetadata(flacStreamMetadataB.a, flacStreamMetadataB.f1292b, flacStreamMetadataB.c, flacStreamMetadataB.d, flacStreamMetadataB.e, flacStreamMetadataB.g, flacStreamMetadataB.h, flacStreamMetadataB.j, flacStreamMetadataB.k, flacStreamMetadataB.f(FlacStreamMetadata.a(Arrays.asList(AnimatableValueParser.N1(parsableByteArray2, r4, r4).a), Collections.emptyList())));
                        } else {
                            z2 = zF;
                            if (iG == 6) {
                                ParsableByteArray parsableByteArray3 = new ParsableByteArray(iG2);
                                extractorInput.readFully(parsableByteArray3.a, 0, iG2);
                                parsableByteArray3.F(i2);
                                int iF = parsableByteArray3.f();
                                String strR = parsableByteArray3.r(parsableByteArray3.f(), Charsets.a);
                                String strQ = parsableByteArray3.q(parsableByteArray3.f());
                                int iF2 = parsableByteArray3.f();
                                int iF3 = parsableByteArray3.f();
                                int iF4 = parsableByteArray3.f();
                                int iF5 = parsableByteArray3.f();
                                int iF6 = parsableByteArray3.f();
                                byte[] bArr4 = new byte[iF6];
                                System.arraycopy(parsableByteArray3.a, parsableByteArray3.f984b, bArr4, 0, iF6);
                                parsableByteArray3.f984b += iF6;
                                flacStreamMetadata = new FlacStreamMetadata(flacStreamMetadataB.a, flacStreamMetadataB.f1292b, flacStreamMetadataB.c, flacStreamMetadataB.d, flacStreamMetadataB.e, flacStreamMetadataB.g, flacStreamMetadataB.h, flacStreamMetadataB.j, flacStreamMetadataB.k, flacStreamMetadataB.f(FlacStreamMetadata.a(Collections.emptyList(), Collections.singletonList(new PictureFrame(iF, strR, strQ, iF2, iF3, iF4, iF5, bArr4)))));
                            } else {
                                extractorInput.l(iG2);
                            }
                        }
                        flacStreamMetadataB = flacStreamMetadata;
                    }
                    int i5 = Util2.a;
                    this.i = flacStreamMetadataB;
                    z5 = z2;
                    r4 = 0;
                    i2 = 4;
                    i3 = 3;
                    i4 = 7;
                }
                z2 = zF;
                int i6 = Util2.a;
                this.i = flacStreamMetadataB;
                z5 = z2;
                r4 = 0;
                i2 = 4;
                i3 = 3;
                i4 = 7;
            }
            Objects.requireNonNull(this.i);
            this.j = Math.max(this.i.c, 6);
            TrackOutput2 trackOutput2 = this.f;
            int i7 = Util2.a;
            trackOutput2.e(this.i.e(this.a, this.h));
            this.g = 4;
            return 0;
        }
        long j2 = 0;
        if (i == 4) {
            extractorInput.k();
            byte[] bArr5 = new byte[2];
            extractorInput.o(bArr5, 0, 2);
            int i8 = (bArr5[1] & 255) | ((bArr5[0] & 255) << 8);
            if ((i8 >> 2) != 16382) {
                extractorInput.k();
                throw ParserException.a("First frame does not start with sync code.", null);
            }
            extractorInput.k();
            this.k = i8;
            ExtractorOutput extractorOutput = this.e;
            int i9 = Util2.a;
            long position = extractorInput.getPosition();
            long jB = extractorInput.b();
            Objects.requireNonNull(this.i);
            FlacStreamMetadata flacStreamMetadata2 = this.i;
            if (flacStreamMetadata2.k != null) {
                bVar = new FlacSeekTableSeekMap(flacStreamMetadata2, position);
            } else if (jB == -1 || flacStreamMetadata2.j <= 0) {
                bVar = new SeekMap.b(flacStreamMetadata2.d(), 0L);
            } else {
                FlacBinarySearchSeeker flacBinarySearchSeeker = new FlacBinarySearchSeeker(flacStreamMetadata2, this.k, position, jB);
                this.l = flacBinarySearchSeeker;
                bVar = flacBinarySearchSeeker.a;
            }
            extractorOutput.a(bVar);
            this.g = 5;
            return 0;
        }
        if (i != 5) {
            throw new IllegalStateException();
        }
        Objects.requireNonNull(this.f);
        Objects.requireNonNull(this.i);
        FlacBinarySearchSeeker flacBinarySearchSeeker2 = this.l;
        if (flacBinarySearchSeeker2 != null && flacBinarySearchSeeker2.b()) {
            return this.l.a(extractorInput, positionHolder);
        }
        if (this.n == -1) {
            FlacStreamMetadata flacStreamMetadata3 = this.i;
            extractorInput.k();
            extractorInput.g(1);
            byte[] bArr6 = new byte[1];
            extractorInput.o(bArr6, 0, 1);
            boolean z6 = (bArr6[0] & 1) == 1;
            extractorInput.g(2);
            i4 = z6 ? 7 : 6;
            ParsableByteArray parsableByteArray4 = new ParsableByteArray(i4);
            parsableByteArray4.D(AnimatableValueParser.z1(extractorInput, parsableByteArray4.a, 0, i4));
            extractorInput.k();
            try {
                long jZ = parsableByteArray4.z();
                if (!z6) {
                    jZ *= (long) flacStreamMetadata3.f1292b;
                }
                j2 = jZ;
            } catch (NumberFormatException unused) {
                z3 = false;
            }
            if (!z3) {
                throw ParserException.a(null, null);
            }
            this.n = j2;
            return 0;
        }
        ParsableByteArray parsableByteArray5 = this.f1169b;
        int i10 = parsableByteArray5.c;
        if (i10 < 32768) {
            int i11 = extractorInput.read(parsableByteArray5.a, i10, 32768 - i10);
            z3 = i11 == -1;
            if (!z3) {
                this.f1169b.D(i10 + i11);
            } else if (this.f1169b.a() == 0) {
                a();
                return -1;
            }
        } else {
            z3 = false;
        }
        ParsableByteArray parsableByteArray6 = this.f1169b;
        int i12 = parsableByteArray6.f984b;
        int i13 = this.m;
        int i14 = this.j;
        if (i13 < i14) {
            parsableByteArray6.F(Math.min(i14 - i13, parsableByteArray6.a()));
        }
        ParsableByteArray parsableByteArray7 = this.f1169b;
        Objects.requireNonNull(this.i);
        int i15 = parsableByteArray7.f984b;
        while (true) {
            if (i15 > parsableByteArray7.c - 16) {
                if (z3) {
                    while (true) {
                        int i16 = parsableByteArray7.c;
                        if (i15 <= i16 - this.j) {
                            parsableByteArray7.E(i15);
                            try {
                                zB = FlacFrameReader.b(parsableByteArray7, this.i, this.k, this.d);
                            } catch (IndexOutOfBoundsException unused2) {
                                zB = false;
                            }
                            if (parsableByteArray7.f984b > parsableByteArray7.c) {
                                zB = false;
                            }
                            if (zB) {
                                parsableByteArray7.E(i15);
                                j = this.d.a;
                                break;
                            }
                            i15++;
                        } else {
                            parsableByteArray7.E(i16);
                        }
                    }
                } else {
                    parsableByteArray7.E(i15);
                }
                j = -1;
                break;
            }
            parsableByteArray7.E(i15);
            if (FlacFrameReader.b(parsableByteArray7, this.i, this.k, this.d)) {
                parsableByteArray7.E(i15);
                j = this.d.a;
                break;
            }
            i15++;
        }
        ParsableByteArray parsableByteArray8 = this.f1169b;
        int i17 = parsableByteArray8.f984b - i12;
        parsableByteArray8.E(i12);
        this.f.c(this.f1169b, i17);
        this.m += i17;
        if (j != -1) {
            a();
            this.m = 0;
            this.n = j;
        }
        if (this.f1169b.a() >= 16) {
            return 0;
        }
        int iA = this.f1169b.a();
        ParsableByteArray parsableByteArray9 = this.f1169b;
        byte[] bArr7 = parsableByteArray9.a;
        System.arraycopy(bArr7, parsableByteArray9.f984b, bArr7, 0, iA);
        this.f1169b.E(0);
        this.f1169b.D(iA);
        return 0;
    }

    @Override // b.i.a.c.x2.Extractor
    public void f(ExtractorOutput extractorOutput) {
        this.e = extractorOutput;
        this.f = extractorOutput.p(0, 1);
        extractorOutput.j();
    }

    @Override // b.i.a.c.x2.Extractor
    public void g(long j, long j2) {
        if (j == 0) {
            this.g = 0;
        } else {
            FlacBinarySearchSeeker flacBinarySearchSeeker = this.l;
            if (flacBinarySearchSeeker != null) {
                flacBinarySearchSeeker.e(j2);
            }
        }
        this.n = j2 != 0 ? -1L : 0L;
        this.m = 0;
        this.f1169b.A(0);
    }

    @Override // b.i.a.c.x2.Extractor
    public void release() {
    }
}
