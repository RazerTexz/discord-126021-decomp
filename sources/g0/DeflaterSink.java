package g0;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import java.io.IOException;
import java.util.zip.Deflater;
import okio.BufferedSink;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;

/* JADX INFO: renamed from: g0.h, reason: use source file name */
/* JADX INFO: compiled from: DeflaterSink.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class DeflaterSink implements Sink {
    public boolean j;
    public final BufferedSink k;
    public final Deflater l;

    public DeflaterSink(Sink sink, Deflater deflater) {
        Intrinsics3.checkParameterIsNotNull(sink, "sink");
        Intrinsics3.checkParameterIsNotNull(deflater, "deflater");
        Intrinsics3.checkParameterIsNotNull(sink, "$this$buffer");
        RealBufferedSink realBufferedSink = new RealBufferedSink(sink);
        Intrinsics3.checkParameterIsNotNull(realBufferedSink, "sink");
        Intrinsics3.checkParameterIsNotNull(deflater, "deflater");
        this.k = realBufferedSink;
        this.l = deflater;
    }

    @IgnoreJRERequirement
    public final void a(boolean z2) throws IOException {
        Segment2 segment2N;
        int iDeflate;
        Buffer3 buffer3G = this.k.g();
        while (true) {
            segment2N = buffer3G.N(1);
            if (z2) {
                Deflater deflater = this.l;
                byte[] bArr = segment2N.a;
                int i = segment2N.c;
                iDeflate = deflater.deflate(bArr, i, 8192 - i, 2);
            } else {
                Deflater deflater2 = this.l;
                byte[] bArr2 = segment2N.a;
                int i2 = segment2N.c;
                iDeflate = deflater2.deflate(bArr2, i2, 8192 - i2);
            }
            if (iDeflate > 0) {
                segment2N.c += iDeflate;
                buffer3G.k += (long) iDeflate;
                this.k.F();
            } else if (this.l.needsInput()) {
                break;
            }
        }
        if (segment2N.f3693b == segment2N.c) {
            buffer3G.j = segment2N.a();
            SegmentPool.a(segment2N);
        }
    }

    @Override // g0.Sink, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws Throwable {
        if (this.j) {
            return;
        }
        Throwable th = null;
        try {
            this.l.finish();
            a(false);
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            this.l.end();
        } catch (Throwable th3) {
            if (th == null) {
                th = th3;
            }
        }
        try {
            this.k.close();
        } catch (Throwable th4) {
            if (th == null) {
                th = th4;
            }
        }
        this.j = true;
        if (th != null) {
            throw th;
        }
    }

    @Override // g0.Sink, java.io.Flushable
    public void flush() throws IOException {
        a(true);
        this.k.flush();
    }

    @Override // g0.Sink
    public Timeout2 timeout() {
        return this.k.timeout();
    }

    public String toString() {
        StringBuilder sbU = outline.U("DeflaterSink(");
        sbU.append(this.k);
        sbU.append(')');
        return sbU.toString();
    }

    @Override // g0.Sink
    public void write(Buffer3 buffer3, long j) throws IOException {
        Intrinsics3.checkParameterIsNotNull(buffer3, "source");
        b.i.a.f.e.o.f.B(buffer3.k, 0L, j);
        while (j > 0) {
            Segment2 segment2 = buffer3.j;
            if (segment2 == null) {
                Intrinsics3.throwNpe();
            }
            int iMin = (int) Math.min(j, segment2.c - segment2.f3693b);
            this.l.setInput(segment2.a, segment2.f3693b, iMin);
            a(false);
            long j2 = iMin;
            buffer3.k -= j2;
            int i = segment2.f3693b + iMin;
            segment2.f3693b = i;
            if (i == segment2.c) {
                buffer3.j = segment2.a();
                SegmentPool.a(segment2);
            }
            j -= j2;
        }
    }
}
