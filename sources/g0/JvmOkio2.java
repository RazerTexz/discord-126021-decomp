package g0;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: renamed from: g0.p, reason: use source file name */
/* JADX INFO: compiled from: JvmOkio.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class JvmOkio2 implements Sink {
    public final OutputStream j;
    public final Timeout2 k;

    public JvmOkio2(OutputStream outputStream, Timeout2 timeout2) {
        Intrinsics3.checkParameterIsNotNull(outputStream, "out");
        Intrinsics3.checkParameterIsNotNull(timeout2, "timeout");
        this.j = outputStream;
        this.k = timeout2;
    }

    @Override // g0.Sink, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.j.close();
    }

    @Override // g0.Sink, java.io.Flushable
    public void flush() throws IOException {
        this.j.flush();
    }

    @Override // g0.Sink
    public Timeout2 timeout() {
        return this.k;
    }

    public String toString() {
        StringBuilder sbU = outline.U("sink(");
        sbU.append(this.j);
        sbU.append(')');
        return sbU.toString();
    }

    @Override // g0.Sink
    public void write(Buffer3 buffer3, long j) throws IOException {
        Intrinsics3.checkParameterIsNotNull(buffer3, "source");
        b.i.a.f.e.o.f.B(buffer3.k, 0L, j);
        while (j > 0) {
            this.k.f();
            Segment2 segment2 = buffer3.j;
            if (segment2 == null) {
                Intrinsics3.throwNpe();
            }
            int iMin = (int) Math.min(j, segment2.c - segment2.f3693b);
            this.j.write(segment2.a, segment2.f3693b, iMin);
            int i = segment2.f3693b + iMin;
            segment2.f3693b = i;
            long j2 = iMin;
            j -= j2;
            buffer3.k -= j2;
            if (i == segment2.c) {
                buffer3.j = segment2.a();
                SegmentPool.a(segment2);
            }
        }
    }
}
