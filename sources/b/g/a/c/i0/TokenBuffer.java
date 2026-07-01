package b.g.a.c.i0;

import b.d.b.a.outline;
import b.g.a.b.Base64Variant;
import b.g.a.b.JsonGenerator;
import b.g.a.b.JsonLocation;
import b.g.a.b.JsonStreamContext;
import b.g.a.b.JsonToken2;
import b.g.a.b.ObjectCodec;
import b.g.a.b.SerializableString;
import b.g.a.b.o.ParserMinimalBase;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.math.BigInteger;

/* JADX INFO: renamed from: b.g.a.c.i0.s, reason: use source file name */
/* JADX INFO: compiled from: TokenBuffer.java */
/* JADX INFO: loaded from: classes3.dex */
public class TokenBuffer extends JsonGenerator {
    public int m;

    /* JADX INFO: renamed from: b.g.a.c.i0.s$a */
    /* JADX INFO: compiled from: TokenBuffer.java */
    public static final class a extends ParserMinimalBase {
        public int n;
        public TokenBufferReadContext o;
        public boolean p;

        public a(ObjectCodec objectCodec, boolean z2, boolean z3, JsonStreamContext jsonStreamContext) {
            super(0);
            this.n = -1;
            this.o = new TokenBufferReadContext();
        }

        @Override // b.g.a.b.JsonParser
        public JsonLocation a() {
            return JsonLocation.j;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.p) {
                return;
            }
            this.p = true;
        }
    }

    static {
        JsonGenerator.a.f();
    }

    @Override // b.g.a.b.JsonGenerator
    public void A() throws IOException {
        JsonToken2 jsonToken2 = JsonToken2.VALUE_NULL;
        throw null;
    }

    @Override // b.g.a.b.JsonGenerator
    public void C(double d) throws IOException {
        o0(JsonToken2.VALUE_NUMBER_FLOAT, Double.valueOf(d));
        throw null;
    }

    @Override // b.g.a.b.JsonGenerator
    public void D(float f) throws IOException {
        o0(JsonToken2.VALUE_NUMBER_FLOAT, Float.valueOf(f));
        throw null;
    }

    @Override // b.g.a.b.JsonGenerator
    public void H(int i) throws IOException {
        o0(JsonToken2.VALUE_NUMBER_INT, Integer.valueOf(i));
        throw null;
    }

    @Override // b.g.a.b.JsonGenerator
    public void I(long j) throws IOException {
        o0(JsonToken2.VALUE_NUMBER_INT, Long.valueOf(j));
        throw null;
    }

    @Override // b.g.a.b.JsonGenerator
    public void J(String str) throws IOException {
        o0(JsonToken2.VALUE_NUMBER_FLOAT, str);
        throw null;
    }

    @Override // b.g.a.b.JsonGenerator
    public void L(BigDecimal bigDecimal) throws IOException {
        if (bigDecimal == null) {
            A();
            throw null;
        }
        o0(JsonToken2.VALUE_NUMBER_FLOAT, bigDecimal);
        throw null;
    }

    @Override // b.g.a.b.JsonGenerator
    public void N(BigInteger bigInteger) throws IOException {
        if (bigInteger == null) {
            A();
            throw null;
        }
        o0(JsonToken2.VALUE_NUMBER_INT, bigInteger);
        throw null;
    }

    @Override // b.g.a.b.JsonGenerator
    public void O(short s2) throws IOException {
        o0(JsonToken2.VALUE_NUMBER_INT, Short.valueOf(s2));
        throw null;
    }

    @Override // b.g.a.b.JsonGenerator
    public void R(char c) throws IOException {
        r0();
        throw null;
    }

    @Override // b.g.a.b.JsonGenerator
    public void S(SerializableString serializableString) throws IOException {
        r0();
        throw null;
    }

    @Override // b.g.a.b.JsonGenerator
    public void T(String str) throws IOException {
        r0();
        throw null;
    }

    @Override // b.g.a.b.JsonGenerator
    public void U(char[] cArr, int i, int i2) throws IOException {
        r0();
        throw null;
    }

    @Override // b.g.a.b.JsonGenerator
    public void V(String str) throws IOException {
        JsonToken2 jsonToken2 = JsonToken2.VALUE_EMBEDDED_OBJECT;
        throw null;
    }

    @Override // b.g.a.b.JsonGenerator
    public final void W() throws IOException {
        throw null;
    }

    @Override // b.g.a.b.JsonGenerator
    public void X(Object obj) throws IOException {
        throw null;
    }

    @Override // b.g.a.b.JsonGenerator
    public JsonGenerator b(JsonGenerator.a aVar) {
        this.m = (~aVar.h()) & this.m;
        return this;
    }

    @Override // b.g.a.b.JsonGenerator
    public void b0(Object obj, int i) throws IOException {
        throw null;
    }

    @Override // b.g.a.b.JsonGenerator
    public JsonStreamContext c() {
        return null;
    }

    @Override // b.g.a.b.JsonGenerator
    public final void c0() throws IOException {
        throw null;
    }

    @Override // b.g.a.b.JsonGenerator, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
    }

    @Override // b.g.a.b.JsonGenerator
    public boolean d(JsonGenerator.a aVar) {
        return (aVar.h() & this.m) != 0;
    }

    @Override // b.g.a.b.JsonGenerator
    public void d0(Object obj) throws IOException {
        throw null;
    }

    @Override // b.g.a.b.JsonGenerator
    public int f(Base64Variant base64Variant, InputStream inputStream, int i) {
        throw new UnsupportedOperationException();
    }

    @Override // b.g.a.b.JsonGenerator
    public void f0(Object obj, int i) throws IOException {
        throw null;
    }

    @Override // java.io.Flushable
    public void flush() throws IOException {
    }

    @Override // b.g.a.b.JsonGenerator
    public void g0(SerializableString serializableString) throws IOException {
        if (serializableString == null) {
            A();
            throw null;
        }
        o0(JsonToken2.VALUE_STRING, serializableString);
        throw null;
    }

    @Override // b.g.a.b.JsonGenerator
    public void j0(String str) throws IOException {
        if (str == null) {
            A();
            throw null;
        }
        o0(JsonToken2.VALUE_STRING, str);
        throw null;
    }

    @Override // b.g.a.b.JsonGenerator
    public void m0(char[] cArr, int i, int i2) throws IOException {
        j0(new String(cArr, i, i2));
        throw null;
    }

    @Override // b.g.a.b.JsonGenerator
    public void n(Base64Variant base64Variant, byte[] bArr, int i, int i2) throws IOException {
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, i, bArr2, 0, i2);
        writeObject(bArr2);
        throw null;
    }

    public final void o0(JsonToken2 jsonToken2, Object obj) {
        throw null;
    }

    public void r0() {
        throw new UnsupportedOperationException("Called operation not supported for TokenBuffer");
    }

    @Override // b.g.a.b.JsonGenerator
    public void s(boolean z2) throws IOException {
        if (z2) {
            JsonToken2 jsonToken2 = JsonToken2.VALUE_TRUE;
        } else {
            JsonToken2 jsonToken3 = JsonToken2.VALUE_FALSE;
        }
        throw null;
    }

    @Override // b.g.a.b.JsonGenerator
    public final void t() throws IOException {
        JsonToken2 jsonToken2 = JsonToken2.END_ARRAY;
        throw null;
    }

    public String toString() {
        StringBuilder sbU = outline.U("[TokenBuffer: ");
        new a(null, false, false, null);
        sbU.append(']');
        return sbU.toString();
    }

    @Override // b.g.a.b.JsonGenerator
    public final void u() throws IOException {
        JsonToken2 jsonToken2 = JsonToken2.END_OBJECT;
        throw null;
    }

    public void writeObject(Object obj) throws IOException {
        if (obj == null) {
            A();
            throw null;
        }
        if (obj.getClass() == byte[].class || (obj instanceof RawValue)) {
            o0(JsonToken2.VALUE_EMBEDDED_OBJECT, obj);
            throw null;
        }
        o0(JsonToken2.VALUE_EMBEDDED_OBJECT, obj);
        throw null;
    }

    @Override // b.g.a.b.JsonGenerator
    public void x(SerializableString serializableString) throws IOException {
        serializableString.getValue();
        throw null;
    }

    @Override // b.g.a.b.JsonGenerator
    public final void y(String str) throws IOException {
        throw null;
    }
}
