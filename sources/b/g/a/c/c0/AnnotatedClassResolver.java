package b.g.a.c.c0;

import b.g.a.c.AnnotationIntrospector;
import b.g.a.c.JavaType;
import b.g.a.c.c0.AnnotationCollector;
import b.g.a.c.c0.ClassIntrospector;
import b.g.a.c.h0.TypeBindings;
import b.g.a.c.i0.Annotations;
import b.g.a.c.i0.ClassUtil;
import b.g.a.c.z.MapperConfig;
import b.g.a.c.z.MapperConfigBase;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: renamed from: b.g.a.c.c0.d, reason: use source file name */
/* JADX INFO: compiled from: AnnotatedClassResolver.java */
/* JADX INFO: loaded from: classes3.dex */
public class AnnotatedClassResolver {
    public static final Class<?> a = List.class;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Class<?> f689b = Map.class;
    public final MapperConfig<?> c;
    public final AnnotationIntrospector d;
    public final ClassIntrospector.a e;
    public final TypeBindings f;
    public final JavaType g;
    public final Class<?> h;
    public final Class<?> i;
    public final boolean j;

    public AnnotatedClassResolver(MapperConfig<?> mapperConfig, JavaType javaType, ClassIntrospector.a aVar) {
        this.c = mapperConfig;
        this.g = javaType;
        Class<?> cls = javaType._class;
        this.h = cls;
        this.e = aVar;
        this.f = javaType.j();
        AnnotationIntrospector annotationIntrospectorE = mapperConfig.p() ? mapperConfig.e() : null;
        this.d = annotationIntrospectorE;
        this.i = aVar != null ? aVar.a(cls) : null;
        this.j = (annotationIntrospectorE == null || (ClassUtil.r(cls) && javaType.v())) ? false : true;
    }

    public static void d(JavaType javaType, List<JavaType> list, boolean z2) {
        Class<?> cls = javaType._class;
        if (z2) {
            if (f(list, cls)) {
                return;
            }
            list.add(javaType);
            if (cls == a || cls == f689b) {
                return;
            }
        }
        Iterator<JavaType> it = javaType.n().iterator();
        while (it.hasNext()) {
            d(it.next(), list, true);
        }
    }

    public static void e(JavaType javaType, List<JavaType> list, boolean z2) {
        Class<?> cls = javaType._class;
        if (cls == Object.class || cls == Enum.class) {
            return;
        }
        if (z2) {
            if (f(list, cls)) {
                return;
            } else {
                list.add(javaType);
            }
        }
        Iterator<JavaType> it = javaType.n().iterator();
        while (it.hasNext()) {
            d(it.next(), list, true);
        }
        JavaType javaTypeQ = javaType.q();
        if (javaTypeQ != null) {
            e(javaTypeQ, list, true);
        }
    }

    public static boolean f(List<JavaType> list, Class<?> cls) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (list.get(i)._class == cls) {
                return true;
            }
        }
        return false;
    }

    public static AnnotatedClass h(MapperConfig<?> mapperConfig, Class<?> cls) {
        if (cls.isArray() && i(mapperConfig, cls)) {
            return new AnnotatedClass(cls);
        }
        AnnotatedClassResolver annotatedClassResolver = new AnnotatedClassResolver(mapperConfig, cls, mapperConfig);
        List<JavaType> listEmptyList = Collections.emptyList();
        return new AnnotatedClass(null, cls, listEmptyList, annotatedClassResolver.i, annotatedClassResolver.g(listEmptyList), annotatedClassResolver.f, annotatedClassResolver.d, mapperConfig, mapperConfig._base._typeFactory, annotatedClassResolver.j);
    }

    public static boolean i(MapperConfig<?> mapperConfig, Class<?> cls) {
        return mapperConfig == null || ((MapperConfigBase) mapperConfig)._mixIns.a(cls) == null;
    }

    public final AnnotationCollector a(AnnotationCollector annotationCollector, Annotation[] annotationArr) {
        if (annotationArr != null) {
            for (Annotation annotation : annotationArr) {
                if (!annotationCollector.d(annotation)) {
                    annotationCollector = annotationCollector.a(annotation);
                    if (this.d.b0(annotation)) {
                        annotationCollector = c(annotationCollector, annotation);
                    }
                }
            }
        }
        return annotationCollector;
    }

    public final AnnotationCollector b(AnnotationCollector annotationCollector, Class<?> cls, Class<?> cls2) {
        if (cls2 != null) {
            annotationCollector = a(annotationCollector, ClassUtil.i(cls2));
            Iterator it = ((ArrayList) ClassUtil.j(cls2, cls, false)).iterator();
            while (it.hasNext()) {
                annotationCollector = a(annotationCollector, ClassUtil.i((Class) it.next()));
            }
        }
        return annotationCollector;
    }

    public final AnnotationCollector c(AnnotationCollector annotationCollector, Annotation annotation) {
        for (Annotation annotation2 : ClassUtil.i(annotation.annotationType())) {
            if (!(annotation2 instanceof Target) && !(annotation2 instanceof Retention) && !annotationCollector.d(annotation2)) {
                annotationCollector = annotationCollector.a(annotation2);
                if (this.d.b0(annotation2)) {
                    annotationCollector = c(annotationCollector, annotation2);
                }
            }
        }
        return annotationCollector;
    }

    public final Annotations g(List<JavaType> list) {
        if (this.d == null) {
            return AnnotationCollector.a;
        }
        ClassIntrospector.a aVar = this.e;
        boolean z2 = aVar != null && (!(aVar instanceof SimpleMixInResolver) || ((SimpleMixInResolver) aVar).b());
        if (!z2 && !this.j) {
            return AnnotationCollector.a;
        }
        AnnotationCollector annotationCollectorB = AnnotationCollector.a.c;
        Class<?> cls = this.i;
        if (cls != null) {
            annotationCollectorB = b(annotationCollectorB, this.h, cls);
        }
        if (this.j) {
            annotationCollectorB = a(annotationCollectorB, ClassUtil.i(this.h));
        }
        for (JavaType javaType : list) {
            if (z2) {
                Class<?> cls2 = javaType._class;
                annotationCollectorB = b(annotationCollectorB, cls2, this.e.a(cls2));
            }
            if (this.j) {
                annotationCollectorB = a(annotationCollectorB, ClassUtil.i(javaType._class));
            }
        }
        if (z2) {
            annotationCollectorB = b(annotationCollectorB, Object.class, this.e.a(Object.class));
        }
        return annotationCollectorB.c();
    }

    public AnnotatedClassResolver(MapperConfig<?> mapperConfig, Class<?> cls, ClassIntrospector.a aVar) {
        this.c = mapperConfig;
        this.g = null;
        this.h = cls;
        this.e = aVar;
        this.f = TypeBindings.l;
        if (mapperConfig == null) {
            this.d = null;
            this.i = null;
        } else {
            this.d = mapperConfig.p() ? mapperConfig.e() : null;
            this.i = aVar != null ? aVar.a(cls) : null;
        }
        this.j = this.d != null;
    }
}
