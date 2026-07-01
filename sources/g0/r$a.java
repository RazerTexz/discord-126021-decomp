package g0;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: RealBufferedSource.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class r$a extends InputStream {
    public final /* synthetic */ r j;

    public r$a(r rVar) {
        this.j = rVar;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        r rVar = this.j;
        if (rVar.k) {
            throw new IOException("closed");
        }
        return (int) Math.min(rVar.j.k, Integer.MAX_VALUE);
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.j.close();
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        r rVar = this.j;
        if (rVar.k) {
            throw new IOException("closed");
        }
        e eVar = rVar.j;
        if (eVar.k == 0 && rVar.l.i0(eVar, 8192) == -1) {
            return -1;
        }
        return this.j.j.readByte() & 255;
    }

    public String toString() {
        return this.j + ".inputStream()";
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        d0.z.d.m.checkParameterIsNotNull(bArr, "data");
        if (!this.j.k) {
            b.i.a.f.e.o.f.B(bArr.length, i, i2);
            r rVar = this.j;
            e eVar = rVar.j;
            if (eVar.k == 0 && rVar.l.i0(eVar, 8192) == -1) {
                return -1;
            }
            return this.j.j.read(bArr, i, i2);
        }
        throw new IOException("closed");
    }
}
