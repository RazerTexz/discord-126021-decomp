package b.g.a.c.g0.t;

import b.g.a.b.JsonGenerator;
import b.g.a.b.JsonToken2;
import b.g.a.b.s.WritableTypeId;
import b.g.a.c.BeanProperty;
import b.g.a.c.JsonSerializer;
import b.g.a.c.SerializationFeature;
import b.g.a.c.SerializerProvider;
import b.g.a.c.e0.TypeSerializer;
import b.g.a.c.g0.u.StaticListSerializerBase;
import b.g.a.c.y.JacksonStdImpl;
import java.io.IOException;
import java.util.Collection;

/* JADX INFO: renamed from: b.g.a.c.g0.t.o, reason: use source file name */
/* JADX INFO: compiled from: StringCollectionSerializer.java */
/* JADX INFO: loaded from: classes3.dex */
@JacksonStdImpl
public class StringCollectionSerializer extends StaticListSerializerBase<Collection<String>> {
    public static final StringCollectionSerializer k = new StringCollectionSerializer();

    public StringCollectionSerializer() {
        super(Collection.class);
    }

    @Override // b.g.a.c.JsonSerializer
    public void f(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        Collection<String> collection = (Collection) obj;
        int size = collection.size();
        if (size == 1 && ((this._unwrapSingle == null && serializerProvider.D(SerializationFeature.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED)) || this._unwrapSingle == Boolean.TRUE)) {
            r(collection, jsonGenerator, serializerProvider);
            return;
        }
        jsonGenerator.b0(collection, size);
        r(collection, jsonGenerator, serializerProvider);
        jsonGenerator.t();
    }

    @Override // b.g.a.c.g0.u.StaticListSerializerBase, b.g.a.c.JsonSerializer
    public void g(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) throws IOException {
        Collection<String> collection = (Collection) obj;
        WritableTypeId writableTypeIdE = typeSerializer.e(jsonGenerator, typeSerializer.d(collection, JsonToken2.START_ARRAY));
        jsonGenerator.e(collection);
        r(collection, jsonGenerator, serializerProvider);
        typeSerializer.f(jsonGenerator, writableTypeIdE);
    }

    @Override // b.g.a.c.g0.u.StaticListSerializerBase
    public JsonSerializer<?> p(BeanProperty beanProperty, Boolean bool) {
        return new StringCollectionSerializer(this, bool);
    }

    @Override // b.g.a.c.g0.u.StaticListSerializerBase
    /* JADX INFO: renamed from: q */
    public void g(Collection<String> collection, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) throws IOException {
        WritableTypeId writableTypeIdE = typeSerializer.e(jsonGenerator, typeSerializer.d(collection, JsonToken2.START_ARRAY));
        jsonGenerator.e(collection);
        r(collection, jsonGenerator, serializerProvider);
        typeSerializer.f(jsonGenerator, writableTypeIdE);
    }

    public final void r(Collection<String> collection, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        int i = 0;
        try {
            for (String str : collection) {
                if (str == null) {
                    serializerProvider.l(jsonGenerator);
                } else {
                    jsonGenerator.j0(str);
                }
                i++;
            }
        } catch (Exception e) {
            n(serializerProvider, e, collection, i);
            throw null;
        }
    }

    public StringCollectionSerializer(StringCollectionSerializer stringCollectionSerializer, Boolean bool) {
        super(stringCollectionSerializer, bool);
    }
}
