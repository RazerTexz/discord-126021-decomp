package b.g.a.c.g0.u;

import b.g.a.a.JsonFormat;
import b.g.a.c.AnnotationIntrospector;
import b.g.a.c.BeanProperty;
import b.g.a.c.JavaType;
import b.g.a.c.JsonSerializer;
import b.g.a.c.SerializationFeature;
import b.g.a.c.SerializerProvider;
import b.g.a.c.c0.AnnotatedMember;
import b.g.a.c.g0.PropertyFilter;
import b.g.a.c.i0.ClassUtil;
import b.g.a.c.i0.Converter;
import b.g.a.c.z.ContextAttributes;
import com.fasterxml.jackson.databind.JsonMappingException;
import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: renamed from: b.g.a.c.g0.u.q0, reason: use source file name */
/* JADX INFO: compiled from: StdSerializer.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class StdSerializer<T> extends JsonSerializer<T> implements Serializable {
    public static final Object j = new Object();
    private static final long serialVersionUID = 1;
    public final Class<T> _handledType;

    public StdSerializer(Class<T> cls) {
        this._handledType = cls;
    }

    public static final boolean j(Object obj, Object obj2) {
        return (obj == null || obj2 == null) ? false : true;
    }

    @Override // b.g.a.c.JsonSerializer
    public Class<T> c() {
        return this._handledType;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public JsonSerializer<?> k(SerializerProvider serializerProvider, BeanProperty beanProperty, JsonSerializer<?> jsonSerializer) throws JsonMappingException {
        JsonSerializer<?> stdDelegatingSerializer;
        AnnotatedMember member;
        Object objG;
        Object obj = j;
        Map identityHashMap = (Map) serializerProvider.w(obj);
        if (identityHashMap == null) {
            identityHashMap = new IdentityHashMap();
            ContextAttributes.a aVar = (ContextAttributes.a) serializerProvider.l;
            Map<Object, Object> map = aVar.l;
            if (map == null) {
                HashMap map2 = new HashMap();
                map2.put(obj, identityHashMap == null ? ContextAttributes.a.k : identityHashMap);
                aVar = new ContextAttributes.a(aVar._shared, map2);
            } else {
                map.put(obj, identityHashMap);
            }
            serializerProvider.l = aVar;
        } else if (identityHashMap.get(beanProperty) != null) {
            return jsonSerializer;
        }
        identityHashMap.put(beanProperty, Boolean.TRUE);
        try {
            AnnotationIntrospector annotationIntrospectorV = serializerProvider.v();
            if (!j(annotationIntrospectorV, beanProperty) || (member = beanProperty.getMember()) == null || (objG = annotationIntrospectorV.G(member)) == null) {
                stdDelegatingSerializer = jsonSerializer;
            } else {
                Converter<Object, Object> converterC = serializerProvider.c(beanProperty.getMember(), objG);
                JavaType javaTypeA = converterC.a(serializerProvider.d());
                stdDelegatingSerializer = new StdDelegatingSerializer(converterC, javaTypeA, (jsonSerializer != null || javaTypeA.y()) ? jsonSerializer : serializerProvider.s(javaTypeA));
            }
            return stdDelegatingSerializer != null ? serializerProvider.z(stdDelegatingSerializer, beanProperty) : jsonSerializer;
        } finally {
            identityHashMap.remove(beanProperty);
        }
    }

    public JsonFormat.d l(SerializerProvider serializerProvider, BeanProperty beanProperty, Class<?> cls) {
        return beanProperty != null ? beanProperty.a(serializerProvider._config, cls) : serializerProvider._config.i(cls);
    }

    public PropertyFilter m(SerializerProvider serializerProvider, Object obj, Object obj2) throws JsonMappingException {
        Objects.requireNonNull(serializerProvider._config);
        serializerProvider.g(this._handledType, "Cannot resolve PropertyFilter with id '" + obj + "'; no FilterProvider configured");
        throw null;
    }

    public void n(SerializerProvider serializerProvider, Throwable th, Object obj, int i) throws IOException {
        while ((th instanceof InvocationTargetException) && th.getCause() != null) {
            th = th.getCause();
        }
        ClassUtil.w(th);
        boolean z2 = serializerProvider == null || serializerProvider.D(SerializationFeature.WRAP_EXCEPTIONS);
        if (th instanceof IOException) {
            if (!z2 || !(th instanceof JsonMappingException)) {
                throw ((IOException) th);
            }
        } else if (!z2) {
            ClassUtil.x(th);
        }
        throw JsonMappingException.f(th, new JsonMappingException.a(obj, i));
    }

    public void o(SerializerProvider serializerProvider, Throwable th, Object obj, String str) throws IOException {
        while ((th instanceof InvocationTargetException) && th.getCause() != null) {
            th = th.getCause();
        }
        ClassUtil.w(th);
        boolean z2 = serializerProvider == null || serializerProvider.D(SerializationFeature.WRAP_EXCEPTIONS);
        if (th instanceof IOException) {
            if (!z2 || !(th instanceof JsonMappingException)) {
                throw ((IOException) th);
            }
        } else if (!z2) {
            ClassUtil.x(th);
        }
        int i = JsonMappingException.j;
        throw JsonMappingException.f(th, new JsonMappingException.a(obj, str));
    }

    public StdSerializer(JavaType javaType) {
        this._handledType = (Class<T>) javaType._class;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public StdSerializer(Class<?> cls, boolean z2) {
        this._handledType = cls;
    }

    public StdSerializer(StdSerializer<?> stdSerializer) {
        this._handledType = (Class<T>) stdSerializer._handledType;
    }
}
