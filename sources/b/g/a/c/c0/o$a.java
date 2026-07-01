package b.g.a.c.c0;

import java.lang.annotation.Annotation;

/* JADX INFO: compiled from: AnnotationCollector.java */
/* JADX INFO: loaded from: classes3.dex */
public class o$a extends o {
    public static final o$a c = new o$a(null);

    public o$a(Object obj) {
        super(null);
    }

    @Override // b.g.a.c.c0.o
    public o a(Annotation annotation) {
        return new o$e(this.f692b, annotation.annotationType(), annotation);
    }

    @Override // b.g.a.c.c0.o
    public p b() {
        return new p();
    }

    @Override // b.g.a.c.c0.o
    public b.g.a.c.i0.a c() {
        return o.a;
    }

    @Override // b.g.a.c.c0.o
    public boolean d(Annotation annotation) {
        return false;
    }
}
