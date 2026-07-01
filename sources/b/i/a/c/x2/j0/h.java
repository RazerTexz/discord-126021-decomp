package b.i.a.c.x2.j0;

import b.i.a.c.f3.x;
import b.i.a.c.j1$b;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;

/* JADX INFO: compiled from: OpusReader.java */
/* JADX INFO: loaded from: classes3.dex */
public final class h extends i {
    public static final byte[] n = {79, 112, 117, 115, 72, 101, 97, 100};
    public boolean o;

    @Override // b.i.a.c.x2.j0.i
    public long c(x xVar) {
        int i;
        byte[] bArr = xVar.a;
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

    @Override // b.i.a.c.x2.j0.i
    @EnsuresNonNullIf(expression = {"#3.format"}, result = false)
    public boolean d(x xVar, long j, i$b i_b) {
        if (this.o) {
            Objects.requireNonNull(i_b.a);
            boolean z2 = xVar.f() == 1332770163;
            xVar.E(0);
            return z2;
        }
        byte[] bArrCopyOf = Arrays.copyOf(xVar.a, xVar.c);
        int i = bArrCopyOf[9] & 255;
        List<byte[]> listG = b.c.a.a0.d.g(bArrCopyOf);
        j1$b j1_b = new j1$b();
        j1_b.k = "audio/opus";
        j1_b.f1023x = i;
        j1_b.f1024y = 48000;
        j1_b.m = listG;
        i_b.a = j1_b.a();
        this.o = true;
        return true;
    }

    @Override // b.i.a.c.x2.j0.i
    public void e(boolean z2) {
        super.e(z2);
        if (z2) {
            this.o = false;
        }
    }
}
