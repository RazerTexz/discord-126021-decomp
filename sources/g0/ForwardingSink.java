package g0;

import d0.z.d.Intrinsics3;
import java.io.IOException;

/* JADX INFO: renamed from: g0.i, reason: use source file name */
/* JADX INFO: compiled from: ForwardingSink.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class ForwardingSink implements Sink {
    private final Sink delegate;

    public ForwardingSink(Sink sink) {
        Intrinsics3.checkParameterIsNotNull(sink, "delegate");
        this.delegate = sink;
    }

    /* JADX INFO: renamed from: -deprecated_delegate, reason: not valid java name */
    public final Sink m114deprecated_delegate() {
        return this.delegate;
    }

    @Override // g0.Sink, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.delegate.close();
    }

    public final Sink delegate() {
        return this.delegate;
    }

    @Override // g0.Sink, java.io.Flushable
    public void flush() throws IOException {
        this.delegate.flush();
    }

    @Override // g0.Sink
    public Timeout2 timeout() {
        return this.delegate.timeout();
    }

    public String toString() {
        return getClass().getSimpleName() + '(' + this.delegate + ')';
    }

    @Override // g0.Sink
    public void write(Buffer3 buffer3, long j) throws IOException {
        Intrinsics3.checkParameterIsNotNull(buffer3, "source");
        this.delegate.write(buffer3, j);
    }
}
