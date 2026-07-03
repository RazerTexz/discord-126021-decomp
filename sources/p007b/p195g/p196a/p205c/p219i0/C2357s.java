package p007b.p195g.p196a.p205c.p219i0;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.math.BigInteger;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p195g.p196a.p198b.AbstractC2108d;
import p007b.p195g.p196a.p198b.AbstractC2111g;
import p007b.p195g.p196a.p198b.AbstractC2113i;
import p007b.p195g.p196a.p198b.C2105a;
import p007b.p195g.p196a.p198b.C2109e;
import p007b.p195g.p196a.p198b.EnumC2112h;
import p007b.p195g.p196a.p198b.InterfaceC2115k;
import p007b.p195g.p196a.p198b.p199o.AbstractC2120b;

/* JADX INFO: renamed from: b.g.a.c.i0.s */
/* JADX INFO: compiled from: TokenBuffer.java */
/* JADX INFO: loaded from: classes3.dex */
public class C2357s extends AbstractC2108d {

    /* JADX INFO: renamed from: m */
    public int f4979m;

    /* JADX INFO: renamed from: b.g.a.c.i0.s$a */
    /* JADX INFO: compiled from: TokenBuffer.java */
    public static final class a extends AbstractC2120b {

        /* JADX INFO: renamed from: n */
        public int f4980n;

        /* JADX INFO: renamed from: o */
        public C2358t f4981o;

        /* JADX INFO: renamed from: p */
        public boolean f4982p;

        public a(AbstractC2113i abstractC2113i, boolean z2, boolean z3, AbstractC2111g abstractC2111g) {
            super(0);
            this.f4980n = -1;
            this.f4981o = new C2358t();
        }

        @Override // p007b.p195g.p196a.p198b.AbstractC2110f
        /* JADX INFO: renamed from: a */
        public C2109e mo1671a() {
            return C2109e.f4478j;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.f4982p) {
                return;
            }
            this.f4982p = true;
        }
    }

    static {
        AbstractC2108d.a.m1667f();
    }

    @Override // p007b.p195g.p196a.p198b.AbstractC2108d
    /* JADX INFO: renamed from: A */
    public void mo1631A() throws IOException {
        EnumC2112h enumC2112h = EnumC2112h.VALUE_NULL;
        throw null;
    }

    @Override // p007b.p195g.p196a.p198b.AbstractC2108d
    /* JADX INFO: renamed from: C */
    public void mo1632C(double d) throws IOException {
        m2213o0(EnumC2112h.VALUE_NUMBER_FLOAT, Double.valueOf(d));
        throw null;
    }

    @Override // p007b.p195g.p196a.p198b.AbstractC2108d
    /* JADX INFO: renamed from: D */
    public void mo1633D(float f) throws IOException {
        m2213o0(EnumC2112h.VALUE_NUMBER_FLOAT, Float.valueOf(f));
        throw null;
    }

    @Override // p007b.p195g.p196a.p198b.AbstractC2108d
    /* JADX INFO: renamed from: H */
    public void mo1634H(int i) throws IOException {
        m2213o0(EnumC2112h.VALUE_NUMBER_INT, Integer.valueOf(i));
        throw null;
    }

    @Override // p007b.p195g.p196a.p198b.AbstractC2108d
    /* JADX INFO: renamed from: I */
    public void mo1635I(long j) throws IOException {
        m2213o0(EnumC2112h.VALUE_NUMBER_INT, Long.valueOf(j));
        throw null;
    }

    @Override // p007b.p195g.p196a.p198b.AbstractC2108d
    /* JADX INFO: renamed from: J */
    public void mo1636J(String str) throws IOException {
        m2213o0(EnumC2112h.VALUE_NUMBER_FLOAT, str);
        throw null;
    }

    @Override // p007b.p195g.p196a.p198b.AbstractC2108d
    /* JADX INFO: renamed from: L */
    public void mo1637L(BigDecimal bigDecimal) throws IOException {
        if (bigDecimal == null) {
            mo1631A();
            throw null;
        }
        m2213o0(EnumC2112h.VALUE_NUMBER_FLOAT, bigDecimal);
        throw null;
    }

    @Override // p007b.p195g.p196a.p198b.AbstractC2108d
    /* JADX INFO: renamed from: N */
    public void mo1638N(BigInteger bigInteger) throws IOException {
        if (bigInteger == null) {
            mo1631A();
            throw null;
        }
        m2213o0(EnumC2112h.VALUE_NUMBER_INT, bigInteger);
        throw null;
    }

    @Override // p007b.p195g.p196a.p198b.AbstractC2108d
    /* JADX INFO: renamed from: O */
    public void mo1639O(short s2) throws IOException {
        m2213o0(EnumC2112h.VALUE_NUMBER_INT, Short.valueOf(s2));
        throw null;
    }

    @Override // p007b.p195g.p196a.p198b.AbstractC2108d
    /* JADX INFO: renamed from: R */
    public void mo1640R(char c) throws IOException {
        m2214r0();
        throw null;
    }

    @Override // p007b.p195g.p196a.p198b.AbstractC2108d
    /* JADX INFO: renamed from: S */
    public void mo1641S(InterfaceC2115k interfaceC2115k) throws IOException {
        m2214r0();
        throw null;
    }

    @Override // p007b.p195g.p196a.p198b.AbstractC2108d
    /* JADX INFO: renamed from: T */
    public void mo1642T(String str) throws IOException {
        m2214r0();
        throw null;
    }

    @Override // p007b.p195g.p196a.p198b.AbstractC2108d
    /* JADX INFO: renamed from: U */
    public void mo1643U(char[] cArr, int i, int i2) throws IOException {
        m2214r0();
        throw null;
    }

    @Override // p007b.p195g.p196a.p198b.AbstractC2108d
    /* JADX INFO: renamed from: V */
    public void mo1644V(String str) throws IOException {
        EnumC2112h enumC2112h = EnumC2112h.VALUE_EMBEDDED_OBJECT;
        throw null;
    }

    @Override // p007b.p195g.p196a.p198b.AbstractC2108d
    /* JADX INFO: renamed from: W */
    public final void mo1645W() throws IOException {
        throw null;
    }

    @Override // p007b.p195g.p196a.p198b.AbstractC2108d
    /* JADX INFO: renamed from: X */
    public void mo1646X(Object obj) throws IOException {
        throw null;
    }

    @Override // p007b.p195g.p196a.p198b.AbstractC2108d
    /* JADX INFO: renamed from: b */
    public AbstractC2108d mo1648b(AbstractC2108d.a aVar) {
        this.f4979m = (~aVar.m1669h()) & this.f4979m;
        return this;
    }

    @Override // p007b.p195g.p196a.p198b.AbstractC2108d
    /* JADX INFO: renamed from: b0 */
    public void mo1649b0(Object obj, int i) throws IOException {
        throw null;
    }

    @Override // p007b.p195g.p196a.p198b.AbstractC2108d
    /* JADX INFO: renamed from: c */
    public AbstractC2111g mo1650c() {
        return null;
    }

    @Override // p007b.p195g.p196a.p198b.AbstractC2108d
    /* JADX INFO: renamed from: c0 */
    public final void mo1651c0() throws IOException {
        throw null;
    }

    @Override // p007b.p195g.p196a.p198b.AbstractC2108d, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
    }

    @Override // p007b.p195g.p196a.p198b.AbstractC2108d
    /* JADX INFO: renamed from: d */
    public boolean mo1652d(AbstractC2108d.a aVar) {
        return (aVar.m1669h() & this.f4979m) != 0;
    }

    @Override // p007b.p195g.p196a.p198b.AbstractC2108d
    /* JADX INFO: renamed from: d0 */
    public void mo1653d0(Object obj) throws IOException {
        throw null;
    }

    @Override // p007b.p195g.p196a.p198b.AbstractC2108d
    /* JADX INFO: renamed from: f */
    public int mo1655f(C2105a c2105a, InputStream inputStream, int i) {
        throw new UnsupportedOperationException();
    }

    @Override // p007b.p195g.p196a.p198b.AbstractC2108d
    /* JADX INFO: renamed from: f0 */
    public void mo1656f0(Object obj, int i) throws IOException {
        throw null;
    }

    @Override // java.io.Flushable
    public void flush() throws IOException {
    }

    @Override // p007b.p195g.p196a.p198b.AbstractC2108d
    /* JADX INFO: renamed from: g0 */
    public void mo1657g0(InterfaceC2115k interfaceC2115k) throws IOException {
        if (interfaceC2115k == null) {
            mo1631A();
            throw null;
        }
        m2213o0(EnumC2112h.VALUE_STRING, interfaceC2115k);
        throw null;
    }

    @Override // p007b.p195g.p196a.p198b.AbstractC2108d
    /* JADX INFO: renamed from: j0 */
    public void mo1658j0(String str) throws IOException {
        if (str == null) {
            mo1631A();
            throw null;
        }
        m2213o0(EnumC2112h.VALUE_STRING, str);
        throw null;
    }

    @Override // p007b.p195g.p196a.p198b.AbstractC2108d
    /* JADX INFO: renamed from: m0 */
    public void mo1659m0(char[] cArr, int i, int i2) throws IOException {
        mo1658j0(new String(cArr, i, i2));
        throw null;
    }

    @Override // p007b.p195g.p196a.p198b.AbstractC2108d
    /* JADX INFO: renamed from: n */
    public void mo1660n(C2105a c2105a, byte[] bArr, int i, int i2) throws IOException {
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, i, bArr2, 0, i2);
        writeObject(bArr2);
        throw null;
    }

    /* JADX INFO: renamed from: o0 */
    public final void m2213o0(EnumC2112h enumC2112h, Object obj) {
        throw null;
    }

    /* JADX INFO: renamed from: r0 */
    public void m2214r0() {
        throw new UnsupportedOperationException("Called operation not supported for TokenBuffer");
    }

    @Override // p007b.p195g.p196a.p198b.AbstractC2108d
    /* JADX INFO: renamed from: s */
    public void mo1662s(boolean z2) throws IOException {
        if (z2) {
            EnumC2112h enumC2112h = EnumC2112h.VALUE_TRUE;
        } else {
            EnumC2112h enumC2112h2 = EnumC2112h.VALUE_FALSE;
        }
        throw null;
    }

    @Override // p007b.p195g.p196a.p198b.AbstractC2108d
    /* JADX INFO: renamed from: t */
    public final void mo1663t() throws IOException {
        EnumC2112h enumC2112h = EnumC2112h.END_ARRAY;
        throw null;
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("[TokenBuffer: ");
        new a(null, false, false, null);
        sbM833U.append(']');
        return sbM833U.toString();
    }

    @Override // p007b.p195g.p196a.p198b.AbstractC2108d
    /* JADX INFO: renamed from: u */
    public final void mo1664u() throws IOException {
        EnumC2112h enumC2112h = EnumC2112h.END_OBJECT;
        throw null;
    }

    public void writeObject(Object obj) throws IOException {
        if (obj == null) {
            mo1631A();
            throw null;
        }
        if (obj.getClass() == byte[].class || (obj instanceof C2353o)) {
            m2213o0(EnumC2112h.VALUE_EMBEDDED_OBJECT, obj);
            throw null;
        }
        m2213o0(EnumC2112h.VALUE_EMBEDDED_OBJECT, obj);
        throw null;
    }

    @Override // p007b.p195g.p196a.p198b.AbstractC2108d
    /* JADX INFO: renamed from: x */
    public void mo1665x(InterfaceC2115k interfaceC2115k) throws IOException {
        interfaceC2115k.getValue();
        throw null;
    }

    @Override // p007b.p195g.p196a.p198b.AbstractC2108d
    /* JADX INFO: renamed from: y */
    public final void mo1666y(String str) throws IOException {
        throw null;
    }
}
