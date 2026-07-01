package b.g.a.c.g0.u;

import b.g.a.a.JsonFormat;
import b.g.a.b.JsonGenerator;
import b.g.a.b.JsonToken2;
import b.g.a.b.s.WritableTypeId;
import b.g.a.c.BeanProperty;
import b.g.a.c.JsonSerializer;
import b.g.a.c.SerializationFeature;
import b.g.a.c.SerializerProvider;
import b.g.a.c.e0.TypeSerializer;
import b.g.a.c.g0.ContainerSerializer;
import b.g.a.c.g0.ContextualSerializer;
import com.fasterxml.jackson.databind.JsonMappingException;
import java.io.IOException;
import java.util.Objects;

/* JADX INFO: renamed from: b.g.a.c.g0.u.a, reason: use source file name */
/* JADX INFO: compiled from: ArraySerializerBase.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class ArraySerializerBase<T> extends ContainerSerializer<T> implements ContextualSerializer {
    public final BeanProperty _property;
    public final Boolean _unwrapSingle;

    public ArraySerializerBase(Class<T> cls) {
        super(cls);
        this._property = null;
        this._unwrapSingle = null;
    }

    public JsonSerializer<?> a(SerializerProvider serializerProvider, BeanProperty beanProperty) throws JsonMappingException {
        JsonFormat.d dVarL;
        if (beanProperty != null && (dVarL = l(serializerProvider, beanProperty, this._handledType)) != null) {
            Boolean boolB = dVarL.b(JsonFormat.a.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED);
            if (!Objects.equals(boolB, this._unwrapSingle)) {
                return s(beanProperty, boolB);
            }
        }
        return this;
    }

    @Override // b.g.a.c.JsonSerializer
    public void f(T t, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        if (r(serializerProvider) && q(t)) {
            t(t, jsonGenerator, serializerProvider);
            return;
        }
        jsonGenerator.X(t);
        t(t, jsonGenerator, serializerProvider);
        jsonGenerator.t();
    }

    @Override // b.g.a.c.JsonSerializer
    public final void g(T t, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) throws IOException {
        WritableTypeId writableTypeIdE = typeSerializer.e(jsonGenerator, typeSerializer.d(t, JsonToken2.START_ARRAY));
        jsonGenerator.e(t);
        t(t, jsonGenerator, serializerProvider);
        typeSerializer.f(jsonGenerator, writableTypeIdE);
    }

    public final boolean r(SerializerProvider serializerProvider) {
        Boolean bool = this._unwrapSingle;
        return bool == null ? serializerProvider.D(SerializationFeature.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED) : bool.booleanValue();
    }

    public abstract JsonSerializer<?> s(BeanProperty beanProperty, Boolean bool);

    public abstract void t(T t, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException;

    public ArraySerializerBase(ArraySerializerBase<?> arraySerializerBase, BeanProperty beanProperty, Boolean bool) {
        super(arraySerializerBase._handledType, false);
        this._property = beanProperty;
        this._unwrapSingle = bool;
    }
}
