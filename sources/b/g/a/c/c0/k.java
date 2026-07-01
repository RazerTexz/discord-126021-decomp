package b.g.a.c.c0;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: AnnotatedMethodCollector.java */
/* JADX INFO: loaded from: classes3.dex */
public class k extends u {
    public final t$a d;
    public final boolean e;

    public k(b.g.a.c.b bVar, t$a t_a, boolean z2) {
        super(bVar);
        this.d = bVar == null ? null : t_a;
        this.e = z2;
    }

    public static boolean h(Method method) {
        return (Modifier.isStatic(method.getModifiers()) || method.isSynthetic() || method.isBridge() || method.getParameterTypes().length > 2) ? false : true;
    }

    public final void f(e0 e0Var, Class<?> cls, Map<y, k$a> map, Class<?> cls2) {
        if (cls2 != null) {
            g(e0Var, cls, map, cls2);
        }
        if (cls == null) {
            return;
        }
        for (Method method : b.g.a.c.i0.d.k(cls)) {
            if (h(method)) {
                y yVar = new y(method);
                k$a k_a = map.get(yVar);
                if (k_a == null) {
                    map.put(yVar, new k$a(e0Var, method, this.c == null ? o$a.c : c(method.getDeclaredAnnotations())));
                } else {
                    if (this.e) {
                        k_a.c = d(k_a.c, method.getDeclaredAnnotations());
                    }
                    Method method2 = k_a.f691b;
                    if (method2 == null) {
                        k_a.f691b = method;
                    } else if (Modifier.isAbstract(method2.getModifiers()) && !Modifier.isAbstract(method.getModifiers())) {
                        k_a.f691b = method;
                        k_a.a = e0Var;
                    }
                }
            }
        }
    }

    public void g(e0 e0Var, Class<?> cls, Map<y, k$a> map, Class<?> cls2) {
        List listEmptyList;
        if (this.c == null) {
            return;
        }
        Annotation[] annotationArr = b.g.a.c.i0.d.a;
        if (cls2 == cls || cls2 == Object.class) {
            listEmptyList = Collections.emptyList();
        } else {
            listEmptyList = new ArrayList(8);
            b.g.a.c.i0.d.a(cls2, cls, listEmptyList, true);
        }
        Iterator it = listEmptyList.iterator();
        while (it.hasNext()) {
            for (Method method : ((Class) it.next()).getDeclaredMethods()) {
                if (h(method)) {
                    y yVar = new y(method);
                    k$a k_a = map.get(yVar);
                    Annotation[] declaredAnnotations = method.getDeclaredAnnotations();
                    if (k_a == null) {
                        map.put(yVar, new k$a(e0Var, null, c(declaredAnnotations)));
                    } else {
                        k_a.c = d(k_a.c, declaredAnnotations);
                    }
                }
            }
        }
    }
}
