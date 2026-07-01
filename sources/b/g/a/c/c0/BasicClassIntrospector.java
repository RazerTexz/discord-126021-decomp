package b.g.a.c.c0;

import b.g.a.c.JavaType;
import b.g.a.c.JsonNode;
import b.g.a.c.c0.ClassIntrospector;
import b.g.a.c.h0.ArrayType;
import b.g.a.c.h0.SimpleType;
import b.g.a.c.i0.ClassUtil;
import b.g.a.c.z.MapperConfig;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

/* JADX INFO: renamed from: b.g.a.c.c0.r, reason: use source file name */
/* JADX INFO: compiled from: BasicClassIntrospector.java */
/* JADX INFO: loaded from: classes3.dex */
public class BasicClassIntrospector extends ClassIntrospector implements Serializable {
    public static final Class<?> j = JsonNode.class;
    public static final BasicBeanDescription k;
    public static final BasicBeanDescription l;
    public static final BasicBeanDescription m;
    public static final BasicBeanDescription n;
    public static final BasicBeanDescription o;
    private static final long serialVersionUID = 2;

    static {
        SimpleType simpleTypeL = SimpleType.L(String.class);
        Class<?> cls = AnnotatedClassResolver.a;
        k = BasicBeanDescription.e(null, simpleTypeL, new AnnotatedClass(String.class));
        Class cls2 = Boolean.TYPE;
        l = BasicBeanDescription.e(null, SimpleType.L(cls2), new AnnotatedClass(cls2));
        Class cls3 = Integer.TYPE;
        m = BasicBeanDescription.e(null, SimpleType.L(cls3), new AnnotatedClass(cls3));
        Class cls4 = Long.TYPE;
        n = BasicBeanDescription.e(null, SimpleType.L(cls4), new AnnotatedClass(cls4));
        o = BasicBeanDescription.e(null, SimpleType.L(Object.class), new AnnotatedClass(Object.class));
    }

    public BasicBeanDescription a(MapperConfig<?> mapperConfig, JavaType javaType) {
        Class<?> cls = javaType._class;
        if (cls.isPrimitive()) {
            if (cls == Integer.TYPE) {
                return m;
            }
            if (cls == Long.TYPE) {
                return n;
            }
            if (cls == Boolean.TYPE) {
                return l;
            }
            return null;
        }
        if (!ClassUtil.r(cls)) {
            if (!j.isAssignableFrom(cls)) {
                return null;
            }
            Class<?> cls2 = AnnotatedClassResolver.a;
            return BasicBeanDescription.e(mapperConfig, javaType, new AnnotatedClass(cls));
        }
        if (cls == Object.class) {
            return o;
        }
        if (cls == String.class) {
            return k;
        }
        if (cls == Integer.class) {
            return m;
        }
        if (cls == Long.class) {
            return n;
        }
        if (cls == Boolean.class) {
            return l;
        }
        return null;
    }

    public AnnotatedClass b(MapperConfig<?> mapperConfig, JavaType javaType, ClassIntrospector.a aVar) {
        Class<?> cls = AnnotatedClassResolver.a;
        Objects.requireNonNull(javaType);
        if ((javaType instanceof ArrayType) && AnnotatedClassResolver.i(mapperConfig, javaType._class)) {
            return new AnnotatedClass(javaType._class);
        }
        AnnotatedClassResolver annotatedClassResolver = new AnnotatedClassResolver(mapperConfig, javaType, aVar);
        ArrayList arrayList = new ArrayList(8);
        Class<?> cls2 = javaType._class;
        if (!(cls2 == Object.class)) {
            if (cls2.isInterface()) {
                AnnotatedClassResolver.d(javaType, arrayList, false);
            } else {
                AnnotatedClassResolver.e(javaType, arrayList, false);
            }
        }
        return new AnnotatedClass(javaType, annotatedClassResolver.h, arrayList, annotatedClassResolver.i, annotatedClassResolver.g(arrayList), annotatedClassResolver.f, annotatedClassResolver.d, aVar, mapperConfig._base._typeFactory, annotatedClassResolver.j);
    }
}
