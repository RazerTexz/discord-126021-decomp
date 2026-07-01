package b.g.a.c.c0;

import java.io.Serializable;
import java.lang.annotation.Annotation;

/* JADX INFO: compiled from: AnnotationCollector.java */
/* JADX INFO: loaded from: classes3.dex */
public class o$f implements b.g.a.c.i0.a, Serializable {
    private static final long serialVersionUID = 1;
    private final Class<?> _type1;
    private final Class<?> _type2;
    private final Annotation _value1;
    private final Annotation _value2;

    public o$f(Class<?> cls, Annotation annotation, Class<?> cls2, Annotation annotation2) {
        this._type1 = cls;
        this._value1 = annotation;
        this._type2 = cls2;
        this._value2 = annotation2;
    }

    @Override // b.g.a.c.i0.a
    public <A extends Annotation> A a(Class<A> cls) {
        if (this._type1 == cls) {
            return (A) this._value1;
        }
        if (this._type2 == cls) {
            return (A) this._value2;
        }
        return null;
    }

    @Override // b.g.a.c.i0.a
    public int size() {
        return 2;
    }
}
