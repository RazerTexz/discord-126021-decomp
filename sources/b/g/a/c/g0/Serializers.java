package b.g.a.c.g0;

import b.g.a.c.BeanDescription;
import b.g.a.c.JavaType;
import b.g.a.c.JsonSerializer;
import b.g.a.c.SerializationConfig;
import b.g.a.c.e0.TypeSerializer;
import b.g.a.c.h0.ArrayType;
import b.g.a.c.h0.CollectionLikeType;
import b.g.a.c.h0.CollectionType;
import b.g.a.c.h0.MapLikeType;
import b.g.a.c.h0.MapType;
import b.g.a.c.h0.ReferenceType;

/* JADX INFO: renamed from: b.g.a.c.g0.r, reason: use source file name */
/* JADX INFO: compiled from: Serializers.java */
/* JADX INFO: loaded from: classes3.dex */
public interface Serializers {
    JsonSerializer<?> a(SerializationConfig serializationConfig, ReferenceType referenceType, BeanDescription beanDescription, TypeSerializer typeSerializer, JsonSerializer<Object> jsonSerializer);

    JsonSerializer<?> b(SerializationConfig serializationConfig, JavaType javaType, BeanDescription beanDescription);

    JsonSerializer<?> c(SerializationConfig serializationConfig, MapType mapType, BeanDescription beanDescription, JsonSerializer<Object> jsonSerializer, TypeSerializer typeSerializer, JsonSerializer<Object> jsonSerializer2);

    JsonSerializer<?> d(SerializationConfig serializationConfig, CollectionLikeType collectionLikeType, BeanDescription beanDescription, TypeSerializer typeSerializer, JsonSerializer<Object> jsonSerializer);

    JsonSerializer<?> e(SerializationConfig serializationConfig, ArrayType arrayType, BeanDescription beanDescription, TypeSerializer typeSerializer, JsonSerializer<Object> jsonSerializer);

    JsonSerializer<?> f(SerializationConfig serializationConfig, MapLikeType mapLikeType, BeanDescription beanDescription, JsonSerializer<Object> jsonSerializer, TypeSerializer typeSerializer, JsonSerializer<Object> jsonSerializer2);

    JsonSerializer<?> g(SerializationConfig serializationConfig, CollectionType collectionType, BeanDescription beanDescription, TypeSerializer typeSerializer, JsonSerializer<Object> jsonSerializer);
}
