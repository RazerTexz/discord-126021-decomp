package g0;

import java.io.Closeable;
import java.io.IOException;

/* JADX INFO: renamed from: g0.x, reason: use source file name */
/* JADX INFO: compiled from: Source.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface Source2 extends Closeable {
    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close() throws IOException;

    long i0(Buffer3 buffer3, long j) throws IOException;

    Timeout2 timeout();
}
