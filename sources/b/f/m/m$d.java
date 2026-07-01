package b.f.m;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: UnpackingSoSource.java */
/* JADX INFO: loaded from: classes3.dex */
public final class m$d implements Closeable {
    public final m$b j;
    public final InputStream k;

    public m$d(m$b m_b, InputStream inputStream) {
        this.j = m_b;
        this.k = inputStream;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.k.close();
    }
}
