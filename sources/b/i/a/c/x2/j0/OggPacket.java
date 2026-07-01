package b.i.a.c.x2.j0;

import b.c.a.a0.AnimatableValueParser;
import b.i.a.c.f3.ParsableByteArray;
import b.i.a.c.x2.ExtractorInput;
import java.io.EOFException;
import java.io.IOException;

/* JADX INFO: renamed from: b.i.a.c.x2.j0.e, reason: use source file name */
/* JADX INFO: compiled from: OggPacket.java */
/* JADX INFO: loaded from: classes3.dex */
public final class OggPacket {
    public final OggPageHeader a = new OggPageHeader();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ParsableByteArray f1237b = new ParsableByteArray(new byte[65025], 0);
    public int c = -1;
    public int d;
    public boolean e;

    public final int a(int i) {
        int i2;
        int i3 = 0;
        this.d = 0;
        do {
            int i4 = this.d;
            int i5 = i + i4;
            OggPageHeader oggPageHeader = this.a;
            if (i5 >= oggPageHeader.d) {
                break;
            }
            int[] iArr = oggPageHeader.g;
            this.d = i4 + 1;
            i2 = iArr[i4 + i];
            i3 += i2;
        } while (i2 == 255);
        return i3;
    }

    public boolean b(ExtractorInput extractorInput) throws IOException {
        boolean z2;
        int i;
        boolean z3;
        AnimatableValueParser.D(extractorInput != null);
        if (this.e) {
            this.e = false;
            this.f1237b.A(0);
        }
        while (!this.e) {
            if (this.c < 0) {
                if (!this.a.c(extractorInput, -1L) || !this.a.a(extractorInput, true)) {
                    return false;
                }
                OggPageHeader oggPageHeader = this.a;
                int iA = oggPageHeader.e;
                if ((oggPageHeader.f1238b & 1) == 1 && this.f1237b.c == 0) {
                    iA += a(0);
                    i = this.d + 0;
                } else {
                    i = 0;
                }
                try {
                    extractorInput.l(iA);
                    z3 = true;
                } catch (EOFException unused) {
                    z3 = false;
                }
                if (!z3) {
                    return false;
                }
                this.c = i;
            }
            int iA2 = a(this.c);
            int i2 = this.c + this.d;
            if (iA2 > 0) {
                ParsableByteArray parsableByteArray = this.f1237b;
                parsableByteArray.b(parsableByteArray.c + iA2);
                ParsableByteArray parsableByteArray2 = this.f1237b;
                try {
                    extractorInput.readFully(parsableByteArray2.a, parsableByteArray2.c, iA2);
                    z2 = true;
                } catch (EOFException unused2) {
                    z2 = false;
                }
                if (!z2) {
                    return false;
                }
                ParsableByteArray parsableByteArray3 = this.f1237b;
                parsableByteArray3.D(parsableByteArray3.c + iA2);
                this.e = this.a.g[i2 + (-1)] != 255;
            }
            if (i2 == this.a.d) {
                i2 = -1;
            }
            this.c = i2;
        }
        return true;
    }
}
