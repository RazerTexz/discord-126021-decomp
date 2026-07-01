package b.g.a.c.g0.t;

import b.g.a.b.JsonGenerator;
import b.g.a.b.JsonToken2;
import b.g.a.c.SerializationFeature;
import b.g.a.c.SerializerProvider;
import b.g.a.c.e0.TypeSerializer;
import b.g.a.c.g0.u.StdSerializer;
import com.fasterxml.jackson.databind.JsonMappingException;
import java.io.IOException;

/* JADX INFO: renamed from: b.g.a.c.g0.t.q, reason: use source file name */
/* JADX INFO: compiled from: UnknownSerializer.java */
/* JADX INFO: loaded from: classes3.dex */
public class UnknownSerializer extends StdSerializer<Object> {
    public UnknownSerializer() {
        super(Object.class);
    }

    @Override // b.g.a.c.JsonSerializer
    public boolean d(SerializerProvider serializerProvider, Object obj) {
        return true;
    }

    @Override // b.g.a.c.JsonSerializer
    public void f(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        if (serializerProvider.D(SerializationFeature.FAIL_ON_EMPTY_BEANS)) {
            p(serializerProvider, obj);
        }
        jsonGenerator.f0(obj, 0);
        jsonGenerator.u();
    }

    @Override // b.g.a.c.JsonSerializer
    public final void g(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) throws IOException {
        if (serializerProvider.D(SerializationFeature.FAIL_ON_EMPTY_BEANS)) {
            p(serializerProvider, obj);
        }
        typeSerializer.f(jsonGenerator, typeSerializer.e(jsonGenerator, typeSerializer.d(obj, JsonToken2.START_OBJECT)));
    }

    public void p(SerializerProvider serializerProvider, Object obj) throws JsonMappingException {
        serializerProvider.g(this._handledType, String.format("No serializer found for class %s and no properties discovered to create BeanSerializer (to avoid exception, disable SerializationFeature.FAIL_ON_EMPTY_BEANS)", obj.getClass().getName()));
    }

    public UnknownSerializer(Class<?> cls) {
        super(cls, false);
    }
}
