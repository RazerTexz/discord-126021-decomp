package g0;

import java.io.Closeable;
import java.io.IOException;

/* JADX INFO: compiled from: Source.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface x extends Closeable {
    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close() throws IOException;

    long i0(e eVar, long j) throws IOException;

    y timeout();
}
