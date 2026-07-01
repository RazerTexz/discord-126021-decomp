package b.i.a.c.x2.g0;

import b.i.a.c.f3.ParsableByteArray;
import b.i.a.c.x2.ExtractorInput;
import java.io.IOException;

/* JADX INFO: renamed from: b.i.a.c.x2.g0.f, reason: use source file name */
/* JADX INFO: compiled from: Sniffer.java */
/* JADX INFO: loaded from: classes3.dex */
public final class Sniffer {
    public final ParsableByteArray a = new ParsableByteArray(8);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f1201b;

    public final long a(ExtractorInput extractorInput) throws IOException {
        int i = 0;
        extractorInput.o(this.a.a, 0, 1);
        int i2 = this.a.a[0] & 255;
        if (i2 == 0) {
            return Long.MIN_VALUE;
        }
        int i3 = 128;
        int i4 = 0;
        while ((i2 & i3) == 0) {
            i3 >>= 1;
            i4++;
        }
        int i5 = i2 & (~i3);
        extractorInput.o(this.a.a, 1, i4);
        while (i < i4) {
            i++;
            i5 = (this.a.a[i] & 255) + (i5 << 8);
        }
        this.f1201b = i4 + 1 + this.f1201b;
        return i5;
    }
}
