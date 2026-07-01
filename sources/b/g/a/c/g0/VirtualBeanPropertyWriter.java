package b.g.a.c.g0;

import b.g.a.a.JsonInclude;
import b.g.a.b.JsonGenerator;
import b.g.a.c.JavaType;
import b.g.a.c.JsonSerializer;
import b.g.a.c.SerializerProvider;
import b.g.a.c.c0.AnnotatedClass;
import b.g.a.c.c0.AnnotatedMember;
import b.g.a.c.c0.BeanPropertyDefinition;
import b.g.a.c.e0.TypeSerializer;
import b.g.a.c.g0.t.PropertySerializerMap;
import b.g.a.c.i0.Annotations;
import b.g.a.c.z.MapperConfig;
import java.io.Serializable;

/* JADX INFO: renamed from: b.g.a.c.g0.s, reason: use source file name */
/* JADX INFO: compiled from: VirtualBeanPropertyWriter.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class VirtualBeanPropertyWriter extends BeanPropertyWriter implements Serializable {
    private static final long serialVersionUID = 1;

    public VirtualBeanPropertyWriter() {
    }

    @Override // b.g.a.c.g0.BeanPropertyWriter
    public void h(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws Exception {
        Object objJ = j(obj, jsonGenerator, serializerProvider);
        if (objJ == null) {
            JsonSerializer<Object> jsonSerializer = this._nullSerializer;
            if (jsonSerializer != null) {
                jsonSerializer.f(null, jsonGenerator, serializerProvider);
                return;
            } else {
                jsonGenerator.A();
                return;
            }
        }
        JsonSerializer<Object> jsonSerializerC = this._serializer;
        if (jsonSerializerC == null) {
            Class<?> cls = objJ.getClass();
            PropertySerializerMap propertySerializerMap = this.n;
            JsonSerializer<Object> jsonSerializerC2 = propertySerializerMap.c(cls);
            jsonSerializerC = jsonSerializerC2 == null ? c(propertySerializerMap, cls, serializerProvider) : jsonSerializerC2;
        }
        Object obj2 = this._suppressableValue;
        if (obj2 != null) {
            if (JsonInclude.a.NON_EMPTY == obj2) {
                if (jsonSerializerC.d(serializerProvider, objJ)) {
                    JsonSerializer<Object> jsonSerializer2 = this._nullSerializer;
                    if (jsonSerializer2 != null) {
                        jsonSerializer2.f(null, jsonGenerator, serializerProvider);
                        return;
                    } else {
                        jsonGenerator.A();
                        return;
                    }
                }
            } else if (obj2.equals(objJ)) {
                JsonSerializer<Object> jsonSerializer3 = this._nullSerializer;
                if (jsonSerializer3 != null) {
                    jsonSerializer3.f(null, jsonGenerator, serializerProvider);
                    return;
                } else {
                    jsonGenerator.A();
                    return;
                }
            }
        }
        if (objJ == obj && d(jsonGenerator, serializerProvider, jsonSerializerC)) {
            return;
        }
        TypeSerializer typeSerializer = this._typeSerializer;
        if (typeSerializer == null) {
            jsonSerializerC.f(objJ, jsonGenerator, serializerProvider);
        } else {
            jsonSerializerC.g(objJ, jsonGenerator, serializerProvider, typeSerializer);
        }
    }

    @Override // b.g.a.c.g0.BeanPropertyWriter
    public void i(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws Exception {
        Object objJ = j(obj, jsonGenerator, serializerProvider);
        if (objJ == null) {
            if (this._nullSerializer != null) {
                jsonGenerator.x(this._name);
                this._nullSerializer.f(null, jsonGenerator, serializerProvider);
                return;
            }
            return;
        }
        JsonSerializer<Object> jsonSerializerC = this._serializer;
        if (jsonSerializerC == null) {
            Class<?> cls = objJ.getClass();
            PropertySerializerMap propertySerializerMap = this.n;
            JsonSerializer<Object> jsonSerializerC2 = propertySerializerMap.c(cls);
            jsonSerializerC = jsonSerializerC2 == null ? c(propertySerializerMap, cls, serializerProvider) : jsonSerializerC2;
        }
        Object obj2 = this._suppressableValue;
        if (obj2 != null) {
            if (JsonInclude.a.NON_EMPTY == obj2) {
                if (jsonSerializerC.d(serializerProvider, objJ)) {
                    return;
                }
            } else if (obj2.equals(objJ)) {
                return;
            }
        }
        if (objJ == obj && d(jsonGenerator, serializerProvider, jsonSerializerC)) {
            return;
        }
        jsonGenerator.x(this._name);
        TypeSerializer typeSerializer = this._typeSerializer;
        if (typeSerializer == null) {
            jsonSerializerC.f(objJ, jsonGenerator, serializerProvider);
        } else {
            jsonSerializerC.g(objJ, jsonGenerator, serializerProvider, typeSerializer);
        }
    }

    public abstract Object j(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws Exception;

    public abstract VirtualBeanPropertyWriter k(MapperConfig<?> mapperConfig, AnnotatedClass annotatedClass, BeanPropertyDefinition beanPropertyDefinition, JavaType javaType);

    /* JADX WARN: Illegal instructions before constructor call */
    public VirtualBeanPropertyWriter(BeanPropertyDefinition beanPropertyDefinition, Annotations annotations, JavaType javaType, JsonSerializer<?> jsonSerializer, TypeSerializer typeSerializer, JavaType javaType2, JsonInclude.b bVar, Class<?>[] clsArr) {
        boolean z2;
        Object obj;
        JsonInclude.a aVar = JsonInclude.a.USE_DEFAULTS;
        JsonInclude.a aVar2 = JsonInclude.a.ALWAYS;
        AnnotatedMember annotatedMemberQ = beanPropertyDefinition.q();
        boolean z3 = false;
        if (bVar == null) {
            z2 = false;
        } else {
            JsonInclude.a aVar3 = bVar._valueInclusion;
            if (aVar3 != aVar2 && aVar3 != aVar) {
                z3 = true;
            }
            z2 = z3;
        }
        if (bVar == null) {
            obj = Boolean.FALSE;
        } else {
            JsonInclude.a aVar4 = bVar._valueInclusion;
            obj = (aVar4 == aVar2 || aVar4 == JsonInclude.a.NON_NULL || aVar4 == aVar) ? null : JsonInclude.a.NON_EMPTY;
        }
        super(beanPropertyDefinition, annotatedMemberQ, annotations, javaType, null, null, null, z2, obj, null);
    }
}
