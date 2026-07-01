package b.g.a.c;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.List;

/* JADX INFO: compiled from: JavaType.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class j extends b.g.a.b.s.a implements Serializable, Type {
    private static final long serialVersionUID = 1;
    public final boolean _asStatic;
    public final Class<?> _class;
    public final int _hash;
    public final Object _typeHandler;
    public final Object _valueHandler;

    public j(Class<?> cls, int i, Object obj, Object obj2, boolean z2) {
        this._class = cls;
        this._hash = cls.getName().hashCode() + i;
        this._valueHandler = obj;
        this._typeHandler = obj2;
        this._asStatic = z2;
    }

    public final boolean A() {
        Class<?> cls = this._class;
        Annotation[] annotationArr = b.g.a.c.i0.d.a;
        Class<? super Object> superclass = cls.getSuperclass();
        return superclass != null && "java.lang.Record".equals(superclass.getName());
    }

    public final boolean B(Class<?> cls) {
        Class<?> cls2 = this._class;
        return cls2 == cls || cls.isAssignableFrom(cls2);
    }

    public abstract j C(Class<?> cls, b.g.a.c.h0.m mVar, j jVar, j[] jVarArr);

    public abstract j D(j jVar);

    public abstract j E(Object obj);

    public j F(j jVar) {
        Object obj = jVar._typeHandler;
        j jVarH = obj != this._typeHandler ? H(obj) : this;
        Object obj2 = jVar._valueHandler;
        return obj2 != this._valueHandler ? jVarH.I(obj2) : jVarH;
    }

    public abstract j G();

    public abstract j H(Object obj);

    public abstract j I(Object obj);

    @Override // b.g.a.b.s.a
    public /* bridge */ /* synthetic */ b.g.a.b.s.a a() {
        return p();
    }

    public abstract boolean equals(Object obj);

    public abstract j f(int i);

    public abstract int g();

    public j h(int i) {
        j jVarF = f(i);
        return jVarF == null ? b.g.a.c.h0.n.k() : jVarF;
    }

    public final int hashCode() {
        return this._hash;
    }

    public abstract j i(Class<?> cls);

    public abstract b.g.a.c.h0.m j();

    public j k() {
        return null;
    }

    public abstract StringBuilder l(StringBuilder sb);

    public abstract StringBuilder m(StringBuilder sb);

    public abstract List<j> n();

    public j o() {
        return null;
    }

    public j p() {
        return null;
    }

    public abstract j q();

    public boolean r() {
        return g() > 0;
    }

    public boolean s() {
        return (this._typeHandler == null && this._valueHandler == null) ? false : true;
    }

    public final boolean t(Class<?> cls) {
        return this._class == cls;
    }

    public boolean u() {
        return false;
    }

    public abstract boolean v();

    public final boolean w() {
        return b.g.a.c.i0.d.q(this._class);
    }

    public final boolean x() {
        return Modifier.isFinal(this._class.getModifiers());
    }

    public final boolean y() {
        return this._class == Object.class;
    }

    public boolean z() {
        return false;
    }
}
