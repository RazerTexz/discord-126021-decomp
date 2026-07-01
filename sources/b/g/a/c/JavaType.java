package b.g.a.c;

import b.g.a.b.s.ResolvedType;
import b.g.a.c.h0.TypeBindings;
import b.g.a.c.h0.TypeFactory;
import b.g.a.c.i0.ClassUtil;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.List;

/* JADX INFO: renamed from: b.g.a.c.j, reason: use source file name */
/* JADX INFO: compiled from: JavaType.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class JavaType extends ResolvedType implements Serializable, Type {
    private static final long serialVersionUID = 1;
    public final boolean _asStatic;
    public final Class<?> _class;
    public final int _hash;
    public final Object _typeHandler;
    public final Object _valueHandler;

    public JavaType(Class<?> cls, int i, Object obj, Object obj2, boolean z2) {
        this._class = cls;
        this._hash = cls.getName().hashCode() + i;
        this._valueHandler = obj;
        this._typeHandler = obj2;
        this._asStatic = z2;
    }

    public final boolean A() {
        Class<?> cls = this._class;
        Annotation[] annotationArr = ClassUtil.a;
        Class<? super Object> superclass = cls.getSuperclass();
        return superclass != null && "java.lang.Record".equals(superclass.getName());
    }

    public final boolean B(Class<?> cls) {
        Class<?> cls2 = this._class;
        return cls2 == cls || cls.isAssignableFrom(cls2);
    }

    public abstract JavaType C(Class<?> cls, TypeBindings typeBindings, JavaType javaType, JavaType[] javaTypeArr);

    public abstract JavaType D(JavaType javaType);

    public abstract JavaType E(Object obj);

    public JavaType F(JavaType javaType) {
        Object obj = javaType._typeHandler;
        JavaType javaTypeH = obj != this._typeHandler ? H(obj) : this;
        Object obj2 = javaType._valueHandler;
        return obj2 != this._valueHandler ? javaTypeH.I(obj2) : javaTypeH;
    }

    public abstract JavaType G();

    public abstract JavaType H(Object obj);

    public abstract JavaType I(Object obj);

    public abstract boolean equals(Object obj);

    public abstract JavaType f(int i);

    public abstract int g();

    public JavaType h(int i) {
        JavaType javaTypeF = f(i);
        return javaTypeF == null ? TypeFactory.k() : javaTypeF;
    }

    public final int hashCode() {
        return this._hash;
    }

    public abstract JavaType i(Class<?> cls);

    public abstract TypeBindings j();

    public JavaType k() {
        return null;
    }

    public abstract StringBuilder l(StringBuilder sb);

    public abstract StringBuilder m(StringBuilder sb);

    public abstract List<JavaType> n();

    public JavaType o() {
        return null;
    }

    @Override // b.g.a.b.s.ResolvedType
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public JavaType a() {
        return null;
    }

    public abstract JavaType q();

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
        return ClassUtil.q(this._class);
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
