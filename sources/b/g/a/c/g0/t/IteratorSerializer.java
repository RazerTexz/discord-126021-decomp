package b.g.a.c.g0.t;

import b.g.a.b.JsonGenerator;
import b.g.a.c.BeanProperty;
import b.g.a.c.JavaType;
import b.g.a.c.JsonSerializer;
import b.g.a.c.SerializerProvider;
import b.g.a.c.e0.TypeSerializer;
import b.g.a.c.g0.ContainerSerializer;
import b.g.a.c.g0.t.PropertySerializerMap;
import b.g.a.c.g0.u.AsArraySerializerBase;
import b.g.a.c.y.JacksonStdImpl;
import java.io.IOException;
import java.util.Iterator;

/* JADX INFO: renamed from: b.g.a.c.g0.t.h, reason: use source file name */
/* JADX INFO: compiled from: IteratorSerializer.java */
/* JADX INFO: loaded from: classes3.dex */
@JacksonStdImpl
public class IteratorSerializer extends AsArraySerializerBase<Iterator<?>> {
    public IteratorSerializer(JavaType javaType, boolean z2, TypeSerializer typeSerializer) {
        super((Class<?>) Iterator.class, javaType, z2, typeSerializer, (JsonSerializer<Object>) null);
    }

    @Override // b.g.a.c.JsonSerializer
    public boolean d(SerializerProvider serializerProvider, Object obj) {
        return !((Iterator) obj).hasNext();
    }

    @Override // b.g.a.c.g0.u.AsArraySerializerBase, b.g.a.c.JsonSerializer
    public void f(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        Iterator<?> it = (Iterator) obj;
        jsonGenerator.X(it);
        s(it, jsonGenerator, serializerProvider);
        jsonGenerator.t();
    }

    @Override // b.g.a.c.g0.ContainerSerializer
    public ContainerSerializer<?> p(TypeSerializer typeSerializer) {
        return new IteratorSerializer(this, this._property, typeSerializer, this._elementSerializer, this._unwrapSingle);
    }

    @Override // b.g.a.c.g0.ContainerSerializer
    public /* bridge */ /* synthetic */ boolean q(Object obj) {
        return false;
    }

    @Override // b.g.a.c.g0.u.AsArraySerializerBase
    public AsArraySerializerBase<Iterator<?>> t(BeanProperty beanProperty, TypeSerializer typeSerializer, JsonSerializer jsonSerializer, Boolean bool) {
        return new IteratorSerializer(this, beanProperty, typeSerializer, jsonSerializer, bool);
    }

    @Override // b.g.a.c.g0.u.AsArraySerializerBase
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public void s(Iterator<?> it, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        JsonSerializer<Object> jsonSerializerR;
        if (it.hasNext()) {
            JsonSerializer<Object> jsonSerializer = this._elementSerializer;
            if (jsonSerializer != null) {
                TypeSerializer typeSerializer = this._valueTypeSerializer;
                do {
                    Object next = it.next();
                    if (next == null) {
                        serializerProvider.l(jsonGenerator);
                    } else if (typeSerializer == null) {
                        jsonSerializer.f(next, jsonGenerator, serializerProvider);
                    } else {
                        jsonSerializer.g(next, jsonGenerator, serializerProvider, typeSerializer);
                    }
                } while (it.hasNext());
                return;
            }
            TypeSerializer typeSerializer2 = this._valueTypeSerializer;
            PropertySerializerMap propertySerializerMap = this._dynamicSerializers;
            do {
                Object next2 = it.next();
                if (next2 == null) {
                    serializerProvider.l(jsonGenerator);
                } else {
                    Class<?> cls = next2.getClass();
                    JsonSerializer<Object> jsonSerializerC = propertySerializerMap.c(cls);
                    if (jsonSerializerC == null) {
                        if (this._elementType.r()) {
                            PropertySerializerMap.d dVarA = propertySerializerMap.a(serializerProvider.k(this._elementType, cls), serializerProvider, this._property);
                            PropertySerializerMap propertySerializerMap2 = dVarA.f708b;
                            if (propertySerializerMap != propertySerializerMap2) {
                                this._dynamicSerializers = propertySerializerMap2;
                            }
                            jsonSerializerR = dVarA.a;
                        } else {
                            jsonSerializerR = r(propertySerializerMap, cls, serializerProvider);
                        }
                        jsonSerializerC = jsonSerializerR;
                        propertySerializerMap = this._dynamicSerializers;
                    }
                    if (typeSerializer2 == null) {
                        jsonSerializerC.f(next2, jsonGenerator, serializerProvider);
                    } else {
                        jsonSerializerC.g(next2, jsonGenerator, serializerProvider, typeSerializer2);
                    }
                }
            } while (it.hasNext());
        }
    }

    public IteratorSerializer(IteratorSerializer iteratorSerializer, BeanProperty beanProperty, TypeSerializer typeSerializer, JsonSerializer<?> jsonSerializer, Boolean bool) {
        super(iteratorSerializer, beanProperty, typeSerializer, jsonSerializer, bool);
    }
}
