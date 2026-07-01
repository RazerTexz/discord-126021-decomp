package b.g.a.c.c0;

import java.io.Serializable;
import java.lang.annotation.Annotation;

/* JADX INFO: compiled from: AnnotationCollector.java */
/* JADX INFO: loaded from: classes3.dex */
public class o$d implements b.g.a.c.i0.a, Serializable {
    private static final long serialVersionUID = 1;
    private final Class<?> _type;
    private final Annotation _value;

    public o$d(Class<?> cls, Annotation annotation) {
        this._type = cls;
        this._value = annotation;
    }

    @Override // b.g.a.c.i0.a
    public <A extends Annotation> A a(Class<A> cls) {
        if (this._type == cls) {
            return (A) this._value;
        }
        return null;
    }

    @Override // b.g.a.c.i0.a
    public int size() {
        return 1;
    }
}
