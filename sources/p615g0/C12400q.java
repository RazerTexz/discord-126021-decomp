package p615g0;

import java.io.IOException;
import java.nio.ByteBuffer;
import okio.BufferedSink;
import okio.ByteString;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: g0.q */
/* JADX INFO: compiled from: RealBufferedSink.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C12400q implements BufferedSink {

    /* JADX INFO: renamed from: j */
    public final C12388e f26111j;

    /* JADX INFO: renamed from: k */
    public boolean f26112k;

    /* JADX INFO: renamed from: l */
    public final InterfaceC12405v f26113l;

    public C12400q(InterfaceC12405v interfaceC12405v) {
        C12238m.checkParameterIsNotNull(interfaceC12405v, "sink");
        this.f26113l = interfaceC12405v;
        this.f26111j = new C12388e();
    }

    @Override // okio.BufferedSink
    /* JADX INFO: renamed from: F */
    public BufferedSink mo10431F() throws IOException {
        if (!(!this.f26112k)) {
            throw new IllegalStateException("closed".toString());
        }
        long jM10456f = this.f26111j.m10456f();
        if (jM10456f > 0) {
            this.f26113l.write(this.f26111j, jM10456f);
        }
        return this;
    }

    @Override // okio.BufferedSink
    /* JADX INFO: renamed from: K */
    public BufferedSink mo10436K(String str) throws IOException {
        C12238m.checkParameterIsNotNull(str, "string");
        if (!(!this.f26112k)) {
            throw new IllegalStateException("closed".toString());
        }
        this.f26111j.m10452b0(str);
        mo10431F();
        return this;
    }

    @Override // okio.BufferedSink
    /* JADX INFO: renamed from: P */
    public long mo10440P(InterfaceC12407x interfaceC12407x) throws IOException {
        C12238m.checkParameterIsNotNull(interfaceC12407x, "source");
        long j = 0;
        while (true) {
            long jMo10176i0 = ((C12397n) interfaceC12407x).mo10176i0(this.f26111j, 8192);
            if (jMo10176i0 == -1) {
                return j;
            }
            j += jMo10176i0;
            mo10431F();
        }
    }

    @Override // okio.BufferedSink
    /* JADX INFO: renamed from: Q */
    public BufferedSink mo10441Q(long j) {
        if (!(!this.f26112k)) {
            throw new IllegalStateException("closed".toString());
        }
        this.f26111j.mo10441Q(j);
        return mo10431F();
    }

    @Override // p615g0.InterfaceC12405v, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws Throwable {
        if (this.f26112k) {
            return;
        }
        Throwable th = null;
        try {
            C12388e c12388e = this.f26111j;
            long j = c12388e.f26080k;
            if (j > 0) {
                this.f26113l.write(c12388e, j);
            }
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            this.f26113l.close();
        } catch (Throwable th3) {
            if (th == null) {
                th = th3;
            }
        }
        this.f26112k = true;
        if (th != null) {
            throw th;
        }
    }

    @Override // okio.BufferedSink
    /* JADX INFO: renamed from: e0 */
    public BufferedSink mo10455e0(ByteString byteString) throws IOException {
        C12238m.checkParameterIsNotNull(byteString, "byteString");
        if (!(!this.f26112k)) {
            throw new IllegalStateException("closed".toString());
        }
        this.f26111j.m10439O(byteString);
        mo10431F();
        return this;
    }

    @Override // okio.BufferedSink, p615g0.InterfaceC12405v, java.io.Flushable
    public void flush() throws IOException {
        if (!(!this.f26112k)) {
            throw new IllegalStateException("closed".toString());
        }
        C12388e c12388e = this.f26111j;
        long j = c12388e.f26080k;
        if (j > 0) {
            this.f26113l.write(c12388e, j);
        }
        this.f26113l.flush();
    }

    @Override // okio.BufferedSink
    /* JADX INFO: renamed from: g */
    public C12388e mo10457g() {
        return this.f26111j;
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.f26112k;
    }

    @Override // okio.BufferedSink
    /* JADX INFO: renamed from: p */
    public BufferedSink mo10462p() throws IOException {
        if (!(!this.f26112k)) {
            throw new IllegalStateException("closed".toString());
        }
        C12388e c12388e = this.f26111j;
        long j = c12388e.f26080k;
        if (j > 0) {
            this.f26113l.write(c12388e, j);
        }
        return this;
    }

    @Override // okio.BufferedSink
    /* JADX INFO: renamed from: q0 */
    public BufferedSink mo10465q0(long j) throws IOException {
        if (!(!this.f26112k)) {
            throw new IllegalStateException("closed".toString());
        }
        this.f26111j.mo10465q0(j);
        mo10431F();
        return this;
    }

    @Override // p615g0.InterfaceC12405v
    public C12408y timeout() {
        return this.f26113l.timeout();
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("buffer(");
        sbM833U.append(this.f26113l);
        sbM833U.append(')');
        return sbM833U.toString();
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) throws IOException {
        C12238m.checkParameterIsNotNull(byteBuffer, "source");
        if (!(!this.f26112k)) {
            throw new IllegalStateException("closed".toString());
        }
        int iWrite = this.f26111j.write(byteBuffer);
        mo10431F();
        return iWrite;
    }

    @Override // okio.BufferedSink
    public BufferedSink writeByte(int i) {
        if (!(!this.f26112k)) {
            throw new IllegalStateException("closed".toString());
        }
        this.f26111j.m10444T(i);
        return mo10431F();
    }

    @Override // okio.BufferedSink
    public BufferedSink writeInt(int i) {
        if (!(!this.f26112k)) {
            throw new IllegalStateException("closed".toString());
        }
        this.f26111j.m10447W(i);
        return mo10431F();
    }

    @Override // okio.BufferedSink
    public BufferedSink writeShort(int i) throws IOException {
        if (!(!this.f26112k)) {
            throw new IllegalStateException("closed".toString());
        }
        this.f26111j.m10448X(i);
        mo10431F();
        return this;
    }

    @Override // p615g0.InterfaceC12405v
    public void write(C12388e c12388e, long j) throws IOException {
        C12238m.checkParameterIsNotNull(c12388e, "source");
        if (!this.f26112k) {
            this.f26111j.write(c12388e, j);
            mo10431F();
            return;
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.BufferedSink
    public BufferedSink write(byte[] bArr) throws IOException {
        C12238m.checkParameterIsNotNull(bArr, "source");
        if (!this.f26112k) {
            this.f26111j.m10442R(bArr);
            mo10431F();
            return this;
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.BufferedSink
    public BufferedSink write(byte[] bArr, int i, int i2) throws IOException {
        C12238m.checkParameterIsNotNull(bArr, "source");
        if (!this.f26112k) {
            this.f26111j.m10443S(bArr, i, i2);
            mo10431F();
            return this;
        }
        throw new IllegalStateException("closed".toString());
    }
}
