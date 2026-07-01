package b.i.a.c.x2;

import androidx.annotation.Nullable;
import b.c.a.a0.AnimatableValueParser;
import b.i.a.c.x2.TrackOutput2;
import java.io.IOException;

/* JADX INFO: renamed from: b.i.a.c.x2.x, reason: use source file name */
/* JADX INFO: compiled from: TrueHdSampleRechunker.java */
/* JADX INFO: loaded from: classes3.dex */
public final class TrueHdSampleRechunker {
    public final byte[] a = new byte[10];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f1300b;
    public int c;
    public long d;
    public int e;
    public int f;
    public int g;

    public void a(TrackOutput2 trackOutput2, @Nullable TrackOutput2.a aVar) {
        if (this.c > 0) {
            trackOutput2.d(this.d, this.e, this.f, this.g, aVar);
            this.c = 0;
        }
    }

    public void b(TrackOutput2 trackOutput2, long j, int i, int i2, int i3, @Nullable TrackOutput2.a aVar) {
        AnimatableValueParser.E(this.g <= i2 + i3, "TrueHD chunk samples must be contiguous in the sample queue.");
        if (this.f1300b) {
            int i4 = this.c;
            int i5 = i4 + 1;
            this.c = i5;
            if (i4 == 0) {
                this.d = j;
                this.e = i;
                this.f = 0;
            }
            this.f += i2;
            this.g = i3;
            if (i5 >= 16) {
                a(trackOutput2, aVar);
            }
        }
    }

    public void c(ExtractorInput extractorInput) throws IOException {
        if (this.f1300b) {
            return;
        }
        int i = 0;
        extractorInput.o(this.a, 0, 10);
        extractorInput.k();
        byte[] bArr = this.a;
        if (bArr[4] == -8 && bArr[5] == 114 && bArr[6] == 111 && (bArr[7] & 254) == 186) {
            i = 40 << ((bArr[((bArr[7] & 255) == 187 ? 1 : 0) != 0 ? '\t' : '\b'] >> 4) & 7);
        }
        if (i == 0) {
            return;
        }
        this.f1300b = true;
    }
}
