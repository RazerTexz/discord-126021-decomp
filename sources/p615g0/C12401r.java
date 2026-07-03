package p615g0;

import androidx.recyclerview.widget.RecyclerView;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import okio.ByteString;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p507d0.p579g0.C12084a;
import p507d0.p592z.p594d.C12238m;
import p615g0.p616z.C12409a;

/* JADX INFO: renamed from: g0.r */
/* JADX INFO: compiled from: RealBufferedSource.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C12401r implements InterfaceC12390g {

    /* JADX INFO: renamed from: j */
    public final C12388e f26114j;

    /* JADX INFO: renamed from: k */
    public boolean f26115k;

    /* JADX INFO: renamed from: l */
    public final InterfaceC12407x f26116l;

    public C12401r(InterfaceC12407x interfaceC12407x) {
        C12238m.checkParameterIsNotNull(interfaceC12407x, "source");
        this.f26116l = interfaceC12407x;
        this.f26114j = new C12388e();
    }

    @Override // p615g0.InterfaceC12390g
    /* JADX INFO: renamed from: B */
    public void mo10428B(C12388e c12388e, long j) throws IOException {
        C12238m.checkParameterIsNotNull(c12388e, "sink");
        try {
            if (!mo10458j(j)) {
                throw new EOFException();
            }
            this.f26114j.mo10428B(c12388e, j);
        } catch (EOFException e) {
            c12388e.mo10440P(this.f26114j);
            throw e;
        }
    }

    @Override // p615g0.InterfaceC12390g
    /* JADX INFO: renamed from: E */
    public long mo10430E(ByteString byteString) {
        C12238m.checkParameterIsNotNull(byteString, "targetBytes");
        C12238m.checkParameterIsNotNull(byteString, "targetBytes");
        if (!(!this.f26115k)) {
            throw new IllegalStateException("closed".toString());
        }
        long jMax = 0;
        while (true) {
            long jM10468t = this.f26114j.m10468t(byteString, jMax);
            if (jM10468t != -1) {
                return jM10468t;
            }
            C12388e c12388e = this.f26114j;
            long j = c12388e.f26080k;
            if (this.f26116l.mo10176i0(c12388e, 8192) == -1) {
                return -1L;
            }
            jMax = Math.max(jMax, j);
        }
    }

    @Override // p615g0.InterfaceC12390g
    /* JADX INFO: renamed from: G */
    public String mo10432G(long j) throws EOFException {
        if (!(j >= 0)) {
            throw new IllegalArgumentException(C1643a.m877t("limit < 0: ", j).toString());
        }
        long j2 = j == RecyclerView.FOREVER_NS ? Long.MAX_VALUE : j + 1;
        byte b2 = (byte) 10;
        long jM10492a = m10492a(b2, 0L, j2);
        if (jM10492a != -1) {
            return C12409a.m10513a(this.f26114j, jM10492a);
        }
        if (j2 < RecyclerView.FOREVER_NS && mo10458j(j2) && this.f26114j.m10464q(j2 - 1) == ((byte) 13) && mo10458j(1 + j2) && this.f26114j.m10464q(j2) == b2) {
            return C12409a.m10513a(this.f26114j, j2);
        }
        C12388e c12388e = new C12388e();
        C12388e c12388e2 = this.f26114j;
        c12388e2.m10460n(c12388e, 0L, Math.min(32, c12388e2.f26080k));
        throw new EOFException("\\n not found: limit=" + Math.min(this.f26114j.f26080k, j) + " content=" + c12388e.m10473x().mo10503k() + "…");
    }

    @Override // p615g0.InterfaceC12390g
    /* JADX INFO: renamed from: M */
    public String mo10437M(Charset charset) throws IOException {
        C12238m.checkParameterIsNotNull(charset, "charset");
        this.f26114j.mo10440P(this.f26116l);
        return this.f26114j.mo10437M(charset);
    }

    @Override // p615g0.InterfaceC12390g
    /* JADX INFO: renamed from: Y */
    public String mo10449Y() {
        return mo10432G(RecyclerView.FOREVER_NS);
    }

    @Override // p615g0.InterfaceC12390g
    /* JADX INFO: renamed from: Z */
    public byte[] mo10450Z(long j) throws EOFException {
        if (mo10458j(j)) {
            return this.f26114j.mo10450Z(j);
        }
        throw new EOFException();
    }

    /* JADX INFO: renamed from: a */
    public long m10492a(byte b2, long j, long j2) {
        if (!(!this.f26115k)) {
            throw new IllegalStateException("closed".toString());
        }
        if (!(0 <= j && j2 >= j)) {
            throw new IllegalArgumentException(("fromIndex=" + j + " toIndex=" + j2).toString());
        }
        while (j < j2) {
            long jM10466s = this.f26114j.m10466s(b2, j, j2);
            if (jM10466s != -1) {
                return jM10466s;
            }
            C12388e c12388e = this.f26114j;
            long j3 = c12388e.f26080k;
            if (j3 >= j2 || this.f26116l.mo10176i0(c12388e, 8192) == -1) {
                return -1L;
            }
            j = Math.max(j, j3);
        }
        return -1L;
    }

    /* JADX INFO: renamed from: b */
    public int m10493b() throws EOFException {
        mo10463p0(4L);
        int i = this.f26114j.readInt();
        return ((i & 255) << 24) | (((-16777216) & i) >>> 24) | ((16711680 & i) >>> 8) | ((65280 & i) << 8);
    }

    @Override // p615g0.InterfaceC12407x, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.f26115k) {
            return;
        }
        this.f26115k = true;
        this.f26116l.close();
        C12388e c12388e = this.f26114j;
        c12388e.skip(c12388e.f26080k);
    }

    @Override // p615g0.InterfaceC12390g, okio.BufferedSink
    /* JADX INFO: renamed from: g */
    public C12388e mo10457g() {
        return this.f26114j;
    }

    @Override // p615g0.InterfaceC12407x
    /* JADX INFO: renamed from: i0 */
    public long mo10176i0(C12388e c12388e, long j) {
        C12238m.checkParameterIsNotNull(c12388e, "sink");
        if (!(j >= 0)) {
            throw new IllegalArgumentException(C1643a.m877t("byteCount < 0: ", j).toString());
        }
        if (!(!this.f26115k)) {
            throw new IllegalStateException("closed".toString());
        }
        C12388e c12388e2 = this.f26114j;
        if (c12388e2.f26080k == 0 && this.f26116l.mo10176i0(c12388e2, 8192) == -1) {
            return -1L;
        }
        return this.f26114j.mo10176i0(c12388e, Math.min(j, this.f26114j.f26080k));
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.f26115k;
    }

    @Override // p615g0.InterfaceC12390g
    /* JADX INFO: renamed from: j */
    public boolean mo10458j(long j) {
        C12388e c12388e;
        if (!(j >= 0)) {
            throw new IllegalArgumentException(C1643a.m877t("byteCount < 0: ", j).toString());
        }
        if (!(!this.f26115k)) {
            throw new IllegalStateException("closed".toString());
        }
        do {
            c12388e = this.f26114j;
            if (c12388e.f26080k >= j) {
                return true;
            }
        } while (this.f26116l.mo10176i0(c12388e, 8192) != -1);
        return false;
    }

    @Override // p615g0.InterfaceC12390g
    /* JADX INFO: renamed from: k0 */
    public long mo10459k0(InterfaceC12405v interfaceC12405v) throws IOException {
        C12238m.checkParameterIsNotNull(interfaceC12405v, "sink");
        long j = 0;
        while (this.f26116l.mo10176i0(this.f26114j, 8192) != -1) {
            long jM10456f = this.f26114j.m10456f();
            if (jM10456f > 0) {
                j += jM10456f;
                interfaceC12405v.write(this.f26114j, jM10456f);
            }
        }
        C12388e c12388e = this.f26114j;
        long j2 = c12388e.f26080k;
        if (j2 <= 0) {
            return j;
        }
        long j3 = j + j2;
        interfaceC12405v.write(c12388e, j2);
        return j3;
    }

    @Override // p615g0.InterfaceC12390g
    /* JADX INFO: renamed from: o */
    public ByteString mo10461o(long j) throws EOFException {
        if (mo10458j(j)) {
            return this.f26114j.mo10461o(j);
        }
        throw new EOFException();
    }

    @Override // p615g0.InterfaceC12390g
    /* JADX INFO: renamed from: p0 */
    public void mo10463p0(long j) throws EOFException {
        if (!mo10458j(j)) {
            throw new EOFException();
        }
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) {
        C12238m.checkParameterIsNotNull(byteBuffer, "sink");
        C12388e c12388e = this.f26114j;
        if (c12388e.f26080k == 0 && this.f26116l.mo10176i0(c12388e, 8192) == -1) {
            return -1;
        }
        return this.f26114j.read(byteBuffer);
    }

    @Override // p615g0.InterfaceC12390g
    public byte readByte() throws EOFException {
        mo10463p0(1L);
        return this.f26114j.readByte();
    }

    @Override // p615g0.InterfaceC12390g
    public void readFully(byte[] bArr) throws EOFException {
        C12238m.checkParameterIsNotNull(bArr, "sink");
        try {
            mo10463p0(bArr.length);
            this.f26114j.readFully(bArr);
        } catch (EOFException e) {
            int i = 0;
            while (true) {
                C12388e c12388e = this.f26114j;
                long j = c12388e.f26080k;
                if (j <= 0) {
                    throw e;
                }
                int i2 = c12388e.read(bArr, i, (int) j);
                if (i2 == -1) {
                    throw new AssertionError();
                }
                i += i2;
            }
        }
    }

    @Override // p615g0.InterfaceC12390g
    public int readInt() throws EOFException {
        mo10463p0(4L);
        return this.f26114j.readInt();
    }

    @Override // p615g0.InterfaceC12390g
    public long readLong() throws EOFException {
        mo10463p0(8L);
        return this.f26114j.readLong();
    }

    @Override // p615g0.InterfaceC12390g
    public short readShort() throws EOFException {
        mo10463p0(2L);
        return this.f26114j.readShort();
    }

    @Override // p615g0.InterfaceC12390g
    /* JADX INFO: renamed from: s0 */
    public long mo10467s0() throws EOFException {
        mo10463p0(1L);
        int i = 0;
        while (true) {
            int i2 = i + 1;
            if (!mo10458j(i2)) {
                break;
            }
            byte bM10464q = this.f26114j.m10464q(i);
            if ((bM10464q < ((byte) 48) || bM10464q > ((byte) 57)) && ((bM10464q < ((byte) 97) || bM10464q > ((byte) 102)) && (bM10464q < ((byte) 65) || bM10464q > ((byte) 70)))) {
                if (i != 0) {
                    break;
                }
                StringBuilder sbM833U = C1643a.m833U("Expected leading [0-9a-fA-F] character but was 0x");
                String string = Integer.toString(bM10464q, C12084a.checkRadix(C12084a.checkRadix(16)));
                C12238m.checkExpressionValueIsNotNull(string, "java.lang.Integer.toStri…(this, checkRadix(radix))");
                sbM833U.append(string);
                throw new NumberFormatException(sbM833U.toString());
            }
            i = i2;
        }
        return this.f26114j.mo10467s0();
    }

    @Override // p615g0.InterfaceC12390g
    public void skip(long j) throws EOFException {
        if (!(!this.f26115k)) {
            throw new IllegalStateException("closed".toString());
        }
        while (j > 0) {
            C12388e c12388e = this.f26114j;
            if (c12388e.f26080k == 0 && this.f26116l.mo10176i0(c12388e, 8192) == -1) {
                throw new EOFException();
            }
            long jMin = Math.min(j, this.f26114j.f26080k);
            this.f26114j.skip(jMin);
            j -= jMin;
        }
    }

    @Override // p615g0.InterfaceC12407x
    public C12408y timeout() {
        return this.f26116l.timeout();
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("buffer(");
        sbM833U.append(this.f26116l);
        sbM833U.append(')');
        return sbM833U.toString();
    }

    @Override // p615g0.InterfaceC12390g
    /* JADX INFO: renamed from: u0 */
    public InputStream mo10470u0() {
        return new a();
    }

    @Override // p615g0.InterfaceC12390g
    /* JADX INFO: renamed from: v0 */
    public int mo10471v0(C12398o c12398o) throws EOFException {
        C12238m.checkParameterIsNotNull(c12398o, "options");
        if (!(!this.f26115k)) {
            throw new IllegalStateException("closed".toString());
        }
        do {
            int iM10514b = C12409a.m10514b(this.f26114j, c12398o, true);
            if (iM10514b != -2) {
                if (iM10514b == -1) {
                    break;
                }
                this.f26114j.skip(c12398o.f26107l[iM10514b].mo10502j());
                return iM10514b;
            }
        } while (this.f26116l.mo10176i0(this.f26114j, 8192) != -1);
        return -1;
    }

    @Override // p615g0.InterfaceC12390g
    /* JADX INFO: renamed from: w */
    public boolean mo10472w() {
        if (!this.f26115k) {
            return this.f26114j.mo10472w() && this.f26116l.mo10176i0(this.f26114j, (long) 8192) == -1;
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
            C12401r c12401r = C12401r.this;
            if (c12401r.f26115k) {
                throw new IOException("closed");
            }
            return (int) Math.min(c12401r.f26114j.f26080k, Integer.MAX_VALUE);
        }

        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            C12401r.this.close();
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            C12401r c12401r = C12401r.this;
            if (c12401r.f26115k) {
                throw new IOException("closed");
            }
            C12388e c12388e = c12401r.f26114j;
            if (c12388e.f26080k == 0 && c12401r.f26116l.mo10176i0(c12388e, 8192) == -1) {
                return -1;
            }
            return C12401r.this.f26114j.readByte() & 255;
        }

        public String toString() {
            return C12401r.this + ".inputStream()";
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i, int i2) throws IOException {
            C12238m.checkParameterIsNotNull(bArr, "data");
            if (!C12401r.this.f26115k) {
                C3404f.m4192B(bArr.length, i, i2);
                C12401r c12401r = C12401r.this;
                C12388e c12388e = c12401r.f26114j;
                if (c12388e.f26080k == 0 && c12401r.f26116l.mo10176i0(c12388e, 8192) == -1) {
                    return -1;
                }
                return C12401r.this.f26114j.read(bArr, i, i2);
            }
            throw new IOException("closed");
        }
    }
}
