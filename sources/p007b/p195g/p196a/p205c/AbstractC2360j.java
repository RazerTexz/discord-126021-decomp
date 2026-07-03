package p007b.p195g.p196a.p205c;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.List;
import p007b.p195g.p196a.p198b.p203s.AbstractC2137a;
import p007b.p195g.p196a.p205c.p218h0.C2334m;
import p007b.p195g.p196a.p205c.p218h0.C2335n;
import p007b.p195g.p196a.p205c.p219i0.C2342d;

/* JADX INFO: renamed from: b.g.a.c.j */
/* JADX INFO: compiled from: JavaType.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC2360j extends AbstractC2137a implements Serializable, Type {
    private static final long serialVersionUID = 1;
    public final boolean _asStatic;
    public final Class<?> _class;
    public final int _hash;
    public final Object _typeHandler;
    public final Object _valueHandler;

    public AbstractC2360j(Class<?> cls, int i, Object obj, Object obj2, boolean z2) {
        this._class = cls;
        this._hash = cls.getName().hashCode() + i;
        this._valueHandler = obj;
        this._typeHandler = obj2;
        this._asStatic = z2;
    }

    /* JADX INFO: renamed from: A */
    public final boolean m2215A() {
        Class<?> cls = this._class;
        Annotation[] annotationArr = C2342d.f4944a;
        Class<? super Object> superclass = cls.getSuperclass();
        return superclass != null && "java.lang.Record".equals(superclass.getName());
    }

    /* JADX INFO: renamed from: B */
    public final boolean m2216B(Class<?> cls) {
        Class<?> cls2 = this._class;
        return cls2 == cls || cls.isAssignableFrom(cls2);
    }

    /* JADX INFO: renamed from: C */
    public abstract AbstractC2360j mo2093C(Class<?> cls, C2334m c2334m, AbstractC2360j abstractC2360j, AbstractC2360j[] abstractC2360jArr);

    /* JADX INFO: renamed from: D */
    public abstract AbstractC2360j mo2094D(AbstractC2360j abstractC2360j);

    /* JADX INFO: renamed from: E */
    public abstract AbstractC2360j mo2095E(Object obj);

    /* JADX INFO: renamed from: F */
    public AbstractC2360j mo2105F(AbstractC2360j abstractC2360j) {
        Object obj = abstractC2360j._typeHandler;
        AbstractC2360j abstractC2360jMo2097H = obj != this._typeHandler ? mo2097H(obj) : this;
        Object obj2 = abstractC2360j._valueHandler;
        return obj2 != this._valueHandler ? abstractC2360jMo2097H.mo2098I(obj2) : abstractC2360jMo2097H;
    }

    /* JADX INFO: renamed from: G */
    public abstract AbstractC2360j mo2096G();

    /* JADX INFO: renamed from: H */
    public abstract AbstractC2360j mo2097H(Object obj);

    /* JADX INFO: renamed from: I */
    public abstract AbstractC2360j mo2098I(Object obj);

    public abstract boolean equals(Object obj);

    /* JADX INFO: renamed from: f */
    public abstract AbstractC2360j mo2142f(int i);

    /* JADX INFO: renamed from: g */
    public abstract int mo2143g();

    /* JADX INFO: renamed from: h */
    public AbstractC2360j m2217h(int i) {
        AbstractC2360j abstractC2360jMo2142f = mo2142f(i);
        return abstractC2360jMo2142f == null ? C2335n.m2158k() : abstractC2360jMo2142f;
    }

    public final int hashCode() {
        return this._hash;
    }

    /* JADX INFO: renamed from: i */
    public abstract AbstractC2360j mo2144i(Class<?> cls);

    /* JADX INFO: renamed from: j */
    public abstract C2334m mo2136j();

    /* JADX INFO: renamed from: k */
    public AbstractC2360j mo2099k() {
        return null;
    }

    /* JADX INFO: renamed from: l */
    public abstract StringBuilder mo2100l(StringBuilder sb);

    /* JADX INFO: renamed from: m */
    public abstract StringBuilder mo2101m(StringBuilder sb);

    /* JADX INFO: renamed from: n */
    public abstract List<AbstractC2360j> mo2145n();

    /* JADX INFO: renamed from: o */
    public AbstractC2360j mo2121o() {
        return null;
    }

    @Override // p007b.p195g.p196a.p198b.p203s.AbstractC2137a
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public AbstractC2360j mo1727a() {
        return null;
    }

    /* JADX INFO: renamed from: q */
    public abstract AbstractC2360j mo2137q();

    /* JADX INFO: renamed from: r */
    public boolean mo2102r() {
        return mo2143g() > 0;
    }

    /* JADX INFO: renamed from: s */
    public boolean mo2103s() {
        return (this._typeHandler == null && this._valueHandler == null) ? false : true;
    }

    /* JADX INFO: renamed from: t */
    public final boolean m2218t(Class<?> cls) {
        return this._class == cls;
    }

    /* JADX INFO: renamed from: u */
    public boolean mo2111u() {
        return false;
    }

    /* JADX INFO: renamed from: v */
    public abstract boolean mo2104v();

    /* JADX INFO: renamed from: w */
    public final boolean m2219w() {
        return C2342d.m2185q(this._class);
    }

    /* JADX INFO: renamed from: x */
    public final boolean m2220x() {
        return Modifier.isFinal(this._class.getModifiers());
    }

    /* JADX INFO: renamed from: y */
    public final boolean m2221y() {
        return this._class == Object.class;
    }

    /* JADX INFO: renamed from: z */
    public boolean mo2122z() {
        return false;
    }
}
