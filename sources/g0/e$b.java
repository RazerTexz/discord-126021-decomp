package g0;

import java.io.InputStream;

/* JADX INFO: compiled from: Buffer.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class e$b extends InputStream {
    public final /* synthetic */ e j;

    public e$b(e eVar) {
        this.j = eVar;
    }

    @Override // java.io.InputStream
    public int available() {
        return (int) Math.min(this.j.k, Integer.MAX_VALUE);
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // java.io.InputStream
    public int read() {
        e eVar = this.j;
        if (eVar.k > 0) {
            return eVar.readByte() & 255;
        }
        return -1;
    }

    public String toString() {
        return this.j + ".inputStream()";
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) {
        d0.z.d.m.checkParameterIsNotNull(bArr, "sink");
        return this.j.read(bArr, i, i2);
    }
}
