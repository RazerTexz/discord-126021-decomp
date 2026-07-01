package b.g.a.c.i0;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.math.BigInteger;

/* JADX INFO: compiled from: TokenBuffer.java */
/* JADX INFO: loaded from: classes3.dex */
public class s extends b.g.a.b.d {
    public int m;

    static {
        b.g.a.b.d$a.f();
    }

    @Override // b.g.a.b.d
    public void A() throws IOException {
        b.g.a.b.h hVar = b.g.a.b.h.VALUE_NULL;
        throw null;
    }

    @Override // b.g.a.b.d
    public void C(double d) throws IOException {
        o0(b.g.a.b.h.VALUE_NUMBER_FLOAT, Double.valueOf(d));
        throw null;
    }

    @Override // b.g.a.b.d
    public void D(float f) throws IOException {
        o0(b.g.a.b.h.VALUE_NUMBER_FLOAT, Float.valueOf(f));
        throw null;
    }

    @Override // b.g.a.b.d
    public void H(int i) throws IOException {
        o0(b.g.a.b.h.VALUE_NUMBER_INT, Integer.valueOf(i));
        throw null;
    }

    @Override // b.g.a.b.d
    public void I(long j) throws IOException {
        o0(b.g.a.b.h.VALUE_NUMBER_INT, Long.valueOf(j));
        throw null;
    }

    @Override // b.g.a.b.d
    public void J(String str) throws IOException {
        o0(b.g.a.b.h.VALUE_NUMBER_FLOAT, str);
        throw null;
    }

    @Override // b.g.a.b.d
    public void L(BigDecimal bigDecimal) throws IOException {
        if (bigDecimal == null) {
            A();
            throw null;
        }
        o0(b.g.a.b.h.VALUE_NUMBER_FLOAT, bigDecimal);
        throw null;
    }

    @Override // b.g.a.b.d
    public void N(BigInteger bigInteger) throws IOException {
        if (bigInteger == null) {
            A();
            throw null;
        }
        o0(b.g.a.b.h.VALUE_NUMBER_INT, bigInteger);
        throw null;
    }

    @Override // b.g.a.b.d
    public void O(short s2) throws IOException {
        o0(b.g.a.b.h.VALUE_NUMBER_INT, Short.valueOf(s2));
        throw null;
    }

    @Override // b.g.a.b.d
    public void R(char c) throws IOException {
        r0();
        throw null;
    }

    @Override // b.g.a.b.d
    public void S(b.g.a.b.k kVar) throws IOException {
        r0();
        throw null;
    }

    @Override // b.g.a.b.d
    public void T(String str) throws IOException {
        r0();
        throw null;
    }

    @Override // b.g.a.b.d
    public void U(char[] cArr, int i, int i2) throws IOException {
        r0();
        throw null;
    }

    @Override // b.g.a.b.d
    public void V(String str) throws IOException {
        b.g.a.b.h hVar = b.g.a.b.h.VALUE_EMBEDDED_OBJECT;
        throw null;
    }

    @Override // b.g.a.b.d
    public final void W() throws IOException {
        throw null;
    }

    @Override // b.g.a.b.d
    public void X(Object obj) throws IOException {
        throw null;
    }

    @Override // b.g.a.b.d
    public b.g.a.b.d b(b.g.a.b.d$a d_a) {
        this.m = (~d_a.h()) & this.m;
        return this;
    }

    @Override // b.g.a.b.d
    public void b0(Object obj, int i) throws IOException {
        throw null;
    }

    @Override // b.g.a.b.d
    public b.g.a.b.g c() {
        return null;
    }

    @Override // b.g.a.b.d
    public final void c0() throws IOException {
        throw null;
    }

    @Override // b.g.a.b.d, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
    }

    @Override // b.g.a.b.d
    public boolean d(b.g.a.b.d$a d_a) {
        return (d_a.h() & this.m) != 0;
    }

    @Override // b.g.a.b.d
    public void d0(Object obj) throws IOException {
        throw null;
    }

    @Override // b.g.a.b.d
    public int f(b.g.a.b.a aVar, InputStream inputStream, int i) {
        throw new UnsupportedOperationException();
    }

    @Override // b.g.a.b.d
    public void f0(Object obj, int i) throws IOException {
        throw null;
    }

    @Override // java.io.Flushable
    public void flush() throws IOException {
    }

    @Override // b.g.a.b.d
    public void g0(b.g.a.b.k kVar) throws IOException {
        if (kVar == null) {
            A();
            throw null;
        }
        o0(b.g.a.b.h.VALUE_STRING, kVar);
        throw null;
    }

    @Override // b.g.a.b.d
    public void j0(String str) throws IOException {
        if (str == null) {
            A();
            throw null;
        }
        o0(b.g.a.b.h.VALUE_STRING, str);
        throw null;
    }

    @Override // b.g.a.b.d
    public void m0(char[] cArr, int i, int i2) throws IOException {
        j0(new String(cArr, i, i2));
        throw null;
    }

    @Override // b.g.a.b.d
    public void n(b.g.a.b.a aVar, byte[] bArr, int i, int i2) throws IOException {
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, i, bArr2, 0, i2);
        writeObject(bArr2);
        throw null;
    }

    public final void o0(b.g.a.b.h hVar, Object obj) {
        throw null;
    }

    public void r0() {
        throw new UnsupportedOperationException("Called operation not supported for TokenBuffer");
    }

    @Override // b.g.a.b.d
    public void s(boolean z2) throws IOException {
        if (z2) {
            b.g.a.b.h hVar = b.g.a.b.h.VALUE_TRUE;
        } else {
            b.g.a.b.h hVar2 = b.g.a.b.h.VALUE_FALSE;
        }
        throw null;
    }

    @Override // b.g.a.b.d
    public final void t() throws IOException {
        b.g.a.b.h hVar = b.g.a.b.h.END_ARRAY;
        throw null;
    }

    public String toString() {
        StringBuilder sbU = b.d.b.a.a.U("[TokenBuffer: ");
        new s$a(null, false, false, null);
        sbU.append(']');
        return sbU.toString();
    }

    @Override // b.g.a.b.d
    public final void u() throws IOException {
        b.g.a.b.h hVar = b.g.a.b.h.END_OBJECT;
        throw null;
    }

    public void writeObject(Object obj) throws IOException {
        if (obj == null) {
            A();
            throw null;
        }
        if (obj.getClass() == byte[].class || (obj instanceof o)) {
            o0(b.g.a.b.h.VALUE_EMBEDDED_OBJECT, obj);
            throw null;
        }
        o0(b.g.a.b.h.VALUE_EMBEDDED_OBJECT, obj);
        throw null;
    }

    @Override // b.g.a.b.d
    public void x(b.g.a.b.k kVar) throws IOException {
        kVar.getValue();
        throw null;
    }

    @Override // b.g.a.b.d
    public final void y(String str) throws IOException {
        throw null;
    }
}
