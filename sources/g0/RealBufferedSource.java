package g0;

import androidx.recyclerview.widget.RecyclerView;
import b.d.b.a.outline;
import d0.g0.CharJVM;
import d0.z.d.Intrinsics3;
import g0.z.Buffer5;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import okio.ByteString;

/* JADX INFO: renamed from: g0.r, reason: use source file name */
/* JADX INFO: compiled from: RealBufferedSource.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class RealBufferedSource implements BufferedSource {
    public final Buffer3 j;
    public boolean k;
    public final Source2 l;

    public RealBufferedSource(Source2 source2) {
        Intrinsics3.checkParameterIsNotNull(source2, "source");
        this.l = source2;
        this.j = new Buffer3();
    }

    @Override // g0.BufferedSource
    public void B(Buffer3 buffer3, long j) throws IOException {
        Intrinsics3.checkParameterIsNotNull(buffer3, "sink");
        try {
            if (!j(j)) {
                throw new EOFException();
            }
            this.j.B(buffer3, j);
        } catch (EOFException e) {
            buffer3.P(this.j);
            throw e;
        }
    }

    @Override // g0.BufferedSource
    public long E(ByteString byteString) {
        Intrinsics3.checkParameterIsNotNull(byteString, "targetBytes");
        Intrinsics3.checkParameterIsNotNull(byteString, "targetBytes");
        if (!(!this.k)) {
            throw new IllegalStateException("closed".toString());
        }
        long jMax = 0;
        while (true) {
            long jT = this.j.t(byteString, jMax);
            if (jT != -1) {
                return jT;
            }
            Buffer3 buffer3 = this.j;
            long j = buffer3.k;
            if (this.l.i0(buffer3, 8192) == -1) {
                return -1L;
            }
            jMax = Math.max(jMax, j);
        }
    }

    @Override // g0.BufferedSource
    public String G(long j) throws EOFException {
        if (!(j >= 0)) {
            throw new IllegalArgumentException(outline.t("limit < 0: ", j).toString());
        }
        long j2 = j == RecyclerView.FOREVER_NS ? Long.MAX_VALUE : j + 1;
        byte b2 = (byte) 10;
        long jA = a(b2, 0L, j2);
        if (jA != -1) {
            return Buffer5.a(this.j, jA);
        }
        if (j2 < RecyclerView.FOREVER_NS && j(j2) && this.j.q(j2 - 1) == ((byte) 13) && j(1 + j2) && this.j.q(j2) == b2) {
            return Buffer5.a(this.j, j2);
        }
        Buffer3 buffer3 = new Buffer3();
        Buffer3 buffer4 = this.j;
        buffer4.n(buffer3, 0L, Math.min(32, buffer4.k));
        throw new EOFException("\\n not found: limit=" + Math.min(this.j.k, j) + " content=" + buffer3.x().k() + "…");
    }

    @Override // g0.BufferedSource
    public String M(Charset charset) throws IOException {
        Intrinsics3.checkParameterIsNotNull(charset, "charset");
        this.j.P(this.l);
        return this.j.M(charset);
    }

    @Override // g0.BufferedSource
    public String Y() {
        return G(RecyclerView.FOREVER_NS);
    }

    @Override // g0.BufferedSource
    public byte[] Z(long j) throws EOFException {
        if (j(j)) {
            return this.j.Z(j);
        }
        throw new EOFException();
    }

    public long a(byte b2, long j, long j2) {
        if (!(!this.k)) {
            throw new IllegalStateException("closed".toString());
        }
        if (!(0 <= j && j2 >= j)) {
            throw new IllegalArgumentException(("fromIndex=" + j + " toIndex=" + j2).toString());
        }
        while (j < j2) {
            long jS = this.j.s(b2, j, j2);
            if (jS != -1) {
                return jS;
            }
            Buffer3 buffer3 = this.j;
            long j3 = buffer3.k;
            if (j3 >= j2 || this.l.i0(buffer3, 8192) == -1) {
                return -1L;
            }
            j = Math.max(j, j3);
        }
        return -1L;
    }

    public int b() throws EOFException {
        p0(4L);
        int i = this.j.readInt();
        return ((i & 255) << 24) | (((-16777216) & i) >>> 24) | ((16711680 & i) >>> 8) | ((65280 & i) << 8);
    }

    @Override // g0.Source2, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.k) {
            return;
        }
        this.k = true;
        this.l.close();
        Buffer3 buffer3 = this.j;
        buffer3.skip(buffer3.k);
    }

    @Override // g0.BufferedSource, okio.BufferedSink
    public Buffer3 g() {
        return this.j;
    }

    @Override // g0.Source2
    public long i0(Buffer3 buffer3, long j) {
        Intrinsics3.checkParameterIsNotNull(buffer3, "sink");
        if (!(j >= 0)) {
            throw new IllegalArgumentException(outline.t("byteCount < 0: ", j).toString());
        }
        if (!(!this.k)) {
            throw new IllegalStateException("closed".toString());
        }
        Buffer3 buffer4 = this.j;
        if (buffer4.k == 0 && this.l.i0(buffer4, 8192) == -1) {
            return -1L;
        }
        return this.j.i0(buffer3, Math.min(j, this.j.k));
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.k;
    }

    @Override // g0.BufferedSource
    public boolean j(long j) {
        Buffer3 buffer3;
        if (!(j >= 0)) {
            throw new IllegalArgumentException(outline.t("byteCount < 0: ", j).toString());
        }
        if (!(!this.k)) {
            throw new IllegalStateException("closed".toString());
        }
        do {
            buffer3 = this.j;
            if (buffer3.k >= j) {
                return true;
            }
        } while (this.l.i0(buffer3, 8192) != -1);
        return false;
    }

    @Override // g0.BufferedSource
    public long k0(Sink sink) throws IOException {
        Intrinsics3.checkParameterIsNotNull(sink, "sink");
        long j = 0;
        while (this.l.i0(this.j, 8192) != -1) {
            long jF = this.j.f();
            if (jF > 0) {
                j += jF;
                sink.write(this.j, jF);
            }
        }
        Buffer3 buffer3 = this.j;
        long j2 = buffer3.k;
        if (j2 <= 0) {
            return j;
        }
        long j3 = j + j2;
        sink.write(buffer3, j2);
        return j3;
    }

    @Override // g0.BufferedSource
    public ByteString o(long j) throws EOFException {
        if (j(j)) {
            return this.j.o(j);
        }
        throw new EOFException();
    }

    @Override // g0.BufferedSource
    public void p0(long j) throws EOFException {
        if (!j(j)) {
            throw new EOFException();
        }
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) {
        Intrinsics3.checkParameterIsNotNull(byteBuffer, "sink");
        Buffer3 buffer3 = this.j;
        if (buffer3.k == 0 && this.l.i0(buffer3, 8192) == -1) {
            return -1;
        }
        return this.j.read(byteBuffer);
    }

    @Override // g0.BufferedSource
    public byte readByte() throws EOFException {
        p0(1L);
        return this.j.readByte();
    }

    @Override // g0.BufferedSource
    public void readFully(byte[] bArr) throws EOFException {
        Intrinsics3.checkParameterIsNotNull(bArr, "sink");
        try {
            p0(bArr.length);
            this.j.readFully(bArr);
        } catch (EOFException e) {
            int i = 0;
            while (true) {
                Buffer3 buffer3 = this.j;
                long j = buffer3.k;
                if (j <= 0) {
                    throw e;
                }
                int i2 = buffer3.read(bArr, i, (int) j);
                if (i2 == -1) {
                    throw new AssertionError();
                }
                i += i2;
            }
        }
    }

    @Override // g0.BufferedSource
    public int readInt() throws EOFException {
        p0(4L);
        return this.j.readInt();
    }

    @Override // g0.BufferedSource
    public long readLong() throws EOFException {
        p0(8L);
        return this.j.readLong();
    }

    @Override // g0.BufferedSource
    public short readShort() throws EOFException {
        p0(2L);
        return this.j.readShort();
    }

    @Override // g0.BufferedSource
    public long s0() throws EOFException {
        p0(1L);
        int i = 0;
        while (true) {
            int i2 = i + 1;
            if (!j(i2)) {
                break;
            }
            byte bQ = this.j.q(i);
            if ((bQ < ((byte) 48) || bQ > ((byte) 57)) && ((bQ < ((byte) 97) || bQ > ((byte) 102)) && (bQ < ((byte) 65) || bQ > ((byte) 70)))) {
                if (i != 0) {
                    break;
                }
                StringBuilder sbU = outline.U("Expected leading [0-9a-fA-F] character but was 0x");
                String string = Integer.toString(bQ, CharJVM.checkRadix(CharJVM.checkRadix(16)));
                Intrinsics3.checkExpressionValueIsNotNull(string, "java.lang.Integer.toStri…(this, checkRadix(radix))");
                sbU.append(string);
                throw new NumberFormatException(sbU.toString());
            }
            i = i2;
        }
        return this.j.s0();
    }

    @Override // g0.BufferedSource
    public void skip(long j) throws EOFException {
        if (!(!this.k)) {
            throw new IllegalStateException("closed".toString());
        }
        while (j > 0) {
            Buffer3 buffer3 = this.j;
            if (buffer3.k == 0 && this.l.i0(buffer3, 8192) == -1) {
                throw new EOFException();
            }
            long jMin = Math.min(j, this.j.k);
            this.j.skip(jMin);
            j -= jMin;
        }
    }

    @Override // g0.Source2
    public Timeout2 timeout() {
        return this.l.timeout();
    }

    public String toString() {
        StringBuilder sbU = outline.U("buffer(");
        sbU.append(this.l);
        sbU.append(')');
        return sbU.toString();
    }

    @Override // g0.BufferedSource
    public InputStream u0() {
        return new a();
    }

    @Override // g0.BufferedSource
    public int v0(Options2 options2) throws EOFException {
        Intrinsics3.checkParameterIsNotNull(options2, "options");
        if (!(!this.k)) {
            throw new IllegalStateException("closed".toString());
        }
        do {
            int iB = Buffer5.b(this.j, options2, true);
            if (iB != -2) {
                if (iB == -1) {
                    break;
                }
                this.j.skip(options2.l[iB].j());
                return iB;
            }
        } while (this.l.i0(this.j, 8192) != -1);
        return -1;
    }

    @Override // g0.BufferedSource
    public boolean w() {
        if (!this.k) {
            return this.j.w() && this.l.i0(this.j, (long) 8192) == -1;
        }
        throw new IllegalStateException("closed".toString());
    }

    /* JADX INFO: renamed from: g0.r$a */
    /* JADX INFO: compiled from: RealBufferedSource.kt */
    public static final class a extends InputStream {
        public a() {
        }

        @Override // java.io.InputStream
        public int available() throws IOException {
            RealBufferedSource realBufferedSource = RealBufferedSource.this;
            if (realBufferedSource.k) {
                throw new IOException("closed");
            }
            return (int) Math.min(realBufferedSource.j.k, Integer.MAX_VALUE);
        }

        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            RealBufferedSource.this.close();
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            RealBufferedSource realBufferedSource = RealBufferedSource.this;
            if (realBufferedSource.k) {
                throw new IOException("closed");
            }
            Buffer3 buffer3 = realBufferedSource.j;
            if (buffer3.k == 0 && realBufferedSource.l.i0(buffer3, 8192) == -1) {
                return -1;
            }
            return RealBufferedSource.this.j.readByte() & 255;
        }

        public String toString() {
            return RealBufferedSource.this + ".inputStream()";
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i, int i2) throws IOException {
            Intrinsics3.checkParameterIsNotNull(bArr, "data");
            if (!RealBufferedSource.this.k) {
                b.i.a.f.e.o.f.B(bArr.length, i, i2);
                RealBufferedSource realBufferedSource = RealBufferedSource.this;
                Buffer3 buffer3 = realBufferedSource.j;
                if (buffer3.k == 0 && realBufferedSource.l.i0(buffer3, 8192) == -1) {
                    return -1;
                }
                return RealBufferedSource.this.j.read(bArr, i, i2);
            }
            throw new IOException("closed");
        }
    }
}
