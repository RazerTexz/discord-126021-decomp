package b.i.c.m.d.l;

import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

/* JADX INFO: compiled from: QueueFile.java */
/* JADX INFO: loaded from: classes3.dex */
public final class c$c extends InputStream {
    public int j;
    public int k;
    public final /* synthetic */ c l;

    public c$c(c cVar, c$b c_b, c$a c_a) {
        this.l = cVar;
        int i = c_b.f1709b + 4;
        int i2 = cVar.l;
        this.j = i >= i2 ? (i + 16) - i2 : i;
        this.k = c_b.c;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        Objects.requireNonNull(bArr, "buffer");
        if ((i | i2) < 0 || i2 > bArr.length - i) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int i3 = this.k;
        if (i3 <= 0) {
            return -1;
        }
        if (i2 > i3) {
            i2 = i3;
        }
        this.l.t(this.j, bArr, i, i2);
        this.j = c.a(this.l, this.j + i2);
        this.k -= i2;
        return i2;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (this.k == 0) {
            return -1;
        }
        this.l.k.seek(this.j);
        int i = this.l.k.read();
        this.j = c.a(this.l, this.j + 1);
        this.k--;
        return i;
    }
}
