package p007b.p195g.p196a.p205c.p210c0;

import java.lang.annotation.Annotation;
import java.util.HashMap;
import p007b.p195g.p196a.p205c.p219i0.InterfaceC2339a;

/* JADX INFO: renamed from: b.g.a.c.c0.p */
/* JADX INFO: compiled from: AnnotationMap.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C2195p implements InterfaceC2339a {

    /* JADX INFO: renamed from: j */
    public HashMap<Class<?>, Annotation> f4731j;

    public C2195p() {
    }

    /* JADX INFO: renamed from: c */
    public static C2195p m1916c(C2195p c2195p, C2195p c2195p2) {
        HashMap<Class<?>, Annotation> map;
        HashMap<Class<?>, Annotation> map2;
        if (c2195p == null || (map = c2195p.f4731j) == null || map.isEmpty()) {
            return c2195p2;
        }
        if (c2195p2 == null || (map2 = c2195p2.f4731j) == null || map2.isEmpty()) {
            return c2195p;
        }
        HashMap map3 = new HashMap();
        for (Annotation annotation : c2195p2.f4731j.values()) {
            map3.put(annotation.annotationType(), annotation);
        }
        for (Annotation annotation2 : c2195p.f4731j.values()) {
            map3.put(annotation2.annotationType(), annotation2);
        }
        return new C2195p(map3);
    }

    @Override // p007b.p195g.p196a.p205c.p219i0.InterfaceC2339a
    /* JADX INFO: renamed from: a */
    public <A extends Annotation> A mo1915a(Class<A> cls) {
        HashMap<Class<?>, Annotation> map = this.f4731j;
        if (map == null) {
            return null;
        }
        return (A) map.get(cls);
    }

    /* JADX INFO: renamed from: b */
    public boolean m1917b(Class<? extends Annotation>[] clsArr) {
        if (this.f4731j != null) {
            for (Class<? extends Annotation> cls : clsArr) {
                if (this.f4731j.containsKey(cls)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // p007b.p195g.p196a.p205c.p219i0.InterfaceC2339a
    public int size() {
        HashMap<Class<?>, Annotation> map = this.f4731j;
        if (map == null) {
            return 0;
        }
        return map.size();
    }

    public String toString() {
        HashMap<Class<?>, Annotation> map = this.f4731j;
        return map == null ? "[null]" : map.toString();
    }

    public C2195p(HashMap<Class<?>, Annotation> map) {
        this.f4731j = map;
    }
}
