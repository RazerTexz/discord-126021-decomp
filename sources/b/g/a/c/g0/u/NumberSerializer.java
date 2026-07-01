package b.g.a.c.g0.u;

import b.g.a.a.JsonFormat;
import b.g.a.b.JsonGenerator;
import b.g.a.c.BeanProperty;
import b.g.a.c.JsonSerializer;
import b.g.a.c.SerializerProvider;
import b.g.a.c.g0.ContextualSerializer;
import b.g.a.c.y.JacksonStdImpl;
import com.fasterxml.jackson.databind.JsonMappingException;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;

/* JADX INFO: renamed from: b.g.a.c.g0.u.v, reason: use source file name */
/* JADX INFO: compiled from: NumberSerializer.java */
/* JADX INFO: loaded from: classes3.dex */
@JacksonStdImpl
public class NumberSerializer extends StdScalarSerializer<Number> implements ContextualSerializer {
    public static final NumberSerializer k = new NumberSerializer(Number.class);
    public final boolean _isInt;

    /* JADX INFO: renamed from: b.g.a.c.g0.u.v$a */
    /* JADX INFO: compiled from: NumberSerializer.java */
    public static final class a extends ToStringSerializerBase {
        public static final a k = new a();

        public a() {
            super(BigDecimal.class);
        }

        @Override // b.g.a.c.g0.u.ToStringSerializerBase, b.g.a.c.JsonSerializer
        public boolean d(SerializerProvider serializerProvider, Object obj) {
            return false;
        }

        @Override // b.g.a.c.g0.u.ToStringSerializerBase, b.g.a.c.JsonSerializer
        public void f(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            String string;
            if (jsonGenerator.d(JsonGenerator.a.WRITE_BIGDECIMAL_AS_PLAIN)) {
                BigDecimal bigDecimal = (BigDecimal) obj;
                int iScale = bigDecimal.scale();
                if (!(iScale >= -9999 && iScale <= 9999)) {
                    serializerProvider.G(String.format("Attempt to write plain `java.math.BigDecimal` (see JsonGenerator.Feature.WRITE_BIGDECIMAL_AS_PLAIN) with illegal scale (%d): needs to be between [-%d, %d]", Integer.valueOf(bigDecimal.scale()), 9999, 9999), new Object[0]);
                    throw null;
                }
                string = bigDecimal.toPlainString();
            } else {
                string = obj.toString();
            }
            jsonGenerator.j0(string);
        }

        @Override // b.g.a.c.g0.u.ToStringSerializerBase
        public String p(Object obj) {
            throw new IllegalStateException();
        }
    }

    public NumberSerializer(Class<? extends Number> cls) {
        super(cls, false);
        this._isInt = cls == BigInteger.class;
    }

    @Override // b.g.a.c.g0.ContextualSerializer
    public JsonSerializer<?> a(SerializerProvider serializerProvider, BeanProperty beanProperty) throws JsonMappingException {
        JsonFormat.d dVarL = l(serializerProvider, beanProperty, this._handledType);
        if (dVarL == null || dVarL.e().ordinal() != 8) {
            return this;
        }
        return this._handledType == BigDecimal.class ? a.k : ToStringSerializer.k;
    }

    @Override // b.g.a.c.JsonSerializer
    public void f(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        Number number = (Number) obj;
        if (number instanceof BigDecimal) {
            jsonGenerator.L((BigDecimal) number);
            return;
        }
        if (number instanceof BigInteger) {
            jsonGenerator.N((BigInteger) number);
            return;
        }
        if (number instanceof Long) {
            jsonGenerator.I(number.longValue());
            return;
        }
        if (number instanceof Double) {
            jsonGenerator.C(number.doubleValue());
            return;
        }
        if (number instanceof Float) {
            jsonGenerator.D(number.floatValue());
        } else if ((number instanceof Integer) || (number instanceof Byte) || (number instanceof Short)) {
            jsonGenerator.H(number.intValue());
        } else {
            jsonGenerator.J(number.toString());
        }
    }
}
