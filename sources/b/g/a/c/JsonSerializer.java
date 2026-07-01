package b.g.a.c;

import b.g.a.b.JsonGenerator;
import b.g.a.c.e0.TypeSerializer;
import b.g.a.c.g0.t.UnwrappingBeanSerializer;
import b.g.a.c.i0.NameTransformer4;
import java.io.IOException;

/* JADX INFO: renamed from: b.g.a.c.n, reason: use source file name */
/* JADX INFO: compiled from: JsonSerializer.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class JsonSerializer<T> {

    /* JADX INFO: renamed from: b.g.a.c.n$a */
    /* JADX INFO: compiled from: JsonSerializer.java */
    public static abstract class a extends JsonSerializer<Object> {
    }

    public Class<T> c() {
        return null;
    }

    public boolean d(SerializerProvider serializerProvider, T t) {
        return t == null;
    }

    public boolean e() {
        return this instanceof UnwrappingBeanSerializer;
    }

    public abstract void f(T t, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException;

    public void g(T t, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) throws IOException {
        Class clsC = c();
        if (clsC == null) {
            clsC = t.getClass();
        }
        serializerProvider.f(serializerProvider.b(clsC), String.format("Type id handling not implemented for type %s (by serializer of type %s)", clsC.getName(), getClass().getName()));
        throw null;
    }

    public JsonSerializer<T> h(NameTransformer4 nameTransformer4) {
        return this;
    }

    public boolean i() {
        return false;
    }
}
