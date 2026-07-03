package p007b.p109f.p115d.p119d;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: renamed from: b.f.d.d.b */
/* JADX INFO: compiled from: CountingOutputStream.java */
/* JADX INFO: loaded from: classes.dex */
public class C1679b extends FilterOutputStream {

    /* JADX INFO: renamed from: j */
    public long f3092j;

    public C1679b(OutputStream outputStream) {
        super(outputStream);
        this.f3092j = 0L;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        ((FilterOutputStream) this).out.close();
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        ((FilterOutputStream) this).out.write(bArr, i, i2);
        this.f3092j += (long) i2;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(int i) throws IOException {
        ((FilterOutputStream) this).out.write(i);
        this.f3092j++;
    }
}
