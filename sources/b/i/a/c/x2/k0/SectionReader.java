package b.i.a.c.x2.k0;

import androidx.core.view.InputDeviceCompat;
import b.i.a.c.f3.ParsableByteArray;
import b.i.a.c.f3.TimestampAdjuster;
import b.i.a.c.f3.Util2;
import b.i.a.c.x2.ExtractorOutput;
import b.i.a.c.x2.k0.TsPayloadReader;

/* JADX INFO: renamed from: b.i.a.c.x2.k0.d0, reason: use source file name */
/* JADX INFO: compiled from: SectionReader.java */
/* JADX INFO: loaded from: classes3.dex */
public final class SectionReader implements TsPayloadReader {
    public final SectionPayloadReader a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ParsableByteArray f1245b = new ParsableByteArray(32);
    public int c;
    public int d;
    public boolean e;
    public boolean f;

    public SectionReader(SectionPayloadReader sectionPayloadReader) {
        this.a = sectionPayloadReader;
    }

    @Override // b.i.a.c.x2.k0.TsPayloadReader
    public void a(TimestampAdjuster timestampAdjuster, ExtractorOutput extractorOutput, TsPayloadReader.d dVar) {
        this.a.a(timestampAdjuster, extractorOutput, dVar);
        this.f = true;
    }

    @Override // b.i.a.c.x2.k0.TsPayloadReader
    public void b(ParsableByteArray parsableByteArray, int i) {
        boolean z2 = (i & 1) != 0;
        int iT = z2 ? parsableByteArray.f984b + parsableByteArray.t() : -1;
        if (this.f) {
            if (!z2) {
                return;
            }
            this.f = false;
            parsableByteArray.E(iT);
            this.d = 0;
        }
        while (parsableByteArray.a() > 0) {
            int i2 = this.d;
            if (i2 < 3) {
                if (i2 == 0) {
                    int iT2 = parsableByteArray.t();
                    parsableByteArray.E(parsableByteArray.f984b - 1);
                    if (iT2 == 255) {
                        this.f = true;
                        return;
                    }
                }
                int iMin = Math.min(parsableByteArray.a(), 3 - this.d);
                parsableByteArray.e(this.f1245b.a, this.d, iMin);
                int i3 = this.d + iMin;
                this.d = i3;
                if (i3 == 3) {
                    this.f1245b.E(0);
                    this.f1245b.D(3);
                    this.f1245b.F(1);
                    int iT3 = this.f1245b.t();
                    int iT4 = this.f1245b.t();
                    this.e = (iT3 & 128) != 0;
                    int i4 = (((iT3 & 15) << 8) | iT4) + 3;
                    this.c = i4;
                    byte[] bArr = this.f1245b.a;
                    if (bArr.length < i4) {
                        this.f1245b.b(Math.min(InputDeviceCompat.SOURCE_TOUCHSCREEN, Math.max(i4, bArr.length * 2)));
                    }
                }
            } else {
                int iMin2 = Math.min(parsableByteArray.a(), this.c - this.d);
                parsableByteArray.e(this.f1245b.a, this.d, iMin2);
                int i5 = this.d + iMin2;
                this.d = i5;
                int i6 = this.c;
                if (i5 != i6) {
                    continue;
                } else {
                    if (this.e) {
                        byte[] bArr2 = this.f1245b.a;
                        int i7 = Util2.a;
                        int i8 = -1;
                        for (int i9 = 0; i9 < i6; i9++) {
                            i8 = Util2.k[((i8 >>> 24) ^ (bArr2[i9] & 255)) & 255] ^ (i8 << 8);
                        }
                        if (i8 != 0) {
                            this.f = true;
                            return;
                        }
                        this.f1245b.D(this.c - 4);
                    } else {
                        this.f1245b.D(i6);
                    }
                    this.f1245b.E(0);
                    this.a.b(this.f1245b);
                    this.d = 0;
                }
            }
        }
    }

    @Override // b.i.a.c.x2.k0.TsPayloadReader
    public void c() {
        this.f = true;
    }
}
