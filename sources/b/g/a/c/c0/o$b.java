package b.g.a.c.c0;

import java.lang.annotation.Annotation;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map$Entry;

/* JADX INFO: compiled from: AnnotationCollector.java */
/* JADX INFO: loaded from: classes3.dex */
public class o$b extends o {
    public final HashMap<Class<?>, Annotation> c;

    public o$b(Object obj, Class<?> cls, Annotation annotation, Class<?> cls2, Annotation annotation2) {
        super(obj);
        HashMap<Class<?>, Annotation> map = new HashMap<>();
        this.c = map;
        map.put(cls, annotation);
        map.put(cls2, annotation2);
    }

    @Override // b.g.a.c.c0.o
    public o a(Annotation annotation) {
        this.c.put(annotation.annotationType(), annotation);
        return this;
    }

    @Override // b.g.a.c.c0.o
    public p b() {
        p pVar = new p();
        for (Annotation annotation : this.c.values()) {
            if (pVar.j == null) {
                pVar.j = new HashMap<>();
            }
            Annotation annotationPut = pVar.j.put(annotation.annotationType(), annotation);
            if (annotationPut != null) {
                annotationPut.equals(annotation);
            }
        }
        return pVar;
    }

    @Override // b.g.a.c.c0.o
    public b.g.a.c.i0.a c() {
        if (this.c.size() != 2) {
            return new p(this.c);
        }
        Iterator<Map$Entry<Class<?>, Annotation>> it = this.c.entrySet().iterator();
        Map$Entry<Class<?>, Annotation> next = it.next();
        Map$Entry<Class<?>, Annotation> next2 = it.next();
        return new o$f(next.getKey(), next.getValue(), next2.getKey(), next2.getValue());
    }

    @Override // b.g.a.c.c0.o
    public boolean d(Annotation annotation) {
        return this.c.containsKey(annotation.annotationType());
    }
}
