package b.g.a.c.g0;

import b.g.a.c.JavaType;
import b.g.a.c.JsonSerializer;
import b.g.a.c.SerializationConfig;
import b.g.a.c.SerializerProvider;
import b.g.a.c.e0.TypeSerializer;
import com.fasterxml.jackson.databind.JsonMappingException;

/* JADX INFO: renamed from: b.g.a.c.g0.q, reason: use source file name */
/* JADX INFO: compiled from: SerializerFactory.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class SerializerFactory2 {
    public abstract JsonSerializer<Object> a(SerializerProvider serializerProvider, JavaType javaType, JsonSerializer<Object> jsonSerializer) throws JsonMappingException;

    public abstract JsonSerializer<Object> b(SerializerProvider serializerProvider, JavaType javaType) throws JsonMappingException;

    public abstract TypeSerializer c(SerializationConfig serializationConfig, JavaType javaType) throws JsonMappingException;
}
