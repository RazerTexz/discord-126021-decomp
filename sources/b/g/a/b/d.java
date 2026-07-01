package b.g.a.b;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.math.BigInteger;

/* JADX INFO: compiled from: JsonGenerator.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class d implements Closeable, Flushable {
    public static final b.g.a.b.t.h<m> j;
    public static final b.g.a.b.t.h<m> k;
    public j l;

    static {
        b.g.a.b.t.h<m> hVarA = b.g.a.b.t.h.a(m.values());
        j = hVarA;
        k = hVarA.b(m.CAN_WRITE_FORMATTED_NUMBERS);
        hVarA.b(m.CAN_WRITE_BINARY_NATIVELY);
    }

    public abstract void A() throws IOException;

    public abstract void C(double d) throws IOException;

    public abstract void D(float f) throws IOException;

    public abstract void H(int i) throws IOException;

    public abstract void I(long j2) throws IOException;

    public abstract void J(String str) throws IOException;

    public abstract void L(BigDecimal bigDecimal) throws IOException;

    public abstract void N(BigInteger bigInteger) throws IOException;

    public void O(short s2) throws IOException {
        H(s2);
    }

    public abstract void R(char c) throws IOException;

    public void S(k kVar) throws IOException {
        T(kVar.getValue());
    }

    public abstract void T(String str) throws IOException;

    public abstract void U(char[] cArr, int i, int i2) throws IOException;

    public abstract void V(String str) throws IOException;

    public abstract void W() throws IOException;

    public void X(Object obj) throws IOException {
        W();
        e(obj);
    }

    public final void a(int i, int i2, int i3) {
        if (i2 < 0 || i2 + i3 > i) {
            throw new IllegalArgumentException(String.format("invalid argument(s) (offset=%d, length=%d) for input array of %d element", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i)));
        }
    }

    public abstract d b(d$a d_a);

    public void b0(Object obj, int i) throws IOException {
        W();
        e(obj);
    }

    public abstract g c();

    public abstract void c0() throws IOException;

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public abstract void close() throws IOException;

    public abstract boolean d(d$a d_a);

    public void d0(Object obj) throws IOException {
        c0();
        e(obj);
    }

    public void e(Object obj) {
        g gVarC = c();
        if (gVarC != null) {
            gVarC.d(obj);
        }
    }

    public abstract int f(a aVar, InputStream inputStream, int i) throws IOException;

    public void f0(Object obj, int i) throws IOException {
        c0();
        e(obj);
    }

    public abstract void g0(k kVar) throws IOException;

    public abstract void j0(String str) throws IOException;

    public abstract void m0(char[] cArr, int i, int i2) throws IOException;

    public abstract void n(a aVar, byte[] bArr, int i, int i2) throws IOException;

    public void q(byte[] bArr) throws IOException {
        n(b.f656b, bArr, 0, bArr.length);
    }

    public abstract void s(boolean z2) throws IOException;

    public abstract void t() throws IOException;

    public abstract void u() throws IOException;

    public abstract void x(k kVar) throws IOException;

    public abstract void y(String str) throws IOException;
}
