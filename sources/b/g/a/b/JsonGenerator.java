package b.g.a.b;

import b.g.a.b.t.JacksonFeatureSet;
import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.math.BigInteger;

/* JADX INFO: renamed from: b.g.a.b.d, reason: use source file name */
/* JADX INFO: compiled from: JsonGenerator.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class JsonGenerator implements Closeable, Flushable {
    public static final JacksonFeatureSet<StreamWriteCapability> j;
    public static final JacksonFeatureSet<StreamWriteCapability> k;
    public PrettyPrinter2 l;

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

        public static int f() {
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

        public boolean g(int i) {
            return (i & this._mask) != 0;
        }

        public int h() {
            return this._mask;
        }
    }

    static {
        JacksonFeatureSet<StreamWriteCapability> jacksonFeatureSetA = JacksonFeatureSet.a(StreamWriteCapability.values());
        j = jacksonFeatureSetA;
        k = jacksonFeatureSetA.b(StreamWriteCapability.CAN_WRITE_FORMATTED_NUMBERS);
        jacksonFeatureSetA.b(StreamWriteCapability.CAN_WRITE_BINARY_NATIVELY);
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

    public void S(SerializableString serializableString) throws IOException {
        T(serializableString.getValue());
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

    public abstract JsonGenerator b(a aVar);

    public void b0(Object obj, int i) throws IOException {
        W();
        e(obj);
    }

    public abstract JsonStreamContext c();

    public abstract void c0() throws IOException;

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public abstract void close() throws IOException;

    public abstract boolean d(a aVar);

    public void d0(Object obj) throws IOException {
        c0();
        e(obj);
    }

    public void e(Object obj) {
        JsonStreamContext jsonStreamContextC = c();
        if (jsonStreamContextC != null) {
            jsonStreamContextC.d(obj);
        }
    }

    public abstract int f(Base64Variant base64Variant, InputStream inputStream, int i) throws IOException;

    public void f0(Object obj, int i) throws IOException {
        c0();
        e(obj);
    }

    public abstract void g0(SerializableString serializableString) throws IOException;

    public abstract void j0(String str) throws IOException;

    public abstract void m0(char[] cArr, int i, int i2) throws IOException;

    public abstract void n(Base64Variant base64Variant, byte[] bArr, int i, int i2) throws IOException;

    public void q(byte[] bArr) throws IOException {
        n(Base64Variants.f656b, bArr, 0, bArr.length);
    }

    public abstract void s(boolean z2) throws IOException;

    public abstract void t() throws IOException;

    public abstract void u() throws IOException;

    public abstract void x(SerializableString serializableString) throws IOException;

    public abstract void y(String str) throws IOException;
}
