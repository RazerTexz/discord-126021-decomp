package b.i.a.c.x2.j0;

import b.c.a.a0.AnimatableValueParser;
import b.i.a.c.f3.ParsableByteArray;
import b.i.a.c.x2.ExtractorInput;
import com.google.android.exoplayer2.ParserException;
import java.io.IOException;

/* JADX INFO: renamed from: b.i.a.c.x2.j0.f, reason: use source file name */
/* JADX INFO: compiled from: OggPageHeader.java */
/* JADX INFO: loaded from: classes3.dex */
public final class OggPageHeader {
    public int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f1238b;
    public long c;
    public int d;
    public int e;
    public int f;
    public final int[] g = new int[255];
    public final ParsableByteArray h = new ParsableByteArray(255);

    public boolean a(ExtractorInput extractorInput, boolean z2) throws IOException {
        b();
        this.h.A(27);
        if (!AnimatableValueParser.x1(extractorInput, this.h.a, 0, 27, z2) || this.h.u() != 1332176723) {
            return false;
        }
        int iT = this.h.t();
        this.a = iT;
        if (iT != 0) {
            if (z2) {
                return false;
            }
            throw ParserException.b("unsupported bit stream revision");
        }
        this.f1238b = this.h.t();
        ParsableByteArray parsableByteArray = this.h;
        byte[] bArr = parsableByteArray.a;
        int i = parsableByteArray.f984b;
        int i2 = i + 1;
        parsableByteArray.f984b = i2;
        long j = ((long) bArr[i]) & 255;
        int i3 = i2 + 1;
        parsableByteArray.f984b = i3;
        long j2 = j | ((((long) bArr[i2]) & 255) << 8);
        int i4 = i3 + 1;
        parsableByteArray.f984b = i4;
        long j3 = j2 | ((((long) bArr[i3]) & 255) << 16);
        int i5 = i4 + 1;
        parsableByteArray.f984b = i5;
        long j4 = j3 | ((((long) bArr[i4]) & 255) << 24);
        int i6 = i5 + 1;
        parsableByteArray.f984b = i6;
        long j5 = j4 | ((((long) bArr[i5]) & 255) << 32);
        int i7 = i6 + 1;
        parsableByteArray.f984b = i7;
        long j6 = j5 | ((((long) bArr[i6]) & 255) << 40);
        int i8 = i7 + 1;
        parsableByteArray.f984b = i8;
        long j7 = j6 | ((((long) bArr[i7]) & 255) << 48);
        parsableByteArray.f984b = i8 + 1;
        this.c = j7 | ((((long) bArr[i8]) & 255) << 56);
        parsableByteArray.j();
        this.h.j();
        this.h.j();
        int iT2 = this.h.t();
        this.d = iT2;
        this.e = iT2 + 27;
        this.h.A(iT2);
        if (!AnimatableValueParser.x1(extractorInput, this.h.a, 0, this.d, z2)) {
            return false;
        }
        for (int i9 = 0; i9 < this.d; i9++) {
            this.g[i9] = this.h.t();
            this.f += this.g[i9];
        }
        return true;
    }

    public void b() {
        this.a = 0;
        this.f1238b = 0;
        this.c = 0L;
        this.d = 0;
        this.e = 0;
        this.f = 0;
    }

    public boolean c(ExtractorInput extractorInput, long j) throws IOException {
        AnimatableValueParser.j(extractorInput.getPosition() == extractorInput.f());
        this.h.A(4);
        while (true) {
            if ((j != -1 && extractorInput.getPosition() + 4 >= j) || !AnimatableValueParser.x1(extractorInput, this.h.a, 0, 4, true)) {
                break;
            }
            this.h.E(0);
            if (this.h.u() == 1332176723) {
                extractorInput.k();
                return true;
            }
            extractorInput.l(1);
        }
        do {
            if (j != -1 && extractorInput.getPosition() >= j) {
                break;
            }
        } while (extractorInput.h(1) != -1);
        return false;
    }
}
