package b.g.a.c.g0.t;

import b.g.a.b.JsonGenerator;
import b.g.a.c.BeanProperty;
import b.g.a.c.JavaType;
import b.g.a.c.JsonSerializer;
import b.g.a.c.SerializationFeature;
import b.g.a.c.SerializerProvider;
import b.g.a.c.e0.TypeSerializer;
import b.g.a.c.g0.ContainerSerializer;
import b.g.a.c.g0.t.PropertySerializerMap;
import b.g.a.c.g0.u.AsArraySerializerBase;
import b.g.a.c.y.JacksonStdImpl;
import java.io.IOException;
import java.util.List;

/* JADX INFO: renamed from: b.g.a.c.g0.t.f, reason: use source file name */
/* JADX INFO: compiled from: IndexedListSerializer.java */
/* JADX INFO: loaded from: classes3.dex */
@JacksonStdImpl
public final class IndexedListSerializer extends AsArraySerializerBase<List<?>> {
    private static final long serialVersionUID = 1;

    public IndexedListSerializer(JavaType javaType, boolean z2, TypeSerializer typeSerializer, JsonSerializer<Object> jsonSerializer) {
        super((Class<?>) List.class, javaType, z2, typeSerializer, jsonSerializer);
    }

    @Override // b.g.a.c.JsonSerializer
    public boolean d(SerializerProvider serializerProvider, Object obj) {
        return ((List) obj).isEmpty();
    }

    @Override // b.g.a.c.g0.u.AsArraySerializerBase, b.g.a.c.JsonSerializer
    public void f(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        List<?> list = (List) obj;
        int size = list.size();
        if (size == 1 && ((this._unwrapSingle == null && serializerProvider.D(SerializationFeature.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED)) || this._unwrapSingle == Boolean.TRUE)) {
            s(list, jsonGenerator, serializerProvider);
            return;
        }
        jsonGenerator.b0(list, size);
        s(list, jsonGenerator, serializerProvider);
        jsonGenerator.t();
    }

    @Override // b.g.a.c.g0.ContainerSerializer
    public ContainerSerializer<?> p(TypeSerializer typeSerializer) {
        return new IndexedListSerializer(this, this._property, typeSerializer, this._elementSerializer, this._unwrapSingle);
    }

    @Override // b.g.a.c.g0.ContainerSerializer
    public boolean q(Object obj) {
        return ((List) obj).size() == 1;
    }

    @Override // b.g.a.c.g0.u.AsArraySerializerBase
    public AsArraySerializerBase<List<?>> t(BeanProperty beanProperty, TypeSerializer typeSerializer, JsonSerializer jsonSerializer, Boolean bool) {
        return new IndexedListSerializer(this, beanProperty, typeSerializer, jsonSerializer, bool);
    }

    @Override // b.g.a.c.g0.u.AsArraySerializerBase
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public void s(List<?> list, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        JsonSerializer<Object> jsonSerializerR;
        JsonSerializer<Object> jsonSerializerR2;
        JsonSerializer<Object> jsonSerializer = this._elementSerializer;
        int i = 0;
        if (jsonSerializer != null) {
            int size = list.size();
            if (size == 0) {
                return;
            }
            TypeSerializer typeSerializer = this._valueTypeSerializer;
            while (i < size) {
                Object obj = list.get(i);
                if (obj == null) {
                    try {
                        serializerProvider.l(jsonGenerator);
                    } catch (Exception e) {
                        n(serializerProvider, e, list, i);
                        throw null;
                    }
                } else if (typeSerializer == null) {
                    jsonSerializer.f(obj, jsonGenerator, serializerProvider);
                } else {
                    jsonSerializer.g(obj, jsonGenerator, serializerProvider, typeSerializer);
                }
                i++;
            }
            return;
        }
        if (this._valueTypeSerializer == null) {
            int size2 = list.size();
            if (size2 == 0) {
                return;
            }
            try {
                PropertySerializerMap propertySerializerMap = this._dynamicSerializers;
                while (i < size2) {
                    Object obj2 = list.get(i);
                    if (obj2 == null) {
                        serializerProvider.l(jsonGenerator);
                    } else {
                        Class<?> cls = obj2.getClass();
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
                        jsonSerializerC.f(obj2, jsonGenerator, serializerProvider);
                    }
                    i++;
                }
                return;
            } catch (Exception e2) {
                n(serializerProvider, e2, list, i);
                throw null;
            }
        }
        int size3 = list.size();
        if (size3 == 0) {
            return;
        }
        try {
            TypeSerializer typeSerializer2 = this._valueTypeSerializer;
            PropertySerializerMap propertySerializerMap3 = this._dynamicSerializers;
            while (i < size3) {
                Object obj3 = list.get(i);
                if (obj3 == null) {
                    serializerProvider.l(jsonGenerator);
                } else {
                    Class<?> cls2 = obj3.getClass();
                    JsonSerializer<Object> jsonSerializerC2 = propertySerializerMap3.c(cls2);
                    if (jsonSerializerC2 == null) {
                        if (this._elementType.r()) {
                            PropertySerializerMap.d dVarA2 = propertySerializerMap3.a(serializerProvider.k(this._elementType, cls2), serializerProvider, this._property);
                            PropertySerializerMap propertySerializerMap4 = dVarA2.f708b;
                            if (propertySerializerMap3 != propertySerializerMap4) {
                                this._dynamicSerializers = propertySerializerMap4;
                            }
                            jsonSerializerR2 = dVarA2.a;
                        } else {
                            jsonSerializerR2 = r(propertySerializerMap3, cls2, serializerProvider);
                        }
                        jsonSerializerC2 = jsonSerializerR2;
                        propertySerializerMap3 = this._dynamicSerializers;
                    }
                    jsonSerializerC2.g(obj3, jsonGenerator, serializerProvider, typeSerializer2);
                }
                i++;
            }
        } catch (Exception e3) {
            n(serializerProvider, e3, list, i);
            throw null;
        }
    }

    public IndexedListSerializer(IndexedListSerializer indexedListSerializer, BeanProperty beanProperty, TypeSerializer typeSerializer, JsonSerializer<?> jsonSerializer, Boolean bool) {
        super(indexedListSerializer, beanProperty, typeSerializer, jsonSerializer, bool);
    }
}
