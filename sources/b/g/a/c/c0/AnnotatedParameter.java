package b.g.a.c.c0;

import b.d.b.a.outline;
import b.g.a.c.JavaType;
import b.g.a.c.i0.ClassUtil;
import java.lang.reflect.Member;

/* JADX INFO: renamed from: b.g.a.c.c0.m, reason: use source file name */
/* JADX INFO: compiled from: AnnotatedParameter.java */
/* JADX INFO: loaded from: classes3.dex */
public final class AnnotatedParameter extends AnnotatedMember {
    private static final long serialVersionUID = 1;
    public final int _index;
    public final AnnotatedWithParams _owner;
    public final JavaType _type;

    public AnnotatedParameter(AnnotatedWithParams annotatedWithParams, JavaType javaType, TypeResolutionContext typeResolutionContext, AnnotationMap annotationMap, int i) {
        super(typeResolutionContext, annotationMap);
        this._owner = annotatedWithParams;
        this._type = javaType;
        this._index = i;
    }

    @Override // b.g.a.c.c0.Annotated
    public String c() {
        return "";
    }

    @Override // b.g.a.c.c0.Annotated
    public Class<?> d() {
        return this._type._class;
    }

    @Override // b.g.a.c.c0.Annotated
    public JavaType e() {
        return this._type;
    }

    @Override // b.g.a.c.c0.Annotated
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!ClassUtil.o(obj, AnnotatedParameter.class)) {
            return false;
        }
        AnnotatedParameter annotatedParameter = (AnnotatedParameter) obj;
        return annotatedParameter._owner.equals(this._owner) && annotatedParameter._index == this._index;
    }

    @Override // b.g.a.c.c0.AnnotatedMember
    public Class<?> g() {
        return this._owner.g();
    }

    @Override // b.g.a.c.c0.Annotated
    public int hashCode() {
        return this._owner.hashCode() + this._index;
    }

    @Override // b.g.a.c.c0.AnnotatedMember
    public Member i() {
        return this._owner.i();
    }

    @Override // b.g.a.c.c0.AnnotatedMember
    public Object j(Object obj) throws UnsupportedOperationException {
        StringBuilder sbU = outline.U("Cannot call getValue() on constructor parameter of ");
        sbU.append(g().getName());
        throw new UnsupportedOperationException(sbU.toString());
    }

    @Override // b.g.a.c.c0.AnnotatedMember
    public Annotated l(AnnotationMap annotationMap) {
        if (annotationMap == this.k) {
            return this;
        }
        AnnotatedWithParams annotatedWithParams = this._owner;
        int i = this._index;
        annotatedWithParams._paramAnnotations[i] = annotationMap;
        return annotatedWithParams.m(i);
    }

    public String toString() {
        StringBuilder sbU = outline.U("[parameter #");
        sbU.append(this._index);
        sbU.append(", annotations: ");
        sbU.append(this.k);
        sbU.append("]");
        return sbU.toString();
    }
}
