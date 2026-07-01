package b.g.a.c;

import b.d.b.a.outline;
import b.g.a.a.ObjectIdGenerator;
import b.g.a.c.c0.Annotated;
import b.g.a.c.c0.ObjectIdInfo;
import b.g.a.c.h0.TypeFactory;
import b.g.a.c.i0.ClassUtil;
import b.g.a.c.i0.Converter;
import com.fasterxml.jackson.databind.JsonMappingException;
import java.lang.reflect.Type;
import java.util.Objects;

/* JADX INFO: renamed from: b.g.a.c.e, reason: use source file name */
/* JADX INFO: compiled from: DatabindContext.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class DatabindContext {
    public final String a(String str, Object... objArr) {
        return objArr.length > 0 ? String.format(str, objArr) : str;
    }

    public JavaType b(Type type) {
        if (type == null) {
            return null;
        }
        return d().b(null, type, TypeFactory.l);
    }

    public Converter<Object, Object> c(Annotated annotated, Object obj) throws JsonMappingException {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Converter) {
            return (Converter) obj;
        }
        if (!(obj instanceof Class)) {
            StringBuilder sbU = outline.U("AnnotationIntrospector returned Converter definition of type ");
            sbU.append(obj.getClass().getName());
            sbU.append("; expected type Converter or Class<Converter> instead");
            throw new IllegalStateException(sbU.toString());
        }
        Class cls = (Class) obj;
        if (cls == Converter.a.class || ClassUtil.p(cls)) {
            return null;
        }
        if (!Converter.class.isAssignableFrom(cls)) {
            throw new IllegalStateException(outline.o(cls, outline.U("AnnotationIntrospector returned Class "), "; expected Class<Converter>"));
        }
        SerializationConfig serializationConfig = ((SerializerProvider) this)._config;
        Objects.requireNonNull(serializationConfig._base);
        return (Converter) ClassUtil.g(cls, serializationConfig.b());
    }

    public abstract TypeFactory d();

    public ObjectIdGenerator<?> e(Annotated annotated, ObjectIdInfo objectIdInfo) throws JsonMappingException {
        Class<? extends ObjectIdGenerator<?>> cls = objectIdInfo.c;
        SerializationConfig serializationConfig = ((SerializerProvider) this)._config;
        Objects.requireNonNull(serializationConfig._base);
        return ((ObjectIdGenerator) ClassUtil.g(cls, serializationConfig.b())).b(objectIdInfo.e);
    }

    public abstract <T> T f(JavaType javaType, String str) throws JsonMappingException;

    public <T> T g(Class<?> cls, String str) throws JsonMappingException {
        return (T) f(b(cls), str);
    }
}
