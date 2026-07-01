package b.i.a.b.j;

import java.io.Closeable;
import java.io.IOException;

/* JADX INFO: renamed from: b.i.a.b.j.o, reason: use source file name */
/* JADX INFO: compiled from: TransportRuntimeComponent.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class TransportRuntimeComponent implements Closeable {
    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        ((DaggerTransportRuntimeComponent) this).o.get().close();
    }
}
