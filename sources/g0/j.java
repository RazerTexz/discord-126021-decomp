package g0;

import java.io.IOException;

/* JADX INFO: compiled from: ForwardingSource.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class j implements x {
    public final x j;

    public j(x xVar) {
        d0.z.d.m.checkParameterIsNotNull(xVar, "delegate");
        this.j = xVar;
    }

    @Override // g0.x, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.j.close();
    }

    @Override // g0.x
    public y timeout() {
        return this.j.timeout();
    }

    public String toString() {
        return getClass().getSimpleName() + '(' + this.j + ')';
    }
}
