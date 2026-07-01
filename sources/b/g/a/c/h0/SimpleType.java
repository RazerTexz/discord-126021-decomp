package b.g.a.c.h0;

import b.g.a.c.JavaType;

/* JADX INFO: renamed from: b.g.a.c.h0.k, reason: use source file name */
/* JADX INFO: compiled from: SimpleType.java */
/* JADX INFO: loaded from: classes3.dex */
public class SimpleType extends TypeBase {
    private static final long serialVersionUID = 1;

    public SimpleType(Class<?> cls, TypeBindings typeBindings, JavaType javaType, JavaType[] javaTypeArr, Object obj, Object obj2, boolean z2) {
        super(cls, typeBindings, javaType, javaTypeArr, 0, obj, obj2, z2);
    }

    public static SimpleType L(Class<?> cls) {
        return new SimpleType(cls, null, null, null, null, null, false);
    }

    @Override // b.g.a.c.JavaType
    public JavaType C(Class<?> cls, TypeBindings typeBindings, JavaType javaType, JavaType[] javaTypeArr) {
        return null;
    }

    @Override // b.g.a.c.JavaType
    public JavaType D(JavaType javaType) {
        throw new IllegalArgumentException("Simple types have no content types; cannot call withContentType()");
    }

    @Override // b.g.a.c.JavaType
    public JavaType E(Object obj) {
        throw new IllegalArgumentException("Simple types have no content types; cannot call withContenTypeHandler()");
    }

    @Override // b.g.a.c.h0.TypeBase
    public String K() {
        StringBuilder sb = new StringBuilder();
        sb.append(this._class.getName());
        int iJ = this._bindings.j();
        if (iJ > 0) {
            sb.append('<');
            for (int i = 0; i < iJ; i++) {
                JavaType javaTypeF = f(i);
                if (i > 0) {
                    sb.append(',');
                }
                sb.append(javaTypeF.e());
            }
            sb.append('>');
        }
        return sb.toString();
    }

    @Override // b.g.a.c.JavaType
    public SimpleType M() {
        return this._asStatic ? this : new SimpleType(this._class, this._bindings, this._superClass, this._superInterfaces, this._valueHandler, this._typeHandler, true);
    }

    @Override // b.g.a.c.JavaType
    public SimpleType N(Object obj) {
        return this._typeHandler == obj ? this : new SimpleType(this._class, this._bindings, this._superClass, this._superInterfaces, this._valueHandler, obj, this._asStatic);
    }

    @Override // b.g.a.c.JavaType
    public SimpleType O(Object obj) {
        return obj == this._valueHandler ? this : new SimpleType(this._class, this._bindings, this._superClass, this._superInterfaces, obj, this._typeHandler, this._asStatic);
    }

    @Override // b.g.a.c.JavaType
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        SimpleType simpleType = (SimpleType) obj;
        if (simpleType._class != this._class) {
            return false;
        }
        return this._bindings.equals(simpleType._bindings);
    }

    @Override // b.g.a.c.JavaType
    public StringBuilder l(StringBuilder sb) {
        TypeBase.J(this._class, sb, true);
        return sb;
    }

    @Override // b.g.a.c.JavaType
    public StringBuilder m(StringBuilder sb) {
        TypeBase.J(this._class, sb, false);
        int iJ = this._bindings.j();
        if (iJ > 0) {
            sb.append('<');
            for (int i = 0; i < iJ; i++) {
                sb = f(i).m(sb);
            }
            sb.append('>');
        }
        sb.append(';');
        return sb;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(40);
        sb.append("[simple type, class ");
        sb.append(K());
        sb.append(']');
        return sb.toString();
    }

    @Override // b.g.a.c.JavaType
    public boolean v() {
        return false;
    }

    public SimpleType(Class<?> cls) {
        this(cls, TypeBindings.l, null, null, null, null, false);
    }

    public SimpleType(Class<?> cls, TypeBindings typeBindings, JavaType javaType, JavaType[] javaTypeArr, int i, Object obj, Object obj2, boolean z2) {
        super(cls, typeBindings, javaType, javaTypeArr, i, obj, obj2, z2);
    }
}
