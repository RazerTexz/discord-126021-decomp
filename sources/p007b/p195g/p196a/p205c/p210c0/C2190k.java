package p007b.p195g.p196a.p205c.p210c0;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import p007b.p195g.p196a.p205c.AbstractC2165b;
import p007b.p195g.p196a.p205c.p219i0.C2342d;

/* JADX INFO: renamed from: b.g.a.c.c0.k */
/* JADX INFO: compiled from: AnnotatedMethodCollector.java */
/* JADX INFO: loaded from: classes3.dex */
public class C2190k extends C2200u {

    /* JADX INFO: renamed from: d */
    public final AbstractC2199t.a f4719d;

    /* JADX INFO: renamed from: e */
    public final boolean f4720e;

    /* JADX INFO: renamed from: b.g.a.c.c0.k$a */
    /* JADX INFO: compiled from: AnnotatedMethodCollector.java */
    public static final class a {

        /* JADX INFO: renamed from: a */
        public InterfaceC2182e0 f4721a;

        /* JADX INFO: renamed from: b */
        public Method f4722b;

        /* JADX INFO: renamed from: c */
        public AbstractC2194o f4723c;

        public a(InterfaceC2182e0 interfaceC2182e0, Method method, AbstractC2194o abstractC2194o) {
            this.f4721a = interfaceC2182e0;
            this.f4722b = method;
            this.f4723c = abstractC2194o;
        }
    }

    public C2190k(AbstractC2165b abstractC2165b, AbstractC2199t.a aVar, boolean z2) {
        super(abstractC2165b);
        this.f4719d = abstractC2165b == null ? null : aVar;
        this.f4720e = z2;
    }

    /* JADX INFO: renamed from: h */
    public static boolean m1907h(Method method) {
        return (Modifier.isStatic(method.getModifiers()) || method.isSynthetic() || method.isBridge() || method.getParameterTypes().length > 2) ? false : true;
    }

    /* JADX INFO: renamed from: f */
    public final void m1908f(InterfaceC2182e0 interfaceC2182e0, Class<?> cls, Map<C2204y, a> map, Class<?> cls2) {
        if (cls2 != null) {
            m1909g(interfaceC2182e0, cls, map, cls2);
        }
        if (cls == null) {
            return;
        }
        for (Method method : C2342d.m2179k(cls)) {
            if (m1907h(method)) {
                C2204y c2204y = new C2204y(method);
                a aVar = map.get(c2204y);
                if (aVar == null) {
                    map.put(c2204y, new a(interfaceC2182e0, method, this.f4750c == null ? AbstractC2194o.a.f4727c : m1925c(method.getDeclaredAnnotations())));
                } else {
                    if (this.f4720e) {
                        aVar.f4723c = m1926d(aVar.f4723c, method.getDeclaredAnnotations());
                    }
                    Method method2 = aVar.f4722b;
                    if (method2 == null) {
                        aVar.f4722b = method;
                    } else if (Modifier.isAbstract(method2.getModifiers()) && !Modifier.isAbstract(method.getModifiers())) {
                        aVar.f4722b = method;
                        aVar.f4721a = interfaceC2182e0;
                    }
                }
            }
        }
    }

    /* JADX INFO: renamed from: g */
    public void m1909g(InterfaceC2182e0 interfaceC2182e0, Class<?> cls, Map<C2204y, a> map, Class<?> cls2) {
        List listEmptyList;
        if (this.f4750c == null) {
            return;
        }
        Annotation[] annotationArr = C2342d.f4944a;
        if (cls2 == cls || cls2 == Object.class) {
            listEmptyList = Collections.emptyList();
        } else {
            listEmptyList = new ArrayList(8);
            C2342d.m2169a(cls2, cls, listEmptyList, true);
        }
        Iterator it = listEmptyList.iterator();
        while (it.hasNext()) {
            for (Method method : ((Class) it.next()).getDeclaredMethods()) {
                if (m1907h(method)) {
                    C2204y c2204y = new C2204y(method);
                    a aVar = map.get(c2204y);
                    Annotation[] declaredAnnotations = method.getDeclaredAnnotations();
                    if (aVar == null) {
                        map.put(c2204y, new a(interfaceC2182e0, null, m1925c(declaredAnnotations)));
                    } else {
                        aVar.f4723c = m1926d(aVar.f4723c, declaredAnnotations);
                    }
                }
            }
        }
    }
}
