package p007b.p195g.p196a.p198b;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.math.BigInteger;
import p007b.p195g.p196a.p198b.p204t.C2146h;

/* JADX INFO: renamed from: b.g.a.b.d */
/* JADX INFO: compiled from: JsonGenerator.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC2108d implements Closeable, Flushable {

    /* JADX INFO: renamed from: j */
    public static final C2146h<EnumC2117m> f4464j;

    /* JADX INFO: renamed from: k */
    public static final C2146h<EnumC2117m> f4465k;

    /* JADX INFO: renamed from: l */
    public InterfaceC2114j f4466l;

    /* JADX INFO: renamed from: b.g.a.b.d$a */
    /* JADX INFO: compiled from: JsonGenerator.java */
    public enum a {
        AUTO_CLOSE_TARGET(true),
        AUTO_CLOSE_JSON_CONTENT(true),
        FLUSH_PASSED_TO_STREAM(true),
        QUOTE_FIELD_NAMES(true),
        QUOTE_NON_NUMERIC_NUMBERS(true),
        ESCAPE_NON_ASCII(false),
        WRITE_NUMBERS_AS_STRINGS(false),
        WRITE_BIGDECIMAL_AS_PLAIN(false),
        STRICT_DUPLICATE_DETECTION(false),
        IGNORE_UNKNOWN(false);

        private final boolean _defaultState;
        private final int _mask = 1 << ordinal();

        a(boolean z2) {
            this._defaultState = z2;
        }

        /* JADX INFO: renamed from: f */
        public static int m1667f() {
            a[] aVarArrValues = values();
            int i = 0;
            for (int i2 = 0; i2 < 10; i2++) {
                a aVar = aVarArrValues[i2];
                if (aVar._defaultState) {
                    i |= aVar._mask;
                }
            }
            return i;
        }

        /* JADX INFO: renamed from: g */
        public boolean m1668g(int i) {
            return (i & this._mask) != 0;
        }

        /* JADX INFO: renamed from: h */
        public int m1669h() {
            return this._mask;
        }
    }

    static {
        C2146h<EnumC2117m> c2146hM1734a = C2146h.m1734a(EnumC2117m.values());
        f4464j = c2146hM1734a;
        f4465k = c2146hM1734a.m1735b(EnumC2117m.CAN_WRITE_FORMATTED_NUMBERS);
        c2146hM1734a.m1735b(EnumC2117m.CAN_WRITE_BINARY_NATIVELY);
    }

    /* JADX INFO: renamed from: A */
    public abstract void mo1631A() throws IOException;

    /* JADX INFO: renamed from: C */
    public abstract void mo1632C(double d) throws IOException;

    /* JADX INFO: renamed from: D */
    public abstract void mo1633D(float f) throws IOException;

    /* JADX INFO: renamed from: H */
    public abstract void mo1634H(int i) throws IOException;

    /* JADX INFO: renamed from: I */
    public abstract void mo1635I(long j) throws IOException;

    /* JADX INFO: renamed from: J */
    public abstract void mo1636J(String str) throws IOException;

    /* JADX INFO: renamed from: L */
    public abstract void mo1637L(BigDecimal bigDecimal) throws IOException;

    /* JADX INFO: renamed from: N */
    public abstract void mo1638N(BigInteger bigInteger) throws IOException;

    /* JADX INFO: renamed from: O */
    public void mo1639O(short s2) throws IOException {
        mo1634H(s2);
    }

    /* JADX INFO: renamed from: R */
    public abstract void mo1640R(char c) throws IOException;

    /* JADX INFO: renamed from: S */
    public void mo1641S(InterfaceC2115k interfaceC2115k) throws IOException {
        mo1642T(interfaceC2115k.getValue());
    }

    /* JADX INFO: renamed from: T */
    public abstract void mo1642T(String str) throws IOException;

    /* JADX INFO: renamed from: U */
    public abstract void mo1643U(char[] cArr, int i, int i2) throws IOException;

    /* JADX INFO: renamed from: V */
    public abstract void mo1644V(String str) throws IOException;

    /* JADX INFO: renamed from: W */
    public abstract void mo1645W() throws IOException;

    /* JADX INFO: renamed from: X */
    public void mo1646X(Object obj) throws IOException {
        mo1645W();
        mo1654e(obj);
    }

    /* JADX INFO: renamed from: a */
    public final void m1647a(int i, int i2, int i3) {
        if (i2 < 0 || i2 + i3 > i) {
            throw new IllegalArgumentException(String.format("invalid argument(s) (offset=%d, length=%d) for input array of %d element", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i)));
        }
    }

    /* JADX INFO: renamed from: b */
    public abstract AbstractC2108d mo1648b(a aVar);

    /* JADX INFO: renamed from: b0 */
    public void mo1649b0(Object obj, int i) throws IOException {
        mo1645W();
        mo1654e(obj);
    }

    /* JADX INFO: renamed from: c */
    public abstract AbstractC2111g mo1650c();

    /* JADX INFO: renamed from: c0 */
    public abstract void mo1651c0() throws IOException;

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public abstract void close() throws IOException;

    /* JADX INFO: renamed from: d */
    public abstract boolean mo1652d(a aVar);

    /* JADX INFO: renamed from: d0 */
    public void mo1653d0(Object obj) throws IOException {
        mo1651c0();
        mo1654e(obj);
    }

    /* JADX INFO: renamed from: e */
    public void mo1654e(Object obj) {
        AbstractC2111g abstractC2111gMo1650c = mo1650c();
        if (abstractC2111gMo1650c != null) {
            abstractC2111gMo1650c.mo1676d(obj);
        }
    }

    /* JADX INFO: renamed from: f */
    public abstract int mo1655f(C2105a c2105a, InputStream inputStream, int i) throws IOException;

    /* JADX INFO: renamed from: f0 */
    public void mo1656f0(Object obj, int i) throws IOException {
        mo1651c0();
        mo1654e(obj);
    }

    /* JADX INFO: renamed from: g0 */
    public abstract void mo1657g0(InterfaceC2115k interfaceC2115k) throws IOException;

    /* JADX INFO: renamed from: j0 */
    public abstract void mo1658j0(String str) throws IOException;

    /* JADX INFO: renamed from: m0 */
    public abstract void mo1659m0(char[] cArr, int i, int i2) throws IOException;

    /* JADX INFO: renamed from: n */
    public abstract void mo1660n(C2105a c2105a, byte[] bArr, int i, int i2) throws IOException;

    /* JADX INFO: renamed from: q */
    public void m1661q(byte[] bArr) throws IOException {
        mo1660n(C2106b.f4452b, bArr, 0, bArr.length);
    }

    /* JADX INFO: renamed from: s */
    public abstract void mo1662s(boolean z2) throws IOException;

    /* JADX INFO: renamed from: t */
    public abstract void mo1663t() throws IOException;

    /* JADX INFO: renamed from: u */
    public abstract void mo1664u() throws IOException;

    /* JADX INFO: renamed from: x */
    public abstract void mo1665x(InterfaceC2115k interfaceC2115k) throws IOException;

    /* JADX INFO: renamed from: y */
    public abstract void mo1666y(String str) throws IOException;
}
