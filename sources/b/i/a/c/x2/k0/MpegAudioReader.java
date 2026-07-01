package b.i.a.c.x2.k0;

import androidx.annotation.Nullable;
import b.c.a.a0.AnimatableValueParser;
import b.i.a.c.Format2;
import b.i.a.c.f3.ParsableByteArray;
import b.i.a.c.t2.MpegAudioUtil;
import b.i.a.c.x2.ExtractorOutput;
import b.i.a.c.x2.TrackOutput2;
import b.i.a.c.x2.k0.TsPayloadReader;

/* JADX INFO: renamed from: b.i.a.c.x2.k0.v, reason: use source file name */
/* JADX INFO: compiled from: MpegAudioReader.java */
/* JADX INFO: loaded from: classes3.dex */
public final class MpegAudioReader implements ElementaryStreamReader {
    public final ParsableByteArray a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MpegAudioUtil.a f1280b;

    @Nullable
    public final String c;
    public TrackOutput2 d;
    public String e;
    public int f = 0;
    public int g;
    public boolean h;
    public boolean i;
    public long j;
    public int k;
    public long l;

    public MpegAudioReader(@Nullable String str) {
        ParsableByteArray parsableByteArray = new ParsableByteArray(4);
        this.a = parsableByteArray;
        parsableByteArray.a[0] = -1;
        this.f1280b = new MpegAudioUtil.a();
        this.l = -9223372036854775807L;
        this.c = str;
    }

    @Override // b.i.a.c.x2.k0.ElementaryStreamReader
    public void b(ParsableByteArray parsableByteArray) {
        AnimatableValueParser.H(this.d);
        while (parsableByteArray.a() > 0) {
            int i = this.f;
            if (i == 0) {
                byte[] bArr = parsableByteArray.a;
                int i2 = parsableByteArray.f984b;
                int i3 = parsableByteArray.c;
                while (true) {
                    if (i2 >= i3) {
                        parsableByteArray.E(i3);
                        break;
                    }
                    boolean z2 = (bArr[i2] & 255) == 255;
                    boolean z3 = this.i && (bArr[i2] & 224) == 224;
                    this.i = z2;
                    if (z3) {
                        parsableByteArray.E(i2 + 1);
                        this.i = false;
                        this.a.a[1] = bArr[i2];
                        this.g = 2;
                        this.f = 1;
                        break;
                    }
                    i2++;
                }
            } else if (i == 1) {
                int iMin = Math.min(parsableByteArray.a(), 4 - this.g);
                parsableByteArray.e(this.a.a, this.g, iMin);
                int i4 = this.g + iMin;
                this.g = i4;
                if (i4 >= 4) {
                    this.a.E(0);
                    if (this.f1280b.a(this.a.f())) {
                        MpegAudioUtil.a aVar = this.f1280b;
                        this.k = aVar.c;
                        if (!this.h) {
                            long j = ((long) aVar.g) * 1000000;
                            int i5 = aVar.d;
                            this.j = j / ((long) i5);
                            Format2.b bVar = new Format2.b();
                            bVar.a = this.e;
                            bVar.k = aVar.f1116b;
                            bVar.l = 4096;
                            bVar.f1023x = aVar.e;
                            bVar.f1024y = i5;
                            bVar.c = this.c;
                            this.d.e(bVar.a());
                            this.h = true;
                        }
                        this.a.E(0);
                        this.d.c(this.a, 4);
                        this.f = 2;
                    } else {
                        this.g = 0;
                        this.f = 1;
                    }
                }
            } else {
                if (i != 2) {
                    throw new IllegalStateException();
                }
                int iMin2 = Math.min(parsableByteArray.a(), this.k - this.g);
                this.d.c(parsableByteArray, iMin2);
                int i6 = this.g + iMin2;
                this.g = i6;
                int i7 = this.k;
                if (i6 >= i7) {
                    long j2 = this.l;
                    if (j2 != -9223372036854775807L) {
                        this.d.d(j2, 1, i7, 0, null);
                        this.l += this.j;
                    }
                    this.g = 0;
                    this.f = 0;
                }
            }
        }
    }

    @Override // b.i.a.c.x2.k0.ElementaryStreamReader
    public void c() {
        this.f = 0;
        this.g = 0;
        this.i = false;
        this.l = -9223372036854775807L;
    }

    @Override // b.i.a.c.x2.k0.ElementaryStreamReader
    public void d() {
    }

    @Override // b.i.a.c.x2.k0.ElementaryStreamReader
    public void e(ExtractorOutput extractorOutput, TsPayloadReader.d dVar) {
        dVar.a();
        this.e = dVar.b();
        this.d = extractorOutput.p(dVar.c(), 1);
    }

    @Override // b.i.a.c.x2.k0.ElementaryStreamReader
    public void f(long j, int i) {
        if (j != -9223372036854775807L) {
            this.l = j;
        }
    }
}
