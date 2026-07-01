package b.g.a.c.c0;

import java.lang.annotation.Annotation;
import java.util.HashMap;

/* JADX INFO: compiled from: AnnotationCollector.java */
/* JADX INFO: loaded from: classes3.dex */
public class o$e extends o {
    public Class<?> c;
    public Annotation d;

    public o$e(Object obj, Class<?> cls, Annotation annotation) {
        super(obj);
        this.c = cls;
        this.d = annotation;
    }

    @Override // b.g.a.c.c0.o
    public o a(Annotation annotation) {
        Class<? extends Annotation> clsAnnotationType = annotation.annotationType();
        Class<?> cls = this.c;
        if (cls != clsAnnotationType) {
            return new o$b(this.f692b, cls, this.d, clsAnnotationType, annotation);
        }
        this.d = annotation;
        return this;
    }

    @Override // b.g.a.c.c0.o
    public p b() {
        Class<?> cls = this.c;
        Annotation annotation = this.d;
        HashMap map = new HashMap(4);
        map.put(cls, annotation);
        return new p(map);
    }

    @Override // b.g.a.c.c0.o
    public b.g.a.c.i0.a c() {
        return new o$d(this.c, this.d);
    }

    @Override // b.g.a.c.c0.o
    public boolean d(Annotation annotation) {
        return annotation.annotationType() == this.c;
    }
}
