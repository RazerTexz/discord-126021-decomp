package g0;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import java.io.IOException;

/* JADX INFO: renamed from: g0.d, reason: use source file name */
/* JADX INFO: compiled from: AsyncTimeout.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class AsyncTimeout3 implements Source2 {
    public final /* synthetic */ AsyncTimeout j;
    public final /* synthetic */ Source2 k;

    public AsyncTimeout3(AsyncTimeout asyncTimeout, Source2 source2) {
        this.j = asyncTimeout;
        this.k = source2;
    }

    @Override // g0.Source2, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        AsyncTimeout asyncTimeout = this.j;
        asyncTimeout.i();
        try {
            try {
                this.k.close();
                if (asyncTimeout.j()) {
                    throw asyncTimeout.k(null);
                }
            } catch (IOException e) {
                if (!asyncTimeout.j()) {
                    throw e;
                }
                throw asyncTimeout.k(e);
            }
        } catch (Throwable th) {
            asyncTimeout.j();
            throw th;
        }
    }

    @Override // g0.Source2
    public long i0(Buffer3 buffer3, long j) throws IOException {
        Intrinsics3.checkParameterIsNotNull(buffer3, "sink");
        AsyncTimeout asyncTimeout = this.j;
        asyncTimeout.i();
        try {
            try {
                long jI0 = this.k.i0(buffer3, j);
                if (asyncTimeout.j()) {
                    throw asyncTimeout.k(null);
                }
                return jI0;
            } catch (IOException e) {
                if (asyncTimeout.j()) {
                    throw asyncTimeout.k(e);
                }
                throw e;
            }
        } catch (Throwable th) {
            asyncTimeout.j();
            throw th;
        }
    }

    @Override // g0.Source2
    public Timeout2 timeout() {
        return this.j;
    }

    public String toString() {
        StringBuilder sbU = outline.U("AsyncTimeout.source(");
        sbU.append(this.k);
        sbU.append(')');
        return sbU.toString();
    }
}
