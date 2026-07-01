package b.g.a.c.g0.u;

import b.g.a.b.JsonGenerator;
import b.g.a.c.BeanProperty;
import b.g.a.c.JavaType;
import b.g.a.c.JsonSerializer;
import b.g.a.c.SerializationFeature;
import b.g.a.c.SerializerProvider;
import b.g.a.c.e0.TypeSerializer;
import b.g.a.c.g0.ContainerSerializer;
import java.io.IOException;
import java.util.EnumSet;
import java.util.Iterator;

/* JADX INFO: renamed from: b.g.a.c.g0.u.n, reason: use source file name */
/* JADX INFO: compiled from: EnumSetSerializer.java */
/* JADX INFO: loaded from: classes3.dex */
public class EnumSetSerializer2 extends AsArraySerializerBase<EnumSet<? extends Enum<?>>> {
    public EnumSetSerializer2(JavaType javaType) {
        super((Class<?>) EnumSet.class, javaType, true, (TypeSerializer) null, (JsonSerializer<Object>) null);
    }

    @Override // b.g.a.c.JsonSerializer
    public boolean d(SerializerProvider serializerProvider, Object obj) {
        return ((EnumSet) obj).isEmpty();
    }

    @Override // b.g.a.c.g0.u.AsArraySerializerBase, b.g.a.c.JsonSerializer
    public void f(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        EnumSet<? extends Enum<?>> enumSet = (EnumSet) obj;
        int size = enumSet.size();
        if (size == 1 && ((this._unwrapSingle == null && serializerProvider.D(SerializationFeature.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED)) || this._unwrapSingle == Boolean.TRUE)) {
            s(enumSet, jsonGenerator, serializerProvider);
            return;
        }
        jsonGenerator.b0(enumSet, size);
        s(enumSet, jsonGenerator, serializerProvider);
        jsonGenerator.t();
    }

    @Override // b.g.a.c.g0.ContainerSerializer
    public ContainerSerializer p(TypeSerializer typeSerializer) {
        return this;
    }

    @Override // b.g.a.c.g0.ContainerSerializer
    public boolean q(Object obj) {
        return ((EnumSet) obj).size() == 1;
    }

    @Override // b.g.a.c.g0.u.AsArraySerializerBase
    public AsArraySerializerBase<EnumSet<? extends Enum<?>>> t(BeanProperty beanProperty, TypeSerializer typeSerializer, JsonSerializer jsonSerializer, Boolean bool) {
        return new EnumSetSerializer2(this, beanProperty, typeSerializer, jsonSerializer, bool);
    }

    @Override // b.g.a.c.g0.u.AsArraySerializerBase
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public void s(EnumSet<? extends Enum<?>> enumSet, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        JsonSerializer<Object> jsonSerializerN = this._elementSerializer;
        Iterator it = enumSet.iterator();
        while (it.hasNext()) {
            Enum r1 = (Enum) it.next();
            if (jsonSerializerN == null) {
                jsonSerializerN = serializerProvider.n(r1.getDeclaringClass(), this._property);
            }
            jsonSerializerN.f(r1, jsonGenerator, serializerProvider);
        }
    }

    public EnumSetSerializer2(EnumSetSerializer2 enumSetSerializer2, BeanProperty beanProperty, TypeSerializer typeSerializer, JsonSerializer<?> jsonSerializer, Boolean bool) {
        super(enumSetSerializer2, beanProperty, typeSerializer, jsonSerializer, bool);
    }
}
