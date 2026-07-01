package b.g.a.c.c0;

import b.g.a.c.AnnotationIntrospector;
import b.g.a.c.c0.AnnotationCollector;
import b.g.a.c.c0.ClassIntrospector;
import b.g.a.c.i0.ClassUtil;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: renamed from: b.g.a.c.c0.k, reason: use source file name */
/* JADX INFO: compiled from: AnnotatedMethodCollector.java */
/* JADX INFO: loaded from: classes3.dex */
public class AnnotatedMethodCollector extends CollectorBase {
    public final ClassIntrospector.a d;
    public final boolean e;

    /* JADX INFO: renamed from: b.g.a.c.c0.k$a */
    /* JADX INFO: compiled from: AnnotatedMethodCollector.java */
    public static final class a {
        public TypeResolutionContext a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Method f691b;
        public AnnotationCollector c;

        public a(TypeResolutionContext typeResolutionContext, Method method, AnnotationCollector annotationCollector) {
            this.a = typeResolutionContext;
            this.f691b = method;
            this.c = annotationCollector;
        }
    }

    public AnnotatedMethodCollector(AnnotationIntrospector annotationIntrospector, ClassIntrospector.a aVar, boolean z2) {
        super(annotationIntrospector);
        this.d = annotationIntrospector == null ? null : aVar;
        this.e = z2;
    }

    public static boolean h(Method method) {
        return (Modifier.isStatic(method.getModifiers()) || method.isSynthetic() || method.isBridge() || method.getParameterTypes().length > 2) ? false : true;
    }

    public final void f(TypeResolutionContext typeResolutionContext, Class<?> cls, Map<MemberKey, a> map, Class<?> cls2) {
        if (cls2 != null) {
            g(typeResolutionContext, cls, map, cls2);
        }
        if (cls == null) {
            return;
        }
        for (Method method : ClassUtil.k(cls)) {
            if (h(method)) {
                MemberKey memberKey = new MemberKey(method);
                a aVar = map.get(memberKey);
                if (aVar == null) {
                    map.put(memberKey, new a(typeResolutionContext, method, this.c == null ? AnnotationCollector.a.c : c(method.getDeclaredAnnotations())));
                } else {
                    if (this.e) {
                        aVar.c = d(aVar.c, method.getDeclaredAnnotations());
                    }
                    Method method2 = aVar.f691b;
                    if (method2 == null) {
                        aVar.f691b = method;
                    } else if (Modifier.isAbstract(method2.getModifiers()) && !Modifier.isAbstract(method.getModifiers())) {
                        aVar.f691b = method;
                        aVar.a = typeResolutionContext;
                    }
                }
            }
        }
    }

    public void g(TypeResolutionContext typeResolutionContext, Class<?> cls, Map<MemberKey, a> map, Class<?> cls2) {
        List listEmptyList;
        if (this.c == null) {
            return;
        }
        Annotation[] annotationArr = ClassUtil.a;
        if (cls2 == cls || cls2 == Object.class) {
            listEmptyList = Collections.emptyList();
        } else {
            listEmptyList = new ArrayList(8);
            ClassUtil.a(cls2, cls, listEmptyList, true);
        }
        Iterator it = listEmptyList.iterator();
        while (it.hasNext()) {
            for (Method method : ((Class) it.next()).getDeclaredMethods()) {
                if (h(method)) {
                    MemberKey memberKey = new MemberKey(method);
                    a aVar = map.get(memberKey);
                    Annotation[] declaredAnnotations = method.getDeclaredAnnotations();
                    if (aVar == null) {
                        map.put(memberKey, new a(typeResolutionContext, null, c(declaredAnnotations)));
                    } else {
                        aVar.c = d(aVar.c, declaredAnnotations);
                    }
                }
            }
        }
    }
}
