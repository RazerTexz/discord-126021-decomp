package g0;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import java.io.IOException;
import java.nio.ByteBuffer;
import okio.BufferedSink;
import okio.ByteString;

/* JADX INFO: renamed from: g0.q, reason: use source file name */
/* JADX INFO: compiled from: RealBufferedSink.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class RealBufferedSink implements BufferedSink {
    public final Buffer3 j;
    public boolean k;
    public final Sink l;

    public RealBufferedSink(Sink sink) {
        Intrinsics3.checkParameterIsNotNull(sink, "sink");
        this.l = sink;
        this.j = new Buffer3();
    }

    @Override // okio.BufferedSink
    public BufferedSink F() throws IOException {
        if (!(!this.k)) {
            throw new IllegalStateException("closed".toString());
        }
        long jF = this.j.f();
        if (jF > 0) {
            this.l.write(this.j, jF);
        }
        return this;
    }

    @Override // okio.BufferedSink
    public BufferedSink K(String str) throws IOException {
        Intrinsics3.checkParameterIsNotNull(str, "string");
        if (!(!this.k)) {
            throw new IllegalStateException("closed".toString());
        }
        this.j.b0(str);
        F();
        return this;
    }

    @Override // okio.BufferedSink
    public long P(Source2 source2) throws IOException {
        Intrinsics3.checkParameterIsNotNull(source2, "source");
        long j = 0;
        while (true) {
            long jI0 = ((JvmOkio) source2).i0(this.j, 8192);
            if (jI0 == -1) {
                return j;
            }
            j += jI0;
            F();
        }
    }

    @Override // okio.BufferedSink
    public BufferedSink Q(long j) {
        if (!(!this.k)) {
            throw new IllegalStateException("closed".toString());
        }
        this.j.Q(j);
        return F();
    }

    @Override // g0.Sink, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws Throwable {
        if (this.k) {
            return;
        }
        Throwable th = null;
        try {
            Buffer3 buffer3 = this.j;
            long j = buffer3.k;
            if (j > 0) {
                this.l.write(buffer3, j);
            }
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            this.l.close();
        } catch (Throwable th3) {
            if (th == null) {
                th = th3;
            }
        }
        this.k = true;
        if (th != null) {
            throw th;
        }
    }

    @Override // okio.BufferedSink
    public BufferedSink e0(ByteString byteString) throws IOException {
        Intrinsics3.checkParameterIsNotNull(byteString, "byteString");
        if (!(!this.k)) {
            throw new IllegalStateException("closed".toString());
        }
        this.j.O(byteString);
        F();
        return this;
    }

    @Override // okio.BufferedSink, g0.Sink, java.io.Flushable
    public void flush() throws IOException {
        if (!(!this.k)) {
            throw new IllegalStateException("closed".toString());
        }
        Buffer3 buffer3 = this.j;
        long j = buffer3.k;
        if (j > 0) {
            this.l.write(buffer3, j);
        }
        this.l.flush();
    }

    @Override // okio.BufferedSink
    public Buffer3 g() {
        return this.j;
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.k;
    }

    @Override // okio.BufferedSink
    public BufferedSink p() throws IOException {
        if (!(!this.k)) {
            throw new IllegalStateException("closed".toString());
        }
        Buffer3 buffer3 = this.j;
        long j = buffer3.k;
        if (j > 0) {
            this.l.write(buffer3, j);
        }
        return this;
    }

    @Override // okio.BufferedSink
    public BufferedSink q0(long j) throws IOException {
        if (!(!this.k)) {
            throw new IllegalStateException("closed".toString());
        }
        this.j.q0(j);
        F();
        return this;
    }

    @Override // g0.Sink
    public Timeout2 timeout() {
        return this.l.timeout();
    }

    public String toString() {
        StringBuilder sbU = outline.U("buffer(");
        sbU.append(this.l);
        sbU.append(')');
        return sbU.toString();
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) throws IOException {
        Intrinsics3.checkParameterIsNotNull(byteBuffer, "source");
        if (!(!this.k)) {
            throw new IllegalStateException("closed".toString());
        }
        int iWrite = this.j.write(byteBuffer);
        F();
        return iWrite;
    }

    @Override // okio.BufferedSink
    public BufferedSink writeByte(int i) {
        if (!(!this.k)) {
            throw new IllegalStateException("closed".toString());
        }
        this.j.T(i);
        return F();
    }

    @Override // okio.BufferedSink
    public BufferedSink writeInt(int i) {
        if (!(!this.k)) {
            throw new IllegalStateException("closed".toString());
        }
        this.j.W(i);
        return F();
    }

    @Override // okio.BufferedSink
    public BufferedSink writeShort(int i) throws IOException {
        if (!(!this.k)) {
            throw new IllegalStateException("closed".toString());
        }
        this.j.X(i);
        F();
        return this;
    }

    @Override // g0.Sink
    public void write(Buffer3 buffer3, long j) throws IOException {
        Intrinsics3.checkParameterIsNotNull(buffer3, "source");
        if (!this.k) {
            this.j.write(buffer3, j);
            F();
            return;
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.BufferedSink
    public BufferedSink write(byte[] bArr) throws IOException {
        Intrinsics3.checkParameterIsNotNull(bArr, "source");
        if (!this.k) {
            this.j.R(bArr);
            F();
            return this;
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.BufferedSink
    public BufferedSink write(byte[] bArr, int i, int i2) throws IOException {
        Intrinsics3.checkParameterIsNotNull(bArr, "source");
        if (!this.k) {
            this.j.S(bArr, i, i2);
            F();
            return this;
        }
        throw new IllegalStateException("closed".toString());
    }
}
