package p615g0;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;

/* JADX INFO: renamed from: g0.v */
/* JADX INFO: compiled from: Sink.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface InterfaceC12405v extends Closeable, Flushable {
    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close() throws IOException;

    void flush() throws IOException;

    C12408y timeout();

    void write(C12388e c12388e, long j) throws IOException;
}
