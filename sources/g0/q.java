package g0;

import java.io.IOException;
import java.nio.ByteBuffer;
import okio.BufferedSink;
import okio.ByteString;

/* JADX INFO: compiled from: RealBufferedSink.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class q implements BufferedSink {
    public final e j;
    public boolean k;
    public final v l;

    public q(v vVar) {
        d0.z.d.m.checkParameterIsNotNull(vVar, "sink");
        this.l = vVar;
        this.j = new e();
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
        d0.z.d.m.checkParameterIsNotNull(str, "string");
        if (!(!this.k)) {
            throw new IllegalStateException("closed".toString());
        }
        this.j.b0(str);
        F();
        return this;
    }

    @Override // okio.BufferedSink
    public long P(x xVar) throws IOException {
        d0.z.d.m.checkParameterIsNotNull(xVar, "source");
        long j = 0;
        while (true) {
            long jI0 = ((n) xVar).i0(this.j, 8192);
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
        this.j.V(j);
        return F();
    }

    @Override // g0.v, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws Throwable {
        if (this.k) {
            return;
        }
        Throwable th = null;
        try {
            e eVar = this.j;
            long j = eVar.k;
            if (j > 0) {
                this.l.write(eVar, j);
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
        d0.z.d.m.checkParameterIsNotNull(byteString, "byteString");
        if (!(!this.k)) {
            throw new IllegalStateException("closed".toString());
        }
        this.j.O(byteString);
        F();
        return this;
    }

    @Override // okio.BufferedSink, g0.v, java.io.Flushable
    public void flush() throws IOException {
        if (!(!this.k)) {
            throw new IllegalStateException("closed".toString());
        }
        e eVar = this.j;
        long j = eVar.k;
        if (j > 0) {
            this.l.write(eVar, j);
        }
        this.l.flush();
    }

    @Override // okio.BufferedSink
    public e g() {
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
        e eVar = this.j;
        long j = eVar.k;
        if (j > 0) {
            this.l.write(eVar, j);
        }
        return this;
    }

    @Override // okio.BufferedSink
    public BufferedSink q0(long j) throws IOException {
        if (!(!this.k)) {
            throw new IllegalStateException("closed".toString());
        }
        this.j.U(j);
        F();
        return this;
    }

    @Override // g0.v
    public y timeout() {
        return this.l.timeout();
    }

    public String toString() {
        StringBuilder sbU = b.d.b.a.a.U("buffer(");
        sbU.append(this.l);
        sbU.append(')');
        return sbU.toString();
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) throws IOException {
        d0.z.d.m.checkParameterIsNotNull(byteBuffer, "source");
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

    @Override // g0.v
    public void write(e eVar, long j) throws IOException {
        d0.z.d.m.checkParameterIsNotNull(eVar, "source");
        if (!this.k) {
            this.j.write(eVar, j);
            F();
            return;
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.BufferedSink
    public BufferedSink write(byte[] bArr) throws IOException {
        d0.z.d.m.checkParameterIsNotNull(bArr, "source");
        if (!this.k) {
            this.j.R(bArr);
            F();
            return this;
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.BufferedSink
    public BufferedSink write(byte[] bArr, int i, int i2) throws IOException {
        d0.z.d.m.checkParameterIsNotNull(bArr, "source");
        if (!this.k) {
            this.j.S(bArr, i, i2);
            F();
            return this;
        }
        throw new IllegalStateException("closed".toString());
    }
}
