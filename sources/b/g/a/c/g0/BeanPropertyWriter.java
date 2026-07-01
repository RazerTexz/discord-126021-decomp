package b.g.a.c.g0;

import b.d.b.a.outline;
import b.g.a.a.JsonInclude;
import b.g.a.b.JsonGenerator;
import b.g.a.b.p.SerializedString;
import b.g.a.c.JavaType;
import b.g.a.c.JsonSerializer;
import b.g.a.c.PropertyMetadata;
import b.g.a.c.PropertyName;
import b.g.a.c.SerializationFeature;
import b.g.a.c.SerializerProvider;
import b.g.a.c.c0.AnnotatedField;
import b.g.a.c.c0.AnnotatedMember;
import b.g.a.c.c0.AnnotatedMethod;
import b.g.a.c.c0.BeanPropertyDefinition;
import b.g.a.c.e0.TypeSerializer;
import b.g.a.c.g0.t.PropertySerializerMap;
import b.g.a.c.g0.u.BeanSerializerBase;
import b.g.a.c.i0.Annotations;
import b.g.a.c.i0.ClassUtil;
import b.g.a.c.i0.NameTransformer4;
import b.g.a.c.y.JacksonStdImpl;
import com.fasterxml.jackson.databind.JsonMappingException;
import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;

/* JADX INFO: renamed from: b.g.a.c.g0.c, reason: use source file name */
/* JADX INFO: compiled from: BeanPropertyWriter.java */
/* JADX INFO: loaded from: classes3.dex */
@JacksonStdImpl
public class BeanPropertyWriter extends PropertyWriter implements Serializable {
    public static final /* synthetic */ int j = 0;
    private static final long serialVersionUID = 1;
    public final JavaType _cfgSerializationType;
    public final JavaType _declaredType;
    public final Class<?>[] _includeInViews;
    public final AnnotatedMember _member;
    public final SerializedString _name;
    public JavaType _nonTrivialBaseType;
    public JsonSerializer<Object> _nullSerializer;
    public JsonSerializer<Object> _serializer;
    public final boolean _suppressNulls;
    public final Object _suppressableValue;
    public TypeSerializer _typeSerializer;
    public final PropertyName _wrapperName;
    public final transient Annotations k;
    public transient Method l;
    public transient Field m;
    public transient PropertySerializerMap n;
    public transient HashMap<Object, Object> o;

    public BeanPropertyWriter(BeanPropertyDefinition beanPropertyDefinition, AnnotatedMember annotatedMember, Annotations annotations, JavaType javaType, JsonSerializer<?> jsonSerializer, TypeSerializer typeSerializer, JavaType javaType2, boolean z2, Object obj, Class<?>[] clsArr) {
        super(beanPropertyDefinition);
        this._member = annotatedMember;
        this.k = annotations;
        this._name = new SerializedString(beanPropertyDefinition.p());
        this._wrapperName = beanPropertyDefinition.t();
        this._declaredType = javaType;
        this._serializer = jsonSerializer;
        this.n = jsonSerializer == null ? PropertySerializerMap.b.f706b : null;
        this._typeSerializer = typeSerializer;
        this._cfgSerializationType = javaType2;
        if (annotatedMember instanceof AnnotatedField) {
            this.l = null;
            this.m = (Field) annotatedMember.i();
        } else if (annotatedMember instanceof AnnotatedMethod) {
            this.l = (Method) annotatedMember.i();
            this.m = null;
        } else {
            this.l = null;
            this.m = null;
        }
        this._suppressNulls = z2;
        this._suppressableValue = obj;
        this._nullSerializer = null;
        this._includeInViews = clsArr;
    }

    public JsonSerializer<Object> c(PropertySerializerMap propertySerializerMap, Class<?> cls, SerializerProvider serializerProvider) throws JsonMappingException {
        PropertySerializerMap.d dVar;
        JavaType javaType = this._nonTrivialBaseType;
        if (javaType != null) {
            JavaType javaTypeK = serializerProvider.k(javaType, cls);
            JsonSerializer<Object> jsonSerializerQ = serializerProvider.q(javaTypeK, this);
            dVar = new PropertySerializerMap.d(jsonSerializerQ, propertySerializerMap.b(javaTypeK._class, jsonSerializerQ));
        } else {
            JsonSerializer<Object> jsonSerializerR = serializerProvider.r(cls, this);
            dVar = new PropertySerializerMap.d(jsonSerializerR, propertySerializerMap.b(cls, jsonSerializerR));
        }
        PropertySerializerMap propertySerializerMap2 = dVar.f708b;
        if (propertySerializerMap != propertySerializerMap2) {
            this.n = propertySerializerMap2;
        }
        return dVar.a;
    }

    public boolean d(JsonGenerator jsonGenerator, SerializerProvider serializerProvider, JsonSerializer jsonSerializer) throws IOException {
        if (jsonSerializer.i()) {
            return false;
        }
        if (serializerProvider.D(SerializationFeature.FAIL_ON_SELF_REFERENCES)) {
            if (!(jsonSerializer instanceof BeanSerializerBase)) {
                return false;
            }
            serializerProvider.f(this._declaredType, "Direct self-reference leading to cycle");
            throw null;
        }
        if (!serializerProvider.D(SerializationFeature.WRITE_SELF_REFERENCES_AS_NULL)) {
            return false;
        }
        if (this._nullSerializer == null) {
            return true;
        }
        if (!jsonGenerator.c().b()) {
            jsonGenerator.x(this._name);
        }
        this._nullSerializer.f(null, jsonGenerator, serializerProvider);
        return true;
    }

    public void e(JsonSerializer<Object> jsonSerializer) {
        JsonSerializer<Object> jsonSerializer2 = this._nullSerializer;
        if (jsonSerializer2 != null && jsonSerializer2 != jsonSerializer) {
            throw new IllegalStateException(String.format("Cannot override _nullSerializer: had a %s, trying to set to %s", ClassUtil.e(this._nullSerializer), ClassUtil.e(jsonSerializer)));
        }
        this._nullSerializer = jsonSerializer;
    }

    public void f(JsonSerializer<Object> jsonSerializer) {
        JsonSerializer<Object> jsonSerializer2 = this._serializer;
        if (jsonSerializer2 != null && jsonSerializer2 != jsonSerializer) {
            throw new IllegalStateException(String.format("Cannot override _serializer: had a %s, trying to set to %s", ClassUtil.e(this._serializer), ClassUtil.e(jsonSerializer)));
        }
        this._serializer = jsonSerializer;
    }

    public BeanPropertyWriter g(NameTransformer4 nameTransformer4) {
        String strA = nameTransformer4.a(this._name._value);
        return strA.equals(this._name._value) ? this : new BeanPropertyWriter(this, PropertyName.a(strA));
    }

    @Override // b.g.a.c.BeanProperty
    public AnnotatedMember getMember() {
        return this._member;
    }

    @Override // b.g.a.c.BeanProperty
    public JavaType getType() {
        return this._declaredType;
    }

    public void h(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws Exception {
        Method method = this.l;
        Object objInvoke = method == null ? this.m.get(obj) : method.invoke(obj, null);
        if (objInvoke == null) {
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
            Class<?> cls = objInvoke.getClass();
            PropertySerializerMap propertySerializerMap = this.n;
            JsonSerializer<Object> jsonSerializerC2 = propertySerializerMap.c(cls);
            jsonSerializerC = jsonSerializerC2 == null ? c(propertySerializerMap, cls, serializerProvider) : jsonSerializerC2;
        }
        Object obj2 = this._suppressableValue;
        if (obj2 != null) {
            if (JsonInclude.a.NON_EMPTY == obj2) {
                if (jsonSerializerC.d(serializerProvider, objInvoke)) {
                    JsonSerializer<Object> jsonSerializer2 = this._nullSerializer;
                    if (jsonSerializer2 != null) {
                        jsonSerializer2.f(null, jsonGenerator, serializerProvider);
                        return;
                    } else {
                        jsonGenerator.A();
                        return;
                    }
                }
            } else if (obj2.equals(objInvoke)) {
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
        if (objInvoke == obj && d(jsonGenerator, serializerProvider, jsonSerializerC)) {
            return;
        }
        TypeSerializer typeSerializer = this._typeSerializer;
        if (typeSerializer == null) {
            jsonSerializerC.f(objInvoke, jsonGenerator, serializerProvider);
        } else {
            jsonSerializerC.g(objInvoke, jsonGenerator, serializerProvider, typeSerializer);
        }
    }

    public void i(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws Exception {
        Method method = this.l;
        Object objInvoke = method == null ? this.m.get(obj) : method.invoke(obj, null);
        if (objInvoke == null) {
            if (this._nullSerializer != null) {
                jsonGenerator.x(this._name);
                this._nullSerializer.f(null, jsonGenerator, serializerProvider);
                return;
            }
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
        jsonGenerator.x(this._name);
        TypeSerializer typeSerializer = this._typeSerializer;
        if (typeSerializer == null) {
            jsonSerializerC.f(objInvoke, jsonGenerator, serializerProvider);
        } else {
            jsonSerializerC.g(objInvoke, jsonGenerator, serializerProvider, typeSerializer);
        }
    }

    public Object readResolve() {
        AnnotatedMember annotatedMember = this._member;
        if (annotatedMember instanceof AnnotatedField) {
            this.l = null;
            this.m = (Field) annotatedMember.i();
        } else if (annotatedMember instanceof AnnotatedMethod) {
            this.l = (Method) annotatedMember.i();
            this.m = null;
        }
        if (this._serializer == null) {
            this.n = PropertySerializerMap.b.f706b;
        }
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(40);
        sb.append("property '");
        sb.append(this._name._value);
        sb.append("' (");
        if (this.l != null) {
            sb.append("via method ");
            sb.append(this.l.getDeclaringClass().getName());
            sb.append("#");
            sb.append(this.l.getName());
        } else if (this.m != null) {
            sb.append("field \"");
            sb.append(this.m.getDeclaringClass().getName());
            sb.append("#");
            sb.append(this.m.getName());
        } else {
            sb.append("virtual");
        }
        if (this._serializer == null) {
            sb.append(", no static serializer");
        } else {
            StringBuilder sbU = outline.U(", static serializer of type ");
            sbU.append(this._serializer.getClass().getName());
            sb.append(sbU.toString());
        }
        sb.append(')');
        return sb.toString();
    }

    public BeanPropertyWriter() {
        super(PropertyMetadata.l);
        this._member = null;
        this.k = null;
        this._name = null;
        this._wrapperName = null;
        this._includeInViews = null;
        this._declaredType = null;
        this._serializer = null;
        this.n = null;
        this._typeSerializer = null;
        this._cfgSerializationType = null;
        this.l = null;
        this.m = null;
        this._suppressNulls = false;
        this._suppressableValue = null;
        this._nullSerializer = null;
    }

    public BeanPropertyWriter(BeanPropertyWriter beanPropertyWriter, PropertyName propertyName) {
        super(beanPropertyWriter);
        this._name = new SerializedString(propertyName._simpleName);
        this._wrapperName = beanPropertyWriter._wrapperName;
        this.k = beanPropertyWriter.k;
        this._declaredType = beanPropertyWriter._declaredType;
        this._member = beanPropertyWriter._member;
        this.l = beanPropertyWriter.l;
        this.m = beanPropertyWriter.m;
        this._serializer = beanPropertyWriter._serializer;
        this._nullSerializer = beanPropertyWriter._nullSerializer;
        if (beanPropertyWriter.o != null) {
            this.o = new HashMap<>(beanPropertyWriter.o);
        }
        this._cfgSerializationType = beanPropertyWriter._cfgSerializationType;
        this.n = beanPropertyWriter.n;
        this._suppressNulls = beanPropertyWriter._suppressNulls;
        this._suppressableValue = beanPropertyWriter._suppressableValue;
        this._includeInViews = beanPropertyWriter._includeInViews;
        this._typeSerializer = beanPropertyWriter._typeSerializer;
        this._nonTrivialBaseType = beanPropertyWriter._nonTrivialBaseType;
    }

    public BeanPropertyWriter(BeanPropertyWriter beanPropertyWriter, SerializedString serializedString) {
        super(beanPropertyWriter);
        this._name = serializedString;
        this._wrapperName = beanPropertyWriter._wrapperName;
        this._member = beanPropertyWriter._member;
        this.k = beanPropertyWriter.k;
        this._declaredType = beanPropertyWriter._declaredType;
        this.l = beanPropertyWriter.l;
        this.m = beanPropertyWriter.m;
        this._serializer = beanPropertyWriter._serializer;
        this._nullSerializer = beanPropertyWriter._nullSerializer;
        if (beanPropertyWriter.o != null) {
            this.o = new HashMap<>(beanPropertyWriter.o);
        }
        this._cfgSerializationType = beanPropertyWriter._cfgSerializationType;
        this.n = beanPropertyWriter.n;
        this._suppressNulls = beanPropertyWriter._suppressNulls;
        this._suppressableValue = beanPropertyWriter._suppressableValue;
        this._includeInViews = beanPropertyWriter._includeInViews;
        this._typeSerializer = beanPropertyWriter._typeSerializer;
        this._nonTrivialBaseType = beanPropertyWriter._nonTrivialBaseType;
    }
}
