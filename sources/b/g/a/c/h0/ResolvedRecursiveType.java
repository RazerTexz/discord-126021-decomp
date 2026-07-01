package b.g.a.c.h0;

import b.g.a.c.JavaType;

/* JADX INFO: renamed from: b.g.a.c.h0.j, reason: use source file name */
/* JADX INFO: compiled from: ResolvedRecursiveType.java */
/* JADX INFO: loaded from: classes3.dex */
public class ResolvedRecursiveType extends TypeBase {
    private static final long serialVersionUID = 1;
    public JavaType _referencedType;

    public ResolvedRecursiveType(Class<?> cls, TypeBindings typeBindings) {
        super(cls, typeBindings, null, null, 0, null, null, false);
    }

    @Override // b.g.a.c.JavaType
    public JavaType C(Class<?> cls, TypeBindings typeBindings, JavaType javaType, JavaType[] javaTypeArr) {
        return null;
    }

    @Override // b.g.a.c.JavaType
    public JavaType D(JavaType javaType) {
        return this;
    }

    @Override // b.g.a.c.JavaType
    public JavaType E(Object obj) {
        return this;
    }

    @Override // b.g.a.c.JavaType
    /* JADX INFO: renamed from: G */
    public JavaType M() {
        return this;
    }

    @Override // b.g.a.c.JavaType
    /* JADX INFO: renamed from: H */
    public JavaType N(Object obj) {
        return this;
    }

    @Override // b.g.a.c.JavaType
    /* JADX INFO: renamed from: I */
    public JavaType O(Object obj) {
        return this;
    }

    @Override // b.g.a.c.JavaType
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj != null && obj.getClass() == ResolvedRecursiveType.class) {
        }
        return false;
    }

    @Override // b.g.a.c.h0.TypeBase, b.g.a.c.JavaType
    public TypeBindings j() {
        JavaType javaType = this._referencedType;
        return javaType != null ? javaType.j() : this._bindings;
    }

    @Override // b.g.a.c.JavaType
    public StringBuilder l(StringBuilder sb) {
        JavaType javaType = this._referencedType;
        return javaType != null ? javaType.l(sb) : sb;
    }

    @Override // b.g.a.c.JavaType
    public StringBuilder m(StringBuilder sb) {
        JavaType javaType = this._referencedType;
        if (javaType != null) {
            return javaType.l(sb);
        }
        sb.append("?");
        return sb;
    }

    @Override // b.g.a.c.h0.TypeBase, b.g.a.c.JavaType
    public JavaType q() {
        JavaType javaType = this._referencedType;
        return javaType != null ? javaType.q() : this._superClass;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(40);
        sb.append("[recursive type; ");
        JavaType javaType = this._referencedType;
        if (javaType == null) {
            sb.append("UNRESOLVED");
        } else {
            sb.append(javaType._class.getName());
        }
        return sb.toString();
    }

    @Override // b.g.a.c.JavaType
    public boolean v() {
        return false;
    }
}
