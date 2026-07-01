package g0;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: renamed from: g0.n, reason: use source file name */
/* JADX INFO: compiled from: JvmOkio.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class JvmOkio implements Source2 {
    public final InputStream j;
    public final Timeout2 k;

    public JvmOkio(InputStream inputStream, Timeout2 timeout2) {
        Intrinsics3.checkParameterIsNotNull(inputStream, "input");
        Intrinsics3.checkParameterIsNotNull(timeout2, "timeout");
        this.j = inputStream;
        this.k = timeout2;
    }

    @Override // g0.Source2, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.j.close();
    }

    @Override // g0.Source2
    public long i0(Buffer3 buffer3, long j) {
        Intrinsics3.checkParameterIsNotNull(buffer3, "sink");
        if (j == 0) {
            return 0L;
        }
        if (!(j >= 0)) {
            throw new IllegalArgumentException(outline.t("byteCount < 0: ", j).toString());
        }
        try {
            this.k.f();
            Segment2 segment2N = buffer3.N(1);
            int i = this.j.read(segment2N.a, segment2N.c, (int) Math.min(j, 8192 - segment2N.c));
            if (i != -1) {
                segment2N.c += i;
                long j2 = i;
                buffer3.k += j2;
                return j2;
            }
            if (segment2N.f3693b != segment2N.c) {
                return -1L;
            }
            buffer3.j = segment2N.a();
            SegmentPool.a(segment2N);
            return -1L;
        } catch (AssertionError e) {
            if (b.i.a.f.e.o.f.z0(e)) {
                throw new IOException(e);
            }
            throw e;
        }
    }

    @Override // g0.Source2
    public Timeout2 timeout() {
        return this.k;
    }

    public String toString() {
        StringBuilder sbU = outline.U("source(");
        sbU.append(this.j);
        sbU.append(')');
        return sbU.toString();
    }
}
