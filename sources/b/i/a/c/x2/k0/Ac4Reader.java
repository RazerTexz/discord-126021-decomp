package b.i.a.c.x2.k0;

import androidx.annotation.Nullable;
import b.c.a.a0.AnimatableValueParser;
import b.i.a.c.Format2;
import b.i.a.c.f3.ParsableBitArray;
import b.i.a.c.f3.ParsableByteArray;
import b.i.a.c.t2.Ac4Util;
import b.i.a.c.x2.ExtractorOutput;
import b.i.a.c.x2.TrackOutput2;
import b.i.a.c.x2.k0.TsPayloadReader;

/* JADX INFO: renamed from: b.i.a.c.x2.k0.i, reason: use source file name */
/* JADX INFO: compiled from: Ac4Reader.java */
/* JADX INFO: loaded from: classes3.dex */
public final class Ac4Reader implements ElementaryStreamReader {
    public final ParsableBitArray a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ParsableByteArray f1256b;

    @Nullable
    public final String c;
    public String d;
    public TrackOutput2 e;
    public int f;
    public int g;
    public boolean h;
    public boolean i;
    public long j;
    public Format2 k;
    public int l;
    public long m;

    public Ac4Reader(@Nullable String str) {
        ParsableBitArray parsableBitArray = new ParsableBitArray(new byte[16]);
        this.a = parsableBitArray;
        this.f1256b = new ParsableByteArray(parsableBitArray.a);
        this.f = 0;
        this.g = 0;
        this.h = false;
        this.i = false;
        this.m = -9223372036854775807L;
        this.c = str;
    }

    @Override // b.i.a.c.x2.k0.ElementaryStreamReader
    public void b(ParsableByteArray parsableByteArray) {
        boolean z2;
        AnimatableValueParser.H(this.e);
        while (parsableByteArray.a() > 0) {
            int i = this.f;
            if (i == 0) {
                while (true) {
                    if (parsableByteArray.a() <= 0) {
                        z2 = false;
                        break;
                    }
                    if (this.h) {
                        int iT = parsableByteArray.t();
                        this.h = iT == 172;
                        if (iT == 64 || iT == 65) {
                            this.i = iT == 65;
                            z2 = true;
                            break;
                        }
                    } else {
                        this.h = parsableByteArray.t() == 172;
                    }
                }
                if (z2) {
                    this.f = 1;
                    byte[] bArr = this.f1256b.a;
                    bArr[0] = -84;
                    bArr[1] = (byte) (this.i ? 65 : 64);
                    this.g = 2;
                }
            } else if (i == 1) {
                byte[] bArr2 = this.f1256b.a;
                int iMin = Math.min(parsableByteArray.a(), 16 - this.g);
                System.arraycopy(parsableByteArray.a, parsableByteArray.f984b, bArr2, this.g, iMin);
                parsableByteArray.f984b += iMin;
                int i2 = this.g + iMin;
                this.g = i2;
                if (i2 == 16) {
                    this.a.k(0);
                    Ac4Util.b bVarB = Ac4Util.b(this.a);
                    Format2 format2 = this.k;
                    if (format2 == null || 2 != format2.J || bVarB.a != format2.K || !"audio/ac4".equals(format2.w)) {
                        Format2.b bVar = new Format2.b();
                        bVar.a = this.d;
                        bVar.k = "audio/ac4";
                        bVar.f1023x = 2;
                        bVar.f1024y = bVarB.a;
                        bVar.c = this.c;
                        Format2 format2A = bVar.a();
                        this.k = format2A;
                        this.e.e(format2A);
                    }
                    this.l = bVarB.f1124b;
                    this.j = (((long) bVarB.c) * 1000000) / ((long) this.k.K);
                    this.f1256b.E(0);
                    this.e.c(this.f1256b, 16);
                    this.f = 2;
                }
            } else if (i == 2) {
                int iMin2 = Math.min(parsableByteArray.a(), this.l - this.g);
                this.e.c(parsableByteArray, iMin2);
                int i3 = this.g + iMin2;
                this.g = i3;
                int i4 = this.l;
                if (i3 == i4) {
                    long j = this.m;
                    if (j != -9223372036854775807L) {
                        this.e.d(j, 1, i4, 0, null);
                        this.m += this.j;
                    }
                    this.f = 0;
                }
            }
        }
    }

    @Override // b.i.a.c.x2.k0.ElementaryStreamReader
    public void c() {
        this.f = 0;
        this.g = 0;
        this.h = false;
        this.i = false;
        this.m = -9223372036854775807L;
    }

    @Override // b.i.a.c.x2.k0.ElementaryStreamReader
    public void d() {
    }

    @Override // b.i.a.c.x2.k0.ElementaryStreamReader
    public void e(ExtractorOutput extractorOutput, TsPayloadReader.d dVar) {
        dVar.a();
        this.d = dVar.b();
        this.e = extractorOutput.p(dVar.c(), 1);
    }

    @Override // b.i.a.c.x2.k0.ElementaryStreamReader
    public void f(long j, int i) {
        if (j != -9223372036854775807L) {
            this.m = j;
        }
    }
}
