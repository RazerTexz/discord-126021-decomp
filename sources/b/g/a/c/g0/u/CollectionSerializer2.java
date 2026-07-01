package b.g.a.c.g0.u;

import b.g.a.b.JsonGenerator;
import b.g.a.c.BeanProperty;
import b.g.a.c.JavaType;
import b.g.a.c.JsonSerializer;
import b.g.a.c.SerializationFeature;
import b.g.a.c.SerializerProvider;
import b.g.a.c.e0.TypeSerializer;
import b.g.a.c.g0.ContainerSerializer;
import b.g.a.c.g0.t.PropertySerializerMap;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: renamed from: b.g.a.c.g0.u.j, reason: use source file name */
/* JADX INFO: compiled from: CollectionSerializer.java */
/* JADX INFO: loaded from: classes3.dex */
public class CollectionSerializer2 extends AsArraySerializerBase<Collection<?>> {
    private static final long serialVersionUID = 1;

    public CollectionSerializer2(JavaType javaType, boolean z2, TypeSerializer typeSerializer, JsonSerializer<Object> jsonSerializer) {
        super((Class<?>) Collection.class, javaType, z2, typeSerializer, jsonSerializer);
    }

    @Override // b.g.a.c.JsonSerializer
    public boolean d(SerializerProvider serializerProvider, Object obj) {
        return ((Collection) obj).isEmpty();
    }

    @Override // b.g.a.c.g0.u.AsArraySerializerBase, b.g.a.c.JsonSerializer
    public void f(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        Collection<?> collection = (Collection) obj;
        int size = collection.size();
        if (size == 1 && ((this._unwrapSingle == null && serializerProvider.D(SerializationFeature.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED)) || this._unwrapSingle == Boolean.TRUE)) {
            s(collection, jsonGenerator, serializerProvider);
            return;
        }
        jsonGenerator.b0(collection, size);
        s(collection, jsonGenerator, serializerProvider);
        jsonGenerator.t();
    }

    @Override // b.g.a.c.g0.ContainerSerializer
    public ContainerSerializer<?> p(TypeSerializer typeSerializer) {
        return new CollectionSerializer2(this, this._property, typeSerializer, this._elementSerializer, this._unwrapSingle);
    }

    @Override // b.g.a.c.g0.ContainerSerializer
    public boolean q(Object obj) {
        return ((Collection) obj).size() == 1;
    }

    @Override // b.g.a.c.g0.u.AsArraySerializerBase
    public AsArraySerializerBase<Collection<?>> t(BeanProperty beanProperty, TypeSerializer typeSerializer, JsonSerializer jsonSerializer, Boolean bool) {
        return new CollectionSerializer2(this, beanProperty, typeSerializer, jsonSerializer, bool);
    }

    @Override // b.g.a.c.g0.u.AsArraySerializerBase
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public void s(Collection<?> collection, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        JsonSerializer<Object> jsonSerializerR;
        jsonGenerator.e(collection);
        JsonSerializer<Object> jsonSerializer = this._elementSerializer;
        int i = 0;
        if (jsonSerializer != null) {
            Iterator<?> it = collection.iterator();
            if (it.hasNext()) {
                TypeSerializer typeSerializer = this._valueTypeSerializer;
                do {
                    Object next = it.next();
                    if (next == null) {
                        try {
                            serializerProvider.l(jsonGenerator);
                        } catch (Exception e) {
                            n(serializerProvider, e, collection, i);
                            throw null;
                        }
                    } else if (typeSerializer == null) {
                        jsonSerializer.f(next, jsonGenerator, serializerProvider);
                    } else {
                        jsonSerializer.g(next, jsonGenerator, serializerProvider, typeSerializer);
                    }
                    i++;
                } while (it.hasNext());
                return;
            }
            return;
        }
        Iterator<?> it2 = collection.iterator();
        if (it2.hasNext()) {
            PropertySerializerMap propertySerializerMap = this._dynamicSerializers;
            TypeSerializer typeSerializer2 = this._valueTypeSerializer;
            do {
                try {
                    Object next2 = it2.next();
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
                    i++;
                } catch (Exception e2) {
                    n(serializerProvider, e2, collection, i);
                    throw null;
                }
            } while (it2.hasNext());
        }
    }

    public CollectionSerializer2(CollectionSerializer2 collectionSerializer2, BeanProperty beanProperty, TypeSerializer typeSerializer, JsonSerializer<?> jsonSerializer, Boolean bool) {
        super(collectionSerializer2, beanProperty, typeSerializer, jsonSerializer, bool);
    }
}
