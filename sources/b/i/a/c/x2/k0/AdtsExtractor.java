package b.i.a.c.x2.k0;

import android.net.Uri;
import b.c.a.a0.AnimatableValueParser;
import b.i.a.c.f3.ParsableBitArray;
import b.i.a.c.f3.ParsableByteArray;
import b.i.a.c.x2.ConstantBitrateSeekMap;
import b.i.a.c.x2.Extractor;
import b.i.a.c.x2.ExtractorInput;
import b.i.a.c.x2.ExtractorOutput;
import b.i.a.c.x2.ExtractorsFactory;
import b.i.a.c.x2.ExtractorsFactory2;
import b.i.a.c.x2.PositionHolder;
import b.i.a.c.x2.SeekMap;
import b.i.a.c.x2.k0.TsPayloadReader;
import com.google.android.exoplayer2.ParserException;
import java.io.EOFException;
import java.io.IOException;
import java.util.Map;

/* JADX INFO: renamed from: b.i.a.c.x2.k0.j, reason: use source file name */
/* JADX INFO: compiled from: AdtsExtractor.java */
/* JADX INFO: loaded from: classes3.dex */
public final class AdtsExtractor implements Extractor {
    public final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AdtsReader f1260b;
    public final ParsableByteArray c;
    public final ParsableByteArray d;
    public final ParsableBitArray e;
    public ExtractorOutput f;
    public long g;
    public long h;
    public int i;
    public boolean j;
    public boolean k;
    public boolean l;

    static {
        c cVar = new ExtractorsFactory2() { // from class: b.i.a.c.x2.k0.c
            @Override // b.i.a.c.x2.ExtractorsFactory2
            public final Extractor[] a() {
                return new Extractor[]{new AdtsExtractor(0)};
            }

            @Override // b.i.a.c.x2.ExtractorsFactory2
            public /* synthetic */ Extractor[] b(Uri uri, Map map) {
                return ExtractorsFactory.a(this, uri, map);
            }
        };
    }

    public AdtsExtractor(int i) {
        this.a = (i & 2) != 0 ? i | 1 : i;
        this.f1260b = new AdtsReader(true, null);
        this.c = new ParsableByteArray(2048);
        this.i = -1;
        this.h = -1L;
        ParsableByteArray parsableByteArray = new ParsableByteArray(10);
        this.d = parsableByteArray;
        this.e = new ParsableBitArray(parsableByteArray.a);
    }

    public final int a(ExtractorInput extractorInput) throws IOException {
        int i = 0;
        while (true) {
            extractorInput.o(this.d.a, 0, 10);
            this.d.E(0);
            if (this.d.v() != 4801587) {
                break;
            }
            this.d.F(3);
            int iS = this.d.s();
            i += iS + 10;
            extractorInput.g(iS);
        }
        extractorInput.k();
        extractorInput.g(i);
        if (this.h == -1) {
            this.h = i;
        }
        return i;
    }

    @Override // b.i.a.c.x2.Extractor
    public boolean b(ExtractorInput extractorInput) throws IOException {
        int iA = a(extractorInput);
        int i = iA;
        int i2 = 0;
        int i3 = 0;
        do {
            extractorInput.o(this.d.a, 0, 2);
            this.d.E(0);
            if (AdtsReader.g(this.d.y())) {
                i2++;
                if (i2 >= 4 && i3 > 188) {
                    return true;
                }
                extractorInput.o(this.d.a, 0, 4);
                this.e.k(14);
                int iG = this.e.g(13);
                if (iG <= 6) {
                    i++;
                    extractorInput.k();
                    extractorInput.g(i);
                } else {
                    extractorInput.g(iG - 6);
                    i3 += iG;
                }
            } else {
                i++;
                extractorInput.k();
                extractorInput.g(i);
            }
            i2 = 0;
            i3 = 0;
        } while (i - iA < 8192);
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:72:0x0108  */
    @Override // b.i.a.c.x2.Extractor
    public int e(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException {
        int iG;
        AnimatableValueParser.H(this.f);
        long jB = extractorInput.b();
        int i = this.a;
        if ((((i & 2) == 0 && ((i & 1) == 0 || jB == -1)) ? false : true) && !this.j) {
            this.i = -1;
            extractorInput.k();
            if (extractorInput.getPosition() == 0) {
                a(extractorInput);
            }
            long j = 0;
            int i2 = 0;
            do {
                try {
                    if (!extractorInput.e(this.d.a, 0, 2, true)) {
                        break;
                    }
                    this.d.E(0);
                    if (!AdtsReader.g(this.d.y())) {
                        i2 = 0;
                        break;
                    }
                    if (!extractorInput.e(this.d.a, 0, 4, true)) {
                        break;
                    }
                    this.e.k(14);
                    iG = this.e.g(13);
                    if (iG <= 6) {
                        this.j = true;
                        throw ParserException.a("Malformed ADTS stream", null);
                    }
                    j += (long) iG;
                    i2++;
                    if (i2 == 1000) {
                        break;
                    }
                } catch (EOFException unused) {
                }
            } while (extractorInput.m(iG - 6, true));
            extractorInput.k();
            if (i2 > 0) {
                this.i = (int) (j / ((long) i2));
            } else {
                this.i = -1;
            }
            this.j = true;
        }
        int i3 = extractorInput.read(this.c.a, 0, 2048);
        boolean z2 = i3 == -1;
        if (!this.l) {
            int i4 = this.a;
            boolean z3 = (i4 & 1) != 0 && this.i > 0;
            if (!z3 || this.f1260b.r != -9223372036854775807L || z2) {
                if (z3) {
                    long j2 = this.f1260b.r;
                    if (j2 != -9223372036854775807L) {
                        ExtractorOutput extractorOutput = this.f;
                        boolean z4 = (2 & i4) != 0;
                        int i5 = this.i;
                        extractorOutput.a(new ConstantBitrateSeekMap(jB, this.h, (int) ((((long) (i5 * 8)) * 1000000) / j2), i5, z4));
                    } else {
                        this.f.a(new SeekMap.b(-9223372036854775807L, 0L));
                    }
                } else {
                    this.f.a(new SeekMap.b(-9223372036854775807L, 0L));
                }
                this.l = true;
            }
        }
        if (z2) {
            return -1;
        }
        this.c.E(0);
        this.c.D(i3);
        if (!this.k) {
            this.f1260b.f(this.g, 4);
            this.k = true;
        }
        this.f1260b.b(this.c);
        return 0;
    }

    @Override // b.i.a.c.x2.Extractor
    public void f(ExtractorOutput extractorOutput) {
        this.f = extractorOutput;
        this.f1260b.e(extractorOutput, new TsPayloadReader.d(Integer.MIN_VALUE, 0, 1));
        extractorOutput.j();
    }

    @Override // b.i.a.c.x2.Extractor
    public void g(long j, long j2) {
        this.k = false;
        this.f1260b.c();
        this.g = j2;
    }

    @Override // b.i.a.c.x2.Extractor
    public void release() {
    }
}
