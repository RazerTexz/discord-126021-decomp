package g0;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

/* JADX INFO: renamed from: g0.m, reason: use source file name */
/* JADX INFO: compiled from: InflaterSource.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class InflaterSource implements Source2 {
    public int j;
    public boolean k;
    public final BufferedSource l;
    public final Inflater m;

    public InflaterSource(Source2 source2, Inflater inflater) {
        Intrinsics3.checkParameterIsNotNull(source2, "source");
        Intrinsics3.checkParameterIsNotNull(inflater, "inflater");
        Intrinsics3.checkParameterIsNotNull(source2, "$this$buffer");
        RealBufferedSource realBufferedSource = new RealBufferedSource(source2);
        Intrinsics3.checkParameterIsNotNull(realBufferedSource, "source");
        Intrinsics3.checkParameterIsNotNull(inflater, "inflater");
        this.l = realBufferedSource;
        this.m = inflater;
    }

    public final long a(Buffer3 buffer3, long j) throws IOException {
        Intrinsics3.checkParameterIsNotNull(buffer3, "sink");
        if (!(j >= 0)) {
            throw new IllegalArgumentException(outline.t("byteCount < 0: ", j).toString());
        }
        if (!(!this.k)) {
            throw new IllegalStateException("closed".toString());
        }
        if (j == 0) {
            return 0L;
        }
        try {
            Segment2 segment2N = buffer3.N(1);
            int iMin = (int) Math.min(j, 8192 - segment2N.c);
            if (this.m.needsInput() && !this.l.w()) {
                Segment2 segment2 = this.l.g().j;
                if (segment2 == null) {
                    Intrinsics3.throwNpe();
                }
                int i = segment2.c;
                int i2 = segment2.f3693b;
                int i3 = i - i2;
                this.j = i3;
                this.m.setInput(segment2.a, i2, i3);
            }
            int iInflate = this.m.inflate(segment2N.a, segment2N.c, iMin);
            int i4 = this.j;
            if (i4 != 0) {
                int remaining = i4 - this.m.getRemaining();
                this.j -= remaining;
                this.l.skip(remaining);
            }
            if (iInflate > 0) {
                segment2N.c += iInflate;
                long j2 = iInflate;
                buffer3.k += j2;
                return j2;
            }
            if (segment2N.f3693b == segment2N.c) {
                buffer3.j = segment2N.a();
                SegmentPool.a(segment2N);
            }
            return 0L;
        } catch (DataFormatException e) {
            throw new IOException(e);
        }
    }

    @Override // g0.Source2, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.k) {
            return;
        }
        this.m.end();
        this.k = true;
        this.l.close();
    }

    @Override // g0.Source2
    public long i0(Buffer3 buffer3, long j) throws IOException {
        Intrinsics3.checkParameterIsNotNull(buffer3, "sink");
        do {
            long jA = a(buffer3, j);
            if (jA > 0) {
                return jA;
            }
            if (this.m.finished() || this.m.needsDictionary()) {
                return -1L;
            }
        } while (!this.l.w());
        throw new EOFException("source exhausted prematurely");
    }

    @Override // g0.Source2
    public Timeout2 timeout() {
        return this.l.timeout();
    }

    public InflaterSource(BufferedSource bufferedSource, Inflater inflater) {
        Intrinsics3.checkParameterIsNotNull(bufferedSource, "source");
        Intrinsics3.checkParameterIsNotNull(inflater, "inflater");
        this.l = bufferedSource;
        this.m = inflater;
    }
}
