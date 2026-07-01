package b.i.a.c.x2.g0;

import b.i.a.c.x2.ExtractorInput;
import java.io.IOException;

/* JADX INFO: renamed from: b.i.a.c.x2.g0.g, reason: use source file name */
/* JADX INFO: compiled from: VarintReader.java */
/* JADX INFO: loaded from: classes3.dex */
public final class VarintReader {
    public static final long[] a = {128, 64, 32, 16, 8, 4, 2, 1};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f1202b = new byte[8];
    public int c;
    public int d;

    public static long a(byte[] bArr, int i, boolean z2) {
        long j = ((long) bArr[0]) & 255;
        if (z2) {
            j &= ~a[i - 1];
        }
        for (int i2 = 1; i2 < i; i2++) {
            j = (j << 8) | (((long) bArr[i2]) & 255);
        }
        return j;
    }

    public static int b(int i) {
        int i2 = 0;
        while (true) {
            long[] jArr = a;
            if (i2 >= jArr.length) {
                return -1;
            }
            if ((jArr[i2] & ((long) i)) != 0) {
                return i2 + 1;
            }
            i2++;
        }
    }

    public long c(ExtractorInput extractorInput, boolean z2, boolean z3, int i) throws IOException {
        if (this.c == 0) {
            if (!extractorInput.c(this.f1202b, 0, 1, z2)) {
                return -1L;
            }
            int iB = b(this.f1202b[0] & 255);
            this.d = iB;
            if (iB == -1) {
                throw new IllegalStateException("No valid varint length mask found");
            }
            this.c = 1;
        }
        int i2 = this.d;
        if (i2 > i) {
            this.c = 0;
            return -2L;
        }
        if (i2 != 1) {
            extractorInput.readFully(this.f1202b, 1, i2 - 1);
        }
        this.c = 0;
        return a(this.f1202b, this.d, z3);
    }
}
