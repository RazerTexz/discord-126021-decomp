package b.g.a.c.c0;

import b.g.a.c.i0.Annotations;
import java.lang.annotation.Annotation;
import java.util.HashMap;

/* JADX INFO: renamed from: b.g.a.c.c0.p, reason: use source file name */
/* JADX INFO: compiled from: AnnotationMap.java */
/* JADX INFO: loaded from: classes3.dex */
public final class AnnotationMap implements Annotations {
    public HashMap<Class<?>, Annotation> j;

    public AnnotationMap() {
    }

    public static AnnotationMap c(AnnotationMap annotationMap, AnnotationMap annotationMap2) {
        HashMap<Class<?>, Annotation> map;
        HashMap<Class<?>, Annotation> map2;
        if (annotationMap == null || (map = annotationMap.j) == null || map.isEmpty()) {
            return annotationMap2;
        }
        if (annotationMap2 == null || (map2 = annotationMap2.j) == null || map2.isEmpty()) {
            return annotationMap;
        }
        HashMap map3 = new HashMap();
        for (Annotation annotation : annotationMap2.j.values()) {
            map3.put(annotation.annotationType(), annotation);
        }
        for (Annotation annotation2 : annotationMap.j.values()) {
            map3.put(annotation2.annotationType(), annotation2);
        }
        return new AnnotationMap(map3);
    }

    @Override // b.g.a.c.i0.Annotations
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

    @Override // b.g.a.c.i0.Annotations
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

    public AnnotationMap(HashMap<Class<?>, Annotation> map) {
        this.j = map;
    }
}
