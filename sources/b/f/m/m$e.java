package b.f.m;

import java.io.Closeable;
import java.io.IOException;

/* JADX INFO: compiled from: UnpackingSoSource.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class m$e implements Closeable {
    public abstract boolean a();

    public abstract m$d b() throws IOException;

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
    }
}
