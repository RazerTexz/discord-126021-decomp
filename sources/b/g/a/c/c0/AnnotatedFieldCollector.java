package b.g.a.c.c0;

import b.g.a.c.AnnotationIntrospector;
import b.g.a.c.JavaType;
import b.g.a.c.c0.AnnotationCollector;
import b.g.a.c.c0.ClassIntrospector;
import b.g.a.c.c0.TypeResolutionContext;
import b.g.a.c.h0.TypeFactory;
import b.g.a.c.i0.ClassUtil;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: renamed from: b.g.a.c.c0.h, reason: use source file name */
/* JADX INFO: compiled from: AnnotatedFieldCollector.java */
/* JADX INFO: loaded from: classes3.dex */
public class AnnotatedFieldCollector extends CollectorBase {
    public final TypeFactory d;
    public final ClassIntrospector.a e;
    public final boolean f;

    /* JADX INFO: renamed from: b.g.a.c.c0.h$a */
    /* JADX INFO: compiled from: AnnotatedFieldCollector.java */
    public static final class a {
        public final TypeResolutionContext a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Field f690b;
        public AnnotationCollector c = AnnotationCollector.a.c;

        public a(TypeResolutionContext typeResolutionContext, Field field) {
            this.a = typeResolutionContext;
            this.f690b = field;
        }
    }

    public AnnotatedFieldCollector(AnnotationIntrospector annotationIntrospector, TypeFactory typeFactory, ClassIntrospector.a aVar, boolean z2) {
        super(annotationIntrospector);
        this.d = typeFactory;
        this.e = annotationIntrospector == null ? null : aVar;
        this.f = z2;
    }

    public final Map<String, a> f(TypeResolutionContext typeResolutionContext, JavaType javaType, Map<String, a> map) {
        ClassIntrospector.a aVar;
        Class<?> clsA;
        a aVar2;
        JavaType javaTypeQ = javaType.q();
        if (javaTypeQ == null) {
            return map;
        }
        Class<?> cls = javaType._class;
        Map<String, a> mapF = f(new TypeResolutionContext.a(this.d, javaTypeQ.j()), javaTypeQ, map);
        for (Field field : cls.getDeclaredFields()) {
            if (g(field)) {
                if (mapF == null) {
                    mapF = new LinkedHashMap<>();
                }
                a aVar3 = new a(typeResolutionContext, field);
                if (this.f) {
                    aVar3.c = b(aVar3.c, field.getDeclaredAnnotations());
                }
                mapF.put(field.getName(), aVar3);
            }
        }
        if (mapF != null && (aVar = this.e) != null && (clsA = aVar.a(cls)) != null) {
            Iterator it = ((ArrayList) ClassUtil.j(clsA, cls, true)).iterator();
            while (it.hasNext()) {
                for (Field field2 : ((Class) it.next()).getDeclaredFields()) {
                    if (g(field2) && (aVar2 = mapF.get(field2.getName())) != null) {
                        aVar2.c = b(aVar2.c, field2.getDeclaredAnnotations());
                    }
                }
            }
        }
        return mapF;
    }

    public final boolean g(Field field) {
        return (field.isSynthetic() || Modifier.isStatic(field.getModifiers())) ? false : true;
    }
}
