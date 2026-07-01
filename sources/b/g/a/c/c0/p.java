package b.g.a.c.c0;

import java.lang.annotation.Annotation;
import java.util.HashMap;

/* JADX INFO: compiled from: AnnotationMap.java */
/* JADX INFO: loaded from: classes3.dex */
public final class p implements b.g.a.c.i0.a {
    public HashMap<Class<?>, Annotation> j;

    public p() {
    }

    public static p c(p pVar, p pVar2) {
        HashMap<Class<?>, Annotation> map;
        HashMap<Class<?>, Annotation> map2;
        if (pVar == null || (map = pVar.j) == null || map.isEmpty()) {
            return pVar2;
        }
        if (pVar2 == null || (map2 = pVar2.j) == null || map2.isEmpty()) {
            return pVar;
        }
        HashMap map3 = new HashMap();
        for (Annotation annotation : pVar2.j.values()) {
            map3.put(annotation.annotationType(), annotation);
        }
        for (Annotation annotation2 : pVar.j.values()) {
            map3.put(annotation2.annotationType(), annotation2);
        }
        return new p(map3);
    }

    @Override // b.g.a.c.i0.a
    public <A extends Annotation> A a(Class<A> cls) {
        HashMap<Class<?>, Annotation> map = this.j;
        if (map == null) {
            return null;
        }
        return (A) map.get(cls);
    }

    public boolean b(Class<? extends Annotation>[] clsArr) {
        if (this.j != null) {
            for (Class<? extends Annotation> cls : clsArr) {
                if (this.j.containsKey(cls)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // b.g.a.c.i0.a
    public int size() {
        HashMap<Class<?>, Annotation> map = this.j;
        if (map == null) {
            return 0;
        }
        return map.size();
    }

    public String toString() {
        HashMap<Class<?>, Annotation> map = this.j;
        return map == null ? "[null]" : map.toString();
    }

    public p(HashMap<Class<?>, Annotation> map) {
        this.j = map;
    }
}
