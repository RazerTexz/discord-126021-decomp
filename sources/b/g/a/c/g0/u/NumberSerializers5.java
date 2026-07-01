package b.g.a.c.g0.u;

import b.g.a.b.JsonGenerator;
import b.g.a.b.JsonParser;
import b.g.a.b.JsonToken2;
import b.g.a.b.s.WritableTypeId;
import b.g.a.c.SerializerProvider;
import b.g.a.c.e0.TypeSerializer;
import b.g.a.c.y.JacksonStdImpl;
import java.io.IOException;

/* JADX INFO: renamed from: b.g.a.c.g0.u.x, reason: use source file name */
/* JADX INFO: compiled from: NumberSerializers.java */
/* JADX INFO: loaded from: classes3.dex */
@JacksonStdImpl
public class NumberSerializers5 extends NumberSerializers4<Object> {
    public NumberSerializers5(Class<?> cls) {
        super(cls, JsonParser.b.DOUBLE, "number");
    }

    @Override // b.g.a.c.JsonSerializer
    public void f(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.C(((Double) obj).doubleValue());
    }

    @Override // b.g.a.c.g0.u.StdScalarSerializer, b.g.a.c.JsonSerializer
    public void g(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) throws IOException {
        Double d = (Double) obj;
        double dDoubleValue = d.doubleValue();
        if (!(Double.isNaN(dDoubleValue) || Double.isInfinite(dDoubleValue))) {
            jsonGenerator.C(d.doubleValue());
            return;
        }
        WritableTypeId writableTypeIdE = typeSerializer.e(jsonGenerator, typeSerializer.d(obj, JsonToken2.VALUE_NUMBER_FLOAT));
        jsonGenerator.C(d.doubleValue());
        typeSerializer.f(jsonGenerator, writableTypeIdE);
    }
}
