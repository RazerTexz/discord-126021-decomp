package b.i.a.c.x2.j0;

import android.net.Uri;
import b.c.a.a0.AnimatableValueParser;
import b.i.a.c.Format2;
import b.i.a.c.f3.ParsableByteArray;
import b.i.a.c.f3.Util2;
import b.i.a.c.x2.Extractor;
import b.i.a.c.x2.ExtractorInput;
import b.i.a.c.x2.ExtractorOutput;
import b.i.a.c.x2.ExtractorsFactory;
import b.i.a.c.x2.ExtractorsFactory2;
import b.i.a.c.x2.PositionHolder;
import b.i.a.c.x2.SeekMap;
import b.i.a.c.x2.TrackOutput2;
import b.i.a.c.x2.j0.StreamReader;
import com.discord.utilities.auth.GoogleSmartLockManager;
import com.google.android.exoplayer2.ParserException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;

/* JADX INFO: renamed from: b.i.a.c.x2.j0.d, reason: use source file name */
/* JADX INFO: compiled from: OggExtractor.java */
/* JADX INFO: loaded from: classes3.dex */
public class OggExtractor implements Extractor {
    public ExtractorOutput a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public StreamReader f1236b;
    public boolean c;

    static {
        a aVar = new ExtractorsFactory2() { // from class: b.i.a.c.x2.j0.a
            @Override // b.i.a.c.x2.ExtractorsFactory2
            public final Extractor[] a() {
                return new Extractor[]{new OggExtractor()};
            }

            @Override // b.i.a.c.x2.ExtractorsFactory2
            public /* synthetic */ Extractor[] b(Uri uri, Map map) {
                return ExtractorsFactory.a(this, uri, map);
            }
        };
    }

    @EnsuresNonNullIf(expression = {"streamReader"}, result = GoogleSmartLockManager.SET_DISCORD_ACCOUNT_DETAILS)
    public final boolean a(ExtractorInput extractorInput) throws IOException {
        boolean zN2;
        boolean zEquals;
        OggPageHeader oggPageHeader = new OggPageHeader();
        if (oggPageHeader.a(extractorInput, true) && (oggPageHeader.f1238b & 2) == 2) {
            int iMin = Math.min(oggPageHeader.f, 8);
            ParsableByteArray parsableByteArray = new ParsableByteArray(iMin);
            extractorInput.o(parsableByteArray.a, 0, iMin);
            parsableByteArray.E(0);
            if (parsableByteArray.a() >= 5 && parsableByteArray.t() == 127 && parsableByteArray.u() == 1179402563) {
                this.f1236b = new FlacReader();
            } else {
                parsableByteArray.E(0);
                try {
                    zN2 = AnimatableValueParser.n2(1, parsableByteArray, true);
                } catch (ParserException unused) {
                    zN2 = false;
                }
                if (zN2) {
                    this.f1236b = new VorbisReader();
                } else {
                    parsableByteArray.E(0);
                    int iA = parsableByteArray.a();
                    byte[] bArr = OpusReader.n;
                    if (iA < bArr.length) {
                        zEquals = false;
                    } else {
                        byte[] bArr2 = new byte[bArr.length];
                        int length = bArr.length;
                        System.arraycopy(parsableByteArray.a, parsableByteArray.f984b, bArr2, 0, length);
                        parsableByteArray.f984b += length;
                        zEquals = Arrays.equals(bArr2, bArr);
                    }
                    if (zEquals) {
                        this.f1236b = new OpusReader();
                    }
                }
            }
            return true;
        }
        return false;
    }

    @Override // b.i.a.c.x2.Extractor
    public boolean b(ExtractorInput extractorInput) throws IOException {
        try {
            return a(extractorInput);
        } catch (ParserException unused) {
            return false;
        }
    }

    /* JADX WARN: Code duplicated, block: B:70:0x0180  */
    /* JADX WARN: Code duplicated, block: B:78:? A[RETURN, SYNTHETIC] */
    @Override // b.i.a.c.x2.Extractor
    public int e(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException {
        boolean z2;
        int i;
        OggPacket oggPacket;
        ParsableByteArray parsableByteArray;
        byte[] bArr;
        AnimatableValueParser.H(this.a);
        if (this.f1236b == null) {
            if (!a(extractorInput)) {
                throw ParserException.a("Failed to determine bitstream type", null);
            }
            extractorInput.k();
        }
        if (!this.c) {
            TrackOutput2 trackOutput2P = this.a.p(0, 1);
            this.a.j();
            StreamReader streamReader = this.f1236b;
            streamReader.c = this.a;
            streamReader.f1239b = trackOutput2P;
            streamReader.e(true);
            this.c = true;
        }
        StreamReader streamReader2 = this.f1236b;
        AnimatableValueParser.H(streamReader2.f1239b);
        int i2 = Util2.a;
        int i3 = streamReader2.h;
        int i4 = 3;
        if (i3 == 0) {
            while (true) {
                if (!streamReader2.a.b(extractorInput)) {
                    streamReader2.h = i4;
                    z2 = false;
                    break;
                }
                long position = extractorInput.getPosition();
                long j = streamReader2.f;
                streamReader2.k = position - j;
                if (!streamReader2.d(streamReader2.a.f1237b, j, streamReader2.j)) {
                    z2 = true;
                    break;
                }
                streamReader2.f = extractorInput.getPosition();
                i4 = 3;
            }
            if (z2) {
                Format2 format2 = streamReader2.j.a;
                streamReader2.i = format2.K;
                if (!streamReader2.m) {
                    streamReader2.f1239b.e(format2);
                    streamReader2.m = true;
                }
                OggSeeker oggSeeker = streamReader2.j.f1240b;
                if (oggSeeker == null) {
                    if (extractorInput.b() == -1) {
                        streamReader2.d = new StreamReader.c(null);
                    } else {
                        OggPageHeader oggPageHeader = streamReader2.a.a;
                        i = 2;
                        streamReader2.d = new DefaultOggSeeker(streamReader2, streamReader2.f, extractorInput.b(), oggPageHeader.e + oggPageHeader.f, oggPageHeader.c, (oggPageHeader.f1238b & 4) != 0);
                    }
                    streamReader2.h = i;
                    oggPacket = streamReader2.a;
                    parsableByteArray = oggPacket.f1237b;
                    bArr = parsableByteArray.a;
                    if (bArr.length == 65025) {
                        return 0;
                    }
                    parsableByteArray.C(Arrays.copyOf(bArr, Math.max(65025, parsableByteArray.c)), oggPacket.f1237b.c);
                    return 0;
                }
                streamReader2.d = oggSeeker;
                i = 2;
                streamReader2.h = i;
                oggPacket = streamReader2.a;
                parsableByteArray = oggPacket.f1237b;
                bArr = parsableByteArray.a;
                if (bArr.length == 65025) {
                    return 0;
                }
                parsableByteArray.C(Arrays.copyOf(bArr, Math.max(65025, parsableByteArray.c)), oggPacket.f1237b.c);
                return 0;
            }
        } else {
            if (i3 == 1) {
                extractorInput.l((int) streamReader2.f);
                streamReader2.h = 2;
                return 0;
            }
            if (i3 == 2) {
                long jB = streamReader2.d.b(extractorInput);
                if (jB >= 0) {
                    positionHolder.a = jB;
                    return 1;
                }
                if (jB < -1) {
                    streamReader2.b(-(jB + 2));
                }
                if (!streamReader2.l) {
                    SeekMap seekMapA = streamReader2.d.a();
                    AnimatableValueParser.H(seekMapA);
                    streamReader2.c.a(seekMapA);
                    streamReader2.l = true;
                }
                if (streamReader2.k > 0 || streamReader2.a.b(extractorInput)) {
                    streamReader2.k = 0L;
                    ParsableByteArray parsableByteArray2 = streamReader2.a.f1237b;
                    long jC = streamReader2.c(parsableByteArray2);
                    if (jC >= 0) {
                        long j2 = streamReader2.g;
                        if (j2 + jC >= streamReader2.e) {
                            long j3 = (j2 * 1000000) / ((long) streamReader2.i);
                            streamReader2.f1239b.c(parsableByteArray2, parsableByteArray2.c);
                            streamReader2.f1239b.d(j3, 1, parsableByteArray2.c, 0, null);
                            streamReader2.e = -1L;
                        }
                    }
                    streamReader2.g += jC;
                    return 0;
                }
                streamReader2.h = 3;
            } else if (i3 != 3) {
                throw new IllegalStateException();
            }
        }
        return -1;
    }

    @Override // b.i.a.c.x2.Extractor
    public void f(ExtractorOutput extractorOutput) {
        this.a = extractorOutput;
    }

    @Override // b.i.a.c.x2.Extractor
    public void g(long j, long j2) {
        StreamReader streamReader = this.f1236b;
        if (streamReader != null) {
            OggPacket oggPacket = streamReader.a;
            oggPacket.a.b();
            oggPacket.f1237b.A(0);
            oggPacket.c = -1;
            oggPacket.e = false;
            if (j == 0) {
                streamReader.e(!streamReader.l);
                return;
            }
            if (streamReader.h != 0) {
                long j3 = (((long) streamReader.i) * j2) / 1000000;
                streamReader.e = j3;
                OggSeeker oggSeeker = streamReader.d;
                int i = Util2.a;
                oggSeeker.c(j3);
                streamReader.h = 2;
            }
        }
    }

    @Override // b.i.a.c.x2.Extractor
    public void release() {
    }
}
