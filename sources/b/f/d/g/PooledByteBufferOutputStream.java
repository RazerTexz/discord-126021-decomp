package b.f.d.g;

import b.f.d.d.Throwables;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: renamed from: b.f.d.g.i, reason: use source file name */
/* JADX INFO: compiled from: PooledByteBufferOutputStream.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class PooledByteBufferOutputStream extends OutputStream {
    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws Throwable {
        try {
            super.close();
        } catch (IOException e) {
            Throwables.a(e);
            throw new RuntimeException(e);
        }
    }
}
