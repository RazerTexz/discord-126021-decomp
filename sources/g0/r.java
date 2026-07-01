package g0;

import androidx.recyclerview.widget.RecyclerView;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import okio.ByteString;

/* JADX INFO: compiled from: RealBufferedSource.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class r implements g {
    public final e j;
    public boolean k;
    public final x l;

    public r(x xVar) {
        d0.z.d.m.checkParameterIsNotNull(xVar, "source");
        this.l = xVar;
        this.j = new e();
    }

    @Override // g0.g
    public void B(e eVar, long j) throws IOException {
        d0.z.d.m.checkParameterIsNotNull(eVar, "sink");
        try {
            if (!j(j)) {
                throw new EOFException();
            }
            this.j.B(eVar, j);
        } catch (EOFException e) {
            eVar.P(this.j);
            throw e;
        }
    }

    @Override // g0.g
    public long E(ByteString byteString) {
        d0.z.d.m.checkParameterIsNotNull(byteString, "targetBytes");
        d0.z.d.m.checkParameterIsNotNull(byteString, "targetBytes");
        if (!(!this.k)) {
            throw new IllegalStateException("closed".toString());
        }
        long jMax = 0;
        while (true) {
            long jT = this.j.t(byteString, jMax);
            if (jT != -1) {
                return jT;
            }
            e eVar = this.j;
            long j = eVar.k;
            if (this.l.i0(eVar, 8192) == -1) {
                return -1L;
            }
            jMax = Math.max(jMax, j);
        }
    }

    @Override // g0.g
    public String G(long j) throws EOFException {
        if (!(j >= 0)) {
            throw new IllegalArgumentException(b.d.b.a.a.t("limit < 0: ", j).toString());
        }
        long j2 = j == RecyclerView.FOREVER_NS ? Long.MAX_VALUE : j + 1;
        byte b2 = (byte) 10;
        long jA = a(b2, 0L, j2);
        if (jA != -1) {
            return g0.z.a.a(this.j, jA);
        }
        if (j2 < RecyclerView.FOREVER_NS && j(j2) && this.j.q(j2 - 1) == ((byte) 13) && j(1 + j2) && this.j.q(j2) == b2) {
            return g0.z.a.a(this.j, j2);
        }
        e eVar = new e();
        e eVar2 = this.j;
        eVar2.n(eVar, 0L, Math.min(32, eVar2.k));
        throw new EOFException("\\n not found: limit=" + Math.min(this.j.k, j) + " content=" + eVar.x().k() + "…");
    }

    @Override // g0.g
    public String M(Charset charset) throws IOException {
        d0.z.d.m.checkParameterIsNotNull(charset, "charset");
        this.j.P(this.l);
        return this.j.M(charset);
    }

    @Override // g0.g
    public String Y() {
        return G(RecyclerView.FOREVER_NS);
    }

    @Override // g0.g
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
            e eVar = this.j;
            long j3 = eVar.k;
            if (j3 >= j2 || this.l.i0(eVar, 8192) == -1) {
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

    @Override // g0.x, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.k) {
            return;
        }
        this.k = true;
        this.l.close();
        e eVar = this.j;
        eVar.skip(eVar.k);
    }

    @Override // g0.g, okio.BufferedSink
    public e g() {
        return this.j;
    }

    @Override // g0.x
    public long i0(e eVar, long j) {
        d0.z.d.m.checkParameterIsNotNull(eVar, "sink");
        if (!(j >= 0)) {
            throw new IllegalArgumentException(b.d.b.a.a.t("byteCount < 0: ", j).toString());
        }
        if (!(!this.k)) {
            throw new IllegalStateException("closed".toString());
        }
        e eVar2 = this.j;
        if (eVar2.k == 0 && this.l.i0(eVar2, 8192) == -1) {
            return -1L;
        }
        return this.j.i0(eVar, Math.min(j, this.j.k));
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.k;
    }

    @Override // g0.g
    public boolean j(long j) {
        e eVar;
        if (!(j >= 0)) {
            throw new IllegalArgumentException(b.d.b.a.a.t("byteCount < 0: ", j).toString());
        }
        if (!(!this.k)) {
            throw new IllegalStateException("closed".toString());
        }
        do {
            eVar = this.j;
            if (eVar.k >= j) {
                return true;
            }
        } while (this.l.i0(eVar, 8192) != -1);
        return false;
    }

    @Override // g0.g
    public long k0(v vVar) throws IOException {
        d0.z.d.m.checkParameterIsNotNull(vVar, "sink");
        long j = 0;
        while (this.l.i0(this.j, 8192) != -1) {
            long jF = this.j.f();
            if (jF > 0) {
                j += jF;
                vVar.write(this.j, jF);
            }
        }
        e eVar = this.j;
        long j2 = eVar.k;
        if (j2 <= 0) {
            return j;
        }
        long j3 = j + j2;
        vVar.write(eVar, j2);
        return j3;
    }

    @Override // g0.g
    public ByteString o(long j) throws EOFException {
        if (j(j)) {
            return this.j.o(j);
        }
        throw new EOFException();
    }

    @Override // g0.g
    public void p0(long j) throws EOFException {
        if (!j(j)) {
            throw new EOFException();
        }
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) {
        d0.z.d.m.checkParameterIsNotNull(byteBuffer, "sink");
        e eVar = this.j;
        if (eVar.k == 0 && this.l.i0(eVar, 8192) == -1) {
            return -1;
        }
        return this.j.read(byteBuffer);
    }

    @Override // g0.g
    public byte readByte() throws EOFException {
        p0(1L);
        return this.j.readByte();
    }

    @Override // g0.g
    public void readFully(byte[] bArr) throws EOFException {
        d0.z.d.m.checkParameterIsNotNull(bArr, "sink");
        try {
            p0(bArr.length);
            this.j.readFully(bArr);
        } catch (EOFException e) {
            int i = 0;
            while (true) {
                e eVar = this.j;
                long j = eVar.k;
                if (j <= 0) {
                    throw e;
                }
                int i2 = eVar.read(bArr, i, (int) j);
                if (i2 == -1) {
                    throw new AssertionError();
                }
                i += i2;
            }
        }
    }

    @Override // g0.g
    public int readInt() throws EOFException {
        p0(4L);
        return this.j.readInt();
    }

    @Override // g0.g
    public long readLong() throws EOFException {
        p0(8L);
        return this.j.readLong();
    }

    @Override // g0.g
    public short readShort() throws EOFException {
        p0(2L);
        return this.j.readShort();
    }

    @Override // g0.g
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
                StringBuilder sbU = b.d.b.a.a.U("Expected leading [0-9a-fA-F] character but was 0x");
                String string = Integer.toString(bQ, d0.g0.a.checkRadix(d0.g0.a.checkRadix(16)));
                d0.z.d.m.checkExpressionValueIsNotNull(string, "java.lang.Integer.toStri…(this, checkRadix(radix))");
                sbU.append(string);
                throw new NumberFormatException(sbU.toString());
            }
            i = i2;
        }
        return this.j.s0();
    }

    @Override // g0.g
    public void skip(long j) throws EOFException {
        if (!(!this.k)) {
            throw new IllegalStateException("closed".toString());
        }
        while (j > 0) {
            e eVar = this.j;
            if (eVar.k == 0 && this.l.i0(eVar, 8192) == -1) {
                throw new EOFException();
            }
            long jMin = Math.min(j, this.j.k);
            this.j.skip(jMin);
            j -= jMin;
        }
    }

    @Override // g0.x
    public y timeout() {
        return this.l.timeout();
    }

    public String toString() {
        StringBuilder sbU = b.d.b.a.a.U("buffer(");
        sbU.append(this.l);
        sbU.append(')');
        return sbU.toString();
    }

    @Override // g0.g
    public InputStream u0() {
        return new r$a(this);
    }

    @Override // g0.g
    public int v0(o oVar) throws EOFException {
        d0.z.d.m.checkParameterIsNotNull(oVar, "options");
        if (!(!this.k)) {
            throw new IllegalStateException("closed".toString());
        }
        do {
            int iB = g0.z.a.b(this.j, oVar, true);
            if (iB != -2) {
                if (iB == -1) {
                    break;
                }
                this.j.skip(oVar.l[iB].j());
                return iB;
            }
        } while (this.l.i0(this.j, 8192) != -1);
        return -1;
    }

    @Override // g0.g
    public boolean w() {
        if (!this.k) {
            return this.j.w() && this.l.i0(this.j, (long) 8192) == -1;
        }
        throw new IllegalStateException("closed".toString());
    }
}
