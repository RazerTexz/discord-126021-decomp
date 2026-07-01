package b.f.m;

import java.io.Closeable;
import java.io.IOException;

/* JADX INFO: compiled from: UnpackingSoSource.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class m$f implements Closeable {
    public abstract m$c a() throws IOException;

    public abstract m$e b() throws IOException;

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
    }
}
