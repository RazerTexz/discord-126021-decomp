package b.i.a.c.x2.j0;

import b.c.a.a0.AnimatableValueParser;
import b.i.a.c.Format2;
import b.i.a.c.f3.ParsableByteArray;
import b.i.a.c.x2.j0.StreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;

/* JADX INFO: renamed from: b.i.a.c.x2.j0.h, reason: use source file name */
/* JADX INFO: compiled from: OpusReader.java */
/* JADX INFO: loaded from: classes3.dex */
public final class OpusReader extends StreamReader {
    public static final byte[] n = {79, 112, 117, 115, 72, 101, 97, 100};
    public boolean o;

    @Override // b.i.a.c.x2.j0.StreamReader
    public long c(ParsableByteArray parsableByteArray) {
        int i;
        byte[] bArr = parsableByteArray.a;
        int i2 = bArr[0] & 255;
        int i3 = i2 & 3;
        int i4 = 2;
        if (i3 == 0) {
            i4 = 1;
        } else if (i3 != 1 && i3 != 2) {
            i4 = bArr[1] & 63;
        }
        int i5 = i2 >> 3;
        int i6 = i5 & 3;
        if (i5 >= 16) {
            i = 2500 << i6;
        } else if (i5 >= 12) {
            i = 10000 << (i6 & 1);
        } else {
            i = i6 == 3 ? 60000 : 10000 << i6;
        }
        return a(((long) i4) * ((long) i));
    }

    @Override // b.i.a.c.x2.j0.StreamReader
    @EnsuresNonNullIf(expression = {"#3.format"}, result = false)
    public boolean d(ParsableByteArray parsableByteArray, long j, StreamReader.b bVar) {
        if (this.o) {
            Objects.requireNonNull(bVar.a);
            boolean z2 = parsableByteArray.f() == 1332770163;
            parsableByteArray.E(0);
            return z2;
        }
        byte[] bArrCopyOf = Arrays.copyOf(parsableByteArray.a, parsableByteArray.c);
        int i = bArrCopyOf[9] & 255;
        List<byte[]> listG = AnimatableValueParser.g(bArrCopyOf);
        Format2.b bVar2 = new Format2.b();
        bVar2.k = "audio/opus";
        bVar2.f1023x = i;
        bVar2.f1024y = 48000;
        bVar2.m = listG;
        bVar.a = bVar2.a();
        this.o = true;
        return true;
    }

    @Override // b.i.a.c.x2.j0.StreamReader
    public void e(boolean z2) {
        super.e(z2);
        if (z2) {
            this.o = false;
        }
    }
}
