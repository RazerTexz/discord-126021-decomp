package g0;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import java.io.IOException;

/* JADX INFO: renamed from: g0.c, reason: use source file name */
/* JADX INFO: compiled from: AsyncTimeout.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class AsyncTimeout2 implements Sink {
    public final /* synthetic */ AsyncTimeout j;
    public final /* synthetic */ Sink k;

    public AsyncTimeout2(AsyncTimeout asyncTimeout, Sink sink) {
        this.j = asyncTimeout;
        this.k = sink;
    }

    @Override // g0.Sink, java.io.Closeable, java.lang.AutoCloseable
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

    @Override // g0.Sink, java.io.Flushable
    public void flush() throws IOException {
        AsyncTimeout asyncTimeout = this.j;
        asyncTimeout.i();
        try {
            try {
                this.k.flush();
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

    @Override // g0.Sink
    public Timeout2 timeout() {
        return this.j;
    }

    public String toString() {
        StringBuilder sbU = outline.U("AsyncTimeout.sink(");
        sbU.append(this.k);
        sbU.append(')');
        return sbU.toString();
    }

    @Override // g0.Sink
    public void write(Buffer3 buffer3, long j) throws IOException {
        Intrinsics3.checkParameterIsNotNull(buffer3, "source");
        b.i.a.f.e.o.f.B(buffer3.k, 0L, j);
        while (true) {
            long j2 = 0;
            if (j <= 0) {
                return;
            }
            Segment2 segment2 = buffer3.j;
            if (segment2 == null) {
                Intrinsics3.throwNpe();
            }
            while (j2 < 65536) {
                j2 += (long) (segment2.c - segment2.f3693b);
                if (j2 >= j) {
                    j2 = j;
                    break;
                } else {
                    segment2 = segment2.f;
                    if (segment2 == null) {
                        Intrinsics3.throwNpe();
                    }
                }
            }
            AsyncTimeout asyncTimeout = this.j;
            asyncTimeout.i();
            try {
                try {
                    this.k.write(buffer3, j2);
                    if (asyncTimeout.j()) {
                        throw asyncTimeout.k(null);
                    }
                    j -= j2;
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
    }
}
