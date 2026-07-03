package p007b.p109f.p115d.p122g;

import java.io.IOException;
import java.io.OutputStream;
import p007b.p109f.p115d.p119d.C1690m;

/* JADX INFO: renamed from: b.f.d.g.i */
/* JADX INFO: compiled from: PooledByteBufferOutputStream.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1702i extends OutputStream {
    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws Throwable {
        try {
            super.close();
        } catch (IOException e) {
            C1690m.m972a(e);
            throw new RuntimeException(e);
        }
    }
}
