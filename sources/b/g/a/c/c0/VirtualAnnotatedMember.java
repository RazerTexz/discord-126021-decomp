package b.g.a.c.c0;

import b.d.b.a.outline;
import b.g.a.c.JavaType;
import b.g.a.c.i0.ClassUtil;
import java.io.Serializable;
import java.lang.reflect.Member;

/* JADX INFO: renamed from: b.g.a.c.c0.f0, reason: use source file name */
/* JADX INFO: compiled from: VirtualAnnotatedMember.java */
/* JADX INFO: loaded from: classes3.dex */
public class VirtualAnnotatedMember extends AnnotatedMember implements Serializable {
    private static final long serialVersionUID = 1;
    public final Class<?> _declaringClass;
    public final String _name;
    public final JavaType _type;

    public VirtualAnnotatedMember(TypeResolutionContext typeResolutionContext, Class<?> cls, String str, JavaType javaType) {
        super(typeResolutionContext, null);
        this._declaringClass = cls;
        this._type = javaType;
        this._name = str;
    }

    @Override // b.g.a.c.c0.Annotated
    public String c() {
        return this._name;
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
        if (!ClassUtil.o(obj, VirtualAnnotatedMember.class)) {
            return false;
        }
        VirtualAnnotatedMember virtualAnnotatedMember = (VirtualAnnotatedMember) obj;
        return virtualAnnotatedMember._declaringClass == this._declaringClass && virtualAnnotatedMember._name.equals(this._name);
    }

    @Override // b.g.a.c.c0.AnnotatedMember
    public Class<?> g() {
        return this._declaringClass;
    }

    @Override // b.g.a.c.c0.Annotated
    public int hashCode() {
        return this._name.hashCode();
    }

    @Override // b.g.a.c.c0.AnnotatedMember
    public Member i() {
        return null;
    }

    @Override // b.g.a.c.c0.AnnotatedMember
    public Object j(Object obj) throws IllegalArgumentException {
        throw new IllegalArgumentException(outline.J(outline.U("Cannot get virtual property '"), this._name, "'"));
    }

    @Override // b.g.a.c.c0.AnnotatedMember
    public Annotated l(AnnotationMap annotationMap) {
        return this;
    }

    public String toString() {
        StringBuilder sbU = outline.U("[virtual ");
        sbU.append(h());
        sbU.append("]");
        return sbU.toString();
    }
}
