package b.f.d.d;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: renamed from: b.f.d.d.b, reason: use source file name */
/* JADX INFO: compiled from: CountingOutputStream.java */
/* JADX INFO: loaded from: classes.dex */
public class CountingOutputStream extends FilterOutputStream {
    public long j;

    public CountingOutputStream(OutputStream outputStream) {
        super(outputStream);
        this.j = 0L;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        ((FilterOutputStream) this).out.close();
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        ((FilterOutputStream) this).out.write(bArr, i, i2);
        this.j += (long) i2;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(int i) throws IOException {
        ((FilterOutputStream) this).out.write(i);
        this.j++;
    }
}
