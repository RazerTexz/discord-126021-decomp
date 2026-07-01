package b.f.d.g;

import b.f.d.d.m;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: compiled from: PooledByteBufferOutputStream.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class i extends OutputStream {
    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws Throwable {
        try {
            super.close();
        } catch (IOException e) {
            m.a(e);
            throw new RuntimeException(e);
        }
    }
}
