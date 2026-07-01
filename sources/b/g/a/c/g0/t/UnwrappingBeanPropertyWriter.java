package b.g.a.c.g0.t;

import b.g.a.a.JsonInclude;
import b.g.a.b.JsonGenerator;
import b.g.a.b.p.SerializedString;
import b.g.a.c.JavaType;
import b.g.a.c.JsonSerializer;
import b.g.a.c.SerializerProvider;
import b.g.a.c.e0.TypeSerializer;
import b.g.a.c.g0.BeanPropertyWriter;
import b.g.a.c.i0.NameTransformer4;
import com.fasterxml.jackson.databind.JsonMappingException;
import java.io.Serializable;
import java.lang.reflect.Method;

/* JADX INFO: renamed from: b.g.a.c.g0.t.s, reason: use source file name */
/* JADX INFO: compiled from: UnwrappingBeanPropertyWriter.java */
/* JADX INFO: loaded from: classes3.dex */
public class UnwrappingBeanPropertyWriter extends BeanPropertyWriter implements Serializable {
    private static final long serialVersionUID = 1;
    public final NameTransformer4 _nameTransformer;

    public UnwrappingBeanPropertyWriter(UnwrappingBeanPropertyWriter unwrappingBeanPropertyWriter, NameTransformer4 nameTransformer4, SerializedString serializedString) {
        super(unwrappingBeanPropertyWriter, serializedString);
        this._nameTransformer = nameTransformer4;
    }

    @Override // b.g.a.c.g0.BeanPropertyWriter
    public JsonSerializer<Object> c(PropertySerializerMap propertySerializerMap, Class<?> cls, SerializerProvider serializerProvider) throws JsonMappingException {
        JavaType javaType = this._nonTrivialBaseType;
        JsonSerializer<Object> jsonSerializerT = javaType != null ? serializerProvider.t(serializerProvider.k(javaType, cls), this) : serializerProvider.u(cls, this);
        NameTransformer4 aVar = this._nameTransformer;
        if (jsonSerializerT.e() && (jsonSerializerT instanceof UnwrappingBeanSerializer)) {
            aVar = new NameTransformer4.a(aVar, ((UnwrappingBeanSerializer) jsonSerializerT)._nameTransformer);
        }
        JsonSerializer<Object> jsonSerializerH = jsonSerializerT.h(aVar);
        this.n = this.n.b(cls, jsonSerializerH);
        return jsonSerializerH;
    }

    @Override // b.g.a.c.g0.BeanPropertyWriter
    public void f(JsonSerializer<Object> jsonSerializer) {
        if (jsonSerializer != null) {
            NameTransformer4 aVar = this._nameTransformer;
            if (jsonSerializer.e() && (jsonSerializer instanceof UnwrappingBeanSerializer)) {
                aVar = new NameTransformer4.a(aVar, ((UnwrappingBeanSerializer) jsonSerializer)._nameTransformer);
            }
            jsonSerializer = jsonSerializer.h(aVar);
        }
        super.f(jsonSerializer);
    }

    @Override // b.g.a.c.g0.BeanPropertyWriter
    public BeanPropertyWriter g(NameTransformer4 nameTransformer4) {
        return new UnwrappingBeanPropertyWriter(this, new NameTransformer4.a(nameTransformer4, this._nameTransformer), new SerializedString(nameTransformer4.a(this._name._value)));
    }

    @Override // b.g.a.c.g0.BeanPropertyWriter
    public void i(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws Exception {
        Method method = this.l;
        Object objInvoke = method == null ? this.m.get(obj) : method.invoke(obj, null);
        if (objInvoke == null) {
            return;
        }
        JsonSerializer<Object> jsonSerializerC = this._serializer;
        if (jsonSerializerC == null) {
            Class<?> cls = objInvoke.getClass();
            PropertySerializerMap propertySerializerMap = this.n;
            JsonSerializer<Object> jsonSerializerC2 = propertySerializerMap.c(cls);
            jsonSerializerC = jsonSerializerC2 == null ? c(propertySerializerMap, cls, serializerProvider) : jsonSerializerC2;
        }
        Object obj2 = this._suppressableValue;
        if (obj2 != null) {
            if (JsonInclude.a.NON_EMPTY == obj2) {
                if (jsonSerializerC.d(serializerProvider, objInvoke)) {
                    return;
                }
            } else if (obj2.equals(objInvoke)) {
                return;
            }
        }
        if (objInvoke == obj && d(jsonGenerator, serializerProvider, jsonSerializerC)) {
            return;
        }
        if (!jsonSerializerC.e()) {
            jsonGenerator.x(this._name);
        }
        TypeSerializer typeSerializer = this._typeSerializer;
        if (typeSerializer == null) {
            jsonSerializerC.f(objInvoke, jsonGenerator, serializerProvider);
        } else {
            jsonSerializerC.g(objInvoke, jsonGenerator, serializerProvider, typeSerializer);
        }
    }

    public UnwrappingBeanPropertyWriter(BeanPropertyWriter beanPropertyWriter, NameTransformer4 nameTransformer4) {
        super(beanPropertyWriter, beanPropertyWriter._name);
        this._nameTransformer = nameTransformer4;
    }
}
