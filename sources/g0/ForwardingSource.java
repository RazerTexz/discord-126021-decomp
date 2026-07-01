package g0;

import d0.z.d.Intrinsics3;
import java.io.IOException;

/* JADX INFO: renamed from: g0.j, reason: use source file name */
/* JADX INFO: compiled from: ForwardingSource.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class ForwardingSource implements Source2 {
    public final Source2 j;

    public ForwardingSource(Source2 source2) {
        Intrinsics3.checkParameterIsNotNull(source2, "delegate");
        this.j = source2;
    }

    @Override // g0.Source2, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.j.close();
    }

    @Override // g0.Source2
    public Timeout2 timeout() {
        return this.j.timeout();
    }

    public String toString() {
        return getClass().getSimpleName() + '(' + this.j + ')';
    }
}
