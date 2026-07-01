package b.i.a.c.f3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: compiled from: AtomicFile.java */
/* JADX INFO: loaded from: classes3.dex */
public final class e$a extends OutputStream {
    public final FileOutputStream j;
    public boolean k = false;

    public e$a(File file) throws FileNotFoundException {
        this.j = new FileOutputStream(file);
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.k) {
            return;
        }
        this.k = true;
        this.j.flush();
        try {
            this.j.getFD().sync();
        } catch (IOException e) {
            q.c("AtomicFile", "Failed to sync file descriptor:", e);
        }
        this.j.close();
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        this.j.flush();
    }

    @Override // java.io.OutputStream
    public void write(int i) throws IOException {
        this.j.write(i);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        this.j.write(bArr);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        this.j.write(bArr, i, i2);
    }
}
