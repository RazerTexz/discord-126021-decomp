package g0;

import java.io.OutputStream;

/* JADX INFO: compiled from: Buffer.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class f extends OutputStream {
    public final /* synthetic */ e j;

    public f(e eVar) {
        this.j = eVar;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() {
    }

    public String toString() {
        return this.j + ".outputStream()";
    }

    @Override // java.io.OutputStream
    public void write(int i) {
        this.j.T(i);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) {
        d0.z.d.m.checkParameterIsNotNull(bArr, "data");
        this.j.S(bArr, i, i2);
    }
}
